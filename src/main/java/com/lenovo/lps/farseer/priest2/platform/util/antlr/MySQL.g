/*
compile with antlr 3.1.3 
compile method: java org.antlr.Tool MySQL.g -Xconversiontimeout 3000
	note: with no option -Xconversiontimeout will cause compilation error
*/
grammar MySQL;

options 
{
	output=AST;
	ASTLabelType=CommonTree;
	backtrack=true;
	memoize=true;
}

import SQLLexer, SQLParser1, SQLParser2;

tokens {
	TN_SELECT;
	TN_SELECT_OPTIONS;
	TN_COLS;
	TN_COL;
	TN_COL_ALLC;
	TN_COL_ALLTC;
	TN_COL_EXP;
	TN_COL_BITEXP;
	TN_FROM;
	TN_TABLE_REF;
	TN_TABLE_SPEC;
	TN_PARTITION;
	TN_WHERE;
	TN_GROUPBY;
	TN_HAVING;
	TN_ORDERBY;
	TN_LIMIT;
	TN_LOCKTYPE;
	TN_UPDATE;
	TN_CREATE;
	TN_ALTER;
	TN_DROP;
	TN_INSERT;
	TN_REPLACE;
	TN_DELETE;
	TN_TRUNCATE;
	TN_UNION;
	TN_JOIN;
	TN_JOIN_QUALIFIER;
	TN_JOIN_TABLE;
	TN_JOIN_COND;
	TN_FUNCTION;
	TN_SUBQUERY;
	TN_CASE_WHEN;
}

@parser::header{package com.lenovo.lps.farseer.priest2.platform.util.antlr;}

@parser::members {

  @Override
  protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
    throw new MismatchedTokenException(ttype, input);
  }

  @Override
  public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException {
    throw e;
  }

}

@rulecatch {
catch (RecognitionException e){
	throw e;
}
}

// basic type definition -----------------------------------------------------------------------
relational_op: 
	EQ_SYM | LTH | GTH | NOT_EQ | LET | GET  ;
	
charset_name:
	  ARMSCII8
	| ASCII_SYM
	| BIG5
	| BINARY
	| CP1250
	| CP1251
	| CP1256
	| CP1257
	| CP850
	| CP852
	| CP866
	| CP932
	| DEC8
	| EUCJPMS
	| EUCKR
	| GB2312
	| GBK
	| GEOSTD8
	| GREEK
	| HEBREW
	| HP8
	| KEYBCS2
	| KOI8R
	| KOI8U
	| LATIN1
	| LATIN2
	| LATIN5
	| LATIN7
	| MACCE
	| MACROMAN
	| SJIS
	| SWE7
	| TIS620
	| UCS2
	| UJIS
	| UTF8;

cast_data_type:	
	BINARY (INTEGER_NUM)? 
	| CHAR (INTEGER_NUM)? 
	| DATE_SYM
	| DATETIME 
	| DECIMAL_SYM ( INTEGER_NUM (COMMA INTEGER_NUM)? )?
	| SIGNED_SYM (INTEGER_SYM)?
	| TIME_SYM
	| UNSIGNED_SYM (INTEGER_SYM)?
;

search_modifier:	
	(IN_SYM NATURAL LANGUAGE MODE_SYM)
	| (IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM)
	| (IN_SYM BOOLEAN_SYM MODE_SYM)
	| (WITH QUERY_SYM EXPANSION_SYM)
;

transcoding_name:
	  LATIN1
	| UTF8
;

interval_unit:
	  SECOND
	| MINUTE
	| HOUR
	| DAY_SYM
	| WEEK
	| MONTH
	| QUARTER
	| Y_ E_ A_ R_
	| SECOND_MICROSECOND
	| MINUTE_MICROSECOND
	| MINUTE_SECOND
	| HOUR_MICROSECOND
	| HOUR_SECOND
	| HOUR_MINUTE
	| DAY_MICROSECOND
	| DAY_SECOND
	| DAY_MINUTE
	| DAY_HOUR
	| YEAR_MONTH
;

collation_names:
	LATIN1_GENERAL_CS | LATIN1_BIN
;

