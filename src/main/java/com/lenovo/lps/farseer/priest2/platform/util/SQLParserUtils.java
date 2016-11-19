package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.entity.SQLStatementEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.FromItem;
import com.lenovo.lps.farseer.priest2.platform.entity.Join;
import com.lenovo.lps.farseer.priest2.platform.entity.MySqlFunctionEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.Select;
import com.lenovo.lps.farseer.priest2.platform.entity.SelectColumn;
import com.lenovo.lps.farseer.priest2.platform.entity.SelectItem;
import com.lenovo.lps.farseer.priest2.platform.entity.SelectItemEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.SubQuery;
import com.lenovo.lps.farseer.priest2.platform.entity.Table;
import com.lenovo.lps.farseer.priest2.platform.util.antlr.MySQLParser;
import com.lenovo.lps.farseer.priest2.platform.util.antlr.MySQLParser.root_statement_return;
import com.lenovo.lps.farseer.priest2.platform.util.antlr.SQLLexer;

/**
 * 解析SQL类
 * 
 * @author niexm1
 * 
 */
public final class SQLParserUtils {
	private final static Logger logger = Logger.getLogger(SQLParserUtils.class);
	private final static String ALL_COLUMN = "*";

	/** select decode(t1.col1,'1','2') from t1 模式 select column为运算结果 **/
	private final static boolean SELECT_EXPRESSION = true;
	/** select t1.col1 from t1 模式,select column直接为表列 **/
	private final static boolean SELECT_EXPRESSION_NO = false;

	/** select * or select t.* 模式,选择所有列 **/
	private final static boolean SELECT_ALL = true;
	/** select t.col from t模式,选择列明确指定 **/
	private final static boolean SELECT_ALL_NO = false;

