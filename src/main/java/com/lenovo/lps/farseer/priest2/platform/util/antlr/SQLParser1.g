parser grammar SQLParser1;

@rulecatch {
catch (RecognitionException e){
	throw e;
}
}

// insert -----------------------------------------------------------------------------
insert_statements :
	insert_statement1 | insert_statement2 | insert_statement3
;

insert_header:
	INSERT insert_expression-> ^(TN_INSERT insert_expression)
;

insert_expression:
	(LOW_PRIORITY | HIGH_PRIORITY)? (IGNORE_SYM)?
	(INTO)? table_spec 
	(partition_clause)?
	;

insert_subfix:
	ON DUPLICATE_SYM KEY_SYM UPDATE column_spec EQ_SYM expression (COMMA column_spec EQ_SYM expression)*
;

insert_statement1:
	insert_header
	(column_list)? 
	value_list_clause
	( insert_subfix )?
	-> ^(insert_header)
;
value_list_clause:	(VALUES | VALUE_SYM) column_value_list (COMMA column_value_list)*;
column_value_list:	LPAREN (bit_expr|DEFAULT) (COMMA (bit_expr|DEFAULT) )* RPAREN ;

insert_statement2:
	insert_header
	set_columns_cluase
	( insert_subfix )?
	-> ^(insert_header)
;
set_columns_cluase:	SET_SYM set_column_cluase ( COMMA set_column_cluase )*;
set_column_cluase:	column_spec EQ_SYM (expression|DEFAULT) ;

insert_statement3:
	insert_header
	(column_list)? 
	select_expression
	( insert_subfix )?
	-> ^(insert_header select_expression)
;

// update ----------------------------------------------------------------------------
update_statements :
	single_table_update_statement | multiple_table_update_statement
;

single_table_update_statement: 
	UPDATE single_update_expression
	-> ^(TN_UPDATE single_update_expression)
;

single_update_expression:
	(LOW_PRIORITY)? (IGNORE_SYM)? table_reference
	set_columns_cluase
	(where_clause)?
	(orderby_clause)?
	(limit_clause)?
	;

multiple_table_update_statement: 
	UPDATE multiple_update_expression
	-> ^(TN_UPDATE multiple_update_expression)
;

multiple_update_expression:
	(LOW_PRIORITY)? (IGNORE_SYM)? table_references
	set_columns_cluase
	(where_clause)?
	;

// call ---------------------------------------------------------------------------------
call_statement:
	CALL_SYM procedure_name (LPAREN ( bit_expr (COMMA bit_expr)* )? RPAREN)?
;

// do ------------------------------------------------------------------------------------
do_statement:
	DO_SYM root_statement (COMMA root_statement)*
;

// handler -------------------------------------------------------------------------------
handler_statements:
	HANDLER_SYM table_name
	(open_handler_statement | handler_statement1 | handler_statement2 | handler_statement3 | close_handler_statement)
;

open_handler_statement:
	OPEN_SYM (alias)?
;

handler_statement1:
	READ_SYM index_name relational_op LPAREN bit_expr (COMMA bit_expr)* RPAREN
	(where_clause)? (limit_clause)?
;

handler_statement2:
	READ_SYM index_name (FIRST_SYM | NEXT_SYM | PREV_SYM | LAST_SYM)
	(where_clause)? (limit_clause)?
;

handler_statement3:
	READ_SYM (FIRST_SYM | NEXT_SYM)
	(where_clause)? (limit_clause)?
;

close_handler_statement:
	CLOSE_SYM
;

// load data ------------------------------------------------------------------------------------
load_data_statement:
	LOAD DATA_SYM (LOW_PRIORITY | CONCURRENT)? (LOCAL_SYM)? INFILE TEXT_STRING
	(REPLACE | IGNORE_SYM)?
	INTO TABLE table_spec
	(partition_clause)?
	(CHARACTER_SYM SET_SYM charset_name)?
	(
		(FIELDS_SYM | COLUMNS_SYM)
		(TERMINATED BY_SYM TEXT_STRING)?
		((OPTIONALLY)? ENCLOSED BY_SYM TEXT_STRING)?
		(ESCAPED BY_SYM TEXT_STRING)?
	)?
	(
		LINES
		(STARTING BY_SYM TEXT_STRING)?
		(TERMINATED BY_SYM TEXT_STRING)?
	)?
	(IGNORE_SYM INTEGER_NUM (LINES | ROWS_SYM))?
	(LPAREN (column_spec|USER_VAR) (COMMA (column_spec|USER_VAR))* RPAREN)?
	(set_columns_cluase)?
	-> ^(LOAD table_spec)