// basic const data definition ---------------------------------------------------------------
string_literal:		TEXT_STRING | NULL_SYM ;
number_literal:		(PLUS | MINUS)? (INTEGER_NUM | REAL_NUMBER | NULL_SYM) ;
hex_literal:		HEX_DIGIT | NULL_SYM;
boolean_literal:	TRUE_SYM | FALSE_SYM | NULL_SYM;
bit_literal:		BIT_NUM | NULL_SYM;

literal_value:
        ( string_literal | number_literal | hex_literal | boolean_literal | bit_literal | NULL_SYM ) ;
		
// function defintion -------------------------------------------------------------------------
functionList:
	  number_functions 
	| char_functions 
	| time_functions
	| other_functions
;

special_functions:
	EXTRACT LPAREN interval_unit FROM expression RPAREN
	| YEAR_FUNC expression RPAREN
;

number_functions:
	  ABS
	| ACOS
	| ASIN
	| ATAN2
	| ATAN
	| CEIL
	| CEILING
	| CONV
	| COS
	| COT
	| CRC32
	| DEGREES
	| EXP
	| FLOOR
	| LN
	| LOG10
	| LOG2
	| LOG
	| MOD
	| PI
	| POW
	| POWER
	| RADIANS
	| RAND
	| ROUND
	| SIGN
	| SIN
	| SQRT
	| TAN
	| TRUNCATE
;	

char_functions:
	  ASCII_SYM
	| BIN
	| BIT_LENGTH
	| CHAR_LENGTH
	| CHAR
	| CONCAT_WS
	| CONCAT
	| ELT
	| EXPORT_SET
	| FIELD
	| FIND_IN_SET
	| FORMAT
	| FROM_BASE64
	| HEX
	| INSERT
	| INSTR
	| LEFT
	| LENGTH
	| LOAD_FILE
	| LOCATE
	| LOWER
	| LPAD
	| LTRIM
	| MAKE_SET
	| MID
	| OCT
	| ORD
	| QUOTE
	| REPEAT
	| REPLACE
	| REVERSE
	| RIGHT
	| RPAD
	| RTRIM
	| SOUNDEX
	| SPACE
	| STRCMP
	| SUBSTRING_INDEX
	| SUBSTRING
	| TO_BASE64
	| TRIM
	| UNHEX
	| UPPER
	| WEIGHT_STRING
;

time_functions:
	  ADDDATE
	| ADDTIME
	| CONVERT_TZ
	| CURDATE
	| CURTIME
	| DATE_ADD
	| DATE_FORMAT
	| DATE_SUB
	| DATE_SYM
	| DATEDIFF
	| DAYNAME
	| DAYOFMONTH
	| DAYOFWEEK
	| DAYOFYEAR
	| DAY_SYM
	| FROM_DAYS
	| FROM_UNIXTIME
	| GET_FORMAT
	| HOUR
	| LAST_DAY 
	| MAKEDATE
	| MAKETIME 
	| MICROSECOND
	| MINUTE
	| MONTH
	| MONTHNAME
	| NOW
	| PERIOD_ADD
	| PERIOD_DIFF
	| QUARTER
	| SEC_TO_TIME
	| SECOND
	| STR_TO_DATE
	| SUBTIME
	| SYSDATE
	| TIME_FORMAT
	| TIME_TO_SEC
	| TIME_SYM
	| TIMEDIFF
	| TIMESTAMP
	| TIMESTAMPADD
	| TIMESTAMPDIFF
	| TO_DAYS
	| TO_SECONDS
	| UNIX_TIMESTAMP
	| UTC_DATE
	| UTC_TIME
	| UTC_TIMESTAMP
	| WEEK
	| WEEKDAY
	| WEEKOFYEAR
	| YEARWEEK
;

other_functions:
	MAKE_SET | LOAD_FILE
	| IF | IFNULL
	| AES_ENCRYPT | AES_DECRYPT
	| DECODE | ENCODE
	| DES_DECRYPT | DES_ENCRYPT
	| ENCRYPT | MD5
	| OLD_PASSWORD | PASSWORD
	| BENCHMARK | CHARSET | COERCIBILITY | COLLATION | CONNECTION_ID
	| CURRENT_USER | DATABASE | SCHEMA | USER | SESSION_USER | SYSTEM_USER
	| VERSION_SYM
	| FOUND_ROWS | LAST_INSERT_ID | DEFAULT
	| GET_LOCK | RELEASE_LOCK | IS_FREE_LOCK | IS_USED_LOCK | MASTER_POS_WAIT
	| INET_ATON | INET_NTOA
	| NAME_CONST
	| SLEEP
	| UUID
	| VALUES