	/** 匹配select column为常量或null的正则表达式 */
	private final static String CONST_REGEX = "\\d|null|([\'\"][\\w\\-:]*[\'\"])";
	private final static Pattern CONST_PATTERN = Pattern.compile(CONST_REGEX, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

	/**
	 * 工具类不应该被实例化使用
	 */
	private SQLParserUtils(){}
	
	/**
	 * 获取ANTLR语法分析器
	 * 
	 * @param sql
	 * @return
	 * @throws IOException
	 */
	private static MySQLParser getANTLRParser(String sql) {
		String rsql = sql.replaceAll("(\\\\)+'", "'").replaceAll("(\\\\)+\"", "\"");
		ANTLRStringStream stream = new ANTLRStringStream(rsql);
		SQLLexer lexer = new SQLLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MySQLParser parser = new MySQLParser(tokens);

		return parser;
	}

	/**
	 * MySQL/Oracle sql语法检查
	 * 
	 * @param sql
	 * @throws RecognitionException
	 */
	public static String checkSQLGrammar(String sql) {
		String sqlReplced = sql.replaceAll("('|\")?\\$\\{.*?\\}('|\")?", "aa");
		MySQLParser parser = getANTLRParser(sqlReplced);
		
		String errMsg = "";
		try {
			parser.root_statement();
		} catch (RecognitionException e) {
			String errorHeader = parser.getErrorHeader(e);
			String errorMessage = parser.getErrorMessage(e, parser.getTokenNames());
			errMsg = errorHeader + " " + errorMessage;
		}
		
		return errMsg;
	}

	/**
	 * 解析SQL,转化为java对象
	 * 
	 * @param sql
	 * @return
	 * @throws IOException
	 */
	public static Select parseSelectSQL(String sql) {
		// 参数检查
		Assert.hasText(sql, "sql is empty");

		MySQLParser parser = getANTLRParser(sql);
		root_statement_return ret;
		try {
			ret = parser.root_statement();
		} catch (RecognitionException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}

		CommonTree tree = (CommonTree) ret.getTree();
		if (tree.getType() == MySQLParser.TN_SELECT || tree.getType() == MySQLParser.TN_UNION) {
			return ASTParser.traverseTree(tree);
		}

		return null;

	}

	/**
	 * 解析select a.*,b.col1 as c1,col2 from a,b模式中的列:列名,列的别名,列所属的下层表名
	 * 
	 * @param sql
	 * @return
	 * @throws IOException
	 */
	public static SelectColumn[] getColumn(String sql) {
		List<SelectColumn> columns = new ArrayList<SelectColumn>();

		Select select = parseSelectSQL(sql);
		List<SelectItem> selects = select.getSelectItems();
		String columnName, aliasName;// 列名,列的别名,表名或者表的别名

		for (SelectItem selectColumn : selects) {
			// select * 模式
			SelectItemEnum selectItemType = selectColumn.getItemType();
			if (selectItemType == SelectItemEnum.ALL_COLUMN) {
				columnName = ALL_COLUMN;
				aliasName = null;// select * 别名非法
				SelectColumn column = getColumn(columnName, aliasName, select.getFromItem(), select);
				if (column != null) {
					columns.add(column);
					continue;// 已经找到
				}
			}
			// select t.* 模式
			if (selectItemType == SelectItemEnum.ALL_TABLE_COLUMN) {
				columnName = ALL_COLUMN;
				aliasName = null;// select t.* 别名非法
				SelectColumn column = getColumn(columnName, aliasName, selectColumn.getTable(), select);
				if (column != null) {
					columns.add(column);// 已经找到
				}
			}
			// select t1.col,t2.col2模式
			else {
				// select col from table 模式,选择列上无运算,单纯从表取值
				if (selectItemType == SelectItemEnum.LITERAL || selectItemType == SelectItemEnum.EXPRESSION) {
					getTableCols(columns, select, selectColumn);
				}
				// select function(a.xx) as col模式
				else if (selectItemType == SelectItemEnum.FUNCTION_CALL) {
					String colName = selectColumn.getColumn();

					String functionName = null;
					int lparenIdx = colName.indexOf('(');
					if (lparenIdx != -1) {
						functionName = colName.substring(0, lparenIdx);
					} else {
						break;
					}

					getFuncCols(columns, select, selectColumn, colName, functionName, lparenIdx);
				} else {
					// 跳过select count(*) , case when end 等列
					logger.warn("no column found:" + selectColumn + ">>>sql:" + sql);
					continue;
				}
			}
		}

		return columns.toArray(new SelectColumn[columns.size()]);
	}

	private static void getFuncCols(List<SelectColumn> columns, Select select, SelectItem selectColumn, String colName,
			String functionName, int lparenIdx) {
		MySqlFunctionEnum sqlFunctionEnum = null;
		try {
			sqlFunctionEnum = MySqlFunctionEnum.valueOf(org.apache.commons.lang3.StringUtils.upperCase(functionName));
		} catch (Exception e) {
			sqlFunctionEnum = MySqlFunctionEnum.NOT_SUPPORT;
		}

		switch (sqlFunctionEnum) {
		case CONCAT:
			String paraStr = colName.substring(lparenIdx + 1, colName.indexOf(')'));
			String[] paraList = paraStr.split(",");
			if (paraList != null && paraList.length > 0) {
				// 函数左参
				String leftParam = paraList[0];

				if (StringUtils.isNotEmpty(leftParam)) {
					// concat(字符串,字符串)
					if (CONST_PATTERN.matcher(leftParam).matches()) {
						SelectColumn column = new SelectColumn();
						column.setConstantValue(leftParam);
						column.setAlias(selectColumn.getAlias());
						columns.add(column); // 已经找到
					} else if (leftParam.matches("\\w+(\\.\\w+)?")) {
						SelectItem item = ASTParser.parseColumn(leftParam);

						SelectColumn column = null;
						if (item.getTable() != null) {
							column = getColumn(item.getColumn(), item.getAlias(), item.getTable(), select);
						} else {
							column = getColumn(item.getColumn(), item.getAlias(), select.getFromItem(), select);
						}

						if (column != null) {
							columns.add(column);
						}
					} else {
						throw new PriestPlatformException("bad function parameters");
					}
				}
			} else {
				throw new PriestPlatformException("bad function parameters");
			}
			break;
		default:
			break;
		}
	}

	private static void getTableCols(List<SelectColumn> columns, Select select, SelectItem selectColumn) {
		SelectColumn column = null;
		if (StringUtils.isNotEmpty(selectColumn.getTable())) {
			column = getColumn(selectColumn.getColumn(), selectColumn.getAlias(), selectColumn.getTable(), select);
		} else {
			column = getColumn(selectColumn.getColumn(), selectColumn.getAlias(), select.getFromItem(), select);
		}

		if (column != null) {
			columns.add(column);// 已经找到
		}
	}

	/**
	 * 解析select t1.col1, t1.col1 + t2.y as col2 ,case t1.col3 when 'a' then 'b'
	 * end as col3, t1.x + t2.y as col4 from t1,t2 模式是否包含表达式select列,如case表达式,
	 * t1.x+ t2.y加法表达式
	 * 
	 * @param sql
	 * @return
	 * @throws IOException
	 */
	public static boolean checkExpressionSelect(String sql) {
		Select select = parseSelectSQL(sql);

		if (select != null && CollectionUtils.isNotEmpty(select.getSelectItems())) {
			for (SelectItem selectItem : select.getSelectItems()) {
				if (StringUtils.isNotEmpty(selectItem.getTable()) || selectItem.getItemType().isExpressionSelect()) {
					return SELECT_EXPRESSION;
				}
			}
		}
		return SELECT_EXPRESSION_NO;
	}

	/**
	 * 检查是否包含select * or select t.* 模式
	 * 
	 * @param sql
	 * @return
	 * @throws IOException
	 */
	public static boolean checkSelectAll(String sql) {
		Select select = parseSelectSQL(sql);
		for (SelectItem selectColumn : select.getSelectItems()) {
			// select * 模式
			if (selectColumn.getItemType() == SelectItemEnum.ALL_COLUMN) {
				return SELECT_ALL;
			}
			// select t.* 模式
			if (selectColumn.getItemType() == SelectItemEnum.ALL_TABLE_COLUMN) {
				return SELECT_ALL;
			}
			// else select t1.col,t2.col2模式
		}

		return SELECT_ALL_NO;
	}

	/**
	 * 根据select a.col from
	 * 模式,分析列col从属具体表名(注:表名不一定是a,a可能是表的别名,也有可以是子查询的别名,还有可能是join查询的别名)
	 * 
	 * @param aliasOrTableName
	 * @param select
	 * @return
	 */
	private static SelectColumn getColumn(String columnName, String aliasName, String aliasOrTableName, Select select) {
		// 查询左半部 select t1.*,t2.* from t1,t2 ;在t1部分查询
		SelectColumn column = getColumnFromItem(columnName, aliasName, aliasOrTableName, select.getFromItems());
		if (column != null) {
			return column;
		}

		// 查询右半部 select t1.*,t2.* from t1,t2 ;在t2部分中查询
		if (CollectionUtils.isNotEmpty(select.getJoins())) {
			List<Join> joins = select.getJoins();

			for (Join join : joins) {
				if (join.getRightItem() != null) {
					List<FromItem> rightItem = new ArrayList<FromItem>();
					rightItem.add(join.getRightItem());
					column = getColumnFromItem(columnName, aliasName, aliasOrTableName, rightItem);
					if (column != null) {
						return column;
					}
				}
			}
		}

		return null;
	}

	private static SelectColumn getColumnFromItem(String columnName, String aliasName, String aliasOrTableName,
			List<FromItem> fromItems) {
		for (FromItem from : fromItems) {
			// 表匹配
			if (from instanceof Table) {
				Table table = (Table) from;
				// 与表名或者别名匹配,找到列所在表
				if (aliasOrTableName.equals(table.getAlias()) || aliasOrTableName.equals(table.getTableName())) {
					SelectColumn column = new SelectColumn();
					column.setColumnName(columnName);
					column.setAlias(aliasName);
					column.setTableName(table.getTableName());

					if (CONST_PATTERN.matcher(columnName).matches()) {
						column.setConstantValue(columnName);
					}

					return column;
				}
			}
			// 子查询匹配（包括subSelect, subJoin）
			else if (from instanceof SubQuery) {
				SubQuery subSelect = (SubQuery) from;
				List<Join> subJoinList = subSelect.getSubSelect().getJoins();

				if (CollectionUtils.isNotEmpty(subJoinList)) {
					// 在子查询中匹配 select a.col1,b.col2 from (select * from table1) as a, b模式
					if (aliasOrTableName.equals(subSelect.getAlias())) {
						// 在子查询中匹配
						SelectColumn column = getColumn(columnName, aliasName, aliasOrTableName, (Select) subSelect.getSubSelect());

						if (column != null) {
							return column;
						}
					}
				} else {
					// subJoin匹配 select a.col1,b.col2 from (select * from table1 join table2 on table1.col1 = table2.col1) as a ,b模式
					if (aliasOrTableName.equals(subSelect.getAlias())) {
						List<FromItem> subJoinLeft = subSelect.getSubSelect().getFromItems();
						if (subJoinLeft != null) {
							SelectColumn column = getColumnFromItem(columnName, aliasName, aliasOrTableName, subJoinLeft);
							if (column != null) {
								return column;
							}
						}

						Join subJoin = subJoinList.get(0);
						if (subJoin != null && subJoin.getRightItem() != null) {
							List<FromItem> rightItem = new ArrayList<FromItem>();
							rightItem.add(subJoin.getRightItem());
							SelectColumn column = getColumnFromItem(columnName, aliasName, aliasOrTableName, rightItem);
							if (column != null) {
								return column;
							}
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * 获取sql所有表名
	 * 
	 * @param selectSQL
	 * @return
	 * @throws IOException
	 */
	public static String[] getTableName(String selectSQL) {
		Select select = parseSelectSQL(selectSQL);
		return getTableName(select);
	}

	private static String[] getTableName(Select select) {
		List<String> ret = new ArrayList<String>();

		String[] fromTables = getTableName(select.getFromItems());
		if (fromTables != null && fromTables.length > 0) {
			ret.addAll(Arrays.asList(fromTables));
		}

		// 查询右半部 select t1.*,t2.* from t1,t2 ;在t2部分中查询
		if (CollectionUtils.isNotEmpty(select.getJoins())) {
			List<Join> joins = select.getJoins();
			for (Join join : joins) {
				if (join.getRightItem() != null) {
					List<FromItem> rightItem = new ArrayList<FromItem>();
					rightItem.add(join.getRightItem());
					String[] tables = getTableName(rightItem);
					if (tables != null && tables.length > 0) {
						ret.addAll(Arrays.asList(tables));
					}
				}
			}
		}

		return ret.toArray(new String[0]);
	}

	private static String[] getTableName(List<FromItem> fromItems) {
		List<String> tableList = new ArrayList<String>();
		for (FromItem from : fromItems) {
			// 表匹配
			if (from instanceof Table) {
				Table table = (Table) from;
				tableList.add(table.getTableName());
			}
			// 子查询匹配 select a.col1,b.col2 from (select * from table1) as a ,b模式
			else if (from instanceof SubQuery) {
				SubQuery subSelect = (SubQuery) from;
				List<Join> subJoins = subSelect.getSubSelect().getJoins();

				if (CollectionUtils.isNotEmpty(subJoins)) {
					return getTableName(subSelect.getSubSelect());
				} else {
					String[] left = null, right = null;

					// 在join左部查找
					List<FromItem> joinLeft = subSelect.getSubSelect().getFromItems();
					if (joinLeft != null) {
						left = getTableName(joinLeft);
						tableList.addAll(Arrays.asList(left));
					}

					// 在join右部查找
					Join join = subJoins.get(0);
					if (join != null && join.getRightItem() != null) {
						List<FromItem> rightItem = new ArrayList<FromItem>();
						rightItem.add(join.getRightItem());
						right = getTableName(rightItem);
						tableList.addAll(Arrays.asList(right));
					}

				}
			}
		}

		return (CollectionUtils.isNotEmpty(tableList) ? tableList.toArray(new String[tableList.size()]) : null);
	}

	/**
	 * 判断是否为连表查询
	 * 
	 * @param sql
	 * @return
	 * @throws IOException
	 */
	public static boolean isJoinSelect(String sql) {
		Select select = parseSelectSQL(sql);
		return CollectionUtils.isNotEmpty(select.getJoins());
	}

	public static String[] getColumnNames(SelectColumn[] selectColumns) {
		List<String> columns = new ArrayList<String>(selectColumns.length);
		for (SelectColumn selectColumn : selectColumns) {
			columns.add(selectColumn.getColumnName());
		}
		return columns.toArray(new String[columns.size()]);

	}

	/**
	 * 解析select a.*,b.col1 as c1,col2 from a,b模式中的列:列名,列的别名,列所属的下层表名
	 * 
	 * @param sql
	 * @return
	 * @throws IOException
	 */
	public static String checkSelect(String sql) {
		Select select = parseSelectSQL(sql);
		List<SelectItem> selects = select.getSelectItems();

		for (SelectItem selectColumn : selects) {
			if (selectColumn.getItemType() == SelectItemEnum.CASE_WHEN && StringUtils.isEmpty(selectColumn.getAlias())) {
				return "'case when' must order an alias  :" + selectColumn.toString();
			}
		}

		return null;
	}

	public static String buildCountSql(String sql) {
		Select select = SQLParserUtils.parseSelectSQL(sql);

		SelectItem item = new SelectItem();
		item.setColumn("count(*)");
		item.setItemType(SelectItemEnum.FUNCTION_CALL);
		select.getSelectItems().clear();
		select.getSelectItems().add(item);

		return select.toString();
	}

	/**
	 * select * from a,b where a.col1 = b.col2 SQL转为select * from a,b where 1=0
	 * ,只取meta信息,不取数据
	 * 
	 * @param sql
	 * @return
	 * @throws IOException
	 */
	public static String buildGetMetaDataSql(String sql) {
		Select select = SQLParserUtils.parseSelectSQL(sql);

		// where 1 = 0 条件
		select.setWhere("1 = 0");

		return select.toString();
	}

	/**
	 * 解析SQL,判断SQL类型
	 * 
	 * @param sql
	 * @return
	 * @throws IOException
	 */
	public static SQLStatementEnum getSQLType(String sql) {

		// 参数检查
		Assert.hasText(sql, "sql is empty");
		String trimSql = sql.trim();

		root_statement_return ret = getRootStmtRtn(trimSql);

		int nodeType = ((CommonTree) ret.getTree()).getType();
		if (nodeType == MySQLParser.TN_SELECT || nodeType == MySQLParser.TN_UNION) {
			return SQLStatementEnum.select;
		} else if (nodeType == MySQLParser.TN_CREATE) {
			return SQLStatementEnum.create;
		} else if (nodeType == MySQLParser.TN_DROP) {
			return SQLStatementEnum.drop;
		} else if (nodeType == MySQLParser.TN_ALTER) {
			return SQLStatementEnum.alter;
		} else if (nodeType == MySQLParser.TN_INSERT) {
			return SQLStatementEnum.insert;
		} else if (nodeType == MySQLParser.TN_UPDATE) {
			return SQLStatementEnum.update;
		} else if (nodeType == MySQLParser.TN_REPLACE) {
			return SQLStatementEnum.replace;
		} else if (nodeType == MySQLParser.TN_DELETE) {
			return SQLStatementEnum.delete;
		} else if (nodeType == MySQLParser.TN_TRUNCATE) {
			return SQLStatementEnum.truncate;
		} else {
			throw new IllegalArgumentException("unknown sql type:" + trimSql);
		}

	}

	private static root_statement_return getRootStmtRtn(String trimSql) {
		MySQLParser parser = getANTLRParser(trimSql);
		root_statement_return ret = null;
		try {
			ret = parser.root_statement();
		} catch (RecognitionException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(SQLParserUtils.parseSelectSQL("select userid lenovoid,username,substr(modifydate,12,8) `time`,payamount,businessappid appkey,substr(modifydate,1,10) p_event_date from cashier_user_order"));
	}

}
