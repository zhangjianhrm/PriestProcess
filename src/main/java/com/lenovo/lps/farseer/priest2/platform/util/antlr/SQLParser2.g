parser grammar SQLParser2;

@rulecatch {
catch (RecognitionException e){
	throw e;
}
}

// create table --------------------------------------------------------------
create_table_statement:
	create_table_statement1 | create_table_statement2 | create_table_statement3
;

create_table_statement1:	
	CREATE create_table_expression1 -> ^(TN_CREATE create_table_expression1)
;

create_table_expression1:
	(TEMPORARY)? TABLE (IF NOT_SYM EXISTS)? table_name
	LPAREN create_definition (COMMA create_definition)* RPAREN
	(table_options)?
	(partition_options)?
	(select_statement)?
	;

create_table_statement2:
	CREATE create_table_expression2 -> ^(TN_CREATE create_table_expression2)
;

create_table_expression2:
	(TEMPORARY)? TABLE (IF NOT_SYM EXISTS)? table_name
	(table_options)?
	(partition_options)?
	select_statement
	;

create_table_statement3:
	CREATE create_table_expression3 -> ^(TN_CREATE create_table_expression3)
;

create_table_expression3:
	(TEMPORARY)? TABLE (IF NOT_SYM EXISTS)? table_name
	( (LIKE_SYM table_name) | (LPAREN LIKE_SYM table_name RPAREN) )
	;

create_definition:
	  (  column_name column_definition  )
	| (  (CONSTRAINT (constraint_symbol_name)?)? PRIMARY_SYM KEY_SYM (index_type)? LPAREN index_column_name (COMMA index_column_name)* RPAREN (index_option)*  )
	| (  (INDEX_SYM|KEY_SYM) (index_name)? (index_type)? LPAREN index_column_name (COMMA index_column_name)* RPAREN (index_option)*  )
	| (  (CONSTRAINT (constraint_symbol_name)?)? UNIQUE_SYM (INDEX_SYM|KEY_SYM)? (index_name)? (index_type)? LPAREN index_column_name (COMMA index_column_name)* RPAREN (index_option)*  )
	| (  (FULLTEXT_SYM|SPATIAL_SYM) (INDEX_SYM|KEY_SYM)? (index_name)? LPAREN index_column_name (COMMA index_column_name)* RPAREN (index_option)*  )
	| (  (CONSTRAINT (constraint_symbol_name)?)? FOREIGN KEY_SYM (index_name)? LPAREN index_column_name (COMMA index_column_name)* RPAREN reference_definition  )
	| (  CHECK_SYM LPAREN expression RPAREN  )
;

column_definition:
	column_data_type_header
	(AUTO_INCREMENT)? ( (UNIQUE_SYM (KEY_SYM)?) | (PRIMARY_SYM (KEY_SYM)?) )?
	(COMMENT_SYM TEXT_STRING)?
	(COLUMN_FORMAT (FIXED_SYM|DYNAMIC_SYM|DEFAULT))?
	(reference_definition)?
;

null_or_notnull:
	(NOT_SYM NULL_SYM) | NULL_SYM
;

