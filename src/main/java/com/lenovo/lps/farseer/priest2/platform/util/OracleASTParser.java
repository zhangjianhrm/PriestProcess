package com.lenovo.lps.farseer.priest2.platform.util;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.Tree;

import com.lenovo.lps.farseer.priest2.platform.entity.FromItem;
import com.lenovo.lps.farseer.priest2.platform.entity.Join;
import com.lenovo.lps.farseer.priest2.platform.entity.Select;
import com.lenovo.lps.farseer.priest2.platform.entity.SelectItem;
import com.lenovo.lps.farseer.priest2.platform.entity.SelectItemEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.SubQuery;
import com.lenovo.lps.farseer.priest2.platform.entity.Table;
import com.lenovo.lps.farseer.priest2.platform.util.antlr.OracleParser;

/**
 * 遍历oracle抽象树
 */
public final class OracleASTParser {
	/**
	 * table列表，用于分析表名，列所属表等
	 */
	private static final List<Table> tableList = new ArrayList<Table>();

	private OracleASTParser() {
	}

	/**
	 * 分析select语法树入口
	 * 
	 * @param tree
	 * @return
	 */
	public static Select parseSelectTree(Tree tree, boolean isStart) {
		Select select = new Select();

		if (isStart) {
			tableList.clear();
		}
		parseSelectTree(tree, select);
		select.setTableList(tableList);

		return select;
	}

	/**
	 * 分析select语法树
	 * 
	 * @param tree
	 *            以SELECT_STATEMENT为根结点的树
	 * @param select
	 */
	private static void parseSelectTree(Tree tree, Select select) {
		if (tree != null) {
			boolean isSkipParseChild = false;

			int nodeType = tree.getType();

			switch (nodeType) {
			// from子句，包含join子句
			// 此处先分析from子树是为了填充tableList列表
			case OracleParser.FROM_CLAUSE:
				visitFromClause(tree, select);
				isSkipParseChild = true;
				break;
			// select选项，distinct, unique等
			case OracleParser.SELECT_OPTIONS:
				List<String> opts = visitSelectOpts(tree);
				select.setSelectOptions(opts);
				break;
			// select列
			case OracleParser.SELECT_LIST:
				List<SelectItem> selectItems = visitSelectList(tree);
				select.setSelectItems(selectItems);
				break;
			// where子句
			case OracleParser.WHERE_CLAUSE:
				String where = visitWhere(tree);
				select.setWhere(where);
				break;
			// group by子句，包含having子句
			case OracleParser.GROUP_BY_CLAUSE:
				visitGroupBy(tree, select);
				break;
			// order by 子句
			case OracleParser.ORDER_BY_CLAUSE:
				List<String> orderBys = visitOrderBy(tree);
				select.setOrderBys(orderBys);
			default:
				break;
			}

			if (!isSkipParseChild) {
				for (int i = 0; i < tree.getChildCount(); i++) {
					parseSelectTree(tree.getChild(i), select);
				}
			}
		}
	}