;

group_functions:
	AVG | COUNT | MAX_SYM | MIN_SYM | SUM
	| BIT_AND | BIT_OR | BIT_XOR
	| GROUP_CONCAT
	| STD | STDDEV | STDDEV_POP | STDDEV_SAMP
	| VAR_POP | VAR_SAMP | VARIANCE
;

// identifiers ---------------------------------------------------------------------
schema_name			: tmpName=ID ;
table_name			: tmpName=ID ;
engine_name			: tmpName=ID ;
column_name			: tmpName=ID ;
view_name			: tmpName=ID ;
parser_name			: tmpName=ID ;
index_name			: tmpName=ID ;
partition_name			: tmpName=ID ;
partition_logical_name		: tmpName=ID ;
constraint_symbol_name		: tmpName=ID ;
foreign_key_symbol_name		: tmpName=ID ;
collation_name			: tmpName=ID ;
event_name			: tmpName=ID ;
user_name			: tmpName=ID ;
function_name			: tmpName=ID ;
procedure_name			: tmpName=ID ;
server_name			: tmpName=ID ;
wrapper_name			: tmpName=ID ;
alias				: ( AS_SYM )? tmpName=ID ;

// expression statement -----------------------------------------------------------------
expression:	exp_factor1 ( OR_SYM exp_factor1 )* ;
exp_factor1:	exp_factor2 ( XOR exp_factor2 )* ;
exp_factor2:	exp_factor3 ( AND_SYM exp_factor3 )* ;
exp_factor3:	(NOT_SYM)? exp_factor4 ;
exp_factor4:	bool_primary ( IS_SYM (NOT_SYM)? (boolean_literal|NULL_SYM) )? ;
bool_primary:
	  ( predicate relational_op predicate ) 
	| ( predicate relational_op ( ALL | ANY )? subquery )
	| ( NOT_SYM? EXISTS subquery )
	| predicate 
;
predicate:
	  ( bit_expr (NOT_SYM)? IN_SYM (subquery | expression_list) )
	| ( bit_expr (NOT_SYM)? BETWEEN bit_expr AND_SYM predicate ) 
	| ( bit_expr SOUNDS_SYM LIKE_SYM bit_expr ) 
	| ( bit_expr (NOT_SYM)? LIKE_SYM simple_expr (ESCAPE_SYM simple_expr)? )
	| ( bit_expr (NOT_SYM)? REGEXP bit_expr ) 
	| ( bit_expr )  
;
bit_expr:
	factor1 ( VERTBAR factor1 )? ;
factor1:
	factor2 ( BITAND factor2 )? ;
factor2:
	factor3 ( (SHIFT_LEFT|SHIFT_RIGHT) factor3 )? ;
factor3:
	factor4 ( (PLUS|MINUS) factor4 )* ;
factor4:
	factor5 ( (ASTERISK|DIVIDE|MOD_SYM|POWER_OP) factor5 )* ;
factor5:
	factor6 ( (PLUS|MINUS) interval_expr )? ;
factor6:
	(PLUS | MINUS | NEGATION | BINARY) simple_expr
	| simple_expr
	;
simple_expr:
	literal_value
	| column_spec
	| function_call -> ^(TN_FUNCTION function_call)
	| USER_VAR
	| expression_list
	| (ROW_SYM expression_list)
	| subquery
	| EXISTS subquery
	| match_against_statement
	| case_when_statement -> ^(TN_CASE_WHEN case_when_statement)
	| interval_expr
;

function_call:
	  (  functionList ( LPAREN (expression (COMMA expression)*)? RPAREN ) ?  )
	| (  CAST_SYM LPAREN expression AS_SYM cast_data_type RPAREN  )
	| (  CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN  )
	| (  CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN  )
	| (  group_functions ( LPAREN ( ASTERISK | ALL | DISTINCT )? bit_expr? RPAREN )?  )
	| ( special_functions )
;

case_when_statement:
        case_when_statement1 | case_when_statement2
;
case_when_statement1:
        CASE_SYM
        ( WHEN_SYM expression THEN_SYM bit_expr )+
        ( ELSE_SYM bit_expr )?
        END_SYM