column_data_type_header:
	  (  BIT_SYM(LPAREN length RPAREN)? (null_or_notnull)? (DEFAULT bit_literal)?  )
	| (  TINYINT(LPAREN length RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT number_literal)?  )
	| (  SMALLINT(LPAREN length RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT number_literal)?  )
	| (  MEDIUMINT(LPAREN length RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT number_literal)?  )
	| (  INT_SYM(LPAREN length RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT (number_literal|TEXT_STRING))?  )
	| (  INTEGER_SYM(LPAREN length RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT number_literal)?  )
	| (  BIGINT(LPAREN length RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT number_literal)?  )
	| (  REAL(LPAREN length COMMA number_literal RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT number_literal)?  )
	| (  DOUBLE_SYM(LPAREN length COMMA number_literal RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT number_literal)?  )
	| (  FLOAT_SYM(LPAREN length COMMA number_literal RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT number_literal)?  )
	| (  DECIMAL_SYM(LPAREN length( COMMA number_literal)? RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT number_literal)?  )
	| (  NUMERIC_SYM(LPAREN length( COMMA number_literal)? RPAREN)? (UNSIGNED_SYM)? (ZEROFILL)? (null_or_notnull)? (DEFAULT number_literal)?  )
	| (  DATE_SYM (null_or_notnull)? (DEFAULT (TEXT_STRING|NULL_SYM))?  )
	| (  TIME_SYM (null_or_notnull)? (DEFAULT (TEXT_STRING|NULL_SYM))?  )
	| (  TIMESTAMP (null_or_notnull)? (DEFAULT (CURRENT_TIMESTAMP|TEXT_STRING|NULL_SYM))?  )
	| (  DATETIME (null_or_notnull)? (DEFAULT (CURRENT_TIMESTAMP|TEXT_STRING|NULL_SYM))?  )
	| (  Y_ E_ A_ R_ (null_or_notnull)? (DEFAULT INTEGER_NUM)?  )
	| (  CHAR   (LPAREN length RPAREN)? (CHARACTER_SYM SET_SYM charset_name)? (COLLATE_SYM collation_name)? (null_or_notnull)? (DEFAULT (TEXT_STRING|NULL_SYM))?  )
	| (  VARCHAR LPAREN length RPAREN   (CHARACTER_SYM SET_SYM charset_name)? (COLLATE_SYM collation_name)? (null_or_notnull)? (DEFAULT (TEXT_STRING|NULL_SYM))?  )
	| (  BINARY   (LPAREN length RPAREN)? (null_or_notnull)? (DEFAULT (TEXT_STRING|NULL_SYM))?  )
	| (  VARBINARY LPAREN length RPAREN (null_or_notnull)? (DEFAULT (TEXT_STRING|NULL_SYM))?  )
	| (  TINYBLOB (null_or_notnull)?  )
	| (  BLOB_SYM (null_or_notnull)?  )
	| (  MEDIUMBLOB (null_or_notnull)?  )
	| (  LONGBLOB (null_or_notnull)?  )
	| (  TINYTEXT   (BINARY)? (CHARACTER_SYM SET_SYM charset_name)? (COLLATE_SYM collation_name)? (null_or_notnull)?  )
	| (  TEXT_SYM   (BINARY)? (CHARACTER_SYM SET_SYM charset_name)? (COLLATE_SYM collation_name)? (null_or_notnull)?  )
	| (  MEDIUMTEXT (BINARY)? (CHARACTER_SYM SET_SYM charset_name)? (COLLATE_SYM collation_name)? (null_or_notnull)?  )
	| (  LONGTEXT   (BINARY)? (CHARACTER_SYM SET_SYM charset_name)? (COLLATE_SYM collation_name)? (null_or_notnull)?  )
	| (  ENUM    LPAREN TEXT_STRING (COMMA TEXT_STRING)* RPAREN (CHARACTER_SYM SET_SYM charset_name)? (COLLATE_SYM collation_name)? (null_or_notnull)? (DEFAULT (TEXT_STRING|NULL_SYM))?  )
	| (  SET_SYM LPAREN TEXT_STRING (COMMA TEXT_STRING)* RPAREN (CHARACTER_SYM SET_SYM charset_name)? (COLLATE_SYM collation_name)? (null_or_notnull)? (DEFAULT (TEXT_STRING|NULL_SYM))?  )
;

index_column_name:
	column_name (LPAREN INTEGER_NUM RPAREN)? (ASC | DESC)?
;

reference_definition:
	REFERENCES table_name LPAREN index_column_name (COMMA index_column_name)* RPAREN
	( (MATCH FULL) | (MATCH PARTIAL) | (MATCH SIMPLE_SYM) )?
	(ON DELETE_SYM reference_option)?
	(ON UPDATE reference_option)?
;
reference_option:
	(RESTRICT) | (CASCADE) | (SET_SYM NULL_SYM) | (NO_SYM ACTION)
