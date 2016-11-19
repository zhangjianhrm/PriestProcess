// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 Commons.g 2013-11-19 14:17:31
package com.lenovo.lps.farseer.priest2.platform.util.antlr;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEarlyExitException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

@SuppressWarnings("unused")
public class OracleParser_Commons extends Parser {
    public static final int SQL92_RESERVED_DECLARE=107;
    public static final int D_=12;
    public static final int BIT_VK=357;
    public static final int PARAMETERS_VK=261;
    public static final int SIGNTYPE_VK=337;
    public static final int DOUBLE_ASTERISK=57;
    public static final int DEBUG_VK=188;
    public static final int COMMENT_VK=238;
    public static final int NESTED_VK=229;
    public static final int PRECISION=626;
    public static final int JAVA_VK=254;
    public static final int CURRENT_USER_VK=198;
    public static final int SEARCH_VK=503;
    public static final int COMPATIBILITY_VK=445;
    public static final int SERVERERROR_VK=226;
    public static final int XMLQUERY_VK=477;
    public static final int SELECT_STATEMENT=663;
    public static final int E_=13;
    public static final int TABLE_EXPRESSION=683;
    public static final int PERCENT_ROWCOUNT_VK=280;
    public static final int PARALLEL_ENABLE_VK=202;
    public static final int VERTICAL_BAR=78;
    public static final int DIMENSION_VK=400;
    public static final int EXECUTE_VK=295;
    public static final int QUESTION_MARK=66;
    public static final int ELEMENT=745;
    public static final int SAVEPOINT_NAME=594;
    public static final int BLOB_VK=338;
    public static final int LINK_NAME=616;
    public static final int SQL92_RESERVED_EXISTS=117;
    public static final int IS_NOT_A_SET=724;
    public static final int CHAR_CS_VK=451;
    public static final int AT_VK=433;
    public static final int PLSQL_RESERVED_VIEWS=169;
    public static final int F_=14;
    public static final int POSITIVEN_VK=321;
    public static final int EXIT_VK=287;
    public static final int PARAMETER_NAME=592;
    public static final int CARRET_OPERATOR_PART=73;
    public static final int LOGIC_EXPR=681;
    public static final int SQL92_RESERVED_HAVING=125;
    public static final int UNDERSCORE=8;
    public static final int SUBMULTISET_VK=418;
    public static final int PLSQL_NON_RESERVED_MODEL=174;
    public static final int IS_OF_TYPE=729;
    public static final int SEED_VK=396;
    public static final int CALL_VK=207;
    public static final int VALIDATE_VK=240;
    public static final int C_VK=256;
    public static final int NUMERIC_VK=364;
    public static final int REJECT_VK=381;
    public static final int ATTRIBUTE_NAME=593;
    public static final int BOOLEAN_VK=348;
    public static final int RULES_VK=408;
    public static final int HOSTED_VARIABLE=629;
    public static final int HASH_VK=205;
    public static final int ROUTINE_CALL=630;
    public static final int SQL92_RESERVED_DELETE=109;
    public static final int QS_ANGLE=44;
    public static final int G_=15;
    public static final int XMLFOREST_VK=469;
    public static final int SUBPARTITION_VK=317;
    public static final int SQL92_RESERVED_UNIQUE=165;
    public static final int SIMPLE_INTEGER_VK=328;
    public static final int LIKE2_VK=420;
    public static final int SELECT_LIST=672;
    public static final int DETERMINISTIC_VK=191;
    public static final int UPDATE_STATEMENT=664;
    public static final int ALIAS=588;
    public static final int SEQUENCE_NAME=607;
    public static final int EVALNAME_VK=465;
    public static final int SQL92_RESERVED_ORDER=147;
    public static final int NATURALN_VK=327;
    public static final int MONTH_VK=376;
    public static final int FUNC_NAME=506;
    public static final int ORDINALITY_VK=485;
    public static final int SQL92_RESERVED_THEN=161;
    public static final int SELECT_OPTIONS=671;
    public static final int SUSPEND_VK=221;
    public static final int ORADATA_VK=266;
    public static final int XML_VK=387;
    public static final int COMMIT_VK=297;
    public static final int TIMESTAMP_TZ_UNCONSTRAINED_VK=319;
    public static final int MEASURES_VK=404;
    public static final int REAL_VK=359;
    public static final int SQLDATA_VK=268;
    public static final int LEFT_BRACKET=80;
    public static final int NOSCHEMACHECK_VK=475;
    public static final int ROW_VK=422;
    public static final int WORK_VK=298;
    public static final int TREAT_VK=453;
    public static final int PREDICTION_FUNCTION=744;
    public static final int LAST_VK=413;
    public static final int EXCLUDE_VK=393;
    public static final int AUTHID_VK=196;
    public static final int SUBQUERY=670;
    public static final int WHERE_CLAUSE=634;
    public static final int RIGHT_PAREN=56;
    public static final int SESSIONTIMEZONE_VK=344;
    public static final int HAVING_CLAUSE=695;
    public static final int COMPILE_VK=242;
    public static final int SPECIFICATION_VK=203;
    public static final int LEFT=179;
    public static final int DOT_ASTERISK=675;
    public static final int A_=9;
    public static final int ARGUMENT=591;
    public static final int SQL92_RESERVED_WITH=172;
    public static final int SQL92_RESERVED_DESC=110;
    public static final int BEFORE_VK=212;
    public static final int OPEN_VK=310;
    public static final int PLSQL_RESERVED_IF=127;
    public static final int CASCATED_ELEMENT=627;
    public static final int FIRST_VK=384;
    public static final int CUSTOMDATUM_VK=265;
    public static final int AUTOMATIC_VK=412;
    public static final int NOORDER_VK=497;
    public static final int PLSQL_NON_RESERVED_PIVOT=176;
    public static final int TIMEZONE_MINUTE_VK=373;
    public static final int DAY_VK=377;
    public static final int OBJECT_VK=271;
    public static final int FLOAT_VK=358;
    public static final int OUTER=182;
    public static final int SQL92_RESERVED_VIEW=168;
    public static final int FOLLOWS_VK=228;
    public static final int NAV_VK=411;
    public static final int SQL92_RESERVED_ALL=86;
    public static final int B_=10;
    public static final int SQL92_RESERVED_GOTO=122;
    public static final int SKIP_VK=391;
    public static final int STARTUP_VK=218;
    public static final int AMPERSAND=54;
    public static final int BIT_STRING_LIT=39;
    public static final int CYCLE_VK=498;
    public static final int SQL92_RESERVED_TRUE=163;
    public static final int XMLCAST_VK=462;
    public static final int BINDVAR=67;
    public static final int RIGHT=180;
    public static final int SQL92_RESERVED_PROCEDURE=150;
    public static final int DISABLE_VK=211;
    public static final int INDEX_NAME=612;
    public static final int CLOSE_VK=312;
    public static final int SOLIDUS=61;
    public static final int PLSQL_RESERVED_START=157;
    public static final int DB_ROLE_CHANGE_VK=231;
    public static final int FACTORING=669;
    public static final int COLON=64;
    public static final int COLUMNS=710;
    public static final int SELECT_MODE=685;
    public static final int SQL92_RESERVED_GROUP=124;
    public static final int PLSQL_RESERVED_MODE=138;
    public static final int UNPIVOT_VK=402;
    public static final int MERGE_VK=380;
    public static final int C_=11;
    public static final int TABLE_ELEMENT=708;
    public static final int QS_OTHER_CH=51;
    public static final int PERCENT_ROWTYPE_VK=281;
    public static final int NATURAL=184;
    public static final int IGNORE_VK=416;
    public static final int UNARY_OPERATOR=733;
    public static final int UNBOUNDED_VK=449;
    public static final int INT_VK=368;
    public static final int OVER_VK=446;
    public static final int LAST_VALUE_VK=447;
    public static final int HIERARCHICAL=692;
    public static final int LEFT_VK=427;
    public static final int VERSION_VK=461;
    public static final int SAMPLE_VK=405;
    public static final int XMLCOLATTVAL_VK=467;
    public static final int OUT_VK=259;
    public static final int FULL_VK=425;
    public static final int PLSQL_NON_RESERVED_ELSIF=175;
    public static final int SQL92_RESERVED_LIKE=135;
    public static final int LIMIT_VK=244;
    public static final int CLUSTER_VK=199;
    public static final int FORCE_VK=239;
    public static final int SQL92_RESERVED_DISTINCT=111;
    public static final int RESPECT_VK=417;
    public static final int L_=20;
    public static final int CHAR_SET_NAME=619;
    public static final int PLSQL_RESERVED_EXCLUSIVE=116;
    public static final int QUOTE=50;
    public static final int LABEL_NAME=605;
    public static final int SQL92_RESERVED_OVERLAPS=148;
    public static final int PLSQL_RESERVED_RESOURCE=152;
    public static final int CONCATENATION_OP=77;
    public static final int MULTI_TABLE_MODE=707;
    public static final int LESS_THAN_OR_EQUALS_OP=69;
    public static final int WRITE_VK=303;
    public static final int LANGUAGE_VK=253;
    public static final int AUTONOMOUS_TRANSACTION_VK=284;
    public static final int COMMENT=83;
    public static final int SPECIAL_FUNC=751;
    public static final int TIMESTAMP_LTZ_UNCONSTRAINED_VK=326;
    public static final int M_=21;
    public static final int REGULAR_ID=186;
    public static final int UNPIVOT_IN_ELEMENT=691;
    public static final int TIMEZONE_HOUR_VK=372;
    public static final int SQL92_RESERVED_PRIOR=149;
    public static final int EXCLAMATION_OPERATOR_PART=75;
    public static final int TILDE_OPERATOR_PART=74;
    public static final int PERIOD=41;
    public static final int MODIFY_VK=248;
    public static final int NATIONAL_CHAR_STRING_LIT=37;
    public static final int SQL92_RESERVED_VALUES=167;
    public static final int STANDARD_FUNCTION=734;
    public static final int SEQUENCE_VK=496;
    public static final int PRECEDING_VK=442;
    public static final int N_=22;
    public static final int BLOCK_VK=386;
    public static final int SQL92_RESERVED_DATE=106;
    public static final int SQL92_RESERVED_CREATE=103;
    public static final int SCHEMA_VK=216;
    public static final int ELEMENTS_MODE=689;
    public static final int WITHIN_VK=443;
    public static final int RESULT_CACHE_VK=192;
    public static final int XML_ALIAS=747;
    public static final int PERCENT_TYPE_VK=282;
    public static final int SQL92_RESERVED_INSERT=131;
    public static final int NOMAXVALUE_VK=501;
    public static final int XMLNAMESPACES_VK=474;
    public static final int INVALIDATE_VK=251;
    public static final int XML_COLUMN=746;
    public static final int SQL92_RESERVED_FROM=121;
    public static final int REFERENCE_MODEL_NAME=601;
    public static final int O_=23;
    public static final int CONTENT_VK=454;
    public static final int MAP_VK=274;
    public static final int SQL92_RESERVED_CURSOR=105;
    public static final int CURRENT_VK=448;
    public static final int CONDITIONAL_INSERT=709;
    public static final int HOSTED_VARIABLE_ROUTINE_CALL=628;
    public static final int PASSING_VK=470;
    public static final int UNTIL_VK=395;
    public static final int DIRECT_MODE=686;
    public static final int JOIN_ON_PART=680;
    public static final int SIBLINGS_VK=397;
    public static final int SQL92_RESERVED_THE=160;
    public static final int H_=16;
    public static final int INTRODUCER=82;
    public static final int ENABLE_VK=209;
    public static final int CURSOR_NAME=613;
    public static final int PROCEDURE_NAME=610;
    public static final int ID=620;
    public static final int SPACE=84;
    public static final int FROM_CLAUSE=674;
    public static final int CROSS=183;
    public static final int CROSS_VK=426;
    public static final int SQL92_RESERVED_TABLE=159;
    public static final int INCLUDING_VK=249;
    public static final int FOR_SINGLE_COLUMN=736;
    public static final int EXCEPTIONS_VK=243;
    public static final int EXPR_LIST=715;
    public static final int EXTRACT_VK=495;
    public static final int NOENTITYESCAPING_VK=476;
    public static final int EXPR=589;
    public static final int AFTER_VK=215;
    public static final int DISASSOCIATE_VK=223;
    public static final int TABLE_VAR_NAME=596;
    public static final int TIMESTAMP_UNCONSTRAINED_VK=336;
    public static final int ENCODING_VK=482;
    public static final int COMMA=60;
    public static final int SOME_VK=424;
    public static final int SEQUENTIAL_VK=389;
    public static final int FIRST_VALUE_VK=441;
    public static final int SIMPLE_CASE=738;
    public static final int HOSTED_VARIABLE_NAME=622;
    public static final int TYPE_NAME=606;
    public static final int SQL92_RESERVED_UPDATE=166;
    public static final int GROUPING_VK=414;
    public static final int IS_INFINITE=723;
    public static final int SQL92_RESERVED_BY=94;
    public static final int SECOND_VK=371;
    public static final int QUERY_NAME=603;
    public static final int I_=17;
    public static final int NOCOPY_VK=263;
    public static final int NOCACHE_VK=500;
    public static final int CORRUPT_XID_ALL_VK=305;
    public static final int HEX_STRING_LIT=40;
    public static final int AGGREGATE_VK=194;
    public static final int FUNCTION_ENABLING_WITHIN_OR_OVER=743;
    public static final int CUBE_VK=398;
    public static final int PLSQL_RESERVED_IDENTIFIED=126;
    public static final int MODEL_EXPRESSION=735;
    public static final int DOUBLE_PERIOD=7;
    public static final int PLUS_SIGN=59;
    public static final int INCREMENT_VK=431;
    public static final int SCN_VK=401;
    public static final int COUNT_VK=488;
    public static final int PLSQL_RESERVED_SHARE=155;
    public static final int NOT_BETWEEN=731;
    public static final int J_=18;
    public static final int CHARACTER_VK=353;
    public static final int PLSQL_RESERVED_INDEXES=130;
    public static final int SQL92_RESERVED_AS=90;
    public static final int LOGOFF_VK=232;
    public static final int RANGE_VK=204;
    public static final int DELIMITED_ID=52;
    public static final int PLSQL_NON_RESERVED_UNPIVOT=177;
    public static final int OFF_VK=294;
    public static final int PACKAGE_NAME=599;
    public static final int MAXVALUE_VK=341;
    public static final int VERSIONS_VK=407;
    public static final int TRIM_VK=491;
    public static final int BINARY_FLOAT_VK=330;
    public static final int TIMEZONE_ABBR_VK=322;
    public static final int ASSIGN=702;
    public static final int TABLEVIEW_NAME=618;
    public static final int TIMESTAMP_VK=363;
    public static final int SQL92_RESERVED_OPTION=145;
    public static final int K_=19;
    public static final int TRUNCATE_VK=217;
    public static final int WELLFORMED_VK=459;
    public static final int GREATER_THAN_OP=76;
    public static final int PERCENT_NOTFOUND_VK=277;
    public static final int ROWID_VK=335;
    public static final int SQL92_RESERVED_REVOKE=153;
    public static final int ONLY_VK=314;
    public static final int MEMBER_VK=269;
    public static final int STRING_VK=340;
    public static final int XMLATTRIBUTES_VK=481;
    public static final int PIPELINED_VK=193;
    public static final int XMLTABLE_VK=478;
    public static final int QS_OTHER=48;
    public static final int PLSQL_RESERVED_CRASH=102;
    public static final int PARTITION_VK=318;
    public static final int GROUP_BY_ELEMENT=694;
    public static final int MINUTE_VK=379;
    public static final int IS_NOT_PRESENT=720;
    public static final int XMLSERIALIZE_VK=484;
    public static final int PERCENT_FOUND_VK=278;
    public static final int U_=29;
    public static final int SEPARATOR=38;
    public static final int JOIN_DEF=678;
    public static final int ROWS_VK=437;
    public static final int EOF=-1;
    public static final int DEFINER_VK=197;
    public static final int IS_PRESENT=721;
    public static final int EXCEPTION_INIT_VK=276;
    public static final int SQL92_RESERVED_SIZE=156;
    public static final int INTEGER_VK=367;
    public static final int TIMEZONE_REGION_VK=325;
    public static final int ASSIGN_OP=63;
    public static final int DEFAULTS_VK=486;
    public static final int SIMPLE_LETTER=65;
    public static final int IS_NULL=717;
    public static final int SHOW_VK=483;
    public static final int FUNCTION_ENABLING_USING=742;
    public static final int SQL92_RESERVED_PUBLIC=151;
    public static final int PLSQL_RESERVED_NOWAIT=141;
    public static final int CONVERT_VK=252;
    public static final int SET_VK=423;
    public static final int NOAUDIT_VK=220;
    public static final int CONTEXT_VK=258;
    public static final int PLSQL_RESERVED_NOCOMPRESS=139;
    public static final int INTERVAL_DATATYPE=625;
    public static final int RIGHT_BRACKET=81;
    public static final int LIBRARY_VK=257;
    public static final int STANDALONE_VK=458;
    public static final int MAIN_MODEL=697;
    public static final int EXPLAIN_STATEMENT=662;
    public static final int T_=28;
    public static final int ADD_VK=247;
    public static final int ANALYZE_VK=233;
    public static final int UPSERT_VK=406;
    public static final int SINGLE_VK=390;
    public static final int DECIMAL_VK=365;
    public static final int SMALLINT_VK=369;
    public static final int COMPOUND_VK=225;
    public static final int ROLLBACK_VK=309;
    public static final int AT_SIGN=62;
    public static final int W_=31;
    public static final int SEMICOLON=68;
    public static final int CONTINUE_VK=292;
    public static final int SQL92_RESERVED_ELSE=113;
    public static final int SQL92_RESERVED_GRANT=123;
    public static final int PLSQL_NON_RESERVED_CONNECT_BY_ROOT=101;
    public static final int SQL92_RESERVED_FETCH=119;
    public static final int REVERSE_VK=293;
    public static final int PIVOT_IN_ELEMENT=690;
    public static final int LEADING_VK=492;
    public static final int EXTERNAL_VK=206;
    public static final int ROLLBACK_SEGMENT_NAME=595;
    public static final int RIGHT_VK=428;
    public static final int IS_NOT_INFINITE=722;
    public static final int TABLE_REF=676;
    public static final int PERCENT_ISOPEN_VK=279;
    public static final int ORDER_BY_CLAUSE=703;
    public static final int PIVOT_ELEMENT=687;
    public static final int MINVALUE_VK=342;
    public static final int V_=30;
    public static final int LIKEC_VK=419;
    public static final int LEFT_PAREN=55;
    public static final int SQL92_RESERVED_ALTER=87;
    public static final int ROLLUP_VK=410;
    public static final int COLUMN_NAME=617;
    public static final int XMLPI_VK=466;
    public static final int PLSQL_RESERVED_COLAUTH=98;
    public static final int LOCK_TABLE_ELEMENT=713;
    public static final int INSTANTIABLE_VK=245;
    public static final int FOR_MULTI_COLUMN=737;
    public static final int CLOB_VK=332;
    public static final int PLS_INTEGER_VK=316;
    public static final int SAVEPOINT_VK=311;
    public static final int MAIN_MODEL_NAME=602;
    public static final int COLLECT_VK=436;
    public static final int DENSE_RANK_VK=434;
    public static final int XMLEXISTS_VK=460;
    public static final int Q_=25;
    public static final int BYTE_VK=329;
    public static final int ORDER_BY_ELEMENT=705;
    public static final int SQL92_RESERVED_INTERSECT=132;
    public static final int ASTERISK=58;
    public static final int PLSQL_RESERVED_LOCK=136;
    public static final int UNSIGNED_INTEGER=4;
    public static final int RECORD_NAME=614;
    public static final int AUDIT_VK=222;
    public static final int DEC_VK=366;
    public static final int CHAR_STRING_PERL=49;
    public static final int IS_NOT_NAN=718;
    public static final int MINUS_SIGN=6;
    public static final int OLD_VK=230;
    public static final int GREATER_THAN_OR_EQUALS_OP=71;
    public static final int SQL92_RESERVED_WHEN=170;
    public static final int NEW_VK=236;
    public static final int BULK_VK=299;
    public static final int P_=24;
    public static final int CACHE_VK=499;
    public static final int INNER_VK=429;
    public static final int REFERENCING_VK=213;
    public static final int ROUTINE_NAME=598;
    public static final int RESTRICT_REFERENCES_VK=286;
    public static final int MERGE_UPDATE=711;
    public static final int LOOP_VK=290;
    public static final int UNDER_VK=273;
    public static final int SCHEMA_NAME=597;
    public static final int TRAILING_VK=493;
    public static final int JOIN_QUALIFIER=679;
    public static final int MERGE_INSERT=712;
    public static final int IS_NOT_NULL=716;
    public static final int NCLOB_VK=331;
    public static final int NCHAR_CS_VK=438;
    public static final int S_=27;
    public static final int MLSLABEL_VK=350;
    public static final int UPDATED_VK=392;
    public static final int VARCHAR_VK=355;
    public static final int BODY_VK=201;
    public static final int YES_VK=463;
    public static final int LOCAL_VK=374;
    public static final int LIKE4_VK=421;
    public static final int SQL92_RESERVED_FALSE=118;
    public static final int REPLACE_VK=190;
    public static final int FUNCTION_NAME=609;
    public static final int SQL92_RESERVED_IN=128;
    public static final int NATIVE_DATATYPE=624;
    public static final int SQL92_RESERVED_IS=134;
    public static final int SQL92_RESERVED_WHERE=171;
    public static final int R_=26;
    public static final int IS_NAN=719;
    public static final int CHAR_STRING=43;
    public static final int QS_PAREN=47;
    public static final int NVARCHAR2_VK=339;
    public static final int BOTH_VK=494;
    public static final int CONSTRUCTOR_VK=267;
    public static final int XML_COLUMN_NAME=633;
    public static final int CONSTRAINT_NAME=604;
    public static final int SQL92_RESERVED_CONNECT=100;
    public static final int TRANSLATE_VK=490;
    public static final int DELETE_STATEMENT=665;
    public static final int CAST_VK=489;
    public static final int NOCYCLE_VK=385;
    public static final int SQL92_RESERVED_ON=144;
    public static final int GROUPIN_SET=696;
    public static final int WAIT_VK=304;
    public static final int OVERRIDING_VK=255;
    public static final int BFILE_VK=324;
    public static final int XMLROOT_VK=479;
    public static final int CHR_VK=487;
    public static final int SQL92_RESERVED_OF=143;
    public static final int SHUTDOWN_VK=224;
    public static final int IS_EMPTY=727;
    public static final int RAW_VK=345;
    public static final int NOT_EQUAL_OP=72;
    public static final int SELECT_ITEM=673;
    public static final int IS_NOT_OF_TYPE=728;
    public static final int SQL92_RESERVED_DROP=112;
    public static final int TABLE_REF_ELEMENT=677;
    public static final int FULL=181;
    public static final int PLSQL_NON_RESERVED_USING=173;
    public static final int CONSTANT_VK=275;
    public static final int SQL92_RESERVED_CHECK=96;
    public static final int SINGLE_TABLE_MODE=706;
    public static final int SQL92_RESERVED_NULL=142;
    public static final int PARENT_VK=227;
    public static final int PROMPT=85;
    public static final int BINARY_DOUBLE_VK=323;
    public static final int AGENT_VK=262;
    public static final int YEAR_VK=375;
    public static final int SQL92_RESERVED_OR=146;
    public static final int DSINTERVAL_UNCONSTRAINED_VK=333;
    public static final int UROWID_VK=320;
    public static final int BREADTH_VK=505;
    public static final int APPROXIMATE_NUM_LIT=5;
    public static final int DECREMENT_VK=432;
    public static final int IS_NOT_EMPTY=726;
    public static final int KEEP_VK=403;
    public static final int COLLECTION_NAME=615;
    public static final int XMLPARSE_VK=455;
    public static final int SERIALIZABLE_VK=302;
    public static final int SQL92_RESERVED_BETWEEN=93;
    public static final int ISOLATION_VK=301;
    public static final int PLSQL_RESERVED_INDEX=129;
    public static final int QS_BRACE=45;
    public static final int POSITIVE_VK=349;
    public static final int PRECISION_VK=361;
    public static final int XML_ELEMENT=750;
    public static final int ARGUMENTS=590;
    public static final int CUSTOM_TYPE=623;
    public static final int PIVOT_VK=388;
    public static final int PLSQL_RESERVED_TABAUTH=158;
    public static final int DATABASE_VK=210;
    public static final int VARCHAR2_VK=347;
    public static final int PLSQL_RESERVED_COMPRESS=99;
    public static final int SQL92_RESERVED_AND=88;
    public static final int QS_BRACK=46;
    public static final int SELF_VK=270;
    public static final int EQUALS_OP=79;
    public static final int SQL92_RESERVED_CASE=95;
    public static final int INLINE_VK=285;
    public static final int ANY_ELEMENT=631;
    public static final int NO_VK=464;
    public static final int TIME_VK=362;
    public static final int UNLIMITED_VK=383;
    public static final int GROUP_BY_CLAUSE=693;
    public static final int RAISE_VK=289;
    public static final int CHAR_VK=354;
    public static final int VECTOR_EXPR=740;
    public static final int NOT_IN=730;
    public static final int MERGE_STATEMENT=668;
    public static final int DDL_VK=208;
    public static final int FUNCTION_ENABLING_OVER=741;
    public static final int MODEL_RULE=701;
    public static final int SERIALLY_REUSABLE_VK=283;
    public static final int IMMEDIATE_VK=296;
    public static final int EXACT_NUM_LIT=42;
    public static final int DBTIMEZONE_VK=343;
    public static final int CANONICAL_VK=444;
    public static final int SQL92_RESERVED_ANY=89;
    public static final int INCLUDE_VK=415;
    public static final int DATETIME_OP=749;
    public static final int SELECTED_TABLEVIEW=682;
    public static final int NCHAR_VK=356;
    public static final int Y_=33;
    public static final int NULLS_VK=399;
    public static final int INNER=185;
    public static final int COLLECTION_MODE=684;
    public static final int RETURN_VK=288;
    public static final int TRIGGER_NAME=611;
    public static final int RELIES_ON_VK=195;
    public static final int PLSQL_RESERVED_MINUS=137;
    public static final int SQL92_RESERVED_DEFAULT=108;
    public static final int DEPTH_VK=504;
    public static final int SQL92_RESERVED_FOR=120;
    public static final int LOGON_VK=214;
    public static final int INDENT_VK=471;
    public static final int INSTEAD_VK=234;
    public static final int ITERATE_VK=409;
    public static final int PRAGMA_VK=264;
    public static final int ZV=187;
    public static final int DECOMPOSE_VK=439;
    public static final int HOUR_VK=378;
    public static final int X_=32;
    public static final int MODEL_COLUMN=698;
    public static final int VARIABLE_NAME=621;
    public static final int IS_A_SET=725;
    public static final int XMLAGG_VK=473;
    public static final int MODEL_COLUMNS=699;
    public static final int COST_VK=450;
    public static final int REFERENCE_VK=394;
    public static final int NOMINVALUE_VK=502;
    public static final int SQL92_RESERVED_INTO=133;
    public static final int CORRUPT_XID_VK=306;
    public static final int REUSE_VK=189;
    public static final int COMMITTED_VK=300;
    public static final int NATURAL_VK=370;
    public static final int NUMBER_VK=346;
    public static final int LOCK_TABLE_STATEMENT=667;
    public static final int REF_VK=315;
    public static final int LESS_THAN_OP=70;
    public static final int FOR_NOTATION=35;
    public static final int SEARCHED_CASE=739;
    public static final int XMLELEMENT_VK=456;
    public static final int SQL92_RESERVED_TO=162;
    public static final int LONG_VK=352;
    public static final int FOLLOWING_VK=440;
    public static final int ORDER_BY_ELEMENTS=704;
    public static final int CASCADE_VK=250;
    public static final int NAME_VK=435;
    public static final int PERCENT=53;
    public static final int PACKAGE_VK=200;
    public static final int VALUE_VK=430;
    public static final int SQL92_RESERVED_UNION=164;
    public static final int INSERT_STATEMENT=666;
    public static final int MODEL_RULES=700;
    public static final int LOG_VK=382;
    public static final int ENTITYESCAPING_VK=457;
    public static final int YMINTERVAL_UNCONSTRAINED_VK=334;
    public static final int NOT_LIKE=732;
    public static final int SQL92_RESERVED_END=114;
    public static final int COST_CLASS_NAME=632;
    public static final int AUTO_VK=452;
    public static final int DEFERRED_VK=308;
    public static final int EXCEPTION_NAME=608;
    public static final int DOUBLE_VK=360;
    public static final int PLSQL_RESERVED_CLUSTERS=97;
    public static final int IMPLEMENTATION_TYPE_NAME=600;
    public static final int SQL92_RESERVED_CURRENT=104;
    public static final int JOIN=178;
    public static final int SQL92_RESERVED_EXCEPTION=115;
    public static final int STATIC_VK=272;
    public static final int READ_VK=313;
    public static final int FORALL_VK=291;
    public static final int ANY_MODE=688;
    public static final int NEWLINE=36;
    public static final int Z_=34;
    public static final int RENAME_VK=237;
    public static final int SQL92_RESERVED_SELECT=154;
    public static final int INOUT_VK=260;
    public static final int SQL92_RESERVED_ASC=91;
    public static final int ASSOCIATE_VK=235;
    public static final int BINARY_INTEGER_VK=351;
    public static final int PIVOT_ALIAS=748;
    public static final int DOCUMENT_VK=468;
    public static final int HIDE_VK=472;
    public static final int BATCH_VK=307;
    public static final int SQL92_RESERVED_NOT=140;
    public static final int TYPE_VK=241;
    public static final int STATIC_RETURNING=714;
    public static final int FINAL_VK=246;
    public static final int SQL92_RESERVED_BEGIN=92;
    public static final int SCHEMACHECK_VK=480;
    public static final int STATISTICS_VK=219;

    // delegates
    // delegators
    public OracleParser gOracleParser;
    public OracleParser gParent;


        public OracleParser_Commons(TokenStream input, OracleParser gOracleParser) {
            this(input, new RecognizerSharedState(), gOracleParser);
        }
        public OracleParser_Commons(TokenStream input, RecognizerSharedState state, OracleParser gOracleParser) {
            super(input, state);
            this.gOracleParser = gOracleParser;
             
            gParent = gOracleParser;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return OracleParser.tokenNames; }
    public String getGrammarFileName() { return "Commons.g"; }


    public static class partition_extension_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "partition_extension_clause"
    // Commons.g:57:1: partition_extension_clause : ( subpartition_key | partition_key ) ( for_key )? expression_list ;
    public final OracleParser_Commons.partition_extension_clause_return partition_extension_clause() throws RecognitionException {
        OracleParser_Commons.partition_extension_clause_return retval = new OracleParser_Commons.partition_extension_clause_return();
        retval.start = input.LT(1);
        int partition_extension_clause_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Keys.subpartition_key_return subpartition_key1 = null;

        OracleParser_Keys.partition_key_return partition_key2 = null;

        OracleParser_Keys.for_key_return for_key3 = null;

        OracleParser.expression_list_return expression_list4 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 549) ) { return retval; }
            // Commons.g:58:5: ( ( subpartition_key | partition_key ) ( for_key )? expression_list )
            // Commons.g:58:10: ( subpartition_key | partition_key ) ( for_key )? expression_list
            {
            root_0 = (Object)adaptor.nil();

            // Commons.g:58:10: ( subpartition_key | partition_key )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==REGULAR_ID) && ((input.LT(1).getText().equalsIgnoreCase("partition")))) {
                int LA1_1 = input.LA(2);

                if ( ((synpred1_Commons()&&(input.LT(1).getText().equalsIgnoreCase("subpartition")))) ) {
                    alt1=1;
                }
                else if ( ((input.LT(1).getText().equalsIgnoreCase("partition"))) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // Commons.g:58:12: subpartition_key
                    {
                    pushFollow(FOLLOW_subpartition_key_in_partition_extension_clause366);
                    subpartition_key1=gOracleParser.subpartition_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(subpartition_key1.getTree(), root_0);

                    }
                    break;
                case 2 :
                    // Commons.g:58:32: partition_key
                    {
                    pushFollow(FOLLOW_partition_key_in_partition_extension_clause371);
                    partition_key2=gOracleParser.partition_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(partition_key2.getTree(), root_0);

                    }
                    break;

            }

            // Commons.g:59:16: ( for_key )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==SQL92_RESERVED_FOR) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Commons.g:0:0: for_key
                    {
                    pushFollow(FOLLOW_for_key_in_partition_extension_clause385);
                    for_key3=gOracleParser.for_key();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_expression_list_in_partition_extension_clause389);
            expression_list4=gOracleParser.expression_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_list4.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 549, partition_extension_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "partition_extension_clause"

    public static class column_alias_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "column_alias"
    // Commons.g:62:1: column_alias options {backtrack=true; } : ( ( as_key )? ( id | alias_quoted_string ) -> ^( ALIAS ( id )? ( alias_quoted_string )? ) | as_key );
    public final OracleParser_Commons.column_alias_return column_alias() throws RecognitionException {
        OracleParser_Commons.column_alias_return retval = new OracleParser_Commons.column_alias_return();
        retval.start = input.LT(1);
        int column_alias_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Keys.as_key_return as_key5 = null;

        OracleParser_Commons.id_return id6 = null;

        OracleParser_Commons.alias_quoted_string_return alias_quoted_string7 = null;

        OracleParser_Keys.as_key_return as_key8 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_as_key=new RewriteRuleSubtreeStream(adaptor,"rule as_key");
        RewriteRuleSubtreeStream stream_alias_quoted_string=new RewriteRuleSubtreeStream(adaptor,"rule alias_quoted_string");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 550) ) { return retval; }
            // Commons.g:67:5: ( ( as_key )? ( id | alias_quoted_string ) -> ^( ALIAS ( id )? ( alias_quoted_string )? ) | as_key )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==SQL92_RESERVED_AS) ) {
                int LA5_1 = input.LA(2);

                if ( (synpred5_Commons()) ) {
                    alt5=1;
                }
                else if ( (true) ) {
                    alt5=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA5_0==NATIONAL_CHAR_STRING_LIT||LA5_0==CHAR_STRING||LA5_0==CHAR_STRING_PERL||LA5_0==DELIMITED_ID||LA5_0==INTRODUCER||LA5_0==REGULAR_ID) ) {
                alt5=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // Commons.g:67:10: ( as_key )? ( id | alias_quoted_string )
                    {
                    // Commons.g:67:10: ( as_key )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==SQL92_RESERVED_AS) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // Commons.g:0:0: as_key
                            {
                            pushFollow(FOLLOW_as_key_in_column_alias418);
                            as_key5=gOracleParser.as_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_as_key.add(as_key5.getTree());

                            }
                            break;

                    }

                    // Commons.g:67:18: ( id | alias_quoted_string )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==DELIMITED_ID||LA4_0==INTRODUCER||LA4_0==REGULAR_ID) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==NATIONAL_CHAR_STRING_LIT||LA4_0==CHAR_STRING||LA4_0==CHAR_STRING_PERL) ) {
                        alt4=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // Commons.g:67:19: id
                            {
                            pushFollow(FOLLOW_id_in_column_alias422);
                            id6=id();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_id.add(id6.getTree());

                            }
                            break;
                        case 2 :
                            // Commons.g:67:22: alias_quoted_string
                            {
                            pushFollow(FOLLOW_alias_quoted_string_in_column_alias424);
                            alias_quoted_string7=alias_quoted_string();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_alias_quoted_string.add(alias_quoted_string7.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: id, alias_quoted_string
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 68:5: -> ^( ALIAS ( id )? ( alias_quoted_string )? )
                    {
                        // Commons.g:68:11: ^( ALIAS ( id )? ( alias_quoted_string )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ALIAS, "ALIAS"), root_1);

                        // Commons.g:68:19: ( id )?
                        if ( stream_id.hasNext() ) {
                            adaptor.addChild(root_1, stream_id.nextTree());

                        }
                        stream_id.reset();
                        // Commons.g:68:23: ( alias_quoted_string )?
                        if ( stream_alias_quoted_string.hasNext() ) {
                            adaptor.addChild(root_1, stream_alias_quoted_string.nextTree());

                        }
                        stream_alias_quoted_string.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Commons.g:69:10: as_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_as_key_in_column_alias455);
                    as_key8=gOracleParser.as_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, as_key8.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 550, column_alias_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "column_alias"

    public static class table_alias_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table_alias"
    // Commons.g:72:1: table_alias : ( id | alias_quoted_string ) -> ^( ALIAS ( id )? ( alias_quoted_string )? ) ;
    public final OracleParser_Commons.table_alias_return table_alias() throws RecognitionException {
        OracleParser_Commons.table_alias_return retval = new OracleParser_Commons.table_alias_return();
        retval.start = input.LT(1);
        int table_alias_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id9 = null;

        OracleParser_Commons.alias_quoted_string_return alias_quoted_string10 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_alias_quoted_string=new RewriteRuleSubtreeStream(adaptor,"rule alias_quoted_string");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 551) ) { return retval; }
            // Commons.g:73:5: ( ( id | alias_quoted_string ) -> ^( ALIAS ( id )? ( alias_quoted_string )? ) )
            // Commons.g:73:10: ( id | alias_quoted_string )
            {
            // Commons.g:73:10: ( id | alias_quoted_string )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DELIMITED_ID||LA6_0==INTRODUCER||LA6_0==REGULAR_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==NATIONAL_CHAR_STRING_LIT||LA6_0==CHAR_STRING||LA6_0==CHAR_STRING_PERL) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // Commons.g:73:12: id
                    {
                    pushFollow(FOLLOW_id_in_table_alias477);
                    id9=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id9.getTree());

                    }
                    break;
                case 2 :
                    // Commons.g:73:17: alias_quoted_string
                    {
                    pushFollow(FOLLOW_alias_quoted_string_in_table_alias481);
                    alias_quoted_string10=alias_quoted_string();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_alias_quoted_string.add(alias_quoted_string10.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: id, alias_quoted_string
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 74:5: -> ^( ALIAS ( id )? ( alias_quoted_string )? )
            {
                // Commons.g:74:10: ^( ALIAS ( id )? ( alias_quoted_string )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ALIAS, "ALIAS"), root_1);

                // Commons.g:74:18: ( id )?
                if ( stream_id.hasNext() ) {
                    adaptor.addChild(root_1, stream_id.nextTree());

                }
                stream_id.reset();
                // Commons.g:74:22: ( alias_quoted_string )?
                if ( stream_alias_quoted_string.hasNext() ) {
                    adaptor.addChild(root_1, stream_alias_quoted_string.nextTree());

                }
                stream_alias_quoted_string.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 551, table_alias_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "table_alias"

    public static class alias_quoted_string_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alias_quoted_string"
    // Commons.g:77:1: alias_quoted_string : quoted_string -> ID[$quoted_string.start] ;
    public final OracleParser_Commons.alias_quoted_string_return alias_quoted_string() throws RecognitionException {
        OracleParser_Commons.alias_quoted_string_return retval = new OracleParser_Commons.alias_quoted_string_return();
        retval.start = input.LT(1);
        int alias_quoted_string_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.quoted_string_return quoted_string11 = null;


        RewriteRuleSubtreeStream stream_quoted_string=new RewriteRuleSubtreeStream(adaptor,"rule quoted_string");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 552) ) { return retval; }
            // Commons.g:78:5: ( quoted_string -> ID[$quoted_string.start] )
            // Commons.g:78:10: quoted_string
            {
            pushFollow(FOLLOW_quoted_string_in_alias_quoted_string521);
            quoted_string11=quoted_string();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_quoted_string.add(quoted_string11.getTree());


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 79:9: -> ID[$quoted_string.start]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(ID, (quoted_string11!=null?((Token)quoted_string11.start):null)));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 552, alias_quoted_string_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "alias_quoted_string"

    public static class where_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where_clause"
    // Commons.g:82:1: where_clause : where_key ( current_of_clause -> ^( WHERE_CLAUSE current_of_clause ) | condition_wrapper -> ^( WHERE_CLAUSE condition_wrapper ) ) ;
    public final OracleParser_Commons.where_clause_return where_clause() throws RecognitionException {
        OracleParser_Commons.where_clause_return retval = new OracleParser_Commons.where_clause_return();
        retval.start = input.LT(1);
        int where_clause_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Keys.where_key_return where_key12 = null;

        OracleParser_Commons.current_of_clause_return current_of_clause13 = null;

        OracleParser.condition_wrapper_return condition_wrapper14 = null;


        RewriteRuleSubtreeStream stream_condition_wrapper=new RewriteRuleSubtreeStream(adaptor,"rule condition_wrapper");
        RewriteRuleSubtreeStream stream_where_key=new RewriteRuleSubtreeStream(adaptor,"rule where_key");
        RewriteRuleSubtreeStream stream_current_of_clause=new RewriteRuleSubtreeStream(adaptor,"rule current_of_clause");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 553) ) { return retval; }
            // Commons.g:83:5: ( where_key ( current_of_clause -> ^( WHERE_CLAUSE current_of_clause ) | condition_wrapper -> ^( WHERE_CLAUSE condition_wrapper ) ) )
            // Commons.g:83:10: where_key ( current_of_clause -> ^( WHERE_CLAUSE current_of_clause ) | condition_wrapper -> ^( WHERE_CLAUSE condition_wrapper ) )
            {
            pushFollow(FOLLOW_where_key_in_where_clause554);
            where_key12=gOracleParser.where_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_where_key.add(where_key12.getTree());
            // Commons.g:83:20: ( current_of_clause -> ^( WHERE_CLAUSE current_of_clause ) | condition_wrapper -> ^( WHERE_CLAUSE condition_wrapper ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==SQL92_RESERVED_CURRENT) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=UNSIGNED_INTEGER && LA7_0<=MINUS_SIGN)||LA7_0==NATIONAL_CHAR_STRING_LIT||(LA7_0>=EXACT_NUM_LIT && LA7_0<=CHAR_STRING)||LA7_0==CHAR_STRING_PERL||LA7_0==DELIMITED_ID||LA7_0==LEFT_PAREN||LA7_0==PLUS_SIGN||LA7_0==COLON||LA7_0==BINDVAR||LA7_0==INTRODUCER||LA7_0==SQL92_RESERVED_ALL||LA7_0==SQL92_RESERVED_ANY||LA7_0==SQL92_RESERVED_CASE||LA7_0==PLSQL_NON_RESERVED_CONNECT_BY_ROOT||(LA7_0>=SQL92_RESERVED_CURSOR && LA7_0<=SQL92_RESERVED_DATE)||LA7_0==SQL92_RESERVED_DEFAULT||LA7_0==SQL92_RESERVED_DISTINCT||(LA7_0>=SQL92_RESERVED_EXISTS && LA7_0<=SQL92_RESERVED_FALSE)||LA7_0==SQL92_RESERVED_NOT||LA7_0==SQL92_RESERVED_NULL||LA7_0==SQL92_RESERVED_PRIOR||LA7_0==SQL92_RESERVED_TRUE||LA7_0==REGULAR_ID) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // Commons.g:83:21: current_of_clause
                    {
                    pushFollow(FOLLOW_current_of_clause_in_where_clause557);
                    current_of_clause13=current_of_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_current_of_clause.add(current_of_clause13.getTree());


                    // AST REWRITE
                    // elements: current_of_clause
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 83:39: -> ^( WHERE_CLAUSE current_of_clause )
                    {
                        // Commons.g:83:42: ^( WHERE_CLAUSE current_of_clause )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHERE_CLAUSE, "WHERE_CLAUSE"), root_1);

                        adaptor.addChild(root_1, stream_current_of_clause.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Commons.g:84:3: condition_wrapper
                    {
                    pushFollow(FOLLOW_condition_wrapper_in_where_clause569);
                    condition_wrapper14=gOracleParser.condition_wrapper();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_condition_wrapper.add(condition_wrapper14.getTree());


                    // AST REWRITE
                    // elements: condition_wrapper
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 84:21: -> ^( WHERE_CLAUSE condition_wrapper )
                    {
                        // Commons.g:84:24: ^( WHERE_CLAUSE condition_wrapper )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHERE_CLAUSE, "WHERE_CLAUSE"), root_1);

                        adaptor.addChild(root_1, stream_condition_wrapper.nextTree());

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

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 553, where_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "where_clause"

    public static class current_of_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "current_of_clause"
    // Commons.g:88:1: current_of_clause : current_key of_key cursor_name ;
    public final OracleParser_Commons.current_of_clause_return current_of_clause() throws RecognitionException {
        OracleParser_Commons.current_of_clause_return retval = new OracleParser_Commons.current_of_clause_return();
        retval.start = input.LT(1);
        int current_of_clause_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Keys.current_key_return current_key15 = null;

        OracleParser_Keys.of_key_return of_key16 = null;

        OracleParser_Commons.cursor_name_return cursor_name17 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 554) ) { return retval; }
            // Commons.g:89:5: ( current_key of_key cursor_name )
            // Commons.g:89:10: current_key of_key cursor_name
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_current_key_in_current_of_clause601);
            current_key15=gOracleParser.current_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(current_key15.getTree(), root_0);
            pushFollow(FOLLOW_of_key_in_current_of_clause604);
            of_key16=gOracleParser.of_key();

            state._fsp--;
            if (state.failed) return retval;
            pushFollow(FOLLOW_cursor_name_in_current_of_clause607);
            cursor_name17=cursor_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, cursor_name17.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 554, current_of_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "current_of_clause"

    public static class into_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "into_clause"
    // Commons.g:92:1: into_clause : ( into_key variable_name ( COMMA variable_name )* | bulk_key collect_key into_key variable_name ( COMMA variable_name )* );
    public final OracleParser_Commons.into_clause_return into_clause() throws RecognitionException {
        OracleParser_Commons.into_clause_return retval = new OracleParser_Commons.into_clause_return();
        retval.start = input.LT(1);
        int into_clause_StartIndex = input.index();
        Object root_0 = null;

        Token COMMA20=null;
        Token COMMA26=null;
        OracleParser_Keys.into_key_return into_key18 = null;

        OracleParser_Commons.variable_name_return variable_name19 = null;

        OracleParser_Commons.variable_name_return variable_name21 = null;

        OracleParser_Keys.bulk_key_return bulk_key22 = null;

        OracleParser_Keys.collect_key_return collect_key23 = null;

        OracleParser_Keys.into_key_return into_key24 = null;

        OracleParser_Commons.variable_name_return variable_name25 = null;

        OracleParser_Commons.variable_name_return variable_name27 = null;


        Object COMMA20_tree=null;
        Object COMMA26_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 555) ) { return retval; }
            // Commons.g:93:5: ( into_key variable_name ( COMMA variable_name )* | bulk_key collect_key into_key variable_name ( COMMA variable_name )* )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==SQL92_RESERVED_INTO) ) {
                alt10=1;
            }
            else if ( (LA10_0==REGULAR_ID) && ((input.LT(1).getText().equalsIgnoreCase("bulk")))) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // Commons.g:93:10: into_key variable_name ( COMMA variable_name )*
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_into_key_in_into_clause627);
                    into_key18=gOracleParser.into_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(into_key18.getTree(), root_0);
                    pushFollow(FOLLOW_variable_name_in_into_clause630);
                    variable_name19=variable_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variable_name19.getTree());
                    // Commons.g:93:34: ( COMMA variable_name )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Commons.g:93:35: COMMA variable_name
                    	    {
                    	    COMMA20=(Token)match(input,COMMA,FOLLOW_COMMA_in_into_clause633); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_variable_name_in_into_clause636);
                    	    variable_name21=variable_name();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, variable_name21.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Commons.g:94:10: bulk_key collect_key into_key variable_name ( COMMA variable_name )*
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_bulk_key_in_into_clause650);
                    bulk_key22=gOracleParser.bulk_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(bulk_key22.getTree(), root_0);
                    pushFollow(FOLLOW_collect_key_in_into_clause653);
                    collect_key23=gOracleParser.collect_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_into_key_in_into_clause656);
                    into_key24=gOracleParser.into_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_variable_name_in_into_clause659);
                    variable_name25=variable_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variable_name25.getTree());
                    // Commons.g:94:57: ( COMMA variable_name )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==COMMA) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Commons.g:94:58: COMMA variable_name
                    	    {
                    	    COMMA26=(Token)match(input,COMMA,FOLLOW_COMMA_in_into_clause662); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_variable_name_in_into_clause665);
                    	    variable_name27=variable_name();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, variable_name27.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 555, into_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "into_clause"

    public static class xml_column_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xml_column_name"
    // Commons.g:101:1: xml_column_name : ( id -> ^( XML_COLUMN_NAME id ) | quoted_string -> ^( XML_COLUMN_NAME ID[$quoted_string.start] ) );
    public final OracleParser_Commons.xml_column_name_return xml_column_name() throws RecognitionException {
        OracleParser_Commons.xml_column_name_return retval = new OracleParser_Commons.xml_column_name_return();
        retval.start = input.LT(1);
        int xml_column_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id28 = null;

        OracleParser_Commons.quoted_string_return quoted_string29 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_quoted_string=new RewriteRuleSubtreeStream(adaptor,"rule quoted_string");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 556) ) { return retval; }
            // Commons.g:102:5: ( id -> ^( XML_COLUMN_NAME id ) | quoted_string -> ^( XML_COLUMN_NAME ID[$quoted_string.start] ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==DELIMITED_ID||LA11_0==INTRODUCER||LA11_0==REGULAR_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==NATIONAL_CHAR_STRING_LIT||LA11_0==CHAR_STRING||LA11_0==CHAR_STRING_PERL) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // Commons.g:102:10: id
                    {
                    pushFollow(FOLLOW_id_in_xml_column_name692);
                    id28=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id28.getTree());


                    // AST REWRITE
                    // elements: id
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 102:13: -> ^( XML_COLUMN_NAME id )
                    {
                        // Commons.g:102:16: ^( XML_COLUMN_NAME id )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(XML_COLUMN_NAME, "XML_COLUMN_NAME"), root_1);

                        adaptor.addChild(root_1, stream_id.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Commons.g:103:10: quoted_string
                    {
                    pushFollow(FOLLOW_quoted_string_in_xml_column_name711);
                    quoted_string29=quoted_string();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_quoted_string.add(quoted_string29.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 103:24: -> ^( XML_COLUMN_NAME ID[$quoted_string.start] )
                    {
                        // Commons.g:103:27: ^( XML_COLUMN_NAME ID[$quoted_string.start] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(XML_COLUMN_NAME, "XML_COLUMN_NAME"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(ID, (quoted_string29!=null?((Token)quoted_string29.start):null)));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 556, xml_column_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "xml_column_name"

    public static class cost_class_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cost_class_name"
    // Commons.g:106:1: cost_class_name : id -> ^( COST_CLASS_NAME id ) ;
    public final OracleParser_Commons.cost_class_name_return cost_class_name() throws RecognitionException {
        OracleParser_Commons.cost_class_name_return retval = new OracleParser_Commons.cost_class_name_return();
        retval.start = input.LT(1);
        int cost_class_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id30 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 557) ) { return retval; }
            // Commons.g:107:5: ( id -> ^( COST_CLASS_NAME id ) )
            // Commons.g:107:10: id
            {
            pushFollow(FOLLOW_id_in_cost_class_name740);
            id30=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id30.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 108:9: -> ^( COST_CLASS_NAME id )
            {
                // Commons.g:108:12: ^( COST_CLASS_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COST_CLASS_NAME, "COST_CLASS_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 557, cost_class_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "cost_class_name"

    public static class attribute_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute_name"
    // Commons.g:111:1: attribute_name : id -> ^( ATTRIBUTE_NAME id ) ;
    public final OracleParser_Commons.attribute_name_return attribute_name() throws RecognitionException {
        OracleParser_Commons.attribute_name_return retval = new OracleParser_Commons.attribute_name_return();
        retval.start = input.LT(1);
        int attribute_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id31 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 558) ) { return retval; }
            // Commons.g:112:5: ( id -> ^( ATTRIBUTE_NAME id ) )
            // Commons.g:112:10: id
            {
            pushFollow(FOLLOW_id_in_attribute_name776);
            id31=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id31.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 113:9: -> ^( ATTRIBUTE_NAME id )
            {
                // Commons.g:113:12: ^( ATTRIBUTE_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 558, attribute_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "attribute_name"

    public static class savepoint_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "savepoint_name"
    // Commons.g:116:1: savepoint_name : id -> ^( SAVEPOINT_NAME id ) ;
    public final OracleParser_Commons.savepoint_name_return savepoint_name() throws RecognitionException {
        OracleParser_Commons.savepoint_name_return retval = new OracleParser_Commons.savepoint_name_return();
        retval.start = input.LT(1);
        int savepoint_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id32 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 559) ) { return retval; }
            // Commons.g:117:5: ( id -> ^( SAVEPOINT_NAME id ) )
            // Commons.g:117:10: id
            {
            pushFollow(FOLLOW_id_in_savepoint_name812);
            id32=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id32.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 118:9: -> ^( SAVEPOINT_NAME id )
            {
                // Commons.g:118:12: ^( SAVEPOINT_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SAVEPOINT_NAME, "SAVEPOINT_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 559, savepoint_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "savepoint_name"

    public static class rollback_segment_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rollback_segment_name"
    // Commons.g:121:1: rollback_segment_name : id -> ^( ROLLBACK_SEGMENT_NAME id ) ;
    public final OracleParser_Commons.rollback_segment_name_return rollback_segment_name() throws RecognitionException {
        OracleParser_Commons.rollback_segment_name_return retval = new OracleParser_Commons.rollback_segment_name_return();
        retval.start = input.LT(1);
        int rollback_segment_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id33 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 560) ) { return retval; }
            // Commons.g:122:5: ( id -> ^( ROLLBACK_SEGMENT_NAME id ) )
            // Commons.g:122:10: id
            {
            pushFollow(FOLLOW_id_in_rollback_segment_name848);
            id33=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id33.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 123:9: -> ^( ROLLBACK_SEGMENT_NAME id )
            {
                // Commons.g:123:12: ^( ROLLBACK_SEGMENT_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROLLBACK_SEGMENT_NAME, "ROLLBACK_SEGMENT_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 560, rollback_segment_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "rollback_segment_name"

    public static class table_var_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table_var_name"
    // Commons.g:127:1: table_var_name : id -> ^( TABLE_VAR_NAME id ) ;
    public final OracleParser_Commons.table_var_name_return table_var_name() throws RecognitionException {
        OracleParser_Commons.table_var_name_return retval = new OracleParser_Commons.table_var_name_return();
        retval.start = input.LT(1);
        int table_var_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id34 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 561) ) { return retval; }
            // Commons.g:128:5: ( id -> ^( TABLE_VAR_NAME id ) )
            // Commons.g:128:10: id
            {
            pushFollow(FOLLOW_id_in_table_var_name885);
            id34=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id34.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 129:9: -> ^( TABLE_VAR_NAME id )
            {
                // Commons.g:129:12: ^( TABLE_VAR_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TABLE_VAR_NAME, "TABLE_VAR_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 561, table_var_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "table_var_name"

    public static class schema_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schema_name"
    // Commons.g:132:1: schema_name : id -> ^( SCHEMA_NAME id ) ;
    public final OracleParser_Commons.schema_name_return schema_name() throws RecognitionException {
        OracleParser_Commons.schema_name_return retval = new OracleParser_Commons.schema_name_return();
        retval.start = input.LT(1);
        int schema_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id35 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 562) ) { return retval; }
            // Commons.g:133:5: ( id -> ^( SCHEMA_NAME id ) )
            // Commons.g:133:10: id
            {
            pushFollow(FOLLOW_id_in_schema_name921);
            id35=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id35.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 134:9: -> ^( SCHEMA_NAME id )
            {
                // Commons.g:134:12: ^( SCHEMA_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SCHEMA_NAME, "SCHEMA_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 562, schema_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "schema_name"

    public static class routine_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "routine_name"
    // Commons.g:137:1: routine_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )* ( AT_SIGN link_name )? -> ^( ROUTINE_NAME id ( id_expression )* ( link_name )? ) ;
    public final OracleParser_Commons.routine_name_return routine_name() throws RecognitionException {
        OracleParser_Commons.routine_name_return retval = new OracleParser_Commons.routine_name_return();
        retval.start = input.LT(1);
        int routine_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD37=null;
        Token AT_SIGN39=null;
        OracleParser_Commons.id_return id36 = null;

        OracleParser_Commons.id_expression_return id_expression38 = null;

        OracleParser_Commons.link_name_return link_name40 = null;


        Object PERIOD37_tree=null;
        Object AT_SIGN39_tree=null;
        RewriteRuleTokenStream stream_AT_SIGN=new RewriteRuleTokenStream(adaptor,"token AT_SIGN");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_link_name=new RewriteRuleSubtreeStream(adaptor,"rule link_name");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 563) ) { return retval; }
            // Commons.g:138:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )* ( AT_SIGN link_name )? -> ^( ROUTINE_NAME id ( id_expression )* ( link_name )? ) )
            // Commons.g:138:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )* ( AT_SIGN link_name )?
            {
            pushFollow(FOLLOW_id_in_routine_name957);
            id36=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id36.getTree());
            // Commons.g:138:13: ( ( PERIOD id_expression )=> PERIOD id_expression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==PERIOD) && (synpred12_Commons())) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Commons.g:138:14: ( PERIOD id_expression )=> PERIOD id_expression
            	    {
            	    PERIOD37=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_routine_name967); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD37);

            	    pushFollow(FOLLOW_id_expression_in_routine_name969);
            	    id_expression38=id_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_id_expression.add(id_expression38.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // Commons.g:138:62: ( AT_SIGN link_name )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==AT_SIGN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Commons.g:138:63: AT_SIGN link_name
                    {
                    AT_SIGN39=(Token)match(input,AT_SIGN,FOLLOW_AT_SIGN_in_routine_name974); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AT_SIGN.add(AT_SIGN39);

                    pushFollow(FOLLOW_link_name_in_routine_name976);
                    link_name40=link_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_link_name.add(link_name40.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: id_expression, link_name, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 139:9: -> ^( ROUTINE_NAME id ( id_expression )* ( link_name )? )
            {
                // Commons.g:139:12: ^( ROUTINE_NAME id ( id_expression )* ( link_name )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROUTINE_NAME, "ROUTINE_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:139:30: ( id_expression )*
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();
                // Commons.g:139:45: ( link_name )?
                if ( stream_link_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_link_name.nextTree());

                }
                stream_link_name.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 563, routine_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "routine_name"

    public static class package_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "package_name"
    // Commons.g:142:1: package_name : id -> ^( PACKAGE_NAME id ) ;
    public final OracleParser_Commons.package_name_return package_name() throws RecognitionException {
        OracleParser_Commons.package_name_return retval = new OracleParser_Commons.package_name_return();
        retval.start = input.LT(1);
        int package_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id41 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 564) ) { return retval; }
            // Commons.g:143:5: ( id -> ^( PACKAGE_NAME id ) )
            // Commons.g:143:10: id
            {
            pushFollow(FOLLOW_id_in_package_name1020);
            id41=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id41.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 144:9: -> ^( PACKAGE_NAME id )
            {
                // Commons.g:144:12: ^( PACKAGE_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PACKAGE_NAME, "PACKAGE_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 564, package_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "package_name"

    public static class implementation_type_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "implementation_type_name"
    // Commons.g:147:1: implementation_type_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( IMPLEMENTATION_TYPE_NAME id ( id_expression )? ) ;
    public final OracleParser_Commons.implementation_type_name_return implementation_type_name() throws RecognitionException {
        OracleParser_Commons.implementation_type_name_return retval = new OracleParser_Commons.implementation_type_name_return();
        retval.start = input.LT(1);
        int implementation_type_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD43=null;
        OracleParser_Commons.id_return id42 = null;

        OracleParser_Commons.id_expression_return id_expression44 = null;


        Object PERIOD43_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 565) ) { return retval; }
            // Commons.g:148:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( IMPLEMENTATION_TYPE_NAME id ( id_expression )? ) )
            // Commons.g:148:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )?
            {
            pushFollow(FOLLOW_id_in_implementation_type_name1056);
            id42=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id42.getTree());
            // Commons.g:148:13: ( ( PERIOD id_expression )=> PERIOD id_expression )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==PERIOD) && (synpred14_Commons())) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Commons.g:148:14: ( PERIOD id_expression )=> PERIOD id_expression
                    {
                    PERIOD43=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_implementation_type_name1066); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD43);

                    pushFollow(FOLLOW_id_expression_in_implementation_type_name1068);
                    id_expression44=id_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id_expression.add(id_expression44.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: id_expression, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 149:9: -> ^( IMPLEMENTATION_TYPE_NAME id ( id_expression )? )
            {
                // Commons.g:149:12: ^( IMPLEMENTATION_TYPE_NAME id ( id_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IMPLEMENTATION_TYPE_NAME, "IMPLEMENTATION_TYPE_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:149:42: ( id_expression )?
                if ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 565, implementation_type_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "implementation_type_name"

    public static class parameter_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameter_name"
    // Commons.g:152:1: parameter_name : id -> ^( PARAMETER_NAME id ) ;
    public final OracleParser_Commons.parameter_name_return parameter_name() throws RecognitionException {
        OracleParser_Commons.parameter_name_return retval = new OracleParser_Commons.parameter_name_return();
        retval.start = input.LT(1);
        int parameter_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id45 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 566) ) { return retval; }
            // Commons.g:153:5: ( id -> ^( PARAMETER_NAME id ) )
            // Commons.g:153:10: id
            {
            pushFollow(FOLLOW_id_in_parameter_name1109);
            id45=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id45.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 154:9: -> ^( PARAMETER_NAME id )
            {
                // Commons.g:154:12: ^( PARAMETER_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMETER_NAME, "PARAMETER_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 566, parameter_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "parameter_name"

    public static class reference_model_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "reference_model_name"
    // Commons.g:157:1: reference_model_name : id -> ^( REFERENCE_MODEL_NAME id ) ;
    public final OracleParser_Commons.reference_model_name_return reference_model_name() throws RecognitionException {
        OracleParser_Commons.reference_model_name_return retval = new OracleParser_Commons.reference_model_name_return();
        retval.start = input.LT(1);
        int reference_model_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id46 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 567) ) { return retval; }
            // Commons.g:158:5: ( id -> ^( REFERENCE_MODEL_NAME id ) )
            // Commons.g:158:10: id
            {
            pushFollow(FOLLOW_id_in_reference_model_name1145);
            id46=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id46.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 159:9: -> ^( REFERENCE_MODEL_NAME id )
            {
                // Commons.g:159:12: ^( REFERENCE_MODEL_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REFERENCE_MODEL_NAME, "REFERENCE_MODEL_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 567, reference_model_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "reference_model_name"

    public static class main_model_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "main_model_name"
    // Commons.g:162:1: main_model_name : id -> ^( MAIN_MODEL_NAME id ) ;
    public final OracleParser_Commons.main_model_name_return main_model_name() throws RecognitionException {
        OracleParser_Commons.main_model_name_return retval = new OracleParser_Commons.main_model_name_return();
        retval.start = input.LT(1);
        int main_model_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id47 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 568) ) { return retval; }
            // Commons.g:163:5: ( id -> ^( MAIN_MODEL_NAME id ) )
            // Commons.g:163:10: id
            {
            pushFollow(FOLLOW_id_in_main_model_name1181);
            id47=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id47.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 164:9: -> ^( MAIN_MODEL_NAME id )
            {
                // Commons.g:164:12: ^( MAIN_MODEL_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAIN_MODEL_NAME, "MAIN_MODEL_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 568, main_model_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "main_model_name"

    public static class aggregate_function_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aggregate_function_name"
    // Commons.g:167:1: aggregate_function_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( ROUTINE_NAME id ( id_expression )* ) ;
    public final OracleParser_Commons.aggregate_function_name_return aggregate_function_name() throws RecognitionException {
        OracleParser_Commons.aggregate_function_name_return retval = new OracleParser_Commons.aggregate_function_name_return();
        retval.start = input.LT(1);
        int aggregate_function_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD49=null;
        OracleParser_Commons.id_return id48 = null;

        OracleParser_Commons.id_expression_return id_expression50 = null;


        Object PERIOD49_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 569) ) { return retval; }
            // Commons.g:168:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( ROUTINE_NAME id ( id_expression )* ) )
            // Commons.g:168:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )*
            {
            pushFollow(FOLLOW_id_in_aggregate_function_name1217);
            id48=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id48.getTree());
            // Commons.g:168:13: ( ( PERIOD id_expression )=> PERIOD id_expression )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==PERIOD) && (synpred15_Commons())) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Commons.g:168:14: ( PERIOD id_expression )=> PERIOD id_expression
            	    {
            	    PERIOD49=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_aggregate_function_name1227); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD49);

            	    pushFollow(FOLLOW_id_expression_in_aggregate_function_name1229);
            	    id_expression50=id_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_id_expression.add(id_expression50.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);



            // AST REWRITE
            // elements: id_expression, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 169:9: -> ^( ROUTINE_NAME id ( id_expression )* )
            {
                // Commons.g:169:12: ^( ROUTINE_NAME id ( id_expression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROUTINE_NAME, "ROUTINE_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:169:30: ( id_expression )*
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 569, aggregate_function_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "aggregate_function_name"

    public static class query_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query_name"
    // Commons.g:172:1: query_name : id -> ^( QUERY_NAME id ) ;
    public final OracleParser_Commons.query_name_return query_name() throws RecognitionException {
        OracleParser_Commons.query_name_return retval = new OracleParser_Commons.query_name_return();
        retval.start = input.LT(1);
        int query_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id51 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 570) ) { return retval; }
            // Commons.g:173:5: ( id -> ^( QUERY_NAME id ) )
            // Commons.g:173:10: id
            {
            pushFollow(FOLLOW_id_in_query_name1270);
            id51=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id51.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 174:9: -> ^( QUERY_NAME id )
            {
                // Commons.g:174:12: ^( QUERY_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUERY_NAME, "QUERY_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 570, query_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "query_name"

    public static class constraint_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constraint_name"
    // Commons.g:177:1: constraint_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )* ( AT_SIGN link_name )? -> ^( CONSTRAINT_NAME id ( id_expression )* ( link_name )? ) ;
    public final OracleParser_Commons.constraint_name_return constraint_name() throws RecognitionException {
        OracleParser_Commons.constraint_name_return retval = new OracleParser_Commons.constraint_name_return();
        retval.start = input.LT(1);
        int constraint_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD53=null;
        Token AT_SIGN55=null;
        OracleParser_Commons.id_return id52 = null;

        OracleParser_Commons.id_expression_return id_expression54 = null;

        OracleParser_Commons.link_name_return link_name56 = null;


        Object PERIOD53_tree=null;
        Object AT_SIGN55_tree=null;
        RewriteRuleTokenStream stream_AT_SIGN=new RewriteRuleTokenStream(adaptor,"token AT_SIGN");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_link_name=new RewriteRuleSubtreeStream(adaptor,"rule link_name");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 571) ) { return retval; }
            // Commons.g:178:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )* ( AT_SIGN link_name )? -> ^( CONSTRAINT_NAME id ( id_expression )* ( link_name )? ) )
            // Commons.g:178:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )* ( AT_SIGN link_name )?
            {
            pushFollow(FOLLOW_id_in_constraint_name1306);
            id52=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id52.getTree());
            // Commons.g:178:13: ( ( PERIOD id_expression )=> PERIOD id_expression )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==PERIOD) && (synpred16_Commons())) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // Commons.g:178:14: ( PERIOD id_expression )=> PERIOD id_expression
            	    {
            	    PERIOD53=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_constraint_name1316); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD53);

            	    pushFollow(FOLLOW_id_expression_in_constraint_name1318);
            	    id_expression54=id_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_id_expression.add(id_expression54.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // Commons.g:178:62: ( AT_SIGN link_name )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==AT_SIGN) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Commons.g:178:63: AT_SIGN link_name
                    {
                    AT_SIGN55=(Token)match(input,AT_SIGN,FOLLOW_AT_SIGN_in_constraint_name1323); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AT_SIGN.add(AT_SIGN55);

                    pushFollow(FOLLOW_link_name_in_constraint_name1325);
                    link_name56=link_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_link_name.add(link_name56.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: id, id_expression, link_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 179:9: -> ^( CONSTRAINT_NAME id ( id_expression )* ( link_name )? )
            {
                // Commons.g:179:12: ^( CONSTRAINT_NAME id ( id_expression )* ( link_name )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT_NAME, "CONSTRAINT_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:179:33: ( id_expression )*
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();
                // Commons.g:179:48: ( link_name )?
                if ( stream_link_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_link_name.nextTree());

                }
                stream_link_name.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 571, constraint_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "constraint_name"

    public static class label_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "label_name"
    // Commons.g:182:1: label_name : id_expression -> ^( LABEL_NAME id_expression ) ;
    public final OracleParser_Commons.label_name_return label_name() throws RecognitionException {
        OracleParser_Commons.label_name_return retval = new OracleParser_Commons.label_name_return();
        retval.start = input.LT(1);
        int label_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_expression_return id_expression57 = null;


        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 572) ) { return retval; }
            // Commons.g:183:5: ( id_expression -> ^( LABEL_NAME id_expression ) )
            // Commons.g:183:10: id_expression
            {
            pushFollow(FOLLOW_id_expression_in_label_name1369);
            id_expression57=id_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id_expression.add(id_expression57.getTree());


            // AST REWRITE
            // elements: id_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 184:9: -> ^( LABEL_NAME id_expression )
            {
                // Commons.g:184:12: ^( LABEL_NAME id_expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LABEL_NAME, "LABEL_NAME"), root_1);

                adaptor.addChild(root_1, stream_id_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 572, label_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "label_name"

    public static class type_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type_name"
    // Commons.g:187:1: type_name : id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( TYPE_NAME ( id_expression )+ ) ;
    public final OracleParser_Commons.type_name_return type_name() throws RecognitionException {
        OracleParser_Commons.type_name_return retval = new OracleParser_Commons.type_name_return();
        retval.start = input.LT(1);
        int type_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD59=null;
        OracleParser_Commons.id_expression_return id_expression58 = null;

        OracleParser_Commons.id_expression_return id_expression60 = null;


        Object PERIOD59_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 573) ) { return retval; }
            // Commons.g:188:5: ( id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( TYPE_NAME ( id_expression )+ ) )
            // Commons.g:188:10: id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )*
            {
            pushFollow(FOLLOW_id_expression_in_type_name1405);
            id_expression58=id_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id_expression.add(id_expression58.getTree());
            // Commons.g:188:24: ( ( PERIOD id_expression )=> PERIOD id_expression )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==PERIOD) && (synpred18_Commons())) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Commons.g:188:25: ( PERIOD id_expression )=> PERIOD id_expression
            	    {
            	    PERIOD59=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_type_name1415); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD59);

            	    pushFollow(FOLLOW_id_expression_in_type_name1417);
            	    id_expression60=id_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_id_expression.add(id_expression60.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);



            // AST REWRITE
            // elements: id_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 189:9: -> ^( TYPE_NAME ( id_expression )+ )
            {
                // Commons.g:189:12: ^( TYPE_NAME ( id_expression )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPE_NAME, "TYPE_NAME"), root_1);

                if ( !(stream_id_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 573, type_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "type_name"

    public static class sequence_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sequence_name"
    // Commons.g:192:1: sequence_name : id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( SEQUENCE_NAME ( id_expression )+ ) ;
    public final OracleParser_Commons.sequence_name_return sequence_name() throws RecognitionException {
        OracleParser_Commons.sequence_name_return retval = new OracleParser_Commons.sequence_name_return();
        retval.start = input.LT(1);
        int sequence_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD62=null;
        OracleParser_Commons.id_expression_return id_expression61 = null;

        OracleParser_Commons.id_expression_return id_expression63 = null;


        Object PERIOD62_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 574) ) { return retval; }
            // Commons.g:193:5: ( id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( SEQUENCE_NAME ( id_expression )+ ) )
            // Commons.g:193:10: id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )*
            {
            pushFollow(FOLLOW_id_expression_in_sequence_name1456);
            id_expression61=id_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id_expression.add(id_expression61.getTree());
            // Commons.g:193:24: ( ( PERIOD id_expression )=> PERIOD id_expression )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==PERIOD) && (synpred19_Commons())) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // Commons.g:193:25: ( PERIOD id_expression )=> PERIOD id_expression
            	    {
            	    PERIOD62=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_sequence_name1466); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD62);

            	    pushFollow(FOLLOW_id_expression_in_sequence_name1468);
            	    id_expression63=id_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_id_expression.add(id_expression63.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);



            // AST REWRITE
            // elements: id_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 194:9: -> ^( SEQUENCE_NAME ( id_expression )+ )
            {
                // Commons.g:194:12: ^( SEQUENCE_NAME ( id_expression )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SEQUENCE_NAME, "SEQUENCE_NAME"), root_1);

                if ( !(stream_id_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 574, sequence_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "sequence_name"

    public static class exception_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exception_name"
    // Commons.g:197:1: exception_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( EXCEPTION_NAME id ( id_expression )* ) ;
    public final OracleParser_Commons.exception_name_return exception_name() throws RecognitionException {
        OracleParser_Commons.exception_name_return retval = new OracleParser_Commons.exception_name_return();
        retval.start = input.LT(1);
        int exception_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD65=null;
        OracleParser_Commons.id_return id64 = null;

        OracleParser_Commons.id_expression_return id_expression66 = null;


        Object PERIOD65_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 575) ) { return retval; }
            // Commons.g:198:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( EXCEPTION_NAME id ( id_expression )* ) )
            // Commons.g:198:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )*
            {
            pushFollow(FOLLOW_id_in_exception_name1507);
            id64=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id64.getTree());
            // Commons.g:198:13: ( ( PERIOD id_expression )=> PERIOD id_expression )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==PERIOD) && (synpred20_Commons())) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Commons.g:198:14: ( PERIOD id_expression )=> PERIOD id_expression
            	    {
            	    PERIOD65=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_exception_name1517); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD65);

            	    pushFollow(FOLLOW_id_expression_in_exception_name1519);
            	    id_expression66=id_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_id_expression.add(id_expression66.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);



            // AST REWRITE
            // elements: id, id_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 199:9: -> ^( EXCEPTION_NAME id ( id_expression )* )
            {
                // Commons.g:199:11: ^( EXCEPTION_NAME id ( id_expression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXCEPTION_NAME, "EXCEPTION_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:199:31: ( id_expression )*
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 575, exception_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "exception_name"

    public static class function_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_name"
    // Commons.g:202:1: function_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( FUNCTION_NAME id ( id_expression )* ) ;
    public final OracleParser_Commons.function_name_return function_name() throws RecognitionException {
        OracleParser_Commons.function_name_return retval = new OracleParser_Commons.function_name_return();
        retval.start = input.LT(1);
        int function_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD68=null;
        OracleParser_Commons.id_return id67 = null;

        OracleParser_Commons.id_expression_return id_expression69 = null;


        Object PERIOD68_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 576) ) { return retval; }
            // Commons.g:203:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( FUNCTION_NAME id ( id_expression )* ) )
            // Commons.g:203:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )?
            {
            pushFollow(FOLLOW_id_in_function_name1560);
            id67=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id67.getTree());
            // Commons.g:203:13: ( ( PERIOD id_expression )=> PERIOD id_expression )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==PERIOD) && (synpred21_Commons())) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Commons.g:203:14: ( PERIOD id_expression )=> PERIOD id_expression
                    {
                    PERIOD68=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_function_name1570); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD68);

                    pushFollow(FOLLOW_id_expression_in_function_name1572);
                    id_expression69=id_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id_expression.add(id_expression69.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: id, id_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 204:9: -> ^( FUNCTION_NAME id ( id_expression )* )
            {
                // Commons.g:204:12: ^( FUNCTION_NAME id ( id_expression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_NAME, "FUNCTION_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:204:31: ( id_expression )*
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 576, function_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "function_name"

    public static class procedure_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "procedure_name"
    // Commons.g:207:1: procedure_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( PROCEDURE_NAME id ( id_expression )* ) ;
    public final OracleParser_Commons.procedure_name_return procedure_name() throws RecognitionException {
        OracleParser_Commons.procedure_name_return retval = new OracleParser_Commons.procedure_name_return();
        retval.start = input.LT(1);
        int procedure_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD71=null;
        OracleParser_Commons.id_return id70 = null;

        OracleParser_Commons.id_expression_return id_expression72 = null;


        Object PERIOD71_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 577) ) { return retval; }
            // Commons.g:208:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( PROCEDURE_NAME id ( id_expression )* ) )
            // Commons.g:208:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )?
            {
            pushFollow(FOLLOW_id_in_procedure_name1613);
            id70=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id70.getTree());
            // Commons.g:208:13: ( ( PERIOD id_expression )=> PERIOD id_expression )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==PERIOD) && (synpred22_Commons())) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Commons.g:208:14: ( PERIOD id_expression )=> PERIOD id_expression
                    {
                    PERIOD71=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_procedure_name1623); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD71);

                    pushFollow(FOLLOW_id_expression_in_procedure_name1625);
                    id_expression72=id_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id_expression.add(id_expression72.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: id_expression, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 209:9: -> ^( PROCEDURE_NAME id ( id_expression )* )
            {
                // Commons.g:209:12: ^( PROCEDURE_NAME id ( id_expression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROCEDURE_NAME, "PROCEDURE_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:209:32: ( id_expression )*
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 577, procedure_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "procedure_name"

    public static class trigger_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trigger_name"
    // Commons.g:212:1: trigger_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( TRIGGER_NAME id ( id_expression )* ) ;
    public final OracleParser_Commons.trigger_name_return trigger_name() throws RecognitionException {
        OracleParser_Commons.trigger_name_return retval = new OracleParser_Commons.trigger_name_return();
        retval.start = input.LT(1);
        int trigger_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD74=null;
        OracleParser_Commons.id_return id73 = null;

        OracleParser_Commons.id_expression_return id_expression75 = null;


        Object PERIOD74_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 578) ) { return retval; }
            // Commons.g:213:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( TRIGGER_NAME id ( id_expression )* ) )
            // Commons.g:213:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )?
            {
            pushFollow(FOLLOW_id_in_trigger_name1666);
            id73=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id73.getTree());
            // Commons.g:213:13: ( ( PERIOD id_expression )=> PERIOD id_expression )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==PERIOD) && (synpred23_Commons())) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Commons.g:213:14: ( PERIOD id_expression )=> PERIOD id_expression
                    {
                    PERIOD74=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_trigger_name1676); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD74);

                    pushFollow(FOLLOW_id_expression_in_trigger_name1678);
                    id_expression75=id_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id_expression.add(id_expression75.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: id, id_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 214:9: -> ^( TRIGGER_NAME id ( id_expression )* )
            {
                // Commons.g:214:11: ^( TRIGGER_NAME id ( id_expression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TRIGGER_NAME, "TRIGGER_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:214:29: ( id_expression )*
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 578, trigger_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "trigger_name"

    public static class variable_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_name"
    // Commons.g:217:1: variable_name : ( ( INTRODUCER char_set_name )? id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( VARIABLE_NAME ( char_set_name )? ( id_expression )* ) | bind_variable -> ^( HOSTED_VARIABLE_NAME bind_variable ) );
    public final OracleParser_Commons.variable_name_return variable_name() throws RecognitionException {
        OracleParser_Commons.variable_name_return retval = new OracleParser_Commons.variable_name_return();
        retval.start = input.LT(1);
        int variable_name_StartIndex = input.index();
        Object root_0 = null;

        Token INTRODUCER76=null;
        Token PERIOD79=null;
        OracleParser_Commons.char_set_name_return char_set_name77 = null;

        OracleParser_Commons.id_expression_return id_expression78 = null;

        OracleParser_Commons.id_expression_return id_expression80 = null;

        OracleParser_Commons.bind_variable_return bind_variable81 = null;


        Object INTRODUCER76_tree=null;
        Object PERIOD79_tree=null;
        RewriteRuleTokenStream stream_INTRODUCER=new RewriteRuleTokenStream(adaptor,"token INTRODUCER");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_bind_variable=new RewriteRuleSubtreeStream(adaptor,"rule bind_variable");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        RewriteRuleSubtreeStream stream_char_set_name=new RewriteRuleSubtreeStream(adaptor,"rule char_set_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 579) ) { return retval; }
            // Commons.g:218:5: ( ( INTRODUCER char_set_name )? id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( VARIABLE_NAME ( char_set_name )? ( id_expression )* ) | bind_variable -> ^( HOSTED_VARIABLE_NAME bind_variable ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==DELIMITED_ID||LA26_0==INTRODUCER||LA26_0==REGULAR_ID) ) {
                alt26=1;
            }
            else if ( (LA26_0==COLON||LA26_0==BINDVAR) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // Commons.g:218:10: ( INTRODUCER char_set_name )? id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )?
                    {
                    // Commons.g:218:10: ( INTRODUCER char_set_name )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==INTRODUCER) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // Commons.g:218:11: INTRODUCER char_set_name
                            {
                            INTRODUCER76=(Token)match(input,INTRODUCER,FOLLOW_INTRODUCER_in_variable_name1719); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INTRODUCER.add(INTRODUCER76);

                            pushFollow(FOLLOW_char_set_name_in_variable_name1721);
                            char_set_name77=char_set_name();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_char_set_name.add(char_set_name77.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_id_expression_in_variable_name1737);
                    id_expression78=id_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id_expression.add(id_expression78.getTree());
                    // Commons.g:219:27: ( ( PERIOD id_expression )=> PERIOD id_expression )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==PERIOD) && (synpred25_Commons())) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // Commons.g:219:28: ( PERIOD id_expression )=> PERIOD id_expression
                            {
                            PERIOD79=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_variable_name1747); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD79);

                            pushFollow(FOLLOW_id_expression_in_variable_name1749);
                            id_expression80=id_expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_id_expression.add(id_expression80.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: id_expression, char_set_name
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 220:9: -> ^( VARIABLE_NAME ( char_set_name )? ( id_expression )* )
                    {
                        // Commons.g:220:12: ^( VARIABLE_NAME ( char_set_name )? ( id_expression )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE_NAME, "VARIABLE_NAME"), root_1);

                        // Commons.g:220:28: ( char_set_name )?
                        if ( stream_char_set_name.hasNext() ) {
                            adaptor.addChild(root_1, stream_char_set_name.nextTree());

                        }
                        stream_char_set_name.reset();
                        // Commons.g:220:43: ( id_expression )*
                        while ( stream_id_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_id_expression.nextTree());

                        }
                        stream_id_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Commons.g:221:10: bind_variable
                    {
                    pushFollow(FOLLOW_bind_variable_in_variable_name1782);
                    bind_variable81=bind_variable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_bind_variable.add(bind_variable81.getTree());


                    // AST REWRITE
                    // elements: bind_variable
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 222:9: -> ^( HOSTED_VARIABLE_NAME bind_variable )
                    {
                        // Commons.g:222:12: ^( HOSTED_VARIABLE_NAME bind_variable )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(HOSTED_VARIABLE_NAME, "HOSTED_VARIABLE_NAME"), root_1);

                        adaptor.addChild(root_1, stream_bind_variable.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 579, variable_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "variable_name"

    public static class index_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "index_name"
    // Commons.g:225:1: index_name : id -> ^( INDEX_NAME id ) ;
    public final OracleParser_Commons.index_name_return index_name() throws RecognitionException {
        OracleParser_Commons.index_name_return retval = new OracleParser_Commons.index_name_return();
        retval.start = input.LT(1);
        int index_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id82 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 580) ) { return retval; }
            // Commons.g:226:5: ( id -> ^( INDEX_NAME id ) )
            // Commons.g:226:10: id
            {
            pushFollow(FOLLOW_id_in_index_name1818);
            id82=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id82.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 227:9: -> ^( INDEX_NAME id )
            {
                // Commons.g:227:12: ^( INDEX_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INDEX_NAME, "INDEX_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 580, index_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "index_name"

    public static class cursor_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cursor_name"
    // Commons.g:230:1: cursor_name : ( id | bind_variable ) -> ^( CURSOR_NAME ( id )? ( bind_variable )? ) ;
    public final OracleParser_Commons.cursor_name_return cursor_name() throws RecognitionException {
        OracleParser_Commons.cursor_name_return retval = new OracleParser_Commons.cursor_name_return();
        retval.start = input.LT(1);
        int cursor_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id83 = null;

        OracleParser_Commons.bind_variable_return bind_variable84 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_bind_variable=new RewriteRuleSubtreeStream(adaptor,"rule bind_variable");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 581) ) { return retval; }
            // Commons.g:231:5: ( ( id | bind_variable ) -> ^( CURSOR_NAME ( id )? ( bind_variable )? ) )
            // Commons.g:231:10: ( id | bind_variable )
            {
            // Commons.g:231:10: ( id | bind_variable )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==DELIMITED_ID||LA27_0==INTRODUCER||LA27_0==REGULAR_ID) ) {
                alt27=1;
            }
            else if ( (LA27_0==COLON||LA27_0==BINDVAR) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // Commons.g:231:11: id
                    {
                    pushFollow(FOLLOW_id_in_cursor_name1855);
                    id83=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id83.getTree());

                    }
                    break;
                case 2 :
                    // Commons.g:231:16: bind_variable
                    {
                    pushFollow(FOLLOW_bind_variable_in_cursor_name1859);
                    bind_variable84=bind_variable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_bind_variable.add(bind_variable84.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: id, bind_variable
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 232:9: -> ^( CURSOR_NAME ( id )? ( bind_variable )? )
            {
                // Commons.g:232:12: ^( CURSOR_NAME ( id )? ( bind_variable )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CURSOR_NAME, "CURSOR_NAME"), root_1);

                // Commons.g:232:26: ( id )?
                if ( stream_id.hasNext() ) {
                    adaptor.addChild(root_1, stream_id.nextTree());

                }
                stream_id.reset();
                // Commons.g:232:30: ( bind_variable )?
                if ( stream_bind_variable.hasNext() ) {
                    adaptor.addChild(root_1, stream_bind_variable.nextTree());

                }
                stream_bind_variable.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 581, cursor_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "cursor_name"

    public static class record_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "record_name"
    // Commons.g:235:1: record_name : ( id | bind_variable ) -> ^( RECORD_NAME id ) ;
    public final OracleParser_Commons.record_name_return record_name() throws RecognitionException {
        OracleParser_Commons.record_name_return retval = new OracleParser_Commons.record_name_return();
        retval.start = input.LT(1);
        int record_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id85 = null;

        OracleParser_Commons.bind_variable_return bind_variable86 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_bind_variable=new RewriteRuleSubtreeStream(adaptor,"rule bind_variable");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 582) ) { return retval; }
            // Commons.g:236:5: ( ( id | bind_variable ) -> ^( RECORD_NAME id ) )
            // Commons.g:236:10: ( id | bind_variable )
            {
            // Commons.g:236:10: ( id | bind_variable )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==DELIMITED_ID||LA28_0==INTRODUCER||LA28_0==REGULAR_ID) ) {
                alt28=1;
            }
            else if ( (LA28_0==COLON||LA28_0==BINDVAR) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // Commons.g:236:11: id
                    {
                    pushFollow(FOLLOW_id_in_record_name1901);
                    id85=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id85.getTree());

                    }
                    break;
                case 2 :
                    // Commons.g:236:16: bind_variable
                    {
                    pushFollow(FOLLOW_bind_variable_in_record_name1905);
                    bind_variable86=bind_variable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_bind_variable.add(bind_variable86.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 237:9: -> ^( RECORD_NAME id )
            {
                // Commons.g:237:11: ^( RECORD_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RECORD_NAME, "RECORD_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 582, record_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "record_name"

    public static class collection_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "collection_name"
    // Commons.g:240:1: collection_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( COLLECTION_NAME id ( id_expression )? ) ;
    public final OracleParser_Commons.collection_name_return collection_name() throws RecognitionException {
        OracleParser_Commons.collection_name_return retval = new OracleParser_Commons.collection_name_return();
        retval.start = input.LT(1);
        int collection_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD88=null;
        OracleParser_Commons.id_return id87 = null;

        OracleParser_Commons.id_expression_return id_expression89 = null;


        Object PERIOD88_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 583) ) { return retval; }
            // Commons.g:241:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )? -> ^( COLLECTION_NAME id ( id_expression )? ) )
            // Commons.g:241:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )?
            {
            pushFollow(FOLLOW_id_in_collection_name1941);
            id87=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id87.getTree());
            // Commons.g:241:13: ( ( PERIOD id_expression )=> PERIOD id_expression )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==PERIOD) && (synpred29_Commons())) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // Commons.g:241:14: ( PERIOD id_expression )=> PERIOD id_expression
                    {
                    PERIOD88=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_collection_name1951); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD88);

                    pushFollow(FOLLOW_id_expression_in_collection_name1953);
                    id_expression89=id_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id_expression.add(id_expression89.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: id, id_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 242:9: -> ^( COLLECTION_NAME id ( id_expression )? )
            {
                // Commons.g:242:11: ^( COLLECTION_NAME id ( id_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COLLECTION_NAME, "COLLECTION_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:242:32: ( id_expression )?
                if ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 583, collection_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "collection_name"

    public static class link_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "link_name"
    // Commons.g:245:1: link_name : id -> ^( LINK_NAME id ) ;
    public final OracleParser_Commons.link_name_return link_name() throws RecognitionException {
        OracleParser_Commons.link_name_return retval = new OracleParser_Commons.link_name_return();
        retval.start = input.LT(1);
        int link_name_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.id_return id90 = null;


        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 584) ) { return retval; }
            // Commons.g:246:5: ( id -> ^( LINK_NAME id ) )
            // Commons.g:246:10: id
            {
            pushFollow(FOLLOW_id_in_link_name1993);
            id90=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id90.getTree());


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 247:9: -> ^( LINK_NAME id )
            {
                // Commons.g:247:12: ^( LINK_NAME id )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LINK_NAME, "LINK_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 584, link_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "link_name"

    public static class column_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "column_name"
    // Commons.g:250:1: column_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( COLUMN_NAME id ( id_expression )* ) ;
    public final OracleParser_Commons.column_name_return column_name() throws RecognitionException {
        OracleParser_Commons.column_name_return retval = new OracleParser_Commons.column_name_return();
        retval.start = input.LT(1);
        int column_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD92=null;
        OracleParser_Commons.id_return id91 = null;

        OracleParser_Commons.id_expression_return id_expression93 = null;


        Object PERIOD92_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 585) ) { return retval; }
            // Commons.g:251:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( COLUMN_NAME id ( id_expression )* ) )
            // Commons.g:251:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )*
            {
            pushFollow(FOLLOW_id_in_column_name2029);
            id91=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id91.getTree());
            // Commons.g:251:13: ( ( PERIOD id_expression )=> PERIOD id_expression )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==PERIOD) && (synpred30_Commons())) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // Commons.g:251:14: ( PERIOD id_expression )=> PERIOD id_expression
            	    {
            	    PERIOD92=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_column_name2039); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD92);

            	    pushFollow(FOLLOW_id_expression_in_column_name2041);
            	    id_expression93=id_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_id_expression.add(id_expression93.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);



            // AST REWRITE
            // elements: id_expression, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 252:9: -> ^( COLUMN_NAME id ( id_expression )* )
            {
                // Commons.g:252:12: ^( COLUMN_NAME id ( id_expression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COLUMN_NAME, "COLUMN_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:252:29: ( id_expression )*
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 585, column_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "column_name"

    public static class tableview_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tableview_name"
    // Commons.g:255:1: tableview_name : id ( ( PERIOD id_expression )=> PERIOD id_expression )? ( AT_SIGN link_name | {...}? => partition_extension_clause )? -> ^( TABLEVIEW_NAME id ( id_expression )? ( link_name )? ( partition_extension_clause )? ) ;
    public final OracleParser_Commons.tableview_name_return tableview_name() throws RecognitionException {
        OracleParser_Commons.tableview_name_return retval = new OracleParser_Commons.tableview_name_return();
        retval.start = input.LT(1);
        int tableview_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD95=null;
        Token AT_SIGN97=null;
        OracleParser_Commons.id_return id94 = null;

        OracleParser_Commons.id_expression_return id_expression96 = null;

        OracleParser_Commons.link_name_return link_name98 = null;

        OracleParser_Commons.partition_extension_clause_return partition_extension_clause99 = null;


        Object PERIOD95_tree=null;
        Object AT_SIGN97_tree=null;
        RewriteRuleTokenStream stream_AT_SIGN=new RewriteRuleTokenStream(adaptor,"token AT_SIGN");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_partition_extension_clause=new RewriteRuleSubtreeStream(adaptor,"rule partition_extension_clause");
        RewriteRuleSubtreeStream stream_link_name=new RewriteRuleSubtreeStream(adaptor,"rule link_name");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 586) ) { return retval; }
            // Commons.g:256:5: ( id ( ( PERIOD id_expression )=> PERIOD id_expression )? ( AT_SIGN link_name | {...}? => partition_extension_clause )? -> ^( TABLEVIEW_NAME id ( id_expression )? ( link_name )? ( partition_extension_clause )? ) )
            // Commons.g:256:10: id ( ( PERIOD id_expression )=> PERIOD id_expression )? ( AT_SIGN link_name | {...}? => partition_extension_clause )?
            {
            pushFollow(FOLLOW_id_in_tableview_name2082);
            id94=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id94.getTree());
            // Commons.g:256:13: ( ( PERIOD id_expression )=> PERIOD id_expression )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==PERIOD) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==REGULAR_ID) && (synpred31_Commons())) {
                    alt31=1;
                }
                else if ( (LA31_1==DELIMITED_ID) && (synpred31_Commons())) {
                    alt31=1;
                }
            }
            switch (alt31) {
                case 1 :
                    // Commons.g:256:14: ( PERIOD id_expression )=> PERIOD id_expression
                    {
                    PERIOD95=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_tableview_name2092); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD95);

                    pushFollow(FOLLOW_id_expression_in_tableview_name2094);
                    id_expression96=id_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id_expression.add(id_expression96.getTree());

                    }
                    break;

            }

            // Commons.g:257:5: ( AT_SIGN link_name | {...}? => partition_extension_clause )?
            int alt32=3;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // Commons.g:257:10: AT_SIGN link_name
                    {
                    AT_SIGN97=(Token)match(input,AT_SIGN,FOLLOW_AT_SIGN_in_tableview_name2108); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AT_SIGN.add(AT_SIGN97);

                    pushFollow(FOLLOW_link_name_in_tableview_name2110);
                    link_name98=link_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_link_name.add(link_name98.getTree());

                    }
                    break;
                case 2 :
                    // Commons.g:258:10: {...}? => partition_extension_clause
                    {
                    if ( !((!(input.LA(2) == SQL92_RESERVED_BY))) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "tableview_name", "!(input.LA(2) == SQL92_RESERVED_BY)");
                    }
                    pushFollow(FOLLOW_partition_extension_clause_in_tableview_name2124);
                    partition_extension_clause99=partition_extension_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_partition_extension_clause.add(partition_extension_clause99.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: partition_extension_clause, id_expression, link_name, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 260:9: -> ^( TABLEVIEW_NAME id ( id_expression )? ( link_name )? ( partition_extension_clause )? )
            {
                // Commons.g:260:12: ^( TABLEVIEW_NAME id ( id_expression )? ( link_name )? ( partition_extension_clause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TABLEVIEW_NAME, "TABLEVIEW_NAME"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // Commons.g:260:32: ( id_expression )?
                if ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();
                // Commons.g:260:47: ( link_name )?
                if ( stream_link_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_link_name.nextTree());

                }
                stream_link_name.reset();
                // Commons.g:260:58: ( partition_extension_clause )?
                if ( stream_partition_extension_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_partition_extension_clause.nextTree());

                }
                stream_partition_extension_clause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 586, tableview_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "tableview_name"

    public static class char_set_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "char_set_name"
    // Commons.g:263:1: char_set_name : id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( CHAR_SET_NAME ( id_expression )+ ) ;
    public final OracleParser_Commons.char_set_name_return char_set_name() throws RecognitionException {
        OracleParser_Commons.char_set_name_return retval = new OracleParser_Commons.char_set_name_return();
        retval.start = input.LT(1);
        int char_set_name_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD101=null;
        OracleParser_Commons.id_expression_return id_expression100 = null;

        OracleParser_Commons.id_expression_return id_expression102 = null;


        Object PERIOD101_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 587) ) { return retval; }
            // Commons.g:264:5: ( id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )* -> ^( CHAR_SET_NAME ( id_expression )+ ) )
            // Commons.g:264:10: id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )*
            {
            pushFollow(FOLLOW_id_expression_in_char_set_name2176);
            id_expression100=id_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id_expression.add(id_expression100.getTree());
            // Commons.g:264:24: ( ( PERIOD id_expression )=> PERIOD id_expression )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==PERIOD) && (synpred34_Commons())) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // Commons.g:264:25: ( PERIOD id_expression )=> PERIOD id_expression
            	    {
            	    PERIOD101=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_char_set_name2186); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD101);

            	    pushFollow(FOLLOW_id_expression_in_char_set_name2188);
            	    id_expression102=id_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_id_expression.add(id_expression102.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);



            // AST REWRITE
            // elements: id_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 265:9: -> ^( CHAR_SET_NAME ( id_expression )+ )
            {
                // Commons.g:265:11: ^( CHAR_SET_NAME ( id_expression )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CHAR_SET_NAME, "CHAR_SET_NAME"), root_1);

                if ( !(stream_id_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 587, char_set_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "char_set_name"

    public static class keep_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keep_clause"
    // Commons.g:273:1: keep_clause : keep_key LEFT_PAREN dense_rank_key ( first_key | last_key ) order_by_clause RIGHT_PAREN ( over_clause )? ;
    public final OracleParser_Commons.keep_clause_return keep_clause() throws RecognitionException {
        OracleParser_Commons.keep_clause_return retval = new OracleParser_Commons.keep_clause_return();
        retval.start = input.LT(1);
        int keep_clause_StartIndex = input.index();
        Object root_0 = null;

        Token LEFT_PAREN104=null;
        Token RIGHT_PAREN109=null;
        OracleParser_Keys.keep_key_return keep_key103 = null;

        OracleParser_Keys.dense_rank_key_return dense_rank_key105 = null;

        OracleParser_Keys.first_key_return first_key106 = null;

        OracleParser_Keys.last_key_return last_key107 = null;

        OracleParser.order_by_clause_return order_by_clause108 = null;

        OracleParser.over_clause_return over_clause110 = null;


        Object LEFT_PAREN104_tree=null;
        Object RIGHT_PAREN109_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 588) ) { return retval; }
            // Commons.g:274:5: ( keep_key LEFT_PAREN dense_rank_key ( first_key | last_key ) order_by_clause RIGHT_PAREN ( over_clause )? )
            // Commons.g:274:9: keep_key LEFT_PAREN dense_rank_key ( first_key | last_key ) order_by_clause RIGHT_PAREN ( over_clause )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_keep_key_in_keep_clause2230);
            keep_key103=gOracleParser.keep_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(keep_key103.getTree(), root_0);
            LEFT_PAREN104=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_keep_clause2241); if (state.failed) return retval;
            pushFollow(FOLLOW_dense_rank_key_in_keep_clause2256);
            dense_rank_key105=gOracleParser.dense_rank_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dense_rank_key105.getTree());
            // Commons.g:276:28: ( first_key | last_key )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==REGULAR_ID) && ((input.LT(1).getText().equalsIgnoreCase("last")))) {
                int LA34_1 = input.LA(2);

                if ( ((synpred35_Commons()&&(input.LT(1).getText().equalsIgnoreCase("first")))) ) {
                    alt34=1;
                }
                else if ( ((input.LT(1).getText().equalsIgnoreCase("last"))) ) {
                    alt34=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // Commons.g:276:29: first_key
                    {
                    pushFollow(FOLLOW_first_key_in_keep_clause2259);
                    first_key106=gOracleParser.first_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, first_key106.getTree());

                    }
                    break;
                case 2 :
                    // Commons.g:276:39: last_key
                    {
                    pushFollow(FOLLOW_last_key_in_keep_clause2261);
                    last_key107=gOracleParser.last_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, last_key107.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_order_by_clause_in_keep_clause2277);
            order_by_clause108=gOracleParser.order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, order_by_clause108.getTree());
            RIGHT_PAREN109=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_keep_clause2287); if (state.failed) return retval;
            // Commons.g:278:22: ( over_clause )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // Commons.g:0:0: over_clause
                    {
                    pushFollow(FOLLOW_over_clause_in_keep_clause2290);
                    over_clause110=gOracleParser.over_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, over_clause110.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 588, keep_clause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "keep_clause"

    public static class function_argument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_argument"
    // Commons.g:281:1: function_argument : LEFT_PAREN ( argument )? ( COMMA argument )* RIGHT_PAREN ( keep_clause )? -> ^( ARGUMENTS ( argument )* ( keep_clause )? ) ;
    public final OracleParser_Commons.function_argument_return function_argument() throws RecognitionException {
        OracleParser_Commons.function_argument_return retval = new OracleParser_Commons.function_argument_return();
        retval.start = input.LT(1);
        int function_argument_StartIndex = input.index();
        Object root_0 = null;

        Token LEFT_PAREN111=null;
        Token COMMA113=null;
        Token RIGHT_PAREN115=null;
        OracleParser_Commons.argument_return argument112 = null;

        OracleParser_Commons.argument_return argument114 = null;

        OracleParser_Commons.keep_clause_return keep_clause116 = null;


        Object LEFT_PAREN111_tree=null;
        Object COMMA113_tree=null;
        Object RIGHT_PAREN115_tree=null;
        RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
        RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_argument=new RewriteRuleSubtreeStream(adaptor,"rule argument");
        RewriteRuleSubtreeStream stream_keep_clause=new RewriteRuleSubtreeStream(adaptor,"rule keep_clause");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 589) ) { return retval; }
            // Commons.g:282:5: ( LEFT_PAREN ( argument )? ( COMMA argument )* RIGHT_PAREN ( keep_clause )? -> ^( ARGUMENTS ( argument )* ( keep_clause )? ) )
            // Commons.g:282:10: LEFT_PAREN ( argument )? ( COMMA argument )* RIGHT_PAREN ( keep_clause )?
            {
            LEFT_PAREN111=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_function_argument2311); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN111);

            // Commons.g:283:13: ( argument )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=UNSIGNED_INTEGER && LA36_0<=MINUS_SIGN)||LA36_0==NATIONAL_CHAR_STRING_LIT||(LA36_0>=EXACT_NUM_LIT && LA36_0<=CHAR_STRING)||LA36_0==CHAR_STRING_PERL||LA36_0==DELIMITED_ID||LA36_0==LEFT_PAREN||LA36_0==PLUS_SIGN||LA36_0==COLON||LA36_0==BINDVAR||LA36_0==INTRODUCER||LA36_0==SQL92_RESERVED_ALL||LA36_0==SQL92_RESERVED_ANY||LA36_0==SQL92_RESERVED_CASE||LA36_0==PLSQL_NON_RESERVED_CONNECT_BY_ROOT||(LA36_0>=SQL92_RESERVED_CURSOR && LA36_0<=SQL92_RESERVED_DATE)||LA36_0==SQL92_RESERVED_DEFAULT||LA36_0==SQL92_RESERVED_DISTINCT||(LA36_0>=SQL92_RESERVED_EXISTS && LA36_0<=SQL92_RESERVED_FALSE)||LA36_0==SQL92_RESERVED_NOT||LA36_0==SQL92_RESERVED_NULL||LA36_0==SQL92_RESERVED_PRIOR||LA36_0==SQL92_RESERVED_TRUE||LA36_0==REGULAR_ID) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // Commons.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_function_argument2326);
                    argument112=argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_argument.add(argument112.getTree());

                    }
                    break;

            }

            // Commons.g:283:23: ( COMMA argument )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==COMMA) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // Commons.g:283:24: COMMA argument
            	    {
            	    COMMA113=(Token)match(input,COMMA,FOLLOW_COMMA_in_function_argument2330); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA113);

            	    pushFollow(FOLLOW_argument_in_function_argument2332);
            	    argument114=argument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_argument.add(argument114.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            RIGHT_PAREN115=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_function_argument2346); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN115);

            // Commons.g:285:9: ( keep_clause )?
            int alt38=2;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // Commons.g:0:0: keep_clause
                    {
                    pushFollow(FOLLOW_keep_clause_in_function_argument2356);
                    keep_clause116=keep_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keep_clause.add(keep_clause116.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: keep_clause, argument
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 286:9: -> ^( ARGUMENTS ( argument )* ( keep_clause )? )
            {
                // Commons.g:286:12: ^( ARGUMENTS ( argument )* ( keep_clause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENTS, "ARGUMENTS"), root_1);

                // Commons.g:286:24: ( argument )*
                while ( stream_argument.hasNext() ) {
                    adaptor.addChild(root_1, stream_argument.nextTree());

                }
                stream_argument.reset();
                // Commons.g:286:34: ( keep_clause )?
                if ( stream_keep_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_keep_clause.nextTree());

                }
                stream_keep_clause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 589, function_argument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "function_argument"

    public static class function_argument_analytic_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_argument_analytic"
    // Commons.g:289:1: function_argument_analytic : LEFT_PAREN ( argument ( respect_or_ignore_nulls )? )? ( COMMA argument ( respect_or_ignore_nulls )? )* RIGHT_PAREN ( keep_clause )? -> ^( ARGUMENTS ( argument )* ( keep_clause )? ) ;
    public final OracleParser_Commons.function_argument_analytic_return function_argument_analytic() throws RecognitionException {
        OracleParser_Commons.function_argument_analytic_return retval = new OracleParser_Commons.function_argument_analytic_return();
        retval.start = input.LT(1);
        int function_argument_analytic_StartIndex = input.index();
        Object root_0 = null;

        Token LEFT_PAREN117=null;
        Token COMMA120=null;
        Token RIGHT_PAREN123=null;
        OracleParser_Commons.argument_return argument118 = null;

        OracleParser_Commons.respect_or_ignore_nulls_return respect_or_ignore_nulls119 = null;

        OracleParser_Commons.argument_return argument121 = null;

        OracleParser_Commons.respect_or_ignore_nulls_return respect_or_ignore_nulls122 = null;

        OracleParser_Commons.keep_clause_return keep_clause124 = null;


        Object LEFT_PAREN117_tree=null;
        Object COMMA120_tree=null;
        Object RIGHT_PAREN123_tree=null;
        RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
        RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_argument=new RewriteRuleSubtreeStream(adaptor,"rule argument");
        RewriteRuleSubtreeStream stream_respect_or_ignore_nulls=new RewriteRuleSubtreeStream(adaptor,"rule respect_or_ignore_nulls");
        RewriteRuleSubtreeStream stream_keep_clause=new RewriteRuleSubtreeStream(adaptor,"rule keep_clause");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 590) ) { return retval; }
            // Commons.g:290:5: ( LEFT_PAREN ( argument ( respect_or_ignore_nulls )? )? ( COMMA argument ( respect_or_ignore_nulls )? )* RIGHT_PAREN ( keep_clause )? -> ^( ARGUMENTS ( argument )* ( keep_clause )? ) )
            // Commons.g:290:10: LEFT_PAREN ( argument ( respect_or_ignore_nulls )? )? ( COMMA argument ( respect_or_ignore_nulls )? )* RIGHT_PAREN ( keep_clause )?
            {
            LEFT_PAREN117=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_function_argument_analytic2397); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN117);

            // Commons.g:291:13: ( argument ( respect_or_ignore_nulls )? )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=UNSIGNED_INTEGER && LA40_0<=MINUS_SIGN)||LA40_0==NATIONAL_CHAR_STRING_LIT||(LA40_0>=EXACT_NUM_LIT && LA40_0<=CHAR_STRING)||LA40_0==CHAR_STRING_PERL||LA40_0==DELIMITED_ID||LA40_0==LEFT_PAREN||LA40_0==PLUS_SIGN||LA40_0==COLON||LA40_0==BINDVAR||LA40_0==INTRODUCER||LA40_0==SQL92_RESERVED_ALL||LA40_0==SQL92_RESERVED_ANY||LA40_0==SQL92_RESERVED_CASE||LA40_0==PLSQL_NON_RESERVED_CONNECT_BY_ROOT||(LA40_0>=SQL92_RESERVED_CURSOR && LA40_0<=SQL92_RESERVED_DATE)||LA40_0==SQL92_RESERVED_DEFAULT||LA40_0==SQL92_RESERVED_DISTINCT||(LA40_0>=SQL92_RESERVED_EXISTS && LA40_0<=SQL92_RESERVED_FALSE)||LA40_0==SQL92_RESERVED_NOT||LA40_0==SQL92_RESERVED_NULL||LA40_0==SQL92_RESERVED_PRIOR||LA40_0==SQL92_RESERVED_TRUE||LA40_0==REGULAR_ID) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // Commons.g:291:14: argument ( respect_or_ignore_nulls )?
                    {
                    pushFollow(FOLLOW_argument_in_function_argument_analytic2412);
                    argument118=argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_argument.add(argument118.getTree());
                    // Commons.g:291:23: ( respect_or_ignore_nulls )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==REGULAR_ID) && (((input.LT(1).getText().equalsIgnoreCase("respect"))||(input.LT(1).getText().equalsIgnoreCase("ignore"))))) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // Commons.g:0:0: respect_or_ignore_nulls
                            {
                            pushFollow(FOLLOW_respect_or_ignore_nulls_in_function_argument_analytic2414);
                            respect_or_ignore_nulls119=respect_or_ignore_nulls();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_respect_or_ignore_nulls.add(respect_or_ignore_nulls119.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            // Commons.g:292:13: ( COMMA argument ( respect_or_ignore_nulls )? )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==COMMA) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // Commons.g:292:14: COMMA argument ( respect_or_ignore_nulls )?
            	    {
            	    COMMA120=(Token)match(input,COMMA,FOLLOW_COMMA_in_function_argument_analytic2432); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA120);

            	    pushFollow(FOLLOW_argument_in_function_argument_analytic2434);
            	    argument121=argument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_argument.add(argument121.getTree());
            	    // Commons.g:292:29: ( respect_or_ignore_nulls )?
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( (LA41_0==REGULAR_ID) && (((input.LT(1).getText().equalsIgnoreCase("respect"))||(input.LT(1).getText().equalsIgnoreCase("ignore"))))) {
            	        alt41=1;
            	    }
            	    switch (alt41) {
            	        case 1 :
            	            // Commons.g:0:0: respect_or_ignore_nulls
            	            {
            	            pushFollow(FOLLOW_respect_or_ignore_nulls_in_function_argument_analytic2436);
            	            respect_or_ignore_nulls122=respect_or_ignore_nulls();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_respect_or_ignore_nulls.add(respect_or_ignore_nulls122.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            RIGHT_PAREN123=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_function_argument_analytic2451); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN123);

            // Commons.g:294:10: ( keep_clause )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==REGULAR_ID) && (((input.LT(1).getText().equalsIgnoreCase("over"))||(input.LT(1).getText().equalsIgnoreCase("respect"))||(input.LT(1).getText().equalsIgnoreCase("ignore"))))) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==LEFT_PAREN) && ((input.LT(1).getText().equalsIgnoreCase("over")))) {
                    int LA43_3 = input.LA(3);

                    if ( (LA43_3==REGULAR_ID) && ((input.LT(1).getText().equalsIgnoreCase("over")))) {
                        int LA43_4 = input.LA(4);

                        if ( (LA43_4==REGULAR_ID) && ((input.LT(1).getText().equalsIgnoreCase("keep")))) {
                            alt43=1;
                        }
                    }
                }
            }
            switch (alt43) {
                case 1 :
                    // Commons.g:0:0: keep_clause
                    {
                    pushFollow(FOLLOW_keep_clause_in_function_argument_analytic2462);
                    keep_clause124=keep_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keep_clause.add(keep_clause124.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: argument, keep_clause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 295:10: -> ^( ARGUMENTS ( argument )* ( keep_clause )? )
            {
                // Commons.g:295:13: ^( ARGUMENTS ( argument )* ( keep_clause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENTS, "ARGUMENTS"), root_1);

                // Commons.g:295:25: ( argument )*
                while ( stream_argument.hasNext() ) {
                    adaptor.addChild(root_1, stream_argument.nextTree());

                }
                stream_argument.reset();
                // Commons.g:295:35: ( keep_clause )?
                if ( stream_keep_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_keep_clause.nextTree());

                }
                stream_keep_clause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 590, function_argument_analytic_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "function_argument_analytic"

    public static class function_argument_modeling_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_argument_modeling"
    // Commons.g:298:1: function_argument_modeling : LEFT_PAREN column_name ( COMMA ( numeric | null_key ) ( COMMA ( numeric | null_key ) )? )? using_key ( ( tableview_name PERIOD ASTERISK )=> tableview_name PERIOD ASTERISK | ASTERISK | expression ( column_alias )? ( COMMA expression ( column_alias )? )* ) RIGHT_PAREN ( keep_clause )? -> ^( ARGUMENTS column_name ( keep_clause )? ) ;
    public final OracleParser_Commons.function_argument_modeling_return function_argument_modeling() throws RecognitionException {
        OracleParser_Commons.function_argument_modeling_return retval = new OracleParser_Commons.function_argument_modeling_return();
        retval.start = input.LT(1);
        int function_argument_modeling_StartIndex = input.index();
        Object root_0 = null;

        Token LEFT_PAREN125=null;
        Token COMMA127=null;
        Token COMMA130=null;
        Token PERIOD135=null;
        Token ASTERISK136=null;
        Token ASTERISK137=null;
        Token COMMA140=null;
        Token RIGHT_PAREN143=null;
        OracleParser_Commons.column_name_return column_name126 = null;

        OracleParser_Commons.numeric_return numeric128 = null;

        OracleParser_Keys.null_key_return null_key129 = null;

        OracleParser_Commons.numeric_return numeric131 = null;

        OracleParser_Keys.null_key_return null_key132 = null;

        OracleParser_Keys.using_key_return using_key133 = null;

        OracleParser_Commons.tableview_name_return tableview_name134 = null;

        OracleParser.expression_return expression138 = null;

        OracleParser_Commons.column_alias_return column_alias139 = null;

        OracleParser.expression_return expression141 = null;

        OracleParser_Commons.column_alias_return column_alias142 = null;

        OracleParser_Commons.keep_clause_return keep_clause144 = null;


        Object LEFT_PAREN125_tree=null;
        Object COMMA127_tree=null;
        Object COMMA130_tree=null;
        Object PERIOD135_tree=null;
        Object ASTERISK136_tree=null;
        Object ASTERISK137_tree=null;
        Object COMMA140_tree=null;
        Object RIGHT_PAREN143_tree=null;
        RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
        RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleTokenStream stream_ASTERISK=new RewriteRuleTokenStream(adaptor,"token ASTERISK");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_using_key=new RewriteRuleSubtreeStream(adaptor,"rule using_key");
        RewriteRuleSubtreeStream stream_numeric=new RewriteRuleSubtreeStream(adaptor,"rule numeric");
        RewriteRuleSubtreeStream stream_null_key=new RewriteRuleSubtreeStream(adaptor,"rule null_key");
        RewriteRuleSubtreeStream stream_column_alias=new RewriteRuleSubtreeStream(adaptor,"rule column_alias");
        RewriteRuleSubtreeStream stream_keep_clause=new RewriteRuleSubtreeStream(adaptor,"rule keep_clause");
        RewriteRuleSubtreeStream stream_column_name=new RewriteRuleSubtreeStream(adaptor,"rule column_name");
        RewriteRuleSubtreeStream stream_tableview_name=new RewriteRuleSubtreeStream(adaptor,"rule tableview_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 591) ) { return retval; }
            // Commons.g:299:5: ( LEFT_PAREN column_name ( COMMA ( numeric | null_key ) ( COMMA ( numeric | null_key ) )? )? using_key ( ( tableview_name PERIOD ASTERISK )=> tableview_name PERIOD ASTERISK | ASTERISK | expression ( column_alias )? ( COMMA expression ( column_alias )? )* ) RIGHT_PAREN ( keep_clause )? -> ^( ARGUMENTS column_name ( keep_clause )? ) )
            // Commons.g:299:10: LEFT_PAREN column_name ( COMMA ( numeric | null_key ) ( COMMA ( numeric | null_key ) )? )? using_key ( ( tableview_name PERIOD ASTERISK )=> tableview_name PERIOD ASTERISK | ASTERISK | expression ( column_alias )? ( COMMA expression ( column_alias )? )* ) RIGHT_PAREN ( keep_clause )?
            {
            LEFT_PAREN125=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_function_argument_modeling2504); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN125);

            pushFollow(FOLLOW_column_name_in_function_argument_modeling2518);
            column_name126=column_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_column_name.add(column_name126.getTree());
            // Commons.g:300:25: ( COMMA ( numeric | null_key ) ( COMMA ( numeric | null_key ) )? )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==COMMA) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // Commons.g:300:26: COMMA ( numeric | null_key ) ( COMMA ( numeric | null_key ) )?
                    {
                    COMMA127=(Token)match(input,COMMA,FOLLOW_COMMA_in_function_argument_modeling2521); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMA.add(COMMA127);

                    // Commons.g:300:32: ( numeric | null_key )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( ((LA44_0>=UNSIGNED_INTEGER && LA44_0<=APPROXIMATE_NUM_LIT)||LA44_0==EXACT_NUM_LIT) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==SQL92_RESERVED_NULL) ) {
                        alt44=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // Commons.g:300:33: numeric
                            {
                            pushFollow(FOLLOW_numeric_in_function_argument_modeling2524);
                            numeric128=numeric();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_numeric.add(numeric128.getTree());

                            }
                            break;
                        case 2 :
                            // Commons.g:300:41: null_key
                            {
                            pushFollow(FOLLOW_null_key_in_function_argument_modeling2526);
                            null_key129=gOracleParser.null_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_null_key.add(null_key129.getTree());

                            }
                            break;

                    }

                    // Commons.g:300:51: ( COMMA ( numeric | null_key ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==COMMA) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // Commons.g:300:52: COMMA ( numeric | null_key )
                            {
                            COMMA130=(Token)match(input,COMMA,FOLLOW_COMMA_in_function_argument_modeling2530); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA130);

                            // Commons.g:300:58: ( numeric | null_key )
                            int alt45=2;
                            int LA45_0 = input.LA(1);

                            if ( ((LA45_0>=UNSIGNED_INTEGER && LA45_0<=APPROXIMATE_NUM_LIT)||LA45_0==EXACT_NUM_LIT) ) {
                                alt45=1;
                            }
                            else if ( (LA45_0==SQL92_RESERVED_NULL) ) {
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
                                    // Commons.g:300:59: numeric
                                    {
                                    pushFollow(FOLLOW_numeric_in_function_argument_modeling2533);
                                    numeric131=numeric();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_numeric.add(numeric131.getTree());

                                    }
                                    break;
                                case 2 :
                                    // Commons.g:300:67: null_key
                                    {
                                    pushFollow(FOLLOW_null_key_in_function_argument_modeling2535);
                                    null_key132=gOracleParser.null_key();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_null_key.add(null_key132.getTree());

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_using_key_in_function_argument_modeling2556);
            using_key133=gOracleParser.using_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_using_key.add(using_key133.getTree());
            // Commons.g:302:17: ( ( tableview_name PERIOD ASTERISK )=> tableview_name PERIOD ASTERISK | ASTERISK | expression ( column_alias )? ( COMMA expression ( column_alias )? )* )
            int alt51=3;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // Commons.g:302:19: ( tableview_name PERIOD ASTERISK )=> tableview_name PERIOD ASTERISK
                    {
                    pushFollow(FOLLOW_tableview_name_in_function_argument_modeling2585);
                    tableview_name134=tableview_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tableview_name.add(tableview_name134.getTree());
                    PERIOD135=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_function_argument_modeling2587); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD135);

                    ASTERISK136=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_function_argument_modeling2589); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASTERISK.add(ASTERISK136);


                    }
                    break;
                case 2 :
                    // Commons.g:303:19: ASTERISK
                    {
                    ASTERISK137=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_function_argument_modeling2609); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASTERISK.add(ASTERISK137);


                    }
                    break;
                case 3 :
                    // Commons.g:304:19: expression ( column_alias )? ( COMMA expression ( column_alias )? )*
                    {
                    pushFollow(FOLLOW_expression_in_function_argument_modeling2629);
                    expression138=gOracleParser.expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression138.getTree());
                    // Commons.g:304:30: ( column_alias )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==NATIONAL_CHAR_STRING_LIT||LA48_0==CHAR_STRING||LA48_0==CHAR_STRING_PERL||LA48_0==DELIMITED_ID||LA48_0==INTRODUCER||LA48_0==SQL92_RESERVED_AS||LA48_0==REGULAR_ID) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // Commons.g:0:0: column_alias
                            {
                            pushFollow(FOLLOW_column_alias_in_function_argument_modeling2631);
                            column_alias139=column_alias();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_column_alias.add(column_alias139.getTree());

                            }
                            break;

                    }

                    // Commons.g:304:44: ( COMMA expression ( column_alias )? )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==COMMA) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // Commons.g:304:45: COMMA expression ( column_alias )?
                    	    {
                    	    COMMA140=(Token)match(input,COMMA,FOLLOW_COMMA_in_function_argument_modeling2635); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA140);

                    	    pushFollow(FOLLOW_expression_in_function_argument_modeling2637);
                    	    expression141=gOracleParser.expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expression.add(expression141.getTree());
                    	    // Commons.g:304:62: ( column_alias )?
                    	    int alt49=2;
                    	    int LA49_0 = input.LA(1);

                    	    if ( (LA49_0==NATIONAL_CHAR_STRING_LIT||LA49_0==CHAR_STRING||LA49_0==CHAR_STRING_PERL||LA49_0==DELIMITED_ID||LA49_0==INTRODUCER||LA49_0==SQL92_RESERVED_AS||LA49_0==REGULAR_ID) ) {
                    	        alt49=1;
                    	    }
                    	    switch (alt49) {
                    	        case 1 :
                    	            // Commons.g:0:0: column_alias
                    	            {
                    	            pushFollow(FOLLOW_column_alias_in_function_argument_modeling2639);
                    	            column_alias142=column_alias();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) stream_column_alias.add(column_alias142.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }

            RIGHT_PAREN143=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_function_argument_modeling2671); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN143);

            // Commons.g:307:10: ( keep_clause )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==REGULAR_ID) && ((input.LT(1).getText().equalsIgnoreCase("keep")))) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // Commons.g:0:0: keep_clause
                    {
                    pushFollow(FOLLOW_keep_clause_in_function_argument_modeling2682);
                    keep_clause144=keep_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keep_clause.add(keep_clause144.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: keep_clause, column_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 308:10: -> ^( ARGUMENTS column_name ( keep_clause )? )
            {
                // Commons.g:308:13: ^( ARGUMENTS column_name ( keep_clause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENTS, "ARGUMENTS"), root_1);

                adaptor.addChild(root_1, stream_column_name.nextTree());
                // Commons.g:308:37: ( keep_clause )?
                if ( stream_keep_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_keep_clause.nextTree());

                }
                stream_keep_clause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 591, function_argument_modeling_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "function_argument_modeling"

    public static class respect_or_ignore_nulls_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "respect_or_ignore_nulls"
    // Commons.g:311:1: respect_or_ignore_nulls : ( respect_key | ignore_key ) nulls_key ;
    public final OracleParser_Commons.respect_or_ignore_nulls_return respect_or_ignore_nulls() throws RecognitionException {
        OracleParser_Commons.respect_or_ignore_nulls_return retval = new OracleParser_Commons.respect_or_ignore_nulls_return();
        retval.start = input.LT(1);
        int respect_or_ignore_nulls_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Keys.respect_key_return respect_key145 = null;

        OracleParser_Keys.ignore_key_return ignore_key146 = null;

        OracleParser_Keys.nulls_key_return nulls_key147 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 592) ) { return retval; }
            // Commons.g:312:5: ( ( respect_key | ignore_key ) nulls_key )
            // Commons.g:312:10: ( respect_key | ignore_key ) nulls_key
            {
            root_0 = (Object)adaptor.nil();

            // Commons.g:312:10: ( respect_key | ignore_key )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==REGULAR_ID) && ((input.LT(1).getText().equalsIgnoreCase("ignore")))) {
                int LA53_1 = input.LA(2);

                if ( ((synpred55_Commons()&&(input.LT(1).getText().equalsIgnoreCase("respect")))) ) {
                    alt53=1;
                }
                else if ( ((input.LT(1).getText().equalsIgnoreCase("ignore"))) ) {
                    alt53=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // Commons.g:312:11: respect_key
                    {
                    pushFollow(FOLLOW_respect_key_in_respect_or_ignore_nulls2724);
                    respect_key145=gOracleParser.respect_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, respect_key145.getTree());

                    }
                    break;
                case 2 :
                    // Commons.g:312:25: ignore_key
                    {
                    pushFollow(FOLLOW_ignore_key_in_respect_or_ignore_nulls2728);
                    ignore_key146=gOracleParser.ignore_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ignore_key146.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_nulls_key_in_respect_or_ignore_nulls2731);
            nulls_key147=gOracleParser.nulls_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, nulls_key147.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 592, respect_or_ignore_nulls_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "respect_or_ignore_nulls"

    public static class argument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argument"
    // Commons.g:315:1: argument : ( ( id EQUALS_OP GREATER_THAN_OP )=> id EQUALS_OP GREATER_THAN_OP )? expression_wrapper -> {mode == 1}? ^( ARGUMENT expression_wrapper ^( PARAMETER_NAME[$EQUALS_OP] id ) ) -> ^( ARGUMENT expression_wrapper ) ;
    public final OracleParser_Commons.argument_return argument() throws RecognitionException {
        OracleParser_Commons.argument_return retval = new OracleParser_Commons.argument_return();
        retval.start = input.LT(1);
        int argument_StartIndex = input.index();
        Object root_0 = null;

        Token EQUALS_OP149=null;
        Token GREATER_THAN_OP150=null;
        OracleParser_Commons.id_return id148 = null;

        OracleParser.expression_wrapper_return expression_wrapper151 = null;


        Object EQUALS_OP149_tree=null;
        Object GREATER_THAN_OP150_tree=null;
        RewriteRuleTokenStream stream_GREATER_THAN_OP=new RewriteRuleTokenStream(adaptor,"token GREATER_THAN_OP");
        RewriteRuleTokenStream stream_EQUALS_OP=new RewriteRuleTokenStream(adaptor,"token EQUALS_OP");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_expression_wrapper=new RewriteRuleSubtreeStream(adaptor,"rule expression_wrapper");
            int mode = 0;    
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 593) ) { return retval; }
            // Commons.g:317:5: ( ( ( id EQUALS_OP GREATER_THAN_OP )=> id EQUALS_OP GREATER_THAN_OP )? expression_wrapper -> {mode == 1}? ^( ARGUMENT expression_wrapper ^( PARAMETER_NAME[$EQUALS_OP] id ) ) -> ^( ARGUMENT expression_wrapper ) )
            // Commons.g:317:10: ( ( id EQUALS_OP GREATER_THAN_OP )=> id EQUALS_OP GREATER_THAN_OP )? expression_wrapper
            {
            // Commons.g:317:10: ( ( id EQUALS_OP GREATER_THAN_OP )=> id EQUALS_OP GREATER_THAN_OP )?
            int alt54=2;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // Commons.g:317:11: ( id EQUALS_OP GREATER_THAN_OP )=> id EQUALS_OP GREATER_THAN_OP
                    {
                    pushFollow(FOLLOW_id_in_argument2769);
                    id148=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id148.getTree());
                    EQUALS_OP149=(Token)match(input,EQUALS_OP,FOLLOW_EQUALS_OP_in_argument2771); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUALS_OP.add(EQUALS_OP149);

                    GREATER_THAN_OP150=(Token)match(input,GREATER_THAN_OP,FOLLOW_GREATER_THAN_OP_in_argument2773); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GREATER_THAN_OP.add(GREATER_THAN_OP150);

                    if ( state.backtracking==0 ) {
                      mode = 1;
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_expression_wrapper_in_argument2779);
            expression_wrapper151=gOracleParser.expression_wrapper();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression_wrapper.add(expression_wrapper151.getTree());


            // AST REWRITE
            // elements: expression_wrapper, id, expression_wrapper
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 318:9: -> {mode == 1}? ^( ARGUMENT expression_wrapper ^( PARAMETER_NAME[$EQUALS_OP] id ) )
            if (mode == 1) {
                // Commons.g:318:24: ^( ARGUMENT expression_wrapper ^( PARAMETER_NAME[$EQUALS_OP] id ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENT, "ARGUMENT"), root_1);

                adaptor.addChild(root_1, stream_expression_wrapper.nextTree());
                // Commons.g:318:54: ^( PARAMETER_NAME[$EQUALS_OP] id )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMETER_NAME, EQUALS_OP149), root_2);

                adaptor.addChild(root_2, stream_id.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 319:9: -> ^( ARGUMENT expression_wrapper )
            {
                // Commons.g:319:12: ^( ARGUMENT expression_wrapper )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENT, "ARGUMENT"), root_1);

                adaptor.addChild(root_1, stream_expression_wrapper.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 593, argument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "argument"

    public static class type_spec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type_spec"
    // Commons.g:322:1: type_spec : ( datatype | ( ref_key )? type_name ( percent_rowtype_key | percent_type_key )? -> ^( CUSTOM_TYPE type_name ( ref_key )? ( percent_rowtype_key )? ( percent_type_key )? ) );
    public final OracleParser_Commons.type_spec_return type_spec() throws RecognitionException {
        OracleParser_Commons.type_spec_return retval = new OracleParser_Commons.type_spec_return();
        retval.start = input.LT(1);
        int type_spec_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Commons.datatype_return datatype152 = null;

        OracleParser_Keys.ref_key_return ref_key153 = null;

        OracleParser_Commons.type_name_return type_name154 = null;

        OracleParser_Keys.percent_rowtype_key_return percent_rowtype_key155 = null;

        OracleParser_Keys.percent_type_key_return percent_type_key156 = null;


        RewriteRuleSubtreeStream stream_percent_type_key=new RewriteRuleSubtreeStream(adaptor,"rule percent_type_key");
        RewriteRuleSubtreeStream stream_type_name=new RewriteRuleSubtreeStream(adaptor,"rule type_name");
        RewriteRuleSubtreeStream stream_percent_rowtype_key=new RewriteRuleSubtreeStream(adaptor,"rule percent_rowtype_key");
        RewriteRuleSubtreeStream stream_ref_key=new RewriteRuleSubtreeStream(adaptor,"rule ref_key");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 594) ) { return retval; }
            // Commons.g:323:5: ( datatype | ( ref_key )? type_name ( percent_rowtype_key | percent_type_key )? -> ^( CUSTOM_TYPE type_name ( ref_key )? ( percent_rowtype_key )? ( percent_type_key )? ) )
            int alt57=2;
            switch ( input.LA(1) ) {
            case REGULAR_ID:
                {
                int LA57_1 = input.LA(2);

                if ( (((synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_abbr")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("long")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("binary_float")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("char")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("dec")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("number")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp_unconstrained")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("bfile")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("varchar")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp_tz_unconstrained")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("clob")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("year")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_region")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("interval")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("mlslabel")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("yminterval_unconstrained")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("binary_double")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("naturaln")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("nclob")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("real")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("double")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("varchar2")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("positiven")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("positive")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("pls_integer")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_minute")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("binary_integer")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("dsinterval_unconstrained")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("nchar")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("natural")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("minute")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("second")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("blob")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("numeric")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("smallint")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("rowid")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_hour")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("raw")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("decimal")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("string")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("month")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("float")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("urowid")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("integer")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("character")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("signtype")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("boolean")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("day")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp_ltz_unconstrained")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("int")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("nvarchar2")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("simple_integer")))||(synpred57_Commons()&&(input.LT(1).getText().equalsIgnoreCase("hour"))))) ) {
                    alt57=1;
                }
                else if ( (true) ) {
                    alt57=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 1, input);

                    throw nvae;
                }
                }
                break;
            case SQL92_RESERVED_DATE:
                {
                alt57=1;
                }
                break;
            case DELIMITED_ID:
                {
                alt57=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // Commons.g:323:11: datatype
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_datatype_in_type_spec2840);
                    datatype152=datatype();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, datatype152.getTree());

                    }
                    break;
                case 2 :
                    // Commons.g:324:10: ( ref_key )? type_name ( percent_rowtype_key | percent_type_key )?
                    {
                    // Commons.g:324:10: ( ref_key )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==REGULAR_ID) ) {
                        int LA55_1 = input.LA(2);

                        if ( (LA55_1==REGULAR_ID) ) {
                            int LA55_3 = input.LA(3);

                            if ( ((synpred58_Commons()&&(input.LT(1).getText().equalsIgnoreCase("ref")))) ) {
                                alt55=1;
                            }
                        }
                        else if ( (LA55_1==DELIMITED_ID) && ((input.LT(1).getText().equalsIgnoreCase("ref")))) {
                            alt55=1;
                        }
                    }
                    switch (alt55) {
                        case 1 :
                            // Commons.g:0:0: ref_key
                            {
                            pushFollow(FOLLOW_ref_key_in_type_spec2851);
                            ref_key153=gOracleParser.ref_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_ref_key.add(ref_key153.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_type_name_in_type_spec2854);
                    type_name154=type_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_name.add(type_name154.getTree());
                    // Commons.g:324:29: ( percent_rowtype_key | percent_type_key )?
                    int alt56=3;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==PERCENT) ) {
                        int LA56_1 = input.LA(2);

                        if ( (LA56_1==REGULAR_ID) ) {
                            int LA56_5 = input.LA(3);

                            if ( ((synpred59_Commons()&&(input.LT(2).getText().equalsIgnoreCase("rowtype")))) ) {
                                alt56=1;
                            }
                            else if ( ((synpred60_Commons()&&(input.LT(2).getText().equalsIgnoreCase("type")))) ) {
                                alt56=2;
                            }
                        }
                    }
                    switch (alt56) {
                        case 1 :
                            // Commons.g:324:30: percent_rowtype_key
                            {
                            pushFollow(FOLLOW_percent_rowtype_key_in_type_spec2857);
                            percent_rowtype_key155=gOracleParser.percent_rowtype_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_percent_rowtype_key.add(percent_rowtype_key155.getTree());

                            }
                            break;
                        case 2 :
                            // Commons.g:324:50: percent_type_key
                            {
                            pushFollow(FOLLOW_percent_type_key_in_type_spec2859);
                            percent_type_key156=gOracleParser.percent_type_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_percent_type_key.add(percent_type_key156.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: percent_rowtype_key, percent_type_key, ref_key, type_name
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 324:69: -> ^( CUSTOM_TYPE type_name ( ref_key )? ( percent_rowtype_key )? ( percent_type_key )? )
                    {
                        // Commons.g:324:72: ^( CUSTOM_TYPE type_name ( ref_key )? ( percent_rowtype_key )? ( percent_type_key )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CUSTOM_TYPE, "CUSTOM_TYPE"), root_1);

                        adaptor.addChild(root_1, stream_type_name.nextTree());
                        // Commons.g:324:96: ( ref_key )?
                        if ( stream_ref_key.hasNext() ) {
                            adaptor.addChild(root_1, stream_ref_key.nextTree());

                        }
                        stream_ref_key.reset();
                        // Commons.g:324:105: ( percent_rowtype_key )?
                        if ( stream_percent_rowtype_key.hasNext() ) {
                            adaptor.addChild(root_1, stream_percent_rowtype_key.nextTree());

                        }
                        stream_percent_rowtype_key.reset();
                        // Commons.g:324:126: ( percent_type_key )?
                        if ( stream_percent_type_key.hasNext() ) {
                            adaptor.addChild(root_1, stream_percent_type_key.nextTree());

                        }
                        stream_percent_type_key.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 594, type_spec_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "type_spec"

    public static class datatype_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "datatype"
    // Commons.g:327:1: datatype : ( native_datatype_element ( precision_part )? ( with_key ( local_key )? time_key zone_key )? -> ^( NATIVE_DATATYPE native_datatype_element ( precision_part )? ( time_key )? ( local_key )? ) | interval_key ( year_key | day_key ) ( LEFT_PAREN expression_wrapper RIGHT_PAREN )? to_key ( month_key | second_key ) ( LEFT_PAREN expression_wrapper RIGHT_PAREN )? -> ^( INTERVAL_DATATYPE[$interval_key.start] ( year_key )? ( day_key )? ( month_key )? ( second_key )? ( expression_wrapper )* ) );
    public final OracleParser_Commons.datatype_return datatype() throws RecognitionException {
        OracleParser_Commons.datatype_return retval = new OracleParser_Commons.datatype_return();
        retval.start = input.LT(1);
        int datatype_StartIndex = input.index();
        Object root_0 = null;

        Token LEFT_PAREN166=null;
        Token RIGHT_PAREN168=null;
        Token LEFT_PAREN172=null;
        Token RIGHT_PAREN174=null;
        OracleParser_Commons.native_datatype_element_return native_datatype_element157 = null;

        OracleParser_Commons.precision_part_return precision_part158 = null;

        OracleParser_Keys.with_key_return with_key159 = null;

        OracleParser_Keys.local_key_return local_key160 = null;

        OracleParser_Keys.time_key_return time_key161 = null;

        OracleParser_Keys.zone_key_return zone_key162 = null;

        OracleParser_Keys.interval_key_return interval_key163 = null;

        OracleParser_Keys.year_key_return year_key164 = null;

        OracleParser_Keys.day_key_return day_key165 = null;

        OracleParser.expression_wrapper_return expression_wrapper167 = null;

        OracleParser_Keys.to_key_return to_key169 = null;

        OracleParser_Keys.month_key_return month_key170 = null;

        OracleParser_Keys.second_key_return second_key171 = null;

        OracleParser.expression_wrapper_return expression_wrapper173 = null;


        Object LEFT_PAREN166_tree=null;
        Object RIGHT_PAREN168_tree=null;
        Object LEFT_PAREN172_tree=null;
        Object RIGHT_PAREN174_tree=null;
        RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
        RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
        RewriteRuleSubtreeStream stream_with_key=new RewriteRuleSubtreeStream(adaptor,"rule with_key");
        RewriteRuleSubtreeStream stream_second_key=new RewriteRuleSubtreeStream(adaptor,"rule second_key");
        RewriteRuleSubtreeStream stream_day_key=new RewriteRuleSubtreeStream(adaptor,"rule day_key");
        RewriteRuleSubtreeStream stream_local_key=new RewriteRuleSubtreeStream(adaptor,"rule local_key");
        RewriteRuleSubtreeStream stream_expression_wrapper=new RewriteRuleSubtreeStream(adaptor,"rule expression_wrapper");
        RewriteRuleSubtreeStream stream_to_key=new RewriteRuleSubtreeStream(adaptor,"rule to_key");
        RewriteRuleSubtreeStream stream_precision_part=new RewriteRuleSubtreeStream(adaptor,"rule precision_part");
        RewriteRuleSubtreeStream stream_native_datatype_element=new RewriteRuleSubtreeStream(adaptor,"rule native_datatype_element");
        RewriteRuleSubtreeStream stream_month_key=new RewriteRuleSubtreeStream(adaptor,"rule month_key");
        RewriteRuleSubtreeStream stream_year_key=new RewriteRuleSubtreeStream(adaptor,"rule year_key");
        RewriteRuleSubtreeStream stream_interval_key=new RewriteRuleSubtreeStream(adaptor,"rule interval_key");
        RewriteRuleSubtreeStream stream_zone_key=new RewriteRuleSubtreeStream(adaptor,"rule zone_key");
        RewriteRuleSubtreeStream stream_time_key=new RewriteRuleSubtreeStream(adaptor,"rule time_key");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 595) ) { return retval; }
            // Commons.g:328:5: ( native_datatype_element ( precision_part )? ( with_key ( local_key )? time_key zone_key )? -> ^( NATIVE_DATATYPE native_datatype_element ( precision_part )? ( time_key )? ( local_key )? ) | interval_key ( year_key | day_key ) ( LEFT_PAREN expression_wrapper RIGHT_PAREN )? to_key ( month_key | second_key ) ( LEFT_PAREN expression_wrapper RIGHT_PAREN )? -> ^( INTERVAL_DATATYPE[$interval_key.start] ( year_key )? ( day_key )? ( month_key )? ( second_key )? ( expression_wrapper )* ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==REGULAR_ID) ) {
                int LA65_1 = input.LA(2);

                if ( (((synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp_unconstrained")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp_ltz_unconstrained")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("month")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("minute")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("dec")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("second")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("positiven")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("boolean")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("signtype")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("binary_integer")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("number")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("string")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("bfile")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("hour")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("real")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("natural")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_hour")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("raw")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("char")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("smallint")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("dsinterval_unconstrained")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("simple_integer")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("mlslabel")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("year")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("varchar2")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_abbr")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("urowid")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("nvarchar2")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("pls_integer")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_region")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("positive")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("character")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("varchar")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("decimal")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("float")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("nclob")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("nchar")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("int")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("rowid")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("numeric")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("clob")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_minute")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("day")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("double")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("integer")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("naturaln")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("binary_float")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("blob")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("yminterval_unconstrained")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp_tz_unconstrained")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("long")))||(synpred64_Commons()&&(input.LT(1).getText().equalsIgnoreCase("binary_double"))))) ) {
                    alt65=1;
                }
                else if ( ((input.LT(1).getText().equalsIgnoreCase("interval"))) ) {
                    alt65=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA65_0==SQL92_RESERVED_DATE) ) {
                alt65=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // Commons.g:328:10: native_datatype_element ( precision_part )? ( with_key ( local_key )? time_key zone_key )?
                    {
                    pushFollow(FOLLOW_native_datatype_element_in_datatype2898);
                    native_datatype_element157=native_datatype_element();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_native_datatype_element.add(native_datatype_element157.getTree());
                    // Commons.g:329:9: ( precision_part )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==LEFT_PAREN) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // Commons.g:0:0: precision_part
                            {
                            pushFollow(FOLLOW_precision_part_in_datatype2908);
                            precision_part158=precision_part();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_precision_part.add(precision_part158.getTree());

                            }
                            break;

                    }

                    // Commons.g:330:9: ( with_key ( local_key )? time_key zone_key )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==SQL92_RESERVED_WITH) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // Commons.g:330:10: with_key ( local_key )? time_key zone_key
                            {
                            pushFollow(FOLLOW_with_key_in_datatype2920);
                            with_key159=gOracleParser.with_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_with_key.add(with_key159.getTree());
                            // Commons.g:330:19: ( local_key )?
                            int alt59=2;
                            int LA59_0 = input.LA(1);

                            if ( (LA59_0==REGULAR_ID) ) {
                                int LA59_1 = input.LA(2);

                                if ( (LA59_1==REGULAR_ID) ) {
                                    int LA59_2 = input.LA(3);

                                    if ( (LA59_2==REGULAR_ID) ) {
                                        int LA59_4 = input.LA(4);

                                        if ( ((synpred62_Commons()&&(input.LT(1).getText().equalsIgnoreCase("local")))) ) {
                                            alt59=1;
                                        }
                                    }
                                }
                            }
                            switch (alt59) {
                                case 1 :
                                    // Commons.g:0:0: local_key
                                    {
                                    pushFollow(FOLLOW_local_key_in_datatype2922);
                                    local_key160=gOracleParser.local_key();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_local_key.add(local_key160.getTree());

                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_time_key_in_datatype2925);
                            time_key161=gOracleParser.time_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_time_key.add(time_key161.getTree());
                            pushFollow(FOLLOW_zone_key_in_datatype2927);
                            zone_key162=gOracleParser.zone_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_zone_key.add(zone_key162.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: precision_part, native_datatype_element, local_key, time_key
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 331:9: -> ^( NATIVE_DATATYPE native_datatype_element ( precision_part )? ( time_key )? ( local_key )? )
                    {
                        // Commons.g:331:12: ^( NATIVE_DATATYPE native_datatype_element ( precision_part )? ( time_key )? ( local_key )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NATIVE_DATATYPE, "NATIVE_DATATYPE"), root_1);

                        adaptor.addChild(root_1, stream_native_datatype_element.nextTree());
                        // Commons.g:331:54: ( precision_part )?
                        if ( stream_precision_part.hasNext() ) {
                            adaptor.addChild(root_1, stream_precision_part.nextTree());

                        }
                        stream_precision_part.reset();
                        // Commons.g:331:70: ( time_key )?
                        if ( stream_time_key.hasNext() ) {
                            adaptor.addChild(root_1, stream_time_key.nextTree());

                        }
                        stream_time_key.reset();
                        // Commons.g:331:80: ( local_key )?
                        if ( stream_local_key.hasNext() ) {
                            adaptor.addChild(root_1, stream_local_key.nextTree());

                        }
                        stream_local_key.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Commons.g:332:10: interval_key ( year_key | day_key ) ( LEFT_PAREN expression_wrapper RIGHT_PAREN )? to_key ( month_key | second_key ) ( LEFT_PAREN expression_wrapper RIGHT_PAREN )?
                    {
                    pushFollow(FOLLOW_interval_key_in_datatype2965);
                    interval_key163=gOracleParser.interval_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_interval_key.add(interval_key163.getTree());
                    // Commons.g:332:23: ( year_key | day_key )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==REGULAR_ID) && ((input.LT(1).getText().equalsIgnoreCase("day")))) {
                        int LA61_1 = input.LA(2);

                        if ( ((synpred65_Commons()&&(input.LT(1).getText().equalsIgnoreCase("year")))) ) {
                            alt61=1;
                        }
                        else if ( ((input.LT(1).getText().equalsIgnoreCase("day"))) ) {
                            alt61=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 61, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }
                    switch (alt61) {
                        case 1 :
                            // Commons.g:332:24: year_key
                            {
                            pushFollow(FOLLOW_year_key_in_datatype2968);
                            year_key164=gOracleParser.year_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_year_key.add(year_key164.getTree());

                            }
                            break;
                        case 2 :
                            // Commons.g:332:33: day_key
                            {
                            pushFollow(FOLLOW_day_key_in_datatype2970);
                            day_key165=gOracleParser.day_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_day_key.add(day_key165.getTree());

                            }
                            break;

                    }

                    // Commons.g:333:17: ( LEFT_PAREN expression_wrapper RIGHT_PAREN )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==LEFT_PAREN) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // Commons.g:333:18: LEFT_PAREN expression_wrapper RIGHT_PAREN
                            {
                            LEFT_PAREN166=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_datatype2990); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN166);

                            pushFollow(FOLLOW_expression_wrapper_in_datatype2992);
                            expression_wrapper167=gOracleParser.expression_wrapper();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expression_wrapper.add(expression_wrapper167.getTree());
                            RIGHT_PAREN168=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_datatype2994); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN168);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_to_key_in_datatype3011);
                    to_key169=gOracleParser.to_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_to_key.add(to_key169.getTree());
                    // Commons.g:334:20: ( month_key | second_key )
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==REGULAR_ID) ) {
                        int LA63_1 = input.LA(2);

                        if ( ((synpred67_Commons()&&(input.LT(1).getText().equalsIgnoreCase("month")))) ) {
                            alt63=1;
                        }
                        else if ( ((input.LT(1).getText().equalsIgnoreCase("second"))) ) {
                            alt63=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 63, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 0, input);

                        throw nvae;
                    }
                    switch (alt63) {
                        case 1 :
                            // Commons.g:334:21: month_key
                            {
                            pushFollow(FOLLOW_month_key_in_datatype3014);
                            month_key170=gOracleParser.month_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_month_key.add(month_key170.getTree());

                            }
                            break;
                        case 2 :
                            // Commons.g:334:31: second_key
                            {
                            pushFollow(FOLLOW_second_key_in_datatype3016);
                            second_key171=gOracleParser.second_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_second_key.add(second_key171.getTree());

                            }
                            break;

                    }

                    // Commons.g:335:17: ( LEFT_PAREN expression_wrapper RIGHT_PAREN )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==LEFT_PAREN) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // Commons.g:335:18: LEFT_PAREN expression_wrapper RIGHT_PAREN
                            {
                            LEFT_PAREN172=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_datatype3037); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN172);

                            pushFollow(FOLLOW_expression_wrapper_in_datatype3039);
                            expression_wrapper173=gOracleParser.expression_wrapper();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expression_wrapper.add(expression_wrapper173.getTree());
                            RIGHT_PAREN174=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_datatype3041); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN174);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: day_key, expression_wrapper, month_key, year_key, second_key
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 336:9: -> ^( INTERVAL_DATATYPE[$interval_key.start] ( year_key )? ( day_key )? ( month_key )? ( second_key )? ( expression_wrapper )* )
                    {
                        // Commons.g:336:12: ^( INTERVAL_DATATYPE[$interval_key.start] ( year_key )? ( day_key )? ( month_key )? ( second_key )? ( expression_wrapper )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INTERVAL_DATATYPE, (interval_key163!=null?((Token)interval_key163.start):null)), root_1);

                        // Commons.g:336:53: ( year_key )?
                        if ( stream_year_key.hasNext() ) {
                            adaptor.addChild(root_1, stream_year_key.nextTree());

                        }
                        stream_year_key.reset();
                        // Commons.g:336:63: ( day_key )?
                        if ( stream_day_key.hasNext() ) {
                            adaptor.addChild(root_1, stream_day_key.nextTree());

                        }
                        stream_day_key.reset();
                        // Commons.g:336:72: ( month_key )?
                        if ( stream_month_key.hasNext() ) {
                            adaptor.addChild(root_1, stream_month_key.nextTree());

                        }
                        stream_month_key.reset();
                        // Commons.g:336:83: ( second_key )?
                        if ( stream_second_key.hasNext() ) {
                            adaptor.addChild(root_1, stream_second_key.nextTree());

                        }
                        stream_second_key.reset();
                        // Commons.g:336:95: ( expression_wrapper )*
                        while ( stream_expression_wrapper.hasNext() ) {
                            adaptor.addChild(root_1, stream_expression_wrapper.nextTree());

                        }
                        stream_expression_wrapper.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 595, datatype_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "datatype"

    public static class precision_part_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "precision_part"
    // Commons.g:339:1: precision_part : LEFT_PAREN numeric ( COMMA numeric )? ( char_key | byte_key )? RIGHT_PAREN -> ^( PRECISION ( numeric )+ ( char_key )? ( byte_key )? ) ;
    public final OracleParser_Commons.precision_part_return precision_part() throws RecognitionException {
        OracleParser_Commons.precision_part_return retval = new OracleParser_Commons.precision_part_return();
        retval.start = input.LT(1);
        int precision_part_StartIndex = input.index();
        Object root_0 = null;

        Token LEFT_PAREN175=null;
        Token COMMA177=null;
        Token RIGHT_PAREN181=null;
        OracleParser_Commons.numeric_return numeric176 = null;

        OracleParser_Commons.numeric_return numeric178 = null;

        OracleParser_Keys.char_key_return char_key179 = null;

        OracleParser_Keys.byte_key_return byte_key180 = null;


        Object LEFT_PAREN175_tree=null;
        Object COMMA177_tree=null;
        Object RIGHT_PAREN181_tree=null;
        RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
        RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_numeric=new RewriteRuleSubtreeStream(adaptor,"rule numeric");
        RewriteRuleSubtreeStream stream_byte_key=new RewriteRuleSubtreeStream(adaptor,"rule byte_key");
        RewriteRuleSubtreeStream stream_char_key=new RewriteRuleSubtreeStream(adaptor,"rule char_key");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 596) ) { return retval; }
            // Commons.g:340:5: ( LEFT_PAREN numeric ( COMMA numeric )? ( char_key | byte_key )? RIGHT_PAREN -> ^( PRECISION ( numeric )+ ( char_key )? ( byte_key )? ) )
            // Commons.g:340:10: LEFT_PAREN numeric ( COMMA numeric )? ( char_key | byte_key )? RIGHT_PAREN
            {
            LEFT_PAREN175=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_precision_part3093); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN175);

            pushFollow(FOLLOW_numeric_in_precision_part3095);
            numeric176=numeric();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_numeric.add(numeric176.getTree());
            // Commons.g:340:29: ( COMMA numeric )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==COMMA) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // Commons.g:340:30: COMMA numeric
                    {
                    COMMA177=(Token)match(input,COMMA,FOLLOW_COMMA_in_precision_part3098); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMA.add(COMMA177);

                    pushFollow(FOLLOW_numeric_in_precision_part3100);
                    numeric178=numeric();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_numeric.add(numeric178.getTree());

                    }
                    break;

            }

            // Commons.g:340:46: ( char_key | byte_key )?
            int alt67=3;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==REGULAR_ID) ) {
                int LA67_1 = input.LA(2);

                if ( ((synpred70_Commons()&&(input.LT(1).getText().equalsIgnoreCase("char")))) ) {
                    alt67=1;
                }
                else if ( ((synpred71_Commons()&&(input.LT(1).getText().equalsIgnoreCase("byte")))) ) {
                    alt67=2;
                }
            }
            switch (alt67) {
                case 1 :
                    // Commons.g:340:47: char_key
                    {
                    pushFollow(FOLLOW_char_key_in_precision_part3105);
                    char_key179=gOracleParser.char_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_char_key.add(char_key179.getTree());

                    }
                    break;
                case 2 :
                    // Commons.g:340:58: byte_key
                    {
                    pushFollow(FOLLOW_byte_key_in_precision_part3109);
                    byte_key180=gOracleParser.byte_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_byte_key.add(byte_key180.getTree());

                    }
                    break;

            }

            RIGHT_PAREN181=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_precision_part3113); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN181);



            // AST REWRITE
            // elements: numeric, byte_key, char_key
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 341:9: -> ^( PRECISION ( numeric )+ ( char_key )? ( byte_key )? )
            {
                // Commons.g:341:12: ^( PRECISION ( numeric )+ ( char_key )? ( byte_key )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECISION, "PRECISION"), root_1);

                if ( !(stream_numeric.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_numeric.hasNext() ) {
                    adaptor.addChild(root_1, stream_numeric.nextTree());

                }
                stream_numeric.reset();
                // Commons.g:341:33: ( char_key )?
                if ( stream_char_key.hasNext() ) {
                    adaptor.addChild(root_1, stream_char_key.nextTree());

                }
                stream_char_key.reset();
                // Commons.g:341:43: ( byte_key )?
                if ( stream_byte_key.hasNext() ) {
                    adaptor.addChild(root_1, stream_byte_key.nextTree());

                }
                stream_byte_key.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 596, precision_part_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "precision_part"

    public static class native_datatype_element_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "native_datatype_element"
    // Commons.g:344:1: native_datatype_element : ( binary_integer_key | pls_integer_key | natural_key | binary_float_key | binary_double_key | naturaln_key | positive_key | positiven_key | signtype_key | simple_integer_key | nvarchar2_key | dec_key | integer_key | int_key | numeric_key | smallint_key | number_key | decimal_key | double_key ( precision_key )? | float_key | real_key | nchar_key | long_key ( raw_key )? | char_key | character_key | varchar2_key | varchar_key | string_key | raw_key | boolean_key | date_key | rowid_key | urowid_key | year_key | month_key | day_key | hour_key | minute_key | second_key | timezone_hour_key | timezone_minute_key | timezone_region_key | timezone_abbr_key | timestamp_key | timestamp_unconstrained_key | timestamp_tz_unconstrained_key | timestamp_ltz_unconstrained_key | yminterval_unconstrained_key | dsinterval_unconstrained_key | bfile_key | blob_key | clob_key | nclob_key | mlslabel_key );
    public final OracleParser_Commons.native_datatype_element_return native_datatype_element() throws RecognitionException {
        OracleParser_Commons.native_datatype_element_return retval = new OracleParser_Commons.native_datatype_element_return();
        retval.start = input.LT(1);
        int native_datatype_element_StartIndex = input.index();
        Object root_0 = null;

        OracleParser_Keys.binary_integer_key_return binary_integer_key182 = null;

        OracleParser_Keys.pls_integer_key_return pls_integer_key183 = null;

        OracleParser_Keys.natural_key_return natural_key184 = null;

        OracleParser_Keys.binary_float_key_return binary_float_key185 = null;

        OracleParser_Keys.binary_double_key_return binary_double_key186 = null;

        OracleParser_Keys.naturaln_key_return naturaln_key187 = null;

        OracleParser_Keys.positive_key_return positive_key188 = null;

        OracleParser_Keys.positiven_key_return positiven_key189 = null;

        OracleParser_Keys.signtype_key_return signtype_key190 = null;

        OracleParser_Keys.simple_integer_key_return simple_integer_key191 = null;

        OracleParser_Keys.nvarchar2_key_return nvarchar2_key192 = null;

        OracleParser_Keys.dec_key_return dec_key193 = null;

        OracleParser_Keys.integer_key_return integer_key194 = null;

        OracleParser_Keys.int_key_return int_key195 = null;

        OracleParser_Keys.numeric_key_return numeric_key196 = null;

        OracleParser_Keys.smallint_key_return smallint_key197 = null;

        OracleParser_Keys.number_key_return number_key198 = null;

        OracleParser_Keys.decimal_key_return decimal_key199 = null;

        OracleParser_Keys.double_key_return double_key200 = null;

        OracleParser_Keys.precision_key_return precision_key201 = null;

        OracleParser_Keys.float_key_return float_key202 = null;

        OracleParser_Keys.real_key_return real_key203 = null;

        OracleParser_Keys.nchar_key_return nchar_key204 = null;

        OracleParser_Keys.long_key_return long_key205 = null;

        OracleParser_Keys.raw_key_return raw_key206 = null;

        OracleParser_Keys.char_key_return char_key207 = null;

        OracleParser_Keys.character_key_return character_key208 = null;

        OracleParser_Keys.varchar2_key_return varchar2_key209 = null;

        OracleParser_Keys.varchar_key_return varchar_key210 = null;

        OracleParser_Keys.string_key_return string_key211 = null;

        OracleParser_Keys.raw_key_return raw_key212 = null;

        OracleParser_Keys.boolean_key_return boolean_key213 = null;

        OracleParser_Keys.date_key_return date_key214 = null;

        OracleParser_Keys.rowid_key_return rowid_key215 = null;

        OracleParser_Keys.urowid_key_return urowid_key216 = null;

        OracleParser_Keys.year_key_return year_key217 = null;

        OracleParser_Keys.month_key_return month_key218 = null;

        OracleParser_Keys.day_key_return day_key219 = null;

        OracleParser_Keys.hour_key_return hour_key220 = null;

        OracleParser_Keys.minute_key_return minute_key221 = null;

        OracleParser_Keys.second_key_return second_key222 = null;

        OracleParser_Keys.timezone_hour_key_return timezone_hour_key223 = null;

        OracleParser_Keys.timezone_minute_key_return timezone_minute_key224 = null;

        OracleParser_Keys.timezone_region_key_return timezone_region_key225 = null;

        OracleParser_Keys.timezone_abbr_key_return timezone_abbr_key226 = null;

        OracleParser_Keys.timestamp_key_return timestamp_key227 = null;

        OracleParser_Keys.timestamp_unconstrained_key_return timestamp_unconstrained_key228 = null;

        OracleParser_Keys.timestamp_tz_unconstrained_key_return timestamp_tz_unconstrained_key229 = null;

        OracleParser_Keys.timestamp_ltz_unconstrained_key_return timestamp_ltz_unconstrained_key230 = null;

        OracleParser_Keys.yminterval_unconstrained_key_return yminterval_unconstrained_key231 = null;

        OracleParser_Keys.dsinterval_unconstrained_key_return dsinterval_unconstrained_key232 = null;

        OracleParser_Keys.bfile_key_return bfile_key233 = null;

        OracleParser_Keys.blob_key_return blob_key234 = null;

        OracleParser_Keys.clob_key_return clob_key235 = null;

        OracleParser_Keys.nclob_key_return nclob_key236 = null;

        OracleParser_Keys.mlslabel_key_return mlslabel_key237 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 597) ) { return retval; }
            // Commons.g:345:5: ( binary_integer_key | pls_integer_key | natural_key | binary_float_key | binary_double_key | naturaln_key | positive_key | positiven_key | signtype_key | simple_integer_key | nvarchar2_key | dec_key | integer_key | int_key | numeric_key | smallint_key | number_key | decimal_key | double_key ( precision_key )? | float_key | real_key | nchar_key | long_key ( raw_key )? | char_key | character_key | varchar2_key | varchar_key | string_key | raw_key | boolean_key | date_key | rowid_key | urowid_key | year_key | month_key | day_key | hour_key | minute_key | second_key | timezone_hour_key | timezone_minute_key | timezone_region_key | timezone_abbr_key | timestamp_key | timestamp_unconstrained_key | timestamp_tz_unconstrained_key | timestamp_ltz_unconstrained_key | yminterval_unconstrained_key | dsinterval_unconstrained_key | bfile_key | blob_key | clob_key | nclob_key | mlslabel_key )
            int alt70=54;
            alt70 = dfa70.predict(input);
            switch (alt70) {
                case 1 :
                    // Commons.g:345:10: binary_integer_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_binary_integer_key_in_native_datatype_element3156);
                    binary_integer_key182=gOracleParser.binary_integer_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_integer_key182.getTree());

                    }
                    break;
                case 2 :
                    // Commons.g:346:10: pls_integer_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pls_integer_key_in_native_datatype_element3167);
                    pls_integer_key183=gOracleParser.pls_integer_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pls_integer_key183.getTree());

                    }
                    break;
                case 3 :
                    // Commons.g:347:10: natural_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_natural_key_in_native_datatype_element3178);
                    natural_key184=gOracleParser.natural_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, natural_key184.getTree());

                    }
                    break;
                case 4 :
                    // Commons.g:348:10: binary_float_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_binary_float_key_in_native_datatype_element3189);
                    binary_float_key185=gOracleParser.binary_float_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_float_key185.getTree());

                    }
                    break;
                case 5 :
                    // Commons.g:349:10: binary_double_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_binary_double_key_in_native_datatype_element3200);
                    binary_double_key186=gOracleParser.binary_double_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_double_key186.getTree());

                    }
                    break;
                case 6 :
                    // Commons.g:350:10: naturaln_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_naturaln_key_in_native_datatype_element3211);
                    naturaln_key187=gOracleParser.naturaln_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, naturaln_key187.getTree());

                    }
                    break;
                case 7 :
                    // Commons.g:351:10: positive_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_positive_key_in_native_datatype_element3222);
                    positive_key188=gOracleParser.positive_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, positive_key188.getTree());

                    }
                    break;
                case 8 :
                    // Commons.g:352:10: positiven_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_positiven_key_in_native_datatype_element3233);
                    positiven_key189=gOracleParser.positiven_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, positiven_key189.getTree());

                    }
                    break;
                case 9 :
                    // Commons.g:353:10: signtype_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signtype_key_in_native_datatype_element3244);
                    signtype_key190=gOracleParser.signtype_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, signtype_key190.getTree());

                    }
                    break;
                case 10 :
                    // Commons.g:354:10: simple_integer_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simple_integer_key_in_native_datatype_element3255);
                    simple_integer_key191=gOracleParser.simple_integer_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_integer_key191.getTree());

                    }
                    break;
                case 11 :
                    // Commons.g:355:10: nvarchar2_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nvarchar2_key_in_native_datatype_element3266);
                    nvarchar2_key192=gOracleParser.nvarchar2_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nvarchar2_key192.getTree());

                    }
                    break;
                case 12 :
                    // Commons.g:356:10: dec_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_dec_key_in_native_datatype_element3277);
                    dec_key193=gOracleParser.dec_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dec_key193.getTree());

                    }
                    break;
                case 13 :
                    // Commons.g:357:10: integer_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_integer_key_in_native_datatype_element3288);
                    integer_key194=gOracleParser.integer_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_key194.getTree());

                    }
                    break;
                case 14 :
                    // Commons.g:358:10: int_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_int_key_in_native_datatype_element3299);
                    int_key195=gOracleParser.int_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, int_key195.getTree());

                    }
                    break;
                case 15 :
                    // Commons.g:359:10: numeric_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numeric_key_in_native_datatype_element3310);
                    numeric_key196=gOracleParser.numeric_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_key196.getTree());

                    }
                    break;
                case 16 :
                    // Commons.g:360:10: smallint_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_smallint_key_in_native_datatype_element3321);
                    smallint_key197=gOracleParser.smallint_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, smallint_key197.getTree());

                    }
                    break;
                case 17 :
                    // Commons.g:361:10: number_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_number_key_in_native_datatype_element3332);
                    number_key198=gOracleParser.number_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, number_key198.getTree());

                    }
                    break;
                case 18 :
                    // Commons.g:362:10: decimal_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_decimal_key_in_native_datatype_element3343);
                    decimal_key199=gOracleParser.decimal_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decimal_key199.getTree());

                    }
                    break;
                case 19 :
                    // Commons.g:363:10: double_key ( precision_key )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_double_key_in_native_datatype_element3355);
                    double_key200=gOracleParser.double_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, double_key200.getTree());
                    // Commons.g:363:21: ( precision_key )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==REGULAR_ID) ) {
                        int LA68_1 = input.LA(2);

                        if ( ((synpred90_Commons()&&(input.LT(1).getText().equalsIgnoreCase("precision")))) ) {
                            alt68=1;
                        }
                    }
                    switch (alt68) {
                        case 1 :
                            // Commons.g:0:0: precision_key
                            {
                            pushFollow(FOLLOW_precision_key_in_native_datatype_element3357);
                            precision_key201=gOracleParser.precision_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, precision_key201.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 20 :
                    // Commons.g:364:10: float_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_float_key_in_native_datatype_element3369);
                    float_key202=gOracleParser.float_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, float_key202.getTree());

                    }
                    break;
                case 21 :
                    // Commons.g:365:10: real_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_real_key_in_native_datatype_element3380);
                    real_key203=gOracleParser.real_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, real_key203.getTree());

                    }
                    break;
                case 22 :
                    // Commons.g:366:10: nchar_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nchar_key_in_native_datatype_element3391);
                    nchar_key204=gOracleParser.nchar_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nchar_key204.getTree());

                    }
                    break;
                case 23 :
                    // Commons.g:367:10: long_key ( raw_key )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_long_key_in_native_datatype_element3402);
                    long_key205=gOracleParser.long_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, long_key205.getTree());
                    // Commons.g:367:19: ( raw_key )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==REGULAR_ID) && (((input.LT(1).getText().equalsIgnoreCase("no"))||(input.LT(1).getText().equalsIgnoreCase("path"))||(input.LT(1).getText().equalsIgnoreCase("encoding"))||(input.LT(1).getText().equalsIgnoreCase("indent"))||(input.LT(1).getText().equalsIgnoreCase("version"))||(input.LT(1).getText().equalsIgnoreCase("hide"))||(input.LT(1).getText().equalsIgnoreCase("show"))))) {
                        int LA69_1 = input.LA(2);

                        if ( ((synpred95_Commons()&&(input.LT(1).getText().equalsIgnoreCase("raw")))) ) {
                            alt69=1;
                        }
                    }
                    switch (alt69) {
                        case 1 :
                            // Commons.g:0:0: raw_key
                            {
                            pushFollow(FOLLOW_raw_key_in_native_datatype_element3404);
                            raw_key206=gOracleParser.raw_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, raw_key206.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 24 :
                    // Commons.g:368:10: char_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_char_key_in_native_datatype_element3416);
                    char_key207=gOracleParser.char_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, char_key207.getTree());

                    }
                    break;
                case 25 :
                    // Commons.g:369:10: character_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_character_key_in_native_datatype_element3429);
                    character_key208=gOracleParser.character_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, character_key208.getTree());

                    }
                    break;
                case 26 :
                    // Commons.g:370:10: varchar2_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_varchar2_key_in_native_datatype_element3441);
                    varchar2_key209=gOracleParser.varchar2_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varchar2_key209.getTree());

                    }
                    break;
                case 27 :
                    // Commons.g:371:10: varchar_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_varchar_key_in_native_datatype_element3452);
                    varchar_key210=gOracleParser.varchar_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varchar_key210.getTree());

                    }
                    break;
                case 28 :
                    // Commons.g:372:10: string_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_string_key_in_native_datatype_element3463);
                    string_key211=gOracleParser.string_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string_key211.getTree());

                    }
                    break;
                case 29 :
                    // Commons.g:373:10: raw_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_raw_key_in_native_datatype_element3474);
                    raw_key212=gOracleParser.raw_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, raw_key212.getTree());

                    }
                    break;
                case 30 :
                    // Commons.g:374:10: boolean_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_boolean_key_in_native_datatype_element3485);
                    boolean_key213=gOracleParser.boolean_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, boolean_key213.getTree());

                    }
                    break;
                case 31 :
                    // Commons.g:375:10: date_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_date_key_in_native_datatype_element3496);
                    date_key214=gOracleParser.date_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, date_key214.getTree());

                    }
                    break;
                case 32 :
                    // Commons.g:376:10: rowid_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_rowid_key_in_native_datatype_element3507);
                    rowid_key215=gOracleParser.rowid_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rowid_key215.getTree());

                    }
                    break;
                case 33 :
                    // Commons.g:377:10: urowid_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_urowid_key_in_native_datatype_element3518);
                    urowid_key216=gOracleParser.urowid_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, urowid_key216.getTree());

                    }
                    break;
                case 34 :
                    // Commons.g:378:10: year_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_year_key_in_native_datatype_element3529);
                    year_key217=gOracleParser.year_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, year_key217.getTree());

                    }
                    break;
                case 35 :
                    // Commons.g:379:10: month_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_month_key_in_native_datatype_element3540);
                    month_key218=gOracleParser.month_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, month_key218.getTree());

                    }
                    break;
                case 36 :
                    // Commons.g:380:10: day_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_day_key_in_native_datatype_element3551);
                    day_key219=gOracleParser.day_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, day_key219.getTree());

                    }
                    break;
                case 37 :
                    // Commons.g:381:10: hour_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hour_key_in_native_datatype_element3562);
                    hour_key220=gOracleParser.hour_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hour_key220.getTree());

                    }
                    break;
                case 38 :
                    // Commons.g:382:10: minute_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_minute_key_in_native_datatype_element3573);
                    minute_key221=gOracleParser.minute_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, minute_key221.getTree());

                    }
                    break;
                case 39 :
                    // Commons.g:383:10: second_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_second_key_in_native_datatype_element3584);
                    second_key222=gOracleParser.second_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, second_key222.getTree());

                    }
                    break;
                case 40 :
                    // Commons.g:384:10: timezone_hour_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_timezone_hour_key_in_native_datatype_element3595);
                    timezone_hour_key223=gOracleParser.timezone_hour_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timezone_hour_key223.getTree());

                    }
                    break;
                case 41 :
                    // Commons.g:385:10: timezone_minute_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_timezone_minute_key_in_native_datatype_element3606);
                    timezone_minute_key224=gOracleParser.timezone_minute_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timezone_minute_key224.getTree());

                    }
                    break;
                case 42 :
                    // Commons.g:386:10: timezone_region_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_timezone_region_key_in_native_datatype_element3617);
                    timezone_region_key225=gOracleParser.timezone_region_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timezone_region_key225.getTree());

                    }
                    break;
                case 43 :
                    // Commons.g:387:10: timezone_abbr_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_timezone_abbr_key_in_native_datatype_element3628);
                    timezone_abbr_key226=gOracleParser.timezone_abbr_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timezone_abbr_key226.getTree());

                    }
                    break;
                case 44 :
                    // Commons.g:388:10: timestamp_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_timestamp_key_in_native_datatype_element3639);
                    timestamp_key227=gOracleParser.timestamp_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timestamp_key227.getTree());

                    }
                    break;
                case 45 :
                    // Commons.g:389:10: timestamp_unconstrained_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_timestamp_unconstrained_key_in_native_datatype_element3650);
                    timestamp_unconstrained_key228=gOracleParser.timestamp_unconstrained_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timestamp_unconstrained_key228.getTree());

                    }
                    break;
                case 46 :
                    // Commons.g:390:10: timestamp_tz_unconstrained_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_timestamp_tz_unconstrained_key_in_native_datatype_element3661);
                    timestamp_tz_unconstrained_key229=gOracleParser.timestamp_tz_unconstrained_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timestamp_tz_unconstrained_key229.getTree());

                    }
                    break;
                case 47 :
                    // Commons.g:391:10: timestamp_ltz_unconstrained_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_timestamp_ltz_unconstrained_key_in_native_datatype_element3672);
                    timestamp_ltz_unconstrained_key230=gOracleParser.timestamp_ltz_unconstrained_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timestamp_ltz_unconstrained_key230.getTree());

                    }
                    break;
                case 48 :
                    // Commons.g:392:10: yminterval_unconstrained_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_yminterval_unconstrained_key_in_native_datatype_element3683);
                    yminterval_unconstrained_key231=gOracleParser.yminterval_unconstrained_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, yminterval_unconstrained_key231.getTree());

                    }
                    break;
                case 49 :
                    // Commons.g:393:10: dsinterval_unconstrained_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_dsinterval_unconstrained_key_in_native_datatype_element3694);
                    dsinterval_unconstrained_key232=gOracleParser.dsinterval_unconstrained_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dsinterval_unconstrained_key232.getTree());

                    }
                    break;
                case 50 :
                    // Commons.g:394:10: bfile_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_bfile_key_in_native_datatype_element3705);
                    bfile_key233=gOracleParser.bfile_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bfile_key233.getTree());

                    }
                    break;
                case 51 :
                    // Commons.g:395:10: blob_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_blob_key_in_native_datatype_element3716);
                    blob_key234=gOracleParser.blob_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, blob_key234.getTree());

                    }
                    break;
                case 52 :
                    // Commons.g:396:10: clob_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_clob_key_in_native_datatype_element3727);
                    clob_key235=gOracleParser.clob_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, clob_key235.getTree());

                    }
                    break;
                case 53 :
                    // Commons.g:397:10: nclob_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nclob_key_in_native_datatype_element3738);
                    nclob_key236=gOracleParser.nclob_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nclob_key236.getTree());

                    }
                    break;
                case 54 :
                    // Commons.g:398:10: mlslabel_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_mlslabel_key_in_native_datatype_element3749);
                    mlslabel_key237=gOracleParser.mlslabel_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mlslabel_key237.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 597, native_datatype_element_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "native_datatype_element"

    public static class bind_variable_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bind_variable"
    // Commons.g:401:1: bind_variable : (b1= BINDVAR | COLON u1= UNSIGNED_INTEGER ) ( ( indicator_key )? (b2= BINDVAR | COLON u2= UNSIGNED_INTEGER ) )? ( ( PERIOD general_element_part )=> PERIOD general_element_part )* -> ^( HOSTED_VARIABLE_NAME ( $b1)? ( $u1)? ( indicator_key )? ( $b2)? ( $u2)? ( general_element_part )* ) ;
    public final OracleParser_Commons.bind_variable_return bind_variable() throws RecognitionException {
        OracleParser_Commons.bind_variable_return retval = new OracleParser_Commons.bind_variable_return();
        retval.start = input.LT(1);
        int bind_variable_StartIndex = input.index();
        Object root_0 = null;

        Token b1=null;
        Token u1=null;
        Token b2=null;
        Token u2=null;
        Token COLON238=null;
        Token COLON240=null;
        Token PERIOD241=null;
        OracleParser_Keys.indicator_key_return indicator_key239 = null;

        OracleParser_Commons.general_element_part_return general_element_part242 = null;


        Object b1_tree=null;
        Object u1_tree=null;
        Object b2_tree=null;
        Object u2_tree=null;
        Object COLON238_tree=null;
        Object COLON240_tree=null;
        Object PERIOD241_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_BINDVAR=new RewriteRuleTokenStream(adaptor,"token BINDVAR");
        RewriteRuleTokenStream stream_UNSIGNED_INTEGER=new RewriteRuleTokenStream(adaptor,"token UNSIGNED_INTEGER");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_indicator_key=new RewriteRuleSubtreeStream(adaptor,"rule indicator_key");
        RewriteRuleSubtreeStream stream_general_element_part=new RewriteRuleSubtreeStream(adaptor,"rule general_element_part");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 598) ) { return retval; }
            // Commons.g:402:5: ( (b1= BINDVAR | COLON u1= UNSIGNED_INTEGER ) ( ( indicator_key )? (b2= BINDVAR | COLON u2= UNSIGNED_INTEGER ) )? ( ( PERIOD general_element_part )=> PERIOD general_element_part )* -> ^( HOSTED_VARIABLE_NAME ( $b1)? ( $u1)? ( indicator_key )? ( $b2)? ( $u2)? ( general_element_part )* ) )
            // Commons.g:402:10: (b1= BINDVAR | COLON u1= UNSIGNED_INTEGER ) ( ( indicator_key )? (b2= BINDVAR | COLON u2= UNSIGNED_INTEGER ) )? ( ( PERIOD general_element_part )=> PERIOD general_element_part )*
            {
            // Commons.g:402:10: (b1= BINDVAR | COLON u1= UNSIGNED_INTEGER )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==BINDVAR) ) {
                alt71=1;
            }
            else if ( (LA71_0==COLON) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // Commons.g:402:12: b1= BINDVAR
                    {
                    b1=(Token)match(input,BINDVAR,FOLLOW_BINDVAR_in_bind_variable3773); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BINDVAR.add(b1);


                    }
                    break;
                case 2 :
                    // Commons.g:402:25: COLON u1= UNSIGNED_INTEGER
                    {
                    COLON238=(Token)match(input,COLON,FOLLOW_COLON_in_bind_variable3777); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON238);

                    u1=(Token)match(input,UNSIGNED_INTEGER,FOLLOW_UNSIGNED_INTEGER_in_bind_variable3781); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNSIGNED_INTEGER.add(u1);


                    }
                    break;

            }

            // Commons.g:403:10: ( ( indicator_key )? (b2= BINDVAR | COLON u2= UNSIGNED_INTEGER ) )?
            int alt74=2;
            alt74 = dfa74.predict(input);
            switch (alt74) {
                case 1 :
                    // Commons.g:403:12: ( indicator_key )? (b2= BINDVAR | COLON u2= UNSIGNED_INTEGER )
                    {
                    // Commons.g:403:12: ( indicator_key )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==REGULAR_ID) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // Commons.g:0:0: indicator_key
                            {
                            pushFollow(FOLLOW_indicator_key_in_bind_variable3795);
                            indicator_key239=gOracleParser.indicator_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_indicator_key.add(indicator_key239.getTree());

                            }
                            break;

                    }

                    // Commons.g:403:27: (b2= BINDVAR | COLON u2= UNSIGNED_INTEGER )
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==BINDVAR) ) {
                        alt73=1;
                    }
                    else if ( (LA73_0==COLON) ) {
                        alt73=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 73, 0, input);

                        throw nvae;
                    }
                    switch (alt73) {
                        case 1 :
                            // Commons.g:403:28: b2= BINDVAR
                            {
                            b2=(Token)match(input,BINDVAR,FOLLOW_BINDVAR_in_bind_variable3801); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BINDVAR.add(b2);


                            }
                            break;
                        case 2 :
                            // Commons.g:403:41: COLON u2= UNSIGNED_INTEGER
                            {
                            COLON240=(Token)match(input,COLON,FOLLOW_COLON_in_bind_variable3805); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON.add(COLON240);

                            u2=(Token)match(input,UNSIGNED_INTEGER,FOLLOW_UNSIGNED_INTEGER_in_bind_variable3809); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_UNSIGNED_INTEGER.add(u2);


                            }
                            break;

                    }


                    }
                    break;

            }

            // Commons.g:404:10: ( ( PERIOD general_element_part )=> PERIOD general_element_part )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==PERIOD) && (synpred131_Commons())) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // Commons.g:404:11: ( PERIOD general_element_part )=> PERIOD general_element_part
            	    {
            	    PERIOD241=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_bind_variable3831); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD241);

            	    pushFollow(FOLLOW_general_element_part_in_bind_variable3833);
            	    general_element_part242=general_element_part();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_general_element_part.add(general_element_part242.getTree());

            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);



            // AST REWRITE
            // elements: indicator_key, b2, u2, general_element_part, b1, u1
            // token labels: u2, u1, b1, b2
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_u2=new RewriteRuleTokenStream(adaptor,"token u2",u2);
            RewriteRuleTokenStream stream_u1=new RewriteRuleTokenStream(adaptor,"token u1",u1);
            RewriteRuleTokenStream stream_b1=new RewriteRuleTokenStream(adaptor,"token b1",b1);
            RewriteRuleTokenStream stream_b2=new RewriteRuleTokenStream(adaptor,"token b2",b2);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 405:10: -> ^( HOSTED_VARIABLE_NAME ( $b1)? ( $u1)? ( indicator_key )? ( $b2)? ( $u2)? ( general_element_part )* )
            {
                // Commons.g:405:12: ^( HOSTED_VARIABLE_NAME ( $b1)? ( $u1)? ( indicator_key )? ( $b2)? ( $u2)? ( general_element_part )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(HOSTED_VARIABLE_NAME, "HOSTED_VARIABLE_NAME"), root_1);

                // Commons.g:405:35: ( $b1)?
                if ( stream_b1.hasNext() ) {
                    adaptor.addChild(root_1, stream_b1.nextNode());

                }
                stream_b1.reset();
                // Commons.g:405:40: ( $u1)?
                if ( stream_u1.hasNext() ) {
                    adaptor.addChild(root_1, stream_u1.nextNode());

                }
                stream_u1.reset();
                // Commons.g:405:45: ( indicator_key )?
                if ( stream_indicator_key.hasNext() ) {
                    adaptor.addChild(root_1, stream_indicator_key.nextTree());

                }
                stream_indicator_key.reset();
                // Commons.g:405:60: ( $b2)?
                if ( stream_b2.hasNext() ) {
                    adaptor.addChild(root_1, stream_b2.nextNode());

                }
                stream_b2.reset();
                // Commons.g:405:65: ( $u2)?
                if ( stream_u2.hasNext() ) {
                    adaptor.addChild(root_1, stream_u2.nextNode());

                }
                stream_u2.reset();
                // Commons.g:405:70: ( general_element_part )*
                while ( stream_general_element_part.hasNext() ) {
                    adaptor.addChild(root_1, stream_general_element_part.nextTree());

                }
                stream_general_element_part.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 598, bind_variable_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "bind_variable"

    public static class general_element_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "general_element"
    // Commons.g:408:1: general_element : general_element_part ( ( PERIOD general_element_part )=> PERIOD general_element_part )* -> {isCascated}? ^( CASCATED_ELEMENT ( general_element_part )+ ) -> general_element_part ;
    public final OracleParser_Commons.general_element_return general_element() throws RecognitionException {
        OracleParser_Commons.general_element_return retval = new OracleParser_Commons.general_element_return();
        retval.start = input.LT(1);
        int general_element_StartIndex = input.index();
        Object root_0 = null;

        Token PERIOD244=null;
        OracleParser_Commons.general_element_part_return general_element_part243 = null;

        OracleParser_Commons.general_element_part_return general_element_part245 = null;


        Object PERIOD244_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_general_element_part=new RewriteRuleSubtreeStream(adaptor,"rule general_element_part");
         boolean isCascated = true; 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 599) ) { return retval; }
            // Commons.g:410:5: ( general_element_part ( ( PERIOD general_element_part )=> PERIOD general_element_part )* -> {isCascated}? ^( CASCATED_ELEMENT ( general_element_part )+ ) -> general_element_part )
            // Commons.g:410:10: general_element_part ( ( PERIOD general_element_part )=> PERIOD general_element_part )*
            {
            pushFollow(FOLLOW_general_element_part_in_general_element3899);
            general_element_part243=general_element_part();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_general_element_part.add(general_element_part243.getTree());
            // Commons.g:410:31: ( ( PERIOD general_element_part )=> PERIOD general_element_part )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==PERIOD) && (synpred132_Commons())) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // Commons.g:410:32: ( PERIOD general_element_part )=> PERIOD general_element_part
            	    {
            	    PERIOD244=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_general_element3909); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD244);

            	    pushFollow(FOLLOW_general_element_part_in_general_element3911);
            	    general_element_part245=general_element_part();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_general_element_part.add(general_element_part245.getTree());
            	    if ( state.backtracking==0 ) {
            	      isCascated = true;
            	    }

            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);



            // AST REWRITE
            // elements: general_element_part, general_element_part
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 411:9: -> {isCascated}? ^( CASCATED_ELEMENT ( general_element_part )+ )
            if (isCascated) {
                // Commons.g:411:25: ^( CASCATED_ELEMENT ( general_element_part )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CASCATED_ELEMENT, "CASCATED_ELEMENT"), root_1);

                if ( !(stream_general_element_part.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_general_element_part.hasNext() ) {
                    adaptor.addChild(root_1, stream_general_element_part.nextTree());

                }
                stream_general_element_part.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 412:9: -> general_element_part
            {
                adaptor.addChild(root_0, stream_general_element_part.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 599, general_element_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "general_element"

    public static class general_element_part_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "general_element_part"
    // Commons.g:415:1: general_element_part : ( INTRODUCER char_set_name )? id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )* ( function_argument )? -> {isRoutineCall}? ^( ROUTINE_CALL ^( ROUTINE_NAME ( char_set_name )? ( id_expression )+ ) function_argument ) -> ^( ANY_ELEMENT ( char_set_name )? ( id_expression )+ ) ;
    public final OracleParser_Commons.general_element_part_return general_element_part() throws RecognitionException {
        OracleParser_Commons.general_element_part_return retval = new OracleParser_Commons.general_element_part_return();
        retval.start = input.LT(1);
        int general_element_part_StartIndex = input.index();
        Object root_0 = null;

        Token INTRODUCER246=null;
        Token PERIOD249=null;
        OracleParser_Commons.char_set_name_return char_set_name247 = null;

        OracleParser_Commons.id_expression_return id_expression248 = null;

        OracleParser_Commons.id_expression_return id_expression250 = null;

        OracleParser_Commons.function_argument_return function_argument251 = null;


        Object INTRODUCER246_tree=null;
        Object PERIOD249_tree=null;
        RewriteRuleTokenStream stream_INTRODUCER=new RewriteRuleTokenStream(adaptor,"token INTRODUCER");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        RewriteRuleSubtreeStream stream_function_argument=new RewriteRuleSubtreeStream(adaptor,"rule function_argument");
        RewriteRuleSubtreeStream stream_char_set_name=new RewriteRuleSubtreeStream(adaptor,"rule char_set_name");
         boolean isRoutineCall = false; 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 600) ) { return retval; }
            // Commons.g:417:5: ( ( INTRODUCER char_set_name )? id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )* ( function_argument )? -> {isRoutineCall}? ^( ROUTINE_CALL ^( ROUTINE_NAME ( char_set_name )? ( id_expression )+ ) function_argument ) -> ^( ANY_ELEMENT ( char_set_name )? ( id_expression )+ ) )
            // Commons.g:417:10: ( INTRODUCER char_set_name )? id_expression ( ( PERIOD id_expression )=> PERIOD id_expression )* ( function_argument )?
            {
            // Commons.g:417:10: ( INTRODUCER char_set_name )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==INTRODUCER) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // Commons.g:417:11: INTRODUCER char_set_name
                    {
                    INTRODUCER246=(Token)match(input,INTRODUCER,FOLLOW_INTRODUCER_in_general_element_part3974); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INTRODUCER.add(INTRODUCER246);

                    pushFollow(FOLLOW_char_set_name_in_general_element_part3976);
                    char_set_name247=char_set_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_char_set_name.add(char_set_name247.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_id_expression_in_general_element_part3980);
            id_expression248=id_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id_expression.add(id_expression248.getTree());
            // Commons.g:418:13: ( ( PERIOD id_expression )=> PERIOD id_expression )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==PERIOD) ) {
                    int LA78_2 = input.LA(2);

                    if ( (LA78_2==REGULAR_ID) ) {
                        int LA78_3 = input.LA(3);

                        if ( (synpred134_Commons()) ) {
                            alt78=1;
                        }


                    }
                    else if ( (LA78_2==DELIMITED_ID) ) {
                        int LA78_4 = input.LA(3);

                        if ( (synpred134_Commons()) ) {
                            alt78=1;
                        }


                    }


                }


                switch (alt78) {
            	case 1 :
            	    // Commons.g:418:14: ( PERIOD id_expression )=> PERIOD id_expression
            	    {
            	    PERIOD249=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_general_element_part4002); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD249);

            	    pushFollow(FOLLOW_id_expression_in_general_element_part4004);
            	    id_expression250=id_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_id_expression.add(id_expression250.getTree());

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            // Commons.g:418:62: ( function_argument )?
            int alt79=2;
            alt79 = dfa79.predict(input);
            switch (alt79) {
                case 1 :
                    // Commons.g:418:63: function_argument
                    {
                    pushFollow(FOLLOW_function_argument_in_general_element_part4009);
                    function_argument251=function_argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_function_argument.add(function_argument251.getTree());
                    if ( state.backtracking==0 ) {
                      isRoutineCall = true;
                    }

                    }
                    break;

            }



            // AST REWRITE
            // elements: id_expression, char_set_name, char_set_name, id_expression, function_argument
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 419:9: -> {isRoutineCall}? ^( ROUTINE_CALL ^( ROUTINE_NAME ( char_set_name )? ( id_expression )+ ) function_argument )
            if (isRoutineCall) {
                // Commons.g:419:28: ^( ROUTINE_CALL ^( ROUTINE_NAME ( char_set_name )? ( id_expression )+ ) function_argument )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROUTINE_CALL, "ROUTINE_CALL"), root_1);

                // Commons.g:419:43: ^( ROUTINE_NAME ( char_set_name )? ( id_expression )+ )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROUTINE_NAME, "ROUTINE_NAME"), root_2);

                // Commons.g:419:58: ( char_set_name )?
                if ( stream_char_set_name.hasNext() ) {
                    adaptor.addChild(root_2, stream_char_set_name.nextTree());

                }
                stream_char_set_name.reset();
                if ( !(stream_id_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_2, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_function_argument.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 420:9: -> ^( ANY_ELEMENT ( char_set_name )? ( id_expression )+ )
            {
                // Commons.g:420:12: ^( ANY_ELEMENT ( char_set_name )? ( id_expression )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ANY_ELEMENT, "ANY_ELEMENT"), root_1);

                // Commons.g:420:26: ( char_set_name )?
                if ( stream_char_set_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_char_set_name.nextTree());

                }
                stream_char_set_name.reset();
                if ( !(stream_id_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 600, general_element_part_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "general_element_part"

    public static class table_element_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table_element"
    // Commons.g:423:1: table_element : ( INTRODUCER char_set_name )? id_expression ( PERIOD id_expression )* -> ^( ANY_ELEMENT ( char_set_name )? ( id_expression )+ ) ;
    public final OracleParser_Commons.table_element_return table_element() throws RecognitionException {
        OracleParser_Commons.table_element_return retval = new OracleParser_Commons.table_element_return();
        retval.start = input.LT(1);
        int table_element_StartIndex = input.index();
        Object root_0 = null;

        Token INTRODUCER252=null;
        Token PERIOD255=null;
        OracleParser_Commons.char_set_name_return char_set_name253 = null;

        OracleParser_Commons.id_expression_return id_expression254 = null;

        OracleParser_Commons.id_expression_return id_expression256 = null;


        Object INTRODUCER252_tree=null;
        Object PERIOD255_tree=null;
        RewriteRuleTokenStream stream_INTRODUCER=new RewriteRuleTokenStream(adaptor,"token INTRODUCER");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        RewriteRuleSubtreeStream stream_char_set_name=new RewriteRuleSubtreeStream(adaptor,"rule char_set_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 601) ) { return retval; }
            // Commons.g:424:5: ( ( INTRODUCER char_set_name )? id_expression ( PERIOD id_expression )* -> ^( ANY_ELEMENT ( char_set_name )? ( id_expression )+ ) )
            // Commons.g:424:10: ( INTRODUCER char_set_name )? id_expression ( PERIOD id_expression )*
            {
            // Commons.g:424:10: ( INTRODUCER char_set_name )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==INTRODUCER) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // Commons.g:424:11: INTRODUCER char_set_name
                    {
                    INTRODUCER252=(Token)match(input,INTRODUCER,FOLLOW_INTRODUCER_in_table_element4081); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INTRODUCER.add(INTRODUCER252);

                    pushFollow(FOLLOW_char_set_name_in_table_element4083);
                    char_set_name253=char_set_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_char_set_name.add(char_set_name253.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_id_expression_in_table_element4087);
            id_expression254=id_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id_expression.add(id_expression254.getTree());
            // Commons.g:424:52: ( PERIOD id_expression )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==PERIOD) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // Commons.g:424:53: PERIOD id_expression
            	    {
            	    PERIOD255=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_table_element4090); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD255);

            	    pushFollow(FOLLOW_id_expression_in_table_element4092);
            	    id_expression256=id_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_id_expression.add(id_expression256.getTree());

            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);



            // AST REWRITE
            // elements: char_set_name, id_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 425:10: -> ^( ANY_ELEMENT ( char_set_name )? ( id_expression )+ )
            {
                // Commons.g:425:13: ^( ANY_ELEMENT ( char_set_name )? ( id_expression )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ANY_ELEMENT, "ANY_ELEMENT"), root_1);

                // Commons.g:425:27: ( char_set_name )?
                if ( stream_char_set_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_char_set_name.nextTree());

                }
                stream_char_set_name.reset();
                if ( !(stream_id_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_id_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_id_expression.nextTree());

                }
                stream_id_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 601, table_element_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "table_element"

    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // Commons.g:432:1: constant : ( timestamp_key ( quoted_string | bind_variable ) ( at_key time_key zone_key quoted_string )? | interval_key ( quoted_string | bind_variable | general_element_part ) ( day_key | hour_key | minute_key | second_key ) ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )? RIGHT_PAREN )? ( to_key ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? ) )? | numeric | date_key quoted_string | quoted_string | null_key | true_key | false_key | dbtimezone_key | sessiontimezone_key | minvalue_key | maxvalue_key | default_key );
    public final OracleParser_Commons.constant_return constant() throws RecognitionException {
        OracleParser_Commons.constant_return retval = new OracleParser_Commons.constant_return();
        retval.start = input.LT(1);
        int constant_StartIndex = input.index();
        Object root_0 = null;

        Token LEFT_PAREN272=null;
        Token UNSIGNED_INTEGER273=null;
        Token COMMA275=null;
        Token UNSIGNED_INTEGER276=null;
        Token RIGHT_PAREN278=null;
        Token LEFT_PAREN284=null;
        Token UNSIGNED_INTEGER285=null;
        Token RIGHT_PAREN287=null;
        OracleParser_Keys.timestamp_key_return timestamp_key257 = null;

        OracleParser_Commons.quoted_string_return quoted_string258 = null;

        OracleParser_Commons.bind_variable_return bind_variable259 = null;

        OracleParser_Keys.at_key_return at_key260 = null;

        OracleParser_Keys.time_key_return time_key261 = null;

        OracleParser_Keys.zone_key_return zone_key262 = null;

        OracleParser_Commons.quoted_string_return quoted_string263 = null;

        OracleParser_Keys.interval_key_return interval_key264 = null;

        OracleParser_Commons.quoted_string_return quoted_string265 = null;

        OracleParser_Commons.bind_variable_return bind_variable266 = null;

        OracleParser_Commons.general_element_part_return general_element_part267 = null;

        OracleParser_Keys.day_key_return day_key268 = null;

        OracleParser_Keys.hour_key_return hour_key269 = null;

        OracleParser_Keys.minute_key_return minute_key270 = null;

        OracleParser_Keys.second_key_return second_key271 = null;

        OracleParser_Commons.bind_variable_return bind_variable274 = null;

        OracleParser_Commons.bind_variable_return bind_variable277 = null;

        OracleParser_Keys.to_key_return to_key279 = null;

        OracleParser_Keys.day_key_return day_key280 = null;

        OracleParser_Keys.hour_key_return hour_key281 = null;

        OracleParser_Keys.minute_key_return minute_key282 = null;

        OracleParser_Keys.second_key_return second_key283 = null;

        OracleParser_Commons.bind_variable_return bind_variable286 = null;

        OracleParser_Commons.numeric_return numeric288 = null;

        OracleParser_Keys.date_key_return date_key289 = null;

        OracleParser_Commons.quoted_string_return quoted_string290 = null;

        OracleParser_Commons.quoted_string_return quoted_string291 = null;

        OracleParser_Keys.null_key_return null_key292 = null;

        OracleParser_Keys.true_key_return true_key293 = null;

        OracleParser_Keys.false_key_return false_key294 = null;

        OracleParser_Keys.dbtimezone_key_return dbtimezone_key295 = null;

        OracleParser_Keys.sessiontimezone_key_return sessiontimezone_key296 = null;

        OracleParser_Keys.minvalue_key_return minvalue_key297 = null;

        OracleParser_Keys.maxvalue_key_return maxvalue_key298 = null;

        OracleParser_Keys.default_key_return default_key299 = null;


        Object LEFT_PAREN272_tree=null;
        Object UNSIGNED_INTEGER273_tree=null;
        Object COMMA275_tree=null;
        Object UNSIGNED_INTEGER276_tree=null;
        Object RIGHT_PAREN278_tree=null;
        Object LEFT_PAREN284_tree=null;
        Object UNSIGNED_INTEGER285_tree=null;
        Object RIGHT_PAREN287_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 602) ) { return retval; }
            // Commons.g:433:5: ( timestamp_key ( quoted_string | bind_variable ) ( at_key time_key zone_key quoted_string )? | interval_key ( quoted_string | bind_variable | general_element_part ) ( day_key | hour_key | minute_key | second_key ) ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )? RIGHT_PAREN )? ( to_key ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? ) )? | numeric | date_key quoted_string | quoted_string | null_key | true_key | false_key | dbtimezone_key | sessiontimezone_key | minvalue_key | maxvalue_key | default_key )
            int alt94=13;
            alt94 = dfa94.predict(input);
            switch (alt94) {
                case 1 :
                    // Commons.g:433:10: timestamp_key ( quoted_string | bind_variable ) ( at_key time_key zone_key quoted_string )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_timestamp_key_in_constant4139);
                    timestamp_key257=gOracleParser.timestamp_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timestamp_key257.getTree());
                    // Commons.g:433:24: ( quoted_string | bind_variable )
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==NATIONAL_CHAR_STRING_LIT||LA82_0==CHAR_STRING||LA82_0==CHAR_STRING_PERL) ) {
                        alt82=1;
                    }
                    else if ( (LA82_0==COLON||LA82_0==BINDVAR) ) {
                        alt82=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 82, 0, input);

                        throw nvae;
                    }
                    switch (alt82) {
                        case 1 :
                            // Commons.g:433:25: quoted_string
                            {
                            pushFollow(FOLLOW_quoted_string_in_constant4142);
                            quoted_string258=quoted_string();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, quoted_string258.getTree());

                            }
                            break;
                        case 2 :
                            // Commons.g:433:41: bind_variable
                            {
                            pushFollow(FOLLOW_bind_variable_in_constant4146);
                            bind_variable259=bind_variable();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, bind_variable259.getTree());

                            }
                            break;

                    }

                    // Commons.g:433:56: ( at_key time_key zone_key quoted_string )?
                    int alt83=2;
                    alt83 = dfa83.predict(input);
                    switch (alt83) {
                        case 1 :
                            // Commons.g:433:57: at_key time_key zone_key quoted_string
                            {
                            pushFollow(FOLLOW_at_key_in_constant4150);
                            at_key260=gOracleParser.at_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, at_key260.getTree());
                            pushFollow(FOLLOW_time_key_in_constant4152);
                            time_key261=gOracleParser.time_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, time_key261.getTree());
                            pushFollow(FOLLOW_zone_key_in_constant4154);
                            zone_key262=gOracleParser.zone_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, zone_key262.getTree());
                            pushFollow(FOLLOW_quoted_string_in_constant4156);
                            quoted_string263=quoted_string();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, quoted_string263.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // Commons.g:434:10: interval_key ( quoted_string | bind_variable | general_element_part ) ( day_key | hour_key | minute_key | second_key ) ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )? RIGHT_PAREN )? ( to_key ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? ) )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_interval_key_in_constant4169);
                    interval_key264=gOracleParser.interval_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, interval_key264.getTree());
                    // Commons.g:434:23: ( quoted_string | bind_variable | general_element_part )
                    int alt84=3;
                    switch ( input.LA(1) ) {
                    case NATIONAL_CHAR_STRING_LIT:
                    case CHAR_STRING:
                    case CHAR_STRING_PERL:
                        {
                        alt84=1;
                        }
                        break;
                    case COLON:
                    case BINDVAR:
                        {
                        alt84=2;
                        }
                        break;
                    case DELIMITED_ID:
                    case INTRODUCER:
                    case REGULAR_ID:
                        {
                        alt84=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 84, 0, input);

                        throw nvae;
                    }

                    switch (alt84) {
                        case 1 :
                            // Commons.g:434:24: quoted_string
                            {
                            pushFollow(FOLLOW_quoted_string_in_constant4172);
                            quoted_string265=quoted_string();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, quoted_string265.getTree());

                            }
                            break;
                        case 2 :
                            // Commons.g:434:40: bind_variable
                            {
                            pushFollow(FOLLOW_bind_variable_in_constant4176);
                            bind_variable266=bind_variable();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, bind_variable266.getTree());

                            }
                            break;
                        case 3 :
                            // Commons.g:434:56: general_element_part
                            {
                            pushFollow(FOLLOW_general_element_part_in_constant4180);
                            general_element_part267=general_element_part();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, general_element_part267.getTree());

                            }
                            break;

                    }

                    // Commons.g:435:10: ( day_key | hour_key | minute_key | second_key )
                    int alt85=4;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==REGULAR_ID) ) {
                        int LA85_1 = input.LA(2);

                        if ( ((synpred143_Commons()&&(input.LT(1).getText().equalsIgnoreCase("day")))) ) {
                            alt85=1;
                        }
                        else if ( ((synpred144_Commons()&&(input.LT(1).getText().equalsIgnoreCase("hour")))) ) {
                            alt85=2;
                        }
                        else if ( ((synpred145_Commons()&&(input.LT(1).getText().equalsIgnoreCase("minute")))) ) {
                            alt85=3;
                        }
                        else if ( ((input.LT(1).getText().equalsIgnoreCase("second"))) ) {
                            alt85=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 85, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 85, 0, input);

                        throw nvae;
                    }
                    switch (alt85) {
                        case 1 :
                            // Commons.g:435:12: day_key
                            {
                            pushFollow(FOLLOW_day_key_in_constant4194);
                            day_key268=gOracleParser.day_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, day_key268.getTree());

                            }
                            break;
                        case 2 :
                            // Commons.g:435:22: hour_key
                            {
                            pushFollow(FOLLOW_hour_key_in_constant4198);
                            hour_key269=gOracleParser.hour_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, hour_key269.getTree());

                            }
                            break;
                        case 3 :
                            // Commons.g:435:33: minute_key
                            {
                            pushFollow(FOLLOW_minute_key_in_constant4202);
                            minute_key270=gOracleParser.minute_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, minute_key270.getTree());

                            }
                            break;
                        case 4 :
                            // Commons.g:435:46: second_key
                            {
                            pushFollow(FOLLOW_second_key_in_constant4206);
                            second_key271=gOracleParser.second_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, second_key271.getTree());

                            }
                            break;

                    }

                    // Commons.g:436:10: ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )? RIGHT_PAREN )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==LEFT_PAREN) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // Commons.g:436:12: LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )? RIGHT_PAREN
                            {
                            LEFT_PAREN272=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_constant4220); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT_PAREN272_tree = (Object)adaptor.create(LEFT_PAREN272);
                            adaptor.addChild(root_0, LEFT_PAREN272_tree);
                            }
                            // Commons.g:436:23: ( UNSIGNED_INTEGER | bind_variable )
                            int alt86=2;
                            int LA86_0 = input.LA(1);

                            if ( (LA86_0==UNSIGNED_INTEGER) ) {
                                alt86=1;
                            }
                            else if ( (LA86_0==COLON||LA86_0==BINDVAR) ) {
                                alt86=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 86, 0, input);

                                throw nvae;
                            }
                            switch (alt86) {
                                case 1 :
                                    // Commons.g:436:24: UNSIGNED_INTEGER
                                    {
                                    UNSIGNED_INTEGER273=(Token)match(input,UNSIGNED_INTEGER,FOLLOW_UNSIGNED_INTEGER_in_constant4223); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    UNSIGNED_INTEGER273_tree = (Object)adaptor.create(UNSIGNED_INTEGER273);
                                    adaptor.addChild(root_0, UNSIGNED_INTEGER273_tree);
                                    }

                                    }
                                    break;
                                case 2 :
                                    // Commons.g:436:43: bind_variable
                                    {
                                    pushFollow(FOLLOW_bind_variable_in_constant4227);
                                    bind_variable274=bind_variable();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bind_variable274.getTree());

                                    }
                                    break;

                            }

                            // Commons.g:436:58: ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )?
                            int alt88=2;
                            int LA88_0 = input.LA(1);

                            if ( (LA88_0==COMMA) ) {
                                alt88=1;
                            }
                            switch (alt88) {
                                case 1 :
                                    // Commons.g:436:59: COMMA ( UNSIGNED_INTEGER | bind_variable )
                                    {
                                    COMMA275=(Token)match(input,COMMA,FOLLOW_COMMA_in_constant4231); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    COMMA275_tree = (Object)adaptor.create(COMMA275);
                                    adaptor.addChild(root_0, COMMA275_tree);
                                    }
                                    // Commons.g:436:65: ( UNSIGNED_INTEGER | bind_variable )
                                    int alt87=2;
                                    int LA87_0 = input.LA(1);

                                    if ( (LA87_0==UNSIGNED_INTEGER) ) {
                                        alt87=1;
                                    }
                                    else if ( (LA87_0==COLON||LA87_0==BINDVAR) ) {
                                        alt87=2;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return retval;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 87, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt87) {
                                        case 1 :
                                            // Commons.g:436:66: UNSIGNED_INTEGER
                                            {
                                            UNSIGNED_INTEGER276=(Token)match(input,UNSIGNED_INTEGER,FOLLOW_UNSIGNED_INTEGER_in_constant4234); if (state.failed) return retval;
                                            if ( state.backtracking==0 ) {
                                            UNSIGNED_INTEGER276_tree = (Object)adaptor.create(UNSIGNED_INTEGER276);
                                            adaptor.addChild(root_0, UNSIGNED_INTEGER276_tree);
                                            }

                                            }
                                            break;
                                        case 2 :
                                            // Commons.g:436:85: bind_variable
                                            {
                                            pushFollow(FOLLOW_bind_variable_in_constant4238);
                                            bind_variable277=bind_variable();

                                            state._fsp--;
                                            if (state.failed) return retval;
                                            if ( state.backtracking==0 ) adaptor.addChild(root_0, bind_variable277.getTree());

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }

                            RIGHT_PAREN278=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_constant4244); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT_PAREN278_tree = (Object)adaptor.create(RIGHT_PAREN278);
                            adaptor.addChild(root_0, RIGHT_PAREN278_tree);
                            }

                            }
                            break;

                    }

                    // Commons.g:437:10: ( to_key ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? ) )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==SQL92_RESERVED_TO) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // Commons.g:437:12: to_key ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? )
                            {
                            pushFollow(FOLLOW_to_key_in_constant4259);
                            to_key279=gOracleParser.to_key();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, to_key279.getTree());
                            // Commons.g:438:14: ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? )
                            int alt92=4;
                            int LA92_0 = input.LA(1);

                            if ( (LA92_0==REGULAR_ID) ) {
                                int LA92_1 = input.LA(2);

                                if ( ((synpred150_Commons()&&(input.LT(1).getText().equalsIgnoreCase("day")))) ) {
                                    alt92=1;
                                }
                                else if ( ((synpred151_Commons()&&(input.LT(1).getText().equalsIgnoreCase("hour")))) ) {
                                    alt92=2;
                                }
                                else if ( ((synpred152_Commons()&&(input.LT(1).getText().equalsIgnoreCase("minute")))) ) {
                                    alt92=3;
                                }
                                else if ( ((input.LT(1).getText().equalsIgnoreCase("second"))) ) {
                                    alt92=4;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 92, 1, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 92, 0, input);

                                throw nvae;
                            }
                            switch (alt92) {
                                case 1 :
                                    // Commons.g:438:16: day_key
                                    {
                                    pushFollow(FOLLOW_day_key_in_constant4276);
                                    day_key280=gOracleParser.day_key();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, day_key280.getTree());

                                    }
                                    break;
                                case 2 :
                                    // Commons.g:438:26: hour_key
                                    {
                                    pushFollow(FOLLOW_hour_key_in_constant4280);
                                    hour_key281=gOracleParser.hour_key();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hour_key281.getTree());

                                    }
                                    break;
                                case 3 :
                                    // Commons.g:438:37: minute_key
                                    {
                                    pushFollow(FOLLOW_minute_key_in_constant4284);
                                    minute_key282=gOracleParser.minute_key();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, minute_key282.getTree());

                                    }
                                    break;
                                case 4 :
                                    // Commons.g:438:50: second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )?
                                    {
                                    pushFollow(FOLLOW_second_key_in_constant4288);
                                    second_key283=gOracleParser.second_key();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, second_key283.getTree());
                                    // Commons.g:438:61: ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )?
                                    int alt91=2;
                                    int LA91_0 = input.LA(1);

                                    if ( (LA91_0==LEFT_PAREN) ) {
                                        alt91=1;
                                    }
                                    switch (alt91) {
                                        case 1 :
                                            // Commons.g:438:62: LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN
                                            {
                                            LEFT_PAREN284=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_constant4291); if (state.failed) return retval;
                                            if ( state.backtracking==0 ) {
                                            LEFT_PAREN284_tree = (Object)adaptor.create(LEFT_PAREN284);
                                            adaptor.addChild(root_0, LEFT_PAREN284_tree);
                                            }
                                            // Commons.g:438:73: ( UNSIGNED_INTEGER | bind_variable )
                                            int alt90=2;
                                            int LA90_0 = input.LA(1);

                                            if ( (LA90_0==UNSIGNED_INTEGER) ) {
                                                alt90=1;
                                            }
                                            else if ( (LA90_0==COLON||LA90_0==BINDVAR) ) {
                                                alt90=2;
                                            }
                                            else {
                                                if (state.backtracking>0) {state.failed=true; return retval;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 90, 0, input);

                                                throw nvae;
                                            }
                                            switch (alt90) {
                                                case 1 :
                                                    // Commons.g:438:74: UNSIGNED_INTEGER
                                                    {
                                                    UNSIGNED_INTEGER285=(Token)match(input,UNSIGNED_INTEGER,FOLLOW_UNSIGNED_INTEGER_in_constant4294); if (state.failed) return retval;
                                                    if ( state.backtracking==0 ) {
                                                    UNSIGNED_INTEGER285_tree = (Object)adaptor.create(UNSIGNED_INTEGER285);
                                                    adaptor.addChild(root_0, UNSIGNED_INTEGER285_tree);
                                                    }

                                                    }
                                                    break;
                                                case 2 :
                                                    // Commons.g:438:93: bind_variable
                                                    {
                                                    pushFollow(FOLLOW_bind_variable_in_constant4298);
                                                    bind_variable286=bind_variable();

                                                    state._fsp--;
                                                    if (state.failed) return retval;
                                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bind_variable286.getTree());

                                                    }
                                                    break;

                                            }

                                            RIGHT_PAREN287=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_constant4301); if (state.failed) return retval;
                                            if ( state.backtracking==0 ) {
                                            RIGHT_PAREN287_tree = (Object)adaptor.create(RIGHT_PAREN287);
                                            adaptor.addChild(root_0, RIGHT_PAREN287_tree);
                                            }

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // Commons.g:440:10: numeric
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numeric_in_constant4328);
                    numeric288=numeric();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric288.getTree());

                    }
                    break;
                case 4 :
                    // Commons.g:441:10: date_key quoted_string
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_date_key_in_constant4339);
                    date_key289=gOracleParser.date_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, date_key289.getTree());
                    pushFollow(FOLLOW_quoted_string_in_constant4341);
                    quoted_string290=quoted_string();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, quoted_string290.getTree());

                    }
                    break;
                case 5 :
                    // Commons.g:442:10: quoted_string
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_quoted_string_in_constant4352);
                    quoted_string291=quoted_string();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, quoted_string291.getTree());

                    }
                    break;
                case 6 :
                    // Commons.g:443:10: null_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_null_key_in_constant4363);
                    null_key292=gOracleParser.null_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, null_key292.getTree());

                    }
                    break;
                case 7 :
                    // Commons.g:444:10: true_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_true_key_in_constant4374);
                    true_key293=gOracleParser.true_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, true_key293.getTree());

                    }
                    break;
                case 8 :
                    // Commons.g:445:10: false_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_false_key_in_constant4385);
                    false_key294=gOracleParser.false_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, false_key294.getTree());

                    }
                    break;
                case 9 :
                    // Commons.g:446:10: dbtimezone_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_dbtimezone_key_in_constant4396);
                    dbtimezone_key295=gOracleParser.dbtimezone_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dbtimezone_key295.getTree());

                    }
                    break;
                case 10 :
                    // Commons.g:447:10: sessiontimezone_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_sessiontimezone_key_in_constant4408);
                    sessiontimezone_key296=gOracleParser.sessiontimezone_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sessiontimezone_key296.getTree());

                    }
                    break;
                case 11 :
                    // Commons.g:448:10: minvalue_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_minvalue_key_in_constant4419);
                    minvalue_key297=gOracleParser.minvalue_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, minvalue_key297.getTree());

                    }
                    break;
                case 12 :
                    // Commons.g:449:10: maxvalue_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_maxvalue_key_in_constant4430);
                    maxvalue_key298=gOracleParser.maxvalue_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, maxvalue_key298.getTree());

                    }
                    break;
                case 13 :
                    // Commons.g:450:10: default_key
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_default_key_in_constant4441);
                    default_key299=gOracleParser.default_key();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, default_key299.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 602, constant_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "constant"

    public static class numeric_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numeric"
    // Commons.g:453:1: numeric : ( UNSIGNED_INTEGER | EXACT_NUM_LIT | APPROXIMATE_NUM_LIT );
    public final OracleParser_Commons.numeric_return numeric() throws RecognitionException {
        OracleParser_Commons.numeric_return retval = new OracleParser_Commons.numeric_return();
        retval.start = input.LT(1);
        int numeric_StartIndex = input.index();
        Object root_0 = null;

        Token set300=null;

        Object set300_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 603) ) { return retval; }
            // Commons.g:454:5: ( UNSIGNED_INTEGER | EXACT_NUM_LIT | APPROXIMATE_NUM_LIT )
            // Commons.g:
            {
            root_0 = (Object)adaptor.nil();

            set300=(Token)input.LT(1);
            if ( (input.LA(1)>=UNSIGNED_INTEGER && input.LA(1)<=APPROXIMATE_NUM_LIT)||input.LA(1)==EXACT_NUM_LIT ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set300));
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

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 603, numeric_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "numeric"

    public static class quoted_string_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "quoted_string"
    // Commons.g:458:1: quoted_string : ( CHAR_STRING | CHAR_STRING_PERL | NATIONAL_CHAR_STRING_LIT );
    public final OracleParser_Commons.quoted_string_return quoted_string() throws RecognitionException {
        OracleParser_Commons.quoted_string_return retval = new OracleParser_Commons.quoted_string_return();
        retval.start = input.LT(1);
        int quoted_string_StartIndex = input.index();
        Object root_0 = null;

        Token set301=null;

        Object set301_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 604) ) { return retval; }
            // Commons.g:459:5: ( CHAR_STRING | CHAR_STRING_PERL | NATIONAL_CHAR_STRING_LIT )
            // Commons.g:
            {
            root_0 = (Object)adaptor.nil();

            set301=(Token)input.LT(1);
            if ( input.LA(1)==NATIONAL_CHAR_STRING_LIT||input.LA(1)==CHAR_STRING||input.LA(1)==CHAR_STRING_PERL ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set301));
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

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 604, quoted_string_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "quoted_string"

    public static class id_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "id"
    // Commons.g:464:1: id : ( INTRODUCER char_set_name )? id_expression -> ( char_set_name )? id_expression ;
    public final OracleParser_Commons.id_return id() throws RecognitionException {
        OracleParser_Commons.id_return retval = new OracleParser_Commons.id_return();
        retval.start = input.LT(1);
        int id_StartIndex = input.index();
        Object root_0 = null;

        Token INTRODUCER302=null;
        OracleParser_Commons.char_set_name_return char_set_name303 = null;

        OracleParser_Commons.id_expression_return id_expression304 = null;


        Object INTRODUCER302_tree=null;
        RewriteRuleTokenStream stream_INTRODUCER=new RewriteRuleTokenStream(adaptor,"token INTRODUCER");
        RewriteRuleSubtreeStream stream_id_expression=new RewriteRuleSubtreeStream(adaptor,"rule id_expression");
        RewriteRuleSubtreeStream stream_char_set_name=new RewriteRuleSubtreeStream(adaptor,"rule char_set_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 605) ) { return retval; }
            // Commons.g:465:5: ( ( INTRODUCER char_set_name )? id_expression -> ( char_set_name )? id_expression )
            // Commons.g:465:10: ( INTRODUCER char_set_name )? id_expression
            {
            // Commons.g:465:10: ( INTRODUCER char_set_name )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==INTRODUCER) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // Commons.g:465:11: INTRODUCER char_set_name
                    {
                    INTRODUCER302=(Token)match(input,INTRODUCER,FOLLOW_INTRODUCER_in_id4541); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INTRODUCER.add(INTRODUCER302);

                    pushFollow(FOLLOW_char_set_name_in_id4543);
                    char_set_name303=char_set_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_char_set_name.add(char_set_name303.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_id_expression_in_id4555);
            id_expression304=id_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id_expression.add(id_expression304.getTree());


            // AST REWRITE
            // elements: id_expression, char_set_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 467:9: -> ( char_set_name )? id_expression
            {
                // Commons.g:467:12: ( char_set_name )?
                if ( stream_char_set_name.hasNext() ) {
                    adaptor.addChild(root_0, stream_char_set_name.nextTree());

                }
                stream_char_set_name.reset();
                adaptor.addChild(root_0, stream_id_expression.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 605, id_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "id"

    public static class id_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "id_expression"
    // Commons.g:470:1: id_expression : ( REGULAR_ID -> ID[$REGULAR_ID] | DELIMITED_ID -> ID[$DELIMITED_ID] );
    public final OracleParser_Commons.id_expression_return id_expression() throws RecognitionException {
        OracleParser_Commons.id_expression_return retval = new OracleParser_Commons.id_expression_return();
        retval.start = input.LT(1);
        int id_expression_StartIndex = input.index();
        Object root_0 = null;

        Token REGULAR_ID305=null;
        Token DELIMITED_ID306=null;

        Object REGULAR_ID305_tree=null;
        Object DELIMITED_ID306_tree=null;
        RewriteRuleTokenStream stream_DELIMITED_ID=new RewriteRuleTokenStream(adaptor,"token DELIMITED_ID");
        RewriteRuleTokenStream stream_REGULAR_ID=new RewriteRuleTokenStream(adaptor,"token REGULAR_ID");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 606) ) { return retval; }
            // Commons.g:471:5: ( REGULAR_ID -> ID[$REGULAR_ID] | DELIMITED_ID -> ID[$DELIMITED_ID] )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==REGULAR_ID) ) {
                alt96=1;
            }
            else if ( (LA96_0==DELIMITED_ID) ) {
                alt96=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // Commons.g:471:10: REGULAR_ID
                    {
                    REGULAR_ID305=(Token)match(input,REGULAR_ID,FOLLOW_REGULAR_ID_in_id_expression4590); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_REGULAR_ID.add(REGULAR_ID305);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 471:21: -> ID[$REGULAR_ID]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(ID, REGULAR_ID305));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Commons.g:472:10: DELIMITED_ID
                    {
                    DELIMITED_ID306=(Token)match(input,DELIMITED_ID,FOLLOW_DELIMITED_ID_in_id_expression4609); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DELIMITED_ID.add(DELIMITED_ID306);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 472:23: -> ID[$DELIMITED_ID]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(ID, DELIMITED_ID306));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 606, id_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "id_expression"

    public static class not_equal_op_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "not_equal_op"
    // Commons.g:475:1: not_equal_op : ( NOT_EQUAL_OP | LESS_THAN_OP GREATER_THAN_OP | EXCLAMATION_OPERATOR_PART EQUALS_OP | CARRET_OPERATOR_PART EQUALS_OP );
    public final OracleParser_Commons.not_equal_op_return not_equal_op() throws RecognitionException {
        OracleParser_Commons.not_equal_op_return retval = new OracleParser_Commons.not_equal_op_return();
        retval.start = input.LT(1);
        int not_equal_op_StartIndex = input.index();
        Object root_0 = null;

        Token NOT_EQUAL_OP307=null;
        Token LESS_THAN_OP308=null;
        Token GREATER_THAN_OP309=null;
        Token EXCLAMATION_OPERATOR_PART310=null;
        Token EQUALS_OP311=null;
        Token CARRET_OPERATOR_PART312=null;
        Token EQUALS_OP313=null;

        Object NOT_EQUAL_OP307_tree=null;
        Object LESS_THAN_OP308_tree=null;
        Object GREATER_THAN_OP309_tree=null;
        Object EXCLAMATION_OPERATOR_PART310_tree=null;
        Object EQUALS_OP311_tree=null;
        Object CARRET_OPERATOR_PART312_tree=null;
        Object EQUALS_OP313_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 607) ) { return retval; }
            // Commons.g:476:5: ( NOT_EQUAL_OP | LESS_THAN_OP GREATER_THAN_OP | EXCLAMATION_OPERATOR_PART EQUALS_OP | CARRET_OPERATOR_PART EQUALS_OP )
            int alt97=4;
            switch ( input.LA(1) ) {
            case NOT_EQUAL_OP:
                {
                alt97=1;
                }
                break;
            case LESS_THAN_OP:
                {
                alt97=2;
                }
                break;
            case EXCLAMATION_OPERATOR_PART:
                {
                alt97=3;
                }
                break;
            case CARRET_OPERATOR_PART:
                {
                alt97=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // Commons.g:476:10: NOT_EQUAL_OP
                    {
                    root_0 = (Object)adaptor.nil();

                    NOT_EQUAL_OP307=(Token)match(input,NOT_EQUAL_OP,FOLLOW_NOT_EQUAL_OP_in_not_equal_op4638); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT_EQUAL_OP307_tree = (Object)adaptor.create(NOT_EQUAL_OP307);
                    adaptor.addChild(root_0, NOT_EQUAL_OP307_tree);
                    }

                    }
                    break;
                case 2 :
                    // Commons.g:477:10: LESS_THAN_OP GREATER_THAN_OP
                    {
                    root_0 = (Object)adaptor.nil();

                    LESS_THAN_OP308=(Token)match(input,LESS_THAN_OP,FOLLOW_LESS_THAN_OP_in_not_equal_op4649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LESS_THAN_OP308_tree = (Object)adaptor.create(LESS_THAN_OP308);
                    adaptor.addChild(root_0, LESS_THAN_OP308_tree);
                    }
                    GREATER_THAN_OP309=(Token)match(input,GREATER_THAN_OP,FOLLOW_GREATER_THAN_OP_in_not_equal_op4651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GREATER_THAN_OP309_tree = (Object)adaptor.create(GREATER_THAN_OP309);
                    adaptor.addChild(root_0, GREATER_THAN_OP309_tree);
                    }

                    }
                    break;
                case 3 :
                    // Commons.g:478:10: EXCLAMATION_OPERATOR_PART EQUALS_OP
                    {
                    root_0 = (Object)adaptor.nil();

                    EXCLAMATION_OPERATOR_PART310=(Token)match(input,EXCLAMATION_OPERATOR_PART,FOLLOW_EXCLAMATION_OPERATOR_PART_in_not_equal_op4662); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXCLAMATION_OPERATOR_PART310_tree = (Object)adaptor.create(EXCLAMATION_OPERATOR_PART310);
                    adaptor.addChild(root_0, EXCLAMATION_OPERATOR_PART310_tree);
                    }
                    EQUALS_OP311=(Token)match(input,EQUALS_OP,FOLLOW_EQUALS_OP_in_not_equal_op4664); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQUALS_OP311_tree = (Object)adaptor.create(EQUALS_OP311);
                    adaptor.addChild(root_0, EQUALS_OP311_tree);
                    }

                    }
                    break;
                case 4 :
                    // Commons.g:479:10: CARRET_OPERATOR_PART EQUALS_OP
                    {
                    root_0 = (Object)adaptor.nil();

                    CARRET_OPERATOR_PART312=(Token)match(input,CARRET_OPERATOR_PART,FOLLOW_CARRET_OPERATOR_PART_in_not_equal_op4675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CARRET_OPERATOR_PART312_tree = (Object)adaptor.create(CARRET_OPERATOR_PART312);
                    adaptor.addChild(root_0, CARRET_OPERATOR_PART312_tree);
                    }
                    EQUALS_OP313=(Token)match(input,EQUALS_OP,FOLLOW_EQUALS_OP_in_not_equal_op4677); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQUALS_OP313_tree = (Object)adaptor.create(EQUALS_OP313);
                    adaptor.addChild(root_0, EQUALS_OP313_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 607, not_equal_op_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "not_equal_op"

    public static class greater_than_or_equals_op_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "greater_than_or_equals_op"
    // Commons.g:482:1: greater_than_or_equals_op : ( GREATER_THAN_OR_EQUALS_OP | GREATER_THAN_OP EQUALS_OP );
    public final OracleParser_Commons.greater_than_or_equals_op_return greater_than_or_equals_op() throws RecognitionException {
        OracleParser_Commons.greater_than_or_equals_op_return retval = new OracleParser_Commons.greater_than_or_equals_op_return();
        retval.start = input.LT(1);
        int greater_than_or_equals_op_StartIndex = input.index();
        Object root_0 = null;

        Token GREATER_THAN_OR_EQUALS_OP314=null;
        Token GREATER_THAN_OP315=null;
        Token EQUALS_OP316=null;

        Object GREATER_THAN_OR_EQUALS_OP314_tree=null;
        Object GREATER_THAN_OP315_tree=null;
        Object EQUALS_OP316_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 608) ) { return retval; }
            // Commons.g:483:5: ( GREATER_THAN_OR_EQUALS_OP | GREATER_THAN_OP EQUALS_OP )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==GREATER_THAN_OR_EQUALS_OP) ) {
                alt98=1;
            }
            else if ( (LA98_0==GREATER_THAN_OP) ) {
                alt98=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // Commons.g:483:10: GREATER_THAN_OR_EQUALS_OP
                    {
                    root_0 = (Object)adaptor.nil();

                    GREATER_THAN_OR_EQUALS_OP314=(Token)match(input,GREATER_THAN_OR_EQUALS_OP,FOLLOW_GREATER_THAN_OR_EQUALS_OP_in_greater_than_or_equals_op4697); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GREATER_THAN_OR_EQUALS_OP314_tree = (Object)adaptor.create(GREATER_THAN_OR_EQUALS_OP314);
                    adaptor.addChild(root_0, GREATER_THAN_OR_EQUALS_OP314_tree);
                    }

                    }
                    break;
                case 2 :
                    // Commons.g:484:10: GREATER_THAN_OP EQUALS_OP
                    {
                    root_0 = (Object)adaptor.nil();

                    GREATER_THAN_OP315=(Token)match(input,GREATER_THAN_OP,FOLLOW_GREATER_THAN_OP_in_greater_than_or_equals_op4708); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GREATER_THAN_OP315_tree = (Object)adaptor.create(GREATER_THAN_OP315);
                    adaptor.addChild(root_0, GREATER_THAN_OP315_tree);
                    }
                    EQUALS_OP316=(Token)match(input,EQUALS_OP,FOLLOW_EQUALS_OP_in_greater_than_or_equals_op4710); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQUALS_OP316_tree = (Object)adaptor.create(EQUALS_OP316);
                    adaptor.addChild(root_0, EQUALS_OP316_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 608, greater_than_or_equals_op_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "greater_than_or_equals_op"

    public static class less_than_or_equals_op_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "less_than_or_equals_op"
    // Commons.g:487:1: less_than_or_equals_op : ( LESS_THAN_OR_EQUALS_OP | LESS_THAN_OP EQUALS_OP );
    public final OracleParser_Commons.less_than_or_equals_op_return less_than_or_equals_op() throws RecognitionException {
        OracleParser_Commons.less_than_or_equals_op_return retval = new OracleParser_Commons.less_than_or_equals_op_return();
        retval.start = input.LT(1);
        int less_than_or_equals_op_StartIndex = input.index();
        Object root_0 = null;

        Token LESS_THAN_OR_EQUALS_OP317=null;
        Token LESS_THAN_OP318=null;
        Token EQUALS_OP319=null;

        Object LESS_THAN_OR_EQUALS_OP317_tree=null;
        Object LESS_THAN_OP318_tree=null;
        Object EQUALS_OP319_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 609) ) { return retval; }
            // Commons.g:488:5: ( LESS_THAN_OR_EQUALS_OP | LESS_THAN_OP EQUALS_OP )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==LESS_THAN_OR_EQUALS_OP) ) {
                alt99=1;
            }
            else if ( (LA99_0==LESS_THAN_OP) ) {
                alt99=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // Commons.g:488:10: LESS_THAN_OR_EQUALS_OP
                    {
                    root_0 = (Object)adaptor.nil();

                    LESS_THAN_OR_EQUALS_OP317=(Token)match(input,LESS_THAN_OR_EQUALS_OP,FOLLOW_LESS_THAN_OR_EQUALS_OP_in_less_than_or_equals_op4730); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LESS_THAN_OR_EQUALS_OP317_tree = (Object)adaptor.create(LESS_THAN_OR_EQUALS_OP317);
                    adaptor.addChild(root_0, LESS_THAN_OR_EQUALS_OP317_tree);
                    }

                    }
                    break;
                case 2 :
                    // Commons.g:489:10: LESS_THAN_OP EQUALS_OP
                    {
                    root_0 = (Object)adaptor.nil();

                    LESS_THAN_OP318=(Token)match(input,LESS_THAN_OP,FOLLOW_LESS_THAN_OP_in_less_than_or_equals_op4741); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LESS_THAN_OP318_tree = (Object)adaptor.create(LESS_THAN_OP318);
                    adaptor.addChild(root_0, LESS_THAN_OP318_tree);
                    }
                    EQUALS_OP319=(Token)match(input,EQUALS_OP,FOLLOW_EQUALS_OP_in_less_than_or_equals_op4743); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQUALS_OP319_tree = (Object)adaptor.create(EQUALS_OP319);
                    adaptor.addChild(root_0, EQUALS_OP319_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 609, less_than_or_equals_op_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "less_than_or_equals_op"

    public static class concatenation_op_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concatenation_op"
    // Commons.g:492:1: concatenation_op : ( CONCATENATION_OP | VERTICAL_BAR VERTICAL_BAR );
    public final OracleParser_Commons.concatenation_op_return concatenation_op() throws RecognitionException {
        OracleParser_Commons.concatenation_op_return retval = new OracleParser_Commons.concatenation_op_return();
        retval.start = input.LT(1);
        int concatenation_op_StartIndex = input.index();
        Object root_0 = null;

        Token CONCATENATION_OP320=null;
        Token VERTICAL_BAR321=null;
        Token VERTICAL_BAR322=null;

        Object CONCATENATION_OP320_tree=null;
        Object VERTICAL_BAR321_tree=null;
        Object VERTICAL_BAR322_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 610) ) { return retval; }
            // Commons.g:493:5: ( CONCATENATION_OP | VERTICAL_BAR VERTICAL_BAR )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==CONCATENATION_OP) ) {
                alt100=1;
            }
            else if ( (LA100_0==VERTICAL_BAR) ) {
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
                    // Commons.g:493:10: CONCATENATION_OP
                    {
                    root_0 = (Object)adaptor.nil();

                    CONCATENATION_OP320=(Token)match(input,CONCATENATION_OP,FOLLOW_CONCATENATION_OP_in_concatenation_op4763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONCATENATION_OP320_tree = (Object)adaptor.create(CONCATENATION_OP320);
                    adaptor.addChild(root_0, CONCATENATION_OP320_tree);
                    }

                    }
                    break;
                case 2 :
                    // Commons.g:494:10: VERTICAL_BAR VERTICAL_BAR
                    {
                    root_0 = (Object)adaptor.nil();

                    VERTICAL_BAR321=(Token)match(input,VERTICAL_BAR,FOLLOW_VERTICAL_BAR_in_concatenation_op4774); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VERTICAL_BAR321_tree = (Object)adaptor.create(VERTICAL_BAR321);
                    adaptor.addChild(root_0, VERTICAL_BAR321_tree);
                    }
                    VERTICAL_BAR322=(Token)match(input,VERTICAL_BAR,FOLLOW_VERTICAL_BAR_in_concatenation_op4776); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VERTICAL_BAR322_tree = (Object)adaptor.create(VERTICAL_BAR322);
                    adaptor.addChild(root_0, VERTICAL_BAR322_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 610, concatenation_op_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "concatenation_op"

    public static class outer_join_sign_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "outer_join_sign"
    // Commons.g:497:1: outer_join_sign : LEFT_PAREN PLUS_SIGN RIGHT_PAREN ;
    public final OracleParser_Commons.outer_join_sign_return outer_join_sign() throws RecognitionException {
        OracleParser_Commons.outer_join_sign_return retval = new OracleParser_Commons.outer_join_sign_return();
        retval.start = input.LT(1);
        int outer_join_sign_StartIndex = input.index();
        Object root_0 = null;

        Token LEFT_PAREN323=null;
        Token PLUS_SIGN324=null;
        Token RIGHT_PAREN325=null;

        Object LEFT_PAREN323_tree=null;
        Object PLUS_SIGN324_tree=null;
        Object RIGHT_PAREN325_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 611) ) { return retval; }
            // Commons.g:498:5: ( LEFT_PAREN PLUS_SIGN RIGHT_PAREN )
            // Commons.g:498:10: LEFT_PAREN PLUS_SIGN RIGHT_PAREN
            {
            root_0 = (Object)adaptor.nil();

            LEFT_PAREN323=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_outer_join_sign4796); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LEFT_PAREN323_tree = (Object)adaptor.create(LEFT_PAREN323);
            adaptor.addChild(root_0, LEFT_PAREN323_tree);
            }
            PLUS_SIGN324=(Token)match(input,PLUS_SIGN,FOLLOW_PLUS_SIGN_in_outer_join_sign4798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PLUS_SIGN324_tree = (Object)adaptor.create(PLUS_SIGN324);
            adaptor.addChild(root_0, PLUS_SIGN324_tree);
            }
            RIGHT_PAREN325=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_outer_join_sign4800); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RIGHT_PAREN325_tree = (Object)adaptor.create(RIGHT_PAREN325);
            adaptor.addChild(root_0, RIGHT_PAREN325_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 611, outer_join_sign_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "outer_join_sign"

    // $ANTLR start synpred1_Commons
    public final void synpred1_Commons_fragment() throws RecognitionException {   
        // Commons.g:58:12: ( subpartition_key )
        // Commons.g:58:12: subpartition_key
        {
        pushFollow(FOLLOW_subpartition_key_in_synpred1_Commons366);
        gOracleParser.subpartition_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Commons

    // $ANTLR start synpred5_Commons
    public final void synpred5_Commons_fragment() throws RecognitionException {   
        // Commons.g:67:10: ( ( as_key )? ( id | alias_quoted_string ) )
        // Commons.g:67:10: ( as_key )? ( id | alias_quoted_string )
        {
        // Commons.g:67:10: ( as_key )?
        int alt101=2;
        int LA101_0 = input.LA(1);

        if ( (LA101_0==SQL92_RESERVED_AS) ) {
            alt101=1;
        }
        switch (alt101) {
            case 1 :
                // Commons.g:0:0: as_key
                {
                pushFollow(FOLLOW_as_key_in_synpred5_Commons418);
                gOracleParser.as_key();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        // Commons.g:67:18: ( id | alias_quoted_string )
        int alt102=2;
        int LA102_0 = input.LA(1);

        if ( (LA102_0==DELIMITED_ID||LA102_0==INTRODUCER||LA102_0==REGULAR_ID) ) {
            alt102=1;
        }
        else if ( (LA102_0==NATIONAL_CHAR_STRING_LIT||LA102_0==CHAR_STRING||LA102_0==CHAR_STRING_PERL) ) {
            alt102=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 102, 0, input);

            throw nvae;
        }
        switch (alt102) {
            case 1 :
                // Commons.g:67:19: id
                {
                pushFollow(FOLLOW_id_in_synpred5_Commons422);
                id();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // Commons.g:67:22: alias_quoted_string
                {
                pushFollow(FOLLOW_alias_quoted_string_in_synpred5_Commons424);
                alias_quoted_string();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred5_Commons

    // $ANTLR start synpred12_Commons
    public final void synpred12_Commons_fragment() throws RecognitionException {   
        // Commons.g:138:14: ( PERIOD id_expression )
        // Commons.g:138:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred12_Commons961); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred12_Commons963);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_Commons

    // $ANTLR start synpred14_Commons
    public final void synpred14_Commons_fragment() throws RecognitionException {   
        // Commons.g:148:14: ( PERIOD id_expression )
        // Commons.g:148:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred14_Commons1060); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred14_Commons1062);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_Commons

    // $ANTLR start synpred15_Commons
    public final void synpred15_Commons_fragment() throws RecognitionException {   
        // Commons.g:168:14: ( PERIOD id_expression )
        // Commons.g:168:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred15_Commons1221); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred15_Commons1223);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_Commons

    // $ANTLR start synpred16_Commons
    public final void synpred16_Commons_fragment() throws RecognitionException {   
        // Commons.g:178:14: ( PERIOD id_expression )
        // Commons.g:178:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred16_Commons1310); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred16_Commons1312);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_Commons

    // $ANTLR start synpred18_Commons
    public final void synpred18_Commons_fragment() throws RecognitionException {   
        // Commons.g:188:25: ( PERIOD id_expression )
        // Commons.g:188:26: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred18_Commons1409); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred18_Commons1411);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_Commons

    // $ANTLR start synpred19_Commons
    public final void synpred19_Commons_fragment() throws RecognitionException {   
        // Commons.g:193:25: ( PERIOD id_expression )
        // Commons.g:193:26: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred19_Commons1460); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred19_Commons1462);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_Commons

    // $ANTLR start synpred20_Commons
    public final void synpred20_Commons_fragment() throws RecognitionException {   
        // Commons.g:198:14: ( PERIOD id_expression )
        // Commons.g:198:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred20_Commons1511); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred20_Commons1513);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_Commons

    // $ANTLR start synpred21_Commons
    public final void synpred21_Commons_fragment() throws RecognitionException {   
        // Commons.g:203:14: ( PERIOD id_expression )
        // Commons.g:203:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred21_Commons1564); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred21_Commons1566);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_Commons

    // $ANTLR start synpred22_Commons
    public final void synpred22_Commons_fragment() throws RecognitionException {   
        // Commons.g:208:14: ( PERIOD id_expression )
        // Commons.g:208:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred22_Commons1617); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred22_Commons1619);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_Commons

    // $ANTLR start synpred23_Commons
    public final void synpred23_Commons_fragment() throws RecognitionException {   
        // Commons.g:213:14: ( PERIOD id_expression )
        // Commons.g:213:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred23_Commons1670); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred23_Commons1672);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_Commons

    // $ANTLR start synpred25_Commons
    public final void synpred25_Commons_fragment() throws RecognitionException {   
        // Commons.g:219:28: ( PERIOD id_expression )
        // Commons.g:219:29: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred25_Commons1741); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred25_Commons1743);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_Commons

    // $ANTLR start synpred29_Commons
    public final void synpred29_Commons_fragment() throws RecognitionException {   
        // Commons.g:241:14: ( PERIOD id_expression )
        // Commons.g:241:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred29_Commons1945); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred29_Commons1947);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_Commons

    // $ANTLR start synpred30_Commons
    public final void synpred30_Commons_fragment() throws RecognitionException {   
        // Commons.g:251:14: ( PERIOD id_expression )
        // Commons.g:251:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred30_Commons2033); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred30_Commons2035);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_Commons

    // $ANTLR start synpred31_Commons
    public final void synpred31_Commons_fragment() throws RecognitionException {   
        // Commons.g:256:14: ( PERIOD id_expression )
        // Commons.g:256:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred31_Commons2086); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred31_Commons2088);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_Commons

    // $ANTLR start synpred33_Commons
    public final void synpred33_Commons_fragment() throws RecognitionException {   
        // Commons.g:258:10: ({...}? => partition_extension_clause )
        // Commons.g:258:10: {...}? => partition_extension_clause
        {
        if ( !((!(input.LA(2) == SQL92_RESERVED_BY))) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_Commons", "!(input.LA(2) == SQL92_RESERVED_BY)");
        }
        pushFollow(FOLLOW_partition_extension_clause_in_synpred33_Commons2124);
        partition_extension_clause();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_Commons

    // $ANTLR start synpred34_Commons
    public final void synpred34_Commons_fragment() throws RecognitionException {   
        // Commons.g:264:25: ( PERIOD id_expression )
        // Commons.g:264:26: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred34_Commons2180); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred34_Commons2182);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_Commons

    // $ANTLR start synpred35_Commons
    public final void synpred35_Commons_fragment() throws RecognitionException {   
        // Commons.g:276:29: ( first_key )
        // Commons.g:276:29: first_key
        {
        pushFollow(FOLLOW_first_key_in_synpred35_Commons2259);
        gOracleParser.first_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_Commons

    // $ANTLR start synpred36_Commons
    public final void synpred36_Commons_fragment() throws RecognitionException {   
        // Commons.g:278:22: ( over_clause )
        // Commons.g:278:22: over_clause
        {
        pushFollow(FOLLOW_over_clause_in_synpred36_Commons2290);
        gOracleParser.over_clause();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_Commons

    // $ANTLR start synpred39_Commons
    public final void synpred39_Commons_fragment() throws RecognitionException {   
        // Commons.g:285:9: ( keep_clause )
        // Commons.g:285:9: keep_clause
        {
        pushFollow(FOLLOW_keep_clause_in_synpred39_Commons2356);
        keep_clause();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_Commons

    // $ANTLR start synpred40_Commons
    public final void synpred40_Commons_fragment() throws RecognitionException {   
        // Commons.g:291:23: ( respect_or_ignore_nulls )
        // Commons.g:291:23: respect_or_ignore_nulls
        {
        pushFollow(FOLLOW_respect_or_ignore_nulls_in_synpred40_Commons2414);
        respect_or_ignore_nulls();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_Commons

    // $ANTLR start synpred42_Commons
    public final void synpred42_Commons_fragment() throws RecognitionException {   
        // Commons.g:292:29: ( respect_or_ignore_nulls )
        // Commons.g:292:29: respect_or_ignore_nulls
        {
        pushFollow(FOLLOW_respect_or_ignore_nulls_in_synpred42_Commons2436);
        respect_or_ignore_nulls();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_Commons

    // $ANTLR start synpred44_Commons
    public final void synpred44_Commons_fragment() throws RecognitionException {   
        // Commons.g:294:10: ( keep_clause )
        // Commons.g:294:10: keep_clause
        {
        pushFollow(FOLLOW_keep_clause_in_synpred44_Commons2462);
        keep_clause();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_Commons

    // $ANTLR start synpred49_Commons
    public final void synpred49_Commons_fragment() throws RecognitionException {   
        // Commons.g:302:19: ( tableview_name PERIOD ASTERISK )
        // Commons.g:302:20: tableview_name PERIOD ASTERISK
        {
        pushFollow(FOLLOW_tableview_name_in_synpred49_Commons2577);
        tableview_name();

        state._fsp--;
        if (state.failed) return ;
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred49_Commons2579); if (state.failed) return ;
        match(input,ASTERISK,FOLLOW_ASTERISK_in_synpred49_Commons2581); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_Commons

    // $ANTLR start synpred54_Commons
    public final void synpred54_Commons_fragment() throws RecognitionException {   
        // Commons.g:307:10: ( keep_clause )
        // Commons.g:307:10: keep_clause
        {
        pushFollow(FOLLOW_keep_clause_in_synpred54_Commons2682);
        keep_clause();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_Commons

    // $ANTLR start synpred55_Commons
    public final void synpred55_Commons_fragment() throws RecognitionException {   
        // Commons.g:312:11: ( respect_key )
        // Commons.g:312:11: respect_key
        {
        pushFollow(FOLLOW_respect_key_in_synpred55_Commons2724);
        gOracleParser.respect_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_Commons

    // $ANTLR start synpred56_Commons
    public final void synpred56_Commons_fragment() throws RecognitionException {   
        // Commons.g:317:11: ( id EQUALS_OP GREATER_THAN_OP )
        // Commons.g:317:12: id EQUALS_OP GREATER_THAN_OP
        {
        pushFollow(FOLLOW_id_in_synpred56_Commons2761);
        id();

        state._fsp--;
        if (state.failed) return ;
        match(input,EQUALS_OP,FOLLOW_EQUALS_OP_in_synpred56_Commons2763); if (state.failed) return ;
        match(input,GREATER_THAN_OP,FOLLOW_GREATER_THAN_OP_in_synpred56_Commons2765); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_Commons

    // $ANTLR start synpred57_Commons
    public final void synpred57_Commons_fragment() throws RecognitionException {   
        // Commons.g:323:11: ( datatype )
        // Commons.g:323:11: datatype
        {
        pushFollow(FOLLOW_datatype_in_synpred57_Commons2840);
        datatype();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_Commons

    // $ANTLR start synpred58_Commons
    public final void synpred58_Commons_fragment() throws RecognitionException {   
        // Commons.g:324:10: ( ref_key )
        // Commons.g:324:10: ref_key
        {
        pushFollow(FOLLOW_ref_key_in_synpred58_Commons2851);
        gOracleParser.ref_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_Commons

    // $ANTLR start synpred59_Commons
    public final void synpred59_Commons_fragment() throws RecognitionException {   
        // Commons.g:324:30: ( percent_rowtype_key )
        // Commons.g:324:30: percent_rowtype_key
        {
        pushFollow(FOLLOW_percent_rowtype_key_in_synpred59_Commons2857);
        gOracleParser.percent_rowtype_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_Commons

    // $ANTLR start synpred60_Commons
    public final void synpred60_Commons_fragment() throws RecognitionException {   
        // Commons.g:324:50: ( percent_type_key )
        // Commons.g:324:50: percent_type_key
        {
        pushFollow(FOLLOW_percent_type_key_in_synpred60_Commons2859);
        gOracleParser.percent_type_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_Commons

    // $ANTLR start synpred62_Commons
    public final void synpred62_Commons_fragment() throws RecognitionException {   
        // Commons.g:330:19: ( local_key )
        // Commons.g:330:19: local_key
        {
        pushFollow(FOLLOW_local_key_in_synpred62_Commons2922);
        gOracleParser.local_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred62_Commons

    // $ANTLR start synpred64_Commons
    public final void synpred64_Commons_fragment() throws RecognitionException {   
        // Commons.g:328:10: ( native_datatype_element ( precision_part )? ( with_key ( local_key )? time_key zone_key )? )
        // Commons.g:328:10: native_datatype_element ( precision_part )? ( with_key ( local_key )? time_key zone_key )?
        {
        pushFollow(FOLLOW_native_datatype_element_in_synpred64_Commons2898);
        native_datatype_element();

        state._fsp--;
        if (state.failed) return ;
        // Commons.g:329:9: ( precision_part )?
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==LEFT_PAREN) ) {
            alt114=1;
        }
        switch (alt114) {
            case 1 :
                // Commons.g:0:0: precision_part
                {
                pushFollow(FOLLOW_precision_part_in_synpred64_Commons2908);
                precision_part();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        // Commons.g:330:9: ( with_key ( local_key )? time_key zone_key )?
        int alt116=2;
        int LA116_0 = input.LA(1);

        if ( (LA116_0==SQL92_RESERVED_WITH) ) {
            alt116=1;
        }
        switch (alt116) {
            case 1 :
                // Commons.g:330:10: with_key ( local_key )? time_key zone_key
                {
                pushFollow(FOLLOW_with_key_in_synpred64_Commons2920);
                gOracleParser.with_key();

                state._fsp--;
                if (state.failed) return ;
                // Commons.g:330:19: ( local_key )?
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==REGULAR_ID) ) {
                    int LA115_1 = input.LA(2);

                    if ( (LA115_1==REGULAR_ID) ) {
                        int LA115_2 = input.LA(3);

                        if ( (LA115_2==REGULAR_ID) ) {
                            alt115=1;
                        }
                    }
                }
                switch (alt115) {
                    case 1 :
                        // Commons.g:0:0: local_key
                        {
                        pushFollow(FOLLOW_local_key_in_synpred64_Commons2922);
                        gOracleParser.local_key();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }

                pushFollow(FOLLOW_time_key_in_synpred64_Commons2925);
                gOracleParser.time_key();

                state._fsp--;
                if (state.failed) return ;
                pushFollow(FOLLOW_zone_key_in_synpred64_Commons2927);
                gOracleParser.zone_key();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred64_Commons

    // $ANTLR start synpred65_Commons
    public final void synpred65_Commons_fragment() throws RecognitionException {   
        // Commons.g:332:24: ( year_key )
        // Commons.g:332:24: year_key
        {
        pushFollow(FOLLOW_year_key_in_synpred65_Commons2968);
        gOracleParser.year_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred65_Commons

    // $ANTLR start synpred67_Commons
    public final void synpred67_Commons_fragment() throws RecognitionException {   
        // Commons.g:334:21: ( month_key )
        // Commons.g:334:21: month_key
        {
        pushFollow(FOLLOW_month_key_in_synpred67_Commons3014);
        gOracleParser.month_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred67_Commons

    // $ANTLR start synpred70_Commons
    public final void synpred70_Commons_fragment() throws RecognitionException {   
        // Commons.g:340:47: ( char_key )
        // Commons.g:340:47: char_key
        {
        pushFollow(FOLLOW_char_key_in_synpred70_Commons3105);
        gOracleParser.char_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred70_Commons

    // $ANTLR start synpred71_Commons
    public final void synpred71_Commons_fragment() throws RecognitionException {   
        // Commons.g:340:58: ( byte_key )
        // Commons.g:340:58: byte_key
        {
        pushFollow(FOLLOW_byte_key_in_synpred71_Commons3109);
        gOracleParser.byte_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred71_Commons

    // $ANTLR start synpred72_Commons
    public final void synpred72_Commons_fragment() throws RecognitionException {   
        // Commons.g:345:10: ( binary_integer_key )
        // Commons.g:345:10: binary_integer_key
        {
        pushFollow(FOLLOW_binary_integer_key_in_synpred72_Commons3156);
        gOracleParser.binary_integer_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred72_Commons

    // $ANTLR start synpred73_Commons
    public final void synpred73_Commons_fragment() throws RecognitionException {   
        // Commons.g:346:10: ( pls_integer_key )
        // Commons.g:346:10: pls_integer_key
        {
        pushFollow(FOLLOW_pls_integer_key_in_synpred73_Commons3167);
        gOracleParser.pls_integer_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred73_Commons

    // $ANTLR start synpred74_Commons
    public final void synpred74_Commons_fragment() throws RecognitionException {   
        // Commons.g:347:10: ( natural_key )
        // Commons.g:347:10: natural_key
        {
        pushFollow(FOLLOW_natural_key_in_synpred74_Commons3178);
        gOracleParser.natural_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred74_Commons

    // $ANTLR start synpred75_Commons
    public final void synpred75_Commons_fragment() throws RecognitionException {   
        // Commons.g:348:10: ( binary_float_key )
        // Commons.g:348:10: binary_float_key
        {
        pushFollow(FOLLOW_binary_float_key_in_synpred75_Commons3189);
        gOracleParser.binary_float_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred75_Commons

    // $ANTLR start synpred76_Commons
    public final void synpred76_Commons_fragment() throws RecognitionException {   
        // Commons.g:349:10: ( binary_double_key )
        // Commons.g:349:10: binary_double_key
        {
        pushFollow(FOLLOW_binary_double_key_in_synpred76_Commons3200);
        gOracleParser.binary_double_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred76_Commons

    // $ANTLR start synpred77_Commons
    public final void synpred77_Commons_fragment() throws RecognitionException {   
        // Commons.g:350:10: ( naturaln_key )
        // Commons.g:350:10: naturaln_key
        {
        pushFollow(FOLLOW_naturaln_key_in_synpred77_Commons3211);
        gOracleParser.naturaln_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred77_Commons

    // $ANTLR start synpred78_Commons
    public final void synpred78_Commons_fragment() throws RecognitionException {   
        // Commons.g:351:10: ( positive_key )
        // Commons.g:351:10: positive_key
        {
        pushFollow(FOLLOW_positive_key_in_synpred78_Commons3222);
        gOracleParser.positive_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred78_Commons

    // $ANTLR start synpred79_Commons
    public final void synpred79_Commons_fragment() throws RecognitionException {   
        // Commons.g:352:10: ( positiven_key )
        // Commons.g:352:10: positiven_key
        {
        pushFollow(FOLLOW_positiven_key_in_synpred79_Commons3233);
        gOracleParser.positiven_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred79_Commons

    // $ANTLR start synpred80_Commons
    public final void synpred80_Commons_fragment() throws RecognitionException {   
        // Commons.g:353:10: ( signtype_key )
        // Commons.g:353:10: signtype_key
        {
        pushFollow(FOLLOW_signtype_key_in_synpred80_Commons3244);
        gOracleParser.signtype_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_Commons

    // $ANTLR start synpred81_Commons
    public final void synpred81_Commons_fragment() throws RecognitionException {   
        // Commons.g:354:10: ( simple_integer_key )
        // Commons.g:354:10: simple_integer_key
        {
        pushFollow(FOLLOW_simple_integer_key_in_synpred81_Commons3255);
        gOracleParser.simple_integer_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred81_Commons

    // $ANTLR start synpred82_Commons
    public final void synpred82_Commons_fragment() throws RecognitionException {   
        // Commons.g:355:10: ( nvarchar2_key )
        // Commons.g:355:10: nvarchar2_key
        {
        pushFollow(FOLLOW_nvarchar2_key_in_synpred82_Commons3266);
        gOracleParser.nvarchar2_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred82_Commons

    // $ANTLR start synpred83_Commons
    public final void synpred83_Commons_fragment() throws RecognitionException {   
        // Commons.g:356:10: ( dec_key )
        // Commons.g:356:10: dec_key
        {
        pushFollow(FOLLOW_dec_key_in_synpred83_Commons3277);
        gOracleParser.dec_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred83_Commons

    // $ANTLR start synpred84_Commons
    public final void synpred84_Commons_fragment() throws RecognitionException {   
        // Commons.g:357:10: ( integer_key )
        // Commons.g:357:10: integer_key
        {
        pushFollow(FOLLOW_integer_key_in_synpred84_Commons3288);
        gOracleParser.integer_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred84_Commons

    // $ANTLR start synpred85_Commons
    public final void synpred85_Commons_fragment() throws RecognitionException {   
        // Commons.g:358:10: ( int_key )
        // Commons.g:358:10: int_key
        {
        pushFollow(FOLLOW_int_key_in_synpred85_Commons3299);
        gOracleParser.int_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred85_Commons

    // $ANTLR start synpred86_Commons
    public final void synpred86_Commons_fragment() throws RecognitionException {   
        // Commons.g:359:10: ( numeric_key )
        // Commons.g:359:10: numeric_key
        {
        pushFollow(FOLLOW_numeric_key_in_synpred86_Commons3310);
        gOracleParser.numeric_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_Commons

    // $ANTLR start synpred87_Commons
    public final void synpred87_Commons_fragment() throws RecognitionException {   
        // Commons.g:360:10: ( smallint_key )
        // Commons.g:360:10: smallint_key
        {
        pushFollow(FOLLOW_smallint_key_in_synpred87_Commons3321);
        gOracleParser.smallint_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred87_Commons

    // $ANTLR start synpred88_Commons
    public final void synpred88_Commons_fragment() throws RecognitionException {   
        // Commons.g:361:10: ( number_key )
        // Commons.g:361:10: number_key
        {
        pushFollow(FOLLOW_number_key_in_synpred88_Commons3332);
        gOracleParser.number_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_Commons

    // $ANTLR start synpred89_Commons
    public final void synpred89_Commons_fragment() throws RecognitionException {   
        // Commons.g:362:10: ( decimal_key )
        // Commons.g:362:10: decimal_key
        {
        pushFollow(FOLLOW_decimal_key_in_synpred89_Commons3343);
        gOracleParser.decimal_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred89_Commons

    // $ANTLR start synpred90_Commons
    public final void synpred90_Commons_fragment() throws RecognitionException {   
        // Commons.g:363:21: ( precision_key )
        // Commons.g:363:21: precision_key
        {
        pushFollow(FOLLOW_precision_key_in_synpred90_Commons3357);
        gOracleParser.precision_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_Commons

    // $ANTLR start synpred91_Commons
    public final void synpred91_Commons_fragment() throws RecognitionException {   
        // Commons.g:363:10: ( double_key ( precision_key )? )
        // Commons.g:363:10: double_key ( precision_key )?
        {
        pushFollow(FOLLOW_double_key_in_synpred91_Commons3355);
        gOracleParser.double_key();

        state._fsp--;
        if (state.failed) return ;
        // Commons.g:363:21: ( precision_key )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==REGULAR_ID) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // Commons.g:0:0: precision_key
                {
                pushFollow(FOLLOW_precision_key_in_synpred91_Commons3357);
                gOracleParser.precision_key();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred91_Commons

    // $ANTLR start synpred92_Commons
    public final void synpred92_Commons_fragment() throws RecognitionException {   
        // Commons.g:364:10: ( float_key )
        // Commons.g:364:10: float_key
        {
        pushFollow(FOLLOW_float_key_in_synpred92_Commons3369);
        gOracleParser.float_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred92_Commons

    // $ANTLR start synpred93_Commons
    public final void synpred93_Commons_fragment() throws RecognitionException {   
        // Commons.g:365:10: ( real_key )
        // Commons.g:365:10: real_key
        {
        pushFollow(FOLLOW_real_key_in_synpred93_Commons3380);
        gOracleParser.real_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred93_Commons

    // $ANTLR start synpred94_Commons
    public final void synpred94_Commons_fragment() throws RecognitionException {   
        // Commons.g:366:10: ( nchar_key )
        // Commons.g:366:10: nchar_key
        {
        pushFollow(FOLLOW_nchar_key_in_synpred94_Commons3391);
        gOracleParser.nchar_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred94_Commons

    // $ANTLR start synpred95_Commons
    public final void synpred95_Commons_fragment() throws RecognitionException {   
        // Commons.g:367:19: ( raw_key )
        // Commons.g:367:19: raw_key
        {
        pushFollow(FOLLOW_raw_key_in_synpred95_Commons3404);
        gOracleParser.raw_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred95_Commons

    // $ANTLR start synpred96_Commons
    public final void synpred96_Commons_fragment() throws RecognitionException {   
        // Commons.g:367:10: ( long_key ( raw_key )? )
        // Commons.g:367:10: long_key ( raw_key )?
        {
        pushFollow(FOLLOW_long_key_in_synpred96_Commons3402);
        gOracleParser.long_key();

        state._fsp--;
        if (state.failed) return ;
        // Commons.g:367:19: ( raw_key )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==REGULAR_ID) && ((input.LT(1).getText().equalsIgnoreCase("raw")))) {
            alt118=1;
        }
        switch (alt118) {
            case 1 :
                // Commons.g:0:0: raw_key
                {
                pushFollow(FOLLOW_raw_key_in_synpred96_Commons3404);
                gOracleParser.raw_key();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred96_Commons

    // $ANTLR start synpred97_Commons
    public final void synpred97_Commons_fragment() throws RecognitionException {   
        // Commons.g:368:10: ( char_key )
        // Commons.g:368:10: char_key
        {
        pushFollow(FOLLOW_char_key_in_synpred97_Commons3416);
        gOracleParser.char_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred97_Commons

    // $ANTLR start synpred98_Commons
    public final void synpred98_Commons_fragment() throws RecognitionException {   
        // Commons.g:369:10: ( character_key )
        // Commons.g:369:10: character_key
        {
        pushFollow(FOLLOW_character_key_in_synpred98_Commons3429);
        gOracleParser.character_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred98_Commons

    // $ANTLR start synpred99_Commons
    public final void synpred99_Commons_fragment() throws RecognitionException {   
        // Commons.g:370:10: ( varchar2_key )
        // Commons.g:370:10: varchar2_key
        {
        pushFollow(FOLLOW_varchar2_key_in_synpred99_Commons3441);
        gOracleParser.varchar2_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_Commons

    // $ANTLR start synpred100_Commons
    public final void synpred100_Commons_fragment() throws RecognitionException {   
        // Commons.g:371:10: ( varchar_key )
        // Commons.g:371:10: varchar_key
        {
        pushFollow(FOLLOW_varchar_key_in_synpred100_Commons3452);
        gOracleParser.varchar_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred100_Commons

    // $ANTLR start synpred101_Commons
    public final void synpred101_Commons_fragment() throws RecognitionException {   
        // Commons.g:372:10: ( string_key )
        // Commons.g:372:10: string_key
        {
        pushFollow(FOLLOW_string_key_in_synpred101_Commons3463);
        gOracleParser.string_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred101_Commons

    // $ANTLR start synpred102_Commons
    public final void synpred102_Commons_fragment() throws RecognitionException {   
        // Commons.g:373:10: ( raw_key )
        // Commons.g:373:10: raw_key
        {
        pushFollow(FOLLOW_raw_key_in_synpred102_Commons3474);
        gOracleParser.raw_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred102_Commons

    // $ANTLR start synpred103_Commons
    public final void synpred103_Commons_fragment() throws RecognitionException {   
        // Commons.g:374:10: ( boolean_key )
        // Commons.g:374:10: boolean_key
        {
        pushFollow(FOLLOW_boolean_key_in_synpred103_Commons3485);
        gOracleParser.boolean_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_Commons

    // $ANTLR start synpred105_Commons
    public final void synpred105_Commons_fragment() throws RecognitionException {   
        // Commons.g:376:10: ( rowid_key )
        // Commons.g:376:10: rowid_key
        {
        pushFollow(FOLLOW_rowid_key_in_synpred105_Commons3507);
        gOracleParser.rowid_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred105_Commons

    // $ANTLR start synpred106_Commons
    public final void synpred106_Commons_fragment() throws RecognitionException {   
        // Commons.g:377:10: ( urowid_key )
        // Commons.g:377:10: urowid_key
        {
        pushFollow(FOLLOW_urowid_key_in_synpred106_Commons3518);
        gOracleParser.urowid_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred106_Commons

    // $ANTLR start synpred107_Commons
    public final void synpred107_Commons_fragment() throws RecognitionException {   
        // Commons.g:378:10: ( year_key )
        // Commons.g:378:10: year_key
        {
        pushFollow(FOLLOW_year_key_in_synpred107_Commons3529);
        gOracleParser.year_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred107_Commons

    // $ANTLR start synpred108_Commons
    public final void synpred108_Commons_fragment() throws RecognitionException {   
        // Commons.g:379:10: ( month_key )
        // Commons.g:379:10: month_key
        {
        pushFollow(FOLLOW_month_key_in_synpred108_Commons3540);
        gOracleParser.month_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred108_Commons

    // $ANTLR start synpred109_Commons
    public final void synpred109_Commons_fragment() throws RecognitionException {   
        // Commons.g:380:10: ( day_key )
        // Commons.g:380:10: day_key
        {
        pushFollow(FOLLOW_day_key_in_synpred109_Commons3551);
        gOracleParser.day_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred109_Commons

    // $ANTLR start synpred110_Commons
    public final void synpred110_Commons_fragment() throws RecognitionException {   
        // Commons.g:381:10: ( hour_key )
        // Commons.g:381:10: hour_key
        {
        pushFollow(FOLLOW_hour_key_in_synpred110_Commons3562);
        gOracleParser.hour_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred110_Commons

    // $ANTLR start synpred111_Commons
    public final void synpred111_Commons_fragment() throws RecognitionException {   
        // Commons.g:382:10: ( minute_key )
        // Commons.g:382:10: minute_key
        {
        pushFollow(FOLLOW_minute_key_in_synpred111_Commons3573);
        gOracleParser.minute_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred111_Commons

    // $ANTLR start synpred112_Commons
    public final void synpred112_Commons_fragment() throws RecognitionException {   
        // Commons.g:383:10: ( second_key )
        // Commons.g:383:10: second_key
        {
        pushFollow(FOLLOW_second_key_in_synpred112_Commons3584);
        gOracleParser.second_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred112_Commons

    // $ANTLR start synpred113_Commons
    public final void synpred113_Commons_fragment() throws RecognitionException {   
        // Commons.g:384:10: ( timezone_hour_key )
        // Commons.g:384:10: timezone_hour_key
        {
        pushFollow(FOLLOW_timezone_hour_key_in_synpred113_Commons3595);
        gOracleParser.timezone_hour_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred113_Commons

    // $ANTLR start synpred114_Commons
    public final void synpred114_Commons_fragment() throws RecognitionException {   
        // Commons.g:385:10: ( timezone_minute_key )
        // Commons.g:385:10: timezone_minute_key
        {
        pushFollow(FOLLOW_timezone_minute_key_in_synpred114_Commons3606);
        gOracleParser.timezone_minute_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred114_Commons

    // $ANTLR start synpred115_Commons
    public final void synpred115_Commons_fragment() throws RecognitionException {   
        // Commons.g:386:10: ( timezone_region_key )
        // Commons.g:386:10: timezone_region_key
        {
        pushFollow(FOLLOW_timezone_region_key_in_synpred115_Commons3617);
        gOracleParser.timezone_region_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred115_Commons

    // $ANTLR start synpred116_Commons
    public final void synpred116_Commons_fragment() throws RecognitionException {   
        // Commons.g:387:10: ( timezone_abbr_key )
        // Commons.g:387:10: timezone_abbr_key
        {
        pushFollow(FOLLOW_timezone_abbr_key_in_synpred116_Commons3628);
        gOracleParser.timezone_abbr_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred116_Commons

    // $ANTLR start synpred117_Commons
    public final void synpred117_Commons_fragment() throws RecognitionException {   
        // Commons.g:388:10: ( timestamp_key )
        // Commons.g:388:10: timestamp_key
        {
        pushFollow(FOLLOW_timestamp_key_in_synpred117_Commons3639);
        gOracleParser.timestamp_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred117_Commons

    // $ANTLR start synpred118_Commons
    public final void synpred118_Commons_fragment() throws RecognitionException {   
        // Commons.g:389:10: ( timestamp_unconstrained_key )
        // Commons.g:389:10: timestamp_unconstrained_key
        {
        pushFollow(FOLLOW_timestamp_unconstrained_key_in_synpred118_Commons3650);
        gOracleParser.timestamp_unconstrained_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred118_Commons

    // $ANTLR start synpred119_Commons
    public final void synpred119_Commons_fragment() throws RecognitionException {   
        // Commons.g:390:10: ( timestamp_tz_unconstrained_key )
        // Commons.g:390:10: timestamp_tz_unconstrained_key
        {
        pushFollow(FOLLOW_timestamp_tz_unconstrained_key_in_synpred119_Commons3661);
        gOracleParser.timestamp_tz_unconstrained_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred119_Commons

    // $ANTLR start synpred120_Commons
    public final void synpred120_Commons_fragment() throws RecognitionException {   
        // Commons.g:391:10: ( timestamp_ltz_unconstrained_key )
        // Commons.g:391:10: timestamp_ltz_unconstrained_key
        {
        pushFollow(FOLLOW_timestamp_ltz_unconstrained_key_in_synpred120_Commons3672);
        gOracleParser.timestamp_ltz_unconstrained_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred120_Commons

    // $ANTLR start synpred121_Commons
    public final void synpred121_Commons_fragment() throws RecognitionException {   
        // Commons.g:392:10: ( yminterval_unconstrained_key )
        // Commons.g:392:10: yminterval_unconstrained_key
        {
        pushFollow(FOLLOW_yminterval_unconstrained_key_in_synpred121_Commons3683);
        gOracleParser.yminterval_unconstrained_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred121_Commons

    // $ANTLR start synpred122_Commons
    public final void synpred122_Commons_fragment() throws RecognitionException {   
        // Commons.g:393:10: ( dsinterval_unconstrained_key )
        // Commons.g:393:10: dsinterval_unconstrained_key
        {
        pushFollow(FOLLOW_dsinterval_unconstrained_key_in_synpred122_Commons3694);
        gOracleParser.dsinterval_unconstrained_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred122_Commons

    // $ANTLR start synpred123_Commons
    public final void synpred123_Commons_fragment() throws RecognitionException {   
        // Commons.g:394:10: ( bfile_key )
        // Commons.g:394:10: bfile_key
        {
        pushFollow(FOLLOW_bfile_key_in_synpred123_Commons3705);
        gOracleParser.bfile_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred123_Commons

    // $ANTLR start synpred124_Commons
    public final void synpred124_Commons_fragment() throws RecognitionException {   
        // Commons.g:395:10: ( blob_key )
        // Commons.g:395:10: blob_key
        {
        pushFollow(FOLLOW_blob_key_in_synpred124_Commons3716);
        gOracleParser.blob_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred124_Commons

    // $ANTLR start synpred125_Commons
    public final void synpred125_Commons_fragment() throws RecognitionException {   
        // Commons.g:396:10: ( clob_key )
        // Commons.g:396:10: clob_key
        {
        pushFollow(FOLLOW_clob_key_in_synpred125_Commons3727);
        gOracleParser.clob_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred125_Commons

    // $ANTLR start synpred126_Commons
    public final void synpred126_Commons_fragment() throws RecognitionException {   
        // Commons.g:397:10: ( nclob_key )
        // Commons.g:397:10: nclob_key
        {
        pushFollow(FOLLOW_nclob_key_in_synpred126_Commons3738);
        gOracleParser.nclob_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred126_Commons

    // $ANTLR start synpred130_Commons
    public final void synpred130_Commons_fragment() throws RecognitionException {   
        Token b2=null;
        Token u2=null;

        // Commons.g:403:12: ( ( indicator_key )? (b2= BINDVAR | COLON u2= UNSIGNED_INTEGER ) )
        // Commons.g:403:12: ( indicator_key )? (b2= BINDVAR | COLON u2= UNSIGNED_INTEGER )
        {
        // Commons.g:403:12: ( indicator_key )?
        int alt119=2;
        int LA119_0 = input.LA(1);

        if ( (LA119_0==REGULAR_ID) ) {
            alt119=1;
        }
        switch (alt119) {
            case 1 :
                // Commons.g:0:0: indicator_key
                {
                pushFollow(FOLLOW_indicator_key_in_synpred130_Commons3795);
                gOracleParser.indicator_key();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        // Commons.g:403:27: (b2= BINDVAR | COLON u2= UNSIGNED_INTEGER )
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==BINDVAR) ) {
            alt120=1;
        }
        else if ( (LA120_0==COLON) ) {
            alt120=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 120, 0, input);

            throw nvae;
        }
        switch (alt120) {
            case 1 :
                // Commons.g:403:28: b2= BINDVAR
                {
                b2=(Token)match(input,BINDVAR,FOLLOW_BINDVAR_in_synpred130_Commons3801); if (state.failed) return ;

                }
                break;
            case 2 :
                // Commons.g:403:41: COLON u2= UNSIGNED_INTEGER
                {
                match(input,COLON,FOLLOW_COLON_in_synpred130_Commons3805); if (state.failed) return ;
                u2=(Token)match(input,UNSIGNED_INTEGER,FOLLOW_UNSIGNED_INTEGER_in_synpred130_Commons3809); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred130_Commons

    // $ANTLR start synpred131_Commons
    public final void synpred131_Commons_fragment() throws RecognitionException {   
        // Commons.g:404:11: ( PERIOD general_element_part )
        // Commons.g:404:12: PERIOD general_element_part
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred131_Commons3825); if (state.failed) return ;
        pushFollow(FOLLOW_general_element_part_in_synpred131_Commons3827);
        general_element_part();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred131_Commons

    // $ANTLR start synpred132_Commons
    public final void synpred132_Commons_fragment() throws RecognitionException {   
        // Commons.g:410:32: ( PERIOD general_element_part )
        // Commons.g:410:33: PERIOD general_element_part
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred132_Commons3903); if (state.failed) return ;
        pushFollow(FOLLOW_general_element_part_in_synpred132_Commons3905);
        general_element_part();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred132_Commons

    // $ANTLR start synpred134_Commons
    public final void synpred134_Commons_fragment() throws RecognitionException {   
        // Commons.g:418:14: ( PERIOD id_expression )
        // Commons.g:418:15: PERIOD id_expression
        {
        match(input,PERIOD,FOLLOW_PERIOD_in_synpred134_Commons3996); if (state.failed) return ;
        pushFollow(FOLLOW_id_expression_in_synpred134_Commons3998);
        id_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred134_Commons

    // $ANTLR start synpred135_Commons
    public final void synpred135_Commons_fragment() throws RecognitionException {   
        // Commons.g:418:63: ( function_argument )
        // Commons.g:418:63: function_argument
        {
        pushFollow(FOLLOW_function_argument_in_synpred135_Commons4009);
        function_argument();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred135_Commons

    // $ANTLR start synpred139_Commons
    public final void synpred139_Commons_fragment() throws RecognitionException {   
        // Commons.g:433:57: ( at_key time_key zone_key quoted_string )
        // Commons.g:433:57: at_key time_key zone_key quoted_string
        {
        pushFollow(FOLLOW_at_key_in_synpred139_Commons4150);
        gOracleParser.at_key();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_time_key_in_synpred139_Commons4152);
        gOracleParser.time_key();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_zone_key_in_synpred139_Commons4154);
        gOracleParser.zone_key();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_quoted_string_in_synpred139_Commons4156);
        quoted_string();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred139_Commons

    // $ANTLR start synpred140_Commons
    public final void synpred140_Commons_fragment() throws RecognitionException {   
        // Commons.g:433:10: ( timestamp_key ( quoted_string | bind_variable ) ( at_key time_key zone_key quoted_string )? )
        // Commons.g:433:10: timestamp_key ( quoted_string | bind_variable ) ( at_key time_key zone_key quoted_string )?
        {
        pushFollow(FOLLOW_timestamp_key_in_synpred140_Commons4139);
        gOracleParser.timestamp_key();

        state._fsp--;
        if (state.failed) return ;
        // Commons.g:433:24: ( quoted_string | bind_variable )
        int alt121=2;
        int LA121_0 = input.LA(1);

        if ( (LA121_0==NATIONAL_CHAR_STRING_LIT||LA121_0==CHAR_STRING||LA121_0==CHAR_STRING_PERL) ) {
            alt121=1;
        }
        else if ( (LA121_0==COLON||LA121_0==BINDVAR) ) {
            alt121=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 121, 0, input);

            throw nvae;
        }
        switch (alt121) {
            case 1 :
                // Commons.g:433:25: quoted_string
                {
                pushFollow(FOLLOW_quoted_string_in_synpred140_Commons4142);
                quoted_string();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // Commons.g:433:41: bind_variable
                {
                pushFollow(FOLLOW_bind_variable_in_synpred140_Commons4146);
                bind_variable();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        // Commons.g:433:56: ( at_key time_key zone_key quoted_string )?
        int alt122=2;
        int LA122_0 = input.LA(1);

        if ( (LA122_0==REGULAR_ID) && ((input.LT(1).getText().equalsIgnoreCase("at")))) {
            alt122=1;
        }
        switch (alt122) {
            case 1 :
                // Commons.g:433:57: at_key time_key zone_key quoted_string
                {
                pushFollow(FOLLOW_at_key_in_synpred140_Commons4150);
                gOracleParser.at_key();

                state._fsp--;
                if (state.failed) return ;
                pushFollow(FOLLOW_time_key_in_synpred140_Commons4152);
                gOracleParser.time_key();

                state._fsp--;
                if (state.failed) return ;
                pushFollow(FOLLOW_zone_key_in_synpred140_Commons4154);
                gOracleParser.zone_key();

                state._fsp--;
                if (state.failed) return ;
                pushFollow(FOLLOW_quoted_string_in_synpred140_Commons4156);
                quoted_string();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred140_Commons

    // $ANTLR start synpred143_Commons
    public final void synpred143_Commons_fragment() throws RecognitionException {   
        // Commons.g:435:12: ( day_key )
        // Commons.g:435:12: day_key
        {
        pushFollow(FOLLOW_day_key_in_synpred143_Commons4194);
        gOracleParser.day_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred143_Commons

    // $ANTLR start synpred144_Commons
    public final void synpred144_Commons_fragment() throws RecognitionException {   
        // Commons.g:435:22: ( hour_key )
        // Commons.g:435:22: hour_key
        {
        pushFollow(FOLLOW_hour_key_in_synpred144_Commons4198);
        gOracleParser.hour_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred144_Commons

    // $ANTLR start synpred145_Commons
    public final void synpred145_Commons_fragment() throws RecognitionException {   
        // Commons.g:435:33: ( minute_key )
        // Commons.g:435:33: minute_key
        {
        pushFollow(FOLLOW_minute_key_in_synpred145_Commons4202);
        gOracleParser.minute_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred145_Commons

    // $ANTLR start synpred150_Commons
    public final void synpred150_Commons_fragment() throws RecognitionException {   
        // Commons.g:438:16: ( day_key )
        // Commons.g:438:16: day_key
        {
        pushFollow(FOLLOW_day_key_in_synpred150_Commons4276);
        gOracleParser.day_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred150_Commons

    // $ANTLR start synpred151_Commons
    public final void synpred151_Commons_fragment() throws RecognitionException {   
        // Commons.g:438:26: ( hour_key )
        // Commons.g:438:26: hour_key
        {
        pushFollow(FOLLOW_hour_key_in_synpred151_Commons4280);
        gOracleParser.hour_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred151_Commons

    // $ANTLR start synpred152_Commons
    public final void synpred152_Commons_fragment() throws RecognitionException {   
        // Commons.g:438:37: ( minute_key )
        // Commons.g:438:37: minute_key
        {
        pushFollow(FOLLOW_minute_key_in_synpred152_Commons4284);
        gOracleParser.minute_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred152_Commons

    // $ANTLR start synpred156_Commons
    public final void synpred156_Commons_fragment() throws RecognitionException {   
        // Commons.g:434:10: ( interval_key ( quoted_string | bind_variable | general_element_part ) ( day_key | hour_key | minute_key | second_key ) ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )? RIGHT_PAREN )? ( to_key ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? ) )? )
        // Commons.g:434:10: interval_key ( quoted_string | bind_variable | general_element_part ) ( day_key | hour_key | minute_key | second_key ) ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )? RIGHT_PAREN )? ( to_key ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? ) )?
        {
        pushFollow(FOLLOW_interval_key_in_synpred156_Commons4169);
        gOracleParser.interval_key();

        state._fsp--;
        if (state.failed) return ;
        // Commons.g:434:23: ( quoted_string | bind_variable | general_element_part )
        int alt131=3;
        switch ( input.LA(1) ) {
        case NATIONAL_CHAR_STRING_LIT:
        case CHAR_STRING:
        case CHAR_STRING_PERL:
            {
            alt131=1;
            }
            break;
        case COLON:
        case BINDVAR:
            {
            alt131=2;
            }
            break;
        case DELIMITED_ID:
        case INTRODUCER:
        case REGULAR_ID:
            {
            alt131=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 131, 0, input);

            throw nvae;
        }

        switch (alt131) {
            case 1 :
                // Commons.g:434:24: quoted_string
                {
                pushFollow(FOLLOW_quoted_string_in_synpred156_Commons4172);
                quoted_string();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // Commons.g:434:40: bind_variable
                {
                pushFollow(FOLLOW_bind_variable_in_synpred156_Commons4176);
                bind_variable();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // Commons.g:434:56: general_element_part
                {
                pushFollow(FOLLOW_general_element_part_in_synpred156_Commons4180);
                general_element_part();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        // Commons.g:435:10: ( day_key | hour_key | minute_key | second_key )
        int alt132=4;
        int LA132_0 = input.LA(1);

        if ( (LA132_0==REGULAR_ID) ) {
            int LA132_1 = input.LA(2);

            if ( ((synpred143_Commons()&&(input.LT(1).getText().equalsIgnoreCase("day")))) ) {
                alt132=1;
            }
            else if ( ((synpred144_Commons()&&(input.LT(1).getText().equalsIgnoreCase("hour")))) ) {
                alt132=2;
            }
            else if ( ((synpred145_Commons()&&(input.LT(1).getText().equalsIgnoreCase("minute")))) ) {
                alt132=3;
            }
            else if ( ((input.LT(1).getText().equalsIgnoreCase("second"))) ) {
                alt132=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 132, 0, input);

            throw nvae;
        }
        switch (alt132) {
            case 1 :
                // Commons.g:435:12: day_key
                {
                pushFollow(FOLLOW_day_key_in_synpred156_Commons4194);
                gOracleParser.day_key();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // Commons.g:435:22: hour_key
                {
                pushFollow(FOLLOW_hour_key_in_synpred156_Commons4198);
                gOracleParser.hour_key();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // Commons.g:435:33: minute_key
                {
                pushFollow(FOLLOW_minute_key_in_synpred156_Commons4202);
                gOracleParser.minute_key();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 4 :
                // Commons.g:435:46: second_key
                {
                pushFollow(FOLLOW_second_key_in_synpred156_Commons4206);
                gOracleParser.second_key();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        // Commons.g:436:10: ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )? RIGHT_PAREN )?
        int alt136=2;
        int LA136_0 = input.LA(1);

        if ( (LA136_0==LEFT_PAREN) ) {
            alt136=1;
        }
        switch (alt136) {
            case 1 :
                // Commons.g:436:12: LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )? RIGHT_PAREN
                {
                match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_synpred156_Commons4220); if (state.failed) return ;
                // Commons.g:436:23: ( UNSIGNED_INTEGER | bind_variable )
                int alt133=2;
                int LA133_0 = input.LA(1);

                if ( (LA133_0==UNSIGNED_INTEGER) ) {
                    alt133=1;
                }
                else if ( (LA133_0==COLON||LA133_0==BINDVAR) ) {
                    alt133=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 133, 0, input);

                    throw nvae;
                }
                switch (alt133) {
                    case 1 :
                        // Commons.g:436:24: UNSIGNED_INTEGER
                        {
                        match(input,UNSIGNED_INTEGER,FOLLOW_UNSIGNED_INTEGER_in_synpred156_Commons4223); if (state.failed) return ;

                        }
                        break;
                    case 2 :
                        // Commons.g:436:43: bind_variable
                        {
                        pushFollow(FOLLOW_bind_variable_in_synpred156_Commons4227);
                        bind_variable();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }

                // Commons.g:436:58: ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )?
                int alt135=2;
                int LA135_0 = input.LA(1);

                if ( (LA135_0==COMMA) ) {
                    alt135=1;
                }
                switch (alt135) {
                    case 1 :
                        // Commons.g:436:59: COMMA ( UNSIGNED_INTEGER | bind_variable )
                        {
                        match(input,COMMA,FOLLOW_COMMA_in_synpred156_Commons4231); if (state.failed) return ;
                        // Commons.g:436:65: ( UNSIGNED_INTEGER | bind_variable )
                        int alt134=2;
                        int LA134_0 = input.LA(1);

                        if ( (LA134_0==UNSIGNED_INTEGER) ) {
                            alt134=1;
                        }
                        else if ( (LA134_0==COLON||LA134_0==BINDVAR) ) {
                            alt134=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 134, 0, input);

                            throw nvae;
                        }
                        switch (alt134) {
                            case 1 :
                                // Commons.g:436:66: UNSIGNED_INTEGER
                                {
                                match(input,UNSIGNED_INTEGER,FOLLOW_UNSIGNED_INTEGER_in_synpred156_Commons4234); if (state.failed) return ;

                                }
                                break;
                            case 2 :
                                // Commons.g:436:85: bind_variable
                                {
                                pushFollow(FOLLOW_bind_variable_in_synpred156_Commons4238);
                                bind_variable();

                                state._fsp--;
                                if (state.failed) return ;

                                }
                                break;

                        }


                        }
                        break;

                }

                match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_synpred156_Commons4244); if (state.failed) return ;

                }
                break;

        }

        // Commons.g:437:10: ( to_key ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? ) )?
        int alt140=2;
        int LA140_0 = input.LA(1);

        if ( (LA140_0==SQL92_RESERVED_TO) ) {
            alt140=1;
        }
        switch (alt140) {
            case 1 :
                // Commons.g:437:12: to_key ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? )
                {
                pushFollow(FOLLOW_to_key_in_synpred156_Commons4259);
                gOracleParser.to_key();

                state._fsp--;
                if (state.failed) return ;
                // Commons.g:438:14: ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? )
                int alt139=4;
                int LA139_0 = input.LA(1);

                if ( (LA139_0==REGULAR_ID) ) {
                    int LA139_1 = input.LA(2);

                    if ( ((synpred150_Commons()&&(input.LT(1).getText().equalsIgnoreCase("day")))) ) {
                        alt139=1;
                    }
                    else if ( ((synpred151_Commons()&&(input.LT(1).getText().equalsIgnoreCase("hour")))) ) {
                        alt139=2;
                    }
                    else if ( ((synpred152_Commons()&&(input.LT(1).getText().equalsIgnoreCase("minute")))) ) {
                        alt139=3;
                    }
                    else if ( ((input.LT(1).getText().equalsIgnoreCase("second"))) ) {
                        alt139=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 139, 1, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 139, 0, input);

                    throw nvae;
                }
                switch (alt139) {
                    case 1 :
                        // Commons.g:438:16: day_key
                        {
                        pushFollow(FOLLOW_day_key_in_synpred156_Commons4276);
                        gOracleParser.day_key();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 2 :
                        // Commons.g:438:26: hour_key
                        {
                        pushFollow(FOLLOW_hour_key_in_synpred156_Commons4280);
                        gOracleParser.hour_key();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 3 :
                        // Commons.g:438:37: minute_key
                        {
                        pushFollow(FOLLOW_minute_key_in_synpred156_Commons4284);
                        gOracleParser.minute_key();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 4 :
                        // Commons.g:438:50: second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )?
                        {
                        pushFollow(FOLLOW_second_key_in_synpred156_Commons4288);
                        gOracleParser.second_key();

                        state._fsp--;
                        if (state.failed) return ;
                        // Commons.g:438:61: ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )?
                        int alt138=2;
                        int LA138_0 = input.LA(1);

                        if ( (LA138_0==LEFT_PAREN) ) {
                            alt138=1;
                        }
                        switch (alt138) {
                            case 1 :
                                // Commons.g:438:62: LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN
                                {
                                match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_synpred156_Commons4291); if (state.failed) return ;
                                // Commons.g:438:73: ( UNSIGNED_INTEGER | bind_variable )
                                int alt137=2;
                                int LA137_0 = input.LA(1);

                                if ( (LA137_0==UNSIGNED_INTEGER) ) {
                                    alt137=1;
                                }
                                else if ( (LA137_0==COLON||LA137_0==BINDVAR) ) {
                                    alt137=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return ;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 137, 0, input);

                                    throw nvae;
                                }
                                switch (alt137) {
                                    case 1 :
                                        // Commons.g:438:74: UNSIGNED_INTEGER
                                        {
                                        match(input,UNSIGNED_INTEGER,FOLLOW_UNSIGNED_INTEGER_in_synpred156_Commons4294); if (state.failed) return ;

                                        }
                                        break;
                                    case 2 :
                                        // Commons.g:438:93: bind_variable
                                        {
                                        pushFollow(FOLLOW_bind_variable_in_synpred156_Commons4298);
                                        bind_variable();

                                        state._fsp--;
                                        if (state.failed) return ;

                                        }
                                        break;

                                }

                                match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_synpred156_Commons4301); if (state.failed) return ;

                                }
                                break;

                        }


                        }
                        break;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred156_Commons

    // $ANTLR start synpred163_Commons
    public final void synpred163_Commons_fragment() throws RecognitionException {   
        // Commons.g:446:10: ( dbtimezone_key )
        // Commons.g:446:10: dbtimezone_key
        {
        pushFollow(FOLLOW_dbtimezone_key_in_synpred163_Commons4396);
        gOracleParser.dbtimezone_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred163_Commons

    // $ANTLR start synpred164_Commons
    public final void synpred164_Commons_fragment() throws RecognitionException {   
        // Commons.g:447:10: ( sessiontimezone_key )
        // Commons.g:447:10: sessiontimezone_key
        {
        pushFollow(FOLLOW_sessiontimezone_key_in_synpred164_Commons4408);
        gOracleParser.sessiontimezone_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred164_Commons

    // $ANTLR start synpred165_Commons
    public final void synpred165_Commons_fragment() throws RecognitionException {   
        // Commons.g:448:10: ( minvalue_key )
        // Commons.g:448:10: minvalue_key
        {
        pushFollow(FOLLOW_minvalue_key_in_synpred165_Commons4419);
        gOracleParser.minvalue_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred165_Commons

    // $ANTLR start synpred166_Commons
    public final void synpred166_Commons_fragment() throws RecognitionException {   
        // Commons.g:449:10: ( maxvalue_key )
        // Commons.g:449:10: maxvalue_key
        {
        pushFollow(FOLLOW_maxvalue_key_in_synpred166_Commons4430);
        gOracleParser.maxvalue_key();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred166_Commons

    // Delegated rules

    public final boolean synpred145_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred145_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred95_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred95_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred97_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred97_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred91_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred156_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred156_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred139_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred139_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred130_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred130_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred140_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred140_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred67_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred111_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred111_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred77_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred121_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred121_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred132_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred118_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred118_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred152_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred152_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred126_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred84_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred143_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred143_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred165_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred165_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred116_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred124_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred124_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred122_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred120_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred120_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred164_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred164_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred123_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred123_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred81_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred134_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred144_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred144_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred82_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred82_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred79_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred79_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred163_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred163_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred150_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred150_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred110_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred151_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred151_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred74_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred74_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred131_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred131_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred73_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred73_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred125_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred125_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred166_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred166_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred75_Commons() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred75_Commons_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA32 dfa32 = new DFA32(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA54 dfa54 = new DFA54(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA79 dfa79 = new DFA79(this);
    protected DFA94 dfa94 = new DFA94(this);
    protected DFA83 dfa83 = new DFA83(this);
    static final String DFA32_eotS =
        "\122\uffff";
    static final String DFA32_eofS =
        "\1\3\121\uffff";
    static final String DFA32_minS =
        "\1\4\1\uffff\1\0\117\uffff";
    static final String DFA32_maxS =
        "\1\u00ba\1\uffff\1\0\117\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\115\uffff\1\2";
    static final String DFA32_specialS =
        "\2\uffff\1\0\117\uffff}>";
    static final String[] DFA32_transitionS = {
            "\3\3\36\uffff\1\3\3\uffff\3\3\5\uffff\1\3\2\uffff\1\3\2\uffff"+
            "\2\3\1\uffff\4\3\1\1\1\uffff\1\3\2\uffff\1\3\1\uffff\5\3\1\uffff"+
            "\10\3\3\uffff\1\3\1\uffff\4\3\1\uffff\1\3\1\uffff\1\3\4\uffff"+
            "\2\3\3\uffff\2\3\1\uffff\4\3\1\uffff\2\3\2\uffff\2\3\1\uffff"+
            "\2\3\2\uffff\2\3\2\uffff\1\3\3\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\3\1\uffff\2\3\1\uffff\1\3\4\uffff"+
            "\1\3\2\uffff\1\3\3\uffff\4\3\2\uffff\1\3\2\uffff\5\3\3\uffff"+
            "\4\3\1\uffff\3\3\1\2",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "257:5: ( AT_SIGN link_name | {...}? => partition_extension_clause )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred33_Commons()&&(!(input.LA(2) == SQL92_RESERVED_BY)))&&(input.LT(1).getText().equalsIgnoreCase("subpartition")))||((synpred33_Commons()&&(!(input.LA(2) == SQL92_RESERVED_BY)))&&(input.LT(1).getText().equalsIgnoreCase("partition"))))) ) {s = 81;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA35_eotS =
        "\101\uffff";
    static final String DFA35_eofS =
        "\1\2\100\uffff";
    static final String DFA35_minS =
        "\1\6\1\0\77\uffff";
    static final String DFA35_maxS =
        "\1\u00ba\1\0\77\uffff";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\75\uffff\1\1";
    static final String DFA35_specialS =
        "\1\uffff\1\0\77\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\2\36\uffff\1\2\3\uffff\1\2\1\uffff\1\2\5\uffff\1\2\2\uffff"+
            "\1\2\2\uffff\2\2\1\uffff\4\2\7\uffff\5\2\1\uffff\10\2\5\uffff"+
            "\1\2\1\uffff\2\2\1\uffff\1\2\6\uffff\1\2\7\uffff\3\2\2\uffff"+
            "\2\2\5\uffff\2\2\2\uffff\2\2\2\uffff\1\2\3\uffff\4\2\1\uffff"+
            "\1\2\2\uffff\1\2\3\uffff\1\2\1\uffff\2\2\6\uffff\1\2\2\uffff"+
            "\1\2\3\uffff\2\2\1\uffff\1\2\5\uffff\5\2\3\uffff\4\2\1\uffff"+
            "\3\2\1\1",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "278:22: ( over_clause )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_1 = input.LA(1);

                         
                        int index35_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred36_Commons()&&(input.LT(1).getText().equalsIgnoreCase("over")))) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA38_eotS =
        "\13\uffff";
    static final String DFA38_eofS =
        "\2\2\11\uffff";
    static final String DFA38_minS =
        "\1\6\1\4\1\uffff\2\4\4\uffff\1\4\1\uffff";
    static final String DFA38_maxS =
        "\2\u00ba\1\uffff\2\u00ba\4\uffff\1\u00ba\1\uffff";
    static final String DFA38_acceptS =
        "\2\uffff\1\2\2\uffff\4\2\1\uffff\1\1";
    static final String DFA38_specialS =
        "\3\uffff\1\0\1\1\4\uffff\1\2\1\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\2\36\uffff\1\2\3\uffff\1\2\1\uffff\1\2\5\uffff\1\2\2\uffff"+
            "\1\2\2\uffff\2\2\1\uffff\4\2\7\uffff\5\2\1\uffff\10\2\5\uffff"+
            "\1\2\1\uffff\2\2\1\uffff\1\2\6\uffff\1\2\7\uffff\3\2\2\uffff"+
            "\2\2\5\uffff\2\2\2\uffff\2\2\2\uffff\1\2\3\uffff\4\2\1\uffff"+
            "\1\2\2\uffff\1\2\3\uffff\1\2\1\uffff\2\2\6\uffff\1\2\2\uffff"+
            "\1\2\3\uffff\2\2\1\uffff\1\2\5\uffff\5\2\3\uffff\4\2\1\uffff"+
            "\3\2\1\1",
            "\3\2\36\uffff\1\2\4\uffff\2\2\5\uffff\1\2\2\uffff\1\2\2\uffff"+
            "\1\3\1\2\1\uffff\4\2\2\uffff\1\2\2\uffff\1\2\1\uffff\5\2\1\uffff"+
            "\10\2\3\uffff\1\2\1\uffff\4\2\1\uffff\3\2\4\uffff\2\2\2\uffff"+
            "\3\2\1\uffff\4\2\1\uffff\2\2\2\uffff\2\2\1\uffff\2\2\2\uffff"+
            "\2\2\2\uffff\1\2\3\uffff\4\2\1\uffff\1\2\2\uffff\1\2\1\uffff"+
            "\3\2\1\uffff\2\2\1\uffff\1\2\4\uffff\1\2\1\uffff\2\2\3\uffff"+
            "\4\2\5\uffff\5\2\3\uffff\4\2\1\uffff\4\2",
            "",
            "\1\2\1\6\1\2\36\uffff\1\2\4\uffff\1\6\1\2\5\uffff\1\2\2\uffff"+
            "\1\2\2\uffff\1\2\1\5\2\uffff\1\2\4\uffff\1\2\2\uffff\1\2\16"+
            "\uffff\1\2\3\uffff\1\2\2\uffff\1\2\5\uffff\1\2\5\uffff\1\2\3"+
            "\uffff\2\2\1\uffff\1\2\2\uffff\1\2\5\uffff\2\2\25\uffff\1\2"+
            "\1\uffff\1\2\4\uffff\1\5\1\uffff\1\2\4\uffff\1\2\10\uffff\1"+
            "\2\26\uffff\1\4",
            "\2\10\1\6\36\uffff\1\10\3\uffff\3\10\5\uffff\1\10\2\uffff"+
            "\1\10\2\uffff\1\6\1\10\1\uffff\4\10\2\uffff\1\10\2\uffff\1\10"+
            "\1\uffff\5\10\1\uffff\6\10\1\uffff\1\10\3\uffff\1\10\1\uffff"+
            "\2\10\3\uffff\1\10\1\7\1\6\5\uffff\1\10\4\uffff\1\10\1\uffff"+
            "\1\10\2\uffff\1\10\5\uffff\2\10\1\uffff\1\10\7\uffff\1\10\5"+
            "\uffff\2\10\4\uffff\1\10\1\uffff\1\10\3\uffff\1\10\2\uffff\1"+
            "\10\15\uffff\1\10\26\uffff\1\11",
            "",
            "",
            "",
            "",
            "\3\10\36\uffff\1\10\3\uffff\3\10\5\uffff\1\10\2\uffff\1\10"+
            "\2\uffff\2\10\1\uffff\4\10\2\uffff\1\10\2\uffff\1\10\1\uffff"+
            "\5\10\1\uffff\6\10\1\uffff\1\10\3\uffff\1\10\1\uffff\2\10\3"+
            "\uffff\1\10\1\uffff\1\10\5\uffff\1\10\4\uffff\1\10\1\uffff\1"+
            "\10\2\uffff\1\10\5\uffff\2\10\11\uffff\1\10\5\uffff\2\10\4\uffff"+
            "\1\10\1\uffff\2\10\2\uffff\1\10\1\12\1\uffff\1\10\14\uffff\2"+
            "\10\26\uffff\1\10",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "285:9: ( keep_clause )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_3 = input.LA(1);

                         
                        int index38_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA38_3==UNSIGNED_INTEGER||LA38_3==MINUS_SIGN||LA38_3==NATIONAL_CHAR_STRING_LIT||LA38_3==CHAR_STRING||LA38_3==CHAR_STRING_PERL||LA38_3==DELIMITED_ID||LA38_3==LEFT_PAREN||LA38_3==PLUS_SIGN||LA38_3==COLON||LA38_3==BINDVAR||LA38_3==INTRODUCER||LA38_3==SQL92_RESERVED_ALL||LA38_3==SQL92_RESERVED_ANY||LA38_3==SQL92_RESERVED_CASE||LA38_3==PLSQL_NON_RESERVED_CONNECT_BY_ROOT||(LA38_3>=SQL92_RESERVED_CURSOR && LA38_3<=SQL92_RESERVED_DATE)||LA38_3==SQL92_RESERVED_DEFAULT||LA38_3==SQL92_RESERVED_DISTINCT||(LA38_3>=SQL92_RESERVED_EXISTS && LA38_3<=SQL92_RESERVED_FALSE)||LA38_3==SQL92_RESERVED_NOT||LA38_3==SQL92_RESERVED_NULL||LA38_3==SQL92_RESERVED_PRIOR||LA38_3==SQL92_RESERVED_SELECT||LA38_3==SQL92_RESERVED_TRUE) ) {s = 2;}

                        else if ( (LA38_3==REGULAR_ID) ) {s = 4;}

                        else if ( (LA38_3==RIGHT_PAREN||LA38_3==SQL92_RESERVED_ORDER) && ((input.LT(1).getText().equalsIgnoreCase("over")))) {s = 5;}

                        else if ( (LA38_3==APPROXIMATE_NUM_LIT||LA38_3==EXACT_NUM_LIT) ) {s = 6;}

                         
                        input.seek(index38_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_4 = input.LA(1);

                         
                        int index38_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA38_4==MINUS_SIGN||LA38_4==LEFT_PAREN||LA38_4==SQL92_RESERVED_CASE) ) {s = 6;}

                        else if ( (LA38_4==SQL92_RESERVED_BY) && ((input.LT(1).getText().equalsIgnoreCase("over")))) {s = 7;}

                        else if ( ((LA38_4>=UNSIGNED_INTEGER && LA38_4<=APPROXIMATE_NUM_LIT)||LA38_4==NATIONAL_CHAR_STRING_LIT||(LA38_4>=PERIOD && LA38_4<=CHAR_STRING)||LA38_4==CHAR_STRING_PERL||LA38_4==DELIMITED_ID||LA38_4==RIGHT_PAREN||(LA38_4>=ASTERISK && LA38_4<=SOLIDUS)||LA38_4==COLON||LA38_4==BINDVAR||(LA38_4>=LESS_THAN_OR_EQUALS_OP && LA38_4<=CARRET_OPERATOR_PART)||(LA38_4>=EXCLAMATION_OPERATOR_PART && LA38_4<=LEFT_BRACKET)||LA38_4==INTRODUCER||LA38_4==SQL92_RESERVED_ALL||(LA38_4>=SQL92_RESERVED_AND && LA38_4<=SQL92_RESERVED_ANY)||LA38_4==SQL92_RESERVED_BETWEEN||LA38_4==PLSQL_NON_RESERVED_CONNECT_BY_ROOT||LA38_4==SQL92_RESERVED_DATE||LA38_4==SQL92_RESERVED_DEFAULT||LA38_4==SQL92_RESERVED_DISTINCT||(LA38_4>=SQL92_RESERVED_EXISTS && LA38_4<=SQL92_RESERVED_FALSE)||LA38_4==SQL92_RESERVED_FOR||LA38_4==SQL92_RESERVED_IN||(LA38_4>=SQL92_RESERVED_IS && LA38_4<=SQL92_RESERVED_LIKE)||LA38_4==SQL92_RESERVED_NOT||LA38_4==SQL92_RESERVED_NULL||LA38_4==SQL92_RESERVED_OR||LA38_4==SQL92_RESERVED_PRIOR||LA38_4==SQL92_RESERVED_TRUE) ) {s = 8;}

                        else if ( (LA38_4==REGULAR_ID) ) {s = 9;}

                         
                        input.seek(index38_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA38_9 = input.LA(1);

                         
                        int index38_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA38_9>=UNSIGNED_INTEGER && LA38_9<=MINUS_SIGN)||LA38_9==NATIONAL_CHAR_STRING_LIT||(LA38_9>=PERIOD && LA38_9<=CHAR_STRING)||LA38_9==CHAR_STRING_PERL||LA38_9==DELIMITED_ID||(LA38_9>=LEFT_PAREN && LA38_9<=RIGHT_PAREN)||(LA38_9>=ASTERISK && LA38_9<=SOLIDUS)||LA38_9==COLON||LA38_9==BINDVAR||(LA38_9>=LESS_THAN_OR_EQUALS_OP && LA38_9<=CARRET_OPERATOR_PART)||(LA38_9>=EXCLAMATION_OPERATOR_PART && LA38_9<=LEFT_BRACKET)||LA38_9==INTRODUCER||LA38_9==SQL92_RESERVED_ALL||(LA38_9>=SQL92_RESERVED_AND && LA38_9<=SQL92_RESERVED_ANY)||LA38_9==SQL92_RESERVED_BETWEEN||LA38_9==SQL92_RESERVED_CASE||LA38_9==PLSQL_NON_RESERVED_CONNECT_BY_ROOT||LA38_9==SQL92_RESERVED_DATE||LA38_9==SQL92_RESERVED_DEFAULT||LA38_9==SQL92_RESERVED_DISTINCT||(LA38_9>=SQL92_RESERVED_EXISTS && LA38_9<=SQL92_RESERVED_FALSE)||LA38_9==SQL92_RESERVED_IN||(LA38_9>=SQL92_RESERVED_IS && LA38_9<=SQL92_RESERVED_LIKE)||LA38_9==SQL92_RESERVED_NOT||(LA38_9>=SQL92_RESERVED_NULL && LA38_9<=SQL92_RESERVED_OF)||LA38_9==SQL92_RESERVED_OR||LA38_9==SQL92_RESERVED_PRIOR||(LA38_9>=SQL92_RESERVED_TO && LA38_9<=SQL92_RESERVED_TRUE)||LA38_9==REGULAR_ID) ) {s = 8;}

                        else if ( (LA38_9==SQL92_RESERVED_ORDER) && ((input.LT(1).getText().equalsIgnoreCase("keep")))) {s = 10;}

                         
                        input.seek(index38_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA51_eotS =
        "\33\uffff";
    static final String DFA51_eofS =
        "\33\uffff";
    static final String DFA51_minS =
        "\1\4\3\0\27\uffff";
    static final String DFA51_maxS =
        "\1\u00ba\3\0\27\uffff";
    static final String DFA51_acceptS =
        "\4\uffff\1\2\1\3\24\uffff\1\1";
    static final String DFA51_specialS =
        "\1\uffff\1\0\1\1\1\2\27\uffff}>";
    static final String[] DFA51_transitionS = {
            "\3\5\36\uffff\1\5\4\uffff\2\5\5\uffff\1\5\2\uffff\1\3\2\uffff"+
            "\1\5\2\uffff\1\4\1\5\4\uffff\1\5\2\uffff\1\5\16\uffff\1\1\3"+
            "\uffff\1\5\2\uffff\1\5\5\uffff\1\5\5\uffff\1\5\3\uffff\2\5\1"+
            "\uffff\1\5\2\uffff\1\5\5\uffff\2\5\25\uffff\1\5\1\uffff\1\5"+
            "\6\uffff\1\5\15\uffff\1\5\26\uffff\1\2",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "302:17: ( ( tableview_name PERIOD ASTERISK )=> tableview_name PERIOD ASTERISK | ASTERISK | expression ( column_alias )? ( COMMA expression ( column_alias )? )* )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_1 = input.LA(1);

                         
                        int index51_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_Commons()) ) {s = 26;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index51_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA51_2 = input.LA(1);

                         
                        int index51_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_Commons()) ) {s = 26;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index51_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA51_3 = input.LA(1);

                         
                        int index51_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_Commons()) ) {s = 26;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index51_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA54_eotS =
        "\41\uffff";
    static final String DFA54_eofS =
        "\2\uffff\1\4\1\31\30\uffff\2\31\3\uffff";
    static final String DFA54_minS =
        "\1\4\1\64\1\4\1\6\1\uffff\2\51\1\4\22\uffff\1\4\1\64\2\6\1\uffff"+
        "\2\51";
    static final String DFA54_maxS =
        "\4\u00ba\1\uffff\3\u00ba\22\uffff\4\u00ba\1\uffff\2\u00ba";
    static final String DFA54_acceptS =
        "\4\uffff\1\2\3\uffff\22\2\4\uffff\1\1\2\uffff";
    static final String DFA54_specialS =
        "\2\uffff\1\1\4\uffff\1\0\22\uffff\1\2\6\uffff}>";
    static final String[] DFA54_transitionS = {
            "\3\4\36\uffff\1\4\4\uffff\2\4\5\uffff\1\4\2\uffff\1\3\2\uffff"+
            "\1\4\3\uffff\1\4\4\uffff\1\4\2\uffff\1\4\16\uffff\1\1\3\uffff"+
            "\1\4\2\uffff\1\4\5\uffff\1\4\5\uffff\1\4\3\uffff\2\4\1\uffff"+
            "\1\4\2\uffff\1\4\5\uffff\2\4\25\uffff\1\4\1\uffff\1\4\6\uffff"+
            "\1\4\15\uffff\1\4\26\uffff\1\2",
            "\1\6\u0085\uffff\1\5",
            "\2\22\1\4\36\uffff\1\24\3\uffff\1\31\1\22\1\24\5\uffff\1\24"+
            "\2\uffff\1\14\2\uffff\2\4\1\uffff\4\4\2\uffff\1\21\2\uffff\1"+
            "\21\1\uffff\5\4\1\uffff\4\4\1\7\1\4\1\uffff\1\20\3\uffff\1\13"+
            "\1\uffff\1\4\1\17\3\uffff\1\4\1\uffff\1\15\5\uffff\1\11\4\uffff"+
            "\1\23\1\uffff\1\30\2\uffff\1\12\5\uffff\1\16\1\27\11\uffff\1"+
            "\4\5\uffff\2\4\4\uffff\1\4\1\uffff\1\25\3\uffff\1\4\2\uffff"+
            "\1\10\15\uffff\1\26\26\uffff\1\4",
            "\1\31\42\uffff\1\31\15\uffff\2\31\1\uffff\4\31\7\uffff\5\31"+
            "\1\uffff\4\31\1\32\1\31\7\uffff\1\31\4\uffff\1\31\1\uffff\1"+
            "\31\40\uffff\1\31\5\uffff\2\31\4\uffff\1\31\5\uffff\1\31\47"+
            "\uffff\1\31",
            "",
            "\1\33\12\uffff\1\35\u0085\uffff\1\34",
            "\1\33\12\uffff\1\35\u0085\uffff\1\34",
            "\3\31\36\uffff\1\31\4\uffff\2\31\5\uffff\1\31\2\uffff\1\31"+
            "\2\uffff\1\31\3\uffff\1\31\4\uffff\1\31\2\uffff\1\31\10\uffff"+
            "\1\36\5\uffff\1\31\3\uffff\1\31\2\uffff\1\31\5\uffff\1\31\5"+
            "\uffff\1\31\4\uffff\1\31\1\uffff\1\31\2\uffff\1\31\5\uffff\2"+
            "\31\27\uffff\1\31\6\uffff\1\31\15\uffff\1\31\26\uffff\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\3\31\36\uffff\1\31\4\uffff\2\31\5\uffff\1\31\2\uffff\1\31"+
            "\2\uffff\1\31\3\uffff\1\31\4\uffff\1\31\2\uffff\1\31\10\uffff"+
            "\1\36\5\uffff\1\31\3\uffff\1\31\2\uffff\1\31\5\uffff\1\31\5"+
            "\uffff\1\31\4\uffff\1\31\1\uffff\1\31\2\uffff\1\31\5\uffff\2"+
            "\31\27\uffff\1\31\6\uffff\1\31\15\uffff\1\31\26\uffff\1\31",
            "\1\40\u0085\uffff\1\37",
            "\1\31\42\uffff\1\31\15\uffff\2\31\1\uffff\4\31\7\uffff\5\31"+
            "\1\uffff\4\31\1\32\1\31\7\uffff\1\31\4\uffff\1\31\42\uffff\1"+
            "\31\5\uffff\2\31\4\uffff\1\31\5\uffff\1\31\47\uffff\1\31",
            "\1\31\42\uffff\1\31\15\uffff\2\31\1\uffff\4\31\7\uffff\5\31"+
            "\1\uffff\4\31\1\32\1\31\7\uffff\1\31\4\uffff\1\31\42\uffff\1"+
            "\31\5\uffff\2\31\4\uffff\1\31\5\uffff\1\31\47\uffff\1\31",
            "",
            "\1\33\12\uffff\1\35\u0085\uffff\1\34",
            "\1\33\12\uffff\1\35\u0085\uffff\1\34"
    };

    static final short[] DFA54_eot = DFA.unpackEncodedString(DFA54_eotS);
    static final short[] DFA54_eof = DFA.unpackEncodedString(DFA54_eofS);
    static final char[] DFA54_min = DFA.unpackEncodedStringToUnsignedChars(DFA54_minS);
    static final char[] DFA54_max = DFA.unpackEncodedStringToUnsignedChars(DFA54_maxS);
    static final short[] DFA54_accept = DFA.unpackEncodedString(DFA54_acceptS);
    static final short[] DFA54_special = DFA.unpackEncodedString(DFA54_specialS);
    static final short[][] DFA54_transition;

    static {
        int numStates = DFA54_transitionS.length;
        DFA54_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA54_transition[i] = DFA.unpackEncodedString(DFA54_transitionS[i]);
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = DFA54_eot;
            this.eof = DFA54_eof;
            this.min = DFA54_min;
            this.max = DFA54_max;
            this.accept = DFA54_accept;
            this.special = DFA54_special;
            this.transition = DFA54_transition;
        }
        public String getDescription() {
            return "317:10: ( ( id EQUALS_OP GREATER_THAN_OP )=> id EQUALS_OP GREATER_THAN_OP )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA54_7 = input.LA(1);

                         
                        int index54_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA54_7==GREATER_THAN_OP) && (synpred56_Commons())) {s = 30;}

                        else if ( ((LA54_7>=UNSIGNED_INTEGER && LA54_7<=MINUS_SIGN)||LA54_7==NATIONAL_CHAR_STRING_LIT||(LA54_7>=EXACT_NUM_LIT && LA54_7<=CHAR_STRING)||LA54_7==CHAR_STRING_PERL||LA54_7==DELIMITED_ID||LA54_7==LEFT_PAREN||LA54_7==PLUS_SIGN||LA54_7==COLON||LA54_7==BINDVAR||LA54_7==INTRODUCER||LA54_7==SQL92_RESERVED_ALL||LA54_7==SQL92_RESERVED_ANY||LA54_7==SQL92_RESERVED_CASE||LA54_7==PLSQL_NON_RESERVED_CONNECT_BY_ROOT||LA54_7==SQL92_RESERVED_DATE||LA54_7==SQL92_RESERVED_DEFAULT||LA54_7==SQL92_RESERVED_DISTINCT||(LA54_7>=SQL92_RESERVED_EXISTS && LA54_7<=SQL92_RESERVED_FALSE)||LA54_7==SQL92_RESERVED_NULL||LA54_7==SQL92_RESERVED_PRIOR||LA54_7==SQL92_RESERVED_TRUE||LA54_7==REGULAR_ID) ) {s = 25;}

                         
                        input.seek(index54_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA54_2 = input.LA(1);

                         
                        int index54_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA54_2==EOF||LA54_2==MINUS_SIGN||(LA54_2>=LEFT_PAREN && LA54_2<=RIGHT_PAREN)||(LA54_2>=ASTERISK && LA54_2<=SOLIDUS)||(LA54_2>=LESS_THAN_OR_EQUALS_OP && LA54_2<=CARRET_OPERATOR_PART)||(LA54_2>=EXCLAMATION_OPERATOR_PART && LA54_2<=VERTICAL_BAR)||LA54_2==LEFT_BRACKET||LA54_2==SQL92_RESERVED_AND||LA54_2==SQL92_RESERVED_BETWEEN||LA54_2==SQL92_RESERVED_IN||(LA54_2>=SQL92_RESERVED_IS && LA54_2<=SQL92_RESERVED_LIKE)||LA54_2==SQL92_RESERVED_NOT||LA54_2==SQL92_RESERVED_OR||LA54_2==REGULAR_ID) ) {s = 4;}

                        else if ( (LA54_2==EQUALS_OP) ) {s = 7;}

                        else if ( (LA54_2==SQL92_RESERVED_PRIOR) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 8;}

                        else if ( (LA54_2==PLSQL_NON_RESERVED_CONNECT_BY_ROOT) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 9;}

                        else if ( (LA54_2==SQL92_RESERVED_DISTINCT) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 10;}

                        else if ( (LA54_2==SQL92_RESERVED_ALL) && ((((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new")))||((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new")))))) {s = 11;}

                        else if ( (LA54_2==DELIMITED_ID) && ((((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new")))||((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new")))||((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new")))||(input.LT(1).getText().equalsIgnoreCase("interval"))||((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new")))))) {s = 12;}

                        else if ( (LA54_2==SQL92_RESERVED_CASE) ) {s = 13;}

                        else if ( (LA54_2==SQL92_RESERVED_EXISTS) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 14;}

                        else if ( (LA54_2==SQL92_RESERVED_ANY) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 15;}

                        else if ( (LA54_2==INTRODUCER) && ((((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new")))||((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new")))||(input.LT(1).getText().equalsIgnoreCase("interval"))))) {s = 16;}

                        else if ( (LA54_2==COLON||LA54_2==BINDVAR) ) {s = 17;}

                        else if ( ((LA54_2>=UNSIGNED_INTEGER && LA54_2<=APPROXIMATE_NUM_LIT)||LA54_2==EXACT_NUM_LIT) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 18;}

                        else if ( (LA54_2==SQL92_RESERVED_DATE) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 19;}

                        else if ( (LA54_2==NATIONAL_CHAR_STRING_LIT||LA54_2==CHAR_STRING||LA54_2==CHAR_STRING_PERL) ) {s = 20;}

                        else if ( (LA54_2==SQL92_RESERVED_NULL) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 21;}

                        else if ( (LA54_2==SQL92_RESERVED_TRUE) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 22;}

                        else if ( (LA54_2==SQL92_RESERVED_FALSE) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 23;}

                        else if ( (LA54_2==SQL92_RESERVED_DEFAULT) && (((input.LT(1).getText().equalsIgnoreCase("new") && !input.LT(2).getText().equals("."))&&(input.LT(1).getText().equalsIgnoreCase("new"))))) {s = 24;}

                        else if ( (LA54_2==PERIOD) ) {s = 25;}

                         
                        input.seek(index54_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA54_26 = input.LA(1);

                         
                        int index54_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA54_26==GREATER_THAN_OP) && (synpred56_Commons())) {s = 30;}

                        else if ( ((LA54_26>=UNSIGNED_INTEGER && LA54_26<=MINUS_SIGN)||LA54_26==NATIONAL_CHAR_STRING_LIT||(LA54_26>=EXACT_NUM_LIT && LA54_26<=CHAR_STRING)||LA54_26==CHAR_STRING_PERL||LA54_26==DELIMITED_ID||LA54_26==LEFT_PAREN||LA54_26==PLUS_SIGN||LA54_26==COLON||LA54_26==BINDVAR||LA54_26==INTRODUCER||LA54_26==SQL92_RESERVED_ALL||LA54_26==SQL92_RESERVED_ANY||LA54_26==SQL92_RESERVED_CASE||LA54_26==PLSQL_NON_RESERVED_CONNECT_BY_ROOT||LA54_26==SQL92_RESERVED_DATE||LA54_26==SQL92_RESERVED_DEFAULT||LA54_26==SQL92_RESERVED_DISTINCT||(LA54_26>=SQL92_RESERVED_EXISTS && LA54_26<=SQL92_RESERVED_FALSE)||LA54_26==SQL92_RESERVED_NULL||LA54_26==SQL92_RESERVED_PRIOR||LA54_26==SQL92_RESERVED_TRUE||LA54_26==REGULAR_ID) ) {s = 25;}

                         
                        input.seek(index54_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 54, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA70_eotS =
        "\70\uffff";
    static final String DFA70_eofS =
        "\70\uffff";
    static final String DFA70_minS =
        "\1\152\1\0\66\uffff";
    static final String DFA70_maxS =
        "\1\u00ba\1\0\66\uffff";
    static final String DFA70_acceptS =
        "\2\uffff\1\37\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\1\32\1\33\1\34\1\35\1\36\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
        "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
        "\1\64\1\65\1\66";
    static final String DFA70_specialS =
        "\1\uffff\1\0\66\uffff}>";
    static final String[] DFA70_transitionS = {
            "\1\2\117\uffff\1\1",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA70_eot = DFA.unpackEncodedString(DFA70_eotS);
    static final short[] DFA70_eof = DFA.unpackEncodedString(DFA70_eofS);
    static final char[] DFA70_min = DFA.unpackEncodedStringToUnsignedChars(DFA70_minS);
    static final char[] DFA70_max = DFA.unpackEncodedStringToUnsignedChars(DFA70_maxS);
    static final short[] DFA70_accept = DFA.unpackEncodedString(DFA70_acceptS);
    static final short[] DFA70_special = DFA.unpackEncodedString(DFA70_specialS);
    static final short[][] DFA70_transition;

    static {
        int numStates = DFA70_transitionS.length;
        DFA70_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA70_transition[i] = DFA.unpackEncodedString(DFA70_transitionS[i]);
        }
    }

    class DFA70 extends DFA {

        public DFA70(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 70;
            this.eot = DFA70_eot;
            this.eof = DFA70_eof;
            this.min = DFA70_min;
            this.max = DFA70_max;
            this.accept = DFA70_accept;
            this.special = DFA70_special;
            this.transition = DFA70_transition;
        }
        public String getDescription() {
            return "344:1: native_datatype_element : ( binary_integer_key | pls_integer_key | natural_key | binary_float_key | binary_double_key | naturaln_key | positive_key | positiven_key | signtype_key | simple_integer_key | nvarchar2_key | dec_key | integer_key | int_key | numeric_key | smallint_key | number_key | decimal_key | double_key ( precision_key )? | float_key | real_key | nchar_key | long_key ( raw_key )? | char_key | character_key | varchar2_key | varchar_key | string_key | raw_key | boolean_key | date_key | rowid_key | urowid_key | year_key | month_key | day_key | hour_key | minute_key | second_key | timezone_hour_key | timezone_minute_key | timezone_region_key | timezone_abbr_key | timestamp_key | timestamp_unconstrained_key | timestamp_tz_unconstrained_key | timestamp_ltz_unconstrained_key | yminterval_unconstrained_key | dsinterval_unconstrained_key | bfile_key | blob_key | clob_key | nclob_key | mlslabel_key );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA70_1 = input.LA(1);

                         
                        int index70_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred72_Commons()&&(input.LT(1).getText().equalsIgnoreCase("binary_integer")))) ) {s = 3;}

                        else if ( ((synpred73_Commons()&&(input.LT(1).getText().equalsIgnoreCase("pls_integer")))) ) {s = 4;}

                        else if ( ((synpred74_Commons()&&(input.LT(1).getText().equalsIgnoreCase("natural")))) ) {s = 5;}

                        else if ( ((synpred75_Commons()&&(input.LT(1).getText().equalsIgnoreCase("binary_float")))) ) {s = 6;}

                        else if ( ((synpred76_Commons()&&(input.LT(1).getText().equalsIgnoreCase("binary_double")))) ) {s = 7;}

                        else if ( ((synpred77_Commons()&&(input.LT(1).getText().equalsIgnoreCase("naturaln")))) ) {s = 8;}

                        else if ( ((synpred78_Commons()&&(input.LT(1).getText().equalsIgnoreCase("positive")))) ) {s = 9;}

                        else if ( ((synpred79_Commons()&&(input.LT(1).getText().equalsIgnoreCase("positiven")))) ) {s = 10;}

                        else if ( ((synpred80_Commons()&&(input.LT(1).getText().equalsIgnoreCase("signtype")))) ) {s = 11;}

                        else if ( ((synpred81_Commons()&&(input.LT(1).getText().equalsIgnoreCase("simple_integer")))) ) {s = 12;}

                        else if ( ((synpred82_Commons()&&(input.LT(1).getText().equalsIgnoreCase("nvarchar2")))) ) {s = 13;}

                        else if ( ((synpred83_Commons()&&(input.LT(1).getText().equalsIgnoreCase("dec")))) ) {s = 14;}

                        else if ( ((synpred84_Commons()&&(input.LT(1).getText().equalsIgnoreCase("integer")))) ) {s = 15;}

                        else if ( ((synpred85_Commons()&&(input.LT(1).getText().equalsIgnoreCase("int")))) ) {s = 16;}

                        else if ( ((synpred86_Commons()&&(input.LT(1).getText().equalsIgnoreCase("numeric")))) ) {s = 17;}

                        else if ( ((synpred87_Commons()&&(input.LT(1).getText().equalsIgnoreCase("smallint")))) ) {s = 18;}

                        else if ( ((synpred88_Commons()&&(input.LT(1).getText().equalsIgnoreCase("number")))) ) {s = 19;}

                        else if ( ((synpred89_Commons()&&(input.LT(1).getText().equalsIgnoreCase("decimal")))) ) {s = 20;}

                        else if ( ((synpred91_Commons()&&(input.LT(1).getText().equalsIgnoreCase("double")))) ) {s = 21;}

                        else if ( ((synpred92_Commons()&&(input.LT(1).getText().equalsIgnoreCase("float")))) ) {s = 22;}

                        else if ( ((synpred93_Commons()&&(input.LT(1).getText().equalsIgnoreCase("real")))) ) {s = 23;}

                        else if ( ((synpred94_Commons()&&(input.LT(1).getText().equalsIgnoreCase("nchar")))) ) {s = 24;}

                        else if ( ((synpred96_Commons()&&(input.LT(1).getText().equalsIgnoreCase("long")))) ) {s = 25;}

                        else if ( ((synpred97_Commons()&&(input.LT(1).getText().equalsIgnoreCase("char")))) ) {s = 26;}

                        else if ( ((synpred98_Commons()&&(input.LT(1).getText().equalsIgnoreCase("character")))) ) {s = 27;}

                        else if ( ((synpred99_Commons()&&(input.LT(1).getText().equalsIgnoreCase("varchar2")))) ) {s = 28;}

                        else if ( ((synpred100_Commons()&&(input.LT(1).getText().equalsIgnoreCase("varchar")))) ) {s = 29;}

                        else if ( ((synpred101_Commons()&&(input.LT(1).getText().equalsIgnoreCase("string")))) ) {s = 30;}

                        else if ( ((synpred102_Commons()&&(input.LT(1).getText().equalsIgnoreCase("raw")))) ) {s = 31;}

                        else if ( ((synpred103_Commons()&&(input.LT(1).getText().equalsIgnoreCase("boolean")))) ) {s = 32;}

                        else if ( ((synpred105_Commons()&&(input.LT(1).getText().equalsIgnoreCase("rowid")))) ) {s = 33;}

                        else if ( ((synpred106_Commons()&&(input.LT(1).getText().equalsIgnoreCase("urowid")))) ) {s = 34;}

                        else if ( ((synpred107_Commons()&&(input.LT(1).getText().equalsIgnoreCase("year")))) ) {s = 35;}

                        else if ( ((synpred108_Commons()&&(input.LT(1).getText().equalsIgnoreCase("month")))) ) {s = 36;}

                        else if ( ((synpred109_Commons()&&(input.LT(1).getText().equalsIgnoreCase("day")))) ) {s = 37;}

                        else if ( ((synpred110_Commons()&&(input.LT(1).getText().equalsIgnoreCase("hour")))) ) {s = 38;}

                        else if ( ((synpred111_Commons()&&(input.LT(1).getText().equalsIgnoreCase("minute")))) ) {s = 39;}

                        else if ( ((synpred112_Commons()&&(input.LT(1).getText().equalsIgnoreCase("second")))) ) {s = 40;}

                        else if ( ((synpred113_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_hour")))) ) {s = 41;}

                        else if ( ((synpred114_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_minute")))) ) {s = 42;}

                        else if ( ((synpred115_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_region")))) ) {s = 43;}

                        else if ( ((synpred116_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timezone_abbr")))) ) {s = 44;}

                        else if ( ((synpred117_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp")))) ) {s = 45;}

                        else if ( ((synpred118_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp_unconstrained")))) ) {s = 46;}

                        else if ( ((synpred119_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp_tz_unconstrained")))) ) {s = 47;}

                        else if ( ((synpred120_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp_ltz_unconstrained")))) ) {s = 48;}

                        else if ( ((synpred121_Commons()&&(input.LT(1).getText().equalsIgnoreCase("yminterval_unconstrained")))) ) {s = 49;}

                        else if ( ((synpred122_Commons()&&(input.LT(1).getText().equalsIgnoreCase("dsinterval_unconstrained")))) ) {s = 50;}

                        else if ( ((synpred123_Commons()&&(input.LT(1).getText().equalsIgnoreCase("bfile")))) ) {s = 51;}

                        else if ( ((synpred124_Commons()&&(input.LT(1).getText().equalsIgnoreCase("blob")))) ) {s = 52;}

                        else if ( ((synpred125_Commons()&&(input.LT(1).getText().equalsIgnoreCase("clob")))) ) {s = 53;}

                        else if ( ((synpred126_Commons()&&(input.LT(1).getText().equalsIgnoreCase("nclob")))) ) {s = 54;}

                        else if ( ((input.LT(1).getText().equalsIgnoreCase("mlslabel"))) ) {s = 55;}

                         
                        input.seek(index70_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 70, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA74_eotS =
        "\13\uffff";
    static final String DFA74_eofS =
        "\2\3\11\uffff";
    static final String DFA74_minS =
        "\1\6\1\4\2\uffff\1\0\1\4\4\uffff\1\0";
    static final String DFA74_maxS =
        "\2\u00ba\2\uffff\1\0\1\4\4\uffff\1\0";
    static final String DFA74_acceptS =
        "\2\uffff\1\1\1\2\2\uffff\4\2\1\uffff";
    static final String DFA74_specialS =
        "\1\uffff\1\2\2\uffff\1\1\5\uffff\1\0}>";
    static final String[] DFA74_transitionS = {
            "\1\3\36\uffff\1\3\3\uffff\1\3\1\uffff\1\3\5\uffff\1\3\2\uffff"+
            "\1\3\2\uffff\2\3\1\uffff\4\3\2\uffff\1\2\2\uffff\1\2\1\uffff"+
            "\5\3\1\uffff\10\3\5\uffff\1\3\1\uffff\2\3\1\uffff\1\3\6\uffff"+
            "\1\3\7\uffff\3\3\2\uffff\2\3\5\uffff\2\3\2\uffff\2\3\2\uffff"+
            "\1\3\3\uffff\4\3\1\uffff\1\3\2\uffff\1\3\3\uffff\1\3\1\uffff"+
            "\2\3\6\uffff\1\3\2\uffff\1\3\3\uffff\2\3\1\uffff\1\3\5\uffff"+
            "\5\3\3\uffff\4\3\1\uffff\3\3\1\1",
            "\3\3\36\uffff\1\3\4\uffff\2\3\5\uffff\1\3\2\uffff\1\3\2\uffff"+
            "\2\3\1\uffff\4\3\2\uffff\1\5\2\uffff\1\4\1\uffff\5\3\1\uffff"+
            "\10\3\3\uffff\1\3\1\uffff\4\3\1\uffff\1\3\1\6\1\3\4\uffff\2"+
            "\3\2\uffff\1\11\2\3\1\uffff\4\3\1\uffff\2\3\2\uffff\2\3\1\uffff"+
            "\2\3\2\uffff\2\3\2\uffff\1\3\3\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\10\1\3\1\uffff\2\3\1\uffff\1\3\4\uffff\1"+
            "\3\1\uffff\1\7\1\3\3\uffff\4\3\5\uffff\5\3\3\uffff\4\3\1\uffff"+
            "\4\3",
            "",
            "",
            "\1\uffff",
            "\1\12",
            "",
            "",
            "",
            "",
            "\1\uffff"
    };

    static final short[] DFA74_eot = DFA.unpackEncodedString(DFA74_eotS);
    static final short[] DFA74_eof = DFA.unpackEncodedString(DFA74_eofS);
    static final char[] DFA74_min = DFA.unpackEncodedStringToUnsignedChars(DFA74_minS);
    static final char[] DFA74_max = DFA.unpackEncodedStringToUnsignedChars(DFA74_maxS);
    static final short[] DFA74_accept = DFA.unpackEncodedString(DFA74_acceptS);
    static final short[] DFA74_special = DFA.unpackEncodedString(DFA74_specialS);
    static final short[][] DFA74_transition;

    static {
        int numStates = DFA74_transitionS.length;
        DFA74_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA74_transition[i] = DFA.unpackEncodedString(DFA74_transitionS[i]);
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = DFA74_eot;
            this.eof = DFA74_eof;
            this.min = DFA74_min;
            this.max = DFA74_max;
            this.accept = DFA74_accept;
            this.special = DFA74_special;
            this.transition = DFA74_transition;
        }
        public String getDescription() {
            return "403:10: ( ( indicator_key )? (b2= BINDVAR | COLON u2= UNSIGNED_INTEGER ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA74_10 = input.LA(1);

                         
                        int index74_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred130_Commons()&&(input.LT(1).getText().equalsIgnoreCase("indicator")))) ) {s = 2;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index74_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA74_4 = input.LA(1);

                         
                        int index74_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred130_Commons()&&(input.LT(1).getText().equalsIgnoreCase("indicator")))) ) {s = 2;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index74_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA74_1 = input.LA(1);

                         
                        int index74_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA74_1==EOF||(LA74_1>=UNSIGNED_INTEGER && LA74_1<=MINUS_SIGN)||LA74_1==NATIONAL_CHAR_STRING_LIT||(LA74_1>=EXACT_NUM_LIT && LA74_1<=CHAR_STRING)||LA74_1==CHAR_STRING_PERL||LA74_1==DELIMITED_ID||(LA74_1>=LEFT_PAREN && LA74_1<=RIGHT_PAREN)||(LA74_1>=ASTERISK && LA74_1<=SOLIDUS)||(LA74_1>=LESS_THAN_OR_EQUALS_OP && LA74_1<=CARRET_OPERATOR_PART)||(LA74_1>=EXCLAMATION_OPERATOR_PART && LA74_1<=INTRODUCER)||LA74_1==SQL92_RESERVED_ALL||(LA74_1>=SQL92_RESERVED_AND && LA74_1<=SQL92_RESERVED_ASC)||LA74_1==SQL92_RESERVED_BETWEEN||LA74_1==SQL92_RESERVED_CASE||(LA74_1>=SQL92_RESERVED_CONNECT && LA74_1<=PLSQL_NON_RESERVED_CONNECT_BY_ROOT)||(LA74_1>=SQL92_RESERVED_CURSOR && LA74_1<=SQL92_RESERVED_DATE)||(LA74_1>=SQL92_RESERVED_DEFAULT && LA74_1<=SQL92_RESERVED_DISTINCT)||(LA74_1>=SQL92_RESERVED_ELSE && LA74_1<=SQL92_RESERVED_END)||(LA74_1>=SQL92_RESERVED_EXISTS && LA74_1<=SQL92_RESERVED_FALSE)||(LA74_1>=SQL92_RESERVED_FOR && LA74_1<=SQL92_RESERVED_FROM)||(LA74_1>=SQL92_RESERVED_GROUP && LA74_1<=SQL92_RESERVED_HAVING)||LA74_1==SQL92_RESERVED_IN||(LA74_1>=SQL92_RESERVED_INTERSECT && LA74_1<=SQL92_RESERVED_LIKE)||LA74_1==PLSQL_RESERVED_MINUS||LA74_1==SQL92_RESERVED_NOT||LA74_1==SQL92_RESERVED_NULL||LA74_1==SQL92_RESERVED_ON||(LA74_1>=SQL92_RESERVED_OR && LA74_1<=SQL92_RESERVED_ORDER)||LA74_1==SQL92_RESERVED_PRIOR||LA74_1==SQL92_RESERVED_SELECT||LA74_1==PLSQL_RESERVED_START||(LA74_1>=SQL92_RESERVED_THEN && LA74_1<=SQL92_RESERVED_UNION)||(LA74_1>=SQL92_RESERVED_WHEN && LA74_1<=PLSQL_NON_RESERVED_MODEL)||(LA74_1>=JOIN && LA74_1<=FULL)||(LA74_1>=CROSS && LA74_1<=REGULAR_ID)) ) {s = 3;}

                        else if ( (LA74_1==BINDVAR) ) {s = 4;}

                        else if ( (LA74_1==COLON) ) {s = 5;}

                        else if ( (LA74_1==SQL92_RESERVED_BY) && (((input.LT(1).getText().equalsIgnoreCase("passing"))||(input.LT(1).getText().equalsIgnoreCase("partition"))))) {s = 6;}

                        else if ( (LA74_1==SQL92_RESERVED_SIZE) && ((input.LT(1).getText().equalsIgnoreCase("indent")))) {s = 7;}

                        else if ( (LA74_1==SQL92_RESERVED_OF) && (((input.LT(1).getText().equalsIgnoreCase("submultiset"))||(input.LT(1).getText().equalsIgnoreCase("member"))))) {s = 8;}

                        else if ( (LA74_1==SQL92_RESERVED_CURRENT) && (((input.LT(1).getText().equalsIgnoreCase("rows"))||(input.LT(1).getText().equalsIgnoreCase("range"))))) {s = 9;}

                         
                        input.seek(index74_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 74, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA79_eotS =
        "\101\uffff";
    static final String DFA79_eofS =
        "\1\2\100\uffff";
    static final String DFA79_minS =
        "\1\6\1\0\77\uffff";
    static final String DFA79_maxS =
        "\1\u00ba\1\0\77\uffff";
    static final String DFA79_acceptS =
        "\2\uffff\1\2\75\uffff\1\1";
    static final String DFA79_specialS =
        "\1\uffff\1\0\77\uffff}>";
    static final String[] DFA79_transitionS = {
            "\1\2\36\uffff\1\2\3\uffff\1\2\1\uffff\1\2\5\uffff\1\2\2\uffff"+
            "\1\2\2\uffff\1\1\1\2\1\uffff\4\2\7\uffff\5\2\1\uffff\10\2\5"+
            "\uffff\1\2\1\uffff\2\2\1\uffff\1\2\6\uffff\1\2\7\uffff\3\2\2"+
            "\uffff\2\2\5\uffff\2\2\2\uffff\2\2\2\uffff\1\2\3\uffff\4\2\1"+
            "\uffff\1\2\2\uffff\1\2\3\uffff\1\2\1\uffff\2\2\6\uffff\1\2\2"+
            "\uffff\1\2\3\uffff\2\2\1\uffff\1\2\5\uffff\5\2\3\uffff\4\2\1"+
            "\uffff\4\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
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
            return "418:62: ( function_argument )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA79_1 = input.LA(1);

                         
                        int index79_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_Commons()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index79_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 79, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA94_eotS =
        "\17\uffff";
    static final String DFA94_eofS =
        "\17\uffff";
    static final String DFA94_minS =
        "\1\4\1\0\15\uffff";
    static final String DFA94_maxS =
        "\1\u00ba\1\0\15\uffff";
    static final String DFA94_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\15\1\1\1\2\1\11\1\12\1\13\1"+
        "\14";
    static final String DFA94_specialS =
        "\1\uffff\1\0\15\uffff}>";
    static final String[] DFA94_transitionS = {
            "\2\2\37\uffff\1\4\4\uffff\1\2\1\4\5\uffff\1\4\70\uffff\1\3"+
            "\1\uffff\1\10\11\uffff\1\7\27\uffff\1\5\24\uffff\1\6\26\uffff"+
            "\1\1",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA94_eot = DFA.unpackEncodedString(DFA94_eotS);
    static final short[] DFA94_eof = DFA.unpackEncodedString(DFA94_eofS);
    static final char[] DFA94_min = DFA.unpackEncodedStringToUnsignedChars(DFA94_minS);
    static final char[] DFA94_max = DFA.unpackEncodedStringToUnsignedChars(DFA94_maxS);
    static final short[] DFA94_accept = DFA.unpackEncodedString(DFA94_acceptS);
    static final short[] DFA94_special = DFA.unpackEncodedString(DFA94_specialS);
    static final short[][] DFA94_transition;

    static {
        int numStates = DFA94_transitionS.length;
        DFA94_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA94_transition[i] = DFA.unpackEncodedString(DFA94_transitionS[i]);
        }
    }

    class DFA94 extends DFA {

        public DFA94(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 94;
            this.eot = DFA94_eot;
            this.eof = DFA94_eof;
            this.min = DFA94_min;
            this.max = DFA94_max;
            this.accept = DFA94_accept;
            this.special = DFA94_special;
            this.transition = DFA94_transition;
        }
        public String getDescription() {
            return "432:1: constant : ( timestamp_key ( quoted_string | bind_variable ) ( at_key time_key zone_key quoted_string )? | interval_key ( quoted_string | bind_variable | general_element_part ) ( day_key | hour_key | minute_key | second_key ) ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) ( COMMA ( UNSIGNED_INTEGER | bind_variable ) )? RIGHT_PAREN )? ( to_key ( day_key | hour_key | minute_key | second_key ( LEFT_PAREN ( UNSIGNED_INTEGER | bind_variable ) RIGHT_PAREN )? ) )? | numeric | date_key quoted_string | quoted_string | null_key | true_key | false_key | dbtimezone_key | sessiontimezone_key | minvalue_key | maxvalue_key | default_key );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA94_1 = input.LA(1);

                         
                        int index94_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred140_Commons()&&(input.LT(1).getText().equalsIgnoreCase("timestamp")))) ) {s = 9;}

                        else if ( ((synpred156_Commons()&&(input.LT(1).getText().equalsIgnoreCase("interval")))) ) {s = 10;}

                        else if ( ((synpred163_Commons()&&(input.LT(1).getText().equalsIgnoreCase("dbtimezone")))) ) {s = 11;}

                        else if ( ((synpred164_Commons()&&(input.LT(1).getText().equalsIgnoreCase("sessiontimezone")))) ) {s = 12;}

                        else if ( ((synpred165_Commons()&&(input.LT(1).getText().equalsIgnoreCase("minvalue")))) ) {s = 13;}

                        else if ( ((synpred166_Commons()&&(input.LT(1).getText().equalsIgnoreCase("maxvalue")))) ) {s = 14;}

                         
                        input.seek(index94_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 94, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA83_eotS =
        "\100\uffff";
    static final String DFA83_eofS =
        "\1\2\77\uffff";
    static final String DFA83_minS =
        "\1\6\1\0\76\uffff";
    static final String DFA83_maxS =
        "\1\u00ba\1\0\76\uffff";
    static final String DFA83_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA83_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA83_transitionS = {
            "\1\2\36\uffff\1\2\5\uffff\1\2\5\uffff\1\2\2\uffff\1\2\2\uffff"+
            "\2\2\1\uffff\4\2\7\uffff\5\2\1\uffff\10\2\5\uffff\1\2\1\uffff"+
            "\2\2\1\uffff\1\2\6\uffff\1\2\7\uffff\3\2\2\uffff\2\2\5\uffff"+
            "\2\2\2\uffff\2\2\2\uffff\1\2\3\uffff\4\2\1\uffff\1\2\2\uffff"+
            "\1\2\3\uffff\1\2\1\uffff\2\2\6\uffff\1\2\2\uffff\1\2\3\uffff"+
            "\2\2\1\uffff\1\2\5\uffff\5\2\3\uffff\4\2\1\uffff\3\2\1\1",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA83_eot = DFA.unpackEncodedString(DFA83_eotS);
    static final short[] DFA83_eof = DFA.unpackEncodedString(DFA83_eofS);
    static final char[] DFA83_min = DFA.unpackEncodedStringToUnsignedChars(DFA83_minS);
    static final char[] DFA83_max = DFA.unpackEncodedStringToUnsignedChars(DFA83_maxS);
    static final short[] DFA83_accept = DFA.unpackEncodedString(DFA83_acceptS);
    static final short[] DFA83_special = DFA.unpackEncodedString(DFA83_specialS);
    static final short[][] DFA83_transition;

    static {
        int numStates = DFA83_transitionS.length;
        DFA83_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA83_transition[i] = DFA.unpackEncodedString(DFA83_transitionS[i]);
        }
    }

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = DFA83_eot;
            this.eof = DFA83_eof;
            this.min = DFA83_min;
            this.max = DFA83_max;
            this.accept = DFA83_accept;
            this.special = DFA83_special;
            this.transition = DFA83_transition;
        }
        public String getDescription() {
            return "433:56: ( at_key time_key zone_key quoted_string )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA83_1 = input.LA(1);

                         
                        int index83_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred139_Commons()&&(input.LT(1).getText().equalsIgnoreCase("at")))) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index83_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 83, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_subpartition_key_in_partition_extension_clause366 = new BitSet(new long[]{0x0080000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_partition_key_in_partition_extension_clause371 = new BitSet(new long[]{0x0080000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_for_key_in_partition_extension_clause385 = new BitSet(new long[]{0x0080000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_expression_list_in_partition_extension_clause389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_as_key_in_column_alias418 = new BitSet(new long[]{0x0012082000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_in_column_alias422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_quoted_string_in_column_alias424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_as_key_in_column_alias455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_table_alias477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_quoted_string_in_table_alias481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quoted_string_in_alias_quoted_string521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_key_in_where_clause554 = new BitSet(new long[]{0x08920C2000000070L,0x0060972082440009L,0x0400000800205000L});
    public static final BitSet FOLLOW_current_of_clause_in_where_clause557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condition_wrapper_in_where_clause569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_current_key_in_current_of_clause601 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_of_key_in_current_of_clause604 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040009L,0x0400000000000000L});
    public static final BitSet FOLLOW_cursor_name_in_current_of_clause607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_into_key_in_into_clause627 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040009L,0x0400000000000000L});
    public static final BitSet FOLLOW_variable_name_in_into_clause630 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_into_clause633 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040009L,0x0400000000000000L});
    public static final BitSet FOLLOW_variable_name_in_into_clause636 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_bulk_key_in_into_clause650 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_collect_key_in_into_clause653 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_into_key_in_into_clause656 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040009L,0x0400000000000000L});
    public static final BitSet FOLLOW_variable_name_in_into_clause659 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_into_clause662 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040009L,0x0400000000000000L});
    public static final BitSet FOLLOW_variable_name_in_into_clause665 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_id_in_xml_column_name692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quoted_string_in_xml_column_name711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_cost_class_name740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_attribute_name776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_savepoint_name812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_rollback_segment_name848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_table_var_name885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_schema_name921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_routine_name957 = new BitSet(new long[]{0x4000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_routine_name967 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_routine_name969 = new BitSet(new long[]{0x4000020000000002L});
    public static final BitSet FOLLOW_AT_SIGN_in_routine_name974 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_link_name_in_routine_name976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_package_name1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_implementation_type_name1056 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_implementation_type_name1066 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_implementation_type_name1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_parameter_name1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_reference_model_name1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_main_model_name1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_aggregate_function_name1217 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_aggregate_function_name1227 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_aggregate_function_name1229 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_id_in_query_name1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_constraint_name1306 = new BitSet(new long[]{0x4000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_constraint_name1316 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_constraint_name1318 = new BitSet(new long[]{0x4000020000000002L});
    public static final BitSet FOLLOW_AT_SIGN_in_constraint_name1323 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_link_name_in_constraint_name1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_expression_in_label_name1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_expression_in_type_name1405 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_type_name1415 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_type_name1417 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_id_expression_in_sequence_name1456 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_sequence_name1466 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_sequence_name1468 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_id_in_exception_name1507 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_exception_name1517 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_exception_name1519 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_id_in_function_name1560 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_function_name1570 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_function_name1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_procedure_name1613 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_procedure_name1623 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_procedure_name1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_trigger_name1666 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_trigger_name1676 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_trigger_name1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTRODUCER_in_variable_name1719 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_char_set_name_in_variable_name1721 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_variable_name1737 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_variable_name1747 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_variable_name1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bind_variable_in_variable_name1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_index_name1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_cursor_name1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bind_variable_in_cursor_name1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_record_name1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bind_variable_in_record_name1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_collection_name1941 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_collection_name1951 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_collection_name1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_link_name1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_column_name2029 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_column_name2039 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_column_name2041 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_id_in_tableview_name2082 = new BitSet(new long[]{0x4000020000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_PERIOD_in_tableview_name2092 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_tableview_name2094 = new BitSet(new long[]{0x4000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_AT_SIGN_in_tableview_name2108 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_link_name_in_tableview_name2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partition_extension_clause_in_tableview_name2124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_expression_in_char_set_name2176 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_char_set_name2186 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_char_set_name2188 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_keep_key_in_keep_clause2230 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_keep_clause2241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_dense_rank_key_in_keep_clause2256 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_first_key_in_keep_clause2259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_last_key_in_keep_clause2261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_order_by_clause_in_keep_clause2277 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_keep_clause2287 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_over_clause_in_keep_clause2290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_function_argument2311 = new BitSet(new long[]{0x19920C2000000070L,0x0060972082440009L,0x0400000800205000L});
    public static final BitSet FOLLOW_argument_in_function_argument2326 = new BitSet(new long[]{0x1100000000000000L});
    public static final BitSet FOLLOW_COMMA_in_function_argument2330 = new BitSet(new long[]{0x08920C2000000070L,0x0060972082440009L,0x0400000800205000L});
    public static final BitSet FOLLOW_argument_in_function_argument2332 = new BitSet(new long[]{0x1100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_function_argument2346 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_keep_clause_in_function_argument2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_function_argument_analytic2397 = new BitSet(new long[]{0x19920C2000000070L,0x0060972082440009L,0x0400000800205000L});
    public static final BitSet FOLLOW_argument_in_function_argument_analytic2412 = new BitSet(new long[]{0x1100000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_respect_or_ignore_nulls_in_function_argument_analytic2414 = new BitSet(new long[]{0x1100000000000000L});
    public static final BitSet FOLLOW_COMMA_in_function_argument_analytic2432 = new BitSet(new long[]{0x08920C2000000070L,0x0060972082440009L,0x0400000800205000L});
    public static final BitSet FOLLOW_argument_in_function_argument_analytic2434 = new BitSet(new long[]{0x1100000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_respect_or_ignore_nulls_in_function_argument_analytic2436 = new BitSet(new long[]{0x1100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_function_argument_analytic2451 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_keep_clause_in_function_argument_analytic2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_function_argument_modeling2504 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_column_name_in_function_argument_modeling2518 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_COMMA_in_function_argument_modeling2521 = new BitSet(new long[]{0x0000040000000030L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_numeric_in_function_argument_modeling2524 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_null_key_in_function_argument_modeling2526 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_COMMA_in_function_argument_modeling2530 = new BitSet(new long[]{0x0000040000000030L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_numeric_in_function_argument_modeling2533 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_null_key_in_function_argument_modeling2535 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_using_key_in_function_argument_modeling2556 = new BitSet(new long[]{0x0C920C2000000070L,0x0060972082440009L,0x0400000800205000L});
    public static final BitSet FOLLOW_tableview_name_in_function_argument_modeling2585 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_PERIOD_in_function_argument_modeling2587 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ASTERISK_in_function_argument_modeling2589 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ASTERISK_in_function_argument_modeling2609 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_expression_in_function_argument_modeling2629 = new BitSet(new long[]{0x1112082000000000L,0x0000000004040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_column_alias_in_function_argument_modeling2631 = new BitSet(new long[]{0x1100000000000000L});
    public static final BitSet FOLLOW_COMMA_in_function_argument_modeling2635 = new BitSet(new long[]{0x08920C2000000070L,0x0060972082440009L,0x0400000800205000L});
    public static final BitSet FOLLOW_expression_in_function_argument_modeling2637 = new BitSet(new long[]{0x1112082000000000L,0x0000000004040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_column_alias_in_function_argument_modeling2639 = new BitSet(new long[]{0x1100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_function_argument_modeling2671 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_keep_clause_in_function_argument_modeling2682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_respect_key_in_respect_or_ignore_nulls2724 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_ignore_key_in_respect_or_ignore_nulls2728 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_nulls_key_in_respect_or_ignore_nulls2731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_argument2769 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_EQUALS_OP_in_argument2771 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_GREATER_THAN_OP_in_argument2773 = new BitSet(new long[]{0x08920C2000000070L,0x0060972082440009L,0x0400000800205000L});
    public static final BitSet FOLLOW_expression_wrapper_in_argument2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_datatype_in_type_spec2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ref_key_in_type_spec2851 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_type_name_in_type_spec2854 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_percent_rowtype_key_in_type_spec2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_percent_type_key_in_type_spec2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_datatype_element_in_datatype2898 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_precision_part_in_datatype2908 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_with_key_in_datatype2920 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_local_key_in_datatype2922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_time_key_in_datatype2925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_zone_key_in_datatype2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interval_key_in_datatype2965 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_year_key_in_datatype2968 = new BitSet(new long[]{0x0080000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_day_key_in_datatype2970 = new BitSet(new long[]{0x0080000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_datatype2990 = new BitSet(new long[]{0x08920C2000000070L,0x0060972082440009L,0x0400000800205000L});
    public static final BitSet FOLLOW_expression_wrapper_in_datatype2992 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_datatype2994 = new BitSet(new long[]{0x0080000000000000L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_to_key_in_datatype3011 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_month_key_in_datatype3014 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_second_key_in_datatype3016 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_datatype3037 = new BitSet(new long[]{0x08920C2000000070L,0x0060972082440009L,0x0400000800205000L});
    public static final BitSet FOLLOW_expression_wrapper_in_datatype3039 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_datatype3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_precision_part3093 = new BitSet(new long[]{0x0000040000000030L});
    public static final BitSet FOLLOW_numeric_in_precision_part3095 = new BitSet(new long[]{0x1100000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_COMMA_in_precision_part3098 = new BitSet(new long[]{0x0000040000000030L});
    public static final BitSet FOLLOW_numeric_in_precision_part3100 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_char_key_in_precision_part3105 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_byte_key_in_precision_part3109 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_precision_part3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_integer_key_in_native_datatype_element3156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pls_integer_key_in_native_datatype_element3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_natural_key_in_native_datatype_element3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_float_key_in_native_datatype_element3189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_double_key_in_native_datatype_element3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_naturaln_key_in_native_datatype_element3211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positive_key_in_native_datatype_element3222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positiven_key_in_native_datatype_element3233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signtype_key_in_native_datatype_element3244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_integer_key_in_native_datatype_element3255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nvarchar2_key_in_native_datatype_element3266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dec_key_in_native_datatype_element3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_key_in_native_datatype_element3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_int_key_in_native_datatype_element3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_key_in_native_datatype_element3310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_smallint_key_in_native_datatype_element3321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_key_in_native_datatype_element3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decimal_key_in_native_datatype_element3343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_double_key_in_native_datatype_element3355 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_precision_key_in_native_datatype_element3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_float_key_in_native_datatype_element3369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_real_key_in_native_datatype_element3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nchar_key_in_native_datatype_element3391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_long_key_in_native_datatype_element3402 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_raw_key_in_native_datatype_element3404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_key_in_native_datatype_element3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_character_key_in_native_datatype_element3429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varchar2_key_in_native_datatype_element3441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varchar_key_in_native_datatype_element3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_key_in_native_datatype_element3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_raw_key_in_native_datatype_element3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_key_in_native_datatype_element3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_key_in_native_datatype_element3496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rowid_key_in_native_datatype_element3507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_urowid_key_in_native_datatype_element3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_year_key_in_native_datatype_element3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_month_key_in_native_datatype_element3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_day_key_in_native_datatype_element3551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hour_key_in_native_datatype_element3562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minute_key_in_native_datatype_element3573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_second_key_in_native_datatype_element3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timezone_hour_key_in_native_datatype_element3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timezone_minute_key_in_native_datatype_element3606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timezone_region_key_in_native_datatype_element3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timezone_abbr_key_in_native_datatype_element3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timestamp_key_in_native_datatype_element3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timestamp_unconstrained_key_in_native_datatype_element3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timestamp_tz_unconstrained_key_in_native_datatype_element3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timestamp_ltz_unconstrained_key_in_native_datatype_element3672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_yminterval_unconstrained_key_in_native_datatype_element3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dsinterval_unconstrained_key_in_native_datatype_element3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bfile_key_in_native_datatype_element3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blob_key_in_native_datatype_element3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_clob_key_in_native_datatype_element3727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nclob_key_in_native_datatype_element3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mlslabel_key_in_native_datatype_element3749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINDVAR_in_bind_variable3773 = new BitSet(new long[]{0x0000020000000002L,0x0000000000000009L,0x0400000000000000L});
    public static final BitSet FOLLOW_COLON_in_bind_variable3777 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_UNSIGNED_INTEGER_in_bind_variable3781 = new BitSet(new long[]{0x0000020000000002L,0x0000000000000009L,0x0400000000000000L});
    public static final BitSet FOLLOW_indicator_key_in_bind_variable3795 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000009L});
    public static final BitSet FOLLOW_BINDVAR_in_bind_variable3801 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_COLON_in_bind_variable3805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_UNSIGNED_INTEGER_in_bind_variable3809 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_bind_variable3831 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_general_element_part_in_bind_variable3833 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_general_element_part_in_general_element3899 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_general_element3909 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_general_element_part_in_general_element3911 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_INTRODUCER_in_general_element_part3974 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_char_set_name_in_general_element_part3976 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_general_element_part3980 = new BitSet(new long[]{0x0080020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_general_element_part4002 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_general_element_part4004 = new BitSet(new long[]{0x0080020000000002L});
    public static final BitSet FOLLOW_function_argument_in_general_element_part4009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTRODUCER_in_table_element4081 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_char_set_name_in_table_element4083 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_table_element4087 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_PERIOD_in_table_element4090 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_table_element4092 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_timestamp_key_in_constant4139 = new BitSet(new long[]{0x0012082000000000L,0x0000000000040009L,0x0400000000000000L});
    public static final BitSet FOLLOW_quoted_string_in_constant4142 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_bind_variable_in_constant4146 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_at_key_in_constant4150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_time_key_in_constant4152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_zone_key_in_constant4154 = new BitSet(new long[]{0x0012082000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_quoted_string_in_constant4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interval_key_in_constant4169 = new BitSet(new long[]{0x0012082000000000L,0x0000000000040009L,0x0400000000000000L});
    public static final BitSet FOLLOW_quoted_string_in_constant4172 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_bind_variable_in_constant4176 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_general_element_part_in_constant4180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_day_key_in_constant4194 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_hour_key_in_constant4198 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_minute_key_in_constant4202 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_second_key_in_constant4206 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_constant4220 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000009L});
    public static final BitSet FOLLOW_UNSIGNED_INTEGER_in_constant4223 = new BitSet(new long[]{0x1100000000000000L});
    public static final BitSet FOLLOW_bind_variable_in_constant4227 = new BitSet(new long[]{0x1100000000000000L});
    public static final BitSet FOLLOW_COMMA_in_constant4231 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000009L});
    public static final BitSet FOLLOW_UNSIGNED_INTEGER_in_constant4234 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_bind_variable_in_constant4238 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_constant4244 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_to_key_in_constant4259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_day_key_in_constant4276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hour_key_in_constant4280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minute_key_in_constant4284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_second_key_in_constant4288 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_constant4291 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000009L});
    public static final BitSet FOLLOW_UNSIGNED_INTEGER_in_constant4294 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_bind_variable_in_constant4298 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_constant4301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_in_constant4328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_key_in_constant4339 = new BitSet(new long[]{0x0012082000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_quoted_string_in_constant4341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quoted_string_in_constant4352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_null_key_in_constant4363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_true_key_in_constant4374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_false_key_in_constant4385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dbtimezone_key_in_constant4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sessiontimezone_key_in_constant4408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minvalue_key_in_constant4419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_maxvalue_key_in_constant4430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_default_key_in_constant4441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_numeric0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_quoted_string0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTRODUCER_in_id4541 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_char_set_name_in_id4543 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_id4555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGULAR_ID_in_id_expression4590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELIMITED_ID_in_id_expression4609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_EQUAL_OP_in_not_equal_op4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_OP_in_not_equal_op4649 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_GREATER_THAN_OP_in_not_equal_op4651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXCLAMATION_OPERATOR_PART_in_not_equal_op4662 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_EQUALS_OP_in_not_equal_op4664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARRET_OPERATOR_PART_in_not_equal_op4675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_EQUALS_OP_in_not_equal_op4677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_THAN_OR_EQUALS_OP_in_greater_than_or_equals_op4697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_THAN_OP_in_greater_than_or_equals_op4708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_EQUALS_OP_in_greater_than_or_equals_op4710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_OR_EQUALS_OP_in_less_than_or_equals_op4730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_OP_in_less_than_or_equals_op4741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_EQUALS_OP_in_less_than_or_equals_op4743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONCATENATION_OP_in_concatenation_op4763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VERTICAL_BAR_in_concatenation_op4774 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_VERTICAL_BAR_in_concatenation_op4776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_outer_join_sign4796 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_PLUS_SIGN_in_outer_join_sign4798 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_outer_join_sign4800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subpartition_key_in_synpred1_Commons366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_as_key_in_synpred5_Commons418 = new BitSet(new long[]{0x0012082000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_in_synpred5_Commons422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_quoted_string_in_synpred5_Commons424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred12_Commons961 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred12_Commons963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred14_Commons1060 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred14_Commons1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred15_Commons1221 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred15_Commons1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred16_Commons1310 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred16_Commons1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred18_Commons1409 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred18_Commons1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred19_Commons1460 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred19_Commons1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred20_Commons1511 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred20_Commons1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred21_Commons1564 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred21_Commons1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred22_Commons1617 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred22_Commons1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred23_Commons1670 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred23_Commons1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred25_Commons1741 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred25_Commons1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred29_Commons1945 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred29_Commons1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred30_Commons2033 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred30_Commons2035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred31_Commons2086 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred31_Commons2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partition_extension_clause_in_synpred33_Commons2124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred34_Commons2180 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred34_Commons2182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_first_key_in_synpred35_Commons2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_over_clause_in_synpred36_Commons2290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keep_clause_in_synpred39_Commons2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_respect_or_ignore_nulls_in_synpred40_Commons2414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_respect_or_ignore_nulls_in_synpred42_Commons2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keep_clause_in_synpred44_Commons2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tableview_name_in_synpred49_Commons2577 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_PERIOD_in_synpred49_Commons2579 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ASTERISK_in_synpred49_Commons2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keep_clause_in_synpred54_Commons2682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_respect_key_in_synpred55_Commons2724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_synpred56_Commons2761 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_EQUALS_OP_in_synpred56_Commons2763 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_GREATER_THAN_OP_in_synpred56_Commons2765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_datatype_in_synpred57_Commons2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ref_key_in_synpred58_Commons2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_percent_rowtype_key_in_synpred59_Commons2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_percent_type_key_in_synpred60_Commons2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_local_key_in_synpred62_Commons2922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_datatype_element_in_synpred64_Commons2898 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_precision_part_in_synpred64_Commons2908 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_with_key_in_synpred64_Commons2920 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_local_key_in_synpred64_Commons2922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_time_key_in_synpred64_Commons2925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_zone_key_in_synpred64_Commons2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_year_key_in_synpred65_Commons2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_month_key_in_synpred67_Commons3014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_key_in_synpred70_Commons3105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_byte_key_in_synpred71_Commons3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_integer_key_in_synpred72_Commons3156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pls_integer_key_in_synpred73_Commons3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_natural_key_in_synpred74_Commons3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_float_key_in_synpred75_Commons3189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_double_key_in_synpred76_Commons3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_naturaln_key_in_synpred77_Commons3211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positive_key_in_synpred78_Commons3222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positiven_key_in_synpred79_Commons3233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signtype_key_in_synpred80_Commons3244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_integer_key_in_synpred81_Commons3255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nvarchar2_key_in_synpred82_Commons3266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dec_key_in_synpred83_Commons3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_key_in_synpred84_Commons3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_int_key_in_synpred85_Commons3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_key_in_synpred86_Commons3310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_smallint_key_in_synpred87_Commons3321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_key_in_synpred88_Commons3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decimal_key_in_synpred89_Commons3343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_precision_key_in_synpred90_Commons3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_double_key_in_synpred91_Commons3355 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_precision_key_in_synpred91_Commons3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_float_key_in_synpred92_Commons3369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_real_key_in_synpred93_Commons3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nchar_key_in_synpred94_Commons3391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_raw_key_in_synpred95_Commons3404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_long_key_in_synpred96_Commons3402 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_raw_key_in_synpred96_Commons3404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_key_in_synpred97_Commons3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_character_key_in_synpred98_Commons3429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varchar2_key_in_synpred99_Commons3441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varchar_key_in_synpred100_Commons3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_key_in_synpred101_Commons3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_raw_key_in_synpred102_Commons3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_key_in_synpred103_Commons3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rowid_key_in_synpred105_Commons3507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_urowid_key_in_synpred106_Commons3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_year_key_in_synpred107_Commons3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_month_key_in_synpred108_Commons3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_day_key_in_synpred109_Commons3551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hour_key_in_synpred110_Commons3562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minute_key_in_synpred111_Commons3573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_second_key_in_synpred112_Commons3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timezone_hour_key_in_synpred113_Commons3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timezone_minute_key_in_synpred114_Commons3606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timezone_region_key_in_synpred115_Commons3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timezone_abbr_key_in_synpred116_Commons3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timestamp_key_in_synpred117_Commons3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timestamp_unconstrained_key_in_synpred118_Commons3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timestamp_tz_unconstrained_key_in_synpred119_Commons3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timestamp_ltz_unconstrained_key_in_synpred120_Commons3672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_yminterval_unconstrained_key_in_synpred121_Commons3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dsinterval_unconstrained_key_in_synpred122_Commons3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bfile_key_in_synpred123_Commons3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blob_key_in_synpred124_Commons3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_clob_key_in_synpred125_Commons3727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nclob_key_in_synpred126_Commons3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_indicator_key_in_synpred130_Commons3795 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000009L});
    public static final BitSet FOLLOW_BINDVAR_in_synpred130_Commons3801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_synpred130_Commons3805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_UNSIGNED_INTEGER_in_synpred130_Commons3809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred131_Commons3825 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_general_element_part_in_synpred131_Commons3827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred132_Commons3903 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_general_element_part_in_synpred132_Commons3905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_synpred134_Commons3996 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_id_expression_in_synpred134_Commons3998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_argument_in_synpred135_Commons4009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_at_key_in_synpred139_Commons4150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_time_key_in_synpred139_Commons4152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_zone_key_in_synpred139_Commons4154 = new BitSet(new long[]{0x0012082000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_quoted_string_in_synpred139_Commons4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timestamp_key_in_synpred140_Commons4139 = new BitSet(new long[]{0x0012082000000000L,0x0000000000040009L,0x0400000000000000L});
    public static final BitSet FOLLOW_quoted_string_in_synpred140_Commons4142 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_bind_variable_in_synpred140_Commons4146 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_at_key_in_synpred140_Commons4150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_time_key_in_synpred140_Commons4152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_zone_key_in_synpred140_Commons4154 = new BitSet(new long[]{0x0012082000000000L,0x0000000000040000L,0x0400000000000000L});
    public static final BitSet FOLLOW_quoted_string_in_synpred140_Commons4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_day_key_in_synpred143_Commons4194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hour_key_in_synpred144_Commons4198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minute_key_in_synpred145_Commons4202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_day_key_in_synpred150_Commons4276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hour_key_in_synpred151_Commons4280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minute_key_in_synpred152_Commons4284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interval_key_in_synpred156_Commons4169 = new BitSet(new long[]{0x0012082000000000L,0x0000000000040009L,0x0400000000000000L});
    public static final BitSet FOLLOW_quoted_string_in_synpred156_Commons4172 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_bind_variable_in_synpred156_Commons4176 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_general_element_part_in_synpred156_Commons4180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_day_key_in_synpred156_Commons4194 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_hour_key_in_synpred156_Commons4198 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_minute_key_in_synpred156_Commons4202 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_second_key_in_synpred156_Commons4206 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_synpred156_Commons4220 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000009L});
    public static final BitSet FOLLOW_UNSIGNED_INTEGER_in_synpred156_Commons4223 = new BitSet(new long[]{0x1100000000000000L});
    public static final BitSet FOLLOW_bind_variable_in_synpred156_Commons4227 = new BitSet(new long[]{0x1100000000000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred156_Commons4231 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000009L});
    public static final BitSet FOLLOW_UNSIGNED_INTEGER_in_synpred156_Commons4234 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_bind_variable_in_synpred156_Commons4238 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_synpred156_Commons4244 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_to_key_in_synpred156_Commons4259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_day_key_in_synpred156_Commons4276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hour_key_in_synpred156_Commons4280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minute_key_in_synpred156_Commons4284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_second_key_in_synpred156_Commons4288 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_synpred156_Commons4291 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000009L});
    public static final BitSet FOLLOW_UNSIGNED_INTEGER_in_synpred156_Commons4294 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_bind_variable_in_synpred156_Commons4298 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_synpred156_Commons4301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dbtimezone_key_in_synpred163_Commons4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sessiontimezone_key_in_synpred164_Commons4408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minvalue_key_in_synpred165_Commons4419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_maxvalue_key_in_synpred166_Commons4430 = new BitSet(new long[]{0x0000000000000002L});

}