	/**
	 * 分析from子树
	 * 
	 * @param tree
	 *            根结点为FROM_CLAUSE的子树
	 * @param select
	 */
	private static void visitFromClause(Tree tree, Select select) {
		List<FromItem> fromItems = new ArrayList<FromItem>();
		List<Join> joins = new ArrayList<Join>();
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree tableRef = tree.getChild(i);
			for (int j = 0; j < tableRef.getChildCount(); j++) {
				Tree tableRefChild = tableRef.getChild(j);
				// 分析from表名、别名
				if (tableRefChild.getType() == OracleParser.TABLE_REF_ELEMENT) {
					FromItem item = visitTableElement(tableRefChild);
					fromItems.add(item);
				}
				// 分析join
				else if (tableRefChild.getType() == OracleParser.JOIN_DEF) {
					Join join = visitJoinElement(tableRefChild);
					joins.add(join);
				}
			}
		}
		select.setFromItems(fromItems);
		select.setJoins(joins);
	}

	/**
	 * 分析table子树
	 * 
	 * @param tableRefElement
	 *            根结点为TABLE_REF_ELEMENT的子树
	 * @return
	 */
	private static FromItem visitTableElement(Tree tableRefElement) {
		FromItem item = null;
		String alias = null;
		for (int i = 0; i < tableRefElement.getChildCount(); i++) {
			Tree refChild = tableRefElement.getChild(i);
			// 设置table别名
			if (refChild.getType() == OracleParser.ALIAS) {
				alias = refChild.getChild(0).getText();
			}
			// 设置table表名
			else if (refChild.getType() == OracleParser.TABLE_EXPRESSION) {
				Tree mode = refChild.getChild(0);
				// from后为表名
				if (mode.getType() == OracleParser.DIRECT_MODE) {
					Tree tableView = mode.getChild(0);
					String tableName = "";
					for(int j=0; j<tableView.getChildCount(); j++){
						tableName += tableView.getChild(j).getText() + ".";
					}
					tableName = tableName.substring(0, tableName.length()-1);
					
					Table table = new Table();
					table.setTableName(tableName);

					item = table;
					// from后为子查询
				} else if (mode.getType() == OracleParser.SELECT_MODE) {
					SubQuery subQuery = new SubQuery();
					Select select = parseSelectTree(mode.getChild(0), false);
					subQuery.setSubSelect(select);

					item = subQuery;
				}
			}
		}
		item.setAlias(alias);

		// 填充table列表
		if (item instanceof Table) {
			tableList.add((Table) item);
		}

		return item;
	}

	/**
	 * 分析join子树
	 * 
	 * @param tableRefChild
	 *            根结点为JOIN_DEF的子树
	 * @return
	 */
	private static Join visitJoinElement(Tree tableRefChild) {
		Join join = new Join();
		for (int i = 0; i < tableRefChild.getChildCount(); i++) {
			Tree child = tableRefChild.getChild(i);
			// join修饰符, left, right, outer等
			if (child.getType() == OracleParser.JOIN_QUALIFIER && child.getChildCount() > 0) {
				String qualifier = buildTreeElements(child, false);
				join.setQualifier(qualifier);
			}
			// join的表
			else if (child.getType() == OracleParser.TABLE_REF_ELEMENT) {
				FromItem rightItem = visitTableElement(child);
				join.setRightItem(rightItem);
				// on表达式
			} else if (child.getType() == OracleParser.JOIN_ON_PART) {
				Tree equalPart = child.getChild(0).getChild(0);
				String leftExpr = buildCascatedElement(equalPart.getChild(0), false);
				String rightExpr = buildCascatedElement(equalPart.getChild(1), false);
				join.setOnExpression(leftExpr + " = " + rightExpr);
			}
		}

		return join;
	}

	/**
	 * 分析select选项，distinct, unique等
	 * 
	 * @param tree
	 *            根结点为SELECT_OPTIONS的子树
	 * @return 选项列表
	 */
	private static List<String> visitSelectOpts(Tree tree) {
		List<String> opts = new ArrayList<String>();

		final int childCount = tree.getChildCount();
		if (childCount > 0) {
			for (int i = 0; i < childCount; i++) {
				opts.add(tree.getChild(i).getText());
			}
		}
		return opts;
	}

	/**
	 * 分析select列
	 * 
	 * @param tree
	 *            根结点为SELECT_LIST的子树
	 * @return SelectItem列表
	 */
	private static List<SelectItem> visitSelectList(Tree tree) {
		List<SelectItem> selectItems = new ArrayList<SelectItem>();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree listChild = tree.getChild(i);

			// select * from ...
			if ("*".equals(listChild.getText())) {
				SelectItem item = new SelectItem();
				item.setColumn(listChild.getText());
				item.setItemType(SelectItemEnum.ALL_COLUMN);
				selectItems.add(item);
				break;
			}

			if (listChild.getType() == OracleParser.SELECT_ITEM) {
				selectItems.add(visitSelectItem(listChild));
			}
		}

		return selectItems;
	}

	/**
	 * 分析每个select列
	 * 
	 * @param tree
	 *            根结点为SELECT_ITEM的子树
	 * @return SelectItem
	 */
	private static SelectItem visitSelectItem(Tree tree) {
		SelectItem selectItem = new SelectItem();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree itemChild = tree.getChild(i);

			// select table.* from ...模式
			if (itemChild.getChild(0).getType() == OracleParser.DOT_ASTERISK) {
				Tree asteriskTree = itemChild.getChild(0);
				selectItem.setColumn(asteriskTree.getText());
				selectItem.setTable(asteriskTree.getChild(0).getChild(0).getText());
				selectItem.setItemType(SelectItemEnum.ALL_TABLE_COLUMN);
				break;
			}

			if (itemChild.getType() == OracleParser.EXPR) {
				Tree exprChild = itemChild.getChild(0);

				// 列为函数
				if (exprChild.getType() == OracleParser.STANDARD_FUNCTION) {
					selectItem.setItemType(SelectItemEnum.FUNCTION_CALL);
					selectItem.setColumn(visitFunction(exprChild));
				// case when
				} else if ("case".equalsIgnoreCase(exprChild.getText())) {
					selectItem.setItemType(SelectItemEnum.CASE_WHEN);
					selectItem.setColumn(visitCaseWhenItem(exprChild));
				}
				// expression
				else if (exprChild.getText().matches("\\+|-|\\*|/")) {
					selectItem.setItemType(SelectItemEnum.EXPRESSION);
					selectItem.setColumn(visitExpItem(exprChild));
				} else if (exprChild.getType() == OracleParser.CASCATED_ELEMENT) {
					selectItem.setItemType(SelectItemEnum.LITERAL);
					Tree elem = exprChild.getChild(0);
					if (elem.getType() == OracleParser.ROUTINE_CALL) {
						selectItem.setItemType(SelectItemEnum.FUNCTION_CALL);
						selectItem.setColumn(buildCascatedElement(exprChild, false));
					} else if (elem.getChildCount() > 1) {
						selectItem.setTable(elem.getChild(0).getText());
						selectItem.setColumn(elem.getChild(1).getText());
					} else {
						selectItem.setColumn(elem.getChild(0).getText());
					}
				} else {
					selectItem.setItemType(SelectItemEnum.LITERAL);
					selectItem.setColumn(buildCondPart(exprChild));
				}
				// 别名
			} else if (itemChild.getType() == OracleParser.ALIAS) {
				selectItem.setAlias(itemChild.getChild(0).getText());
			}
		}

		return selectItem;
	}

	/**
	 * 分析函数列
	 * 
	 * @param exprChild
	 *            根结点为STANDARD_FUNCTION的子树
	 * @return
	 */
	private static String visitFunction(Tree exprChild) {
		StringBuilder sb = new StringBuilder(exprChild.getChild(0).getText());
		sb.append("(");
		Tree funcTree = exprChild.getChild(0);
		if(funcTree.getChild(0).getType() == OracleParser.CASCATED_ELEMENT){
			sb.append(buildCascatedElement(funcTree.getChild(0), true));
		} else {
			sb.append(funcTree.getChild(0).getChild(0).getText());
		}
		sb.append(" as ");
		if(funcTree.getChildCount() > 1 && funcTree.getChild(1).getType() == OracleParser.NATIVE_DATATYPE){
			Tree subFuncTree = funcTree.getChild(1);
			sb.append(subFuncTree.getChild(0).getText());
			if (subFuncTree.getChildCount() > 1 && subFuncTree.getChild(1).getType() == OracleParser.PRECISION) {
				sb.append("(" + subFuncTree.getChild(1).getChild(0).getText() + ")");
			}
		}
		sb.append(")");
		
		return sb.toString();
	}

	/**
	 * 分析case when列
	 * 
	 * @param exprChild
	 *            根结点为case的子树
	 * @return
	 */
	private static String visitCaseWhenItem(Tree exprChild) {
		StringBuilder sb = new StringBuilder();

		sb.append("(case ");
		for (int i = 0; i < exprChild.getChildCount(); i++) {
			Tree childItem = exprChild.getChild(i);

			if ("when".equalsIgnoreCase(childItem.getText())) {
				sb.append(visitWhenItem(childItem));
			} else if ("else".equalsIgnoreCase(childItem.getText())) {
				sb.append("else ");
				sb.append(buildTreeElements(childItem.getChild(0), false));
			}
		}
		sb.append(" end");
		sb.append(")");

		return sb.toString();
	}

	/**
	 * 分析case when中的when部分
	 * 
	 * @param childItem
	 *            根结点为when的子树
	 * @return
	 */
	private static String visitWhenItem(Tree childItem) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < childItem.getChildCount(); i++) {
			Tree childTree = childItem.getChild(i);
			if (childTree.getType() == OracleParser.LOGIC_EXPR) {
				sb.append("when ");
				sb.append(buildLogicExpr(childTree));
				sb.append(" ");
			} else if (childTree.getType() == OracleParser.EXPR) {
				sb.append("then ");
				sb.append(buildTreeElements(childTree, false));
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	/**
	 * 分析expression列， 像 a + b 的表达式
	 * 
	 * @param exprChild
	 *            根结点为算术运算符的子树
	 * @return
	 */
	private static String visitExpItem(Tree exprChild) {
		StringBuilder sb = new StringBuilder();

		sb.append("(");
		for (int i = 0; i < exprChild.getChildCount(); i++) {
			if (i > 0) {
				sb.append(exprChild.getText());
			}

			Tree childElem = exprChild.getChild(i);
			if (childElem.getText().matches("\\+|-|\\*|/")) {
				sb.append(visitExpItem(childElem));
			} else {
				sb.append(buildCascatedElement(childElem, false));
			}
		}
		sb.append(")");

		return sb.toString();
	}

	/**
	 * 分析where子树
	 * 
	 * @param tree
	 *            根结点为WHERE_CLAUSE的树
	 * @return
	 */
	private static String visitWhere(Tree tree) {
		StringBuilder sb = new StringBuilder();

		Tree logicExpr = tree.getChild(0);
		if (tree.getType() != OracleParser.WHERE_CLAUSE) {
			logicExpr = tree;
		}

		for (int i = 0; i < logicExpr.getChildCount(); i++) {
			Tree logicExprChild = logicExpr.getChild(i);
			// where条件包含and/or/not等逻辑操作符
			if (logicExprChild.getText().matches("and|or|not")) {
				boolean isNested = false;
				// 条件嵌套
				if (logicExprChild.getParent().getText().matches("and|or|not") && i == 1) {
					sb.append(" " + logicExpr.getText() + " (");
					isNested = true;
				}
				
				sb.append(visitWhere(logicExprChild));
				
				if(isNested){
					sb.append(") ");
				}
			}
			// where条件为单个表达式
			else {
				if (i == 1) {
					sb.append(" " + logicExpr.getText() + " ");
				}
				
				sb.append(buildCondition(logicExprChild));
			}
		}

		return sb.toString();
	}

	private static String buildCondition(Tree logicExprChild) {
		StringBuilder sb = new StringBuilder();
		
		// left part
		sb.append(buildCondPart(logicExprChild.getChild(0)));
		
		String logicExpr = logicExprChild.getText();
		// is null, is not null 等is开头的条件做特殊处理
		if (logicExpr.startsWith("IS_")) {
			sb.append(" " + logicExpr.toLowerCase().replace('_', ' '));
		// in, not in
		} else if(logicExpr.matches("(?i)in|not_in")){
			sb.append(" " + buildInPart(logicExprChild) + "");
		} else {
			// operator
			sb.append(" " + logicExpr + " ");
			// right part
			sb.append(buildCondPart(logicExprChild.getChild(1)));
		}
		
		return sb.toString();
	}

	/**
	 * 构造where条件中的in, not in部分
	 * 
	 * @param logicExprChild
	 * @return
	 */
	private static String buildInPart(Tree logicExprChild) {
		StringBuilder sb = new StringBuilder();

		// in/not in literal
		sb.append(logicExprChild.getText().toLowerCase().replace('_', ' '));

		// in/not in list
		sb.append(" (");

		for (int i = 0; i < logicExprChild.getChildCount(); i++) {
			// eg: (EXPR_LIST (EXPR 'PHONE') (EXPR 'PAD'))
			if (logicExprChild.getChild(i).getType() == OracleParser.EXPR_LIST) {
				Tree exprList = logicExprChild.getChild(i);
				// eg: (EXPR 'PHONE')
				for (int j = 0; j < exprList.getChildCount(); j++) {
					if (j != 0) {
						sb.append(", ");
					}
					sb.append(exprList.getChild(j).getChild(0).getText());
				}
			// in subquery
			} else if(logicExprChild.getChild(i).getType() == OracleParser.SUBQUERY){
				sb.append(parseSelectTree(logicExprChild.getChild(i), false));
			}
		}
		
		sb.append(") ");
		
		return sb.toString();
	}

	private static String buildCondPart(Tree child) {
		StringBuilder sb = new StringBuilder();
		
		if (child.getType() == OracleParser.CASCATED_ELEMENT) {
			sb.append(buildCascatedElement(child, false));
		} else if(child.getType() == OracleParser.SPECIAL_FUNC){
			sb.append(buildSpecialFunc(child));
		} else {
			if (child.getChildCount() == 0) {
				sb.append(child.getText());
			} else {
				sb.append(buildCondition(child));
			}
		}
		
		return sb.toString();
	}

	private static String buildSpecialFunc(Tree child) {
		Tree funcNameTree = child.getChild(0);
		String funcName = "";
		for(int i=0; i< funcNameTree.getChildCount(); i++){
			funcName += funcNameTree.getChild(i).getText();
		}
		
		String args = "";
		for(int i=1; i< child.getChildCount(); i++){
			args += child.getChild(i).getText() + " ";
		}
		
		return (funcName + " " + args).trim();
	}

	/**
	 * 分析group by子树
	 * 
	 * @param tree
	 *            根结点为GROUP_BY_CLAUSE的子树
	 * @param select
	 */
	private static void visitGroupBy(Tree tree, Select select) {
		List<String> groupBys = new ArrayList<String>();
		String having = "";
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree groupByExpr = tree.getChild(i);
			if (groupByExpr.getType() == OracleParser.GROUP_BY_ELEMENT) {
				String groupBy = buildCascatedElement(groupByExpr.getChild(0), true);
				groupBys.add(groupBy);
			} else if (groupByExpr.getType() == OracleParser.HAVING_CLAUSE) {
				having = visitWhere(groupByExpr.getChild(0));
			}
		}
		select.setGroupByColumnReferences(groupBys);
		select.setHaving(having);
	}

	/**
	 * 分析order by子树
	 * 
	 * @param tree
	 *            根结点为ORDER_BY_CLAUSE的子树
	 * @return
	 */
	private static List<String> visitOrderBy(Tree tree) {
		List<String> orderBys = new ArrayList<String>();

		Tree orderByElems = tree.getChild(0);
		for (int i = 0; i < orderByElems.getChildCount(); i++) {
			Tree orderByElem = orderByElems.getChild(i);
			if (orderByElem.getType() == OracleParser.ORDER_BY_ELEMENT) {
				String orderBy = buildCascatedElement(orderByElem.getChild(0), true);
				orderBys.add(orderBy);
			}
		}

		return orderBys;
	}

	private static String buildLogicExpr(Tree tree) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree childTree = tree.getChild(i);

			if (childTree.getText().toLowerCase().matches("and|or|not|\\+|-|\\*|/")) {
				sb.append(buildLogicExpr(childTree));
			} else {
				if (i == 1) {
					sb.append(" " + tree.getText() + " ");
				}
				sb.append(buildCascatedElement(childTree, true));
				sb.append(" " + childTree.getText() + " ");
				sb.append(childTree.getChild(1).getText());
			}
		}

		return sb.toString();
	}

	private static String buildCascatedElement(Tree tree, boolean isExpr) {
		Tree anyElemTree = tree.getChild(0);
		
		String result = null;
		if(anyElemTree.getType() == OracleParser.ROUTINE_CALL){
			result = buildRoutineCall(anyElemTree);
		} else {
			if (isExpr) {
				anyElemTree = anyElemTree.getChild(0);
			}

			result = buildTreeElements(anyElemTree);
		}
		
		return result;
	}
	
	private static String buildRoutineCall(Tree tree) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < tree.getChildCount(); i++) {
			int subTreeType = tree.getChild(i).getType();
			if (subTreeType == OracleParser.ROUTINE_NAME) {
				sb.append(tree.getChild(i).getChild(0).getText());
			} else if (subTreeType == OracleParser.ARGUMENTS) {
				sb.append("(");
				sb.append(buildArguments(tree.getChild(i)));
				sb.append(")");
			}
		}

		return sb.toString();
	}

	private static Object buildArguments(Tree tree) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree subTree = tree.getChild(i);
			if (subTree.getType() == OracleParser.ARGUMENT) {
				Tree casElemTree = subTree.getChild(0).getChild(0);
				// AST eg: (ARGUMENT (EXPR '2013-09-12'))
				if (casElemTree.getChildCount() == 0) {
					sb.append(casElemTree.getText());
				// AST eg: (ARGUMENT (EXPR (CASCATED_ELEMENT (ANY_ELEMENT sysdate))))
				} else if (casElemTree.getType() == OracleParser.CASCATED_ELEMENT) {
					sb.append(buildCascatedElement(casElemTree, false));
				// AST eg: (ARGUMENT (EXPR (- (CASCATED_ELEMENT (ANY_ELEMENT sysdate)) 1)))
				} else {
					sb.append(buildCascatedElement(casElemTree.getChild(0), false));
					sb.append(casElemTree.getText());
					sb.append(casElemTree.getChild(1).getText());
				}
				sb.append(", ");
			}
		}

		return sb.delete(sb.length() - 2, sb.length()).toString();
	}

	private static String buildTreeElements(Tree tree) {
		return buildTreeElements(tree, true);
	}

	private static String buildTreeElements(Tree tree, boolean isAddDot) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tree.getChildCount(); i++) {
			sb.append(tree.getChild(i).getText());
			if (isAddDot) {
				sb.append(".");
			} else {
				sb.append(" ");
			}
		}

		return sb.deleteCharAt(sb.length() - 1).toString();
	}

}