;

table_options:
	table_option (( COMMA )? table_option)*
;

table_option:
	  (  ENGINE_SYM (EQ_SYM)? engine_name  )
	| (  AUTO_INCREMENT (EQ_SYM)? INTEGER_NUM  )
	| (  AVG_ROW_LENGTH (EQ_SYM)? INTEGER_NUM  )
	| (  (DEFAULT)? (CHARACTER_SYM SET_SYM | CHARSET) (EQ_SYM)? charset_name  )
	| (  CHECKSUM_SYM (EQ_SYM)? INTEGER_NUM  )
	| (  (DEFAULT)? COLLATE_SYM (EQ_SYM)? collation_name  )
	| (  COMMENT_SYM (EQ_SYM)? TEXT_STRING  )
	| (  CONNECTION_SYM (EQ_SYM)? TEXT_STRING  )
	| (  DATA_SYM DIRECTORY_SYM (EQ_SYM)? TEXT_STRING  )
	| (  DELAY_KEY_WRITE_SYM (EQ_SYM)? INTEGER_NUM  )
	| (  INDEX_SYM DIRECTORY_SYM (EQ_SYM)? TEXT_STRING  )
	| (  INSERT_METHOD (EQ_SYM)? ( NO_SYM | FIRST_SYM | LAST_SYM )  )
	| (  KEY_BLOCK_SIZE (EQ_SYM)? INTEGER_NUM  )
	| (  MAX_ROWS (EQ_SYM)? INTEGER_NUM  )
	| (  MIN_ROWS (EQ_SYM)? INTEGER_NUM  )
	| (  PACK_KEYS_SYM (EQ_SYM)? (INTEGER_NUM | DEFAULT)  )
	| (  PASSWORD (EQ_SYM)? TEXT_STRING  )
	| (  ROW_FORMAT_SYM (EQ_SYM)? (DEFAULT|DYNAMIC_SYM|FIXED_SYM|COMPRESSED_SYM|REDUNDANT_SYM|COMPACT_SYM)  )
	| (  STATS_AUTO_RECALC (EQ_SYM)? (DEFAULT | INTEGER_NUM)  )
	| (  STATS_PERSISTENT (EQ_SYM)? (DEFAULT | INTEGER_NUM)  )
	| (  UNION_SYM (EQ_SYM)? LPAREN table_name( COMMA table_name)* RPAREN  )
;

partition_options:
	PARTITION_SYM BY_SYM
	( 
		  ( (LINEAR_SYM)? HASH_SYM LPAREN expression RPAREN )
		| ( (LINEAR_SYM)? KEY_SYM LPAREN column_list RPAREN )
		| ( RANGE_SYM(LPAREN expression RPAREN | COLUMNS_SYM LPAREN column_list RPAREN) )
		| ( LIST_SYM(LPAREN expression RPAREN | COLUMNS_SYM LPAREN column_list RPAREN) )
	)
	(PARTITIONS_SYM INTEGER_NUM)?
	(
		SUBPARTITION_SYM BY_SYM
		( ( (LINEAR_SYM)? HASH_SYM LPAREN expression RPAREN ) | ( (LINEAR_SYM)? KEY_SYM LPAREN column_list RPAREN ) )
		(SUBPARTITIONS_SYM INTEGER_NUM)?
	)?
	(LPAREN partition_definition ( COMMA  partition_definition)* RPAREN)?
;

partition_definition:
	PARTITION_SYM partition_name
	(
		VALUES 
		(
			(LESS_SYM THAN_SYM ( expression_list | MAXVALUE_SYM ))
			| 
			(IN_SYM expression_list)
		)
	)?
	((STORAGE_SYM)? ENGINE_SYM (EQ_SYM)? engine_name)?
	(COMMENT_SYM (EQ_SYM)? TEXT_STRING )?
	(DATA_SYM DIRECTORY_SYM (EQ_SYM)? TEXT_STRING)?
	(INDEX_SYM DIRECTORY_SYM (EQ_SYM)? TEXT_STRING)?
	(MAX_ROWS (EQ_SYM)? INTEGER_NUM)?
	(MIN_ROWS (EQ_SYM)? INTEGER_NUM)?
	(LPAREN subpartition_definition (COMMA  subpartition_definition)* RPAREN)?
