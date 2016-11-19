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
import com.lenovo.lps.farseer.priest2.platform.util.antlr.MySQLParser;

public final class ASTParser {
	/**
	 * 工具类不应该被实例化使用
	 */
	private ASTParser(){}

	/**
	 * 遍历抽象语法树
	 * 
	 * @param tree
	 */
	public static Select traverseTree(Tree tree) {
		Select select = new Select();
		traverseTree(tree, select);
		return select;
	}

	/**
	 * 遍历抽象select语法树
	 * 
	 * @param tree
	 * @param select
	 */
	private static void traverseTree(Tree tree, Select select) {
		if (tree == null) {
			return;
		}
		
		int nodeType = visitNode(tree, select);

		// 遍历子结点
		if (nodeType != MySQLParser.TN_SUBQUERY) {
			for (int i = 0; i < tree.getChildCount(); i++) {
				traverseTree(tree.getChild(i), select);
			}
		}
	}

	private static int visitNode(Tree tree, Select select) {
		int nodeType = tree.getType();
		switch (nodeType) {
		// select options: all, distinct...
		case MySQLParser.TN_SELECT_OPTIONS:
			visitSelectOpts(tree, select);
			break;
		// columns
		case MySQLParser.TN_COLS:
			List<SelectItem> selectItems = buildSelectItems(tree);
			select.setSelectItems(selectItems);
			break;
		// table, sub query...
		case MySQLParser.TN_FROM:
			List<FromItem> fromItems = buildFromItems(tree);
			select.setFromItems(fromItems);
			break;
		// join
		case MySQLParser.TN_JOIN:
			visitJoin(tree, select);
			break;
		// where
		case MySQLParser.TN_WHERE:
			String where = buildTreeString(tree, true);
			select.setWhere(where);
			break;
		// group by
		case MySQLParser.TN_GROUPBY:
			visitGroupBy(tree, select);
			break;
		// having
		case MySQLParser.TN_HAVING:
			String having = buildTreeString(tree);
			select.setHaving(having);
			break;
		// order by
		case MySQLParser.TN_ORDERBY:
			select.setOrderBys(new ArrayList<String>());
			for (int i = 0; i < tree.getChildCount(); i++) {
				select.getOrderBys().add(tree.getChild(i).getText());
			}
			break;
		default:
			break;
		}
		return nodeType;
	}

	private static void visitGroupBy(Tree tree, Select select) {
		select.setGroupByColumnReferences(new ArrayList<String>());
		for (int i = 0; i < tree.getChildCount(); i++) {
			select.getGroupByColumnReferences().add(tree.getChild(i).getText());
		}
	}

	private static void visitJoin(Tree tree, Select select) {
		if (select.getJoins() == null) {
			select.setJoins(new ArrayList<Join>());
		}
		Join join = buildJoin(tree);
		select.getJoins().add(join);
	}

	private static void visitSelectOpts(Tree tree, Select select) {
		select.setSelectOptions(new ArrayList<String>());
		for (int i = 0; i < tree.getChildCount(); i++) {
			select.getSelectOptions().add(tree.getChild(i).getText());
		}
	}

	/**
	 * 构造select item列表
	 * 
	 * @param tree
	 * @return
	 */
	private static List<SelectItem> buildSelectItems(Tree tree) {
		List<SelectItem> selectItems = new ArrayList<SelectItem>();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree subTree = tree.getChild(i);
			if (subTree.getType() == MySQLParser.TN_COL) {
				Tree colTree = subTree.getChild(0);
				
				SelectItem item = null;
				switch (colTree.getType()) {
				case MySQLParser.TN_COL_EXP:
					item = buildSelectItem(colTree, SelectItemEnum.LITERAL);
					break;
				case MySQLParser.TN_COL_ALLC:
					item = buildSelectItem(colTree, SelectItemEnum.ALL_COLUMN);
					break;
				case MySQLParser.TN_COL_ALLTC:
					item = buildSelectItem(colTree, SelectItemEnum.ALL_TABLE_COLUMN);
					break;
				case MySQLParser.TN_COL_BITEXP:
					item = buildBitExp(colTree);
					break;
				default:
					break;
				}
				
				selectItems.add(item);
			}
		}