;

// load xml ---------------------------------------------------------------------------------------
load_xml_statement:
	LOAD XML_SYM (LOW_PRIORITY | CONCURRENT)? (LOCAL_SYM)? INFILE TEXT_STRING
	(REPLACE | IGNORE_SYM)?
	INTO TABLE table_spec
	(partition_clause)?
	(CHARACTER_SYM SET_SYM charset_name)?
	(ROWS_SYM IDENTIFIED_SYM BY_SYM TEXT_STRING)?
	(IGNORE_SYM INTEGER_NUM (LINES | ROWS_SYM))?
	(LPAREN (column_spec|USER_VAR) (COMMA (column_spec|USER_VAR))* RPAREN)?
	(set_columns_cluase)?
;

// replace -----------------------------------------------------------------------------------
replace_statement:
	replace_statement_header
	( replace_statement1 | replace_statement2 | replace_statement3 )
;

replace_statement_header:
	REPLACE replace_statement_expression -> ^(TN_REPLACE replace_statement_expression)
;

replace_statement_expression:
	(LOW_PRIORITY | DELAYED_SYM)?
	(INTO)? table_name
	(partition_clause)?
	;

replace_statement1:
	(column_list)?
	value_list_clause
;

replace_statement2:
	set_columns_cluase
;

replace_statement3:
	(column_list)?
	select_statement
;

// create database --------------------------------------------------------------------
create_database_statement:
	CREATE create_database_expression -> ^(TN_CREATE create_database_expression)
;
create_database_expression:
	(DATABASE | SCHEMA) (IF NOT_SYM EXISTS)? schema_name
	( create_specification (COMMA create_specification)* )*
;
create_specification:
	(DEFAULT)? 
	(
		(  CHARACTER_SYM SET_SYM (EQ_SYM)? charset_name  )
		|
		(  COLLATE_SYM (EQ_SYM)? collation_name  )
	)
;

// alter database -------------------------------------------------------------------------
alter_database_statements:
	ALTER alter_database_expression -> ^(TN_ALTER alter_database_expression)
;
alter_database_expression:
	alter_database_statement1 | alter_database_statement2
;
alter_database_statement1:
	(DATABASE | SCHEMA) (schema_name)?
	alter_database_specification
;
alter_database_statement2:
	(DATABASE | SCHEMA) schema_name
	UPGRADE_SYM DATA_SYM DIRECTORY_SYM N_ A_ M_ E_
;
alter_database_specification:
	(DEFAULT)? CHARACTER_SYM SET_SYM (EQ_SYM)? charset_name
	| 
	(DEFAULT)? COLLATE_SYM (EQ_SYM)? collation_names

;

// drop database --------------------------------------------------------------------------
drop_database_statement:
	DROP drop_database_expression -> ^(TN_DROP drop_database_expression)
;
drop_database_expression:
	(DATABASE | SCHEMA) (IF EXISTS)? schema_name
;

// create event ---------------------------------------------------------------------
create_event_statement:
	CREATE create_event_expression -> ^(TN_CREATE create_event_expression)
	
;
create_event_expression:
	(DEFINER EQ_SYM ( user_name | CURRENT_USER ))?
	EVENT_SYM
	(IF NOT_SYM EXISTS)?
	event_name
	ON SCHEDULE_SYM schedule_definition
	(ON COMPLETION_SYM (NOT_SYM)? PRESERVE_SYM)?
	( ENABLE_SYM | DISABLE_SYM | (DISABLE_SYM ON SLAVE) )?
	(COMMENT_SYM TEXT_STRING)?
	do_statement