;

subpartition_definition:
	SUBPARTITION_SYM partition_logical_name
	((STORAGE_SYM)? ENGINE_SYM (EQ_SYM)? engine_name)?
	(COMMENT_SYM (EQ_SYM)? TEXT_STRING )?
	(DATA_SYM DIRECTORY_SYM (EQ_SYM)? TEXT_STRING)?
	(INDEX_SYM DIRECTORY_SYM (EQ_SYM)? TEXT_STRING)?
	(MAX_ROWS (EQ_SYM)? INTEGER_NUM)?
	(MIN_ROWS (EQ_SYM)? INTEGER_NUM)?
;

length	:	INTEGER_NUM;

// alter table ---------------------------------------------------------------------------------
alter_table_statement:
	ALTER alter_table_expression -> ^(TN_ALTER alter_table_expression)
;
alter_table_expression:
	(IGNORE_SYM)? TABLE table_name
	( alter_table_specification (COMMA alter_table_specification)* )?
	( partition_options )?
	;
alter_table_specification:
	  table_options
	| ( ADD_SYM (COLUMN_SYM)? column_name column_definition ( (FIRST_SYM|AFTER_SYM) column_name )? )
	| ( ADD_SYM (COLUMN_SYM)? LPAREN column_definitions RPAREN )
	| ( ADD_SYM (INDEX_SYM|KEY_SYM) (index_name)? (index_type)? LPAREN index_column_names RPAREN (index_option)* )
	| ( ADD_SYM (CONSTRAINT (constraint_symbol_name)?)? PRIMARY_SYM KEY_SYM (index_type)? LPAREN index_column_names RPAREN (index_option)* )
	| 
		( 
		ADD_SYM (CONSTRAINT (constraint_symbol_name)?)? UNIQUE_SYM (INDEX_SYM|KEY_SYM)? (index_name)? 
		(index_type)? LPAREN index_column_name (COMMA index_column_name)* RPAREN (index_option)*
		)
	| ( ADD_SYM FULLTEXT_SYM (INDEX_SYM|KEY_SYM)? (index_name)? LPAREN index_column_names RPAREN (index_option)* )
	| ( ADD_SYM SPATIAL_SYM (INDEX_SYM|KEY_SYM)? (index_name)? LPAREN index_column_names RPAREN (index_option)* )
	| ( ADD_SYM (CONSTRAINT (constraint_symbol_name)?)? FOREIGN KEY_SYM (index_name)? LPAREN index_column_names RPAREN reference_definition )
	| ( ALGORITHM_SYM (EQ_SYM)? (DEFAULT|INPLACE_SYM|COPY_SYM) )
	| ( ALTER (COLUMN_SYM)? column_name ((SET_SYM DEFAULT literal_value) | (DROP DEFAULT)) )
	| ( CHANGE (COLUMN_SYM)? column_name column_name column_definition (FIRST_SYM|AFTER_SYM column_name)? )
	| ( LOCK (EQ_SYM)? (DEFAULT|NONE_SYM|SHARED_SYM|EXCLUSIVE_SYM) )
	| ( MODIFY_SYM (COLUMN_SYM)? column_name column_definition (FIRST_SYM | AFTER_SYM column_name)? )
	| ( DROP (COLUMN_SYM)? column_name )
	| ( DROP PRIMARY_SYM KEY_SYM )
	| ( DROP (INDEX_SYM|KEY_SYM) index_name )
	| ( DROP FOREIGN KEY_SYM foreign_key_symbol_name )
	| ( DISABLE_SYM KEYS )
	| ( ENABLE_SYM KEYS )
	| ( RENAME (TO_SYM|AS_SYM)? table_name )
	| ( ORDER_SYM BY_SYM column_name (COMMA column_name)* )
	| ( CONVERT_SYM TO_SYM CHARACTER_SYM SET_SYM charset_name (COLLATE_SYM collation_name)? )
	| ( (DEFAULT)? CHARACTER_SYM SET_SYM (EQ_SYM)? charset_name (COLLATE_SYM (EQ_SYM)? collation_name)? )
	| ( DISCARD TABLESPACE )
	| ( IMPORT TABLESPACE )
	| ( FORCE_SYM )
	| ( ADD_SYM PARTITION_SYM LPAREN partition_definition RPAREN )
	| ( DROP PARTITION_SYM partition_names )
	| ( TRUNCATE PARTITION_SYM (partition_names | ALL) )
	| ( COALESCE PARTITION_SYM INTEGER_NUM )
	| ( REORGANIZE_SYM PARTITION_SYM partition_names INTO LPAREN partition_definition (COMMA partition_definition)* RPAREN )
	| ( EXCHANGE_SYM PARTITION_SYM partition_name WITH TABLE table_name )
	| ( ANALYZE_SYM PARTITION_SYM (partition_names | ALL) )
	| ( CHECK_SYM PARTITION_SYM (partition_names | ALL) )
	| ( OPTIMIZE PARTITION_SYM (partition_names | ALL) )
	| ( REBUILD_SYM PARTITION_SYM (partition_names | ALL) )
	| ( REPAIR PARTITION_SYM (partition_names | ALL) )
	| ( REMOVE_SYM PARTITIONING_SYM )
