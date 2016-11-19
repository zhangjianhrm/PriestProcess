package com.lenovo.lps.farseer.priest2.platform.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
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
import com.lenovo.lps.farseer.priest2.platform.entity.Select;
import com.lenovo.lps.farseer.priest2.platform.entity.SelectColumn;
import com.lenovo.lps.farseer.priest2.platform.entity.SelectItem;
import com.lenovo.lps.farseer.priest2.platform.entity.SelectItemEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.Table;
import com.lenovo.lps.farseer.priest2.platform.util.antlr.OracleLexer;
import com.lenovo.lps.farseer.priest2.platform.util.antlr.OracleParser;
import com.lenovo.lps.farseer.priest2.platform.util.antlr.OracleParser.seq_of_statements_return;

/**
 * oracle语法分析工具类
 *
 */
public final class OracleSQLParserUtils {
	private final static Logger logger = Logger.getLogger(OracleSQLParserUtils.class);
	
	/**
	 * DDL正则表达式（可匹配create table/create view/alter table/alter view）
	 */
	private static final String DDL_REGEX = "^(create|alter|drop|truncate)\\s+(table|view)\\s+";
	private static final Pattern DDL_PATTERN = Pattern.compile(DDL_REGEX, Pattern.CASE_INSENSITIVE);
	
