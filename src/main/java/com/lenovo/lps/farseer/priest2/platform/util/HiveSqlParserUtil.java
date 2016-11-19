package com.lenovo.lps.farseer.priest2.platform.util;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.tree.Tree;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.ErrorMsg;
import org.apache.hadoop.hive.ql.exec.FunctionRegistry;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.HiveParser;
import org.apache.hadoop.hive.ql.parse.ParseDriver;
import org.apache.hadoop.hive.ql.parse.ParseException;
import org.apache.hadoop.hive.ql.parse.ParseUtils;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFResolver;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.platform.entity.HiveDestinationEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.HiveInsertClause;
import com.lenovo.lps.farseer.priest2.platform.entity.HiveJoinEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.HiveQueryEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.HiveSelectColumn;
import com.lenovo.lps.farseer.priest2.platform.entity.HiveTableEntity;
import com.lenovo.lps.farseer.priest2.platform.hive.HiveOperationEnum;

/**
 * Hive SQL分析
 * 
 * @author niexm1
 * 
 */
@SuppressWarnings("deprecation")
public final class HiveSqlParserUtil {

	// insert
	private static final String INSERT_REGEX = "\\s*(insert)\\s+";
	private static final Pattern INSERT_PATTERN = Pattern.compile(INSERT_REGEX, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

	/**
	 * QL常量
	 * */
	private static final String CONST_REGEX = "\\d|null|TOK_NULL|([\'\"][\\w\\-:]*[\'\"])";
	
	private static final Pattern patt = Pattern.compile("(`/[a-zA-Z0-9_/]*`)", Pattern.CASE_INSENSITIVE);
	
	/**
	 * 工具类不应该被实例化使用
	 */
	private HiveSqlParserUtil() {
	}

	/**
	 * Hive Sql语法检查
	 * 
	 * @param sql
	 * @throws ParseException
	 */
	public static String checkSqlGrammar(String sql) {
		String sqlTrimmed = sql.trim();
		if (sqlTrimmed.startsWith("--")) {
			sqlTrimmed = sqlTrimmed.substring(sqlTrimmed.indexOf('\n') + 1);
		}
		String[] tokens = sqlTrimmed.split("\\s+");
		String firstToken = tokens[0].toLowerCase();

		if (sqlTrimmed.equalsIgnoreCase("quit") || sqlTrimmed.equalsIgnoreCase("exit")) {
			return "Do not support quit/exit command";
		} else if (sqlTrimmed.startsWith("!")) {
			return "Do not support shell command";
		} else if ("list".equals(firstToken) || "dfs".equals(firstToken)) {
			return "Do not support " + firstToken + " command";
		} else if ("set".equals(firstToken) || "add".equals(firstToken) || "delete".equals(firstToken) || "source".equals(firstToken)) {
			return "";
		}

		// sql分析时，语句中的流程变量和应用变量会报错，事先替换为空字符串
		String sqlReplced = sql.replaceAll("\\$\\{(.*?)\\}", "0");

		String message = "";
		ParseDriver pd = new ParseDriver();
		try {
			pd.parse(sqlReplced);
		} catch (Exception e) {    //这里捕捉Exception，防止unchecked异常抛出
			message = e.getMessage();
		}
		return message;
	}

	private static HiveQueryEntity doParserHiveSql(String sql) throws ParseException, SemanticException, MalformedURLException {
		HiveQueryEntity queryEntity = new HiveQueryEntity();
		Matcher m = patt.matcher(sql);
		if (m.find()) {
			m.reset();
			StringBuffer sb = new StringBuffer(); 
			while(m.find()) {
				m.appendReplacement(sb, m.group(1).replaceAll("/", ""));
			}
			m.appendTail(sb);
			sql = sb.toString();
		}
		sql = sql.replaceAll("`", "");
		ParseDriver pd = new ParseDriver();
		ASTNode tree = pd.parse(sql);
		tree = ParseUtils.findRootNonNullToken(tree);
		ASTNode parent = null;

		doAnalyzeHiveSql(tree, parent, queryEntity);
		return queryEntity;
	}

	/**
	 * 分析hive sql各部分
	 * 
	 * @param ast
	 * @throws SemanticException
	 */
	private static HiveQueryEntity doAnalyzeHiveSql(ASTNode ast, ASTNode parent, HiveQueryEntity queryEntity) throws SemanticException {
		boolean skipRecursion = false;

		if (ast.getToken() != null) {
			skipRecursion = true;
			switch (ast.getToken().getType()) {

			// select distinct col1
			case HiveParser.TOK_SELECTDI:
				// fall through
			case HiveParser.TOK_SELECT:
				// 获取 select col1 alias,col2,col3 中的列
				Map<String, String> exprToColumnAlias = doPhase1GetColumnAliasesFromSelect(ast);

				queryEntity.getInsertClause(parent).setSelectColumnAliasMap(exprToColumnAlias);
				break;

			case HiveParser.TOK_WHERE:
				queryEntity.getInsertClause(parent).setWhere(ast.toStringTree());
				break;

			case HiveParser.TOK_INSERT_INTO:
				String tabName = getUnescapedName((ASTNode) ast.getChild(0).getChild(0));
				queryEntity.getInsertClause(parent).setInsertInto(tabName);
				break;
			case HiveParser.TOK_DESTINATION:
				HiveDestinationEntity desc = new HiveDestinationEntity();
				Tree childOfAst = ast.getChild(0);
				int tokType = childOfAst.getType();
				if (HiveParser.TOK_TAB == tokType) {
					Tree child = childOfAst.getChild(0);
					String destTabName = "";
					if (1 == child.getChildCount()) {
						destTabName = child.getChild(0).getText();
					} else if (2 == child.getChildCount()) {
						String dbName = child.getChild(0).getText();
						String tbName = child.getChild(1).getText();
						destTabName = dbName + "." + tbName;
					}
					queryEntity.getInsertClause(parent).setInsertInto(destTabName);
				} else {
					desc.setFileLocation(((ASTNode) ast.getChild(0)).toStringTree());
					queryEntity.getInsertClause(parent).setDest(desc);
				}
				break;

			// select ... from table1 a,(select b,d,c from table2) b
			case HiveParser.TOK_FROM:
				int childCount = ast.getChildCount();
				if (childCount != 1) {
					throw new PriestPlatformException("Multiple Children " + childCount);
				}

				Object from = null;

				// Check if this is a subquery / lateral view
				ASTNode frm = (ASTNode) ast.getChild(0);
				if (frm.getToken().getType() == HiveParser.TOK_TABREF) {
					from = processTable(frm);
				} else if (frm.getToken().getType() == HiveParser.TOK_SUBQUERY) {
					from = processSubQuery(frm);
				} else if (frm.getToken().getType() == HiveParser.TOK_LATERAL_VIEW) {
					from = processLateralView(frm);
				} else if (isJoinToken(frm)) {
					from = processJoin(frm);
				}

				queryEntity.setFrom(from);
				break;

			case HiveParser.TOK_CLUSTERBY:
				queryEntity.getInsertClause(parent).setClusterBy(ast.toStringTree());
				break;

			case HiveParser.TOK_DISTRIBUTEBY:
				queryEntity.getInsertClause(parent).setDistributeBy(ast.toStringTree());
				break;

			case HiveParser.TOK_SORTBY:
				queryEntity.getInsertClause(parent).setSortBy(ast.toStringTree());
				break;

			case HiveParser.TOK_ORDERBY:
				queryEntity.getInsertClause(parent).setOrderBy(ast.toStringTree());
				break;

			case HiveParser.TOK_GROUPBY:
				queryEntity.getInsertClause(parent).setGroupBy(ast.toStringTree());
				skipRecursion = true;
				break;

			case HiveParser.TOK_HAVING:
				queryEntity.getInsertClause(parent).setHaving(ast.toStringTree());
				break;

			case HiveParser.TOK_LIMIT:
				queryEntity.getInsertClause(parent).setLimit(Integer.valueOf(ast.getChild(0).getText()));
				break;

			case HiveParser.TOK_ANALYZE:
				break;

			case HiveParser.TOK_UNION:
				break;
			default:
				skipRecursion = false;
				break;
			}
		}

		if (!skipRecursion) {
			// Iterate over the rest of the children
			int childCount = ast.getChildCount();

			// 处理insert child前，创建QueryEntity与InsertClause关系，方便Insert child与其建立关系
			if (ast.getToken().getType() == HiveParser.TOK_INSERT) {
				if (!queryEntity.getSourceToInsertClauseMap().containsKey(ast)) {
					HiveInsertClause insertClause = new HiveInsertClause();
					queryEntity.setInsertClause(insertClause);
					queryEntity.putInsertClause(ast, insertClause);
				}
			}

			for (int childPos = 0; childPos < childCount; ++childPos) {

				// Recurse
				doAnalyzeHiveSql((ASTNode) ast.getChild(childPos), ast, queryEntity);
			}
		}

		return queryEntity;
	}

	/**
	 * Remove the encapsulating "`" pair from the identifier. We allow users to
	 * use "`" to escape identifier for table names, column names and aliases,
	 * in case that coincide with Hive language keywords.
	 */
	private static String unescapeIdentifier(String val) {
		String retVal = val;
		if (retVal == null) {
			return null;
		}
		if (retVal.charAt(0) == '`' && retVal.charAt(retVal.length() - 1) == '`') {
			retVal = retVal.substring(1, retVal.length() - 1);
		}
		return retVal;
	}

	/**
	 * @param Get
	 *            the name from a table node
	 * @return if DB name is give, db.tab is returned. Otherwise, tab.
	 */
	private static String getUnescapedName(ASTNode tableNameNode) {
		if (tableNameNode.getToken().getType() == HiveParser.TOK_TABNAME) {
			if (tableNameNode.getChildCount() == 2) {
				String dbName = unescapeIdentifier(tableNameNode.getChild(0).getText());
				String tableName = unescapeIdentifier(tableNameNode.getChild(1).getText());
				return dbName + "." + tableName;
			} else {
				return unescapeIdentifier(tableNameNode.getChild(0).getText());
			}
		}
		return unescapeIdentifier(tableNameNode.getText());
	}

	/**
	 * DFS-scan the expressionTree to find all aggregation subtrees and put them
	 * in aggregations.
	 * 
	 * @param expressionTree
	 * @param aggregations
	 *            the key to the HashTable is the toStringTree() representation
	 *            of the aggregation subtree.
	 */
	private static void doPhase1GetAllAggregations(ASTNode expressionTree, Map<String, ASTNode> aggregations) {
		int exprTokenType = expressionTree.getToken().getType();
		if (exprTokenType == HiveParser.TOK_FUNCTION || exprTokenType == HiveParser.TOK_FUNCTIONDI
				|| exprTokenType == HiveParser.TOK_FUNCTIONSTAR) {
			assert (expressionTree.getChildCount() != 0);
			if (expressionTree.getChild(0).getType() == HiveParser.Identifier) {
				String functionName = unescapeIdentifier(expressionTree.getChild(0).getText());
				GenericUDAFResolver udafr = null ;
				try {
					udafr  = FunctionRegistry.getGenericUDAFResolver(functionName) ;
				} catch (Exception e) {
					e.printStackTrace();
				}
				if ( udafr != null) {
					aggregations.put(expressionTree.toStringTree(), expressionTree);
					return;
				}
			}
		}
		for (int i = 0; i < expressionTree.getChildCount(); i++) {
			doPhase1GetAllAggregations((ASTNode) expressionTree.getChild(i), aggregations);
		}
	}

	@SuppressWarnings("unused")
	private static Map<String, ASTNode> doPhase1GetAggregationsFromSelect(ASTNode selExpr) {
		// Iterate over the selects search for aggregation Trees.
		// Use String as keys to eliminate duplicate trees.
		LinkedHashMap<String, ASTNode> aggregationTrees = new LinkedHashMap<String, ASTNode>();
		for (int i = 0; i < selExpr.getChildCount(); ++i) {
			ASTNode sel = (ASTNode) selExpr.getChild(i).getChild(0);
			doPhase1GetAllAggregations(sel, aggregationTrees);
		}
		return aggregationTrees;
	}

	private static Map<String, String> doPhase1GetColumnAliasesFromSelect(ASTNode selectExpr) {
		Map<String, String> exprToColumnAlias = new HashMap<String, String>();
		for (int i = 0; i < selectExpr.getChildCount(); ++i) {
			ASTNode selExpr = (ASTNode) selectExpr.getChild(i);
			if ((selExpr.getToken().getType() == HiveParser.TOK_SELEXPR)) {
				if (selExpr.getChildCount() == 2) {
					String columnAlias = unescapeIdentifier(selExpr.getChild(1).getText());
					exprToColumnAlias.put(((ASTNode) selExpr.getChild(0)).toString(), columnAlias);
				}
				// 没有别名
				else {
					exprToColumnAlias.put(((ASTNode) selExpr.getChild(0)).toString(), null);
				}
			}
		}

		return exprToColumnAlias;
	}

	/**
	 * Goes though the tabref tree and finds the alias for the table. Once
	 * found, it records the table name-> alias association in aliasToTabs. It
	 * also makes an association from the alias to the table AST in parse info.
	 * 
	 * @return the alias of the table
	 */
	private static HiveTableEntity processTable(ASTNode tabref) throws SemanticException {
		int aliasIndex = 0;
		if (tabref.getChildCount() == 2) {
			// tablename tablesample
			// OR
			// tablename alias
			ASTNode ct = (ASTNode) tabref.getChild(1);
			int ctType = ct.getToken().getType();
			if (ctType != HiveParser.TOK_TABLEBUCKETSAMPLE || ctType != HiveParser.TOK_TABLESPLITSAMPLE) {
				aliasIndex = 1;
			}
		} else if (tabref.getChildCount() == 3) {
			// table name table sample alias
			aliasIndex = 2;
		}
		ASTNode tableTree = (ASTNode) (tabref.getChild(0));
		String tabIdName = getUnescapedName(tableTree);
		String alias = (aliasIndex != 0) ? unescapeIdentifier(tabref.getChild(aliasIndex).getText()) : tabIdName;
		return new HiveTableEntity(null, tabIdName, alias);
	}

	/**
	 * 处理子查询
	 * 
	 * @param qb
	 * @param subq
	 * @return
	 * @throws SemanticException
	 */
	private static HiveQueryEntity processSubQuery(ASTNode subq) throws SemanticException {
		// This is a subquery and must have an alias
		if (subq.getChildCount() != 2) {
			throw new SemanticException(ErrorMsg.NO_SUBQUERY_ALIAS.getMsg(subq));
		}
		ASTNode subqref = (ASTNode) subq.getChild(0);
		String alias = unescapeIdentifier(subq.getChild(1).getText());

		HiveQueryEntity subQuery = new HiveQueryEntity();
		subQuery.setAliasName(alias);

		doPhase1QBExpr(subqref, subQuery);

		return subQuery;
	}

	/**
	 * 子查询处理
	 * 
	 * @param ast
	 * @param queryEntitys
	 * @throws SemanticException
	 */
	private static void doPhase1QBExpr(ASTNode ast, HiveQueryEntity subQuery) throws SemanticException {
		assert (ast.getToken() != null);
		switch (ast.getToken().getType()) {
		case HiveParser.TOK_QUERY: {
			ASTNode parent = null;
			doAnalyzeHiveSql(ast, parent, subQuery);
			break;
		}
		case HiveParser.TOK_UNION: {
			// query 1
			assert (ast.getChild(0) != null);
			doPhase1QBExpr((ASTNode) ast.getChild(0), subQuery);

			doPhase1QBExpr((ASTNode) ast.getChild(1), subQuery);
			break;
		}
		default:
			break;
		}

	}

	/**
	 * 解析lateralview
	 * 
	 * @param qb
	 * @param lateralView
	 * @return
	 * @throws SemanticException
	 */
	private static Object processLateralView(ASTNode lateralView) throws SemanticException {
		int numChildren = lateralView.getChildCount();

		assert (numChildren == 2);
		ASTNode next = (ASTNode) lateralView.getChild(1);

		switch (next.getToken().getType()) {
		case HiveParser.TOK_TABREF:
			return processTable(next);
		case HiveParser.TOK_SUBQUERY:
			return processSubQuery(next);
		case HiveParser.TOK_LATERAL_VIEW:
			return processLateralView(next);
		default:
			throw new SemanticException(ErrorMsg.LATERAL_VIEW_INVALID_CHILD.getMsg(lateralView));
		}
	}

	/**
	 * 判断是否是join
	 * 
	 * @param node
	 * @return
	 */
	private static boolean isJoinToken(ASTNode node) {
		int nodeType = node.getToken().getType();
		int[] joinTypes = { HiveParser.TOK_JOIN, HiveParser.TOK_LEFTOUTERJOIN, HiveParser.TOK_RIGHTOUTERJOIN,
				HiveParser.TOK_FULLOUTERJOIN, HiveParser.TOK_LEFTSEMIJOIN, HiveParser.TOK_UNIQUEJOIN };

		for (int joinType : joinTypes) {
			if (nodeType == joinType) {
				return true;
			}
		}

		return false;
	}

	/**
	 * parse join
	 * 
	 * @param join
	 * @throws SemanticException
	 */
	private static HiveJoinEntity processJoin(ASTNode join) throws SemanticException {
		int numChildren = join.getChildCount();
		if ((numChildren != 2) && (numChildren != 3) && join.getToken().getType() != HiveParser.TOK_UNIQUEJOIN) {
			throw new SemanticException("Join with multiple children");
		}

		HiveJoinEntity joinEntity = new HiveJoinEntity();
		for (int num = 0; num < numChildren; num++) {
			ASTNode child = (ASTNode) join.getChild(num);
			int childType = child.getToken().getType();
			if (childType == HiveParser.TOK_TABREF) {
				HiveTableEntity tableEntity = processTable(child);
				joinEntity.setJoin(tableEntity);
			} else if (childType == HiveParser.TOK_SUBQUERY) {
				HiveQueryEntity subQueryEntity = processSubQuery(child);
				joinEntity.setJoin(subQueryEntity);
			} else if (childType == HiveParser.TOK_LATERAL_VIEW) {
				// SELECT * FROM src1 LATERAL VIEW udtf() AS myTable JOIN src2
				// ...
				// is not supported. Instead, the lateral view must be in a
				// subquery
				// SELECT * FROM (SELECT * FROM src1 LATERAL VIEW udtf() AS
				// myTable) a
				// JOIN src2 ...
				throw new SemanticException(ErrorMsg.LATERAL_VIEW_WITH_JOIN.getMsg(join));
			} else if (isJoinToken(child)) {
				HiveJoinEntity subJoins = processJoin(child);

				for (Object subJoin : subJoins.getJoins()) {
					joinEntity.setJoin(subJoin);
				}
			}
		}

		return joinEntity;
	}

	/**
	 * 获取插入目的表列表
	 * 
	 * @param hiveSql
	 * @return
	 */
	public static List<String> getInsertTableName(String hiveSql) {
		try {
			List<String> insertTableNames = new ArrayList<String>();
			HiveQueryEntity queryEntity = doParserHiveSql(hiveSql);
			List<HiveInsertClause> insertClauses = queryEntity.getInsertClauses();
			for (HiveInsertClause hiveInsertClause : insertClauses) {
				String insertTableName = hiveInsertClause.getInsertInto();
				insertTableNames.add(insertTableName);
			}
			return insertTableNames;
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}
	public static List<String> getInsertDest(String hiveSql) {
		try {
			List<String> insertDest = new ArrayList<String>();
			HiveQueryEntity queryEntity = doParserHiveSql(hiveSql);
			List<HiveInsertClause> insertClauses = queryEntity.getInsertClauses();
			for (HiveInsertClause hiveInsertClause : insertClauses) {
				String dest =  hiveInsertClause.getInsertInto(); 
				if ( StringUtils.isEmpty(dest) && hiveInsertClause.getDest() != null ){
					dest = hiveInsertClause.getDest().getFileLocation();					
				}
				if ( !StringUtils.isEmpty(dest)){
					insertDest.add(dest);
				}
			}
			return insertDest;
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}
	
	/**
	 * @see getFromTableName
	 */
	public static List<String> getFromTableName(String hiveSql) {
		try {
			HiveQueryEntity queryEntity = doParserHiveSql(hiveSql);

			return getFrom(queryEntity.getFrom());

		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}

	private static List<String> getFrom(Object from) {
		List<String> result = new ArrayList<String>();

		Class<?> fromClass = from.getClass();
		// from table
		if (HiveTableEntity.class.isAssignableFrom(fromClass)) {
			HiveTableEntity table = (HiveTableEntity) from;
			result.add(table.getName());
		}
		// from 子查询
		else if (HiveQueryEntity.class.isAssignableFrom(fromClass)) {
			HiveQueryEntity subQuery = (HiveQueryEntity) from;
			result.addAll(getFrom(subQuery.getFrom()));
		}
		// from join
		else if (HiveJoinEntity.class.isAssignableFrom(fromClass)) {
			HiveJoinEntity joinEntity = (HiveJoinEntity) from;
			List<Object> joins = joinEntity.getJoins();

			for (Object join : joins) {
				result.addAll(getFrom(join));
			}
		}

		return result;
	}

	/**
	 * 分析SQL操作类型
	 * 
	 * @see analyzeHiveOperatorType
	 */
	public static HiveOperationEnum analyzeHiveOperatorType(String sql) {
		Matcher m = patt.matcher(sql);
		if (m.find()) {
			m.reset();
			StringBuffer sb = new StringBuffer(); 
			while(m.find()) {
				m.appendReplacement(sb, m.group(1).replaceAll("/", ""));
			}
			m.appendTail(sb);
			sql = sb.toString();
		} 
		sql = sql.replaceAll("`", "");
		String sqlTrimmed = sql.trim();
		String[] tokens = sqlTrimmed.split("\\s+");

		String firstToken = tokens[0].toLowerCase();

		// exit / quit
		if (sqlTrimmed.equalsIgnoreCase("quit") || sqlTrimmed.equalsIgnoreCase("exit")) {
			return HiveOperationEnum.QUIT;
		}
		// source
		else if ("source".equals(firstToken)) {
			return HiveOperationEnum.SOURCE;
		}
		// !shell cmd
		else if (sqlTrimmed.startsWith("!")) {
			return HiveOperationEnum.SHELL;
		}
		// list jar / file
		else if ("list".equals(firstToken)) {
			return HiveOperationEnum.LIST;
		}
		// set xxx=yyy
		else if ("set".equals(firstToken)) {
			return HiveOperationEnum.SET;
		}
		// dfs fs -ls xxx
		else if ("dfs".equals(firstToken)) {
			return HiveOperationEnum.DFS;
		}
		// add jar / file
		else if ("add".equals(firstToken)) {
			return HiveOperationEnum.ADD;
		}
		// delete delete
		else if ("delete".equals(firstToken)) {
			return HiveOperationEnum.DELETE;
		}
		// hive sql
		else {
			ParseDriver pd = new ParseDriver();
			ASTNode tree;
			try {
				tree = pd.parse(sql);
			} catch (ParseException e) {
				throw new PriestPlatformException("Parse sql error: " + e.getMessage());
			}
			tree = ParseUtils.findRootNonNullToken(tree);

			if (tree.getToken() == null) {
				throw new PriestPlatformException("Empty Syntax Tree");
			}
			// 分析语法树
			else {
                String strTokType = tree.getToken().getText();
				switch (tree.getToken().getType()) {
				case HiveParser.TOK_EXPLAIN:
					return HiveOperationEnum.EXPLAIN;
				case HiveParser.TOK_LOAD:
					return HiveOperationEnum.LOAD;
				case HiveParser.TOK_EXPORT:
					return HiveOperationEnum.EXPORT;
				case HiveParser.TOK_IMPORT:
					return HiveOperationEnum.IMPORT;
				case HiveParser.TOK_CREATEDATABASE:
				case HiveParser.TOK_CREATETABLE:
				case HiveParser.TOK_CREATEINDEX:
				case HiveParser.TOK_CREATEROLE:
					return HiveOperationEnum.CREATE;
				case HiveParser.TOK_DROPDATABASE:
				case HiveParser.TOK_DROPTABLE:
				case HiveParser.TOK_DROPVIEW:
				case HiveParser.TOK_DROPINDEX:
				case HiveParser.TOK_DROPROLE:
					return HiveOperationEnum.DROP;
				case HiveParser.TOK_ALTERTABLE_ADDCOLS:
				case HiveParser.TOK_ALTERTABLE_RENAMECOL:
				case HiveParser.TOK_ALTERTABLE_REPLACECOLS:
				case HiveParser.TOK_ALTERTABLE_RENAME:
				case HiveParser.TOK_ALTERTABLE_DROPPARTS:
				case HiveParser.TOK_ALTERTABLE_ADDPARTS:
				case HiveParser.TOK_ALTERTABLE_PROPERTIES:
				case HiveParser.TOK_ALTERTABLE_SERIALIZER:
				case HiveParser.TOK_ALTERTABLE_SERDEPROPERTIES:
				case HiveParser.TOK_ALTERINDEX_REBUILD:
				case HiveParser.TOK_ALTERINDEX_PROPERTIES:
				case HiveParser.TOK_ALTERVIEW_PROPERTIES:
				case HiveParser.TOK_ALTERVIEW_ADDPARTS:
				case HiveParser.TOK_ALTERVIEW_DROPPARTS:
				case HiveParser.TOK_ALTERVIEW_RENAME:
				case HiveParser.TOK_ALTERTABLE_CLUSTER_SORT:
				case HiveParser.TOK_ALTERTABLE_TOUCH:
				case HiveParser.TOK_ALTERTABLE_ARCHIVE:
				case HiveParser.TOK_ALTERTABLE_UNARCHIVE:
				case HiveParser.TOK_ALTERDATABASE_PROPERTIES:
				//case HiveParser.TOK_ALTERTABLE_PARTITION:
					return HiveOperationEnum.ALTER;
				case HiveParser.TOK_SHOWDATABASES:
				case HiveParser.TOK_SHOWTABLES:
				case HiveParser.TOK_SHOW_TABLESTATUS:
				case HiveParser.TOK_SHOWFUNCTIONS:
				case HiveParser.TOK_SHOWPARTITIONS:
				case HiveParser.TOK_SHOWINDEXES:
				case HiveParser.TOK_SHOWLOCKS:
				case HiveParser.TOK_SHOW_GRANT:
				case HiveParser.TOK_SHOW_ROLE_GRANT:
				case HiveParser.TOK_SWITCHDATABASE:
				case HiveParser.TOK_DESCDATABASE:
				case HiveParser.TOK_DESCTABLE:
				case HiveParser.TOK_DESCFUNCTION:
				case HiveParser.TOK_MSCK:
				case HiveParser.TOK_LOCKTABLE:
				case HiveParser.TOK_UNLOCKTABLE:
				case HiveParser.TOK_GRANT:
				case HiveParser.TOK_REVOKE:
				case HiveParser.TOK_GRANT_ROLE:
				case HiveParser.TOK_REVOKE_ROLE:
					return HiveOperationEnum.DDL;
				case HiveParser.TOK_CREATEFUNCTION:
				case HiveParser.TOK_DROPFUNCTION:
					return HiveOperationEnum.FUNC;
				default:
                    if ( strTokType.startsWith("TOK_ALTERTABLE")){
                        return HiveOperationEnum.ALTER;
                    }
					// 带insert
					if (INSERT_PATTERN.matcher(sql).find()) {
						return HiveOperationEnum.DML_INSERT;
					}
					// 只是查询
					else {
						return HiveOperationEnum.DML_SELECT;
					}
				}
			}
		}
	}

	/**
	 * @see isJoinQL
	 */
	public static boolean isJoinQL(String hiveSql) {
		HiveQueryEntity queryEntity = null;
		try {
			queryEntity = doParserHiveSql(hiveSql);
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}

		Object from = queryEntity.getFrom();
		if (from instanceof HiveJoinEntity) {
			return true;
		}

		return false;
	}

	/**
	 * 获取列名
	 * 
	 * @see getColumn
	 */
	public static HiveSelectColumn[] getColumn(String hiveSql) {
		ParseDriver pd = new ParseDriver();
		ASTNode tree;
		try {
			tree = pd.parse(hiveSql);
		} catch (ParseException e) {
			throw new PriestPlatformException("Parse sql error: " + e.getMessage());
		}
		tree = ParseUtils.findRootNonNullToken(tree);

		List<HiveSelectColumn> columnList = new ArrayList<HiveSelectColumn>();
		analyzeSelectColumns(tree, columnList);

		return columnList.toArray(new HiveSelectColumn[columnList.size()]);
	}

	private static void analyzeSelectColumns(ASTNode ast, List<HiveSelectColumn> columnList) {
		boolean skipRecursion = false;

		if (ast.getToken() != null) {
			int nodeType = ast.getToken().getType();
			if (nodeType == HiveParser.TOK_SELECT || nodeType == HiveParser.TOK_SELECTDI) {
				// 找到select结点后，不再遍历子结点
				skipRecursion = true;
				for (int i = 0; i < ast.getChildCount(); ++i) {
					ASTNode selExpr = (ASTNode) ast.getChild(i);
					if ((selExpr.getToken().getType() == HiveParser.TOK_SELEXPR)) {
						HiveSelectColumn selectColumn = getSelectCol(selExpr);

						columnList.add(selectColumn);
					}
				}
			}
		}

		if (!skipRecursion) {
			for (int i = 0; i < ast.getChildCount(); i++) {
				analyzeSelectColumns((ASTNode) ast.getChild(i), columnList);
			}
		}
	}

	private static HiveSelectColumn getSelectCol(ASTNode selExpr) {
		HiveSelectColumn selectColumn = new HiveSelectColumn();

		int childType = selExpr.getChild(0).getType();
		// * 或 t.*
		if (childType == HiveParser.TOK_ALLCOLREF) {
			selectColumn.setColumnName("*");
			// 包含表名引用 t.col
		} else if (childType == HiveParser.DOT) {
			ASTNode dotNode = (ASTNode) selExpr.getChild(0);
			selectColumn.setTableName(dotNode.getChild(0).getChild(0).getText());
			selectColumn.setColumnName(dotNode.getChild(1).getText());

			// 取列别名
			if (selExpr.getChildCount() > 1) {
				String columnAlias = unescapeIdentifier(selExpr.getChild(1).getText());
				selectColumn.setAlias(columnAlias);
			}
		} else {
			String constOrCol = selExpr.getChild(0).getText();
			if (constOrCol.matches(CONST_REGEX)) {
				selectColumn.setConstantValue(constOrCol);
			} else {
				String columnName = selExpr.getChild(0).getChild(0).getText();
				selectColumn.setColumnName(columnName);
			}

			if (selExpr.getChild(1) != null) {
				String columnAlias = unescapeIdentifier(selExpr.getChild(1).getText());
				selectColumn.setAlias(columnAlias);
			}
		}
		return selectColumn;
	}

	/**
	 * 获取查询limit, 仅限于select查询和只有一个insert的hive sql
	 * 
	 * @param sql
	 * @return
	 */
	public static Integer getLimit(String sql){
		try {
			HiveQueryEntity queryEntity = doParserHiveSql(sql);
			return queryEntity.getInsertClauses().get(0).getLimit();
		} catch (Exception e) {
			throw new PriestPlatformException(e);
		}
	}
}