;

index_column_names:
	index_column_name (COMMA index_column_name)*;
index_type:
	USING_SYM (BTREE_SYM | HASH_SYM)
;
index_option:
	  ( KEY_BLOCK_SIZE (EQ_SYM)? INTEGER_NUM )
	| index_type
	| ( WITH PARSER_SYM parser_name )
	| ( COMMENT_SYM TEXT_STRING )
;
column_definitions:
	column_name column_definition (COMMA column_name column_definition)*
;

// rename table ----------------------------------------------------------
rename_table_statement:
	RENAME TABLE 
	table_name TO_SYM table_name
	(COMMA table_name TO_SYM table_name)*
;


// drop table ----------------------------------------------------------------
drop_table_statement:
	DROP drop_table_expression -> ^(TN_DROP drop_table_expression)
;

drop_table_expression:
	(TEMPORARY)? TABLE (IF EXISTS)?
	table_name (COMMA table_name)*
	(RESTRICT | CASCADE)?
	;

// truncate table ----------------------------------------------------------------
truncate_table_statement:
	TRUNCATE (TABLE)? table_name -> ^(TN_TRUNCATE table_name)
;

// create view -------------------------------------------------------------------
create_view_statement:
	CREATE create_view_expression -> ^(TN_CREATE create_view_expression)
;
create_view_expression:
	(OR_SYM REPLACE)?
	create_view_body
;
create_view_body:
	(ALGORITHM_SYM EQ_SYM (UNDEFINED_SYM | MERGE_SYM | TEMPTABLE_SYM))?
	(DEFINER EQ_SYM (user_name | CURRENT_USER) )?
	(SQL_SYM SECURITY_SYM ( DEFINER | INVOKER_SYM ))?
	VIEW_SYM view_name (LPAREN column_list RPAREN)?
	AS_SYM select_statement
	(WITH (CASCADED | LOCAL_SYM)? CHECK_SYM OPTION)?
;


// alter view -----------------------------------------------------------------------
alter_view_statement:
	ALTER create_view_body -> ^(TN_ALTER create_view_body)
;


// drop view -----------------------------------------------------------------------------
drop_view_statement:
	DROP drop_view_expression -> ^(TN_DROP drop_view_expression)
;
drop_view_expression:
	VIEW_SYM (IF EXISTS)?
	view_name (COMMA view_name)*
	(RESTRICT | CASCADE)?
;