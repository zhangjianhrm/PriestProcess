package com.lenovo.lps.farseer.priest2.platform.entity;

public enum SelectItemEnum {
	LITERAL, ALL_COLUMN, ALL_TABLE_COLUMN, FUNCTION_CALL, CASE_WHEN, EXPRESSION;
	
	public boolean isExpressionSelect(){
		if(this == EXPRESSION || this == FUNCTION_CALL || this == CASE_WHEN){
			return true;
		}
		
		return false;
	}
	
}