;
case_when_statement2:
        CASE_SYM bit_expr
        ( WHEN_SYM bit_expr THEN_SYM bit_expr )+
        ( ELSE_SYM bit_expr )?
        END_SYM
;

match_against_statement:	
	MATCH (column_spec (COMMA column_spec)* ) AGAINST (expression (search_modifier)? ) 
;

column_spec:
	( table_name DOT )? column_name;

expression_list:
	LPAREN expression ( COMMA expression )* RPAREN ;

interval_expr:
	INTERVAL_SYM expression interval_unit
;

// JOIN Syntax ------------------------------------------------------------------
table_references:
        table_reference ( COMMA table_reference )*
;

table_reference:
	table_atom join_table*
	;
join_table:
	(join_qualifier1)? JOIN_SYM table_atom (join_condition)? -> ^(TN_JOIN ^(TN_JOIN_QUALIFIER join_qualifier1)? ^(TN_JOIN_TABLE table_atom) ^(join_condition)?)
	| STRAIGHT_JOIN table_atom (ON expression)?
	| (join_qualifier2) (OUTER)? JOIN_SYM table_atom join_condition -> ^(TN_JOIN ^(TN_JOIN_QUALIFIER join_qualifier2 OUTER?) ^(TN_JOIN_TABLE table_atom) ^(join_condition))
	| NATURAL ( (LEFT|RIGHT) (OUTER)? )? JOIN_SYM table_atom
	;
join_qualifier1:
	INNER_SYM | CROSS 
	;
join_qualifier2:
	LEFT|RIGHT
	;
table_atom:
	  table_spec (alias)? (index_hint_list)? -> ^(TN_TABLE_REF table_spec alias?)
	| subquery alias
	| LPAREN table_references RPAREN
	;
join_condition:
	  ON expression -> ^(TN_JOIN_COND expression)
	  | (USING_SYM column_list)
;
index_hint_list:
	index_hint (COMMA index_hint)*
;
index_options:
	(INDEX_SYM | KEY_SYM) (  FOR_SYM ((JOIN_SYM) | (ORDER_SYM BY_SYM) | (GROUP_SYM BY_SYM))  )?
;
index_hint:
	  USE_SYM    index_options LPAREN (index_list)? RPAREN
	| IGNORE_SYM index_options LPAREN index_list RPAREN
	| FORCE_SYM  index_options LPAREN index_list RPAREN
;
index_list:
	index_name (COMMA index_name)
;
partition_clause:
	PARTITION_SYM LPAREN partition_names RPAREN
;
partition_names:	partition_name (COMMA partition_name)* ;

// SQL Statement Syntax ------------------------------------------------------------------------------
root_statement:
	(SHIFT_LEFT! SHIFT_RIGHT!)?  
	( data_manipulation_statements | data_definition_statements )
	(SEMI!)? EOF!
;

data_manipulation_statements:
	  select_statement
	| delete_statements
	| insert_statements
	| update_statements

	| call_statement
	| do_statement
	| handler_statements
	| load_data_statement
	| load_xml_statement
	| replace_statement
	| use_statement
;

data_definition_statements: 
	  create_database_statement
	| alter_database_statements
	| drop_database_statement
	
	| create_event_statement
	| alter_event_statement
	| drop_event_statement
	
	| create_server_statement
	| alter_server_statement
	| drop_server_statement
	
	| create_table_statement
	| alter_table_statement
	| drop_table_statement
	
	| create_view_statement
	| alter_view_statement
	| rename_table_statement
	| drop_view_statement
	| truncate_table_statement
	
	| create_index_statement
	| drop_index_statement
;

use_statement:
		USE_SYM schema_name -> ^(USE_SYM schema_name)
;

// select --------------------------------------------------------------------------------------
select_statement:
        select_expression ( (UNION_SYM (ALL)?)^ select_expression )* -> ^(select_expression ^(TN_UNION select_expression)*)
;

select_expression:
	SELECT 
	select_expresssion_cont
	-> ^(TN_SELECT select_expresssion_cont)
	;

select_expresssion_cont:
	select_options?
	select_list
	select_expression_cont2?
	-> ^(TN_SELECT_OPTIONS select_options)? ^(TN_COLS select_list) select_expression_cont2?
	;

