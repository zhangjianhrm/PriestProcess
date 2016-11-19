// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SQLParser1.g 2013-11-29 14:34:07
package com.lenovo.lps.farseer.priest2.platform.util.antlr;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

@SuppressWarnings("unused")
public class MySQL_SQLParser1 extends Parser {
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
    // delegators
    public MySQLParser gMySQL;
    public MySQLParser gParent;


        public MySQL_SQLParser1(TokenStream input, MySQLParser gMySQL) {
            this(input, new RecognizerSharedState(), gMySQL);
        }
        public MySQL_SQLParser1(TokenStream input, RecognizerSharedState state, MySQLParser gMySQL) {
            super(input, state);
            this.gMySQL = gMySQL;
             
            gParent = gMySQL;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return MySQLParser.tokenNames; }
    public String getGrammarFileName() { return "SQLParser1.g"; }


    public static class insert_statements_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insert_statements"
    // SQLParser1.g:10:1: insert_statements : ( insert_statement1 | insert_statement2 | insert_statement3 );
    public final MySQL_SQLParser1.insert_statements_return insert_statements() throws RecognitionException {
        MySQL_SQLParser1.insert_statements_return retval = new MySQL_SQLParser1.insert_statements_return();
        retval.start = input.LT(1);
        int insert_statements_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQL_SQLParser1.insert_statement1_return insert_statement11 = null;

        MySQL_SQLParser1.insert_statement2_return insert_statement22 = null;

        MySQL_SQLParser1.insert_statement3_return insert_statement33 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // SQLParser1.g:10:19: ( insert_statement1 | insert_statement2 | insert_statement3 )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // SQLParser1.g:11:2: insert_statement1
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_insert_statement1_in_insert_statements20);
                    insert_statement11=insert_statement1();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, insert_statement11.getTree());

                    }
                    break;
                case 2 :
                    // SQLParser1.g:11:22: insert_statement2
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_insert_statement2_in_insert_statements24);
                    insert_statement22=insert_statement2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, insert_statement22.getTree());

                    }
                    break;
                case 3 :
                    // SQLParser1.g:11:42: insert_statement3
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_insert_statement3_in_insert_statements28);
                    insert_statement33=insert_statement3();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, insert_statement33.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 1, insert_statements_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "insert_statements"

    public static class insert_header_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insert_header"
    // SQLParser1.g:14:1: insert_header : INSERT insert_expression -> ^( TN_INSERT insert_expression ) ;
	public final MySQL_SQLParser1.insert_header_return insert_header() throws RecognitionException {
        MySQL_SQLParser1.insert_header_return retval = new MySQL_SQLParser1.insert_header_return();
        retval.start = input.LT(1);
        int insert_header_StartIndex = input.index();
        CommonTree root_0 = null;

        Token INSERT4=null;
        MySQL_SQLParser1.insert_expression_return insert_expression5 = null;


        CommonTree INSERT4_tree=null;
        RewriteRuleTokenStream stream_INSERT=new RewriteRuleTokenStream(adaptor,"token INSERT");
        RewriteRuleSubtreeStream stream_insert_expression=new RewriteRuleSubtreeStream(adaptor,"rule insert_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // SQLParser1.g:14:14: ( INSERT insert_expression -> ^( TN_INSERT insert_expression ) )
            // SQLParser1.g:15:2: INSERT insert_expression
            {
            INSERT4=(Token)match(input,INSERT,FOLLOW_INSERT_in_insert_header37); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INSERT.add(INSERT4);

            pushFollow(FOLLOW_insert_expression_in_insert_header39);
            insert_expression5=insert_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_insert_expression.add(insert_expression5.getTree());


            // AST REWRITE
            // elements: insert_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 15:26: -> ^( TN_INSERT insert_expression )
            {
                // SQLParser1.g:15:29: ^( TN_INSERT insert_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_INSERT, "TN_INSERT"), root_1);

                adaptor.addChild(root_1, stream_insert_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 2, insert_header_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "insert_header"

    public static class insert_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insert_expression"
    // SQLParser1.g:18:1: insert_expression : ( LOW_PRIORITY | HIGH_PRIORITY )? ( IGNORE_SYM )? ( INTO )? table_spec ( partition_clause )? ;
	public final MySQL_SQLParser1.insert_expression_return insert_expression() throws RecognitionException {
        MySQL_SQLParser1.insert_expression_return retval = new MySQL_SQLParser1.insert_expression_return();
        retval.start = input.LT(1);
        int insert_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set6=null;
        Token IGNORE_SYM7=null;
        Token INTO8=null;
        MySQLParser.table_spec_return table_spec9 = null;

        MySQLParser.partition_clause_return partition_clause10 = null;


        CommonTree set6_tree=null;
        CommonTree IGNORE_SYM7_tree=null;
        CommonTree INTO8_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // SQLParser1.g:18:18: ( ( LOW_PRIORITY | HIGH_PRIORITY )? ( IGNORE_SYM )? ( INTO )? table_spec ( partition_clause )? )
            // SQLParser1.g:19:2: ( LOW_PRIORITY | HIGH_PRIORITY )? ( IGNORE_SYM )? ( INTO )? table_spec ( partition_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:19:2: ( LOW_PRIORITY | HIGH_PRIORITY )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==HIGH_PRIORITY||LA2_0==LOW_PRIORITY) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // SQLParser1.g:
                    {
                    set6=(Token)input.LT(1);
                    if ( input.LA(1)==HIGH_PRIORITY||input.LA(1)==LOW_PRIORITY ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set6));
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

            // SQLParser1.g:19:34: ( IGNORE_SYM )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IGNORE_SYM) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // SQLParser1.g:19:35: IGNORE_SYM
                    {
                    IGNORE_SYM7=(Token)match(input,IGNORE_SYM,FOLLOW_IGNORE_SYM_in_insert_expression65); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IGNORE_SYM7_tree = (CommonTree)adaptor.create(IGNORE_SYM7);
                    adaptor.addChild(root_0, IGNORE_SYM7_tree);
                    }

                    }
                    break;

            }

            // SQLParser1.g:20:2: ( INTO )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==INTO) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // SQLParser1.g:20:3: INTO
                    {
                    INTO8=(Token)match(input,INTO,FOLLOW_INTO_in_insert_expression71); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO8_tree = (CommonTree)adaptor.create(INTO8);
                    adaptor.addChild(root_0, INTO8_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_table_spec_in_insert_expression75);
            table_spec9=gMySQL.table_spec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_spec9.getTree());
            // SQLParser1.g:21:2: ( partition_clause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PARTITION_SYM) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // SQLParser1.g:21:3: partition_clause
                    {
                    pushFollow(FOLLOW_partition_clause_in_insert_expression80);
                    partition_clause10=gMySQL.partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, partition_clause10.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 3, insert_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "insert_expression"

    public static class insert_subfix_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insert_subfix"
    // SQLParser1.g:24:1: insert_subfix : ON DUPLICATE_SYM KEY_SYM UPDATE column_spec EQ_SYM expression ( COMMA column_spec EQ_SYM expression )* ;
    public final MySQL_SQLParser1.insert_subfix_return insert_subfix() throws RecognitionException {
        MySQL_SQLParser1.insert_subfix_return retval = new MySQL_SQLParser1.insert_subfix_return();
        retval.start = input.LT(1);
        int insert_subfix_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ON11=null;
        Token DUPLICATE_SYM12=null;
        Token KEY_SYM13=null;
        Token UPDATE14=null;
        Token EQ_SYM16=null;
        Token COMMA18=null;
        Token EQ_SYM20=null;
        MySQLParser.column_spec_return column_spec15 = null;

        MySQLParser.expression_return expression17 = null;

        MySQLParser.column_spec_return column_spec19 = null;

        MySQLParser.expression_return expression21 = null;


        CommonTree ON11_tree=null;
        CommonTree DUPLICATE_SYM12_tree=null;
        CommonTree KEY_SYM13_tree=null;
        CommonTree UPDATE14_tree=null;
        CommonTree EQ_SYM16_tree=null;
        CommonTree COMMA18_tree=null;
        CommonTree EQ_SYM20_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // SQLParser1.g:24:14: ( ON DUPLICATE_SYM KEY_SYM UPDATE column_spec EQ_SYM expression ( COMMA column_spec EQ_SYM expression )* )
            // SQLParser1.g:25:2: ON DUPLICATE_SYM KEY_SYM UPDATE column_spec EQ_SYM expression ( COMMA column_spec EQ_SYM expression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            ON11=(Token)match(input,ON,FOLLOW_ON_in_insert_subfix92); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ON11_tree = (CommonTree)adaptor.create(ON11);
            adaptor.addChild(root_0, ON11_tree);
            }
            DUPLICATE_SYM12=(Token)match(input,DUPLICATE_SYM,FOLLOW_DUPLICATE_SYM_in_insert_subfix94); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DUPLICATE_SYM12_tree = (CommonTree)adaptor.create(DUPLICATE_SYM12);
            adaptor.addChild(root_0, DUPLICATE_SYM12_tree);
            }
            KEY_SYM13=(Token)match(input,KEY_SYM,FOLLOW_KEY_SYM_in_insert_subfix96); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_SYM13_tree = (CommonTree)adaptor.create(KEY_SYM13);
            adaptor.addChild(root_0, KEY_SYM13_tree);
            }
            UPDATE14=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_insert_subfix98); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPDATE14_tree = (CommonTree)adaptor.create(UPDATE14);
            adaptor.addChild(root_0, UPDATE14_tree);
            }
            pushFollow(FOLLOW_column_spec_in_insert_subfix100);
            column_spec15=gMySQL.column_spec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec15.getTree());
            EQ_SYM16=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_insert_subfix102); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EQ_SYM16_tree = (CommonTree)adaptor.create(EQ_SYM16);
            adaptor.addChild(root_0, EQ_SYM16_tree);
            }
            pushFollow(FOLLOW_expression_in_insert_subfix104);
            expression17=gMySQL.expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression17.getTree());
            // SQLParser1.g:25:64: ( COMMA column_spec EQ_SYM expression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // SQLParser1.g:25:65: COMMA column_spec EQ_SYM expression
            	    {
            	    COMMA18=(Token)match(input,COMMA,FOLLOW_COMMA_in_insert_subfix107); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA18_tree = (CommonTree)adaptor.create(COMMA18);
            	    adaptor.addChild(root_0, COMMA18_tree);
            	    }
            	    pushFollow(FOLLOW_column_spec_in_insert_subfix109);
            	    column_spec19=gMySQL.column_spec();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec19.getTree());
            	    EQ_SYM20=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_insert_subfix111); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    EQ_SYM20_tree = (CommonTree)adaptor.create(EQ_SYM20);
            	    adaptor.addChild(root_0, EQ_SYM20_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_insert_subfix113);
            	    expression21=gMySQL.expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression21.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
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
            if ( state.backtracking>0 ) { memoize(input, 4, insert_subfix_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "insert_subfix"

    public static class insert_statement1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insert_statement1"
    // SQLParser1.g:28:1: insert_statement1 : insert_header ( column_list )? value_list_clause ( insert_subfix )? -> ^( insert_header ) ;
    public final MySQL_SQLParser1.insert_statement1_return insert_statement1() throws RecognitionException {
        MySQL_SQLParser1.insert_statement1_return retval = new MySQL_SQLParser1.insert_statement1_return();
        retval.start = input.LT(1);
        int insert_statement1_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQL_SQLParser1.insert_header_return insert_header22 = null;

        MySQLParser.column_list_return column_list23 = null;

        MySQL_SQLParser1.value_list_clause_return value_list_clause24 = null;

        MySQL_SQLParser1.insert_subfix_return insert_subfix25 = null;


        RewriteRuleSubtreeStream stream_insert_subfix=new RewriteRuleSubtreeStream(adaptor,"rule insert_subfix");
        RewriteRuleSubtreeStream stream_column_list=new RewriteRuleSubtreeStream(adaptor,"rule column_list");
        RewriteRuleSubtreeStream stream_value_list_clause=new RewriteRuleSubtreeStream(adaptor,"rule value_list_clause");
        RewriteRuleSubtreeStream stream_insert_header=new RewriteRuleSubtreeStream(adaptor,"rule insert_header");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // SQLParser1.g:28:18: ( insert_header ( column_list )? value_list_clause ( insert_subfix )? -> ^( insert_header ) )
            // SQLParser1.g:29:2: insert_header ( column_list )? value_list_clause ( insert_subfix )?
            {
            pushFollow(FOLLOW_insert_header_in_insert_statement1124);
            insert_header22=insert_header();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_insert_header.add(insert_header22.getTree());
            // SQLParser1.g:30:2: ( column_list )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LPAREN) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // SQLParser1.g:30:3: column_list
                    {
                    pushFollow(FOLLOW_column_list_in_insert_statement1128);
                    column_list23=gMySQL.column_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_column_list.add(column_list23.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_value_list_clause_in_insert_statement1134);
            value_list_clause24=value_list_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value_list_clause.add(value_list_clause24.getTree());
            // SQLParser1.g:32:2: ( insert_subfix )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ON) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // SQLParser1.g:32:4: insert_subfix
                    {
                    pushFollow(FOLLOW_insert_subfix_in_insert_statement1139);
                    insert_subfix25=insert_subfix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_insert_subfix.add(insert_subfix25.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: insert_header
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 33:2: -> ^( insert_header )
            {
                // SQLParser1.g:33:5: ^( insert_header )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_insert_header.nextNode(), root_1);

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
            if ( state.backtracking>0 ) { memoize(input, 5, insert_statement1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "insert_statement1"

    public static class value_list_clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value_list_clause"
    // SQLParser1.g:35:1: value_list_clause : ( VALUES | VALUE_SYM ) column_value_list ( COMMA column_value_list )* ;
    public final MySQL_SQLParser1.value_list_clause_return value_list_clause() throws RecognitionException {
        MySQL_SQLParser1.value_list_clause_return retval = new MySQL_SQLParser1.value_list_clause_return();
        retval.start = input.LT(1);
        int value_list_clause_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set26=null;
        Token COMMA28=null;
        MySQL_SQLParser1.column_value_list_return column_value_list27 = null;

        MySQL_SQLParser1.column_value_list_return column_value_list29 = null;


        CommonTree set26_tree=null;
        CommonTree COMMA28_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // SQLParser1.g:35:18: ( ( VALUES | VALUE_SYM ) column_value_list ( COMMA column_value_list )* )
            // SQLParser1.g:35:20: ( VALUES | VALUE_SYM ) column_value_list ( COMMA column_value_list )*
            {
            root_0 = (CommonTree)adaptor.nil();

            set26=(Token)input.LT(1);
            if ( (input.LA(1)>=VALUE_SYM && input.LA(1)<=VALUES) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set26));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_column_value_list_in_value_list_clause164);
            column_value_list27=column_value_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column_value_list27.getTree());
            // SQLParser1.g:35:59: ( COMMA column_value_list )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMMA) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // SQLParser1.g:35:60: COMMA column_value_list
            	    {
            	    COMMA28=(Token)match(input,COMMA,FOLLOW_COMMA_in_value_list_clause167); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA28_tree = (CommonTree)adaptor.create(COMMA28);
            	    adaptor.addChild(root_0, COMMA28_tree);
            	    }
            	    pushFollow(FOLLOW_column_value_list_in_value_list_clause169);
            	    column_value_list29=column_value_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_value_list29.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
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
            if ( state.backtracking>0 ) { memoize(input, 6, value_list_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "value_list_clause"

    public static class column_value_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "column_value_list"
    // SQLParser1.g:36:1: column_value_list : LPAREN ( bit_expr | DEFAULT ) ( COMMA ( bit_expr | DEFAULT ) )* RPAREN ;
    public final MySQL_SQLParser1.column_value_list_return column_value_list() throws RecognitionException {
        MySQL_SQLParser1.column_value_list_return retval = new MySQL_SQLParser1.column_value_list_return();
        retval.start = input.LT(1);
        int column_value_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LPAREN30=null;
        Token DEFAULT32=null;
        Token COMMA33=null;
        Token DEFAULT35=null;
        Token RPAREN36=null;
        MySQLParser.bit_expr_return bit_expr31 = null;

        MySQLParser.bit_expr_return bit_expr34 = null;


        CommonTree LPAREN30_tree=null;
        CommonTree DEFAULT32_tree=null;
        CommonTree COMMA33_tree=null;
        CommonTree DEFAULT35_tree=null;
        CommonTree RPAREN36_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // SQLParser1.g:36:18: ( LPAREN ( bit_expr | DEFAULT ) ( COMMA ( bit_expr | DEFAULT ) )* RPAREN )
            // SQLParser1.g:36:20: LPAREN ( bit_expr | DEFAULT ) ( COMMA ( bit_expr | DEFAULT ) )* RPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAREN30=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_column_value_list177); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN30_tree = (CommonTree)adaptor.create(LPAREN30);
            adaptor.addChild(root_0, LPAREN30_tree);
            }
            // SQLParser1.g:36:27: ( bit_expr | DEFAULT )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=ABS && LA10_0<=ACOS)||(LA10_0>=ADDDATE && LA10_0<=AES_ENCRYPT)||(LA10_0>=ASCII_SYM && LA10_0<=ASIN)||(LA10_0>=ATAN && LA10_0<=ATAN2)||LA10_0==AVG||LA10_0==BENCHMARK||(LA10_0>=BIN && LA10_0<=BIT_OR)||LA10_0==BIT_XOR||(LA10_0>=CASE_SYM && LA10_0<=CEILING)||(LA10_0>=CHAR && LA10_0<=CHAR_LENGTH)||LA10_0==CHARSET||LA10_0==COERCIBILITY||LA10_0==COLLATION||(LA10_0>=CONCAT && LA10_0<=CONCAT_WS)||LA10_0==CONNECTION_ID||(LA10_0>=CONV && LA10_0<=CONVERT_TZ)||(LA10_0>=COS && LA10_0<=COUNT)||LA10_0==CRC32||LA10_0==CURDATE||(LA10_0>=CURRENT_USER && LA10_0<=DATABASE)||(LA10_0>=DATE_ADD && LA10_0<=DATEDIFF)||LA10_0==DAY_SYM||(LA10_0>=DAYNAME && LA10_0<=DAYOFYEAR)||LA10_0==DECODE||LA10_0==DEGREES||(LA10_0>=DES_DECRYPT && LA10_0<=DES_ENCRYPT)||LA10_0==ELT||(LA10_0>=ENCODE && LA10_0<=ENCRYPT)||(LA10_0>=EXISTS && LA10_0<=EXP)||(LA10_0>=EXPORT_SET && LA10_0<=FALSE_SYM)||LA10_0==FIELD||LA10_0==FIND_IN_SET||LA10_0==FLOOR||(LA10_0>=FORMAT && LA10_0<=FOUND_ROWS)||(LA10_0>=FROM_BASE64 && LA10_0<=FROM_UNIXTIME)||(LA10_0>=GET_FORMAT && LA10_0<=GET_LOCK)||LA10_0==GROUP_CONCAT||LA10_0==HEX||LA10_0==HOUR||(LA10_0>=IF && LA10_0<=IFNULL)||(LA10_0>=INET_ATON && LA10_0<=INET_NTOA)||LA10_0==INSERT||LA10_0==INSTR||LA10_0==INTERVAL_SYM||LA10_0==IS_FREE_LOCK||LA10_0==IS_USED_LOCK||(LA10_0>=LAST_DAY && LA10_0<=LAST_INSERT_ID)||(LA10_0>=LEFT && LA10_0<=LENGTH)||LA10_0==LN||LA10_0==LOAD_FILE||LA10_0==LOCATE||(LA10_0>=LOG && LA10_0<=LOG2)||(LA10_0>=LOWER && LA10_0<=LTRIM)||(LA10_0>=MAKE_SET && LA10_0<=MAX_SYM)||LA10_0==MD5||(LA10_0>=MICROSECOND && LA10_0<=MIN_SYM)||LA10_0==MINUTE||LA10_0==MOD||(LA10_0>=MONTH && LA10_0<=NAME_CONST)||(LA10_0>=NOW && LA10_0<=NULL_SYM)||LA10_0==OCT||LA10_0==OLD_PASSWORD||LA10_0==ORD||(LA10_0>=PASSWORD && LA10_0<=PI)||(LA10_0>=POW && LA10_0<=POWER)||LA10_0==QUARTER||(LA10_0>=QUOTE && LA10_0<=RAND)||LA10_0==RELEASE_LOCK||(LA10_0>=REPEAT && LA10_0<=REPLACE)||(LA10_0>=REVERSE && LA10_0<=RIGHT)||LA10_0==ROUND||LA10_0==ROW_SYM||(LA10_0>=RPAD && LA10_0<=RTRIM)||(LA10_0>=SCHEMA && LA10_0<=SECOND)||LA10_0==SESSION_USER||LA10_0==SIGN||LA10_0==SIN||LA10_0==SLEEP||LA10_0==SOUNDEX||LA10_0==SPACE||LA10_0==SQRT||(LA10_0>=STD && LA10_0<=STDDEV_SAMP)||LA10_0==STR_TO_DATE||LA10_0==STRCMP||(LA10_0>=SUBSTRING && LA10_0<=SUM)||(LA10_0>=SYSDATE && LA10_0<=SYSTEM_USER)||LA10_0==TAN||(LA10_0>=TIME_FORMAT && LA10_0<=TIMESTAMPDIFF)||(LA10_0>=TO_BASE64 && LA10_0<=TO_SECONDS)||(LA10_0>=TRIM && LA10_0<=TRUNCATE)||LA10_0==UNHEX||LA10_0==UNIX_TIMESTAMP||LA10_0==UPPER||LA10_0==USER||(LA10_0>=UTC_DATE && LA10_0<=UTC_TIMESTAMP)||LA10_0==UUID||(LA10_0>=VALUES && LA10_0<=VAR_SAMP)||(LA10_0>=VARIANCE && LA10_0<=VERSION_SYM)||(LA10_0>=WEEK && LA10_0<=WEIGHT_STRING)||(LA10_0>=LPAREN && LA10_0<=YEAR_FUNC)||LA10_0==YEARWEEK||(LA10_0>=PLUS && LA10_0<=NEGATION)||LA10_0==INTEGER_NUM||(LA10_0>=HEX_DIGIT && LA10_0<=ID)||LA10_0==USER_VAR) ) {
                alt10=1;
            }
            else if ( (LA10_0==DEFAULT) ) {
                int LA10_2 = input.LA(2);

                if ( (synpred13_SQLParser1()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // SQLParser1.g:36:28: bit_expr
                    {
                    pushFollow(FOLLOW_bit_expr_in_column_value_list180);
                    bit_expr31=gMySQL.bit_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr31.getTree());

                    }
                    break;
                case 2 :
                    // SQLParser1.g:36:37: DEFAULT
                    {
                    DEFAULT32=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_column_value_list182); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFAULT32_tree = (CommonTree)adaptor.create(DEFAULT32);
                    adaptor.addChild(root_0, DEFAULT32_tree);
                    }

                    }
                    break;

            }

            // SQLParser1.g:36:46: ( COMMA ( bit_expr | DEFAULT ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // SQLParser1.g:36:47: COMMA ( bit_expr | DEFAULT )
            	    {
            	    COMMA33=(Token)match(input,COMMA,FOLLOW_COMMA_in_column_value_list186); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA33_tree = (CommonTree)adaptor.create(COMMA33);
            	    adaptor.addChild(root_0, COMMA33_tree);
            	    }
            	    // SQLParser1.g:36:53: ( bit_expr | DEFAULT )
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( ((LA11_0>=ABS && LA11_0<=ACOS)||(LA11_0>=ADDDATE && LA11_0<=AES_ENCRYPT)||(LA11_0>=ASCII_SYM && LA11_0<=ASIN)||(LA11_0>=ATAN && LA11_0<=ATAN2)||LA11_0==AVG||LA11_0==BENCHMARK||(LA11_0>=BIN && LA11_0<=BIT_OR)||LA11_0==BIT_XOR||(LA11_0>=CASE_SYM && LA11_0<=CEILING)||(LA11_0>=CHAR && LA11_0<=CHAR_LENGTH)||LA11_0==CHARSET||LA11_0==COERCIBILITY||LA11_0==COLLATION||(LA11_0>=CONCAT && LA11_0<=CONCAT_WS)||LA11_0==CONNECTION_ID||(LA11_0>=CONV && LA11_0<=CONVERT_TZ)||(LA11_0>=COS && LA11_0<=COUNT)||LA11_0==CRC32||LA11_0==CURDATE||(LA11_0>=CURRENT_USER && LA11_0<=DATABASE)||(LA11_0>=DATE_ADD && LA11_0<=DATEDIFF)||LA11_0==DAY_SYM||(LA11_0>=DAYNAME && LA11_0<=DAYOFYEAR)||LA11_0==DECODE||LA11_0==DEGREES||(LA11_0>=DES_DECRYPT && LA11_0<=DES_ENCRYPT)||LA11_0==ELT||(LA11_0>=ENCODE && LA11_0<=ENCRYPT)||(LA11_0>=EXISTS && LA11_0<=EXP)||(LA11_0>=EXPORT_SET && LA11_0<=FALSE_SYM)||LA11_0==FIELD||LA11_0==FIND_IN_SET||LA11_0==FLOOR||(LA11_0>=FORMAT && LA11_0<=FOUND_ROWS)||(LA11_0>=FROM_BASE64 && LA11_0<=FROM_UNIXTIME)||(LA11_0>=GET_FORMAT && LA11_0<=GET_LOCK)||LA11_0==GROUP_CONCAT||LA11_0==HEX||LA11_0==HOUR||(LA11_0>=IF && LA11_0<=IFNULL)||(LA11_0>=INET_ATON && LA11_0<=INET_NTOA)||LA11_0==INSERT||LA11_0==INSTR||LA11_0==INTERVAL_SYM||LA11_0==IS_FREE_LOCK||LA11_0==IS_USED_LOCK||(LA11_0>=LAST_DAY && LA11_0<=LAST_INSERT_ID)||(LA11_0>=LEFT && LA11_0<=LENGTH)||LA11_0==LN||LA11_0==LOAD_FILE||LA11_0==LOCATE||(LA11_0>=LOG && LA11_0<=LOG2)||(LA11_0>=LOWER && LA11_0<=LTRIM)||(LA11_0>=MAKE_SET && LA11_0<=MAX_SYM)||LA11_0==MD5||(LA11_0>=MICROSECOND && LA11_0<=MIN_SYM)||LA11_0==MINUTE||LA11_0==MOD||(LA11_0>=MONTH && LA11_0<=NAME_CONST)||(LA11_0>=NOW && LA11_0<=NULL_SYM)||LA11_0==OCT||LA11_0==OLD_PASSWORD||LA11_0==ORD||(LA11_0>=PASSWORD && LA11_0<=PI)||(LA11_0>=POW && LA11_0<=POWER)||LA11_0==QUARTER||(LA11_0>=QUOTE && LA11_0<=RAND)||LA11_0==RELEASE_LOCK||(LA11_0>=REPEAT && LA11_0<=REPLACE)||(LA11_0>=REVERSE && LA11_0<=RIGHT)||LA11_0==ROUND||LA11_0==ROW_SYM||(LA11_0>=RPAD && LA11_0<=RTRIM)||(LA11_0>=SCHEMA && LA11_0<=SECOND)||LA11_0==SESSION_USER||LA11_0==SIGN||LA11_0==SIN||LA11_0==SLEEP||LA11_0==SOUNDEX||LA11_0==SPACE||LA11_0==SQRT||(LA11_0>=STD && LA11_0<=STDDEV_SAMP)||LA11_0==STR_TO_DATE||LA11_0==STRCMP||(LA11_0>=SUBSTRING && LA11_0<=SUM)||(LA11_0>=SYSDATE && LA11_0<=SYSTEM_USER)||LA11_0==TAN||(LA11_0>=TIME_FORMAT && LA11_0<=TIMESTAMPDIFF)||(LA11_0>=TO_BASE64 && LA11_0<=TO_SECONDS)||(LA11_0>=TRIM && LA11_0<=TRUNCATE)||LA11_0==UNHEX||LA11_0==UNIX_TIMESTAMP||LA11_0==UPPER||LA11_0==USER||(LA11_0>=UTC_DATE && LA11_0<=UTC_TIMESTAMP)||LA11_0==UUID||(LA11_0>=VALUES && LA11_0<=VAR_SAMP)||(LA11_0>=VARIANCE && LA11_0<=VERSION_SYM)||(LA11_0>=WEEK && LA11_0<=WEIGHT_STRING)||(LA11_0>=LPAREN && LA11_0<=YEAR_FUNC)||LA11_0==YEARWEEK||(LA11_0>=PLUS && LA11_0<=NEGATION)||LA11_0==INTEGER_NUM||(LA11_0>=HEX_DIGIT && LA11_0<=ID)||LA11_0==USER_VAR) ) {
            	        alt11=1;
            	    }
            	    else if ( (LA11_0==DEFAULT) ) {
            	        int LA11_2 = input.LA(2);

            	        if ( (synpred14_SQLParser1()) ) {
            	            alt11=1;
            	        }
            	        else if ( (true) ) {
            	            alt11=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return retval;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 11, 2, input);

            	            throw nvae;
            	        }
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // SQLParser1.g:36:54: bit_expr
            	            {
            	            pushFollow(FOLLOW_bit_expr_in_column_value_list189);
            	            bit_expr34=gMySQL.bit_expr();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr34.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // SQLParser1.g:36:63: DEFAULT
            	            {
            	            DEFAULT35=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_column_value_list191); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DEFAULT35_tree = (CommonTree)adaptor.create(DEFAULT35);
            	            adaptor.addChild(root_0, DEFAULT35_tree);
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            RPAREN36=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_column_value_list197); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN36_tree = (CommonTree)adaptor.create(RPAREN36);
            adaptor.addChild(root_0, RPAREN36_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 7, column_value_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "column_value_list"

    public static class insert_statement2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insert_statement2"
    // SQLParser1.g:38:1: insert_statement2 : insert_header set_columns_cluase ( insert_subfix )? -> ^( insert_header ) ;
    public final MySQL_SQLParser1.insert_statement2_return insert_statement2() throws RecognitionException {
        MySQL_SQLParser1.insert_statement2_return retval = new MySQL_SQLParser1.insert_statement2_return();
        retval.start = input.LT(1);
        int insert_statement2_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQL_SQLParser1.insert_header_return insert_header37 = null;

        MySQL_SQLParser1.set_columns_cluase_return set_columns_cluase38 = null;

        MySQL_SQLParser1.insert_subfix_return insert_subfix39 = null;


        RewriteRuleSubtreeStream stream_insert_subfix=new RewriteRuleSubtreeStream(adaptor,"rule insert_subfix");
        RewriteRuleSubtreeStream stream_set_columns_cluase=new RewriteRuleSubtreeStream(adaptor,"rule set_columns_cluase");
        RewriteRuleSubtreeStream stream_insert_header=new RewriteRuleSubtreeStream(adaptor,"rule insert_header");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // SQLParser1.g:38:18: ( insert_header set_columns_cluase ( insert_subfix )? -> ^( insert_header ) )
            // SQLParser1.g:39:2: insert_header set_columns_cluase ( insert_subfix )?
            {
            pushFollow(FOLLOW_insert_header_in_insert_statement2206);
            insert_header37=insert_header();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_insert_header.add(insert_header37.getTree());
            pushFollow(FOLLOW_set_columns_cluase_in_insert_statement2209);
            set_columns_cluase38=set_columns_cluase();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_set_columns_cluase.add(set_columns_cluase38.getTree());
            // SQLParser1.g:41:2: ( insert_subfix )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ON) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // SQLParser1.g:41:4: insert_subfix
                    {
                    pushFollow(FOLLOW_insert_subfix_in_insert_statement2214);
                    insert_subfix39=insert_subfix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_insert_subfix.add(insert_subfix39.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: insert_header
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 42:2: -> ^( insert_header )
            {
                // SQLParser1.g:42:5: ^( insert_header )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_insert_header.nextNode(), root_1);

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
            if ( state.backtracking>0 ) { memoize(input, 8, insert_statement2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "insert_statement2"

    public static class set_columns_cluase_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "set_columns_cluase"
    // SQLParser1.g:44:1: set_columns_cluase : SET_SYM set_column_cluase ( COMMA set_column_cluase )* ;
    public final MySQL_SQLParser1.set_columns_cluase_return set_columns_cluase() throws RecognitionException {
        MySQL_SQLParser1.set_columns_cluase_return retval = new MySQL_SQLParser1.set_columns_cluase_return();
        retval.start = input.LT(1);
        int set_columns_cluase_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SET_SYM40=null;
        Token COMMA42=null;
        MySQL_SQLParser1.set_column_cluase_return set_column_cluase41 = null;

        MySQL_SQLParser1.set_column_cluase_return set_column_cluase43 = null;


        CommonTree SET_SYM40_tree=null;
        CommonTree COMMA42_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // SQLParser1.g:44:19: ( SET_SYM set_column_cluase ( COMMA set_column_cluase )* )
            // SQLParser1.g:44:21: SET_SYM set_column_cluase ( COMMA set_column_cluase )*
            {
            root_0 = (CommonTree)adaptor.nil();

            SET_SYM40=(Token)match(input,SET_SYM,FOLLOW_SET_SYM_in_set_columns_cluase231); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SET_SYM40_tree = (CommonTree)adaptor.create(SET_SYM40);
            adaptor.addChild(root_0, SET_SYM40_tree);
            }
            pushFollow(FOLLOW_set_column_cluase_in_set_columns_cluase233);
            set_column_cluase41=set_column_cluase();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, set_column_cluase41.getTree());
            // SQLParser1.g:44:47: ( COMMA set_column_cluase )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==COMMA) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // SQLParser1.g:44:49: COMMA set_column_cluase
            	    {
            	    COMMA42=(Token)match(input,COMMA,FOLLOW_COMMA_in_set_columns_cluase237); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA42_tree = (CommonTree)adaptor.create(COMMA42);
            	    adaptor.addChild(root_0, COMMA42_tree);
            	    }
            	    pushFollow(FOLLOW_set_column_cluase_in_set_columns_cluase239);
            	    set_column_cluase43=set_column_cluase();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_column_cluase43.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
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
            if ( state.backtracking>0 ) { memoize(input, 9, set_columns_cluase_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "set_columns_cluase"

    public static class set_column_cluase_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "set_column_cluase"
    // SQLParser1.g:45:1: set_column_cluase : column_spec EQ_SYM ( expression | DEFAULT ) ;
    public final MySQL_SQLParser1.set_column_cluase_return set_column_cluase() throws RecognitionException {
        MySQL_SQLParser1.set_column_cluase_return retval = new MySQL_SQLParser1.set_column_cluase_return();
        retval.start = input.LT(1);
        int set_column_cluase_StartIndex = input.index();
        CommonTree root_0 = null;

        Token EQ_SYM45=null;
        Token DEFAULT47=null;
        MySQLParser.column_spec_return column_spec44 = null;

        MySQLParser.expression_return expression46 = null;


        CommonTree EQ_SYM45_tree=null;
        CommonTree DEFAULT47_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // SQLParser1.g:45:18: ( column_spec EQ_SYM ( expression | DEFAULT ) )
            // SQLParser1.g:45:20: column_spec EQ_SYM ( expression | DEFAULT )
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_column_spec_in_set_column_cluase248);
            column_spec44=gMySQL.column_spec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec44.getTree());
            EQ_SYM45=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_set_column_cluase250); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EQ_SYM45_tree = (CommonTree)adaptor.create(EQ_SYM45);
            adaptor.addChild(root_0, EQ_SYM45_tree);
            }
            // SQLParser1.g:45:39: ( expression | DEFAULT )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=ABS && LA15_0<=ACOS)||(LA15_0>=ADDDATE && LA15_0<=AES_ENCRYPT)||(LA15_0>=ASCII_SYM && LA15_0<=ASIN)||(LA15_0>=ATAN && LA15_0<=ATAN2)||LA15_0==AVG||LA15_0==BENCHMARK||(LA15_0>=BIN && LA15_0<=BIT_OR)||LA15_0==BIT_XOR||(LA15_0>=CASE_SYM && LA15_0<=CEILING)||(LA15_0>=CHAR && LA15_0<=CHAR_LENGTH)||LA15_0==CHARSET||LA15_0==COERCIBILITY||LA15_0==COLLATION||(LA15_0>=CONCAT && LA15_0<=CONCAT_WS)||LA15_0==CONNECTION_ID||(LA15_0>=CONV && LA15_0<=CONVERT_TZ)||(LA15_0>=COS && LA15_0<=COUNT)||LA15_0==CRC32||LA15_0==CURDATE||(LA15_0>=CURRENT_USER && LA15_0<=DATABASE)||(LA15_0>=DATE_ADD && LA15_0<=DATEDIFF)||LA15_0==DAY_SYM||(LA15_0>=DAYNAME && LA15_0<=DAYOFYEAR)||LA15_0==DECODE||LA15_0==DEGREES||(LA15_0>=DES_DECRYPT && LA15_0<=DES_ENCRYPT)||LA15_0==ELT||(LA15_0>=ENCODE && LA15_0<=ENCRYPT)||(LA15_0>=EXISTS && LA15_0<=EXP)||(LA15_0>=EXPORT_SET && LA15_0<=FALSE_SYM)||LA15_0==FIELD||LA15_0==FIND_IN_SET||LA15_0==FLOOR||(LA15_0>=FORMAT && LA15_0<=FOUND_ROWS)||(LA15_0>=FROM_BASE64 && LA15_0<=FROM_UNIXTIME)||(LA15_0>=GET_FORMAT && LA15_0<=GET_LOCK)||LA15_0==GROUP_CONCAT||LA15_0==HEX||LA15_0==HOUR||(LA15_0>=IF && LA15_0<=IFNULL)||(LA15_0>=INET_ATON && LA15_0<=INET_NTOA)||LA15_0==INSERT||LA15_0==INSTR||LA15_0==INTERVAL_SYM||LA15_0==IS_FREE_LOCK||LA15_0==IS_USED_LOCK||(LA15_0>=LAST_DAY && LA15_0<=LAST_INSERT_ID)||(LA15_0>=LEFT && LA15_0<=LENGTH)||LA15_0==LN||LA15_0==LOAD_FILE||LA15_0==LOCATE||(LA15_0>=LOG && LA15_0<=LOG2)||(LA15_0>=LOWER && LA15_0<=LTRIM)||(LA15_0>=MAKE_SET && LA15_0<=MAX_SYM)||LA15_0==MD5||(LA15_0>=MICROSECOND && LA15_0<=MIN_SYM)||LA15_0==MINUTE||LA15_0==MOD||(LA15_0>=MONTH && LA15_0<=NAME_CONST)||(LA15_0>=NOT_SYM && LA15_0<=NULL_SYM)||LA15_0==OCT||LA15_0==OLD_PASSWORD||LA15_0==ORD||(LA15_0>=PASSWORD && LA15_0<=PI)||(LA15_0>=POW && LA15_0<=POWER)||LA15_0==QUARTER||(LA15_0>=QUOTE && LA15_0<=RAND)||LA15_0==RELEASE_LOCK||(LA15_0>=REPEAT && LA15_0<=REPLACE)||(LA15_0>=REVERSE && LA15_0<=RIGHT)||LA15_0==ROUND||LA15_0==ROW_SYM||(LA15_0>=RPAD && LA15_0<=RTRIM)||(LA15_0>=SCHEMA && LA15_0<=SECOND)||LA15_0==SESSION_USER||LA15_0==SIGN||LA15_0==SIN||LA15_0==SLEEP||LA15_0==SOUNDEX||LA15_0==SPACE||LA15_0==SQRT||(LA15_0>=STD && LA15_0<=STDDEV_SAMP)||LA15_0==STR_TO_DATE||LA15_0==STRCMP||(LA15_0>=SUBSTRING && LA15_0<=SUM)||(LA15_0>=SYSDATE && LA15_0<=SYSTEM_USER)||LA15_0==TAN||(LA15_0>=TIME_FORMAT && LA15_0<=TIMESTAMPDIFF)||(LA15_0>=TO_BASE64 && LA15_0<=TO_SECONDS)||(LA15_0>=TRIM && LA15_0<=TRUNCATE)||LA15_0==UNHEX||LA15_0==UNIX_TIMESTAMP||LA15_0==UPPER||LA15_0==USER||(LA15_0>=UTC_DATE && LA15_0<=UTC_TIMESTAMP)||LA15_0==UUID||(LA15_0>=VALUES && LA15_0<=VAR_SAMP)||(LA15_0>=VARIANCE && LA15_0<=VERSION_SYM)||(LA15_0>=WEEK && LA15_0<=WEIGHT_STRING)||(LA15_0>=LPAREN && LA15_0<=YEAR_FUNC)||LA15_0==YEARWEEK||(LA15_0>=PLUS && LA15_0<=NEGATION)||LA15_0==INTEGER_NUM||(LA15_0>=HEX_DIGIT && LA15_0<=ID)||LA15_0==USER_VAR) ) {
                alt15=1;
            }
            else if ( (LA15_0==DEFAULT) ) {
                int LA15_2 = input.LA(2);

                if ( (synpred18_SQLParser1()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // SQLParser1.g:45:40: expression
                    {
                    pushFollow(FOLLOW_expression_in_set_column_cluase253);
                    expression46=gMySQL.expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression46.getTree());

                    }
                    break;
                case 2 :
                    // SQLParser1.g:45:51: DEFAULT
                    {
                    DEFAULT47=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_set_column_cluase255); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFAULT47_tree = (CommonTree)adaptor.create(DEFAULT47);
                    adaptor.addChild(root_0, DEFAULT47_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 10, set_column_cluase_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "set_column_cluase"

    public static class insert_statement3_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insert_statement3"
    // SQLParser1.g:47:1: insert_statement3 : insert_header ( column_list )? select_expression ( insert_subfix )? -> ^( insert_header select_expression ) ;
    public final MySQL_SQLParser1.insert_statement3_return insert_statement3() throws RecognitionException {
        MySQL_SQLParser1.insert_statement3_return retval = new MySQL_SQLParser1.insert_statement3_return();
        retval.start = input.LT(1);
        int insert_statement3_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQL_SQLParser1.insert_header_return insert_header48 = null;

        MySQLParser.column_list_return column_list49 = null;

        MySQLParser.select_expression_return select_expression50 = null;

        MySQL_SQLParser1.insert_subfix_return insert_subfix51 = null;


        RewriteRuleSubtreeStream stream_select_expression=new RewriteRuleSubtreeStream(adaptor,"rule select_expression");
        RewriteRuleSubtreeStream stream_insert_subfix=new RewriteRuleSubtreeStream(adaptor,"rule insert_subfix");
        RewriteRuleSubtreeStream stream_column_list=new RewriteRuleSubtreeStream(adaptor,"rule column_list");
        RewriteRuleSubtreeStream stream_insert_header=new RewriteRuleSubtreeStream(adaptor,"rule insert_header");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // SQLParser1.g:47:18: ( insert_header ( column_list )? select_expression ( insert_subfix )? -> ^( insert_header select_expression ) )
            // SQLParser1.g:48:2: insert_header ( column_list )? select_expression ( insert_subfix )?
            {
            pushFollow(FOLLOW_insert_header_in_insert_statement3265);
            insert_header48=insert_header();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_insert_header.add(insert_header48.getTree());
            // SQLParser1.g:49:2: ( column_list )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LPAREN) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // SQLParser1.g:49:3: column_list
                    {
                    pushFollow(FOLLOW_column_list_in_insert_statement3269);
                    column_list49=gMySQL.column_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_column_list.add(column_list49.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_select_expression_in_insert_statement3275);
            select_expression50=gMySQL.select_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select_expression.add(select_expression50.getTree());
            // SQLParser1.g:51:2: ( insert_subfix )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ON) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // SQLParser1.g:51:4: insert_subfix
                    {
                    pushFollow(FOLLOW_insert_subfix_in_insert_statement3280);
                    insert_subfix51=insert_subfix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_insert_subfix.add(insert_subfix51.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: select_expression, insert_header
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 52:2: -> ^( insert_header select_expression )
            {
                // SQLParser1.g:52:5: ^( insert_header select_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_insert_header.nextNode(), root_1);

                adaptor.addChild(root_1, stream_select_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 11, insert_statement3_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "insert_statement3"

    public static class update_statements_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "update_statements"
    // SQLParser1.g:56:1: update_statements : ( single_table_update_statement | multiple_table_update_statement );
    public final MySQL_SQLParser1.update_statements_return update_statements() throws RecognitionException {
        MySQL_SQLParser1.update_statements_return retval = new MySQL_SQLParser1.update_statements_return();
        retval.start = input.LT(1);
        int update_statements_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQL_SQLParser1.single_table_update_statement_return single_table_update_statement52 = null;

        MySQL_SQLParser1.multiple_table_update_statement_return multiple_table_update_statement53 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // SQLParser1.g:56:19: ( single_table_update_statement | multiple_table_update_statement )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==UPDATE) ) {
                int LA18_1 = input.LA(2);

                if ( (synpred21_SQLParser1()) ) {
                    alt18=1;
                }
                else if ( (true) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // SQLParser1.g:57:2: single_table_update_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_single_table_update_statement_in_update_statements303);
                    single_table_update_statement52=single_table_update_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, single_table_update_statement52.getTree());

                    }
                    break;
                case 2 :
                    // SQLParser1.g:57:34: multiple_table_update_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_multiple_table_update_statement_in_update_statements307);
                    multiple_table_update_statement53=multiple_table_update_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiple_table_update_statement53.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 12, update_statements_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "update_statements"

    public static class single_table_update_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "single_table_update_statement"
    // SQLParser1.g:60:1: single_table_update_statement : UPDATE single_update_expression -> ^( TN_UPDATE single_update_expression ) ;
    public final MySQL_SQLParser1.single_table_update_statement_return single_table_update_statement() throws RecognitionException {
        MySQL_SQLParser1.single_table_update_statement_return retval = new MySQL_SQLParser1.single_table_update_statement_return();
        retval.start = input.LT(1);
        int single_table_update_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token UPDATE54=null;
        MySQL_SQLParser1.single_update_expression_return single_update_expression55 = null;


        CommonTree UPDATE54_tree=null;
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleSubtreeStream stream_single_update_expression=new RewriteRuleSubtreeStream(adaptor,"rule single_update_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // SQLParser1.g:60:30: ( UPDATE single_update_expression -> ^( TN_UPDATE single_update_expression ) )
            // SQLParser1.g:61:2: UPDATE single_update_expression
            {
            UPDATE54=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_single_table_update_statement317); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE54);

            pushFollow(FOLLOW_single_update_expression_in_single_table_update_statement319);
            single_update_expression55=single_update_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_single_update_expression.add(single_update_expression55.getTree());


            // AST REWRITE
            // elements: single_update_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 62:2: -> ^( TN_UPDATE single_update_expression )
            {
                // SQLParser1.g:62:5: ^( TN_UPDATE single_update_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_UPDATE, "TN_UPDATE"), root_1);

                adaptor.addChild(root_1, stream_single_update_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 13, single_table_update_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "single_table_update_statement"

    public static class single_update_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "single_update_expression"
    // SQLParser1.g:65:1: single_update_expression : ( LOW_PRIORITY )? ( IGNORE_SYM )? table_reference set_columns_cluase ( where_clause )? ( orderby_clause )? ( limit_clause )? ;
    public final MySQL_SQLParser1.single_update_expression_return single_update_expression() throws RecognitionException {
        MySQL_SQLParser1.single_update_expression_return retval = new MySQL_SQLParser1.single_update_expression_return();
        retval.start = input.LT(1);
        int single_update_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LOW_PRIORITY56=null;
        Token IGNORE_SYM57=null;
        MySQLParser.table_reference_return table_reference58 = null;

        MySQL_SQLParser1.set_columns_cluase_return set_columns_cluase59 = null;

        MySQLParser.where_clause_return where_clause60 = null;

        MySQLParser.orderby_clause_return orderby_clause61 = null;

        MySQLParser.limit_clause_return limit_clause62 = null;


        CommonTree LOW_PRIORITY56_tree=null;
        CommonTree IGNORE_SYM57_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // SQLParser1.g:65:25: ( ( LOW_PRIORITY )? ( IGNORE_SYM )? table_reference set_columns_cluase ( where_clause )? ( orderby_clause )? ( limit_clause )? )
            // SQLParser1.g:66:2: ( LOW_PRIORITY )? ( IGNORE_SYM )? table_reference set_columns_cluase ( where_clause )? ( orderby_clause )? ( limit_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:66:2: ( LOW_PRIORITY )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LOW_PRIORITY) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // SQLParser1.g:66:3: LOW_PRIORITY
                    {
                    LOW_PRIORITY56=(Token)match(input,LOW_PRIORITY,FOLLOW_LOW_PRIORITY_in_single_update_expression338); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOW_PRIORITY56_tree = (CommonTree)adaptor.create(LOW_PRIORITY56);
                    adaptor.addChild(root_0, LOW_PRIORITY56_tree);
                    }

                    }
                    break;

            }

            // SQLParser1.g:66:18: ( IGNORE_SYM )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==IGNORE_SYM) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // SQLParser1.g:66:19: IGNORE_SYM
                    {
                    IGNORE_SYM57=(Token)match(input,IGNORE_SYM,FOLLOW_IGNORE_SYM_in_single_update_expression343); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IGNORE_SYM57_tree = (CommonTree)adaptor.create(IGNORE_SYM57);
                    adaptor.addChild(root_0, IGNORE_SYM57_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_table_reference_in_single_update_expression347);
            table_reference58=gMySQL.table_reference();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_reference58.getTree());
            pushFollow(FOLLOW_set_columns_cluase_in_single_update_expression350);
            set_columns_cluase59=set_columns_cluase();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, set_columns_cluase59.getTree());
            // SQLParser1.g:68:2: ( where_clause )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==WHERE) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // SQLParser1.g:68:3: where_clause
                    {
                    pushFollow(FOLLOW_where_clause_in_single_update_expression354);
                    where_clause60=gMySQL.where_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, where_clause60.getTree());

                    }
                    break;

            }

            // SQLParser1.g:69:2: ( orderby_clause )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ORDER_SYM) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // SQLParser1.g:69:3: orderby_clause
                    {
                    pushFollow(FOLLOW_orderby_clause_in_single_update_expression360);
                    orderby_clause61=gMySQL.orderby_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, orderby_clause61.getTree());

                    }
                    break;

            }

            // SQLParser1.g:70:2: ( limit_clause )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==LIMIT||LA23_0==INTEGER_NUM) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // SQLParser1.g:70:3: limit_clause
                    {
                    pushFollow(FOLLOW_limit_clause_in_single_update_expression366);
                    limit_clause62=gMySQL.limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, limit_clause62.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 14, single_update_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "single_update_expression"

    public static class multiple_table_update_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiple_table_update_statement"
    // SQLParser1.g:73:1: multiple_table_update_statement : UPDATE multiple_update_expression -> ^( TN_UPDATE multiple_update_expression ) ;
    public final MySQL_SQLParser1.multiple_table_update_statement_return multiple_table_update_statement() throws RecognitionException {
        MySQL_SQLParser1.multiple_table_update_statement_return retval = new MySQL_SQLParser1.multiple_table_update_statement_return();
        retval.start = input.LT(1);
        int multiple_table_update_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token UPDATE63=null;
        MySQL_SQLParser1.multiple_update_expression_return multiple_update_expression64 = null;


        CommonTree UPDATE63_tree=null;
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleSubtreeStream stream_multiple_update_expression=new RewriteRuleSubtreeStream(adaptor,"rule multiple_update_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // SQLParser1.g:73:32: ( UPDATE multiple_update_expression -> ^( TN_UPDATE multiple_update_expression ) )
            // SQLParser1.g:74:2: UPDATE multiple_update_expression
            {
            UPDATE63=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_multiple_table_update_statement379); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE63);

            pushFollow(FOLLOW_multiple_update_expression_in_multiple_table_update_statement381);
            multiple_update_expression64=multiple_update_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_multiple_update_expression.add(multiple_update_expression64.getTree());


            // AST REWRITE
            // elements: multiple_update_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 75:2: -> ^( TN_UPDATE multiple_update_expression )
            {
                // SQLParser1.g:75:5: ^( TN_UPDATE multiple_update_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_UPDATE, "TN_UPDATE"), root_1);

                adaptor.addChild(root_1, stream_multiple_update_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 15, multiple_table_update_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "multiple_table_update_statement"

    public static class multiple_update_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiple_update_expression"
    // SQLParser1.g:78:1: multiple_update_expression : ( LOW_PRIORITY )? ( IGNORE_SYM )? table_references set_columns_cluase ( where_clause )? ;
    public final MySQL_SQLParser1.multiple_update_expression_return multiple_update_expression() throws RecognitionException {
        MySQL_SQLParser1.multiple_update_expression_return retval = new MySQL_SQLParser1.multiple_update_expression_return();
        retval.start = input.LT(1);
        int multiple_update_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LOW_PRIORITY65=null;
        Token IGNORE_SYM66=null;
        MySQLParser.table_references_return table_references67 = null;

        MySQL_SQLParser1.set_columns_cluase_return set_columns_cluase68 = null;

        MySQLParser.where_clause_return where_clause69 = null;


        CommonTree LOW_PRIORITY65_tree=null;
        CommonTree IGNORE_SYM66_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // SQLParser1.g:78:27: ( ( LOW_PRIORITY )? ( IGNORE_SYM )? table_references set_columns_cluase ( where_clause )? )
            // SQLParser1.g:79:2: ( LOW_PRIORITY )? ( IGNORE_SYM )? table_references set_columns_cluase ( where_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:79:2: ( LOW_PRIORITY )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==LOW_PRIORITY) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // SQLParser1.g:79:3: LOW_PRIORITY
                    {
                    LOW_PRIORITY65=(Token)match(input,LOW_PRIORITY,FOLLOW_LOW_PRIORITY_in_multiple_update_expression400); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOW_PRIORITY65_tree = (CommonTree)adaptor.create(LOW_PRIORITY65);
                    adaptor.addChild(root_0, LOW_PRIORITY65_tree);
                    }

                    }
                    break;

            }

            // SQLParser1.g:79:18: ( IGNORE_SYM )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IGNORE_SYM) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // SQLParser1.g:79:19: IGNORE_SYM
                    {
                    IGNORE_SYM66=(Token)match(input,IGNORE_SYM,FOLLOW_IGNORE_SYM_in_multiple_update_expression405); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IGNORE_SYM66_tree = (CommonTree)adaptor.create(IGNORE_SYM66);
                    adaptor.addChild(root_0, IGNORE_SYM66_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_table_references_in_multiple_update_expression409);
            table_references67=gMySQL.table_references();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_references67.getTree());
            pushFollow(FOLLOW_set_columns_cluase_in_multiple_update_expression412);
            set_columns_cluase68=set_columns_cluase();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, set_columns_cluase68.getTree());
            // SQLParser1.g:81:2: ( where_clause )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==WHERE) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // SQLParser1.g:81:3: where_clause
                    {
                    pushFollow(FOLLOW_where_clause_in_multiple_update_expression416);
                    where_clause69=gMySQL.where_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, where_clause69.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 16, multiple_update_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "multiple_update_expression"

    public static class call_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "call_statement"
    // SQLParser1.g:85:1: call_statement : CALL_SYM procedure_name ( LPAREN ( bit_expr ( COMMA bit_expr )* )? RPAREN )? ;
    public final MySQL_SQLParser1.call_statement_return call_statement() throws RecognitionException {
        MySQL_SQLParser1.call_statement_return retval = new MySQL_SQLParser1.call_statement_return();
        retval.start = input.LT(1);
        int call_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CALL_SYM70=null;
        Token LPAREN72=null;
        Token COMMA74=null;
        Token RPAREN76=null;
        MySQLParser.procedure_name_return procedure_name71 = null;

        MySQLParser.bit_expr_return bit_expr73 = null;

        MySQLParser.bit_expr_return bit_expr75 = null;


        CommonTree CALL_SYM70_tree=null;
        CommonTree LPAREN72_tree=null;
        CommonTree COMMA74_tree=null;
        CommonTree RPAREN76_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // SQLParser1.g:85:15: ( CALL_SYM procedure_name ( LPAREN ( bit_expr ( COMMA bit_expr )* )? RPAREN )? )
            // SQLParser1.g:86:2: CALL_SYM procedure_name ( LPAREN ( bit_expr ( COMMA bit_expr )* )? RPAREN )?
            {
            root_0 = (CommonTree)adaptor.nil();

            CALL_SYM70=(Token)match(input,CALL_SYM,FOLLOW_CALL_SYM_in_call_statement429); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CALL_SYM70_tree = (CommonTree)adaptor.create(CALL_SYM70);
            adaptor.addChild(root_0, CALL_SYM70_tree);
            }
            pushFollow(FOLLOW_procedure_name_in_call_statement431);
            procedure_name71=gMySQL.procedure_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, procedure_name71.getTree());
            // SQLParser1.g:86:26: ( LPAREN ( bit_expr ( COMMA bit_expr )* )? RPAREN )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==LPAREN) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // SQLParser1.g:86:27: LPAREN ( bit_expr ( COMMA bit_expr )* )? RPAREN
                    {
                    LPAREN72=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_call_statement434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN72_tree = (CommonTree)adaptor.create(LPAREN72);
                    adaptor.addChild(root_0, LPAREN72_tree);
                    }
                    // SQLParser1.g:86:34: ( bit_expr ( COMMA bit_expr )* )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( ((LA28_0>=ABS && LA28_0<=ACOS)||(LA28_0>=ADDDATE && LA28_0<=AES_ENCRYPT)||(LA28_0>=ASCII_SYM && LA28_0<=ASIN)||(LA28_0>=ATAN && LA28_0<=ATAN2)||LA28_0==AVG||LA28_0==BENCHMARK||(LA28_0>=BIN && LA28_0<=BIT_OR)||LA28_0==BIT_XOR||(LA28_0>=CASE_SYM && LA28_0<=CEILING)||(LA28_0>=CHAR && LA28_0<=CHAR_LENGTH)||LA28_0==CHARSET||LA28_0==COERCIBILITY||LA28_0==COLLATION||(LA28_0>=CONCAT && LA28_0<=CONCAT_WS)||LA28_0==CONNECTION_ID||(LA28_0>=CONV && LA28_0<=CONVERT_TZ)||(LA28_0>=COS && LA28_0<=COUNT)||LA28_0==CRC32||LA28_0==CURDATE||(LA28_0>=CURRENT_USER && LA28_0<=DATABASE)||(LA28_0>=DATE_ADD && LA28_0<=DATEDIFF)||LA28_0==DAY_SYM||(LA28_0>=DAYNAME && LA28_0<=DAYOFYEAR)||(LA28_0>=DECODE && LA28_0<=DEFAULT)||LA28_0==DEGREES||(LA28_0>=DES_DECRYPT && LA28_0<=DES_ENCRYPT)||LA28_0==ELT||(LA28_0>=ENCODE && LA28_0<=ENCRYPT)||(LA28_0>=EXISTS && LA28_0<=EXP)||(LA28_0>=EXPORT_SET && LA28_0<=FALSE_SYM)||LA28_0==FIELD||LA28_0==FIND_IN_SET||LA28_0==FLOOR||(LA28_0>=FORMAT && LA28_0<=FOUND_ROWS)||(LA28_0>=FROM_BASE64 && LA28_0<=FROM_UNIXTIME)||(LA28_0>=GET_FORMAT && LA28_0<=GET_LOCK)||LA28_0==GROUP_CONCAT||LA28_0==HEX||LA28_0==HOUR||(LA28_0>=IF && LA28_0<=IFNULL)||(LA28_0>=INET_ATON && LA28_0<=INET_NTOA)||LA28_0==INSERT||LA28_0==INSTR||LA28_0==INTERVAL_SYM||LA28_0==IS_FREE_LOCK||LA28_0==IS_USED_LOCK||(LA28_0>=LAST_DAY && LA28_0<=LAST_INSERT_ID)||(LA28_0>=LEFT && LA28_0<=LENGTH)||LA28_0==LN||LA28_0==LOAD_FILE||LA28_0==LOCATE||(LA28_0>=LOG && LA28_0<=LOG2)||(LA28_0>=LOWER && LA28_0<=LTRIM)||(LA28_0>=MAKE_SET && LA28_0<=MAX_SYM)||LA28_0==MD5||(LA28_0>=MICROSECOND && LA28_0<=MIN_SYM)||LA28_0==MINUTE||LA28_0==MOD||(LA28_0>=MONTH && LA28_0<=NAME_CONST)||(LA28_0>=NOW && LA28_0<=NULL_SYM)||LA28_0==OCT||LA28_0==OLD_PASSWORD||LA28_0==ORD||(LA28_0>=PASSWORD && LA28_0<=PI)||(LA28_0>=POW && LA28_0<=POWER)||LA28_0==QUARTER||(LA28_0>=QUOTE && LA28_0<=RAND)||LA28_0==RELEASE_LOCK||(LA28_0>=REPEAT && LA28_0<=REPLACE)||(LA28_0>=REVERSE && LA28_0<=RIGHT)||LA28_0==ROUND||LA28_0==ROW_SYM||(LA28_0>=RPAD && LA28_0<=RTRIM)||(LA28_0>=SCHEMA && LA28_0<=SECOND)||LA28_0==SESSION_USER||LA28_0==SIGN||LA28_0==SIN||LA28_0==SLEEP||LA28_0==SOUNDEX||LA28_0==SPACE||LA28_0==SQRT||(LA28_0>=STD && LA28_0<=STDDEV_SAMP)||LA28_0==STR_TO_DATE||LA28_0==STRCMP||(LA28_0>=SUBSTRING && LA28_0<=SUM)||(LA28_0>=SYSDATE && LA28_0<=SYSTEM_USER)||LA28_0==TAN||(LA28_0>=TIME_FORMAT && LA28_0<=TIMESTAMPDIFF)||(LA28_0>=TO_BASE64 && LA28_0<=TO_SECONDS)||(LA28_0>=TRIM && LA28_0<=TRUNCATE)||LA28_0==UNHEX||LA28_0==UNIX_TIMESTAMP||LA28_0==UPPER||LA28_0==USER||(LA28_0>=UTC_DATE && LA28_0<=UTC_TIMESTAMP)||LA28_0==UUID||(LA28_0>=VALUES && LA28_0<=VAR_SAMP)||(LA28_0>=VARIANCE && LA28_0<=VERSION_SYM)||(LA28_0>=WEEK && LA28_0<=WEIGHT_STRING)||(LA28_0>=LPAREN && LA28_0<=YEAR_FUNC)||LA28_0==YEARWEEK||(LA28_0>=PLUS && LA28_0<=NEGATION)||LA28_0==INTEGER_NUM||(LA28_0>=HEX_DIGIT && LA28_0<=ID)||LA28_0==USER_VAR) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // SQLParser1.g:86:36: bit_expr ( COMMA bit_expr )*
                            {
                            pushFollow(FOLLOW_bit_expr_in_call_statement438);
                            bit_expr73=gMySQL.bit_expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr73.getTree());
                            // SQLParser1.g:86:45: ( COMMA bit_expr )*
                            loop27:
                            do {
                                int alt27=2;
                                int LA27_0 = input.LA(1);

                                if ( (LA27_0==COMMA) ) {
                                    alt27=1;
                                }


                                switch (alt27) {
                            	case 1 :
                            	    // SQLParser1.g:86:46: COMMA bit_expr
                            	    {
                            	    COMMA74=(Token)match(input,COMMA,FOLLOW_COMMA_in_call_statement441); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    COMMA74_tree = (CommonTree)adaptor.create(COMMA74);
                            	    adaptor.addChild(root_0, COMMA74_tree);
                            	    }
                            	    pushFollow(FOLLOW_bit_expr_in_call_statement443);
                            	    bit_expr75=gMySQL.bit_expr();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr75.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop27;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RPAREN76=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_call_statement450); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN76_tree = (CommonTree)adaptor.create(RPAREN76);
                    adaptor.addChild(root_0, RPAREN76_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 17, call_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "call_statement"

    public static class do_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "do_statement"
    // SQLParser1.g:90:1: do_statement : DO_SYM root_statement ( COMMA root_statement )* ;
    public final MySQL_SQLParser1.do_statement_return do_statement() throws RecognitionException {
        MySQL_SQLParser1.do_statement_return retval = new MySQL_SQLParser1.do_statement_return();
        retval.start = input.LT(1);
        int do_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DO_SYM77=null;
        Token COMMA79=null;
        MySQLParser.root_statement_return root_statement78 = null;

        MySQLParser.root_statement_return root_statement80 = null;


        CommonTree DO_SYM77_tree=null;
        CommonTree COMMA79_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // SQLParser1.g:90:13: ( DO_SYM root_statement ( COMMA root_statement )* )
            // SQLParser1.g:91:2: DO_SYM root_statement ( COMMA root_statement )*
            {
            root_0 = (CommonTree)adaptor.nil();

            DO_SYM77=(Token)match(input,DO_SYM,FOLLOW_DO_SYM_in_do_statement462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DO_SYM77_tree = (CommonTree)adaptor.create(DO_SYM77);
            adaptor.addChild(root_0, DO_SYM77_tree);
            }
            pushFollow(FOLLOW_root_statement_in_do_statement464);
            root_statement78=gMySQL.root_statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, root_statement78.getTree());
            // SQLParser1.g:91:24: ( COMMA root_statement )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==COMMA) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // SQLParser1.g:91:25: COMMA root_statement
            	    {
            	    COMMA79=(Token)match(input,COMMA,FOLLOW_COMMA_in_do_statement467); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA79_tree = (CommonTree)adaptor.create(COMMA79);
            	    adaptor.addChild(root_0, COMMA79_tree);
            	    }
            	    pushFollow(FOLLOW_root_statement_in_do_statement469);
            	    root_statement80=gMySQL.root_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, root_statement80.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
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
            if ( state.backtracking>0 ) { memoize(input, 18, do_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "do_statement"

    public static class handler_statements_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "handler_statements"
    // SQLParser1.g:95:1: handler_statements : HANDLER_SYM table_name ( open_handler_statement | handler_statement1 | handler_statement2 | handler_statement3 | close_handler_statement ) ;
    public final MySQL_SQLParser1.handler_statements_return handler_statements() throws RecognitionException {
        MySQL_SQLParser1.handler_statements_return retval = new MySQL_SQLParser1.handler_statements_return();
        retval.start = input.LT(1);
        int handler_statements_StartIndex = input.index();
        CommonTree root_0 = null;

        Token HANDLER_SYM81=null;
        MySQLParser.table_name_return table_name82 = null;

        MySQL_SQLParser1.open_handler_statement_return open_handler_statement83 = null;

        MySQL_SQLParser1.handler_statement1_return handler_statement184 = null;

        MySQL_SQLParser1.handler_statement2_return handler_statement285 = null;

        MySQL_SQLParser1.handler_statement3_return handler_statement386 = null;

        MySQL_SQLParser1.close_handler_statement_return close_handler_statement87 = null;


        CommonTree HANDLER_SYM81_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // SQLParser1.g:95:19: ( HANDLER_SYM table_name ( open_handler_statement | handler_statement1 | handler_statement2 | handler_statement3 | close_handler_statement ) )
            // SQLParser1.g:96:2: HANDLER_SYM table_name ( open_handler_statement | handler_statement1 | handler_statement2 | handler_statement3 | close_handler_statement )
            {
            root_0 = (CommonTree)adaptor.nil();

            HANDLER_SYM81=(Token)match(input,HANDLER_SYM,FOLLOW_HANDLER_SYM_in_handler_statements481); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            HANDLER_SYM81_tree = (CommonTree)adaptor.create(HANDLER_SYM81);
            adaptor.addChild(root_0, HANDLER_SYM81_tree);
            }
            pushFollow(FOLLOW_table_name_in_handler_statements483);
            table_name82=gMySQL.table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name82.getTree());
            // SQLParser1.g:97:2: ( open_handler_statement | handler_statement1 | handler_statement2 | handler_statement3 | close_handler_statement )
            int alt31=5;
            switch ( input.LA(1) ) {
            case OPEN_SYM:
                {
                alt31=1;
                }
                break;
            case READ_SYM:
                {
                int LA31_2 = input.LA(2);

                if ( (LA31_2==FIRST_SYM||LA31_2==NEXT_SYM) ) {
                    alt31=4;
                }
                else if ( (LA31_2==ID) ) {
                    int LA31_5 = input.LA(3);

                    if ( ((LA31_5>=EQ_SYM && LA31_5<=GET)||(LA31_5>=GTH && LA31_5<=LTH)) ) {
                        alt31=2;
                    }
                    else if ( (LA31_5==FIRST_SYM||LA31_5==LAST_SYM||LA31_5==NEXT_SYM||LA31_5==PREV_SYM) ) {
                        alt31=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 2, input);

                    throw nvae;
                }
                }
                break;
            case CLOSE_SYM:
                {
                alt31=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // SQLParser1.g:97:3: open_handler_statement
                    {
                    pushFollow(FOLLOW_open_handler_statement_in_handler_statements487);
                    open_handler_statement83=open_handler_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, open_handler_statement83.getTree());

                    }
                    break;
                case 2 :
                    // SQLParser1.g:97:28: handler_statement1
                    {
                    pushFollow(FOLLOW_handler_statement1_in_handler_statements491);
                    handler_statement184=handler_statement1();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, handler_statement184.getTree());

                    }
                    break;
                case 3 :
                    // SQLParser1.g:97:49: handler_statement2
                    {
                    pushFollow(FOLLOW_handler_statement2_in_handler_statements495);
                    handler_statement285=handler_statement2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, handler_statement285.getTree());

                    }
                    break;
                case 4 :
                    // SQLParser1.g:97:70: handler_statement3
                    {
                    pushFollow(FOLLOW_handler_statement3_in_handler_statements499);
                    handler_statement386=handler_statement3();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, handler_statement386.getTree());

                    }
                    break;
                case 5 :
                    // SQLParser1.g:97:91: close_handler_statement
                    {
                    pushFollow(FOLLOW_close_handler_statement_in_handler_statements503);
                    close_handler_statement87=close_handler_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, close_handler_statement87.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 19, handler_statements_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "handler_statements"

    public static class open_handler_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "open_handler_statement"
    // SQLParser1.g:100:1: open_handler_statement : OPEN_SYM ( alias )? ;
    public final MySQL_SQLParser1.open_handler_statement_return open_handler_statement() throws RecognitionException {
        MySQL_SQLParser1.open_handler_statement_return retval = new MySQL_SQLParser1.open_handler_statement_return();
        retval.start = input.LT(1);
        int open_handler_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token OPEN_SYM88=null;
        MySQLParser.alias_return alias89 = null;


        CommonTree OPEN_SYM88_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // SQLParser1.g:100:23: ( OPEN_SYM ( alias )? )
            // SQLParser1.g:101:2: OPEN_SYM ( alias )?
            {
            root_0 = (CommonTree)adaptor.nil();

            OPEN_SYM88=(Token)match(input,OPEN_SYM,FOLLOW_OPEN_SYM_in_open_handler_statement513); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OPEN_SYM88_tree = (CommonTree)adaptor.create(OPEN_SYM88);
            adaptor.addChild(root_0, OPEN_SYM88_tree);
            }
            // SQLParser1.g:101:11: ( alias )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==AS_SYM||LA32_0==ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // SQLParser1.g:101:12: alias
                    {
                    pushFollow(FOLLOW_alias_in_open_handler_statement516);
                    alias89=gMySQL.alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, alias89.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 20, open_handler_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "open_handler_statement"

    public static class handler_statement1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "handler_statement1"
    // SQLParser1.g:104:1: handler_statement1 : READ_SYM index_name relational_op LPAREN bit_expr ( COMMA bit_expr )* RPAREN ( where_clause )? ( limit_clause )? ;
    public final MySQL_SQLParser1.handler_statement1_return handler_statement1() throws RecognitionException {
        MySQL_SQLParser1.handler_statement1_return retval = new MySQL_SQLParser1.handler_statement1_return();
        retval.start = input.LT(1);
        int handler_statement1_StartIndex = input.index();
        CommonTree root_0 = null;

        Token READ_SYM90=null;
        Token LPAREN93=null;
        Token COMMA95=null;
        Token RPAREN97=null;
        MySQLParser.index_name_return index_name91 = null;

        MySQLParser.relational_op_return relational_op92 = null;

        MySQLParser.bit_expr_return bit_expr94 = null;

        MySQLParser.bit_expr_return bit_expr96 = null;

        MySQLParser.where_clause_return where_clause98 = null;

        MySQLParser.limit_clause_return limit_clause99 = null;


        CommonTree READ_SYM90_tree=null;
        CommonTree LPAREN93_tree=null;
        CommonTree COMMA95_tree=null;
        CommonTree RPAREN97_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // SQLParser1.g:104:19: ( READ_SYM index_name relational_op LPAREN bit_expr ( COMMA bit_expr )* RPAREN ( where_clause )? ( limit_clause )? )
            // SQLParser1.g:105:2: READ_SYM index_name relational_op LPAREN bit_expr ( COMMA bit_expr )* RPAREN ( where_clause )? ( limit_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();

            READ_SYM90=(Token)match(input,READ_SYM,FOLLOW_READ_SYM_in_handler_statement1527); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            READ_SYM90_tree = (CommonTree)adaptor.create(READ_SYM90);
            adaptor.addChild(root_0, READ_SYM90_tree);
            }
            pushFollow(FOLLOW_index_name_in_handler_statement1529);
            index_name91=gMySQL.index_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, index_name91.getTree());
            pushFollow(FOLLOW_relational_op_in_handler_statement1531);
            relational_op92=gMySQL.relational_op();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relational_op92.getTree());
            LPAREN93=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_handler_statement1533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN93_tree = (CommonTree)adaptor.create(LPAREN93);
            adaptor.addChild(root_0, LPAREN93_tree);
            }
            pushFollow(FOLLOW_bit_expr_in_handler_statement1535);
            bit_expr94=gMySQL.bit_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr94.getTree());
            // SQLParser1.g:105:52: ( COMMA bit_expr )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==COMMA) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // SQLParser1.g:105:53: COMMA bit_expr
            	    {
            	    COMMA95=(Token)match(input,COMMA,FOLLOW_COMMA_in_handler_statement1538); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA95_tree = (CommonTree)adaptor.create(COMMA95);
            	    adaptor.addChild(root_0, COMMA95_tree);
            	    }
            	    pushFollow(FOLLOW_bit_expr_in_handler_statement1540);
            	    bit_expr96=gMySQL.bit_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_expr96.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            RPAREN97=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_handler_statement1544); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN97_tree = (CommonTree)adaptor.create(RPAREN97);
            adaptor.addChild(root_0, RPAREN97_tree);
            }
            // SQLParser1.g:106:2: ( where_clause )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==WHERE) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // SQLParser1.g:106:3: where_clause
                    {
                    pushFollow(FOLLOW_where_clause_in_handler_statement1548);
                    where_clause98=gMySQL.where_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, where_clause98.getTree());

                    }
                    break;

            }

            // SQLParser1.g:106:18: ( limit_clause )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==LIMIT||LA35_0==INTEGER_NUM) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // SQLParser1.g:106:19: limit_clause
                    {
                    pushFollow(FOLLOW_limit_clause_in_handler_statement1553);
                    limit_clause99=gMySQL.limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, limit_clause99.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 21, handler_statement1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "handler_statement1"

    public static class handler_statement2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "handler_statement2"
    // SQLParser1.g:109:1: handler_statement2 : READ_SYM index_name ( FIRST_SYM | NEXT_SYM | PREV_SYM | LAST_SYM ) ( where_clause )? ( limit_clause )? ;
    public final MySQL_SQLParser1.handler_statement2_return handler_statement2() throws RecognitionException {
        MySQL_SQLParser1.handler_statement2_return retval = new MySQL_SQLParser1.handler_statement2_return();
        retval.start = input.LT(1);
        int handler_statement2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token READ_SYM100=null;
        Token set102=null;
        MySQLParser.index_name_return index_name101 = null;

        MySQLParser.where_clause_return where_clause103 = null;

        MySQLParser.limit_clause_return limit_clause104 = null;


        CommonTree READ_SYM100_tree=null;
        CommonTree set102_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // SQLParser1.g:109:19: ( READ_SYM index_name ( FIRST_SYM | NEXT_SYM | PREV_SYM | LAST_SYM ) ( where_clause )? ( limit_clause )? )
            // SQLParser1.g:110:2: READ_SYM index_name ( FIRST_SYM | NEXT_SYM | PREV_SYM | LAST_SYM ) ( where_clause )? ( limit_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();

            READ_SYM100=(Token)match(input,READ_SYM,FOLLOW_READ_SYM_in_handler_statement2564); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            READ_SYM100_tree = (CommonTree)adaptor.create(READ_SYM100);
            adaptor.addChild(root_0, READ_SYM100_tree);
            }
            pushFollow(FOLLOW_index_name_in_handler_statement2566);
            index_name101=gMySQL.index_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, index_name101.getTree());
            set102=(Token)input.LT(1);
            if ( input.LA(1)==FIRST_SYM||input.LA(1)==LAST_SYM||input.LA(1)==NEXT_SYM||input.LA(1)==PREV_SYM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set102));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // SQLParser1.g:111:2: ( where_clause )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==WHERE) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // SQLParser1.g:111:3: where_clause
                    {
                    pushFollow(FOLLOW_where_clause_in_handler_statement2586);
                    where_clause103=gMySQL.where_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, where_clause103.getTree());

                    }
                    break;

            }

            // SQLParser1.g:111:18: ( limit_clause )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==LIMIT||LA37_0==INTEGER_NUM) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // SQLParser1.g:111:19: limit_clause
                    {
                    pushFollow(FOLLOW_limit_clause_in_handler_statement2591);
                    limit_clause104=gMySQL.limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, limit_clause104.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 22, handler_statement2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "handler_statement2"

    public static class handler_statement3_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "handler_statement3"
    // SQLParser1.g:114:1: handler_statement3 : READ_SYM ( FIRST_SYM | NEXT_SYM ) ( where_clause )? ( limit_clause )? ;
    public final MySQL_SQLParser1.handler_statement3_return handler_statement3() throws RecognitionException {
        MySQL_SQLParser1.handler_statement3_return retval = new MySQL_SQLParser1.handler_statement3_return();
        retval.start = input.LT(1);
        int handler_statement3_StartIndex = input.index();
        CommonTree root_0 = null;

        Token READ_SYM105=null;
        Token set106=null;
        MySQLParser.where_clause_return where_clause107 = null;

        MySQLParser.limit_clause_return limit_clause108 = null;


        CommonTree READ_SYM105_tree=null;
        CommonTree set106_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // SQLParser1.g:114:19: ( READ_SYM ( FIRST_SYM | NEXT_SYM ) ( where_clause )? ( limit_clause )? )
            // SQLParser1.g:115:2: READ_SYM ( FIRST_SYM | NEXT_SYM ) ( where_clause )? ( limit_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();

            READ_SYM105=(Token)match(input,READ_SYM,FOLLOW_READ_SYM_in_handler_statement3602); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            READ_SYM105_tree = (CommonTree)adaptor.create(READ_SYM105);
            adaptor.addChild(root_0, READ_SYM105_tree);
            }
            set106=(Token)input.LT(1);
            if ( input.LA(1)==FIRST_SYM||input.LA(1)==NEXT_SYM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set106));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // SQLParser1.g:116:2: ( where_clause )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==WHERE) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // SQLParser1.g:116:3: where_clause
                    {
                    pushFollow(FOLLOW_where_clause_in_handler_statement3614);
                    where_clause107=gMySQL.where_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, where_clause107.getTree());

                    }
                    break;

            }

            // SQLParser1.g:116:18: ( limit_clause )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==LIMIT||LA39_0==INTEGER_NUM) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // SQLParser1.g:116:19: limit_clause
                    {
                    pushFollow(FOLLOW_limit_clause_in_handler_statement3619);
                    limit_clause108=gMySQL.limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, limit_clause108.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 23, handler_statement3_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "handler_statement3"

    public static class close_handler_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "close_handler_statement"
    // SQLParser1.g:119:1: close_handler_statement : CLOSE_SYM ;
    public final MySQL_SQLParser1.close_handler_statement_return close_handler_statement() throws RecognitionException {
        MySQL_SQLParser1.close_handler_statement_return retval = new MySQL_SQLParser1.close_handler_statement_return();
        retval.start = input.LT(1);
        int close_handler_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CLOSE_SYM109=null;

        CommonTree CLOSE_SYM109_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // SQLParser1.g:119:24: ( CLOSE_SYM )
            // SQLParser1.g:120:2: CLOSE_SYM
            {
            root_0 = (CommonTree)adaptor.nil();

            CLOSE_SYM109=(Token)match(input,CLOSE_SYM,FOLLOW_CLOSE_SYM_in_close_handler_statement630); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CLOSE_SYM109_tree = (CommonTree)adaptor.create(CLOSE_SYM109);
            adaptor.addChild(root_0, CLOSE_SYM109_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 24, close_handler_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "close_handler_statement"

    public static class load_data_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "load_data_statement"
    // SQLParser1.g:124:1: load_data_statement : LOAD DATA_SYM ( LOW_PRIORITY | CONCURRENT )? ( LOCAL_SYM )? INFILE TEXT_STRING ( REPLACE | IGNORE_SYM )? INTO TABLE table_spec ( partition_clause )? ( CHARACTER_SYM SET_SYM charset_name )? ( ( FIELDS_SYM | COLUMNS_SYM ) ( TERMINATED BY_SYM TEXT_STRING )? ( ( OPTIONALLY )? ENCLOSED BY_SYM TEXT_STRING )? ( ESCAPED BY_SYM TEXT_STRING )? )? ( LINES ( STARTING BY_SYM TEXT_STRING )? ( TERMINATED BY_SYM TEXT_STRING )? )? ( IGNORE_SYM INTEGER_NUM ( LINES | ROWS_SYM ) )? ( LPAREN ( column_spec | USER_VAR ) ( COMMA ( column_spec | USER_VAR ) )* RPAREN )? ( set_columns_cluase )? -> ^( LOAD table_spec ) ;
    public final MySQL_SQLParser1.load_data_statement_return load_data_statement() throws RecognitionException {
        MySQL_SQLParser1.load_data_statement_return retval = new MySQL_SQLParser1.load_data_statement_return();
        retval.start = input.LT(1);
        int load_data_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LOAD110=null;
        Token DATA_SYM111=null;
        Token LOW_PRIORITY112=null;
        Token CONCURRENT113=null;
        Token LOCAL_SYM114=null;
        Token INFILE115=null;
        Token TEXT_STRING116=null;
        Token REPLACE117=null;
        Token IGNORE_SYM118=null;
        Token INTO119=null;
        Token TABLE120=null;
        Token CHARACTER_SYM123=null;
        Token SET_SYM124=null;
        Token FIELDS_SYM126=null;
        Token COLUMNS_SYM127=null;
        Token TERMINATED128=null;
        Token BY_SYM129=null;
        Token TEXT_STRING130=null;
        Token OPTIONALLY131=null;
        Token ENCLOSED132=null;
        Token BY_SYM133=null;
        Token TEXT_STRING134=null;
        Token ESCAPED135=null;
        Token BY_SYM136=null;
        Token TEXT_STRING137=null;
        Token LINES138=null;
        Token STARTING139=null;
        Token BY_SYM140=null;
        Token TEXT_STRING141=null;
        Token TERMINATED142=null;
        Token BY_SYM143=null;
        Token TEXT_STRING144=null;
        Token IGNORE_SYM145=null;
        Token INTEGER_NUM146=null;
        Token LINES147=null;
        Token ROWS_SYM148=null;
        Token LPAREN149=null;
        Token USER_VAR151=null;
        Token COMMA152=null;
        Token USER_VAR154=null;
        Token RPAREN155=null;
        MySQLParser.table_spec_return table_spec121 = null;

        MySQLParser.partition_clause_return partition_clause122 = null;

        MySQLParser.charset_name_return charset_name125 = null;

        MySQLParser.column_spec_return column_spec150 = null;

        MySQLParser.column_spec_return column_spec153 = null;

        MySQL_SQLParser1.set_columns_cluase_return set_columns_cluase156 = null;


        CommonTree LOAD110_tree=null;
        CommonTree DATA_SYM111_tree=null;
        CommonTree LOW_PRIORITY112_tree=null;
        CommonTree CONCURRENT113_tree=null;
        CommonTree LOCAL_SYM114_tree=null;
        CommonTree INFILE115_tree=null;
        CommonTree TEXT_STRING116_tree=null;
        CommonTree REPLACE117_tree=null;
        CommonTree IGNORE_SYM118_tree=null;
        CommonTree INTO119_tree=null;
        CommonTree TABLE120_tree=null;
        CommonTree CHARACTER_SYM123_tree=null;
        CommonTree SET_SYM124_tree=null;
        CommonTree FIELDS_SYM126_tree=null;
        CommonTree COLUMNS_SYM127_tree=null;
        CommonTree TERMINATED128_tree=null;
        CommonTree BY_SYM129_tree=null;
        CommonTree TEXT_STRING130_tree=null;
        CommonTree OPTIONALLY131_tree=null;
        CommonTree ENCLOSED132_tree=null;
        CommonTree BY_SYM133_tree=null;
        CommonTree TEXT_STRING134_tree=null;
        CommonTree ESCAPED135_tree=null;
        CommonTree BY_SYM136_tree=null;
        CommonTree TEXT_STRING137_tree=null;
        CommonTree LINES138_tree=null;
        CommonTree STARTING139_tree=null;
        CommonTree BY_SYM140_tree=null;
        CommonTree TEXT_STRING141_tree=null;
        CommonTree TERMINATED142_tree=null;
        CommonTree BY_SYM143_tree=null;
        CommonTree TEXT_STRING144_tree=null;
        CommonTree IGNORE_SYM145_tree=null;
        CommonTree INTEGER_NUM146_tree=null;
        CommonTree LINES147_tree=null;
        CommonTree ROWS_SYM148_tree=null;
        CommonTree LPAREN149_tree=null;
        CommonTree USER_VAR151_tree=null;
        CommonTree COMMA152_tree=null;
        CommonTree USER_VAR154_tree=null;
        CommonTree RPAREN155_tree=null;
        RewriteRuleTokenStream stream_LOCAL_SYM=new RewriteRuleTokenStream(adaptor,"token LOCAL_SYM");
        RewriteRuleTokenStream stream_OPTIONALLY=new RewriteRuleTokenStream(adaptor,"token OPTIONALLY");
        RewriteRuleTokenStream stream_LOAD=new RewriteRuleTokenStream(adaptor,"token LOAD");
        RewriteRuleTokenStream stream_LINES=new RewriteRuleTokenStream(adaptor,"token LINES");
        RewriteRuleTokenStream stream_TABLE=new RewriteRuleTokenStream(adaptor,"token TABLE");
        RewriteRuleTokenStream stream_ENCLOSED=new RewriteRuleTokenStream(adaptor,"token ENCLOSED");
        RewriteRuleTokenStream stream_TERMINATED=new RewriteRuleTokenStream(adaptor,"token TERMINATED");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_DATA_SYM=new RewriteRuleTokenStream(adaptor,"token DATA_SYM");
        RewriteRuleTokenStream stream_USER_VAR=new RewriteRuleTokenStream(adaptor,"token USER_VAR");
        RewriteRuleTokenStream stream_ROWS_SYM=new RewriteRuleTokenStream(adaptor,"token ROWS_SYM");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_FIELDS_SYM=new RewriteRuleTokenStream(adaptor,"token FIELDS_SYM");
        RewriteRuleTokenStream stream_COLUMNS_SYM=new RewriteRuleTokenStream(adaptor,"token COLUMNS_SYM");
        RewriteRuleTokenStream stream_LOW_PRIORITY=new RewriteRuleTokenStream(adaptor,"token LOW_PRIORITY");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_INTEGER_NUM=new RewriteRuleTokenStream(adaptor,"token INTEGER_NUM");
        RewriteRuleTokenStream stream_SET_SYM=new RewriteRuleTokenStream(adaptor,"token SET_SYM");
        RewriteRuleTokenStream stream_REPLACE=new RewriteRuleTokenStream(adaptor,"token REPLACE");
        RewriteRuleTokenStream stream_STARTING=new RewriteRuleTokenStream(adaptor,"token STARTING");
        RewriteRuleTokenStream stream_TEXT_STRING=new RewriteRuleTokenStream(adaptor,"token TEXT_STRING");
        RewriteRuleTokenStream stream_CONCURRENT=new RewriteRuleTokenStream(adaptor,"token CONCURRENT");
        RewriteRuleTokenStream stream_ESCAPED=new RewriteRuleTokenStream(adaptor,"token ESCAPED");
        RewriteRuleTokenStream stream_BY_SYM=new RewriteRuleTokenStream(adaptor,"token BY_SYM");
        RewriteRuleTokenStream stream_INFILE=new RewriteRuleTokenStream(adaptor,"token INFILE");
        RewriteRuleTokenStream stream_INTO=new RewriteRuleTokenStream(adaptor,"token INTO");
        RewriteRuleTokenStream stream_CHARACTER_SYM=new RewriteRuleTokenStream(adaptor,"token CHARACTER_SYM");
        RewriteRuleTokenStream stream_IGNORE_SYM=new RewriteRuleTokenStream(adaptor,"token IGNORE_SYM");
        RewriteRuleSubtreeStream stream_set_columns_cluase=new RewriteRuleSubtreeStream(adaptor,"rule set_columns_cluase");
        RewriteRuleSubtreeStream stream_column_spec=new RewriteRuleSubtreeStream(adaptor,"rule column_spec");
        RewriteRuleSubtreeStream stream_partition_clause=new RewriteRuleSubtreeStream(adaptor,"rule partition_clause");
        RewriteRuleSubtreeStream stream_table_spec=new RewriteRuleSubtreeStream(adaptor,"rule table_spec");
        RewriteRuleSubtreeStream stream_charset_name=new RewriteRuleSubtreeStream(adaptor,"rule charset_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // SQLParser1.g:124:20: ( LOAD DATA_SYM ( LOW_PRIORITY | CONCURRENT )? ( LOCAL_SYM )? INFILE TEXT_STRING ( REPLACE | IGNORE_SYM )? INTO TABLE table_spec ( partition_clause )? ( CHARACTER_SYM SET_SYM charset_name )? ( ( FIELDS_SYM | COLUMNS_SYM ) ( TERMINATED BY_SYM TEXT_STRING )? ( ( OPTIONALLY )? ENCLOSED BY_SYM TEXT_STRING )? ( ESCAPED BY_SYM TEXT_STRING )? )? ( LINES ( STARTING BY_SYM TEXT_STRING )? ( TERMINATED BY_SYM TEXT_STRING )? )? ( IGNORE_SYM INTEGER_NUM ( LINES | ROWS_SYM ) )? ( LPAREN ( column_spec | USER_VAR ) ( COMMA ( column_spec | USER_VAR ) )* RPAREN )? ( set_columns_cluase )? -> ^( LOAD table_spec ) )
            // SQLParser1.g:125:2: LOAD DATA_SYM ( LOW_PRIORITY | CONCURRENT )? ( LOCAL_SYM )? INFILE TEXT_STRING ( REPLACE | IGNORE_SYM )? INTO TABLE table_spec ( partition_clause )? ( CHARACTER_SYM SET_SYM charset_name )? ( ( FIELDS_SYM | COLUMNS_SYM ) ( TERMINATED BY_SYM TEXT_STRING )? ( ( OPTIONALLY )? ENCLOSED BY_SYM TEXT_STRING )? ( ESCAPED BY_SYM TEXT_STRING )? )? ( LINES ( STARTING BY_SYM TEXT_STRING )? ( TERMINATED BY_SYM TEXT_STRING )? )? ( IGNORE_SYM INTEGER_NUM ( LINES | ROWS_SYM ) )? ( LPAREN ( column_spec | USER_VAR ) ( COMMA ( column_spec | USER_VAR ) )* RPAREN )? ( set_columns_cluase )?
            {
            LOAD110=(Token)match(input,LOAD,FOLLOW_LOAD_in_load_data_statement640); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LOAD.add(LOAD110);

            DATA_SYM111=(Token)match(input,DATA_SYM,FOLLOW_DATA_SYM_in_load_data_statement642); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DATA_SYM.add(DATA_SYM111);

            // SQLParser1.g:125:16: ( LOW_PRIORITY | CONCURRENT )?
            int alt40=3;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==LOW_PRIORITY) ) {
                alt40=1;
            }
            else if ( (LA40_0==CONCURRENT) ) {
                alt40=2;
            }
            switch (alt40) {
                case 1 :
                    // SQLParser1.g:125:17: LOW_PRIORITY
                    {
                    LOW_PRIORITY112=(Token)match(input,LOW_PRIORITY,FOLLOW_LOW_PRIORITY_in_load_data_statement645); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LOW_PRIORITY.add(LOW_PRIORITY112);


                    }
                    break;
                case 2 :
                    // SQLParser1.g:125:32: CONCURRENT
                    {
                    CONCURRENT113=(Token)match(input,CONCURRENT,FOLLOW_CONCURRENT_in_load_data_statement649); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONCURRENT.add(CONCURRENT113);


                    }
                    break;

            }

            // SQLParser1.g:125:45: ( LOCAL_SYM )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==LOCAL_SYM) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // SQLParser1.g:125:46: LOCAL_SYM
                    {
                    LOCAL_SYM114=(Token)match(input,LOCAL_SYM,FOLLOW_LOCAL_SYM_in_load_data_statement654); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LOCAL_SYM.add(LOCAL_SYM114);


                    }
                    break;

            }

            INFILE115=(Token)match(input,INFILE,FOLLOW_INFILE_in_load_data_statement658); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INFILE.add(INFILE115);

            TEXT_STRING116=(Token)match(input,TEXT_STRING,FOLLOW_TEXT_STRING_in_load_data_statement660); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TEXT_STRING.add(TEXT_STRING116);

            // SQLParser1.g:126:2: ( REPLACE | IGNORE_SYM )?
            int alt42=3;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==REPLACE) ) {
                alt42=1;
            }
            else if ( (LA42_0==IGNORE_SYM) ) {
                alt42=2;
            }
            switch (alt42) {
                case 1 :
                    // SQLParser1.g:126:3: REPLACE
                    {
                    REPLACE117=(Token)match(input,REPLACE,FOLLOW_REPLACE_in_load_data_statement664); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_REPLACE.add(REPLACE117);


                    }
                    break;
                case 2 :
                    // SQLParser1.g:126:13: IGNORE_SYM
                    {
                    IGNORE_SYM118=(Token)match(input,IGNORE_SYM,FOLLOW_IGNORE_SYM_in_load_data_statement668); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IGNORE_SYM.add(IGNORE_SYM118);


                    }
                    break;

            }

            INTO119=(Token)match(input,INTO,FOLLOW_INTO_in_load_data_statement673); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTO.add(INTO119);

            TABLE120=(Token)match(input,TABLE,FOLLOW_TABLE_in_load_data_statement675); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TABLE.add(TABLE120);

            pushFollow(FOLLOW_table_spec_in_load_data_statement677);
            table_spec121=gMySQL.table_spec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_table_spec.add(table_spec121.getTree());
            // SQLParser1.g:128:2: ( partition_clause )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==PARTITION_SYM) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // SQLParser1.g:128:3: partition_clause
                    {
                    pushFollow(FOLLOW_partition_clause_in_load_data_statement681);
                    partition_clause122=gMySQL.partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_partition_clause.add(partition_clause122.getTree());

                    }
                    break;

            }

            // SQLParser1.g:129:2: ( CHARACTER_SYM SET_SYM charset_name )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==CHARACTER_SYM) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // SQLParser1.g:129:3: CHARACTER_SYM SET_SYM charset_name
                    {
                    CHARACTER_SYM123=(Token)match(input,CHARACTER_SYM,FOLLOW_CHARACTER_SYM_in_load_data_statement687); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHARACTER_SYM.add(CHARACTER_SYM123);

                    SET_SYM124=(Token)match(input,SET_SYM,FOLLOW_SET_SYM_in_load_data_statement689); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SET_SYM.add(SET_SYM124);

                    pushFollow(FOLLOW_charset_name_in_load_data_statement691);
                    charset_name125=gMySQL.charset_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_charset_name.add(charset_name125.getTree());

                    }
                    break;

            }

            // SQLParser1.g:130:2: ( ( FIELDS_SYM | COLUMNS_SYM ) ( TERMINATED BY_SYM TEXT_STRING )? ( ( OPTIONALLY )? ENCLOSED BY_SYM TEXT_STRING )? ( ESCAPED BY_SYM TEXT_STRING )? )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==COLUMNS_SYM||LA50_0==FIELDS_SYM) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // SQLParser1.g:131:3: ( FIELDS_SYM | COLUMNS_SYM ) ( TERMINATED BY_SYM TEXT_STRING )? ( ( OPTIONALLY )? ENCLOSED BY_SYM TEXT_STRING )? ( ESCAPED BY_SYM TEXT_STRING )?
                    {
                    // SQLParser1.g:131:3: ( FIELDS_SYM | COLUMNS_SYM )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==FIELDS_SYM) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==COLUMNS_SYM) ) {
                        alt45=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // SQLParser1.g:131:4: FIELDS_SYM
                            {
                            FIELDS_SYM126=(Token)match(input,FIELDS_SYM,FOLLOW_FIELDS_SYM_in_load_data_statement701); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_FIELDS_SYM.add(FIELDS_SYM126);


                            }
                            break;
                        case 2 :
                            // SQLParser1.g:131:17: COLUMNS_SYM
                            {
                            COLUMNS_SYM127=(Token)match(input,COLUMNS_SYM,FOLLOW_COLUMNS_SYM_in_load_data_statement705); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLUMNS_SYM.add(COLUMNS_SYM127);


                            }
                            break;

                    }

                    // SQLParser1.g:132:3: ( TERMINATED BY_SYM TEXT_STRING )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==TERMINATED) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // SQLParser1.g:132:4: TERMINATED BY_SYM TEXT_STRING
                            {
                            TERMINATED128=(Token)match(input,TERMINATED,FOLLOW_TERMINATED_in_load_data_statement711); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TERMINATED.add(TERMINATED128);

                            BY_SYM129=(Token)match(input,BY_SYM,FOLLOW_BY_SYM_in_load_data_statement713); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY_SYM.add(BY_SYM129);

                            TEXT_STRING130=(Token)match(input,TEXT_STRING,FOLLOW_TEXT_STRING_in_load_data_statement715); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TEXT_STRING.add(TEXT_STRING130);


                            }
                            break;

                    }

                    // SQLParser1.g:133:3: ( ( OPTIONALLY )? ENCLOSED BY_SYM TEXT_STRING )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==ENCLOSED||LA48_0==OPTIONALLY) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // SQLParser1.g:133:4: ( OPTIONALLY )? ENCLOSED BY_SYM TEXT_STRING
                            {
                            // SQLParser1.g:133:4: ( OPTIONALLY )?
                            int alt47=2;
                            int LA47_0 = input.LA(1);

                            if ( (LA47_0==OPTIONALLY) ) {
                                alt47=1;
                            }
                            switch (alt47) {
                                case 1 :
                                    // SQLParser1.g:133:5: OPTIONALLY
                                    {
                                    OPTIONALLY131=(Token)match(input,OPTIONALLY,FOLLOW_OPTIONALLY_in_load_data_statement723); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_OPTIONALLY.add(OPTIONALLY131);


                                    }
                                    break;

                            }

                            ENCLOSED132=(Token)match(input,ENCLOSED,FOLLOW_ENCLOSED_in_load_data_statement727); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ENCLOSED.add(ENCLOSED132);

                            BY_SYM133=(Token)match(input,BY_SYM,FOLLOW_BY_SYM_in_load_data_statement729); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY_SYM.add(BY_SYM133);

                            TEXT_STRING134=(Token)match(input,TEXT_STRING,FOLLOW_TEXT_STRING_in_load_data_statement731); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TEXT_STRING.add(TEXT_STRING134);


                            }
                            break;

                    }

                    // SQLParser1.g:134:3: ( ESCAPED BY_SYM TEXT_STRING )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==ESCAPED) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // SQLParser1.g:134:4: ESCAPED BY_SYM TEXT_STRING
                            {
                            ESCAPED135=(Token)match(input,ESCAPED,FOLLOW_ESCAPED_in_load_data_statement738); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ESCAPED.add(ESCAPED135);

                            BY_SYM136=(Token)match(input,BY_SYM,FOLLOW_BY_SYM_in_load_data_statement740); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY_SYM.add(BY_SYM136);

                            TEXT_STRING137=(Token)match(input,TEXT_STRING,FOLLOW_TEXT_STRING_in_load_data_statement742); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TEXT_STRING.add(TEXT_STRING137);


                            }
                            break;

                    }


                    }
                    break;

            }

            // SQLParser1.g:136:2: ( LINES ( STARTING BY_SYM TEXT_STRING )? ( TERMINATED BY_SYM TEXT_STRING )? )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==LINES) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // SQLParser1.g:137:3: LINES ( STARTING BY_SYM TEXT_STRING )? ( TERMINATED BY_SYM TEXT_STRING )?
                    {
                    LINES138=(Token)match(input,LINES,FOLLOW_LINES_in_load_data_statement755); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LINES.add(LINES138);

                    // SQLParser1.g:138:3: ( STARTING BY_SYM TEXT_STRING )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==STARTING) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // SQLParser1.g:138:4: STARTING BY_SYM TEXT_STRING
                            {
                            STARTING139=(Token)match(input,STARTING,FOLLOW_STARTING_in_load_data_statement760); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_STARTING.add(STARTING139);

                            BY_SYM140=(Token)match(input,BY_SYM,FOLLOW_BY_SYM_in_load_data_statement762); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY_SYM.add(BY_SYM140);

                            TEXT_STRING141=(Token)match(input,TEXT_STRING,FOLLOW_TEXT_STRING_in_load_data_statement764); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TEXT_STRING.add(TEXT_STRING141);


                            }
                            break;

                    }

                    // SQLParser1.g:139:3: ( TERMINATED BY_SYM TEXT_STRING )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==TERMINATED) ) {
                        alt52=1;
                    }
                    switch (alt52) {
                        case 1 :
                            // SQLParser1.g:139:4: TERMINATED BY_SYM TEXT_STRING
                            {
                            TERMINATED142=(Token)match(input,TERMINATED,FOLLOW_TERMINATED_in_load_data_statement771); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TERMINATED.add(TERMINATED142);

                            BY_SYM143=(Token)match(input,BY_SYM,FOLLOW_BY_SYM_in_load_data_statement773); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY_SYM.add(BY_SYM143);

                            TEXT_STRING144=(Token)match(input,TEXT_STRING,FOLLOW_TEXT_STRING_in_load_data_statement775); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_TEXT_STRING.add(TEXT_STRING144);


                            }
                            break;

                    }


                    }
                    break;

            }

            // SQLParser1.g:141:2: ( IGNORE_SYM INTEGER_NUM ( LINES | ROWS_SYM ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==IGNORE_SYM) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // SQLParser1.g:141:3: IGNORE_SYM INTEGER_NUM ( LINES | ROWS_SYM )
                    {
                    IGNORE_SYM145=(Token)match(input,IGNORE_SYM,FOLLOW_IGNORE_SYM_in_load_data_statement785); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IGNORE_SYM.add(IGNORE_SYM145);

                    INTEGER_NUM146=(Token)match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_load_data_statement787); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INTEGER_NUM.add(INTEGER_NUM146);

                    // SQLParser1.g:141:26: ( LINES | ROWS_SYM )
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==LINES) ) {
                        alt54=1;
                    }
                    else if ( (LA54_0==ROWS_SYM) ) {
                        alt54=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 0, input);

                        throw nvae;
                    }
                    switch (alt54) {
                        case 1 :
                            // SQLParser1.g:141:27: LINES
                            {
                            LINES147=(Token)match(input,LINES,FOLLOW_LINES_in_load_data_statement790); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LINES.add(LINES147);


                            }
                            break;
                        case 2 :
                            // SQLParser1.g:141:35: ROWS_SYM
                            {
                            ROWS_SYM148=(Token)match(input,ROWS_SYM,FOLLOW_ROWS_SYM_in_load_data_statement794); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ROWS_SYM.add(ROWS_SYM148);


                            }
                            break;

                    }


                    }
                    break;

            }

            // SQLParser1.g:142:2: ( LPAREN ( column_spec | USER_VAR ) ( COMMA ( column_spec | USER_VAR ) )* RPAREN )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==LPAREN) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // SQLParser1.g:142:3: LPAREN ( column_spec | USER_VAR ) ( COMMA ( column_spec | USER_VAR ) )* RPAREN
                    {
                    LPAREN149=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_load_data_statement801); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN149);

                    // SQLParser1.g:142:10: ( column_spec | USER_VAR )
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==ID) ) {
                        alt56=1;
                    }
                    else if ( (LA56_0==USER_VAR) ) {
                        alt56=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 56, 0, input);

                        throw nvae;
                    }
                    switch (alt56) {
                        case 1 :
                            // SQLParser1.g:142:11: column_spec
                            {
                            pushFollow(FOLLOW_column_spec_in_load_data_statement804);
                            column_spec150=gMySQL.column_spec();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_column_spec.add(column_spec150.getTree());

                            }
                            break;
                        case 2 :
                            // SQLParser1.g:142:23: USER_VAR
                            {
                            USER_VAR151=(Token)match(input,USER_VAR,FOLLOW_USER_VAR_in_load_data_statement806); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_USER_VAR.add(USER_VAR151);


                            }
                            break;

                    }

                    // SQLParser1.g:142:33: ( COMMA ( column_spec | USER_VAR ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==COMMA) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // SQLParser1.g:142:34: COMMA ( column_spec | USER_VAR )
                    	    {
                    	    COMMA152=(Token)match(input,COMMA,FOLLOW_COMMA_in_load_data_statement810); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA152);

                    	    // SQLParser1.g:142:40: ( column_spec | USER_VAR )
                    	    int alt57=2;
                    	    int LA57_0 = input.LA(1);

                    	    if ( (LA57_0==ID) ) {
                    	        alt57=1;
                    	    }
                    	    else if ( (LA57_0==USER_VAR) ) {
                    	        alt57=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 57, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt57) {
                    	        case 1 :
                    	            // SQLParser1.g:142:41: column_spec
                    	            {
                    	            pushFollow(FOLLOW_column_spec_in_load_data_statement813);
                    	            column_spec153=gMySQL.column_spec();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) stream_column_spec.add(column_spec153.getTree());

                    	            }
                    	            break;
                    	        case 2 :
                    	            // SQLParser1.g:142:53: USER_VAR
                    	            {
                    	            USER_VAR154=(Token)match(input,USER_VAR,FOLLOW_USER_VAR_in_load_data_statement815); if (state.failed) return retval; 
                    	            if ( state.backtracking==0 ) stream_USER_VAR.add(USER_VAR154);


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    RPAREN155=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_load_data_statement820); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN155);


                    }
                    break;

            }

            // SQLParser1.g:143:2: ( set_columns_cluase )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==SET_SYM) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // SQLParser1.g:143:3: set_columns_cluase
                    {
                    pushFollow(FOLLOW_set_columns_cluase_in_load_data_statement826);
                    set_columns_cluase156=set_columns_cluase();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_set_columns_cluase.add(set_columns_cluase156.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: table_spec, LOAD
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 144:2: -> ^( LOAD table_spec )
            {
                // SQLParser1.g:144:5: ^( LOAD table_spec )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_LOAD.nextNode(), root_1);

                adaptor.addChild(root_1, stream_table_spec.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 25, load_data_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "load_data_statement"

    public static class load_xml_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "load_xml_statement"
    // SQLParser1.g:148:1: load_xml_statement : LOAD XML_SYM ( LOW_PRIORITY | CONCURRENT )? ( LOCAL_SYM )? INFILE TEXT_STRING ( REPLACE | IGNORE_SYM )? INTO TABLE table_spec ( partition_clause )? ( CHARACTER_SYM SET_SYM charset_name )? ( ROWS_SYM IDENTIFIED_SYM BY_SYM TEXT_STRING )? ( IGNORE_SYM INTEGER_NUM ( LINES | ROWS_SYM ) )? ( LPAREN ( column_spec | USER_VAR ) ( COMMA ( column_spec | USER_VAR ) )* RPAREN )? ( set_columns_cluase )? ;
    public final MySQL_SQLParser1.load_xml_statement_return load_xml_statement() throws RecognitionException {
        MySQL_SQLParser1.load_xml_statement_return retval = new MySQL_SQLParser1.load_xml_statement_return();
        retval.start = input.LT(1);
        int load_xml_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LOAD157=null;
        Token XML_SYM158=null;
        Token set159=null;
        Token LOCAL_SYM160=null;
        Token INFILE161=null;
        Token TEXT_STRING162=null;
        Token set163=null;
        Token INTO164=null;
        Token TABLE165=null;
        Token CHARACTER_SYM168=null;
        Token SET_SYM169=null;
        Token ROWS_SYM171=null;
        Token IDENTIFIED_SYM172=null;
        Token BY_SYM173=null;
        Token TEXT_STRING174=null;
        Token IGNORE_SYM175=null;
        Token INTEGER_NUM176=null;
        Token set177=null;
        Token LPAREN178=null;
        Token USER_VAR180=null;
        Token COMMA181=null;
        Token USER_VAR183=null;
        Token RPAREN184=null;
        MySQLParser.table_spec_return table_spec166 = null;

        MySQLParser.partition_clause_return partition_clause167 = null;

        MySQLParser.charset_name_return charset_name170 = null;

        MySQLParser.column_spec_return column_spec179 = null;

        MySQLParser.column_spec_return column_spec182 = null;

        MySQL_SQLParser1.set_columns_cluase_return set_columns_cluase185 = null;


        CommonTree LOAD157_tree=null;
        CommonTree XML_SYM158_tree=null;
        CommonTree set159_tree=null;
        CommonTree LOCAL_SYM160_tree=null;
        CommonTree INFILE161_tree=null;
        CommonTree TEXT_STRING162_tree=null;
        CommonTree set163_tree=null;
        CommonTree INTO164_tree=null;
        CommonTree TABLE165_tree=null;
        CommonTree CHARACTER_SYM168_tree=null;
        CommonTree SET_SYM169_tree=null;
        CommonTree ROWS_SYM171_tree=null;
        CommonTree IDENTIFIED_SYM172_tree=null;
        CommonTree BY_SYM173_tree=null;
        CommonTree TEXT_STRING174_tree=null;
        CommonTree IGNORE_SYM175_tree=null;
        CommonTree INTEGER_NUM176_tree=null;
        CommonTree set177_tree=null;
        CommonTree LPAREN178_tree=null;
        CommonTree USER_VAR180_tree=null;
        CommonTree COMMA181_tree=null;
        CommonTree USER_VAR183_tree=null;
        CommonTree RPAREN184_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // SQLParser1.g:148:19: ( LOAD XML_SYM ( LOW_PRIORITY | CONCURRENT )? ( LOCAL_SYM )? INFILE TEXT_STRING ( REPLACE | IGNORE_SYM )? INTO TABLE table_spec ( partition_clause )? ( CHARACTER_SYM SET_SYM charset_name )? ( ROWS_SYM IDENTIFIED_SYM BY_SYM TEXT_STRING )? ( IGNORE_SYM INTEGER_NUM ( LINES | ROWS_SYM ) )? ( LPAREN ( column_spec | USER_VAR ) ( COMMA ( column_spec | USER_VAR ) )* RPAREN )? ( set_columns_cluase )? )
            // SQLParser1.g:149:2: LOAD XML_SYM ( LOW_PRIORITY | CONCURRENT )? ( LOCAL_SYM )? INFILE TEXT_STRING ( REPLACE | IGNORE_SYM )? INTO TABLE table_spec ( partition_clause )? ( CHARACTER_SYM SET_SYM charset_name )? ( ROWS_SYM IDENTIFIED_SYM BY_SYM TEXT_STRING )? ( IGNORE_SYM INTEGER_NUM ( LINES | ROWS_SYM ) )? ( LPAREN ( column_spec | USER_VAR ) ( COMMA ( column_spec | USER_VAR ) )* RPAREN )? ( set_columns_cluase )?
            {
            root_0 = (CommonTree)adaptor.nil();

            LOAD157=(Token)match(input,LOAD,FOLLOW_LOAD_in_load_xml_statement847); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD157_tree = (CommonTree)adaptor.create(LOAD157);
            adaptor.addChild(root_0, LOAD157_tree);
            }
            XML_SYM158=(Token)match(input,XML_SYM,FOLLOW_XML_SYM_in_load_xml_statement849); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            XML_SYM158_tree = (CommonTree)adaptor.create(XML_SYM158);
            adaptor.addChild(root_0, XML_SYM158_tree);
            }
            // SQLParser1.g:149:15: ( LOW_PRIORITY | CONCURRENT )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==CONCURRENT||LA61_0==LOW_PRIORITY) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // SQLParser1.g:
                    {
                    set159=(Token)input.LT(1);
                    if ( input.LA(1)==CONCURRENT||input.LA(1)==LOW_PRIORITY ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set159));
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

            // SQLParser1.g:149:44: ( LOCAL_SYM )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==LOCAL_SYM) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // SQLParser1.g:149:45: LOCAL_SYM
                    {
                    LOCAL_SYM160=(Token)match(input,LOCAL_SYM,FOLLOW_LOCAL_SYM_in_load_xml_statement861); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOCAL_SYM160_tree = (CommonTree)adaptor.create(LOCAL_SYM160);
                    adaptor.addChild(root_0, LOCAL_SYM160_tree);
                    }

                    }
                    break;

            }

            INFILE161=(Token)match(input,INFILE,FOLLOW_INFILE_in_load_xml_statement865); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INFILE161_tree = (CommonTree)adaptor.create(INFILE161);
            adaptor.addChild(root_0, INFILE161_tree);
            }
            TEXT_STRING162=(Token)match(input,TEXT_STRING,FOLLOW_TEXT_STRING_in_load_xml_statement867); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TEXT_STRING162_tree = (CommonTree)adaptor.create(TEXT_STRING162);
            adaptor.addChild(root_0, TEXT_STRING162_tree);
            }
            // SQLParser1.g:150:2: ( REPLACE | IGNORE_SYM )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==IGNORE_SYM||LA63_0==REPLACE) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // SQLParser1.g:
                    {
                    set163=(Token)input.LT(1);
                    if ( input.LA(1)==IGNORE_SYM||input.LA(1)==REPLACE ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set163));
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

            INTO164=(Token)match(input,INTO,FOLLOW_INTO_in_load_xml_statement880); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTO164_tree = (CommonTree)adaptor.create(INTO164);
            adaptor.addChild(root_0, INTO164_tree);
            }
            TABLE165=(Token)match(input,TABLE,FOLLOW_TABLE_in_load_xml_statement882); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TABLE165_tree = (CommonTree)adaptor.create(TABLE165);
            adaptor.addChild(root_0, TABLE165_tree);
            }
            pushFollow(FOLLOW_table_spec_in_load_xml_statement884);
            table_spec166=gMySQL.table_spec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_spec166.getTree());
            // SQLParser1.g:152:2: ( partition_clause )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==PARTITION_SYM) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // SQLParser1.g:152:3: partition_clause
                    {
                    pushFollow(FOLLOW_partition_clause_in_load_xml_statement888);
                    partition_clause167=gMySQL.partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, partition_clause167.getTree());

                    }
                    break;

            }

            // SQLParser1.g:153:2: ( CHARACTER_SYM SET_SYM charset_name )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==CHARACTER_SYM) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // SQLParser1.g:153:3: CHARACTER_SYM SET_SYM charset_name
                    {
                    CHARACTER_SYM168=(Token)match(input,CHARACTER_SYM,FOLLOW_CHARACTER_SYM_in_load_xml_statement894); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER_SYM168_tree = (CommonTree)adaptor.create(CHARACTER_SYM168);
                    adaptor.addChild(root_0, CHARACTER_SYM168_tree);
                    }
                    SET_SYM169=(Token)match(input,SET_SYM,FOLLOW_SET_SYM_in_load_xml_statement896); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET_SYM169_tree = (CommonTree)adaptor.create(SET_SYM169);
                    adaptor.addChild(root_0, SET_SYM169_tree);
                    }
                    pushFollow(FOLLOW_charset_name_in_load_xml_statement898);
                    charset_name170=gMySQL.charset_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, charset_name170.getTree());

                    }
                    break;

            }

            // SQLParser1.g:154:2: ( ROWS_SYM IDENTIFIED_SYM BY_SYM TEXT_STRING )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==ROWS_SYM) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // SQLParser1.g:154:3: ROWS_SYM IDENTIFIED_SYM BY_SYM TEXT_STRING
                    {
                    ROWS_SYM171=(Token)match(input,ROWS_SYM,FOLLOW_ROWS_SYM_in_load_xml_statement904); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROWS_SYM171_tree = (CommonTree)adaptor.create(ROWS_SYM171);
                    adaptor.addChild(root_0, ROWS_SYM171_tree);
                    }
                    IDENTIFIED_SYM172=(Token)match(input,IDENTIFIED_SYM,FOLLOW_IDENTIFIED_SYM_in_load_xml_statement906); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIED_SYM172_tree = (CommonTree)adaptor.create(IDENTIFIED_SYM172);
                    adaptor.addChild(root_0, IDENTIFIED_SYM172_tree);
                    }
                    BY_SYM173=(Token)match(input,BY_SYM,FOLLOW_BY_SYM_in_load_xml_statement908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY_SYM173_tree = (CommonTree)adaptor.create(BY_SYM173);
                    adaptor.addChild(root_0, BY_SYM173_tree);
                    }
                    TEXT_STRING174=(Token)match(input,TEXT_STRING,FOLLOW_TEXT_STRING_in_load_xml_statement910); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT_STRING174_tree = (CommonTree)adaptor.create(TEXT_STRING174);
                    adaptor.addChild(root_0, TEXT_STRING174_tree);
                    }

                    }
                    break;

            }

            // SQLParser1.g:155:2: ( IGNORE_SYM INTEGER_NUM ( LINES | ROWS_SYM ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==IGNORE_SYM) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // SQLParser1.g:155:3: IGNORE_SYM INTEGER_NUM ( LINES | ROWS_SYM )
                    {
                    IGNORE_SYM175=(Token)match(input,IGNORE_SYM,FOLLOW_IGNORE_SYM_in_load_xml_statement916); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IGNORE_SYM175_tree = (CommonTree)adaptor.create(IGNORE_SYM175);
                    adaptor.addChild(root_0, IGNORE_SYM175_tree);
                    }
                    INTEGER_NUM176=(Token)match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_load_xml_statement918); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER_NUM176_tree = (CommonTree)adaptor.create(INTEGER_NUM176);
                    adaptor.addChild(root_0, INTEGER_NUM176_tree);
                    }
                    set177=(Token)input.LT(1);
                    if ( input.LA(1)==LINES||input.LA(1)==ROWS_SYM ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set177));
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

            // SQLParser1.g:156:2: ( LPAREN ( column_spec | USER_VAR ) ( COMMA ( column_spec | USER_VAR ) )* RPAREN )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==LPAREN) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // SQLParser1.g:156:3: LPAREN ( column_spec | USER_VAR ) ( COMMA ( column_spec | USER_VAR ) )* RPAREN
                    {
                    LPAREN178=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_load_xml_statement932); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN178_tree = (CommonTree)adaptor.create(LPAREN178);
                    adaptor.addChild(root_0, LPAREN178_tree);
                    }
                    // SQLParser1.g:156:10: ( column_spec | USER_VAR )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==ID) ) {
                        alt68=1;
                    }
                    else if ( (LA68_0==USER_VAR) ) {
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
                            // SQLParser1.g:156:11: column_spec
                            {
                            pushFollow(FOLLOW_column_spec_in_load_xml_statement935);
                            column_spec179=gMySQL.column_spec();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec179.getTree());

                            }
                            break;
                        case 2 :
                            // SQLParser1.g:156:23: USER_VAR
                            {
                            USER_VAR180=(Token)match(input,USER_VAR,FOLLOW_USER_VAR_in_load_xml_statement937); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            USER_VAR180_tree = (CommonTree)adaptor.create(USER_VAR180);
                            adaptor.addChild(root_0, USER_VAR180_tree);
                            }

                            }
                            break;

                    }

                    // SQLParser1.g:156:33: ( COMMA ( column_spec | USER_VAR ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==COMMA) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // SQLParser1.g:156:34: COMMA ( column_spec | USER_VAR )
                    	    {
                    	    COMMA181=(Token)match(input,COMMA,FOLLOW_COMMA_in_load_xml_statement941); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    COMMA181_tree = (CommonTree)adaptor.create(COMMA181);
                    	    adaptor.addChild(root_0, COMMA181_tree);
                    	    }
                    	    // SQLParser1.g:156:40: ( column_spec | USER_VAR )
                    	    int alt69=2;
                    	    int LA69_0 = input.LA(1);

                    	    if ( (LA69_0==ID) ) {
                    	        alt69=1;
                    	    }
                    	    else if ( (LA69_0==USER_VAR) ) {
                    	        alt69=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 69, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt69) {
                    	        case 1 :
                    	            // SQLParser1.g:156:41: column_spec
                    	            {
                    	            pushFollow(FOLLOW_column_spec_in_load_xml_statement944);
                    	            column_spec182=gMySQL.column_spec();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec182.getTree());

                    	            }
                    	            break;
                    	        case 2 :
                    	            // SQLParser1.g:156:53: USER_VAR
                    	            {
                    	            USER_VAR183=(Token)match(input,USER_VAR,FOLLOW_USER_VAR_in_load_xml_statement946); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            USER_VAR183_tree = (CommonTree)adaptor.create(USER_VAR183);
                    	            adaptor.addChild(root_0, USER_VAR183_tree);
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);

                    RPAREN184=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_load_xml_statement951); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN184_tree = (CommonTree)adaptor.create(RPAREN184);
                    adaptor.addChild(root_0, RPAREN184_tree);
                    }

                    }
                    break;

            }

            // SQLParser1.g:157:2: ( set_columns_cluase )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==SET_SYM) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // SQLParser1.g:157:3: set_columns_cluase
                    {
                    pushFollow(FOLLOW_set_columns_cluase_in_load_xml_statement957);
                    set_columns_cluase185=set_columns_cluase();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_columns_cluase185.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 26, load_xml_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "load_xml_statement"

    public static class replace_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "replace_statement"
    // SQLParser1.g:161:1: replace_statement : replace_statement_header ( replace_statement1 | replace_statement2 | replace_statement3 ) ;
    public final MySQL_SQLParser1.replace_statement_return replace_statement() throws RecognitionException {
        MySQL_SQLParser1.replace_statement_return retval = new MySQL_SQLParser1.replace_statement_return();
        retval.start = input.LT(1);
        int replace_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQL_SQLParser1.replace_statement_header_return replace_statement_header186 = null;

        MySQL_SQLParser1.replace_statement1_return replace_statement1187 = null;

        MySQL_SQLParser1.replace_statement2_return replace_statement2188 = null;

        MySQL_SQLParser1.replace_statement3_return replace_statement3189 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // SQLParser1.g:161:18: ( replace_statement_header ( replace_statement1 | replace_statement2 | replace_statement3 ) )
            // SQLParser1.g:162:2: replace_statement_header ( replace_statement1 | replace_statement2 | replace_statement3 )
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_replace_statement_header_in_replace_statement969);
            replace_statement_header186=replace_statement_header();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, replace_statement_header186.getTree());
            // SQLParser1.g:163:2: ( replace_statement1 | replace_statement2 | replace_statement3 )
            int alt73=3;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // SQLParser1.g:163:4: replace_statement1
                    {
                    pushFollow(FOLLOW_replace_statement1_in_replace_statement974);
                    replace_statement1187=replace_statement1();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, replace_statement1187.getTree());

                    }
                    break;
                case 2 :
                    // SQLParser1.g:163:25: replace_statement2
                    {
                    pushFollow(FOLLOW_replace_statement2_in_replace_statement978);
                    replace_statement2188=replace_statement2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, replace_statement2188.getTree());

                    }
                    break;
                case 3 :
                    // SQLParser1.g:163:46: replace_statement3
                    {
                    pushFollow(FOLLOW_replace_statement3_in_replace_statement982);
                    replace_statement3189=replace_statement3();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, replace_statement3189.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 27, replace_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "replace_statement"

    public static class replace_statement_header_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "replace_statement_header"
    // SQLParser1.g:166:1: replace_statement_header : REPLACE replace_statement_expression -> ^( TN_REPLACE replace_statement_expression ) ;
    public final MySQL_SQLParser1.replace_statement_header_return replace_statement_header() throws RecognitionException {
        MySQL_SQLParser1.replace_statement_header_return retval = new MySQL_SQLParser1.replace_statement_header_return();
        retval.start = input.LT(1);
        int replace_statement_header_StartIndex = input.index();
        CommonTree root_0 = null;

        Token REPLACE190=null;
        MySQL_SQLParser1.replace_statement_expression_return replace_statement_expression191 = null;


        CommonTree REPLACE190_tree=null;
        RewriteRuleTokenStream stream_REPLACE=new RewriteRuleTokenStream(adaptor,"token REPLACE");
        RewriteRuleSubtreeStream stream_replace_statement_expression=new RewriteRuleSubtreeStream(adaptor,"rule replace_statement_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // SQLParser1.g:166:25: ( REPLACE replace_statement_expression -> ^( TN_REPLACE replace_statement_expression ) )
            // SQLParser1.g:167:2: REPLACE replace_statement_expression
            {
            REPLACE190=(Token)match(input,REPLACE,FOLLOW_REPLACE_in_replace_statement_header993); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_REPLACE.add(REPLACE190);

            pushFollow(FOLLOW_replace_statement_expression_in_replace_statement_header995);
            replace_statement_expression191=replace_statement_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_replace_statement_expression.add(replace_statement_expression191.getTree());


            // AST REWRITE
            // elements: replace_statement_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 167:39: -> ^( TN_REPLACE replace_statement_expression )
            {
                // SQLParser1.g:167:42: ^( TN_REPLACE replace_statement_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_REPLACE, "TN_REPLACE"), root_1);

                adaptor.addChild(root_1, stream_replace_statement_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 28, replace_statement_header_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "replace_statement_header"

    public static class replace_statement_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "replace_statement_expression"
    // SQLParser1.g:170:1: replace_statement_expression : ( LOW_PRIORITY | DELAYED_SYM )? ( INTO )? table_name ( partition_clause )? ;
    public final MySQL_SQLParser1.replace_statement_expression_return replace_statement_expression() throws RecognitionException {
        MySQL_SQLParser1.replace_statement_expression_return retval = new MySQL_SQLParser1.replace_statement_expression_return();
        retval.start = input.LT(1);
        int replace_statement_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set192=null;
        Token INTO193=null;
        MySQLParser.table_name_return table_name194 = null;

        MySQLParser.partition_clause_return partition_clause195 = null;


        CommonTree set192_tree=null;
        CommonTree INTO193_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // SQLParser1.g:170:29: ( ( LOW_PRIORITY | DELAYED_SYM )? ( INTO )? table_name ( partition_clause )? )
            // SQLParser1.g:171:2: ( LOW_PRIORITY | DELAYED_SYM )? ( INTO )? table_name ( partition_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:171:2: ( LOW_PRIORITY | DELAYED_SYM )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==DELAYED_SYM||LA74_0==LOW_PRIORITY) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // SQLParser1.g:
                    {
                    set192=(Token)input.LT(1);
                    if ( input.LA(1)==DELAYED_SYM||input.LA(1)==LOW_PRIORITY ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set192));
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

            // SQLParser1.g:172:2: ( INTO )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==INTO) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // SQLParser1.g:172:3: INTO
                    {
                    INTO193=(Token)match(input,INTO,FOLLOW_INTO_in_replace_statement_expression1023); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO193_tree = (CommonTree)adaptor.create(INTO193);
                    adaptor.addChild(root_0, INTO193_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_table_name_in_replace_statement_expression1027);
            table_name194=gMySQL.table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name194.getTree());
            // SQLParser1.g:173:2: ( partition_clause )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==PARTITION_SYM) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // SQLParser1.g:173:3: partition_clause
                    {
                    pushFollow(FOLLOW_partition_clause_in_replace_statement_expression1031);
                    partition_clause195=gMySQL.partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, partition_clause195.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 29, replace_statement_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "replace_statement_expression"

    public static class replace_statement1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "replace_statement1"
    // SQLParser1.g:176:1: replace_statement1 : ( column_list )? value_list_clause ;
    public final MySQL_SQLParser1.replace_statement1_return replace_statement1() throws RecognitionException {
        MySQL_SQLParser1.replace_statement1_return retval = new MySQL_SQLParser1.replace_statement1_return();
        retval.start = input.LT(1);
        int replace_statement1_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQLParser.column_list_return column_list196 = null;

        MySQL_SQLParser1.value_list_clause_return value_list_clause197 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // SQLParser1.g:176:19: ( ( column_list )? value_list_clause )
            // SQLParser1.g:177:2: ( column_list )? value_list_clause
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:177:2: ( column_list )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==LPAREN) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // SQLParser1.g:177:3: column_list
                    {
                    pushFollow(FOLLOW_column_list_in_replace_statement11044);
                    column_list196=gMySQL.column_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_list196.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_value_list_clause_in_replace_statement11049);
            value_list_clause197=value_list_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, value_list_clause197.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 30, replace_statement1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "replace_statement1"

    public static class replace_statement2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "replace_statement2"
    // SQLParser1.g:181:1: replace_statement2 : set_columns_cluase ;
    public final MySQL_SQLParser1.replace_statement2_return replace_statement2() throws RecognitionException {
        MySQL_SQLParser1.replace_statement2_return retval = new MySQL_SQLParser1.replace_statement2_return();
        retval.start = input.LT(1);
        int replace_statement2_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQL_SQLParser1.set_columns_cluase_return set_columns_cluase198 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // SQLParser1.g:181:19: ( set_columns_cluase )
            // SQLParser1.g:182:2: set_columns_cluase
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_set_columns_cluase_in_replace_statement21058);
            set_columns_cluase198=set_columns_cluase();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, set_columns_cluase198.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 31, replace_statement2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "replace_statement2"

    public static class replace_statement3_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "replace_statement3"
    // SQLParser1.g:185:1: replace_statement3 : ( column_list )? select_statement ;
    public final MySQL_SQLParser1.replace_statement3_return replace_statement3() throws RecognitionException {
        MySQL_SQLParser1.replace_statement3_return retval = new MySQL_SQLParser1.replace_statement3_return();
        retval.start = input.LT(1);
        int replace_statement3_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQLParser.column_list_return column_list199 = null;

        MySQLParser.select_statement_return select_statement200 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // SQLParser1.g:185:19: ( ( column_list )? select_statement )
            // SQLParser1.g:186:2: ( column_list )? select_statement
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:186:2: ( column_list )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==LPAREN) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // SQLParser1.g:186:3: column_list
                    {
                    pushFollow(FOLLOW_column_list_in_replace_statement31068);
                    column_list199=gMySQL.column_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_list199.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_select_statement_in_replace_statement31073);
            select_statement200=gMySQL.select_statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, select_statement200.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 32, replace_statement3_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "replace_statement3"

    public static class create_database_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_database_statement"
    // SQLParser1.g:191:1: create_database_statement : CREATE create_database_expression -> ^( TN_CREATE create_database_expression ) ;
    public final MySQL_SQLParser1.create_database_statement_return create_database_statement() throws RecognitionException {
        MySQL_SQLParser1.create_database_statement_return retval = new MySQL_SQLParser1.create_database_statement_return();
        retval.start = input.LT(1);
        int create_database_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CREATE201=null;
        MySQL_SQLParser1.create_database_expression_return create_database_expression202 = null;


        CommonTree CREATE201_tree=null;
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleSubtreeStream stream_create_database_expression=new RewriteRuleSubtreeStream(adaptor,"rule create_database_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // SQLParser1.g:191:26: ( CREATE create_database_expression -> ^( TN_CREATE create_database_expression ) )
            // SQLParser1.g:192:2: CREATE create_database_expression
            {
            CREATE201=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_database_statement1083); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE201);

            pushFollow(FOLLOW_create_database_expression_in_create_database_statement1085);
            create_database_expression202=create_database_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_create_database_expression.add(create_database_expression202.getTree());


            // AST REWRITE
            // elements: create_database_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 192:36: -> ^( TN_CREATE create_database_expression )
            {
                // SQLParser1.g:192:39: ^( TN_CREATE create_database_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_CREATE, "TN_CREATE"), root_1);

                adaptor.addChild(root_1, stream_create_database_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 33, create_database_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "create_database_statement"

    public static class create_database_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_database_expression"
    // SQLParser1.g:194:1: create_database_expression : ( DATABASE | SCHEMA ) ( IF NOT_SYM EXISTS )? schema_name ( create_specification ( COMMA create_specification )* )* ;
    public final MySQL_SQLParser1.create_database_expression_return create_database_expression() throws RecognitionException {
        MySQL_SQLParser1.create_database_expression_return retval = new MySQL_SQLParser1.create_database_expression_return();
        retval.start = input.LT(1);
        int create_database_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set203=null;
        Token IF204=null;
        Token NOT_SYM205=null;
        Token EXISTS206=null;
        Token COMMA209=null;
        MySQLParser.schema_name_return schema_name207 = null;

        MySQL_SQLParser1.create_specification_return create_specification208 = null;

        MySQL_SQLParser1.create_specification_return create_specification210 = null;


        CommonTree set203_tree=null;
        CommonTree IF204_tree=null;
        CommonTree NOT_SYM205_tree=null;
        CommonTree EXISTS206_tree=null;
        CommonTree COMMA209_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // SQLParser1.g:194:27: ( ( DATABASE | SCHEMA ) ( IF NOT_SYM EXISTS )? schema_name ( create_specification ( COMMA create_specification )* )* )
            // SQLParser1.g:195:2: ( DATABASE | SCHEMA ) ( IF NOT_SYM EXISTS )? schema_name ( create_specification ( COMMA create_specification )* )*
            {
            root_0 = (CommonTree)adaptor.nil();

            set203=(Token)input.LT(1);
            if ( input.LA(1)==DATABASE||input.LA(1)==SCHEMA ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set203));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // SQLParser1.g:195:22: ( IF NOT_SYM EXISTS )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==IF) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // SQLParser1.g:195:23: IF NOT_SYM EXISTS
                    {
                    IF204=(Token)match(input,IF,FOLLOW_IF_in_create_database_expression1110); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF204_tree = (CommonTree)adaptor.create(IF204);
                    adaptor.addChild(root_0, IF204_tree);
                    }
                    NOT_SYM205=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_create_database_expression1112); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT_SYM205_tree = (CommonTree)adaptor.create(NOT_SYM205);
                    adaptor.addChild(root_0, NOT_SYM205_tree);
                    }
                    EXISTS206=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_create_database_expression1114); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXISTS206_tree = (CommonTree)adaptor.create(EXISTS206);
                    adaptor.addChild(root_0, EXISTS206_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_schema_name_in_create_database_expression1118);
            schema_name207=gMySQL.schema_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, schema_name207.getTree());
            // SQLParser1.g:196:2: ( create_specification ( COMMA create_specification )* )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==CHARACTER_SYM||LA81_0==COLLATE_SYM||LA81_0==DEFAULT) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // SQLParser1.g:196:4: create_specification ( COMMA create_specification )*
            	    {
            	    pushFollow(FOLLOW_create_specification_in_create_database_expression1123);
            	    create_specification208=create_specification();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_specification208.getTree());
            	    // SQLParser1.g:196:25: ( COMMA create_specification )*
            	    loop80:
            	    do {
            	        int alt80=2;
            	        int LA80_0 = input.LA(1);

            	        if ( (LA80_0==COMMA) ) {
            	            alt80=1;
            	        }


            	        switch (alt80) {
            	    	case 1 :
            	    	    // SQLParser1.g:196:26: COMMA create_specification
            	    	    {
            	    	    COMMA209=(Token)match(input,COMMA,FOLLOW_COMMA_in_create_database_expression1126); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    COMMA209_tree = (CommonTree)adaptor.create(COMMA209);
            	    	    adaptor.addChild(root_0, COMMA209_tree);
            	    	    }
            	    	    pushFollow(FOLLOW_create_specification_in_create_database_expression1128);
            	    	    create_specification210=create_specification();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_specification210.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop80;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop81;
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
            if ( state.backtracking>0 ) { memoize(input, 34, create_database_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "create_database_expression"

    public static class create_specification_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_specification"
    // SQLParser1.g:198:1: create_specification : ( DEFAULT )? ( ( CHARACTER_SYM SET_SYM ( EQ_SYM )? charset_name ) | ( COLLATE_SYM ( EQ_SYM )? collation_name ) ) ;
    public final MySQL_SQLParser1.create_specification_return create_specification() throws RecognitionException {
        MySQL_SQLParser1.create_specification_return retval = new MySQL_SQLParser1.create_specification_return();
        retval.start = input.LT(1);
        int create_specification_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DEFAULT211=null;
        Token CHARACTER_SYM212=null;
        Token SET_SYM213=null;
        Token EQ_SYM214=null;
        Token COLLATE_SYM216=null;
        Token EQ_SYM217=null;
        MySQLParser.charset_name_return charset_name215 = null;

        MySQLParser.collation_name_return collation_name218 = null;


        CommonTree DEFAULT211_tree=null;
        CommonTree CHARACTER_SYM212_tree=null;
        CommonTree SET_SYM213_tree=null;
        CommonTree EQ_SYM214_tree=null;
        CommonTree COLLATE_SYM216_tree=null;
        CommonTree EQ_SYM217_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // SQLParser1.g:198:21: ( ( DEFAULT )? ( ( CHARACTER_SYM SET_SYM ( EQ_SYM )? charset_name ) | ( COLLATE_SYM ( EQ_SYM )? collation_name ) ) )
            // SQLParser1.g:199:2: ( DEFAULT )? ( ( CHARACTER_SYM SET_SYM ( EQ_SYM )? charset_name ) | ( COLLATE_SYM ( EQ_SYM )? collation_name ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:199:2: ( DEFAULT )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==DEFAULT) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // SQLParser1.g:199:3: DEFAULT
                    {
                    DEFAULT211=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_create_specification1142); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFAULT211_tree = (CommonTree)adaptor.create(DEFAULT211);
                    adaptor.addChild(root_0, DEFAULT211_tree);
                    }

                    }
                    break;

            }

            // SQLParser1.g:200:2: ( ( CHARACTER_SYM SET_SYM ( EQ_SYM )? charset_name ) | ( COLLATE_SYM ( EQ_SYM )? collation_name ) )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==CHARACTER_SYM) ) {
                alt85=1;
            }
            else if ( (LA85_0==COLLATE_SYM) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // SQLParser1.g:201:3: ( CHARACTER_SYM SET_SYM ( EQ_SYM )? charset_name )
                    {
                    // SQLParser1.g:201:3: ( CHARACTER_SYM SET_SYM ( EQ_SYM )? charset_name )
                    // SQLParser1.g:201:6: CHARACTER_SYM SET_SYM ( EQ_SYM )? charset_name
                    {
                    CHARACTER_SYM212=(Token)match(input,CHARACTER_SYM,FOLLOW_CHARACTER_SYM_in_create_specification1155); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER_SYM212_tree = (CommonTree)adaptor.create(CHARACTER_SYM212);
                    adaptor.addChild(root_0, CHARACTER_SYM212_tree);
                    }
                    SET_SYM213=(Token)match(input,SET_SYM,FOLLOW_SET_SYM_in_create_specification1157); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET_SYM213_tree = (CommonTree)adaptor.create(SET_SYM213);
                    adaptor.addChild(root_0, SET_SYM213_tree);
                    }
                    // SQLParser1.g:201:28: ( EQ_SYM )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==EQ_SYM) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // SQLParser1.g:201:29: EQ_SYM
                            {
                            EQ_SYM214=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_create_specification1160); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            EQ_SYM214_tree = (CommonTree)adaptor.create(EQ_SYM214);
                            adaptor.addChild(root_0, EQ_SYM214_tree);
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_charset_name_in_create_specification1164);
                    charset_name215=gMySQL.charset_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, charset_name215.getTree());

                    }


                    }
                    break;
                case 2 :
                    // SQLParser1.g:203:3: ( COLLATE_SYM ( EQ_SYM )? collation_name )
                    {
                    // SQLParser1.g:203:3: ( COLLATE_SYM ( EQ_SYM )? collation_name )
                    // SQLParser1.g:203:6: COLLATE_SYM ( EQ_SYM )? collation_name
                    {
                    COLLATE_SYM216=(Token)match(input,COLLATE_SYM,FOLLOW_COLLATE_SYM_in_create_specification1178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLLATE_SYM216_tree = (CommonTree)adaptor.create(COLLATE_SYM216);
                    adaptor.addChild(root_0, COLLATE_SYM216_tree);
                    }
                    // SQLParser1.g:203:18: ( EQ_SYM )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==EQ_SYM) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // SQLParser1.g:203:19: EQ_SYM
                            {
                            EQ_SYM217=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_create_specification1181); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            EQ_SYM217_tree = (CommonTree)adaptor.create(EQ_SYM217);
                            adaptor.addChild(root_0, EQ_SYM217_tree);
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_collation_name_in_create_specification1185);
                    collation_name218=gMySQL.collation_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collation_name218.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 35, create_specification_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "create_specification"

    public static class alter_database_statements_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alter_database_statements"
    // SQLParser1.g:208:1: alter_database_statements : ALTER alter_database_expression -> ^( TN_ALTER alter_database_expression ) ;
    public final MySQL_SQLParser1.alter_database_statements_return alter_database_statements() throws RecognitionException {
        MySQL_SQLParser1.alter_database_statements_return retval = new MySQL_SQLParser1.alter_database_statements_return();
        retval.start = input.LT(1);
        int alter_database_statements_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ALTER219=null;
        MySQL_SQLParser1.alter_database_expression_return alter_database_expression220 = null;


        CommonTree ALTER219_tree=null;
        RewriteRuleTokenStream stream_ALTER=new RewriteRuleTokenStream(adaptor,"token ALTER");
        RewriteRuleSubtreeStream stream_alter_database_expression=new RewriteRuleSubtreeStream(adaptor,"rule alter_database_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // SQLParser1.g:208:26: ( ALTER alter_database_expression -> ^( TN_ALTER alter_database_expression ) )
            // SQLParser1.g:209:2: ALTER alter_database_expression
            {
            ALTER219=(Token)match(input,ALTER,FOLLOW_ALTER_in_alter_database_statements1201); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ALTER.add(ALTER219);

            pushFollow(FOLLOW_alter_database_expression_in_alter_database_statements1203);
            alter_database_expression220=alter_database_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_alter_database_expression.add(alter_database_expression220.getTree());


            // AST REWRITE
            // elements: alter_database_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 209:34: -> ^( TN_ALTER alter_database_expression )
            {
                // SQLParser1.g:209:37: ^( TN_ALTER alter_database_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_ALTER, "TN_ALTER"), root_1);

                adaptor.addChild(root_1, stream_alter_database_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 36, alter_database_statements_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alter_database_statements"

    public static class alter_database_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alter_database_expression"
    // SQLParser1.g:211:1: alter_database_expression : ( alter_database_statement1 | alter_database_statement2 );
    public final MySQL_SQLParser1.alter_database_expression_return alter_database_expression() throws RecognitionException {
        MySQL_SQLParser1.alter_database_expression_return retval = new MySQL_SQLParser1.alter_database_expression_return();
        retval.start = input.LT(1);
        int alter_database_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        MySQL_SQLParser1.alter_database_statement1_return alter_database_statement1221 = null;

        MySQL_SQLParser1.alter_database_statement2_return alter_database_statement2222 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // SQLParser1.g:211:26: ( alter_database_statement1 | alter_database_statement2 )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==DATABASE||LA86_0==SCHEMA) ) {
                int LA86_1 = input.LA(2);

                if ( (LA86_1==ID) ) {
                    int LA86_2 = input.LA(3);

                    if ( (LA86_2==UPGRADE_SYM) ) {
                        alt86=2;
                    }
                    else if ( (LA86_2==CHARACTER_SYM||LA86_2==COLLATE_SYM||LA86_2==DEFAULT) ) {
                        alt86=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 86, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA86_1==CHARACTER_SYM||LA86_1==COLLATE_SYM||LA86_1==DEFAULT) ) {
                    alt86=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // SQLParser1.g:212:2: alter_database_statement1
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_alter_database_statement1_in_alter_database_expression1219);
                    alter_database_statement1221=alter_database_statement1();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, alter_database_statement1221.getTree());

                    }
                    break;
                case 2 :
                    // SQLParser1.g:212:30: alter_database_statement2
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_alter_database_statement2_in_alter_database_expression1223);
                    alter_database_statement2222=alter_database_statement2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, alter_database_statement2222.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 37, alter_database_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alter_database_expression"

    public static class alter_database_statement1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alter_database_statement1"
    // SQLParser1.g:214:1: alter_database_statement1 : ( DATABASE | SCHEMA ) ( schema_name )? alter_database_specification ;
    public final MySQL_SQLParser1.alter_database_statement1_return alter_database_statement1() throws RecognitionException {
        MySQL_SQLParser1.alter_database_statement1_return retval = new MySQL_SQLParser1.alter_database_statement1_return();
        retval.start = input.LT(1);
        int alter_database_statement1_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set223=null;
        MySQLParser.schema_name_return schema_name224 = null;

        MySQL_SQLParser1.alter_database_specification_return alter_database_specification225 = null;


        CommonTree set223_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // SQLParser1.g:214:26: ( ( DATABASE | SCHEMA ) ( schema_name )? alter_database_specification )
            // SQLParser1.g:215:2: ( DATABASE | SCHEMA ) ( schema_name )? alter_database_specification
            {
            root_0 = (CommonTree)adaptor.nil();

            set223=(Token)input.LT(1);
            if ( input.LA(1)==DATABASE||input.LA(1)==SCHEMA ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set223));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // SQLParser1.g:215:22: ( schema_name )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==ID) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // SQLParser1.g:215:23: schema_name
                    {
                    pushFollow(FOLLOW_schema_name_in_alter_database_statement11240);
                    schema_name224=gMySQL.schema_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, schema_name224.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_alter_database_specification_in_alter_database_statement11245);
            alter_database_specification225=alter_database_specification();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, alter_database_specification225.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 38, alter_database_statement1_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alter_database_statement1"

    public static class alter_database_statement2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alter_database_statement2"
    // SQLParser1.g:218:1: alter_database_statement2 : ( DATABASE | SCHEMA ) schema_name UPGRADE_SYM DATA_SYM DIRECTORY_SYM N_ A_ M_ E_ ;
    public final MySQL_SQLParser1.alter_database_statement2_return alter_database_statement2() throws RecognitionException {
        MySQL_SQLParser1.alter_database_statement2_return retval = new MySQL_SQLParser1.alter_database_statement2_return();
        retval.start = input.LT(1);
        int alter_database_statement2_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set226=null;
        Token UPGRADE_SYM228=null;
        Token DATA_SYM229=null;
        Token DIRECTORY_SYM230=null;
        Token N_231=null;
        Token A_232=null;
        Token M_233=null;
        Token E_234=null;
        MySQLParser.schema_name_return schema_name227 = null;


        CommonTree set226_tree=null;
        CommonTree UPGRADE_SYM228_tree=null;
        CommonTree DATA_SYM229_tree=null;
        CommonTree DIRECTORY_SYM230_tree=null;
        CommonTree N_231_tree=null;
        CommonTree A_232_tree=null;
        CommonTree M_233_tree=null;
        CommonTree E_234_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // SQLParser1.g:218:26: ( ( DATABASE | SCHEMA ) schema_name UPGRADE_SYM DATA_SYM DIRECTORY_SYM N_ A_ M_ E_ )
            // SQLParser1.g:219:2: ( DATABASE | SCHEMA ) schema_name UPGRADE_SYM DATA_SYM DIRECTORY_SYM N_ A_ M_ E_
            {
            root_0 = (CommonTree)adaptor.nil();

            set226=(Token)input.LT(1);
            if ( input.LA(1)==DATABASE||input.LA(1)==SCHEMA ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set226));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_schema_name_in_alter_database_statement21261);
            schema_name227=gMySQL.schema_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, schema_name227.getTree());
            UPGRADE_SYM228=(Token)match(input,UPGRADE_SYM,FOLLOW_UPGRADE_SYM_in_alter_database_statement21264); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPGRADE_SYM228_tree = (CommonTree)adaptor.create(UPGRADE_SYM228);
            adaptor.addChild(root_0, UPGRADE_SYM228_tree);
            }
            DATA_SYM229=(Token)match(input,DATA_SYM,FOLLOW_DATA_SYM_in_alter_database_statement21266); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DATA_SYM229_tree = (CommonTree)adaptor.create(DATA_SYM229);
            adaptor.addChild(root_0, DATA_SYM229_tree);
            }
            DIRECTORY_SYM230=(Token)match(input,DIRECTORY_SYM,FOLLOW_DIRECTORY_SYM_in_alter_database_statement21268); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DIRECTORY_SYM230_tree = (CommonTree)adaptor.create(DIRECTORY_SYM230);
            adaptor.addChild(root_0, DIRECTORY_SYM230_tree);
            }
            N_231=(Token)match(input,N_,FOLLOW_N__in_alter_database_statement21270); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            N_231_tree = (CommonTree)adaptor.create(N_231);
            adaptor.addChild(root_0, N_231_tree);
            }
            A_232=(Token)match(input,A_,FOLLOW_A__in_alter_database_statement21272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            A_232_tree = (CommonTree)adaptor.create(A_232);
            adaptor.addChild(root_0, A_232_tree);
            }
            M_233=(Token)match(input,M_,FOLLOW_M__in_alter_database_statement21274); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            M_233_tree = (CommonTree)adaptor.create(M_233);
            adaptor.addChild(root_0, M_233_tree);
            }
            E_234=(Token)match(input,E_,FOLLOW_E__in_alter_database_statement21276); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            E_234_tree = (CommonTree)adaptor.create(E_234);
            adaptor.addChild(root_0, E_234_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 39, alter_database_statement2_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alter_database_statement2"

    public static class alter_database_specification_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alter_database_specification"
    // SQLParser1.g:222:1: alter_database_specification : ( ( DEFAULT )? CHARACTER_SYM SET_SYM ( EQ_SYM )? charset_name | ( DEFAULT )? COLLATE_SYM ( EQ_SYM )? collation_names );
    public final MySQL_SQLParser1.alter_database_specification_return alter_database_specification() throws RecognitionException {
        MySQL_SQLParser1.alter_database_specification_return retval = new MySQL_SQLParser1.alter_database_specification_return();
        retval.start = input.LT(1);
        int alter_database_specification_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DEFAULT235=null;
        Token CHARACTER_SYM236=null;
        Token SET_SYM237=null;
        Token EQ_SYM238=null;
        Token DEFAULT240=null;
        Token COLLATE_SYM241=null;
        Token EQ_SYM242=null;
        MySQLParser.charset_name_return charset_name239 = null;

        MySQLParser.collation_names_return collation_names243 = null;


        CommonTree DEFAULT235_tree=null;
        CommonTree CHARACTER_SYM236_tree=null;
        CommonTree SET_SYM237_tree=null;
        CommonTree EQ_SYM238_tree=null;
        CommonTree DEFAULT240_tree=null;
        CommonTree COLLATE_SYM241_tree=null;
        CommonTree EQ_SYM242_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // SQLParser1.g:222:29: ( ( DEFAULT )? CHARACTER_SYM SET_SYM ( EQ_SYM )? charset_name | ( DEFAULT )? COLLATE_SYM ( EQ_SYM )? collation_names )
            int alt92=2;
            switch ( input.LA(1) ) {
            case DEFAULT:
                {
                int LA92_1 = input.LA(2);

                if ( (LA92_1==CHARACTER_SYM) ) {
                    alt92=1;
                }
                else if ( (LA92_1==COLLATE_SYM) ) {
                    alt92=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 92, 1, input);

                    throw nvae;
                }
                }
                break;
            case CHARACTER_SYM:
                {
                alt92=1;
                }
                break;
            case COLLATE_SYM:
                {
                alt92=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // SQLParser1.g:223:2: ( DEFAULT )? CHARACTER_SYM SET_SYM ( EQ_SYM )? charset_name
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:223:2: ( DEFAULT )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==DEFAULT) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // SQLParser1.g:223:3: DEFAULT
                            {
                            DEFAULT235=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_alter_database_specification1285); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DEFAULT235_tree = (CommonTree)adaptor.create(DEFAULT235);
                            adaptor.addChild(root_0, DEFAULT235_tree);
                            }

                            }
                            break;

                    }

                    CHARACTER_SYM236=(Token)match(input,CHARACTER_SYM,FOLLOW_CHARACTER_SYM_in_alter_database_specification1289); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER_SYM236_tree = (CommonTree)adaptor.create(CHARACTER_SYM236);
                    adaptor.addChild(root_0, CHARACTER_SYM236_tree);
                    }
                    SET_SYM237=(Token)match(input,SET_SYM,FOLLOW_SET_SYM_in_alter_database_specification1291); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET_SYM237_tree = (CommonTree)adaptor.create(SET_SYM237);
                    adaptor.addChild(root_0, SET_SYM237_tree);
                    }
                    // SQLParser1.g:223:35: ( EQ_SYM )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==EQ_SYM) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // SQLParser1.g:223:36: EQ_SYM
                            {
                            EQ_SYM238=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_alter_database_specification1294); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            EQ_SYM238_tree = (CommonTree)adaptor.create(EQ_SYM238);
                            adaptor.addChild(root_0, EQ_SYM238_tree);
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_charset_name_in_alter_database_specification1298);
                    charset_name239=gMySQL.charset_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, charset_name239.getTree());

                    }
                    break;
                case 2 :
                    // SQLParser1.g:225:2: ( DEFAULT )? COLLATE_SYM ( EQ_SYM )? collation_names
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:225:2: ( DEFAULT )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==DEFAULT) ) {
                        alt90=1;
                    }
                    switch (alt90) {
                        case 1 :
                            // SQLParser1.g:225:3: DEFAULT
                            {
                            DEFAULT240=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_alter_database_specification1306); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DEFAULT240_tree = (CommonTree)adaptor.create(DEFAULT240);
                            adaptor.addChild(root_0, DEFAULT240_tree);
                            }

                            }
                            break;

                    }

                    COLLATE_SYM241=(Token)match(input,COLLATE_SYM,FOLLOW_COLLATE_SYM_in_alter_database_specification1310); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLLATE_SYM241_tree = (CommonTree)adaptor.create(COLLATE_SYM241);
                    adaptor.addChild(root_0, COLLATE_SYM241_tree);
                    }
                    // SQLParser1.g:225:25: ( EQ_SYM )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==EQ_SYM) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // SQLParser1.g:225:26: EQ_SYM
                            {
                            EQ_SYM242=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_alter_database_specification1313); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            EQ_SYM242_tree = (CommonTree)adaptor.create(EQ_SYM242);
                            adaptor.addChild(root_0, EQ_SYM242_tree);
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_collation_names_in_alter_database_specification1317);
                    collation_names243=gMySQL.collation_names();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collation_names243.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 40, alter_database_specification_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alter_database_specification"

    public static class drop_database_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_database_statement"
    // SQLParser1.g:230:1: drop_database_statement : DROP drop_database_expression -> ^( TN_DROP drop_database_expression ) ;
    public final MySQL_SQLParser1.drop_database_statement_return drop_database_statement() throws RecognitionException {
        MySQL_SQLParser1.drop_database_statement_return retval = new MySQL_SQLParser1.drop_database_statement_return();
        retval.start = input.LT(1);
        int drop_database_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DROP244=null;
        MySQL_SQLParser1.drop_database_expression_return drop_database_expression245 = null;


        CommonTree DROP244_tree=null;
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleSubtreeStream stream_drop_database_expression=new RewriteRuleSubtreeStream(adaptor,"rule drop_database_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // SQLParser1.g:230:24: ( DROP drop_database_expression -> ^( TN_DROP drop_database_expression ) )
            // SQLParser1.g:231:2: DROP drop_database_expression
            {
            DROP244=(Token)match(input,DROP,FOLLOW_DROP_in_drop_database_statement1328); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP244);

            pushFollow(FOLLOW_drop_database_expression_in_drop_database_statement1330);
            drop_database_expression245=drop_database_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_drop_database_expression.add(drop_database_expression245.getTree());


            // AST REWRITE
            // elements: drop_database_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 231:32: -> ^( TN_DROP drop_database_expression )
            {
                // SQLParser1.g:231:35: ^( TN_DROP drop_database_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_DROP, "TN_DROP"), root_1);

                adaptor.addChild(root_1, stream_drop_database_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 41, drop_database_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "drop_database_statement"

    public static class drop_database_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_database_expression"
    // SQLParser1.g:233:1: drop_database_expression : ( DATABASE | SCHEMA ) ( IF EXISTS )? schema_name ;
    public final MySQL_SQLParser1.drop_database_expression_return drop_database_expression() throws RecognitionException {
        MySQL_SQLParser1.drop_database_expression_return retval = new MySQL_SQLParser1.drop_database_expression_return();
        retval.start = input.LT(1);
        int drop_database_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set246=null;
        Token IF247=null;
        Token EXISTS248=null;
        MySQLParser.schema_name_return schema_name249 = null;


        CommonTree set246_tree=null;
        CommonTree IF247_tree=null;
        CommonTree EXISTS248_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // SQLParser1.g:233:25: ( ( DATABASE | SCHEMA ) ( IF EXISTS )? schema_name )
            // SQLParser1.g:234:2: ( DATABASE | SCHEMA ) ( IF EXISTS )? schema_name
            {
            root_0 = (CommonTree)adaptor.nil();

            set246=(Token)input.LT(1);
            if ( input.LA(1)==DATABASE||input.LA(1)==SCHEMA ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set246));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // SQLParser1.g:234:22: ( IF EXISTS )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==IF) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // SQLParser1.g:234:23: IF EXISTS
                    {
                    IF247=(Token)match(input,IF,FOLLOW_IF_in_drop_database_expression1355); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF247_tree = (CommonTree)adaptor.create(IF247);
                    adaptor.addChild(root_0, IF247_tree);
                    }
                    EXISTS248=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_drop_database_expression1357); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXISTS248_tree = (CommonTree)adaptor.create(EXISTS248);
                    adaptor.addChild(root_0, EXISTS248_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_schema_name_in_drop_database_expression1361);
            schema_name249=gMySQL.schema_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, schema_name249.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 42, drop_database_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "drop_database_expression"

    public static class create_event_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_event_statement"
    // SQLParser1.g:238:1: create_event_statement : CREATE create_event_expression -> ^( TN_CREATE create_event_expression ) ;
    public final MySQL_SQLParser1.create_event_statement_return create_event_statement() throws RecognitionException {
        MySQL_SQLParser1.create_event_statement_return retval = new MySQL_SQLParser1.create_event_statement_return();
        retval.start = input.LT(1);
        int create_event_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CREATE250=null;
        MySQL_SQLParser1.create_event_expression_return create_event_expression251 = null;


        CommonTree CREATE250_tree=null;
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleSubtreeStream stream_create_event_expression=new RewriteRuleSubtreeStream(adaptor,"rule create_event_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // SQLParser1.g:238:23: ( CREATE create_event_expression -> ^( TN_CREATE create_event_expression ) )
            // SQLParser1.g:239:2: CREATE create_event_expression
            {
            CREATE250=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_event_statement1371); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE250);

            pushFollow(FOLLOW_create_event_expression_in_create_event_statement1373);
            create_event_expression251=create_event_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_create_event_expression.add(create_event_expression251.getTree());


            // AST REWRITE
            // elements: create_event_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 239:33: -> ^( TN_CREATE create_event_expression )
            {
                // SQLParser1.g:239:36: ^( TN_CREATE create_event_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_CREATE, "TN_CREATE"), root_1);

                adaptor.addChild(root_1, stream_create_event_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 43, create_event_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "create_event_statement"

    public static class create_event_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_event_expression"
    // SQLParser1.g:242:1: create_event_expression : ( DEFINER EQ_SYM ( user_name | CURRENT_USER ) )? EVENT_SYM ( IF NOT_SYM EXISTS )? event_name ON SCHEDULE_SYM schedule_definition ( ON COMPLETION_SYM ( NOT_SYM )? PRESERVE_SYM )? ( ENABLE_SYM | DISABLE_SYM | ( DISABLE_SYM ON SLAVE ) )? ( COMMENT_SYM TEXT_STRING )? do_statement ;
    public final MySQL_SQLParser1.create_event_expression_return create_event_expression() throws RecognitionException {
        MySQL_SQLParser1.create_event_expression_return retval = new MySQL_SQLParser1.create_event_expression_return();
        retval.start = input.LT(1);
        int create_event_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DEFINER252=null;
        Token EQ_SYM253=null;
        Token CURRENT_USER255=null;
        Token EVENT_SYM256=null;
        Token IF257=null;
        Token NOT_SYM258=null;
        Token EXISTS259=null;
        Token ON261=null;
        Token SCHEDULE_SYM262=null;
        Token ON264=null;
        Token COMPLETION_SYM265=null;
        Token NOT_SYM266=null;
        Token PRESERVE_SYM267=null;
        Token ENABLE_SYM268=null;
        Token DISABLE_SYM269=null;
        Token DISABLE_SYM270=null;
        Token ON271=null;
        Token SLAVE272=null;
        Token COMMENT_SYM273=null;
        Token TEXT_STRING274=null;
        MySQLParser.user_name_return user_name254 = null;

        MySQLParser.event_name_return event_name260 = null;

        MySQL_SQLParser1.schedule_definition_return schedule_definition263 = null;

        MySQL_SQLParser1.do_statement_return do_statement275 = null;


        CommonTree DEFINER252_tree=null;
        CommonTree EQ_SYM253_tree=null;
        CommonTree CURRENT_USER255_tree=null;
        CommonTree EVENT_SYM256_tree=null;
        CommonTree IF257_tree=null;
        CommonTree NOT_SYM258_tree=null;
        CommonTree EXISTS259_tree=null;
        CommonTree ON261_tree=null;
        CommonTree SCHEDULE_SYM262_tree=null;
        CommonTree ON264_tree=null;
        CommonTree COMPLETION_SYM265_tree=null;
        CommonTree NOT_SYM266_tree=null;
        CommonTree PRESERVE_SYM267_tree=null;
        CommonTree ENABLE_SYM268_tree=null;
        CommonTree DISABLE_SYM269_tree=null;
        CommonTree DISABLE_SYM270_tree=null;
        CommonTree ON271_tree=null;
        CommonTree SLAVE272_tree=null;
        CommonTree COMMENT_SYM273_tree=null;
        CommonTree TEXT_STRING274_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // SQLParser1.g:242:24: ( ( DEFINER EQ_SYM ( user_name | CURRENT_USER ) )? EVENT_SYM ( IF NOT_SYM EXISTS )? event_name ON SCHEDULE_SYM schedule_definition ( ON COMPLETION_SYM ( NOT_SYM )? PRESERVE_SYM )? ( ENABLE_SYM | DISABLE_SYM | ( DISABLE_SYM ON SLAVE ) )? ( COMMENT_SYM TEXT_STRING )? do_statement )
            // SQLParser1.g:243:2: ( DEFINER EQ_SYM ( user_name | CURRENT_USER ) )? EVENT_SYM ( IF NOT_SYM EXISTS )? event_name ON SCHEDULE_SYM schedule_definition ( ON COMPLETION_SYM ( NOT_SYM )? PRESERVE_SYM )? ( ENABLE_SYM | DISABLE_SYM | ( DISABLE_SYM ON SLAVE ) )? ( COMMENT_SYM TEXT_STRING )? do_statement
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:243:2: ( DEFINER EQ_SYM ( user_name | CURRENT_USER ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==DEFINER) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // SQLParser1.g:243:3: DEFINER EQ_SYM ( user_name | CURRENT_USER )
                    {
                    DEFINER252=(Token)match(input,DEFINER,FOLLOW_DEFINER_in_create_event_expression1392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINER252_tree = (CommonTree)adaptor.create(DEFINER252);
                    adaptor.addChild(root_0, DEFINER252_tree);
                    }
                    EQ_SYM253=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_create_event_expression1394); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQ_SYM253_tree = (CommonTree)adaptor.create(EQ_SYM253);
                    adaptor.addChild(root_0, EQ_SYM253_tree);
                    }
                    // SQLParser1.g:243:18: ( user_name | CURRENT_USER )
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==ID) ) {
                        alt94=1;
                    }
                    else if ( (LA94_0==CURRENT_USER) ) {
                        alt94=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 94, 0, input);

                        throw nvae;
                    }
                    switch (alt94) {
                        case 1 :
                            // SQLParser1.g:243:20: user_name
                            {
                            pushFollow(FOLLOW_user_name_in_create_event_expression1398);
                            user_name254=gMySQL.user_name();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, user_name254.getTree());

                            }
                            break;
                        case 2 :
                            // SQLParser1.g:243:32: CURRENT_USER
                            {
                            CURRENT_USER255=(Token)match(input,CURRENT_USER,FOLLOW_CURRENT_USER_in_create_event_expression1402); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            CURRENT_USER255_tree = (CommonTree)adaptor.create(CURRENT_USER255);
                            adaptor.addChild(root_0, CURRENT_USER255_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            EVENT_SYM256=(Token)match(input,EVENT_SYM,FOLLOW_EVENT_SYM_in_create_event_expression1409); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EVENT_SYM256_tree = (CommonTree)adaptor.create(EVENT_SYM256);
            adaptor.addChild(root_0, EVENT_SYM256_tree);
            }
            // SQLParser1.g:245:2: ( IF NOT_SYM EXISTS )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==IF) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // SQLParser1.g:245:3: IF NOT_SYM EXISTS
                    {
                    IF257=(Token)match(input,IF,FOLLOW_IF_in_create_event_expression1413); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF257_tree = (CommonTree)adaptor.create(IF257);
                    adaptor.addChild(root_0, IF257_tree);
                    }
                    NOT_SYM258=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_create_event_expression1415); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT_SYM258_tree = (CommonTree)adaptor.create(NOT_SYM258);
                    adaptor.addChild(root_0, NOT_SYM258_tree);
                    }
                    EXISTS259=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_create_event_expression1417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXISTS259_tree = (CommonTree)adaptor.create(EXISTS259);
                    adaptor.addChild(root_0, EXISTS259_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_event_name_in_create_event_expression1422);
            event_name260=gMySQL.event_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, event_name260.getTree());
            ON261=(Token)match(input,ON,FOLLOW_ON_in_create_event_expression1425); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ON261_tree = (CommonTree)adaptor.create(ON261);
            adaptor.addChild(root_0, ON261_tree);
            }
            SCHEDULE_SYM262=(Token)match(input,SCHEDULE_SYM,FOLLOW_SCHEDULE_SYM_in_create_event_expression1427); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SCHEDULE_SYM262_tree = (CommonTree)adaptor.create(SCHEDULE_SYM262);
            adaptor.addChild(root_0, SCHEDULE_SYM262_tree);
            }
            pushFollow(FOLLOW_schedule_definition_in_create_event_expression1429);
            schedule_definition263=schedule_definition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, schedule_definition263.getTree());
            // SQLParser1.g:248:2: ( ON COMPLETION_SYM ( NOT_SYM )? PRESERVE_SYM )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==ON) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // SQLParser1.g:248:3: ON COMPLETION_SYM ( NOT_SYM )? PRESERVE_SYM
                    {
                    ON264=(Token)match(input,ON,FOLLOW_ON_in_create_event_expression1433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ON264_tree = (CommonTree)adaptor.create(ON264);
                    adaptor.addChild(root_0, ON264_tree);
                    }
                    COMPLETION_SYM265=(Token)match(input,COMPLETION_SYM,FOLLOW_COMPLETION_SYM_in_create_event_expression1435); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMPLETION_SYM265_tree = (CommonTree)adaptor.create(COMPLETION_SYM265);
                    adaptor.addChild(root_0, COMPLETION_SYM265_tree);
                    }
                    // SQLParser1.g:248:21: ( NOT_SYM )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==NOT_SYM) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // SQLParser1.g:248:22: NOT_SYM
                            {
                            NOT_SYM266=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_create_event_expression1438); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT_SYM266_tree = (CommonTree)adaptor.create(NOT_SYM266);
                            adaptor.addChild(root_0, NOT_SYM266_tree);
                            }

                            }
                            break;

                    }

                    PRESERVE_SYM267=(Token)match(input,PRESERVE_SYM,FOLLOW_PRESERVE_SYM_in_create_event_expression1442); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PRESERVE_SYM267_tree = (CommonTree)adaptor.create(PRESERVE_SYM267);
                    adaptor.addChild(root_0, PRESERVE_SYM267_tree);
                    }

                    }
                    break;

            }

            // SQLParser1.g:249:2: ( ENABLE_SYM | DISABLE_SYM | ( DISABLE_SYM ON SLAVE ) )?
            int alt99=4;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==ENABLE_SYM) ) {
                alt99=1;
            }
            else if ( (LA99_0==DISABLE_SYM) ) {
                int LA99_2 = input.LA(2);

                if ( (LA99_2==ON) ) {
                    alt99=3;
                }
                else if ( (LA99_2==COMMENT_SYM||LA99_2==DO_SYM) ) {
                    alt99=2;
                }
            }
            switch (alt99) {
                case 1 :
                    // SQLParser1.g:249:4: ENABLE_SYM
                    {
                    ENABLE_SYM268=(Token)match(input,ENABLE_SYM,FOLLOW_ENABLE_SYM_in_create_event_expression1449); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ENABLE_SYM268_tree = (CommonTree)adaptor.create(ENABLE_SYM268);
                    adaptor.addChild(root_0, ENABLE_SYM268_tree);
                    }

                    }
                    break;
                case 2 :
                    // SQLParser1.g:249:17: DISABLE_SYM
                    {
                    DISABLE_SYM269=(Token)match(input,DISABLE_SYM,FOLLOW_DISABLE_SYM_in_create_event_expression1453); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISABLE_SYM269_tree = (CommonTree)adaptor.create(DISABLE_SYM269);
                    adaptor.addChild(root_0, DISABLE_SYM269_tree);
                    }

                    }
                    break;
                case 3 :
                    // SQLParser1.g:249:31: ( DISABLE_SYM ON SLAVE )
                    {
                    // SQLParser1.g:249:31: ( DISABLE_SYM ON SLAVE )
                    // SQLParser1.g:249:32: DISABLE_SYM ON SLAVE
                    {
                    DISABLE_SYM270=(Token)match(input,DISABLE_SYM,FOLLOW_DISABLE_SYM_in_create_event_expression1458); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISABLE_SYM270_tree = (CommonTree)adaptor.create(DISABLE_SYM270);
                    adaptor.addChild(root_0, DISABLE_SYM270_tree);
                    }
                    ON271=(Token)match(input,ON,FOLLOW_ON_in_create_event_expression1460); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ON271_tree = (CommonTree)adaptor.create(ON271);
                    adaptor.addChild(root_0, ON271_tree);
                    }
                    SLAVE272=(Token)match(input,SLAVE,FOLLOW_SLAVE_in_create_event_expression1462); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SLAVE272_tree = (CommonTree)adaptor.create(SLAVE272);
                    adaptor.addChild(root_0, SLAVE272_tree);
                    }

                    }


                    }
                    break;

            }

            // SQLParser1.g:250:2: ( COMMENT_SYM TEXT_STRING )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==COMMENT_SYM) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // SQLParser1.g:250:3: COMMENT_SYM TEXT_STRING
                    {
                    COMMENT_SYM273=(Token)match(input,COMMENT_SYM,FOLLOW_COMMENT_SYM_in_create_event_expression1470); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMENT_SYM273_tree = (CommonTree)adaptor.create(COMMENT_SYM273);
                    adaptor.addChild(root_0, COMMENT_SYM273_tree);
                    }
                    TEXT_STRING274=(Token)match(input,TEXT_STRING,FOLLOW_TEXT_STRING_in_create_event_expression1472); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT_STRING274_tree = (CommonTree)adaptor.create(TEXT_STRING274);
                    adaptor.addChild(root_0, TEXT_STRING274_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_do_statement_in_create_event_expression1477);
            do_statement275=do_statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, do_statement275.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 44, create_event_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "create_event_expression"

    public static class schedule_definition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schedule_definition"
    // SQLParser1.g:253:1: schedule_definition : ( ( AT_SYM timestamp ( PLUS INTERVAL_SYM interval )* ) | ( EVERY_SYM interval ) ( S_ T_ A_ R_ T_ S_ timestamp ( PLUS INTERVAL_SYM interval )* )? ( ENDS_SYM timestamp ( PLUS INTERVAL_SYM interval )* )? );
    public final MySQL_SQLParser1.schedule_definition_return schedule_definition() throws RecognitionException {
        MySQL_SQLParser1.schedule_definition_return retval = new MySQL_SQLParser1.schedule_definition_return();
        retval.start = input.LT(1);
        int schedule_definition_StartIndex = input.index();
        CommonTree root_0 = null;

        Token AT_SYM276=null;
        Token PLUS278=null;
        Token INTERVAL_SYM279=null;
        Token EVERY_SYM281=null;
        Token S_283=null;
        Token T_284=null;
        Token A_285=null;
        Token R_286=null;
        Token T_287=null;
        Token S_288=null;
        Token PLUS290=null;
        Token INTERVAL_SYM291=null;
        Token ENDS_SYM293=null;
        Token PLUS295=null;
        Token INTERVAL_SYM296=null;
        MySQL_SQLParser1.timestamp_return timestamp277 = null;

        MySQL_SQLParser1.interval_return interval280 = null;

        MySQL_SQLParser1.interval_return interval282 = null;

        MySQL_SQLParser1.timestamp_return timestamp289 = null;

        MySQL_SQLParser1.interval_return interval292 = null;

        MySQL_SQLParser1.timestamp_return timestamp294 = null;

        MySQL_SQLParser1.interval_return interval297 = null;


        CommonTree AT_SYM276_tree=null;
        CommonTree PLUS278_tree=null;
        CommonTree INTERVAL_SYM279_tree=null;
        CommonTree EVERY_SYM281_tree=null;
        CommonTree S_283_tree=null;
        CommonTree T_284_tree=null;
        CommonTree A_285_tree=null;
        CommonTree R_286_tree=null;
        CommonTree T_287_tree=null;
        CommonTree S_288_tree=null;
        CommonTree PLUS290_tree=null;
        CommonTree INTERVAL_SYM291_tree=null;
        CommonTree ENDS_SYM293_tree=null;
        CommonTree PLUS295_tree=null;
        CommonTree INTERVAL_SYM296_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // SQLParser1.g:253:20: ( ( AT_SYM timestamp ( PLUS INTERVAL_SYM interval )* ) | ( EVERY_SYM interval ) ( S_ T_ A_ R_ T_ S_ timestamp ( PLUS INTERVAL_SYM interval )* )? ( ENDS_SYM timestamp ( PLUS INTERVAL_SYM interval )* )? )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==AT_SYM) ) {
                alt106=1;
            }
            else if ( (LA106_0==EVERY_SYM) ) {
                alt106=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // SQLParser1.g:254:2: ( AT_SYM timestamp ( PLUS INTERVAL_SYM interval )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:254:2: ( AT_SYM timestamp ( PLUS INTERVAL_SYM interval )* )
                    // SQLParser1.g:254:4: AT_SYM timestamp ( PLUS INTERVAL_SYM interval )*
                    {
                    AT_SYM276=(Token)match(input,AT_SYM,FOLLOW_AT_SYM_in_schedule_definition1487); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AT_SYM276_tree = (CommonTree)adaptor.create(AT_SYM276);
                    adaptor.addChild(root_0, AT_SYM276_tree);
                    }
                    pushFollow(FOLLOW_timestamp_in_schedule_definition1489);
                    timestamp277=timestamp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timestamp277.getTree());
                    // SQLParser1.g:254:21: ( PLUS INTERVAL_SYM interval )*
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==PLUS) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // SQLParser1.g:254:22: PLUS INTERVAL_SYM interval
                    	    {
                    	    PLUS278=(Token)match(input,PLUS,FOLLOW_PLUS_in_schedule_definition1492); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    PLUS278_tree = (CommonTree)adaptor.create(PLUS278);
                    	    adaptor.addChild(root_0, PLUS278_tree);
                    	    }
                    	    INTERVAL_SYM279=(Token)match(input,INTERVAL_SYM,FOLLOW_INTERVAL_SYM_in_schedule_definition1494); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    INTERVAL_SYM279_tree = (CommonTree)adaptor.create(INTERVAL_SYM279);
                    	    adaptor.addChild(root_0, INTERVAL_SYM279_tree);
                    	    }
                    	    pushFollow(FOLLOW_interval_in_schedule_definition1496);
                    	    interval280=interval();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, interval280.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop101;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // SQLParser1.g:256:2: ( EVERY_SYM interval ) ( S_ T_ A_ R_ T_ S_ timestamp ( PLUS INTERVAL_SYM interval )* )? ( ENDS_SYM timestamp ( PLUS INTERVAL_SYM interval )* )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:256:2: ( EVERY_SYM interval )
                    // SQLParser1.g:256:4: EVERY_SYM interval
                    {
                    EVERY_SYM281=(Token)match(input,EVERY_SYM,FOLLOW_EVERY_SYM_in_schedule_definition1509); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVERY_SYM281_tree = (CommonTree)adaptor.create(EVERY_SYM281);
                    adaptor.addChild(root_0, EVERY_SYM281_tree);
                    }
                    pushFollow(FOLLOW_interval_in_schedule_definition1511);
                    interval282=interval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, interval282.getTree());

                    }

                    // SQLParser1.g:257:2: ( S_ T_ A_ R_ T_ S_ timestamp ( PLUS INTERVAL_SYM interval )* )?
                    int alt103=2;
                    int LA103_0 = input.LA(1);

                    if ( (LA103_0==S_) ) {
                        alt103=1;
                    }
                    switch (alt103) {
                        case 1 :
                            // SQLParser1.g:257:4: S_ T_ A_ R_ T_ S_ timestamp ( PLUS INTERVAL_SYM interval )*
                            {
                            S_283=(Token)match(input,S_,FOLLOW_S__in_schedule_definition1518); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            S_283_tree = (CommonTree)adaptor.create(S_283);
                            adaptor.addChild(root_0, S_283_tree);
                            }
                            T_284=(Token)match(input,T_,FOLLOW_T__in_schedule_definition1520); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            T_284_tree = (CommonTree)adaptor.create(T_284);
                            adaptor.addChild(root_0, T_284_tree);
                            }
                            A_285=(Token)match(input,A_,FOLLOW_A__in_schedule_definition1522); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            A_285_tree = (CommonTree)adaptor.create(A_285);
                            adaptor.addChild(root_0, A_285_tree);
                            }
                            R_286=(Token)match(input,R_,FOLLOW_R__in_schedule_definition1524); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            R_286_tree = (CommonTree)adaptor.create(R_286);
                            adaptor.addChild(root_0, R_286_tree);
                            }
                            T_287=(Token)match(input,T_,FOLLOW_T__in_schedule_definition1526); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            T_287_tree = (CommonTree)adaptor.create(T_287);
                            adaptor.addChild(root_0, T_287_tree);
                            }
                            S_288=(Token)match(input,S_,FOLLOW_S__in_schedule_definition1528); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            S_288_tree = (CommonTree)adaptor.create(S_288);
                            adaptor.addChild(root_0, S_288_tree);
                            }
                            pushFollow(FOLLOW_timestamp_in_schedule_definition1530);
                            timestamp289=timestamp();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, timestamp289.getTree());
                            // SQLParser1.g:257:32: ( PLUS INTERVAL_SYM interval )*
                            loop102:
                            do {
                                int alt102=2;
                                int LA102_0 = input.LA(1);

                                if ( (LA102_0==PLUS) ) {
                                    alt102=1;
                                }


                                switch (alt102) {
                            	case 1 :
                            	    // SQLParser1.g:257:33: PLUS INTERVAL_SYM interval
                            	    {
                            	    PLUS290=(Token)match(input,PLUS,FOLLOW_PLUS_in_schedule_definition1533); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    PLUS290_tree = (CommonTree)adaptor.create(PLUS290);
                            	    adaptor.addChild(root_0, PLUS290_tree);
                            	    }
                            	    INTERVAL_SYM291=(Token)match(input,INTERVAL_SYM,FOLLOW_INTERVAL_SYM_in_schedule_definition1535); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    INTERVAL_SYM291_tree = (CommonTree)adaptor.create(INTERVAL_SYM291);
                            	    adaptor.addChild(root_0, INTERVAL_SYM291_tree);
                            	    }
                            	    pushFollow(FOLLOW_interval_in_schedule_definition1537);
                            	    interval292=interval();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, interval292.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop102;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // SQLParser1.g:258:2: ( ENDS_SYM timestamp ( PLUS INTERVAL_SYM interval )* )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==ENDS_SYM) ) {
                        alt105=1;
                    }
                    switch (alt105) {
                        case 1 :
                            // SQLParser1.g:258:4: ENDS_SYM timestamp ( PLUS INTERVAL_SYM interval )*
                            {
                            ENDS_SYM293=(Token)match(input,ENDS_SYM,FOLLOW_ENDS_SYM_in_schedule_definition1547); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ENDS_SYM293_tree = (CommonTree)adaptor.create(ENDS_SYM293);
                            adaptor.addChild(root_0, ENDS_SYM293_tree);
                            }
                            pushFollow(FOLLOW_timestamp_in_schedule_definition1549);
                            timestamp294=timestamp();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, timestamp294.getTree());
                            // SQLParser1.g:258:23: ( PLUS INTERVAL_SYM interval )*
                            loop104:
                            do {
                                int alt104=2;
                                int LA104_0 = input.LA(1);

                                if ( (LA104_0==PLUS) ) {
                                    alt104=1;
                                }


                                switch (alt104) {
                            	case 1 :
                            	    // SQLParser1.g:258:24: PLUS INTERVAL_SYM interval
                            	    {
                            	    PLUS295=(Token)match(input,PLUS,FOLLOW_PLUS_in_schedule_definition1552); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    PLUS295_tree = (CommonTree)adaptor.create(PLUS295);
                            	    adaptor.addChild(root_0, PLUS295_tree);
                            	    }
                            	    INTERVAL_SYM296=(Token)match(input,INTERVAL_SYM,FOLLOW_INTERVAL_SYM_in_schedule_definition1554); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    INTERVAL_SYM296_tree = (CommonTree)adaptor.create(INTERVAL_SYM296);
                            	    adaptor.addChild(root_0, INTERVAL_SYM296_tree);
                            	    }
                            	    pushFollow(FOLLOW_interval_in_schedule_definition1556);
                            	    interval297=interval();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, interval297.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop104;
                                }
                            } while (true);


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
            if ( state.backtracking>0 ) { memoize(input, 45, schedule_definition_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "schedule_definition"

    public static class interval_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "interval"
    // SQLParser1.g:260:1: interval : INTEGER_NUM ( Y_ E_ A_ R_ | QUARTER | MONTH | DAY_SYM | HOUR | MINUTE | WEEK | SECOND | YEAR_MONTH | DAY_HOUR | DAY_MINUTE | DAY_SECOND | HOUR_MINUTE | HOUR_SECOND | MINUTE_SECOND ) ;
    public final MySQL_SQLParser1.interval_return interval() throws RecognitionException {
        MySQL_SQLParser1.interval_return retval = new MySQL_SQLParser1.interval_return();
        retval.start = input.LT(1);
        int interval_StartIndex = input.index();
        CommonTree root_0 = null;

        Token INTEGER_NUM298=null;
        Token Y_299=null;
        Token E_300=null;
        Token A_301=null;
        Token R_302=null;
        Token QUARTER303=null;
        Token MONTH304=null;
        Token DAY_SYM305=null;
        Token HOUR306=null;
        Token MINUTE307=null;
        Token WEEK308=null;
        Token SECOND309=null;
        Token YEAR_MONTH310=null;
        Token DAY_HOUR311=null;
        Token DAY_MINUTE312=null;
        Token DAY_SECOND313=null;
        Token HOUR_MINUTE314=null;
        Token HOUR_SECOND315=null;
        Token MINUTE_SECOND316=null;

        CommonTree INTEGER_NUM298_tree=null;
        CommonTree Y_299_tree=null;
        CommonTree E_300_tree=null;
        CommonTree A_301_tree=null;
        CommonTree R_302_tree=null;
        CommonTree QUARTER303_tree=null;
        CommonTree MONTH304_tree=null;
        CommonTree DAY_SYM305_tree=null;
        CommonTree HOUR306_tree=null;
        CommonTree MINUTE307_tree=null;
        CommonTree WEEK308_tree=null;
        CommonTree SECOND309_tree=null;
        CommonTree YEAR_MONTH310_tree=null;
        CommonTree DAY_HOUR311_tree=null;
        CommonTree DAY_MINUTE312_tree=null;
        CommonTree DAY_SECOND313_tree=null;
        CommonTree HOUR_MINUTE314_tree=null;
        CommonTree HOUR_SECOND315_tree=null;
        CommonTree MINUTE_SECOND316_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // SQLParser1.g:260:9: ( INTEGER_NUM ( Y_ E_ A_ R_ | QUARTER | MONTH | DAY_SYM | HOUR | MINUTE | WEEK | SECOND | YEAR_MONTH | DAY_HOUR | DAY_MINUTE | DAY_SECOND | HOUR_MINUTE | HOUR_SECOND | MINUTE_SECOND ) )
            // SQLParser1.g:261:2: INTEGER_NUM ( Y_ E_ A_ R_ | QUARTER | MONTH | DAY_SYM | HOUR | MINUTE | WEEK | SECOND | YEAR_MONTH | DAY_HOUR | DAY_MINUTE | DAY_SECOND | HOUR_MINUTE | HOUR_SECOND | MINUTE_SECOND )
            {
            root_0 = (CommonTree)adaptor.nil();

            INTEGER_NUM298=(Token)match(input,INTEGER_NUM,FOLLOW_INTEGER_NUM_in_interval1569); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER_NUM298_tree = (CommonTree)adaptor.create(INTEGER_NUM298);
            adaptor.addChild(root_0, INTEGER_NUM298_tree);
            }
            // SQLParser1.g:261:14: ( Y_ E_ A_ R_ | QUARTER | MONTH | DAY_SYM | HOUR | MINUTE | WEEK | SECOND | YEAR_MONTH | DAY_HOUR | DAY_MINUTE | DAY_SECOND | HOUR_MINUTE | HOUR_SECOND | MINUTE_SECOND )
            int alt107=15;
            switch ( input.LA(1) ) {
            case Y_:
                {
                alt107=1;
                }
                break;
            case QUARTER:
                {
                alt107=2;
                }
                break;
            case MONTH:
                {
                alt107=3;
                }
                break;
            case DAY_SYM:
                {
                alt107=4;
                }
                break;
            case HOUR:
                {
                alt107=5;
                }
                break;
            case MINUTE:
                {
                alt107=6;
                }
                break;
            case WEEK:
                {
                alt107=7;
                }
                break;
            case SECOND:
                {
                alt107=8;
                }
                break;
            case YEAR_MONTH:
                {
                alt107=9;
                }
                break;
            case DAY_HOUR:
                {
                alt107=10;
                }
                break;
            case DAY_MINUTE:
                {
                alt107=11;
                }
                break;
            case DAY_SECOND:
                {
                alt107=12;
                }
                break;
            case HOUR_MINUTE:
                {
                alt107=13;
                }
                break;
            case HOUR_SECOND:
                {
                alt107=14;
                }
                break;
            case MINUTE_SECOND:
                {
                alt107=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // SQLParser1.g:261:15: Y_ E_ A_ R_
                    {
                    Y_299=(Token)match(input,Y_,FOLLOW_Y__in_interval1572); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Y_299_tree = (CommonTree)adaptor.create(Y_299);
                    adaptor.addChild(root_0, Y_299_tree);
                    }
                    E_300=(Token)match(input,E_,FOLLOW_E__in_interval1574); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    E_300_tree = (CommonTree)adaptor.create(E_300);
                    adaptor.addChild(root_0, E_300_tree);
                    }
                    A_301=(Token)match(input,A_,FOLLOW_A__in_interval1576); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    A_301_tree = (CommonTree)adaptor.create(A_301);
                    adaptor.addChild(root_0, A_301_tree);
                    }
                    R_302=(Token)match(input,R_,FOLLOW_R__in_interval1578); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    R_302_tree = (CommonTree)adaptor.create(R_302);
                    adaptor.addChild(root_0, R_302_tree);
                    }

                    }
                    break;
                case 2 :
                    // SQLParser1.g:261:29: QUARTER
                    {
                    QUARTER303=(Token)match(input,QUARTER,FOLLOW_QUARTER_in_interval1582); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUARTER303_tree = (CommonTree)adaptor.create(QUARTER303);
                    adaptor.addChild(root_0, QUARTER303_tree);
                    }

                    }
                    break;
                case 3 :
                    // SQLParser1.g:261:39: MONTH
                    {
                    MONTH304=(Token)match(input,MONTH,FOLLOW_MONTH_in_interval1586); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MONTH304_tree = (CommonTree)adaptor.create(MONTH304);
                    adaptor.addChild(root_0, MONTH304_tree);
                    }

                    }
                    break;
                case 4 :
                    // SQLParser1.g:261:47: DAY_SYM
                    {
                    DAY_SYM305=(Token)match(input,DAY_SYM,FOLLOW_DAY_SYM_in_interval1590); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DAY_SYM305_tree = (CommonTree)adaptor.create(DAY_SYM305);
                    adaptor.addChild(root_0, DAY_SYM305_tree);
                    }

                    }
                    break;
                case 5 :
                    // SQLParser1.g:261:57: HOUR
                    {
                    HOUR306=(Token)match(input,HOUR,FOLLOW_HOUR_in_interval1594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HOUR306_tree = (CommonTree)adaptor.create(HOUR306);
                    adaptor.addChild(root_0, HOUR306_tree);
                    }

                    }
                    break;
                case 6 :
                    // SQLParser1.g:261:64: MINUTE
                    {
                    MINUTE307=(Token)match(input,MINUTE,FOLLOW_MINUTE_in_interval1598); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUTE307_tree = (CommonTree)adaptor.create(MINUTE307);
                    adaptor.addChild(root_0, MINUTE307_tree);
                    }

                    }
                    break;
                case 7 :
                    // SQLParser1.g:262:12: WEEK
                    {
                    WEEK308=(Token)match(input,WEEK,FOLLOW_WEEK_in_interval1613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WEEK308_tree = (CommonTree)adaptor.create(WEEK308);
                    adaptor.addChild(root_0, WEEK308_tree);
                    }

                    }
                    break;
                case 8 :
                    // SQLParser1.g:262:19: SECOND
                    {
                    SECOND309=(Token)match(input,SECOND,FOLLOW_SECOND_in_interval1617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SECOND309_tree = (CommonTree)adaptor.create(SECOND309);
                    adaptor.addChild(root_0, SECOND309_tree);
                    }

                    }
                    break;
                case 9 :
                    // SQLParser1.g:262:28: YEAR_MONTH
                    {
                    YEAR_MONTH310=(Token)match(input,YEAR_MONTH,FOLLOW_YEAR_MONTH_in_interval1621); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    YEAR_MONTH310_tree = (CommonTree)adaptor.create(YEAR_MONTH310);
                    adaptor.addChild(root_0, YEAR_MONTH310_tree);
                    }

                    }
                    break;
                case 10 :
                    // SQLParser1.g:262:41: DAY_HOUR
                    {
                    DAY_HOUR311=(Token)match(input,DAY_HOUR,FOLLOW_DAY_HOUR_in_interval1625); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DAY_HOUR311_tree = (CommonTree)adaptor.create(DAY_HOUR311);
                    adaptor.addChild(root_0, DAY_HOUR311_tree);
                    }

                    }
                    break;
                case 11 :
                    // SQLParser1.g:262:52: DAY_MINUTE
                    {
                    DAY_MINUTE312=(Token)match(input,DAY_MINUTE,FOLLOW_DAY_MINUTE_in_interval1629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DAY_MINUTE312_tree = (CommonTree)adaptor.create(DAY_MINUTE312);
                    adaptor.addChild(root_0, DAY_MINUTE312_tree);
                    }

                    }
                    break;
                case 12 :
                    // SQLParser1.g:263:12: DAY_SECOND
                    {
                    DAY_SECOND313=(Token)match(input,DAY_SECOND,FOLLOW_DAY_SECOND_in_interval1644); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DAY_SECOND313_tree = (CommonTree)adaptor.create(DAY_SECOND313);
                    adaptor.addChild(root_0, DAY_SECOND313_tree);
                    }

                    }
                    break;
                case 13 :
                    // SQLParser1.g:263:25: HOUR_MINUTE
                    {
                    HOUR_MINUTE314=(Token)match(input,HOUR_MINUTE,FOLLOW_HOUR_MINUTE_in_interval1648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HOUR_MINUTE314_tree = (CommonTree)adaptor.create(HOUR_MINUTE314);
                    adaptor.addChild(root_0, HOUR_MINUTE314_tree);
                    }

                    }
                    break;
                case 14 :
                    // SQLParser1.g:263:39: HOUR_SECOND
                    {
                    HOUR_SECOND315=(Token)match(input,HOUR_SECOND,FOLLOW_HOUR_SECOND_in_interval1652); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HOUR_SECOND315_tree = (CommonTree)adaptor.create(HOUR_SECOND315);
                    adaptor.addChild(root_0, HOUR_SECOND315_tree);
                    }

                    }
                    break;
                case 15 :
                    // SQLParser1.g:263:53: MINUTE_SECOND
                    {
                    MINUTE_SECOND316=(Token)match(input,MINUTE_SECOND,FOLLOW_MINUTE_SECOND_in_interval1656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUTE_SECOND316_tree = (CommonTree)adaptor.create(MINUTE_SECOND316);
                    adaptor.addChild(root_0, MINUTE_SECOND316_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 46, interval_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "interval"

    public static class timestamp_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "timestamp"
    // SQLParser1.g:266:1: timestamp : CURRENT_TIMESTAMP ;
    public final MySQL_SQLParser1.timestamp_return timestamp() throws RecognitionException {
        MySQL_SQLParser1.timestamp_return retval = new MySQL_SQLParser1.timestamp_return();
        retval.start = input.LT(1);
        int timestamp_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CURRENT_TIMESTAMP317=null;

        CommonTree CURRENT_TIMESTAMP317_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // SQLParser1.g:266:10: ( CURRENT_TIMESTAMP )
            // SQLParser1.g:267:2: CURRENT_TIMESTAMP
            {
            root_0 = (CommonTree)adaptor.nil();

            CURRENT_TIMESTAMP317=(Token)match(input,CURRENT_TIMESTAMP,FOLLOW_CURRENT_TIMESTAMP_in_timestamp1666); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CURRENT_TIMESTAMP317_tree = (CommonTree)adaptor.create(CURRENT_TIMESTAMP317);
            adaptor.addChild(root_0, CURRENT_TIMESTAMP317_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 47, timestamp_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "timestamp"

    public static class alter_event_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alter_event_statement"
    // SQLParser1.g:271:1: alter_event_statement : ALTER alter_event_expression -> ^( TN_ALTER alter_event_expression ) ;
    public final MySQL_SQLParser1.alter_event_statement_return alter_event_statement() throws RecognitionException {
        MySQL_SQLParser1.alter_event_statement_return retval = new MySQL_SQLParser1.alter_event_statement_return();
        retval.start = input.LT(1);
        int alter_event_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ALTER318=null;
        MySQL_SQLParser1.alter_event_expression_return alter_event_expression319 = null;


        CommonTree ALTER318_tree=null;
        RewriteRuleTokenStream stream_ALTER=new RewriteRuleTokenStream(adaptor,"token ALTER");
        RewriteRuleSubtreeStream stream_alter_event_expression=new RewriteRuleSubtreeStream(adaptor,"rule alter_event_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // SQLParser1.g:271:22: ( ALTER alter_event_expression -> ^( TN_ALTER alter_event_expression ) )
            // SQLParser1.g:272:2: ALTER alter_event_expression
            {
            ALTER318=(Token)match(input,ALTER,FOLLOW_ALTER_in_alter_event_statement1677); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ALTER.add(ALTER318);

            pushFollow(FOLLOW_alter_event_expression_in_alter_event_statement1679);
            alter_event_expression319=alter_event_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_alter_event_expression.add(alter_event_expression319.getTree());


            // AST REWRITE
            // elements: alter_event_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 272:31: -> ^( TN_ALTER alter_event_expression )
            {
                // SQLParser1.g:272:34: ^( TN_ALTER alter_event_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_ALTER, "TN_ALTER"), root_1);

                adaptor.addChild(root_1, stream_alter_event_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 48, alter_event_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alter_event_statement"

    public static class alter_event_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alter_event_expression"
    // SQLParser1.g:275:1: alter_event_expression : ( DEFINER EQ_SYM ( user_name | CURRENT_USER ) )? EVENT_SYM event_name ( ON SCHEDULE_SYM schedule_definition )? ( ON COMPLETION_SYM ( NOT_SYM )? PRESERVE_SYM )? ( RENAME TO_SYM event_name )? ( ENABLE_SYM | DISABLE_SYM | ( DISABLE_SYM ON SLAVE ) )? ( COMMENT_SYM TEXT_STRING )? ( do_statement )? ;
    public final MySQL_SQLParser1.alter_event_expression_return alter_event_expression() throws RecognitionException {
        MySQL_SQLParser1.alter_event_expression_return retval = new MySQL_SQLParser1.alter_event_expression_return();
        retval.start = input.LT(1);
        int alter_event_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DEFINER320=null;
        Token EQ_SYM321=null;
        Token CURRENT_USER323=null;
        Token EVENT_SYM324=null;
        Token ON326=null;
        Token SCHEDULE_SYM327=null;
        Token ON329=null;
        Token COMPLETION_SYM330=null;
        Token NOT_SYM331=null;
        Token PRESERVE_SYM332=null;
        Token RENAME333=null;
        Token TO_SYM334=null;
        Token ENABLE_SYM336=null;
        Token DISABLE_SYM337=null;
        Token DISABLE_SYM338=null;
        Token ON339=null;
        Token SLAVE340=null;
        Token COMMENT_SYM341=null;
        Token TEXT_STRING342=null;
        MySQLParser.user_name_return user_name322 = null;

        MySQLParser.event_name_return event_name325 = null;

        MySQL_SQLParser1.schedule_definition_return schedule_definition328 = null;

        MySQLParser.event_name_return event_name335 = null;

        MySQL_SQLParser1.do_statement_return do_statement343 = null;


        CommonTree DEFINER320_tree=null;
        CommonTree EQ_SYM321_tree=null;
        CommonTree CURRENT_USER323_tree=null;
        CommonTree EVENT_SYM324_tree=null;
        CommonTree ON326_tree=null;
        CommonTree SCHEDULE_SYM327_tree=null;
        CommonTree ON329_tree=null;
        CommonTree COMPLETION_SYM330_tree=null;
        CommonTree NOT_SYM331_tree=null;
        CommonTree PRESERVE_SYM332_tree=null;
        CommonTree RENAME333_tree=null;
        CommonTree TO_SYM334_tree=null;
        CommonTree ENABLE_SYM336_tree=null;
        CommonTree DISABLE_SYM337_tree=null;
        CommonTree DISABLE_SYM338_tree=null;
        CommonTree ON339_tree=null;
        CommonTree SLAVE340_tree=null;
        CommonTree COMMENT_SYM341_tree=null;
        CommonTree TEXT_STRING342_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // SQLParser1.g:275:23: ( ( DEFINER EQ_SYM ( user_name | CURRENT_USER ) )? EVENT_SYM event_name ( ON SCHEDULE_SYM schedule_definition )? ( ON COMPLETION_SYM ( NOT_SYM )? PRESERVE_SYM )? ( RENAME TO_SYM event_name )? ( ENABLE_SYM | DISABLE_SYM | ( DISABLE_SYM ON SLAVE ) )? ( COMMENT_SYM TEXT_STRING )? ( do_statement )? )
            // SQLParser1.g:276:2: ( DEFINER EQ_SYM ( user_name | CURRENT_USER ) )? EVENT_SYM event_name ( ON SCHEDULE_SYM schedule_definition )? ( ON COMPLETION_SYM ( NOT_SYM )? PRESERVE_SYM )? ( RENAME TO_SYM event_name )? ( ENABLE_SYM | DISABLE_SYM | ( DISABLE_SYM ON SLAVE ) )? ( COMMENT_SYM TEXT_STRING )? ( do_statement )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:276:2: ( DEFINER EQ_SYM ( user_name | CURRENT_USER ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==DEFINER) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // SQLParser1.g:276:3: DEFINER EQ_SYM ( user_name | CURRENT_USER )
                    {
                    DEFINER320=(Token)match(input,DEFINER,FOLLOW_DEFINER_in_alter_event_expression1698); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINER320_tree = (CommonTree)adaptor.create(DEFINER320);
                    adaptor.addChild(root_0, DEFINER320_tree);
                    }
                    EQ_SYM321=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_alter_event_expression1700); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQ_SYM321_tree = (CommonTree)adaptor.create(EQ_SYM321);
                    adaptor.addChild(root_0, EQ_SYM321_tree);
                    }
                    // SQLParser1.g:276:18: ( user_name | CURRENT_USER )
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( (LA108_0==ID) ) {
                        alt108=1;
                    }
                    else if ( (LA108_0==CURRENT_USER) ) {
                        alt108=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 108, 0, input);

                        throw nvae;
                    }
                    switch (alt108) {
                        case 1 :
                            // SQLParser1.g:276:20: user_name
                            {
                            pushFollow(FOLLOW_user_name_in_alter_event_expression1704);
                            user_name322=gMySQL.user_name();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, user_name322.getTree());

                            }
                            break;
                        case 2 :
                            // SQLParser1.g:276:32: CURRENT_USER
                            {
                            CURRENT_USER323=(Token)match(input,CURRENT_USER,FOLLOW_CURRENT_USER_in_alter_event_expression1708); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            CURRENT_USER323_tree = (CommonTree)adaptor.create(CURRENT_USER323);
                            adaptor.addChild(root_0, CURRENT_USER323_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            EVENT_SYM324=(Token)match(input,EVENT_SYM,FOLLOW_EVENT_SYM_in_alter_event_expression1715); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EVENT_SYM324_tree = (CommonTree)adaptor.create(EVENT_SYM324);
            adaptor.addChild(root_0, EVENT_SYM324_tree);
            }
            pushFollow(FOLLOW_event_name_in_alter_event_expression1717);
            event_name325=gMySQL.event_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, event_name325.getTree());
            // SQLParser1.g:278:2: ( ON SCHEDULE_SYM schedule_definition )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==ON) ) {
                int LA110_1 = input.LA(2);

                if ( (LA110_1==SCHEDULE_SYM) ) {
                    alt110=1;
                }
            }
            switch (alt110) {
                case 1 :
                    // SQLParser1.g:278:3: ON SCHEDULE_SYM schedule_definition
                    {
                    ON326=(Token)match(input,ON,FOLLOW_ON_in_alter_event_expression1721); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ON326_tree = (CommonTree)adaptor.create(ON326);
                    adaptor.addChild(root_0, ON326_tree);
                    }
                    SCHEDULE_SYM327=(Token)match(input,SCHEDULE_SYM,FOLLOW_SCHEDULE_SYM_in_alter_event_expression1723); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SCHEDULE_SYM327_tree = (CommonTree)adaptor.create(SCHEDULE_SYM327);
                    adaptor.addChild(root_0, SCHEDULE_SYM327_tree);
                    }
                    pushFollow(FOLLOW_schedule_definition_in_alter_event_expression1725);
                    schedule_definition328=schedule_definition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, schedule_definition328.getTree());

                    }
                    break;

            }

            // SQLParser1.g:279:2: ( ON COMPLETION_SYM ( NOT_SYM )? PRESERVE_SYM )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==ON) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // SQLParser1.g:279:3: ON COMPLETION_SYM ( NOT_SYM )? PRESERVE_SYM
                    {
                    ON329=(Token)match(input,ON,FOLLOW_ON_in_alter_event_expression1731); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ON329_tree = (CommonTree)adaptor.create(ON329);
                    adaptor.addChild(root_0, ON329_tree);
                    }
                    COMPLETION_SYM330=(Token)match(input,COMPLETION_SYM,FOLLOW_COMPLETION_SYM_in_alter_event_expression1733); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMPLETION_SYM330_tree = (CommonTree)adaptor.create(COMPLETION_SYM330);
                    adaptor.addChild(root_0, COMPLETION_SYM330_tree);
                    }
                    // SQLParser1.g:279:21: ( NOT_SYM )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==NOT_SYM) ) {
                        alt111=1;
                    }
                    switch (alt111) {
                        case 1 :
                            // SQLParser1.g:279:22: NOT_SYM
                            {
                            NOT_SYM331=(Token)match(input,NOT_SYM,FOLLOW_NOT_SYM_in_alter_event_expression1736); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT_SYM331_tree = (CommonTree)adaptor.create(NOT_SYM331);
                            adaptor.addChild(root_0, NOT_SYM331_tree);
                            }

                            }
                            break;

                    }

                    PRESERVE_SYM332=(Token)match(input,PRESERVE_SYM,FOLLOW_PRESERVE_SYM_in_alter_event_expression1740); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PRESERVE_SYM332_tree = (CommonTree)adaptor.create(PRESERVE_SYM332);
                    adaptor.addChild(root_0, PRESERVE_SYM332_tree);
                    }

                    }
                    break;

            }

            // SQLParser1.g:280:2: ( RENAME TO_SYM event_name )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==RENAME) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // SQLParser1.g:280:3: RENAME TO_SYM event_name
                    {
                    RENAME333=(Token)match(input,RENAME,FOLLOW_RENAME_in_alter_event_expression1746); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RENAME333_tree = (CommonTree)adaptor.create(RENAME333);
                    adaptor.addChild(root_0, RENAME333_tree);
                    }
                    TO_SYM334=(Token)match(input,TO_SYM,FOLLOW_TO_SYM_in_alter_event_expression1748); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TO_SYM334_tree = (CommonTree)adaptor.create(TO_SYM334);
                    adaptor.addChild(root_0, TO_SYM334_tree);
                    }
                    pushFollow(FOLLOW_event_name_in_alter_event_expression1750);
                    event_name335=gMySQL.event_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, event_name335.getTree());

                    }
                    break;

            }

            // SQLParser1.g:281:2: ( ENABLE_SYM | DISABLE_SYM | ( DISABLE_SYM ON SLAVE ) )?
            int alt114=4;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==ENABLE_SYM) ) {
                alt114=1;
            }
            else if ( (LA114_0==DISABLE_SYM) ) {
                int LA114_2 = input.LA(2);

                if ( (LA114_2==ON) ) {
                    alt114=3;
                }
                else if ( (LA114_2==EOF||LA114_2==COMMENT_SYM||LA114_2==DO_SYM||LA114_2==SEMI) ) {
                    alt114=2;
                }
            }
            switch (alt114) {
                case 1 :
                    // SQLParser1.g:281:4: ENABLE_SYM
                    {
                    ENABLE_SYM336=(Token)match(input,ENABLE_SYM,FOLLOW_ENABLE_SYM_in_alter_event_expression1757); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ENABLE_SYM336_tree = (CommonTree)adaptor.create(ENABLE_SYM336);
                    adaptor.addChild(root_0, ENABLE_SYM336_tree);
                    }

                    }
                    break;
                case 2 :
                    // SQLParser1.g:281:17: DISABLE_SYM
                    {
                    DISABLE_SYM337=(Token)match(input,DISABLE_SYM,FOLLOW_DISABLE_SYM_in_alter_event_expression1761); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISABLE_SYM337_tree = (CommonTree)adaptor.create(DISABLE_SYM337);
                    adaptor.addChild(root_0, DISABLE_SYM337_tree);
                    }

                    }
                    break;
                case 3 :
                    // SQLParser1.g:281:31: ( DISABLE_SYM ON SLAVE )
                    {
                    // SQLParser1.g:281:31: ( DISABLE_SYM ON SLAVE )
                    // SQLParser1.g:281:32: DISABLE_SYM ON SLAVE
                    {
                    DISABLE_SYM338=(Token)match(input,DISABLE_SYM,FOLLOW_DISABLE_SYM_in_alter_event_expression1766); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISABLE_SYM338_tree = (CommonTree)adaptor.create(DISABLE_SYM338);
                    adaptor.addChild(root_0, DISABLE_SYM338_tree);
                    }
                    ON339=(Token)match(input,ON,FOLLOW_ON_in_alter_event_expression1768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ON339_tree = (CommonTree)adaptor.create(ON339);
                    adaptor.addChild(root_0, ON339_tree);
                    }
                    SLAVE340=(Token)match(input,SLAVE,FOLLOW_SLAVE_in_alter_event_expression1770); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SLAVE340_tree = (CommonTree)adaptor.create(SLAVE340);
                    adaptor.addChild(root_0, SLAVE340_tree);
                    }

                    }


                    }
                    break;

            }

            // SQLParser1.g:282:2: ( COMMENT_SYM TEXT_STRING )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==COMMENT_SYM) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // SQLParser1.g:282:3: COMMENT_SYM TEXT_STRING
                    {
                    COMMENT_SYM341=(Token)match(input,COMMENT_SYM,FOLLOW_COMMENT_SYM_in_alter_event_expression1778); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMENT_SYM341_tree = (CommonTree)adaptor.create(COMMENT_SYM341);
                    adaptor.addChild(root_0, COMMENT_SYM341_tree);
                    }
                    TEXT_STRING342=(Token)match(input,TEXT_STRING,FOLLOW_TEXT_STRING_in_alter_event_expression1780); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT_STRING342_tree = (CommonTree)adaptor.create(TEXT_STRING342);
                    adaptor.addChild(root_0, TEXT_STRING342_tree);
                    }

                    }
                    break;

            }

            // SQLParser1.g:283:2: ( do_statement )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==DO_SYM) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // SQLParser1.g:283:3: do_statement
                    {
                    pushFollow(FOLLOW_do_statement_in_alter_event_expression1786);
                    do_statement343=do_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, do_statement343.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 49, alter_event_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alter_event_expression"

    public static class drop_event_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_event_statement"
    // SQLParser1.g:287:1: drop_event_statement : DROP drop_event_expression -> ^( TN_DROP drop_event_expression ) ;
    public final MySQL_SQLParser1.drop_event_statement_return drop_event_statement() throws RecognitionException {
        MySQL_SQLParser1.drop_event_statement_return retval = new MySQL_SQLParser1.drop_event_statement_return();
        retval.start = input.LT(1);
        int drop_event_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DROP344=null;
        MySQL_SQLParser1.drop_event_expression_return drop_event_expression345 = null;


        CommonTree DROP344_tree=null;
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleSubtreeStream stream_drop_event_expression=new RewriteRuleSubtreeStream(adaptor,"rule drop_event_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // SQLParser1.g:287:21: ( DROP drop_event_expression -> ^( TN_DROP drop_event_expression ) )
            // SQLParser1.g:288:2: DROP drop_event_expression
            {
            DROP344=(Token)match(input,DROP,FOLLOW_DROP_in_drop_event_statement1798); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP344);

            pushFollow(FOLLOW_drop_event_expression_in_drop_event_statement1800);
            drop_event_expression345=drop_event_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_drop_event_expression.add(drop_event_expression345.getTree());


            // AST REWRITE
            // elements: drop_event_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 288:29: -> ^( TN_DROP drop_event_expression )
            {
                // SQLParser1.g:288:32: ^( TN_DROP drop_event_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_DROP, "TN_DROP"), root_1);

                adaptor.addChild(root_1, stream_drop_event_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 50, drop_event_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "drop_event_statement"

    public static class drop_event_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_event_expression"
    // SQLParser1.g:290:1: drop_event_expression : EVENT_SYM ( IF EXISTS )? event_name ;
    public final MySQL_SQLParser1.drop_event_expression_return drop_event_expression() throws RecognitionException {
        MySQL_SQLParser1.drop_event_expression_return retval = new MySQL_SQLParser1.drop_event_expression_return();
        retval.start = input.LT(1);
        int drop_event_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token EVENT_SYM346=null;
        Token IF347=null;
        Token EXISTS348=null;
        MySQLParser.event_name_return event_name349 = null;


        CommonTree EVENT_SYM346_tree=null;
        CommonTree IF347_tree=null;
        CommonTree EXISTS348_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // SQLParser1.g:290:22: ( EVENT_SYM ( IF EXISTS )? event_name )
            // SQLParser1.g:291:2: EVENT_SYM ( IF EXISTS )? event_name
            {
            root_0 = (CommonTree)adaptor.nil();

            EVENT_SYM346=(Token)match(input,EVENT_SYM,FOLLOW_EVENT_SYM_in_drop_event_expression1816); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EVENT_SYM346_tree = (CommonTree)adaptor.create(EVENT_SYM346);
            adaptor.addChild(root_0, EVENT_SYM346_tree);
            }
            // SQLParser1.g:291:12: ( IF EXISTS )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==IF) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // SQLParser1.g:291:13: IF EXISTS
                    {
                    IF347=(Token)match(input,IF,FOLLOW_IF_in_drop_event_expression1819); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF347_tree = (CommonTree)adaptor.create(IF347);
                    adaptor.addChild(root_0, IF347_tree);
                    }
                    EXISTS348=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_drop_event_expression1821); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXISTS348_tree = (CommonTree)adaptor.create(EXISTS348);
                    adaptor.addChild(root_0, EXISTS348_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_event_name_in_drop_event_expression1825);
            event_name349=gMySQL.event_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, event_name349.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 51, drop_event_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "drop_event_expression"

    public static class create_index_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_index_statement"
    // SQLParser1.g:295:1: create_index_statement : CREATE create_index_expression -> ^( TN_CREATE create_index_expression ) ;
    public final MySQL_SQLParser1.create_index_statement_return create_index_statement() throws RecognitionException {
        MySQL_SQLParser1.create_index_statement_return retval = new MySQL_SQLParser1.create_index_statement_return();
        retval.start = input.LT(1);
        int create_index_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CREATE350=null;
        MySQL_SQLParser1.create_index_expression_return create_index_expression351 = null;


        CommonTree CREATE350_tree=null;
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleSubtreeStream stream_create_index_expression=new RewriteRuleSubtreeStream(adaptor,"rule create_index_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // SQLParser1.g:295:23: ( CREATE create_index_expression -> ^( TN_CREATE create_index_expression ) )
            // SQLParser1.g:296:2: CREATE create_index_expression
            {
            CREATE350=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_index_statement1835); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE350);

            pushFollow(FOLLOW_create_index_expression_in_create_index_statement1837);
            create_index_expression351=create_index_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_create_index_expression.add(create_index_expression351.getTree());


            // AST REWRITE
            // elements: create_index_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 296:33: -> ^( TN_CREATE create_index_expression )
            {
                // SQLParser1.g:296:36: ^( TN_CREATE create_index_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_CREATE, "TN_CREATE"), root_1);

                adaptor.addChild(root_1, stream_create_index_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 52, create_index_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "create_index_statement"

    public static class create_index_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_index_expression"
    // SQLParser1.g:298:1: create_index_expression : ( UNIQUE_SYM | FULLTEXT_SYM | SPATIAL_SYM )? INDEX_SYM index_name ( index_type )? ON table_name LPAREN index_column_name ( COMMA index_column_name )* RPAREN ( algorithm_option | lock_option )* ;
    public final MySQL_SQLParser1.create_index_expression_return create_index_expression() throws RecognitionException {
        MySQL_SQLParser1.create_index_expression_return retval = new MySQL_SQLParser1.create_index_expression_return();
        retval.start = input.LT(1);
        int create_index_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set352=null;
        Token INDEX_SYM353=null;
        Token ON356=null;
        Token LPAREN358=null;
        Token COMMA360=null;
        Token RPAREN362=null;
        MySQLParser.index_name_return index_name354 = null;

        MySQL_SQLParser2.index_type_return index_type355 = null;

        MySQLParser.table_name_return table_name357 = null;

        MySQL_SQLParser2.index_column_name_return index_column_name359 = null;

        MySQL_SQLParser2.index_column_name_return index_column_name361 = null;

        MySQL_SQLParser1.algorithm_option_return algorithm_option363 = null;

        MySQL_SQLParser1.lock_option_return lock_option364 = null;


        CommonTree set352_tree=null;
        CommonTree INDEX_SYM353_tree=null;
        CommonTree ON356_tree=null;
        CommonTree LPAREN358_tree=null;
        CommonTree COMMA360_tree=null;
        CommonTree RPAREN362_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // SQLParser1.g:298:24: ( ( UNIQUE_SYM | FULLTEXT_SYM | SPATIAL_SYM )? INDEX_SYM index_name ( index_type )? ON table_name LPAREN index_column_name ( COMMA index_column_name )* RPAREN ( algorithm_option | lock_option )* )
            // SQLParser1.g:299:2: ( UNIQUE_SYM | FULLTEXT_SYM | SPATIAL_SYM )? INDEX_SYM index_name ( index_type )? ON table_name LPAREN index_column_name ( COMMA index_column_name )* RPAREN ( algorithm_option | lock_option )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:299:2: ( UNIQUE_SYM | FULLTEXT_SYM | SPATIAL_SYM )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==FULLTEXT_SYM||LA118_0==SPATIAL_SYM||LA118_0==UNIQUE_SYM) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // SQLParser1.g:
                    {
                    set352=(Token)input.LT(1);
                    if ( input.LA(1)==FULLTEXT_SYM||input.LA(1)==SPATIAL_SYM||input.LA(1)==UNIQUE_SYM ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set352));
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

            INDEX_SYM353=(Token)match(input,INDEX_SYM,FOLLOW_INDEX_SYM_in_create_index_expression1862); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INDEX_SYM353_tree = (CommonTree)adaptor.create(INDEX_SYM353);
            adaptor.addChild(root_0, INDEX_SYM353_tree);
            }
            pushFollow(FOLLOW_index_name_in_create_index_expression1864);
            index_name354=gMySQL.index_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, index_name354.getTree());
            // SQLParser1.g:300:2: ( index_type )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==USING_SYM) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // SQLParser1.g:300:3: index_type
                    {
                    pushFollow(FOLLOW_index_type_in_create_index_expression1868);
                    index_type355=gMySQL.index_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, index_type355.getTree());

                    }
                    break;

            }

            ON356=(Token)match(input,ON,FOLLOW_ON_in_create_index_expression1873); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ON356_tree = (CommonTree)adaptor.create(ON356);
            adaptor.addChild(root_0, ON356_tree);
            }
            pushFollow(FOLLOW_table_name_in_create_index_expression1875);
            table_name357=gMySQL.table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name357.getTree());
            LPAREN358=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_index_expression1877); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN358_tree = (CommonTree)adaptor.create(LPAREN358);
            adaptor.addChild(root_0, LPAREN358_tree);
            }
            pushFollow(FOLLOW_index_column_name_in_create_index_expression1879);
            index_column_name359=gMySQL.index_column_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, index_column_name359.getTree());
            // SQLParser1.g:301:41: ( COMMA index_column_name )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==COMMA) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // SQLParser1.g:301:42: COMMA index_column_name
            	    {
            	    COMMA360=(Token)match(input,COMMA,FOLLOW_COMMA_in_create_index_expression1882); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA360_tree = (CommonTree)adaptor.create(COMMA360);
            	    adaptor.addChild(root_0, COMMA360_tree);
            	    }
            	    pushFollow(FOLLOW_index_column_name_in_create_index_expression1884);
            	    index_column_name361=gMySQL.index_column_name();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, index_column_name361.getTree());

            	    }
            	    break;

            	default :
            	    break loop120;
                }
            } while (true);

            RPAREN362=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_index_expression1888); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN362_tree = (CommonTree)adaptor.create(RPAREN362);
            adaptor.addChild(root_0, RPAREN362_tree);
            }
            // SQLParser1.g:302:2: ( algorithm_option | lock_option )*
            loop121:
            do {
                int alt121=3;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==ALGORITHM_SYM) ) {
                    alt121=1;
                }
                else if ( (LA121_0==LOCK) ) {
                    alt121=2;
                }


                switch (alt121) {
            	case 1 :
            	    // SQLParser1.g:302:3: algorithm_option
            	    {
            	    pushFollow(FOLLOW_algorithm_option_in_create_index_expression1892);
            	    algorithm_option363=algorithm_option();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, algorithm_option363.getTree());

            	    }
            	    break;
            	case 2 :
            	    // SQLParser1.g:302:22: lock_option
            	    {
            	    pushFollow(FOLLOW_lock_option_in_create_index_expression1896);
            	    lock_option364=lock_option();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, lock_option364.getTree());

            	    }
            	    break;

            	default :
            	    break loop121;
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
            if ( state.backtracking>0 ) { memoize(input, 53, create_index_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "create_index_expression"

    public static class algorithm_option_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "algorithm_option"
    // SQLParser1.g:304:1: algorithm_option : ALGORITHM_SYM ( EQ_SYM )? ( DEFAULT | INPLACE_SYM | COPY_SYM ) ;
    public final MySQL_SQLParser1.algorithm_option_return algorithm_option() throws RecognitionException {
        MySQL_SQLParser1.algorithm_option_return retval = new MySQL_SQLParser1.algorithm_option_return();
        retval.start = input.LT(1);
        int algorithm_option_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ALGORITHM_SYM365=null;
        Token EQ_SYM366=null;
        Token set367=null;

        CommonTree ALGORITHM_SYM365_tree=null;
        CommonTree EQ_SYM366_tree=null;
        CommonTree set367_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // SQLParser1.g:304:17: ( ALGORITHM_SYM ( EQ_SYM )? ( DEFAULT | INPLACE_SYM | COPY_SYM ) )
            // SQLParser1.g:305:2: ALGORITHM_SYM ( EQ_SYM )? ( DEFAULT | INPLACE_SYM | COPY_SYM )
            {
            root_0 = (CommonTree)adaptor.nil();

            ALGORITHM_SYM365=(Token)match(input,ALGORITHM_SYM,FOLLOW_ALGORITHM_SYM_in_algorithm_option1906); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ALGORITHM_SYM365_tree = (CommonTree)adaptor.create(ALGORITHM_SYM365);
            adaptor.addChild(root_0, ALGORITHM_SYM365_tree);
            }
            // SQLParser1.g:305:16: ( EQ_SYM )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==EQ_SYM) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // SQLParser1.g:305:17: EQ_SYM
                    {
                    EQ_SYM366=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_algorithm_option1909); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQ_SYM366_tree = (CommonTree)adaptor.create(EQ_SYM366);
                    adaptor.addChild(root_0, EQ_SYM366_tree);
                    }

                    }
                    break;

            }

            set367=(Token)input.LT(1);
            if ( input.LA(1)==COPY_SYM||input.LA(1)==DEFAULT||input.LA(1)==INPLACE_SYM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set367));
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
            if ( state.backtracking>0 ) { memoize(input, 54, algorithm_option_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "algorithm_option"

    public static class lock_option_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lock_option"
    // SQLParser1.g:307:1: lock_option : LOCK ( EQ_SYM )? ( DEFAULT | NONE_SYM | SHARED_SYM | EXCLUSIVE_SYM ) ;
    public final MySQL_SQLParser1.lock_option_return lock_option() throws RecognitionException {
        MySQL_SQLParser1.lock_option_return retval = new MySQL_SQLParser1.lock_option_return();
        retval.start = input.LT(1);
        int lock_option_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LOCK368=null;
        Token EQ_SYM369=null;
        Token set370=null;

        CommonTree LOCK368_tree=null;
        CommonTree EQ_SYM369_tree=null;
        CommonTree set370_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // SQLParser1.g:307:12: ( LOCK ( EQ_SYM )? ( DEFAULT | NONE_SYM | SHARED_SYM | EXCLUSIVE_SYM ) )
            // SQLParser1.g:308:2: LOCK ( EQ_SYM )? ( DEFAULT | NONE_SYM | SHARED_SYM | EXCLUSIVE_SYM )
            {
            root_0 = (CommonTree)adaptor.nil();

            LOCK368=(Token)match(input,LOCK,FOLLOW_LOCK_in_lock_option1927); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOCK368_tree = (CommonTree)adaptor.create(LOCK368);
            adaptor.addChild(root_0, LOCK368_tree);
            }
            // SQLParser1.g:308:7: ( EQ_SYM )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==EQ_SYM) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // SQLParser1.g:308:8: EQ_SYM
                    {
                    EQ_SYM369=(Token)match(input,EQ_SYM,FOLLOW_EQ_SYM_in_lock_option1930); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQ_SYM369_tree = (CommonTree)adaptor.create(EQ_SYM369);
                    adaptor.addChild(root_0, EQ_SYM369_tree);
                    }

                    }
                    break;

            }

            set370=(Token)input.LT(1);
            if ( input.LA(1)==DEFAULT||input.LA(1)==EXCLUSIVE_SYM||input.LA(1)==NONE_SYM||input.LA(1)==SHARED_SYM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set370));
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
            if ( state.backtracking>0 ) { memoize(input, 55, lock_option_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "lock_option"

    public static class drop_index_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_index_statement"
    // SQLParser1.g:313:1: drop_index_statement : DROP drop_index_expression -> ^( TN_DROP drop_index_expression ) ;
    public final MySQL_SQLParser1.drop_index_statement_return drop_index_statement() throws RecognitionException {
        MySQL_SQLParser1.drop_index_statement_return retval = new MySQL_SQLParser1.drop_index_statement_return();
        retval.start = input.LT(1);
        int drop_index_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DROP371=null;
        MySQL_SQLParser1.drop_index_expression_return drop_index_expression372 = null;


        CommonTree DROP371_tree=null;
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleSubtreeStream stream_drop_index_expression=new RewriteRuleSubtreeStream(adaptor,"rule drop_index_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // SQLParser1.g:313:21: ( DROP drop_index_expression -> ^( TN_DROP drop_index_expression ) )
            // SQLParser1.g:314:2: DROP drop_index_expression
            {
            DROP371=(Token)match(input,DROP,FOLLOW_DROP_in_drop_index_statement1953); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP371);

            pushFollow(FOLLOW_drop_index_expression_in_drop_index_statement1955);
            drop_index_expression372=drop_index_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_drop_index_expression.add(drop_index_expression372.getTree());


            // AST REWRITE
            // elements: drop_index_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 314:29: -> ^( TN_DROP drop_index_expression )
            {
                // SQLParser1.g:314:32: ^( TN_DROP drop_index_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_DROP, "TN_DROP"), root_1);

                adaptor.addChild(root_1, stream_drop_index_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 56, drop_index_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "drop_index_statement"

    public static class drop_index_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_index_expression"
    // SQLParser1.g:316:1: drop_index_expression : INDEX_SYM index_name ON table_name ( algorithm_option | lock_option )* ;
    public final MySQL_SQLParser1.drop_index_expression_return drop_index_expression() throws RecognitionException {
        MySQL_SQLParser1.drop_index_expression_return retval = new MySQL_SQLParser1.drop_index_expression_return();
        retval.start = input.LT(1);
        int drop_index_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token INDEX_SYM373=null;
        Token ON375=null;
        MySQLParser.index_name_return index_name374 = null;

        MySQLParser.table_name_return table_name376 = null;

        MySQL_SQLParser1.algorithm_option_return algorithm_option377 = null;

        MySQL_SQLParser1.lock_option_return lock_option378 = null;


        CommonTree INDEX_SYM373_tree=null;
        CommonTree ON375_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // SQLParser1.g:316:22: ( INDEX_SYM index_name ON table_name ( algorithm_option | lock_option )* )
            // SQLParser1.g:317:2: INDEX_SYM index_name ON table_name ( algorithm_option | lock_option )*
            {
            root_0 = (CommonTree)adaptor.nil();

            INDEX_SYM373=(Token)match(input,INDEX_SYM,FOLLOW_INDEX_SYM_in_drop_index_expression1971); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INDEX_SYM373_tree = (CommonTree)adaptor.create(INDEX_SYM373);
            adaptor.addChild(root_0, INDEX_SYM373_tree);
            }
            pushFollow(FOLLOW_index_name_in_drop_index_expression1973);
            index_name374=gMySQL.index_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, index_name374.getTree());
            ON375=(Token)match(input,ON,FOLLOW_ON_in_drop_index_expression1975); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ON375_tree = (CommonTree)adaptor.create(ON375);
            adaptor.addChild(root_0, ON375_tree);
            }
            pushFollow(FOLLOW_table_name_in_drop_index_expression1977);
            table_name376=gMySQL.table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name376.getTree());
            // SQLParser1.g:318:2: ( algorithm_option | lock_option )*
            loop124:
            do {
                int alt124=3;
                int LA124_0 = input.LA(1);

                if ( (LA124_0==ALGORITHM_SYM) ) {
                    alt124=1;
                }
                else if ( (LA124_0==LOCK) ) {
                    alt124=2;
                }


                switch (alt124) {
            	case 1 :
            	    // SQLParser1.g:318:3: algorithm_option
            	    {
            	    pushFollow(FOLLOW_algorithm_option_in_drop_index_expression1981);
            	    algorithm_option377=algorithm_option();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, algorithm_option377.getTree());

            	    }
            	    break;
            	case 2 :
            	    // SQLParser1.g:318:22: lock_option
            	    {
            	    pushFollow(FOLLOW_lock_option_in_drop_index_expression1985);
            	    lock_option378=lock_option();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, lock_option378.getTree());

            	    }
            	    break;

            	default :
            	    break loop124;
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
            if ( state.backtracking>0 ) { memoize(input, 57, drop_index_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "drop_index_expression"

    public static class create_server_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_server_statement"
    // SQLParser1.g:322:1: create_server_statement : CREATE create_server_expression -> ^( TN_CREATE create_server_expression ) ;
    public final MySQL_SQLParser1.create_server_statement_return create_server_statement() throws RecognitionException {
        MySQL_SQLParser1.create_server_statement_return retval = new MySQL_SQLParser1.create_server_statement_return();
        retval.start = input.LT(1);
        int create_server_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CREATE379=null;
        MySQL_SQLParser1.create_server_expression_return create_server_expression380 = null;


        CommonTree CREATE379_tree=null;
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleSubtreeStream stream_create_server_expression=new RewriteRuleSubtreeStream(adaptor,"rule create_server_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // SQLParser1.g:322:24: ( CREATE create_server_expression -> ^( TN_CREATE create_server_expression ) )
            // SQLParser1.g:323:2: CREATE create_server_expression
            {
            CREATE379=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_server_statement1997); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE379);

            pushFollow(FOLLOW_create_server_expression_in_create_server_statement1999);
            create_server_expression380=create_server_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_create_server_expression.add(create_server_expression380.getTree());


            // AST REWRITE
            // elements: create_server_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 323:34: -> ^( TN_CREATE create_server_expression )
            {
                // SQLParser1.g:323:37: ^( TN_CREATE create_server_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_CREATE, "TN_CREATE"), root_1);

                adaptor.addChild(root_1, stream_create_server_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 58, create_server_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "create_server_statement"

    public static class create_server_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_server_expression"
    // SQLParser1.g:325:1: create_server_expression : SERVER_SYM server_name FOREIGN DATA_SYM WRAPPER_SYM wrapper_name OPTIONS_SYM LPAREN create_server_option ( COMMA create_server_option )* RPAREN ;
    public final MySQL_SQLParser1.create_server_expression_return create_server_expression() throws RecognitionException {
        MySQL_SQLParser1.create_server_expression_return retval = new MySQL_SQLParser1.create_server_expression_return();
        retval.start = input.LT(1);
        int create_server_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SERVER_SYM381=null;
        Token FOREIGN383=null;
        Token DATA_SYM384=null;
        Token WRAPPER_SYM385=null;
        Token OPTIONS_SYM387=null;
        Token LPAREN388=null;
        Token COMMA390=null;
        Token RPAREN392=null;
        MySQLParser.server_name_return server_name382 = null;

        MySQLParser.wrapper_name_return wrapper_name386 = null;

        MySQL_SQLParser1.create_server_option_return create_server_option389 = null;

        MySQL_SQLParser1.create_server_option_return create_server_option391 = null;


        CommonTree SERVER_SYM381_tree=null;
        CommonTree FOREIGN383_tree=null;
        CommonTree DATA_SYM384_tree=null;
        CommonTree WRAPPER_SYM385_tree=null;
        CommonTree OPTIONS_SYM387_tree=null;
        CommonTree LPAREN388_tree=null;
        CommonTree COMMA390_tree=null;
        CommonTree RPAREN392_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // SQLParser1.g:325:25: ( SERVER_SYM server_name FOREIGN DATA_SYM WRAPPER_SYM wrapper_name OPTIONS_SYM LPAREN create_server_option ( COMMA create_server_option )* RPAREN )
            // SQLParser1.g:326:2: SERVER_SYM server_name FOREIGN DATA_SYM WRAPPER_SYM wrapper_name OPTIONS_SYM LPAREN create_server_option ( COMMA create_server_option )* RPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            SERVER_SYM381=(Token)match(input,SERVER_SYM,FOLLOW_SERVER_SYM_in_create_server_expression2015); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SERVER_SYM381_tree = (CommonTree)adaptor.create(SERVER_SYM381);
            adaptor.addChild(root_0, SERVER_SYM381_tree);
            }
            pushFollow(FOLLOW_server_name_in_create_server_expression2017);
            server_name382=gMySQL.server_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, server_name382.getTree());
            FOREIGN383=(Token)match(input,FOREIGN,FOLLOW_FOREIGN_in_create_server_expression2020); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREIGN383_tree = (CommonTree)adaptor.create(FOREIGN383);
            adaptor.addChild(root_0, FOREIGN383_tree);
            }
            DATA_SYM384=(Token)match(input,DATA_SYM,FOLLOW_DATA_SYM_in_create_server_expression2022); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DATA_SYM384_tree = (CommonTree)adaptor.create(DATA_SYM384);
            adaptor.addChild(root_0, DATA_SYM384_tree);
            }
            WRAPPER_SYM385=(Token)match(input,WRAPPER_SYM,FOLLOW_WRAPPER_SYM_in_create_server_expression2024); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WRAPPER_SYM385_tree = (CommonTree)adaptor.create(WRAPPER_SYM385);
            adaptor.addChild(root_0, WRAPPER_SYM385_tree);
            }
            pushFollow(FOLLOW_wrapper_name_in_create_server_expression2026);
            wrapper_name386=gMySQL.wrapper_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, wrapper_name386.getTree());
            OPTIONS_SYM387=(Token)match(input,OPTIONS_SYM,FOLLOW_OPTIONS_SYM_in_create_server_expression2029); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OPTIONS_SYM387_tree = (CommonTree)adaptor.create(OPTIONS_SYM387);
            adaptor.addChild(root_0, OPTIONS_SYM387_tree);
            }
            LPAREN388=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_server_expression2031); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN388_tree = (CommonTree)adaptor.create(LPAREN388);
            adaptor.addChild(root_0, LPAREN388_tree);
            }
            pushFollow(FOLLOW_create_server_option_in_create_server_expression2033);
            create_server_option389=create_server_option();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, create_server_option389.getTree());
            // SQLParser1.g:328:42: ( COMMA create_server_option )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==COMMA) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // SQLParser1.g:328:43: COMMA create_server_option
            	    {
            	    COMMA390=(Token)match(input,COMMA,FOLLOW_COMMA_in_create_server_expression2036); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA390_tree = (CommonTree)adaptor.create(COMMA390);
            	    adaptor.addChild(root_0, COMMA390_tree);
            	    }
            	    pushFollow(FOLLOW_create_server_option_in_create_server_expression2038);
            	    create_server_option391=create_server_option();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_server_option391.getTree());

            	    }
            	    break;

            	default :
            	    break loop125;
                }
            } while (true);

            RPAREN392=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_server_expression2042); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN392_tree = (CommonTree)adaptor.create(RPAREN392);
            adaptor.addChild(root_0, RPAREN392_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 59, create_server_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "create_server_expression"

    public static class create_server_option_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_server_option"
    // SQLParser1.g:330:1: create_server_option : ( | ( HOST_SYM string_literal ) | ( DATABASE string_literal ) | ( USER string_literal ) | ( PASSWORD string_literal ) | ( SOCKET_SYM string_literal ) | ( OWNER_SYM string_literal ) | ( PORT_SYM number_literal ) );
    public final MySQL_SQLParser1.create_server_option_return create_server_option() throws RecognitionException {
        MySQL_SQLParser1.create_server_option_return retval = new MySQL_SQLParser1.create_server_option_return();
        retval.start = input.LT(1);
        int create_server_option_StartIndex = input.index();
        CommonTree root_0 = null;

        Token HOST_SYM393=null;
        Token DATABASE395=null;
        Token USER397=null;
        Token PASSWORD399=null;
        Token SOCKET_SYM401=null;
        Token OWNER_SYM403=null;
        Token PORT_SYM405=null;
        MySQLParser.string_literal_return string_literal394 = null;

        MySQLParser.string_literal_return string_literal396 = null;

        MySQLParser.string_literal_return string_literal398 = null;

        MySQLParser.string_literal_return string_literal400 = null;

        MySQLParser.string_literal_return string_literal402 = null;

        MySQLParser.string_literal_return string_literal404 = null;

        MySQLParser.number_literal_return number_literal406 = null;


        CommonTree HOST_SYM393_tree=null;
        CommonTree DATABASE395_tree=null;
        CommonTree USER397_tree=null;
        CommonTree PASSWORD399_tree=null;
        CommonTree SOCKET_SYM401_tree=null;
        CommonTree OWNER_SYM403_tree=null;
        CommonTree PORT_SYM405_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // SQLParser1.g:330:21: ( | ( HOST_SYM string_literal ) | ( DATABASE string_literal ) | ( USER string_literal ) | ( PASSWORD string_literal ) | ( SOCKET_SYM string_literal ) | ( OWNER_SYM string_literal ) | ( PORT_SYM number_literal ) )
            int alt126=8;
            switch ( input.LA(1) ) {
            case EOF:
            case COMMA:
            case RPAREN:
                {
                alt126=1;
                }
                break;
            case HOST_SYM:
                {
                alt126=2;
                }
                break;
            case DATABASE:
                {
                alt126=3;
                }
                break;
            case USER:
                {
                alt126=4;
                }
                break;
            case PASSWORD:
                {
                alt126=5;
                }
                break;
            case SOCKET_SYM:
                {
                alt126=6;
                }
                break;
            case OWNER_SYM:
                {
                alt126=7;
                }
                break;
            case PORT_SYM:
                {
                alt126=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;
            }

            switch (alt126) {
                case 1 :
                    // SQLParser1.g:331:2: 
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    }
                    break;
                case 2 :
                    // SQLParser1.g:331:4: ( HOST_SYM string_literal )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:331:4: ( HOST_SYM string_literal )
                    // SQLParser1.g:331:6: HOST_SYM string_literal
                    {
                    HOST_SYM393=(Token)match(input,HOST_SYM,FOLLOW_HOST_SYM_in_create_server_option2054); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HOST_SYM393_tree = (CommonTree)adaptor.create(HOST_SYM393);
                    adaptor.addChild(root_0, HOST_SYM393_tree);
                    }
                    pushFollow(FOLLOW_string_literal_in_create_server_option2056);
                    string_literal394=gMySQL.string_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string_literal394.getTree());

                    }


                    }
                    break;
                case 3 :
                    // SQLParser1.g:332:4: ( DATABASE string_literal )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:332:4: ( DATABASE string_literal )
                    // SQLParser1.g:332:6: DATABASE string_literal
                    {
                    DATABASE395=(Token)match(input,DATABASE,FOLLOW_DATABASE_in_create_server_option2065); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATABASE395_tree = (CommonTree)adaptor.create(DATABASE395);
                    adaptor.addChild(root_0, DATABASE395_tree);
                    }
                    pushFollow(FOLLOW_string_literal_in_create_server_option2067);
                    string_literal396=gMySQL.string_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string_literal396.getTree());

                    }


                    }
                    break;
                case 4 :
                    // SQLParser1.g:333:4: ( USER string_literal )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:333:4: ( USER string_literal )
                    // SQLParser1.g:333:6: USER string_literal
                    {
                    USER397=(Token)match(input,USER,FOLLOW_USER_in_create_server_option2076); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USER397_tree = (CommonTree)adaptor.create(USER397);
                    adaptor.addChild(root_0, USER397_tree);
                    }
                    pushFollow(FOLLOW_string_literal_in_create_server_option2078);
                    string_literal398=gMySQL.string_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string_literal398.getTree());

                    }


                    }
                    break;
                case 5 :
                    // SQLParser1.g:334:4: ( PASSWORD string_literal )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:334:4: ( PASSWORD string_literal )
                    // SQLParser1.g:334:6: PASSWORD string_literal
                    {
                    PASSWORD399=(Token)match(input,PASSWORD,FOLLOW_PASSWORD_in_create_server_option2087); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PASSWORD399_tree = (CommonTree)adaptor.create(PASSWORD399);
                    adaptor.addChild(root_0, PASSWORD399_tree);
                    }
                    pushFollow(FOLLOW_string_literal_in_create_server_option2089);
                    string_literal400=gMySQL.string_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string_literal400.getTree());

                    }


                    }
                    break;
                case 6 :
                    // SQLParser1.g:335:4: ( SOCKET_SYM string_literal )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:335:4: ( SOCKET_SYM string_literal )
                    // SQLParser1.g:335:6: SOCKET_SYM string_literal
                    {
                    SOCKET_SYM401=(Token)match(input,SOCKET_SYM,FOLLOW_SOCKET_SYM_in_create_server_option2098); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SOCKET_SYM401_tree = (CommonTree)adaptor.create(SOCKET_SYM401);
                    adaptor.addChild(root_0, SOCKET_SYM401_tree);
                    }
                    pushFollow(FOLLOW_string_literal_in_create_server_option2100);
                    string_literal402=gMySQL.string_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string_literal402.getTree());

                    }


                    }
                    break;
                case 7 :
                    // SQLParser1.g:336:4: ( OWNER_SYM string_literal )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:336:4: ( OWNER_SYM string_literal )
                    // SQLParser1.g:336:6: OWNER_SYM string_literal
                    {
                    OWNER_SYM403=(Token)match(input,OWNER_SYM,FOLLOW_OWNER_SYM_in_create_server_option2109); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OWNER_SYM403_tree = (CommonTree)adaptor.create(OWNER_SYM403);
                    adaptor.addChild(root_0, OWNER_SYM403_tree);
                    }
                    pushFollow(FOLLOW_string_literal_in_create_server_option2111);
                    string_literal404=gMySQL.string_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string_literal404.getTree());

                    }


                    }
                    break;
                case 8 :
                    // SQLParser1.g:337:4: ( PORT_SYM number_literal )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // SQLParser1.g:337:4: ( PORT_SYM number_literal )
                    // SQLParser1.g:337:6: PORT_SYM number_literal
                    {
                    PORT_SYM405=(Token)match(input,PORT_SYM,FOLLOW_PORT_SYM_in_create_server_option2120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PORT_SYM405_tree = (CommonTree)adaptor.create(PORT_SYM405);
                    adaptor.addChild(root_0, PORT_SYM405_tree);
                    }
                    pushFollow(FOLLOW_number_literal_in_create_server_option2122);
                    number_literal406=gMySQL.number_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, number_literal406.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 60, create_server_option_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "create_server_option"

    public static class alter_server_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alter_server_statement"
    // SQLParser1.g:342:1: alter_server_statement : ALTER alter_server_expression -> ^( TN_ALTER alter_server_expression ) ;
    public final MySQL_SQLParser1.alter_server_statement_return alter_server_statement() throws RecognitionException {
        MySQL_SQLParser1.alter_server_statement_return retval = new MySQL_SQLParser1.alter_server_statement_return();
        retval.start = input.LT(1);
        int alter_server_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ALTER407=null;
        MySQL_SQLParser1.alter_server_expression_return alter_server_expression408 = null;


        CommonTree ALTER407_tree=null;
        RewriteRuleTokenStream stream_ALTER=new RewriteRuleTokenStream(adaptor,"token ALTER");
        RewriteRuleSubtreeStream stream_alter_server_expression=new RewriteRuleSubtreeStream(adaptor,"rule alter_server_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // SQLParser1.g:342:23: ( ALTER alter_server_expression -> ^( TN_ALTER alter_server_expression ) )
            // SQLParser1.g:343:2: ALTER alter_server_expression
            {
            ALTER407=(Token)match(input,ALTER,FOLLOW_ALTER_in_alter_server_statement2135); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ALTER.add(ALTER407);

            pushFollow(FOLLOW_alter_server_expression_in_alter_server_statement2137);
            alter_server_expression408=alter_server_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_alter_server_expression.add(alter_server_expression408.getTree());


            // AST REWRITE
            // elements: alter_server_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 343:32: -> ^( TN_ALTER alter_server_expression )
            {
                // SQLParser1.g:343:35: ^( TN_ALTER alter_server_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_ALTER, "TN_ALTER"), root_1);

                adaptor.addChild(root_1, stream_alter_server_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 61, alter_server_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alter_server_statement"

    public static class alter_server_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alter_server_expression"
    // SQLParser1.g:345:1: alter_server_expression : SERVER_SYM server_name OPTIONS_SYM LPAREN alter_server_option ( COMMA alter_server_option )* RPAREN ;
    public final MySQL_SQLParser1.alter_server_expression_return alter_server_expression() throws RecognitionException {
        MySQL_SQLParser1.alter_server_expression_return retval = new MySQL_SQLParser1.alter_server_expression_return();
        retval.start = input.LT(1);
        int alter_server_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SERVER_SYM409=null;
        Token OPTIONS_SYM411=null;
        Token LPAREN412=null;
        Token COMMA414=null;
        Token RPAREN416=null;
        MySQLParser.server_name_return server_name410 = null;

        MySQL_SQLParser1.alter_server_option_return alter_server_option413 = null;

        MySQL_SQLParser1.alter_server_option_return alter_server_option415 = null;


        CommonTree SERVER_SYM409_tree=null;
        CommonTree OPTIONS_SYM411_tree=null;
        CommonTree LPAREN412_tree=null;
        CommonTree COMMA414_tree=null;
        CommonTree RPAREN416_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // SQLParser1.g:345:24: ( SERVER_SYM server_name OPTIONS_SYM LPAREN alter_server_option ( COMMA alter_server_option )* RPAREN )
            // SQLParser1.g:346:2: SERVER_SYM server_name OPTIONS_SYM LPAREN alter_server_option ( COMMA alter_server_option )* RPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            SERVER_SYM409=(Token)match(input,SERVER_SYM,FOLLOW_SERVER_SYM_in_alter_server_expression2153); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SERVER_SYM409_tree = (CommonTree)adaptor.create(SERVER_SYM409);
            adaptor.addChild(root_0, SERVER_SYM409_tree);
            }
            pushFollow(FOLLOW_server_name_in_alter_server_expression2155);
            server_name410=gMySQL.server_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, server_name410.getTree());
            OPTIONS_SYM411=(Token)match(input,OPTIONS_SYM,FOLLOW_OPTIONS_SYM_in_alter_server_expression2158); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OPTIONS_SYM411_tree = (CommonTree)adaptor.create(OPTIONS_SYM411);
            adaptor.addChild(root_0, OPTIONS_SYM411_tree);
            }
            LPAREN412=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_alter_server_expression2160); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN412_tree = (CommonTree)adaptor.create(LPAREN412);
            adaptor.addChild(root_0, LPAREN412_tree);
            }
            pushFollow(FOLLOW_alter_server_option_in_alter_server_expression2162);
            alter_server_option413=alter_server_option();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, alter_server_option413.getTree());
            // SQLParser1.g:347:41: ( COMMA alter_server_option )*
            loop127:
            do {
                int alt127=2;
                int LA127_0 = input.LA(1);

                if ( (LA127_0==COMMA) ) {
                    alt127=1;
                }


                switch (alt127) {
            	case 1 :
            	    // SQLParser1.g:347:42: COMMA alter_server_option
            	    {
            	    COMMA414=(Token)match(input,COMMA,FOLLOW_COMMA_in_alter_server_expression2165); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA414_tree = (CommonTree)adaptor.create(COMMA414);
            	    adaptor.addChild(root_0, COMMA414_tree);
            	    }
            	    pushFollow(FOLLOW_alter_server_option_in_alter_server_expression2167);
            	    alter_server_option415=alter_server_option();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, alter_server_option415.getTree());

            	    }
            	    break;

            	default :
            	    break loop127;
                }
            } while (true);

            RPAREN416=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_alter_server_expression2171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN416_tree = (CommonTree)adaptor.create(RPAREN416);
            adaptor.addChild(root_0, RPAREN416_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 62, alter_server_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alter_server_expression"

    public static class alter_server_option_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alter_server_option"
    // SQLParser1.g:349:1: alter_server_option : ( USER ) ( ID | TEXT_STRING ) ;
    public final MySQL_SQLParser1.alter_server_option_return alter_server_option() throws RecognitionException {
        MySQL_SQLParser1.alter_server_option_return retval = new MySQL_SQLParser1.alter_server_option_return();
        retval.start = input.LT(1);
        int alter_server_option_StartIndex = input.index();
        CommonTree root_0 = null;

        Token USER417=null;
        Token set418=null;

        CommonTree USER417_tree=null;
        CommonTree set418_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // SQLParser1.g:349:20: ( ( USER ) ( ID | TEXT_STRING ) )
            // SQLParser1.g:350:2: ( USER ) ( ID | TEXT_STRING )
            {
            root_0 = (CommonTree)adaptor.nil();

            // SQLParser1.g:350:2: ( USER )
            // SQLParser1.g:350:3: USER
            {
            USER417=(Token)match(input,USER,FOLLOW_USER_in_alter_server_option2180); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            USER417_tree = (CommonTree)adaptor.create(USER417);
            adaptor.addChild(root_0, USER417_tree);
            }

            }

            set418=(Token)input.LT(1);
            if ( (input.LA(1)>=TEXT_STRING && input.LA(1)<=ID) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set418));
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
            if ( state.backtracking>0 ) { memoize(input, 63, alter_server_option_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alter_server_option"

    public static class drop_server_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_server_statement"
    // SQLParser1.g:355:1: drop_server_statement : DROP drop_server_expression -> ^( TN_DROP drop_server_expression ) ;
    public final MySQL_SQLParser1.drop_server_statement_return drop_server_statement() throws RecognitionException {
        MySQL_SQLParser1.drop_server_statement_return retval = new MySQL_SQLParser1.drop_server_statement_return();
        retval.start = input.LT(1);
        int drop_server_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DROP419=null;
        MySQL_SQLParser1.drop_server_expression_return drop_server_expression420 = null;


        CommonTree DROP419_tree=null;
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleSubtreeStream stream_drop_server_expression=new RewriteRuleSubtreeStream(adaptor,"rule drop_server_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // SQLParser1.g:355:22: ( DROP drop_server_expression -> ^( TN_DROP drop_server_expression ) )
            // SQLParser1.g:356:2: DROP drop_server_expression
            {
            DROP419=(Token)match(input,DROP,FOLLOW_DROP_in_drop_server_statement2198); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP419);

            pushFollow(FOLLOW_drop_server_expression_in_drop_server_statement2200);
            drop_server_expression420=drop_server_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_drop_server_expression.add(drop_server_expression420.getTree());


            // AST REWRITE
            // elements: drop_server_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 356:30: -> ^( TN_DROP drop_server_expression )
            {
                // SQLParser1.g:356:33: ^( TN_DROP drop_server_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TN_DROP, "TN_DROP"), root_1);

                adaptor.addChild(root_1, stream_drop_server_expression.nextTree());

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
            if ( state.backtracking>0 ) { memoize(input, 64, drop_server_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "drop_server_statement"

    public static class drop_server_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_server_expression"
    // SQLParser1.g:358:1: drop_server_expression : SERVER_SYM ( IF EXISTS )? server_name ;
    public final MySQL_SQLParser1.drop_server_expression_return drop_server_expression() throws RecognitionException {
        MySQL_SQLParser1.drop_server_expression_return retval = new MySQL_SQLParser1.drop_server_expression_return();
        retval.start = input.LT(1);
        int drop_server_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SERVER_SYM421=null;
        Token IF422=null;
        Token EXISTS423=null;
        MySQLParser.server_name_return server_name424 = null;


        CommonTree SERVER_SYM421_tree=null;
        CommonTree IF422_tree=null;
        CommonTree EXISTS423_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // SQLParser1.g:358:23: ( SERVER_SYM ( IF EXISTS )? server_name )
            // SQLParser1.g:359:2: SERVER_SYM ( IF EXISTS )? server_name
            {
            root_0 = (CommonTree)adaptor.nil();

            SERVER_SYM421=(Token)match(input,SERVER_SYM,FOLLOW_SERVER_SYM_in_drop_server_expression2216); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SERVER_SYM421_tree = (CommonTree)adaptor.create(SERVER_SYM421);
            adaptor.addChild(root_0, SERVER_SYM421_tree);
            }
            // SQLParser1.g:359:13: ( IF EXISTS )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==IF) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // SQLParser1.g:359:14: IF EXISTS
                    {
                    IF422=(Token)match(input,IF,FOLLOW_IF_in_drop_server_expression2219); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF422_tree = (CommonTree)adaptor.create(IF422);
                    adaptor.addChild(root_0, IF422_tree);
                    }
                    EXISTS423=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_drop_server_expression2221); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXISTS423_tree = (CommonTree)adaptor.create(EXISTS423);
                    adaptor.addChild(root_0, EXISTS423_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_server_name_in_drop_server_expression2225);
            server_name424=gMySQL.server_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, server_name424.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 65, drop_server_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "drop_server_expression"

    // $ANTLR start synpred13_SQLParser1
    public final void synpred13_SQLParser1_fragment() throws RecognitionException {   
        // SQLParser1.g:36:28: ( bit_expr )
        // SQLParser1.g:36:28: bit_expr
        {
        pushFollow(FOLLOW_bit_expr_in_synpred13_SQLParser1180);
        gMySQL.bit_expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_SQLParser1

    // $ANTLR start synpred14_SQLParser1
    public final void synpred14_SQLParser1_fragment() throws RecognitionException {   
        // SQLParser1.g:36:54: ( bit_expr )
        // SQLParser1.g:36:54: bit_expr
        {
        pushFollow(FOLLOW_bit_expr_in_synpred14_SQLParser1189);
        gMySQL.bit_expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_SQLParser1

    // $ANTLR start synpred18_SQLParser1
    public final void synpred18_SQLParser1_fragment() throws RecognitionException {   
        // SQLParser1.g:45:40: ( expression )
        // SQLParser1.g:45:40: expression
        {
        pushFollow(FOLLOW_expression_in_synpred18_SQLParser1253);
        gMySQL.expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_SQLParser1

    // $ANTLR start synpred21_SQLParser1
    public final void synpred21_SQLParser1_fragment() throws RecognitionException {   
        // SQLParser1.g:57:2: ( single_table_update_statement )
        // SQLParser1.g:57:2: single_table_update_statement
        {
        pushFollow(FOLLOW_single_table_update_statement_in_synpred21_SQLParser1303);
        single_table_update_statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_SQLParser1

    // Delegated rules

    public final boolean synpred13_SQLParser1() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_SQLParser1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_SQLParser1() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_SQLParser1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_SQLParser1() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_SQLParser1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_SQLParser1() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_SQLParser1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA73 dfa73 = new DFA73(this);
    static final String DFA1_eotS =
        "\32\uffff";
    static final String DFA1_eofS =
        "\32\uffff";
    static final String DFA1_minS =
        "\1\u00f5\1\u00e2\1\u00ec\1\u00fb\1\u022c\1\u015d\1\u022c\1\u0204"+
        "\1\u022c\3\uffff\1\u015d\1\u022c\1\u0218\1\u0219\2\u022c\1\u018f"+
        "\1\u022c\1\u018f\1\u0219\1\u0218\1\u0219\1\u022c\1\u0219";
    static final String DFA1_maxS =
        "\1\u00f5\4\u022c\1\u0218\1\u022c\1\u0204\1\u022c\3\uffff\1\u0204"+
        "\1\u022c\2\u021b\2\u022c\1\u01ee\1\u022c\1\u0204\3\u021b\1\u022c"+
        "\1\u021b";
    static final String DFA1_acceptS =
        "\11\uffff\1\3\1\2\1\1\16\uffff";
    static final String DFA1_specialS =
        "\32\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1",
            "\1\2\11\uffff\1\3\16\uffff\1\4\50\uffff\1\2\u0107\uffff\1"+
            "\5",
            "\1\3\16\uffff\1\4\u0130\uffff\1\5",
            "\1\4\u0130\uffff\1\5",
            "\1\5",
            "\1\7\61\uffff\1\11\2\uffff\1\12\132\uffff\2\13\25\uffff\1"+
            "\10\23\uffff\1\6",
            "\1\14",
            "\1\15",
            "\1\16",
            "",
            "",
            "",
            "\1\7\61\uffff\1\11\2\uffff\1\12\132\uffff\2\13\25\uffff\1"+
            "\10",
            "\1\17",
            "\1\20\1\21\1\uffff\1\22",
            "\1\23\1\uffff\1\24",
            "\1\25",
            "\1\26",
            "\1\11\135\uffff\2\13",
            "\1\27",
            "\1\11\2\uffff\1\12\132\uffff\2\13\25\uffff\1\10",
            "\1\21\1\uffff\1\22",
            "\1\30\1\21\1\uffff\1\22",
            "\1\23\1\uffff\1\24",
            "\1\31",
            "\1\21\1\uffff\1\22"
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "10:1: insert_statements : ( insert_statement1 | insert_statement2 | insert_statement3 );";
        }
    }
    static final String DFA73_eotS =
        "\15\uffff";
    static final String DFA73_eofS =
        "\15\uffff";
    static final String DFA73_minS =
        "\1\u018f\1\u022c\3\uffff\1\u0218\1\u022c\1\u018f\1\u022c\1\u0218"+
        "\1\u0219\1\u022c\1\u0219";
    static final String DFA73_maxS =
        "\1\u0204\1\u022c\3\uffff\1\u021b\1\u022c\1\u01ee\1\u022c\2\u021b"+
        "\1\u022c\1\u021b";
    static final String DFA73_acceptS =
        "\2\uffff\1\1\1\2\1\3\10\uffff";
    static final String DFA73_specialS =
        "\15\uffff}>";
    static final String[] DFA73_transitionS = {
            "\1\4\2\uffff\1\3\132\uffff\2\2\25\uffff\1\1",
            "\1\5",
            "",
            "",
            "",
            "\1\10\1\6\1\uffff\1\7",
            "\1\11",
            "\1\4\135\uffff\2\2",
            "\1\12",
            "\1\13\1\6\1\uffff\1\7",
            "\1\6\1\uffff\1\7",
            "\1\14",
            "\1\6\1\uffff\1\7"
    };

    static final short[] DFA73_eot = DFA.unpackEncodedString(DFA73_eotS);
    static final short[] DFA73_eof = DFA.unpackEncodedString(DFA73_eofS);
    static final char[] DFA73_min = DFA.unpackEncodedStringToUnsignedChars(DFA73_minS);
    static final char[] DFA73_max = DFA.unpackEncodedStringToUnsignedChars(DFA73_maxS);
    static final short[] DFA73_accept = DFA.unpackEncodedString(DFA73_acceptS);
    static final short[] DFA73_special = DFA.unpackEncodedString(DFA73_specialS);
    static final short[][] DFA73_transition;

    static {
        int numStates = DFA73_transitionS.length;
        DFA73_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA73_transition[i] = DFA.unpackEncodedString(DFA73_transitionS[i]);
        }
    }

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = DFA73_eot;
            this.eof = DFA73_eof;
            this.min = DFA73_min;
            this.max = DFA73_max;
            this.accept = DFA73_accept;
            this.special = DFA73_special;
            this.transition = DFA73_transition;
        }
        public String getDescription() {
            return "163:2: ( replace_statement1 | replace_statement2 | replace_statement3 )";
        }
    }
 

    public static final BitSet FOLLOW_insert_statement1_in_insert_statements20 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insert_statement2_in_insert_statements24 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insert_statement3_in_insert_statements28 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSERT_in_insert_header37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_insert_expression_in_insert_header39 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_insert_expression55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_IGNORE_SYM_in_insert_expression65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_INTO_in_insert_expression71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_spec_in_insert_expression75 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_partition_clause_in_insert_expression80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ON_in_insert_subfix92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_DUPLICATE_SYM_in_insert_subfix94 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEY_SYM_in_insert_subfix96 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_UPDATE_in_insert_subfix98 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_column_spec_in_insert_subfix100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_insert_subfix102 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xACA31C160B07622BL,0x4B84FCF3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_insert_subfix104 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_insert_subfix107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_column_spec_in_insert_subfix109 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_insert_subfix111 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xACA31C160B07622BL,0x4B84FCF3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_insert_subfix113 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_insert_header_in_insert_statement1124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000600000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_column_list_in_insert_statement1128 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000600000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_value_list_clause_in_insert_statement1134 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_insert_subfix_in_insert_statement1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_value_list_clause156 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_column_value_list_in_value_list_clause164 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_value_list_clause167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_column_value_list_in_value_list_clause169 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_column_value_list177 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xACA31C160B07622BL,0x4B84FCF3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_column_value_list180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_DEFAULT_in_column_value_list182 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_column_value_list186 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xACA31C160B07622BL,0x4B84FCF3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_column_value_list189 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_DEFAULT_in_column_value_list191 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_column_value_list197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insert_header_in_insert_statement2206 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_set_columns_cluase_in_insert_statement2209 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_insert_subfix_in_insert_statement2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_SYM_in_set_columns_cluase231 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_set_column_cluase_in_set_columns_cluase233 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_set_columns_cluase237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_set_column_cluase_in_set_columns_cluase239 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_column_spec_in_set_column_cluase248 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_set_column_cluase250 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xACA31C160B07622BL,0x4B84FCF3AA060300L,0x3080E46F0040570EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_expression_in_set_column_cluase253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFAULT_in_set_column_cluase255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insert_header_in_insert_statement3265 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_column_list_in_insert_statement3269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_select_expression_in_insert_statement3275 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_insert_subfix_in_insert_statement3280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_single_table_update_statement_in_update_statements303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiple_table_update_statement_in_update_statements307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_single_table_update_statement317 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_single_update_expression_in_single_table_update_statement319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOW_PRIORITY_in_single_update_expression338 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_IGNORE_SYM_in_single_update_expression343 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_reference_in_single_update_expression347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_set_columns_cluase_in_single_update_expression350 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000800000L,0x0000000000000000L,0x2000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_where_clause_in_single_update_expression354 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_orderby_clause_in_single_update_expression360 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_limit_clause_in_single_update_expression366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_multiple_table_update_statement379 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_multiple_update_expression_in_multiple_table_update_statement381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOW_PRIORITY_in_multiple_update_expression400 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_IGNORE_SYM_in_multiple_update_expression405 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_table_references_in_multiple_update_expression409 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_set_columns_cluase_in_multiple_update_expression412 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_where_clause_in_multiple_update_expression416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CALL_SYM_in_call_statement429 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_procedure_name_in_call_statement431 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_call_statement434 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xACA31C160B07622BL,0x4B84FCF3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C80000B0L});
    public static final BitSet FOLLOW_bit_expr_in_call_statement438 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_call_statement441 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xACA31C160B07622BL,0x4B84FCF3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_call_statement443 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_call_statement450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_SYM_in_do_statement462 = new BitSet(new long[]{0x0000040000000000L,0x1000000000000100L,0x000000A010000000L,0x0020000020000000L,0x0000000004000000L,0x2200000000000000L,0x0000000000008000L,0x0000002402000000L,0x0000000000080010L});
    public static final BitSet FOLLOW_root_statement_in_do_statement464 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_do_statement467 = new BitSet(new long[]{0x0000040000000000L,0x1000000000000100L,0x000000A010000000L,0x0020000020000000L,0x0000000004000000L,0x2200000000000000L,0x0000000000008000L,0x0000002402000000L,0x0000000000080010L});
    public static final BitSet FOLLOW_root_statement_in_do_statement469 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_HANDLER_SYM_in_handler_statements481 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_name_in_handler_statements483 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0002000000020000L});
    public static final BitSet FOLLOW_open_handler_statement_in_handler_statements487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_handler_statement1_in_handler_statements491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_handler_statement2_in_handler_statements495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_handler_statement3_in_handler_statements499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_close_handler_statement_in_handler_statements503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_SYM_in_open_handler_statement513 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_open_handler_statement516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_SYM_in_handler_statement1527 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_index_name_in_handler_statement1529 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000300003C000L});
    public static final BitSet FOLLOW_relational_op_in_handler_statement1531 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_handler_statement1533 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xACA31C160B07622BL,0x4B84FCF3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_handler_statement1535 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_handler_statement1538 = new BitSet(new long[]{0xF15B003CC0000000L,0x880772C0140B7805L,0xB000C80062CF0BEEL,0xACA31C160B07622BL,0x4B84FCF3AA060300L,0x3080E46F0040560EL,0x3795E20149221DABL,0x0F31D751239C3F81L,0x00021F41C00000B0L});
    public static final BitSet FOLLOW_bit_expr_in_handler_statement1540 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_handler_statement1544 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_where_clause_in_handler_statement1548 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_limit_clause_in_handler_statement1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_SYM_in_handler_statement2564 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_index_name_in_handler_statement2566 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L,0x0000000000000400L,0x0000010000000020L});
    public static final BitSet FOLLOW_set_in_handler_statement2568 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_where_clause_in_handler_statement2586 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_limit_clause_in_handler_statement2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_SYM_in_handler_statement3602 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_set_in_handler_statement3604 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_where_clause_in_handler_statement3614 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_limit_clause_in_handler_statement3619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLOSE_SYM_in_close_handler_statement630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_load_data_statement640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_DATA_SYM_in_load_data_statement642 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L,0x0000000000000000L,0x0004000000000000L,0x0000001010000000L});
    public static final BitSet FOLLOW_LOW_PRIORITY_in_load_data_statement645 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0004000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_CONCURRENT_in_load_data_statement649 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0004000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_LOCAL_SYM_in_load_data_statement654 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_INFILE_in_load_data_statement658 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_TEXT_STRING_in_load_data_statement660 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_REPLACE_in_load_data_statement664 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_IGNORE_SYM_in_load_data_statement668 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_INTO_in_load_data_statement673 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_TABLE_in_load_data_statement675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_spec_in_load_data_statement677 = new BitSet(new long[]{0x0000000000000002L,0x0000000080040000L,0x0000000000000000L,0x0000100000000004L,0x0000000000800000L,0x0000000020000000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_partition_clause_in_load_data_statement681 = new BitSet(new long[]{0x0000000000000002L,0x0000000080040000L,0x0000000000000000L,0x0000100000000004L,0x0000000000800000L,0x0000000000000000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_CHARACTER_SYM_in_load_data_statement687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_SET_SYM_in_load_data_statement689 = new BitSet(new long[]{0x2401200000000000L,0x07F8000000000000L,0x00C0000000100000L,0x0000010104E00000L,0x000003000001E068L,0x0000000000000000L,0x0800000002000000L,0x000008000C020000L});
    public static final BitSet FOLLOW_charset_name_in_load_data_statement691 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L,0x0000000000000000L,0x0000100000000004L,0x0000000000800000L,0x0000000000000000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_FIELDS_SYM_in_load_data_statement701 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0020200000000000L,0x0000100000000000L,0x0000000000800000L,0x0000000000100000L,0x0000000000040000L,0x0000000000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_COLUMNS_SYM_in_load_data_statement705 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0020200000000000L,0x0000100000000000L,0x0000000000800000L,0x0000000000100000L,0x0000000000040000L,0x0000000000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_TERMINATED_in_load_data_statement711 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_BY_SYM_in_load_data_statement713 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_TEXT_STRING_in_load_data_statement715 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0020200000000000L,0x0000100000000000L,0x0000000000800000L,0x0000000000100000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_OPTIONALLY_in_load_data_statement723 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_ENCLOSED_in_load_data_statement727 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_BY_SYM_in_load_data_statement729 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_TEXT_STRING_in_load_data_statement731 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0020000000000000L,0x0000100000000000L,0x0000000000800000L,0x0000000000000000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ESCAPED_in_load_data_statement738 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_BY_SYM_in_load_data_statement740 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_TEXT_STRING_in_load_data_statement742 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L,0x0000000000800000L,0x0000000000000000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LINES_in_load_data_statement755 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000040000040000L,0x0000000000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_STARTING_in_load_data_statement760 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_BY_SYM_in_load_data_statement762 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_TEXT_STRING_in_load_data_statement764 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L,0x0000000000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_TERMINATED_in_load_data_statement771 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_BY_SYM_in_load_data_statement773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_TEXT_STRING_in_load_data_statement775 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IGNORE_SYM_in_load_data_statement785 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_load_data_statement787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LINES_in_load_data_statement790 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ROWS_SYM_in_load_data_statement794 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_load_data_statement801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0002100000000000L});
    public static final BitSet FOLLOW_column_spec_in_load_data_statement804 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_USER_VAR_in_load_data_statement806 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_load_data_statement810 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0002100000000000L});
    public static final BitSet FOLLOW_column_spec_in_load_data_statement813 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_USER_VAR_in_load_data_statement815 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_load_data_statement820 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_set_columns_cluase_in_load_data_statement826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_load_xml_statement847 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_XML_SYM_in_load_xml_statement849 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L,0x0000000000000000L,0x0004000000000000L,0x0000001010000000L});
    public static final BitSet FOLLOW_set_in_load_xml_statement851 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0004000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_LOCAL_SYM_in_load_xml_statement861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_INFILE_in_load_xml_statement865 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_TEXT_STRING_in_load_xml_statement867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_set_in_load_xml_statement870 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_INTO_in_load_xml_statement880 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_TABLE_in_load_xml_statement882 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_spec_in_load_xml_statement884 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L,0x0000000000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000020000000L,0x0000000000040040L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_partition_clause_in_load_xml_statement888 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L,0x0000000000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040040L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_CHARACTER_SYM_in_load_xml_statement894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_SET_SYM_in_load_xml_statement896 = new BitSet(new long[]{0x2401200000000000L,0x07F8000000000000L,0x00C0000000100000L,0x0000010104E00000L,0x000003000001E068L,0x0000000000000000L,0x0800000002000000L,0x000008000C020000L});
    public static final BitSet FOLLOW_charset_name_in_load_xml_statement898 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040040L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ROWS_SYM_in_load_xml_statement904 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_IDENTIFIED_SYM_in_load_xml_statement906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_BY_SYM_in_load_xml_statement908 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_TEXT_STRING_in_load_xml_statement910 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IGNORE_SYM_in_load_xml_statement916 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_load_xml_statement918 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_set_in_load_xml_statement920 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_load_xml_statement932 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0002100000000000L});
    public static final BitSet FOLLOW_column_spec_in_load_xml_statement935 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_USER_VAR_in_load_xml_statement937 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_load_xml_statement941 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0002100000000000L});
    public static final BitSet FOLLOW_column_spec_in_load_xml_statement944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_USER_VAR_in_load_xml_statement946 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_load_xml_statement951 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_set_columns_cluase_in_load_xml_statement957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_replace_statement_header_in_replace_statement969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000048000L,0x0000600000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_replace_statement1_in_replace_statement974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_replace_statement2_in_replace_statement978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_replace_statement3_in_replace_statement982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPLACE_in_replace_statement_header993 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_replace_statement_expression_in_replace_statement_header995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_replace_statement_expression1012 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_INTO_in_replace_statement_expression1023 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_name_in_replace_statement_expression1027 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_partition_clause_in_replace_statement_expression1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_list_in_replace_statement11044 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000600000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_value_list_clause_in_replace_statement11049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_columns_cluase_in_replace_statement21058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_list_in_replace_statement31068 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_select_statement_in_replace_statement31073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_database_statement1083 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_create_database_expression_in_create_database_statement1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_create_database_expression1101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_IF_in_create_database_expression1110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_create_database_expression1112 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_EXISTS_in_create_database_expression1114 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_schema_name_in_create_database_expression1118 = new BitSet(new long[]{0x0000000000000002L,0x0000000008040000L,0x0000000000800000L});
    public static final BitSet FOLLOW_create_specification_in_create_database_expression1123 = new BitSet(new long[]{0x0000000000000002L,0x0000000008040000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_create_database_expression1126 = new BitSet(new long[]{0x0000000000000000L,0x0000000008040000L,0x0000000000800000L});
    public static final BitSet FOLLOW_create_specification_in_create_database_expression1128 = new BitSet(new long[]{0x0000000000000002L,0x0000000008040000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_DEFAULT_in_create_specification1142 = new BitSet(new long[]{0x0000000000000000L,0x0000000008040000L});
    public static final BitSet FOLLOW_CHARACTER_SYM_in_create_specification1155 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_SET_SYM_in_create_specification1157 = new BitSet(new long[]{0x2401200000000000L,0x07F8000000000000L,0x00C0000000100000L,0x0000010104E00000L,0x000003000001E068L,0x0000000000000000L,0x0800000002000000L,0x000008000C020000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_create_specification1160 = new BitSet(new long[]{0x2401200000000000L,0x07F8000000000000L,0x00C0000000100000L,0x0000010104E00000L,0x000003000001E068L,0x0000000000000000L,0x0800000002000000L,0x000008000C020000L});
    public static final BitSet FOLLOW_charset_name_in_create_specification1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLLATE_SYM_in_create_specification1178 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_create_specification1181 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000004000L});
    public static final BitSet FOLLOW_collation_name_in_create_specification1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALTER_in_alter_database_statements1201 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_alter_database_expression_in_alter_database_statements1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alter_database_statement1_in_alter_database_expression1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alter_database_statement2_in_alter_database_expression1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_alter_database_statement11231 = new BitSet(new long[]{0x0000000000000000L,0x0000000008040000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_schema_name_in_alter_database_statement11240 = new BitSet(new long[]{0x0000000000000000L,0x0000000008040000L,0x0000000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_alter_database_specification_in_alter_database_statement11245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_alter_database_statement21253 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_schema_name_in_alter_database_statement21261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_UPGRADE_SYM_in_alter_database_statement21264 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_DATA_SYM_in_alter_database_statement21266 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_DIRECTORY_SYM_in_alter_database_statement21268 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_N__in_alter_database_statement21270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_A__in_alter_database_statement21272 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_M__in_alter_database_statement21274 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_E__in_alter_database_statement21276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFAULT_in_alter_database_specification1285 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_CHARACTER_SYM_in_alter_database_specification1289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_SET_SYM_in_alter_database_specification1291 = new BitSet(new long[]{0x2401200000000000L,0x07F8000000000000L,0x00C0000000100000L,0x0000010104E00000L,0x000003000001E068L,0x0000000000000000L,0x0800000002000000L,0x000008000C020000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_alter_database_specification1294 = new BitSet(new long[]{0x2401200000000000L,0x07F8000000000000L,0x00C0000000100000L,0x0000010104E00000L,0x000003000001E068L,0x0000000000000000L,0x0800000002000000L,0x000008000C020000L});
    public static final BitSet FOLLOW_charset_name_in_alter_database_specification1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFAULT_in_alter_database_specification1306 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_COLLATE_SYM_in_alter_database_specification1310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000001800L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_alter_database_specification1313 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000001800L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_collation_names_in_alter_database_specification1317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_database_statement1328 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_drop_database_expression_in_drop_database_statement1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_drop_database_expression1346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_IF_in_drop_database_expression1355 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_EXISTS_in_drop_database_expression1357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_schema_name_in_drop_database_expression1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_event_statement1371 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000001000000L});
    public static final BitSet FOLLOW_create_event_expression_in_create_event_statement1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINER_in_create_event_expression1392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_create_event_expression1394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_user_name_in_create_event_expression1398 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_CURRENT_USER_in_create_event_expression1402 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_EVENT_SYM_in_create_event_expression1409 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_IF_in_create_event_expression1413 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_create_event_expression1415 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_EXISTS_in_create_event_expression1417 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_event_name_in_create_event_expression1422 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_ON_in_create_event_expression1425 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_SCHEDULE_SYM_in_create_event_expression1427 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_schedule_definition_in_create_event_expression1429 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000102200000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_ON_in_create_event_expression1433 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_COMPLETION_SYM_in_create_event_expression1435 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_create_event_expression1438 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_PRESERVE_SYM_in_create_event_expression1442 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000102200000000L});
    public static final BitSet FOLLOW_ENABLE_SYM_in_create_event_expression1449 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_DISABLE_SYM_in_create_event_expression1453 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_DISABLE_SYM_in_create_event_expression1458 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_ON_in_create_event_expression1460 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_SLAVE_in_create_event_expression1462 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_COMMENT_SYM_in_create_event_expression1470 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_TEXT_STRING_in_create_event_expression1472 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_do_statement_in_create_event_expression1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_SYM_in_schedule_definition1487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_timestamp_in_schedule_definition1489 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_PLUS_in_schedule_definition1492 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_INTERVAL_SYM_in_schedule_definition1494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_interval_in_schedule_definition1496 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_EVERY_SYM_in_schedule_definition1509 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_interval_in_schedule_definition1511 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_S__in_schedule_definition1518 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_T__in_schedule_definition1520 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_A__in_schedule_definition1522 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_R__in_schedule_definition1524 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_T__in_schedule_definition1526 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_S__in_schedule_definition1528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_timestamp_in_schedule_definition1530 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0002000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_PLUS_in_schedule_definition1533 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_INTERVAL_SYM_in_schedule_definition1535 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_interval_in_schedule_definition1537 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0002000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ENDS_SYM_in_schedule_definition1547 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_timestamp_in_schedule_definition1549 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_PLUS_in_schedule_definition1552 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_INTERVAL_SYM_in_schedule_definition1554 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_interval_in_schedule_definition1556 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_INTEGER_NUM_in_interval1569 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000000L,0x000000000000D800L,0x000000D000000000L,0x2800000000000000L,0x0000040000000002L,0x0000000000001000L,0x0100000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_Y__in_interval1572 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_E__in_interval1574 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_A__in_interval1576 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_R__in_interval1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUARTER_in_interval1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MONTH_in_interval1586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAY_SYM_in_interval1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOUR_in_interval1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUTE_in_interval1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WEEK_in_interval1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SECOND_in_interval1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YEAR_MONTH_in_interval1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAY_HOUR_in_interval1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAY_MINUTE_in_interval1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAY_SECOND_in_interval1644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOUR_MINUTE_in_interval1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOUR_SECOND_in_interval1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUTE_SECOND_in_interval1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_TIMESTAMP_in_timestamp1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALTER_in_alter_event_statement1677 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000001000000L});
    public static final BitSet FOLLOW_alter_event_expression_in_alter_event_statement1679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINER_in_alter_event_expression1698 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_alter_event_expression1700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_user_name_in_alter_event_expression1704 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_CURRENT_USER_in_alter_event_expression1708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_EVENT_SYM_in_alter_event_expression1715 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_event_name_in_alter_event_expression1717 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L,0x0000102200000000L,0x0000000000000000L,0x0000000000000000L,0x0200000000008000L});
    public static final BitSet FOLLOW_ON_in_alter_event_expression1721 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_SCHEDULE_SYM_in_alter_event_expression1723 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_schedule_definition_in_alter_event_expression1725 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L,0x0000102200000000L,0x0000000000000000L,0x0000000000000000L,0x0200000000008000L});
    public static final BitSet FOLLOW_ON_in_alter_event_expression1731 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_COMPLETION_SYM_in_alter_event_expression1733 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000100L});
    public static final BitSet FOLLOW_NOT_SYM_in_alter_event_expression1736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_PRESERVE_SYM_in_alter_event_expression1740 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L,0x0000102200000000L,0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_RENAME_in_alter_event_expression1746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_TO_SYM_in_alter_event_expression1748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_event_name_in_alter_event_expression1750 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L,0x0000102200000000L});
    public static final BitSet FOLLOW_ENABLE_SYM_in_alter_event_expression1757 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_DISABLE_SYM_in_alter_event_expression1761 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_DISABLE_SYM_in_alter_event_expression1766 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_ON_in_alter_event_expression1768 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_SLAVE_in_alter_event_expression1770 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_COMMENT_SYM_in_alter_event_expression1778 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_TEXT_STRING_in_alter_event_expression1780 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_do_statement_in_alter_event_expression1786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_event_statement1798 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_drop_event_expression_in_drop_event_statement1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVENT_SYM_in_drop_event_expression1816 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_IF_in_drop_event_expression1819 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_EXISTS_in_drop_event_expression1821 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_event_name_in_drop_event_expression1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_index_statement1835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000100000L,0x0000000000000000L,0x0000000000000000L,0x0000000200000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_create_index_expression_in_create_index_statement1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_create_index_expression1853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_INDEX_SYM_in_create_index_expression1862 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_index_name_in_create_index_expression1864 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_index_type_in_create_index_expression1868 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_ON_in_create_index_expression1873 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_name_in_create_index_expression1875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_create_index_expression1877 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_index_column_name_in_create_index_expression1879 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_create_index_expression1882 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_index_column_name_in_create_index_expression1884 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_create_index_expression1888 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_algorithm_option_in_create_index_expression1892 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_lock_option_in_create_index_expression1896 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ALGORITHM_SYM_in_algorithm_option1906 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L,0x0000000000800000L,0x0010000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_algorithm_option1909 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L,0x0000000000800000L,0x0010000000000000L});
    public static final BitSet FOLLOW_set_in_algorithm_option1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_lock_option1927 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000080L,0x0000000000080000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQ_SYM_in_lock_option1930 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000800000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000080L,0x0000000000080000L});
    public static final BitSet FOLLOW_set_in_lock_option1934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_index_statement1953 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_drop_index_expression_in_drop_index_statement1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDEX_SYM_in_drop_index_expression1971 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_index_name_in_drop_index_expression1973 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_ON_in_drop_index_expression1975 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800100400000000L,0x0000001000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_table_name_in_drop_index_expression1977 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_algorithm_option_in_drop_index_expression1981 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_lock_option_in_drop_index_expression1985 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_CREATE_in_create_server_statement1997 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_create_server_expression_in_create_server_statement1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERVER_SYM_in_create_server_expression2015 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_server_name_in_create_server_expression2017 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_FOREIGN_in_create_server_expression2020 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_DATA_SYM_in_create_server_expression2022 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_WRAPPER_SYM_in_create_server_expression2024 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_wrapper_name_in_create_server_expression2026 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_OPTIONS_SYM_in_create_server_expression2029 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_create_server_expression2031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L,0x0000000800000000L,0x0000000000000000L,0x0000001102000000L,0x0000000020000000L,0x0000004000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_create_server_option_in_create_server_expression2033 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_create_server_expression2036 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L,0x0000000800000000L,0x0000000000000000L,0x0000001102000000L,0x0000000020000000L,0x0000004000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_create_server_option_in_create_server_expression2038 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_create_server_expression2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOST_SYM_in_create_server_option2054 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_string_literal_in_create_server_option2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATABASE_in_create_server_option2065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_string_literal_in_create_server_option2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USER_in_create_server_option2076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_string_literal_in_create_server_option2078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PASSWORD_in_create_server_option2087 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_string_literal_in_create_server_option2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SOCKET_SYM_in_create_server_option2098 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_string_literal_in_create_server_option2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OWNER_SYM_in_create_server_option2109 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_string_literal_in_create_server_option2111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PORT_SYM_in_create_server_option2120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000000000000000L,0x00000440C0000000L});
    public static final BitSet FOLLOW_number_literal_in_create_server_option2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALTER_in_alter_server_statement2135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_alter_server_expression_in_alter_server_statement2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERVER_SYM_in_alter_server_expression2153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_server_name_in_alter_server_expression2155 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_OPTIONS_SYM_in_alter_server_expression2158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_alter_server_expression2160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_alter_server_option_in_alter_server_expression2162 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_COMMA_in_alter_server_expression2165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_alter_server_option_in_alter_server_expression2167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_RPAREN_in_alter_server_expression2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USER_in_alter_server_option2180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000180000000000L});
    public static final BitSet FOLLOW_set_in_alter_server_option2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_server_statement2198 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_drop_server_expression_in_drop_server_statement2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERVER_SYM_in_drop_server_expression2216 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000040000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_IF_in_drop_server_expression2219 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_EXISTS_in_drop_server_expression2221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_server_name_in_drop_server_expression2225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_synpred13_SQLParser1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bit_expr_in_synpred14_SQLParser1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred18_SQLParser1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_single_table_update_statement_in_synpred21_SQLParser1303 = new BitSet(new long[]{0x0000000000000002L});

}