		return selectItems;
	}

	private static SelectItem buildBitExp(Tree colTree) {
		Tree bitSubTree = colTree.getChild(0);
		int bitSubTreeType = bitSubTree.getType();
		
		SelectItemEnum itemType = SelectItemEnum.EXPRESSION;
		if (bitSubTreeType == MySQLParser.TN_FUNCTION) {
			itemType = (bitSubTree.getChildCount() > 1 ? SelectItemEnum.FUNCTION_CALL
					: SelectItemEnum.LITERAL);
		} else if (bitSubTreeType == MySQLParser.TN_CASE_WHEN) {
			itemType = SelectItemEnum.CASE_WHEN;
		} 
		
		SelectItem item = buildSelectItem(bitSubTree, itemType);
		if (colTree.getChild(1) != null) {
			String asTxt = colTree.getChild(1).getText();
			String alias = ("as".equalsIgnoreCase(asTxt) ? colTree.getChild(2).getText() : asTxt);
			item.setAlias(alias);
		}
		return item;
	}

	/**
	 * 构造单个select item
	 * 
	 * @param tree
	 * @return
	 */
	private static SelectItem buildSelectItem(Tree tree, SelectItemEnum itemType) {
		String column = null;
		if(itemType != SelectItemEnum.EXPRESSION){
			column = buildTreeString(tree, true);
		} else {
			column = tree.getText();
		}
		
		SelectItem item = null;
		if (itemType == SelectItemEnum.FUNCTION_CALL || itemType == SelectItemEnum.CASE_WHEN) {
			item = new SelectItem();
			item.setColumn(column);
		} else {
			item = parseColumn(column);
		}
		item.setItemType(itemType);
		
		return item;
	}

	public static SelectItem parseColumn(String column) {
		SelectItem item = new SelectItem();
		
		String columnCopy = column.trim();
		int dotIdx = columnCopy.indexOf('.');
		if (dotIdx != -1) {
			String tableName = columnCopy.substring(0, dotIdx);
			item.setTable(tableName.trim());
			columnCopy = columnCopy.replace(tableName + ".", "");
		}
		
		int asIdx = columnCopy.indexOf("as");
		if (asIdx != -1) {
			columnCopy = columnCopy.replace("as ", "");
		}
		int blankIdx = columnCopy.indexOf(' ');
		if (blankIdx != -1) {
			String alias = columnCopy.substring(blankIdx + 1);
			item.setAlias(alias.trim());
			columnCopy = columnCopy.replace(" " + alias, "");
		}
		
		item.setColumn(columnCopy.trim());
		
		return item;
	}

	/**
	 * 构造from item，item分为三种：table, sub query, join
	 * 
	 * @param tree
	 * @return
	 */
	private static List<FromItem> buildFromItems(Tree tree) {
		List<FromItem> fromItems = new ArrayList<FromItem>();
		
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree subTree = tree.getChild(i);
			if (subTree.getType() == MySQLParser.TN_TABLE_REF) {
				// table
				Table table = buildTable(subTree);
	
				fromItems.add(table);
			} else if (subTree.getType() == MySQLParser.TN_SUBQUERY) {
				// sub query
				SubQuery query = new SubQuery();
				query.setSubSelect(traverseTree(subTree.getChild(0)));
				if (tree.getChild(1) != null) {
					query.setAlias(tree.getChild(1).getText());
				}
	
				fromItems.add(query);
			}
		}

		return fromItems;
	}

	private static Table buildTable(Tree tree) {
		Table table = new Table();

		for(int i=0; i<tree.getChildCount(); i++){
			Tree subTree = tree.getChild(i);
			
			if (subTree.getType() == MySQLParser.TN_TABLE_SPEC) {
				table.setTableName(buildTreeString(subTree));
			} else {
				table.setAlias(subTree.getText());
			}
		}
		
		return table;
	}

	/**
	 * 构造join
	 * 
	 * @param tree
	 * @param join
	 */
	private static Join buildJoin(Tree tree) {
		Join join = new Join();
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree subTree = tree.getChild(i);
			int subTreeType = subTree.getType();
			// join修改符: left, left outer, right等
			if (subTreeType == MySQLParser.TN_JOIN_QUALIFIER) {
				String qualifier = buildTreeString(subTree, true);
				join.setQualifier(qualifier);
			}
			// join表
			if (subTreeType == MySQLParser.TN_JOIN_TABLE && subTree.getChild(0).getType() == MySQLParser.TN_TABLE_REF) {
				Table table = buildTable(subTree.getChild(0));
				join.setRightItem(table);
			}
			// join条件， 即on表达式
			if (subTreeType == MySQLParser.TN_JOIN_COND) {
				String condition = buildTreeString(subTree, true);
				join.setOnExpression(condition);
			}
		}

		return join;
	}

	/**
	 * 根据树的子结点构造字符串
	 * 
	 * @param tree
	 * @return
	 */
	private static String buildTreeString(Tree tree) {
		return buildTreeString(tree, false);
	}

	/**
	 * 根据树的子结点构造字符串
	 * 
	 * @param tree
	 * @param isAddBlank
	 *            是否在结点末尾添加空白
	 * @return
	 */
	private static String buildTreeString(Tree tree, boolean isAddBlank) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree subTree = tree.getChild(i);
			int subTreeType = subTree.getType();

			if (subTreeType == MySQLParser.TN_SUBQUERY) {
				sb.append("(");
				sb.append(traverseTree(subTree.getChild(0)).toString());
				sb.append(")");
				continue;
			}

			if (subTreeType == MySQLParser.TN_FUNCTION) {
				sb.append(buildTreeString(subTree, true));
			} else {
				sb.append(subTree.getText());
			}

			if (isAddBlank) {
				if (hasExtraBlank(subTreeType)) {
					int lastBlank = sb.lastIndexOf(" ");
					if (lastBlank != -1) {
						sb.deleteCharAt(sb.lastIndexOf(" "));
					}
				} else if (subTreeType == MySQLParser.MINUS || subTreeType == MySQLParser.PLUS) {
					continue;
				} else {
					sb.append(" ");
				}
			}
		}
		return sb.toString();
	}

	private static boolean hasExtraBlank(int subTreeType) {
		return subTreeType == MySQLParser.DOT || subTreeType == MySQLParser.LPAREN || subTreeType == MySQLParser.RPAREN;
	}
	
}