select_expression_cont2:
	( 
		FROM table_references
		( partition_clause )?
		( where_clause )? 
		( groupby_clause )?
		( having_clause )?
	) ? 
	( orderby_clause )?
	( limit_clause )?
	( lock_type )? 
	-> ^(TN_FROM table_references ^(TN_PARTITION partition_clause)? ^(TN_WHERE where_clause)? ^(groupby_clause)? ^(TN_HAVING having_clause)?)?
	^(orderby_clause)? ^(TN_LIMIT limit_clause)? ^(TN_LOCKTYPE lock_type)?
	;
	
select_options:
	( ALL | DISTINCT | DISTINCTROW )? 
	(HIGH_PRIORITY)?
	(STRAIGHT_JOIN)?
	(SQL_SMALL_RESULT)? (SQL_BIG_RESULT)? (SQL_BUFFER_RESULT)?
	(SQL_CACHE_SYM | SQL_NO_CACHE_SYM)? (SQL_CALC_FOUND_ROWS)?
	;
	
lock_type:
	( FOR_SYM UPDATE) | (LOCK IN_SYM SHARE_SYM MODE_SYM)
	;

where_clause:
	WHERE! expression
;

groupby_clause:
	GROUP_SYM BY_SYM groupby_item (COMMA groupby_item)* (WITH ROLLUP_SYM)? -> ^(TN_GROUPBY groupby_item groupby_item* )
;
groupby_item:	column_spec | INTEGER_NUM | bit_expr ;

having_clause:
	HAVING! expression
;

orderby_clause:
	ORDER_SYM BY_SYM orderby_item (COMMA orderby_item)* -> ^(TN_ORDERBY orderby_item orderby_item*)
;
orderby_item:	groupby_item (ASC | DESC)? ;

limit_clause:
	LIMIT! ((offset COMMA)? row_count) | (row_count OFFSET_SYM offset)
;
offset:		INTEGER_NUM ;
row_count:	INTEGER_NUM ;

select_list:
	displayed_column (COMMA displayed_column)* -> ^(TN_COL displayed_column)+
;

column_list:
	LPAREN column_spec (COMMA column_spec)* RPAREN
;

subquery:
	LPAREN select_statement RPAREN -> ^(TN_SUBQUERY select_statement)
;

table_spec:
	( schema_name DOT )? table_name -> ^(TN_TABLE_SPEC (schema_name DOT)? table_name)
;

displayed_column:
	table_name DOT column_name (alias)? -> ^(TN_COL_EXP table_name DOT column_name (alias)?)
	| column_name (alias)? -> ^(TN_COL_EXP column_name (alias)?)
	| column_spec (column_op column_spec)+ (alias)? -> ^(TN_COL_EXP column_spec (column_op column_spec)+ (alias)?)
	| ASTERISK -> ^(TN_COL_ALLC ASTERISK)
	| table_name ALL_FIELDS -> ^(TN_COL_ALLTC table_name ALL_FIELDS)
	| bit_expr (alias)? -> ^(TN_COL_BITEXP bit_expr (alias)?)
	| column_spec column_op simple_expr (alias)?
	;

column_op:
	PLUS|MINUS|ASTERISK|DIVIDE
	;
	
// delete -----------------------------------------------------------------------------
delete_statements:
	DELETE_SYM delete_expression -> ^(TN_DELETE delete_expression)
;
delete_expression:
	(LOW_PRIORITY)? (QUICK)? (IGNORE_SYM)?
	( delete_single_table_statement -> ^(delete_single_table_statement) | delete_multiple_table_statement1 -> ^(delete_multiple_table_statement1) | delete_multiple_table_statement2 -> ^(delete_multiple_table_statement2) )
	;
	
delete_single_table_statement:
	FROM table_spec
	(partition_clause)?
	(where_clause)?
	(orderby_clause)?
	(limit_clause)?
	-> ^(table_spec)
;
delete_multiple_table_statement1:
	table_spec (ALL_FIELDS!)? (COMMA^ table_spec (ALL_FIELDS!)?)*
	FROM! table_references
	(where_clause!)?
;
delete_multiple_table_statement2:
	FROM! table_spec (ALL_FIELDS!)? (COMMA^ table_spec (ALL_FIELDS!)?)*
	USING_SYM! table_references
	(where_clause!)?
;