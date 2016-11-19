// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 MySQL.g 2013-11-29 14:34:07
package com.lenovo.lps.farseer.priest2.platform.util.antlr;

import java.util.HashMap;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEarlyExitException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

@SuppressWarnings("unused")
public class MySQLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "A_", "B_", "C_", "D_", "E_", "F_", "G_", "H_", "I_", "J_", "K_", "L_", "M_", "N_", "O_", "P_", "Q_", "R_", "S_", "T_", "U_", "V_", "W_", "X_", "Y_", "Z_", "ABS", "ACOS", "ACTION", "ADD_SYM", "ADDDATE", "ADDTIME", "AES_DECRYPT", "AES_ENCRYPT", "AFTER_SYM", "AGAINST", "ALGORITHM_SYM", "ALL", "ALTER", "ANALYZE_SYM", "ANY", "ARMSCII8", "AS_SYM", "ASC", "ASCII_SYM", "ASIN", "AT_SYM", "ATAN", "ATAN2", "AUTO_INCREMENT", "AVG", "AVG_ROW_LENGTH", "BENCHMARK", "BETWEEN", "BIG5", "BIGINT", "BIN", "BINARY", "BIT_AND", "BIT_LENGTH", "BIT_OR", "BIT_SYM", "BIT_XOR", "BLOB_SYM", "BOOLEAN_SYM", "BTREE_SYM", "BY_SYM", "CACHE_SYM", "CALL_SYM", "CASCADE", "CASCADED", "CASE_SYM", "CAST_SYM", "CEIL", "CEILING", "CHANGE", "CHAR", "CHAR_LENGTH", "CHARACTER_SYM", "CHARSET", "CHECK_SYM", "CHECKSUM_SYM", "CIPHER_SYM", "CLOSE_SYM", "COALESCE", "CODE_SYM", "COERCIBILITY", "COLLATE_SYM", "COLLATION", "COLUMN_FORMAT", "COLUMN_SYM", "COLUMNS_SYM", "COMMENT_SYM", "COMMITTED_SYM", "COMPACT_SYM", "COMPLETION_SYM", "COMPRESS", "COMPRESSED_SYM", "CONCAT", "CONCAT_WS", "CONCURRENT", "CONNECTION_ID", "CONNECTION_SYM", "CONSTRAINT", "CONV", "CONVERT_SYM", "CONVERT_TZ", "COPY_SYM", "COS", "COT", "COUNT", "CP1250", "CP1251", "CP1256", "CP1257", "CP850", "CP852", "CP866", "CP932", "CRC32", "CREATE", "CROSECOND", "CROSS", "CURDATE", "CURRENT_TIMESTAMP", "CURRENT_USER", "CURTIME", "DATABASE", "DATA_SYM", "DATE_ADD", "DATE_FORMAT", "DATE_SUB", "DATE_SYM", "DATEDIFF", "DATETIME", "DAY_SYM", "DAY_HOUR", "DAY_MICROSECOND", "DAY_MINUTE", "DAY_SECOND", "DAYNAME", "DAYOFMONTH", "DAYOFWEEK", "DAYOFYEAR", "DEC8", "DECIMAL_SYM", "DECODE", "DEFAULT", "DEFINER", "DEGREES", "DELAY_KEY_WRITE_SYM", "DELAYED_SYM", "DELETE_SYM", "DES_DECRYPT", "DES_ENCRYPT", "DESC", "DIRECTORY_SYM", "DISABLE_SYM", "DISCARD", "DISTINCT", "DISTINCTROW", "DO_SYM", "DOUBLE_SYM", "DROP", "DUPLICATE_SYM", "DYNAMIC_SYM", "ELSE_SYM", "ELT", "ENABLE_SYM", "ENCLOSED", "ENCODE", "ENCRYPT", "END_SYM", "ENDS_SYM", "ENGINE_SYM", "ENUM", "ESCAPE_SYM", "ESCAPED", "EUCJPMS", "EUCKR", "EVENT_SYM", "EVERY_SYM", "EXCHANGE_SYM", "EXCLUSIVE_SYM", "EXISTS", "EXP", "EXPANSION_SYM", "EXPORT_SET", "EXTRACT", "FALSE_SYM", "FIELDS_SYM", "FIELD", "FILE_SYM", "FIND_IN_SET", "FIRST_SYM", "FIXED_SYM", "FLOAT_SYM", "FLOOR", "FOR_SYM", "FORCE_SYM", "FOREIGN", "FORMAT", "FOUND_ROWS", "FROM", "FROM_BASE64", "FROM_DAYS", "FROM_UNIXTIME", "FULL", "FULLTEXT_SYM", "GB2312", "GBK", "GEOSTD8", "GET_FORMAT", "GET_LOCK", "GREEK", "GROUP_CONCAT", "GROUP_SYM", "HANDLER_SYM", "HASH_SYM", "HAVING", "HEBREW", "HEX", "HIGH_PRIORITY", "HOST_SYM", "HOUR", "HOUR_MICROSECOND", "HOUR_MINUTE", "HOUR_SECOND", "HP8", "IDENTIFIED_SYM", "IF", "IFNULL", "IGNORE_SYM", "IMPORT", "IN_SYM", "INDEX_SYM", "INET_ATON", "INET_NTOA", "INFILE", "INNER_SYM", "INPLACE_SYM", "INSERT", "INSERT_METHOD", "INSTR", "INT_SYM", "INTEGER_SYM", "INTERVAL_SYM", "INTO", "INVOKER_SYM", "IS_FREE_LOCK", "IS_SYM", "IS_USED_LOCK", "JOIN_SYM", "KEY_BLOCK_SIZE", "KEY_SYM", "KEYBCS2", "KEYS", "KOI8R", "KOI8U", "LANGUAGE", "LAST_DAY", "LAST_INSERT_ID", "LAST_SYM", "LATIN1_BIN", "LATIN1_GENERAL_CS", "LATIN1", "LATIN2", "LATIN5", "LATIN7", "LEFT", "LENGTH", "LESS_SYM", "LIKE_SYM", "LIMIT", "LINEAR_SYM", "LINES", "LIST_SYM", "LN", "LOAD", "LOAD_FILE", "LOCAL_SYM", "LOCATE", "LOCK", "LOG", "LOG10", "LOG2", "LONGBLOB", "LONGTEXT", "LOW_PRIORITY", "LOWER", "LPAD", "LTRIM", "MACCE", "MACROMAN", "MAKE_SET", "MAKEDATE", "MAKETIME", "MASTER_POS_WAIT", "MATCH", "MAX_SYM", "MAX_ROWS", "MAXVALUE_SYM", "MD5", "MEDIUMBLOB", "MEDIUMINT", "MEDIUMTEXT", "MERGE_SYM", "MICROSECOND", "MID", "MIN_SYM", "MIN_ROWS", "MINUTE", "MINUTE_MICROSECOND", "MINUTE_SECOND", "MOD", "MODE_SYM", "MODIFY_SYM", "MONTH", "MONTHNAME", "NAME_CONST", "NATURAL", "NEXT_SYM", "NO_SYM", "NONE_SYM", "NOT_SYM", "NOW", "NULL_SYM", "NUMERIC_SYM", "OCT", "OFFSET_SYM", "OLD_PASSWORD", "ON", "ONE_SYM", "OPEN_SYM", "OPTIMIZE", "OPTION", "OPTIONALLY", "OPTIONS_SYM", "ORD", "ORDER_SYM", "OUTER", "OWNER_SYM", "PACK_KEYS_SYM", "PARSER_SYM", "PARTIAL", "PARTITION_SYM", "PARTITIONING_SYM", "PARTITIONS_SYM", "PASSWORD", "PERIOD_ADD", "PERIOD_DIFF", "PI", "PORT_SYM", "POW", "POWER", "PRESERVE_SYM", "PREV_SYM", "PRIMARY_SYM", "QUARTER", "QUERY_SYM", "QUICK", "QUOTE", "RADIANS", "RAND", "RANGE_SYM", "READ_SYM", "REAL", "REBUILD_SYM", "REDUNDANT_SYM", "REFERENCES", "REGEXP", "RELEASE_LOCK", "REMOVE_SYM", "RENAME", "REORGANIZE_SYM", "REPAIR", "REPEAT", "REPLACE", "REPLICATION", "RESTRICT", "REVERSE", "RIGHT", "ROLLUP_SYM", "ROUND", "ROW_FORMAT_SYM", "ROW_SYM", "ROWS_SYM", "RPAD", "RTRIM", "SCHEDULE_SYM", "SCHEMA", "SEC_TO_TIME", "SECOND", "SECOND_MICROSECOND", "SECURITY_SYM", "SELECT", "SERVER_SYM", "SESSION_USER", "SET_SYM", "SHARED_SYM", "SHARE_SYM", "SIGN", "SIGNED_SYM", "SIMPLE_SYM", "SIN", "SJIS", "SLAVE", "SLEEP", "SMALLINT", "SOCKET_SYM", "SOUNDEX", "SOUNDS_SYM", "SPACE", "SPATIAL_SYM", "SQL_BIG_RESULT", "SQL_BUFFER_RESULT", "SQL_CACHE_SYM", "SQL_CALC_FOUND_ROWS", "SQL_NO_CACHE_SYM", "SQL_SMALL_RESULT", "SQL_SYM", "SQRT", "STARTING", "STATS_AUTO_RECALC", "STATS_PERSISTENT", "STD", "STDDEV", "STDDEV_POP", "STDDEV_SAMP", "STORAGE_SYM", "STR_TO_DATE", "STRAIGHT_JOIN", "STRCMP", "SUBPARTITION_SYM", "SUBPARTITIONS_SYM", "SUBSTRING", "SUBSTRING_INDEX", "SUBTIME", "SUM", "SWE7", "SYSDATE", "SYSTEM_USER", "TABLE", "TABLESPACE", "TAN", "TEMPORARY", "TEMPTABLE_SYM", "TERMINATED", "TEXT_SYM", "THAN_SYM", "THEN_SYM", "TIME_FORMAT", "TIME_SYM", "TIME_TO_SEC", "TIMEDIFF", "TIMESTAMP", "TIMESTAMPADD", "TIMESTAMPDIFF", "TINYBLOB", "TINYINT", "TINYTEXT", "TIS620", "TO_BASE64", "TO_DAYS", "TO_SECONDS", "TO_SYM", "TRANSACTION", "TRIM", "TRUE_SYM", "TRUNCATE", "UCS2", "UJIS", "UNDEFINED_SYM", "UNHEX", "UNION_SYM", "UNIQUE_SYM", "UNIX_TIMESTAMP", "UNSIGNED_SYM", "UPDATE", "UPGRADE_SYM", "UPPER", "USE_SYM", "USER", "USING_SYM", "UTC_DATE", "UTC_TIME", "UTC_TIMESTAMP", "UTF8", "UUID", "VALUE_SYM", "VALUES", "VAR_POP", "VAR_SAMP", "VARBINARY", "VARCHAR", "VARIABLES", "VARIANCE", "VERSION_SYM", "VIEW_SYM", "WAIT_SYM", "WEEK", "WEEKDAY", "WEEKOFYEAR", "WEIGHT_STRING", "WHEN_SYM", "WHERE", "WITH", "WRAPPER_SYM", "WRITE_SYM", "XA_SYM", "XML_SYM", "XOR", "LPAREN", "YEAR_FUNC", "YEAR_MONTH", "YEARWEEK", "ZEROFILL", "DIVIDE", "MOD_SYM", "OR_SYM", "AND_SYM", "ARROW", "EQ_SYM", "NOT_EQ", "LET", "GET", "SET_VAR", "SHIFT_LEFT", "SHIFT_RIGHT", "ALL_FIELDS", "SEMI", "COLON", "DOT", "COMMA", "ASTERISK", "RPAREN", "RBRACK", "LBRACK", "PLUS", "MINUS", "NEGATION", "VERTBAR", "BITAND", "POWER_OP", "GTH", "LTH", "INTEGER_NUM", "HEX_DIGIT_FRAGMENT", "HEX_DIGIT", "BIT_NUM", "REAL_NUMBER", "TEXT_STRING", "ID", "USER_VAR_SUBFIX1", "USER_VAR_SUBFIX2", "USER_VAR_SUBFIX3", "USER_VAR_SUBFIX4", "USER_VAR", "WHITE_SPACE", "SL_COMMENT", "ML_COMMENT", "TN_SELECT", "TN_SELECT_OPTIONS", "TN_COLS", "TN_COL", "TN_COL_ALLC", "TN_COL_ALLTC", "TN_COL_EXP", "TN_COL_BITEXP", "TN_FROM", "TN_TABLE_REF", "TN_TABLE_SPEC", "TN_PARTITION", "TN_WHERE", "TN_GROUPBY", "TN_HAVING", "TN_ORDERBY", "TN_LIMIT", "TN_LOCKTYPE", "TN_UPDATE", "TN_CREATE", "TN_ALTER", "TN_DROP", "TN_INSERT", "TN_REPLACE", "TN_DELETE", "TN_TRUNCATE", "TN_UNION", "TN_JOIN", "TN_JOIN_QUALIFIER", "TN_JOIN_TABLE", "TN_JOIN_COND", "TN_FUNCTION", "TN_SUBQUERY", "TN_CASE_WHEN"
    };
    public static final int D_=7;
    public static final int DEGREES=153;
    public static final int NAME_CONST=323;
    public static final int CASCADED=74;
    public static final int KOI8U=262;
    public static final int LAST_DAY=264;
    public static final int LIKE_SYM=276;
    public static final int CONCAT_WS=103;
    public static final int INNER_SYM=243;
    public static final int CACHE_SYM=71;
    public static final int E_=8;
    public static final int REORGANIZE_SYM=378;
    public static final int RPAREN=539;
    public static final int CREATE=124;
    public static final int SUBPARTITIONS_SYM=438;
    public static final int REGEXP=374;
    public static final int GET=529;
    public static final int MEDIUMINT=308;
    public static final int DIVIDE=521;
    public static final int TIME_TO_SEC=457;
    public static final int RBRACK=540;
    public static final int SPATIAL_SYM=417;
    public static final int SQL_CACHE_SYM=420;
    public static final int F_=9;
    public static final int ASC=47;
    public static final int ACOS=31;
    public static final int TRANSACTION=470;
    public static final int LATIN2=270;
    public static final int LATIN1=269;
    public static final int LATIN7=272;
    public static final int HEX_DIGIT_FRAGMENT=551;
    public static final int DAYOFYEAR=147;
    public static final int DAY_MINUTE=142;
    public static final int POWER=358;
    public static final int LATIN5=271;
    public static final int CURDATE=127;
    public static final int TN_SELECT=565;
    public static final int RESTRICT=383;
    public static final int OCT=332;
    public static final int G_=10;
    public static final int LOW_PRIORITY=292;
    public static final int SL_COMMENT=563;
    public static final int USER=486;
    public static final int TN_DROP=586;
    public static final int INVOKER_SYM=252;
    public static final int DATE_SUB=135;
    public static final int ASIN=49;
    public static final int SYSTEM_USER=445;
    public static final int KOI8R=261;
    public static final int LOWER=293;
    public static final int MAXVALUE_SYM=305;
    public static final int GET_FORMAT=216;
    public static final int UTF8=491;
    public static final int AVG_ROW_LENGTH=55;
    public static final int MAX_ROWS=304;
    public static final int CONSTRAINT=107;
    public static final int SQL_SMALL_RESULT=423;
    public static final int OPTIONS_SYM=341;
    public static final int TIME_SYM=456;
    public static final int ALTER=42;
    public static final int LBRACK=541;
    public static final int INTERVAL_SYM=250;
    public static final int UUID=492;
    public static final int TIME_FORMAT=455;
    public static final int CURRENT_USER=129;
    public static final int BTREE_SYM=69;
    public static final int TN_UNION=591;
    public static final int SLEEP=411;
    public static final int LONGBLOB=290;
    public static final int GROUP_SYM=220;
    public static final int RANGE_SYM=368;
    public static final int BIT_NUM=553;
    public static final int LINES=279;
    public static final int TABLE=446;
    public static final int VARCHAR=498;
    public static final int SESSION_USER=401;
    public static final int YEAR_FUNC=517;
    public static final int SUM=442;
    public static final int WHITE_SPACE=562;
    public static final int BITAND=546;
    public static final int CHAR_LENGTH=81;
    public static final int SECOND_MICROSECOND=397;
    public static final int UNIX_TIMESTAMP=480;
    public static final int ADDDATE=34;
    public static final int CONNECTION_ID=105;
    public static final int ANALYZE_SYM=43;
    public static final int NULL_SYM=330;
    public static final int INTEGER_NUM=550;
    public static final int COMPRESS=100;
    public static final int AVG=54;
    public static final int LEFT=273;
    public static final int TRUNCATE=473;
    public static final int A_=4;
    public static final int BIT_SYM=65;
    public static final int EQ_SYM=526;
    public static final int GROUP_CONCAT=219;
    public static final int STD=429;
    public static final int PLUS=542;
    public static final int MINUTE_SECOND=317;
    public static final int OUTER=344;
    public static final int CP866=121;
    public static final int LONGTEXT=291;
    public static final int B_=5;
    public static final int INSTR=247;
    public static final int MINUTE_MICROSECOND=316;
    public static final int REMOVE_SYM=376;
    public static final int HEX_DIGIT=552;
    public static final int RIGHT=385;
    public static final int COMPLETION_SYM=99;
    public static final int ATAN2=52;
    public static final int HAVING=223;
    public static final int CHECK_SYM=84;
    public static final int GB2312=213;
    public static final int MINUS=543;
    public static final int SEMI=534;
    public static final int QUICK=364;
    public static final int NOT_EQ=527;
    public static final int VERTBAR=545;
    public static final int COLON=535;
    public static final int OPTIMIZE=338;
    public static final int DATE_SYM=136;
    public static final int CP852=120;
    public static final int COLUMN_SYM=94;
    public static final int DATABASE=131;
    public static final int ENCRYPT=175;
    public static final int C_=6;
    public static final int CP850=119;
    public static final int VIEW_SYM=502;
    public static final int USE_SYM=485;
    public static final int SQL_BIG_RESULT=418;
    public static final int TEXT_STRING=555;
    public static final int FROM_BASE64=208;
    public static final int ARROW=525;
    public static final int FORMAT=205;
    public static final int NATURAL=324;
    public static final int TN_LOCKTYPE=582;
    public static final int CLOSE_SYM=87;
    public static final int FORCE_SYM=203;
    public static final int PARTITION_SYM=349;
    public static final int WEEK=504;
    public static final int LESS_SYM=275;
    public static final int LN=281;
    public static final int UNSIGNED_SYM=481;
    public static final int SQL_CALC_FOUND_ROWS=421;
    public static final int CONVERT_SYM=109;
    public static final int CHAR=80;
    public static final int INT_SYM=248;
    public static final int COUNT=114;
    public static final int BIT_LENGTH=63;
    public static final int FIND_IN_SET=197;
    public static final int SUBSTRING_INDEX=440;
    public static final int TERMINATED=451;
    public static final int L_=15;
    public static final int DATEDIFF=137;
    public static final int BENCHMARK=56;
    public static final int CURTIME=130;
    public static final int QUOTE=365;
    public static final int ENDS_SYM=177;
    public static final int QUARTER=362;
    public static final int XML_SYM=514;
    public static final int BIT_OR=64;
    public static final int TAN=448;
    public static final int SWE7=443;
    public static final int MEDIUMBLOB=307;
    public static final int LATIN1_BIN=267;
    public static final int PERIOD_DIFF=354;
    public static final int HOUR_MICROSECOND=229;
    public static final int TN_REPLACE=588;
    public static final int TN_COL=568;
    public static final int AND_SYM=524;
    public static final int LPAD=294;
    public static final int TN_ORDERBY=580;
    public static final int SELECT=399;
    public static final int M_=16;
    public static final int BIG5=58;
    public static final int INTO=251;
    public static final int DELAYED_SYM=155;
    public static final int LTRIM=295;
    public static final int COALESCE=88;
    public static final int SECOND=396;
    public static final int DAY_MICROSECOND=141;
    public static final int FILE_SYM=196;
    public static final int TN_PARTITION=576;
    public static final int LOG10=288;
    public static final int SQL_NO_CACHE_SYM=422;
    public static final int TINYTEXT=464;
    public static final int CIPHER_SYM=86;
    public static final int ON=335;
    public static final int SHARED_SYM=403;
    public static final int MATCH=302;
    public static final int FOR_SYM=202;
    public static final int STRAIGHT_JOIN=435;
    public static final int FLOOR=201;
    public static final int COMMITTED_SYM=97;
    public static final int COLLATE_SYM=91;
    public static final int AGAINST=39;
    public static final int N_=17;
    public static final int SHIFT_LEFT=531;
    public static final int SHIFT_RIGHT=532;
    public static final int FIELDS_SYM=194;
    public static final int DELETE_SYM=156;
    public static final int DISCARD=162;
    public static final int FOUND_ROWS=206;
    public static final int ADDTIME=35;
    public static final int MODE_SYM=319;
    public static final int TO_BASE64=466;
    public static final int PORT_SYM=356;
    public static final int TN_SUBQUERY=597;
    public static final int STDDEV=430;
    public static final int DOUBLE_SYM=166;
    public static final int ROUND=387;
    public static final int CONCURRENT=104;
    public static final int ONE_SYM=336;
    public static final int PI=355;
    public static final int THEN_SYM=454;
    public static final int KEY_BLOCK_SIZE=257;
    public static final int TN_ALTER=585;
    public static final int GET_LOCK=217;
    public static final int IN_SYM=238;
    public static final int TIMESTAMP=459;
    public static final int O_=18;
    public static final int UPPER=484;
    public static final int DISTINCTROW=164;
    public static final int WHERE=509;
    public static final int VAR_SAMP=496;
    public static final int TN_COL_EXP=571;
    public static final int DIRECTORY_SYM=160;
    public static final int LOAD_FILE=283;
    public static final int BIT_AND=62;
    public static final int UTC_TIMESTAMP=490;
    public static final int ROW_FORMAT_SYM=388;
    public static final int LIMIT=277;
    public static final int TN_LIMIT=581;
    public static final int MOD_SYM=522;
    public static final int ADD_SYM=33;
    public static final int H_=11;
    public static final int ID=556;
    public static final int SPACE=416;
    public static final int ENABLE_SYM=172;
    public static final int CROSS=126;
    public static final int DATA_SYM=132;
    public static final int LENGTH=274;
    public static final int IF=234;
    public static final int YEAR_MONTH=518;
    public static final int TN_JOIN_QUALIFIER=593;
    public static final int MACCE=296;
    public static final int QUERY_SYM=363;
    public static final int MD5=306;
    public static final int COMMA=537;
    public static final int EXPORT_SET=191;
    public static final int HEX=225;
    public static final int REFERENCES=373;
    public static final int OFFSET_SYM=333;
    public static final int WAIT_SYM=503;
    public static final int ELSE_SYM=170;
    public static final int PARTITIONS_SYM=351;
    public static final int AT_SYM=50;
    public static final int I_=12;
    public static final int CHECKSUM_SYM=85;
    public static final int TN_JOIN=592;
    public static final int WITH=510;
    public static final int FULLTEXT_SYM=212;
    public static final int EUCJPMS=182;
    public static final int IS_SYM=254;
    public static final int VARBINARY=497;
    public static final int GBK=214;
    public static final int UNHEX=477;
    public static final int OPEN_SYM=337;
    public static final int DATETIME=138;
    public static final int SOUNDS_SYM=415;
    public static final int DEFAULT=151;
    public static final int J_=13;
    public static final int DEC8=148;
    public static final int SQRT=425;
    public static final int DO_SYM=165;
    public static final int STRCMP=436;
    public static final int LAST_INSERT_ID=265;
    public static final int END_SYM=176;
    public static final int SUBPARTITION_SYM=437;
    public static final int SUBSTRING=439;
    public static final int LATIN1_GENERAL_CS=268;
    public static final int COMPACT_SYM=98;
    public static final int DAY_SECOND=143;
    public static final int BLOB_SYM=67;
    public static final int TN_FUNCTION=596;
    public static final int LOCATE=285;
    public static final int MODIFY_SYM=320;
    public static final int CROSECOND=125;
    public static final int TN_CREATE=584;
    public static final int VARIANCE=500;
    public static final int K_=14;
    public static final int TN_SELECT_OPTIONS=566;
    public static final int TN_UPDATE=583;
    public static final int MINUTE=315;
    public static final int INFILE=242;
    public static final int LET=528;
    public static final int COMPRESSED_SYM=101;
    public static final int TN_WHERE=577;
    public static final int IGNORE_SYM=236;
    public static final int DES_DECRYPT=157;
    public static final int GREEK=218;
    public static final int USING_SYM=487;
    public static final int INSERT_METHOD=246;
    public static final int MOD=318;
    public static final int LOCAL_SYM=284;
    public static final int UNIQUE_SYM=479;
    public static final int TN_CASE_WHEN=598;
    public static final int NOW=329;
    public static final int U_=24;
    public static final int EOF=-1;
    public static final int FOREIGN=204;
    public static final int UTC_DATE=488;
    public static final int UNDEFINED_SYM=476;
    public static final int ACTION=32;
    public static final int MONTH=321;
    public static final int TN_TRUNCATE=590;
    public static final int IDENTIFIED_SYM=233;
    public static final int TN_GROUPBY=578;
    public static final int USER_VAR=561;
    public static final int WEIGHT_STRING=507;
    public static final int STDDEV_POP=431;
    public static final int AS_SYM=46;
    public static final int IMPORT=237;
    public static final int SIN=408;
    public static final int NO_SYM=326;
    public static final int STORAGE_SYM=433;
    public static final int TRUE_SYM=472;
    public static final int AUTO_INCREMENT=53;
    public static final int TEXT_SYM=452;
    public static final int ZEROFILL=520;
    public static final int PREV_SYM=360;
    public static final int T_=23;
    public static final int CONNECTION_SYM=106;
    public static final int TINYBLOB=462;
    public static final int BY_SYM=70;
    public static final int DAYOFWEEK=146;
    public static final int ARMSCII8=45;
    public static final int STDDEV_SAMP=432;
    public static final int MONTHNAME=322;
    public static final int ROLLUP_SYM=386;
    public static final int CHARACTER_SYM=82;
    public static final int WRAPPER_SYM=511;
    public static final int SLAVE=410;
    public static final int DELAY_KEY_WRITE_SYM=154;
    public static final int YEARWEEK=519;
    public static final int TIS620=465;
    public static final int IS_USED_LOCK=255;
    public static final int SHARE_SYM=404;
    public static final int ELT=171;
    public static final int PRIMARY_SYM=361;
    public static final int LOAD=282;
    public static final int AES_DECRYPT=36;
    public static final int TIMESTAMPADD=460;
    public static final int MEDIUMTEXT=309;
    public static final int DEFINER=152;
    public static final int W_=26;
    public static final int UPGRADE_SYM=483;
    public static final int MERGE_SYM=310;
    public static final int TABLESPACE=447;
    public static final int ABS=30;
    public static final int INET_ATON=240;
    public static final int REAL=370;
    public static final int CALL_SYM=72;
    public static final int LANGUAGE=263;
    public static final int UNION_SYM=478;
    public static final int RADIANS=366;
    public static final int MAKEDATE=299;
    public static final int REAL_NUMBER=554;
    public static final int TN_TABLE_SPEC=575;
    public static final int TRIM=471;
    public static final int V_=25;
    public static final int MIN_ROWS=314;
    public static final int REPEAT=380;
    public static final int UTC_TIME=489;
    public static final int NONE_SYM=327;
    public static final int REVERSE=384;
    public static final int TO_DAYS=467;
    public static final int INTEGER_SYM=249;
    public static final int TEMPTABLE_SYM=450;
    public static final int STATS_AUTO_RECALC=427;
    public static final int DISABLE_SYM=161;
    public static final int CONVERT_TZ=110;
    public static final int HEBREW=224;
    public static final int REBUILD_SYM=371;
    public static final int REPLICATION=382;
    public static final int RENAME=377;
    public static final int SQL_BUFFER_RESULT=419;
    public static final int OPTION=339;
    public static final int JOIN_SYM=256;
    public static final int PERIOD_ADD=353;
    public static final int MICROSECOND=311;
    public static final int EXCLUSIVE_SYM=187;
    public static final int OPTIONALLY=340;
    public static final int TN_HAVING=579;
    public static final int NEXT_SYM=325;
    public static final int ALL_FIELDS=533;
    public static final int Q_=20;
    public static final int CHARSET=83;
    public static final int SOCKET_SYM=413;
    public static final int DAYOFMONTH=145;
    public static final int ASTERISK=538;
    public static final int LPAREN=516;
    public static final int PARSER_SYM=347;
    public static final int DAY_HOUR=140;
    public static final int COLLATION=92;
    public static final int REPLACE=381;
    public static final int EUCKR=183;
    public static final int HANDLER_SYM=221;
    public static final int RAND=367;
    public static final int TIMEDIFF=458;
    public static final int FROM_UNIXTIME=210;
    public static final int EXISTS=188;
    public static final int INET_NTOA=241;
    public static final int P_=19;
    public static final int INDEX_SYM=239;
    public static final int CP932=122;
    public static final int NUMERIC_SYM=331;
    public static final int PACK_KEYS_SYM=346;
    public static final int DES_ENCRYPT=158;
    public static final int MACROMAN=297;
    public static final int TN_COL_ALLC=569;
    public static final int FALSE_SYM=193;
    public static final int MID=312;
    public static final int UCS2=474;
    public static final int WRITE_SYM=512;
    public static final int TO_SYM=469;
    public static final int HOUR=228;
    public static final int THAN_SYM=453;
    public static final int CHANGE=79;
    public static final int S_=22;
    public static final int REDUNDANT_SYM=372;
    public static final int SCHEMA=394;
    public static final int ENUM=179;
    public static final int COLUMNS_SYM=95;
    public static final int NEGATION=544;
    public static final int DROP=167;
    public static final int BIGINT=59;
    public static final int EXPANSION_SYM=190;
    public static final int BIT_XOR=66;
    public static final int VALUE_SYM=493;
    public static final int HOUR_MINUTE=230;
    public static final int ORDER_SYM=343;
    public static final int IS_FREE_LOCK=253;
    public static final int XA_SYM=513;
    public static final int BIN=60;
    public static final int BETWEEN=57;
    public static final int R_=21;
    public static final int SIGN=405;
    public static final int LOG=287;
    public static final int OWNER_SYM=345;
    public static final int MAKETIME=300;
    public static final int TN_COL_BITEXP=572;
    public static final int DAYNAME=144;
    public static final int CASCADE=73;
    public static final int OR_SYM=523;
    public static final int MIN_SYM=313;
    public static final int TO_SECONDS=468;
    public static final int TN_JOIN_COND=595;
    public static final int WEEKDAY=505;
    public static final int SOUNDEX=414;
    public static final int FULL=211;
    public static final int REPAIR=379;
    public static final int COT=113;
    public static final int POW=357;
    public static final int INSERT=245;
    public static final int SECURITY_SYM=398;
    public static final int EXP=189;
    public static final int DATE_FORMAT=134;
    public static final int COS=112;
    public static final int EVENT_SYM=184;
    public static final int BOOLEAN_SYM=68;
    public static final int FIRST_SYM=198;
    public static final int TINYINT=463;
    public static final int AES_ENCRYPT=37;
    public static final int LOG2=289;
    public static final int MASTER_POS_WAIT=301;
    public static final int ATAN=51;
    public static final int TN_COLS=567;
    public static final int FLOAT_SYM=200;
    public static final int EVERY_SYM=185;
    public static final int NOT_SYM=328;
    public static final int CP1256=117;
    public static final int COMMENT_SYM=96;
    public static final int CP1251=116;
    public static final int CP1250=115;
    public static final int CONCAT=102;
    public static final int KEYBCS2=259;
    public static final int OLD_PASSWORD=334;
    public static final int LIST_SYM=280;
    public static final int CODE_SYM=89;
    public static final int DATE_ADD=133;
    public static final int POWER_OP=547;
    public static final int VERSION_SYM=501;
    public static final int HOUR_SECOND=231;
    public static final int PASSWORD=352;
    public static final int CP1257=118;
    public static final int COLUMN_FORMAT=93;
    public static final int CASE_SYM=75;
    public static final int SERVER_SYM=400;
    public static final int VAR_POP=495;
    public static final int TIMESTAMPDIFF=461;
    public static final int SUBTIME=441;
    public static final int FIELD=195;
    public static final int ESCAPED=181;
    public static final int STR_TO_DATE=434;
    public static final int FROM=207;
    public static final int GEOSTD8=215;
    public static final int TEMPORARY=449;
    public static final int DISTINCT=163;
    public static final int RTRIM=392;
    public static final int ENCODE=174;
    public static final int SEC_TO_TIME=395;
    public static final int UJIS=475;
    public static final int Y_=28;
    public static final int MAKE_SET=298;
    public static final int CEILING=78;
    public static final int GTH=548;
    public static final int DECIMAL_SYM=149;
    public static final int FROM_DAYS=209;
    public static final int COPY_SYM=111;
    public static final int UPDATE=482;
    public static final int TN_INSERT=587;
    public static final int WEEKOFYEAR=506;
    public static final int HP8=232;
    public static final int SCHEDULE_SYM=393;
    public static final int AFTER_SYM=38;
    public static final int READ_SYM=369;
    public static final int ORD=342;
    public static final int LOCK=286;
    public static final int RELEASE_LOCK=375;
    public static final int ROWS_SYM=390;
    public static final int ML_COMMENT=564;
    public static final int X_=27;
    public static final int PRESERVE_SYM=359;
    public static final int INPLACE_SYM=244;
    public static final int SJIS=409;
    public static final int SYSDATE=444;
    public static final int ALGORITHM_SYM=40;
    public static final int ALL=41;
    public static final int HIGH_PRIORITY=226;
    public static final int COERCIBILITY=90;
    public static final int TN_JOIN_TABLE=594;
    public static final int DAY_SYM=139;
    public static final int ASCII_SYM=48;
    public static final int DOT=536;
    public static final int EXTRACT=192;
    public static final int STATS_PERSISTENT=428;
    public static final int EXCHANGE_SYM=186;
    public static final int CURRENT_TIMESTAMP=128;
    public static final int PARTITIONING_SYM=350;
    public static final int PARTIAL=348;
    public static final int USER_VAR_SUBFIX4=560;
    public static final int TN_TABLE_REF=574;
    public static final int USER_VAR_SUBFIX3=559;
    public static final int SIMPLE_SYM=407;
    public static final int USER_VAR_SUBFIX2=558;
    public static final int USER_VAR_SUBFIX1=557;
    public static final int XOR=515;
    public static final int CRC32=123;
    public static final int VALUES=494;
    public static final int HOST_SYM=227;
    public static final int SET_VAR=530;
    public static final int IFNULL=235;
    public static final int DYNAMIC_SYM=169;
    public static final int TN_FROM=573;
    public static final int ROW_SYM=389;
    public static final int ENCLOSED=173;
    public static final int DUPLICATE_SYM=168;
    public static final int LAST_SYM=266;
    public static final int TN_DELETE=589;
    public static final int KEY_SYM=258;
    public static final int LINEAR_SYM=278;
    public static final int TN_COL_ALLTC=570;
    public static final int LTH=549;
    public static final int ANY=44;
    public static final int Z_=29;
    public static final int SET_SYM=402;
    public static final int ESCAPE_SYM=180;
    public static final int DECODE=150;
    public static final int CONV=108;
    public static final int VARIABLES=499;
    public static final int STARTING=426;
    public static final int CEIL=77;
    public static final int SIGNED_SYM=406;
    public static final int FIXED_SYM=199;
    public static final int WHEN_SYM=508;
    public static final int DESC=159;
    public static final int BINARY=61;
    public static final int CAST_SYM=76;
    public static final int HASH_SYM=222;
    public static final int KEYS=260;
    public static final int MAX_SYM=303;
    public static final int ENGINE_SYM=178;
    public static final int SQL_SYM=424;
    public static final int RPAD=391;
    public static final int SMALLINT=412;

    // delegates
    public MySQL_SQLParser1 gSQLParser1;
    public MySQL_SQLParser2 gSQLParser2;
    // delegators


        public MySQLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MySQLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[1327+1];
             
            gSQLParser1 = new MySQL_SQLParser1(input, state, this);
            gSQLParser2 = new MySQL_SQLParser2(input, state, this);         
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
        gSQLParser1.setTreeAdaptor(this.adaptor);gSQLParser2.setTreeAdaptor(this.adaptor);
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return MySQLParser.tokenNames; }
    public String getGrammarFileName() { return "MySQL.g"; }



      @Override
      protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
        throw new MismatchedTokenException(ttype, input);
      }

      @Override
      public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException {
        throw e;
      }



    public static class relational_op_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relational_op"
    // MySQL.g:78:1: relational_op : ( EQ_SYM | LTH | GTH | NOT_EQ | LET | GET );
    public final MySQLParser.relational_op_return relational_op() throws RecognitionException {
        MySQLParser.relational_op_return retval = new MySQLParser.relational_op_return();
        retval.start = input.LT(1);
        int relational_op_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set1=null;

        CommonTree set1_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 752) ) { return retval; }
            // MySQL.g:78:14: ( EQ_SYM | LTH | GTH | NOT_EQ | LET | GET )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set1=(Token)input.LT(1);
            if ( (input.LA(1)>=EQ_SYM && input.LA(1)<=GET)||(input.LA(1)>=GTH && input.LA(1)<=LTH) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set1));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 752, relational_op_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "relational_op"

    public static class charset_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "charset_name"
    // MySQL.g:81:1: charset_name : ( ARMSCII8 | ASCII_SYM | BIG5 | BINARY | CP1250 | CP1251 | CP1256 | CP1257 | CP850 | CP852 | CP866 | CP932 | DEC8 | EUCJPMS | EUCKR | GB2312 | GBK | GEOSTD8 | GREEK | HEBREW | HP8 | KEYBCS2 | KOI8R | KOI8U | LATIN1 | LATIN2 | LATIN5 | LATIN7 | MACCE | MACROMAN | SJIS | SWE7 | TIS620 | UCS2 | UJIS | UTF8 );
    public final MySQLParser.charset_name_return charset_name() throws RecognitionException {
        MySQLParser.charset_name_return retval = new MySQLParser.charset_name_return();
        retval.start = input.LT(1);
        int charset_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set2=null;

        CommonTree set2_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 753) ) { return retval; }
            // MySQL.g:81:13: ( ARMSCII8 | ASCII_SYM | BIG5 | BINARY | CP1250 | CP1251 | CP1256 | CP1257 | CP850 | CP852 | CP866 | CP932 | DEC8 | EUCJPMS | EUCKR | GB2312 | GBK | GEOSTD8 | GREEK | HEBREW | HP8 | KEYBCS2 | KOI8R | KOI8U | LATIN1 | LATIN2 | LATIN5 | LATIN7 | MACCE | MACROMAN | SJIS | SWE7 | TIS620 | UCS2 | UJIS | UTF8 )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set2=(Token)input.LT(1);
            if ( input.LA(1)==ARMSCII8||input.LA(1)==ASCII_SYM||input.LA(1)==BIG5||input.LA(1)==BINARY||(input.LA(1)>=CP1250 && input.LA(1)<=CP932)||input.LA(1)==DEC8||(input.LA(1)>=EUCJPMS && input.LA(1)<=EUCKR)||(input.LA(1)>=GB2312 && input.LA(1)<=GEOSTD8)||input.LA(1)==GREEK||input.LA(1)==HEBREW||input.LA(1)==HP8||input.LA(1)==KEYBCS2||(input.LA(1)>=KOI8R && input.LA(1)<=KOI8U)||(input.LA(1)>=LATIN1 && input.LA(1)<=LATIN7)||(input.LA(1)>=MACCE && input.LA(1)<=MACROMAN)||input.LA(1)==SJIS||input.LA(1)==SWE7||input.LA(1)==TIS620||(input.LA(1)>=UCS2 && input.LA(1)<=UJIS)||input.LA(1)==UTF8 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set2));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 753, charset_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "charset_name"

    public static class cast_data_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cast_data_type"
    // MySQL.g:119:1: cast_data_type : ( BINARY ( INTEGER_NUM )? | CHAR ( INTEGER_NUM )? | DATE_SYM | DATETIME | DECIMAL_SYM ( INTEGER_NUM ( COMMA INTEGER_NUM )? )? | SIGNED_SYM ( INTEGER_SYM )? | TIME_SYM | UNSIGNED_SYM ( INTEGER_SYM )? );
    public final MySQLParser.cast_data_type_return cast_data_type() throws RecognitionException {
        MySQLParser.cast_data_type_return retval = new MySQLParser.cast_data_type_return();
        retval.start = input.LT(1);
        int cast_data_type_StartIndex = input.index();
        CommonTree root_0 = null;

        Token BINARY3=null;
        Token INTEGER_NUM4=null;
        Token CHAR5=null;
        Token INTEGER_NUM6=null;
        Token DATE_SYM7=null;
        Token DATETIME8=null;
        Token DECIMAL_SYM9=null;
        Token INTEGER_NUM10=null;
        Token COMMA11=null;
        Token INTEGER_NUM12=null;
        Token SIGNED_SYM13=null;
        Token INTEGER_SYM14=null;
        Token TIME_SYM15=null;
        Token UNSIGNED_SYM16=null;
        Token INTEGER_SYM17=null;

        CommonTree BINARY3_tree=null;
        CommonTree INTEGER_NUM4_tree=null;
        CommonTree CHAR5_tree=null;
        CommonTree INTEGER_NUM6_tree=null;
        CommonTree DATE_SYM7_tree=null;
        CommonTree DATETIME8_tree=null;
        CommonTree DECIMAL_SYM9_tree=null;
        CommonTree INTEGER_NUM10_tree=null;
        CommonTree COMMA11_tree=null;
        CommonTree INTEGER_NUM12_tree=null;
        CommonTree SIGNED_SYM13_tree=null;
        CommonTree INTEGER_SYM14_tree=null;
        CommonTree TIME_SYM15_tree=null;
        CommonTree UNSIGNED_SYM16_tree=null;
        CommonTree INTEGER_SYM17_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 754) ) { return retval; }
            // MySQL.g:119:15: ( BINARY ( INTEGER_NUM )? | CHAR ( INTEGER_NUM )? | DATE_SYM | DATETIME | DECIMAL_SYM ( INTEGER_NUM ( COMMA INTEGER_NUM )? )? | SIGNED_SYM ( INTEGER_SYM )? | TIME_SYM | UNSIGNED_SYM ( INTEGER_SYM )? )
            int alt7=8;
            switch ( input.LA(1) ) {
            case BINARY:
                {
                alt7=1;
                }
                break;
            case CHAR:
                {
                alt7=2;
                }
                break;
            case DATE_SYM:
                {
                alt7=3;
                }
                break;
            case DATETIME:
                {
                alt7=4;
                }
                break;
            case DECIMAL_SYM:
                {
                alt7=5;
                }
                break;
            case SIGNED_SYM:
                {
                alt7=6;
                }
                break;
            case TIME_SYM:
                {
                alt7=7;
                }
                break;
            case UNSIGNED_SYM:
                {
                alt7=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // MySQL.g:120:2: BINARY ( INTEGER_NUM )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    BINARY3=(Token)match(input,BINARY,FOLLOW_BINARY_in_cast_data_type436); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BINARY3_tree = (CommonTree)adaptor.create(BINARY3);
                    adaptor.addChild(root_0, BINARY3_tree);
                    }
                    // MySQL.g:120:9: ( INTEGER_NUM )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==INTEGER_NUM) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // MySQL.g:120:10: INTEGER_NUM
                            {
                            INTEGER_NUM4=(Token)match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_cast_data_type439); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            INTEGER_NUM4_tree = (CommonTree)adaptor.create(INTEGER_NUM4);
                            adaptor.addChild(root_0, INTEGER_NUM4_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // MySQL.g:121:4: CHAR ( INTEGER_NUM )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CHAR5=(Token)match(input,CHAR,FOLLOW_CHAR_in_cast_data_type447); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHAR5_tree = (CommonTree)adaptor.create(CHAR5);
                    adaptor.addChild(root_0, CHAR5_tree);
                    }
                    // MySQL.g:121:9: ( INTEGER_NUM )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==INTEGER_NUM) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // MySQL.g:121:10: INTEGER_NUM
                            {
                            INTEGER_NUM6=(Token)match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_cast_data_type450); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            INTEGER_NUM6_tree = (CommonTree)adaptor.create(INTEGER_NUM6);
                            adaptor.addChild(root_0, INTEGER_NUM6_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // MySQL.g:122:4: DATE_SYM
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DATE_SYM7=(Token)match(input,DATE_SYM,FOLLOW_DATE_SYM_in_cast_data_type458); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATE_SYM7_tree = (CommonTree)adaptor.create(DATE_SYM7);
                    adaptor.addChild(root_0, DATE_SYM7_tree);
                    }

                    }
                    break;
                case 4 :
                    // MySQL.g:123:4: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DATETIME8=(Token)match(input,DATETIME,FOLLOW_DATETIME_in_cast_data_type463); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME8_tree = (CommonTree)adaptor.create(DATETIME8);
                    adaptor.addChild(root_0, DATETIME8_tree);
                    }

                    }
                    break;
                case 5 :
                    // MySQL.g:124:4: DECIMAL_SYM ( INTEGER_NUM ( COMMA INTEGER_NUM )? )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DECIMAL_SYM9=(Token)match(input,DECIMAL_SYM,FOLLOW_DECIMAL_SYM_in_cast_data_type469); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMAL_SYM9_tree = (CommonTree)adaptor.create(DECIMAL_SYM9);
                    adaptor.addChild(root_0, DECIMAL_SYM9_tree);
                    }
                    // MySQL.g:124:16: ( INTEGER_NUM ( COMMA INTEGER_NUM )? )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==INTEGER_NUM) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // MySQL.g:124:18: INTEGER_NUM ( COMMA INTEGER_NUM )?
                            {
                            INTEGER_NUM10=(Token)match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_cast_data_type473); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            INTEGER_NUM10_tree = (CommonTree)adaptor.create(INTEGER_NUM10);
                            adaptor.addChild(root_0, INTEGER_NUM10_tree);
                            }
                            // MySQL.g:124:30: ( COMMA INTEGER_NUM )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==COMMA) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // MySQL.g:124:31: COMMA INTEGER_NUM
                                    {
                                    COMMA11=(Token)match(input,COMMA,FOLLOW_COMMA_in_cast_data_type476); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    COMMA11_tree = (CommonTree)adaptor.create(COMMA11);
                                    adaptor.addChild(root_0, COMMA11_tree);
                                    }
                                    INTEGER_NUM12=(Token)match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_cast_data_type478); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    INTEGER_NUM12_tree = (CommonTree)adaptor.create(INTEGER_NUM12);
                                    adaptor.addChild(root_0, INTEGER_NUM12_tree);
                                    }

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // MySQL.g:125:4: SIGNED_SYM ( INTEGER_SYM )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SIGNED_SYM13=(Token)match(input,SIGNED_SYM,FOLLOW_SIGNED_SYM_in_cast_data_type488); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SIGNED_SYM13_tree = (CommonTree)adaptor.create(SIGNED_SYM13);
                    adaptor.addChild(root_0, SIGNED_SYM13_tree);
                    }
                    // MySQL.g:125:15: ( INTEGER_SYM )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==INTEGER_SYM) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // MySQL.g:125:16: INTEGER_SYM
                            {
                            INTEGER_SYM14=(Token)match(input,INTEGER_SYM,FOLLOW_INTEGER_SYM_in_cast_data_type491); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            INTEGER_SYM14_tree = (CommonTree)adaptor.create(INTEGER_SYM14);
                            adaptor.addChild(root_0, INTEGER_SYM14_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 7 :
                    // MySQL.g:126:4: TIME_SYM
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TIME_SYM15=(Token)match(input,TIME_SYM,FOLLOW_TIME_SYM_in_cast_data_type498); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TIME_SYM15_tree = (CommonTree)adaptor.create(TIME_SYM15);
                    adaptor.addChild(root_0, TIME_SYM15_tree);
                    }

                    }
                    break;
                case 8 :
                    // MySQL.g:127:4: UNSIGNED_SYM ( INTEGER_SYM )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    UNSIGNED_SYM16=(Token)match(input,UNSIGNED_SYM,FOLLOW_UNSIGNED_SYM_in_cast_data_type503); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNSIGNED_SYM16_tree = (CommonTree)adaptor.create(UNSIGNED_SYM16);
                    adaptor.addChild(root_0, UNSIGNED_SYM16_tree);
                    }
                    // MySQL.g:127:17: ( INTEGER_SYM )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==INTEGER_SYM) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // MySQL.g:127:18: INTEGER_SYM
                            {
                            INTEGER_SYM17=(Token)match(input,INTEGER_SYM,FOLLOW_INTEGER_SYM_in_cast_data_type506); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            INTEGER_SYM17_tree = (CommonTree)adaptor.create(INTEGER_SYM17);
                            adaptor.addChild(root_0, INTEGER_SYM17_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 754, cast_data_type_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "cast_data_type"

    public static class search_modifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "search_modifier"
    // MySQL.g:130:1: search_modifier : ( ( IN_SYM NATURAL LANGUAGE MODE_SYM ) | ( IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM ) | ( IN_SYM BOOLEAN_SYM MODE_SYM ) | ( WITH QUERY_SYM EXPANSION_SYM ) );
    public final MySQLParser.search_modifier_return search_modifier() throws RecognitionException {
        MySQLParser.search_modifier_return retval = new MySQLParser.search_modifier_return();
        retval.start = input.LT(1);
        int search_modifier_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IN_SYM18=null;
        Token NATURAL19=null;
        Token LANGUAGE20=null;
        Token MODE_SYM21=null;
        Token IN_SYM22=null;
        Token NATURAL23=null;
        Token LANGUAGE24=null;
        Token MODE_SYM25=null;
        Token WITH26=null;
        Token QUERY_SYM27=null;
        Token EXPANSION_SYM28=null;
        Token IN_SYM29=null;
        Token BOOLEAN_SYM30=null;
        Token MODE_SYM31=null;
        Token WITH32=null;
        Token QUERY_SYM33=null;
        Token EXPANSION_SYM34=null;

        CommonTree IN_SYM18_tree=null;
        CommonTree NATURAL19_tree=null;
        CommonTree LANGUAGE20_tree=null;
        CommonTree MODE_SYM21_tree=null;
        CommonTree IN_SYM22_tree=null;
        CommonTree NATURAL23_tree=null;
        CommonTree LANGUAGE24_tree=null;
        CommonTree MODE_SYM25_tree=null;
        CommonTree WITH26_tree=null;
        CommonTree QUERY_SYM27_tree=null;
        CommonTree EXPANSION_SYM28_tree=null;
        CommonTree IN_SYM29_tree=null;
        CommonTree BOOLEAN_SYM30_tree=null;
        CommonTree MODE_SYM31_tree=null;
        CommonTree WITH32_tree=null;
        CommonTree QUERY_SYM33_tree=null;
        CommonTree EXPANSION_SYM34_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 755) ) { return retval; }
            // MySQL.g:130:16: ( ( IN_SYM NATURAL LANGUAGE MODE_SYM ) | ( IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM ) | ( IN_SYM BOOLEAN_SYM MODE_SYM ) | ( WITH QUERY_SYM EXPANSION_SYM ) )
            int alt8=4;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // MySQL.g:131:2: ( IN_SYM NATURAL LANGUAGE MODE_SYM )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:131:2: ( IN_SYM NATURAL LANGUAGE MODE_SYM )
                    // MySQL.g:131:3: IN_SYM NATURAL LANGUAGE MODE_SYM
                    {
                    IN_SYM18=(Token)match(input,IN_SYM,FOLLOW_IN_SYM_in_search_modifier519); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN_SYM18_tree = (CommonTree)adaptor.create(IN_SYM18);
                    adaptor.addChild(root_0, IN_SYM18_tree);
                    }
                    NATURAL19=(Token)match(input,NATURAL,FOLLOW_NATURAL_in_search_modifier521); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATURAL19_tree = (CommonTree)adaptor.create(NATURAL19);
                    adaptor.addChild(root_0, NATURAL19_tree);
                    }
                    LANGUAGE20=(Token)match(input,LANGUAGE,FOLLOW_LANGUAGE_in_search_modifier523); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LANGUAGE20_tree = (CommonTree)adaptor.create(LANGUAGE20);
                    adaptor.addChild(root_0, LANGUAGE20_tree);
                    }
                    MODE_SYM21=(Token)match(input,MODE_SYM,FOLLOW_MODE_SYM_in_search_modifier525); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MODE_SYM21_tree = (CommonTree)adaptor.create(MODE_SYM21);
                    adaptor.addChild(root_0, MODE_SYM21_tree);
                    }

                    }


                    }
                    break;
                case 2 :
                    // MySQL.g:132:4: ( IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:132:4: ( IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM )
                    // MySQL.g:132:5: IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM
                    {
                    IN_SYM22=(Token)match(input,IN_SYM,FOLLOW_IN_SYM_in_search_modifier532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN_SYM22_tree = (CommonTree)adaptor.create(IN_SYM22);
                    adaptor.addChild(root_0, IN_SYM22_tree);
                    }
                    NATURAL23=(Token)match(input,NATURAL,FOLLOW_NATURAL_in_search_modifier534); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATURAL23_tree = (CommonTree)adaptor.create(NATURAL23);
                    adaptor.addChild(root_0, NATURAL23_tree);
                    }
                    LANGUAGE24=(Token)match(input,LANGUAGE,FOLLOW_LANGUAGE_in_search_modifier536); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LANGUAGE24_tree = (CommonTree)adaptor.create(LANGUAGE24);
                    adaptor.addChild(root_0, LANGUAGE24_tree);
                    }
                    MODE_SYM25=(Token)match(input,MODE_SYM,FOLLOW_MODE_SYM_in_search_modifier538); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MODE_SYM25_tree = (CommonTree)adaptor.create(MODE_SYM25);
                    adaptor.addChild(root_0, MODE_SYM25_tree);
                    }
                    WITH26=(Token)match(input,WITH,FOLLOW_WITH_in_search_modifier540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WITH26_tree = (CommonTree)adaptor.create(WITH26);
                    adaptor.addChild(root_0, WITH26_tree);
                    }
                    QUERY_SYM27=(Token)match(input,QUERY_SYM,FOLLOW_QUERY_SYM_in_search_modifier542); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUERY_SYM27_tree = (CommonTree)adaptor.create(QUERY_SYM27);
                    adaptor.addChild(root_0, QUERY_SYM27_tree);
                    }
                    EXPANSION_SYM28=(Token)match(input,EXPANSION_SYM,FOLLOW_EXPANSION_SYM_in_search_modifier544); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPANSION_SYM28_tree = (CommonTree)adaptor.create(EXPANSION_SYM28);
                    adaptor.addChild(root_0, EXPANSION_SYM28_tree);
                    }

                    }


                    }
                    break;
                case 3 :
                    // MySQL.g:133:4: ( IN_SYM BOOLEAN_SYM MODE_SYM )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:133:4: ( IN_SYM BOOLEAN_SYM MODE_SYM )
                    // MySQL.g:133:5: IN_SYM BOOLEAN_SYM MODE_SYM
                    {
                    IN_SYM29=(Token)match(input,IN_SYM,FOLLOW_IN_SYM_in_search_modifier551); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN_SYM29_tree = (CommonTree)adaptor.create(IN_SYM29);
                    adaptor.addChild(root_0, IN_SYM29_tree);
                    }
                    BOOLEAN_SYM30=(Token)match(input,BOOLEAN_SYM,FOLLOW_BOOLEAN_SYM_in_search_modifier553); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN_SYM30_tree = (CommonTree)adaptor.create(BOOLEAN_SYM30);
                    adaptor.addChild(root_0, BOOLEAN_SYM30_tree);
                    }
                    MODE_SYM31=(Token)match(input,MODE_SYM,FOLLOW_MODE_SYM_in_search_modifier555); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MODE_SYM31_tree = (CommonTree)adaptor.create(MODE_SYM31);
                    adaptor.addChild(root_0, MODE_SYM31_tree);
                    }

                    }


                    }
                    break;
                case 4 :
                    // MySQL.g:134:4: ( WITH QUERY_SYM EXPANSION_SYM )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:134:4: ( WITH QUERY_SYM EXPANSION_SYM )
                    // MySQL.g:134:5: WITH QUERY_SYM EXPANSION_SYM
                    {
                    WITH32=(Token)match(input,WITH,FOLLOW_WITH_in_search_modifier562); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WITH32_tree = (CommonTree)adaptor.create(WITH32);
                    adaptor.addChild(root_0, WITH32_tree);
                    }
                    QUERY_SYM33=(Token)match(input,QUERY_SYM,FOLLOW_QUERY_SYM_in_search_modifier564); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUERY_SYM33_tree = (CommonTree)adaptor.create(QUERY_SYM33);
                    adaptor.addChild(root_0, QUERY_SYM33_tree);
                    }
                    EXPANSION_SYM34=(Token)match(input,EXPANSION_SYM,FOLLOW_EXPANSION_SYM_in_search_modifier566); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPANSION_SYM34_tree = (CommonTree)adaptor.create(EXPANSION_SYM34);
                    adaptor.addChild(root_0, EXPANSION_SYM34_tree);
                    }

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 755, search_modifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "search_modifier"

    public static class transcoding_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "transcoding_name"
    // MySQL.g:137:1: transcoding_name : ( LATIN1 | UTF8 );
    public final MySQLParser.transcoding_name_return transcoding_name() throws RecognitionException {
        MySQLParser.transcoding_name_return retval = new MySQLParser.transcoding_name_return();
        retval.start = input.LT(1);
        int transcoding_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set35=null;

        CommonTree set35_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 756) ) { return retval; }
            // MySQL.g:137:17: ( LATIN1 | UTF8 )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set35=(Token)input.LT(1);
            if ( input.LA(1)==LATIN1||input.LA(1)==UTF8 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set35));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 756, transcoding_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "transcoding_name"

    public static class interval_unit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "interval_unit"
    // MySQL.g:142:1: interval_unit : ( SECOND | MINUTE | HOUR | DAY_SYM | WEEK | MONTH | QUARTER | Y_ E_ A_ R_ | SECOND_MICROSECOND | MINUTE_MICROSECOND | MINUTE_SECOND | HOUR_MICROSECOND | HOUR_SECOND | HOUR_MINUTE | DAY_MICROSECOND | DAY_SECOND | DAY_MINUTE | DAY_HOUR | YEAR_MONTH );
    public final MySQLParser.interval_unit_return interval_unit() throws RecognitionException {
        MySQLParser.interval_unit_return retval = new MySQLParser.interval_unit_return();
        retval.start = input.LT(1);
        int interval_unit_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SECOND36=null;
        Token MINUTE37=null;
        Token HOUR38=null;
        Token DAY_SYM39=null;
        Token WEEK40=null;
        Token MONTH41=null;
        Token QUARTER42=null;
        Token Y_43=null;
        Token E_44=null;
        Token A_45=null;
        Token R_46=null;
        Token SECOND_MICROSECOND47=null;
        Token MINUTE_MICROSECOND48=null;
        Token MINUTE_SECOND49=null;
        Token HOUR_MICROSECOND50=null;
        Token HOUR_SECOND51=null;
        Token HOUR_MINUTE52=null;
        Token DAY_MICROSECOND53=null;
        Token DAY_SECOND54=null;
        Token DAY_MINUTE55=null;
        Token DAY_HOUR56=null;
        Token YEAR_MONTH57=null;

        CommonTree SECOND36_tree=null;
        CommonTree MINUTE37_tree=null;
        CommonTree HOUR38_tree=null;
        CommonTree DAY_SYM39_tree=null;
        CommonTree WEEK40_tree=null;
        CommonTree MONTH41_tree=null;
        CommonTree QUARTER42_tree=null;
        CommonTree Y_43_tree=null;
        CommonTree E_44_tree=null;
        CommonTree A_45_tree=null;
        CommonTree R_46_tree=null;
        CommonTree SECOND_MICROSECOND47_tree=null;
        CommonTree MINUTE_MICROSECOND48_tree=null;
        CommonTree MINUTE_SECOND49_tree=null;
        CommonTree HOUR_MICROSECOND50_tree=null;
        CommonTree HOUR_SECOND51_tree=null;
        CommonTree HOUR_MINUTE52_tree=null;
        CommonTree DAY_MICROSECOND53_tree=null;
        CommonTree DAY_SECOND54_tree=null;
        CommonTree DAY_MINUTE55_tree=null;
        CommonTree DAY_HOUR56_tree=null;
        CommonTree YEAR_MONTH57_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 757) ) { return retval; }
            // MySQL.g:142:14: ( SECOND | MINUTE | HOUR | DAY_SYM | WEEK | MONTH | QUARTER | Y_ E_ A_ R_ | SECOND_MICROSECOND | MINUTE_MICROSECOND | MINUTE_SECOND | HOUR_MICROSECOND | HOUR_SECOND | HOUR_MINUTE | DAY_MICROSECOND | DAY_SECOND | DAY_MINUTE | DAY_HOUR | YEAR_MONTH )
            int alt9=19;
            switch ( input.LA(1) ) {
            case SECOND:
                {
                alt9=1;
                }
                break;
            case MINUTE:
                {
                alt9=2;
                }
                break;
            case HOUR:
                {
                alt9=3;
                }
                break;
            case DAY_SYM:
                {
                alt9=4;
                }
                break;
            case WEEK:
                {
                alt9=5;
                }
                break;
            case MONTH:
                {
                alt9=6;
                }
                break;
            case QUARTER:
                {
                alt9=7;
                }
                break;
            case Y_:
                {
                alt9=8;
                }
                break;
            case SECOND_MICROSECOND:
                {
                alt9=9;
                }
                break;
            case MINUTE_MICROSECOND:
                {
                alt9=10;
                }
                break;
            case MINUTE_SECOND:
                {
                alt9=11;
                }
                break;
            case HOUR_MICROSECOND:
                {
                alt9=12;
                }
                break;
            case HOUR_SECOND:
                {
                alt9=13;
                }
                break;
            case HOUR_MINUTE:
                {
                alt9=14;
                }
                break;
            case DAY_MICROSECOND:
                {
                alt9=15;
                }
                break;
            case DAY_SECOND:
                {
                alt9=16;
                }
                break;
            case DAY_MINUTE:
                {
                alt9=17;
                }
                break;
            case DAY_HOUR:
                {
                alt9=18;
                }
                break;
            case YEAR_MONTH:
                {
                alt9=19;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // MySQL.g:143:4: SECOND
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SECOND36=(Token)match(input,SECOND,FOLLOW_SECOND_in_interval_unit594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SECOND36_tree = (CommonTree)adaptor.create(SECOND36);
                    adaptor.addChild(root_0, SECOND36_tree);
                    }

                    }
                    break;
                case 2 :
                    // MySQL.g:144:4: MINUTE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    MINUTE37=(Token)match(input,MINUTE,FOLLOW_MINUTE_in_interval_unit599); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUTE37_tree = (CommonTree)adaptor.create(MINUTE37);
                    adaptor.addChild(root_0, MINUTE37_tree);
                    }

                    }
                    break;
                case 3 :
                    // MySQL.g:145:4: HOUR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    HOUR38=(Token)match(input,HOUR,FOLLOW_HOUR_in_interval_unit604); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HOUR38_tree = (CommonTree)adaptor.create(HOUR38);
                    adaptor.addChild(root_0, HOUR38_tree);
                    }

                    }
                    break;
                case 4 :
                    // MySQL.g:146:4: DAY_SYM
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DAY_SYM39=(Token)match(input,DAY_SYM,FOLLOW_DAY_SYM_in_interval_unit609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DAY_SYM39_tree = (CommonTree)adaptor.create(DAY_SYM39);
                    adaptor.addChild(root_0, DAY_SYM39_tree);
                    }

                    }
                    break;
                case 5 :
                    // MySQL.g:147:4: WEEK
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    WEEK40=(Token)match(input,WEEK,FOLLOW_WEEK_in_interval_unit614); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WEEK40_tree = (CommonTree)adaptor.create(WEEK40);
                    adaptor.addChild(root_0, WEEK40_tree);
                    }

                    }
                    break;
                case 6 :
                    // MySQL.g:148:4: MONTH
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    MONTH41=(Token)match(input,MONTH,FOLLOW_MONTH_in_interval_unit619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MONTH41_tree = (CommonTree)adaptor.create(MONTH41);
                    adaptor.addChild(root_0, MONTH41_tree);
                    }

                    }
                    break;
                case 7 :
                    // MySQL.g:149:4: QUARTER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    QUARTER42=(Token)match(input,QUARTER,FOLLOW_QUARTER_in_interval_unit624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUARTER42_tree = (CommonTree)adaptor.create(QUARTER42);
                    adaptor.addChild(root_0, QUARTER42_tree);
                    }

                    }
                    break;
                case 8 :
                    // MySQL.g:150:4: Y_ E_ A_ R_
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    Y_43=(Token)match(input,Y_,FOLLOW_Y__in_interval_unit629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Y_43_tree = (CommonTree)adaptor.create(Y_43);
                    adaptor.addChild(root_0, Y_43_tree);
                    }
                    E_44=(Token)match(input,E_,FOLLOW_E__in_interval_unit631); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    E_44_tree = (CommonTree)adaptor.create(E_44);
                    adaptor.addChild(root_0, E_44_tree);
                    }
                    A_45=(Token)match(input,A_,FOLLOW_A__in_interval_unit633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    A_45_tree = (CommonTree)adaptor.create(A_45);
                    adaptor.addChild(root_0, A_45_tree);
                    }
                    R_46=(Token)match(input,R_,FOLLOW_R__in_interval_unit635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    R_46_tree = (CommonTree)adaptor.create(R_46);
                    adaptor.addChild(root_0, R_46_tree);
                    }

                    }
                    break;
                case 9 :
                    // MySQL.g:151:4: SECOND_MICROSECOND
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SECOND_MICROSECOND47=(Token)match(input,SECOND_MICROSECOND,FOLLOW_SECOND_MICROSECOND_in_interval_unit640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SECOND_MICROSECOND47_tree = (CommonTree)adaptor.create(SECOND_MICROSECOND47);
                    adaptor.addChild(root_0, SECOND_MICROSECOND47_tree);
                    }

                    }
                    break;
                case 10 :
                    // MySQL.g:152:4: MINUTE_MICROSECOND
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    MINUTE_MICROSECOND48=(Token)match(input,MINUTE_MICROSECOND,FOLLOW_MINUTE_MICROSECOND_in_interval_unit645); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUTE_MICROSECOND48_tree = (CommonTree)adaptor.create(MINUTE_MICROSECOND48);
                    adaptor.addChild(root_0, MINUTE_MICROSECOND48_tree);
                    }

                    }
                    break;
                case 11 :
                    // MySQL.g:153:4: MINUTE_SECOND
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    MINUTE_SECOND49=(Token)match(input,MINUTE_SECOND,FOLLOW_MINUTE_SECOND_in_interval_unit650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUTE_SECOND49_tree = (CommonTree)adaptor.create(MINUTE_SECOND49);
                    adaptor.addChild(root_0, MINUTE_SECOND49_tree);
                    }

                    }
                    break;
                case 12 :
                    // MySQL.g:154:4: HOUR_MICROSECOND
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    HOUR_MICROSECOND50=(Token)match(input,HOUR_MICROSECOND,FOLLOW_HOUR_MICROSECOND_in_interval_unit655); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HOUR_MICROSECOND50_tree = (CommonTree)adaptor.create(HOUR_MICROSECOND50);
                    adaptor.addChild(root_0, HOUR_MICROSECOND50_tree);
                    }

                    }
                    break;
                case 13 :
                    // MySQL.g:155:4: HOUR_SECOND
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    HOUR_SECOND51=(Token)match(input,HOUR_SECOND,FOLLOW_HOUR_SECOND_in_interval_unit660); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HOUR_SECOND51_tree = (CommonTree)adaptor.create(HOUR_SECOND51);
                    adaptor.addChild(root_0, HOUR_SECOND51_tree);
                    }

                    }
                    break;
                case 14 :
                    // MySQL.g:156:4: HOUR_MINUTE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    HOUR_MINUTE52=(Token)match(input,HOUR_MINUTE,FOLLOW_HOUR_MINUTE_in_interval_unit665); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HOUR_MINUTE52_tree = (CommonTree)adaptor.create(HOUR_MINUTE52);
                    adaptor.addChild(root_0, HOUR_MINUTE52_tree);
                    }

                    }
                    break;
                case 15 :
                    // MySQL.g:157:4: DAY_MICROSECOND
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DAY_MICROSECOND53=(Token)match(input,DAY_MICROSECOND,FOLLOW_DAY_MICROSECOND_in_interval_unit670); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DAY_MICROSECOND53_tree = (CommonTree)adaptor.create(DAY_MICROSECOND53);
                    adaptor.addChild(root_0, DAY_MICROSECOND53_tree);
                    }

                    }
                    break;
                case 16 :
                    // MySQL.g:158:4: DAY_SECOND
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DAY_SECOND54=(Token)match(input,DAY_SECOND,FOLLOW_DAY_SECOND_in_interval_unit675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DAY_SECOND54_tree = (CommonTree)adaptor.create(DAY_SECOND54);
                    adaptor.addChild(root_0, DAY_SECOND54_tree);
                    }

                    }
                    break;
                case 17 :
                    // MySQL.g:159:4: DAY_MINUTE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DAY_MINUTE55=(Token)match(input,DAY_MINUTE,FOLLOW_DAY_MINUTE_in_interval_unit680); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DAY_MINUTE55_tree = (CommonTree)adaptor.create(DAY_MINUTE55);
                    adaptor.addChild(root_0, DAY_MINUTE55_tree);
                    }

                    }
                    break;
                case 18 :
                    // MySQL.g:160:4: DAY_HOUR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DAY_HOUR56=(Token)match(input,DAY_HOUR,FOLLOW_DAY_HOUR_in_interval_unit685); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DAY_HOUR56_tree = (CommonTree)adaptor.create(DAY_HOUR56);
                    adaptor.addChild(root_0, DAY_HOUR56_tree);
                    }

                    }
                    break;
                case 19 :
                    // MySQL.g:161:4: YEAR_MONTH
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    YEAR_MONTH57=(Token)match(input,YEAR_MONTH,FOLLOW_YEAR_MONTH_in_interval_unit690); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    YEAR_MONTH57_tree = (CommonTree)adaptor.create(YEAR_MONTH57);
                    adaptor.addChild(root_0, YEAR_MONTH57_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 757, interval_unit_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "interval_unit"

    public static class collation_names_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "collation_names"
    // MySQL.g:164:1: collation_names : ( LATIN1_GENERAL_CS | LATIN1_BIN );
    public final MySQLParser.collation_names_return collation_names() throws RecognitionException {
        MySQLParser.collation_names_return retval = new MySQLParser.collation_names_return();
        retval.start = input.LT(1);
        int collation_names_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set58=null;

        CommonTree set58_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 758) ) { return retval; }
            // MySQL.g:164:16: ( LATIN1_GENERAL_CS | LATIN1_BIN )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set58=(Token)input.LT(1);
            if ( (input.LA(1)>=LATIN1_BIN && input.LA(1)<=LATIN1_GENERAL_CS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set58));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 758, collation_names_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "collation_names"

    public static class string_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "string_literal"
    // MySQL.g:169:1: string_literal : ( TEXT_STRING | NULL_SYM );
    public final MySQLParser.string_literal_return string_literal() throws RecognitionException {
        MySQLParser.string_literal_return retval = new MySQLParser.string_literal_return();
        retval.start = input.LT(1);
        int string_literal_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set59=null;

        CommonTree set59_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 759) ) { return retval; }
            // MySQL.g:169:15: ( TEXT_STRING | NULL_SYM )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set59=(Token)input.LT(1);
            if ( input.LA(1)==NULL_SYM||input.LA(1)==TEXT_STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set59));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 759, string_literal_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "string_literal"

    public static class number_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "number_literal"
    // MySQL.g:170:1: number_literal : ( PLUS | MINUS )? ( INTEGER_NUM | REAL_NUMBER | NULL_SYM ) ;
    public final MySQLParser.number_literal_return number_literal() throws RecognitionException {
        MySQLParser.number_literal_return retval = new MySQLParser.number_literal_return();
        retval.start = input.LT(1);
        int number_literal_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set60=null;
        Token set61=null;

        CommonTree set60_tree=null;
        CommonTree set61_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 760) ) { return retval; }
            // MySQL.g:170:15: ( ( PLUS | MINUS )? ( INTEGER_NUM | REAL_NUMBER | NULL_SYM ) )
            // MySQL.g:170:18: ( PLUS | MINUS )? ( INTEGER_NUM | REAL_NUMBER | NULL_SYM )
            {
            root_0 = (CommonTree)adaptor.nil();

            // MySQL.g:170:18: ( PLUS | MINUS )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=PLUS && LA10_0<=MINUS)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // MySQL.g:
                    {
                    set60=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set60));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }

            set61=(Token)input.LT(1);
            if ( input.LA(1)==NULL_SYM||input.LA(1)==INTEGER_NUM||input.LA(1)==REAL_NUMBER ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set61));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 760, number_literal_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "number_literal"

    public static class hex_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hex_literal"
    // MySQL.g:171:1: hex_literal : ( HEX_DIGIT | NULL_SYM );
    public final MySQLParser.hex_literal_return hex_literal() throws RecognitionException {
        MySQLParser.hex_literal_return retval = new MySQLParser.hex_literal_return();
        retval.start = input.LT(1);
        int hex_literal_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set62=null;

        CommonTree set62_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 761) ) { return retval; }
            // MySQL.g:171:12: ( HEX_DIGIT | NULL_SYM )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set62=(Token)input.LT(1);
            if ( input.LA(1)==NULL_SYM||input.LA(1)==HEX_DIGIT ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set62));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 761, hex_literal_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "hex_literal"

    public static class boolean_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "boolean_literal"
    // MySQL.g:172:1: boolean_literal : ( TRUE_SYM | FALSE_SYM | NULL_SYM );
    public final MySQLParser.boolean_literal_return boolean_literal() throws RecognitionException {
        MySQLParser.boolean_literal_return retval = new MySQLParser.boolean_literal_return();
        retval.start = input.LT(1);
        int boolean_literal_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set63=null;

        CommonTree set63_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 762) ) { return retval; }
            // MySQL.g:172:16: ( TRUE_SYM | FALSE_SYM | NULL_SYM )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set63=(Token)input.LT(1);
            if ( input.LA(1)==FALSE_SYM||input.LA(1)==NULL_SYM||input.LA(1)==TRUE_SYM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set63));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 762, boolean_literal_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "boolean_literal"

    public static class bit_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bit_literal"
    // MySQL.g:173:1: bit_literal : ( BIT_NUM | NULL_SYM );
    public final MySQLParser.bit_literal_return bit_literal() throws RecognitionException {
        MySQLParser.bit_literal_return retval = new MySQLParser.bit_literal_return();
        retval.start = input.LT(1);
        int bit_literal_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set64=null;

        CommonTree set64_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 763) ) { return retval; }
            // MySQL.g:173:12: ( BIT_NUM | NULL_SYM )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set64=(Token)input.LT(1);
            if ( input.LA(1)==NULL_SYM||input.LA(1)==BIT_NUM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set64));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 763, bit_literal_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "bit_literal"

    public static class literal_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal_value"
    // MySQL.g:175:1: literal_value : ( string_literal | number_literal | hex_literal | boolean_literal | bit_literal | NULL_SYM ) ;
    public final MySQLParser.literal_value_return literal_value() throws RecognitionException {
        MySQLParser.literal_value_return retval = new MySQLParser.literal_value_return();
        retval.start = input.LT(1);
        int literal_value_StartIndex = input.index();
        CommonTree root_0 = null;

        Token NULL_SYM70=null;
        MySQLParser.string_literal_return string_literal65 = null;

        MySQLParser.number_literal_return number_literal66 = null;

        MySQLParser.hex_literal_return hex_literal67 = null;

        MySQLParser.boolean_literal_return boolean_literal68 = null;

        MySQLParser.bit_literal_return bit_literal69 = null;


        CommonTree NULL_SYM70_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 764) ) { return retval; }
            // MySQL.g:175:14: ( ( string_literal | number_literal | hex_literal | boolean_literal | bit_literal | NULL_SYM ) )
            // MySQL.g:176:9: ( string_literal | number_literal | hex_literal | boolean_literal | bit_literal | NULL_SYM )
            {
            root_0 = (CommonTree)adaptor.nil();

            // MySQL.g:176:9: ( string_literal | number_literal | hex_literal | boolean_literal | bit_literal | NULL_SYM )
            int alt11=6;
            switch ( input.LA(1) ) {
            case NULL_SYM:
                {
                int LA11_1 = input.LA(2);

                if ( (synpred86_MySQL()) ) {
                    alt11=1;
                }
                else if ( (synpred87_MySQL()) ) {
                    alt11=2;
                }
                else if ( (synpred88_MySQL()) ) {
                    alt11=3;
                }
                else if ( (synpred89_MySQL()) ) {
                    alt11=4;
                }
                else if ( (synpred90_MySQL()) ) {
                    alt11=5;
                }
                else if ( (true) ) {
                    alt11=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
                }
                break;
            case PLUS:
            case MINUS:
            case INTEGER_NUM:
            case REAL_NUMBER:
                {
                alt11=2;
                }
                break;
            case TEXT_STRING:
                {
                alt11=1;
                }
                break;
            case HEX_DIGIT:
                {
                alt11=3;
                }
                break;
            case FALSE_SYM:
            case TRUE_SYM:
                {
                alt11=4;
                }
                break;
            case BIT_NUM:
                {
                alt11=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // MySQL.g:176:11: string_literal
                    {
                    pushFollow(FOLLOW_string_literal_in_literal_value798);
                    string_literal65=string_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string_literal65.getTree());

                    }
                    break;
                case 2 :
                    // MySQL.g:176:28: number_literal
                    {
                    pushFollow(FOLLOW_number_literal_in_literal_value802);
                    number_literal66=number_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, number_literal66.getTree());

                    }
                    break;
                case 3 :
                    // MySQL.g:176:45: hex_literal
                    {
                    pushFollow(FOLLOW_hex_literal_in_literal_value806);
                    hex_literal67=hex_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hex_literal67.getTree());

                    }
                    break;
                case 4 :
                    // MySQL.g:176:59: boolean_literal
                    {
                    pushFollow(FOLLOW_boolean_literal_in_literal_value810);
                    boolean_literal68=boolean_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, boolean_literal68.getTree());

                    }
                    break;
                case 5 :
                    // MySQL.g:176:77: bit_literal
                    {
                    pushFollow(FOLLOW_bit_literal_in_literal_value814);
                    bit_literal69=bit_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_literal69.getTree());

                    }
                    break;
                case 6 :
                    // MySQL.g:176:91: NULL_SYM
                    {
                    NULL_SYM70=(Token)match(input,NULL_SYM,FOLLOW_NULL_SYM_in_literal_value818); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL_SYM70_tree = (CommonTree)adaptor.create(NULL_SYM70);
                    adaptor.addChild(root_0, NULL_SYM70_tree);
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 764, literal_value_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "literal_value"

    public static class functionList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionList"
    // MySQL.g:179:1: functionList : ( number_functions | char_functions | time_functions | other_functions );
    public final MySQLParser.functionList_return functionList() throws RecognitionException {
        MySQLParser.functionList_return retval = new MySQLParser.functionList_return();
        retval.start = input.LT(1);
        int functionList_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQLParser.number_functions_return number_functions71 = null;

        MySQLParser.char_functions_return char_functions72 = null;

        MySQLParser.time_functions_return time_functions73 = null;

        MySQLParser.other_functions_return other_functions74 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 765) ) { return retval; }
            // MySQL.g:179:13: ( number_functions | char_functions | time_functions | other_functions )
            int alt12=4;
            switch ( input.LA(1) ) {
            case ABS:
            case ACOS:
            case ASIN:
            case ATAN:
            case ATAN2:
            case CEIL:
            case CEILING:
            case CONV:
            case COS:
            case COT:
            case CRC32:
            case DEGREES:
            case EXP:
            case FLOOR:
            case LN:
            case LOG:
            case LOG10:
            case LOG2:
            case MOD:
            case PI:
            case POW:
            case POWER:
            case RADIANS:
            case RAND:
            case ROUND:
            case SIGN:
            case SIN:
            case SQRT:
            case TAN:
            case TRUNCATE:
                {
                alt12=1;
                }
                break;
            case LOAD_FILE:
            case MAKE_SET:
                {
                int LA12_2 = input.LA(2);

                if ( (synpred92_MySQL()) ) {
                    alt12=2;
                }
                else if ( (true) ) {
                    alt12=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
                }
                break;
            case ADDDATE:
            case ADDTIME:
            case CONVERT_TZ:
            case CURDATE:
            case CURTIME:
            case DATE_ADD:
            case DATE_FORMAT:
            case DATE_SUB:
            case DATE_SYM:
            case DATEDIFF:
            case DAY_SYM:
            case DAYNAME:
            case DAYOFMONTH:
            case DAYOFWEEK:
            case DAYOFYEAR:
            case FROM_DAYS:
            case FROM_UNIXTIME:
            case GET_FORMAT:
            case HOUR:
            case LAST_DAY:
            case MAKEDATE:
            case MAKETIME:
            case MICROSECOND:
            case MINUTE:
            case MONTH:
            case MONTHNAME:
            case NOW:
            case PERIOD_ADD:
            case PERIOD_DIFF:
            case QUARTER:
            case SEC_TO_TIME:
            case SECOND:
            case STR_TO_DATE:
            case SUBTIME:
            case SYSDATE:
            case TIME_FORMAT:
            case TIME_SYM:
            case TIME_TO_SEC:
            case TIMEDIFF:
            case TIMESTAMP:
            case TIMESTAMPADD:
            case TIMESTAMPDIFF:
            case TO_DAYS:
            case TO_SECONDS:
            case UNIX_TIMESTAMP:
            case UTC_DATE:
            case UTC_TIME:
            case UTC_TIMESTAMP:
            case WEEK:
            case WEEKDAY:
            case WEEKOFYEAR:
            case YEARWEEK:
                {
                alt12=3;
                }
                break;
            case ASCII_SYM:
            case BIN:
            case BIT_LENGTH:
            case CHAR:
            case CHAR_LENGTH:
            case CONCAT:
            case CONCAT_WS:
            case ELT:
            case EXPORT_SET:
            case FIELD:
            case FIND_IN_SET:
            case FORMAT:
            case FROM_BASE64:
            case HEX:
            case INSERT:
            case INSTR:
            case LEFT:
            case LENGTH:
            case LOCATE:
            case LOWER:
            case LPAD:
            case LTRIM:
            case MID:
            case OCT:
            case ORD:
            case QUOTE:
            case REPEAT:
            case REPLACE:
            case REVERSE:
            case RIGHT:
            case RPAD:
            case RTRIM:
            case SOUNDEX:
            case SPACE:
            case STRCMP:
            case SUBSTRING:
            case SUBSTRING_INDEX:
            case TO_BASE64:
            case TRIM:
            case UNHEX:
            case UPPER:
            case WEIGHT_STRING:
                {
                alt12=2;
                }
                break;
            case AES_DECRYPT:
            case AES_ENCRYPT:
            case BENCHMARK:
            case CHARSET:
            case COERCIBILITY:
            case COLLATION:
            case CONNECTION_ID:
            case CURRENT_USER:
            case DATABASE:
            case DECODE:
            case DEFAULT:
            case DES_DECRYPT:
            case DES_ENCRYPT:
            case ENCODE:
            case ENCRYPT:
            case FOUND_ROWS:
            case GET_LOCK:
            case IF:
            case IFNULL:
            case INET_ATON:
            case INET_NTOA:
            case IS_FREE_LOCK:
            case IS_USED_LOCK:
            case LAST_INSERT_ID:
            case MASTER_POS_WAIT:
            case MD5:
            case NAME_CONST:
            case OLD_PASSWORD:
            case PASSWORD:
            case RELEASE_LOCK:
            case SCHEMA:
            case SESSION_USER:
            case SLEEP:
            case SYSTEM_USER:
            case USER:
            case UUID:
            case VALUES:
            case VERSION_SYM:
                {
                alt12=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // MySQL.g:180:4: number_functions
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_number_functions_in_functionList834);
                    number_functions71=number_functions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, number_functions71.getTree());

                    }
                    break;
                case 2 :
                    // MySQL.g:181:4: char_functions
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_char_functions_in_functionList840);
                    char_functions72=char_functions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, char_functions72.getTree());

                    }
                    break;
                case 3 :
                    // MySQL.g:182:4: time_functions
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_time_functions_in_functionList846);
                    time_functions73=time_functions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, time_functions73.getTree());

                    }
                    break;
                case 4 :
                    // MySQL.g:183:4: other_functions
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_other_functions_in_functionList851);
                    other_functions74=other_functions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, other_functions74.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 765, functionList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "functionList"

    public static class special_functions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "special_functions"
    // MySQL.g:186:1: special_functions : ( EXTRACT LPAREN interval_unit FROM expression RPAREN | YEAR_FUNC expression RPAREN );
    public final MySQLParser.special_functions_return special_functions() throws RecognitionException {
        MySQLParser.special_functions_return retval = new MySQLParser.special_functions_return();
        retval.start = input.LT(1);
        int special_functions_StartIndex = input.index();
        CommonTree root_0 = null;

        Token EXTRACT75=null;
        Token LPAREN76=null;
        Token FROM78=null;
        Token RPAREN80=null;
        Token YEAR_FUNC81=null;
        Token RPAREN83=null;
        MySQLParser.interval_unit_return interval_unit77 = null;

        MySQLParser.expression_return expression79 = null;

        MySQLParser.expression_return expression82 = null;


        CommonTree EXTRACT75_tree=null;
        CommonTree LPAREN76_tree=null;
        CommonTree FROM78_tree=null;
        CommonTree RPAREN80_tree=null;
        CommonTree YEAR_FUNC81_tree=null;
        CommonTree RPAREN83_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 766) ) { return retval; }
            // MySQL.g:186:18: ( EXTRACT LPAREN interval_unit FROM expression RPAREN | YEAR_FUNC expression RPAREN )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==EXTRACT) ) {
                alt13=1;
            }
            else if ( (LA13_0==YEAR_FUNC) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // MySQL.g:187:2: EXTRACT LPAREN interval_unit FROM expression RPAREN
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    EXTRACT75=(Token)match(input,EXTRACT,FOLLOW_EXTRACT_in_special_functions860); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXTRACT75_tree = (CommonTree)adaptor.create(EXTRACT75);
                    adaptor.addChild(root_0, EXTRACT75_tree);
                    }
                    LPAREN76=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_special_functions862); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN76_tree = (CommonTree)adaptor.create(LPAREN76);
                    adaptor.addChild(root_0, LPAREN76_tree);
                    }
                    pushFollow(FOLLOW_interval_unit_in_special_functions864);
                    interval_unit77=interval_unit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, interval_unit77.getTree());
                    FROM78=(Token)match(input,FROM,FOLLOW_FROM_in_special_functions866); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FROM78_tree = (CommonTree)adaptor.create(FROM78);
                    adaptor.addChild(root_0, FROM78_tree);
                    }
                    pushFollow(FOLLOW_expression_in_special_functions868);
                    expression79=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression79.getTree());
                    RPAREN80=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_special_functions870); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN80_tree = (CommonTree)adaptor.create(RPAREN80);
                    adaptor.addChild(root_0, RPAREN80_tree);
                    }

                    }
                    break;
                case 2 :
                    // MySQL.g:188:4: YEAR_FUNC expression RPAREN
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    YEAR_FUNC81=(Token)match(input,YEAR_FUNC,FOLLOW_YEAR_FUNC_in_special_functions875); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    YEAR_FUNC81_tree = (CommonTree)adaptor.create(YEAR_FUNC81);
                    adaptor.addChild(root_0, YEAR_FUNC81_tree);
                    }
                    pushFollow(FOLLOW_expression_in_special_functions877);
                    expression82=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression82.getTree());
                    RPAREN83=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_special_functions879); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN83_tree = (CommonTree)adaptor.create(RPAREN83);
                    adaptor.addChild(root_0, RPAREN83_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 766, special_functions_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "special_functions"

    public static class number_functions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "number_functions"
    // MySQL.g:191:1: number_functions : ( ABS | ACOS | ASIN | ATAN2 | ATAN | CEIL | CEILING | CONV | COS | COT | CRC32 | DEGREES | EXP | FLOOR | LN | LOG10 | LOG2 | LOG | MOD | PI | POW | POWER | RADIANS | RAND | ROUND | SIGN | SIN | SQRT | TAN | TRUNCATE );
    public final MySQLParser.number_functions_return number_functions() throws RecognitionException {
        MySQLParser.number_functions_return retval = new MySQLParser.number_functions_return();
        retval.start = input.LT(1);
        int number_functions_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set84=null;

        CommonTree set84_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 767) ) { return retval; }
            // MySQL.g:191:17: ( ABS | ACOS | ASIN | ATAN2 | ATAN | CEIL | CEILING | CONV | COS | COT | CRC32 | DEGREES | EXP | FLOOR | LN | LOG10 | LOG2 | LOG | MOD | PI | POW | POWER | RADIANS | RAND | ROUND | SIGN | SIN | SQRT | TAN | TRUNCATE )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set84=(Token)input.LT(1);
            if ( (input.LA(1)>=ABS && input.LA(1)<=ACOS)||input.LA(1)==ASIN||(input.LA(1)>=ATAN && input.LA(1)<=ATAN2)||(input.LA(1)>=CEIL && input.LA(1)<=CEILING)||input.LA(1)==CONV||(input.LA(1)>=COS && input.LA(1)<=COT)||input.LA(1)==CRC32||input.LA(1)==DEGREES||input.LA(1)==EXP||input.LA(1)==FLOOR||input.LA(1)==LN||(input.LA(1)>=LOG && input.LA(1)<=LOG2)||input.LA(1)==MOD||input.LA(1)==PI||(input.LA(1)>=POW && input.LA(1)<=POWER)||(input.LA(1)>=RADIANS && input.LA(1)<=RAND)||input.LA(1)==ROUND||input.LA(1)==SIGN||input.LA(1)==SIN||input.LA(1)==SQRT||input.LA(1)==TAN||input.LA(1)==TRUNCATE ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set84));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 767, number_functions_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "number_functions"

    public static class char_functions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "char_functions"
    // MySQL.g:224:1: char_functions : ( ASCII_SYM | BIN | BIT_LENGTH | CHAR_LENGTH | CHAR | CONCAT_WS | CONCAT | ELT | EXPORT_SET | FIELD | FIND_IN_SET | FORMAT | FROM_BASE64 | HEX | INSERT | INSTR | LEFT | LENGTH | LOAD_FILE | LOCATE | LOWER | LPAD | LTRIM | MAKE_SET | MID | OCT | ORD | QUOTE | REPEAT | REPLACE | REVERSE | RIGHT | RPAD | RTRIM | SOUNDEX | SPACE | STRCMP | SUBSTRING_INDEX | SUBSTRING | TO_BASE64 | TRIM | UNHEX | UPPER | WEIGHT_STRING );
    public final MySQLParser.char_functions_return char_functions() throws RecognitionException {
        MySQLParser.char_functions_return retval = new MySQLParser.char_functions_return();
        retval.start = input.LT(1);
        int char_functions_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set85=null;

        CommonTree set85_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 768) ) { return retval; }
            // MySQL.g:224:15: ( ASCII_SYM | BIN | BIT_LENGTH | CHAR_LENGTH | CHAR | CONCAT_WS | CONCAT | ELT | EXPORT_SET | FIELD | FIND_IN_SET | FORMAT | FROM_BASE64 | HEX | INSERT | INSTR | LEFT | LENGTH | LOAD_FILE | LOCATE | LOWER | LPAD | LTRIM | MAKE_SET | MID | OCT | ORD | QUOTE | REPEAT | REPLACE | REVERSE | RIGHT | RPAD | RTRIM | SOUNDEX | SPACE | STRCMP | SUBSTRING_INDEX | SUBSTRING | TO_BASE64 | TRIM | UNHEX | UPPER | WEIGHT_STRING )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set85=(Token)input.LT(1);
            if ( input.LA(1)==ASCII_SYM||input.LA(1)==BIN||input.LA(1)==BIT_LENGTH||(input.LA(1)>=CHAR && input.LA(1)<=CHAR_LENGTH)||(input.LA(1)>=CONCAT && input.LA(1)<=CONCAT_WS)||input.LA(1)==ELT||input.LA(1)==EXPORT_SET||input.LA(1)==FIELD||input.LA(1)==FIND_IN_SET||input.LA(1)==FORMAT||input.LA(1)==FROM_BASE64||input.LA(1)==HEX||input.LA(1)==INSERT||input.LA(1)==INSTR||(input.LA(1)>=LEFT && input.LA(1)<=LENGTH)||input.LA(1)==LOAD_FILE||input.LA(1)==LOCATE||(input.LA(1)>=LOWER && input.LA(1)<=LTRIM)||input.LA(1)==MAKE_SET||input.LA(1)==MID||input.LA(1)==OCT||input.LA(1)==ORD||input.LA(1)==QUOTE||(input.LA(1)>=REPEAT && input.LA(1)<=REPLACE)||(input.LA(1)>=REVERSE && input.LA(1)<=RIGHT)||(input.LA(1)>=RPAD && input.LA(1)<=RTRIM)||input.LA(1)==SOUNDEX||input.LA(1)==SPACE||input.LA(1)==STRCMP||(input.LA(1)>=SUBSTRING && input.LA(1)<=SUBSTRING_INDEX)||input.LA(1)==TO_BASE64||input.LA(1)==TRIM||input.LA(1)==UNHEX||input.LA(1)==UPPER||input.LA(1)==WEIGHT_STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set85));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 768, char_functions_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "char_functions"

    public static class time_functions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "time_functions"
    // MySQL.g:271:1: time_functions : ( ADDDATE | ADDTIME | CONVERT_TZ | CURDATE | CURTIME | DATE_ADD | DATE_FORMAT | DATE_SUB | DATE_SYM | DATEDIFF | DAYNAME | DAYOFMONTH | DAYOFWEEK | DAYOFYEAR | DAY_SYM | FROM_DAYS | FROM_UNIXTIME | GET_FORMAT | HOUR | LAST_DAY | MAKEDATE | MAKETIME | MICROSECOND | MINUTE | MONTH | MONTHNAME | NOW | PERIOD_ADD | PERIOD_DIFF | QUARTER | SEC_TO_TIME | SECOND | STR_TO_DATE | SUBTIME | SYSDATE | TIME_FORMAT | TIME_TO_SEC | TIME_SYM | TIMEDIFF | TIMESTAMP | TIMESTAMPADD | TIMESTAMPDIFF | TO_DAYS | TO_SECONDS | UNIX_TIMESTAMP | UTC_DATE | UTC_TIME | UTC_TIMESTAMP | WEEK | WEEKDAY | WEEKOFYEAR | YEARWEEK );
    public final MySQLParser.time_functions_return time_functions() throws RecognitionException {
        MySQLParser.time_functions_return retval = new MySQLParser.time_functions_return();
        retval.start = input.LT(1);
        int time_functions_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set86=null;

        CommonTree set86_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 769) ) { return retval; }
            // MySQL.g:271:15: ( ADDDATE | ADDTIME | CONVERT_TZ | CURDATE | CURTIME | DATE_ADD | DATE_FORMAT | DATE_SUB | DATE_SYM | DATEDIFF | DAYNAME | DAYOFMONTH | DAYOFWEEK | DAYOFYEAR | DAY_SYM | FROM_DAYS | FROM_UNIXTIME | GET_FORMAT | HOUR | LAST_DAY | MAKEDATE | MAKETIME | MICROSECOND | MINUTE | MONTH | MONTHNAME | NOW | PERIOD_ADD | PERIOD_DIFF | QUARTER | SEC_TO_TIME | SECOND | STR_TO_DATE | SUBTIME | SYSDATE | TIME_FORMAT | TIME_TO_SEC | TIME_SYM | TIMEDIFF | TIMESTAMP | TIMESTAMPADD | TIMESTAMPDIFF | TO_DAYS | TO_SECONDS | UNIX_TIMESTAMP | UTC_DATE | UTC_TIME | UTC_TIMESTAMP | WEEK | WEEKDAY | WEEKOFYEAR | YEARWEEK )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set86=(Token)input.LT(1);
            if ( (input.LA(1)>=ADDDATE && input.LA(1)<=ADDTIME)||input.LA(1)==CONVERT_TZ||input.LA(1)==CURDATE||input.LA(1)==CURTIME||(input.LA(1)>=DATE_ADD && input.LA(1)<=DATEDIFF)||input.LA(1)==DAY_SYM||(input.LA(1)>=DAYNAME && input.LA(1)<=DAYOFYEAR)||(input.LA(1)>=FROM_DAYS && input.LA(1)<=FROM_UNIXTIME)||input.LA(1)==GET_FORMAT||input.LA(1)==HOUR||input.LA(1)==LAST_DAY||(input.LA(1)>=MAKEDATE && input.LA(1)<=MAKETIME)||input.LA(1)==MICROSECOND||input.LA(1)==MINUTE||(input.LA(1)>=MONTH && input.LA(1)<=MONTHNAME)||input.LA(1)==NOW||(input.LA(1)>=PERIOD_ADD && input.LA(1)<=PERIOD_DIFF)||input.LA(1)==QUARTER||(input.LA(1)>=SEC_TO_TIME && input.LA(1)<=SECOND)||input.LA(1)==STR_TO_DATE||input.LA(1)==SUBTIME||input.LA(1)==SYSDATE||(input.LA(1)>=TIME_FORMAT && input.LA(1)<=TIMESTAMPDIFF)||(input.LA(1)>=TO_DAYS && input.LA(1)<=TO_SECONDS)||input.LA(1)==UNIX_TIMESTAMP||(input.LA(1)>=UTC_DATE && input.LA(1)<=UTC_TIMESTAMP)||(input.LA(1)>=WEEK && input.LA(1)<=WEEKOFYEAR)||input.LA(1)==YEARWEEK ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set86));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 769, time_functions_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "time_functions"

    public static class other_functions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "other_functions"
    // MySQL.g:326:1: other_functions : ( MAKE_SET | LOAD_FILE | IF | IFNULL | AES_ENCRYPT | AES_DECRYPT | DECODE | ENCODE | DES_DECRYPT | DES_ENCRYPT | ENCRYPT | MD5 | OLD_PASSWORD | PASSWORD | BENCHMARK | CHARSET | COERCIBILITY | COLLATION | CONNECTION_ID | CURRENT_USER | DATABASE | SCHEMA | USER | SESSION_USER | SYSTEM_USER | VERSION_SYM | FOUND_ROWS | LAST_INSERT_ID | DEFAULT | GET_LOCK | RELEASE_LOCK | IS_FREE_LOCK | IS_USED_LOCK | MASTER_POS_WAIT | INET_ATON | INET_NTOA | NAME_CONST | SLEEP | UUID | VALUES );
    public final MySQLParser.other_functions_return other_functions() throws RecognitionException {
        MySQLParser.other_functions_return retval = new MySQLParser.other_functions_return();
        retval.start = input.LT(1);
        int other_functions_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set87=null;

        CommonTree set87_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 770) ) { return retval; }
            // MySQL.g:326:16: ( MAKE_SET | LOAD_FILE | IF | IFNULL | AES_ENCRYPT | AES_DECRYPT | DECODE | ENCODE | DES_DECRYPT | DES_ENCRYPT | ENCRYPT | MD5 | OLD_PASSWORD | PASSWORD | BENCHMARK | CHARSET | COERCIBILITY | COLLATION | CONNECTION_ID | CURRENT_USER | DATABASE | SCHEMA | USER | SESSION_USER | SYSTEM_USER | VERSION_SYM | FOUND_ROWS | LAST_INSERT_ID | DEFAULT | GET_LOCK | RELEASE_LOCK | IS_FREE_LOCK | IS_USED_LOCK | MASTER_POS_WAIT | INET_ATON | INET_NTOA | NAME_CONST | SLEEP | UUID | VALUES )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set87=(Token)input.LT(1);
            if ( (input.LA(1)>=AES_DECRYPT && input.LA(1)<=AES_ENCRYPT)||input.LA(1)==BENCHMARK||input.LA(1)==CHARSET||input.LA(1)==COERCIBILITY||input.LA(1)==COLLATION||input.LA(1)==CONNECTION_ID||input.LA(1)==CURRENT_USER||input.LA(1)==DATABASE||(input.LA(1)>=DECODE && input.LA(1)<=DEFAULT)||(input.LA(1)>=DES_DECRYPT && input.LA(1)<=DES_ENCRYPT)||(input.LA(1)>=ENCODE && input.LA(1)<=ENCRYPT)||input.LA(1)==FOUND_ROWS||input.LA(1)==GET_LOCK||(input.LA(1)>=IF && input.LA(1)<=IFNULL)||(input.LA(1)>=INET_ATON && input.LA(1)<=INET_NTOA)||input.LA(1)==IS_FREE_LOCK||input.LA(1)==IS_USED_LOCK||input.LA(1)==LAST_INSERT_ID||input.LA(1)==LOAD_FILE||input.LA(1)==MAKE_SET||input.LA(1)==MASTER_POS_WAIT||input.LA(1)==MD5||input.LA(1)==NAME_CONST||input.LA(1)==OLD_PASSWORD||input.LA(1)==PASSWORD||input.LA(1)==RELEASE_LOCK||input.LA(1)==SCHEMA||input.LA(1)==SESSION_USER||input.LA(1)==SLEEP||input.LA(1)==SYSTEM_USER||input.LA(1)==USER||input.LA(1)==UUID||input.LA(1)==VALUES||input.LA(1)==VERSION_SYM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set87));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 770, other_functions_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "other_functions"

    public static class group_functions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "group_functions"
    // MySQL.g:346:1: group_functions : ( AVG | COUNT | MAX_SYM | MIN_SYM | SUM | BIT_AND | BIT_OR | BIT_XOR | GROUP_CONCAT | STD | STDDEV | STDDEV_POP | STDDEV_SAMP | VAR_POP | VAR_SAMP | VARIANCE );
    public final MySQLParser.group_functions_return group_functions() throws RecognitionException {
        MySQLParser.group_functions_return retval = new MySQLParser.group_functions_return();
        retval.start = input.LT(1);
        int group_functions_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set88=null;

        CommonTree set88_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 771) ) { return retval; }
            // MySQL.g:346:16: ( AVG | COUNT | MAX_SYM | MIN_SYM | SUM | BIT_AND | BIT_OR | BIT_XOR | GROUP_CONCAT | STD | STDDEV | STDDEV_POP | STDDEV_SAMP | VAR_POP | VAR_SAMP | VARIANCE )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set88=(Token)input.LT(1);
            if ( input.LA(1)==AVG||input.LA(1)==BIT_AND||input.LA(1)==BIT_OR||input.LA(1)==BIT_XOR||input.LA(1)==COUNT||input.LA(1)==GROUP_CONCAT||input.LA(1)==MAX_SYM||input.LA(1)==MIN_SYM||(input.LA(1)>=STD && input.LA(1)<=STDDEV_SAMP)||input.LA(1)==SUM||(input.LA(1)>=VAR_POP && input.LA(1)<=VAR_SAMP)||input.LA(1)==VARIANCE ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set88));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 771, group_functions_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "group_functions"

    public static class schema_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schema_name"
    // MySQL.g:355:1: schema_name : tmpName= ID ;
    public final MySQLParser.schema_name_return schema_name() throws RecognitionException {
        MySQLParser.schema_name_return retval = new MySQLParser.schema_name_return();
        retval.start = input.LT(1);
        int schema_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 772) ) { return retval; }
            // MySQL.g:355:15: (tmpName= ID )
            // MySQL.g:355:17: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_schema_name1798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 772, schema_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "schema_name"

    public static class table_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table_name"
    // MySQL.g:356:1: table_name : tmpName= ID ;
    public final MySQLParser.table_name_return table_name() throws RecognitionException {
        MySQLParser.table_name_return retval = new MySQLParser.table_name_return();
        retval.start = input.LT(1);
        int table_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 773) ) { return retval; }
            // MySQL.g:356:14: (tmpName= ID )
            // MySQL.g:356:16: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_table_name1810); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 773, table_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "table_name"

    public static class engine_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "engine_name"
    // MySQL.g:357:1: engine_name : tmpName= ID ;
    public final MySQLParser.engine_name_return engine_name() throws RecognitionException {
        MySQLParser.engine_name_return retval = new MySQLParser.engine_name_return();
        retval.start = input.LT(1);
        int engine_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 774) ) { return retval; }
            // MySQL.g:357:15: (tmpName= ID )
            // MySQL.g:357:17: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_engine_name1822); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 774, engine_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "engine_name"

    public static class column_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "column_name"
    // MySQL.g:358:1: column_name : tmpName= ID ;
    public final MySQLParser.column_name_return column_name() throws RecognitionException {
        MySQLParser.column_name_return retval = new MySQLParser.column_name_return();
        retval.start = input.LT(1);
        int column_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 775) ) { return retval; }
            // MySQL.g:358:15: (tmpName= ID )
            // MySQL.g:358:17: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_column_name1834); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 775, column_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "column_name"

    public static class view_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "view_name"
    // MySQL.g:359:1: view_name : tmpName= ID ;
    public final MySQLParser.view_name_return view_name() throws RecognitionException {
        MySQLParser.view_name_return retval = new MySQLParser.view_name_return();
        retval.start = input.LT(1);
        int view_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 776) ) { return retval; }
            // MySQL.g:359:13: (tmpName= ID )
            // MySQL.g:359:15: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_view_name1846); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 776, view_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "view_name"

    public static class parser_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parser_name"
    // MySQL.g:360:1: parser_name : tmpName= ID ;
    public final MySQLParser.parser_name_return parser_name() throws RecognitionException {
        MySQLParser.parser_name_return retval = new MySQLParser.parser_name_return();
        retval.start = input.LT(1);
        int parser_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 777) ) { return retval; }
            // MySQL.g:360:15: (tmpName= ID )
            // MySQL.g:360:17: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_parser_name1858); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 777, parser_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "parser_name"

    public static class index_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "index_name"
    // MySQL.g:361:1: index_name : tmpName= ID ;
    public final MySQLParser.index_name_return index_name() throws RecognitionException {
        MySQLParser.index_name_return retval = new MySQLParser.index_name_return();
        retval.start = input.LT(1);
        int index_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 778) ) { return retval; }
            // MySQL.g:361:14: (tmpName= ID )
            // MySQL.g:361:16: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_index_name1870); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 778, index_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "index_name"

    public static class partition_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "partition_name"
    // MySQL.g:362:1: partition_name : tmpName= ID ;
    public final MySQLParser.partition_name_return partition_name() throws RecognitionException {
        MySQLParser.partition_name_return retval = new MySQLParser.partition_name_return();
        retval.start = input.LT(1);
        int partition_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 779) ) { return retval; }
            // MySQL.g:362:18: (tmpName= ID )
            // MySQL.g:362:20: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_partition_name1882); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 779, partition_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "partition_name"

    public static class partition_logical_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "partition_logical_name"
    // MySQL.g:363:1: partition_logical_name : tmpName= ID ;
    public final MySQLParser.partition_logical_name_return partition_logical_name() throws RecognitionException {
        MySQLParser.partition_logical_name_return retval = new MySQLParser.partition_logical_name_return();
        retval.start = input.LT(1);
        int partition_logical_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 780) ) { return retval; }
            // MySQL.g:363:25: (tmpName= ID )
            // MySQL.g:363:27: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_partition_logical_name1893); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 780, partition_logical_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "partition_logical_name"

    public static class constraint_symbol_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constraint_symbol_name"
    // MySQL.g:364:1: constraint_symbol_name : tmpName= ID ;
    public final MySQLParser.constraint_symbol_name_return constraint_symbol_name() throws RecognitionException {
        MySQLParser.constraint_symbol_name_return retval = new MySQLParser.constraint_symbol_name_return();
        retval.start = input.LT(1);
        int constraint_symbol_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 781) ) { return retval; }
            // MySQL.g:364:25: (tmpName= ID )
            // MySQL.g:364:27: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_constraint_symbol_name1904); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 781, constraint_symbol_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "constraint_symbol_name"

    public static class foreign_key_symbol_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "foreign_key_symbol_name"
    // MySQL.g:365:1: foreign_key_symbol_name : tmpName= ID ;
    public final MySQLParser.foreign_key_symbol_name_return foreign_key_symbol_name() throws RecognitionException {
        MySQLParser.foreign_key_symbol_name_return retval = new MySQLParser.foreign_key_symbol_name_return();
        retval.start = input.LT(1);
        int foreign_key_symbol_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 782) ) { return retval; }
            // MySQL.g:365:26: (tmpName= ID )
            // MySQL.g:365:28: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_foreign_key_symbol_name1915); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 782, foreign_key_symbol_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "foreign_key_symbol_name"

    public static class collation_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "collation_name"
    // MySQL.g:366:1: collation_name : tmpName= ID ;
    public final MySQLParser.collation_name_return collation_name() throws RecognitionException {
        MySQLParser.collation_name_return retval = new MySQLParser.collation_name_return();
        retval.start = input.LT(1);
        int collation_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 783) ) { return retval; }
            // MySQL.g:366:18: (tmpName= ID )
            // MySQL.g:366:20: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_collation_name1927); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 783, collation_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "collation_name"

    public static class event_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "event_name"
    // MySQL.g:367:1: event_name : tmpName= ID ;
    public final MySQLParser.event_name_return event_name() throws RecognitionException {
        MySQLParser.event_name_return retval = new MySQLParser.event_name_return();
        retval.start = input.LT(1);
        int event_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 784) ) { return retval; }
            // MySQL.g:367:14: (tmpName= ID )
            // MySQL.g:367:16: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_event_name1939); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 784, event_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "event_name"

    public static class user_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "user_name"
    // MySQL.g:368:1: user_name : tmpName= ID ;
    public final MySQLParser.user_name_return user_name() throws RecognitionException {
        MySQLParser.user_name_return retval = new MySQLParser.user_name_return();
        retval.start = input.LT(1);
        int user_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 785) ) { return retval; }
            // MySQL.g:368:13: (tmpName= ID )
            // MySQL.g:368:15: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_user_name1951); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 785, user_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "user_name"

    public static class function_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_name"
    // MySQL.g:369:1: function_name : tmpName= ID ;
    public final MySQLParser.function_name_return function_name() throws RecognitionException {
        MySQLParser.function_name_return retval = new MySQLParser.function_name_return();
        retval.start = input.LT(1);
        int function_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 786) ) { return retval; }
            // MySQL.g:369:17: (tmpName= ID )
            // MySQL.g:369:19: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_function_name1963); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 786, function_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "function_name"

    public static class procedure_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "procedure_name"
    // MySQL.g:370:1: procedure_name : tmpName= ID ;
    public final MySQLParser.procedure_name_return procedure_name() throws RecognitionException {
        MySQLParser.procedure_name_return retval = new MySQLParser.procedure_name_return();
        retval.start = input.LT(1);
        int procedure_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 787) ) { return retval; }
            // MySQL.g:370:18: (tmpName= ID )
            // MySQL.g:370:20: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_procedure_name1975); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 787, procedure_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "procedure_name"

    public static class server_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "server_name"
    // MySQL.g:371:1: server_name : tmpName= ID ;
    public final MySQLParser.server_name_return server_name() throws RecognitionException {
        MySQLParser.server_name_return retval = new MySQLParser.server_name_return();
        retval.start = input.LT(1);
        int server_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 788) ) { return retval; }
            // MySQL.g:371:15: (tmpName= ID )
            // MySQL.g:371:17: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_server_name1987); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 788, server_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "server_name"

    public static class wrapper_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "wrapper_name"
    // MySQL.g:372:1: wrapper_name : tmpName= ID ;
    public final MySQLParser.wrapper_name_return wrapper_name() throws RecognitionException {
        MySQLParser.wrapper_name_return retval = new MySQLParser.wrapper_name_return();
        retval.start = input.LT(1);
        int wrapper_name_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;

        CommonTree tmpName_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 789) ) { return retval; }
            // MySQL.g:372:16: (tmpName= ID )
            // MySQL.g:372:18: tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_wrapper_name1999); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 789, wrapper_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "wrapper_name"

    public static class alias_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alias"
    // MySQL.g:373:1: alias : ( AS_SYM )? tmpName= ID ;
    public final MySQLParser.alias_return alias() throws RecognitionException {
        MySQLParser.alias_return retval = new MySQLParser.alias_return();
        retval.start = input.LT(1);
        int alias_StartIndex = input.index();
        CommonTree root_0 = null;

        Token tmpName=null;
        Token AS_SYM89=null;

        CommonTree tmpName_tree=null;
        CommonTree AS_SYM89_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 790) ) { return retval; }
            // MySQL.g:373:10: ( ( AS_SYM )? tmpName= ID )
            // MySQL.g:373:12: ( AS_SYM )? tmpName= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            // MySQL.g:373:12: ( AS_SYM )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==AS_SYM) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // MySQL.g:373:14: AS_SYM
                    {
                    AS_SYM89=(Token)match(input,AS_SYM,FOLLOW_AS_SYM_in_alias2012); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS_SYM89_tree = (CommonTree)adaptor.create(AS_SYM89);
                    adaptor.addChild(root_0, AS_SYM89_tree);
                    }

                    }
                    break;

            }

            tmpName=(Token)match(input,ID,FOLLOW_ID_in_alias2019); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tmpName_tree = (CommonTree)adaptor.create(tmpName);
            adaptor.addChild(root_0, tmpName_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 790, alias_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alias"

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // MySQL.g:376:1: expression : exp_factor1 ( OR_SYM exp_factor1 )* ;
    public final MySQLParser.expression_return expression() throws RecognitionException {
        MySQLParser.expression_return retval = new MySQLParser.expression_return();
        retval.start = input.LT(1);
        int expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token OR_SYM91=null;
        MySQLParser.exp_factor1_return exp_factor190 = null;

        MySQLParser.exp_factor1_return exp_factor192 = null;


        CommonTree OR_SYM91_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 791) ) { return retval; }
            // MySQL.g:376:11: ( exp_factor1 ( OR_SYM exp_factor1 )* )
            // MySQL.g:376:13: exp_factor1 ( OR_SYM exp_factor1 )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_exp_factor1_in_expression2028);
            exp_factor190=exp_factor1();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exp_factor190.getTree());
            // MySQL.g:376:25: ( OR_SYM exp_factor1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==OR_SYM) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred273_MySQL()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // MySQL.g:376:27: OR_SYM exp_factor1
            	    {
            	    OR_SYM91=(Token)match(input,OR_SYM,FOLLOW_OR_SYM_in_expression2032); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR_SYM91_tree = (CommonTree)adaptor.create(OR_SYM91);
            	    adaptor.addChild(root_0, OR_SYM91_tree);
            	    }
            	    pushFollow(FOLLOW_exp_factor1_in_expression2034);
            	    exp_factor192=exp_factor1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exp_factor192.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 791, expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class exp_factor1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exp_factor1"
    // MySQL.g:377:1: exp_factor1 : exp_factor2 ( XOR exp_factor2 )* ;
    public final MySQLParser.exp_factor1_return exp_factor1() throws RecognitionException {
        MySQLParser.exp_factor1_return retval = new MySQLParser.exp_factor1_return();
        retval.start = input.LT(1);
        int exp_factor1_StartIndex = input.index();
        CommonTree root_0 = null;

        Token XOR94=null;
        MySQLParser.exp_factor2_return exp_factor293 = null;

        MySQLParser.exp_factor2_return exp_factor295 = null;


        CommonTree XOR94_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 792) ) { return retval; }
            // MySQL.g:377:12: ( exp_factor2 ( XOR exp_factor2 )* )
            // MySQL.g:377:14: exp_factor2 ( XOR exp_factor2 )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_exp_factor2_in_exp_factor12044);
            exp_factor293=exp_factor2();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exp_factor293.getTree());
            // MySQL.g:377:26: ( XOR exp_factor2 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==XOR) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred274_MySQL()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // MySQL.g:377:28: XOR exp_factor2
            	    {
            	    XOR94=(Token)match(input,XOR,FOLLOW_XOR_in_exp_factor12048); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    XOR94_tree = (CommonTree)adaptor.create(XOR94);
            	    adaptor.addChild(root_0, XOR94_tree);
            	    }
            	    pushFollow(FOLLOW_exp_factor2_in_exp_factor12050);
            	    exp_factor295=exp_factor2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exp_factor295.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 792, exp_factor1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "exp_factor1"

    public static class exp_factor2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exp_factor2"
    // MySQL.g:378:1: exp_factor2 : exp_factor3 ( AND_SYM exp_factor3 )* ;
    public final MySQLParser.exp_factor2_return exp_factor2() throws RecognitionException {
        MySQLParser.exp_factor2_return retval = new MySQLParser.exp_factor2_return();
        retval.start = input.LT(1);
        int exp_factor2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token AND_SYM97=null;
        MySQLParser.exp_factor3_return exp_factor396 = null;

        MySQLParser.exp_factor3_return exp_factor398 = null;


        CommonTree AND_SYM97_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 793) ) { return retval; }
            // MySQL.g:378:12: ( exp_factor3 ( AND_SYM exp_factor3 )* )
            // MySQL.g:378:14: exp_factor3 ( AND_SYM exp_factor3 )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_exp_factor3_in_exp_factor22060);
            exp_factor396=exp_factor3();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exp_factor396.getTree());
            // MySQL.g:378:26: ( AND_SYM exp_factor3 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==AND_SYM) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred275_MySQL()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // MySQL.g:378:28: AND_SYM exp_factor3
            	    {
            	    AND_SYM97=(Token)match(input,AND_SYM,FOLLOW_AND_SYM_in_exp_factor22064); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND_SYM97_tree = (CommonTree)adaptor.create(AND_SYM97);
            	    adaptor.addChild(root_0, AND_SYM97_tree);
            	    }
            	    pushFollow(FOLLOW_exp_factor3_in_exp_factor22066);
            	    exp_factor398=exp_factor3();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exp_factor398.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 793, exp_factor2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "exp_factor2"

    public static class exp_factor3_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exp_factor3"
    // MySQL.g:379:1: exp_factor3 : ( NOT_SYM )? exp_factor4 ;
    public final MySQLParser.exp_factor3_return exp_factor3() throws RecognitionException {
        MySQLParser.exp_factor3_return retval = new MySQLParser.exp_factor3_return();
        retval.start = input.LT(1);
        int exp_factor3_StartIndex = input.index();
        CommonTree root_0 = null;

        Token NOT_SYM99=null;
        MySQLParser.exp_factor4_return exp_factor4100 = null;


        CommonTree NOT_SYM99_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 794) ) { return retval; }
            // MySQL.g:379:12: ( ( NOT_SYM )? exp_factor4 )
            // MySQL.g:379:14: ( NOT_SYM )? exp_factor4
            {
            root_0 = (CommonTree)adaptor.nil();

            // MySQL.g:379:14: ( NOT_SYM )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==NOT_SYM) ) {
                int LA18_1 = input.LA(2);

                if ( (synpred276_MySQL()) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // MySQL.g:379:15: NOT_SYM
                    {
                    NOT_SYM99=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_exp_factor32077); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT_SYM99_tree = (CommonTree)adaptor.create(NOT_SYM99);
                    adaptor.addChild(root_0, NOT_SYM99_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_exp_factor4_in_exp_factor32081);
            exp_factor4100=exp_factor4();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exp_factor4100.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 794, exp_factor3_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "exp_factor3"

    public static class exp_factor4_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exp_factor4"
    // MySQL.g:380:1: exp_factor4 : bool_primary ( IS_SYM ( NOT_SYM )? ( boolean_literal | NULL_SYM ) )? ;
    public final MySQLParser.exp_factor4_return exp_factor4() throws RecognitionException {
        MySQLParser.exp_factor4_return retval = new MySQLParser.exp_factor4_return();
        retval.start = input.LT(1);
        int exp_factor4_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IS_SYM102=null;
        Token NOT_SYM103=null;
        Token NULL_SYM105=null;
        MySQLParser.bool_primary_return bool_primary101 = null;

        MySQLParser.boolean_literal_return boolean_literal104 = null;


        CommonTree IS_SYM102_tree=null;
        CommonTree NOT_SYM103_tree=null;
        CommonTree NULL_SYM105_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 795) ) { return retval; }
            // MySQL.g:380:12: ( bool_primary ( IS_SYM ( NOT_SYM )? ( boolean_literal | NULL_SYM ) )? )
            // MySQL.g:380:14: bool_primary ( IS_SYM ( NOT_SYM )? ( boolean_literal | NULL_SYM ) )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_bool_primary_in_exp_factor42088);
            bool_primary101=bool_primary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bool_primary101.getTree());
            // MySQL.g:380:27: ( IS_SYM ( NOT_SYM )? ( boolean_literal | NULL_SYM ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==IS_SYM) ) {
                int LA21_1 = input.LA(2);

                if ( (synpred279_MySQL()) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // MySQL.g:380:29: IS_SYM ( NOT_SYM )? ( boolean_literal | NULL_SYM )
                    {
                    IS_SYM102=(Token)match(input,IS_SYM,FOLLOW_IS_SYM_in_exp_factor42092); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS_SYM102_tree = (CommonTree)adaptor.create(IS_SYM102);
                    adaptor.addChild(root_0, IS_SYM102_tree);
                    }
                    // MySQL.g:380:36: ( NOT_SYM )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==NOT_SYM) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // MySQL.g:380:37: NOT_SYM
                            {
                            NOT_SYM103=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_exp_factor42095); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT_SYM103_tree = (CommonTree)adaptor.create(NOT_SYM103);
                            adaptor.addChild(root_0, NOT_SYM103_tree);
                            }

                            }
                            break;

                    }

                    // MySQL.g:380:47: ( boolean_literal | NULL_SYM )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==NULL_SYM) ) {
                        int LA20_1 = input.LA(2);

                        if ( (synpred278_MySQL()) ) {
                            alt20=1;
                        }
                        else if ( (true) ) {
                            alt20=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 20, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA20_0==FALSE_SYM||LA20_0==TRUE_SYM) ) {
                        alt20=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // MySQL.g:380:48: boolean_literal
                            {
                            pushFollow(FOLLOW_boolean_literal_in_exp_factor42100);
                            boolean_literal104=boolean_literal();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, boolean_literal104.getTree());

                            }
                            break;
                        case 2 :
                            // MySQL.g:380:64: NULL_SYM
                            {
                            NULL_SYM105=(Token)match(input,NULL_SYM,FOLLOW_NULL_SYM_in_exp_factor42102); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NULL_SYM105_tree = (CommonTree)adaptor.create(NULL_SYM105);
                            adaptor.addChild(root_0, NULL_SYM105_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 795, exp_factor4_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "exp_factor4"

    public static class bool_primary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bool_primary"
    // MySQL.g:381:1: bool_primary : ( ( predicate relational_op predicate ) | ( predicate relational_op ( ALL | ANY )? subquery ) | ( ( NOT_SYM )? EXISTS subquery ) | predicate );
    public final MySQLParser.bool_primary_return bool_primary() throws RecognitionException {
        MySQLParser.bool_primary_return retval = new MySQLParser.bool_primary_return();
        retval.start = input.LT(1);
        int bool_primary_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set111=null;
        Token NOT_SYM113=null;
        Token EXISTS114=null;
        MySQLParser.predicate_return predicate106 = null;

        MySQLParser.relational_op_return relational_op107 = null;

        MySQLParser.predicate_return predicate108 = null;

        MySQLParser.predicate_return predicate109 = null;

        MySQLParser.relational_op_return relational_op110 = null;

        MySQLParser.subquery_return subquery112 = null;

        MySQLParser.subquery_return subquery115 = null;

        MySQLParser.predicate_return predicate116 = null;


        CommonTree set111_tree=null;
        CommonTree NOT_SYM113_tree=null;
        CommonTree EXISTS114_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 796) ) { return retval; }
            // MySQL.g:381:13: ( ( predicate relational_op predicate ) | ( predicate relational_op ( ALL | ANY )? subquery ) | ( ( NOT_SYM )? EXISTS subquery ) | predicate )
            int alt24=4;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // MySQL.g:382:4: ( predicate relational_op predicate )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:382:4: ( predicate relational_op predicate )
                    // MySQL.g:382:6: predicate relational_op predicate
                    {
                    pushFollow(FOLLOW_predicate_in_bool_primary2118);
                    predicate106=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate106.getTree());
                    pushFollow(FOLLOW_relational_op_in_bool_primary2120);
                    relational_op107=relational_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, relational_op107.getTree());
                    pushFollow(FOLLOW_predicate_in_bool_primary2122);
                    predicate108=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate108.getTree());

                    }


                    }
                    break;
                case 2 :
                    // MySQL.g:383:4: ( predicate relational_op ( ALL | ANY )? subquery )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:383:4: ( predicate relational_op ( ALL | ANY )? subquery )
                    // MySQL.g:383:6: predicate relational_op ( ALL | ANY )? subquery
                    {
                    pushFollow(FOLLOW_predicate_in_bool_primary2132);
                    predicate109=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate109.getTree());
                    pushFollow(FOLLOW_relational_op_in_bool_primary2134);
                    relational_op110=relational_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, relational_op110.getTree());
                    // MySQL.g:383:30: ( ALL | ANY )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==ALL||LA22_0==ANY) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // MySQL.g:
                            {
                            set111=(Token)input.LT(1);
                            if ( input.LA(1)==ALL||input.LA(1)==ANY ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set111));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    pushFollow(FOLLOW_subquery_in_bool_primary2147);
                    subquery112=subquery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subquery112.getTree());

                    }


                    }
                    break;
                case 3 :
                    // MySQL.g:384:4: ( ( NOT_SYM )? EXISTS subquery )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:384:4: ( ( NOT_SYM )? EXISTS subquery )
                    // MySQL.g:384:6: ( NOT_SYM )? EXISTS subquery
                    {
                    // MySQL.g:384:6: ( NOT_SYM )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==NOT_SYM) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // MySQL.g:0:0: NOT_SYM
                            {
                            NOT_SYM113=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_bool_primary2156); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT_SYM113_tree = (CommonTree)adaptor.create(NOT_SYM113);
                            adaptor.addChild(root_0, NOT_SYM113_tree);
                            }

                            }
                            break;

                    }

                    EXISTS114=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_bool_primary2159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXISTS114_tree = (CommonTree)adaptor.create(EXISTS114);
                    adaptor.addChild(root_0, EXISTS114_tree);
                    }
                    pushFollow(FOLLOW_subquery_in_bool_primary2161);
                    subquery115=subquery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subquery115.getTree());

                    }


                    }
                    break;
                case 4 :
                    // MySQL.g:385:4: predicate
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_predicate_in_bool_primary2168);
                    predicate116=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate116.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 796, bool_primary_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "bool_primary"

    public static class predicate_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // MySQL.g:387:1: predicate : ( ( bit_expr ( NOT_SYM )? IN_SYM ( subquery | expression_list ) ) | ( bit_expr ( NOT_SYM )? BETWEEN bit_expr AND_SYM predicate ) | ( bit_expr SOUNDS_SYM LIKE_SYM bit_expr ) | ( bit_expr ( NOT_SYM )? LIKE_SYM simple_expr ( ESCAPE_SYM simple_expr )? ) | ( bit_expr ( NOT_SYM )? REGEXP bit_expr ) | ( bit_expr ) );
    public final MySQLParser.predicate_return predicate() throws RecognitionException {
        MySQLParser.predicate_return retval = new MySQLParser.predicate_return();
        retval.start = input.LT(1);
        int predicate_StartIndex = input.index();
        CommonTree root_0 = null;

        Token NOT_SYM118=null;
        Token IN_SYM119=null;
        Token NOT_SYM123=null;
        Token BETWEEN124=null;
        Token AND_SYM126=null;
        Token SOUNDS_SYM129=null;
        Token LIKE_SYM130=null;
        Token NOT_SYM133=null;
        Token LIKE_SYM134=null;
        Token ESCAPE_SYM136=null;
        Token NOT_SYM139=null;
        Token REGEXP140=null;
        MySQLParser.bit_expr_return bit_expr117 = null;

        MySQLParser.subquery_return subquery120 = null;

        MySQLParser.expression_list_return expression_list121 = null;

        MySQLParser.bit_expr_return bit_expr122 = null;

        MySQLParser.bit_expr_return bit_expr125 = null;

        MySQLParser.predicate_return predicate127 = null;

        MySQLParser.bit_expr_return bit_expr128 = null;

        MySQLParser.bit_expr_return bit_expr131 = null;

        MySQLParser.bit_expr_return bit_expr132 = null;

        MySQLParser.simple_expr_return simple_expr135 = null;

        MySQLParser.simple_expr_return simple_expr137 = null;

        MySQLParser.bit_expr_return bit_expr138 = null;

        MySQLParser.bit_expr_return bit_expr141 = null;

        MySQLParser.bit_expr_return bit_expr142 = null;


        CommonTree NOT_SYM118_tree=null;
        CommonTree IN_SYM119_tree=null;
        CommonTree NOT_SYM123_tree=null;
        CommonTree BETWEEN124_tree=null;
        CommonTree AND_SYM126_tree=null;
        CommonTree SOUNDS_SYM129_tree=null;
        CommonTree LIKE_SYM130_tree=null;
        CommonTree NOT_SYM133_tree=null;
        CommonTree LIKE_SYM134_tree=null;
        CommonTree ESCAPE_SYM136_tree=null;
        CommonTree NOT_SYM139_tree=null;
        CommonTree REGEXP140_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 797) ) { return retval; }
            // MySQL.g:387:10: ( ( bit_expr ( NOT_SYM )? IN_SYM ( subquery | expression_list ) ) | ( bit_expr ( NOT_SYM )? BETWEEN bit_expr AND_SYM predicate ) | ( bit_expr SOUNDS_SYM LIKE_SYM bit_expr ) | ( bit_expr ( NOT_SYM )? LIKE_SYM simple_expr ( ESCAPE_SYM simple_expr )? ) | ( bit_expr ( NOT_SYM )? REGEXP bit_expr ) | ( bit_expr ) )
            int alt31=6;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // MySQL.g:388:4: ( bit_expr ( NOT_SYM )? IN_SYM ( subquery | expression_list ) )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:388:4: ( bit_expr ( NOT_SYM )? IN_SYM ( subquery | expression_list ) )
                    // MySQL.g:388:6: bit_expr ( NOT_SYM )? IN_SYM ( subquery | expression_list )
                    {
                    pushFollow(FOLLOW_bit_expr_in_predicate2181);
                    bit_expr117=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr117.getTree());
                    // MySQL.g:388:15: ( NOT_SYM )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==NOT_SYM) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // MySQL.g:388:16: NOT_SYM
                            {
                            NOT_SYM118=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_predicate2184); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT_SYM118_tree = (CommonTree)adaptor.create(NOT_SYM118);
                            adaptor.addChild(root_0, NOT_SYM118_tree);
                            }

                            }
                            break;

                    }

                    IN_SYM119=(Token)match(input,IN_SYM,FOLLOW_IN_SYM_in_predicate2188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN_SYM119_tree = (CommonTree)adaptor.create(IN_SYM119);
                    adaptor.addChild(root_0, IN_SYM119_tree);
                    }
                    // MySQL.g:388:33: ( subquery | expression_list )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==LPAREN) ) {
                        int LA26_1 = input.LA(2);

                        if ( ((LA26_1>=ABS && LA26_1<=ACOS)||(LA26_1>=ADDDATE && LA26_1<=AES_ENCRYPT)||(LA26_1>=ASCII_SYM && LA26_1<=ASIN)||(LA26_1>=ATAN && LA26_1<=ATAN2)||LA26_1==AVG||LA26_1==BENCHMARK||(LA26_1>=BIN && LA26_1<=BIT_OR)||LA26_1==BIT_XOR||(LA26_1>=CASE_SYM && LA26_1<=CEILING)||(LA26_1>=CHAR && LA26_1<=CHAR_LENGTH)||LA26_1==CHARSET||LA26_1==COERCIBILITY||LA26_1==COLLATION||(LA26_1>=CONCAT && LA26_1<=CONCAT_WS)||LA26_1==CONNECTION_ID||(LA26_1>=CONV && LA26_1<=CONVERT_TZ)||(LA26_1>=COS && LA26_1<=COUNT)||LA26_1==CRC32||LA26_1==CURDATE||(LA26_1>=CURRENT_USER && LA26_1<=DATABASE)||(LA26_1>=DATE_ADD && LA26_1<=DATEDIFF)||LA26_1==DAY_SYM||(LA26_1>=DAYNAME && LA26_1<=DAYOFYEAR)||(LA26_1>=DECODE && LA26_1<=DEFAULT)||LA26_1==DEGREES||(LA26_1>=DES_DECRYPT && LA26_1<=DES_ENCRYPT)||LA26_1==ELT||(LA26_1>=ENCODE && LA26_1<=ENCRYPT)||(LA26_1>=EXISTS && LA26_1<=EXP)||(LA26_1>=EXPORT_SET && LA26_1<=FALSE_SYM)||LA26_1==FIELD||LA26_1==FIND_IN_SET||LA26_1==FLOOR||(LA26_1>=FORMAT && LA26_1<=FOUND_ROWS)||(LA26_1>=FROM_BASE64 && LA26_1<=FROM_UNIXTIME)||(LA26_1>=GET_FORMAT && LA26_1<=GET_LOCK)||LA26_1==GROUP_CONCAT||LA26_1==HEX||LA26_1==HOUR||(LA26_1>=IF && LA26_1<=IFNULL)||(LA26_1>=INET_ATON && LA26_1<=INET_NTOA)||LA26_1==INSERT||LA26_1==INSTR||LA26_1==INTERVAL_SYM||LA26_1==IS_FREE_LOCK||LA26_1==IS_USED_LOCK||(LA26_1>=LAST_DAY && LA26_1<=LAST_INSERT_ID)||(LA26_1>=LEFT && LA26_1<=LENGTH)||LA26_1==LN||LA26_1==LOAD_FILE||LA26_1==LOCATE||(LA26_1>=LOG && LA26_1<=LOG2)||(LA26_1>=LOWER && LA26_1<=LTRIM)||(LA26_1>=MAKE_SET && LA26_1<=MAX_SYM)||LA26_1==MD5||(LA26_1>=MICROSECOND && LA26_1<=MIN_SYM)||LA26_1==MINUTE||LA26_1==MOD||(LA26_1>=MONTH && LA26_1<=NAME_CONST)||(LA26_1>=NOT_SYM && LA26_1<=NULL_SYM)||LA26_1==OCT||LA26_1==OLD_PASSWORD||LA26_1==ORD||(LA26_1>=PASSWORD && LA26_1<=PI)||(LA26_1>=POW && LA26_1<=POWER)||LA26_1==QUARTER||(LA26_1>=QUOTE && LA26_1<=RAND)||LA26_1==RELEASE_LOCK||(LA26_1>=REPEAT && LA26_1<=REPLACE)||(LA26_1>=REVERSE && LA26_1<=RIGHT)||LA26_1==ROUND||LA26_1==ROW_SYM||(LA26_1>=RPAD && LA26_1<=RTRIM)||(LA26_1>=SCHEMA && LA26_1<=SECOND)||LA26_1==SESSION_USER||LA26_1==SIGN||LA26_1==SIN||LA26_1==SLEEP||LA26_1==SOUNDEX||LA26_1==SPACE||LA26_1==SQRT||(LA26_1>=STD && LA26_1<=STDDEV_SAMP)||LA26_1==STR_TO_DATE||LA26_1==STRCMP||(LA26_1>=SUBSTRING && LA26_1<=SUM)||(LA26_1>=SYSDATE && LA26_1<=SYSTEM_USER)||LA26_1==TAN||(LA26_1>=TIME_FORMAT && LA26_1<=TIMESTAMPDIFF)||(LA26_1>=TO_BASE64 && LA26_1<=TO_SECONDS)||(LA26_1>=TRIM && LA26_1<=TRUNCATE)||LA26_1==UNHEX||LA26_1==UNIX_TIMESTAMP||LA26_1==UPPER||LA26_1==USER||(LA26_1>=UTC_DATE && LA26_1<=UTC_TIMESTAMP)||LA26_1==UUID||(LA26_1>=VALUES && LA26_1<=VAR_SAMP)||(LA26_1>=VARIANCE && LA26_1<=VERSION_SYM)||(LA26_1>=WEEK && LA26_1<=WEIGHT_STRING)||(LA26_1>=LPAREN && LA26_1<=YEAR_FUNC)||LA26_1==YEARWEEK||(LA26_1>=PLUS && LA26_1<=NEGATION)||LA26_1==INTEGER_NUM||(LA26_1>=HEX_DIGIT && LA26_1<=ID)||LA26_1==USER_VAR) ) {
                            alt26=2;
                        }
                        else if ( (LA26_1==SELECT) ) {
                            alt26=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 26, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // MySQL.g:388:34: subquery
                            {
                            pushFollow(FOLLOW_subquery_in_predicate2191);
                            subquery120=subquery();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, subquery120.getTree());

                            }
                            break;
                        case 2 :
                            // MySQL.g:388:45: expression_list
                            {
                            pushFollow(FOLLOW_expression_list_in_predicate2195);
                            expression_list121=expression_list();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_list121.getTree());

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // MySQL.g:389:4: ( bit_expr ( NOT_SYM )? BETWEEN bit_expr AND_SYM predicate )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:389:4: ( bit_expr ( NOT_SYM )? BETWEEN bit_expr AND_SYM predicate )
                    // MySQL.g:389:6: bit_expr ( NOT_SYM )? BETWEEN bit_expr AND_SYM predicate
                    {
                    pushFollow(FOLLOW_bit_expr_in_predicate2205);
                    bit_expr122=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr122.getTree());
                    // MySQL.g:389:15: ( NOT_SYM )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==NOT_SYM) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // MySQL.g:389:16: NOT_SYM
                            {
                            NOT_SYM123=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_predicate2208); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT_SYM123_tree = (CommonTree)adaptor.create(NOT_SYM123);
                            adaptor.addChild(root_0, NOT_SYM123_tree);
                            }

                            }
                            break;

                    }

                    BETWEEN124=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_predicate2212); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BETWEEN124_tree = (CommonTree)adaptor.create(BETWEEN124);
                    adaptor.addChild(root_0, BETWEEN124_tree);
                    }
                    pushFollow(FOLLOW_bit_expr_in_predicate2214);
                    bit_expr125=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr125.getTree());
                    AND_SYM126=(Token)match(input,AND_SYM,FOLLOW_AND_SYM_in_predicate2216); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND_SYM126_tree = (CommonTree)adaptor.create(AND_SYM126);
                    adaptor.addChild(root_0, AND_SYM126_tree);
                    }
                    pushFollow(FOLLOW_predicate_in_predicate2218);
                    predicate127=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate127.getTree());

                    }


                    }
                    break;
                case 3 :
                    // MySQL.g:390:4: ( bit_expr SOUNDS_SYM LIKE_SYM bit_expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:390:4: ( bit_expr SOUNDS_SYM LIKE_SYM bit_expr )
                    // MySQL.g:390:6: bit_expr SOUNDS_SYM LIKE_SYM bit_expr
                    {
                    pushFollow(FOLLOW_bit_expr_in_predicate2228);
                    bit_expr128=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr128.getTree());
                    SOUNDS_SYM129=(Token)match(input,SOUNDS_SYM,FOLLOW_SOUNDS_SYM_in_predicate2230); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SOUNDS_SYM129_tree = (CommonTree)adaptor.create(SOUNDS_SYM129);
                    adaptor.addChild(root_0, SOUNDS_SYM129_tree);
                    }
                    LIKE_SYM130=(Token)match(input,LIKE_SYM,FOLLOW_LIKE_SYM_in_predicate2232); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIKE_SYM130_tree = (CommonTree)adaptor.create(LIKE_SYM130);
                    adaptor.addChild(root_0, LIKE_SYM130_tree);
                    }
                    pushFollow(FOLLOW_bit_expr_in_predicate2234);
                    bit_expr131=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr131.getTree());

                    }


                    }
                    break;
                case 4 :
                    // MySQL.g:391:4: ( bit_expr ( NOT_SYM )? LIKE_SYM simple_expr ( ESCAPE_SYM simple_expr )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:391:4: ( bit_expr ( NOT_SYM )? LIKE_SYM simple_expr ( ESCAPE_SYM simple_expr )? )
                    // MySQL.g:391:6: bit_expr ( NOT_SYM )? LIKE_SYM simple_expr ( ESCAPE_SYM simple_expr )?
                    {
                    pushFollow(FOLLOW_bit_expr_in_predicate2244);
                    bit_expr132=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr132.getTree());
                    // MySQL.g:391:15: ( NOT_SYM )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==NOT_SYM) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // MySQL.g:391:16: NOT_SYM
                            {
                            NOT_SYM133=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_predicate2247); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT_SYM133_tree = (CommonTree)adaptor.create(NOT_SYM133);
                            adaptor.addChild(root_0, NOT_SYM133_tree);
                            }

                            }
                            break;

                    }

                    LIKE_SYM134=(Token)match(input,LIKE_SYM,FOLLOW_LIKE_SYM_in_predicate2251); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIKE_SYM134_tree = (CommonTree)adaptor.create(LIKE_SYM134);
                    adaptor.addChild(root_0, LIKE_SYM134_tree);
                    }
                    pushFollow(FOLLOW_simple_expr_in_predicate2253);
                    simple_expr135=simple_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_expr135.getTree());
                    // MySQL.g:391:47: ( ESCAPE_SYM simple_expr )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==ESCAPE_SYM) ) {
                        int LA29_1 = input.LA(2);

                        if ( (synpred293_MySQL()) ) {
                            alt29=1;
                        }
                    }
                    switch (alt29) {
                        case 1 :
                            // MySQL.g:391:48: ESCAPE_SYM simple_expr
                            {
                            ESCAPE_SYM136=(Token)match(input,ESCAPE_SYM,FOLLOW_ESCAPE_SYM_in_predicate2256); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ESCAPE_SYM136_tree = (CommonTree)adaptor.create(ESCAPE_SYM136);
                            adaptor.addChild(root_0, ESCAPE_SYM136_tree);
                            }
                            pushFollow(FOLLOW_simple_expr_in_predicate2258);
                            simple_expr137=simple_expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_expr137.getTree());

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // MySQL.g:392:4: ( bit_expr ( NOT_SYM )? REGEXP bit_expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:392:4: ( bit_expr ( NOT_SYM )? REGEXP bit_expr )
                    // MySQL.g:392:6: bit_expr ( NOT_SYM )? REGEXP bit_expr
                    {
                    pushFollow(FOLLOW_bit_expr_in_predicate2269);
                    bit_expr138=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr138.getTree());
                    // MySQL.g:392:15: ( NOT_SYM )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==NOT_SYM) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // MySQL.g:392:16: NOT_SYM
                            {
                            NOT_SYM139=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_predicate2272); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT_SYM139_tree = (CommonTree)adaptor.create(NOT_SYM139);
                            adaptor.addChild(root_0, NOT_SYM139_tree);
                            }

                            }
                            break;

                    }

                    REGEXP140=(Token)match(input,REGEXP,FOLLOW_REGEXP_in_predicate2276); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    REGEXP140_tree = (CommonTree)adaptor.create(REGEXP140);
                    adaptor.addChild(root_0, REGEXP140_tree);
                    }
                    pushFollow(FOLLOW_bit_expr_in_predicate2278);
                    bit_expr141=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr141.getTree());

                    }


                    }
                    break;
                case 6 :
                    // MySQL.g:393:4: ( bit_expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:393:4: ( bit_expr )
                    // MySQL.g:393:6: bit_expr
                    {
                    pushFollow(FOLLOW_bit_expr_in_predicate2288);
                    bit_expr142=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr142.getTree());

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 797, predicate_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "predicate"

    public static class bit_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bit_expr"
    // MySQL.g:395:1: bit_expr : factor1 ( VERTBAR factor1 )? ;
    public final MySQLParser.bit_expr_return bit_expr() throws RecognitionException {
        MySQLParser.bit_expr_return retval = new MySQLParser.bit_expr_return();
        retval.start = input.LT(1);
        int bit_expr_StartIndex = input.index();
        CommonTree root_0 = null;

        Token VERTBAR144=null;
        MySQLParser.factor1_return factor1143 = null;

        MySQLParser.factor1_return factor1145 = null;


        CommonTree VERTBAR144_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 798) ) { return retval; }
            // MySQL.g:395:9: ( factor1 ( VERTBAR factor1 )? )
            // MySQL.g:396:2: factor1 ( VERTBAR factor1 )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_factor1_in_bit_expr2300);
            factor1143=factor1();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, factor1143.getTree());
            // MySQL.g:396:10: ( VERTBAR factor1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==VERTBAR) ) {
                int LA32_1 = input.LA(2);

                if ( (synpred297_MySQL()) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // MySQL.g:396:12: VERTBAR factor1
                    {
                    VERTBAR144=(Token)match(input,VERTBAR,FOLLOW_VERTBAR_in_bit_expr2304); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VERTBAR144_tree = (CommonTree)adaptor.create(VERTBAR144);
                    adaptor.addChild(root_0, VERTBAR144_tree);
                    }
                    pushFollow(FOLLOW_factor1_in_bit_expr2306);
                    factor1145=factor1();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, factor1145.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 798, bit_expr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "bit_expr"

    public static class factor1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor1"
    // MySQL.g:397:1: factor1 : factor2 ( BITAND factor2 )? ;
    public final MySQLParser.factor1_return factor1() throws RecognitionException {
        MySQLParser.factor1_return retval = new MySQLParser.factor1_return();
        retval.start = input.LT(1);
        int factor1_StartIndex = input.index();
        CommonTree root_0 = null;

        Token BITAND147=null;
        MySQLParser.factor2_return factor2146 = null;

        MySQLParser.factor2_return factor2148 = null;


        CommonTree BITAND147_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 799) ) { return retval; }
            // MySQL.g:397:8: ( factor2 ( BITAND factor2 )? )
            // MySQL.g:398:2: factor2 ( BITAND factor2 )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_factor2_in_factor12317);
            factor2146=factor2();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, factor2146.getTree());
            // MySQL.g:398:10: ( BITAND factor2 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==BITAND) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred298_MySQL()) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // MySQL.g:398:12: BITAND factor2
                    {
                    BITAND147=(Token)match(input,BITAND,FOLLOW_BITAND_in_factor12321); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BITAND147_tree = (CommonTree)adaptor.create(BITAND147);
                    adaptor.addChild(root_0, BITAND147_tree);
                    }
                    pushFollow(FOLLOW_factor2_in_factor12323);
                    factor2148=factor2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, factor2148.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 799, factor1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "factor1"

    public static class factor2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor2"
    // MySQL.g:399:1: factor2 : factor3 ( ( SHIFT_LEFT | SHIFT_RIGHT ) factor3 )? ;
    public final MySQLParser.factor2_return factor2() throws RecognitionException {
        MySQLParser.factor2_return retval = new MySQLParser.factor2_return();
        retval.start = input.LT(1);
        int factor2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set150=null;
        MySQLParser.factor3_return factor3149 = null;

        MySQLParser.factor3_return factor3151 = null;


        CommonTree set150_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 800) ) { return retval; }
            // MySQL.g:399:8: ( factor3 ( ( SHIFT_LEFT | SHIFT_RIGHT ) factor3 )? )
            // MySQL.g:400:2: factor3 ( ( SHIFT_LEFT | SHIFT_RIGHT ) factor3 )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_factor3_in_factor22334);
            factor3149=factor3();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, factor3149.getTree());
            // MySQL.g:400:10: ( ( SHIFT_LEFT | SHIFT_RIGHT ) factor3 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=SHIFT_LEFT && LA34_0<=SHIFT_RIGHT)) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred300_MySQL()) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // MySQL.g:400:12: ( SHIFT_LEFT | SHIFT_RIGHT ) factor3
                    {
                    set150=(Token)input.LT(1);
                    if ( (input.LA(1)>=SHIFT_LEFT && input.LA(1)<=SHIFT_RIGHT) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set150));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_factor3_in_factor22344);
                    factor3151=factor3();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, factor3151.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 800, factor2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "factor2"

    public static class factor3_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor3"
    // MySQL.g:401:1: factor3 : factor4 ( ( PLUS | MINUS ) factor4 )* ;
    public final MySQLParser.factor3_return factor3() throws RecognitionException {
        MySQLParser.factor3_return retval = new MySQLParser.factor3_return();
        retval.start = input.LT(1);
        int factor3_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set153=null;
        MySQLParser.factor4_return factor4152 = null;

        MySQLParser.factor4_return factor4154 = null;


        CommonTree set153_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 801) ) { return retval; }
            // MySQL.g:401:8: ( factor4 ( ( PLUS | MINUS ) factor4 )* )
            // MySQL.g:402:2: factor4 ( ( PLUS | MINUS ) factor4 )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_factor4_in_factor32355);
            factor4152=factor4();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, factor4152.getTree());
            // MySQL.g:402:10: ( ( PLUS | MINUS ) factor4 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=PLUS && LA35_0<=MINUS)) ) {
                    int LA35_2 = input.LA(2);

                    if ( (synpred302_MySQL()) ) {
                        alt35=1;
                    }


                }


                switch (alt35) {
            	case 1 :
            	    // MySQL.g:402:12: ( PLUS | MINUS ) factor4
            	    {
            	    set153=(Token)input.LT(1);
            	    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set153));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_factor4_in_factor32365);
            	    factor4154=factor4();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, factor4154.getTree());

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 801, factor3_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "factor3"

    public static class factor4_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor4"
    // MySQL.g:403:1: factor4 : factor5 ( ( ASTERISK | DIVIDE | MOD_SYM | POWER_OP ) factor5 )* ;
    public final MySQLParser.factor4_return factor4() throws RecognitionException {
        MySQLParser.factor4_return retval = new MySQLParser.factor4_return();
        retval.start = input.LT(1);
        int factor4_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set156=null;
        MySQLParser.factor5_return factor5155 = null;

        MySQLParser.factor5_return factor5157 = null;


        CommonTree set156_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 802) ) { return retval; }
            // MySQL.g:403:8: ( factor5 ( ( ASTERISK | DIVIDE | MOD_SYM | POWER_OP ) factor5 )* )
            // MySQL.g:404:2: factor5 ( ( ASTERISK | DIVIDE | MOD_SYM | POWER_OP ) factor5 )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_factor5_in_factor42376);
            factor5155=factor5();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, factor5155.getTree());
            // MySQL.g:404:10: ( ( ASTERISK | DIVIDE | MOD_SYM | POWER_OP ) factor5 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=DIVIDE && LA36_0<=MOD_SYM)||LA36_0==ASTERISK||LA36_0==POWER_OP) ) {
                    int LA36_2 = input.LA(2);

                    if ( (synpred306_MySQL()) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // MySQL.g:404:12: ( ASTERISK | DIVIDE | MOD_SYM | POWER_OP ) factor5
            	    {
            	    set156=(Token)input.LT(1);
            	    if ( (input.LA(1)>=DIVIDE && input.LA(1)<=MOD_SYM)||input.LA(1)==ASTERISK||input.LA(1)==POWER_OP ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set156));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_factor5_in_factor42390);
            	    factor5157=factor5();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, factor5157.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 802, factor4_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "factor4"

    public static class factor5_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor5"
    // MySQL.g:405:1: factor5 : factor6 ( ( PLUS | MINUS ) interval_expr )? ;
    public final MySQLParser.factor5_return factor5() throws RecognitionException {
        MySQLParser.factor5_return retval = new MySQLParser.factor5_return();
        retval.start = input.LT(1);
        int factor5_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set159=null;
        MySQLParser.factor6_return factor6158 = null;

        MySQLParser.interval_expr_return interval_expr160 = null;


        CommonTree set159_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 803) ) { return retval; }
            // MySQL.g:405:8: ( factor6 ( ( PLUS | MINUS ) interval_expr )? )
            // MySQL.g:406:2: factor6 ( ( PLUS | MINUS ) interval_expr )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_factor6_in_factor52401);
            factor6158=factor6();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, factor6158.getTree());
            // MySQL.g:406:10: ( ( PLUS | MINUS ) interval_expr )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=PLUS && LA37_0<=MINUS)) ) {
                int LA37_1 = input.LA(2);

                if ( (synpred308_MySQL()) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // MySQL.g:406:12: ( PLUS | MINUS ) interval_expr
                    {
                    set159=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set159));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_interval_expr_in_factor52411);
                    interval_expr160=interval_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, interval_expr160.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 803, factor5_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "factor5"

    public static class factor6_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor6"
    // MySQL.g:407:1: factor6 : ( ( PLUS | MINUS | NEGATION | BINARY ) simple_expr | simple_expr );
    public final MySQLParser.factor6_return factor6() throws RecognitionException {
        MySQLParser.factor6_return retval = new MySQLParser.factor6_return();
        retval.start = input.LT(1);
        int factor6_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set161=null;
        MySQLParser.simple_expr_return simple_expr162 = null;

        MySQLParser.simple_expr_return simple_expr163 = null;


        CommonTree set161_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 804) ) { return retval; }
            // MySQL.g:407:8: ( ( PLUS | MINUS | NEGATION | BINARY ) simple_expr | simple_expr )
            int alt38=2;
            switch ( input.LA(1) ) {
            case PLUS:
            case MINUS:
                {
                switch ( input.LA(2) ) {
                case NULL_SYM:
                    {
                    int LA38_4 = input.LA(3);

                    if ( (synpred312_MySQL()) ) {
                        alt38=1;
                    }
                    else if ( (true) ) {
                        alt38=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case INTEGER_NUM:
                case REAL_NUMBER:
                    {
                    int LA38_5 = input.LA(3);

                    if ( (synpred312_MySQL()) ) {
                        alt38=1;
                    }
                    else if ( (true) ) {
                        alt38=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case ABS:
                case ACOS:
                case ADDDATE:
                case ADDTIME:
                case AES_DECRYPT:
                case AES_ENCRYPT:
                case ASCII_SYM:
                case ASIN:
                case ATAN:
                case ATAN2:
                case AVG:
                case BENCHMARK:
                case BIN:
                case BIT_AND:
                case BIT_LENGTH:
                case BIT_OR:
                case BIT_XOR:
                case CASE_SYM:
                case CAST_SYM:
                case CEIL:
                case CEILING:
                case CHAR:
                case CHAR_LENGTH:
                case CHARSET:
                case COERCIBILITY:
                case COLLATION:
                case CONCAT:
                case CONCAT_WS:
                case CONNECTION_ID:
                case CONV:
                case CONVERT_SYM:
                case CONVERT_TZ:
                case COS:
                case COT:
                case COUNT:
                case CRC32:
                case CURDATE:
                case CURRENT_USER:
                case CURTIME:
                case DATABASE:
                case DATE_ADD:
                case DATE_FORMAT:
                case DATE_SUB:
                case DATE_SYM:
                case DATEDIFF:
                case DAY_SYM:
                case DAYNAME:
                case DAYOFMONTH:
                case DAYOFWEEK:
                case DAYOFYEAR:
                case DECODE:
                case DEFAULT:
                case DEGREES:
                case DES_DECRYPT:
                case DES_ENCRYPT:
                case ELT:
                case ENCODE:
                case ENCRYPT:
                case EXISTS:
                case EXP:
                case EXPORT_SET:
                case EXTRACT:
                case FALSE_SYM:
                case FIELD:
                case FIND_IN_SET:
                case FLOOR:
                case FORMAT:
                case FOUND_ROWS:
                case FROM_BASE64:
                case FROM_DAYS:
                case FROM_UNIXTIME:
                case GET_FORMAT:
                case GET_LOCK:
                case GROUP_CONCAT:
                case HEX:
                case HOUR:
                case IF:
                case IFNULL:
                case INET_ATON:
                case INET_NTOA:
                case INSERT:
                case INSTR:
                case INTERVAL_SYM:
                case IS_FREE_LOCK:
                case IS_USED_LOCK:
                case LAST_DAY:
                case LAST_INSERT_ID:
                case LEFT:
                case LENGTH:
                case LN:
                case LOAD_FILE:
                case LOCATE:
                case LOG:
                case LOG10:
                case LOG2:
                case LOWER:
                case LPAD:
                case LTRIM:
                case MAKE_SET:
                case MAKEDATE:
                case MAKETIME:
                case MASTER_POS_WAIT:
                case MATCH:
                case MAX_SYM:
                case MD5:
                case MICROSECOND:
                case MID:
                case MIN_SYM:
                case MINUTE:
                case MOD:
                case MONTH:
                case MONTHNAME:
                case NAME_CONST:
                case NOW:
                case OCT:
                case OLD_PASSWORD:
                case ORD:
                case PASSWORD:
                case PERIOD_ADD:
                case PERIOD_DIFF:
                case PI:
                case POW:
                case POWER:
                case QUARTER:
                case QUOTE:
                case RADIANS:
                case RAND:
                case RELEASE_LOCK:
                case REPEAT:
                case REPLACE:
                case REVERSE:
                case RIGHT:
                case ROUND:
                case ROW_SYM:
                case RPAD:
                case RTRIM:
                case SCHEMA:
                case SEC_TO_TIME:
                case SECOND:
                case SESSION_USER:
                case SIGN:
                case SIN:
                case SLEEP:
                case SOUNDEX:
                case SPACE:
                case SQRT:
                case STD:
                case STDDEV:
                case STDDEV_POP:
                case STDDEV_SAMP:
                case STR_TO_DATE:
                case STRCMP:
                case SUBSTRING:
                case SUBSTRING_INDEX:
                case SUBTIME:
                case SUM:
                case SYSDATE:
                case SYSTEM_USER:
                case TAN:
                case TIME_FORMAT:
                case TIME_SYM:
                case TIME_TO_SEC:
                case TIMEDIFF:
                case TIMESTAMP:
                case TIMESTAMPADD:
                case TIMESTAMPDIFF:
                case TO_BASE64:
                case TO_DAYS:
                case TO_SECONDS:
                case TRIM:
                case TRUE_SYM:
                case TRUNCATE:
                case UNHEX:
                case UNIX_TIMESTAMP:
                case UPPER:
                case USER:
                case UTC_DATE:
                case UTC_TIME:
                case UTC_TIMESTAMP:
                case UUID:
                case VALUES:
                case VAR_POP:
                case VAR_SAMP:
                case VARIANCE:
                case VERSION_SYM:
                case WEEK:
                case WEEKDAY:
                case WEEKOFYEAR:
                case WEIGHT_STRING:
                case LPAREN:
                case YEAR_FUNC:
                case YEARWEEK:
                case PLUS:
                case MINUS:
                case HEX_DIGIT:
                case BIT_NUM:
                case TEXT_STRING:
                case ID:
                case USER_VAR:
                    {
                    alt38=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }

                }
                break;
            case ABS:
            case ACOS:
            case ADDDATE:
            case ADDTIME:
            case AES_DECRYPT:
            case AES_ENCRYPT:
            case ASCII_SYM:
            case ASIN:
            case ATAN:
            case ATAN2:
            case AVG:
            case BENCHMARK:
            case BIN:
            case BIT_AND:
            case BIT_LENGTH:
            case BIT_OR:
            case BIT_XOR:
            case CASE_SYM:
            case CAST_SYM:
            case CEIL:
            case CEILING:
            case CHAR:
            case CHAR_LENGTH:
            case CHARSET:
            case COERCIBILITY:
            case COLLATION:
            case CONCAT:
            case CONCAT_WS:
            case CONNECTION_ID:
            case CONV:
            case CONVERT_SYM:
            case CONVERT_TZ:
            case COS:
            case COT:
            case COUNT:
            case CRC32:
            case CURDATE:
            case CURRENT_USER:
            case CURTIME:
            case DATABASE:
            case DATE_ADD:
            case DATE_FORMAT:
            case DATE_SUB:
            case DATE_SYM:
            case DATEDIFF:
            case DAY_SYM:
            case DAYNAME:
            case DAYOFMONTH:
            case DAYOFWEEK:
            case DAYOFYEAR:
            case DECODE:
            case DEFAULT:
            case DEGREES:
            case DES_DECRYPT:
            case DES_ENCRYPT:
            case ELT:
            case ENCODE:
            case ENCRYPT:
            case EXISTS:
            case EXP:
            case EXPORT_SET:
            case EXTRACT:
            case FALSE_SYM:
            case FIELD:
            case FIND_IN_SET:
            case FLOOR:
            case FORMAT:
            case FOUND_ROWS:
            case FROM_BASE64:
            case FROM_DAYS:
            case FROM_UNIXTIME:
            case GET_FORMAT:
            case GET_LOCK:
            case GROUP_CONCAT:
            case HEX:
            case HOUR:
            case IF:
            case IFNULL:
            case INET_ATON:
            case INET_NTOA:
            case INSERT:
            case INSTR:
            case INTERVAL_SYM:
            case IS_FREE_LOCK:
            case IS_USED_LOCK:
            case LAST_DAY:
            case LAST_INSERT_ID:
            case LEFT:
            case LENGTH:
            case LN:
            case LOAD_FILE:
            case LOCATE:
            case LOG:
            case LOG10:
            case LOG2:
            case LOWER:
            case LPAD:
            case LTRIM:
            case MAKE_SET:
            case MAKEDATE:
            case MAKETIME:
            case MASTER_POS_WAIT:
            case MATCH:
            case MAX_SYM:
            case MD5:
            case MICROSECOND:
            case MID:
            case MIN_SYM:
            case MINUTE:
            case MOD:
            case MONTH:
            case MONTHNAME:
            case NAME_CONST:
            case NOW:
            case NULL_SYM:
            case OCT:
            case OLD_PASSWORD:
            case ORD:
            case PASSWORD:
            case PERIOD_ADD:
            case PERIOD_DIFF:
            case PI:
            case POW:
            case POWER:
            case QUARTER:
            case QUOTE:
            case RADIANS:
            case RAND:
            case RELEASE_LOCK:
            case REPEAT:
            case REPLACE:
            case REVERSE:
            case RIGHT:
            case ROUND:
            case ROW_SYM:
            case RPAD:
            case RTRIM:
            case SCHEMA:
            case SEC_TO_TIME:
            case SECOND:
            case SESSION_USER:
            case SIGN:
            case SIN:
            case SLEEP:
            case SOUNDEX:
            case SPACE:
            case SQRT:
            case STD:
            case STDDEV:
            case STDDEV_POP:
            case STDDEV_SAMP:
            case STR_TO_DATE:
            case STRCMP:
            case SUBSTRING:
            case SUBSTRING_INDEX:
            case SUBTIME:
            case SUM:
            case SYSDATE:
            case SYSTEM_USER:
            case TAN:
            case TIME_FORMAT:
            case TIME_SYM:
            case TIME_TO_SEC:
            case TIMEDIFF:
            case TIMESTAMP:
            case TIMESTAMPADD:
            case TIMESTAMPDIFF:
            case TO_BASE64:
            case TO_DAYS:
            case TO_SECONDS:
            case TRIM:
            case TRUE_SYM:
            case TRUNCATE:
            case UNHEX:
            case UNIX_TIMESTAMP:
            case UPPER:
            case USER:
            case UTC_DATE:
            case UTC_TIME:
            case UTC_TIMESTAMP:
            case UUID:
            case VALUES:
            case VAR_POP:
            case VAR_SAMP:
            case VARIANCE:
            case VERSION_SYM:
            case WEEK:
            case WEEKDAY:
            case WEEKOFYEAR:
            case WEIGHT_STRING:
            case LPAREN:
            case YEAR_FUNC:
            case YEARWEEK:
            case INTEGER_NUM:
            case HEX_DIGIT:
            case BIT_NUM:
            case REAL_NUMBER:
            case TEXT_STRING:
            case ID:
            case USER_VAR:
                {
                alt38=2;
                }
                break;
            case BINARY:
            case NEGATION:
                {
                alt38=1;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // MySQL.g:408:2: ( PLUS | MINUS | NEGATION | BINARY ) simple_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    set161=(Token)input.LT(1);
                    if ( input.LA(1)==BINARY||(input.LA(1)>=PLUS && input.LA(1)<=NEGATION) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set161));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_simple_expr_in_factor62438);
                    simple_expr162=simple_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_expr162.getTree());

                    }
                    break;
                case 2 :
                    // MySQL.g:409:4: simple_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simple_expr_in_factor62443);
                    simple_expr163=simple_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_expr163.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 804, factor6_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "factor6"

    public static class simple_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simple_expr"
    // MySQL.g:411:1: simple_expr : ( literal_value | column_spec | function_call -> ^( TN_FUNCTION function_call ) | USER_VAR | expression_list | ( ROW_SYM expression_list ) | subquery | EXISTS subquery | match_against_statement | case_when_statement -> ^( TN_CASE_WHEN case_when_statement ) | interval_expr );
    public final MySQLParser.simple_expr_return simple_expr() throws RecognitionException {
        MySQLParser.simple_expr_return retval = new MySQLParser.simple_expr_return();
        retval.start = input.LT(1);
        int simple_expr_StartIndex = input.index();
        CommonTree root_0 = null;

        Token USER_VAR167=null;
        Token ROW_SYM169=null;
        Token EXISTS172=null;
        MySQLParser.literal_value_return literal_value164 = null;

        MySQLParser.column_spec_return column_spec165 = null;

        MySQLParser.function_call_return function_call166 = null;

        MySQLParser.expression_list_return expression_list168 = null;

        MySQLParser.expression_list_return expression_list170 = null;

        MySQLParser.subquery_return subquery171 = null;

        MySQLParser.subquery_return subquery173 = null;

        MySQLParser.match_against_statement_return match_against_statement174 = null;

        MySQLParser.case_when_statement_return case_when_statement175 = null;

        MySQLParser.interval_expr_return interval_expr176 = null;


        CommonTree USER_VAR167_tree=null;
        CommonTree ROW_SYM169_tree=null;
        CommonTree EXISTS172_tree=null;
        RewriteRuleSubtreeStream stream_function_call=new RewriteRuleSubtreeStream(adaptor,"rule function_call");
        RewriteRuleSubtreeStream stream_case_when_statement=new RewriteRuleSubtreeStream(adaptor,"rule case_when_statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 805) ) { return retval; }
            // MySQL.g:411:12: ( literal_value | column_spec | function_call -> ^( TN_FUNCTION function_call ) | USER_VAR | expression_list | ( ROW_SYM expression_list ) | subquery | EXISTS subquery | match_against_statement | case_when_statement -> ^( TN_CASE_WHEN case_when_statement ) | interval_expr )
            int alt39=11;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // MySQL.g:412:2: literal_value
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_value_in_simple_expr2452);
                    literal_value164=literal_value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal_value164.getTree());

                    }
                    break;
                case 2 :
                    // MySQL.g:413:4: column_spec
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_spec_in_simple_expr2457);
                    column_spec165=column_spec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec165.getTree());

                    }
                    break;
                case 3 :
                    // MySQL.g:414:4: function_call
                    {
                    pushFollow(FOLLOW_function_call_in_simple_expr2462);
                    function_call166=function_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_function_call.add(function_call166.getTree());


                    // AST REWRITE
                    // elements: function_call
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 414:18: -> ^( TN_FUNCTION function_call )
                    {
                        // MySQL.g:414:21: ^( TN_FUNCTION function_call )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_FUNCTION, "TN_FUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_function_call.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MySQL.g:415:4: USER_VAR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    USER_VAR167=(Token)match(input,USER_VAR,FOLLOW_USER_VAR_in_simple_expr2475); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USER_VAR167_tree = (CommonTree)adaptor.create(USER_VAR167);
                    adaptor.addChild(root_0, USER_VAR167_tree);
                    }

                    }
                    break;
                case 5 :
                    // MySQL.g:416:4: expression_list
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expression_list_in_simple_expr2480);
                    expression_list168=expression_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_list168.getTree());

                    }
                    break;
                case 6 :
                    // MySQL.g:417:4: ( ROW_SYM expression_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:417:4: ( ROW_SYM expression_list )
                    // MySQL.g:417:5: ROW_SYM expression_list
                    {
                    ROW_SYM169=(Token)match(input,ROW_SYM,FOLLOW_ROW_SYM_in_simple_expr2486); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROW_SYM169_tree = (CommonTree)adaptor.create(ROW_SYM169);
                    adaptor.addChild(root_0, ROW_SYM169_tree);
                    }
                    pushFollow(FOLLOW_expression_list_in_simple_expr2488);
                    expression_list170=expression_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_list170.getTree());

                    }


                    }
                    break;
                case 7 :
                    // MySQL.g:418:4: subquery
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_subquery_in_simple_expr2494);
                    subquery171=subquery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subquery171.getTree());

                    }
                    break;
                case 8 :
                    // MySQL.g:419:4: EXISTS subquery
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    EXISTS172=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_simple_expr2499); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXISTS172_tree = (CommonTree)adaptor.create(EXISTS172);
                    adaptor.addChild(root_0, EXISTS172_tree);
                    }
                    pushFollow(FOLLOW_subquery_in_simple_expr2501);
                    subquery173=subquery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subquery173.getTree());

                    }
                    break;
                case 9 :
                    // MySQL.g:420:4: match_against_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_match_against_statement_in_simple_expr2506);
                    match_against_statement174=match_against_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, match_against_statement174.getTree());

                    }
                    break;
                case 10 :
                    // MySQL.g:421:4: case_when_statement
                    {
                    pushFollow(FOLLOW_case_when_statement_in_simple_expr2511);
                    case_when_statement175=case_when_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_case_when_statement.add(case_when_statement175.getTree());


                    // AST REWRITE
                    // elements: case_when_statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 421:24: -> ^( TN_CASE_WHEN case_when_statement )
                    {
                        // MySQL.g:421:27: ^( TN_CASE_WHEN case_when_statement )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_CASE_WHEN, "TN_CASE_WHEN"), root_1);

                        adaptor.addChild(root_1, stream_case_when_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // MySQL.g:422:4: interval_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_interval_expr_in_simple_expr2524);
                    interval_expr176=interval_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, interval_expr176.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 805, simple_expr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "simple_expr"

    public static class function_call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_call"
    // MySQL.g:425:1: function_call : ( ( functionList ( LPAREN ( expression ( COMMA expression )* )? RPAREN )? ) | ( CAST_SYM LPAREN expression AS_SYM cast_data_type RPAREN ) | ( CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN ) | ( CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN ) | ( group_functions ( LPAREN ( ASTERISK | ALL | DISTINCT )? ( bit_expr )? RPAREN )? ) | ( special_functions ) );
    public final MySQLParser.function_call_return function_call() throws RecognitionException {
        MySQLParser.function_call_return retval = new MySQLParser.function_call_return();
        retval.start = input.LT(1);
        int function_call_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LPAREN178=null;
        Token COMMA180=null;
        Token RPAREN182=null;
        Token CAST_SYM183=null;
        Token LPAREN184=null;
        Token AS_SYM186=null;
        Token RPAREN188=null;
        Token CONVERT_SYM189=null;
        Token LPAREN190=null;
        Token COMMA192=null;
        Token RPAREN194=null;
        Token CONVERT_SYM195=null;
        Token LPAREN196=null;
        Token USING_SYM198=null;
        Token RPAREN200=null;
        Token LPAREN202=null;
        Token set203=null;
        Token RPAREN205=null;
        MySQLParser.functionList_return functionList177 = null;

        MySQLParser.expression_return expression179 = null;

        MySQLParser.expression_return expression181 = null;

        MySQLParser.expression_return expression185 = null;

        MySQLParser.cast_data_type_return cast_data_type187 = null;

        MySQLParser.expression_return expression191 = null;

        MySQLParser.cast_data_type_return cast_data_type193 = null;

        MySQLParser.expression_return expression197 = null;

        MySQLParser.transcoding_name_return transcoding_name199 = null;

        MySQLParser.group_functions_return group_functions201 = null;

        MySQLParser.bit_expr_return bit_expr204 = null;

        MySQLParser.special_functions_return special_functions206 = null;


        CommonTree LPAREN178_tree=null;
        CommonTree COMMA180_tree=null;
        CommonTree RPAREN182_tree=null;
        CommonTree CAST_SYM183_tree=null;
        CommonTree LPAREN184_tree=null;
        CommonTree AS_SYM186_tree=null;
        CommonTree RPAREN188_tree=null;
        CommonTree CONVERT_SYM189_tree=null;
        CommonTree LPAREN190_tree=null;
        CommonTree COMMA192_tree=null;
        CommonTree RPAREN194_tree=null;
        CommonTree CONVERT_SYM195_tree=null;
        CommonTree LPAREN196_tree=null;
        CommonTree USING_SYM198_tree=null;
        CommonTree RPAREN200_tree=null;
        CommonTree LPAREN202_tree=null;
        CommonTree set203_tree=null;
        CommonTree RPAREN205_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 806) ) { return retval; }
            // MySQL.g:425:14: ( ( functionList ( LPAREN ( expression ( COMMA expression )* )? RPAREN )? ) | ( CAST_SYM LPAREN expression AS_SYM cast_data_type RPAREN ) | ( CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN ) | ( CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN ) | ( group_functions ( LPAREN ( ASTERISK | ALL | DISTINCT )? ( bit_expr )? RPAREN )? ) | ( special_functions ) )
            int alt46=6;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // MySQL.g:426:4: ( functionList ( LPAREN ( expression ( COMMA expression )* )? RPAREN )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:426:4: ( functionList ( LPAREN ( expression ( COMMA expression )* )? RPAREN )? )
                    // MySQL.g:426:7: functionList ( LPAREN ( expression ( COMMA expression )* )? RPAREN )?
                    {
                    pushFollow(FOLLOW_functionList_in_function_call2538);
                    functionList177=functionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionList177.getTree());
                    // MySQL.g:426:20: ( LPAREN ( expression ( COMMA expression )* )? RPAREN )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==LPAREN) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // MySQL.g:426:22: LPAREN ( expression ( COMMA expression )* )? RPAREN
                            {
                            LPAREN178=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function_call2542); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LPAREN178_tree = (CommonTree)adaptor.create(LPAREN178);
                            adaptor.addChild(root_0, LPAREN178_tree);
                            }
                            // MySQL.g:426:29: ( expression ( COMMA expression )* )?
                            int alt41=2;
                            int LA41_0 = input.LA(1);

                            if ( ((LA41_0>=ABS && LA41_0<=ACOS)||(LA41_0>=ADDDATE && LA41_0<=AES_ENCRYPT)||(LA41_0>=ASCII_SYM && LA41_0<=ASIN)||(LA41_0>=ATAN && LA41_0<=ATAN2)||LA41_0==AVG||LA41_0==BENCHMARK||(LA41_0>=BIN && LA41_0<=BIT_OR)||LA41_0==BIT_XOR||(LA41_0>=CASE_SYM && LA41_0<=CEILING)||(LA41_0>=CHAR && LA41_0<=CHAR_LENGTH)||LA41_0==CHARSET||LA41_0==COERCIBILITY||LA41_0==COLLATION||(LA41_0>=CONCAT && LA41_0<=CONCAT_WS)||LA41_0==CONNECTION_ID||(LA41_0>=CONV && LA41_0<=CONVERT_TZ)||(LA41_0>=COS && LA41_0<=COUNT)||LA41_0==CRC32||LA41_0==CURDATE||(LA41_0>=CURRENT_USER && LA41_0<=DATABASE)||(LA41_0>=DATE_ADD && LA41_0<=DATEDIFF)||LA41_0==DAY_SYM||(LA41_0>=DAYNAME && LA41_0<=DAYOFYEAR)||(LA41_0>=DECODE && LA41_0<=DEFAULT)||LA41_0==DEGREES||(LA41_0>=DES_DECRYPT && LA41_0<=DES_ENCRYPT)||LA41_0==ELT||(LA41_0>=ENCODE && LA41_0<=ENCRYPT)||(LA41_0>=EXISTS && LA41_0<=EXP)||(LA41_0>=EXPORT_SET && LA41_0<=FALSE_SYM)||LA41_0==FIELD||LA41_0==FIND_IN_SET||LA41_0==FLOOR||(LA41_0>=FORMAT && LA41_0<=FOUND_ROWS)||(LA41_0>=FROM_BASE64 && LA41_0<=FROM_UNIXTIME)||(LA41_0>=GET_FORMAT && LA41_0<=GET_LOCK)||LA41_0==GROUP_CONCAT||LA41_0==HEX||LA41_0==HOUR||(LA41_0>=IF && LA41_0<=IFNULL)||(LA41_0>=INET_ATON && LA41_0<=INET_NTOA)||LA41_0==INSERT||LA41_0==INSTR||LA41_0==INTERVAL_SYM||LA41_0==IS_FREE_LOCK||LA41_0==IS_USED_LOCK||(LA41_0>=LAST_DAY && LA41_0<=LAST_INSERT_ID)||(LA41_0>=LEFT && LA41_0<=LENGTH)||LA41_0==LN||LA41_0==LOAD_FILE||LA41_0==LOCATE||(LA41_0>=LOG && LA41_0<=LOG2)||(LA41_0>=LOWER && LA41_0<=LTRIM)||(LA41_0>=MAKE_SET && LA41_0<=MAX_SYM)||LA41_0==MD5||(LA41_0>=MICROSECOND && LA41_0<=MIN_SYM)||LA41_0==MINUTE||LA41_0==MOD||(LA41_0>=MONTH && LA41_0<=NAME_CONST)||(LA41_0>=NOT_SYM && LA41_0<=NULL_SYM)||LA41_0==OCT||LA41_0==OLD_PASSWORD||LA41_0==ORD||(LA41_0>=PASSWORD && LA41_0<=PI)||(LA41_0>=POW && LA41_0<=POWER)||LA41_0==QUARTER||(LA41_0>=QUOTE && LA41_0<=RAND)||LA41_0==RELEASE_LOCK||(LA41_0>=REPEAT && LA41_0<=REPLACE)||(LA41_0>=REVERSE && LA41_0<=RIGHT)||LA41_0==ROUND||LA41_0==ROW_SYM||(LA41_0>=RPAD && LA41_0<=RTRIM)||(LA41_0>=SCHEMA && LA41_0<=SECOND)||LA41_0==SESSION_USER||LA41_0==SIGN||LA41_0==SIN||LA41_0==SLEEP||LA41_0==SOUNDEX||LA41_0==SPACE||LA41_0==SQRT||(LA41_0>=STD && LA41_0<=STDDEV_SAMP)||LA41_0==STR_TO_DATE||LA41_0==STRCMP||(LA41_0>=SUBSTRING && LA41_0<=SUM)||(LA41_0>=SYSDATE && LA41_0<=SYSTEM_USER)||LA41_0==TAN||(LA41_0>=TIME_FORMAT && LA41_0<=TIMESTAMPDIFF)||(LA41_0>=TO_BASE64 && LA41_0<=TO_SECONDS)||(LA41_0>=TRIM && LA41_0<=TRUNCATE)||LA41_0==UNHEX||LA41_0==UNIX_TIMESTAMP||LA41_0==UPPER||LA41_0==USER||(LA41_0>=UTC_DATE && LA41_0<=UTC_TIMESTAMP)||LA41_0==UUID||(LA41_0>=VALUES && LA41_0<=VAR_SAMP)||(LA41_0>=VARIANCE && LA41_0<=VERSION_SYM)||(LA41_0>=WEEK && LA41_0<=WEIGHT_STRING)||(LA41_0>=LPAREN && LA41_0<=YEAR_FUNC)||LA41_0==YEARWEEK||(LA41_0>=PLUS && LA41_0<=NEGATION)||LA41_0==INTEGER_NUM||(LA41_0>=HEX_DIGIT && LA41_0<=ID)||LA41_0==USER_VAR) ) {
                                alt41=1;
                            }
                            switch (alt41) {
                                case 1 :
                                    // MySQL.g:426:30: expression ( COMMA expression )*
                                    {
                                    pushFollow(FOLLOW_expression_in_function_call2545);
                                    expression179=expression();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression179.getTree());
                                    // MySQL.g:426:41: ( COMMA expression )*
                                    loop40:
                                    do {
                                        int alt40=2;
                                        int LA40_0 = input.LA(1);

                                        if ( (LA40_0==COMMA) ) {
                                            alt40=1;
                                        }


                                        switch (alt40) {
                                    	case 1 :
                                    	    // MySQL.g:426:42: COMMA expression
                                    	    {
                                    	    COMMA180=(Token)match(input,COMMA,FOLLOW_COMMA_in_function_call2548); if (state.failed) return retval;
                                    	    if ( state.backtracking==0 ) {
                                    	    COMMA180_tree = (CommonTree)adaptor.create(COMMA180);
                                    	    adaptor.addChild(root_0, COMMA180_tree);
                                    	    }
                                    	    pushFollow(FOLLOW_expression_in_function_call2550);
                                    	    expression181=expression();

                                    	    state._fsp--;
                                    	    if (state.failed) return retval;
                                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression181.getTree());

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop40;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            RPAREN182=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function_call2556); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RPAREN182_tree = (CommonTree)adaptor.create(RPAREN182);
                            adaptor.addChild(root_0, RPAREN182_tree);
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // MySQL.g:427:4: ( CAST_SYM LPAREN expression AS_SYM cast_data_type RPAREN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:427:4: ( CAST_SYM LPAREN expression AS_SYM cast_data_type RPAREN )
                    // MySQL.g:427:7: CAST_SYM LPAREN expression AS_SYM cast_data_type RPAREN
                    {
                    CAST_SYM183=(Token)match(input,CAST_SYM,FOLLOW_CAST_SYM_in_function_call2571); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_SYM183_tree = (CommonTree)adaptor.create(CAST_SYM183);
                    adaptor.addChild(root_0, CAST_SYM183_tree);
                    }
                    LPAREN184=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function_call2573); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN184_tree = (CommonTree)adaptor.create(LPAREN184);
                    adaptor.addChild(root_0, LPAREN184_tree);
                    }
                    pushFollow(FOLLOW_expression_in_function_call2575);
                    expression185=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression185.getTree());
                    AS_SYM186=(Token)match(input,AS_SYM,FOLLOW_AS_SYM_in_function_call2577); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS_SYM186_tree = (CommonTree)adaptor.create(AS_SYM186);
                    adaptor.addChild(root_0, AS_SYM186_tree);
                    }
                    pushFollow(FOLLOW_cast_data_type_in_function_call2579);
                    cast_data_type187=cast_data_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cast_data_type187.getTree());
                    RPAREN188=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function_call2581); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN188_tree = (CommonTree)adaptor.create(RPAREN188);
                    adaptor.addChild(root_0, RPAREN188_tree);
                    }

                    }


                    }
                    break;
                case 3 :
                    // MySQL.g:428:4: ( CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:428:4: ( CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN )
                    // MySQL.g:428:7: CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN
                    {
                    CONVERT_SYM189=(Token)match(input,CONVERT_SYM,FOLLOW_CONVERT_SYM_in_function_call2592); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONVERT_SYM189_tree = (CommonTree)adaptor.create(CONVERT_SYM189);
                    adaptor.addChild(root_0, CONVERT_SYM189_tree);
                    }
                    LPAREN190=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function_call2594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN190_tree = (CommonTree)adaptor.create(LPAREN190);
                    adaptor.addChild(root_0, LPAREN190_tree);
                    }
                    pushFollow(FOLLOW_expression_in_function_call2596);
                    expression191=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression191.getTree());
                    COMMA192=(Token)match(input,COMMA,FOLLOW_COMMA_in_function_call2598); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMA192_tree = (CommonTree)adaptor.create(COMMA192);
                    adaptor.addChild(root_0, COMMA192_tree);
                    }
                    pushFollow(FOLLOW_cast_data_type_in_function_call2600);
                    cast_data_type193=cast_data_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cast_data_type193.getTree());
                    RPAREN194=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function_call2602); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN194_tree = (CommonTree)adaptor.create(RPAREN194);
                    adaptor.addChild(root_0, RPAREN194_tree);
                    }

                    }


                    }
                    break;
                case 4 :
                    // MySQL.g:429:4: ( CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:429:4: ( CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN )
                    // MySQL.g:429:7: CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN
                    {
                    CONVERT_SYM195=(Token)match(input,CONVERT_SYM,FOLLOW_CONVERT_SYM_in_function_call2613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONVERT_SYM195_tree = (CommonTree)adaptor.create(CONVERT_SYM195);
                    adaptor.addChild(root_0, CONVERT_SYM195_tree);
                    }
                    LPAREN196=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function_call2615); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN196_tree = (CommonTree)adaptor.create(LPAREN196);
                    adaptor.addChild(root_0, LPAREN196_tree);
                    }
                    pushFollow(FOLLOW_expression_in_function_call2617);
                    expression197=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression197.getTree());
                    USING_SYM198=(Token)match(input,USING_SYM,FOLLOW_USING_SYM_in_function_call2619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING_SYM198_tree = (CommonTree)adaptor.create(USING_SYM198);
                    adaptor.addChild(root_0, USING_SYM198_tree);
                    }
                    pushFollow(FOLLOW_transcoding_name_in_function_call2621);
                    transcoding_name199=transcoding_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transcoding_name199.getTree());
                    RPAREN200=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function_call2623); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN200_tree = (CommonTree)adaptor.create(RPAREN200);
                    adaptor.addChild(root_0, RPAREN200_tree);
                    }

                    }


                    }
                    break;
                case 5 :
                    // MySQL.g:430:4: ( group_functions ( LPAREN ( ASTERISK | ALL | DISTINCT )? ( bit_expr )? RPAREN )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:430:4: ( group_functions ( LPAREN ( ASTERISK | ALL | DISTINCT )? ( bit_expr )? RPAREN )? )
                    // MySQL.g:430:7: group_functions ( LPAREN ( ASTERISK | ALL | DISTINCT )? ( bit_expr )? RPAREN )?
                    {
                    pushFollow(FOLLOW_group_functions_in_function_call2634);
                    group_functions201=group_functions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, group_functions201.getTree());
                    // MySQL.g:430:23: ( LPAREN ( ASTERISK | ALL | DISTINCT )? ( bit_expr )? RPAREN )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==LPAREN) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // MySQL.g:430:25: LPAREN ( ASTERISK | ALL | DISTINCT )? ( bit_expr )? RPAREN
                            {
                            LPAREN202=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function_call2638); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LPAREN202_tree = (CommonTree)adaptor.create(LPAREN202);
                            adaptor.addChild(root_0, LPAREN202_tree);
                            }
                            // MySQL.g:430:32: ( ASTERISK | ALL | DISTINCT )?
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( (LA43_0==ALL||LA43_0==DISTINCT||LA43_0==ASTERISK) ) {
                                alt43=1;
                            }
                            switch (alt43) {
                                case 1 :
                                    // MySQL.g:
                                    {
                                    set203=(Token)input.LT(1);
                                    if ( input.LA(1)==ALL||input.LA(1)==DISTINCT||input.LA(1)==ASTERISK ) {
                                        input.consume();
                                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set203));
                                        state.errorRecovery=false;state.failed=false;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return retval;}
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        throw mse;
                                    }


                                    }
                                    break;

                            }

                            // MySQL.g:430:63: ( bit_expr )?
                            int alt44=2;
                            int LA44_0 = input.LA(1);

                            if ( ((LA44_0>=ABS && LA44_0<=ACOS)||(LA44_0>=ADDDATE && LA44_0<=AES_ENCRYPT)||(LA44_0>=ASCII_SYM && LA44_0<=ASIN)||(LA44_0>=ATAN && LA44_0<=ATAN2)||LA44_0==AVG||LA44_0==BENCHMARK||(LA44_0>=BIN && LA44_0<=BIT_OR)||LA44_0==BIT_XOR||(LA44_0>=CASE_SYM && LA44_0<=CEILING)||(LA44_0>=CHAR && LA44_0<=CHAR_LENGTH)||LA44_0==CHARSET||LA44_0==COERCIBILITY||LA44_0==COLLATION||(LA44_0>=CONCAT && LA44_0<=CONCAT_WS)||LA44_0==CONNECTION_ID||(LA44_0>=CONV && LA44_0<=CONVERT_TZ)||(LA44_0>=COS && LA44_0<=COUNT)||LA44_0==CRC32||LA44_0==CURDATE||(LA44_0>=CURRENT_USER && LA44_0<=DATABASE)||(LA44_0>=DATE_ADD && LA44_0<=DATEDIFF)||LA44_0==DAY_SYM||(LA44_0>=DAYNAME && LA44_0<=DAYOFYEAR)||(LA44_0>=DECODE && LA44_0<=DEFAULT)||LA44_0==DEGREES||(LA44_0>=DES_DECRYPT && LA44_0<=DES_ENCRYPT)||LA44_0==ELT||(LA44_0>=ENCODE && LA44_0<=ENCRYPT)||(LA44_0>=EXISTS && LA44_0<=EXP)||(LA44_0>=EXPORT_SET && LA44_0<=FALSE_SYM)||LA44_0==FIELD||LA44_0==FIND_IN_SET||LA44_0==FLOOR||(LA44_0>=FORMAT && LA44_0<=FOUND_ROWS)||(LA44_0>=FROM_BASE64 && LA44_0<=FROM_UNIXTIME)||(LA44_0>=GET_FORMAT && LA44_0<=GET_LOCK)||LA44_0==GROUP_CONCAT||LA44_0==HEX||LA44_0==HOUR||(LA44_0>=IF && LA44_0<=IFNULL)||(LA44_0>=INET_ATON && LA44_0<=INET_NTOA)||LA44_0==INSERT||LA44_0==INSTR||LA44_0==INTERVAL_SYM||LA44_0==IS_FREE_LOCK||LA44_0==IS_USED_LOCK||(LA44_0>=LAST_DAY && LA44_0<=LAST_INSERT_ID)||(LA44_0>=LEFT && LA44_0<=LENGTH)||LA44_0==LN||LA44_0==LOAD_FILE||LA44_0==LOCATE||(LA44_0>=LOG && LA44_0<=LOG2)||(LA44_0>=LOWER && LA44_0<=LTRIM)||(LA44_0>=MAKE_SET && LA44_0<=MAX_SYM)||LA44_0==MD5||(LA44_0>=MICROSECOND && LA44_0<=MIN_SYM)||LA44_0==MINUTE||LA44_0==MOD||(LA44_0>=MONTH && LA44_0<=NAME_CONST)||(LA44_0>=NOW && LA44_0<=NULL_SYM)||LA44_0==OCT||LA44_0==OLD_PASSWORD||LA44_0==ORD||(LA44_0>=PASSWORD && LA44_0<=PI)||(LA44_0>=POW && LA44_0<=POWER)||LA44_0==QUARTER||(LA44_0>=QUOTE && LA44_0<=RAND)||LA44_0==RELEASE_LOCK||(LA44_0>=REPEAT && LA44_0<=REPLACE)||(LA44_0>=REVERSE && LA44_0<=RIGHT)||LA44_0==ROUND||LA44_0==ROW_SYM||(LA44_0>=RPAD && LA44_0<=RTRIM)||(LA44_0>=SCHEMA && LA44_0<=SECOND)||LA44_0==SESSION_USER||LA44_0==SIGN||LA44_0==SIN||LA44_0==SLEEP||LA44_0==SOUNDEX||LA44_0==SPACE||LA44_0==SQRT||(LA44_0>=STD && LA44_0<=STDDEV_SAMP)||LA44_0==STR_TO_DATE||LA44_0==STRCMP||(LA44_0>=SUBSTRING && LA44_0<=SUM)||(LA44_0>=SYSDATE && LA44_0<=SYSTEM_USER)||LA44_0==TAN||(LA44_0>=TIME_FORMAT && LA44_0<=TIMESTAMPDIFF)||(LA44_0>=TO_BASE64 && LA44_0<=TO_SECONDS)||(LA44_0>=TRIM && LA44_0<=TRUNCATE)||LA44_0==UNHEX||LA44_0==UNIX_TIMESTAMP||LA44_0==UPPER||LA44_0==USER||(LA44_0>=UTC_DATE && LA44_0<=UTC_TIMESTAMP)||LA44_0==UUID||(LA44_0>=VALUES && LA44_0<=VAR_SAMP)||(LA44_0>=VARIANCE && LA44_0<=VERSION_SYM)||(LA44_0>=WEEK && LA44_0<=WEIGHT_STRING)||(LA44_0>=LPAREN && LA44_0<=YEAR_FUNC)||LA44_0==YEARWEEK||(LA44_0>=PLUS && LA44_0<=NEGATION)||LA44_0==INTEGER_NUM||(LA44_0>=HEX_DIGIT && LA44_0<=ID)||LA44_0==USER_VAR) ) {
                                alt44=1;
                            }
                            switch (alt44) {
                                case 1 :
                                    // MySQL.g:0:0: bit_expr
                                    {
                                    pushFollow(FOLLOW_bit_expr_in_function_call2655);
                                    bit_expr204=bit_expr();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr204.getTree());

                                    }
                                    break;

                            }

                            RPAREN205=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function_call2658); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RPAREN205_tree = (CommonTree)adaptor.create(RPAREN205);
                            adaptor.addChild(root_0, RPAREN205_tree);
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 6 :
                    // MySQL.g:431:4: ( special_functions )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:431:4: ( special_functions )
                    // MySQL.g:431:6: special_functions
                    {
                    pushFollow(FOLLOW_special_functions_in_function_call2671);
                    special_functions206=special_functions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, special_functions206.getTree());

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 806, function_call_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "function_call"

    public static class case_when_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "case_when_statement"
    // MySQL.g:434:1: case_when_statement : ( case_when_statement1 | case_when_statement2 );
    public final MySQLParser.case_when_statement_return case_when_statement() throws RecognitionException {
        MySQLParser.case_when_statement_return retval = new MySQLParser.case_when_statement_return();
        retval.start = input.LT(1);
        int case_when_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQLParser.case_when_statement1_return case_when_statement1207 = null;

        MySQLParser.case_when_statement2_return case_when_statement2208 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 807) ) { return retval; }
            // MySQL.g:434:20: ( case_when_statement1 | case_when_statement2 )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==CASE_SYM) ) {
                int LA47_1 = input.LA(2);

                if ( ((LA47_1>=ABS && LA47_1<=ACOS)||(LA47_1>=ADDDATE && LA47_1<=AES_ENCRYPT)||(LA47_1>=ASCII_SYM && LA47_1<=ASIN)||(LA47_1>=ATAN && LA47_1<=ATAN2)||LA47_1==AVG||LA47_1==BENCHMARK||(LA47_1>=BIN && LA47_1<=BIT_OR)||LA47_1==BIT_XOR||(LA47_1>=CASE_SYM && LA47_1<=CEILING)||(LA47_1>=CHAR && LA47_1<=CHAR_LENGTH)||LA47_1==CHARSET||LA47_1==COERCIBILITY||LA47_1==COLLATION||(LA47_1>=CONCAT && LA47_1<=CONCAT_WS)||LA47_1==CONNECTION_ID||(LA47_1>=CONV && LA47_1<=CONVERT_TZ)||(LA47_1>=COS && LA47_1<=COUNT)||LA47_1==CRC32||LA47_1==CURDATE||(LA47_1>=CURRENT_USER && LA47_1<=DATABASE)||(LA47_1>=DATE_ADD && LA47_1<=DATEDIFF)||LA47_1==DAY_SYM||(LA47_1>=DAYNAME && LA47_1<=DAYOFYEAR)||(LA47_1>=DECODE && LA47_1<=DEFAULT)||LA47_1==DEGREES||(LA47_1>=DES_DECRYPT && LA47_1<=DES_ENCRYPT)||LA47_1==ELT||(LA47_1>=ENCODE && LA47_1<=ENCRYPT)||(LA47_1>=EXISTS && LA47_1<=EXP)||(LA47_1>=EXPORT_SET && LA47_1<=FALSE_SYM)||LA47_1==FIELD||LA47_1==FIND_IN_SET||LA47_1==FLOOR||(LA47_1>=FORMAT && LA47_1<=FOUND_ROWS)||(LA47_1>=FROM_BASE64 && LA47_1<=FROM_UNIXTIME)||(LA47_1>=GET_FORMAT && LA47_1<=GET_LOCK)||LA47_1==GROUP_CONCAT||LA47_1==HEX||LA47_1==HOUR||(LA47_1>=IF && LA47_1<=IFNULL)||(LA47_1>=INET_ATON && LA47_1<=INET_NTOA)||LA47_1==INSERT||LA47_1==INSTR||LA47_1==INTERVAL_SYM||LA47_1==IS_FREE_LOCK||LA47_1==IS_USED_LOCK||(LA47_1>=LAST_DAY && LA47_1<=LAST_INSERT_ID)||(LA47_1>=LEFT && LA47_1<=LENGTH)||LA47_1==LN||LA47_1==LOAD_FILE||LA47_1==LOCATE||(LA47_1>=LOG && LA47_1<=LOG2)||(LA47_1>=LOWER && LA47_1<=LTRIM)||(LA47_1>=MAKE_SET && LA47_1<=MAX_SYM)||LA47_1==MD5||(LA47_1>=MICROSECOND && LA47_1<=MIN_SYM)||LA47_1==MINUTE||LA47_1==MOD||(LA47_1>=MONTH && LA47_1<=NAME_CONST)||(LA47_1>=NOW && LA47_1<=NULL_SYM)||LA47_1==OCT||LA47_1==OLD_PASSWORD||LA47_1==ORD||(LA47_1>=PASSWORD && LA47_1<=PI)||(LA47_1>=POW && LA47_1<=POWER)||LA47_1==QUARTER||(LA47_1>=QUOTE && LA47_1<=RAND)||LA47_1==RELEASE_LOCK||(LA47_1>=REPEAT && LA47_1<=REPLACE)||(LA47_1>=REVERSE && LA47_1<=RIGHT)||LA47_1==ROUND||LA47_1==ROW_SYM||(LA47_1>=RPAD && LA47_1<=RTRIM)||(LA47_1>=SCHEMA && LA47_1<=SECOND)||LA47_1==SESSION_USER||LA47_1==SIGN||LA47_1==SIN||LA47_1==SLEEP||LA47_1==SOUNDEX||LA47_1==SPACE||LA47_1==SQRT||(LA47_1>=STD && LA47_1<=STDDEV_SAMP)||LA47_1==STR_TO_DATE||LA47_1==STRCMP||(LA47_1>=SUBSTRING && LA47_1<=SUM)||(LA47_1>=SYSDATE && LA47_1<=SYSTEM_USER)||LA47_1==TAN||(LA47_1>=TIME_FORMAT && LA47_1<=TIMESTAMPDIFF)||(LA47_1>=TO_BASE64 && LA47_1<=TO_SECONDS)||(LA47_1>=TRIM && LA47_1<=TRUNCATE)||LA47_1==UNHEX||LA47_1==UNIX_TIMESTAMP||LA47_1==UPPER||LA47_1==USER||(LA47_1>=UTC_DATE && LA47_1<=UTC_TIMESTAMP)||LA47_1==UUID||(LA47_1>=VALUES && LA47_1<=VAR_SAMP)||(LA47_1>=VARIANCE && LA47_1<=VERSION_SYM)||(LA47_1>=WEEK && LA47_1<=WEIGHT_STRING)||(LA47_1>=LPAREN && LA47_1<=YEAR_FUNC)||LA47_1==YEARWEEK||(LA47_1>=PLUS && LA47_1<=NEGATION)||LA47_1==INTEGER_NUM||(LA47_1>=HEX_DIGIT && LA47_1<=ID)||LA47_1==USER_VAR) ) {
                    alt47=2;
                }
                else if ( (LA47_1==WHEN_SYM) ) {
                    alt47=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // MySQL.g:435:9: case_when_statement1
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_case_when_statement1_in_case_when_statement2689);
                    case_when_statement1207=case_when_statement1();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, case_when_statement1207.getTree());

                    }
                    break;
                case 2 :
                    // MySQL.g:435:32: case_when_statement2
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_case_when_statement2_in_case_when_statement2693);
                    case_when_statement2208=case_when_statement2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, case_when_statement2208.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 807, case_when_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "case_when_statement"

    public static class case_when_statement1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "case_when_statement1"
    // MySQL.g:437:1: case_when_statement1 : CASE_SYM ( WHEN_SYM expression THEN_SYM bit_expr )+ ( ELSE_SYM bit_expr )? END_SYM ;
    public final MySQLParser.case_when_statement1_return case_when_statement1() throws RecognitionException {
        MySQLParser.case_when_statement1_return retval = new MySQLParser.case_when_statement1_return();
        retval.start = input.LT(1);
        int case_when_statement1_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CASE_SYM209=null;
        Token WHEN_SYM210=null;
        Token THEN_SYM212=null;
        Token ELSE_SYM214=null;
        Token END_SYM216=null;
        MySQLParser.expression_return expression211 = null;

        MySQLParser.bit_expr_return bit_expr213 = null;

        MySQLParser.bit_expr_return bit_expr215 = null;


        CommonTree CASE_SYM209_tree=null;
        CommonTree WHEN_SYM210_tree=null;
        CommonTree THEN_SYM212_tree=null;
        CommonTree ELSE_SYM214_tree=null;
        CommonTree END_SYM216_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 808) ) { return retval; }
            // MySQL.g:437:21: ( CASE_SYM ( WHEN_SYM expression THEN_SYM bit_expr )+ ( ELSE_SYM bit_expr )? END_SYM )
            // MySQL.g:438:9: CASE_SYM ( WHEN_SYM expression THEN_SYM bit_expr )+ ( ELSE_SYM bit_expr )? END_SYM
            {
            root_0 = (CommonTree)adaptor.nil();

            CASE_SYM209=(Token)match(input,CASE_SYM,FOLLOW_CASE_SYM_in_case_when_statement12708); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_SYM209_tree = (CommonTree)adaptor.create(CASE_SYM209);
            adaptor.addChild(root_0, CASE_SYM209_tree);
            }
            // MySQL.g:439:9: ( WHEN_SYM expression THEN_SYM bit_expr )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==WHEN_SYM) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // MySQL.g:439:11: WHEN_SYM expression THEN_SYM bit_expr
            	    {
            	    WHEN_SYM210=(Token)match(input,WHEN_SYM,FOLLOW_WHEN_SYM_in_case_when_statement12720); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    WHEN_SYM210_tree = (CommonTree)adaptor.create(WHEN_SYM210);
            	    adaptor.addChild(root_0, WHEN_SYM210_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_case_when_statement12722);
            	    expression211=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression211.getTree());
            	    THEN_SYM212=(Token)match(input,THEN_SYM,FOLLOW_THEN_SYM_in_case_when_statement12724); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    THEN_SYM212_tree = (CommonTree)adaptor.create(THEN_SYM212);
            	    adaptor.addChild(root_0, THEN_SYM212_tree);
            	    }
            	    pushFollow(FOLLOW_bit_expr_in_case_when_statement12726);
            	    bit_expr213=bit_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr213.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);

            // MySQL.g:440:9: ( ELSE_SYM bit_expr )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==ELSE_SYM) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // MySQL.g:440:11: ELSE_SYM bit_expr
                    {
                    ELSE_SYM214=(Token)match(input,ELSE_SYM,FOLLOW_ELSE_SYM_in_case_when_statement12741); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ELSE_SYM214_tree = (CommonTree)adaptor.create(ELSE_SYM214);
                    adaptor.addChild(root_0, ELSE_SYM214_tree);
                    }
                    pushFollow(FOLLOW_bit_expr_in_case_when_statement12743);
                    bit_expr215=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr215.getTree());

                    }
                    break;

            }

            END_SYM216=(Token)match(input,END_SYM,FOLLOW_END_SYM_in_case_when_statement12756); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            END_SYM216_tree = (CommonTree)adaptor.create(END_SYM216);
            adaptor.addChild(root_0, END_SYM216_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 808, case_when_statement1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "case_when_statement1"

    public static class case_when_statement2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "case_when_statement2"
    // MySQL.g:443:1: case_when_statement2 : CASE_SYM bit_expr ( WHEN_SYM bit_expr THEN_SYM bit_expr )+ ( ELSE_SYM bit_expr )? END_SYM ;
    public final MySQLParser.case_when_statement2_return case_when_statement2() throws RecognitionException {
        MySQLParser.case_when_statement2_return retval = new MySQLParser.case_when_statement2_return();
        retval.start = input.LT(1);
        int case_when_statement2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CASE_SYM217=null;
        Token WHEN_SYM219=null;
        Token THEN_SYM221=null;
        Token ELSE_SYM223=null;
        Token END_SYM225=null;
        MySQLParser.bit_expr_return bit_expr218 = null;

        MySQLParser.bit_expr_return bit_expr220 = null;

        MySQLParser.bit_expr_return bit_expr222 = null;

        MySQLParser.bit_expr_return bit_expr224 = null;


        CommonTree CASE_SYM217_tree=null;
        CommonTree WHEN_SYM219_tree=null;
        CommonTree THEN_SYM221_tree=null;
        CommonTree ELSE_SYM223_tree=null;
        CommonTree END_SYM225_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 809) ) { return retval; }
            // MySQL.g:443:21: ( CASE_SYM bit_expr ( WHEN_SYM bit_expr THEN_SYM bit_expr )+ ( ELSE_SYM bit_expr )? END_SYM )
            // MySQL.g:444:9: CASE_SYM bit_expr ( WHEN_SYM bit_expr THEN_SYM bit_expr )+ ( ELSE_SYM bit_expr )? END_SYM
            {
            root_0 = (CommonTree)adaptor.nil();

            CASE_SYM217=(Token)match(input,CASE_SYM,FOLLOW_CASE_SYM_in_case_when_statement22771); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_SYM217_tree = (CommonTree)adaptor.create(CASE_SYM217);
            adaptor.addChild(root_0, CASE_SYM217_tree);
            }
            pushFollow(FOLLOW_bit_expr_in_case_when_statement22773);
            bit_expr218=bit_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr218.getTree());
            // MySQL.g:445:9: ( WHEN_SYM bit_expr THEN_SYM bit_expr )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==WHEN_SYM) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // MySQL.g:445:11: WHEN_SYM bit_expr THEN_SYM bit_expr
            	    {
            	    WHEN_SYM219=(Token)match(input,WHEN_SYM,FOLLOW_WHEN_SYM_in_case_when_statement22785); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    WHEN_SYM219_tree = (CommonTree)adaptor.create(WHEN_SYM219);
            	    adaptor.addChild(root_0, WHEN_SYM219_tree);
            	    }
            	    pushFollow(FOLLOW_bit_expr_in_case_when_statement22787);
            	    bit_expr220=bit_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr220.getTree());
            	    THEN_SYM221=(Token)match(input,THEN_SYM,FOLLOW_THEN_SYM_in_case_when_statement22789); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    THEN_SYM221_tree = (CommonTree)adaptor.create(THEN_SYM221);
            	    adaptor.addChild(root_0, THEN_SYM221_tree);
            	    }
            	    pushFollow(FOLLOW_bit_expr_in_case_when_statement22791);
            	    bit_expr222=bit_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr222.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);

            // MySQL.g:446:9: ( ELSE_SYM bit_expr )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==ELSE_SYM) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // MySQL.g:446:11: ELSE_SYM bit_expr
                    {
                    ELSE_SYM223=(Token)match(input,ELSE_SYM,FOLLOW_ELSE_SYM_in_case_when_statement22806); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ELSE_SYM223_tree = (CommonTree)adaptor.create(ELSE_SYM223);
                    adaptor.addChild(root_0, ELSE_SYM223_tree);
                    }
                    pushFollow(FOLLOW_bit_expr_in_case_when_statement22808);
                    bit_expr224=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr224.getTree());

                    }
                    break;

            }

            END_SYM225=(Token)match(input,END_SYM,FOLLOW_END_SYM_in_case_when_statement22821); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            END_SYM225_tree = (CommonTree)adaptor.create(END_SYM225);
            adaptor.addChild(root_0, END_SYM225_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 809, case_when_statement2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "case_when_statement2"

    public static class match_against_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "match_against_statement"
    // MySQL.g:450:1: match_against_statement : MATCH ( column_spec ( COMMA column_spec )* ) AGAINST ( expression ( search_modifier )? ) ;
    public final MySQLParser.match_against_statement_return match_against_statement() throws RecognitionException {
        MySQLParser.match_against_statement_return retval = new MySQLParser.match_against_statement_return();
        retval.start = input.LT(1);
        int match_against_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token MATCH226=null;
        Token COMMA228=null;
        Token AGAINST230=null;
        MySQLParser.column_spec_return column_spec227 = null;

        MySQLParser.column_spec_return column_spec229 = null;

        MySQLParser.expression_return expression231 = null;

        MySQLParser.search_modifier_return search_modifier232 = null;


        CommonTree MATCH226_tree=null;
        CommonTree COMMA228_tree=null;
        CommonTree AGAINST230_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 810) ) { return retval; }
            // MySQL.g:450:24: ( MATCH ( column_spec ( COMMA column_spec )* ) AGAINST ( expression ( search_modifier )? ) )
            // MySQL.g:451:2: MATCH ( column_spec ( COMMA column_spec )* ) AGAINST ( expression ( search_modifier )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            MATCH226=(Token)match(input,MATCH,FOLLOW_MATCH_in_match_against_statement2831); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MATCH226_tree = (CommonTree)adaptor.create(MATCH226);
            adaptor.addChild(root_0, MATCH226_tree);
            }
            // MySQL.g:451:8: ( column_spec ( COMMA column_spec )* )
            // MySQL.g:451:9: column_spec ( COMMA column_spec )*
            {
            pushFollow(FOLLOW_column_spec_in_match_against_statement2834);
            column_spec227=column_spec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec227.getTree());
            // MySQL.g:451:21: ( COMMA column_spec )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==COMMA) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // MySQL.g:451:22: COMMA column_spec
            	    {
            	    COMMA228=(Token)match(input,COMMA,FOLLOW_COMMA_in_match_against_statement2837); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA228_tree = (CommonTree)adaptor.create(COMMA228);
            	    adaptor.addChild(root_0, COMMA228_tree);
            	    }
            	    pushFollow(FOLLOW_column_spec_in_match_against_statement2839);
            	    column_spec229=column_spec();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec229.getTree());

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }

            AGAINST230=(Token)match(input,AGAINST,FOLLOW_AGAINST_in_match_against_statement2845); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AGAINST230_tree = (CommonTree)adaptor.create(AGAINST230);
            adaptor.addChild(root_0, AGAINST230_tree);
            }
            // MySQL.g:451:52: ( expression ( search_modifier )? )
            // MySQL.g:451:53: expression ( search_modifier )?
            {
            pushFollow(FOLLOW_expression_in_match_against_statement2848);
            expression231=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression231.getTree());
            // MySQL.g:451:64: ( search_modifier )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==IN_SYM) ) {
                int LA53_1 = input.LA(2);

                if ( (synpred342_MySQL()) ) {
                    alt53=1;
                }
            }
            else if ( (LA53_0==WITH) ) {
                int LA53_2 = input.LA(2);

                if ( (synpred342_MySQL()) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // MySQL.g:451:65: search_modifier
                    {
                    pushFollow(FOLLOW_search_modifier_in_match_against_statement2851);
                    search_modifier232=search_modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, search_modifier232.getTree());

                    }
                    break;

            }


            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 810, match_against_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "match_against_statement"

    public static class column_spec_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "column_spec"
    // MySQL.g:454:1: column_spec : ( table_name DOT )? column_name ;
    public final MySQLParser.column_spec_return column_spec() throws RecognitionException {
        MySQLParser.column_spec_return retval = new MySQLParser.column_spec_return();
        retval.start = input.LT(1);
        int column_spec_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DOT234=null;
        MySQLParser.table_name_return table_name233 = null;

        MySQLParser.column_name_return column_name235 = null;


        CommonTree DOT234_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 811) ) { return retval; }
            // MySQL.g:454:12: ( ( table_name DOT )? column_name )
            // MySQL.g:455:2: ( table_name DOT )? column_name
            {
            root_0 = (CommonTree)adaptor.nil();

            // MySQL.g:455:2: ( table_name DOT )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==ID) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==DOT) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // MySQL.g:455:4: table_name DOT
                    {
                    pushFollow(FOLLOW_table_name_in_column_spec2867);
                    table_name233=table_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name233.getTree());
                    DOT234=(Token)match(input,DOT,FOLLOW_DOT_in_column_spec2869); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOT234_tree = (CommonTree)adaptor.create(DOT234);
                    adaptor.addChild(root_0, DOT234_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_column_name_in_column_spec2874);
            column_name235=column_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column_name235.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 811, column_spec_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "column_spec"

    public static class expression_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression_list"
    // MySQL.g:457:1: expression_list : LPAREN expression ( COMMA expression )* RPAREN ;
    public final MySQLParser.expression_list_return expression_list() throws RecognitionException {
        MySQLParser.expression_list_return retval = new MySQLParser.expression_list_return();
        retval.start = input.LT(1);
        int expression_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LPAREN236=null;
        Token COMMA238=null;
        Token RPAREN240=null;
        MySQLParser.expression_return expression237 = null;

        MySQLParser.expression_return expression239 = null;


        CommonTree LPAREN236_tree=null;
        CommonTree COMMA238_tree=null;
        CommonTree RPAREN240_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 812) ) { return retval; }
            // MySQL.g:457:16: ( LPAREN expression ( COMMA expression )* RPAREN )
            // MySQL.g:458:2: LPAREN expression ( COMMA expression )* RPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAREN236=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expression_list2882); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN236_tree = (CommonTree)adaptor.create(LPAREN236);
            adaptor.addChild(root_0, LPAREN236_tree);
            }
            pushFollow(FOLLOW_expression_in_expression_list2884);
            expression237=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression237.getTree());
            // MySQL.g:458:20: ( COMMA expression )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==COMMA) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // MySQL.g:458:22: COMMA expression
            	    {
            	    COMMA238=(Token)match(input,COMMA,FOLLOW_COMMA_in_expression_list2888); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA238_tree = (CommonTree)adaptor.create(COMMA238);
            	    adaptor.addChild(root_0, COMMA238_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression_list2890);
            	    expression239=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression239.getTree());

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            RPAREN240=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expression_list2895); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN240_tree = (CommonTree)adaptor.create(RPAREN240);
            adaptor.addChild(root_0, RPAREN240_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 812, expression_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expression_list"

    public static class interval_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "interval_expr"
    // MySQL.g:460:1: interval_expr : INTERVAL_SYM expression interval_unit ;
    public final MySQLParser.interval_expr_return interval_expr() throws RecognitionException {
        MySQLParser.interval_expr_return retval = new MySQLParser.interval_expr_return();
        retval.start = input.LT(1);
        int interval_expr_StartIndex = input.index();
        CommonTree root_0 = null;

        Token INTERVAL_SYM241=null;
        MySQLParser.expression_return expression242 = null;

        MySQLParser.interval_unit_return interval_unit243 = null;


        CommonTree INTERVAL_SYM241_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 813) ) { return retval; }
            // MySQL.g:460:14: ( INTERVAL_SYM expression interval_unit )
            // MySQL.g:461:2: INTERVAL_SYM expression interval_unit
            {
            root_0 = (CommonTree)adaptor.nil();

            INTERVAL_SYM241=(Token)match(input,INTERVAL_SYM,FOLLOW_INTERVAL_SYM_in_interval_expr2904); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTERVAL_SYM241_tree = (CommonTree)adaptor.create(INTERVAL_SYM241);
            adaptor.addChild(root_0, INTERVAL_SYM241_tree);
            }
            pushFollow(FOLLOW_expression_in_interval_expr2906);
            expression242=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression242.getTree());
            pushFollow(FOLLOW_interval_unit_in_interval_expr2908);
            interval_unit243=interval_unit();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, interval_unit243.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 813, interval_expr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "interval_expr"

    public static class table_references_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table_references"
    // MySQL.g:465:1: table_references : table_reference ( COMMA table_reference )* ;
    public final MySQLParser.table_references_return table_references() throws RecognitionException {
        MySQLParser.table_references_return retval = new MySQLParser.table_references_return();
        retval.start = input.LT(1);
        int table_references_StartIndex = input.index();
        CommonTree root_0 = null;

        Token COMMA245=null;
        MySQLParser.table_reference_return table_reference244 = null;

        MySQLParser.table_reference_return table_reference246 = null;


        CommonTree COMMA245_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 814) ) { return retval; }
            // MySQL.g:465:17: ( table_reference ( COMMA table_reference )* )
            // MySQL.g:466:9: table_reference ( COMMA table_reference )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_table_reference_in_table_references2925);
            table_reference244=table_reference();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_reference244.getTree());
            // MySQL.g:466:25: ( COMMA table_reference )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==COMMA) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // MySQL.g:466:27: COMMA table_reference
            	    {
            	    COMMA245=(Token)match(input,COMMA,FOLLOW_COMMA_in_table_references2929); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA245_tree = (CommonTree)adaptor.create(COMMA245);
            	    adaptor.addChild(root_0, COMMA245_tree);
            	    }
            	    pushFollow(FOLLOW_table_reference_in_table_references2931);
            	    table_reference246=table_reference();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, table_reference246.getTree());

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 814, table_references_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "table_references"

    public static class table_reference_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table_reference"
    // MySQL.g:469:1: table_reference : table_atom ( join_table )* ;
    public final MySQLParser.table_reference_return table_reference() throws RecognitionException {
        MySQLParser.table_reference_return retval = new MySQLParser.table_reference_return();
        retval.start = input.LT(1);
        int table_reference_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQLParser.table_atom_return table_atom247 = null;

        MySQLParser.join_table_return join_table248 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 815) ) { return retval; }
            // MySQL.g:469:16: ( table_atom ( join_table )* )
            // MySQL.g:470:2: table_atom ( join_table )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_table_atom_in_table_reference2943);
            table_atom247=table_atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_atom247.getTree());
            // MySQL.g:470:13: ( join_table )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==CROSS||LA57_0==INNER_SYM||LA57_0==JOIN_SYM||LA57_0==LEFT||LA57_0==NATURAL||LA57_0==RIGHT||LA57_0==STRAIGHT_JOIN) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // MySQL.g:0:0: join_table
            	    {
            	    pushFollow(FOLLOW_join_table_in_table_reference2945);
            	    join_table248=join_table();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, join_table248.getTree());

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 815, table_reference_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "table_reference"

    public static class join_table_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "join_table"
    // MySQL.g:472:1: join_table : ( ( join_qualifier1 )? JOIN_SYM table_atom ( join_condition )? -> ^( TN_JOIN ( ^( TN_JOIN_QUALIFIER join_qualifier1 ) )? ^( TN_JOIN_TABLE table_atom ) ( ^( join_condition ) )? ) | STRAIGHT_JOIN table_atom ( ON expression )? | ( join_qualifier2 ) ( OUTER )? JOIN_SYM table_atom join_condition -> ^( TN_JOIN ^( TN_JOIN_QUALIFIER join_qualifier2 ( OUTER )? ) ^( TN_JOIN_TABLE table_atom ) ^( join_condition ) ) | NATURAL ( ( LEFT | RIGHT ) ( OUTER )? )? JOIN_SYM table_atom );
    public final MySQLParser.join_table_return join_table() throws RecognitionException {
        MySQLParser.join_table_return retval = new MySQLParser.join_table_return();
        retval.start = input.LT(1);
        int join_table_StartIndex = input.index();
        CommonTree root_0 = null;

        Token JOIN_SYM250=null;
        Token STRAIGHT_JOIN253=null;
        Token ON255=null;
        Token OUTER258=null;
        Token JOIN_SYM259=null;
        Token NATURAL262=null;
        Token set263=null;
        Token OUTER264=null;
        Token JOIN_SYM265=null;
        MySQLParser.join_qualifier1_return join_qualifier1249 = null;

        MySQLParser.table_atom_return table_atom251 = null;

        MySQLParser.join_condition_return join_condition252 = null;

        MySQLParser.table_atom_return table_atom254 = null;

        MySQLParser.expression_return expression256 = null;

        MySQLParser.join_qualifier2_return join_qualifier2257 = null;

        MySQLParser.table_atom_return table_atom260 = null;

        MySQLParser.join_condition_return join_condition261 = null;

        MySQLParser.table_atom_return table_atom266 = null;


        CommonTree JOIN_SYM250_tree=null;
        CommonTree STRAIGHT_JOIN253_tree=null;
        CommonTree ON255_tree=null;
        CommonTree OUTER258_tree=null;
        CommonTree JOIN_SYM259_tree=null;
        CommonTree NATURAL262_tree=null;
        CommonTree set263_tree=null;
        CommonTree OUTER264_tree=null;
        CommonTree JOIN_SYM265_tree=null;
        RewriteRuleTokenStream stream_OUTER=new RewriteRuleTokenStream(adaptor,"token OUTER");
        RewriteRuleTokenStream stream_JOIN_SYM=new RewriteRuleTokenStream(adaptor,"token JOIN_SYM");
        RewriteRuleSubtreeStream stream_table_atom=new RewriteRuleSubtreeStream(adaptor,"rule table_atom");
        RewriteRuleSubtreeStream stream_join_qualifier1=new RewriteRuleSubtreeStream(adaptor,"rule join_qualifier1");
        RewriteRuleSubtreeStream stream_join_qualifier2=new RewriteRuleSubtreeStream(adaptor,"rule join_qualifier2");
        RewriteRuleSubtreeStream stream_join_condition=new RewriteRuleSubtreeStream(adaptor,"rule join_condition");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 816) ) { return retval; }
            // MySQL.g:472:11: ( ( join_qualifier1 )? JOIN_SYM table_atom ( join_condition )? -> ^( TN_JOIN ( ^( TN_JOIN_QUALIFIER join_qualifier1 ) )? ^( TN_JOIN_TABLE table_atom ) ( ^( join_condition ) )? ) | STRAIGHT_JOIN table_atom ( ON expression )? | ( join_qualifier2 ) ( OUTER )? JOIN_SYM table_atom join_condition -> ^( TN_JOIN ^( TN_JOIN_QUALIFIER join_qualifier2 ( OUTER )? ) ^( TN_JOIN_TABLE table_atom ) ^( join_condition ) ) | NATURAL ( ( LEFT | RIGHT ) ( OUTER )? )? JOIN_SYM table_atom )
            int alt64=4;
            switch ( input.LA(1) ) {
            case CROSS:
            case INNER_SYM:
            case JOIN_SYM:
                {
                alt64=1;
                }
                break;
            case STRAIGHT_JOIN:
                {
                alt64=2;
                }
                break;
            case LEFT:
            case RIGHT:
                {
                alt64=3;
                }
                break;
            case NATURAL:
                {
                alt64=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // MySQL.g:473:2: ( join_qualifier1 )? JOIN_SYM table_atom ( join_condition )?
                    {
                    // MySQL.g:473:2: ( join_qualifier1 )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==CROSS||LA58_0==INNER_SYM) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // MySQL.g:473:3: join_qualifier1
                            {
                            pushFollow(FOLLOW_join_qualifier1_in_join_table2956);
                            join_qualifier1249=join_qualifier1();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_join_qualifier1.add(join_qualifier1249.getTree());

                            }
                            break;

                    }

                    JOIN_SYM250=(Token)match(input,JOIN_SYM,FOLLOW_JOIN_SYM_in_join_table2960); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_JOIN_SYM.add(JOIN_SYM250);

                    pushFollow(FOLLOW_table_atom_in_join_table2962);
                    table_atom251=table_atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_table_atom.add(table_atom251.getTree());
                    // MySQL.g:473:41: ( join_condition )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==ON) ) {
                        int LA59_1 = input.LA(2);

                        if ( ((LA59_1>=ABS && LA59_1<=ACOS)||(LA59_1>=ADDDATE && LA59_1<=AES_ENCRYPT)||(LA59_1>=ASCII_SYM && LA59_1<=ASIN)||(LA59_1>=ATAN && LA59_1<=ATAN2)||LA59_1==AVG||LA59_1==BENCHMARK||(LA59_1>=BIN && LA59_1<=BIT_OR)||LA59_1==BIT_XOR||(LA59_1>=CASE_SYM && LA59_1<=CEILING)||(LA59_1>=CHAR && LA59_1<=CHAR_LENGTH)||LA59_1==CHARSET||LA59_1==COERCIBILITY||LA59_1==COLLATION||(LA59_1>=CONCAT && LA59_1<=CONCAT_WS)||LA59_1==CONNECTION_ID||(LA59_1>=CONV && LA59_1<=CONVERT_TZ)||(LA59_1>=COS && LA59_1<=COUNT)||LA59_1==CRC32||LA59_1==CURDATE||(LA59_1>=CURRENT_USER && LA59_1<=DATABASE)||(LA59_1>=DATE_ADD && LA59_1<=DATEDIFF)||LA59_1==DAY_SYM||(LA59_1>=DAYNAME && LA59_1<=DAYOFYEAR)||(LA59_1>=DECODE && LA59_1<=DEFAULT)||LA59_1==DEGREES||(LA59_1>=DES_DECRYPT && LA59_1<=DES_ENCRYPT)||LA59_1==ELT||(LA59_1>=ENCODE && LA59_1<=ENCRYPT)||(LA59_1>=EXISTS && LA59_1<=EXP)||(LA59_1>=EXPORT_SET && LA59_1<=FALSE_SYM)||LA59_1==FIELD||LA59_1==FIND_IN_SET||LA59_1==FLOOR||(LA59_1>=FORMAT && LA59_1<=FOUND_ROWS)||(LA59_1>=FROM_BASE64 && LA59_1<=FROM_UNIXTIME)||(LA59_1>=GET_FORMAT && LA59_1<=GET_LOCK)||LA59_1==GROUP_CONCAT||LA59_1==HEX||LA59_1==HOUR||(LA59_1>=IF && LA59_1<=IFNULL)||(LA59_1>=INET_ATON && LA59_1<=INET_NTOA)||LA59_1==INSERT||LA59_1==INSTR||LA59_1==INTERVAL_SYM||LA59_1==IS_FREE_LOCK||LA59_1==IS_USED_LOCK||(LA59_1>=LAST_DAY && LA59_1<=LAST_INSERT_ID)||(LA59_1>=LEFT && LA59_1<=LENGTH)||LA59_1==LN||LA59_1==LOAD_FILE||LA59_1==LOCATE||(LA59_1>=LOG && LA59_1<=LOG2)||(LA59_1>=LOWER && LA59_1<=LTRIM)||(LA59_1>=MAKE_SET && LA59_1<=MAX_SYM)||LA59_1==MD5||(LA59_1>=MICROSECOND && LA59_1<=MIN_SYM)||LA59_1==MINUTE||LA59_1==MOD||(LA59_1>=MONTH && LA59_1<=NAME_CONST)||(LA59_1>=NOT_SYM && LA59_1<=NULL_SYM)||LA59_1==OCT||LA59_1==OLD_PASSWORD||LA59_1==ORD||(LA59_1>=PASSWORD && LA59_1<=PI)||(LA59_1>=POW && LA59_1<=POWER)||LA59_1==QUARTER||(LA59_1>=QUOTE && LA59_1<=RAND)||LA59_1==RELEASE_LOCK||(LA59_1>=REPEAT && LA59_1<=REPLACE)||(LA59_1>=REVERSE && LA59_1<=RIGHT)||LA59_1==ROUND||LA59_1==ROW_SYM||(LA59_1>=RPAD && LA59_1<=RTRIM)||(LA59_1>=SCHEMA && LA59_1<=SECOND)||LA59_1==SESSION_USER||LA59_1==SIGN||LA59_1==SIN||LA59_1==SLEEP||LA59_1==SOUNDEX||LA59_1==SPACE||LA59_1==SQRT||(LA59_1>=STD && LA59_1<=STDDEV_SAMP)||LA59_1==STR_TO_DATE||LA59_1==STRCMP||(LA59_1>=SUBSTRING && LA59_1<=SUM)||(LA59_1>=SYSDATE && LA59_1<=SYSTEM_USER)||LA59_1==TAN||(LA59_1>=TIME_FORMAT && LA59_1<=TIMESTAMPDIFF)||(LA59_1>=TO_BASE64 && LA59_1<=TO_SECONDS)||(LA59_1>=TRIM && LA59_1<=TRUNCATE)||LA59_1==UNHEX||LA59_1==UNIX_TIMESTAMP||LA59_1==UPPER||LA59_1==USER||(LA59_1>=UTC_DATE && LA59_1<=UTC_TIMESTAMP)||LA59_1==UUID||(LA59_1>=VALUES && LA59_1<=VAR_SAMP)||(LA59_1>=VARIANCE && LA59_1<=VERSION_SYM)||(LA59_1>=WEEK && LA59_1<=WEIGHT_STRING)||(LA59_1>=LPAREN && LA59_1<=YEAR_FUNC)||LA59_1==YEARWEEK||(LA59_1>=PLUS && LA59_1<=NEGATION)||LA59_1==INTEGER_NUM||(LA59_1>=HEX_DIGIT && LA59_1<=ID)||LA59_1==USER_VAR) ) {
                            alt59=1;
                        }
                    }
                    else if ( (LA59_0==USING_SYM) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // MySQL.g:473:42: join_condition
                            {
                            pushFollow(FOLLOW_join_condition_in_join_table2965);
                            join_condition252=join_condition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_join_condition.add(join_condition252.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: join_qualifier1, join_condition, table_atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 473:59: -> ^( TN_JOIN ( ^( TN_JOIN_QUALIFIER join_qualifier1 ) )? ^( TN_JOIN_TABLE table_atom ) ( ^( join_condition ) )? )
                    {
                        // MySQL.g:473:62: ^( TN_JOIN ( ^( TN_JOIN_QUALIFIER join_qualifier1 ) )? ^( TN_JOIN_TABLE table_atom ) ( ^( join_condition ) )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_JOIN, "TN_JOIN"), root_1);

                        // MySQL.g:473:72: ( ^( TN_JOIN_QUALIFIER join_qualifier1 ) )?
                        if ( stream_join_qualifier1.hasNext() ) {
                            // MySQL.g:473:72: ^( TN_JOIN_QUALIFIER join_qualifier1 )
                            {
                            CommonTree root_2 = (CommonTree)adaptor.nil();
                            root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_JOIN_QUALIFIER, "TN_JOIN_QUALIFIER"), root_2);

                            adaptor.addChild(root_2, stream_join_qualifier1.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_join_qualifier1.reset();
                        // MySQL.g:473:110: ^( TN_JOIN_TABLE table_atom )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_JOIN_TABLE, "TN_JOIN_TABLE"), root_2);

                        adaptor.addChild(root_2, stream_table_atom.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MySQL.g:473:138: ( ^( join_condition ) )?
                        if ( stream_join_condition.hasNext() ) {
                            // MySQL.g:473:138: ^( join_condition )
                            {
                            CommonTree root_2 = (CommonTree)adaptor.nil();
                            root_2 = (CommonTree)adaptor.becomeRoot(stream_join_condition.nextNode(), root_2);

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_join_condition.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MySQL.g:474:4: STRAIGHT_JOIN table_atom ( ON expression )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    STRAIGHT_JOIN253=(Token)match(input,STRAIGHT_JOIN,FOLLOW_STRAIGHT_JOIN_in_join_table2996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRAIGHT_JOIN253_tree = (CommonTree)adaptor.create(STRAIGHT_JOIN253);
                    adaptor.addChild(root_0, STRAIGHT_JOIN253_tree);
                    }
                    pushFollow(FOLLOW_table_atom_in_join_table2998);
                    table_atom254=table_atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, table_atom254.getTree());
                    // MySQL.g:474:29: ( ON expression )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==ON) ) {
                        int LA60_1 = input.LA(2);

                        if ( ((LA60_1>=ABS && LA60_1<=ACOS)||(LA60_1>=ADDDATE && LA60_1<=AES_ENCRYPT)||(LA60_1>=ASCII_SYM && LA60_1<=ASIN)||(LA60_1>=ATAN && LA60_1<=ATAN2)||LA60_1==AVG||LA60_1==BENCHMARK||(LA60_1>=BIN && LA60_1<=BIT_OR)||LA60_1==BIT_XOR||(LA60_1>=CASE_SYM && LA60_1<=CEILING)||(LA60_1>=CHAR && LA60_1<=CHAR_LENGTH)||LA60_1==CHARSET||LA60_1==COERCIBILITY||LA60_1==COLLATION||(LA60_1>=CONCAT && LA60_1<=CONCAT_WS)||LA60_1==CONNECTION_ID||(LA60_1>=CONV && LA60_1<=CONVERT_TZ)||(LA60_1>=COS && LA60_1<=COUNT)||LA60_1==CRC32||LA60_1==CURDATE||(LA60_1>=CURRENT_USER && LA60_1<=DATABASE)||(LA60_1>=DATE_ADD && LA60_1<=DATEDIFF)||LA60_1==DAY_SYM||(LA60_1>=DAYNAME && LA60_1<=DAYOFYEAR)||(LA60_1>=DECODE && LA60_1<=DEFAULT)||LA60_1==DEGREES||(LA60_1>=DES_DECRYPT && LA60_1<=DES_ENCRYPT)||LA60_1==ELT||(LA60_1>=ENCODE && LA60_1<=ENCRYPT)||(LA60_1>=EXISTS && LA60_1<=EXP)||(LA60_1>=EXPORT_SET && LA60_1<=FALSE_SYM)||LA60_1==FIELD||LA60_1==FIND_IN_SET||LA60_1==FLOOR||(LA60_1>=FORMAT && LA60_1<=FOUND_ROWS)||(LA60_1>=FROM_BASE64 && LA60_1<=FROM_UNIXTIME)||(LA60_1>=GET_FORMAT && LA60_1<=GET_LOCK)||LA60_1==GROUP_CONCAT||LA60_1==HEX||LA60_1==HOUR||(LA60_1>=IF && LA60_1<=IFNULL)||(LA60_1>=INET_ATON && LA60_1<=INET_NTOA)||LA60_1==INSERT||LA60_1==INSTR||LA60_1==INTERVAL_SYM||LA60_1==IS_FREE_LOCK||LA60_1==IS_USED_LOCK||(LA60_1>=LAST_DAY && LA60_1<=LAST_INSERT_ID)||(LA60_1>=LEFT && LA60_1<=LENGTH)||LA60_1==LN||LA60_1==LOAD_FILE||LA60_1==LOCATE||(LA60_1>=LOG && LA60_1<=LOG2)||(LA60_1>=LOWER && LA60_1<=LTRIM)||(LA60_1>=MAKE_SET && LA60_1<=MAX_SYM)||LA60_1==MD5||(LA60_1>=MICROSECOND && LA60_1<=MIN_SYM)||LA60_1==MINUTE||LA60_1==MOD||(LA60_1>=MONTH && LA60_1<=NAME_CONST)||(LA60_1>=NOT_SYM && LA60_1<=NULL_SYM)||LA60_1==OCT||LA60_1==OLD_PASSWORD||LA60_1==ORD||(LA60_1>=PASSWORD && LA60_1<=PI)||(LA60_1>=POW && LA60_1<=POWER)||LA60_1==QUARTER||(LA60_1>=QUOTE && LA60_1<=RAND)||LA60_1==RELEASE_LOCK||(LA60_1>=REPEAT && LA60_1<=REPLACE)||(LA60_1>=REVERSE && LA60_1<=RIGHT)||LA60_1==ROUND||LA60_1==ROW_SYM||(LA60_1>=RPAD && LA60_1<=RTRIM)||(LA60_1>=SCHEMA && LA60_1<=SECOND)||LA60_1==SESSION_USER||LA60_1==SIGN||LA60_1==SIN||LA60_1==SLEEP||LA60_1==SOUNDEX||LA60_1==SPACE||LA60_1==SQRT||(LA60_1>=STD && LA60_1<=STDDEV_SAMP)||LA60_1==STR_TO_DATE||LA60_1==STRCMP||(LA60_1>=SUBSTRING && LA60_1<=SUM)||(LA60_1>=SYSDATE && LA60_1<=SYSTEM_USER)||LA60_1==TAN||(LA60_1>=TIME_FORMAT && LA60_1<=TIMESTAMPDIFF)||(LA60_1>=TO_BASE64 && LA60_1<=TO_SECONDS)||(LA60_1>=TRIM && LA60_1<=TRUNCATE)||LA60_1==UNHEX||LA60_1==UNIX_TIMESTAMP||LA60_1==UPPER||LA60_1==USER||(LA60_1>=UTC_DATE && LA60_1<=UTC_TIMESTAMP)||LA60_1==UUID||(LA60_1>=VALUES && LA60_1<=VAR_SAMP)||(LA60_1>=VARIANCE && LA60_1<=VERSION_SYM)||(LA60_1>=WEEK && LA60_1<=WEIGHT_STRING)||(LA60_1>=LPAREN && LA60_1<=YEAR_FUNC)||LA60_1==YEARWEEK||(LA60_1>=PLUS && LA60_1<=NEGATION)||LA60_1==INTEGER_NUM||(LA60_1>=HEX_DIGIT && LA60_1<=ID)||LA60_1==USER_VAR) ) {
                            alt60=1;
                        }
                    }
                    switch (alt60) {
                        case 1 :
                            // MySQL.g:474:30: ON expression
                            {
                            ON255=(Token)match(input,ON,FOLLOW_ON_in_join_table3001); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ON255_tree = (CommonTree)adaptor.create(ON255);
                            adaptor.addChild(root_0, ON255_tree);
                            }
                            pushFollow(FOLLOW_expression_in_join_table3003);
                            expression256=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression256.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // MySQL.g:475:4: ( join_qualifier2 ) ( OUTER )? JOIN_SYM table_atom join_condition
                    {
                    // MySQL.g:475:4: ( join_qualifier2 )
                    // MySQL.g:475:5: join_qualifier2
                    {
                    pushFollow(FOLLOW_join_qualifier2_in_join_table3011);
                    join_qualifier2257=join_qualifier2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_join_qualifier2.add(join_qualifier2257.getTree());

                    }

                    // MySQL.g:475:22: ( OUTER )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==OUTER) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // MySQL.g:475:23: OUTER
                            {
                            OUTER258=(Token)match(input,OUTER,FOLLOW_OUTER_in_join_table3015); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_OUTER.add(OUTER258);


                            }
                            break;

                    }

                    JOIN_SYM259=(Token)match(input,JOIN_SYM,FOLLOW_JOIN_SYM_in_join_table3019); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_JOIN_SYM.add(JOIN_SYM259);

                    pushFollow(FOLLOW_table_atom_in_join_table3021);
                    table_atom260=table_atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_table_atom.add(table_atom260.getTree());
                    pushFollow(FOLLOW_join_condition_in_join_table3023);
                    join_condition261=join_condition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_join_condition.add(join_condition261.getTree());


                    // AST REWRITE
                    // elements: OUTER, table_atom, join_qualifier2, join_condition
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 475:66: -> ^( TN_JOIN ^( TN_JOIN_QUALIFIER join_qualifier2 ( OUTER )? ) ^( TN_JOIN_TABLE table_atom ) ^( join_condition ) )
                    {
                        // MySQL.g:475:69: ^( TN_JOIN ^( TN_JOIN_QUALIFIER join_qualifier2 ( OUTER )? ) ^( TN_JOIN_TABLE table_atom ) ^( join_condition ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_JOIN, "TN_JOIN"), root_1);

                        // MySQL.g:475:79: ^( TN_JOIN_QUALIFIER join_qualifier2 ( OUTER )? )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_JOIN_QUALIFIER, "TN_JOIN_QUALIFIER"), root_2);

                        adaptor.addChild(root_2, stream_join_qualifier2.nextTree());
                        // MySQL.g:475:115: ( OUTER )?
                        if ( stream_OUTER.hasNext() ) {
                            adaptor.addChild(root_2, stream_OUTER.nextNode());

                        }
                        stream_OUTER.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // MySQL.g:475:123: ^( TN_JOIN_TABLE table_atom )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_JOIN_TABLE, "TN_JOIN_TABLE"), root_2);

                        adaptor.addChild(root_2, stream_table_atom.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // MySQL.g:475:151: ^( join_condition )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(stream_join_condition.nextNode(), root_2);

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MySQL.g:476:4: NATURAL ( ( LEFT | RIGHT ) ( OUTER )? )? JOIN_SYM table_atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NATURAL262=(Token)match(input,NATURAL,FOLLOW_NATURAL_in_join_table3053); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATURAL262_tree = (CommonTree)adaptor.create(NATURAL262);
                    adaptor.addChild(root_0, NATURAL262_tree);
                    }
                    // MySQL.g:476:12: ( ( LEFT | RIGHT ) ( OUTER )? )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==LEFT||LA63_0==RIGHT) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // MySQL.g:476:14: ( LEFT | RIGHT ) ( OUTER )?
                            {
                            set263=(Token)input.LT(1);
                            if ( input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set263));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            // MySQL.g:476:27: ( OUTER )?
                            int alt62=2;
                            int LA62_0 = input.LA(1);

                            if ( (LA62_0==OUTER) ) {
                                alt62=1;
                            }
                            switch (alt62) {
                                case 1 :
                                    // MySQL.g:476:28: OUTER
                                    {
                                    OUTER264=(Token)match(input,OUTER,FOLLOW_OUTER_in_join_table3064); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    OUTER264_tree = (CommonTree)adaptor.create(OUTER264);
                                    adaptor.addChild(root_0, OUTER264_tree);
                                    }

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    JOIN_SYM265=(Token)match(input,JOIN_SYM,FOLLOW_JOIN_SYM_in_join_table3071); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN_SYM265_tree = (CommonTree)adaptor.create(JOIN_SYM265);
                    adaptor.addChild(root_0, JOIN_SYM265_tree);
                    }
                    pushFollow(FOLLOW_table_atom_in_join_table3073);
                    table_atom266=table_atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, table_atom266.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 816, join_table_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "join_table"

    public static class join_qualifier1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "join_qualifier1"
    // MySQL.g:478:1: join_qualifier1 : ( INNER_SYM | CROSS );
    public final MySQLParser.join_qualifier1_return join_qualifier1() throws RecognitionException {
        MySQLParser.join_qualifier1_return retval = new MySQLParser.join_qualifier1_return();
        retval.start = input.LT(1);
        int join_qualifier1_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set267=null;

        CommonTree set267_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 817) ) { return retval; }
            // MySQL.g:478:16: ( INNER_SYM | CROSS )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set267=(Token)input.LT(1);
            if ( input.LA(1)==CROSS||input.LA(1)==INNER_SYM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set267));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 817, join_qualifier1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "join_qualifier1"

    public static class join_qualifier2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "join_qualifier2"
    // MySQL.g:481:1: join_qualifier2 : ( LEFT | RIGHT );
    public final MySQLParser.join_qualifier2_return join_qualifier2() throws RecognitionException {
        MySQLParser.join_qualifier2_return retval = new MySQLParser.join_qualifier2_return();
        retval.start = input.LT(1);
        int join_qualifier2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set268=null;

        CommonTree set268_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 818) ) { return retval; }
            // MySQL.g:481:16: ( LEFT | RIGHT )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set268=(Token)input.LT(1);
            if ( input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set268));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 818, join_qualifier2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "join_qualifier2"

    public static class table_atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table_atom"
    // MySQL.g:484:1: table_atom : ( table_spec ( alias )? ( index_hint_list )? -> ^( TN_TABLE_REF table_spec ( alias )? ) | subquery alias | LPAREN table_references RPAREN );
    public final MySQLParser.table_atom_return table_atom() throws RecognitionException {
        MySQLParser.table_atom_return retval = new MySQLParser.table_atom_return();
        retval.start = input.LT(1);
        int table_atom_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LPAREN274=null;
        Token RPAREN276=null;
        MySQLParser.table_spec_return table_spec269 = null;

        MySQLParser.alias_return alias270 = null;

        MySQLParser.index_hint_list_return index_hint_list271 = null;

        MySQLParser.subquery_return subquery272 = null;

        MySQLParser.alias_return alias273 = null;

        MySQLParser.table_references_return table_references275 = null;


        CommonTree LPAREN274_tree=null;
        CommonTree RPAREN276_tree=null;
        RewriteRuleSubtreeStream stream_index_hint_list=new RewriteRuleSubtreeStream(adaptor,"rule index_hint_list");
        RewriteRuleSubtreeStream stream_alias=new RewriteRuleSubtreeStream(adaptor,"rule alias");
        RewriteRuleSubtreeStream stream_table_spec=new RewriteRuleSubtreeStream(adaptor,"rule table_spec");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 819) ) { return retval; }
            // MySQL.g:484:11: ( table_spec ( alias )? ( index_hint_list )? -> ^( TN_TABLE_REF table_spec ( alias )? ) | subquery alias | LPAREN table_references RPAREN )
            int alt67=3;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==ID) ) {
                alt67=1;
            }
            else if ( (LA67_0==LPAREN) ) {
                int LA67_2 = input.LA(2);

                if ( (LA67_2==LPAREN||LA67_2==ID) ) {
                    alt67=3;
                }
                else if ( (LA67_2==SELECT) ) {
                    alt67=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // MySQL.g:485:4: table_spec ( alias )? ( index_hint_list )?
                    {
                    pushFollow(FOLLOW_table_spec_in_table_atom3109);
                    table_spec269=table_spec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_table_spec.add(table_spec269.getTree());
                    // MySQL.g:485:15: ( alias )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==AS_SYM||LA65_0==ID) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // MySQL.g:485:16: alias
                            {
                            pushFollow(FOLLOW_alias_in_table_atom3112);
                            alias270=alias();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_alias.add(alias270.getTree());

                            }
                            break;

                    }

                    // MySQL.g:485:24: ( index_hint_list )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==FORCE_SYM||LA66_0==IGNORE_SYM||LA66_0==USE_SYM) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // MySQL.g:485:25: index_hint_list
                            {
                            pushFollow(FOLLOW_index_hint_list_in_table_atom3117);
                            index_hint_list271=index_hint_list();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_index_hint_list.add(index_hint_list271.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: alias, table_spec
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 485:43: -> ^( TN_TABLE_REF table_spec ( alias )? )
                    {
                        // MySQL.g:485:46: ^( TN_TABLE_REF table_spec ( alias )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_TABLE_REF, "TN_TABLE_REF"), root_1);

                        adaptor.addChild(root_1, stream_table_spec.nextTree());
                        // MySQL.g:485:72: ( alias )?
                        if ( stream_alias.hasNext() ) {
                            adaptor.addChild(root_1, stream_alias.nextTree());

                        }
                        stream_alias.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MySQL.g:486:4: subquery alias
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_subquery_in_table_atom3135);
                    subquery272=subquery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subquery272.getTree());
                    pushFollow(FOLLOW_alias_in_table_atom3137);
                    alias273=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, alias273.getTree());

                    }
                    break;
                case 3 :
                    // MySQL.g:487:4: LPAREN table_references RPAREN
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LPAREN274=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_table_atom3142); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN274_tree = (CommonTree)adaptor.create(LPAREN274);
                    adaptor.addChild(root_0, LPAREN274_tree);
                    }
                    pushFollow(FOLLOW_table_references_in_table_atom3144);
                    table_references275=table_references();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, table_references275.getTree());
                    RPAREN276=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_table_atom3146); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN276_tree = (CommonTree)adaptor.create(RPAREN276);
                    adaptor.addChild(root_0, RPAREN276_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 819, table_atom_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "table_atom"

    public static class join_condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "join_condition"
    // MySQL.g:489:1: join_condition : ( ON expression -> ^( TN_JOIN_COND expression ) | ( USING_SYM column_list ) );
    public final MySQLParser.join_condition_return join_condition() throws RecognitionException {
        MySQLParser.join_condition_return retval = new MySQLParser.join_condition_return();
        retval.start = input.LT(1);
        int join_condition_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ON277=null;
        Token USING_SYM279=null;
        MySQLParser.expression_return expression278 = null;

        MySQLParser.column_list_return column_list280 = null;


        CommonTree ON277_tree=null;
        CommonTree USING_SYM279_tree=null;
        RewriteRuleTokenStream stream_ON=new RewriteRuleTokenStream(adaptor,"token ON");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 820) ) { return retval; }
            // MySQL.g:489:15: ( ON expression -> ^( TN_JOIN_COND expression ) | ( USING_SYM column_list ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==ON) ) {
                alt68=1;
            }
            else if ( (LA68_0==USING_SYM) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // MySQL.g:490:4: ON expression
                    {
                    ON277=(Token)match(input,ON,FOLLOW_ON_in_join_condition3157); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ON.add(ON277);

                    pushFollow(FOLLOW_expression_in_join_condition3159);
                    expression278=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression278.getTree());


                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 490:18: -> ^( TN_JOIN_COND expression )
                    {
                        // MySQL.g:490:21: ^( TN_JOIN_COND expression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_JOIN_COND, "TN_JOIN_COND"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MySQL.g:491:6: ( USING_SYM column_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:491:6: ( USING_SYM column_list )
                    // MySQL.g:491:7: USING_SYM column_list
                    {
                    USING_SYM279=(Token)match(input,USING_SYM,FOLLOW_USING_SYM_in_join_condition3175); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING_SYM279_tree = (CommonTree)adaptor.create(USING_SYM279);
                    adaptor.addChild(root_0, USING_SYM279_tree);
                    }
                    pushFollow(FOLLOW_column_list_in_join_condition3177);
                    column_list280=column_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_list280.getTree());

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 820, join_condition_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "join_condition"

    public static class index_hint_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "index_hint_list"
    // MySQL.g:493:1: index_hint_list : index_hint ( COMMA index_hint )* ;
    public final MySQLParser.index_hint_list_return index_hint_list() throws RecognitionException {
        MySQLParser.index_hint_list_return retval = new MySQLParser.index_hint_list_return();
        retval.start = input.LT(1);
        int index_hint_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token COMMA282=null;
        MySQLParser.index_hint_return index_hint281 = null;

        MySQLParser.index_hint_return index_hint283 = null;


        CommonTree COMMA282_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 821) ) { return retval; }
            // MySQL.g:493:16: ( index_hint ( COMMA index_hint )* )
            // MySQL.g:494:2: index_hint ( COMMA index_hint )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_index_hint_in_index_hint_list3186);
            index_hint281=index_hint();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, index_hint281.getTree());
            // MySQL.g:494:13: ( COMMA index_hint )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==COMMA) ) {
                    int LA69_2 = input.LA(2);

                    if ( (LA69_2==FORCE_SYM||LA69_2==IGNORE_SYM||LA69_2==USE_SYM) ) {
                        alt69=1;
                    }


                }


                switch (alt69) {
            	case 1 :
            	    // MySQL.g:494:14: COMMA index_hint
            	    {
            	    COMMA282=(Token)match(input,COMMA,FOLLOW_COMMA_in_index_hint_list3189); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA282_tree = (CommonTree)adaptor.create(COMMA282);
            	    adaptor.addChild(root_0, COMMA282_tree);
            	    }
            	    pushFollow(FOLLOW_index_hint_in_index_hint_list3191);
            	    index_hint283=index_hint();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, index_hint283.getTree());

            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 821, index_hint_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "index_hint_list"

    public static class index_options_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "index_options"
    // MySQL.g:496:1: index_options : ( INDEX_SYM | KEY_SYM ) ( FOR_SYM ( ( JOIN_SYM ) | ( ORDER_SYM BY_SYM ) | ( GROUP_SYM BY_SYM ) ) )? ;
    public final MySQLParser.index_options_return index_options() throws RecognitionException {
        MySQLParser.index_options_return retval = new MySQLParser.index_options_return();
        retval.start = input.LT(1);
        int index_options_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set284=null;
        Token FOR_SYM285=null;
        Token JOIN_SYM286=null;
        Token ORDER_SYM287=null;
        Token BY_SYM288=null;
        Token GROUP_SYM289=null;
        Token BY_SYM290=null;

        CommonTree set284_tree=null;
        CommonTree FOR_SYM285_tree=null;
        CommonTree JOIN_SYM286_tree=null;
        CommonTree ORDER_SYM287_tree=null;
        CommonTree BY_SYM288_tree=null;
        CommonTree GROUP_SYM289_tree=null;
        CommonTree BY_SYM290_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 822) ) { return retval; }
            // MySQL.g:496:14: ( ( INDEX_SYM | KEY_SYM ) ( FOR_SYM ( ( JOIN_SYM ) | ( ORDER_SYM BY_SYM ) | ( GROUP_SYM BY_SYM ) ) )? )
            // MySQL.g:497:2: ( INDEX_SYM | KEY_SYM ) ( FOR_SYM ( ( JOIN_SYM ) | ( ORDER_SYM BY_SYM ) | ( GROUP_SYM BY_SYM ) ) )?
            {
            root_0 = (CommonTree)adaptor.nil();

            set284=(Token)input.LT(1);
            if ( input.LA(1)==INDEX_SYM||input.LA(1)==KEY_SYM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set284));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // MySQL.g:497:24: ( FOR_SYM ( ( JOIN_SYM ) | ( ORDER_SYM BY_SYM ) | ( GROUP_SYM BY_SYM ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==FOR_SYM) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // MySQL.g:497:27: FOR_SYM ( ( JOIN_SYM ) | ( ORDER_SYM BY_SYM ) | ( GROUP_SYM BY_SYM ) )
                    {
                    FOR_SYM285=(Token)match(input,FOR_SYM,FOLLOW_FOR_SYM_in_index_options3212); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOR_SYM285_tree = (CommonTree)adaptor.create(FOR_SYM285);
                    adaptor.addChild(root_0, FOR_SYM285_tree);
                    }
                    // MySQL.g:497:35: ( ( JOIN_SYM ) | ( ORDER_SYM BY_SYM ) | ( GROUP_SYM BY_SYM ) )
                    int alt70=3;
                    switch ( input.LA(1) ) {
                    case JOIN_SYM:
                        {
                        alt70=1;
                        }
                        break;
                    case ORDER_SYM:
                        {
                        alt70=2;
                        }
                        break;
                    case GROUP_SYM:
                        {
                        alt70=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        throw nvae;
                    }

                    switch (alt70) {
                        case 1 :
                            // MySQL.g:497:36: ( JOIN_SYM )
                            {
                            // MySQL.g:497:36: ( JOIN_SYM )
                            // MySQL.g:497:37: JOIN_SYM
                            {
                            JOIN_SYM286=(Token)match(input,JOIN_SYM,FOLLOW_JOIN_SYM_in_index_options3216); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            JOIN_SYM286_tree = (CommonTree)adaptor.create(JOIN_SYM286);
                            adaptor.addChild(root_0, JOIN_SYM286_tree);
                            }

                            }


                            }
                            break;
                        case 2 :
                            // MySQL.g:497:49: ( ORDER_SYM BY_SYM )
                            {
                            // MySQL.g:497:49: ( ORDER_SYM BY_SYM )
                            // MySQL.g:497:50: ORDER_SYM BY_SYM
                            {
                            ORDER_SYM287=(Token)match(input,ORDER_SYM,FOLLOW_ORDER_SYM_in_index_options3222); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ORDER_SYM287_tree = (CommonTree)adaptor.create(ORDER_SYM287);
                            adaptor.addChild(root_0, ORDER_SYM287_tree);
                            }
                            BY_SYM288=(Token)match(input,BY_SYM,FOLLOW_BY_SYM_in_index_options3224); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BY_SYM288_tree = (CommonTree)adaptor.create(BY_SYM288);
                            adaptor.addChild(root_0, BY_SYM288_tree);
                            }

                            }


                            }
                            break;
                        case 3 :
                            // MySQL.g:497:70: ( GROUP_SYM BY_SYM )
                            {
                            // MySQL.g:497:70: ( GROUP_SYM BY_SYM )
                            // MySQL.g:497:71: GROUP_SYM BY_SYM
                            {
                            GROUP_SYM289=(Token)match(input,GROUP_SYM,FOLLOW_GROUP_SYM_in_index_options3230); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            GROUP_SYM289_tree = (CommonTree)adaptor.create(GROUP_SYM289);
                            adaptor.addChild(root_0, GROUP_SYM289_tree);
                            }
                            BY_SYM290=(Token)match(input,BY_SYM,FOLLOW_BY_SYM_in_index_options3232); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BY_SYM290_tree = (CommonTree)adaptor.create(BY_SYM290);
                            adaptor.addChild(root_0, BY_SYM290_tree);
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 822, index_options_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "index_options"

    public static class index_hint_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "index_hint"
    // MySQL.g:499:1: index_hint : ( USE_SYM index_options LPAREN ( index_list )? RPAREN | IGNORE_SYM index_options LPAREN index_list RPAREN | FORCE_SYM index_options LPAREN index_list RPAREN );
    public final MySQLParser.index_hint_return index_hint() throws RecognitionException {
        MySQLParser.index_hint_return retval = new MySQLParser.index_hint_return();
        retval.start = input.LT(1);
        int index_hint_StartIndex = input.index();
        CommonTree root_0 = null;

        Token USE_SYM291=null;
        Token LPAREN293=null;
        Token RPAREN295=null;
        Token IGNORE_SYM296=null;
        Token LPAREN298=null;
        Token RPAREN300=null;
        Token FORCE_SYM301=null;
        Token LPAREN303=null;
        Token RPAREN305=null;
        MySQLParser.index_options_return index_options292 = null;

        MySQLParser.index_list_return index_list294 = null;

        MySQLParser.index_options_return index_options297 = null;

        MySQLParser.index_list_return index_list299 = null;

        MySQLParser.index_options_return index_options302 = null;

        MySQLParser.index_list_return index_list304 = null;


        CommonTree USE_SYM291_tree=null;
        CommonTree LPAREN293_tree=null;
        CommonTree RPAREN295_tree=null;
        CommonTree IGNORE_SYM296_tree=null;
        CommonTree LPAREN298_tree=null;
        CommonTree RPAREN300_tree=null;
        CommonTree FORCE_SYM301_tree=null;
        CommonTree LPAREN303_tree=null;
        CommonTree RPAREN305_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 823) ) { return retval; }
            // MySQL.g:499:11: ( USE_SYM index_options LPAREN ( index_list )? RPAREN | IGNORE_SYM index_options LPAREN index_list RPAREN | FORCE_SYM index_options LPAREN index_list RPAREN )
            int alt73=3;
            switch ( input.LA(1) ) {
            case USE_SYM:
                {
                alt73=1;
                }
                break;
            case IGNORE_SYM:
                {
                alt73=2;
                }
                break;
            case FORCE_SYM:
                {
                alt73=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // MySQL.g:500:4: USE_SYM index_options LPAREN ( index_list )? RPAREN
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    USE_SYM291=(Token)match(input,USE_SYM,FOLLOW_USE_SYM_in_index_hint3248); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USE_SYM291_tree = (CommonTree)adaptor.create(USE_SYM291);
                    adaptor.addChild(root_0, USE_SYM291_tree);
                    }
                    pushFollow(FOLLOW_index_options_in_index_hint3253);
                    index_options292=index_options();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, index_options292.getTree());
                    LPAREN293=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_index_hint3255); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN293_tree = (CommonTree)adaptor.create(LPAREN293);
                    adaptor.addChild(root_0, LPAREN293_tree);
                    }
                    // MySQL.g:500:36: ( index_list )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==ID) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // MySQL.g:500:37: index_list
                            {
                            pushFollow(FOLLOW_index_list_in_index_hint3258);
                            index_list294=index_list();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, index_list294.getTree());

                            }
                            break;

                    }

                    RPAREN295=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_index_hint3262); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN295_tree = (CommonTree)adaptor.create(RPAREN295);
                    adaptor.addChild(root_0, RPAREN295_tree);
                    }

                    }
                    break;
                case 2 :
                    // MySQL.g:501:4: IGNORE_SYM index_options LPAREN index_list RPAREN
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IGNORE_SYM296=(Token)match(input,IGNORE_SYM,FOLLOW_IGNORE_SYM_in_index_hint3267); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IGNORE_SYM296_tree = (CommonTree)adaptor.create(IGNORE_SYM296);
                    adaptor.addChild(root_0, IGNORE_SYM296_tree);
                    }
                    pushFollow(FOLLOW_index_options_in_index_hint3269);
                    index_options297=index_options();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, index_options297.getTree());
                    LPAREN298=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_index_hint3271); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN298_tree = (CommonTree)adaptor.create(LPAREN298);
                    adaptor.addChild(root_0, LPAREN298_tree);
                    }
                    pushFollow(FOLLOW_index_list_in_index_hint3273);
                    index_list299=index_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, index_list299.getTree());
                    RPAREN300=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_index_hint3275); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN300_tree = (CommonTree)adaptor.create(RPAREN300);
                    adaptor.addChild(root_0, RPAREN300_tree);
                    }

                    }
                    break;
                case 3 :
                    // MySQL.g:502:4: FORCE_SYM index_options LPAREN index_list RPAREN
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FORCE_SYM301=(Token)match(input,FORCE_SYM,FOLLOW_FORCE_SYM_in_index_hint3280); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FORCE_SYM301_tree = (CommonTree)adaptor.create(FORCE_SYM301);
                    adaptor.addChild(root_0, FORCE_SYM301_tree);
                    }
                    pushFollow(FOLLOW_index_options_in_index_hint3283);
                    index_options302=index_options();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, index_options302.getTree());
                    LPAREN303=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_index_hint3285); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN303_tree = (CommonTree)adaptor.create(LPAREN303);
                    adaptor.addChild(root_0, LPAREN303_tree);
                    }
                    pushFollow(FOLLOW_index_list_in_index_hint3287);
                    index_list304=index_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, index_list304.getTree());
                    RPAREN305=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_index_hint3289); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN305_tree = (CommonTree)adaptor.create(RPAREN305);
                    adaptor.addChild(root_0, RPAREN305_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 823, index_hint_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "index_hint"

    public static class index_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "index_list"
    // MySQL.g:504:1: index_list : index_name ( COMMA index_name ) ;
    public final MySQLParser.index_list_return index_list() throws RecognitionException {
        MySQLParser.index_list_return retval = new MySQLParser.index_list_return();
        retval.start = input.LT(1);
        int index_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token COMMA307=null;
        MySQLParser.index_name_return index_name306 = null;

        MySQLParser.index_name_return index_name308 = null;


        CommonTree COMMA307_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 824) ) { return retval; }
            // MySQL.g:504:11: ( index_name ( COMMA index_name ) )
            // MySQL.g:505:2: index_name ( COMMA index_name )
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_index_name_in_index_list3297);
            index_name306=index_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, index_name306.getTree());
            // MySQL.g:505:13: ( COMMA index_name )
            // MySQL.g:505:14: COMMA index_name
            {
            COMMA307=(Token)match(input,COMMA,FOLLOW_COMMA_in_index_list3300); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COMMA307_tree = (CommonTree)adaptor.create(COMMA307);
            adaptor.addChild(root_0, COMMA307_tree);
            }
            pushFollow(FOLLOW_index_name_in_index_list3302);
            index_name308=index_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, index_name308.getTree());

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 824, index_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "index_list"

    public static class partition_clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "partition_clause"
    // MySQL.g:507:1: partition_clause : PARTITION_SYM LPAREN partition_names RPAREN ;
    public final MySQLParser.partition_clause_return partition_clause() throws RecognitionException {
        MySQLParser.partition_clause_return retval = new MySQLParser.partition_clause_return();
        retval.start = input.LT(1);
        int partition_clause_StartIndex = input.index();
        CommonTree root_0 = null;

        Token PARTITION_SYM309=null;
        Token LPAREN310=null;
        Token RPAREN312=null;
        MySQLParser.partition_names_return partition_names311 = null;


        CommonTree PARTITION_SYM309_tree=null;
        CommonTree LPAREN310_tree=null;
        CommonTree RPAREN312_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 825) ) { return retval; }
            // MySQL.g:507:17: ( PARTITION_SYM LPAREN partition_names RPAREN )
            // MySQL.g:508:2: PARTITION_SYM LPAREN partition_names RPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            PARTITION_SYM309=(Token)match(input,PARTITION_SYM,FOLLOW_PARTITION_SYM_in_partition_clause3311); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION_SYM309_tree = (CommonTree)adaptor.create(PARTITION_SYM309);
            adaptor.addChild(root_0, PARTITION_SYM309_tree);
            }
            LPAREN310=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_partition_clause3313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN310_tree = (CommonTree)adaptor.create(LPAREN310);
            adaptor.addChild(root_0, LPAREN310_tree);
            }
            pushFollow(FOLLOW_partition_names_in_partition_clause3315);
            partition_names311=partition_names();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, partition_names311.getTree());
            RPAREN312=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_partition_clause3317); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN312_tree = (CommonTree)adaptor.create(RPAREN312);
            adaptor.addChild(root_0, RPAREN312_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 825, partition_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "partition_clause"

    public static class partition_names_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "partition_names"
    // MySQL.g:510:1: partition_names : partition_name ( COMMA partition_name )* ;
    public final MySQLParser.partition_names_return partition_names() throws RecognitionException {
        MySQLParser.partition_names_return retval = new MySQLParser.partition_names_return();
        retval.start = input.LT(1);
        int partition_names_StartIndex = input.index();
        CommonTree root_0 = null;

        Token COMMA314=null;
        MySQLParser.partition_name_return partition_name313 = null;

        MySQLParser.partition_name_return partition_name315 = null;


        CommonTree COMMA314_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 826) ) { return retval; }
            // MySQL.g:510:16: ( partition_name ( COMMA partition_name )* )
            // MySQL.g:510:18: partition_name ( COMMA partition_name )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_partition_name_in_partition_names3324);
            partition_name313=partition_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, partition_name313.getTree());
            // MySQL.g:510:33: ( COMMA partition_name )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==COMMA) ) {
                    int LA74_1 = input.LA(2);

                    if ( (LA74_1==ID) ) {
                        alt74=1;
                    }


                }


                switch (alt74) {
            	case 1 :
            	    // MySQL.g:510:34: COMMA partition_name
            	    {
            	    COMMA314=(Token)match(input,COMMA,FOLLOW_COMMA_in_partition_names3327); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA314_tree = (CommonTree)adaptor.create(COMMA314);
            	    adaptor.addChild(root_0, COMMA314_tree);
            	    }
            	    pushFollow(FOLLOW_partition_name_in_partition_names3329);
            	    partition_name315=partition_name();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, partition_name315.getTree());

            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 826, partition_names_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "partition_names"

    public static class root_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "root_statement"
    // MySQL.g:513:1: root_statement : ( SHIFT_LEFT SHIFT_RIGHT )? ( data_manipulation_statements | data_definition_statements ) ( SEMI )? EOF ;
    public final MySQLParser.root_statement_return root_statement() throws RecognitionException {
        MySQLParser.root_statement_return retval = new MySQLParser.root_statement_return();
        retval.start = input.LT(1);
        int root_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SHIFT_LEFT316=null;
        Token SHIFT_RIGHT317=null;
        Token SEMI320=null;
        Token EOF321=null;
        MySQLParser.data_manipulation_statements_return data_manipulation_statements318 = null;

        MySQLParser.data_definition_statements_return data_definition_statements319 = null;


        CommonTree SHIFT_LEFT316_tree=null;
        CommonTree SHIFT_RIGHT317_tree=null;
        CommonTree SEMI320_tree=null;
        CommonTree EOF321_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 827) ) { return retval; }
            // MySQL.g:513:15: ( ( SHIFT_LEFT SHIFT_RIGHT )? ( data_manipulation_statements | data_definition_statements ) ( SEMI )? EOF )
            // MySQL.g:514:2: ( SHIFT_LEFT SHIFT_RIGHT )? ( data_manipulation_statements | data_definition_statements ) ( SEMI )? EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // MySQL.g:514:2: ( SHIFT_LEFT SHIFT_RIGHT )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==SHIFT_LEFT) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // MySQL.g:514:3: SHIFT_LEFT SHIFT_RIGHT
                    {
                    SHIFT_LEFT316=(Token)match(input,SHIFT_LEFT,FOLLOW_SHIFT_LEFT_in_root_statement3342); if (state.failed) return retval;
                    SHIFT_RIGHT317=(Token)match(input,SHIFT_RIGHT,FOLLOW_SHIFT_RIGHT_in_root_statement3345); if (state.failed) return retval;

                    }
                    break;

            }

            // MySQL.g:515:2: ( data_manipulation_statements | data_definition_statements )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==CALL_SYM||LA76_0==DELETE_SYM||LA76_0==DO_SYM||LA76_0==HANDLER_SYM||LA76_0==INSERT||LA76_0==LOAD||LA76_0==REPLACE||LA76_0==SELECT||LA76_0==UPDATE||LA76_0==USE_SYM) ) {
                alt76=1;
            }
            else if ( (LA76_0==ALTER||LA76_0==CREATE||LA76_0==DROP||LA76_0==RENAME||LA76_0==TRUNCATE) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // MySQL.g:515:4: data_manipulation_statements
                    {
                    pushFollow(FOLLOW_data_manipulation_statements_in_root_statement3355);
                    data_manipulation_statements318=data_manipulation_statements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, data_manipulation_statements318.getTree());

                    }
                    break;
                case 2 :
                    // MySQL.g:515:35: data_definition_statements
                    {
                    pushFollow(FOLLOW_data_definition_statements_in_root_statement3359);
                    data_definition_statements319=data_definition_statements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, data_definition_statements319.getTree());

                    }
                    break;

            }

            // MySQL.g:516:2: ( SEMI )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==SEMI) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // MySQL.g:516:3: SEMI
                    {
                    SEMI320=(Token)match(input,SEMI,FOLLOW_SEMI_in_root_statement3365); if (state.failed) return retval;

                    }
                    break;

            }

            EOF321=(Token)match(input,EOF,FOLLOW_EOF_in_root_statement3370); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 827, root_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "root_statement"

    public static class data_manipulation_statements_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "data_manipulation_statements"
    // MySQL.g:519:1: data_manipulation_statements : ( select_statement | delete_statements | insert_statements | update_statements | call_statement | do_statement | handler_statements | load_data_statement | load_xml_statement | replace_statement | use_statement );
    public final MySQLParser.data_manipulation_statements_return data_manipulation_statements() throws RecognitionException {
        MySQLParser.data_manipulation_statements_return retval = new MySQLParser.data_manipulation_statements_return();
        retval.start = input.LT(1);
        int data_manipulation_statements_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQLParser.select_statement_return select_statement322 = null;

        MySQLParser.delete_statements_return delete_statements323 = null;

        MySQL_SQLParser1.insert_statements_return insert_statements324 = null;

        MySQL_SQLParser1.update_statements_return update_statements325 = null;

        MySQL_SQLParser1.call_statement_return call_statement326 = null;

        MySQL_SQLParser1.do_statement_return do_statement327 = null;

        MySQL_SQLParser1.handler_statements_return handler_statements328 = null;

        MySQL_SQLParser1.load_data_statement_return load_data_statement329 = null;

        MySQL_SQLParser1.load_xml_statement_return load_xml_statement330 = null;

        MySQL_SQLParser1.replace_statement_return replace_statement331 = null;

        MySQLParser.use_statement_return use_statement332 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 828) ) { return retval; }
            // MySQL.g:519:29: ( select_statement | delete_statements | insert_statements | update_statements | call_statement | do_statement | handler_statements | load_data_statement | load_xml_statement | replace_statement | use_statement )
            int alt78=11;
            alt78 = dfa78.predict(input);
            switch (alt78) {
                case 1 :
                    // MySQL.g:520:4: select_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_select_statement_in_data_manipulation_statements3382);
                    select_statement322=select_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, select_statement322.getTree());

                    }
                    break;
                case 2 :
                    // MySQL.g:521:4: delete_statements
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_delete_statements_in_data_manipulation_statements3387);
                    delete_statements323=delete_statements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delete_statements323.getTree());

                    }
                    break;
                case 3 :
                    // MySQL.g:522:4: insert_statements
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_insert_statements_in_data_manipulation_statements3392);
                    insert_statements324=insert_statements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, insert_statements324.getTree());

                    }
                    break;
                case 4 :
                    // MySQL.g:523:4: update_statements
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_update_statements_in_data_manipulation_statements3397);
                    update_statements325=update_statements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, update_statements325.getTree());

                    }
                    break;
                case 5 :
                    // MySQL.g:525:4: call_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_call_statement_in_data_manipulation_statements3403);
                    call_statement326=call_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, call_statement326.getTree());

                    }
                    break;
                case 6 :
                    // MySQL.g:526:4: do_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_do_statement_in_data_manipulation_statements3408);
                    do_statement327=do_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, do_statement327.getTree());

                    }
                    break;
                case 7 :
                    // MySQL.g:527:4: handler_statements
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_handler_statements_in_data_manipulation_statements3413);
                    handler_statements328=handler_statements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, handler_statements328.getTree());

                    }
                    break;
                case 8 :
                    // MySQL.g:528:4: load_data_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_load_data_statement_in_data_manipulation_statements3418);
                    load_data_statement329=load_data_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, load_data_statement329.getTree());

                    }
                    break;
                case 9 :
                    // MySQL.g:529:4: load_xml_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_load_xml_statement_in_data_manipulation_statements3423);
                    load_xml_statement330=load_xml_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, load_xml_statement330.getTree());

                    }
                    break;
                case 10 :
                    // MySQL.g:530:4: replace_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_replace_statement_in_data_manipulation_statements3428);
                    replace_statement331=replace_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, replace_statement331.getTree());

                    }
                    break;
                case 11 :
                    // MySQL.g:531:4: use_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_use_statement_in_data_manipulation_statements3433);
                    use_statement332=use_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, use_statement332.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 828, data_manipulation_statements_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "data_manipulation_statements"

    public static class data_definition_statements_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "data_definition_statements"
    // MySQL.g:534:1: data_definition_statements : ( create_database_statement | alter_database_statements | drop_database_statement | create_event_statement | alter_event_statement | drop_event_statement | create_server_statement | alter_server_statement | drop_server_statement | create_table_statement | alter_table_statement | drop_table_statement | create_view_statement | alter_view_statement | rename_table_statement | drop_view_statement | truncate_table_statement | create_index_statement | drop_index_statement );
    public final MySQLParser.data_definition_statements_return data_definition_statements() throws RecognitionException {
        MySQLParser.data_definition_statements_return retval = new MySQLParser.data_definition_statements_return();
        retval.start = input.LT(1);
        int data_definition_statements_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQL_SQLParser1.create_database_statement_return create_database_statement333 = null;

        MySQL_SQLParser1.alter_database_statements_return alter_database_statements334 = null;

        MySQL_SQLParser1.drop_database_statement_return drop_database_statement335 = null;

        MySQL_SQLParser1.create_event_statement_return create_event_statement336 = null;

        MySQL_SQLParser1.alter_event_statement_return alter_event_statement337 = null;

        MySQL_SQLParser1.drop_event_statement_return drop_event_statement338 = null;

        MySQL_SQLParser1.create_server_statement_return create_server_statement339 = null;

        MySQL_SQLParser1.alter_server_statement_return alter_server_statement340 = null;

        MySQL_SQLParser1.drop_server_statement_return drop_server_statement341 = null;

        MySQL_SQLParser2.create_table_statement_return create_table_statement342 = null;

        MySQL_SQLParser2.alter_table_statement_return alter_table_statement343 = null;

        MySQL_SQLParser2.drop_table_statement_return drop_table_statement344 = null;

        MySQL_SQLParser2.create_view_statement_return create_view_statement345 = null;

        MySQL_SQLParser2.alter_view_statement_return alter_view_statement346 = null;

        MySQL_SQLParser2.rename_table_statement_return rename_table_statement347 = null;

        MySQL_SQLParser2.drop_view_statement_return drop_view_statement348 = null;

        MySQL_SQLParser2.truncate_table_statement_return truncate_table_statement349 = null;

        MySQL_SQLParser1.create_index_statement_return create_index_statement350 = null;

        MySQL_SQLParser1.drop_index_statement_return drop_index_statement351 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 829) ) { return retval; }
            // MySQL.g:534:27: ( create_database_statement | alter_database_statements | drop_database_statement | create_event_statement | alter_event_statement | drop_event_statement | create_server_statement | alter_server_statement | drop_server_statement | create_table_statement | alter_table_statement | drop_table_statement | create_view_statement | alter_view_statement | rename_table_statement | drop_view_statement | truncate_table_statement | create_index_statement | drop_index_statement )
            int alt79=19;
            alt79 = dfa79.predict(input);
            switch (alt79) {
                case 1 :
                    // MySQL.g:535:4: create_database_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_create_database_statement_in_data_definition_statements3445);
                    create_database_statement333=create_database_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_database_statement333.getTree());

                    }
                    break;
                case 2 :
                    // MySQL.g:536:4: alter_database_statements
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_alter_database_statements_in_data_definition_statements3450);
                    alter_database_statements334=alter_database_statements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, alter_database_statements334.getTree());

                    }
                    break;
                case 3 :
                    // MySQL.g:537:4: drop_database_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_drop_database_statement_in_data_definition_statements3455);
                    drop_database_statement335=drop_database_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_database_statement335.getTree());

                    }
                    break;
                case 4 :
                    // MySQL.g:539:4: create_event_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_create_event_statement_in_data_definition_statements3462);
                    create_event_statement336=create_event_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_event_statement336.getTree());

                    }
                    break;
                case 5 :
                    // MySQL.g:540:4: alter_event_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_alter_event_statement_in_data_definition_statements3467);
                    alter_event_statement337=alter_event_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, alter_event_statement337.getTree());

                    }
                    break;
                case 6 :
                    // MySQL.g:541:4: drop_event_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_drop_event_statement_in_data_definition_statements3472);
                    drop_event_statement338=drop_event_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_event_statement338.getTree());

                    }
                    break;
                case 7 :
                    // MySQL.g:543:4: create_server_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_create_server_statement_in_data_definition_statements3479);
                    create_server_statement339=create_server_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_server_statement339.getTree());

                    }
                    break;
                case 8 :
                    // MySQL.g:544:4: alter_server_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_alter_server_statement_in_data_definition_statements3484);
                    alter_server_statement340=alter_server_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, alter_server_statement340.getTree());

                    }
                    break;
                case 9 :
                    // MySQL.g:545:4: drop_server_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_drop_server_statement_in_data_definition_statements3489);
                    drop_server_statement341=drop_server_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_server_statement341.getTree());

                    }
                    break;
                case 10 :
                    // MySQL.g:547:4: create_table_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_create_table_statement_in_data_definition_statements3496);
                    create_table_statement342=create_table_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_table_statement342.getTree());

                    }
                    break;
                case 11 :
                    // MySQL.g:548:4: alter_table_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_alter_table_statement_in_data_definition_statements3501);
                    alter_table_statement343=alter_table_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, alter_table_statement343.getTree());

                    }
                    break;
                case 12 :
                    // MySQL.g:549:4: drop_table_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_drop_table_statement_in_data_definition_statements3506);
                    drop_table_statement344=drop_table_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_table_statement344.getTree());

                    }
                    break;
                case 13 :
                    // MySQL.g:551:4: create_view_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_create_view_statement_in_data_definition_statements3513);
                    create_view_statement345=create_view_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_view_statement345.getTree());

                    }
                    break;
                case 14 :
                    // MySQL.g:552:4: alter_view_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_alter_view_statement_in_data_definition_statements3518);
                    alter_view_statement346=alter_view_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, alter_view_statement346.getTree());

                    }
                    break;
                case 15 :
                    // MySQL.g:553:4: rename_table_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_rename_table_statement_in_data_definition_statements3523);
                    rename_table_statement347=rename_table_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rename_table_statement347.getTree());

                    }
                    break;
                case 16 :
                    // MySQL.g:554:4: drop_view_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_drop_view_statement_in_data_definition_statements3528);
                    drop_view_statement348=drop_view_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_view_statement348.getTree());

                    }
                    break;
                case 17 :
                    // MySQL.g:555:4: truncate_table_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_truncate_table_statement_in_data_definition_statements3533);
                    truncate_table_statement349=truncate_table_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, truncate_table_statement349.getTree());

                    }
                    break;
                case 18 :
                    // MySQL.g:557:4: create_index_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_create_index_statement_in_data_definition_statements3540);
                    create_index_statement350=create_index_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_index_statement350.getTree());

                    }
                    break;
                case 19 :
                    // MySQL.g:558:4: drop_index_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_drop_index_statement_in_data_definition_statements3545);
                    drop_index_statement351=drop_index_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_index_statement351.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 829, data_definition_statements_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "data_definition_statements"

    public static class use_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "use_statement"
    // MySQL.g:561:1: use_statement : USE_SYM schema_name -> ^( USE_SYM schema_name ) ;
    public final MySQLParser.use_statement_return use_statement() throws RecognitionException {
        MySQLParser.use_statement_return retval = new MySQLParser.use_statement_return();
        retval.start = input.LT(1);
        int use_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token USE_SYM352=null;
        MySQLParser.schema_name_return schema_name353 = null;


        CommonTree USE_SYM352_tree=null;
        RewriteRuleTokenStream stream_USE_SYM=new RewriteRuleTokenStream(adaptor,"token USE_SYM");
        RewriteRuleSubtreeStream stream_schema_name=new RewriteRuleSubtreeStream(adaptor,"rule schema_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 830) ) { return retval; }
            // MySQL.g:561:14: ( USE_SYM schema_name -> ^( USE_SYM schema_name ) )
            // MySQL.g:562:3: USE_SYM schema_name
            {
            USE_SYM352=(Token)match(input,USE_SYM,FOLLOW_USE_SYM_in_use_statement3555); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_USE_SYM.add(USE_SYM352);

            pushFollow(FOLLOW_schema_name_in_use_statement3557);
            schema_name353=schema_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_schema_name.add(schema_name353.getTree());


            // AST REWRITE
            // elements: schema_name, USE_SYM
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 562:23: -> ^( USE_SYM schema_name )
            {
                // MySQL.g:562:26: ^( USE_SYM schema_name )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_USE_SYM.nextNode(), root_1);

                adaptor.addChild(root_1, stream_schema_name.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 830, use_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "use_statement"

    public static class select_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select_statement"
    // MySQL.g:566:1: select_statement : select_expression ( ( UNION_SYM ( ALL )? ) select_expression )* -> ^( select_expression ( ^( TN_UNION select_expression ) )* ) ;
    public final MySQLParser.select_statement_return select_statement() throws RecognitionException {
        MySQLParser.select_statement_return retval = new MySQLParser.select_statement_return();
        retval.start = input.LT(1);
        int select_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token UNION_SYM355=null;
        Token ALL356=null;
        MySQLParser.select_expression_return select_expression354 = null;

        MySQLParser.select_expression_return select_expression357 = null;


        CommonTree UNION_SYM355_tree=null;
        CommonTree ALL356_tree=null;
        RewriteRuleTokenStream stream_UNION_SYM=new RewriteRuleTokenStream(adaptor,"token UNION_SYM");
        RewriteRuleTokenStream stream_ALL=new RewriteRuleTokenStream(adaptor,"token ALL");
        RewriteRuleSubtreeStream stream_select_expression=new RewriteRuleSubtreeStream(adaptor,"rule select_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 831) ) { return retval; }
            // MySQL.g:566:17: ( select_expression ( ( UNION_SYM ( ALL )? ) select_expression )* -> ^( select_expression ( ^( TN_UNION select_expression ) )* ) )
            // MySQL.g:567:9: select_expression ( ( UNION_SYM ( ALL )? ) select_expression )*
            {
            pushFollow(FOLLOW_select_expression_in_select_statement3582);
            select_expression354=select_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select_expression.add(select_expression354.getTree());
            // MySQL.g:567:27: ( ( UNION_SYM ( ALL )? ) select_expression )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==UNION_SYM) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // MySQL.g:567:29: ( UNION_SYM ( ALL )? ) select_expression
            	    {
            	    // MySQL.g:567:29: ( UNION_SYM ( ALL )? )
            	    // MySQL.g:567:30: UNION_SYM ( ALL )?
            	    {
            	    UNION_SYM355=(Token)match(input,UNION_SYM,FOLLOW_UNION_SYM_in_select_statement3587); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_UNION_SYM.add(UNION_SYM355);

            	    // MySQL.g:567:40: ( ALL )?
            	    int alt80=2;
            	    int LA80_0 = input.LA(1);

            	    if ( (LA80_0==ALL) ) {
            	        alt80=1;
            	    }
            	    switch (alt80) {
            	        case 1 :
            	            // MySQL.g:567:41: ALL
            	            {
            	            ALL356=(Token)match(input,ALL,FOLLOW_ALL_in_select_statement3590); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_ALL.add(ALL356);


            	            }
            	            break;

            	    }


            	    }

            	    pushFollow(FOLLOW_select_expression_in_select_statement3596);
            	    select_expression357=select_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_select_expression.add(select_expression357.getTree());

            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);



            // AST REWRITE
            // elements: select_expression, select_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 567:70: -> ^( select_expression ( ^( TN_UNION select_expression ) )* )
            {
                // MySQL.g:567:73: ^( select_expression ( ^( TN_UNION select_expression ) )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_select_expression.nextNode(), root_1);

                // MySQL.g:567:93: ( ^( TN_UNION select_expression ) )*
                while ( stream_select_expression.hasNext() ) {
                    // MySQL.g:567:93: ^( TN_UNION select_expression )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_UNION, "TN_UNION"), root_2);

                    adaptor.addChild(root_2, stream_select_expression.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_select_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 831, select_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "select_statement"

    public static class select_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select_expression"
    // MySQL.g:570:1: select_expression : SELECT select_expresssion_cont -> ^( TN_SELECT select_expresssion_cont ) ;
    public final MySQLParser.select_expression_return select_expression() throws RecognitionException {
        MySQLParser.select_expression_return retval = new MySQLParser.select_expression_return();
        retval.start = input.LT(1);
        int select_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SELECT358=null;
        MySQLParser.select_expresssion_cont_return select_expresssion_cont359 = null;


        CommonTree SELECT358_tree=null;
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_select_expresssion_cont=new RewriteRuleSubtreeStream(adaptor,"rule select_expresssion_cont");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 832) ) { return retval; }
            // MySQL.g:570:18: ( SELECT select_expresssion_cont -> ^( TN_SELECT select_expresssion_cont ) )
            // MySQL.g:571:2: SELECT select_expresssion_cont
            {
            SELECT358=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_expression3621); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SELECT.add(SELECT358);

            pushFollow(FOLLOW_select_expresssion_cont_in_select_expression3625);
            select_expresssion_cont359=select_expresssion_cont();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select_expresssion_cont.add(select_expresssion_cont359.getTree());


            // AST REWRITE
            // elements: select_expresssion_cont
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 573:2: -> ^( TN_SELECT select_expresssion_cont )
            {
                // MySQL.g:573:5: ^( TN_SELECT select_expresssion_cont )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_SELECT, "TN_SELECT"), root_1);

                adaptor.addChild(root_1, stream_select_expresssion_cont.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 832, select_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "select_expression"

    public static class select_expresssion_cont_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select_expresssion_cont"
    // MySQL.g:576:1: select_expresssion_cont : ( select_options )? select_list ( select_expression_cont2 )? -> ( ^( TN_SELECT_OPTIONS select_options ) )? ^( TN_COLS select_list ) ( select_expression_cont2 )? ;
    public final MySQLParser.select_expresssion_cont_return select_expresssion_cont() throws RecognitionException {
        MySQLParser.select_expresssion_cont_return retval = new MySQLParser.select_expresssion_cont_return();
        retval.start = input.LT(1);
        int select_expresssion_cont_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQLParser.select_options_return select_options360 = null;

        MySQLParser.select_list_return select_list361 = null;

        MySQLParser.select_expression_cont2_return select_expression_cont2362 = null;


        RewriteRuleSubtreeStream stream_select_list=new RewriteRuleSubtreeStream(adaptor,"rule select_list");
        RewriteRuleSubtreeStream stream_select_expression_cont2=new RewriteRuleSubtreeStream(adaptor,"rule select_expression_cont2");
        RewriteRuleSubtreeStream stream_select_options=new RewriteRuleSubtreeStream(adaptor,"rule select_options");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 833) ) { return retval; }
            // MySQL.g:576:24: ( ( select_options )? select_list ( select_expression_cont2 )? -> ( ^( TN_SELECT_OPTIONS select_options ) )? ^( TN_COLS select_list ) ( select_expression_cont2 )? )
            // MySQL.g:577:2: ( select_options )? select_list ( select_expression_cont2 )?
            {
            // MySQL.g:577:2: ( select_options )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // MySQL.g:0:0: select_options
                    {
                    pushFollow(FOLLOW_select_options_in_select_expresssion_cont3644);
                    select_options360=select_options();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_select_options.add(select_options360.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_select_list_in_select_expresssion_cont3648);
            select_list361=select_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select_list.add(select_list361.getTree());
            // MySQL.g:579:2: ( select_expression_cont2 )?
            int alt83=2;
            switch ( input.LA(1) ) {
                case FOR_SYM:
                case FROM:
                case LIMIT:
                case LOCK:
                case ORDER_SYM:
                case INTEGER_NUM:
                    {
                    alt83=1;
                    }
                    break;
                case ON:
                    {
                    int LA83_2 = input.LA(2);

                    if ( (synpred407_MySQL()) ) {
                        alt83=1;
                    }
                    }
                    break;
                case EOF:
                    {
                    int LA83_3 = input.LA(2);

                    if ( (synpred407_MySQL()) ) {
                        alt83=1;
                    }
                    }
                    break;
                case SEMI:
                    {
                    int LA83_4 = input.LA(2);

                    if ( (synpred407_MySQL()) ) {
                        alt83=1;
                    }
                    }
                    break;
                case UNION_SYM:
                    {
                    int LA83_5 = input.LA(2);

                    if ( (synpred407_MySQL()) ) {
                        alt83=1;
                    }
                    }
                    break;
                case WITH:
                    {
                    int LA83_6 = input.LA(2);

                    if ( (synpred407_MySQL()) ) {
                        alt83=1;
                    }
                    }
                    break;
                case RPAREN:
                    {
                    int LA83_7 = input.LA(2);

                    if ( (synpred407_MySQL()) ) {
                        alt83=1;
                    }
                    }
                    break;
            }

            switch (alt83) {
                case 1 :
                    // MySQL.g:0:0: select_expression_cont2
                    {
                    pushFollow(FOLLOW_select_expression_cont2_in_select_expresssion_cont3651);
                    select_expression_cont2362=select_expression_cont2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_select_expression_cont2.add(select_expression_cont2362.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: select_options, select_expression_cont2, select_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 580:2: -> ( ^( TN_SELECT_OPTIONS select_options ) )? ^( TN_COLS select_list ) ( select_expression_cont2 )?
            {
                // MySQL.g:580:5: ( ^( TN_SELECT_OPTIONS select_options ) )?
                if ( stream_select_options.hasNext() ) {
                    // MySQL.g:580:5: ^( TN_SELECT_OPTIONS select_options )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_SELECT_OPTIONS, "TN_SELECT_OPTIONS"), root_1);

                    adaptor.addChild(root_1, stream_select_options.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_select_options.reset();
                // MySQL.g:580:42: ^( TN_COLS select_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_COLS, "TN_COLS"), root_1);

                adaptor.addChild(root_1, stream_select_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }
                // MySQL.g:580:65: ( select_expression_cont2 )?
                if ( stream_select_expression_cont2.hasNext() ) {
                    adaptor.addChild(root_0, stream_select_expression_cont2.nextTree());

                }
                stream_select_expression_cont2.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 833, select_expresssion_cont_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "select_expresssion_cont"

    public static class select_expression_cont2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select_expression_cont2"
    // MySQL.g:583:1: select_expression_cont2 : ( FROM table_references ( partition_clause )? ( where_clause )? ( groupby_clause )? ( having_clause )? )? ( orderby_clause )? ( limit_clause )? ( lock_type )? -> ( ^( TN_FROM table_references ( ^( TN_PARTITION partition_clause ) )? ( ^( TN_WHERE where_clause ) )? ( ^( groupby_clause ) )? ( ^( TN_HAVING having_clause ) )? ) )? ( ^( orderby_clause ) )? ( ^( TN_LIMIT limit_clause ) )? ( ^( TN_LOCKTYPE lock_type ) )? ;
    public final MySQLParser.select_expression_cont2_return select_expression_cont2() throws RecognitionException {
        MySQLParser.select_expression_cont2_return retval = new MySQLParser.select_expression_cont2_return();
        retval.start = input.LT(1);
        int select_expression_cont2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token FROM363=null;
        MySQLParser.table_references_return table_references364 = null;

        MySQLParser.partition_clause_return partition_clause365 = null;

        MySQLParser.where_clause_return where_clause366 = null;

        MySQLParser.groupby_clause_return groupby_clause367 = null;

        MySQLParser.having_clause_return having_clause368 = null;

        MySQLParser.orderby_clause_return orderby_clause369 = null;

        MySQLParser.limit_clause_return limit_clause370 = null;

        MySQLParser.lock_type_return lock_type371 = null;


        CommonTree FROM363_tree=null;
        RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
        RewriteRuleSubtreeStream stream_groupby_clause=new RewriteRuleSubtreeStream(adaptor,"rule groupby_clause");
        RewriteRuleSubtreeStream stream_lock_type=new RewriteRuleSubtreeStream(adaptor,"rule lock_type");
        RewriteRuleSubtreeStream stream_table_references=new RewriteRuleSubtreeStream(adaptor,"rule table_references");
        RewriteRuleSubtreeStream stream_having_clause=new RewriteRuleSubtreeStream(adaptor,"rule having_clause");
        RewriteRuleSubtreeStream stream_limit_clause=new RewriteRuleSubtreeStream(adaptor,"rule limit_clause");
        RewriteRuleSubtreeStream stream_where_clause=new RewriteRuleSubtreeStream(adaptor,"rule where_clause");
        RewriteRuleSubtreeStream stream_partition_clause=new RewriteRuleSubtreeStream(adaptor,"rule partition_clause");
        RewriteRuleSubtreeStream stream_orderby_clause=new RewriteRuleSubtreeStream(adaptor,"rule orderby_clause");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 834) ) { return retval; }
            // MySQL.g:583:24: ( ( FROM table_references ( partition_clause )? ( where_clause )? ( groupby_clause )? ( having_clause )? )? ( orderby_clause )? ( limit_clause )? ( lock_type )? -> ( ^( TN_FROM table_references ( ^( TN_PARTITION partition_clause ) )? ( ^( TN_WHERE where_clause ) )? ( ^( groupby_clause ) )? ( ^( TN_HAVING having_clause ) )? ) )? ( ^( orderby_clause ) )? ( ^( TN_LIMIT limit_clause ) )? ( ^( TN_LOCKTYPE lock_type ) )? )
            // MySQL.g:584:2: ( FROM table_references ( partition_clause )? ( where_clause )? ( groupby_clause )? ( having_clause )? )? ( orderby_clause )? ( limit_clause )? ( lock_type )?
            {
            // MySQL.g:584:2: ( FROM table_references ( partition_clause )? ( where_clause )? ( groupby_clause )? ( having_clause )? )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==FROM) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // MySQL.g:585:3: FROM table_references ( partition_clause )? ( where_clause )? ( groupby_clause )? ( having_clause )?
                    {
                    FROM363=(Token)match(input,FROM,FOLLOW_FROM_in_select_expression_cont23686); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FROM.add(FROM363);

                    pushFollow(FOLLOW_table_references_in_select_expression_cont23688);
                    table_references364=table_references();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_table_references.add(table_references364.getTree());
                    // MySQL.g:586:3: ( partition_clause )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==PARTITION_SYM) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // MySQL.g:586:5: partition_clause
                            {
                            pushFollow(FOLLOW_partition_clause_in_select_expression_cont23694);
                            partition_clause365=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_partition_clause.add(partition_clause365.getTree());

                            }
                            break;

                    }

                    // MySQL.g:587:3: ( where_clause )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==WHERE) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // MySQL.g:587:5: where_clause
                            {
                            pushFollow(FOLLOW_where_clause_in_select_expression_cont23703);
                            where_clause366=where_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_where_clause.add(where_clause366.getTree());

                            }
                            break;

                    }

                    // MySQL.g:588:3: ( groupby_clause )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==GROUP_SYM) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // MySQL.g:588:5: groupby_clause
                            {
                            pushFollow(FOLLOW_groupby_clause_in_select_expression_cont23713);
                            groupby_clause367=groupby_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_groupby_clause.add(groupby_clause367.getTree());

                            }
                            break;

                    }

                    // MySQL.g:589:3: ( having_clause )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==HAVING) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // MySQL.g:589:5: having_clause
                            {
                            pushFollow(FOLLOW_having_clause_in_select_expression_cont23722);
                            having_clause368=having_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_having_clause.add(having_clause368.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            // MySQL.g:591:2: ( orderby_clause )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==ORDER_SYM) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // MySQL.g:591:4: orderby_clause
                    {
                    pushFollow(FOLLOW_orderby_clause_in_select_expression_cont23736);
                    orderby_clause369=orderby_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_orderby_clause.add(orderby_clause369.getTree());

                    }
                    break;

            }

            // MySQL.g:592:2: ( limit_clause )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==LIMIT||LA90_0==INTEGER_NUM) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // MySQL.g:592:4: limit_clause
                    {
                    pushFollow(FOLLOW_limit_clause_in_select_expression_cont23744);
                    limit_clause370=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_limit_clause.add(limit_clause370.getTree());

                    }
                    break;

            }

            // MySQL.g:593:2: ( lock_type )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==FOR_SYM||LA91_0==LOCK) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // MySQL.g:593:4: lock_type
                    {
                    pushFollow(FOLLOW_lock_type_in_select_expression_cont23752);
                    lock_type371=lock_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lock_type.add(lock_type371.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: having_clause, lock_type, groupby_clause, orderby_clause, limit_clause, where_clause, partition_clause, table_references
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 594:2: -> ( ^( TN_FROM table_references ( ^( TN_PARTITION partition_clause ) )? ( ^( TN_WHERE where_clause ) )? ( ^( groupby_clause ) )? ( ^( TN_HAVING having_clause ) )? ) )? ( ^( orderby_clause ) )? ( ^( TN_LIMIT limit_clause ) )? ( ^( TN_LOCKTYPE lock_type ) )?
            {
                // MySQL.g:594:5: ( ^( TN_FROM table_references ( ^( TN_PARTITION partition_clause ) )? ( ^( TN_WHERE where_clause ) )? ( ^( groupby_clause ) )? ( ^( TN_HAVING having_clause ) )? ) )?
                if ( stream_having_clause.hasNext()||stream_groupby_clause.hasNext()||stream_where_clause.hasNext()||stream_partition_clause.hasNext()||stream_table_references.hasNext() ) {
                    // MySQL.g:594:5: ^( TN_FROM table_references ( ^( TN_PARTITION partition_clause ) )? ( ^( TN_WHERE where_clause ) )? ( ^( groupby_clause ) )? ( ^( TN_HAVING having_clause ) )? )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_FROM, "TN_FROM"), root_1);

                    adaptor.addChild(root_1, stream_table_references.nextTree());
                    // MySQL.g:594:32: ( ^( TN_PARTITION partition_clause ) )?
                    if ( stream_partition_clause.hasNext() ) {
                        // MySQL.g:594:32: ^( TN_PARTITION partition_clause )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_PARTITION, "TN_PARTITION"), root_2);

                        adaptor.addChild(root_2, stream_partition_clause.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                    }
                    stream_partition_clause.reset();
                    // MySQL.g:594:66: ( ^( TN_WHERE where_clause ) )?
                    if ( stream_where_clause.hasNext() ) {
                        // MySQL.g:594:66: ^( TN_WHERE where_clause )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_WHERE, "TN_WHERE"), root_2);

                        adaptor.addChild(root_2, stream_where_clause.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                    }
                    stream_where_clause.reset();
                    // MySQL.g:594:92: ( ^( groupby_clause ) )?
                    if ( stream_groupby_clause.hasNext() ) {
                        // MySQL.g:594:92: ^( groupby_clause )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(stream_groupby_clause.nextNode(), root_2);

                        adaptor.addChild(root_1, root_2);
                        }

                    }
                    stream_groupby_clause.reset();
                    // MySQL.g:594:111: ( ^( TN_HAVING having_clause ) )?
                    if ( stream_having_clause.hasNext() ) {
                        // MySQL.g:594:111: ^( TN_HAVING having_clause )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_HAVING, "TN_HAVING"), root_2);

                        adaptor.addChild(root_2, stream_having_clause.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                    }
                    stream_having_clause.reset();

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_having_clause.reset();
                stream_groupby_clause.reset();
                stream_where_clause.reset();
                stream_partition_clause.reset();
                stream_table_references.reset();
                // MySQL.g:595:2: ( ^( orderby_clause ) )?
                if ( stream_orderby_clause.hasNext() ) {
                    // MySQL.g:595:2: ^( orderby_clause )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(stream_orderby_clause.nextNode(), root_1);

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_orderby_clause.reset();
                // MySQL.g:595:21: ( ^( TN_LIMIT limit_clause ) )?
                if ( stream_limit_clause.hasNext() ) {
                    // MySQL.g:595:21: ^( TN_LIMIT limit_clause )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_LIMIT, "TN_LIMIT"), root_1);

                    adaptor.addChild(root_1, stream_limit_clause.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_limit_clause.reset();
                // MySQL.g:595:47: ( ^( TN_LOCKTYPE lock_type ) )?
                if ( stream_lock_type.hasNext() ) {
                    // MySQL.g:595:47: ^( TN_LOCKTYPE lock_type )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_LOCKTYPE, "TN_LOCKTYPE"), root_1);

                    adaptor.addChild(root_1, stream_lock_type.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_lock_type.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 834, select_expression_cont2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "select_expression_cont2"

    public static class select_options_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select_options"
    // MySQL.g:598:1: select_options : ( ALL | DISTINCT | DISTINCTROW )? ( HIGH_PRIORITY )? ( STRAIGHT_JOIN )? ( SQL_SMALL_RESULT )? ( SQL_BIG_RESULT )? ( SQL_BUFFER_RESULT )? ( SQL_CACHE_SYM | SQL_NO_CACHE_SYM )? ( SQL_CALC_FOUND_ROWS )? ;
    public final MySQLParser.select_options_return select_options() throws RecognitionException {
        MySQLParser.select_options_return retval = new MySQLParser.select_options_return();
        retval.start = input.LT(1);
        int select_options_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set372=null;
        Token HIGH_PRIORITY373=null;
        Token STRAIGHT_JOIN374=null;
        Token SQL_SMALL_RESULT375=null;
        Token SQL_BIG_RESULT376=null;
        Token SQL_BUFFER_RESULT377=null;
        Token set378=null;
        Token SQL_CALC_FOUND_ROWS379=null;

        CommonTree set372_tree=null;
        CommonTree HIGH_PRIORITY373_tree=null;
        CommonTree STRAIGHT_JOIN374_tree=null;
        CommonTree SQL_SMALL_RESULT375_tree=null;
        CommonTree SQL_BIG_RESULT376_tree=null;
        CommonTree SQL_BUFFER_RESULT377_tree=null;
        CommonTree set378_tree=null;
        CommonTree SQL_CALC_FOUND_ROWS379_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 835) ) { return retval; }
            // MySQL.g:598:15: ( ( ALL | DISTINCT | DISTINCTROW )? ( HIGH_PRIORITY )? ( STRAIGHT_JOIN )? ( SQL_SMALL_RESULT )? ( SQL_BIG_RESULT )? ( SQL_BUFFER_RESULT )? ( SQL_CACHE_SYM | SQL_NO_CACHE_SYM )? ( SQL_CALC_FOUND_ROWS )? )
            // MySQL.g:599:2: ( ALL | DISTINCT | DISTINCTROW )? ( HIGH_PRIORITY )? ( STRAIGHT_JOIN )? ( SQL_SMALL_RESULT )? ( SQL_BIG_RESULT )? ( SQL_BUFFER_RESULT )? ( SQL_CACHE_SYM | SQL_NO_CACHE_SYM )? ( SQL_CALC_FOUND_ROWS )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // MySQL.g:599:2: ( ALL | DISTINCT | DISTINCTROW )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==ALL||(LA92_0>=DISTINCT && LA92_0<=DISTINCTROW)) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // MySQL.g:
                    {
                    set372=(Token)input.LT(1);
                    if ( input.LA(1)==ALL||(input.LA(1)>=DISTINCT && input.LA(1)<=DISTINCTROW) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set372));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }

            // MySQL.g:600:2: ( HIGH_PRIORITY )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==HIGH_PRIORITY) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // MySQL.g:600:3: HIGH_PRIORITY
                    {
                    HIGH_PRIORITY373=(Token)match(input,HIGH_PRIORITY,FOLLOW_HIGH_PRIORITY_in_select_options3841); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HIGH_PRIORITY373_tree = (CommonTree)adaptor.create(HIGH_PRIORITY373);
                    adaptor.addChild(root_0, HIGH_PRIORITY373_tree);
                    }

                    }
                    break;

            }

            // MySQL.g:601:2: ( STRAIGHT_JOIN )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==STRAIGHT_JOIN) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // MySQL.g:601:3: STRAIGHT_JOIN
                    {
                    STRAIGHT_JOIN374=(Token)match(input,STRAIGHT_JOIN,FOLLOW_STRAIGHT_JOIN_in_select_options3847); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRAIGHT_JOIN374_tree = (CommonTree)adaptor.create(STRAIGHT_JOIN374);
                    adaptor.addChild(root_0, STRAIGHT_JOIN374_tree);
                    }

                    }
                    break;

            }

            // MySQL.g:602:2: ( SQL_SMALL_RESULT )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==SQL_SMALL_RESULT) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // MySQL.g:602:3: SQL_SMALL_RESULT
                    {
                    SQL_SMALL_RESULT375=(Token)match(input,SQL_SMALL_RESULT,FOLLOW_SQL_SMALL_RESULT_in_select_options3853); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SQL_SMALL_RESULT375_tree = (CommonTree)adaptor.create(SQL_SMALL_RESULT375);
                    adaptor.addChild(root_0, SQL_SMALL_RESULT375_tree);
                    }

                    }
                    break;

            }

            // MySQL.g:602:22: ( SQL_BIG_RESULT )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==SQL_BIG_RESULT) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // MySQL.g:602:23: SQL_BIG_RESULT
                    {
                    SQL_BIG_RESULT376=(Token)match(input,SQL_BIG_RESULT,FOLLOW_SQL_BIG_RESULT_in_select_options3858); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SQL_BIG_RESULT376_tree = (CommonTree)adaptor.create(SQL_BIG_RESULT376);
                    adaptor.addChild(root_0, SQL_BIG_RESULT376_tree);
                    }

                    }
                    break;

            }

            // MySQL.g:602:40: ( SQL_BUFFER_RESULT )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==SQL_BUFFER_RESULT) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // MySQL.g:602:41: SQL_BUFFER_RESULT
                    {
                    SQL_BUFFER_RESULT377=(Token)match(input,SQL_BUFFER_RESULT,FOLLOW_SQL_BUFFER_RESULT_in_select_options3863); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SQL_BUFFER_RESULT377_tree = (CommonTree)adaptor.create(SQL_BUFFER_RESULT377);
                    adaptor.addChild(root_0, SQL_BUFFER_RESULT377_tree);
                    }

                    }
                    break;

            }

            // MySQL.g:603:2: ( SQL_CACHE_SYM | SQL_NO_CACHE_SYM )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==SQL_CACHE_SYM||LA98_0==SQL_NO_CACHE_SYM) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // MySQL.g:
                    {
                    set378=(Token)input.LT(1);
                    if ( input.LA(1)==SQL_CACHE_SYM||input.LA(1)==SQL_NO_CACHE_SYM ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set378));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }

            // MySQL.g:603:38: ( SQL_CALC_FOUND_ROWS )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==SQL_CALC_FOUND_ROWS) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // MySQL.g:603:39: SQL_CALC_FOUND_ROWS
                    {
                    SQL_CALC_FOUND_ROWS379=(Token)match(input,SQL_CALC_FOUND_ROWS,FOLLOW_SQL_CALC_FOUND_ROWS_in_select_options3878); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SQL_CALC_FOUND_ROWS379_tree = (CommonTree)adaptor.create(SQL_CALC_FOUND_ROWS379);
                    adaptor.addChild(root_0, SQL_CALC_FOUND_ROWS379_tree);
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 835, select_options_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "select_options"

    public static class lock_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lock_type"
    // MySQL.g:606:1: lock_type : ( ( FOR_SYM UPDATE ) | ( LOCK IN_SYM SHARE_SYM MODE_SYM ) );
    public final MySQLParser.lock_type_return lock_type() throws RecognitionException {
        MySQLParser.lock_type_return retval = new MySQLParser.lock_type_return();
        retval.start = input.LT(1);
        int lock_type_StartIndex = input.index();
        CommonTree root_0 = null;

        Token FOR_SYM380=null;
        Token UPDATE381=null;
        Token LOCK382=null;
        Token IN_SYM383=null;
        Token SHARE_SYM384=null;
        Token MODE_SYM385=null;

        CommonTree FOR_SYM380_tree=null;
        CommonTree UPDATE381_tree=null;
        CommonTree LOCK382_tree=null;
        CommonTree IN_SYM383_tree=null;
        CommonTree SHARE_SYM384_tree=null;
        CommonTree MODE_SYM385_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 836) ) { return retval; }
            // MySQL.g:606:10: ( ( FOR_SYM UPDATE ) | ( LOCK IN_SYM SHARE_SYM MODE_SYM ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==FOR_SYM) ) {
                alt100=1;
            }
            else if ( (LA100_0==LOCK) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // MySQL.g:607:2: ( FOR_SYM UPDATE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:607:2: ( FOR_SYM UPDATE )
                    // MySQL.g:607:4: FOR_SYM UPDATE
                    {
                    FOR_SYM380=(Token)match(input,FOR_SYM,FOLLOW_FOR_SYM_in_lock_type3893); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOR_SYM380_tree = (CommonTree)adaptor.create(FOR_SYM380);
                    adaptor.addChild(root_0, FOR_SYM380_tree);
                    }
                    UPDATE381=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_lock_type3895); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UPDATE381_tree = (CommonTree)adaptor.create(UPDATE381);
                    adaptor.addChild(root_0, UPDATE381_tree);
                    }

                    }


                    }
                    break;
                case 2 :
                    // MySQL.g:607:22: ( LOCK IN_SYM SHARE_SYM MODE_SYM )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:607:22: ( LOCK IN_SYM SHARE_SYM MODE_SYM )
                    // MySQL.g:607:23: LOCK IN_SYM SHARE_SYM MODE_SYM
                    {
                    LOCK382=(Token)match(input,LOCK,FOLLOW_LOCK_in_lock_type3901); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOCK382_tree = (CommonTree)adaptor.create(LOCK382);
                    adaptor.addChild(root_0, LOCK382_tree);
                    }
                    IN_SYM383=(Token)match(input,IN_SYM,FOLLOW_IN_SYM_in_lock_type3903); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN_SYM383_tree = (CommonTree)adaptor.create(IN_SYM383);
                    adaptor.addChild(root_0, IN_SYM383_tree);
                    }
                    SHARE_SYM384=(Token)match(input,SHARE_SYM,FOLLOW_SHARE_SYM_in_lock_type3905); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHARE_SYM384_tree = (CommonTree)adaptor.create(SHARE_SYM384);
                    adaptor.addChild(root_0, SHARE_SYM384_tree);
                    }
                    MODE_SYM385=(Token)match(input,MODE_SYM,FOLLOW_MODE_SYM_in_lock_type3907); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MODE_SYM385_tree = (CommonTree)adaptor.create(MODE_SYM385);
                    adaptor.addChild(root_0, MODE_SYM385_tree);
                    }

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 836, lock_type_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "lock_type"

    public static class where_clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where_clause"
    // MySQL.g:610:1: where_clause : WHERE expression ;
    public final MySQLParser.where_clause_return where_clause() throws RecognitionException {
        MySQLParser.where_clause_return retval = new MySQLParser.where_clause_return();
        retval.start = input.LT(1);
        int where_clause_StartIndex = input.index();
        CommonTree root_0 = null;

        Token WHERE386=null;
        MySQLParser.expression_return expression387 = null;


        CommonTree WHERE386_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 837) ) { return retval; }
            // MySQL.g:610:13: ( WHERE expression )
            // MySQL.g:611:2: WHERE expression
            {
            root_0 = (CommonTree)adaptor.nil();

            WHERE386=(Token)match(input,WHERE,FOLLOW_WHERE_in_where_clause3918); if (state.failed) return retval;
            pushFollow(FOLLOW_expression_in_where_clause3921);
            expression387=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression387.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 837, where_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "where_clause"

    public static class groupby_clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupby_clause"
    // MySQL.g:614:1: groupby_clause : GROUP_SYM BY_SYM groupby_item ( COMMA groupby_item )* ( WITH ROLLUP_SYM )? -> ^( TN_GROUPBY groupby_item ( groupby_item )* ) ;
    public final MySQLParser.groupby_clause_return groupby_clause() throws RecognitionException {
        MySQLParser.groupby_clause_return retval = new MySQLParser.groupby_clause_return();
        retval.start = input.LT(1);
        int groupby_clause_StartIndex = input.index();
        CommonTree root_0 = null;

        Token GROUP_SYM388=null;
        Token BY_SYM389=null;
        Token COMMA391=null;
        Token WITH393=null;
        Token ROLLUP_SYM394=null;
        MySQLParser.groupby_item_return groupby_item390 = null;

        MySQLParser.groupby_item_return groupby_item392 = null;


        CommonTree GROUP_SYM388_tree=null;
        CommonTree BY_SYM389_tree=null;
        CommonTree COMMA391_tree=null;
        CommonTree WITH393_tree=null;
        CommonTree ROLLUP_SYM394_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_BY_SYM=new RewriteRuleTokenStream(adaptor,"token BY_SYM");
        RewriteRuleTokenStream stream_ROLLUP_SYM=new RewriteRuleTokenStream(adaptor,"token ROLLUP_SYM");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleTokenStream stream_GROUP_SYM=new RewriteRuleTokenStream(adaptor,"token GROUP_SYM");
        RewriteRuleSubtreeStream stream_groupby_item=new RewriteRuleSubtreeStream(adaptor,"rule groupby_item");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 838) ) { return retval; }
            // MySQL.g:614:15: ( GROUP_SYM BY_SYM groupby_item ( COMMA groupby_item )* ( WITH ROLLUP_SYM )? -> ^( TN_GROUPBY groupby_item ( groupby_item )* ) )
            // MySQL.g:615:2: GROUP_SYM BY_SYM groupby_item ( COMMA groupby_item )* ( WITH ROLLUP_SYM )?
            {
            GROUP_SYM388=(Token)match(input,GROUP_SYM,FOLLOW_GROUP_SYM_in_groupby_clause3930); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROUP_SYM.add(GROUP_SYM388);

            BY_SYM389=(Token)match(input,BY_SYM,FOLLOW_BY_SYM_in_groupby_clause3932); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY_SYM.add(BY_SYM389);

            pushFollow(FOLLOW_groupby_item_in_groupby_clause3934);
            groupby_item390=groupby_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_groupby_item.add(groupby_item390.getTree());
            // MySQL.g:615:32: ( COMMA groupby_item )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==COMMA) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // MySQL.g:615:33: COMMA groupby_item
            	    {
            	    COMMA391=(Token)match(input,COMMA,FOLLOW_COMMA_in_groupby_clause3937); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA391);

            	    pushFollow(FOLLOW_groupby_item_in_groupby_clause3939);
            	    groupby_item392=groupby_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_groupby_item.add(groupby_item392.getTree());

            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);

            // MySQL.g:615:54: ( WITH ROLLUP_SYM )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==WITH) ) {
                int LA102_1 = input.LA(2);

                if ( (LA102_1==ROLLUP_SYM) ) {
                    alt102=1;
                }
            }
            switch (alt102) {
                case 1 :
                    // MySQL.g:615:55: WITH ROLLUP_SYM
                    {
                    WITH393=(Token)match(input,WITH,FOLLOW_WITH_in_groupby_clause3944); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WITH.add(WITH393);

                    ROLLUP_SYM394=(Token)match(input,ROLLUP_SYM,FOLLOW_ROLLUP_SYM_in_groupby_clause3946); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROLLUP_SYM.add(ROLLUP_SYM394);


                    }
                    break;

            }



            // AST REWRITE
            // elements: groupby_item, groupby_item
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 615:73: -> ^( TN_GROUPBY groupby_item ( groupby_item )* )
            {
                // MySQL.g:615:76: ^( TN_GROUPBY groupby_item ( groupby_item )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_GROUPBY, "TN_GROUPBY"), root_1);

                adaptor.addChild(root_1, stream_groupby_item.nextTree());
                // MySQL.g:615:102: ( groupby_item )*
                while ( stream_groupby_item.hasNext() ) {
                    adaptor.addChild(root_1, stream_groupby_item.nextTree());

                }
                stream_groupby_item.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 838, groupby_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "groupby_clause"

    public static class groupby_item_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupby_item"
    // MySQL.g:617:1: groupby_item : ( column_spec | INTEGER_NUM | bit_expr );
    public final MySQLParser.groupby_item_return groupby_item() throws RecognitionException {
        MySQLParser.groupby_item_return retval = new MySQLParser.groupby_item_return();
        retval.start = input.LT(1);
        int groupby_item_StartIndex = input.index();
        CommonTree root_0 = null;

        Token INTEGER_NUM396=null;
        MySQLParser.column_spec_return column_spec395 = null;

        MySQLParser.bit_expr_return bit_expr397 = null;


        CommonTree INTEGER_NUM396_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 839) ) { return retval; }
            // MySQL.g:617:13: ( column_spec | INTEGER_NUM | bit_expr )
            int alt103=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA103_1 = input.LA(2);

                if ( (synpred430_MySQL()) ) {
                    alt103=1;
                }
                else if ( (true) ) {
                    alt103=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 103, 1, input);

                    throw nvae;
                }
                }
                break;
            case INTEGER_NUM:
                {
                int LA103_2 = input.LA(2);

                if ( (synpred431_MySQL()) ) {
                    alt103=2;
                }
                else if ( (true) ) {
                    alt103=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 103, 2, input);

                    throw nvae;
                }
                }
                break;
            case ABS:
            case ACOS:
            case ADDDATE:
            case ADDTIME:
            case AES_DECRYPT:
            case AES_ENCRYPT:
            case ASCII_SYM:
            case ASIN:
            case ATAN:
            case ATAN2:
            case AVG:
            case BENCHMARK:
            case BIN:
            case BINARY:
            case BIT_AND:
            case BIT_LENGTH:
            case BIT_OR:
            case BIT_XOR:
            case CASE_SYM:
            case CAST_SYM:
            case CEIL:
            case CEILING:
            case CHAR:
            case CHAR_LENGTH:
            case CHARSET:
            case COERCIBILITY:
            case COLLATION:
            case CONCAT:
            case CONCAT_WS:
            case CONNECTION_ID:
            case CONV:
            case CONVERT_SYM:
            case CONVERT_TZ:
            case COS:
            case COT:
            case COUNT:
            case CRC32:
            case CURDATE:
            case CURRENT_USER:
            case CURTIME:
            case DATABASE:
            case DATE_ADD:
            case DATE_FORMAT:
            case DATE_SUB:
            case DATE_SYM:
            case DATEDIFF:
            case DAY_SYM:
            case DAYNAME:
            case DAYOFMONTH:
            case DAYOFWEEK:
            case DAYOFYEAR:
            case DECODE:
            case DEFAULT:
            case DEGREES:
            case DES_DECRYPT:
            case DES_ENCRYPT:
            case ELT:
            case ENCODE:
            case ENCRYPT:
            case EXISTS:
            case EXP:
            case EXPORT_SET:
            case EXTRACT:
            case FALSE_SYM:
            case FIELD:
            case FIND_IN_SET:
            case FLOOR:
            case FORMAT:
            case FOUND_ROWS:
            case FROM_BASE64:
            case FROM_DAYS:
            case FROM_UNIXTIME:
            case GET_FORMAT:
            case GET_LOCK:
            case GROUP_CONCAT:
            case HEX:
            case HOUR:
            case IF:
            case IFNULL:
            case INET_ATON:
            case INET_NTOA:
            case INSERT:
            case INSTR:
            case INTERVAL_SYM:
            case IS_FREE_LOCK:
            case IS_USED_LOCK:
            case LAST_DAY:
            case LAST_INSERT_ID:
            case LEFT:
            case LENGTH:
            case LN:
            case LOAD_FILE:
            case LOCATE:
            case LOG:
            case LOG10:
            case LOG2:
            case LOWER:
            case LPAD:
            case LTRIM:
            case MAKE_SET:
            case MAKEDATE:
            case MAKETIME:
            case MASTER_POS_WAIT:
            case MATCH:
            case MAX_SYM:
            case MD5:
            case MICROSECOND:
            case MID:
            case MIN_SYM:
            case MINUTE:
            case MOD:
            case MONTH:
            case MONTHNAME:
            case NAME_CONST:
            case NOW:
            case NULL_SYM:
            case OCT:
            case OLD_PASSWORD:
            case ORD:
            case PASSWORD:
            case PERIOD_ADD:
            case PERIOD_DIFF:
            case PI:
            case POW:
            case POWER:
            case QUARTER:
            case QUOTE:
            case RADIANS:
            case RAND:
            case RELEASE_LOCK:
            case REPEAT:
            case REPLACE:
            case REVERSE:
            case RIGHT:
            case ROUND:
            case ROW_SYM:
            case RPAD:
            case RTRIM:
            case SCHEMA:
            case SEC_TO_TIME:
            case SECOND:
            case SESSION_USER:
            case SIGN:
            case SIN:
            case SLEEP:
            case SOUNDEX:
            case SPACE:
            case SQRT:
            case STD:
            case STDDEV:
            case STDDEV_POP:
            case STDDEV_SAMP:
            case STR_TO_DATE:
            case STRCMP:
            case SUBSTRING:
            case SUBSTRING_INDEX:
            case SUBTIME:
            case SUM:
            case SYSDATE:
            case SYSTEM_USER:
            case TAN:
            case TIME_FORMAT:
            case TIME_SYM:
            case TIME_TO_SEC:
            case TIMEDIFF:
            case TIMESTAMP:
            case TIMESTAMPADD:
            case TIMESTAMPDIFF:
            case TO_BASE64:
            case TO_DAYS:
            case TO_SECONDS:
            case TRIM:
            case TRUE_SYM:
            case TRUNCATE:
            case UNHEX:
            case UNIX_TIMESTAMP:
            case UPPER:
            case USER:
            case UTC_DATE:
            case UTC_TIME:
            case UTC_TIMESTAMP:
            case UUID:
            case VALUES:
            case VAR_POP:
            case VAR_SAMP:
            case VARIANCE:
            case VERSION_SYM:
            case WEEK:
            case WEEKDAY:
            case WEEKOFYEAR:
            case WEIGHT_STRING:
            case LPAREN:
            case YEAR_FUNC:
            case YEARWEEK:
            case PLUS:
            case MINUS:
            case NEGATION:
            case HEX_DIGIT:
            case BIT_NUM:
            case REAL_NUMBER:
            case TEXT_STRING:
            case USER_VAR:
                {
                alt103=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // MySQL.g:617:15: column_spec
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_spec_in_groupby_item3967);
                    column_spec395=column_spec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec395.getTree());

                    }
                    break;
                case 2 :
                    // MySQL.g:617:29: INTEGER_NUM
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    INTEGER_NUM396=(Token)match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_groupby_item3971); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER_NUM396_tree = (CommonTree)adaptor.create(INTEGER_NUM396);
                    adaptor.addChild(root_0, INTEGER_NUM396_tree);
                    }

                    }
                    break;
                case 3 :
                    // MySQL.g:617:43: bit_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_bit_expr_in_groupby_item3975);
                    bit_expr397=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr397.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 839, groupby_item_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "groupby_item"

    public static class having_clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "having_clause"
    // MySQL.g:619:1: having_clause : HAVING expression ;
    public final MySQLParser.having_clause_return having_clause() throws RecognitionException {
        MySQLParser.having_clause_return retval = new MySQLParser.having_clause_return();
        retval.start = input.LT(1);
        int having_clause_StartIndex = input.index();
        CommonTree root_0 = null;

        Token HAVING398=null;
        MySQLParser.expression_return expression399 = null;


        CommonTree HAVING398_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 840) ) { return retval; }
            // MySQL.g:619:14: ( HAVING expression )
            // MySQL.g:620:2: HAVING expression
            {
            root_0 = (CommonTree)adaptor.nil();

            HAVING398=(Token)match(input,HAVING,FOLLOW_HAVING_in_having_clause3984); if (state.failed) return retval;
            pushFollow(FOLLOW_expression_in_having_clause3987);
            expression399=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression399.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 840, having_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "having_clause"

    public static class orderby_clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orderby_clause"
    // MySQL.g:623:1: orderby_clause : ORDER_SYM BY_SYM orderby_item ( COMMA orderby_item )* -> ^( TN_ORDERBY orderby_item ( orderby_item )* ) ;
    public final MySQLParser.orderby_clause_return orderby_clause() throws RecognitionException {
        MySQLParser.orderby_clause_return retval = new MySQLParser.orderby_clause_return();
        retval.start = input.LT(1);
        int orderby_clause_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ORDER_SYM400=null;
        Token BY_SYM401=null;
        Token COMMA403=null;
        MySQLParser.orderby_item_return orderby_item402 = null;

        MySQLParser.orderby_item_return orderby_item404 = null;


        CommonTree ORDER_SYM400_tree=null;
        CommonTree BY_SYM401_tree=null;
        CommonTree COMMA403_tree=null;
        RewriteRuleTokenStream stream_ORDER_SYM=new RewriteRuleTokenStream(adaptor,"token ORDER_SYM");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_BY_SYM=new RewriteRuleTokenStream(adaptor,"token BY_SYM");
        RewriteRuleSubtreeStream stream_orderby_item=new RewriteRuleSubtreeStream(adaptor,"rule orderby_item");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 841) ) { return retval; }
            // MySQL.g:623:15: ( ORDER_SYM BY_SYM orderby_item ( COMMA orderby_item )* -> ^( TN_ORDERBY orderby_item ( orderby_item )* ) )
            // MySQL.g:624:2: ORDER_SYM BY_SYM orderby_item ( COMMA orderby_item )*
            {
            ORDER_SYM400=(Token)match(input,ORDER_SYM,FOLLOW_ORDER_SYM_in_orderby_clause3996); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ORDER_SYM.add(ORDER_SYM400);

            BY_SYM401=(Token)match(input,BY_SYM,FOLLOW_BY_SYM_in_orderby_clause3998); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY_SYM.add(BY_SYM401);

            pushFollow(FOLLOW_orderby_item_in_orderby_clause4000);
            orderby_item402=orderby_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_orderby_item.add(orderby_item402.getTree());
            // MySQL.g:624:32: ( COMMA orderby_item )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==COMMA) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // MySQL.g:624:33: COMMA orderby_item
            	    {
            	    COMMA403=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderby_clause4003); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA403);

            	    pushFollow(FOLLOW_orderby_item_in_orderby_clause4005);
            	    orderby_item404=orderby_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_orderby_item.add(orderby_item404.getTree());

            	    }
            	    break;

            	default :
            	    break loop104;
                }
            } while (true);



            // AST REWRITE
            // elements: orderby_item, orderby_item
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 624:54: -> ^( TN_ORDERBY orderby_item ( orderby_item )* )
            {
                // MySQL.g:624:57: ^( TN_ORDERBY orderby_item ( orderby_item )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_ORDERBY, "TN_ORDERBY"), root_1);

                adaptor.addChild(root_1, stream_orderby_item.nextTree());
                // MySQL.g:624:83: ( orderby_item )*
                while ( stream_orderby_item.hasNext() ) {
                    adaptor.addChild(root_1, stream_orderby_item.nextTree());

                }
                stream_orderby_item.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 841, orderby_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "orderby_clause"

    public static class orderby_item_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orderby_item"
    // MySQL.g:626:1: orderby_item : groupby_item ( ASC | DESC )? ;
    public final MySQLParser.orderby_item_return orderby_item() throws RecognitionException {
        MySQLParser.orderby_item_return retval = new MySQLParser.orderby_item_return();
        retval.start = input.LT(1);
        int orderby_item_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set406=null;
        MySQLParser.groupby_item_return groupby_item405 = null;


        CommonTree set406_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 842) ) { return retval; }
            // MySQL.g:626:13: ( groupby_item ( ASC | DESC )? )
            // MySQL.g:626:15: groupby_item ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_groupby_item_in_orderby_item4025);
            groupby_item405=groupby_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, groupby_item405.getTree());
            // MySQL.g:626:28: ( ASC | DESC )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==ASC||LA105_0==DESC) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // MySQL.g:
                    {
                    set406=(Token)input.LT(1);
                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set406));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 842, orderby_item_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "orderby_item"

    public static class limit_clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "limit_clause"
    // MySQL.g:628:1: limit_clause : ( LIMIT ( ( offset COMMA )? row_count ) | ( row_count OFFSET_SYM offset ) );
    public final MySQLParser.limit_clause_return limit_clause() throws RecognitionException {
        MySQLParser.limit_clause_return retval = new MySQLParser.limit_clause_return();
        retval.start = input.LT(1);
        int limit_clause_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LIMIT407=null;
        Token COMMA409=null;
        Token OFFSET_SYM412=null;
        MySQLParser.offset_return offset408 = null;

        MySQLParser.row_count_return row_count410 = null;

        MySQLParser.row_count_return row_count411 = null;

        MySQLParser.offset_return offset413 = null;


        CommonTree LIMIT407_tree=null;
        CommonTree COMMA409_tree=null;
        CommonTree OFFSET_SYM412_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 843) ) { return retval; }
            // MySQL.g:628:13: ( LIMIT ( ( offset COMMA )? row_count ) | ( row_count OFFSET_SYM offset ) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==LIMIT) ) {
                alt107=1;
            }
            else if ( (LA107_0==INTEGER_NUM) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }
            switch (alt107) {
                case 1 :
                    // MySQL.g:629:2: LIMIT ( ( offset COMMA )? row_count )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LIMIT407=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause4043); if (state.failed) return retval;
                    // MySQL.g:629:9: ( ( offset COMMA )? row_count )
                    // MySQL.g:629:10: ( offset COMMA )? row_count
                    {
                    // MySQL.g:629:10: ( offset COMMA )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==INTEGER_NUM) ) {
                        int LA106_1 = input.LA(2);

                        if ( (LA106_1==COMMA) ) {
                            alt106=1;
                        }
                    }
                    switch (alt106) {
                        case 1 :
                            // MySQL.g:629:11: offset COMMA
                            {
                            pushFollow(FOLLOW_offset_in_limit_clause4048);
                            offset408=offset();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, offset408.getTree());
                            COMMA409=(Token)match(input,COMMA,FOLLOW_COMMA_in_limit_clause4050); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            COMMA409_tree = (CommonTree)adaptor.create(COMMA409);
                            adaptor.addChild(root_0, COMMA409_tree);
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_row_count_in_limit_clause4054);
                    row_count410=row_count();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, row_count410.getTree());

                    }


                    }
                    break;
                case 2 :
                    // MySQL.g:629:39: ( row_count OFFSET_SYM offset )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // MySQL.g:629:39: ( row_count OFFSET_SYM offset )
                    // MySQL.g:629:40: row_count OFFSET_SYM offset
                    {
                    pushFollow(FOLLOW_row_count_in_limit_clause4060);
                    row_count411=row_count();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, row_count411.getTree());
                    OFFSET_SYM412=(Token)match(input,OFFSET_SYM,FOLLOW_OFFSET_SYM_in_limit_clause4062); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OFFSET_SYM412_tree = (CommonTree)adaptor.create(OFFSET_SYM412);
                    adaptor.addChild(root_0, OFFSET_SYM412_tree);
                    }
                    pushFollow(FOLLOW_offset_in_limit_clause4064);
                    offset413=offset();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, offset413.getTree());

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 843, limit_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "limit_clause"

    public static class offset_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "offset"
    // MySQL.g:631:1: offset : INTEGER_NUM ;
    public final MySQLParser.offset_return offset() throws RecognitionException {
        MySQLParser.offset_return retval = new MySQLParser.offset_return();
        retval.start = input.LT(1);
        int offset_StartIndex = input.index();
        CommonTree root_0 = null;

        Token INTEGER_NUM414=null;

        CommonTree INTEGER_NUM414_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 844) ) { return retval; }
            // MySQL.g:631:7: ( INTEGER_NUM )
            // MySQL.g:631:10: INTEGER_NUM
            {
            root_0 = (CommonTree)adaptor.nil();

            INTEGER_NUM414=(Token)match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_offset4073); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER_NUM414_tree = (CommonTree)adaptor.create(INTEGER_NUM414);
            adaptor.addChild(root_0, INTEGER_NUM414_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 844, offset_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "offset"

    public static class row_count_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "row_count"
    // MySQL.g:632:1: row_count : INTEGER_NUM ;
    public final MySQLParser.row_count_return row_count() throws RecognitionException {
        MySQLParser.row_count_return retval = new MySQLParser.row_count_return();
        retval.start = input.LT(1);
        int row_count_StartIndex = input.index();
        CommonTree root_0 = null;

        Token INTEGER_NUM415=null;

        CommonTree INTEGER_NUM415_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 845) ) { return retval; }
            // MySQL.g:632:10: ( INTEGER_NUM )
            // MySQL.g:632:12: INTEGER_NUM
            {
            root_0 = (CommonTree)adaptor.nil();

            INTEGER_NUM415=(Token)match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_row_count4080); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER_NUM415_tree = (CommonTree)adaptor.create(INTEGER_NUM415);
            adaptor.addChild(root_0, INTEGER_NUM415_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 845, row_count_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "row_count"

    public static class select_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select_list"
    // MySQL.g:634:1: select_list : displayed_column ( COMMA displayed_column )* -> ( ^( TN_COL displayed_column ) )+ ;
    public final MySQLParser.select_list_return select_list() throws RecognitionException {
        MySQLParser.select_list_return retval = new MySQLParser.select_list_return();
        retval.start = input.LT(1);
        int select_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token COMMA417=null;
        MySQLParser.displayed_column_return displayed_column416 = null;

        MySQLParser.displayed_column_return displayed_column418 = null;


        CommonTree COMMA417_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_displayed_column=new RewriteRuleSubtreeStream(adaptor,"rule displayed_column");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 846) ) { return retval; }
            // MySQL.g:634:12: ( displayed_column ( COMMA displayed_column )* -> ( ^( TN_COL displayed_column ) )+ )
            // MySQL.g:635:2: displayed_column ( COMMA displayed_column )*
            {
            pushFollow(FOLLOW_displayed_column_in_select_list4089);
            displayed_column416=displayed_column();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_displayed_column.add(displayed_column416.getTree());
            // MySQL.g:635:19: ( COMMA displayed_column )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==COMMA) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // MySQL.g:635:20: COMMA displayed_column
            	    {
            	    COMMA417=(Token)match(input,COMMA,FOLLOW_COMMA_in_select_list4092); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA417);

            	    pushFollow(FOLLOW_displayed_column_in_select_list4094);
            	    displayed_column418=displayed_column();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_displayed_column.add(displayed_column418.getTree());

            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);



            // AST REWRITE
            // elements: displayed_column
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 635:45: -> ( ^( TN_COL displayed_column ) )+
            {
                if ( !(stream_displayed_column.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_displayed_column.hasNext() ) {
                    // MySQL.g:635:48: ^( TN_COL displayed_column )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_COL, "TN_COL"), root_1);

                    adaptor.addChild(root_1, stream_displayed_column.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_displayed_column.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 846, select_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "select_list"

    public static class column_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "column_list"
    // MySQL.g:638:1: column_list : LPAREN column_spec ( COMMA column_spec )* RPAREN ;
    public final MySQLParser.column_list_return column_list() throws RecognitionException {
        MySQLParser.column_list_return retval = new MySQLParser.column_list_return();
        retval.start = input.LT(1);
        int column_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LPAREN419=null;
        Token COMMA421=null;
        Token RPAREN423=null;
        MySQLParser.column_spec_return column_spec420 = null;

        MySQLParser.column_spec_return column_spec422 = null;


        CommonTree LPAREN419_tree=null;
        CommonTree COMMA421_tree=null;
        CommonTree RPAREN423_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 847) ) { return retval; }
            // MySQL.g:638:12: ( LPAREN column_spec ( COMMA column_spec )* RPAREN )
            // MySQL.g:639:2: LPAREN column_spec ( COMMA column_spec )* RPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAREN419=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_column_list4114); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN419_tree = (CommonTree)adaptor.create(LPAREN419);
            adaptor.addChild(root_0, LPAREN419_tree);
            }
            pushFollow(FOLLOW_column_spec_in_column_list4116);
            column_spec420=column_spec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec420.getTree());
            // MySQL.g:639:21: ( COMMA column_spec )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==COMMA) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // MySQL.g:639:22: COMMA column_spec
            	    {
            	    COMMA421=(Token)match(input,COMMA,FOLLOW_COMMA_in_column_list4119); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA421_tree = (CommonTree)adaptor.create(COMMA421);
            	    adaptor.addChild(root_0, COMMA421_tree);
            	    }
            	    pushFollow(FOLLOW_column_spec_in_column_list4121);
            	    column_spec422=column_spec();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec422.getTree());

            	    }
            	    break;

            	default :
            	    break loop109;
                }
            } while (true);

            RPAREN423=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_column_list4125); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN423_tree = (CommonTree)adaptor.create(RPAREN423);
            adaptor.addChild(root_0, RPAREN423_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 847, column_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "column_list"

    public static class subquery_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subquery"
    // MySQL.g:642:1: subquery : LPAREN select_statement RPAREN -> ^( TN_SUBQUERY select_statement ) ;
    public final MySQLParser.subquery_return subquery() throws RecognitionException {
        MySQLParser.subquery_return retval = new MySQLParser.subquery_return();
        retval.start = input.LT(1);
        int subquery_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LPAREN424=null;
        Token RPAREN426=null;
        MySQLParser.select_statement_return select_statement425 = null;


        CommonTree LPAREN424_tree=null;
        CommonTree RPAREN426_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_select_statement=new RewriteRuleSubtreeStream(adaptor,"rule select_statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 848) ) { return retval; }
            // MySQL.g:642:9: ( LPAREN select_statement RPAREN -> ^( TN_SUBQUERY select_statement ) )
            // MySQL.g:643:2: LPAREN select_statement RPAREN
            {
            LPAREN424=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_subquery4134); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN424);

            pushFollow(FOLLOW_select_statement_in_subquery4136);
            select_statement425=select_statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select_statement.add(select_statement425.getTree());
            RPAREN426=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_subquery4138); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN426);



            // AST REWRITE
            // elements: select_statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 643:33: -> ^( TN_SUBQUERY select_statement )
            {
                // MySQL.g:643:36: ^( TN_SUBQUERY select_statement )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_SUBQUERY, "TN_SUBQUERY"), root_1);

                adaptor.addChild(root_1, stream_select_statement.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 848, subquery_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "subquery"

    public static class table_spec_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table_spec"
    // MySQL.g:646:1: table_spec : ( schema_name DOT )? table_name -> ^( TN_TABLE_SPEC ( schema_name DOT )? table_name ) ;
    public final MySQLParser.table_spec_return table_spec() throws RecognitionException {
        MySQLParser.table_spec_return retval = new MySQLParser.table_spec_return();
        retval.start = input.LT(1);
        int table_spec_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DOT428=null;
        MySQLParser.schema_name_return schema_name427 = null;

        MySQLParser.table_name_return table_name429 = null;


        CommonTree DOT428_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_schema_name=new RewriteRuleSubtreeStream(adaptor,"rule schema_name");
        RewriteRuleSubtreeStream stream_table_name=new RewriteRuleSubtreeStream(adaptor,"rule table_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 849) ) { return retval; }
            // MySQL.g:646:11: ( ( schema_name DOT )? table_name -> ^( TN_TABLE_SPEC ( schema_name DOT )? table_name ) )
            // MySQL.g:647:2: ( schema_name DOT )? table_name
            {
            // MySQL.g:647:2: ( schema_name DOT )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==ID) ) {
                int LA110_1 = input.LA(2);

                if ( (LA110_1==DOT) ) {
                    alt110=1;
                }
            }
            switch (alt110) {
                case 1 :
                    // MySQL.g:647:4: schema_name DOT
                    {
                    pushFollow(FOLLOW_schema_name_in_table_spec4157);
                    schema_name427=schema_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_schema_name.add(schema_name427.getTree());
                    DOT428=(Token)match(input,DOT,FOLLOW_DOT_in_table_spec4159); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT428);


                    }
                    break;

            }

            pushFollow(FOLLOW_table_name_in_table_spec4164);
            table_name429=table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_table_name.add(table_name429.getTree());


            // AST REWRITE
            // elements: table_name, DOT, schema_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 647:34: -> ^( TN_TABLE_SPEC ( schema_name DOT )? table_name )
            {
                // MySQL.g:647:37: ^( TN_TABLE_SPEC ( schema_name DOT )? table_name )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_TABLE_SPEC, "TN_TABLE_SPEC"), root_1);

                // MySQL.g:647:53: ( schema_name DOT )?
                if ( stream_DOT.hasNext()||stream_schema_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_schema_name.nextTree());
                    adaptor.addChild(root_1, stream_DOT.nextNode());

                }
                stream_DOT.reset();
                stream_schema_name.reset();
                adaptor.addChild(root_1, stream_table_name.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 849, table_spec_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "table_spec"

    public static class displayed_column_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "displayed_column"
    // MySQL.g:650:1: displayed_column : ( table_name DOT column_name ( alias )? -> ^( TN_COL_EXP table_name DOT column_name ( alias )? ) | column_name ( alias )? -> ^( TN_COL_EXP column_name ( alias )? ) | column_spec ( column_op column_spec )+ ( alias )? -> ^( TN_COL_EXP column_spec ( column_op column_spec )+ ( alias )? ) | ASTERISK -> ^( TN_COL_ALLC ASTERISK ) | table_name ALL_FIELDS -> ^( TN_COL_ALLTC table_name ALL_FIELDS ) | bit_expr ( alias )? -> ^( TN_COL_BITEXP bit_expr ( alias )? ) | column_spec column_op simple_expr ( alias )? );
    public final MySQLParser.displayed_column_return displayed_column() throws RecognitionException {
        MySQLParser.displayed_column_return retval = new MySQLParser.displayed_column_return();
        retval.start = input.LT(1);
        int displayed_column_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DOT431=null;
        Token ASTERISK440=null;
        Token ALL_FIELDS442=null;
        MySQLParser.table_name_return table_name430 = null;

        MySQLParser.column_name_return column_name432 = null;

        MySQLParser.alias_return alias433 = null;

        MySQLParser.column_name_return column_name434 = null;

        MySQLParser.alias_return alias435 = null;

        MySQLParser.column_spec_return column_spec436 = null;

        MySQLParser.column_op_return column_op437 = null;

        MySQLParser.column_spec_return column_spec438 = null;

        MySQLParser.alias_return alias439 = null;

        MySQLParser.table_name_return table_name441 = null;

        MySQLParser.bit_expr_return bit_expr443 = null;

        MySQLParser.alias_return alias444 = null;

        MySQLParser.column_spec_return column_spec445 = null;

        MySQLParser.column_op_return column_op446 = null;

        MySQLParser.simple_expr_return simple_expr447 = null;

        MySQLParser.alias_return alias448 = null;


        CommonTree DOT431_tree=null;
        CommonTree ASTERISK440_tree=null;
        CommonTree ALL_FIELDS442_tree=null;
        RewriteRuleTokenStream stream_ALL_FIELDS=new RewriteRuleTokenStream(adaptor,"token ALL_FIELDS");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_ASTERISK=new RewriteRuleTokenStream(adaptor,"token ASTERISK");
        RewriteRuleSubtreeStream stream_bit_expr=new RewriteRuleSubtreeStream(adaptor,"rule bit_expr");
        RewriteRuleSubtreeStream stream_alias=new RewriteRuleSubtreeStream(adaptor,"rule alias");
        RewriteRuleSubtreeStream stream_column_spec=new RewriteRuleSubtreeStream(adaptor,"rule column_spec");
        RewriteRuleSubtreeStream stream_table_name=new RewriteRuleSubtreeStream(adaptor,"rule table_name");
        RewriteRuleSubtreeStream stream_column_op=new RewriteRuleSubtreeStream(adaptor,"rule column_op");
        RewriteRuleSubtreeStream stream_column_name=new RewriteRuleSubtreeStream(adaptor,"rule column_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 850) ) { return retval; }
            // MySQL.g:650:17: ( table_name DOT column_name ( alias )? -> ^( TN_COL_EXP table_name DOT column_name ( alias )? ) | column_name ( alias )? -> ^( TN_COL_EXP column_name ( alias )? ) | column_spec ( column_op column_spec )+ ( alias )? -> ^( TN_COL_EXP column_spec ( column_op column_spec )+ ( alias )? ) | ASTERISK -> ^( TN_COL_ALLC ASTERISK ) | table_name ALL_FIELDS -> ^( TN_COL_ALLTC table_name ALL_FIELDS ) | bit_expr ( alias )? -> ^( TN_COL_BITEXP bit_expr ( alias )? ) | column_spec column_op simple_expr ( alias )? )
            int alt117=7;
            alt117 = dfa117.predict(input);
            switch (alt117) {
                case 1 :
                    // MySQL.g:651:2: table_name DOT column_name ( alias )?
                    {
                    pushFollow(FOLLOW_table_name_in_displayed_column4188);
                    table_name430=table_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_table_name.add(table_name430.getTree());
                    DOT431=(Token)match(input,DOT,FOLLOW_DOT_in_displayed_column4190); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT431);

                    pushFollow(FOLLOW_column_name_in_displayed_column4192);
                    column_name432=column_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_column_name.add(column_name432.getTree());
                    // MySQL.g:651:29: ( alias )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==AS_SYM||LA111_0==ID) ) {
                        alt111=1;
                    }
                    switch (alt111) {
                        case 1 :
                            // MySQL.g:651:30: alias
                            {
                            pushFollow(FOLLOW_alias_in_displayed_column4195);
                            alias433=alias();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_alias.add(alias433.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: column_name, table_name, alias, DOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 651:38: -> ^( TN_COL_EXP table_name DOT column_name ( alias )? )
                    {
                        // MySQL.g:651:41: ^( TN_COL_EXP table_name DOT column_name ( alias )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_COL_EXP, "TN_COL_EXP"), root_1);

                        adaptor.addChild(root_1, stream_table_name.nextTree());
                        adaptor.addChild(root_1, stream_DOT.nextNode());
                        adaptor.addChild(root_1, stream_column_name.nextTree());
                        // MySQL.g:651:81: ( alias )?
                        if ( stream_alias.hasNext() ) {
                            adaptor.addChild(root_1, stream_alias.nextTree());

                        }
                        stream_alias.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MySQL.g:652:4: column_name ( alias )?
                    {
                    pushFollow(FOLLOW_column_name_in_displayed_column4219);
                    column_name434=column_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_column_name.add(column_name434.getTree());
                    // MySQL.g:652:16: ( alias )?
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( (LA112_0==AS_SYM||LA112_0==ID) ) {
                        alt112=1;
                    }
                    switch (alt112) {
                        case 1 :
                            // MySQL.g:652:17: alias
                            {
                            pushFollow(FOLLOW_alias_in_displayed_column4222);
                            alias435=alias();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_alias.add(alias435.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: column_name, alias
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 652:25: -> ^( TN_COL_EXP column_name ( alias )? )
                    {
                        // MySQL.g:652:28: ^( TN_COL_EXP column_name ( alias )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_COL_EXP, "TN_COL_EXP"), root_1);

                        adaptor.addChild(root_1, stream_column_name.nextTree());
                        // MySQL.g:652:53: ( alias )?
                        if ( stream_alias.hasNext() ) {
                            adaptor.addChild(root_1, stream_alias.nextTree());

                        }
                        stream_alias.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MySQL.g:653:4: column_spec ( column_op column_spec )+ ( alias )?
                    {
                    pushFollow(FOLLOW_column_spec_in_displayed_column4242);
                    column_spec436=column_spec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_column_spec.add(column_spec436.getTree());
                    // MySQL.g:653:16: ( column_op column_spec )+
                    int cnt113=0;
                    loop113:
                    do {
                        int alt113=2;
                        int LA113_0 = input.LA(1);

                        if ( (LA113_0==DIVIDE||LA113_0==ASTERISK||(LA113_0>=PLUS && LA113_0<=MINUS)) ) {
                            alt113=1;
                        }


                        switch (alt113) {
                    	case 1 :
                    	    // MySQL.g:653:17: column_op column_spec
                    	    {
                    	    pushFollow(FOLLOW_column_op_in_displayed_column4245);
                    	    column_op437=column_op();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_column_op.add(column_op437.getTree());
                    	    pushFollow(FOLLOW_column_spec_in_displayed_column4247);
                    	    column_spec438=column_spec();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_column_spec.add(column_spec438.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt113 >= 1 ) break loop113;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(113, input);
                                throw eee;
                        }
                        cnt113++;
                    } while (true);

                    // MySQL.g:653:41: ( alias )?
                    int alt114=2;
                    int LA114_0 = input.LA(1);

                    if ( (LA114_0==AS_SYM||LA114_0==ID) ) {
                        alt114=1;
                    }
                    switch (alt114) {
                        case 1 :
                            // MySQL.g:653:42: alias
                            {
                            pushFollow(FOLLOW_alias_in_displayed_column4252);
                            alias439=alias();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_alias.add(alias439.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: column_spec, alias, column_op, column_spec
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 653:50: -> ^( TN_COL_EXP column_spec ( column_op column_spec )+ ( alias )? )
                    {
                        // MySQL.g:653:53: ^( TN_COL_EXP column_spec ( column_op column_spec )+ ( alias )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_COL_EXP, "TN_COL_EXP"), root_1);

                        adaptor.addChild(root_1, stream_column_spec.nextTree());
                        if ( !(stream_column_spec.hasNext()||stream_column_op.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_column_spec.hasNext()||stream_column_op.hasNext() ) {
                            adaptor.addChild(root_1, stream_column_op.nextTree());
                            adaptor.addChild(root_1, stream_column_spec.nextTree());

                        }
                        stream_column_spec.reset();
                        stream_column_op.reset();
                        // MySQL.g:653:103: ( alias )?
                        if ( stream_alias.hasNext() ) {
                            adaptor.addChild(root_1, stream_alias.nextTree());

                        }
                        stream_alias.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // MySQL.g:654:4: ASTERISK
                    {
                    ASTERISK440=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_displayed_column4279); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASTERISK.add(ASTERISK440);



                    // AST REWRITE
                    // elements: ASTERISK
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 654:13: -> ^( TN_COL_ALLC ASTERISK )
                    {
                        // MySQL.g:654:16: ^( TN_COL_ALLC ASTERISK )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_COL_ALLC, "TN_COL_ALLC"), root_1);

                        adaptor.addChild(root_1, stream_ASTERISK.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // MySQL.g:655:4: table_name ALL_FIELDS
                    {
                    pushFollow(FOLLOW_table_name_in_displayed_column4292);
                    table_name441=table_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_table_name.add(table_name441.getTree());
                    ALL_FIELDS442=(Token)match(input,ALL_FIELDS,FOLLOW_ALL_FIELDS_in_displayed_column4294); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ALL_FIELDS.add(ALL_FIELDS442);



                    // AST REWRITE
                    // elements: ALL_FIELDS, table_name
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 655:26: -> ^( TN_COL_ALLTC table_name ALL_FIELDS )
                    {
                        // MySQL.g:655:29: ^( TN_COL_ALLTC table_name ALL_FIELDS )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_COL_ALLTC, "TN_COL_ALLTC"), root_1);

                        adaptor.addChild(root_1, stream_table_name.nextTree());
                        adaptor.addChild(root_1, stream_ALL_FIELDS.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // MySQL.g:656:4: bit_expr ( alias )?
                    {
                    pushFollow(FOLLOW_bit_expr_in_displayed_column4309);
                    bit_expr443=bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_bit_expr.add(bit_expr443.getTree());
                    // MySQL.g:656:13: ( alias )?
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==AS_SYM||LA115_0==ID) ) {
                        alt115=1;
                    }
                    switch (alt115) {
                        case 1 :
                            // MySQL.g:656:14: alias
                            {
                            pushFollow(FOLLOW_alias_in_displayed_column4312);
                            alias444=alias();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_alias.add(alias444.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: alias, bit_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 656:22: -> ^( TN_COL_BITEXP bit_expr ( alias )? )
                    {
                        // MySQL.g:656:25: ^( TN_COL_BITEXP bit_expr ( alias )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_COL_BITEXP, "TN_COL_BITEXP"), root_1);

                        adaptor.addChild(root_1, stream_bit_expr.nextTree());
                        // MySQL.g:656:50: ( alias )?
                        if ( stream_alias.hasNext() ) {
                            adaptor.addChild(root_1, stream_alias.nextTree());

                        }
                        stream_alias.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // MySQL.g:657:4: column_spec column_op simple_expr ( alias )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_spec_in_displayed_column4332);
                    column_spec445=column_spec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec445.getTree());
                    pushFollow(FOLLOW_column_op_in_displayed_column4334);
                    column_op446=column_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_op446.getTree());
                    pushFollow(FOLLOW_simple_expr_in_displayed_column4336);
                    simple_expr447=simple_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_expr447.getTree());
                    // MySQL.g:657:38: ( alias )?
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==AS_SYM||LA116_0==ID) ) {
                        alt116=1;
                    }
                    switch (alt116) {
                        case 1 :
                            // MySQL.g:657:39: alias
                            {
                            pushFollow(FOLLOW_alias_in_displayed_column4339);
                            alias448=alias();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, alias448.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 850, displayed_column_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "displayed_column"

    public static class column_op_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "column_op"
    // MySQL.g:660:1: column_op : ( PLUS | MINUS | ASTERISK | DIVIDE );
    public final MySQLParser.column_op_return column_op() throws RecognitionException {
        MySQLParser.column_op_return retval = new MySQLParser.column_op_return();
        retval.start = input.LT(1);
        int column_op_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set449=null;

        CommonTree set449_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 851) ) { return retval; }
            // MySQL.g:660:10: ( PLUS | MINUS | ASTERISK | DIVIDE )
            // MySQL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set449=(Token)input.LT(1);
            if ( input.LA(1)==DIVIDE||input.LA(1)==ASTERISK||(input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set449));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 851, column_op_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "column_op"

    public static class delete_statements_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delete_statements"
    // MySQL.g:665:1: delete_statements : DELETE_SYM delete_expression -> ^( TN_DELETE delete_expression ) ;
    public final MySQLParser.delete_statements_return delete_statements() throws RecognitionException {
        MySQLParser.delete_statements_return retval = new MySQLParser.delete_statements_return();
        retval.start = input.LT(1);
        int delete_statements_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DELETE_SYM450=null;
        MySQLParser.delete_expression_return delete_expression451 = null;


        CommonTree DELETE_SYM450_tree=null;
        RewriteRuleTokenStream stream_DELETE_SYM=new RewriteRuleTokenStream(adaptor,"token DELETE_SYM");
        RewriteRuleSubtreeStream stream_delete_expression=new RewriteRuleSubtreeStream(adaptor,"rule delete_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 852) ) { return retval; }
            // MySQL.g:665:18: ( DELETE_SYM delete_expression -> ^( TN_DELETE delete_expression ) )
            // MySQL.g:666:2: DELETE_SYM delete_expression
            {
            DELETE_SYM450=(Token)match(input,DELETE_SYM,FOLLOW_DELETE_SYM_in_delete_statements4369); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DELETE_SYM.add(DELETE_SYM450);

            pushFollow(FOLLOW_delete_expression_in_delete_statements4371);
            delete_expression451=delete_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_delete_expression.add(delete_expression451.getTree());


            // AST REWRITE
            // elements: delete_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 666:31: -> ^( TN_DELETE delete_expression )
            {
                // MySQL.g:666:34: ^( TN_DELETE delete_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_DELETE, "TN_DELETE"), root_1);

                adaptor.addChild(root_1, stream_delete_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 852, delete_statements_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "delete_statements"

    public static class delete_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delete_expression"
    // MySQL.g:668:1: delete_expression : ( LOW_PRIORITY )? ( QUICK )? ( IGNORE_SYM )? ( delete_single_table_statement -> ^( delete_single_table_statement ) | delete_multiple_table_statement1 -> ^( delete_multiple_table_statement1 ) | delete_multiple_table_statement2 -> ^( delete_multiple_table_statement2 ) ) ;
    public final MySQLParser.delete_expression_return delete_expression() throws RecognitionException {
        MySQLParser.delete_expression_return retval = new MySQLParser.delete_expression_return();
        retval.start = input.LT(1);
        int delete_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LOW_PRIORITY452=null;
        Token QUICK453=null;
        Token IGNORE_SYM454=null;
        MySQLParser.delete_single_table_statement_return delete_single_table_statement455 = null;

        MySQLParser.delete_multiple_table_statement1_return delete_multiple_table_statement1456 = null;

        MySQLParser.delete_multiple_table_statement2_return delete_multiple_table_statement2457 = null;


        CommonTree LOW_PRIORITY452_tree=null;
        CommonTree QUICK453_tree=null;
        CommonTree IGNORE_SYM454_tree=null;
        RewriteRuleTokenStream stream_LOW_PRIORITY=new RewriteRuleTokenStream(adaptor,"token LOW_PRIORITY");
        RewriteRuleTokenStream stream_QUICK=new RewriteRuleTokenStream(adaptor,"token QUICK");
        RewriteRuleTokenStream stream_IGNORE_SYM=new RewriteRuleTokenStream(adaptor,"token IGNORE_SYM");
        RewriteRuleSubtreeStream stream_delete_multiple_table_statement1=new RewriteRuleSubtreeStream(adaptor,"rule delete_multiple_table_statement1");
        RewriteRuleSubtreeStream stream_delete_single_table_statement=new RewriteRuleSubtreeStream(adaptor,"rule delete_single_table_statement");
        RewriteRuleSubtreeStream stream_delete_multiple_table_statement2=new RewriteRuleSubtreeStream(adaptor,"rule delete_multiple_table_statement2");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 853) ) { return retval; }
            // MySQL.g:668:18: ( ( LOW_PRIORITY )? ( QUICK )? ( IGNORE_SYM )? ( delete_single_table_statement -> ^( delete_single_table_statement ) | delete_multiple_table_statement1 -> ^( delete_multiple_table_statement1 ) | delete_multiple_table_statement2 -> ^( delete_multiple_table_statement2 ) ) )
            // MySQL.g:669:2: ( LOW_PRIORITY )? ( QUICK )? ( IGNORE_SYM )? ( delete_single_table_statement -> ^( delete_single_table_statement ) | delete_multiple_table_statement1 -> ^( delete_multiple_table_statement1 ) | delete_multiple_table_statement2 -> ^( delete_multiple_table_statement2 ) )
            {
            // MySQL.g:669:2: ( LOW_PRIORITY )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==LOW_PRIORITY) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // MySQL.g:669:3: LOW_PRIORITY
                    {
                    LOW_PRIORITY452=(Token)match(input,LOW_PRIORITY,FOLLOW_LOW_PRIORITY_in_delete_expression4388); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LOW_PRIORITY.add(LOW_PRIORITY452);


                    }
                    break;

            }

            // MySQL.g:669:18: ( QUICK )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==QUICK) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // MySQL.g:669:19: QUICK
                    {
                    QUICK453=(Token)match(input,QUICK,FOLLOW_QUICK_in_delete_expression4393); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUICK.add(QUICK453);


                    }
                    break;

            }

            // MySQL.g:669:27: ( IGNORE_SYM )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==IGNORE_SYM) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // MySQL.g:669:28: IGNORE_SYM
                    {
                    IGNORE_SYM454=(Token)match(input,IGNORE_SYM,FOLLOW_IGNORE_SYM_in_delete_expression4398); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IGNORE_SYM.add(IGNORE_SYM454);


                    }
                    break;

            }

            // MySQL.g:670:2: ( delete_single_table_statement -> ^( delete_single_table_statement ) | delete_multiple_table_statement1 -> ^( delete_multiple_table_statement1 ) | delete_multiple_table_statement2 -> ^( delete_multiple_table_statement2 ) )
            int alt121=3;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==FROM) ) {
                int LA121_1 = input.LA(2);

                if ( (LA121_1==ID) ) {
                    switch ( input.LA(3) ) {
                    case DOT:
                        {
                        int LA121_4 = input.LA(4);

                        if ( (LA121_4==ID) ) {
                            int LA121_7 = input.LA(5);

                            if ( (LA121_7==USING_SYM||LA121_7==ALL_FIELDS||LA121_7==COMMA) ) {
                                alt121=3;
                            }
                            else if ( (LA121_7==EOF||LA121_7==LIMIT||LA121_7==ORDER_SYM||LA121_7==PARTITION_SYM||LA121_7==WHERE||LA121_7==SEMI||LA121_7==INTEGER_NUM) ) {
                                alt121=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 121, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 121, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case USING_SYM:
                    case ALL_FIELDS:
                    case COMMA:
                        {
                        alt121=3;
                        }
                        break;
                    case EOF:
                    case LIMIT:
                    case ORDER_SYM:
                    case PARTITION_SYM:
                    case WHERE:
                    case SEMI:
                    case INTEGER_NUM:
                        {
                        alt121=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 121, 3, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 121, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA121_0==ID) ) {
                alt121=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }
            switch (alt121) {
                case 1 :
                    // MySQL.g:670:4: delete_single_table_statement
                    {
                    pushFollow(FOLLOW_delete_single_table_statement_in_delete_expression4405);
                    delete_single_table_statement455=delete_single_table_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delete_single_table_statement.add(delete_single_table_statement455.getTree());


                    // AST REWRITE
                    // elements: delete_single_table_statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 670:34: -> ^( delete_single_table_statement )
                    {
                        // MySQL.g:670:37: ^( delete_single_table_statement )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_delete_single_table_statement.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // MySQL.g:670:72: delete_multiple_table_statement1
                    {
                    pushFollow(FOLLOW_delete_multiple_table_statement1_in_delete_expression4415);
                    delete_multiple_table_statement1456=delete_multiple_table_statement1();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delete_multiple_table_statement1.add(delete_multiple_table_statement1456.getTree());


                    // AST REWRITE
                    // elements: delete_multiple_table_statement1
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 670:105: -> ^( delete_multiple_table_statement1 )
                    {
                        // MySQL.g:670:108: ^( delete_multiple_table_statement1 )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_delete_multiple_table_statement1.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // MySQL.g:670:146: delete_multiple_table_statement2
                    {
                    pushFollow(FOLLOW_delete_multiple_table_statement2_in_delete_expression4425);
                    delete_multiple_table_statement2457=delete_multiple_table_statement2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delete_multiple_table_statement2.add(delete_multiple_table_statement2457.getTree());


                    // AST REWRITE
                    // elements: delete_multiple_table_statement2
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 670:179: -> ^( delete_multiple_table_statement2 )
                    {
                        // MySQL.g:670:182: ^( delete_multiple_table_statement2 )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_delete_multiple_table_statement2.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 853, delete_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "delete_expression"

    public static class delete_single_table_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delete_single_table_statement"
    // MySQL.g:673:1: delete_single_table_statement : FROM table_spec ( partition_clause )? ( where_clause )? ( orderby_clause )? ( limit_clause )? -> ^( table_spec ) ;
    public final MySQLParser.delete_single_table_statement_return delete_single_table_statement() throws RecognitionException {
        MySQLParser.delete_single_table_statement_return retval = new MySQLParser.delete_single_table_statement_return();
        retval.start = input.LT(1);
        int delete_single_table_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token FROM458=null;
        MySQLParser.table_spec_return table_spec459 = null;

        MySQLParser.partition_clause_return partition_clause460 = null;

        MySQLParser.where_clause_return where_clause461 = null;

        MySQLParser.orderby_clause_return orderby_clause462 = null;

        MySQLParser.limit_clause_return limit_clause463 = null;


        CommonTree FROM458_tree=null;
        RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
        RewriteRuleSubtreeStream stream_limit_clause=new RewriteRuleSubtreeStream(adaptor,"rule limit_clause");
        RewriteRuleSubtreeStream stream_where_clause=new RewriteRuleSubtreeStream(adaptor,"rule where_clause");
        RewriteRuleSubtreeStream stream_partition_clause=new RewriteRuleSubtreeStream(adaptor,"rule partition_clause");
        RewriteRuleSubtreeStream stream_table_spec=new RewriteRuleSubtreeStream(adaptor,"rule table_spec");
        RewriteRuleSubtreeStream stream_orderby_clause=new RewriteRuleSubtreeStream(adaptor,"rule orderby_clause");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 854) ) { return retval; }
            // MySQL.g:673:30: ( FROM table_spec ( partition_clause )? ( where_clause )? ( orderby_clause )? ( limit_clause )? -> ^( table_spec ) )
            // MySQL.g:674:2: FROM table_spec ( partition_clause )? ( where_clause )? ( orderby_clause )? ( limit_clause )?
            {
            FROM458=(Token)match(input,FROM,FOLLOW_FROM_in_delete_single_table_statement4444); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FROM.add(FROM458);

            pushFollow(FOLLOW_table_spec_in_delete_single_table_statement4446);
            table_spec459=table_spec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_table_spec.add(table_spec459.getTree());
            // MySQL.g:675:2: ( partition_clause )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==PARTITION_SYM) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // MySQL.g:675:3: partition_clause
                    {
                    pushFollow(FOLLOW_partition_clause_in_delete_single_table_statement4450);
                    partition_clause460=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_partition_clause.add(partition_clause460.getTree());

                    }
                    break;

            }

            // MySQL.g:676:2: ( where_clause )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==WHERE) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // MySQL.g:676:3: where_clause
                    {
                    pushFollow(FOLLOW_where_clause_in_delete_single_table_statement4456);
                    where_clause461=where_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_where_clause.add(where_clause461.getTree());

                    }
                    break;

            }

            // MySQL.g:677:2: ( orderby_clause )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==ORDER_SYM) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // MySQL.g:677:3: orderby_clause
                    {
                    pushFollow(FOLLOW_orderby_clause_in_delete_single_table_statement4462);
                    orderby_clause462=orderby_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_orderby_clause.add(orderby_clause462.getTree());

                    }
                    break;

            }

            // MySQL.g:678:2: ( limit_clause )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==LIMIT||LA125_0==INTEGER_NUM) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // MySQL.g:678:3: limit_clause
                    {
                    pushFollow(FOLLOW_limit_clause_in_delete_single_table_statement4468);
                    limit_clause463=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_limit_clause.add(limit_clause463.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: table_spec
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 679:2: -> ^( table_spec )
            {
                // MySQL.g:679:5: ^( table_spec )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_table_spec.nextNode(), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 854, delete_single_table_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "delete_single_table_statement"

    public static class delete_multiple_table_statement1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delete_multiple_table_statement1"
    // MySQL.g:681:1: delete_multiple_table_statement1 : table_spec ( ALL_FIELDS )? ( COMMA table_spec ( ALL_FIELDS )? )* FROM table_references ( where_clause )? ;
    public final MySQLParser.delete_multiple_table_statement1_return delete_multiple_table_statement1() throws RecognitionException {
        MySQLParser.delete_multiple_table_statement1_return retval = new MySQLParser.delete_multiple_table_statement1_return();
        retval.start = input.LT(1);
        int delete_multiple_table_statement1_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ALL_FIELDS465=null;
        Token COMMA466=null;
        Token ALL_FIELDS468=null;
        Token FROM469=null;
        MySQLParser.table_spec_return table_spec464 = null;

        MySQLParser.table_spec_return table_spec467 = null;

        MySQLParser.table_references_return table_references470 = null;

        MySQLParser.where_clause_return where_clause471 = null;


        CommonTree ALL_FIELDS465_tree=null;
        CommonTree COMMA466_tree=null;
        CommonTree ALL_FIELDS468_tree=null;
        CommonTree FROM469_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 855) ) { return retval; }
            // MySQL.g:681:33: ( table_spec ( ALL_FIELDS )? ( COMMA table_spec ( ALL_FIELDS )? )* FROM table_references ( where_clause )? )
            // MySQL.g:682:2: table_spec ( ALL_FIELDS )? ( COMMA table_spec ( ALL_FIELDS )? )* FROM table_references ( where_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_table_spec_in_delete_multiple_table_statement14485);
            table_spec464=table_spec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_spec464.getTree());
            // MySQL.g:682:13: ( ALL_FIELDS )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==ALL_FIELDS) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // MySQL.g:682:14: ALL_FIELDS
                    {
                    ALL_FIELDS465=(Token)match(input,ALL_FIELDS,FOLLOW_ALL_FIELDS_in_delete_multiple_table_statement14488); if (state.failed) return retval;

                    }
                    break;

            }

            // MySQL.g:682:28: ( COMMA table_spec ( ALL_FIELDS )? )*
            loop128:
            do {
                int alt128=2;
                int LA128_0 = input.LA(1);

                if ( (LA128_0==COMMA) ) {
                    alt128=1;
                }


                switch (alt128) {
            	case 1 :
            	    // MySQL.g:682:29: COMMA table_spec ( ALL_FIELDS )?
            	    {
            	    COMMA466=(Token)match(input,COMMA,FOLLOW_COMMA_in_delete_multiple_table_statement14494); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA466_tree = (CommonTree)adaptor.create(COMMA466);
            	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA466_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_table_spec_in_delete_multiple_table_statement14497);
            	    table_spec467=table_spec();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, table_spec467.getTree());
            	    // MySQL.g:682:47: ( ALL_FIELDS )?
            	    int alt127=2;
            	    int LA127_0 = input.LA(1);

            	    if ( (LA127_0==ALL_FIELDS) ) {
            	        alt127=1;
            	    }
            	    switch (alt127) {
            	        case 1 :
            	            // MySQL.g:682:48: ALL_FIELDS
            	            {
            	            ALL_FIELDS468=(Token)match(input,ALL_FIELDS,FOLLOW_ALL_FIELDS_in_delete_multiple_table_statement14500); if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop128;
                }
            } while (true);

            FROM469=(Token)match(input,FROM,FOLLOW_FROM_in_delete_multiple_table_statement14508); if (state.failed) return retval;
            pushFollow(FOLLOW_table_references_in_delete_multiple_table_statement14511);
            table_references470=table_references();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_references470.getTree());
            // MySQL.g:684:2: ( where_clause )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==WHERE) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // MySQL.g:684:3: where_clause
                    {
                    pushFollow(FOLLOW_where_clause_in_delete_multiple_table_statement14515);
                    where_clause471=where_clause();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 855, delete_multiple_table_statement1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "delete_multiple_table_statement1"

    public static class delete_multiple_table_statement2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delete_multiple_table_statement2"
    // MySQL.g:686:1: delete_multiple_table_statement2 : FROM table_spec ( ALL_FIELDS )? ( COMMA table_spec ( ALL_FIELDS )? )* USING_SYM table_references ( where_clause )? ;
    public final MySQLParser.delete_multiple_table_statement2_return delete_multiple_table_statement2() throws RecognitionException {
        MySQLParser.delete_multiple_table_statement2_return retval = new MySQLParser.delete_multiple_table_statement2_return();
        retval.start = input.LT(1);
        int delete_multiple_table_statement2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token FROM472=null;
        Token ALL_FIELDS474=null;
        Token COMMA475=null;
        Token ALL_FIELDS477=null;
        Token USING_SYM478=null;
        MySQLParser.table_spec_return table_spec473 = null;

        MySQLParser.table_spec_return table_spec476 = null;

        MySQLParser.table_references_return table_references479 = null;

        MySQLParser.where_clause_return where_clause480 = null;


        CommonTree FROM472_tree=null;
        CommonTree ALL_FIELDS474_tree=null;
        CommonTree COMMA475_tree=null;
        CommonTree ALL_FIELDS477_tree=null;
        CommonTree USING_SYM478_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 856) ) { return retval; }
            // MySQL.g:686:33: ( FROM table_spec ( ALL_FIELDS )? ( COMMA table_spec ( ALL_FIELDS )? )* USING_SYM table_references ( where_clause )? )
            // MySQL.g:687:2: FROM table_spec ( ALL_FIELDS )? ( COMMA table_spec ( ALL_FIELDS )? )* USING_SYM table_references ( where_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();

            FROM472=(Token)match(input,FROM,FOLLOW_FROM_in_delete_multiple_table_statement24526); if (state.failed) return retval;
            pushFollow(FOLLOW_table_spec_in_delete_multiple_table_statement24529);
            table_spec473=table_spec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_spec473.getTree());
            // MySQL.g:687:19: ( ALL_FIELDS )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==ALL_FIELDS) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // MySQL.g:687:20: ALL_FIELDS
                    {
                    ALL_FIELDS474=(Token)match(input,ALL_FIELDS,FOLLOW_ALL_FIELDS_in_delete_multiple_table_statement24532); if (state.failed) return retval;

                    }
                    break;

            }

            // MySQL.g:687:34: ( COMMA table_spec ( ALL_FIELDS )? )*
            loop132:
            do {
                int alt132=2;
                int LA132_0 = input.LA(1);

                if ( (LA132_0==COMMA) ) {
                    alt132=1;
                }


                switch (alt132) {
            	case 1 :
            	    // MySQL.g:687:35: COMMA table_spec ( ALL_FIELDS )?
            	    {
            	    COMMA475=(Token)match(input,COMMA,FOLLOW_COMMA_in_delete_multiple_table_statement24538); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA475_tree = (CommonTree)adaptor.create(COMMA475);
            	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA475_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_table_spec_in_delete_multiple_table_statement24541);
            	    table_spec476=table_spec();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, table_spec476.getTree());
            	    // MySQL.g:687:53: ( ALL_FIELDS )?
            	    int alt131=2;
            	    int LA131_0 = input.LA(1);

            	    if ( (LA131_0==ALL_FIELDS) ) {
            	        alt131=1;
            	    }
            	    switch (alt131) {
            	        case 1 :
            	            // MySQL.g:687:54: ALL_FIELDS
            	            {
            	            ALL_FIELDS477=(Token)match(input,ALL_FIELDS,FOLLOW_ALL_FIELDS_in_delete_multiple_table_statement24544); if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop132;
                }
            } while (true);

            USING_SYM478=(Token)match(input,USING_SYM,FOLLOW_USING_SYM_in_delete_multiple_table_statement24552); if (state.failed) return retval;
            pushFollow(FOLLOW_table_references_in_delete_multiple_table_statement24555);
            table_references479=table_references();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_references479.getTree());
            // MySQL.g:689:2: ( where_clause )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==WHERE) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // MySQL.g:689:3: where_clause
                    {
                    pushFollow(FOLLOW_where_clause_in_delete_multiple_table_statement24559);
                    where_clause480=where_clause();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException e){
        	throw e;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 856, delete_multiple_table_statement2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "delete_multiple_table_statement2"

    // $ANTLR start synpred54_MySQL
    public final void synpred54_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:131:2: ( ( IN_SYM NATURAL LANGUAGE MODE_SYM ) )
        // MySQL.g:131:2: ( IN_SYM NATURAL LANGUAGE MODE_SYM )
        {
        // MySQL.g:131:2: ( IN_SYM NATURAL LANGUAGE MODE_SYM )
        // MySQL.g:131:3: IN_SYM NATURAL LANGUAGE MODE_SYM
        {
        match(input,IN_SYM,FOLLOW_IN_SYM_in_synpred54_MySQL519); if (state.failed) return ;
        match(input,NATURAL,FOLLOW_NATURAL_in_synpred54_MySQL521); if (state.failed) return ;
        match(input,LANGUAGE,FOLLOW_LANGUAGE_in_synpred54_MySQL523); if (state.failed) return ;
        match(input,MODE_SYM,FOLLOW_MODE_SYM_in_synpred54_MySQL525); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred54_MySQL

    // $ANTLR start synpred55_MySQL
    public final void synpred55_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:132:4: ( ( IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM ) )
        // MySQL.g:132:4: ( IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM )
        {
        // MySQL.g:132:4: ( IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM )
        // MySQL.g:132:5: IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM
        {
        match(input,IN_SYM,FOLLOW_IN_SYM_in_synpred55_MySQL532); if (state.failed) return ;
        match(input,NATURAL,FOLLOW_NATURAL_in_synpred55_MySQL534); if (state.failed) return ;
        match(input,LANGUAGE,FOLLOW_LANGUAGE_in_synpred55_MySQL536); if (state.failed) return ;
        match(input,MODE_SYM,FOLLOW_MODE_SYM_in_synpred55_MySQL538); if (state.failed) return ;
        match(input,WITH,FOLLOW_WITH_in_synpred55_MySQL540); if (state.failed) return ;
        match(input,QUERY_SYM,FOLLOW_QUERY_SYM_in_synpred55_MySQL542); if (state.failed) return ;
        match(input,EXPANSION_SYM,FOLLOW_EXPANSION_SYM_in_synpred55_MySQL544); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred55_MySQL

    // $ANTLR start synpred86_MySQL
    public final void synpred86_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:176:11: ( string_literal )
        // MySQL.g:176:11: string_literal
        {
        pushFollow(FOLLOW_string_literal_in_synpred86_MySQL798);
        string_literal();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_MySQL

    // $ANTLR start synpred87_MySQL
    public final void synpred87_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:176:28: ( number_literal )
        // MySQL.g:176:28: number_literal
        {
        pushFollow(FOLLOW_number_literal_in_synpred87_MySQL802);
        number_literal();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred87_MySQL

    // $ANTLR start synpred88_MySQL
    public final void synpred88_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:176:45: ( hex_literal )
        // MySQL.g:176:45: hex_literal
        {
        pushFollow(FOLLOW_hex_literal_in_synpred88_MySQL806);
        hex_literal();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_MySQL

    // $ANTLR start synpred89_MySQL
    public final void synpred89_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:176:59: ( boolean_literal )
        // MySQL.g:176:59: boolean_literal
        {
        pushFollow(FOLLOW_boolean_literal_in_synpred89_MySQL810);
        boolean_literal();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred89_MySQL

    // $ANTLR start synpred90_MySQL
    public final void synpred90_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:176:77: ( bit_literal )
        // MySQL.g:176:77: bit_literal
        {
        pushFollow(FOLLOW_bit_literal_in_synpred90_MySQL814);
        bit_literal();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_MySQL

    // $ANTLR start synpred92_MySQL
    public final void synpred92_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:181:4: ( char_functions )
        // MySQL.g:181:4: char_functions
        {
        pushFollow(FOLLOW_char_functions_in_synpred92_MySQL840);
        char_functions();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred92_MySQL

    // $ANTLR start synpred273_MySQL
    public final void synpred273_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:376:27: ( OR_SYM exp_factor1 )
        // MySQL.g:376:27: OR_SYM exp_factor1
        {
        match(input,OR_SYM,FOLLOW_OR_SYM_in_synpred273_MySQL2032); if (state.failed) return ;
        pushFollow(FOLLOW_exp_factor1_in_synpred273_MySQL2034);
        exp_factor1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred273_MySQL

    // $ANTLR start synpred274_MySQL
    public final void synpred274_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:377:28: ( XOR exp_factor2 )
        // MySQL.g:377:28: XOR exp_factor2
        {
        match(input,XOR,FOLLOW_XOR_in_synpred274_MySQL2048); if (state.failed) return ;
        pushFollow(FOLLOW_exp_factor2_in_synpred274_MySQL2050);
        exp_factor2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred274_MySQL

    // $ANTLR start synpred275_MySQL
    public final void synpred275_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:378:28: ( AND_SYM exp_factor3 )
        // MySQL.g:378:28: AND_SYM exp_factor3
        {
        match(input,AND_SYM,FOLLOW_AND_SYM_in_synpred275_MySQL2064); if (state.failed) return ;
        pushFollow(FOLLOW_exp_factor3_in_synpred275_MySQL2066);
        exp_factor3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred275_MySQL

    // $ANTLR start synpred276_MySQL
    public final void synpred276_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:379:15: ( NOT_SYM )
        // MySQL.g:379:15: NOT_SYM
        {
        match(input,NOT_SYM,FOLLOW_NOT_SYM_in_synpred276_MySQL2077); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred276_MySQL

    // $ANTLR start synpred278_MySQL
    public final void synpred278_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:380:48: ( boolean_literal )
        // MySQL.g:380:48: boolean_literal
        {
        pushFollow(FOLLOW_boolean_literal_in_synpred278_MySQL2100);
        boolean_literal();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred278_MySQL

    // $ANTLR start synpred279_MySQL
    public final void synpred279_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:380:29: ( IS_SYM ( NOT_SYM )? ( boolean_literal | NULL_SYM ) )
        // MySQL.g:380:29: IS_SYM ( NOT_SYM )? ( boolean_literal | NULL_SYM )
        {
        match(input,IS_SYM,FOLLOW_IS_SYM_in_synpred279_MySQL2092); if (state.failed) return ;
        // MySQL.g:380:36: ( NOT_SYM )?
        int alt140=2;
        int LA140_0 = input.LA(1);

        if ( (LA140_0==NOT_SYM) ) {
            alt140=1;
        }
        switch (alt140) {
            case 1 :
                // MySQL.g:380:37: NOT_SYM
                {
                match(input,NOT_SYM,FOLLOW_NOT_SYM_in_synpred279_MySQL2095); if (state.failed) return ;

                }
                break;

        }

        // MySQL.g:380:47: ( boolean_literal | NULL_SYM )
        int alt141=2;
        int LA141_0 = input.LA(1);

        if ( (LA141_0==NULL_SYM) ) {
            int LA141_1 = input.LA(2);

            if ( (synpred278_MySQL()) ) {
                alt141=1;
            }
            else if ( (true) ) {
                alt141=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 1, input);

                throw nvae;
            }
        }
        else if ( (LA141_0==FALSE_SYM||LA141_0==TRUE_SYM) ) {
            alt141=1;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 141, 0, input);

            throw nvae;
        }
        switch (alt141) {
            case 1 :
                // MySQL.g:380:48: boolean_literal
                {
                pushFollow(FOLLOW_boolean_literal_in_synpred279_MySQL2100);
                boolean_literal();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // MySQL.g:380:64: NULL_SYM
                {
                match(input,NULL_SYM,FOLLOW_NULL_SYM_in_synpred279_MySQL2102); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred279_MySQL

    // $ANTLR start synpred280_MySQL
    public final void synpred280_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:382:4: ( ( predicate relational_op predicate ) )
        // MySQL.g:382:4: ( predicate relational_op predicate )
        {
        // MySQL.g:382:4: ( predicate relational_op predicate )
        // MySQL.g:382:6: predicate relational_op predicate
        {
        pushFollow(FOLLOW_predicate_in_synpred280_MySQL2118);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_relational_op_in_synpred280_MySQL2120);
        relational_op();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred280_MySQL2122);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred280_MySQL

    // $ANTLR start synpred283_MySQL
    public final void synpred283_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:383:4: ( ( predicate relational_op ( ALL | ANY )? subquery ) )
        // MySQL.g:383:4: ( predicate relational_op ( ALL | ANY )? subquery )
        {
        // MySQL.g:383:4: ( predicate relational_op ( ALL | ANY )? subquery )
        // MySQL.g:383:6: predicate relational_op ( ALL | ANY )? subquery
        {
        pushFollow(FOLLOW_predicate_in_synpred283_MySQL2132);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_relational_op_in_synpred283_MySQL2134);
        relational_op();

        state._fsp--;
        if (state.failed) return ;
        // MySQL.g:383:30: ( ALL | ANY )?
        int alt142=2;
        int LA142_0 = input.LA(1);

        if ( (LA142_0==ALL||LA142_0==ANY) ) {
            alt142=1;
        }
        switch (alt142) {
            case 1 :
                // MySQL.g:
                {
                if ( input.LA(1)==ALL||input.LA(1)==ANY ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }


                }
                break;

        }

        pushFollow(FOLLOW_subquery_in_synpred283_MySQL2147);
        subquery();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred283_MySQL

    // $ANTLR start synpred285_MySQL
    public final void synpred285_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:384:4: ( ( ( NOT_SYM )? EXISTS subquery ) )
        // MySQL.g:384:4: ( ( NOT_SYM )? EXISTS subquery )
        {
        // MySQL.g:384:4: ( ( NOT_SYM )? EXISTS subquery )
        // MySQL.g:384:6: ( NOT_SYM )? EXISTS subquery
        {
        // MySQL.g:384:6: ( NOT_SYM )?
        int alt143=2;
        int LA143_0 = input.LA(1);

        if ( (LA143_0==NOT_SYM) ) {
            alt143=1;
        }
        switch (alt143) {
            case 1 :
                // MySQL.g:0:0: NOT_SYM
                {
                match(input,NOT_SYM,FOLLOW_NOT_SYM_in_synpred285_MySQL2156); if (state.failed) return ;

                }
                break;

        }

        match(input,EXISTS,FOLLOW_EXISTS_in_synpred285_MySQL2159); if (state.failed) return ;
        pushFollow(FOLLOW_subquery_in_synpred285_MySQL2161);
        subquery();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred285_MySQL

    // $ANTLR start synpred288_MySQL
    public final void synpred288_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:388:4: ( ( bit_expr ( NOT_SYM )? IN_SYM ( subquery | expression_list ) ) )
        // MySQL.g:388:4: ( bit_expr ( NOT_SYM )? IN_SYM ( subquery | expression_list ) )
        {
        // MySQL.g:388:4: ( bit_expr ( NOT_SYM )? IN_SYM ( subquery | expression_list ) )
        // MySQL.g:388:6: bit_expr ( NOT_SYM )? IN_SYM ( subquery | expression_list )
        {
        pushFollow(FOLLOW_bit_expr_in_synpred288_MySQL2181);
        bit_expr();

        state._fsp--;
        if (state.failed) return ;
        // MySQL.g:388:15: ( NOT_SYM )?
        int alt144=2;
        int LA144_0 = input.LA(1);

        if ( (LA144_0==NOT_SYM) ) {
            alt144=1;
        }
        switch (alt144) {
            case 1 :
                // MySQL.g:388:16: NOT_SYM
                {
                match(input,NOT_SYM,FOLLOW_NOT_SYM_in_synpred288_MySQL2184); if (state.failed) return ;

                }
                break;

        }

        match(input,IN_SYM,FOLLOW_IN_SYM_in_synpred288_MySQL2188); if (state.failed) return ;
        // MySQL.g:388:33: ( subquery | expression_list )
        int alt145=2;
        int LA145_0 = input.LA(1);

        if ( (LA145_0==LPAREN) ) {
            int LA145_1 = input.LA(2);

            if ( (LA145_1==SELECT) ) {
                alt145=1;
            }
            else if ( ((LA145_1>=ABS && LA145_1<=ACOS)||(LA145_1>=ADDDATE && LA145_1<=AES_ENCRYPT)||(LA145_1>=ASCII_SYM && LA145_1<=ASIN)||(LA145_1>=ATAN && LA145_1<=ATAN2)||LA145_1==AVG||LA145_1==BENCHMARK||(LA145_1>=BIN && LA145_1<=BIT_OR)||LA145_1==BIT_XOR||(LA145_1>=CASE_SYM && LA145_1<=CEILING)||(LA145_1>=CHAR && LA145_1<=CHAR_LENGTH)||LA145_1==CHARSET||LA145_1==COERCIBILITY||LA145_1==COLLATION||(LA145_1>=CONCAT && LA145_1<=CONCAT_WS)||LA145_1==CONNECTION_ID||(LA145_1>=CONV && LA145_1<=CONVERT_TZ)||(LA145_1>=COS && LA145_1<=COUNT)||LA145_1==CRC32||LA145_1==CURDATE||(LA145_1>=CURRENT_USER && LA145_1<=DATABASE)||(LA145_1>=DATE_ADD && LA145_1<=DATEDIFF)||LA145_1==DAY_SYM||(LA145_1>=DAYNAME && LA145_1<=DAYOFYEAR)||(LA145_1>=DECODE && LA145_1<=DEFAULT)||LA145_1==DEGREES||(LA145_1>=DES_DECRYPT && LA145_1<=DES_ENCRYPT)||LA145_1==ELT||(LA145_1>=ENCODE && LA145_1<=ENCRYPT)||(LA145_1>=EXISTS && LA145_1<=EXP)||(LA145_1>=EXPORT_SET && LA145_1<=FALSE_SYM)||LA145_1==FIELD||LA145_1==FIND_IN_SET||LA145_1==FLOOR||(LA145_1>=FORMAT && LA145_1<=FOUND_ROWS)||(LA145_1>=FROM_BASE64 && LA145_1<=FROM_UNIXTIME)||(LA145_1>=GET_FORMAT && LA145_1<=GET_LOCK)||LA145_1==GROUP_CONCAT||LA145_1==HEX||LA145_1==HOUR||(LA145_1>=IF && LA145_1<=IFNULL)||(LA145_1>=INET_ATON && LA145_1<=INET_NTOA)||LA145_1==INSERT||LA145_1==INSTR||LA145_1==INTERVAL_SYM||LA145_1==IS_FREE_LOCK||LA145_1==IS_USED_LOCK||(LA145_1>=LAST_DAY && LA145_1<=LAST_INSERT_ID)||(LA145_1>=LEFT && LA145_1<=LENGTH)||LA145_1==LN||LA145_1==LOAD_FILE||LA145_1==LOCATE||(LA145_1>=LOG && LA145_1<=LOG2)||(LA145_1>=LOWER && LA145_1<=LTRIM)||(LA145_1>=MAKE_SET && LA145_1<=MAX_SYM)||LA145_1==MD5||(LA145_1>=MICROSECOND && LA145_1<=MIN_SYM)||LA145_1==MINUTE||LA145_1==MOD||(LA145_1>=MONTH && LA145_1<=NAME_CONST)||(LA145_1>=NOT_SYM && LA145_1<=NULL_SYM)||LA145_1==OCT||LA145_1==OLD_PASSWORD||LA145_1==ORD||(LA145_1>=PASSWORD && LA145_1<=PI)||(LA145_1>=POW && LA145_1<=POWER)||LA145_1==QUARTER||(LA145_1>=QUOTE && LA145_1<=RAND)||LA145_1==RELEASE_LOCK||(LA145_1>=REPEAT && LA145_1<=REPLACE)||(LA145_1>=REVERSE && LA145_1<=RIGHT)||LA145_1==ROUND||LA145_1==ROW_SYM||(LA145_1>=RPAD && LA145_1<=RTRIM)||(LA145_1>=SCHEMA && LA145_1<=SECOND)||LA145_1==SESSION_USER||LA145_1==SIGN||LA145_1==SIN||LA145_1==SLEEP||LA145_1==SOUNDEX||LA145_1==SPACE||LA145_1==SQRT||(LA145_1>=STD && LA145_1<=STDDEV_SAMP)||LA145_1==STR_TO_DATE||LA145_1==STRCMP||(LA145_1>=SUBSTRING && LA145_1<=SUM)||(LA145_1>=SYSDATE && LA145_1<=SYSTEM_USER)||LA145_1==TAN||(LA145_1>=TIME_FORMAT && LA145_1<=TIMESTAMPDIFF)||(LA145_1>=TO_BASE64 && LA145_1<=TO_SECONDS)||(LA145_1>=TRIM && LA145_1<=TRUNCATE)||LA145_1==UNHEX||LA145_1==UNIX_TIMESTAMP||LA145_1==UPPER||LA145_1==USER||(LA145_1>=UTC_DATE && LA145_1<=UTC_TIMESTAMP)||LA145_1==UUID||(LA145_1>=VALUES && LA145_1<=VAR_SAMP)||(LA145_1>=VARIANCE && LA145_1<=VERSION_SYM)||(LA145_1>=WEEK && LA145_1<=WEIGHT_STRING)||(LA145_1>=LPAREN && LA145_1<=YEAR_FUNC)||LA145_1==YEARWEEK||(LA145_1>=PLUS && LA145_1<=NEGATION)||LA145_1==INTEGER_NUM||(LA145_1>=HEX_DIGIT && LA145_1<=ID)||LA145_1==USER_VAR) ) {
                alt145=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 145, 0, input);

            throw nvae;
        }
        switch (alt145) {
            case 1 :
                // MySQL.g:388:34: subquery
                {
                pushFollow(FOLLOW_subquery_in_synpred288_MySQL2191);
                subquery();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // MySQL.g:388:45: expression_list
                {
                pushFollow(FOLLOW_expression_list_in_synpred288_MySQL2195);
                expression_list();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred288_MySQL

    // $ANTLR start synpred290_MySQL
    public final void synpred290_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:389:4: ( ( bit_expr ( NOT_SYM )? BETWEEN bit_expr AND_SYM predicate ) )
        // MySQL.g:389:4: ( bit_expr ( NOT_SYM )? BETWEEN bit_expr AND_SYM predicate )
        {
        // MySQL.g:389:4: ( bit_expr ( NOT_SYM )? BETWEEN bit_expr AND_SYM predicate )
        // MySQL.g:389:6: bit_expr ( NOT_SYM )? BETWEEN bit_expr AND_SYM predicate
        {
        pushFollow(FOLLOW_bit_expr_in_synpred290_MySQL2205);
        bit_expr();

        state._fsp--;
        if (state.failed) return ;
        // MySQL.g:389:15: ( NOT_SYM )?
        int alt146=2;
        int LA146_0 = input.LA(1);

        if ( (LA146_0==NOT_SYM) ) {
            alt146=1;
        }
        switch (alt146) {
            case 1 :
                // MySQL.g:389:16: NOT_SYM
                {
                match(input,NOT_SYM,FOLLOW_NOT_SYM_in_synpred290_MySQL2208); if (state.failed) return ;

                }
                break;

        }

        match(input,BETWEEN,FOLLOW_BETWEEN_in_synpred290_MySQL2212); if (state.failed) return ;
        pushFollow(FOLLOW_bit_expr_in_synpred290_MySQL2214);
        bit_expr();

        state._fsp--;
        if (state.failed) return ;
        match(input,AND_SYM,FOLLOW_AND_SYM_in_synpred290_MySQL2216); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred290_MySQL2218);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred290_MySQL

    // $ANTLR start synpred291_MySQL
    public final void synpred291_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:390:4: ( ( bit_expr SOUNDS_SYM LIKE_SYM bit_expr ) )
        // MySQL.g:390:4: ( bit_expr SOUNDS_SYM LIKE_SYM bit_expr )
        {
        // MySQL.g:390:4: ( bit_expr SOUNDS_SYM LIKE_SYM bit_expr )
        // MySQL.g:390:6: bit_expr SOUNDS_SYM LIKE_SYM bit_expr
        {
        pushFollow(FOLLOW_bit_expr_in_synpred291_MySQL2228);
        bit_expr();

        state._fsp--;
        if (state.failed) return ;
        match(input,SOUNDS_SYM,FOLLOW_SOUNDS_SYM_in_synpred291_MySQL2230); if (state.failed) return ;
        match(input,LIKE_SYM,FOLLOW_LIKE_SYM_in_synpred291_MySQL2232); if (state.failed) return ;
        pushFollow(FOLLOW_bit_expr_in_synpred291_MySQL2234);
        bit_expr();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred291_MySQL

    // $ANTLR start synpred293_MySQL
    public final void synpred293_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:391:48: ( ESCAPE_SYM simple_expr )
        // MySQL.g:391:48: ESCAPE_SYM simple_expr
        {
        match(input,ESCAPE_SYM,FOLLOW_ESCAPE_SYM_in_synpred293_MySQL2256); if (state.failed) return ;
        pushFollow(FOLLOW_simple_expr_in_synpred293_MySQL2258);
        simple_expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred293_MySQL

    // $ANTLR start synpred294_MySQL
    public final void synpred294_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:391:4: ( ( bit_expr ( NOT_SYM )? LIKE_SYM simple_expr ( ESCAPE_SYM simple_expr )? ) )
        // MySQL.g:391:4: ( bit_expr ( NOT_SYM )? LIKE_SYM simple_expr ( ESCAPE_SYM simple_expr )? )
        {
        // MySQL.g:391:4: ( bit_expr ( NOT_SYM )? LIKE_SYM simple_expr ( ESCAPE_SYM simple_expr )? )
        // MySQL.g:391:6: bit_expr ( NOT_SYM )? LIKE_SYM simple_expr ( ESCAPE_SYM simple_expr )?
        {
        pushFollow(FOLLOW_bit_expr_in_synpred294_MySQL2244);
        bit_expr();

        state._fsp--;
        if (state.failed) return ;
        // MySQL.g:391:15: ( NOT_SYM )?
        int alt147=2;
        int LA147_0 = input.LA(1);

        if ( (LA147_0==NOT_SYM) ) {
            alt147=1;
        }
        switch (alt147) {
            case 1 :
                // MySQL.g:391:16: NOT_SYM
                {
                match(input,NOT_SYM,FOLLOW_NOT_SYM_in_synpred294_MySQL2247); if (state.failed) return ;

                }
                break;

        }

        match(input,LIKE_SYM,FOLLOW_LIKE_SYM_in_synpred294_MySQL2251); if (state.failed) return ;
        pushFollow(FOLLOW_simple_expr_in_synpred294_MySQL2253);
        simple_expr();

        state._fsp--;
        if (state.failed) return ;
        // MySQL.g:391:47: ( ESCAPE_SYM simple_expr )?
        int alt148=2;
        int LA148_0 = input.LA(1);

        if ( (LA148_0==ESCAPE_SYM) ) {
            alt148=1;
        }
        switch (alt148) {
            case 1 :
                // MySQL.g:391:48: ESCAPE_SYM simple_expr
                {
                match(input,ESCAPE_SYM,FOLLOW_ESCAPE_SYM_in_synpred294_MySQL2256); if (state.failed) return ;
                pushFollow(FOLLOW_simple_expr_in_synpred294_MySQL2258);
                simple_expr();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred294_MySQL

    // $ANTLR start synpred296_MySQL
    public final void synpred296_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:392:4: ( ( bit_expr ( NOT_SYM )? REGEXP bit_expr ) )
        // MySQL.g:392:4: ( bit_expr ( NOT_SYM )? REGEXP bit_expr )
        {
        // MySQL.g:392:4: ( bit_expr ( NOT_SYM )? REGEXP bit_expr )
        // MySQL.g:392:6: bit_expr ( NOT_SYM )? REGEXP bit_expr
        {
        pushFollow(FOLLOW_bit_expr_in_synpred296_MySQL2269);
        bit_expr();

        state._fsp--;
        if (state.failed) return ;
        // MySQL.g:392:15: ( NOT_SYM )?
        int alt149=2;
        int LA149_0 = input.LA(1);

        if ( (LA149_0==NOT_SYM) ) {
            alt149=1;
        }
        switch (alt149) {
            case 1 :
                // MySQL.g:392:16: NOT_SYM
                {
                match(input,NOT_SYM,FOLLOW_NOT_SYM_in_synpred296_MySQL2272); if (state.failed) return ;

                }
                break;

        }

        match(input,REGEXP,FOLLOW_REGEXP_in_synpred296_MySQL2276); if (state.failed) return ;
        pushFollow(FOLLOW_bit_expr_in_synpred296_MySQL2278);
        bit_expr();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred296_MySQL

    // $ANTLR start synpred297_MySQL
    public final void synpred297_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:396:12: ( VERTBAR factor1 )
        // MySQL.g:396:12: VERTBAR factor1
        {
        match(input,VERTBAR,FOLLOW_VERTBAR_in_synpred297_MySQL2304); if (state.failed) return ;
        pushFollow(FOLLOW_factor1_in_synpred297_MySQL2306);
        factor1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred297_MySQL

    // $ANTLR start synpred298_MySQL
    public final void synpred298_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:398:12: ( BITAND factor2 )
        // MySQL.g:398:12: BITAND factor2
        {
        match(input,BITAND,FOLLOW_BITAND_in_synpred298_MySQL2321); if (state.failed) return ;
        pushFollow(FOLLOW_factor2_in_synpred298_MySQL2323);
        factor2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred298_MySQL

    // $ANTLR start synpred300_MySQL
    public final void synpred300_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:400:12: ( ( SHIFT_LEFT | SHIFT_RIGHT ) factor3 )
        // MySQL.g:400:12: ( SHIFT_LEFT | SHIFT_RIGHT ) factor3
        {
        if ( (input.LA(1)>=SHIFT_LEFT && input.LA(1)<=SHIFT_RIGHT) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_factor3_in_synpred300_MySQL2344);
        factor3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred300_MySQL

    // $ANTLR start synpred302_MySQL
    public final void synpred302_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:402:12: ( ( PLUS | MINUS ) factor4 )
        // MySQL.g:402:12: ( PLUS | MINUS ) factor4
        {
        if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_factor4_in_synpred302_MySQL2365);
        factor4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred302_MySQL

    // $ANTLR start synpred306_MySQL
    public final void synpred306_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:404:12: ( ( ASTERISK | DIVIDE | MOD_SYM | POWER_OP ) factor5 )
        // MySQL.g:404:12: ( ASTERISK | DIVIDE | MOD_SYM | POWER_OP ) factor5
        {
        if ( (input.LA(1)>=DIVIDE && input.LA(1)<=MOD_SYM)||input.LA(1)==ASTERISK||input.LA(1)==POWER_OP ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_factor5_in_synpred306_MySQL2390);
        factor5();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred306_MySQL

    // $ANTLR start synpred308_MySQL
    public final void synpred308_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:406:12: ( ( PLUS | MINUS ) interval_expr )
        // MySQL.g:406:12: ( PLUS | MINUS ) interval_expr
        {
        if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_interval_expr_in_synpred308_MySQL2411);
        interval_expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred308_MySQL

    // $ANTLR start synpred312_MySQL
    public final void synpred312_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:408:2: ( ( PLUS | MINUS | NEGATION | BINARY ) simple_expr )
        // MySQL.g:408:2: ( PLUS | MINUS | NEGATION | BINARY ) simple_expr
        {
        if ( input.LA(1)==BINARY||(input.LA(1)>=PLUS && input.LA(1)<=NEGATION) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_simple_expr_in_synpred312_MySQL2438);
        simple_expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred312_MySQL

    // $ANTLR start synpred328_MySQL
    public final void synpred328_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:428:4: ( ( CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN ) )
        // MySQL.g:428:4: ( CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN )
        {
        // MySQL.g:428:4: ( CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN )
        // MySQL.g:428:7: CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN
        {
        match(input,CONVERT_SYM,FOLLOW_CONVERT_SYM_in_synpred328_MySQL2592); if (state.failed) return ;
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred328_MySQL2594); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred328_MySQL2596);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,COMMA,FOLLOW_COMMA_in_synpred328_MySQL2598); if (state.failed) return ;
        pushFollow(FOLLOW_cast_data_type_in_synpred328_MySQL2600);
        cast_data_type();

        state._fsp--;
        if (state.failed) return ;
        match(input,RPAREN,FOLLOW_RPAREN_in_synpred328_MySQL2602); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred328_MySQL

    // $ANTLR start synpred329_MySQL
    public final void synpred329_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:429:4: ( ( CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN ) )
        // MySQL.g:429:4: ( CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN )
        {
        // MySQL.g:429:4: ( CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN )
        // MySQL.g:429:7: CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN
        {
        match(input,CONVERT_SYM,FOLLOW_CONVERT_SYM_in_synpred329_MySQL2613); if (state.failed) return ;
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred329_MySQL2615); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred329_MySQL2617);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,USING_SYM,FOLLOW_USING_SYM_in_synpred329_MySQL2619); if (state.failed) return ;
        pushFollow(FOLLOW_transcoding_name_in_synpred329_MySQL2621);
        transcoding_name();

        state._fsp--;
        if (state.failed) return ;
        match(input,RPAREN,FOLLOW_RPAREN_in_synpred329_MySQL2623); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred329_MySQL

    // $ANTLR start synpred342_MySQL
    public final void synpred342_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:451:65: ( search_modifier )
        // MySQL.g:451:65: search_modifier
        {
        pushFollow(FOLLOW_search_modifier_in_synpred342_MySQL2851);
        search_modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred342_MySQL

    // $ANTLR start synpred406_MySQL
    public final void synpred406_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:577:2: ( select_options )
        // MySQL.g:577:2: select_options
        {
        pushFollow(FOLLOW_select_options_in_synpred406_MySQL3644);
        select_options();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred406_MySQL

    // $ANTLR start synpred407_MySQL
    public final void synpred407_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:579:2: ( select_expression_cont2 )
        // MySQL.g:579:2: select_expression_cont2
        {
        pushFollow(FOLLOW_select_expression_cont2_in_synpred407_MySQL3651);
        select_expression_cont2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred407_MySQL

    // $ANTLR start synpred430_MySQL
    public final void synpred430_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:617:15: ( column_spec )
        // MySQL.g:617:15: column_spec
        {
        pushFollow(FOLLOW_column_spec_in_synpred430_MySQL3967);
        column_spec();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred430_MySQL

    // $ANTLR start synpred431_MySQL
    public final void synpred431_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:617:29: ( INTEGER_NUM )
        // MySQL.g:617:29: INTEGER_NUM
        {
        match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_synpred431_MySQL3971); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred431_MySQL

    // $ANTLR start synpred443_MySQL
    public final void synpred443_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:652:4: ( column_name ( alias )? )
        // MySQL.g:652:4: column_name ( alias )?
        {
        pushFollow(FOLLOW_column_name_in_synpred443_MySQL4219);
        column_name();

        state._fsp--;
        if (state.failed) return ;
        // MySQL.g:652:16: ( alias )?
        int alt177=2;
        int LA177_0 = input.LA(1);

        if ( (LA177_0==AS_SYM||LA177_0==ID) ) {
            alt177=1;
        }
        switch (alt177) {
            case 1 :
                // MySQL.g:652:17: alias
                {
                pushFollow(FOLLOW_alias_in_synpred443_MySQL4222);
                alias();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred443_MySQL

    // $ANTLR start synpred446_MySQL
    public final void synpred446_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:653:4: ( column_spec ( column_op column_spec )+ ( alias )? )
        // MySQL.g:653:4: column_spec ( column_op column_spec )+ ( alias )?
        {
        pushFollow(FOLLOW_column_spec_in_synpred446_MySQL4242);
        column_spec();

        state._fsp--;
        if (state.failed) return ;
        // MySQL.g:653:16: ( column_op column_spec )+
        int cnt178=0;
        loop178:
        do {
            int alt178=2;
            int LA178_0 = input.LA(1);

            if ( (LA178_0==DIVIDE||LA178_0==ASTERISK||(LA178_0>=PLUS && LA178_0<=MINUS)) ) {
                alt178=1;
            }


            switch (alt178) {
        	case 1 :
        	    // MySQL.g:653:17: column_op column_spec
        	    {
        	    pushFollow(FOLLOW_column_op_in_synpred446_MySQL4245);
        	    column_op();

        	    state._fsp--;
        	    if (state.failed) return ;
        	    pushFollow(FOLLOW_column_spec_in_synpred446_MySQL4247);
        	    column_spec();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt178 >= 1 ) break loop178;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(178, input);
                    throw eee;
            }
            cnt178++;
        } while (true);

        // MySQL.g:653:41: ( alias )?
        int alt179=2;
        int LA179_0 = input.LA(1);

        if ( (LA179_0==AS_SYM||LA179_0==ID) ) {
            alt179=1;
        }
        switch (alt179) {
            case 1 :
                // MySQL.g:653:42: alias
                {
                pushFollow(FOLLOW_alias_in_synpred446_MySQL4252);
                alias();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred446_MySQL

    // $ANTLR start synpred450_MySQL
    public final void synpred450_MySQL_fragment() throws RecognitionException {   
        // MySQL.g:656:4: ( bit_expr ( alias )? )
        // MySQL.g:656:4: bit_expr ( alias )?
        {
        pushFollow(FOLLOW_bit_expr_in_synpred450_MySQL4309);
        bit_expr();

        state._fsp--;
        if (state.failed) return ;
        // MySQL.g:656:13: ( alias )?
        int alt180=2;
        int LA180_0 = input.LA(1);

        if ( (LA180_0==AS_SYM||LA180_0==ID) ) {
            alt180=1;
        }
        switch (alt180) {
            case 1 :
                // MySQL.g:656:14: alias
                {
                pushFollow(FOLLOW_alias_in_synpred450_MySQL4312);
                alias();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred450_MySQL

    // Delegated rules
    public MySQL_SQLParser1.alter_database_statements_return alter_database_statements() throws RecognitionException { return gSQLParser1.alter_database_statements(); }
    public MySQL_SQLParser1.alter_server_expression_return alter_server_expression() throws RecognitionException { return gSQLParser1.alter_server_expression(); }
    public MySQL_SQLParser2.create_view_statement_return create_view_statement() throws RecognitionException { return gSQLParser2.create_view_statement(); }
    public MySQL_SQLParser1.create_server_statement_return create_server_statement() throws RecognitionException { return gSQLParser1.create_server_statement(); }
    public MySQL_SQLParser1.alter_database_specification_return alter_database_specification() throws RecognitionException { return gSQLParser1.alter_database_specification(); }
    public MySQL_SQLParser1.alter_database_expression_return alter_database_expression() throws RecognitionException { return gSQLParser1.alter_database_expression(); }
    public MySQL_SQLParser1.set_column_cluase_return set_column_cluase() throws RecognitionException { return gSQLParser1.set_column_cluase(); }
    public MySQL_SQLParser1.alter_event_statement_return alter_event_statement() throws RecognitionException { return gSQLParser1.alter_event_statement(); }
    public MySQL_SQLParser1.replace_statement_return replace_statement() throws RecognitionException { return gSQLParser1.replace_statement(); }
    public MySQL_SQLParser1.insert_statements_return insert_statements() throws RecognitionException { return gSQLParser1.insert_statements(); }
    public MySQL_SQLParser1.timestamp_return timestamp() throws RecognitionException { return gSQLParser1.timestamp(); }
    public MySQL_SQLParser1.algorithm_option_return algorithm_option() throws RecognitionException { return gSQLParser1.algorithm_option(); }
    public MySQL_SQLParser1.interval_return interval() throws RecognitionException { return gSQLParser1.interval(); }
    public MySQL_SQLParser2.subpartition_definition_return subpartition_definition() throws RecognitionException { return gSQLParser2.subpartition_definition(); }
    public MySQL_SQLParser1.drop_server_expression_return drop_server_expression() throws RecognitionException { return gSQLParser1.drop_server_expression(); }
    public MySQL_SQLParser1.schedule_definition_return schedule_definition() throws RecognitionException { return gSQLParser1.schedule_definition(); }
    public MySQL_SQLParser2.create_table_expression3_return create_table_expression3() throws RecognitionException { return gSQLParser2.create_table_expression3(); }
    public MySQL_SQLParser1.drop_index_statement_return drop_index_statement() throws RecognitionException { return gSQLParser1.drop_index_statement(); }
    public MySQL_SQLParser1.replace_statement1_return replace_statement1() throws RecognitionException { return gSQLParser1.replace_statement1(); }
    public MySQL_SQLParser2.index_column_names_return index_column_names() throws RecognitionException { return gSQLParser2.index_column_names(); }
    public MySQL_SQLParser2.column_definition_return column_definition() throws RecognitionException { return gSQLParser2.column_definition(); }
    public MySQL_SQLParser2.reference_definition_return reference_definition() throws RecognitionException { return gSQLParser2.reference_definition(); }
    public MySQL_SQLParser1.column_value_list_return column_value_list() throws RecognitionException { return gSQLParser1.column_value_list(); }
    public MySQL_SQLParser1.create_index_expression_return create_index_expression() throws RecognitionException { return gSQLParser1.create_index_expression(); }
    public MySQL_SQLParser1.load_data_statement_return load_data_statement() throws RecognitionException { return gSQLParser1.load_data_statement(); }
    public MySQL_SQLParser1.alter_database_statement2_return alter_database_statement2() throws RecognitionException { return gSQLParser1.alter_database_statement2(); }
    public MySQL_SQLParser1.alter_database_statement1_return alter_database_statement1() throws RecognitionException { return gSQLParser1.alter_database_statement1(); }
    public MySQL_SQLParser1.load_xml_statement_return load_xml_statement() throws RecognitionException { return gSQLParser1.load_xml_statement(); }
    public MySQL_SQLParser1.handler_statement3_return handler_statement3() throws RecognitionException { return gSQLParser1.handler_statement3(); }
    public MySQL_SQLParser1.update_statements_return update_statements() throws RecognitionException { return gSQLParser1.update_statements(); }
    public MySQL_SQLParser2.null_or_notnull_return null_or_notnull() throws RecognitionException { return gSQLParser2.null_or_notnull(); }
    public MySQL_SQLParser2.length_return length() throws RecognitionException { return gSQLParser2.length(); }
    public MySQL_SQLParser2.index_column_name_return index_column_name() throws RecognitionException { return gSQLParser2.index_column_name(); }
    public MySQL_SQLParser1.create_event_statement_return create_event_statement() throws RecognitionException { return gSQLParser1.create_event_statement(); }
    public MySQL_SQLParser2.truncate_table_statement_return truncate_table_statement() throws RecognitionException { return gSQLParser2.truncate_table_statement(); }
    public MySQL_SQLParser2.reference_option_return reference_option() throws RecognitionException { return gSQLParser2.reference_option(); }
    public MySQL_SQLParser1.alter_server_option_return alter_server_option() throws RecognitionException { return gSQLParser1.alter_server_option(); }
    public MySQL_SQLParser1.replace_statement_expression_return replace_statement_expression() throws RecognitionException { return gSQLParser1.replace_statement_expression(); }
    public MySQL_SQLParser1.insert_statement2_return insert_statement2() throws RecognitionException { return gSQLParser1.insert_statement2(); }
    public MySQL_SQLParser2.drop_view_statement_return drop_view_statement() throws RecognitionException { return gSQLParser2.drop_view_statement(); }
    public MySQL_SQLParser1.insert_statement3_return insert_statement3() throws RecognitionException { return gSQLParser1.insert_statement3(); }
    public MySQL_SQLParser1.open_handler_statement_return open_handler_statement() throws RecognitionException { return gSQLParser1.open_handler_statement(); }
    public MySQL_SQLParser1.create_event_expression_return create_event_expression() throws RecognitionException { return gSQLParser1.create_event_expression(); }
    public MySQL_SQLParser2.create_table_expression1_return create_table_expression1() throws RecognitionException { return gSQLParser2.create_table_expression1(); }
    public MySQL_SQLParser2.create_view_body_return create_view_body() throws RecognitionException { return gSQLParser2.create_view_body(); }
    public MySQL_SQLParser1.call_statement_return call_statement() throws RecognitionException { return gSQLParser1.call_statement(); }
    public MySQL_SQLParser1.create_server_option_return create_server_option() throws RecognitionException { return gSQLParser1.create_server_option(); }
    public MySQL_SQLParser1.do_statement_return do_statement() throws RecognitionException { return gSQLParser1.do_statement(); }
    public MySQL_SQLParser2.column_data_type_header_return column_data_type_header() throws RecognitionException { return gSQLParser2.column_data_type_header(); }
    public MySQL_SQLParser1.set_columns_cluase_return set_columns_cluase() throws RecognitionException { return gSQLParser1.set_columns_cluase(); }
    public MySQL_SQLParser1.drop_index_expression_return drop_index_expression() throws RecognitionException { return gSQLParser1.drop_index_expression(); }
    public MySQL_SQLParser2.alter_table_expression_return alter_table_expression() throws RecognitionException { return gSQLParser2.alter_table_expression(); }
    public MySQL_SQLParser2.create_table_statement3_return create_table_statement3() throws RecognitionException { return gSQLParser2.create_table_statement3(); }
    public MySQL_SQLParser2.partition_options_return partition_options() throws RecognitionException { return gSQLParser2.partition_options(); }
    public MySQL_SQLParser2.column_definitions_return column_definitions() throws RecognitionException { return gSQLParser2.column_definitions(); }
    public MySQL_SQLParser2.create_view_expression_return create_view_expression() throws RecognitionException { return gSQLParser2.create_view_expression(); }
    public MySQL_SQLParser2.index_type_return index_type() throws RecognitionException { return gSQLParser2.index_type(); }
    public MySQL_SQLParser2.drop_view_expression_return drop_view_expression() throws RecognitionException { return gSQLParser2.drop_view_expression(); }
    public MySQL_SQLParser2.create_table_statement1_return create_table_statement1() throws RecognitionException { return gSQLParser2.create_table_statement1(); }
    public MySQL_SQLParser2.index_option_return index_option() throws RecognitionException { return gSQLParser2.index_option(); }
    public MySQL_SQLParser1.replace_statement2_return replace_statement2() throws RecognitionException { return gSQLParser1.replace_statement2(); }
    public MySQL_SQLParser1.handler_statement1_return handler_statement1() throws RecognitionException { return gSQLParser1.handler_statement1(); }
    public MySQL_SQLParser1.lock_option_return lock_option() throws RecognitionException { return gSQLParser1.lock_option(); }
    public MySQL_SQLParser2.create_definition_return create_definition() throws RecognitionException { return gSQLParser2.create_definition(); }
    public MySQL_SQLParser2.rename_table_statement_return rename_table_statement() throws RecognitionException { return gSQLParser2.rename_table_statement(); }
    public MySQL_SQLParser1.value_list_clause_return value_list_clause() throws RecognitionException { return gSQLParser1.value_list_clause(); }
    public MySQL_SQLParser1.create_database_statement_return create_database_statement() throws RecognitionException { return gSQLParser1.create_database_statement(); }
    public MySQL_SQLParser2.alter_table_statement_return alter_table_statement() throws RecognitionException { return gSQLParser2.alter_table_statement(); }
    public MySQL_SQLParser1.drop_event_statement_return drop_event_statement() throws RecognitionException { return gSQLParser1.drop_event_statement(); }
    public MySQL_SQLParser2.drop_table_expression_return drop_table_expression() throws RecognitionException { return gSQLParser2.drop_table_expression(); }
    public MySQL_SQLParser1.create_server_expression_return create_server_expression() throws RecognitionException { return gSQLParser1.create_server_expression(); }
    public MySQL_SQLParser2.table_options_return table_options() throws RecognitionException { return gSQLParser2.table_options(); }
    public MySQL_SQLParser1.handler_statements_return handler_statements() throws RecognitionException { return gSQLParser1.handler_statements(); }
    public MySQL_SQLParser2.alter_table_specification_return alter_table_specification() throws RecognitionException { return gSQLParser2.alter_table_specification(); }
    public MySQL_SQLParser1.insert_statement1_return insert_statement1() throws RecognitionException { return gSQLParser1.insert_statement1(); }
    public MySQL_SQLParser1.handler_statement2_return handler_statement2() throws RecognitionException { return gSQLParser1.handler_statement2(); }
    public MySQL_SQLParser2.table_option_return table_option() throws RecognitionException { return gSQLParser2.table_option(); }
    public MySQL_SQLParser1.insert_subfix_return insert_subfix() throws RecognitionException { return gSQLParser1.insert_subfix(); }
    public MySQL_SQLParser1.drop_database_expression_return drop_database_expression() throws RecognitionException { return gSQLParser1.drop_database_expression(); }
    public MySQL_SQLParser1.create_specification_return create_specification() throws RecognitionException { return gSQLParser1.create_specification(); }
    public MySQL_SQLParser2.alter_view_statement_return alter_view_statement() throws RecognitionException { return gSQLParser2.alter_view_statement(); }
    public MySQL_SQLParser1.alter_server_statement_return alter_server_statement() throws RecognitionException { return gSQLParser1.alter_server_statement(); }
    public MySQL_SQLParser1.replace_statement_header_return replace_statement_header() throws RecognitionException { return gSQLParser1.replace_statement_header(); }
    public MySQL_SQLParser1.multiple_table_update_statement_return multiple_table_update_statement() throws RecognitionException { return gSQLParser1.multiple_table_update_statement(); }
    public MySQL_SQLParser1.close_handler_statement_return close_handler_statement() throws RecognitionException { return gSQLParser1.close_handler_statement(); }
    public MySQL_SQLParser1.multiple_update_expression_return multiple_update_expression() throws RecognitionException { return gSQLParser1.multiple_update_expression(); }
    public MySQL_SQLParser1.insert_expression_return insert_expression() throws RecognitionException { return gSQLParser1.insert_expression(); }
    public MySQL_SQLParser2.partition_definition_return partition_definition() throws RecognitionException { return gSQLParser2.partition_definition(); }
    public MySQL_SQLParser2.drop_table_statement_return drop_table_statement() throws RecognitionException { return gSQLParser2.drop_table_statement(); }
    public MySQL_SQLParser2.create_table_statement_return create_table_statement() throws RecognitionException { return gSQLParser2.create_table_statement(); }
    public MySQL_SQLParser2.create_table_statement2_return create_table_statement2() throws RecognitionException { return gSQLParser2.create_table_statement2(); }
    public MySQL_SQLParser1.create_database_expression_return create_database_expression() throws RecognitionException { return gSQLParser1.create_database_expression(); }
    public MySQL_SQLParser1.single_table_update_statement_return single_table_update_statement() throws RecognitionException { return gSQLParser1.single_table_update_statement(); }
    public MySQL_SQLParser2.create_table_expression2_return create_table_expression2() throws RecognitionException { return gSQLParser2.create_table_expression2(); }
    public MySQL_SQLParser1.drop_database_statement_return drop_database_statement() throws RecognitionException { return gSQLParser1.drop_database_statement(); }
    public MySQL_SQLParser1.insert_header_return insert_header() throws RecognitionException { return gSQLParser1.insert_header(); }
    public MySQL_SQLParser1.single_update_expression_return single_update_expression() throws RecognitionException { return gSQLParser1.single_update_expression(); }
    public MySQL_SQLParser1.alter_event_expression_return alter_event_expression() throws RecognitionException { return gSQLParser1.alter_event_expression(); }
    public MySQL_SQLParser1.drop_server_statement_return drop_server_statement() throws RecognitionException { return gSQLParser1.drop_server_statement(); }
    public MySQL_SQLParser1.replace_statement3_return replace_statement3() throws RecognitionException { return gSQLParser1.replace_statement3(); }
    public MySQL_SQLParser1.drop_event_expression_return drop_event_expression() throws RecognitionException { return gSQLParser1.drop_event_expression(); }
    public MySQL_SQLParser1.create_index_statement_return create_index_statement() throws RecognitionException { return gSQLParser1.create_index_statement(); }

    public final boolean synpred308_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred308_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred285_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred285_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred306_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred306_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred430_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred430_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred290_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred290_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred294_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred294_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred274_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred274_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred283_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred283_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred296_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred296_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred406_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred406_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred443_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred443_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred328_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred328_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred446_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred446_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred342_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred342_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred450_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred450_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred312_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred312_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred431_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred431_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred291_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred291_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred298_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred298_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred329_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred329_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred297_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred297_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred275_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred275_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred279_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred279_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred300_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred300_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred302_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred302_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred273_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred273_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred407_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred407_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred288_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred288_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred276_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred276_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred280_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred280_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred278_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred278_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred293_MySQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred293_MySQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA78 dfa78 = new DFA78(this);
    protected DFA79 dfa79 = new DFA79(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA117 dfa117 = new DFA117(this);
    static final String DFA8_eotS =
        "\14\uffff";
    static final String DFA8_eofS =
        "\6\uffff\1\10\5\uffff";
    static final String DFA8_minS =
        "\1\u00ee\1\104\1\uffff\1\u0107\1\uffff\1\u013f\1\34\1\112\1\uffff"+
        "\1\u00be\1\0\1\uffff";
    static final String DFA8_maxS =
        "\1\u01fe\1\u0144\1\uffff\1\u0107\1\uffff\1\u013f\1\u022c\1\u0182"+
        "\1\uffff\1\u00be\1\0\1\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\4\1\uffff\1\3\3\uffff\1\1\2\uffff\1\2";
    static final String DFA8_specialS =
        "\12\uffff\1\0\1\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\u010f\uffff\1\2",
            "\1\4\u00ff\uffff\1\3",
            "",
            "\1\5",
            "",
            "\1\6",
            "\1\10\21\uffff\2\10\11\uffff\1\10\104\uffff\1\10\14\uffff"+
            "\5\10\17\uffff\1\10\12\uffff\1\10\5\uffff\1\10\3\uffff\1\10"+
            "\25\uffff\1\10\4\uffff\1\10\14\uffff\1\10\2\uffff\1\10\4\uffff"+
            "\4\10\6\uffff\1\10\4\uffff\1\10\12\uffff\1\10\1\uffff\1\10\20"+
            "\uffff\1\10\2\uffff\2\10\10\uffff\1\10\34\uffff\3\10\3\uffff"+
            "\1\10\2\uffff\1\10\3\uffff\1\10\6\uffff\1\10\7\uffff\1\10\5"+
            "\uffff\1\10\14\uffff\1\10\13\uffff\1\10\12\uffff\1\10\12\uffff"+
            "\2\10\4\uffff\1\10\14\uffff\1\10\23\uffff\1\10\22\uffff\1\10"+
            "\27\uffff\1\10\10\uffff\1\10\20\uffff\1\10\3\uffff\2\10\1\7"+
            "\4\uffff\1\10\2\uffff\1\10\2\uffff\4\10\1\uffff\4\10\1\uffff"+
            "\2\10\1\uffff\1\10\2\uffff\3\10\2\uffff\2\10\1\uffff\6\10\5"+
            "\uffff\1\10",
            "\1\10\11\uffff\1\10\u00c7\uffff\1\10\116\uffff\1\11\26\uffff"+
            "\1\10",
            "",
            "\1\12",
            "\1\uffff",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "130:1: search_modifier : ( ( IN_SYM NATURAL LANGUAGE MODE_SYM ) | ( IN_SYM NATURAL LANGUAGE MODE_SYM WITH QUERY_SYM EXPANSION_SYM ) | ( IN_SYM BOOLEAN_SYM MODE_SYM ) | ( WITH QUERY_SYM EXPANSION_SYM ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_10 = input.LA(1);

                         
                        int index8_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MySQL()) ) {s = 8;}

                        else if ( (synpred55_MySQL()) ) {s = 11;}

                         
                        input.seek(index8_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA24_eotS =
        "\37\uffff";
    static final String DFA24_eofS =
        "\37\uffff";
    static final String DFA24_minS =
        "\1\36\32\0\4\uffff";
    static final String DFA24_maxS =
        "\1\u0231\32\0\4\uffff";
    static final String DFA24_acceptS =
        "\33\uffff\1\3\1\1\1\2\1\4";
    static final String DFA24_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\4\uffff}>";
    static final String[] DFA24_transitionS = {
            "\2\12\2\uffff\2\14\2\16\12\uffff\1\15\1\12\1\uffff\2\12\1\uffff"+
            "\1\21\1\uffff\1\16\3\uffff\1\15\1\3\1\21\1\15\1\21\1\uffff\1"+
            "\21\10\uffff\1\31\1\17\2\12\1\uffff\2\15\1\uffff\1\16\6\uffff"+
            "\1\16\1\uffff\1\16\11\uffff\2\15\1\uffff\1\16\2\uffff\1\12\1"+
            "\20\1\14\1\uffff\2\12\1\21\10\uffff\1\12\3\uffff\1\14\1\uffff"+
            "\1\16\1\14\1\16\1\uffff\5\14\1\uffff\1\14\4\uffff\4\14\2\uffff"+
            "\2\16\1\uffff\1\12\3\uffff\2\16\14\uffff\1\15\2\uffff\2\16\14"+
            "\uffff\1\27\1\12\1\uffff\1\15\1\22\1\7\1\uffff\1\15\1\uffff"+
            "\1\15\3\uffff\1\12\3\uffff\1\15\1\16\1\uffff\1\15\2\14\5\uffff"+
            "\1\14\1\16\1\uffff\1\21\5\uffff\1\15\2\uffff\1\14\5\uffff\2"+
            "\16\4\uffff\2\16\3\uffff\1\15\1\uffff\1\15\2\uffff\1\32\2\uffff"+
            "\1\16\1\uffff\1\16\10\uffff\1\14\1\16\7\uffff\2\15\6\uffff\1"+
            "\12\1\uffff\1\13\1\uffff\1\15\1\uffff\3\12\3\uffff\3\15\2\uffff"+
            "\1\13\2\14\1\16\1\30\1\21\2\uffff\1\16\4\uffff\1\14\1\15\1\21"+
            "\1\uffff\1\14\2\uffff\1\12\2\uffff\2\14\1\16\4\uffff\1\33\1"+
            "\14\1\2\1\uffff\1\15\1\uffff\1\16\7\uffff\1\15\11\uffff\1\16"+
            "\2\14\1\12\1\uffff\2\12\3\uffff\1\14\2\uffff\1\15\2\12\7\uffff"+
            "\1\16\4\uffff\2\15\2\uffff\2\15\1\uffff\1\12\1\uffff\1\26\1"+
            "\uffff\2\15\1\uffff\1\16\2\14\4\uffff\1\16\3\uffff\1\12\2\uffff"+
            "\1\12\2\uffff\1\16\2\uffff\1\15\1\uffff\1\15\10\uffff\1\12\3"+
            "\uffff\4\21\1\uffff\1\14\1\uffff\1\15\2\uffff\2\15\1\14\1\21"+
            "\1\uffff\1\14\1\16\2\uffff\1\12\6\uffff\7\14\4\uffff\1\15\2"+
            "\14\2\uffff\1\15\1\7\1\12\3\uffff\1\15\2\uffff\1\14\3\uffff"+
            "\1\15\1\uffff\1\16\1\uffff\3\14\1\uffff\1\16\1\uffff\1\16\2"+
            "\21\3\uffff\1\21\1\16\2\uffff\3\14\1\15\10\uffff\1\25\1\23\1"+
            "\uffff\1\14\26\uffff\2\1\1\3\5\uffff\1\5\1\uffff\1\6\1\10\1"+
            "\5\1\4\1\11\4\uffff\1\24",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "381:1: bool_primary : ( ( predicate relational_op predicate ) | ( predicate relational_op ( ALL | ANY )? subquery ) | ( ( NOT_SYM )? EXISTS subquery ) | predicate );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_1 = input.LA(1);

                         
                        int index24_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_2 = input.LA(1);

                         
                        int index24_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_3 = input.LA(1);

                         
                        int index24_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA24_7 = input.LA(1);

                         
                        int index24_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA24_8 = input.LA(1);

                         
                        int index24_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA24_9 = input.LA(1);

                         
                        int index24_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA24_10 = input.LA(1);

                         
                        int index24_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA24_11 = input.LA(1);

                         
                        int index24_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA24_12 = input.LA(1);

                         
                        int index24_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA24_13 = input.LA(1);

                         
                        int index24_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA24_14 = input.LA(1);

                         
                        int index24_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA24_15 = input.LA(1);

                         
                        int index24_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA24_16 = input.LA(1);

                         
                        int index24_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA24_17 = input.LA(1);

                         
                        int index24_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA24_18 = input.LA(1);

                         
                        int index24_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA24_19 = input.LA(1);

                         
                        int index24_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA24_20 = input.LA(1);

                         
                        int index24_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA24_21 = input.LA(1);

                         
                        int index24_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA24_22 = input.LA(1);

                         
                        int index24_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA24_23 = input.LA(1);

                         
                        int index24_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (synpred285_MySQL()) ) {s = 27;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA24_24 = input.LA(1);

                         
                        int index24_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA24_25 = input.LA(1);

                         
                        int index24_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA24_26 = input.LA(1);

                         
                        int index24_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred280_MySQL()) ) {s = 28;}

                        else if ( (synpred283_MySQL()) ) {s = 29;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index24_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA31_eotS =
        "\41\uffff";
    static final String DFA31_eofS =
        "\41\uffff";
    static final String DFA31_minS =
        "\1\36\32\0\6\uffff";
    static final String DFA31_maxS =
        "\1\u0231\32\0\6\uffff";
    static final String DFA31_acceptS =
        "\33\uffff\1\1\1\2\1\3\1\4\1\5\1\6";
    static final String DFA31_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\6\uffff}>";
    static final String[] DFA31_transitionS = {
            "\2\12\2\uffff\2\14\2\16\12\uffff\1\15\1\12\1\uffff\2\12\1\uffff"+
            "\1\21\1\uffff\1\16\3\uffff\1\15\1\3\1\21\1\15\1\21\1\uffff\1"+
            "\21\10\uffff\1\31\1\17\2\12\1\uffff\2\15\1\uffff\1\16\6\uffff"+
            "\1\16\1\uffff\1\16\11\uffff\2\15\1\uffff\1\16\2\uffff\1\12\1"+
            "\20\1\14\1\uffff\2\12\1\21\10\uffff\1\12\3\uffff\1\14\1\uffff"+
            "\1\16\1\14\1\16\1\uffff\5\14\1\uffff\1\14\4\uffff\4\14\2\uffff"+
            "\2\16\1\uffff\1\12\3\uffff\2\16\14\uffff\1\15\2\uffff\2\16\14"+
            "\uffff\1\27\1\12\1\uffff\1\15\1\22\1\7\1\uffff\1\15\1\uffff"+
            "\1\15\3\uffff\1\12\3\uffff\1\15\1\16\1\uffff\1\15\2\14\5\uffff"+
            "\1\14\1\16\1\uffff\1\21\5\uffff\1\15\2\uffff\1\14\5\uffff\2"+
            "\16\4\uffff\2\16\3\uffff\1\15\1\uffff\1\15\2\uffff\1\32\2\uffff"+
            "\1\16\1\uffff\1\16\10\uffff\1\14\1\16\7\uffff\2\15\6\uffff\1"+
            "\12\1\uffff\1\13\1\uffff\1\15\1\uffff\3\12\3\uffff\3\15\2\uffff"+
            "\1\13\2\14\1\16\1\30\1\21\2\uffff\1\16\4\uffff\1\14\1\15\1\21"+
            "\1\uffff\1\14\2\uffff\1\12\2\uffff\2\14\1\16\5\uffff\1\14\1"+
            "\2\1\uffff\1\15\1\uffff\1\16\7\uffff\1\15\11\uffff\1\16\2\14"+
            "\1\12\1\uffff\2\12\3\uffff\1\14\2\uffff\1\15\2\12\7\uffff\1"+
            "\16\4\uffff\2\15\2\uffff\2\15\1\uffff\1\12\1\uffff\1\26\1\uffff"+
            "\2\15\1\uffff\1\16\2\14\4\uffff\1\16\3\uffff\1\12\2\uffff\1"+
            "\12\2\uffff\1\16\2\uffff\1\15\1\uffff\1\15\10\uffff\1\12\3\uffff"+
            "\4\21\1\uffff\1\14\1\uffff\1\15\2\uffff\2\15\1\14\1\21\1\uffff"+
            "\1\14\1\16\2\uffff\1\12\6\uffff\7\14\4\uffff\1\15\2\14\2\uffff"+
            "\1\15\1\7\1\12\3\uffff\1\15\2\uffff\1\14\3\uffff\1\15\1\uffff"+
            "\1\16\1\uffff\3\14\1\uffff\1\16\1\uffff\1\16\2\21\3\uffff\1"+
            "\21\1\16\2\uffff\3\14\1\15\10\uffff\1\25\1\23\1\uffff\1\14\26"+
            "\uffff\2\1\1\3\5\uffff\1\5\1\uffff\1\6\1\10\1\5\1\4\1\11\4\uffff"+
            "\1\24",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "387:1: predicate : ( ( bit_expr ( NOT_SYM )? IN_SYM ( subquery | expression_list ) ) | ( bit_expr ( NOT_SYM )? BETWEEN bit_expr AND_SYM predicate ) | ( bit_expr SOUNDS_SYM LIKE_SYM bit_expr ) | ( bit_expr ( NOT_SYM )? LIKE_SYM simple_expr ( ESCAPE_SYM simple_expr )? ) | ( bit_expr ( NOT_SYM )? REGEXP bit_expr ) | ( bit_expr ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_1 = input.LA(1);

                         
                        int index31_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_2 = input.LA(1);

                         
                        int index31_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_3 = input.LA(1);

                         
                        int index31_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA31_4 = input.LA(1);

                         
                        int index31_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA31_5 = input.LA(1);

                         
                        int index31_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA31_6 = input.LA(1);

                         
                        int index31_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA31_7 = input.LA(1);

                         
                        int index31_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA31_8 = input.LA(1);

                         
                        int index31_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA31_9 = input.LA(1);

                         
                        int index31_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA31_10 = input.LA(1);

                         
                        int index31_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA31_11 = input.LA(1);

                         
                        int index31_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA31_12 = input.LA(1);

                         
                        int index31_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA31_13 = input.LA(1);

                         
                        int index31_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA31_14 = input.LA(1);

                         
                        int index31_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA31_15 = input.LA(1);

                         
                        int index31_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA31_16 = input.LA(1);

                         
                        int index31_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA31_17 = input.LA(1);

                         
                        int index31_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA31_18 = input.LA(1);

                         
                        int index31_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA31_19 = input.LA(1);

                         
                        int index31_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA31_20 = input.LA(1);

                         
                        int index31_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA31_21 = input.LA(1);

                         
                        int index31_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA31_22 = input.LA(1);

                         
                        int index31_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA31_23 = input.LA(1);

                         
                        int index31_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA31_24 = input.LA(1);

                         
                        int index31_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA31_25 = input.LA(1);

                         
                        int index31_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA31_26 = input.LA(1);

                         
                        int index31_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred288_MySQL()) ) {s = 27;}

                        else if ( (synpred290_MySQL()) ) {s = 28;}

                        else if ( (synpred291_MySQL()) ) {s = 29;}

                        else if ( (synpred294_MySQL()) ) {s = 30;}

                        else if ( (synpred296_MySQL()) ) {s = 31;}

                        else if ( (true) ) {s = 32;}

                         
                        input.seek(index31_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA39_eotS =
        "\15\uffff";
    static final String DFA39_eofS =
        "\15\uffff";
    static final String DFA39_minS =
        "\1\36\4\uffff\1\36\7\uffff";
    static final String DFA39_maxS =
        "\1\u0231\4\uffff\1\u0231\7\uffff";
    static final String DFA39_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\10\1\11\1\12\1\13\1\5\1"+
        "\7";
    static final String DFA39_specialS =
        "\15\uffff}>";
    static final String[] DFA39_transitionS = {
            "\2\3\2\uffff\4\3\12\uffff\2\3\1\uffff\2\3\1\uffff\1\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\3\3\1\uffff\1\3\10\uffff\1\11\3\3\1"+
            "\uffff\2\3\1\uffff\1\3\6\uffff\1\3\1\uffff\1\3\11\uffff\2\3"+
            "\1\uffff\1\3\2\uffff\3\3\1\uffff\3\3\10\uffff\1\3\3\uffff\1"+
            "\3\1\uffff\3\3\1\uffff\5\3\1\uffff\1\3\4\uffff\4\3\2\uffff\2"+
            "\3\1\uffff\1\3\3\uffff\2\3\14\uffff\1\3\2\uffff\2\3\14\uffff"+
            "\1\7\1\3\1\uffff\2\3\1\1\1\uffff\1\3\1\uffff\1\3\3\uffff\1\3"+
            "\3\uffff\2\3\1\uffff\3\3\5\uffff\2\3\1\uffff\1\3\5\uffff\1\3"+
            "\2\uffff\1\3\5\uffff\2\3\4\uffff\2\3\3\uffff\1\3\1\uffff\1\3"+
            "\2\uffff\1\12\2\uffff\1\3\1\uffff\1\3\10\uffff\2\3\7\uffff\2"+
            "\3\6\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\uffff\3\3\3\uffff\3"+
            "\3\2\uffff\4\3\1\10\1\3\2\uffff\1\3\4\uffff\3\3\1\uffff\1\3"+
            "\2\uffff\1\3\2\uffff\3\3\5\uffff\1\3\1\1\1\uffff\1\3\1\uffff"+
            "\1\3\7\uffff\1\3\11\uffff\4\3\1\uffff\2\3\3\uffff\1\3\2\uffff"+
            "\3\3\7\uffff\1\3\4\uffff\2\3\2\uffff\2\3\1\uffff\1\3\1\uffff"+
            "\1\6\1\uffff\2\3\1\uffff\3\3\4\uffff\1\3\3\uffff\1\3\2\uffff"+
            "\1\3\2\uffff\1\3\2\uffff\1\3\1\uffff\1\3\10\uffff\1\3\3\uffff"+
            "\4\3\1\uffff\1\3\1\uffff\1\3\2\uffff\4\3\1\uffff\2\3\2\uffff"+
            "\1\3\6\uffff\7\3\4\uffff\3\3\2\uffff\1\3\1\1\1\3\3\uffff\1\3"+
            "\2\uffff\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\3\3\1\uffff\1\3"+
            "\1\uffff\3\3\3\uffff\2\3\2\uffff\4\3\10\uffff\1\5\1\3\1\uffff"+
            "\1\3\26\uffff\2\1\6\uffff\1\1\1\uffff\4\1\1\2\4\uffff\1\4",
            "",
            "",
            "",
            "",
            "\2\13\2\uffff\4\13\12\uffff\2\13\1\uffff\2\13\1\uffff\1\13"+
            "\1\uffff\1\13\3\uffff\5\13\1\uffff\1\13\10\uffff\4\13\1\uffff"+
            "\2\13\1\uffff\1\13\6\uffff\1\13\1\uffff\1\13\11\uffff\2\13\1"+
            "\uffff\1\13\2\uffff\3\13\1\uffff\3\13\10\uffff\1\13\3\uffff"+
            "\1\13\1\uffff\3\13\1\uffff\5\13\1\uffff\1\13\4\uffff\4\13\2"+
            "\uffff\2\13\1\uffff\1\13\3\uffff\2\13\14\uffff\1\13\2\uffff"+
            "\2\13\14\uffff\2\13\1\uffff\3\13\1\uffff\1\13\1\uffff\1\13\3"+
            "\uffff\1\13\3\uffff\2\13\1\uffff\3\13\5\uffff\2\13\1\uffff\1"+
            "\13\5\uffff\1\13\2\uffff\1\13\5\uffff\2\13\4\uffff\2\13\3\uffff"+
            "\1\13\1\uffff\1\13\2\uffff\1\13\2\uffff\1\13\1\uffff\1\13\10"+
            "\uffff\2\13\7\uffff\2\13\6\uffff\1\13\1\uffff\1\13\1\uffff\1"+
            "\13\1\uffff\3\13\3\uffff\3\13\2\uffff\6\13\2\uffff\1\13\4\uffff"+
            "\3\13\1\uffff\1\13\2\uffff\1\13\2\uffff\3\13\4\uffff\3\13\1"+
            "\uffff\1\13\1\uffff\1\13\7\uffff\1\13\11\uffff\4\13\1\uffff"+
            "\2\13\3\uffff\1\13\2\uffff\3\13\7\uffff\1\13\4\uffff\2\13\2"+
            "\uffff\2\13\1\uffff\1\13\1\uffff\1\13\1\uffff\2\13\1\uffff\3"+
            "\13\2\uffff\1\14\1\uffff\1\13\3\uffff\1\13\2\uffff\1\13\2\uffff"+
            "\1\13\2\uffff\1\13\1\uffff\1\13\10\uffff\1\13\3\uffff\4\13\1"+
            "\uffff\1\13\1\uffff\1\13\2\uffff\4\13\1\uffff\2\13\2\uffff\1"+
            "\13\6\uffff\7\13\4\uffff\3\13\2\uffff\3\13\3\uffff\1\13\2\uffff"+
            "\1\13\3\uffff\1\13\1\uffff\1\13\1\uffff\3\13\1\uffff\1\13\1"+
            "\uffff\3\13\3\uffff\2\13\2\uffff\4\13\10\uffff\2\13\1\uffff"+
            "\1\13\26\uffff\3\13\5\uffff\1\13\1\uffff\5\13\4\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "411:1: simple_expr : ( literal_value | column_spec | function_call -> ^( TN_FUNCTION function_call ) | USER_VAR | expression_list | ( ROW_SYM expression_list ) | subquery | EXISTS subquery | match_against_statement | case_when_statement -> ^( TN_CASE_WHEN case_when_statement ) | interval_expr );";
        }
    }
    static final String DFA46_eotS =
        "\15\uffff";
    static final String DFA46_eofS =
        "\15\uffff";
    static final String DFA46_minS =
        "\1\36\6\uffff\1\0\5\uffff";
    static final String DFA46_maxS =
        "\1\u0207\6\uffff\1\0\5\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\1\uffff\1\5\1\6\1\uffff\1\3\1\4";
    static final String DFA46_specialS =
        "\7\uffff\1\0\5\uffff}>";
    static final String[] DFA46_transitionS = {
            "\2\1\2\uffff\4\1\12\uffff\2\1\1\uffff\2\1\1\uffff\1\10\1\uffff"+
            "\1\1\3\uffff\1\1\1\uffff\1\10\1\1\1\10\1\uffff\1\10\11\uffff"+
            "\1\6\2\1\1\uffff\2\1\1\uffff\1\1\6\uffff\1\1\1\uffff\1\1\11"+
            "\uffff\2\1\1\uffff\1\1\2\uffff\1\1\1\7\1\1\1\uffff\2\1\1\10"+
            "\10\uffff\1\1\3\uffff\1\1\1\uffff\3\1\1\uffff\5\1\1\uffff\1"+
            "\1\4\uffff\4\1\2\uffff\2\1\1\uffff\1\1\3\uffff\2\1\14\uffff"+
            "\1\1\2\uffff\2\1\15\uffff\1\1\1\uffff\1\1\1\11\2\uffff\1\1\1"+
            "\uffff\1\1\3\uffff\1\1\3\uffff\2\1\1\uffff\3\1\5\uffff\2\1\1"+
            "\uffff\1\10\5\uffff\1\1\2\uffff\1\1\5\uffff\2\1\4\uffff\2\1"+
            "\3\uffff\1\1\1\uffff\1\1\5\uffff\1\1\1\uffff\1\1\10\uffff\2"+
            "\1\7\uffff\2\1\6\uffff\1\1\1\uffff\1\1\1\uffff\1\1\1\uffff\3"+
            "\1\3\uffff\3\1\2\uffff\4\1\1\uffff\1\10\2\uffff\1\1\4\uffff"+
            "\2\1\1\10\1\uffff\1\1\2\uffff\1\1\2\uffff\3\1\5\uffff\1\1\2"+
            "\uffff\1\1\1\uffff\1\1\7\uffff\1\1\11\uffff\4\1\1\uffff\2\1"+
            "\3\uffff\1\1\2\uffff\3\1\7\uffff\1\1\4\uffff\2\1\2\uffff\2\1"+
            "\1\uffff\1\1\3\uffff\2\1\1\uffff\3\1\4\uffff\1\1\3\uffff\1\1"+
            "\2\uffff\1\1\2\uffff\1\1\2\uffff\1\1\1\uffff\1\1\10\uffff\1"+
            "\1\3\uffff\4\10\1\uffff\1\1\1\uffff\1\1\2\uffff\3\1\1\10\1\uffff"+
            "\2\1\2\uffff\1\1\6\uffff\7\1\4\uffff\3\1\2\uffff\1\1\1\uffff"+
            "\1\1\3\uffff\1\1\2\uffff\1\1\3\uffff\1\1\1\uffff\1\1\1\uffff"+
            "\3\1\1\uffff\1\1\1\uffff\1\1\2\10\3\uffff\1\10\1\1\2\uffff\4"+
            "\1\11\uffff\1\11\1\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "425:1: function_call : ( ( functionList ( LPAREN ( expression ( COMMA expression )* )? RPAREN )? ) | ( CAST_SYM LPAREN expression AS_SYM cast_data_type RPAREN ) | ( CONVERT_SYM LPAREN expression COMMA cast_data_type RPAREN ) | ( CONVERT_SYM LPAREN expression USING_SYM transcoding_name RPAREN ) | ( group_functions ( LPAREN ( ASTERISK | ALL | DISTINCT )? ( bit_expr )? RPAREN )? ) | ( special_functions ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_7 = input.LA(1);

                         
                        int index46_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred328_MySQL()) ) {s = 11;}

                        else if ( (synpred329_MySQL()) ) {s = 12;}

                         
                        input.seek(index46_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA78_eotS =
        "\15\uffff";
    static final String DFA78_eofS =
        "\15\uffff";
    static final String DFA78_minS =
        "\1\110\7\uffff\1\u0084\4\uffff";
    static final String DFA78_maxS =
        "\1\u01e5\7\uffff\1\u0202\4\uffff";
    static final String DFA78_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\1\13\1\10\1\11";
    static final String DFA78_specialS =
        "\15\uffff}>";
    static final String[] DFA78_transitionS = {
            "\1\5\123\uffff\1\2\10\uffff\1\6\67\uffff\1\7\27\uffff\1\3\44"+
            "\uffff\1\10\142\uffff\1\11\21\uffff\1\1\122\uffff\1\4\2\uffff"+
            "\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13\u017d\uffff\1\14",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA78_eot = DFA.unpackEncodedString(DFA78_eotS);
    static final short[] DFA78_eof = DFA.unpackEncodedString(DFA78_eofS);
    static final char[] DFA78_min = DFA.unpackEncodedStringToUnsignedChars(DFA78_minS);
    static final char[] DFA78_max = DFA.unpackEncodedStringToUnsignedChars(DFA78_maxS);
    static final short[] DFA78_accept = DFA.unpackEncodedString(DFA78_acceptS);
    static final short[] DFA78_special = DFA.unpackEncodedString(DFA78_specialS);
    static final short[][] DFA78_transition;

    static {
        int numStates = DFA78_transitionS.length;
        DFA78_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA78_transition[i] = DFA.unpackEncodedString(DFA78_transitionS[i]);
        }
    }

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = DFA78_eot;
            this.eof = DFA78_eof;
            this.min = DFA78_min;
            this.max = DFA78_max;
            this.accept = DFA78_accept;
            this.special = DFA78_special;
            this.transition = DFA78_transition;
        }
        public String getDescription() {
            return "519:1: data_manipulation_statements : ( select_statement | delete_statements | insert_statements | update_statements | call_statement | do_statement | handler_statements | load_data_statement | load_xml_statement | replace_statement | use_statement );";
        }
    }
    static final String DFA79_eotS =
        "\37\uffff";
    static final String DFA79_eofS =
        "\37\uffff";
    static final String DFA79_minS =
        "\1\52\2\50\1\u0083\5\uffff\1\u020e\6\uffff\1\u020e\10\uffff\2\u0081"+
        "\4\u00b8";
    static final String DFA79_maxS =
        "\1\u01d9\1\u020b\2\u01f6\5\uffff\1\u020e\6\uffff\1\u020e\10\uffff"+
        "\2\u022c\4\u01f6";
    static final String DFA79_acceptS =
        "\4\uffff\1\17\1\21\1\12\1\22\1\15\1\uffff\1\7\1\4\1\1\1\10\1\13"+
        "\1\2\1\uffff\1\5\1\16\1\20\1\11\1\14\1\6\1\3\1\23\6\uffff";
    static final String DFA79_specialS =
        "\37\uffff}>";
    static final String[] DFA79_transitionS = {
            "\1\2\121\uffff\1\1\52\uffff\1\3\u00d1\uffff\1\4\137\uffff\1"+
            "\5",
            "\1\10\132\uffff\1\14\24\uffff\1\11\37\uffff\1\13\33\uffff"+
            "\1\7\32\uffff\1\7\u009a\uffff\1\14\5\uffff\1\12\20\uffff\1\7"+
            "\6\uffff\1\10\25\uffff\1\6\2\uffff\1\6\35\uffff\1\7\26\uffff"+
            "\1\10\24\uffff\1\10",
            "\1\22\132\uffff\1\17\24\uffff\1\20\37\uffff\1\21\63\uffff"+
            "\1\16\u009d\uffff\1\17\5\uffff\1\15\27\uffff\1\22\25\uffff\1"+
            "\16\67\uffff\1\22",
            "\1\27\64\uffff\1\26\66\uffff\1\30\u009a\uffff\1\27\5\uffff"+
            "\1\24\55\uffff\1\25\2\uffff\1\25\64\uffff\1\23",
            "",
            "",
            "",
            "",
            "",
            "\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\34\u01aa\uffff\1\33",
            "\1\36\u01aa\uffff\1\35",
            "\1\13\u00ef\uffff\1\10\115\uffff\1\10",
            "\1\13\u00ef\uffff\1\10\115\uffff\1\10",
            "\1\21\u00ef\uffff\1\22\115\uffff\1\22",
            "\1\21\u00ef\uffff\1\22\115\uffff\1\22"
    };

    static final short[] DFA79_eot = DFA.unpackEncodedString(DFA79_eotS);
    static final short[] DFA79_eof = DFA.unpackEncodedString(DFA79_eofS);
    static final char[] DFA79_min = DFA.unpackEncodedStringToUnsignedChars(DFA79_minS);
    static final char[] DFA79_max = DFA.unpackEncodedStringToUnsignedChars(DFA79_maxS);
    static final short[] DFA79_accept = DFA.unpackEncodedString(DFA79_acceptS);
    static final short[] DFA79_special = DFA.unpackEncodedString(DFA79_specialS);
    static final short[][] DFA79_transition;

    static {
        int numStates = DFA79_transitionS.length;
        DFA79_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA79_transition[i] = DFA.unpackEncodedString(DFA79_transitionS[i]);
        }
    }

    class DFA79 extends DFA {

        public DFA79(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 79;
            this.eot = DFA79_eot;
            this.eof = DFA79_eof;
            this.min = DFA79_min;
            this.max = DFA79_max;
            this.accept = DFA79_accept;
            this.special = DFA79_special;
            this.transition = DFA79_transition;
        }
        public String getDescription() {
            return "534:1: data_definition_statements : ( create_database_statement | alter_database_statements | drop_database_statement | create_event_statement | alter_event_statement | drop_event_statement | create_server_statement | alter_server_statement | drop_server_statement | create_table_statement | alter_table_statement | drop_table_statement | create_view_statement | alter_view_statement | rename_table_statement | drop_view_statement | truncate_table_statement | create_index_statement | drop_index_statement );";
        }
    }
    static final String DFA82_eotS =
        "\45\uffff";
    static final String DFA82_eofS =
        "\45\uffff";
    static final String DFA82_minS =
        "\1\36\10\uffff\33\0\1\uffff";
    static final String DFA82_maxS =
        "\1\u0231\10\uffff\33\0\1\uffff";
    static final String DFA82_acceptS =
        "\1\uffff\1\1\42\uffff\1\2";
    static final String DFA82_specialS =
        "\11\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\1\32\1\uffff}>";
    static final String[] DFA82_transitionS = {
            "\2\23\2\uffff\2\25\2\27\3\uffff\1\1\6\uffff\1\26\1\23\1\uffff"+
            "\2\23\1\uffff\1\32\1\uffff\1\27\3\uffff\1\26\1\15\1\32\1\26"+
            "\1\32\1\uffff\1\32\10\uffff\1\42\1\30\2\23\1\uffff\2\26\1\uffff"+
            "\1\27\6\uffff\1\27\1\uffff\1\27\11\uffff\2\26\1\uffff\1\27\2"+
            "\uffff\1\23\1\31\1\25\1\uffff\2\23\1\32\10\uffff\1\23\3\uffff"+
            "\1\25\1\uffff\1\27\1\25\1\27\1\uffff\5\25\1\uffff\1\25\4\uffff"+
            "\4\25\2\uffff\2\27\1\uffff\1\23\3\uffff\2\27\4\uffff\2\1\6\uffff"+
            "\1\26\2\uffff\2\27\14\uffff\1\40\1\23\1\uffff\1\26\1\33\1\21"+
            "\1\uffff\1\26\1\uffff\1\26\3\uffff\1\23\3\uffff\1\26\1\27\1"+
            "\uffff\1\26\2\25\5\uffff\1\25\1\27\1\uffff\1\32\5\uffff\1\26"+
            "\1\1\1\uffff\1\25\5\uffff\2\27\4\uffff\2\27\3\uffff\1\26\1\uffff"+
            "\1\26\2\uffff\1\43\2\uffff\1\27\1\uffff\1\27\10\uffff\1\25\1"+
            "\27\7\uffff\2\26\6\uffff\1\23\1\uffff\1\24\1\uffff\1\26\1\uffff"+
            "\3\23\3\uffff\3\26\2\uffff\1\24\2\25\1\27\1\41\1\32\2\uffff"+
            "\1\27\4\uffff\1\25\1\26\1\32\1\uffff\1\25\2\uffff\1\23\2\uffff"+
            "\2\25\1\27\5\uffff\1\25\1\14\1\uffff\1\26\1\uffff\1\27\7\uffff"+
            "\1\26\11\uffff\1\27\2\25\1\23\1\uffff\2\23\3\uffff\1\25\2\uffff"+
            "\1\26\2\23\7\uffff\1\27\4\uffff\2\26\2\uffff\2\26\1\uffff\1"+
            "\23\1\uffff\1\37\1\uffff\2\26\1\uffff\1\27\2\25\4\uffff\1\27"+
            "\3\uffff\1\23\2\uffff\1\23\2\uffff\1\27\2\uffff\1\26\1\uffff"+
            "\1\26\1\uffff\6\1\1\uffff\1\23\3\uffff\4\32\1\uffff\1\25\1\1"+
            "\1\26\2\uffff\2\26\1\25\1\32\1\uffff\1\25\1\27\2\uffff\1\23"+
            "\6\uffff\7\25\4\uffff\1\26\2\25\2\uffff\1\26\1\21\1\23\3\uffff"+
            "\1\26\2\uffff\1\25\3\uffff\1\26\1\uffff\1\27\1\uffff\3\25\1"+
            "\uffff\1\27\1\uffff\1\27\2\32\3\uffff\1\32\1\27\2\uffff\3\25"+
            "\1\26\10\uffff\1\36\1\34\1\uffff\1\25\22\uffff\1\12\3\uffff"+
            "\2\13\1\15\5\uffff\1\17\1\uffff\1\20\1\22\1\17\1\16\1\11\4\uffff"+
            "\1\35",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA82_eot = DFA.unpackEncodedString(DFA82_eotS);
    static final short[] DFA82_eof = DFA.unpackEncodedString(DFA82_eofS);
    static final char[] DFA82_min = DFA.unpackEncodedStringToUnsignedChars(DFA82_minS);
    static final char[] DFA82_max = DFA.unpackEncodedStringToUnsignedChars(DFA82_maxS);
    static final short[] DFA82_accept = DFA.unpackEncodedString(DFA82_acceptS);
    static final short[] DFA82_special = DFA.unpackEncodedString(DFA82_specialS);
    static final short[][] DFA82_transition;

    static {
        int numStates = DFA82_transitionS.length;
        DFA82_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA82_transition[i] = DFA.unpackEncodedString(DFA82_transitionS[i]);
        }
    }

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = DFA82_eot;
            this.eof = DFA82_eof;
            this.min = DFA82_min;
            this.max = DFA82_max;
            this.accept = DFA82_accept;
            this.special = DFA82_special;
            this.transition = DFA82_transition;
        }
        public String getDescription() {
            return "577:2: ( select_options )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA82_9 = input.LA(1);

                         
                        int index82_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA82_10 = input.LA(1);

                         
                        int index82_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA82_11 = input.LA(1);

                         
                        int index82_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA82_12 = input.LA(1);

                         
                        int index82_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_12);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA82_13 = input.LA(1);

                         
                        int index82_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_13);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA82_14 = input.LA(1);

                         
                        int index82_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_14);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA82_15 = input.LA(1);

                         
                        int index82_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_15);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA82_16 = input.LA(1);

                         
                        int index82_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_16);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA82_17 = input.LA(1);

                         
                        int index82_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_17);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA82_18 = input.LA(1);

                         
                        int index82_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_18);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA82_19 = input.LA(1);

                         
                        int index82_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_19);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA82_20 = input.LA(1);

                         
                        int index82_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_20);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA82_21 = input.LA(1);

                         
                        int index82_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_21);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA82_22 = input.LA(1);

                         
                        int index82_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_22);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA82_23 = input.LA(1);

                         
                        int index82_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_23);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA82_24 = input.LA(1);

                         
                        int index82_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_24);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA82_25 = input.LA(1);

                         
                        int index82_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_25);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA82_26 = input.LA(1);

                         
                        int index82_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_26);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA82_27 = input.LA(1);

                         
                        int index82_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_27);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA82_28 = input.LA(1);

                         
                        int index82_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_28);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA82_29 = input.LA(1);

                         
                        int index82_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_29);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA82_30 = input.LA(1);

                         
                        int index82_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_30);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA82_31 = input.LA(1);

                         
                        int index82_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_31);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA82_32 = input.LA(1);

                         
                        int index82_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_32);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA82_33 = input.LA(1);

                         
                        int index82_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_33);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA82_34 = input.LA(1);

                         
                        int index82_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_34);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA82_35 = input.LA(1);

                         
                        int index82_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred406_MySQL()) ) {s = 1;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index82_35);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 82, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA117_eotS =
        "\15\uffff";
    static final String DFA117_eofS =
        "\10\uffff\1\13\4\uffff";
    static final String DFA117_minS =
        "\1\36\1\u0209\2\uffff\1\u022c\1\36\2\uffff\1\56\1\0\3\uffff";
    static final String DFA117_maxS =
        "\1\u0231\1\u021f\2\uffff\1\u022c\1\u0231\2\uffff\1\u022c\1\0\3"+
        "\uffff";
    static final String DFA117_acceptS =
        "\2\uffff\1\4\1\6\2\uffff\1\5\1\2\2\uffff\1\7\1\1\1\3";
    static final String DFA117_specialS =
        "\1\uffff\1\0\7\uffff\1\1\3\uffff}>";
    static final String[] DFA117_transitionS = {
            "\2\3\2\uffff\4\3\12\uffff\2\3\1\uffff\2\3\1\uffff\1\3\1\uffff"+
            "\1\3\3\uffff\5\3\1\uffff\1\3\10\uffff\4\3\1\uffff\2\3\1\uffff"+
            "\1\3\6\uffff\1\3\1\uffff\1\3\11\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\3\3\1\uffff\3\3\10\uffff\1\3\3\uffff\1\3\1\uffff\3\3\1\uffff"+
            "\5\3\1\uffff\1\3\4\uffff\4\3\2\uffff\2\3\1\uffff\1\3\3\uffff"+
            "\2\3\14\uffff\1\3\2\uffff\2\3\14\uffff\2\3\1\uffff\3\3\1\uffff"+
            "\1\3\1\uffff\1\3\3\uffff\1\3\3\uffff\2\3\1\uffff\3\3\5\uffff"+
            "\2\3\1\uffff\1\3\5\uffff\1\3\2\uffff\1\3\5\uffff\2\3\4\uffff"+
            "\2\3\3\uffff\1\3\1\uffff\1\3\2\uffff\1\3\2\uffff\1\3\1\uffff"+
            "\1\3\10\uffff\2\3\7\uffff\2\3\6\uffff\1\3\1\uffff\1\3\1\uffff"+
            "\1\3\1\uffff\3\3\3\uffff\3\3\2\uffff\6\3\2\uffff\1\3\4\uffff"+
            "\3\3\1\uffff\1\3\2\uffff\1\3\2\uffff\3\3\5\uffff\2\3\1\uffff"+
            "\1\3\1\uffff\1\3\7\uffff\1\3\11\uffff\4\3\1\uffff\2\3\3\uffff"+
            "\1\3\2\uffff\3\3\7\uffff\1\3\4\uffff\2\3\2\uffff\2\3\1\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\2\3\1\uffff\3\3\4\uffff\1\3\3\uffff"+
            "\1\3\2\uffff\1\3\2\uffff\1\3\2\uffff\1\3\1\uffff\1\3\10\uffff"+
            "\1\3\3\uffff\4\3\1\uffff\1\3\1\uffff\1\3\2\uffff\4\3\1\uffff"+
            "\2\3\2\uffff\1\3\6\uffff\7\3\4\uffff\3\3\2\uffff\3\3\3\uffff"+
            "\1\3\2\uffff\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\3\3\1\uffff"+
            "\1\3\1\uffff\3\3\3\uffff\2\3\2\uffff\4\3\10\uffff\2\3\1\uffff"+
            "\1\3\22\uffff\1\2\3\uffff\3\3\5\uffff\1\3\1\uffff\4\3\1\1\4"+
            "\uffff\1\3",
            "\1\5\13\uffff\1\6\2\uffff\1\4\1\uffff\1\5\3\uffff\2\5",
            "",
            "",
            "\1\10",
            "\2\12\2\uffff\4\12\12\uffff\2\12\1\uffff\2\12\1\uffff\1\12"+
            "\1\uffff\1\12\3\uffff\1\12\1\uffff\3\12\1\uffff\1\12\10\uffff"+
            "\4\12\1\uffff\2\12\1\uffff\1\12\6\uffff\1\12\1\uffff\1\12\11"+
            "\uffff\2\12\1\uffff\1\12\2\uffff\3\12\1\uffff\3\12\10\uffff"+
            "\1\12\3\uffff\1\12\1\uffff\3\12\1\uffff\5\12\1\uffff\1\12\4"+
            "\uffff\4\12\2\uffff\2\12\1\uffff\1\12\3\uffff\2\12\14\uffff"+
            "\1\12\2\uffff\2\12\14\uffff\2\12\1\uffff\3\12\1\uffff\1\12\1"+
            "\uffff\1\12\3\uffff\1\12\3\uffff\2\12\1\uffff\3\12\5\uffff\2"+
            "\12\1\uffff\1\12\5\uffff\1\12\2\uffff\1\12\5\uffff\2\12\4\uffff"+
            "\2\12\3\uffff\1\12\1\uffff\1\12\2\uffff\1\12\2\uffff\1\12\1"+
            "\uffff\1\12\10\uffff\2\12\7\uffff\2\12\6\uffff\1\12\1\uffff"+
            "\1\12\1\uffff\1\12\1\uffff\3\12\3\uffff\3\12\2\uffff\6\12\2"+
            "\uffff\1\12\4\uffff\3\12\1\uffff\1\12\2\uffff\1\12\2\uffff\3"+
            "\12\5\uffff\2\12\1\uffff\1\12\1\uffff\1\12\7\uffff\1\12\11\uffff"+
            "\4\12\1\uffff\2\12\3\uffff\1\12\2\uffff\3\12\7\uffff\1\12\4"+
            "\uffff\2\12\2\uffff\2\12\1\uffff\1\12\1\uffff\1\12\1\uffff\2"+
            "\12\1\uffff\3\12\4\uffff\1\12\3\uffff\1\12\2\uffff\1\12\2\uffff"+
            "\1\12\2\uffff\1\12\1\uffff\1\12\10\uffff\1\12\3\uffff\4\12\1"+
            "\uffff\1\12\1\uffff\1\12\2\uffff\4\12\1\uffff\2\12\2\uffff\1"+
            "\12\6\uffff\7\12\4\uffff\3\12\2\uffff\3\12\3\uffff\1\12\2\uffff"+
            "\1\12\3\uffff\1\12\1\uffff\1\12\1\uffff\3\12\1\uffff\1\12\1"+
            "\uffff\3\12\3\uffff\2\12\2\uffff\4\12\10\uffff\2\12\1\uffff"+
            "\1\12\26\uffff\2\12\6\uffff\1\12\1\uffff\4\12\1\11\4\uffff\1"+
            "\12",
            "",
            "",
            "\1\13\u009b\uffff\1\13\4\uffff\1\13\105\uffff\1\13\10\uffff"+
            "\1\13\60\uffff\1\13\7\uffff\1\13\u0086\uffff\1\13\37\uffff\1"+
            "\13\12\uffff\1\5\14\uffff\1\13\2\uffff\1\13\1\5\1\13\2\uffff"+
            "\2\5\6\uffff\1\13\5\uffff\1\13",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA117_eot = DFA.unpackEncodedString(DFA117_eotS);
    static final short[] DFA117_eof = DFA.unpackEncodedString(DFA117_eofS);
    static final char[] DFA117_min = DFA.unpackEncodedStringToUnsignedChars(DFA117_minS);
    static final char[] DFA117_max = DFA.unpackEncodedStringToUnsignedChars(DFA117_maxS);
    static final short[] DFA117_accept = DFA.unpackEncodedString(DFA117_acceptS);
    static final short[] DFA117_special = DFA.unpackEncodedString(DFA117_specialS);
    static final short[][] DFA117_transition;

    static {
        int numStates = DFA117_transitionS.length;
        DFA117_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA117_transition[i] = DFA.unpackEncodedString(DFA117_transitionS[i]);
        }
    }

    class DFA117 extends DFA {

        public DFA117(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 117;
            this.eot = DFA117_eot;
            this.eof = DFA117_eof;
            this.min = DFA117_min;
            this.max = DFA117_max;
            this.accept = DFA117_accept;
            this.special = DFA117_special;
            this.transition = DFA117_transition;
        }
        public String getDescription() {
            return "650:1: displayed_column : ( table_name DOT column_name ( alias )? -> ^( TN_COL_EXP table_name DOT column_name ( alias )? ) | column_name ( alias )? -> ^( TN_COL_EXP column_name ( alias )? ) | column_spec ( column_op column_spec )+ ( alias )? -> ^( TN_COL_EXP column_spec ( column_op column_spec )+ ( alias )? ) | ASTERISK -> ^( TN_COL_ALLC ASTERISK ) | table_name ALL_FIELDS -> ^( TN_COL_ALLTC table_name ALL_FIELDS ) | bit_expr ( alias )? -> ^( TN_COL_BITEXP bit_expr ( alias )? ) | column_spec column_op simple_expr ( alias )? );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA117_1 = input.LA(1);

                         
                        int index117_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA117_1==DOT) ) {s = 4;}

                        else if ( (LA117_1==DIVIDE||LA117_1==ASTERISK||(LA117_1>=PLUS && LA117_1<=MINUS)) ) {s = 5;}

                        else if ( (LA117_1==ALL_FIELDS) ) {s = 6;}

                        else if ( (synpred443_MySQL()) ) {s = 7;}

                        else if ( (synpred450_MySQL()) ) {s = 3;}

                         
                        input.seek(index117_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA117_9 = input.LA(1);

                         
                        int index117_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred446_MySQL()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index117_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 117, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_set_in_relational_op0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_charset_name0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_in_cast_data_type436 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_cast_data_type439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_cast_data_type447 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_cast_data_type450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATE_SYM_in_cast_data_type458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_cast_data_type463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_SYM_in_cast_data_type469 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_cast_data_type473 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_cast_data_type476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_cast_data_type478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIGNED_SYM_in_cast_data_type488 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_INTEGER_SYM_in_cast_data_type491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIME_SYM_in_cast_data_type498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNSIGNED_SYM_in_cast_data_type503 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_INTEGER_SYM_in_cast_data_type506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_SYM_in_search_modifier519 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_NATURAL_in_search_modifier521 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LANGUAGE_in_search_modifier523 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_MODE_SYM_in_search_modifier525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_SYM_in_search_modifier532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_NATURAL_in_search_modifier534 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LANGUAGE_in_search_modifier536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_MODE_SYM_in_search_modifier538 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_WITH_in_search_modifier540 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_QUERY_SYM_in_search_modifier542 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_EXPANSION_SYM_in_search_modifier544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_SYM_in_search_modifier551 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_BOOLEAN_SYM_in_search_modifier553 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_MODE_SYM_in_search_modifier555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_search_modifier562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_QUERY_SYM_in_search_modifier564 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_EXPANSION_SYM_in_search_modifier566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_transcoding_name0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SECOND_in_interval_unit594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUTE_in_interval_unit599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOUR_in_interval_unit604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAY_SYM_in_interval_unit609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WEEK_in_interval_unit614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MONTH_in_interval_unit619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUARTER_in_interval_unit624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Y__in_interval_unit629 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_E__in_interval_unit631 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_A__in_interval_unit633 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_R__in_interval_unit635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SECOND_MICROSECOND_in_interval_unit640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUTE_MICROSECOND_in_interval_unit645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUTE_SECOND_in_interval_unit650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOUR_MICROSECOND_in_interval_unit655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOUR_SECOND_in_interval_unit660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOUR_MINUTE_in_interval_unit665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAY_MICROSECOND_in_interval_unit670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAY_SECOND_in_interval_unit675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAY_MINUTE_in_interval_unit680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAY_HOUR_in_interval_unit685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YEAR_MONTH_in_interval_unit690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collation_names0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_string_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_number_literal725 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000000000000000L,0x0000044000000000L});
    public static final BitSet FOLLOW_set_in_number_literal734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_hex_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_boolean_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_bit_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_literal_in_literal_value798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_literal_in_literal_value802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hex_literal_in_literal_value806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_literal_in_literal_value810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_literal_in_literal_value814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_SYM_in_literal_value818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_functions_in_functionList834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_functions_in_functionList840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_time_functions_in_functionList846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_other_functions_in_functionList851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTRACT_in_special_functions860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_special_functions862 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000000L,0x000000000000F800L,0x000000F000000000L,0x3800000000000000L,0x0000040000000002L,0x0000000000003000L,0x0100000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_interval_unit_in_special_functions864 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_FROM_in_special_functions866 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_special_functions868 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_special_functions870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YEAR_FUNC_in_special_functions875 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_special_functions877 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_special_functions879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_number_functions0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_char_functions0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_time_functions0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_other_functions0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_group_functions0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_schema_name1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_table_name1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_engine_name1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_column_name1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_view_name1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_parser_name1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_index_name1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_partition_name1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_partition_logical_name1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_constraint_symbol_name1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_foreign_key_symbol_name1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_collation_name1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_event_name1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_user_name1951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_function_name1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_procedure_name1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_server_name1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_wrapper_name1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_SYM_in_alias2012 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_ID_in_alias2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exp_factor1_in_expression2028 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_OR_SYM_in_expression2032 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_exp_factor1_in_expression2034 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_exp_factor2_in_exp_factor12044 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_XOR_in_exp_factor12048 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_exp_factor2_in_exp_factor12050 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_exp_factor3_in_exp_factor22060 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_AND_SYM_in_exp_factor22064 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_exp_factor3_in_exp_factor22066 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_NOT_SYM_in_exp_factor32077 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_exp_factor4_in_exp_factor32081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_primary_in_exp_factor42088 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_IS_SYM_in_exp_factor42092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L,0x0000000000000000L,0x0000000000000500L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_NOT_SYM_in_exp_factor42095 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_boolean_literal_in_exp_factor42100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_SYM_in_exp_factor42102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_bool_primary2118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000300003C000L});
    public static final BitSet FOLLOW_relational_op_in_bool_primary2120 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_predicate_in_bool_primary2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_bool_primary2132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000300003C000L});
    public static final BitSet FOLLOW_relational_op_in_bool_primary2134 = new BitSet(new long[]{0x0000120000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_set_in_bool_primary2136 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_subquery_in_bool_primary2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_SYM_in_bool_primary2156 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_EXISTS_in_bool_primary2159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_subquery_in_bool_primary2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_bool_primary2168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_predicate2181 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000400000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_predicate2184 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_IN_SYM_in_predicate2188 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_subquery_in_predicate2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_list_in_predicate2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_predicate2205 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_predicate2208 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_predicate2212 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_predicate2214 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_AND_SYM_in_predicate2216 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_predicate_in_predicate2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_predicate2228 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_SOUNDS_SYM_in_predicate2230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LIKE_SYM_in_predicate2232 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_predicate2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_predicate2244 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_predicate2247 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LIKE_SYM_in_predicate2251 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_simple_expr_in_predicate2253 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_ESCAPE_SYM_in_predicate2256 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_simple_expr_in_predicate2258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_predicate2269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_predicate2272 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_REGEXP_in_predicate2276 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_predicate2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_predicate2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor1_in_bit_expr2300 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_VERTBAR_in_bit_expr2304 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_factor1_in_bit_expr2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor2_in_factor12317 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_BITAND_in_factor12321 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_factor2_in_factor12323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor3_in_factor22334 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000180000L});
    public static final BitSet FOLLOW_set_in_factor22338 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_factor3_in_factor22344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor4_in_factor32355 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_set_in_factor32359 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_factor4_in_factor32365 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_factor5_in_factor42376 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000804000600L});
    public static final BitSet FOLLOW_set_in_factor42380 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_factor5_in_factor42390 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000804000600L});
    public static final BitSet FOLLOW_factor6_in_factor52401 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_set_in_factor52405 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_interval_expr_in_factor52411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_factor62422 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_simple_expr_in_factor62438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_expr_in_factor62443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_value_in_simple_expr2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_spec_in_simple_expr2457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_simple_expr2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USER_VAR_in_simple_expr2475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_list_in_simple_expr2480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROW_SYM_in_simple_expr2486 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expression_list_in_simple_expr2488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subquery_in_simple_expr2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXISTS_in_simple_expr2499 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_subquery_in_simple_expr2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_match_against_statement_in_simple_expr2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_when_statement_in_simple_expr2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interval_expr_in_simple_expr2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionList_in_function_call2538 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_function_call2542 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C80000B0L});
    public static final BitSet FOLLOW_expression_in_function_call2545 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_function_call2548 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_function_call2550 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_function_call2556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_SYM_in_function_call2571 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_function_call2573 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_function_call2575 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_AS_SYM_in_function_call2577 = new BitSet(new long[]{0x2000000000000000L,0x0000000000010000L,0x0000000000200500L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000400000L,0x0000000200000100L});
    public static final BitSet FOLLOW_cast_data_type_in_function_call2579 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_function_call2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONVERT_SYM_in_function_call2592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_function_call2594 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_function_call2596 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_function_call2598 = new BitSet(new long[]{0x2000000000000000L,0x0000000000010000L,0x0000000000200500L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000400000L,0x0000000200000100L});
    public static final BitSet FOLLOW_cast_data_type_in_function_call2600 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_function_call2602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONVERT_SYM_in_function_call2613 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_function_call2615 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_function_call2617 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_USING_SYM_in_function_call2619 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000002000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_transcoding_name_in_function_call2621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_function_call2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_functions_in_function_call2634 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_function_call2638 = new BitSet(new long[]{0xF15B023CC0000000L,0x880772C0140B7805L,0xB000C80862CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41CC0000B0L});
    public static final BitSet FOLLOW_set_in_function_call2640 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C80000B0L});
    public static final BitSet FOLLOW_bit_expr_in_function_call2655 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_function_call2658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_special_functions_in_function_call2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_when_statement1_in_case_when_statement2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_when_statement2_in_case_when_statement2693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_SYM_in_case_when_statement12708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_WHEN_SYM_in_case_when_statement12720 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_case_when_statement12722 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_THEN_SYM_in_case_when_statement12724 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_case_when_statement12726 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_ELSE_SYM_in_case_when_statement12741 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_case_when_statement12743 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_END_SYM_in_case_when_statement12756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_SYM_in_case_when_statement22771 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_case_when_statement22773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_WHEN_SYM_in_case_when_statement22785 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_case_when_statement22787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_THEN_SYM_in_case_when_statement22789 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_case_when_statement22791 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_ELSE_SYM_in_case_when_statement22806 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_case_when_statement22808 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_END_SYM_in_case_when_statement22821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCH_in_match_against_statement2831 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_column_spec_in_match_against_statement2834 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_match_against_statement2837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_column_spec_in_match_against_statement2839 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_AGAINST_in_match_against_statement2845 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_match_against_statement2848 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000400000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_search_modifier_in_match_against_statement2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_name_in_column_spec2867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_DOT_in_column_spec2869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_column_name_in_column_spec2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_expression_list2882 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_expression_list2884 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_expression_list2888 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_expression_list2890 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_expression_list2895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTERVAL_SYM_in_interval_expr2904 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_interval_expr2906 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000000L,0x000000000000F800L,0x000000F000000000L,0x3800000000000000L,0x0000040000000002L,0x0000000000003000L,0x0100000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_interval_unit_in_interval_expr2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_reference_in_table_references2925 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_table_references2929 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_reference_in_table_references2931 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_table_atom_in_table_reference2943 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000020001L,0x0000000000000010L,0x0008000000000002L});
    public static final BitSet FOLLOW_join_table_in_table_reference2945 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000020001L,0x0000000000000010L,0x0008000000000002L});
    public static final BitSet FOLLOW_join_qualifier1_in_join_table2956 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_JOIN_SYM_in_join_table2960 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_atom_in_join_table2962 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_condition_in_join_table2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRAIGHT_JOIN_in_join_table2996 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_atom_in_join_table2998 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_ON_in_join_table3001 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_join_table3003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_qualifier2_in_join_table3011 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L,0x0000000001000000L});
    public static final BitSet FOLLOW_OUTER_in_join_table3015 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_JOIN_SYM_in_join_table3019 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_atom_in_join_table3021 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_join_condition_in_join_table3023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NATURAL_in_join_table3053 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020001L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_join_table3057 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L,0x0000000001000000L});
    public static final BitSet FOLLOW_OUTER_in_join_table3064 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_JOIN_SYM_in_join_table3071 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_atom_in_join_table3073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_join_qualifier10 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_join_qualifier20 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_spec_in_table_atom3109 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000000L,0x0000000000000000L,0x0000100000000800L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_table_atom3112 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000100000000800L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_index_hint_list_in_table_atom3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subquery_in_table_atom3135 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_table_atom3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_table_atom3142 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_references_in_table_atom3144 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_table_atom3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ON_in_join_condition3157 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_join_condition3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_SYM_in_join_condition3175 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_column_list_in_join_condition3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_index_hint_in_index_hint_list3186 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_index_hint_list3189 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000800L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_index_hint_in_index_hint_list3191 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_set_in_index_options3201 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_FOR_SYM_in_index_options3212 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000010000000L,0x0000000000000001L,0x0000000000800000L});
    public static final BitSet FOLLOW_JOIN_SYM_in_index_options3216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_SYM_in_index_options3222 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_BY_SYM_in_index_options3224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_SYM_in_index_options3230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_BY_SYM_in_index_options3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_SYM_in_index_hint3248 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_index_options_in_index_hint3253 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_index_hint3255 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100008000000L});
    public static final BitSet FOLLOW_index_list_in_index_hint3258 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_index_hint3262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IGNORE_SYM_in_index_hint3267 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_index_options_in_index_hint3269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_index_hint3271 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_index_list_in_index_hint3273 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_index_hint3275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORCE_SYM_in_index_hint3280 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_index_options_in_index_hint3283 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_index_hint3285 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_index_list_in_index_hint3287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_index_hint3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_index_name_in_index_list3297 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_index_list3300 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_index_name_in_index_list3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_SYM_in_partition_clause3311 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_partition_clause3313 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_partition_names_in_partition_clause3315 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_partition_clause3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partition_name_in_partition_names3324 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_partition_names3327 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_partition_name_in_partition_names3329 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SHIFT_LEFT_in_root_statement3342 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_SHIFT_RIGHT_in_root_statement3345 = new BitSet(new long[]{0x0000040000000000L,0x1000000000000100L,0x000000A010000000L,0x0020000020000000L,0x0000000004000000L,0x2200000000000000L,0x0000000000008000L,0x0000002402000000L});
    public static final BitSet FOLLOW_data_manipulation_statements_in_root_statement3355 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_data_definition_statements_in_root_statement3359 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_SEMI_in_root_statement3365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_root_statement3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_statement_in_data_manipulation_statements3382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delete_statements_in_data_manipulation_statements3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insert_statements_in_data_manipulation_statements3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_update_statements_in_data_manipulation_statements3397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_statement_in_data_manipulation_statements3403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_do_statement_in_data_manipulation_statements3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_handler_statements_in_data_manipulation_statements3413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_data_statement_in_data_manipulation_statements3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_xml_statement_in_data_manipulation_statements3423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_replace_statement_in_data_manipulation_statements3428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_use_statement_in_data_manipulation_statements3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_create_database_statement_in_data_definition_statements3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alter_database_statements_in_data_definition_statements3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_drop_database_statement_in_data_definition_statements3455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_create_event_statement_in_data_definition_statements3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alter_event_statement_in_data_definition_statements3467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_drop_event_statement_in_data_definition_statements3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_create_server_statement_in_data_definition_statements3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alter_server_statement_in_data_definition_statements3484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_drop_server_statement_in_data_definition_statements3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_create_table_statement_in_data_definition_statements3496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alter_table_statement_in_data_definition_statements3501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_drop_table_statement_in_data_definition_statements3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_create_view_statement_in_data_definition_statements3513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alter_view_statement_in_data_definition_statements3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rename_table_statement_in_data_definition_statements3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_drop_view_statement_in_data_definition_statements3528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_truncate_table_statement_in_data_definition_statements3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_create_index_statement_in_data_definition_statements3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_drop_index_statement_in_data_definition_statements3545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_SYM_in_use_statement3555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_schema_name_in_use_statement3557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_expression_in_select_statement3582 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_UNION_SYM_in_select_statement3587 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_ALL_in_select_statement3590 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_select_expression_in_select_statement3596 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_SELECT_in_select_expression3621 = new BitSet(new long[]{0xF15B023CC0000000L,0x880772C0140B7805L,0xB000C81862CF0BEEL,0xA4A30C160B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x379DE2FD49221DABL,0x0F31D751239C3F81L,0x00021F41C40000B0L});
    public static final BitSet FOLLOW_select_expresssion_cont_in_select_expression3625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_options_in_select_expresssion_cont3644 = new BitSet(new long[]{0xF15B023CC0000000L,0x880772C0140B7805L,0xB000C81862CF0BEEL,0xA4A30C160B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x379DE2FD49221DABL,0x0F31D751239C3F81L,0x00021F41C40000B0L});
    public static final BitSet FOLLOW_select_list_in_select_expresssion_cont3648 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008400L,0x0000000040200000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_select_expression_cont2_in_select_expresssion_cont3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_select_expression_cont23686 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_references_in_select_expression_cont23688 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000090000400L,0x0000000040200000L,0x0000000020800000L,0x0000000000000000L,0x2000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_partition_clause_in_select_expression_cont23694 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000090000400L,0x0000000040200000L,0x0000000000800000L,0x0000000000000000L,0x2000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_where_clause_in_select_expression_cont23703 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000090000400L,0x0000000040200000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_groupby_clause_in_select_expression_cont23713 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000080000400L,0x0000000040200000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_having_clause_in_select_expression_cont23722 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000040200000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_orderby_clause_in_select_expression_cont23736 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000040200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_limit_clause_in_select_expression_cont23744 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000040000000L});
    public static final BitSet FOLLOW_lock_type_in_select_expression_cont23752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_select_options3823 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000400000000L,0x0000000000000000L,0x0000000000000000L,0x000800FC00000000L});
    public static final BitSet FOLLOW_HIGH_PRIORITY_in_select_options3841 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000800FC00000000L});
    public static final BitSet FOLLOW_STRAIGHT_JOIN_in_select_options3847 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000FC00000000L});
    public static final BitSet FOLLOW_SQL_SMALL_RESULT_in_select_options3853 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000007C00000000L});
    public static final BitSet FOLLOW_SQL_BIG_RESULT_in_select_options3858 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_SQL_BUFFER_RESULT_in_select_options3863 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000007000000000L});
    public static final BitSet FOLLOW_set_in_select_options3868 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_SQL_CALC_FOUND_ROWS_in_select_options3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_SYM_in_lock_type3893 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_UPDATE_in_lock_type3895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_lock_type3901 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_IN_SYM_in_lock_type3903 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_SHARE_SYM_in_lock_type3905 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_MODE_SYM_in_lock_type3907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where_clause3918 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_where_clause3921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_SYM_in_groupby_clause3930 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_BY_SYM_in_groupby_clause3932 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_groupby_item_in_groupby_clause3934 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_groupby_clause3937 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_groupby_item_in_groupby_clause3939 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_WITH_in_groupby_clause3944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_ROLLUP_SYM_in_groupby_clause3946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_spec_in_groupby_item3967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_groupby_item3971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_groupby_item3975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HAVING_in_having_clause3984 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_having_clause3987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_SYM_in_orderby_clause3996 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_BY_SYM_in_orderby_clause3998 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_orderby_item_in_orderby_clause4000 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_orderby_clause4003 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_orderby_item_in_orderby_clause4005 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_groupby_item_in_orderby_item4025 = new BitSet(new long[]{0x0000800000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_set_in_orderby_item4027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause4043 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_offset_in_limit_clause4048 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_limit_clause4050 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_row_count_in_limit_clause4054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_row_count_in_limit_clause4060 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_OFFSET_SYM_in_limit_clause4062 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_offset_in_limit_clause4064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_offset4073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_row_count4080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_displayed_column_in_select_list4089 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_select_list4092 = new BitSet(new long[]{0xF15B023CC0000000L,0x880772C0140B7805L,0xB000C81862CF0BEEL,0xA4A30C160B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x379DE2FD49221DABL,0x0F31D751239C3F81L,0x00021F41C40000B0L});
    public static final BitSet FOLLOW_displayed_column_in_select_list4094 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_column_list4114 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_column_spec_in_column_list4116 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_column_list4119 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_column_spec_in_column_list4121 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_column_list4125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_subquery4134 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_select_statement_in_subquery4136 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_subquery4138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_schema_name_in_table_spec4157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_DOT_in_table_spec4159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_name_in_table_spec4164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_name_in_displayed_column4188 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_DOT_in_displayed_column4190 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_column_name_in_displayed_column4192 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_displayed_column4195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_name_in_displayed_column4219 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_displayed_column4222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_spec_in_displayed_column4242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000C4000200L});
    public static final BitSet FOLLOW_column_op_in_displayed_column4245 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_column_spec_in_displayed_column4247 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00001000C4000200L});
    public static final BitSet FOLLOW_alias_in_displayed_column4252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASTERISK_in_displayed_column4279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_name_in_displayed_column4292 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_ALL_FIELDS_in_displayed_column4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_displayed_column4309 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_displayed_column4312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_spec_in_displayed_column4332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000C4000200L});
    public static final BitSet FOLLOW_column_op_in_displayed_column4334 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_simple_expr_in_displayed_column4336 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_displayed_column4339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_column_op0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_SYM_in_delete_statements4369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000008000L,0x0000001000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_delete_expression_in_delete_statements4371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOW_PRIORITY_in_delete_expression4388 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000008000L,0x0000001000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_QUICK_in_delete_expression4393 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000008000L,0x0000001000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_IGNORE_SYM_in_delete_expression4398 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000008000L,0x0000001000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_delete_single_table_statement_in_delete_expression4405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delete_multiple_table_statement1_in_delete_expression4415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delete_multiple_table_statement2_in_delete_expression4425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_delete_single_table_statement4444 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_spec_in_delete_single_table_statement4446 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000020800000L,0x0000000000000000L,0x2000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_partition_clause_in_delete_single_table_statement4450 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000800000L,0x0000000000000000L,0x2000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_where_clause_in_delete_single_table_statement4456 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_orderby_clause_in_delete_single_table_statement4462 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_limit_clause_in_delete_single_table_statement4468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_spec_in_delete_multiple_table_statement14485 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002200000L});
    public static final BitSet FOLLOW_ALL_FIELDS_in_delete_multiple_table_statement14488 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_delete_multiple_table_statement14494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_spec_in_delete_multiple_table_statement14497 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002200000L});
    public static final BitSet FOLLOW_ALL_FIELDS_in_delete_multiple_table_statement14500 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_FROM_in_delete_multiple_table_statement14508 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_references_in_delete_multiple_table_statement14511 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_where_clause_in_delete_multiple_table_statement14515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_delete_multiple_table_statement24526 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_spec_in_delete_multiple_table_statement24529 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000000L,0x0000000002200000L});
    public static final BitSet FOLLOW_ALL_FIELDS_in_delete_multiple_table_statement24532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_delete_multiple_table_statement24538 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_spec_in_delete_multiple_table_statement24541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000000L,0x0000000002200000L});
    public static final BitSet FOLLOW_ALL_FIELDS_in_delete_multiple_table_statement24544 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_USING_SYM_in_delete_multiple_table_statement24552 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_references_in_delete_multiple_table_statement24555 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_where_clause_in_delete_multiple_table_statement24559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_SYM_in_synpred54_MySQL519 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_NATURAL_in_synpred54_MySQL521 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LANGUAGE_in_synpred54_MySQL523 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_MODE_SYM_in_synpred54_MySQL525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_SYM_in_synpred55_MySQL532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_NATURAL_in_synpred55_MySQL534 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LANGUAGE_in_synpred55_MySQL536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_MODE_SYM_in_synpred55_MySQL538 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_WITH_in_synpred55_MySQL540 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_QUERY_SYM_in_synpred55_MySQL542 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_EXPANSION_SYM_in_synpred55_MySQL544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_literal_in_synpred86_MySQL798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_literal_in_synpred87_MySQL802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hex_literal_in_synpred88_MySQL806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_literal_in_synpred89_MySQL810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_literal_in_synpred90_MySQL814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_functions_in_synpred92_MySQL840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_SYM_in_synpred273_MySQL2032 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_exp_factor1_in_synpred273_MySQL2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_XOR_in_synpred274_MySQL2048 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_exp_factor2_in_synpred274_MySQL2050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_SYM_in_synpred275_MySQL2064 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_exp_factor3_in_synpred275_MySQL2066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_SYM_in_synpred276_MySQL2077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_literal_in_synpred278_MySQL2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_SYM_in_synpred279_MySQL2092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L,0x0000000000000000L,0x0000000000000500L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_NOT_SYM_in_synpred279_MySQL2095 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_boolean_literal_in_synpred279_MySQL2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_SYM_in_synpred279_MySQL2102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred280_MySQL2118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000300003C000L});
    public static final BitSet FOLLOW_relational_op_in_synpred280_MySQL2120 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_predicate_in_synpred280_MySQL2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred283_MySQL2132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000300003C000L});
    public static final BitSet FOLLOW_relational_op_in_synpred283_MySQL2134 = new BitSet(new long[]{0x0000120000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_set_in_synpred283_MySQL2136 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_subquery_in_synpred283_MySQL2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_SYM_in_synpred285_MySQL2156 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_EXISTS_in_synpred285_MySQL2159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_subquery_in_synpred285_MySQL2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_synpred288_MySQL2181 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000400000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_synpred288_MySQL2184 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_IN_SYM_in_synpred288_MySQL2188 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_subquery_in_synpred288_MySQL2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_list_in_synpred288_MySQL2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_synpred290_MySQL2205 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_synpred290_MySQL2208 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_synpred290_MySQL2212 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_synpred290_MySQL2214 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_AND_SYM_in_synpred290_MySQL2216 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_predicate_in_synpred290_MySQL2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_synpred291_MySQL2228 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_SOUNDS_SYM_in_synpred291_MySQL2230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LIKE_SYM_in_synpred291_MySQL2232 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_synpred291_MySQL2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESCAPE_SYM_in_synpred293_MySQL2256 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_simple_expr_in_synpred293_MySQL2258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_synpred294_MySQL2244 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_synpred294_MySQL2247 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LIKE_SYM_in_synpred294_MySQL2251 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_simple_expr_in_synpred294_MySQL2253 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_ESCAPE_SYM_in_synpred294_MySQL2256 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_simple_expr_in_synpred294_MySQL2258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_synpred296_MySQL2269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_synpred296_MySQL2272 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_REGEXP_in_synpred296_MySQL2276 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_synpred296_MySQL2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VERTBAR_in_synpred297_MySQL2304 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_factor1_in_synpred297_MySQL2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BITAND_in_synpred298_MySQL2321 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_factor2_in_synpred298_MySQL2323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred300_MySQL2338 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_factor3_in_synpred300_MySQL2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred302_MySQL2359 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_factor4_in_synpred302_MySQL2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred306_MySQL2380 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_factor5_in_synpred306_MySQL2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred308_MySQL2405 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_interval_expr_in_synpred308_MySQL2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred312_MySQL2422 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_simple_expr_in_synpred312_MySQL2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONVERT_SYM_in_synpred328_MySQL2592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_synpred328_MySQL2594 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_synpred328_MySQL2596 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred328_MySQL2598 = new BitSet(new long[]{0x2000000000000000L,0x0000000000010000L,0x0000000000200500L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000400000L,0x0000000200000100L});
    public static final BitSet FOLLOW_cast_data_type_in_synpred328_MySQL2600 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred328_MySQL2602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONVERT_SYM_in_synpred329_MySQL2613 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_synpred329_MySQL2615 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xA4A30C120B07622BL,0x4B84FCE3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_synpred329_MySQL2617 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_USING_SYM_in_synpred329_MySQL2619 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000002000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_transcoding_name_in_synpred329_MySQL2621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred329_MySQL2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_search_modifier_in_synpred342_MySQL2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_options_in_synpred406_MySQL3644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_expression_cont2_in_synpred407_MySQL3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_spec_in_synpred430_MySQL3967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_synpred431_MySQL3971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_name_in_synpred443_MySQL4219 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_synpred443_MySQL4222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_spec_in_synpred446_MySQL4242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000C4000200L});
    public static final BitSet FOLLOW_column_op_in_synpred446_MySQL4245 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_column_spec_in_synpred446_MySQL4247 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00001000C4000200L});
    public static final BitSet FOLLOW_alias_in_synpred446_MySQL4252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_synpred450_MySQL4309 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_synpred450_MySQL4312 = new BitSet(new long[]{0x0000000000000002L});

}