;
schedule_definition:
	( AT_SYM timestamp (PLUS INTERVAL_SYM interval)* )
	| 
	( EVERY_SYM interval )
	( S_ T_ A_ R_ T_ S_ timestamp (PLUS INTERVAL_SYM interval)* )?
	( ENDS_SYM timestamp (PLUS INTERVAL_SYM interval)* )?
;
interval:
	INTEGER_NUM (Y_ E_ A_ R_ | QUARTER | MONTH | DAY_SYM | HOUR | MINUTE |
	          WEEK | SECOND | YEAR_MONTH | DAY_HOUR | DAY_MINUTE |
	          DAY_SECOND | HOUR_MINUTE | HOUR_SECOND | MINUTE_SECOND)

;
timestamp:
	CURRENT_TIMESTAMP 
;

// alter event ---------------------------------------------------------
alter_event_statement:
	ALTER alter_event_expression -> ^(TN_ALTER alter_event_expression)
	
;
alter_event_expression:
	(DEFINER EQ_SYM ( user_name | CURRENT_USER ))?
	EVENT_SYM event_name
	(ON SCHEDULE_SYM schedule_definition)?
	(ON COMPLETION_SYM (NOT_SYM)? PRESERVE_SYM)?
	(RENAME TO_SYM event_name)?
	( ENABLE_SYM | DISABLE_SYM | (DISABLE_SYM ON SLAVE) )?
	(COMMENT_SYM TEXT_STRING)?
	(do_statement)?
;

// drop event -------------------------------------------------------------------
drop_event_statement:
	DROP drop_event_expression -> ^(TN_DROP drop_event_expression)
;
drop_event_expression:
	EVENT_SYM (IF EXISTS)? event_name
;

// create index --------------------------------------------------------------
create_index_statement:
	CREATE create_index_expression -> ^(TN_CREATE create_index_expression)
;
create_index_expression:
	(UNIQUE_SYM|FULLTEXT_SYM|SPATIAL_SYM)? INDEX_SYM index_name
	(index_type)?
	ON table_name LPAREN index_column_name (COMMA index_column_name)* RPAREN
	(algorithm_option | lock_option)*
;
algorithm_option:
	ALGORITHM_SYM (EQ_SYM)? (DEFAULT|INPLACE_SYM|COPY_SYM)
;
lock_option:
	LOCK (EQ_SYM)? (DEFAULT|NONE_SYM|SHARED_SYM|EXCLUSIVE_SYM)
;


// drop index -----------------------------------------------------------
drop_index_statement:
	DROP drop_index_expression -> ^(TN_DROP drop_index_expression)
;
drop_index_expression:
	INDEX_SYM index_name ON table_name
	(algorithm_option | lock_option)*
;

// create server ------------------------------------------------------
create_server_statement:
	CREATE create_server_expression -> ^(TN_CREATE create_server_expression)
;
create_server_expression:
	SERVER_SYM server_name
	FOREIGN DATA_SYM WRAPPER_SYM wrapper_name
	OPTIONS_SYM LPAREN create_server_option (COMMA create_server_option)* RPAREN
;
create_server_option:
	| ( HOST_SYM string_literal )
	| ( DATABASE string_literal )
	| ( USER string_literal )
	| ( PASSWORD string_literal )
	| ( SOCKET_SYM string_literal )
	| ( OWNER_SYM string_literal )
	| ( PORT_SYM number_literal )
;


// alter server ----------------------------------------------------------
alter_server_statement:
	ALTER alter_server_expression -> ^(TN_ALTER alter_server_expression)
;
alter_server_expression:
	SERVER_SYM server_name
	OPTIONS_SYM LPAREN alter_server_option (COMMA alter_server_option)* RPAREN
;
alter_server_option:
	(USER) (ID|TEXT_STRING)
;


// drop server -------------------------------------------------------------
drop_server_statement:
	DROP drop_server_expression -> ^(TN_DROP drop_server_expression)
;
drop_server_expression:
	SERVER_SYM (IF EXISTS)? server_name
;