	/** 
	 * select column常量或null正则表达式 
	 * */
	private final static String CONST_REGEX = "\\d|null|([\'\"][\\w\\-:]*[\'\"])";
	private final static Pattern CONST_PATTERN = Pattern.compile(CONST_REGEX, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	
	private OracleSQLParserUtils(){}
	
	private static OracleParser getANTLRParser(String sql) {
		String sqlTrimmed = sql.trim();
		ANTLRStringStream stream = new ANTLRStringStream(sqlTrimmed);
		OracleLexer lexer = new OracleLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OracleParser parser = new OracleParser(tokens);

		return parser;
	}
	
	private static CommonTree getTree(String sql) {
		OracleParser parser = getANTLRParser(sql);
		seq_of_statements_return ret = null;
		try {
			ret = parser.seq_of_statements();
		} catch (RecognitionException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
		
		return (CommonTree)ret.getTree();
	}
	
	/**
	 * SQL语法检查
	 * @param sql
	 * @return
	 */
	public static String checkSQLGrammar(String sql) {
		OracleParser parser = getANTLRParser(sql);
		
		String errMsg = "";
		try {
			parser.seq_of_statements();
		} catch (RecognitionException e) {
			String errorHeader = parser.getErrorHeader(e);
			String errorMessage = parser.getErrorMessage(e, parser.getTokenNames());
			errMsg = errorHeader + " " + errorMessage;
		}
		
		return errMsg;
	}
	
	/**
	 * 将SQL转化为Java对象
	 * @param sql
	 * @return
	 */
	public static Select parseSelectSQL(String sql) {
		CommonTree tree = getTree(sql);
		
		Select select = null;
		if(tree.getType() == OracleParser.SELECT_STATEMENT){
			select = OracleASTParser.parseSelectTree(tree, true);
		}
		
		return select;
	}
	
	/**
	 * 获取列对象数组
	 * @param sql
	 * @return
	 */
	public static SelectColumn[] getColumn(String sql) {
		Select select = parseSelectSQL(sql);
		List<SelectItem> items = select.getSelectItems();
		
		List<SelectColumn> columns = new ArrayList<SelectColumn>();
		for(SelectItem item : items){
			String columnName = item.getColumn();
			
			SelectColumn column = new SelectColumn();
			column.setColumnName(columnName);
			column.setAlias(item.getAlias());
			
			String tableName = getColumnTable(select.getTableList(), item.getTable());
			column.setTableName(tableName);
			
			if(CONST_PATTERN.matcher(columnName).matches()){
				column.setConstantValue(columnName);
			}
			
			columns.add(column);
		}
		
		return columns.toArray(new SelectColumn[columns.size()]);
	}

	private static String getColumnTable(List<Table> tableList, String tableNameOrAlias) {
		String tableName = "";
		if (tableList.size() == 1) {
			tableName = tableList.get(0).getTableName();
		} else {
			for (Table table : tableList) {
				if (StringUtils.isNotEmpty(tableNameOrAlias)
						&& (tableNameOrAlias.equals(table.getTableName()) || tableNameOrAlias.equals(table.getAlias()))) {
					tableName = table.getTableName();
					break;
				}
			}
		}
		return tableName;
	}
	
	public static boolean checkExpressionSelect(String sql) {
		Select select = parseSelectSQL(sql);

		if (select != null && CollectionUtils.isNotEmpty(select.getSelectItems())) {
			for (SelectItem selectItem : select.getSelectItems()) {
				if (StringUtils.isNotEmpty(selectItem.getTable()) || selectItem.getItemType().isExpressionSelect()) {
					return true;
				}
				
				if(CONST_PATTERN.matcher(selectItem.getColumn()).matches()){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 检查是否包含select *或 select t.* 模式
	 * @param sql
	 * @return
	 */
	public static boolean checkSelectAll(String sql) {
		Select select = parseSelectSQL(sql);
		
		for (SelectItem selectItem : select.getSelectItems()) {
			SelectItemEnum itemType = selectItem.getItemType();
			if(SelectItemEnum.ALL_COLUMN.equals(itemType) || SelectItemEnum.ALL_TABLE_COLUMN.equals(itemType)){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 获取sql语句中所有表名
	 * @param selectSQL
	 * @return
	 */
	public static String[] getTableName(String sql) {
		Select select = parseSelectSQL(sql);
		
		List<String> tableNames = new ArrayList<String>();
		for(Table table : select.getTableList()){
			tableNames.add(table.getTableName());
		}
		
		return tableNames.toArray(new String[tableNames.size()]);
	}
	
	/**
	 * 判断是否为Join操作
	 * @param sql
	 * @return
	 */
	public static boolean isJoinSelect(String sql) {
		Select select = parseSelectSQL(sql);
		return CollectionUtils.isNotEmpty(select.getJoins());
	}
	
	/**
	 * 获取列名数组
	 * @param selectColumns
	 * @return
	 */
	public static String[] getColumnNames(SelectColumn[] selectColumns) {
		List<String> columns = new ArrayList<String>(selectColumns.length);
		for (SelectColumn selectColumn : selectColumns) {
			columns.add(selectColumn.getColumnName());
		}
		return columns.toArray(new String[columns.size()]);
	}
	
	public static String checkSelect(String sql) {
		Select select = parseSelectSQL(sql);
		List<SelectItem> selects = select.getSelectItems();

		for (SelectItem selectColumn : selects) {
			if (selectColumn.getItemType() == SelectItemEnum.CASE_WHEN && StringUtils.isEmpty(selectColumn.getAlias())) {
				return "case when must order an alias :" + selectColumn.toString();
			}
		}

		return null;
	}
	
	/**
	 * 组建select count(*)语句
	 * @param sql
	 * @return
	 */
	public static String buildCountSql(String sql) {
		Select select = parseSelectSQL(sql);
		
		SelectItem item = new SelectItem();
		item.setColumn("count(*)");
		item.setItemType(SelectItemEnum.FUNCTION_CALL);
		select.getSelectItems().clear();
		select.getSelectItems().add(item);
		
		return select.toString();
	}
	
	/**
	 * 获取sql语句meta信息,不取数据
	 * @param sql
	 * @return
	 */
	public static String buildGetMetaDataSql(String sql) {
		Select select = parseSelectSQL(sql);
		select.setWhere("1 = 0");
		return select.toString();
	}
	
	/**
	 * 获取SQL类型
	 * @param sql
	 * @return
	 */
	public static SQLStatementEnum getSQLType(String sql) {
		Assert.hasText(sql, "sql is empty");
		
		SQLStatementEnum sqlType = null;
		Matcher ddlMatch = DDL_PATTERN.matcher(sql);
		if (ddlMatch.find()) {
			final String op = ddlMatch.group(1);
			if ("create".equalsIgnoreCase(op)) {
				sqlType = SQLStatementEnum.create;
			} else if ("alter".equalsIgnoreCase(op)) {
				sqlType = SQLStatementEnum.alter;
			} else if ("drop".equalsIgnoreCase(op)) {
				sqlType = SQLStatementEnum.drop;
			} else if ("truncate".equalsIgnoreCase(op)) {
				sqlType = SQLStatementEnum.truncate;
			}
		} else {
			CommonTree tree = getTree(sql);
			int nodeType = tree.getType();
			switch (nodeType) {
			case OracleParser.SELECT_STATEMENT:
				sqlType = SQLStatementEnum.select;
				break;
			case OracleParser.UPDATE_STATEMENT:
				sqlType = SQLStatementEnum.update;
				break;
			case OracleParser.INSERT_STATEMENT:
				sqlType = SQLStatementEnum.insert;
				break;
			case OracleParser.DELETE_STATEMENT:
				sqlType = SQLStatementEnum.delete;
				break;
			case OracleParser.MERGE_STATEMENT:
				sqlType = SQLStatementEnum.merge;
				break;
			default:
				throw new IllegalArgumentException("unknown sql type:" + sql);
			}
		}
		
		return sqlType;
	}
}
