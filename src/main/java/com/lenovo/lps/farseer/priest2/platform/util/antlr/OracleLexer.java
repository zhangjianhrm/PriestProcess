// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 OracleLexer.g 2013-08-08 15:53:20

package com.lenovo.lps.farseer.priest2.platform.util.antlr;

import java.util.LinkedList;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;

public class OracleLexer extends Lexer {
    public static final int D_=12;
    public static final int SQL92_RESERVED_DECLARE=107;
    public static final int DOUBLE_ASTERISK=57;
    public static final int U_=29;
    public static final int SEPARATOR=38;
    public static final int EOF=-1;
    public static final int SQL92_RESERVED_SIZE=156;
    public static final int ASSIGN_OP=63;
    public static final int E_=13;
    public static final int SIMPLE_LETTER=65;
    public static final int SQL92_RESERVED_PUBLIC=151;
    public static final int VERTICAL_BAR=78;
    public static final int PLSQL_RESERVED_NOWAIT=141;
    public static final int PLSQL_RESERVED_NOCOMPRESS=139;
    public static final int RIGHT_BRACKET=81;
    public static final int QUESTION_MARK=66;
    public static final int T_=28;
    public static final int SQL92_RESERVED_EXISTS=117;
    public static final int PLSQL_RESERVED_VIEWS=169;
    public static final int F_=14;
    public static final int CARRET_OPERATOR_PART=73;
    public static final int SQL92_RESERVED_HAVING=125;
    public static final int AT_SIGN=62;
    public static final int UNDERSCORE=8;
    public static final int W_=31;
    public static final int SEMICOLON=68;
    public static final int PLSQL_NON_RESERVED_MODEL=174;
    public static final int SQL92_RESERVED_ELSE=113;
    public static final int PLSQL_NON_RESERVED_CONNECT_BY_ROOT=101;
    public static final int SQL92_RESERVED_GRANT=123;
    public static final int SQL92_RESERVED_FETCH=119;
    public static final int SQL92_RESERVED_DELETE=109;
    public static final int QS_ANGLE=44;
    public static final int G_=15;
    public static final int SQL92_RESERVED_UNIQUE=165;
    public static final int V_=30;
    public static final int SQL92_RESERVED_ALTER=87;
    public static final int LEFT_PAREN=55;
    public static final int SQL92_RESERVED_ORDER=147;
    public static final int SQL92_RESERVED_THEN=161;
    public static final int PLSQL_RESERVED_COLAUTH=98;
    public static final int LEFT_BRACKET=80;
    public static final int Q_=25;
    public static final int SQL92_RESERVED_INTERSECT=132;
    public static final int ASTERISK=58;
    public static final int PLSQL_RESERVED_LOCK=136;
    public static final int RIGHT_PAREN=56;
    public static final int UNSIGNED_INTEGER=4;
    public static final int CHAR_STRING_PERL=49;
    public static final int MINUS_SIGN=6;
    public static final int LEFT=179;
    public static final int A_=9;
    public static final int SQL92_RESERVED_WITH=172;
    public static final int SQL92_RESERVED_DESC=110;
    public static final int PLSQL_RESERVED_IF=127;
    public static final int GREATER_THAN_OR_EQUALS_OP=71;
    public static final int SQL92_RESERVED_WHEN=170;
    public static final int P_=24;
    public static final int PLSQL_NON_RESERVED_PIVOT=176;
    public static final int OUTER=182;
    public static final int SQL92_RESERVED_VIEW=168;
    public static final int SQL92_RESERVED_ALL=86;
    public static final int B_=10;
    public static final int SQL92_RESERVED_GOTO=122;
    public static final int AMPERSAND=54;
    public static final int BIT_STRING_LIT=39;
    public static final int SQL92_RESERVED_TRUE=163;
    public static final int BINDVAR=67;
    public static final int RIGHT=180;
    public static final int SQL92_RESERVED_PROCEDURE=150;
    public static final int SOLIDUS=61;
    public static final int PLSQL_RESERVED_START=157;
    public static final int S_=27;
    public static final int COLON=64;
    public static final int SQL92_RESERVED_GROUP=124;
    public static final int PLSQL_RESERVED_MODE=138;
    public static final int C_=11;
    public static final int QS_OTHER_CH=51;
    public static final int SQL92_RESERVED_FALSE=118;
    public static final int NATURAL=184;
    public static final int SQL92_RESERVED_IN=128;
    public static final int SQL92_RESERVED_IS=134;
    public static final int SQL92_RESERVED_WHERE=171;
    public static final int R_=26;
    public static final int CHAR_STRING=43;
    public static final int QS_PAREN=47;
    public static final int SQL92_RESERVED_CONNECT=100;
    public static final int SQL92_RESERVED_ON=144;
    public static final int PLSQL_NON_RESERVED_ELSIF=175;
    public static final int SQL92_RESERVED_LIKE=135;
    public static final int SQL92_RESERVED_DISTINCT=111;
    public static final int L_=20;
    public static final int SQL92_RESERVED_OF=143;
    public static final int NOT_EQUAL_OP=72;
    public static final int PLSQL_RESERVED_EXCLUSIVE=116;
    public static final int QUOTE=50;
    public static final int SQL92_RESERVED_DROP=112;
    public static final int PLSQL_NON_RESERVED_USING=173;
    public static final int FULL=181;
    public static final int SQL92_RESERVED_OVERLAPS=148;
    public static final int PLSQL_RESERVED_RESOURCE=152;
    public static final int SQL92_RESERVED_CHECK=96;
    public static final int CONCATENATION_OP=77;
    public static final int SQL92_RESERVED_NULL=142;
    public static final int PROMPT=85;
    public static final int LESS_THAN_OR_EQUALS_OP=69;
    public static final int SQL92_RESERVED_OR=146;
    public static final int APPROXIMATE_NUM_LIT=5;
    public static final int COMMENT=83;
    public static final int M_=21;
    public static final int REGULAR_ID=186;
    public static final int SQL92_RESERVED_BETWEEN=93;
    public static final int QS_BRACE=45;
    public static final int PLSQL_RESERVED_INDEX=129;
    public static final int SQL92_RESERVED_PRIOR=149;
    public static final int EXCLAMATION_OPERATOR_PART=75;
    public static final int TILDE_OPERATOR_PART=74;
    public static final int PLSQL_RESERVED_TABAUTH=158;
    public static final int PERIOD=41;
    public static final int NATIONAL_CHAR_STRING_LIT=37;
    public static final int PLSQL_RESERVED_COMPRESS=99;
    public static final int SQL92_RESERVED_AND=88;
    public static final int QS_BRACK=46;
    public static final int EQUALS_OP=79;
    public static final int SQL92_RESERVED_VALUES=167;
    public static final int SQL92_RESERVED_CASE=95;
    public static final int N_=22;
    public static final int SQL92_RESERVED_DATE=106;
    public static final int SQL92_RESERVED_CREATE=103;
    public static final int SQL92_RESERVED_INSERT=131;
    public static final int SQL92_RESERVED_FROM=121;
    public static final int EXACT_NUM_LIT=42;
    public static final int SQL92_RESERVED_ANY=89;
    public static final int O_=23;
    public static final int SQL92_RESERVED_CURSOR=105;
    public static final int Y_=33;
    public static final int INNER=185;
    public static final int PLSQL_RESERVED_MINUS=137;
    public static final int SQL92_RESERVED_DEFAULT=108;
    public static final int SQL92_RESERVED_FOR=120;
    public static final int INTRODUCER=82;
    public static final int H_=16;
    public static final int SQL92_RESERVED_THE=160;
    public static final int SPACE=84;
    public static final int ZV=187;
    public static final int CROSS=183;
    public static final int SQL92_RESERVED_TABLE=159;
    public static final int X_=32;
    public static final int COMMA=60;
    public static final int SQL92_RESERVED_INTO=133;
    public static final int SQL92_RESERVED_UPDATE=166;
    public static final int SQL92_RESERVED_BY=94;
    public static final int I_=17;
    public static final int LESS_THAN_OP=70;
    public static final int HEX_STRING_LIT=40;
    public static final int FOR_NOTATION=35;
    public static final int SQL92_RESERVED_TO=162;
    public static final int PLSQL_RESERVED_IDENTIFIED=126;
    public static final int PERCENT=53;
    public static final int SQL92_RESERVED_UNION=164;
    public static final int DOUBLE_PERIOD=7;
    public static final int PLUS_SIGN=59;
    public static final int PLSQL_RESERVED_SHARE=155;
    public static final int SQL92_RESERVED_END=114;
    public static final int J_=18;
    public static final int PLSQL_RESERVED_INDEXES=130;
    public static final int SQL92_RESERVED_AS=90;
    public static final int PLSQL_RESERVED_CLUSTERS=97;
    public static final int DELIMITED_ID=52;
    public static final int SQL92_RESERVED_CURRENT=104;
    public static final int JOIN=178;
    public static final int PLSQL_NON_RESERVED_UNPIVOT=177;
    public static final int SQL92_RESERVED_EXCEPTION=115;
    public static final int NEWLINE=36;
    public static final int Z_=34;
    public static final int SQL92_RESERVED_SELECT=154;
    public static final int SQL92_RESERVED_ASC=91;
    public static final int K_=19;
    public static final int SQL92_RESERVED_OPTION=145;
    public static final int GREATER_THAN_OP=76;
    public static final int SQL92_RESERVED_NOT=140;
    public static final int SQL92_RESERVED_REVOKE=153;
    public static final int QS_OTHER=48;
    public static final int SQL92_RESERVED_BEGIN=92;
    public static final int PLSQL_RESERVED_CRASH=102;

        private LinkedList<Token> tokenBuffer = new LinkedList<Token>();

        public void emit(Token t) {
            tokenBuffer.add(t);
        }

        private void advanceInput(){
            state.tokenStartCharIndex = input.index();
            state.tokenStartCharPositionInLine = input.getCharPositionInLine();
            state.tokenStartLine = input.getLine();
        }

        public Token nextToken() {
            while (true) {
                if (tokenBuffer.size() == 0) {
                    state.token = null;
                    state.channel = Token.DEFAULT_CHANNEL;
                    state.tokenStartCharIndex = input.index();
                    state.tokenStartCharPositionInLine = input.getCharPositionInLine();
                    state.tokenStartLine = input.getLine();
                    state.text = null;
                    if (input.LA(1) == CharStream.EOF) {
                        return Token.EOF_TOKEN;
                    }
                    try {
                        int m = input.mark();
                        state.backtracking = 1;
                        state.failed = false;
                        mTokens();
                        state.backtracking = 0;

                        if (state.failed) {
                            input.rewind(m);
                            input.consume();
                        } else {
                            emit();
                        }
                    } catch (RecognitionException re) {
                        reportError(re);
                        recover(re);
                    }
                } else {
                    Token result = tokenBuffer.poll();
                    if (result == Token.SKIP_TOKEN || result.getType() == Token.INVALID_TOKEN_TYPE || result == null)
                    {
                        continue;
                    }
                    return result;
                }
            }
        }


    // delegates
    // delegators

    public OracleLexer() {;} 
    public OracleLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public OracleLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "OracleLexer.g"; }

    // $ANTLR start "A_"
    public final void mA_() throws RecognitionException {
        try {
            // OracleLexer.g:72:13: ( 'a' | 'A' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "A_"

    // $ANTLR start "B_"
    public final void mB_() throws RecognitionException {
        try {
            // OracleLexer.g:73:13: ( 'b' | 'B' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "B_"

    // $ANTLR start "C_"
    public final void mC_() throws RecognitionException {
        try {
            // OracleLexer.g:74:13: ( 'c' | 'C' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "C_"

    // $ANTLR start "D_"
    public final void mD_() throws RecognitionException {
        try {
            // OracleLexer.g:75:13: ( 'd' | 'D' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "D_"

    // $ANTLR start "E_"
    public final void mE_() throws RecognitionException {
        try {
            // OracleLexer.g:76:13: ( 'e' | 'E' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "E_"

    // $ANTLR start "F_"
    public final void mF_() throws RecognitionException {
        try {
            // OracleLexer.g:77:13: ( 'f' | 'F' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "F_"

    // $ANTLR start "G_"
    public final void mG_() throws RecognitionException {
        try {
            // OracleLexer.g:78:13: ( 'g' | 'G' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "G_"

    // $ANTLR start "H_"
    public final void mH_() throws RecognitionException {
        try {
            // OracleLexer.g:79:13: ( 'h' | 'H' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "H_"

    // $ANTLR start "I_"
    public final void mI_() throws RecognitionException {
        try {
            // OracleLexer.g:80:13: ( 'i' | 'I' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "I_"

    // $ANTLR start "J_"
    public final void mJ_() throws RecognitionException {
        try {
            // OracleLexer.g:81:13: ( 'j' | 'J' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "J_"

    // $ANTLR start "K_"
    public final void mK_() throws RecognitionException {
        try {
            // OracleLexer.g:82:13: ( 'k' | 'K' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "K_"

    // $ANTLR start "L_"
    public final void mL_() throws RecognitionException {
        try {
            // OracleLexer.g:83:13: ( 'l' | 'L' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "L_"

    // $ANTLR start "M_"
    public final void mM_() throws RecognitionException {
        try {
            // OracleLexer.g:84:13: ( 'm' | 'M' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "M_"

    // $ANTLR start "N_"
    public final void mN_() throws RecognitionException {
        try {
            // OracleLexer.g:85:13: ( 'n' | 'N' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "N_"

    // $ANTLR start "O_"
    public final void mO_() throws RecognitionException {
        try {
            // OracleLexer.g:86:13: ( 'o' | 'O' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "O_"

    // $ANTLR start "P_"
    public final void mP_() throws RecognitionException {
        try {
            // OracleLexer.g:87:13: ( 'p' | 'P' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "P_"

    // $ANTLR start "Q_"
    public final void mQ_() throws RecognitionException {
        try {
            // OracleLexer.g:88:13: ( 'q' | 'Q' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Q_"

    // $ANTLR start "R_"
    public final void mR_() throws RecognitionException {
        try {
            // OracleLexer.g:89:13: ( 'r' | 'R' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "R_"

    // $ANTLR start "S_"
    public final void mS_() throws RecognitionException {
        try {
            // OracleLexer.g:90:13: ( 's' | 'S' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "S_"

    // $ANTLR start "T_"
    public final void mT_() throws RecognitionException {
        try {
            // OracleLexer.g:91:13: ( 't' | 'T' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "T_"

    // $ANTLR start "U_"
    public final void mU_() throws RecognitionException {
        try {
            // OracleLexer.g:92:13: ( 'u' | 'U' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "U_"

    // $ANTLR start "V_"
    public final void mV_() throws RecognitionException {
        try {
            // OracleLexer.g:93:13: ( 'v' | 'V' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "V_"

    // $ANTLR start "W_"
    public final void mW_() throws RecognitionException {
        try {
            // OracleLexer.g:94:13: ( 'w' | 'W' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "W_"

    // $ANTLR start "X_"
    public final void mX_() throws RecognitionException {
        try {
            // OracleLexer.g:95:13: ( 'x' | 'X' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "X_"

    // $ANTLR start "Y_"
    public final void mY_() throws RecognitionException {
        try {
            // OracleLexer.g:96:13: ( 'y' | 'Y' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Y_"

    // $ANTLR start "Z_"
    public final void mZ_() throws RecognitionException {
        try {
            // OracleLexer.g:97:13: ( 'z' | 'Z' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Z_"

    // $ANTLR start "FOR_NOTATION"
    public final void mFOR_NOTATION() throws RecognitionException {
        try {
            int _type = FOR_NOTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:100:5: ( UNSIGNED_INTEGER '..' UNSIGNED_INTEGER )
            // OracleLexer.g:100:10: UNSIGNED_INTEGER '..' UNSIGNED_INTEGER
            {
            mUNSIGNED_INTEGER(); 
            state.type = UNSIGNED_INTEGER; emit(); advanceInput();
            match(".."); 

            state.type = DOUBLE_PERIOD; emit(); advanceInput();
            mUNSIGNED_INTEGER(); 
            state.type = UNSIGNED_INTEGER; emit(); advanceInput(); _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOR_NOTATION"

    // $ANTLR start "NATIONAL_CHAR_STRING_LIT"
    public final void mNATIONAL_CHAR_STRING_LIT() throws RecognitionException {
        try {
            int _type = NATIONAL_CHAR_STRING_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:109:5: ( N_ '\\'' ( options {greedy=true; } : ~ ( '\\'' | '\\r' | '\\n' ) | '\\'' '\\'' | NEWLINE )* '\\'' )
            // OracleLexer.g:109:10: N_ '\\'' ( options {greedy=true; } : ~ ( '\\'' | '\\r' | '\\n' ) | '\\'' '\\'' | NEWLINE )* '\\''
            {
            mN_(); 
            match('\''); 
            // OracleLexer.g:109:18: ( options {greedy=true; } : ~ ( '\\'' | '\\r' | '\\n' ) | '\\'' '\\'' | NEWLINE )*
            loop1:
            do {
                int alt1=4;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\'') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='\'') ) {
                        alt1=2;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='&')||(LA1_0>='(' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }
                else if ( (LA1_0=='\n'||LA1_0=='\r') ) {
                    alt1=3;
                }


                switch (alt1) {
            	case 1 :
            	    // OracleLexer.g:109:42: ~ ( '\\'' | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // OracleLexer.g:109:67: '\\'' '\\''
            	    {
            	    match('\''); 
            	    match('\''); 

            	    }
            	    break;
            	case 3 :
            	    // OracleLexer.g:109:79: NEWLINE
            	    {
            	    mNEWLINE(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NATIONAL_CHAR_STRING_LIT"

    // $ANTLR start "BIT_STRING_LIT"
    public final void mBIT_STRING_LIT() throws RecognitionException {
        try {
            int _type = BIT_STRING_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:113:5: ( B_ ( '\\'' ( '0' | '1' )* '\\'' ( SEPARATOR )? )+ )
            // OracleLexer.g:113:10: B_ ( '\\'' ( '0' | '1' )* '\\'' ( SEPARATOR )? )+
            {
            mB_(); 
            // OracleLexer.g:113:13: ( '\\'' ( '0' | '1' )* '\\'' ( SEPARATOR )? )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\'') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // OracleLexer.g:113:14: '\\'' ( '0' | '1' )* '\\'' ( SEPARATOR )?
            	    {
            	    match('\''); 
            	    // OracleLexer.g:113:19: ( '0' | '1' )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( ((LA2_0>='0' && LA2_0<='1')) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // OracleLexer.g:
            	    	    {
            	    	    if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;}


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);

            	    match('\''); 
            	    // OracleLexer.g:113:37: ( SEPARATOR )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' '||LA3_0=='-'||LA3_0=='/') ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // OracleLexer.g:113:37: SEPARATOR
            	            {
            	            mSEPARATOR(); 

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BIT_STRING_LIT"

    // $ANTLR start "HEX_STRING_LIT"
    public final void mHEX_STRING_LIT() throws RecognitionException {
        try {
            int _type = HEX_STRING_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:117:5: ( X_ ( '\\'' ( 'a' .. 'f' | 'A' .. 'F' | '0' .. '9' )* '\\'' ( SEPARATOR )? )+ )
            // OracleLexer.g:117:10: X_ ( '\\'' ( 'a' .. 'f' | 'A' .. 'F' | '0' .. '9' )* '\\'' ( SEPARATOR )? )+
            {
            mX_(); 
            // OracleLexer.g:117:13: ( '\\'' ( 'a' .. 'f' | 'A' .. 'F' | '0' .. '9' )* '\\'' ( SEPARATOR )? )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\'') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // OracleLexer.g:117:14: '\\'' ( 'a' .. 'f' | 'A' .. 'F' | '0' .. '9' )* '\\'' ( SEPARATOR )?
            	    {
            	    match('\''); 
            	    // OracleLexer.g:117:19: ( 'a' .. 'f' | 'A' .. 'F' | '0' .. '9' )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='F')||(LA5_0>='a' && LA5_0<='f')) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // OracleLexer.g:
            	    	    {
            	    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;}


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);

            	    match('\''); 
            	    // OracleLexer.g:117:58: ( SEPARATOR )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( ((LA6_0>='\t' && LA6_0<='\n')||LA6_0=='\r'||LA6_0==' '||LA6_0=='-'||LA6_0=='/') ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // OracleLexer.g:117:58: SEPARATOR
            	            {
            	            mSEPARATOR(); 

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HEX_STRING_LIT"

    // $ANTLR start "PERIOD"
    public final void mPERIOD() throws RecognitionException {
        try {
            int _type = PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:121:5: ( '.' )
            // OracleLexer.g:121:10: '.'
            {
            match('.'); 
                if ((char) input.LA(1) == '.') {
                        input.consume();
                        _type = DOUBLE_PERIOD;
                    }
                

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERIOD"

    // $ANTLR start "EXACT_NUM_LIT"
    public final void mEXACT_NUM_LIT() throws RecognitionException {
        try {
            int _type = EXACT_NUM_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:130:5: ( ( UNSIGNED_INTEGER ( '.' UNSIGNED_INTEGER | ) ( ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER )? | '.' UNSIGNED_INTEGER ( ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER )? ) ( D_ | F_ )? )
            // OracleLexer.g:130:7: ( UNSIGNED_INTEGER ( '.' UNSIGNED_INTEGER | ) ( ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER )? | '.' UNSIGNED_INTEGER ( ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER )? ) ( D_ | F_ )?
            {
            // OracleLexer.g:130:7: ( UNSIGNED_INTEGER ( '.' UNSIGNED_INTEGER | ) ( ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER )? | '.' UNSIGNED_INTEGER ( ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER )? )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                alt13=1;
            }
            else if ( (LA13_0=='.') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // OracleLexer.g:131:13: UNSIGNED_INTEGER ( '.' UNSIGNED_INTEGER | ) ( ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER )?
                    {
                    mUNSIGNED_INTEGER(); 
                    // OracleLexer.g:132:13: ( '.' UNSIGNED_INTEGER | )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='.') ) {
                        alt8=1;
                    }
                    else {
                        alt8=2;}
                    switch (alt8) {
                        case 1 :
                            // OracleLexer.g:132:15: '.' UNSIGNED_INTEGER
                            {
                            match('.'); 
                            mUNSIGNED_INTEGER(); 

                            }
                            break;
                        case 2 :
                            // OracleLexer.g:133:18: 
                            {
                            _type = UNSIGNED_INTEGER;

                            }
                            break;

                    }

                    // OracleLexer.g:134:15: ( ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // OracleLexer.g:134:17: ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER
                            {
                            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            // OracleLexer.g:134:29: ( '+' | '-' )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0=='+'||LA9_0=='-') ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // OracleLexer.g:
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;}


                                    }
                                    break;

                            }

                            mUNSIGNED_INTEGER(); 
                            _type = APPROXIMATE_NUM_LIT;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // OracleLexer.g:135:10: '.' UNSIGNED_INTEGER ( ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER )?
                    {
                    match('.'); 
                    mUNSIGNED_INTEGER(); 
                    // OracleLexer.g:135:31: ( ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='E'||LA12_0=='e') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // OracleLexer.g:135:33: ( 'E' | 'e' ) ( '+' | '-' )? UNSIGNED_INTEGER
                            {
                            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            // OracleLexer.g:135:45: ( '+' | '-' )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0=='+'||LA11_0=='-') ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // OracleLexer.g:
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;}


                                    }
                                    break;

                            }

                            mUNSIGNED_INTEGER(); 
                            _type = APPROXIMATE_NUM_LIT;

                            }
                            break;

                    }


                    }
                    break;

            }

            // OracleLexer.g:137:5: ( D_ | F_ )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='D'||LA14_0=='F'||LA14_0=='d'||LA14_0=='f') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // OracleLexer.g:
                    {
                    if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXACT_NUM_LIT"

    // $ANTLR start "CHAR_STRING"
    public final void mCHAR_STRING() throws RecognitionException {
        try {
            int _type = CHAR_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:141:5: ( '\\'' ( options {greedy=true; } : ~ ( '\\'' | '\\r' | '\\n' ) | '\\'' '\\'' | NEWLINE )* '\\'' )
            // OracleLexer.g:141:10: '\\'' ( options {greedy=true; } : ~ ( '\\'' | '\\r' | '\\n' ) | '\\'' '\\'' | NEWLINE )* '\\''
            {
            match('\''); 
            // OracleLexer.g:141:15: ( options {greedy=true; } : ~ ( '\\'' | '\\r' | '\\n' ) | '\\'' '\\'' | NEWLINE )*
            loop15:
            do {
                int alt15=4;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\'') ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1=='\'') ) {
                        alt15=2;
                    }


                }
                else if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }
                else if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                    alt15=3;
                }


                switch (alt15) {
            	case 1 :
            	    // OracleLexer.g:141:39: ~ ( '\\'' | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // OracleLexer.g:141:63: '\\'' '\\''
            	    {
            	    match('\''); 
            	    match('\''); 

            	    }
            	    break;
            	case 3 :
            	    // OracleLexer.g:141:75: NEWLINE
            	    {
            	    mNEWLINE(); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR_STRING"

    // $ANTLR start "CHAR_STRING_PERL"
    public final void mCHAR_STRING_PERL() throws RecognitionException {
        try {
            int _type = CHAR_STRING_PERL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:144:21: ( Q_ ( QS_ANGLE | QS_BRACE | QS_BRACK | QS_PAREN | QS_OTHER ) )
            // OracleLexer.g:144:23: Q_ ( QS_ANGLE | QS_BRACE | QS_BRACK | QS_PAREN | QS_OTHER )
            {
            mQ_(); 
            // OracleLexer.g:144:26: ( QS_ANGLE | QS_BRACE | QS_BRACK | QS_PAREN | QS_OTHER )
            int alt16=5;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\'') ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1=='[') ) {
                    alt16=3;
                }
                else if ( ((LA16_1>='\u0000' && LA16_1<='\b')||(LA16_1>='\u000B' && LA16_1<='\f')||(LA16_1>='\u000E' && LA16_1<='\u001F')||(LA16_1>='!' && LA16_1<='\'')||(LA16_1>=')' && LA16_1<=';')||(LA16_1>='=' && LA16_1<='Z')||(LA16_1>='\\' && LA16_1<='z')||(LA16_1>='|' && LA16_1<='\uFFFF')) ) {
                    alt16=5;
                }
                else if ( (LA16_1=='(') ) {
                    alt16=4;
                }
                else if ( (LA16_1=='{') ) {
                    alt16=2;
                }
                else if ( (LA16_1=='<') ) {
                    alt16=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // OracleLexer.g:144:28: QS_ANGLE
                    {
                    mQS_ANGLE(); 

                    }
                    break;
                case 2 :
                    // OracleLexer.g:144:39: QS_BRACE
                    {
                    mQS_BRACE(); 

                    }
                    break;
                case 3 :
                    // OracleLexer.g:144:50: QS_BRACK
                    {
                    mQS_BRACK(); 

                    }
                    break;
                case 4 :
                    // OracleLexer.g:144:61: QS_PAREN
                    {
                    mQS_PAREN(); 

                    }
                    break;
                case 5 :
                    // OracleLexer.g:144:72: QS_OTHER
                    {
                    mQS_OTHER(); 

                    }
                    break;

            }

            _type = CHAR_STRING;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR_STRING_PERL"

    // $ANTLR start "QUOTE"
    public final void mQUOTE() throws RecognitionException {
        try {
            // OracleLexer.g:145:21: ( '\\'' )
            // OracleLexer.g:145:23: '\\''
            {
            match('\''); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "QUOTE"

    // $ANTLR start "QS_ANGLE"
    public final void mQS_ANGLE() throws RecognitionException {
        try {
            // OracleLexer.g:146:21: ( QUOTE '<' ( options {greedy=false; } : . )* '>' QUOTE )
            // OracleLexer.g:146:23: QUOTE '<' ( options {greedy=false; } : . )* '>' QUOTE
            {
            mQUOTE(); 
            match('<'); 
            // OracleLexer.g:146:33: ( options {greedy=false; } : . )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='>') ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1=='\'') ) {
                        alt17=2;
                    }
                    else if ( ((LA17_1>='\u0000' && LA17_1<='&')||(LA17_1>='(' && LA17_1<='\uFFFF')) ) {
                        alt17=1;
                    }


                }
                else if ( ((LA17_0>='\u0000' && LA17_0<='=')||(LA17_0>='?' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // OracleLexer.g:146:61: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            match('>'); 
            mQUOTE(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "QS_ANGLE"

    // $ANTLR start "QS_BRACE"
    public final void mQS_BRACE() throws RecognitionException {
        try {
            // OracleLexer.g:147:21: ( QUOTE '{' ( options {greedy=false; } : . )* '}' QUOTE )
            // OracleLexer.g:147:23: QUOTE '{' ( options {greedy=false; } : . )* '}' QUOTE
            {
            mQUOTE(); 
            match('{'); 
            // OracleLexer.g:147:33: ( options {greedy=false; } : . )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='}') ) {
                    int LA18_1 = input.LA(2);

                    if ( ((LA18_1>='\u0000' && LA18_1<='&')||(LA18_1>='(' && LA18_1<='\uFFFF')) ) {
                        alt18=1;
                    }
                    else if ( (LA18_1=='\'') ) {
                        alt18=2;
                    }


                }
                else if ( ((LA18_0>='\u0000' && LA18_0<='|')||(LA18_0>='~' && LA18_0<='\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // OracleLexer.g:147:61: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            match('}'); 
            mQUOTE(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "QS_BRACE"

    // $ANTLR start "QS_BRACK"
    public final void mQS_BRACK() throws RecognitionException {
        try {
            // OracleLexer.g:148:21: ( QUOTE '[' ( options {greedy=false; } : . )* ']' QUOTE )
            // OracleLexer.g:148:23: QUOTE '[' ( options {greedy=false; } : . )* ']' QUOTE
            {
            mQUOTE(); 
            match('['); 
            // OracleLexer.g:148:33: ( options {greedy=false; } : . )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==']') ) {
                    int LA19_1 = input.LA(2);

                    if ( ((LA19_1>='\u0000' && LA19_1<='&')||(LA19_1>='(' && LA19_1<='\uFFFF')) ) {
                        alt19=1;
                    }
                    else if ( (LA19_1=='\'') ) {
                        alt19=2;
                    }


                }
                else if ( ((LA19_0>='\u0000' && LA19_0<='\\')||(LA19_0>='^' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // OracleLexer.g:148:61: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            match(']'); 
            mQUOTE(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "QS_BRACK"

    // $ANTLR start "QS_PAREN"
    public final void mQS_PAREN() throws RecognitionException {
        try {
            // OracleLexer.g:149:21: ( QUOTE '(' ( options {greedy=false; } : . )* ')' QUOTE )
            // OracleLexer.g:149:23: QUOTE '(' ( options {greedy=false; } : . )* ')' QUOTE
            {
            mQUOTE(); 
            match('('); 
            // OracleLexer.g:149:33: ( options {greedy=false; } : . )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==')') ) {
                    int LA20_1 = input.LA(2);

                    if ( ((LA20_1>='\u0000' && LA20_1<='&')||(LA20_1>='(' && LA20_1<='\uFFFF')) ) {
                        alt20=1;
                    }
                    else if ( (LA20_1=='\'') ) {
                        alt20=2;
                    }


                }
                else if ( ((LA20_0>='\u0000' && LA20_0<='(')||(LA20_0>='*' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // OracleLexer.g:149:61: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            match(')'); 
            mQUOTE(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "QS_PAREN"

    // $ANTLR start "QS_OTHER_CH"
    public final void mQS_OTHER_CH() throws RecognitionException {
        try {
            // OracleLexer.g:151:21: (~ ( '<' | '{' | '[' | '(' | ' ' | '\\t' | '\\n' | '\\r' ) )
            // OracleLexer.g:151:23: ~ ( '<' | '{' | '[' | '(' | ' ' | '\\t' | '\\n' | '\\r' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\'')||(input.LA(1)>=')' && input.LA(1)<=';')||(input.LA(1)>='=' && input.LA(1)<='Z')||(input.LA(1)>='\\' && input.LA(1)<='z')||(input.LA(1)>='|' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "QS_OTHER_CH"

    // $ANTLR start "QS_OTHER"
    public final void mQS_OTHER() throws RecognitionException {
        try {
            Token delimiter=null;

            // OracleLexer.g:153:3: ( QUOTE delimiter= QS_OTHER_CH ({...}? => . )* ({...}? => . ) QUOTE )
            // OracleLexer.g:154:3: QUOTE delimiter= QS_OTHER_CH ({...}? => . )* ({...}? => . ) QUOTE
            {
            mQUOTE(); 
            int delimiterStart1099 = getCharIndex();
            mQS_OTHER_CH(); 
            delimiter = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, delimiterStart1099, getCharIndex()-1);
            // OracleLexer.g:155:5: ({...}? => . )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='\uFFFF')) && ((( input.LT(1) != (delimiter!=null?delimiter.getText():null).charAt(0) || ( input.LT(1) == (delimiter!=null?delimiter.getText():null).charAt(0) && input.LT(2) != '\'') )||( input.LT(1) == (delimiter!=null?delimiter.getText():null).charAt(0) && input.LT(2) == '\'' )))) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1=='\'') && ((( input.LT(1) != (delimiter!=null?delimiter.getText():null).charAt(0) || ( input.LT(1) == (delimiter!=null?delimiter.getText():null).charAt(0) && input.LT(2) != '\'') )||( input.LT(1) == (delimiter!=null?delimiter.getText():null).charAt(0) && input.LT(2) == '\'' )))) {
                        int LA21_2 = input.LA(3);

                        if ( ((LA21_2>='\u0000' && LA21_2<='\uFFFF')) && (( input.LT(1) != (delimiter!=null?delimiter.getText():null).charAt(0) || ( input.LT(1) == (delimiter!=null?delimiter.getText():null).charAt(0) && input.LT(2) != '\'') ))) {
                            alt21=1;
                        }


                    }
                    else if ( ((LA21_1>='\u0000' && LA21_1<='&')||(LA21_1>='(' && LA21_1<='\uFFFF')) && (( input.LT(1) != (delimiter!=null?delimiter.getText():null).charAt(0) || ( input.LT(1) == (delimiter!=null?delimiter.getText():null).charAt(0) && input.LT(2) != '\'') ))) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // OracleLexer.g:155:7: {...}? => .
            	    {
            	    if ( !(( input.LT(1) != (delimiter!=null?delimiter.getText():null).charAt(0) || ( input.LT(1) == (delimiter!=null?delimiter.getText():null).charAt(0) && input.LT(2) != '\'') )) ) {
            	        throw new FailedPredicateException(input, "QS_OTHER", " input.LT(1) != $delimiter.text.charAt(0) || ( input.LT(1) == $delimiter.text.charAt(0) && input.LT(2) != '\\'') ");
            	    }
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // OracleLexer.g:156:5: ({...}? => . )
            // OracleLexer.g:156:7: {...}? => .
            {
            if ( !(( input.LT(1) == (delimiter!=null?delimiter.getText():null).charAt(0) && input.LT(2) == '\'' )) ) {
                throw new FailedPredicateException(input, "QS_OTHER", " input.LT(1) == $delimiter.text.charAt(0) && input.LT(2) == '\\'' ");
            }
            matchAny(); 

            }

            mQUOTE(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "QS_OTHER"

    // $ANTLR start "DELIMITED_ID"
    public final void mDELIMITED_ID() throws RecognitionException {
        try {
            int _type = DELIMITED_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:161:5: ( '\"' (~ ( '\"' | '\\r' | '\\n' ) | '\"' '\"' )+ '\"' )
            // OracleLexer.g:161:10: '\"' (~ ( '\"' | '\\r' | '\\n' ) | '\"' '\"' )+ '\"'
            {
            match('\"'); 
            // OracleLexer.g:161:14: (~ ( '\"' | '\\r' | '\\n' ) | '\"' '\"' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='\"') ) {
                    int LA22_1 = input.LA(2);

                    if ( (LA22_1=='\"') ) {
                        alt22=2;
                    }


                }
                else if ( ((LA22_0>='\u0000' && LA22_0<='\t')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='!')||(LA22_0>='#' && LA22_0<='\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // OracleLexer.g:161:15: ~ ( '\"' | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // OracleLexer.g:161:38: '\"' '\"'
            	    {
            	    match('\"'); 
            	    match('\"'); 

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DELIMITED_ID"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:165:5: ( '%' )
            // OracleLexer.g:165:10: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "AMPERSAND"
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:169:5: ( '&' )
            // OracleLexer.g:169:10: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AMPERSAND"

    // $ANTLR start "LEFT_PAREN"
    public final void mLEFT_PAREN() throws RecognitionException {
        try {
            int _type = LEFT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:173:5: ( '(' )
            // OracleLexer.g:173:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT_PAREN"

    // $ANTLR start "RIGHT_PAREN"
    public final void mRIGHT_PAREN() throws RecognitionException {
        try {
            int _type = RIGHT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:177:5: ( ')' )
            // OracleLexer.g:177:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT_PAREN"

    // $ANTLR start "DOUBLE_ASTERISK"
    public final void mDOUBLE_ASTERISK() throws RecognitionException {
        try {
            int _type = DOUBLE_ASTERISK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:181:5: ( '**' )
            // OracleLexer.g:181:10: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_ASTERISK"

    // $ANTLR start "ASTERISK"
    public final void mASTERISK() throws RecognitionException {
        try {
            int _type = ASTERISK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:185:5: ( '*' )
            // OracleLexer.g:185:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASTERISK"

    // $ANTLR start "PLUS_SIGN"
    public final void mPLUS_SIGN() throws RecognitionException {
        try {
            int _type = PLUS_SIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:189:5: ( '+' )
            // OracleLexer.g:189:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS_SIGN"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:193:5: ( ',' )
            // OracleLexer.g:193:10: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SOLIDUS"
    public final void mSOLIDUS() throws RecognitionException {
        try {
            int _type = SOLIDUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:197:5: ( '/' )
            // OracleLexer.g:197:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SOLIDUS"

    // $ANTLR start "AT_SIGN"
    public final void mAT_SIGN() throws RecognitionException {
        try {
            int _type = AT_SIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:201:5: ( '@' )
            // OracleLexer.g:201:10: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_SIGN"

    // $ANTLR start "ASSIGN_OP"
    public final void mASSIGN_OP() throws RecognitionException {
        try {
            int _type = ASSIGN_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:205:5: ( ':=' )
            // OracleLexer.g:205:10: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN_OP"

    // $ANTLR start "BINDVAR"
    public final void mBINDVAR() throws RecognitionException {
        try {
            int _type = BINDVAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:209:5: ( COLON SIMPLE_LETTER ( SIMPLE_LETTER | '0' .. '9' | '_' )* | COLON DELIMITED_ID | COLON UNSIGNED_INTEGER | QUESTION_MARK )
            int alt24=4;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==':') ) {
                switch ( input.LA(2) ) {
                case '\"':
                    {
                    alt24=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt24=3;
                    }
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt24=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA24_0=='?') ) {
                alt24=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // OracleLexer.g:209:10: COLON SIMPLE_LETTER ( SIMPLE_LETTER | '0' .. '9' | '_' )*
                    {
                    mCOLON(); 
                    mSIMPLE_LETTER(); 
                    // OracleLexer.g:209:31: ( SIMPLE_LETTER | '0' .. '9' | '_' )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( ((LA23_0>='0' && LA23_0<='9')||(LA23_0>='A' && LA23_0<='Z')||LA23_0=='_'||(LA23_0>='a' && LA23_0<='z')) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // OracleLexer.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // OracleLexer.g:210:10: COLON DELIMITED_ID
                    {
                    mCOLON(); 
                    mDELIMITED_ID(); 

                    }
                    break;
                case 3 :
                    // OracleLexer.g:211:10: COLON UNSIGNED_INTEGER
                    {
                    mCOLON(); 
                    mUNSIGNED_INTEGER(); 

                    }
                    break;
                case 4 :
                    // OracleLexer.g:212:10: QUESTION_MARK
                    {
                    mQUESTION_MARK(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BINDVAR"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:216:5: ( ':' )
            // OracleLexer.g:216:10: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:220:5: ( ';' )
            // OracleLexer.g:220:10: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "LESS_THAN_OR_EQUALS_OP"
    public final void mLESS_THAN_OR_EQUALS_OP() throws RecognitionException {
        try {
            int _type = LESS_THAN_OR_EQUALS_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:224:5: ( '<=' )
            // OracleLexer.g:224:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS_THAN_OR_EQUALS_OP"

    // $ANTLR start "LESS_THAN_OP"
    public final void mLESS_THAN_OP() throws RecognitionException {
        try {
            int _type = LESS_THAN_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:228:5: ( '<' )
            // OracleLexer.g:228:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS_THAN_OP"

    // $ANTLR start "GREATER_THAN_OR_EQUALS_OP"
    public final void mGREATER_THAN_OR_EQUALS_OP() throws RecognitionException {
        try {
            int _type = GREATER_THAN_OR_EQUALS_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:232:5: ( '>=' )
            // OracleLexer.g:232:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER_THAN_OR_EQUALS_OP"

    // $ANTLR start "NOT_EQUAL_OP"
    public final void mNOT_EQUAL_OP() throws RecognitionException {
        try {
            int _type = NOT_EQUAL_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:236:5: ( '!=' | '<>' | '^=' | '~=' )
            int alt25=4;
            switch ( input.LA(1) ) {
            case '!':
                {
                alt25=1;
                }
                break;
            case '<':
                {
                alt25=2;
                }
                break;
            case '^':
                {
                alt25=3;
                }
                break;
            case '~':
                {
                alt25=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // OracleLexer.g:236:10: '!='
                    {
                    match("!="); 


                    }
                    break;
                case 2 :
                    // OracleLexer.g:237:10: '<>'
                    {
                    match("<>"); 


                    }
                    break;
                case 3 :
                    // OracleLexer.g:238:10: '^='
                    {
                    match("^="); 


                    }
                    break;
                case 4 :
                    // OracleLexer.g:239:10: '~='
                    {
                    match("~="); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT_EQUAL_OP"

    // $ANTLR start "CARRET_OPERATOR_PART"
    public final void mCARRET_OPERATOR_PART() throws RecognitionException {
        try {
            int _type = CARRET_OPERATOR_PART;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:242:5: ( '^' )
            // OracleLexer.g:242:10: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CARRET_OPERATOR_PART"

    // $ANTLR start "TILDE_OPERATOR_PART"
    public final void mTILDE_OPERATOR_PART() throws RecognitionException {
        try {
            int _type = TILDE_OPERATOR_PART;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:246:5: ( '~' )
            // OracleLexer.g:246:10: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TILDE_OPERATOR_PART"

    // $ANTLR start "EXCLAMATION_OPERATOR_PART"
    public final void mEXCLAMATION_OPERATOR_PART() throws RecognitionException {
        try {
            int _type = EXCLAMATION_OPERATOR_PART;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:250:5: ( '!' )
            // OracleLexer.g:250:10: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCLAMATION_OPERATOR_PART"

    // $ANTLR start "GREATER_THAN_OP"
    public final void mGREATER_THAN_OP() throws RecognitionException {
        try {
            int _type = GREATER_THAN_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:254:5: ( '>' )
            // OracleLexer.g:254:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER_THAN_OP"

    // $ANTLR start "QUESTION_MARK"
    public final void mQUESTION_MARK() throws RecognitionException {
        try {
            // OracleLexer.g:259:5: ( '?' )
            // OracleLexer.g:259:10: '?'
            {
            match('?'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "QUESTION_MARK"

    // $ANTLR start "CONCATENATION_OP"
    public final void mCONCATENATION_OP() throws RecognitionException {
        try {
            int _type = CONCATENATION_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:263:5: ( '||' )
            // OracleLexer.g:263:10: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONCATENATION_OP"

    // $ANTLR start "VERTICAL_BAR"
    public final void mVERTICAL_BAR() throws RecognitionException {
        try {
            int _type = VERTICAL_BAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:267:5: ( '|' )
            // OracleLexer.g:267:10: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VERTICAL_BAR"

    // $ANTLR start "EQUALS_OP"
    public final void mEQUALS_OP() throws RecognitionException {
        try {
            int _type = EQUALS_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:271:5: ( '=' )
            // OracleLexer.g:271:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS_OP"

    // $ANTLR start "LEFT_BRACKET"
    public final void mLEFT_BRACKET() throws RecognitionException {
        try {
            int _type = LEFT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:275:5: ( '[' )
            // OracleLexer.g:275:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT_BRACKET"

    // $ANTLR start "RIGHT_BRACKET"
    public final void mRIGHT_BRACKET() throws RecognitionException {
        try {
            int _type = RIGHT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:279:5: ( ']' )
            // OracleLexer.g:279:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT_BRACKET"

    // $ANTLR start "INTRODUCER"
    public final void mINTRODUCER() throws RecognitionException {
        try {
            int _type = INTRODUCER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:283:5: ( '_' ( SEPARATOR )? )
            // OracleLexer.g:283:10: '_' ( SEPARATOR )?
            {
            match('_'); 
            // OracleLexer.g:283:14: ( SEPARATOR )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>='\t' && LA26_0<='\n')||LA26_0=='\r'||LA26_0==' '||LA26_0=='-'||LA26_0=='/') ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // OracleLexer.g:283:15: SEPARATOR
                    {
                    mSEPARATOR(); 
                    _type = UNDERSCORE;

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTRODUCER"

    // $ANTLR start "SEPARATOR"
    public final void mSEPARATOR() throws RecognitionException {
        try {
            int _type = SEPARATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:287:5: ( '-' | COMMENT | ( SPACE | NEWLINE )+ )
            int alt28=3;
            switch ( input.LA(1) ) {
            case '-':
                {
                int LA28_1 = input.LA(2);

                if ( (LA28_1=='-') ) {
                    alt28=2;
                }
                else {
                    alt28=1;}
                }
                break;
            case '/':
                {
                alt28=2;
                }
                break;
            case '\t':
            case '\n':
            case '\r':
            case ' ':
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // OracleLexer.g:287:10: '-'
                    {
                    match('-'); 
                    _type = MINUS_SIGN;

                    }
                    break;
                case 2 :
                    // OracleLexer.g:288:10: COMMENT
                    {
                    mCOMMENT(); 
                     _channel=HIDDEN; 

                    }
                    break;
                case 3 :
                    // OracleLexer.g:289:10: ( SPACE | NEWLINE )+
                    {
                    // OracleLexer.g:289:10: ( SPACE | NEWLINE )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=3;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0=='\t'||LA27_0==' ') ) {
                            alt27=1;
                        }
                        else if ( (LA27_0=='\n'||LA27_0=='\r') ) {
                            alt27=2;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // OracleLexer.g:289:11: SPACE
                    	    {
                    	    mSPACE(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // OracleLexer.g:289:19: NEWLINE
                    	    {
                    	    mNEWLINE(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                     _channel=HIDDEN; 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEPARATOR"

    // $ANTLR start "SIMPLE_LETTER"
    public final void mSIMPLE_LETTER() throws RecognitionException {
        try {
            // OracleLexer.g:294:5: ( 'a' .. 'z' | 'A' .. 'Z' )
            // OracleLexer.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SIMPLE_LETTER"

    // $ANTLR start "UNSIGNED_INTEGER"
    public final void mUNSIGNED_INTEGER() throws RecognitionException {
        try {
            // OracleLexer.g:300:5: ( ( '0' .. '9' )+ )
            // OracleLexer.g:300:10: ( '0' .. '9' )+
            {
            // OracleLexer.g:300:10: ( '0' .. '9' )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>='0' && LA29_0<='9')) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // OracleLexer.g:300:11: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "UNSIGNED_INTEGER"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            // OracleLexer.g:305:5: ( '--' (~ ( '\\r' | '\\n' ) )* ( NEWLINE | EOF ) | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0=='-') ) {
                alt33=1;
            }
            else if ( (LA33_0=='/') ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // OracleLexer.g:305:10: '--' (~ ( '\\r' | '\\n' ) )* ( NEWLINE | EOF )
                    {
                    match("--"); 

                    // OracleLexer.g:305:15: (~ ( '\\r' | '\\n' ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( ((LA30_0>='\u0000' && LA30_0<='\t')||(LA30_0>='\u000B' && LA30_0<='\f')||(LA30_0>='\u000E' && LA30_0<='\uFFFF')) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // OracleLexer.g:305:17: ~ ( '\\r' | '\\n' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    // OracleLexer.g:305:35: ( NEWLINE | EOF )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0=='\n'||LA31_0=='\r') ) {
                        alt31=1;
                    }
                    else {
                        alt31=2;}
                    switch (alt31) {
                        case 1 :
                            // OracleLexer.g:305:36: NEWLINE
                            {
                            mNEWLINE(); 

                            }
                            break;
                        case 2 :
                            // OracleLexer.g:305:44: EOF
                            {
                            match(EOF); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // OracleLexer.g:306:10: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // OracleLexer.g:306:15: ( options {greedy=false; } : . )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0=='*') ) {
                            int LA32_1 = input.LA(2);

                            if ( (LA32_1=='/') ) {
                                alt32=2;
                            }
                            else if ( ((LA32_1>='\u0000' && LA32_1<='.')||(LA32_1>='0' && LA32_1<='\uFFFF')) ) {
                                alt32=1;
                            }


                        }
                        else if ( ((LA32_0>='\u0000' && LA32_0<=')')||(LA32_0>='+' && LA32_0<='\uFFFF')) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // OracleLexer.g:306:41: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    match("*/"); 


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "PROMPT"
    public final void mPROMPT() throws RecognitionException {
        try {
            int _type = PROMPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:310:2: ( P_ R_ O_ M_ P_ T_ SPACE (~ ( '\\r' | '\\n' ) )* ( NEWLINE | EOF ) )
            // OracleLexer.g:310:4: P_ R_ O_ M_ P_ T_ SPACE (~ ( '\\r' | '\\n' ) )* ( NEWLINE | EOF )
            {
            mP_(); 
            mR_(); 
            mO_(); 
            mM_(); 
            mP_(); 
            mT_(); 
            mSPACE(); 
            // OracleLexer.g:310:28: (~ ( '\\r' | '\\n' ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>='\u0000' && LA34_0<='\t')||(LA34_0>='\u000B' && LA34_0<='\f')||(LA34_0>='\u000E' && LA34_0<='\uFFFF')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // OracleLexer.g:310:30: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // OracleLexer.g:310:48: ( NEWLINE | EOF )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0=='\n'||LA35_0=='\r') ) {
                alt35=1;
            }
            else {
                alt35=2;}
            switch (alt35) {
                case 1 :
                    // OracleLexer.g:310:49: NEWLINE
                    {
                    mNEWLINE(); 

                    }
                    break;
                case 2 :
                    // OracleLexer.g:310:57: EOF
                    {
                    match(EOF); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROMPT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            // OracleLexer.g:315:5: ( '\\r' ( options {greedy=true; } : '\\n' )? | '\\n' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0=='\r') ) {
                alt37=1;
            }
            else if ( (LA37_0=='\n') ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // OracleLexer.g:315:10: '\\r' ( options {greedy=true; } : '\\n' )?
                    {
                    match('\r'); 
                    // OracleLexer.g:315:15: ( options {greedy=true; } : '\\n' )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0=='\n') ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // OracleLexer.g:315:39: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // OracleLexer.g:316:10: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "SPACE"
    public final void mSPACE() throws RecognitionException {
        try {
            // OracleLexer.g:319:10: ( ' ' | '\\t' )
            // OracleLexer.g:
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SPACE"

    // $ANTLR start "APPROXIMATE_NUM_LIT"
    public final void mAPPROXIMATE_NUM_LIT() throws RecognitionException {
        try {
            // OracleLexer.g:323:29: ()
            // OracleLexer.g:323:31: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "APPROXIMATE_NUM_LIT"

    // $ANTLR start "MINUS_SIGN"
    public final void mMINUS_SIGN() throws RecognitionException {
        try {
            // OracleLexer.g:324:20: ()
            // OracleLexer.g:324:22: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "MINUS_SIGN"

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            // OracleLexer.g:325:20: ()
            // OracleLexer.g:325:22: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "UNDERSCORE"

    // $ANTLR start "DOUBLE_PERIOD"
    public final void mDOUBLE_PERIOD() throws RecognitionException {
        try {
            // OracleLexer.g:326:23: ()
            // OracleLexer.g:326:25: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_PERIOD"

    // $ANTLR start "SQL92_RESERVED_ALL"
    public final void mSQL92_RESERVED_ALL() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:329:5: ( A_ L_ L_ )
            // OracleLexer.g:329:10: A_ L_ L_
            {
            mA_(); 
            mL_(); 
            mL_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_ALL"

    // $ANTLR start "SQL92_RESERVED_ALTER"
    public final void mSQL92_RESERVED_ALTER() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_ALTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:333:5: ( A_ L_ T_ E_ R_ )
            // OracleLexer.g:333:10: A_ L_ T_ E_ R_
            {
            mA_(); 
            mL_(); 
            mT_(); 
            mE_(); 
            mR_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_ALTER"

    // $ANTLR start "SQL92_RESERVED_AND"
    public final void mSQL92_RESERVED_AND() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:337:5: ( A_ N_ D_ )
            // OracleLexer.g:337:10: A_ N_ D_
            {
            mA_(); 
            mN_(); 
            mD_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_AND"

    // $ANTLR start "SQL92_RESERVED_ANY"
    public final void mSQL92_RESERVED_ANY() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_ANY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:341:5: ( A_ N_ Y_ )
            // OracleLexer.g:341:10: A_ N_ Y_
            {
            mA_(); 
            mN_(); 
            mY_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_ANY"

    // $ANTLR start "SQL92_RESERVED_AS"
    public final void mSQL92_RESERVED_AS() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:345:5: ( A_ S_ )
            // OracleLexer.g:345:10: A_ S_
            {
            mA_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_AS"

    // $ANTLR start "SQL92_RESERVED_ASC"
    public final void mSQL92_RESERVED_ASC() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_ASC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:349:5: ( A_ S_ C_ )
            // OracleLexer.g:349:10: A_ S_ C_
            {
            mA_(); 
            mS_(); 
            mC_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_ASC"

    // $ANTLR start "SQL92_RESERVED_BEGIN"
    public final void mSQL92_RESERVED_BEGIN() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:353:5: ( B_ E_ G_ I_ N_ )
            // OracleLexer.g:353:10: B_ E_ G_ I_ N_
            {
            mB_(); 
            mE_(); 
            mG_(); 
            mI_(); 
            mN_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_BEGIN"

    // $ANTLR start "SQL92_RESERVED_BETWEEN"
    public final void mSQL92_RESERVED_BETWEEN() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_BETWEEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:357:5: ( B_ E_ T_ W_ E_ E_ N_ )
            // OracleLexer.g:357:10: B_ E_ T_ W_ E_ E_ N_
            {
            mB_(); 
            mE_(); 
            mT_(); 
            mW_(); 
            mE_(); 
            mE_(); 
            mN_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_BETWEEN"

    // $ANTLR start "SQL92_RESERVED_BY"
    public final void mSQL92_RESERVED_BY() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:361:5: ( B_ Y_ )
            // OracleLexer.g:361:10: B_ Y_
            {
            mB_(); 
            mY_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_BY"

    // $ANTLR start "SQL92_RESERVED_CASE"
    public final void mSQL92_RESERVED_CASE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_CASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:365:5: ( C_ A_ S_ E_ )
            // OracleLexer.g:365:10: C_ A_ S_ E_
            {
            mC_(); 
            mA_(); 
            mS_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_CASE"

    // $ANTLR start "SQL92_RESERVED_CHECK"
    public final void mSQL92_RESERVED_CHECK() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_CHECK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:369:5: ( C_ H_ E_ C_ K_ )
            // OracleLexer.g:369:10: C_ H_ E_ C_ K_
            {
            mC_(); 
            mH_(); 
            mE_(); 
            mC_(); 
            mK_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_CHECK"

    // $ANTLR start "PLSQL_RESERVED_CLUSTERS"
    public final void mPLSQL_RESERVED_CLUSTERS() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_CLUSTERS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:373:5: ( C_ L_ U_ S_ T_ E_ R_ S_ )
            // OracleLexer.g:373:10: C_ L_ U_ S_ T_ E_ R_ S_
            {
            mC_(); 
            mL_(); 
            mU_(); 
            mS_(); 
            mT_(); 
            mE_(); 
            mR_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_CLUSTERS"

    // $ANTLR start "PLSQL_RESERVED_COLAUTH"
    public final void mPLSQL_RESERVED_COLAUTH() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_COLAUTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:377:5: ( C_ O_ L_ A_ U_ T_ H_ )
            // OracleLexer.g:377:10: C_ O_ L_ A_ U_ T_ H_
            {
            mC_(); 
            mO_(); 
            mL_(); 
            mA_(); 
            mU_(); 
            mT_(); 
            mH_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_COLAUTH"

    // $ANTLR start "PLSQL_RESERVED_COMPRESS"
    public final void mPLSQL_RESERVED_COMPRESS() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_COMPRESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:381:5: ( C_ O_ M_ P_ R_ E_ S_ S_ )
            // OracleLexer.g:381:10: C_ O_ M_ P_ R_ E_ S_ S_
            {
            mC_(); 
            mO_(); 
            mM_(); 
            mP_(); 
            mR_(); 
            mE_(); 
            mS_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_COMPRESS"

    // $ANTLR start "SQL92_RESERVED_CONNECT"
    public final void mSQL92_RESERVED_CONNECT() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_CONNECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:385:5: ( C_ O_ N_ N_ E_ C_ T_ )
            // OracleLexer.g:385:10: C_ O_ N_ N_ E_ C_ T_
            {
            mC_(); 
            mO_(); 
            mN_(); 
            mN_(); 
            mE_(); 
            mC_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_CONNECT"

    // $ANTLR start "PLSQL_NON_RESERVED_CONNECT_BY_ROOT"
    public final void mPLSQL_NON_RESERVED_CONNECT_BY_ROOT() throws RecognitionException {
        try {
            int _type = PLSQL_NON_RESERVED_CONNECT_BY_ROOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:389:5: ( C_ O_ N_ N_ E_ C_ T_ '_' B_ Y_ '_' R_ O_ O_ T_ )
            // OracleLexer.g:389:10: C_ O_ N_ N_ E_ C_ T_ '_' B_ Y_ '_' R_ O_ O_ T_
            {
            mC_(); 
            mO_(); 
            mN_(); 
            mN_(); 
            mE_(); 
            mC_(); 
            mT_(); 
            match('_'); 
            mB_(); 
            mY_(); 
            match('_'); 
            mR_(); 
            mO_(); 
            mO_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_NON_RESERVED_CONNECT_BY_ROOT"

    // $ANTLR start "PLSQL_RESERVED_CRASH"
    public final void mPLSQL_RESERVED_CRASH() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_CRASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:393:5: ( C_ R_ A_ S_ H_ )
            // OracleLexer.g:393:10: C_ R_ A_ S_ H_
            {
            mC_(); 
            mR_(); 
            mA_(); 
            mS_(); 
            mH_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_CRASH"

    // $ANTLR start "SQL92_RESERVED_CREATE"
    public final void mSQL92_RESERVED_CREATE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_CREATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:397:5: ( C_ R_ E_ A_ T_ E_ )
            // OracleLexer.g:397:10: C_ R_ E_ A_ T_ E_
            {
            mC_(); 
            mR_(); 
            mE_(); 
            mA_(); 
            mT_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_CREATE"

    // $ANTLR start "SQL92_RESERVED_CURRENT"
    public final void mSQL92_RESERVED_CURRENT() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_CURRENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:401:5: ( C_ U_ R_ R_ E_ N_ T_ )
            // OracleLexer.g:401:10: C_ U_ R_ R_ E_ N_ T_
            {
            mC_(); 
            mU_(); 
            mR_(); 
            mR_(); 
            mE_(); 
            mN_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_CURRENT"

    // $ANTLR start "SQL92_RESERVED_CURSOR"
    public final void mSQL92_RESERVED_CURSOR() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_CURSOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:405:5: ( C_ U_ R_ S_ O_ R_ )
            // OracleLexer.g:405:10: C_ U_ R_ S_ O_ R_
            {
            mC_(); 
            mU_(); 
            mR_(); 
            mS_(); 
            mO_(); 
            mR_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_CURSOR"

    // $ANTLR start "SQL92_RESERVED_DATE"
    public final void mSQL92_RESERVED_DATE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:409:5: ( D_ A_ T_ E_ )
            // OracleLexer.g:409:10: D_ A_ T_ E_
            {
            mD_(); 
            mA_(); 
            mT_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_DATE"

    // $ANTLR start "SQL92_RESERVED_DECLARE"
    public final void mSQL92_RESERVED_DECLARE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_DECLARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:413:5: ( D_ E_ C_ L_ A_ R_ E_ )
            // OracleLexer.g:413:10: D_ E_ C_ L_ A_ R_ E_
            {
            mD_(); 
            mE_(); 
            mC_(); 
            mL_(); 
            mA_(); 
            mR_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_DECLARE"

    // $ANTLR start "SQL92_RESERVED_DEFAULT"
    public final void mSQL92_RESERVED_DEFAULT() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_DEFAULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:417:5: ( D_ E_ F_ A_ U_ L_ T_ )
            // OracleLexer.g:417:10: D_ E_ F_ A_ U_ L_ T_
            {
            mD_(); 
            mE_(); 
            mF_(); 
            mA_(); 
            mU_(); 
            mL_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_DEFAULT"

    // $ANTLR start "SQL92_RESERVED_DELETE"
    public final void mSQL92_RESERVED_DELETE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_DELETE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:421:5: ( D_ E_ L_ E_ T_ E_ )
            // OracleLexer.g:421:10: D_ E_ L_ E_ T_ E_
            {
            mD_(); 
            mE_(); 
            mL_(); 
            mE_(); 
            mT_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_DELETE"

    // $ANTLR start "SQL92_RESERVED_DESC"
    public final void mSQL92_RESERVED_DESC() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_DESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:425:5: ( D_ E_ S_ C_ )
            // OracleLexer.g:425:10: D_ E_ S_ C_
            {
            mD_(); 
            mE_(); 
            mS_(); 
            mC_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_DESC"

    // $ANTLR start "SQL92_RESERVED_DISTINCT"
    public final void mSQL92_RESERVED_DISTINCT() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_DISTINCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:429:5: ( D_ I_ S_ T_ I_ N_ C_ T_ )
            // OracleLexer.g:429:10: D_ I_ S_ T_ I_ N_ C_ T_
            {
            mD_(); 
            mI_(); 
            mS_(); 
            mT_(); 
            mI_(); 
            mN_(); 
            mC_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_DISTINCT"

    // $ANTLR start "SQL92_RESERVED_DROP"
    public final void mSQL92_RESERVED_DROP() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_DROP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:433:5: ( D_ R_ O_ P_ )
            // OracleLexer.g:433:10: D_ R_ O_ P_
            {
            mD_(); 
            mR_(); 
            mO_(); 
            mP_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_DROP"

    // $ANTLR start "SQL92_RESERVED_ELSE"
    public final void mSQL92_RESERVED_ELSE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:437:5: ( E_ L_ S_ E_ )
            // OracleLexer.g:437:10: E_ L_ S_ E_
            {
            mE_(); 
            mL_(); 
            mS_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_ELSE"

    // $ANTLR start "SQL92_RESERVED_END"
    public final void mSQL92_RESERVED_END() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:441:5: ( E_ N_ D_ )
            // OracleLexer.g:441:10: E_ N_ D_
            {
            mE_(); 
            mN_(); 
            mD_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_END"

    // $ANTLR start "SQL92_RESERVED_EXCEPTION"
    public final void mSQL92_RESERVED_EXCEPTION() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_EXCEPTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            Token e=null;

            // OracleLexer.g:445:5: (e= 'exception' | e= 'EXCEPTION' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0=='e') ) {
                alt38=1;
            }
            else if ( (LA38_0=='E') ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // OracleLexer.g:445:10: e= 'exception'
                    {
                    int eStart = getCharIndex();
                    match("exception"); 
                    e = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, eStart, getCharIndex()-1);

                    }
                    break;
                case 2 :
                    // OracleLexer.g:445:26: e= 'EXCEPTION'
                    {
                    int eStart = getCharIndex();
                    match("EXCEPTION"); 
                    e = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, eStart, getCharIndex()-1);

                        e.setType(SQL92_RESERVED_EXCEPTION);
                        emit(e);
                        advanceInput();

                        _type = Token.INVALID_TOKEN_TYPE;
                        int markModel = input.mark();

                        Token t1 = super.nextToken();
                        { 
                            if( t1 != null && t1.getType() == Token.EOF)
                            {
                                 e.setType(REGULAR_ID);
                            } else {
                                 t1 = tokenBuffer.pollLast(); 
                                 while(true)
                                 {
                                     if(t1.getType() == EOF)   
                                     {
                                         e.setType(REGULAR_ID);
                                         break;
                                     }

                                     if(t1.getChannel() == HIDDEN) 
                                     {
                                         t1 = super.nextToken(); if( t1 == null) { t1 = tokenBuffer.pollLast(); };
                                         continue;
                                     }

                                     if( t1.getType() != SQL92_RESERVED_WHEN && t1.getType() != SEMICOLON) 
                                     {
                                         e.setType(REGULAR_ID);
                                         break;
                                     }

                                     break; 
                                  } 
                             } 
                        }
                        input.rewind(markModel);
                        

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_EXCEPTION"

    // $ANTLR start "PLSQL_RESERVED_EXCLUSIVE"
    public final void mPLSQL_RESERVED_EXCLUSIVE() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_EXCLUSIVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:490:5: ( E_ X_ C_ L_ U_ S_ I_ V_ E_ )
            // OracleLexer.g:490:10: E_ X_ C_ L_ U_ S_ I_ V_ E_
            {
            mE_(); 
            mX_(); 
            mC_(); 
            mL_(); 
            mU_(); 
            mS_(); 
            mI_(); 
            mV_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_EXCLUSIVE"

    // $ANTLR start "SQL92_RESERVED_EXISTS"
    public final void mSQL92_RESERVED_EXISTS() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_EXISTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:494:5: ( E_ X_ I_ S_ T_ S_ )
            // OracleLexer.g:494:10: E_ X_ I_ S_ T_ S_
            {
            mE_(); 
            mX_(); 
            mI_(); 
            mS_(); 
            mT_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_EXISTS"

    // $ANTLR start "SQL92_RESERVED_FALSE"
    public final void mSQL92_RESERVED_FALSE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:498:5: ( F_ A_ L_ S_ E_ )
            // OracleLexer.g:498:10: F_ A_ L_ S_ E_
            {
            mF_(); 
            mA_(); 
            mL_(); 
            mS_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_FALSE"

    // $ANTLR start "SQL92_RESERVED_FETCH"
    public final void mSQL92_RESERVED_FETCH() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_FETCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:502:5: ( F_ E_ T_ C_ H_ )
            // OracleLexer.g:502:10: F_ E_ T_ C_ H_
            {
            mF_(); 
            mE_(); 
            mT_(); 
            mC_(); 
            mH_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_FETCH"

    // $ANTLR start "SQL92_RESERVED_FOR"
    public final void mSQL92_RESERVED_FOR() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:506:5: ( F_ O_ R_ )
            // OracleLexer.g:506:10: F_ O_ R_
            {
            mF_(); 
            mO_(); 
            mR_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_FOR"

    // $ANTLR start "SQL92_RESERVED_FROM"
    public final void mSQL92_RESERVED_FROM() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:510:5: ( F_ R_ O_ M_ )
            // OracleLexer.g:510:10: F_ R_ O_ M_
            {
            mF_(); 
            mR_(); 
            mO_(); 
            mM_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_FROM"

    // $ANTLR start "SQL92_RESERVED_GOTO"
    public final void mSQL92_RESERVED_GOTO() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_GOTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:514:5: ( G_ O_ T_ O_ )
            // OracleLexer.g:514:10: G_ O_ T_ O_
            {
            mG_(); 
            mO_(); 
            mT_(); 
            mO_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_GOTO"

    // $ANTLR start "SQL92_RESERVED_GRANT"
    public final void mSQL92_RESERVED_GRANT() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_GRANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:518:5: ( G_ R_ A_ N_ T_ )
            // OracleLexer.g:518:10: G_ R_ A_ N_ T_
            {
            mG_(); 
            mR_(); 
            mA_(); 
            mN_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_GRANT"

    // $ANTLR start "SQL92_RESERVED_GROUP"
    public final void mSQL92_RESERVED_GROUP() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_GROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:522:5: ( G_ R_ O_ U_ P_ )
            // OracleLexer.g:522:10: G_ R_ O_ U_ P_
            {
            mG_(); 
            mR_(); 
            mO_(); 
            mU_(); 
            mP_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_GROUP"

    // $ANTLR start "SQL92_RESERVED_HAVING"
    public final void mSQL92_RESERVED_HAVING() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_HAVING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:526:5: ( H_ A_ V_ I_ N_ G_ )
            // OracleLexer.g:526:10: H_ A_ V_ I_ N_ G_
            {
            mH_(); 
            mA_(); 
            mV_(); 
            mI_(); 
            mN_(); 
            mG_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_HAVING"

    // $ANTLR start "PLSQL_RESERVED_IDENTIFIED"
    public final void mPLSQL_RESERVED_IDENTIFIED() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_IDENTIFIED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:530:5: ( I_ D_ E_ N_ T_ I_ F_ I_ E_ D_ )
            // OracleLexer.g:530:10: I_ D_ E_ N_ T_ I_ F_ I_ E_ D_
            {
            mI_(); 
            mD_(); 
            mE_(); 
            mN_(); 
            mT_(); 
            mI_(); 
            mF_(); 
            mI_(); 
            mE_(); 
            mD_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_IDENTIFIED"

    // $ANTLR start "PLSQL_RESERVED_IF"
    public final void mPLSQL_RESERVED_IF() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:534:5: ( I_ F_ )
            // OracleLexer.g:534:10: I_ F_
            {
            mI_(); 
            mF_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_IF"

    // $ANTLR start "SQL92_RESERVED_IN"
    public final void mSQL92_RESERVED_IN() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:538:5: ( I_ N_ )
            // OracleLexer.g:538:10: I_ N_
            {
            mI_(); 
            mN_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_IN"

    // $ANTLR start "PLSQL_RESERVED_INDEX"
    public final void mPLSQL_RESERVED_INDEX() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_INDEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:542:5: ( I_ N_ D_ E_ X_ )
            // OracleLexer.g:542:10: I_ N_ D_ E_ X_
            {
            mI_(); 
            mN_(); 
            mD_(); 
            mE_(); 
            mX_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_INDEX"

    // $ANTLR start "PLSQL_RESERVED_INDEXES"
    public final void mPLSQL_RESERVED_INDEXES() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_INDEXES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:546:5: ( I_ N_ D_ E_ X_ E_ S_ )
            // OracleLexer.g:546:10: I_ N_ D_ E_ X_ E_ S_
            {
            mI_(); 
            mN_(); 
            mD_(); 
            mE_(); 
            mX_(); 
            mE_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_INDEXES"

    // $ANTLR start "SQL92_RESERVED_INSERT"
    public final void mSQL92_RESERVED_INSERT() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_INSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:550:5: ( I_ N_ S_ E_ R_ T_ )
            // OracleLexer.g:550:10: I_ N_ S_ E_ R_ T_
            {
            mI_(); 
            mN_(); 
            mS_(); 
            mE_(); 
            mR_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_INSERT"

    // $ANTLR start "SQL92_RESERVED_INTERSECT"
    public final void mSQL92_RESERVED_INTERSECT() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_INTERSECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:554:5: ( I_ N_ T_ E_ R_ S_ E_ C_ T_ )
            // OracleLexer.g:554:10: I_ N_ T_ E_ R_ S_ E_ C_ T_
            {
            mI_(); 
            mN_(); 
            mT_(); 
            mE_(); 
            mR_(); 
            mS_(); 
            mE_(); 
            mC_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_INTERSECT"

    // $ANTLR start "SQL92_RESERVED_INTO"
    public final void mSQL92_RESERVED_INTO() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_INTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:558:5: ( I_ N_ T_ O_ )
            // OracleLexer.g:558:10: I_ N_ T_ O_
            {
            mI_(); 
            mN_(); 
            mT_(); 
            mO_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_INTO"

    // $ANTLR start "SQL92_RESERVED_IS"
    public final void mSQL92_RESERVED_IS() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:562:5: ( I_ S_ )
            // OracleLexer.g:562:10: I_ S_
            {
            mI_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_IS"

    // $ANTLR start "SQL92_RESERVED_LIKE"
    public final void mSQL92_RESERVED_LIKE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_LIKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:566:5: ( L_ I_ K_ E_ )
            // OracleLexer.g:566:10: L_ I_ K_ E_
            {
            mL_(); 
            mI_(); 
            mK_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_LIKE"

    // $ANTLR start "PLSQL_RESERVED_LOCK"
    public final void mPLSQL_RESERVED_LOCK() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_LOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:570:5: ( L_ O_ C_ K_ )
            // OracleLexer.g:570:10: L_ O_ C_ K_
            {
            mL_(); 
            mO_(); 
            mC_(); 
            mK_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_LOCK"

    // $ANTLR start "PLSQL_RESERVED_MINUS"
    public final void mPLSQL_RESERVED_MINUS() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:574:5: ( M_ I_ N_ U_ S_ )
            // OracleLexer.g:574:10: M_ I_ N_ U_ S_
            {
            mM_(); 
            mI_(); 
            mN_(); 
            mU_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_MINUS"

    // $ANTLR start "PLSQL_RESERVED_MODE"
    public final void mPLSQL_RESERVED_MODE() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_MODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:578:5: ( M_ O_ D_ E_ )
            // OracleLexer.g:578:10: M_ O_ D_ E_
            {
            mM_(); 
            mO_(); 
            mD_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_MODE"

    // $ANTLR start "PLSQL_RESERVED_NOCOMPRESS"
    public final void mPLSQL_RESERVED_NOCOMPRESS() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_NOCOMPRESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:582:5: ( N_ O_ C_ O_ M_ P_ R_ E_ S_ S_ )
            // OracleLexer.g:582:10: N_ O_ C_ O_ M_ P_ R_ E_ S_ S_
            {
            mN_(); 
            mO_(); 
            mC_(); 
            mO_(); 
            mM_(); 
            mP_(); 
            mR_(); 
            mE_(); 
            mS_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_NOCOMPRESS"

    // $ANTLR start "SQL92_RESERVED_NOT"
    public final void mSQL92_RESERVED_NOT() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:586:5: ( N_ O_ T_ )
            // OracleLexer.g:586:10: N_ O_ T_
            {
            mN_(); 
            mO_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_NOT"

    // $ANTLR start "PLSQL_RESERVED_NOWAIT"
    public final void mPLSQL_RESERVED_NOWAIT() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_NOWAIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:590:5: ( N_ O_ W_ A_ I_ T_ )
            // OracleLexer.g:590:10: N_ O_ W_ A_ I_ T_
            {
            mN_(); 
            mO_(); 
            mW_(); 
            mA_(); 
            mI_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_NOWAIT"

    // $ANTLR start "SQL92_RESERVED_NULL"
    public final void mSQL92_RESERVED_NULL() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:594:5: ( N_ U_ L_ L_ )
            // OracleLexer.g:594:10: N_ U_ L_ L_
            {
            mN_(); 
            mU_(); 
            mL_(); 
            mL_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_NULL"

    // $ANTLR start "SQL92_RESERVED_OF"
    public final void mSQL92_RESERVED_OF() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_OF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:598:5: ( O_ F_ )
            // OracleLexer.g:598:10: O_ F_
            {
            mO_(); 
            mF_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_OF"

    // $ANTLR start "SQL92_RESERVED_ON"
    public final void mSQL92_RESERVED_ON() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:602:5: ( O_ N_ )
            // OracleLexer.g:602:10: O_ N_
            {
            mO_(); 
            mN_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_ON"

    // $ANTLR start "SQL92_RESERVED_OPTION"
    public final void mSQL92_RESERVED_OPTION() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_OPTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:606:5: ( O_ P_ T_ I_ O_ N_ )
            // OracleLexer.g:606:10: O_ P_ T_ I_ O_ N_
            {
            mO_(); 
            mP_(); 
            mT_(); 
            mI_(); 
            mO_(); 
            mN_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_OPTION"

    // $ANTLR start "SQL92_RESERVED_OR"
    public final void mSQL92_RESERVED_OR() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:610:5: ( O_ R_ )
            // OracleLexer.g:610:10: O_ R_
            {
            mO_(); 
            mR_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_OR"

    // $ANTLR start "SQL92_RESERVED_ORDER"
    public final void mSQL92_RESERVED_ORDER() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:614:5: ( O_ R_ D_ E_ R_ )
            // OracleLexer.g:614:10: O_ R_ D_ E_ R_
            {
            mO_(); 
            mR_(); 
            mD_(); 
            mE_(); 
            mR_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_ORDER"

    // $ANTLR start "SQL92_RESERVED_OVERLAPS"
    public final void mSQL92_RESERVED_OVERLAPS() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_OVERLAPS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:618:5: ( O_ V_ E_ R_ L_ A_ P_ S_ )
            // OracleLexer.g:618:10: O_ V_ E_ R_ L_ A_ P_ S_
            {
            mO_(); 
            mV_(); 
            mE_(); 
            mR_(); 
            mL_(); 
            mA_(); 
            mP_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_OVERLAPS"

    // $ANTLR start "SQL92_RESERVED_PRIOR"
    public final void mSQL92_RESERVED_PRIOR() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_PRIOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:622:5: ( P_ R_ I_ O_ R_ )
            // OracleLexer.g:622:10: P_ R_ I_ O_ R_
            {
            mP_(); 
            mR_(); 
            mI_(); 
            mO_(); 
            mR_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_PRIOR"

    // $ANTLR start "SQL92_RESERVED_PROCEDURE"
    public final void mSQL92_RESERVED_PROCEDURE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_PROCEDURE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:626:5: ( P_ R_ O_ C_ E_ D_ U_ R_ E_ )
            // OracleLexer.g:626:10: P_ R_ O_ C_ E_ D_ U_ R_ E_
            {
            mP_(); 
            mR_(); 
            mO_(); 
            mC_(); 
            mE_(); 
            mD_(); 
            mU_(); 
            mR_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_PROCEDURE"

    // $ANTLR start "SQL92_RESERVED_PUBLIC"
    public final void mSQL92_RESERVED_PUBLIC() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_PUBLIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:630:5: ( P_ U_ B_ L_ I_ C_ )
            // OracleLexer.g:630:10: P_ U_ B_ L_ I_ C_
            {
            mP_(); 
            mU_(); 
            mB_(); 
            mL_(); 
            mI_(); 
            mC_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_PUBLIC"

    // $ANTLR start "PLSQL_RESERVED_RESOURCE"
    public final void mPLSQL_RESERVED_RESOURCE() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_RESOURCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:634:5: ( R_ E_ S_ O_ U_ R_ C_ E_ )
            // OracleLexer.g:634:10: R_ E_ S_ O_ U_ R_ C_ E_
            {
            mR_(); 
            mE_(); 
            mS_(); 
            mO_(); 
            mU_(); 
            mR_(); 
            mC_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_RESOURCE"

    // $ANTLR start "SQL92_RESERVED_REVOKE"
    public final void mSQL92_RESERVED_REVOKE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_REVOKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:638:5: ( R_ E_ V_ O_ K_ E_ )
            // OracleLexer.g:638:10: R_ E_ V_ O_ K_ E_
            {
            mR_(); 
            mE_(); 
            mV_(); 
            mO_(); 
            mK_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_REVOKE"

    // $ANTLR start "SQL92_RESERVED_SELECT"
    public final void mSQL92_RESERVED_SELECT() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:642:5: ( S_ E_ L_ E_ C_ T_ )
            // OracleLexer.g:642:10: S_ E_ L_ E_ C_ T_
            {
            mS_(); 
            mE_(); 
            mL_(); 
            mE_(); 
            mC_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_SELECT"

    // $ANTLR start "PLSQL_RESERVED_SHARE"
    public final void mPLSQL_RESERVED_SHARE() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_SHARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:646:5: ( S_ H_ A_ R_ E_ )
            // OracleLexer.g:646:10: S_ H_ A_ R_ E_
            {
            mS_(); 
            mH_(); 
            mA_(); 
            mR_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_SHARE"

    // $ANTLR start "SQL92_RESERVED_SIZE"
    public final void mSQL92_RESERVED_SIZE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_SIZE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:650:5: ( S_ I_ Z_ E_ )
            // OracleLexer.g:650:10: S_ I_ Z_ E_
            {
            mS_(); 
            mI_(); 
            mZ_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_SIZE"

    // $ANTLR start "PLSQL_RESERVED_START"
    public final void mPLSQL_RESERVED_START() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:654:5: ( S_ T_ A_ R_ T_ )
            // OracleLexer.g:654:10: S_ T_ A_ R_ T_
            {
            mS_(); 
            mT_(); 
            mA_(); 
            mR_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_START"

    // $ANTLR start "PLSQL_RESERVED_TABAUTH"
    public final void mPLSQL_RESERVED_TABAUTH() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_TABAUTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:658:5: ( T_ A_ B_ A_ U_ T_ H_ )
            // OracleLexer.g:658:10: T_ A_ B_ A_ U_ T_ H_
            {
            mT_(); 
            mA_(); 
            mB_(); 
            mA_(); 
            mU_(); 
            mT_(); 
            mH_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_TABAUTH"

    // $ANTLR start "SQL92_RESERVED_TABLE"
    public final void mSQL92_RESERVED_TABLE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_TABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:662:5: ( T_ A_ B_ L_ E_ )
            // OracleLexer.g:662:10: T_ A_ B_ L_ E_
            {
            mT_(); 
            mA_(); 
            mB_(); 
            mL_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_TABLE"

    // $ANTLR start "SQL92_RESERVED_THE"
    public final void mSQL92_RESERVED_THE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_THE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:666:5: ( T_ H_ E_ )
            // OracleLexer.g:666:10: T_ H_ E_
            {
            mT_(); 
            mH_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_THE"

    // $ANTLR start "SQL92_RESERVED_THEN"
    public final void mSQL92_RESERVED_THEN() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:670:5: ( T_ H_ E_ N_ )
            // OracleLexer.g:670:10: T_ H_ E_ N_
            {
            mT_(); 
            mH_(); 
            mE_(); 
            mN_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_THEN"

    // $ANTLR start "SQL92_RESERVED_TO"
    public final void mSQL92_RESERVED_TO() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_TO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:674:5: ( T_ O_ )
            // OracleLexer.g:674:10: T_ O_
            {
            mT_(); 
            mO_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_TO"

    // $ANTLR start "SQL92_RESERVED_TRUE"
    public final void mSQL92_RESERVED_TRUE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:678:5: ( T_ R_ U_ E_ )
            // OracleLexer.g:678:10: T_ R_ U_ E_
            {
            mT_(); 
            mR_(); 
            mU_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_TRUE"

    // $ANTLR start "SQL92_RESERVED_UNION"
    public final void mSQL92_RESERVED_UNION() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_UNION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:682:5: ( U_ N_ I_ O_ N_ )
            // OracleLexer.g:682:10: U_ N_ I_ O_ N_
            {
            mU_(); 
            mN_(); 
            mI_(); 
            mO_(); 
            mN_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_UNION"

    // $ANTLR start "SQL92_RESERVED_UNIQUE"
    public final void mSQL92_RESERVED_UNIQUE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_UNIQUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:686:5: ( U_ N_ I_ Q_ U_ E_ )
            // OracleLexer.g:686:10: U_ N_ I_ Q_ U_ E_
            {
            mU_(); 
            mN_(); 
            mI_(); 
            mQ_(); 
            mU_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_UNIQUE"

    // $ANTLR start "SQL92_RESERVED_UPDATE"
    public final void mSQL92_RESERVED_UPDATE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_UPDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:690:5: ( U_ P_ D_ A_ T_ E_ )
            // OracleLexer.g:690:10: U_ P_ D_ A_ T_ E_
            {
            mU_(); 
            mP_(); 
            mD_(); 
            mA_(); 
            mT_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_UPDATE"

    // $ANTLR start "SQL92_RESERVED_VALUES"
    public final void mSQL92_RESERVED_VALUES() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_VALUES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:694:5: ( V_ A_ L_ U_ E_ S_ )
            // OracleLexer.g:694:10: V_ A_ L_ U_ E_ S_
            {
            mV_(); 
            mA_(); 
            mL_(); 
            mU_(); 
            mE_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_VALUES"

    // $ANTLR start "SQL92_RESERVED_VIEW"
    public final void mSQL92_RESERVED_VIEW() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_VIEW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:698:5: ( V_ I_ E_ W_ )
            // OracleLexer.g:698:10: V_ I_ E_ W_
            {
            mV_(); 
            mI_(); 
            mE_(); 
            mW_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_VIEW"

    // $ANTLR start "PLSQL_RESERVED_VIEWS"
    public final void mPLSQL_RESERVED_VIEWS() throws RecognitionException {
        try {
            int _type = PLSQL_RESERVED_VIEWS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:702:5: ( V_ I_ E_ W_ S_ )
            // OracleLexer.g:702:10: V_ I_ E_ W_ S_
            {
            mV_(); 
            mI_(); 
            mE_(); 
            mW_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_RESERVED_VIEWS"

    // $ANTLR start "SQL92_RESERVED_WHEN"
    public final void mSQL92_RESERVED_WHEN() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_WHEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:706:5: ( W_ H_ E_ N_ )
            // OracleLexer.g:706:10: W_ H_ E_ N_
            {
            mW_(); 
            mH_(); 
            mE_(); 
            mN_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_WHEN"

    // $ANTLR start "SQL92_RESERVED_WHERE"
    public final void mSQL92_RESERVED_WHERE() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:710:5: ( W_ H_ E_ R_ E_ )
            // OracleLexer.g:710:10: W_ H_ E_ R_ E_
            {
            mW_(); 
            mH_(); 
            mE_(); 
            mR_(); 
            mE_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_WHERE"

    // $ANTLR start "SQL92_RESERVED_WITH"
    public final void mSQL92_RESERVED_WITH() throws RecognitionException {
        try {
            int _type = SQL92_RESERVED_WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:714:5: ( W_ I_ T_ H_ )
            // OracleLexer.g:714:10: W_ I_ T_ H_
            {
            mW_(); 
            mI_(); 
            mT_(); 
            mH_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL92_RESERVED_WITH"

    // $ANTLR start "PLSQL_NON_RESERVED_USING"
    public final void mPLSQL_NON_RESERVED_USING() throws RecognitionException {
        try {
            int _type = PLSQL_NON_RESERVED_USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:718:5: ( U_ S_ I_ N_ G_ )
            // OracleLexer.g:718:10: U_ S_ I_ N_ G_
            {
            mU_(); 
            mS_(); 
            mI_(); 
            mN_(); 
            mG_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_NON_RESERVED_USING"

    // $ANTLR start "PLSQL_NON_RESERVED_MODEL"
    public final void mPLSQL_NON_RESERVED_MODEL() throws RecognitionException {
        try {
            int _type = PLSQL_NON_RESERVED_MODEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            Token m=null;

            // OracleLexer.g:722:5: (m= 'model' | m= 'MODEL' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0=='m') ) {
                alt39=1;
            }
            else if ( (LA39_0=='M') ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // OracleLexer.g:722:10: m= 'model'
                    {
                    int mStart = getCharIndex();
                    match("model"); 
                    m = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, mStart, getCharIndex()-1);

                    }
                    break;
                case 2 :
                    // OracleLexer.g:722:22: m= 'MODEL'
                    {
                    int mStart = getCharIndex();
                    match("MODEL"); 
                    m = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, mStart, getCharIndex()-1);

                             m.setType(PLSQL_NON_RESERVED_MODEL);
                             emit(m);
                             advanceInput();

                             _type = Token.INVALID_TOKEN_TYPE;
                             int markModel = input.mark();

                             Token t1 = super.nextToken();
                             {    
                                  if( t1 != null && t1.getType() == Token.EOF)
                                  {
                                      m.setType(REGULAR_ID);
                                  } else {
                                      t1 = tokenBuffer.pollLast(); 
                                      while(true)
                                      {
                                         if(t1.getType() == EOF)   
                                         {
                                             m.setType(REGULAR_ID);
                                             break;
                                         }

                                         if(t1.getChannel() == HIDDEN) 
                                         {
                                             t1 = super.nextToken(); if( t1 == null) { t1 = tokenBuffer.pollLast(); };
                                             continue;
                                         }

                                         if( t1.getType() != REGULAR_ID || 
                                            ( !t1.getText().equalsIgnoreCase("main") &&
                                              !t1.getText().equalsIgnoreCase("partition") &&
                                              !t1.getText().equalsIgnoreCase("dimension")
                                           ))
                                         {
                                             m.setType(REGULAR_ID);
                                             break;
                                         }

                                         break; 
                                      } 
                                  } 
                             }
                             input.rewind(markModel);
                        

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_NON_RESERVED_MODEL"

    // $ANTLR start "PLSQL_NON_RESERVED_ELSIF"
    public final void mPLSQL_NON_RESERVED_ELSIF() throws RecognitionException {
        try {
            int _type = PLSQL_NON_RESERVED_ELSIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:771:5: ( E_ L_ S_ I_ F_ )
            // OracleLexer.g:771:10: E_ L_ S_ I_ F_
            {
            mE_(); 
            mL_(); 
            mS_(); 
            mI_(); 
            mF_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_NON_RESERVED_ELSIF"

    // $ANTLR start "PLSQL_NON_RESERVED_PIVOT"
    public final void mPLSQL_NON_RESERVED_PIVOT() throws RecognitionException {
        try {
            int _type = PLSQL_NON_RESERVED_PIVOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:775:5: ( P_ I_ V_ O_ T_ )
            // OracleLexer.g:775:10: P_ I_ V_ O_ T_
            {
            mP_(); 
            mI_(); 
            mV_(); 
            mO_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_NON_RESERVED_PIVOT"

    // $ANTLR start "PLSQL_NON_RESERVED_UNPIVOT"
    public final void mPLSQL_NON_RESERVED_UNPIVOT() throws RecognitionException {
        try {
            int _type = PLSQL_NON_RESERVED_UNPIVOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:779:5: ( U_ N_ P_ I_ V_ O_ T_ )
            // OracleLexer.g:779:10: U_ N_ P_ I_ V_ O_ T_
            {
            mU_(); 
            mN_(); 
            mP_(); 
            mI_(); 
            mV_(); 
            mO_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLSQL_NON_RESERVED_UNPIVOT"

    // $ANTLR start "JOIN"
    public final void mJOIN() throws RecognitionException {
        try {
            int _type = JOIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:782:5: ( J_ O_ I_ N_ )
            // OracleLexer.g:782:7: J_ O_ I_ N_
            {
            mJ_(); 
            mO_(); 
            mI_(); 
            mN_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "JOIN"

    // $ANTLR start "LEFT"
    public final void mLEFT() throws RecognitionException {
        try {
            int _type = LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:783:5: ( L_ E_ F_ T_ )
            // OracleLexer.g:783:7: L_ E_ F_ T_
            {
            mL_(); 
            mE_(); 
            mF_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT"

    // $ANTLR start "RIGHT"
    public final void mRIGHT() throws RecognitionException {
        try {
            int _type = RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:784:6: ( R_ I_ G_ H_ T_ )
            // OracleLexer.g:784:8: R_ I_ G_ H_ T_
            {
            mR_(); 
            mI_(); 
            mG_(); 
            mH_(); 
            mT_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT"

    // $ANTLR start "FULL"
    public final void mFULL() throws RecognitionException {
        try {
            int _type = FULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:785:5: ( F_ U_ L_ L_ )
            // OracleLexer.g:785:7: F_ U_ L_ L_
            {
            mF_(); 
            mU_(); 
            mL_(); 
            mL_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FULL"

    // $ANTLR start "OUTER"
    public final void mOUTER() throws RecognitionException {
        try {
            int _type = OUTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:786:6: ( O_ U_ T_ E_ R_ )
            // OracleLexer.g:786:8: O_ U_ T_ E_ R_
            {
            mO_(); 
            mU_(); 
            mT_(); 
            mE_(); 
            mR_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTER"

    // $ANTLR start "CROSS"
    public final void mCROSS() throws RecognitionException {
        try {
            int _type = CROSS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:787:6: ( C_ R_ O_ S_ S_ )
            // OracleLexer.g:787:8: C_ R_ O_ S_ S_
            {
            mC_(); 
            mR_(); 
            mO_(); 
            mS_(); 
            mS_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CROSS"

    // $ANTLR start "NATURAL"
    public final void mNATURAL() throws RecognitionException {
        try {
            int _type = NATURAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:788:8: ( N_ A_ T_ U_ R_ A_ L_ )
            // OracleLexer.g:788:10: N_ A_ T_ U_ R_ A_ L_
            {
            mN_(); 
            mA_(); 
            mT_(); 
            mU_(); 
            mR_(); 
            mA_(); 
            mL_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NATURAL"

    // $ANTLR start "INNER"
    public final void mINNER() throws RecognitionException {
        try {
            int _type = INNER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:789:6: ( I_ N_ N_ E_ R_ )
            // OracleLexer.g:789:8: I_ N_ N_ E_ R_
            {
            mI_(); 
            mN_(); 
            mN_(); 
            mE_(); 
            mR_(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INNER"

    // $ANTLR start "REGULAR_ID"
    public final void mREGULAR_ID() throws RecognitionException {
        try {
            int _type = REGULAR_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:792:5: ( ( SIMPLE_LETTER ) ( SIMPLE_LETTER | '$' | '_' | '#' | '0' .. '9' )* )
            // OracleLexer.g:792:10: ( SIMPLE_LETTER ) ( SIMPLE_LETTER | '$' | '_' | '#' | '0' .. '9' )*
            {
            // OracleLexer.g:792:10: ( SIMPLE_LETTER )
            // OracleLexer.g:792:11: SIMPLE_LETTER
            {
            mSIMPLE_LETTER(); 

            }

            // OracleLexer.g:792:26: ( SIMPLE_LETTER | '$' | '_' | '#' | '0' .. '9' )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>='#' && LA40_0<='$')||(LA40_0>='0' && LA40_0<='9')||(LA40_0>='A' && LA40_0<='Z')||LA40_0=='_'||(LA40_0>='a' && LA40_0<='z')) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // OracleLexer.g:
            	    {
            	    if ( (input.LA(1)>='#' && input.LA(1)<='$')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REGULAR_ID"

    // $ANTLR start "ZV"
    public final void mZV() throws RecognitionException {
        try {
            int _type = ZV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // OracleLexer.g:796:5: ( '@!' )
            // OracleLexer.g:796:10: '@!'
            {
            match("@!"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ZV"

    public void mTokens() throws RecognitionException {
        // OracleLexer.g:1:8: ( FOR_NOTATION | NATIONAL_CHAR_STRING_LIT | BIT_STRING_LIT | HEX_STRING_LIT | PERIOD | EXACT_NUM_LIT | CHAR_STRING | CHAR_STRING_PERL | DELIMITED_ID | PERCENT | AMPERSAND | LEFT_PAREN | RIGHT_PAREN | DOUBLE_ASTERISK | ASTERISK | PLUS_SIGN | COMMA | SOLIDUS | AT_SIGN | ASSIGN_OP | BINDVAR | COLON | SEMICOLON | LESS_THAN_OR_EQUALS_OP | LESS_THAN_OP | GREATER_THAN_OR_EQUALS_OP | NOT_EQUAL_OP | CARRET_OPERATOR_PART | TILDE_OPERATOR_PART | EXCLAMATION_OPERATOR_PART | GREATER_THAN_OP | CONCATENATION_OP | VERTICAL_BAR | EQUALS_OP | LEFT_BRACKET | RIGHT_BRACKET | INTRODUCER | SEPARATOR | PROMPT | SQL92_RESERVED_ALL | SQL92_RESERVED_ALTER | SQL92_RESERVED_AND | SQL92_RESERVED_ANY | SQL92_RESERVED_AS | SQL92_RESERVED_ASC | SQL92_RESERVED_BEGIN | SQL92_RESERVED_BETWEEN | SQL92_RESERVED_BY | SQL92_RESERVED_CASE | SQL92_RESERVED_CHECK | PLSQL_RESERVED_CLUSTERS | PLSQL_RESERVED_COLAUTH | PLSQL_RESERVED_COMPRESS | SQL92_RESERVED_CONNECT | PLSQL_NON_RESERVED_CONNECT_BY_ROOT | PLSQL_RESERVED_CRASH | SQL92_RESERVED_CREATE | SQL92_RESERVED_CURRENT | SQL92_RESERVED_CURSOR | SQL92_RESERVED_DATE | SQL92_RESERVED_DECLARE | SQL92_RESERVED_DEFAULT | SQL92_RESERVED_DELETE | SQL92_RESERVED_DESC | SQL92_RESERVED_DISTINCT | SQL92_RESERVED_DROP | SQL92_RESERVED_ELSE | SQL92_RESERVED_END | SQL92_RESERVED_EXCEPTION | PLSQL_RESERVED_EXCLUSIVE | SQL92_RESERVED_EXISTS | SQL92_RESERVED_FALSE | SQL92_RESERVED_FETCH | SQL92_RESERVED_FOR | SQL92_RESERVED_FROM | SQL92_RESERVED_GOTO | SQL92_RESERVED_GRANT | SQL92_RESERVED_GROUP | SQL92_RESERVED_HAVING | PLSQL_RESERVED_IDENTIFIED | PLSQL_RESERVED_IF | SQL92_RESERVED_IN | PLSQL_RESERVED_INDEX | PLSQL_RESERVED_INDEXES | SQL92_RESERVED_INSERT | SQL92_RESERVED_INTERSECT | SQL92_RESERVED_INTO | SQL92_RESERVED_IS | SQL92_RESERVED_LIKE | PLSQL_RESERVED_LOCK | PLSQL_RESERVED_MINUS | PLSQL_RESERVED_MODE | PLSQL_RESERVED_NOCOMPRESS | SQL92_RESERVED_NOT | PLSQL_RESERVED_NOWAIT | SQL92_RESERVED_NULL | SQL92_RESERVED_OF | SQL92_RESERVED_ON | SQL92_RESERVED_OPTION | SQL92_RESERVED_OR | SQL92_RESERVED_ORDER | SQL92_RESERVED_OVERLAPS | SQL92_RESERVED_PRIOR | SQL92_RESERVED_PROCEDURE | SQL92_RESERVED_PUBLIC | PLSQL_RESERVED_RESOURCE | SQL92_RESERVED_REVOKE | SQL92_RESERVED_SELECT | PLSQL_RESERVED_SHARE | SQL92_RESERVED_SIZE | PLSQL_RESERVED_START | PLSQL_RESERVED_TABAUTH | SQL92_RESERVED_TABLE | SQL92_RESERVED_THE | SQL92_RESERVED_THEN | SQL92_RESERVED_TO | SQL92_RESERVED_TRUE | SQL92_RESERVED_UNION | SQL92_RESERVED_UNIQUE | SQL92_RESERVED_UPDATE | SQL92_RESERVED_VALUES | SQL92_RESERVED_VIEW | PLSQL_RESERVED_VIEWS | SQL92_RESERVED_WHEN | SQL92_RESERVED_WHERE | SQL92_RESERVED_WITH | PLSQL_NON_RESERVED_USING | PLSQL_NON_RESERVED_MODEL | PLSQL_NON_RESERVED_ELSIF | PLSQL_NON_RESERVED_PIVOT | PLSQL_NON_RESERVED_UNPIVOT | JOIN | LEFT | RIGHT | FULL | OUTER | CROSS | NATURAL | INNER | REGULAR_ID | ZV )
        int alt41=141;
        alt41 = dfa41.predict(input);
        switch (alt41) {
            case 1 :
                // OracleLexer.g:1:10: FOR_NOTATION
                {
                mFOR_NOTATION(); 

                }
                break;
            case 2 :
                // OracleLexer.g:1:23: NATIONAL_CHAR_STRING_LIT
                {
                mNATIONAL_CHAR_STRING_LIT(); 

                }
                break;
            case 3 :
                // OracleLexer.g:1:48: BIT_STRING_LIT
                {
                mBIT_STRING_LIT(); 

                }
                break;
            case 4 :
                // OracleLexer.g:1:63: HEX_STRING_LIT
                {
                mHEX_STRING_LIT(); 

                }
                break;
            case 5 :
                // OracleLexer.g:1:78: PERIOD
                {
                mPERIOD(); 

                }
                break;
            case 6 :
                // OracleLexer.g:1:85: EXACT_NUM_LIT
                {
                mEXACT_NUM_LIT(); 

                }
                break;
            case 7 :
                // OracleLexer.g:1:99: CHAR_STRING
                {
                mCHAR_STRING(); 

                }
                break;
            case 8 :
                // OracleLexer.g:1:111: CHAR_STRING_PERL
                {
                mCHAR_STRING_PERL(); 

                }
                break;
            case 9 :
                // OracleLexer.g:1:128: DELIMITED_ID
                {
                mDELIMITED_ID(); 

                }
                break;
            case 10 :
                // OracleLexer.g:1:141: PERCENT
                {
                mPERCENT(); 

                }
                break;
            case 11 :
                // OracleLexer.g:1:149: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 12 :
                // OracleLexer.g:1:159: LEFT_PAREN
                {
                mLEFT_PAREN(); 

                }
                break;
            case 13 :
                // OracleLexer.g:1:170: RIGHT_PAREN
                {
                mRIGHT_PAREN(); 

                }
                break;
            case 14 :
                // OracleLexer.g:1:182: DOUBLE_ASTERISK
                {
                mDOUBLE_ASTERISK(); 

                }
                break;
            case 15 :
                // OracleLexer.g:1:198: ASTERISK
                {
                mASTERISK(); 

                }
                break;
            case 16 :
                // OracleLexer.g:1:207: PLUS_SIGN
                {
                mPLUS_SIGN(); 

                }
                break;
            case 17 :
                // OracleLexer.g:1:217: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 18 :
                // OracleLexer.g:1:223: SOLIDUS
                {
                mSOLIDUS(); 

                }
                break;
            case 19 :
                // OracleLexer.g:1:231: AT_SIGN
                {
                mAT_SIGN(); 

                }
                break;
            case 20 :
                // OracleLexer.g:1:239: ASSIGN_OP
                {
                mASSIGN_OP(); 

                }
                break;
            case 21 :
                // OracleLexer.g:1:249: BINDVAR
                {
                mBINDVAR(); 

                }
                break;
            case 22 :
                // OracleLexer.g:1:257: COLON
                {
                mCOLON(); 

                }
                break;
            case 23 :
                // OracleLexer.g:1:263: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 24 :
                // OracleLexer.g:1:273: LESS_THAN_OR_EQUALS_OP
                {
                mLESS_THAN_OR_EQUALS_OP(); 

                }
                break;
            case 25 :
                // OracleLexer.g:1:296: LESS_THAN_OP
                {
                mLESS_THAN_OP(); 

                }
                break;
            case 26 :
                // OracleLexer.g:1:309: GREATER_THAN_OR_EQUALS_OP
                {
                mGREATER_THAN_OR_EQUALS_OP(); 

                }
                break;
            case 27 :
                // OracleLexer.g:1:335: NOT_EQUAL_OP
                {
                mNOT_EQUAL_OP(); 

                }
                break;
            case 28 :
                // OracleLexer.g:1:348: CARRET_OPERATOR_PART
                {
                mCARRET_OPERATOR_PART(); 

                }
                break;
            case 29 :
                // OracleLexer.g:1:369: TILDE_OPERATOR_PART
                {
                mTILDE_OPERATOR_PART(); 

                }
                break;
            case 30 :
                // OracleLexer.g:1:389: EXCLAMATION_OPERATOR_PART
                {
                mEXCLAMATION_OPERATOR_PART(); 

                }
                break;
            case 31 :
                // OracleLexer.g:1:415: GREATER_THAN_OP
                {
                mGREATER_THAN_OP(); 

                }
                break;
            case 32 :
                // OracleLexer.g:1:431: CONCATENATION_OP
                {
                mCONCATENATION_OP(); 

                }
                break;
            case 33 :
                // OracleLexer.g:1:448: VERTICAL_BAR
                {
                mVERTICAL_BAR(); 

                }
                break;
            case 34 :
                // OracleLexer.g:1:461: EQUALS_OP
                {
                mEQUALS_OP(); 

                }
                break;
            case 35 :
                // OracleLexer.g:1:471: LEFT_BRACKET
                {
                mLEFT_BRACKET(); 

                }
                break;
            case 36 :
                // OracleLexer.g:1:484: RIGHT_BRACKET
                {
                mRIGHT_BRACKET(); 

                }
                break;
            case 37 :
                // OracleLexer.g:1:498: INTRODUCER
                {
                mINTRODUCER(); 

                }
                break;
            case 38 :
                // OracleLexer.g:1:509: SEPARATOR
                {
                mSEPARATOR(); 

                }
                break;
            case 39 :
                // OracleLexer.g:1:519: PROMPT
                {
                mPROMPT(); 

                }
                break;
            case 40 :
                // OracleLexer.g:1:526: SQL92_RESERVED_ALL
                {
                mSQL92_RESERVED_ALL(); 

                }
                break;
            case 41 :
                // OracleLexer.g:1:545: SQL92_RESERVED_ALTER
                {
                mSQL92_RESERVED_ALTER(); 

                }
                break;
            case 42 :
                // OracleLexer.g:1:566: SQL92_RESERVED_AND
                {
                mSQL92_RESERVED_AND(); 

                }
                break;
            case 43 :
                // OracleLexer.g:1:585: SQL92_RESERVED_ANY
                {
                mSQL92_RESERVED_ANY(); 

                }
                break;
            case 44 :
                // OracleLexer.g:1:604: SQL92_RESERVED_AS
                {
                mSQL92_RESERVED_AS(); 

                }
                break;
            case 45 :
                // OracleLexer.g:1:622: SQL92_RESERVED_ASC
                {
                mSQL92_RESERVED_ASC(); 

                }
                break;
            case 46 :
                // OracleLexer.g:1:641: SQL92_RESERVED_BEGIN
                {
                mSQL92_RESERVED_BEGIN(); 

                }
                break;
            case 47 :
                // OracleLexer.g:1:662: SQL92_RESERVED_BETWEEN
                {
                mSQL92_RESERVED_BETWEEN(); 

                }
                break;
            case 48 :
                // OracleLexer.g:1:685: SQL92_RESERVED_BY
                {
                mSQL92_RESERVED_BY(); 

                }
                break;
            case 49 :
                // OracleLexer.g:1:703: SQL92_RESERVED_CASE
                {
                mSQL92_RESERVED_CASE(); 

                }
                break;
            case 50 :
                // OracleLexer.g:1:723: SQL92_RESERVED_CHECK
                {
                mSQL92_RESERVED_CHECK(); 

                }
                break;
            case 51 :
                // OracleLexer.g:1:744: PLSQL_RESERVED_CLUSTERS
                {
                mPLSQL_RESERVED_CLUSTERS(); 

                }
                break;
            case 52 :
                // OracleLexer.g:1:768: PLSQL_RESERVED_COLAUTH
                {
                mPLSQL_RESERVED_COLAUTH(); 

                }
                break;
            case 53 :
                // OracleLexer.g:1:791: PLSQL_RESERVED_COMPRESS
                {
                mPLSQL_RESERVED_COMPRESS(); 

                }
                break;
            case 54 :
                // OracleLexer.g:1:815: SQL92_RESERVED_CONNECT
                {
                mSQL92_RESERVED_CONNECT(); 

                }
                break;
            case 55 :
                // OracleLexer.g:1:838: PLSQL_NON_RESERVED_CONNECT_BY_ROOT
                {
                mPLSQL_NON_RESERVED_CONNECT_BY_ROOT(); 

                }
                break;
            case 56 :
                // OracleLexer.g:1:873: PLSQL_RESERVED_CRASH
                {
                mPLSQL_RESERVED_CRASH(); 

                }
                break;
            case 57 :
                // OracleLexer.g:1:894: SQL92_RESERVED_CREATE
                {
                mSQL92_RESERVED_CREATE(); 

                }
                break;
            case 58 :
                // OracleLexer.g:1:916: SQL92_RESERVED_CURRENT
                {
                mSQL92_RESERVED_CURRENT(); 

                }
                break;
            case 59 :
                // OracleLexer.g:1:939: SQL92_RESERVED_CURSOR
                {
                mSQL92_RESERVED_CURSOR(); 

                }
                break;
            case 60 :
                // OracleLexer.g:1:961: SQL92_RESERVED_DATE
                {
                mSQL92_RESERVED_DATE(); 

                }
                break;
            case 61 :
                // OracleLexer.g:1:981: SQL92_RESERVED_DECLARE
                {
                mSQL92_RESERVED_DECLARE(); 

                }
                break;
            case 62 :
                // OracleLexer.g:1:1004: SQL92_RESERVED_DEFAULT
                {
                mSQL92_RESERVED_DEFAULT(); 

                }
                break;
            case 63 :
                // OracleLexer.g:1:1027: SQL92_RESERVED_DELETE
                {
                mSQL92_RESERVED_DELETE(); 

                }
                break;
            case 64 :
                // OracleLexer.g:1:1049: SQL92_RESERVED_DESC
                {
                mSQL92_RESERVED_DESC(); 

                }
                break;
            case 65 :
                // OracleLexer.g:1:1069: SQL92_RESERVED_DISTINCT
                {
                mSQL92_RESERVED_DISTINCT(); 

                }
                break;
            case 66 :
                // OracleLexer.g:1:1093: SQL92_RESERVED_DROP
                {
                mSQL92_RESERVED_DROP(); 

                }
                break;
            case 67 :
                // OracleLexer.g:1:1113: SQL92_RESERVED_ELSE
                {
                mSQL92_RESERVED_ELSE(); 

                }
                break;
            case 68 :
                // OracleLexer.g:1:1133: SQL92_RESERVED_END
                {
                mSQL92_RESERVED_END(); 

                }
                break;
            case 69 :
                // OracleLexer.g:1:1152: SQL92_RESERVED_EXCEPTION
                {
                mSQL92_RESERVED_EXCEPTION(); 

                }
                break;
            case 70 :
                // OracleLexer.g:1:1177: PLSQL_RESERVED_EXCLUSIVE
                {
                mPLSQL_RESERVED_EXCLUSIVE(); 

                }
                break;
            case 71 :
                // OracleLexer.g:1:1202: SQL92_RESERVED_EXISTS
                {
                mSQL92_RESERVED_EXISTS(); 

                }
                break;
            case 72 :
                // OracleLexer.g:1:1224: SQL92_RESERVED_FALSE
                {
                mSQL92_RESERVED_FALSE(); 

                }
                break;
            case 73 :
                // OracleLexer.g:1:1245: SQL92_RESERVED_FETCH
                {
                mSQL92_RESERVED_FETCH(); 

                }
                break;
            case 74 :
                // OracleLexer.g:1:1266: SQL92_RESERVED_FOR
                {
                mSQL92_RESERVED_FOR(); 

                }
                break;
            case 75 :
                // OracleLexer.g:1:1285: SQL92_RESERVED_FROM
                {
                mSQL92_RESERVED_FROM(); 

                }
                break;
            case 76 :
                // OracleLexer.g:1:1305: SQL92_RESERVED_GOTO
                {
                mSQL92_RESERVED_GOTO(); 

                }
                break;
            case 77 :
                // OracleLexer.g:1:1325: SQL92_RESERVED_GRANT
                {
                mSQL92_RESERVED_GRANT(); 

                }
                break;
            case 78 :
                // OracleLexer.g:1:1346: SQL92_RESERVED_GROUP
                {
                mSQL92_RESERVED_GROUP(); 

                }
                break;
            case 79 :
                // OracleLexer.g:1:1367: SQL92_RESERVED_HAVING
                {
                mSQL92_RESERVED_HAVING(); 

                }
                break;
            case 80 :
                // OracleLexer.g:1:1389: PLSQL_RESERVED_IDENTIFIED
                {
                mPLSQL_RESERVED_IDENTIFIED(); 

                }
                break;
            case 81 :
                // OracleLexer.g:1:1415: PLSQL_RESERVED_IF
                {
                mPLSQL_RESERVED_IF(); 

                }
                break;
            case 82 :
                // OracleLexer.g:1:1433: SQL92_RESERVED_IN
                {
                mSQL92_RESERVED_IN(); 

                }
                break;
            case 83 :
                // OracleLexer.g:1:1451: PLSQL_RESERVED_INDEX
                {
                mPLSQL_RESERVED_INDEX(); 

                }
                break;
            case 84 :
                // OracleLexer.g:1:1472: PLSQL_RESERVED_INDEXES
                {
                mPLSQL_RESERVED_INDEXES(); 

                }
                break;
            case 85 :
                // OracleLexer.g:1:1495: SQL92_RESERVED_INSERT
                {
                mSQL92_RESERVED_INSERT(); 

                }
                break;
            case 86 :
                // OracleLexer.g:1:1517: SQL92_RESERVED_INTERSECT
                {
                mSQL92_RESERVED_INTERSECT(); 

                }
                break;
            case 87 :
                // OracleLexer.g:1:1542: SQL92_RESERVED_INTO
                {
                mSQL92_RESERVED_INTO(); 

                }
                break;
            case 88 :
                // OracleLexer.g:1:1562: SQL92_RESERVED_IS
                {
                mSQL92_RESERVED_IS(); 

                }
                break;
            case 89 :
                // OracleLexer.g:1:1580: SQL92_RESERVED_LIKE
                {
                mSQL92_RESERVED_LIKE(); 

                }
                break;
            case 90 :
                // OracleLexer.g:1:1600: PLSQL_RESERVED_LOCK
                {
                mPLSQL_RESERVED_LOCK(); 

                }
                break;
            case 91 :
                // OracleLexer.g:1:1620: PLSQL_RESERVED_MINUS
                {
                mPLSQL_RESERVED_MINUS(); 

                }
                break;
            case 92 :
                // OracleLexer.g:1:1641: PLSQL_RESERVED_MODE
                {
                mPLSQL_RESERVED_MODE(); 

                }
                break;
            case 93 :
                // OracleLexer.g:1:1661: PLSQL_RESERVED_NOCOMPRESS
                {
                mPLSQL_RESERVED_NOCOMPRESS(); 

                }
                break;
            case 94 :
                // OracleLexer.g:1:1687: SQL92_RESERVED_NOT
                {
                mSQL92_RESERVED_NOT(); 

                }
                break;
            case 95 :
                // OracleLexer.g:1:1706: PLSQL_RESERVED_NOWAIT
                {
                mPLSQL_RESERVED_NOWAIT(); 

                }
                break;
            case 96 :
                // OracleLexer.g:1:1728: SQL92_RESERVED_NULL
                {
                mSQL92_RESERVED_NULL(); 

                }
                break;
            case 97 :
                // OracleLexer.g:1:1748: SQL92_RESERVED_OF
                {
                mSQL92_RESERVED_OF(); 

                }
                break;
            case 98 :
                // OracleLexer.g:1:1766: SQL92_RESERVED_ON
                {
                mSQL92_RESERVED_ON(); 

                }
                break;
            case 99 :
                // OracleLexer.g:1:1784: SQL92_RESERVED_OPTION
                {
                mSQL92_RESERVED_OPTION(); 

                }
                break;
            case 100 :
                // OracleLexer.g:1:1806: SQL92_RESERVED_OR
                {
                mSQL92_RESERVED_OR(); 

                }
                break;
            case 101 :
                // OracleLexer.g:1:1824: SQL92_RESERVED_ORDER
                {
                mSQL92_RESERVED_ORDER(); 

                }
                break;
            case 102 :
                // OracleLexer.g:1:1845: SQL92_RESERVED_OVERLAPS
                {
                mSQL92_RESERVED_OVERLAPS(); 

                }
                break;
            case 103 :
                // OracleLexer.g:1:1869: SQL92_RESERVED_PRIOR
                {
                mSQL92_RESERVED_PRIOR(); 

                }
                break;
            case 104 :
                // OracleLexer.g:1:1890: SQL92_RESERVED_PROCEDURE
                {
                mSQL92_RESERVED_PROCEDURE(); 

                }
                break;
            case 105 :
                // OracleLexer.g:1:1915: SQL92_RESERVED_PUBLIC
                {
                mSQL92_RESERVED_PUBLIC(); 

                }
                break;
            case 106 :
                // OracleLexer.g:1:1937: PLSQL_RESERVED_RESOURCE
                {
                mPLSQL_RESERVED_RESOURCE(); 

                }
                break;
            case 107 :
                // OracleLexer.g:1:1961: SQL92_RESERVED_REVOKE
                {
                mSQL92_RESERVED_REVOKE(); 

                }
                break;
            case 108 :
                // OracleLexer.g:1:1983: SQL92_RESERVED_SELECT
                {
                mSQL92_RESERVED_SELECT(); 

                }
                break;
            case 109 :
                // OracleLexer.g:1:2005: PLSQL_RESERVED_SHARE
                {
                mPLSQL_RESERVED_SHARE(); 

                }
                break;
            case 110 :
                // OracleLexer.g:1:2026: SQL92_RESERVED_SIZE
                {
                mSQL92_RESERVED_SIZE(); 

                }
                break;
            case 111 :
                // OracleLexer.g:1:2046: PLSQL_RESERVED_START
                {
                mPLSQL_RESERVED_START(); 

                }
                break;
            case 112 :
                // OracleLexer.g:1:2067: PLSQL_RESERVED_TABAUTH
                {
                mPLSQL_RESERVED_TABAUTH(); 

                }
                break;
            case 113 :
                // OracleLexer.g:1:2090: SQL92_RESERVED_TABLE
                {
                mSQL92_RESERVED_TABLE(); 

                }
                break;
            case 114 :
                // OracleLexer.g:1:2111: SQL92_RESERVED_THE
                {
                mSQL92_RESERVED_THE(); 

                }
                break;
            case 115 :
                // OracleLexer.g:1:2130: SQL92_RESERVED_THEN
                {
                mSQL92_RESERVED_THEN(); 

                }
                break;
            case 116 :
                // OracleLexer.g:1:2150: SQL92_RESERVED_TO
                {
                mSQL92_RESERVED_TO(); 

                }
                break;
            case 117 :
                // OracleLexer.g:1:2168: SQL92_RESERVED_TRUE
                {
                mSQL92_RESERVED_TRUE(); 

                }
                break;
            case 118 :
                // OracleLexer.g:1:2188: SQL92_RESERVED_UNION
                {
                mSQL92_RESERVED_UNION(); 

                }
                break;
            case 119 :
                // OracleLexer.g:1:2209: SQL92_RESERVED_UNIQUE
                {
                mSQL92_RESERVED_UNIQUE(); 

                }
                break;
            case 120 :
                // OracleLexer.g:1:2231: SQL92_RESERVED_UPDATE
                {
                mSQL92_RESERVED_UPDATE(); 

                }
                break;
            case 121 :
                // OracleLexer.g:1:2253: SQL92_RESERVED_VALUES
                {
                mSQL92_RESERVED_VALUES(); 

                }
                break;
            case 122 :
                // OracleLexer.g:1:2275: SQL92_RESERVED_VIEW
                {
                mSQL92_RESERVED_VIEW(); 

                }
                break;
            case 123 :
                // OracleLexer.g:1:2295: PLSQL_RESERVED_VIEWS
                {
                mPLSQL_RESERVED_VIEWS(); 

                }
                break;
            case 124 :
                // OracleLexer.g:1:2316: SQL92_RESERVED_WHEN
                {
                mSQL92_RESERVED_WHEN(); 

                }
                break;
            case 125 :
                // OracleLexer.g:1:2336: SQL92_RESERVED_WHERE
                {
                mSQL92_RESERVED_WHERE(); 

                }
                break;
            case 126 :
                // OracleLexer.g:1:2357: SQL92_RESERVED_WITH
                {
                mSQL92_RESERVED_WITH(); 

                }
                break;
            case 127 :
                // OracleLexer.g:1:2377: PLSQL_NON_RESERVED_USING
                {
                mPLSQL_NON_RESERVED_USING(); 

                }
                break;
            case 128 :
                // OracleLexer.g:1:2402: PLSQL_NON_RESERVED_MODEL
                {
                mPLSQL_NON_RESERVED_MODEL(); 

                }
                break;
            case 129 :
                // OracleLexer.g:1:2427: PLSQL_NON_RESERVED_ELSIF
                {
                mPLSQL_NON_RESERVED_ELSIF(); 

                }
                break;
            case 130 :
                // OracleLexer.g:1:2452: PLSQL_NON_RESERVED_PIVOT
                {
                mPLSQL_NON_RESERVED_PIVOT(); 

                }
                break;
            case 131 :
                // OracleLexer.g:1:2477: PLSQL_NON_RESERVED_UNPIVOT
                {
                mPLSQL_NON_RESERVED_UNPIVOT(); 

                }
                break;
            case 132 :
                // OracleLexer.g:1:2504: JOIN
                {
                mJOIN(); 

                }
                break;
            case 133 :
                // OracleLexer.g:1:2509: LEFT
                {
                mLEFT(); 

                }
                break;
            case 134 :
                // OracleLexer.g:1:2514: RIGHT
                {
                mRIGHT(); 

                }
                break;
            case 135 :
                // OracleLexer.g:1:2520: FULL
                {
                mFULL(); 

                }
                break;
            case 136 :
                // OracleLexer.g:1:2525: OUTER
                {
                mOUTER(); 

                }
                break;
            case 137 :
                // OracleLexer.g:1:2531: CROSS
                {
                mCROSS(); 

                }
                break;
            case 138 :
                // OracleLexer.g:1:2537: NATURAL
                {
                mNATURAL(); 

                }
                break;
            case 139 :
                // OracleLexer.g:1:2545: INNER
                {
                mINNER(); 

                }
                break;
            case 140 :
                // OracleLexer.g:1:2551: REGULAR_ID
                {
                mREGULAR_ID(); 

                }
                break;
            case 141 :
                // OracleLexer.g:1:2562: ZV
                {
                mZV(); 

                }
                break;

        }

    }


    protected DFA41 dfa41 = new DFA41(this);
    static final String DFA41_eotS =
        "\1\uffff\1\66\3\65\1\100\1\uffff\1\65\5\uffff\1\103\2\uffff\1\104"+
        "\1\106\1\110\2\uffff\1\113\1\115\1\116\1\117\1\120\1\122\5\uffff"+
        "\25\65\3\uffff\1\65\1\uffff\3\65\1\u009b\25\uffff\4\65\1\u00a2\30"+
        "\65\1\u00c6\1\u00cb\1\u00cc\10\65\1\u00d5\1\u00d7\2\65\1\u00da\11"+
        "\65\1\u00e5\11\65\1\uffff\1\65\1\u00f1\5\65\1\uffff\5\65\1\u00fd"+
        "\1\uffff\1\u00fe\1\u00ff\1\u0100\25\65\1\u0118\4\65\1\u011d\5\65"+
        "\1\uffff\4\65\2\uffff\10\65\1\uffff\1\65\1\uffff\2\65\1\uffff\7"+
        "\65\1\u013a\2\65\1\uffff\13\65\1\uffff\2\65\1\u014e\10\65\4\uffff"+
        "\12\65\1\u0161\2\65\1\u0164\2\65\1\u0167\1\u0168\3\65\1\u016c\1"+
        "\65\1\uffff\1\65\1\u016f\2\65\1\uffff\1\u0172\2\65\1\u0175\3\65"+
        "\1\u0179\3\65\1\u017d\1\u017e\1\u017f\2\u0181\13\65\1\u018d\1\uffff"+
        "\1\u018e\2\65\1\u0191\5\65\1\u0197\1\65\1\u019a\1\u019b\1\65\1\u0181"+
        "\1\u019e\3\65\1\uffff\1\65\1\u01a3\2\65\1\u01a6\1\65\1\u01a8\1\u01a9"+
        "\3\65\1\u01ad\3\65\1\u01b1\1\65\1\u01b3\1\uffff\2\65\1\uffff\2\65"+
        "\2\uffff\3\65\1\uffff\1\u01bb\1\65\1\uffff\1\u01bd\1\u01be\1\uffff"+
        "\1\u01bf\1\u01c0\1\uffff\1\65\1\u01c2\1\65\1\uffff\1\65\1\u01c6"+
        "\1\65\3\uffff\1\u01c8\1\uffff\1\u01c9\1\u01ca\1\u01cb\4\65\1\u01d0"+
        "\1\65\1\u01d2\1\u01d3\2\uffff\1\65\1\u01d5\1\uffff\2\65\1\u01d8"+
        "\1\u01d9\1\65\1\uffff\1\u01db\1\65\2\uffff\1\u01dd\1\u01c8\1\uffff"+
        "\1\u01de\3\65\1\uffff\2\65\1\uffff\1\u01e4\2\uffff\3\65\1\uffff"+
        "\1\65\1\u01e9\1\65\1\uffff\1\u01eb\1\uffff\2\65\1\u01ee\3\65\1\u01f2"+
        "\1\uffff\1\65\4\uffff\1\u01f4\1\uffff\1\65\1\u01f6\1\65\1\uffff"+
        "\1\65\4\uffff\1\65\1\u01fa\1\65\1\u01fc\1\uffff\1\u01fd\2\uffff"+
        "\1\65\1\uffff\1\65\1\u0200\2\uffff\1\u0201\1\uffff\1\u0202\2\uffff"+
        "\1\65\1\u0204\1\u0205\1\uffff\1\65\1\uffff\1\65\1\u0208\1\u020a"+
        "\1\u020b\1\uffff\1\65\1\uffff\1\u020d\1\u020e\1\uffff\3\65\1\uffff"+
        "\1\65\1\uffff\1\u0213\1\uffff\3\65\1\uffff\1\65\2\uffff\1\u0218"+
        "\1\u0219\3\uffff\1\65\2\uffff\1\65\1\u021c\1\uffff\1\65\2\uffff"+
        "\1\u021e\2\uffff\1\u021f\3\65\1\uffff\2\65\1\u0225\1\u0226\2\uffff"+
        "\1\65\1\u0228\1\uffff\1\65\2\uffff\1\u022a\1\u022b\1\u022a\1\u022c"+
        "\1\65\2\uffff\1\u022e\1\uffff\1\65\3\uffff\1\u0230\1\uffff\1\65"+
        "\1\uffff\3\65\1\u0235\1\uffff";
    static final String DFA41_eofS =
        "\u0236\uffff";
    static final String DFA41_minS =
        "\1\11\1\56\3\47\1\60\1\uffff\1\47\5\uffff\1\52\2\uffff\1\52\1\41"+
        "\1\42\2\uffff\5\75\1\174\5\uffff\1\111\1\114\2\101\2\114\1\101\1"+
        "\117\1\101\1\104\1\105\1\111\1\106\2\105\1\101\1\116\1\101\1\110"+
        "\1\111\1\117\2\uffff\1\56\1\103\1\uffff\1\124\1\114\1\107\1\43\25"+
        "\uffff\1\111\1\102\1\126\1\114\1\43\1\104\1\114\1\105\1\122\1\125"+
        "\1\101\1\123\1\103\1\123\1\117\1\124\1\103\1\123\1\103\1\104\1\103"+
        "\1\117\1\124\1\114\1\122\1\114\1\101\1\124\1\126\3\43\1\105\1\106"+
        "\1\113\1\103\2\104\1\116\1\124\2\43\1\105\1\124\1\43\1\123\1\107"+
        "\1\114\2\101\1\132\1\105\1\102\1\125\1\43\2\111\1\104\1\105\1\114"+
        "\1\124\1\105\1\104\1\111\1\uffff\1\101\1\43\1\117\1\125\1\114\1"+
        "\127\1\111\1\uffff\1\103\1\117\1\114\1\117\1\105\1\43\1\uffff\3"+
        "\43\1\120\1\116\1\101\1\103\1\122\2\123\1\101\1\123\1\105\1\101"+
        "\1\114\1\103\1\105\1\124\1\120\1\105\1\114\1\123\1\114\1\105\1\43"+
        "\1\105\1\115\1\103\1\123\1\43\1\114\1\125\1\116\1\117\1\111\1\uffff"+
        "\4\105\2\uffff\1\116\1\124\1\105\1\113\2\105\1\125\1\105\1\uffff"+
        "\1\105\1\uffff\1\122\1\111\1\uffff\2\117\1\110\1\105\2\122\1\105"+
        "\1\43\1\101\1\105\1\uffff\1\111\1\117\1\116\1\101\1\127\1\125\1"+
        "\110\1\116\1\105\1\116\1\111\1\uffff\1\115\1\122\1\43\1\105\1\116"+
        "\1\120\1\105\1\122\1\111\1\124\1\122\4\uffff\1\122\1\105\1\125\1"+
        "\113\1\105\1\117\1\124\1\110\1\124\1\123\1\43\1\125\1\101\1\43\1"+
        "\124\1\111\2\43\1\160\1\125\1\124\1\43\1\106\1\uffff\1\120\1\43"+
        "\1\110\1\105\1\uffff\1\43\1\120\1\124\1\43\1\116\1\130\1\122\1\43"+
        "\2\122\1\124\5\43\1\123\2\122\1\114\1\117\1\125\1\113\1\124\1\103"+
        "\1\124\1\105\1\43\1\uffff\1\43\1\125\1\105\1\43\1\126\1\125\1\116"+
        "\1\107\1\124\1\43\1\105\2\43\1\105\2\43\1\124\1\120\1\101\1\uffff"+
        "\1\105\1\43\1\124\1\104\1\43\1\103\2\43\1\105\1\103\1\124\1\43\1"+
        "\116\1\122\1\105\1\43\1\105\1\43\1\uffff\1\114\1\122\1\uffff\1\105"+
        "\1\116\2\uffff\1\164\2\123\1\uffff\1\43\1\124\1\uffff\2\43\1\uffff"+
        "\2\43\1\uffff\1\107\1\43\1\124\1\uffff\1\123\1\43\1\111\3\uffff"+
        "\1\43\1\uffff\3\43\1\101\1\116\1\122\1\105\1\43\1\124\2\43\2\uffff"+
        "\1\124\1\43\1\uffff\1\117\1\105\2\43\1\105\1\uffff\1\43\1\123\2"+
        "\uffff\2\43\1\uffff\1\43\1\122\1\114\1\116\1\uffff\1\11\1\125\1"+
        "\uffff\1\43\2\uffff\1\123\1\124\1\110\1\uffff\1\124\1\43\1\122\1"+
        "\uffff\1\43\1\uffff\1\124\1\105\1\43\1\103\1\151\1\111\1\43\1\uffff"+
        "\1\111\4\uffff\1\43\1\uffff\1\123\1\43\1\105\1\uffff\1\106\4\uffff"+
        "\1\120\1\43\1\103\1\43\1\uffff\1\43\2\uffff\1\110\1\uffff\1\124"+
        "\1\43\2\uffff\1\43\1\uffff\1\43\2\uffff\1\105\2\43\1\uffff\1\122"+
        "\1\uffff\1\123\3\43\1\uffff\1\123\1\uffff\2\43\1\uffff\1\124\1\157"+
        "\1\126\1\uffff\1\117\1\uffff\1\43\1\uffff\1\103\1\111\1\123\1\uffff"+
        "\1\105\2\uffff\2\43\3\uffff\1\123\2\uffff\1\105\1\43\1\uffff\1\102"+
        "\2\uffff\1\43\2\uffff\1\43\1\156\1\105\1\116\1\uffff\1\124\1\105"+
        "\2\43\2\uffff\1\123\1\43\1\uffff\1\131\2\uffff\4\43\1\104\2\uffff"+
        "\1\43\1\uffff\1\137\3\uffff\1\43\1\uffff\1\122\1\uffff\2\117\1\124"+
        "\1\43\1\uffff";
    static final String DFA41_maxS =
        "\1\176\1\71\1\165\1\171\1\47\1\71\1\uffff\1\47\5\uffff\1\52\2\uffff"+
        "\1\52\1\41\1\172\2\uffff\1\76\4\75\1\174\5\uffff\1\165\1\163\1\165"+
        "\1\162\2\170\1\165\1\162\1\141\1\163\2\157\1\166\1\151\1\164\1\162"+
        "\1\163\2\151\2\157\2\uffff\1\71\1\167\1\uffff\1\164\1\154\1\164"+
        "\1\172\25\uffff\1\157\1\142\1\166\1\164\1\172\1\171\1\156\1\145"+
        "\1\162\1\165\1\157\3\163\1\157\1\164\1\151\1\163\1\151\1\144\1\151"+
        "\1\157\1\164\1\154\1\162\1\154\1\157\1\164\1\166\3\172\1\145\1\146"+
        "\1\153\1\143\2\144\1\156\1\164\2\172\1\145\1\164\1\172\1\166\1\147"+
        "\1\154\2\141\1\172\1\145\1\142\1\165\1\172\1\160\1\151\1\144\1\145"+
        "\1\154\1\164\1\145\1\144\1\151\1\uffff\1\141\1\172\1\157\1\165\1"+
        "\154\1\167\1\151\1\uffff\1\155\1\157\1\154\1\157\1\145\1\172\1\uffff"+
        "\3\172\1\160\1\156\1\141\1\143\3\163\1\141\1\163\1\145\1\141\1\154"+
        "\1\143\1\145\1\164\1\160\1\145\1\154\1\163\1\154\1\151\1\172\1\154"+
        "\1\155\1\143\1\163\1\172\1\154\1\165\1\156\1\157\1\151\1\uffff\2"+
        "\145\1\157\1\145\2\uffff\1\156\1\164\1\145\1\153\2\145\1\165\1\145"+
        "\1\uffff\1\145\1\uffff\1\162\1\151\1\uffff\2\157\1\150\1\145\2\162"+
        "\1\145\1\172\1\154\1\145\1\uffff\1\151\1\161\1\156\1\141\1\167\1"+
        "\165\1\150\1\162\1\145\1\156\1\151\1\uffff\1\155\1\162\1\172\1\145"+
        "\1\156\1\160\1\145\1\162\1\151\1\164\1\162\4\uffff\1\162\1\145\1"+
        "\165\1\153\1\145\1\157\1\164\1\150\1\164\1\163\1\172\1\165\1\141"+
        "\1\172\1\164\1\151\2\172\1\160\1\165\1\164\1\172\1\146\1\uffff\1"+
        "\120\1\172\1\150\1\145\1\uffff\1\172\1\160\1\164\1\172\1\156\1\170"+
        "\1\162\1\172\2\162\1\164\5\172\1\163\2\162\1\154\1\157\1\165\1\153"+
        "\1\164\1\143\1\164\1\145\1\172\1\uffff\1\172\1\165\1\145\1\172\1"+
        "\166\1\165\1\156\1\147\1\164\1\172\1\145\2\172\1\145\2\172\1\164"+
        "\1\160\1\141\1\uffff\1\145\1\172\1\164\1\144\1\172\1\143\2\172\1"+
        "\145\1\143\1\164\1\172\1\156\1\162\1\145\1\172\1\145\1\172\1\uffff"+
        "\1\154\1\162\1\uffff\1\145\1\156\2\uffff\1\164\2\163\1\uffff\1\172"+
        "\1\124\1\uffff\2\172\1\uffff\2\172\1\uffff\1\147\1\172\1\164\1\uffff"+
        "\1\163\1\172\1\151\3\uffff\1\172\1\uffff\3\172\1\141\1\156\1\162"+
        "\1\145\1\172\1\164\2\172\2\uffff\1\164\1\172\1\uffff\1\157\1\145"+
        "\2\172\1\145\1\uffff\1\172\1\163\2\uffff\2\172\1\uffff\1\172\1\162"+
        "\1\154\1\156\1\uffff\1\40\1\165\1\uffff\1\172\2\uffff\1\163\1\164"+
        "\1\150\1\uffff\1\164\1\172\1\162\1\uffff\1\172\1\uffff\1\164\1\145"+
        "\1\172\1\143\2\151\1\172\1\uffff\1\111\4\uffff\1\172\1\uffff\1\163"+
        "\1\172\1\145\1\uffff\1\146\4\uffff\1\160\1\172\1\143\1\172\1\uffff"+
        "\1\172\2\uffff\1\150\1\uffff\1\164\1\172\2\uffff\1\172\1\uffff\1"+
        "\172\2\uffff\1\145\2\172\1\uffff\1\162\1\uffff\1\163\3\172\1\uffff"+
        "\1\163\1\uffff\2\172\1\uffff\1\164\1\157\1\166\1\uffff\1\117\1\uffff"+
        "\1\172\1\uffff\1\143\1\151\1\163\1\uffff\1\145\2\uffff\2\172\3\uffff"+
        "\1\163\2\uffff\1\145\1\172\1\uffff\1\142\2\uffff\1\172\2\uffff\1"+
        "\172\1\156\1\145\1\116\1\uffff\1\164\1\145\2\172\2\uffff\1\163\1"+
        "\172\1\uffff\1\171\2\uffff\4\172\1\144\2\uffff\1\172\1\uffff\1\137"+
        "\3\uffff\1\172\1\uffff\1\162\1\uffff\2\157\1\164\1\172\1\uffff";
    static final String DFA41_acceptS =
        "\6\uffff\1\7\1\uffff\1\11\1\12\1\13\1\14\1\15\1\uffff\1\20\1\21"+
        "\3\uffff\1\25\1\27\6\uffff\1\42\1\43\1\44\1\45\1\46\25\uffff\1\u008c"+
        "\1\6\2\uffff\1\2\4\uffff\1\3\1\4\1\5\1\10\1\16\1\17\1\22\1\u008d"+
        "\1\23\1\24\1\26\1\30\1\33\1\31\1\32\1\37\1\36\1\34\1\35\1\40\1\41"+
        "\100\uffff\1\1\7\uffff\1\60\6\uffff\1\54\43\uffff\1\122\4\uffff"+
        "\1\121\1\130\10\uffff\1\144\1\uffff\1\142\2\uffff\1\141\12\uffff"+
        "\1\164\13\uffff\1\136\13\uffff\1\50\1\55\1\53\1\52\27\uffff\1\104"+
        "\4\uffff\1\112\34\uffff\1\162\23\uffff\1\140\22\uffff\1\61\2\uffff"+
        "\1\100\2\uffff\1\102\1\74\3\uffff\1\103\2\uffff\1\113\2\uffff\1"+
        "\u0087\2\uffff\1\114\3\uffff\1\127\3\uffff\1\u0085\1\131\1\132\1"+
        "\uffff\1\134\13\uffff\1\156\1\163\2\uffff\1\165\5\uffff\1\172\2"+
        "\uffff\1\176\1\174\2\uffff\1\u0084\4\uffff\1\56\2\uffff\1\147\1"+
        "\uffff\1\u0082\1\51\3\uffff\1\62\3\uffff\1\70\1\uffff\1\u0089\7"+
        "\uffff\1\u0081\1\uffff\1\111\1\110\1\116\1\115\1\uffff\1\123\3\uffff"+
        "\1\u008b\1\uffff\1\u0080\1\133\1\u0088\1\145\4\uffff\1\u0086\1\uffff"+
        "\1\157\1\155\1\uffff\1\161\2\uffff\1\166\1\177\1\uffff\1\173\1\uffff"+
        "\1\175\1\137\3\uffff\1\47\1\uffff\1\151\4\uffff\1\73\1\uffff\1\71"+
        "\2\uffff\1\77\3\uffff\1\107\1\uffff\1\117\1\uffff\1\125\3\uffff"+
        "\1\143\1\uffff\1\153\1\154\2\uffff\1\167\1\170\1\171\1\uffff\1\u008a"+
        "\1\57\2\uffff\1\66\1\uffff\1\64\1\72\1\uffff\1\76\1\75\4\uffff\1"+
        "\124\4\uffff\1\160\1\u0083\2\uffff\1\65\1\uffff\1\63\1\101\5\uffff"+
        "\1\146\1\152\1\uffff\1\150\1\uffff\1\105\1\106\1\126\1\uffff\1\135"+
        "\1\uffff\1\120\4\uffff\1\67";
    static final String DFA41_specialS =
        "\u0236\uffff}>";
    static final String[] DFA41_transitionS = {
            "\2\37\2\uffff\1\37\22\uffff\1\37\1\27\1\10\2\uffff\1\11\1\12"+
            "\1\6\1\13\1\14\1\15\1\16\1\17\1\37\1\5\1\20\12\1\1\22\1\24\1"+
            "\25\1\33\1\26\1\23\1\21\1\41\1\3\1\42\1\43\1\45\1\46\1\47\1"+
            "\50\1\51\1\64\1\65\1\52\1\63\1\2\1\54\1\40\1\7\1\55\1\56\1\57"+
            "\1\60\1\61\1\62\1\4\2\65\1\34\1\uffff\1\35\1\30\1\36\1\uffff"+
            "\1\41\1\3\1\42\1\43\1\44\1\46\1\47\1\50\1\51\1\64\1\65\1\52"+
            "\1\53\1\2\1\54\1\40\1\7\1\55\1\56\1\57\1\60\1\61\1\62\1\4\2"+
            "\65\1\uffff\1\32\1\uffff\1\31",
            "\1\67\1\uffff\12\1",
            "\1\71\31\uffff\1\72\15\uffff\1\70\5\uffff\1\73\13\uffff\1"+
            "\72\15\uffff\1\70\5\uffff\1\73",
            "\1\76\35\uffff\1\74\23\uffff\1\75\13\uffff\1\74\23\uffff\1"+
            "\75",
            "\1\77",
            "\12\66",
            "",
            "\1\101",
            "",
            "",
            "",
            "",
            "",
            "\1\102",
            "",
            "",
            "\1\37",
            "\1\105",
            "\1\23\15\uffff\12\23\3\uffff\1\107\3\uffff\32\23\6\uffff\32"+
            "\23",
            "",
            "",
            "\1\111\1\112",
            "\1\114",
            "\1\112",
            "\1\112",
            "\1\112",
            "\1\121",
            "",
            "",
            "",
            "",
            "",
            "\1\125\10\uffff\1\123\2\uffff\1\124\23\uffff\1\125\10\uffff"+
            "\1\123\2\uffff\1\124",
            "\1\126\1\uffff\1\130\4\uffff\1\127\30\uffff\1\126\1\uffff"+
            "\1\130\4\uffff\1\127",
            "\1\136\6\uffff\1\132\3\uffff\1\134\2\uffff\1\131\2\uffff\1"+
            "\135\2\uffff\1\133\13\uffff\1\136\6\uffff\1\132\3\uffff\1\134"+
            "\2\uffff\1\131\2\uffff\1\135\2\uffff\1\133",
            "\1\142\3\uffff\1\137\3\uffff\1\140\10\uffff\1\141\16\uffff"+
            "\1\142\3\uffff\1\137\3\uffff\1\140\10\uffff\1\141",
            "\1\144\1\uffff\1\146\11\uffff\1\145\23\uffff\1\144\1\uffff"+
            "\1\146\11\uffff\1\143",
            "\1\144\1\uffff\1\146\11\uffff\1\147\23\uffff\1\144\1\uffff"+
            "\1\146\11\uffff\1\145",
            "\1\152\3\uffff\1\151\11\uffff\1\153\2\uffff\1\150\2\uffff"+
            "\1\154\13\uffff\1\152\3\uffff\1\151\11\uffff\1\153\2\uffff\1"+
            "\150\2\uffff\1\154",
            "\1\156\2\uffff\1\155\34\uffff\1\156\2\uffff\1\155",
            "\1\157\37\uffff\1\157",
            "\1\163\1\uffff\1\161\7\uffff\1\160\4\uffff\1\162\20\uffff"+
            "\1\163\1\uffff\1\161\7\uffff\1\160\4\uffff\1\162",
            "\1\164\3\uffff\1\165\5\uffff\1\166\25\uffff\1\164\3\uffff"+
            "\1\165\5\uffff\1\166",
            "\1\171\5\uffff\1\170\31\uffff\1\171\5\uffff\1\167",
            "\1\177\7\uffff\1\174\1\uffff\1\176\1\uffff\1\173\2\uffff\1"+
            "\172\1\175\17\uffff\1\177\7\uffff\1\174\1\uffff\1\176\1\uffff"+
            "\1\173\2\uffff\1\172\1\175",
            "\1\u0080\3\uffff\1\u0081\33\uffff\1\u0080\3\uffff\1\u0081",
            "\1\u0082\2\uffff\1\u0084\1\u0085\12\uffff\1\u0083\20\uffff"+
            "\1\u0082\2\uffff\1\u0084\1\u0085\12\uffff\1\u0083",
            "\1\u0087\6\uffff\1\u0086\6\uffff\1\u0089\2\uffff\1\u0088\16"+
            "\uffff\1\u0087\6\uffff\1\u0086\6\uffff\1\u0089\2\uffff\1\u0088",
            "\1\u008a\1\uffff\1\u008c\2\uffff\1\u008b\32\uffff\1\u008a"+
            "\1\uffff\1\u008c\2\uffff\1\u008b",
            "\1\u008e\7\uffff\1\u008d\27\uffff\1\u008e\7\uffff\1\u008d",
            "\1\u0090\1\u008f\36\uffff\1\u0090\1\u008f",
            "\1\171\5\uffff\1\u0091\31\uffff\1\171\5\uffff\1\170",
            "\1\u0092\37\uffff\1\u0092",
            "",
            "",
            "\1\u0093\1\uffff\12\66",
            "\1\u0096\20\uffff\1\u0095\2\uffff\1\u0094\13\uffff\1\u0096"+
            "\20\uffff\1\u0095\2\uffff\1\u0094",
            "",
            "\1\u0097\37\uffff\1\u0097",
            "\1\u0098\37\uffff\1\u0098",
            "\1\u009a\14\uffff\1\u0099\22\uffff\1\u009a\14\uffff\1\u0099",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u009d\5\uffff\1\u009c\31\uffff\1\u009d\5\uffff\1\u009c",
            "\1\u009e\37\uffff\1\u009e",
            "\1\u009f\37\uffff\1\u009f",
            "\1\u00a1\7\uffff\1\u00a0\27\uffff\1\u00a1\7\uffff\1\u00a0",
            "\2\65\13\uffff\12\65\7\uffff\2\65\1\u00a3\27\65\4\uffff\1"+
            "\65\1\uffff\2\65\1\u00a3\27\65",
            "\1\u00a5\24\uffff\1\u00a4\12\uffff\1\u00a5\24\uffff\1\u00a4",
            "\1\u00a8\1\u00a6\1\u00a7\35\uffff\1\u00a8\1\u00a6\1\u00a7",
            "\1\u00a9\37\uffff\1\u00a9",
            "\1\u00aa\37\uffff\1\u00aa",
            "\1\u00ab\37\uffff\1\u00ab",
            "\1\u00ac\3\uffff\1\u00ad\11\uffff\1\u00ae\21\uffff\1\u00ac"+
            "\3\uffff\1\u00ad\11\uffff\1\u00ae",
            "\1\u00af\37\uffff\1\u00af",
            "\1\u00b1\2\uffff\1\u00b0\5\uffff\1\u00b3\6\uffff\1\u00b2\17"+
            "\uffff\1\u00b1\2\uffff\1\u00b0\5\uffff\1\u00b3\6\uffff\1\u00b2",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\u00b5\37\uffff\1\u00b5",
            "\1\u00b6\37\uffff\1\u00b6",
            "\1\u00b9\5\uffff\1\u00b8\31\uffff\1\u00b7\5\uffff\1\u00b8",
            "\1\u00ba\37\uffff\1\u00ba",
            "\1\u00b9\5\uffff\1\u00b8\31\uffff\1\u00b9\5\uffff\1\u00b8",
            "\1\u00bb\37\uffff\1\u00bb",
            "\1\u00bc\5\uffff\1\u00b8\31\uffff\1\u00b9\5\uffff\1\u00b8",
            "\1\u00bd\37\uffff\1\u00bd",
            "\1\u00be\37\uffff\1\u00be",
            "\1\u00bf\37\uffff\1\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "\1\u00c1\37\uffff\1\u00c1",
            "\1\u00c3\15\uffff\1\u00c2\21\uffff\1\u00c3\15\uffff\1\u00c2",
            "\1\u00c4\37\uffff\1\u00c4",
            "\1\u00c5\37\uffff\1\u00c5",
            "\2\65\13\uffff\12\65\7\uffff\3\65\1\u00c7\11\65\1\u00ca\4"+
            "\65\1\u00c8\1\u00c9\6\65\4\uffff\1\65\1\uffff\3\65\1\u00c7\11"+
            "\65\1\u00ca\4\65\1\u00c8\1\u00c9\6\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\u00ce\37\uffff\1\u00ce",
            "\1\u00cf\37\uffff\1\u00cf",
            "\1\u00d0\37\uffff\1\u00d0",
            "\1\u00d2\37\uffff\1\u00d1",
            "\1\u00d2\37\uffff\1\u00d2",
            "\1\u00d3\37\uffff\1\u00d3",
            "\1\u00d4\37\uffff\1\u00d4",
            "\2\65\13\uffff\12\65\7\uffff\3\65\1\u00d6\26\65\4\uffff\1"+
            "\65\1\uffff\3\65\1\u00d6\26\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u00d8\37\uffff\1\u00d8",
            "\1\u00d9\37\uffff\1\u00d9",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u00db\2\uffff\1\u00dc\34\uffff\1\u00db\2\uffff\1\u00dc",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00de",
            "\1\u00df\37\uffff\1\u00df",
            "\1\u00e0\37\uffff\1\u00e0",
            "\1\u00e1\37\uffff\1\u00e1",
            "\1\u00e2\37\uffff\1\u00e2",
            "\1\u00e3\37\uffff\1\u00e3",
            "\1\u00e4\37\uffff\1\u00e4",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u00e7\6\uffff\1\u00e6\30\uffff\1\u00e7\6\uffff\1\u00e6",
            "\1\u00e8\37\uffff\1\u00e8",
            "\1\u00e9\37\uffff\1\u00e9",
            "\1\u00ea\37\uffff\1\u00ea",
            "\1\u00eb\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00ec",
            "\1\u00ed\37\uffff\1\u00ed",
            "\1\u00ee\37\uffff\1\u00d2",
            "\1\u00ef\37\uffff\1\u00ef",
            "",
            "\1\u00f0\37\uffff\1\u00f0",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u00f2\37\uffff\1\u00f2",
            "\1\u00f3\37\uffff\1\u00f3",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\u00f5\37\uffff\1\u00f5",
            "\1\u00f6\37\uffff\1\u00f6",
            "",
            "\1\u00f8\11\uffff\1\u00f7\25\uffff\1\u00f8\11\uffff\1\u00f7",
            "\1\u00f9\37\uffff\1\u00f9",
            "\1\u00fa\37\uffff\1\u00fa",
            "\1\u00fb\37\uffff\1\u00fb",
            "\1\u00fc\37\uffff\1\u00fc",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0101\37\uffff\1\u0101",
            "\1\u0102\37\uffff\1\u0102",
            "\1\u0103\37\uffff\1\u0103",
            "\1\u0104\37\uffff\1\u0104",
            "\1\u0105\1\u0106\36\uffff\1\u0105\1\u0106",
            "\1\u0107\37\uffff\1\u0107",
            "\1\u0108\37\uffff\1\u0108",
            "\1\u0109\37\uffff\1\u0109",
            "\1\u010a\37\uffff\1\u010a",
            "\1\u010b\37\uffff\1\u010b",
            "\1\u010c\37\uffff\1\u010c",
            "\1\u010d\37\uffff\1\u010d",
            "\1\u010e\37\uffff\1\u010e",
            "\1\u010f\37\uffff\1\u010f",
            "\1\u0110\37\uffff\1\u0110",
            "\1\u0111\37\uffff\1\u0111",
            "\1\u0112\37\uffff\1\u0112",
            "\1\u0114\30\uffff\1\u0113\6\uffff\1\u0114",
            "\1\u0115\37\uffff\1\u0115",
            "\1\u0114\37\uffff\1\u0114",
            "\1\u0116\3\uffff\1\u0117\33\uffff\1\u0116\3\uffff\1\u0117",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0119\6\uffff\1\u0114\37\uffff\1\u0114",
            "\1\u011a\37\uffff\1\u011a",
            "\1\u011b\37\uffff\1\u011b",
            "\1\u011c\37\uffff\1\u011c",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u011e\37\uffff\1\u011e",
            "\1\u011f\37\uffff\1\u011f",
            "\1\u0120\37\uffff\1\u0120",
            "\1\u0121\37\uffff\1\u0121",
            "\1\u0122\37\uffff\1\u0122",
            "",
            "\1\u0123\37\uffff\1\u0123",
            "\1\u0124\37\uffff\1\u0124",
            "\1\u0126\11\uffff\1\u0125\25\uffff\1\u0126\11\uffff\1\u0125",
            "\1\u0127\37\uffff\1\u0127",
            "",
            "",
            "\1\u0128\37\uffff\1\u0128",
            "\1\u0129\37\uffff\1\u0129",
            "\1\u012a\37\uffff\1\u012a",
            "\1\u012b\37\uffff\1\u012b",
            "\1\u012d\37\uffff\1\u012c",
            "\1\u012d\37\uffff\1\u012d",
            "\1\u012e\37\uffff\1\u012e",
            "\1\u012f\37\uffff\1\u012f",
            "",
            "\1\u0130\37\uffff\1\u0130",
            "",
            "\1\u0131\37\uffff\1\u0131",
            "\1\u0132\37\uffff\1\u0132",
            "",
            "\1\u0133\37\uffff\1\u0133",
            "\1\u0134\37\uffff\1\u0134",
            "\1\u0135\37\uffff\1\u0135",
            "\1\u0136\37\uffff\1\u0136",
            "\1\u0137\37\uffff\1\u0137",
            "\1\u0138\37\uffff\1\u0138",
            "\1\u0139\37\uffff\1\u0139",
            "\2\65\13\uffff\12\65\7\uffff\15\65\1\u013b\14\65\4\uffff\1"+
            "\65\1\uffff\15\65\1\u013b\14\65",
            "\1\u013c\12\uffff\1\u013d\24\uffff\1\u013c\12\uffff\1\u013d",
            "\1\u013e\37\uffff\1\u013e",
            "",
            "\1\u013f\37\uffff\1\u013f",
            "\1\u0141\1\uffff\1\u0140\35\uffff\1\u0141\1\uffff\1\u0140",
            "\1\u0142\37\uffff\1\u0142",
            "\1\u0143\37\uffff\1\u0143",
            "\1\u0144\37\uffff\1\u0144",
            "\1\u0145\37\uffff\1\u0145",
            "\1\u0146\37\uffff\1\u0146",
            "\1\u0147\3\uffff\1\u0148\33\uffff\1\u0147\3\uffff\1\u0148",
            "\1\u0149\37\uffff\1\u012d",
            "\1\u014a\37\uffff\1\u014a",
            "\1\u014b\37\uffff\1\u014b",
            "",
            "\1\u014c\37\uffff\1\u014c",
            "\1\u014d\37\uffff\1\u014d",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u014f\37\uffff\1\u014f",
            "\1\u0150\37\uffff\1\u0150",
            "\1\u0151\37\uffff\1\u0151",
            "\1\u0152\37\uffff\1\u0152",
            "\1\u0153\37\uffff\1\u0153",
            "\1\u0154\37\uffff\1\u0154",
            "\1\u0155\37\uffff\1\u0155",
            "\1\u0156\37\uffff\1\u0156",
            "",
            "",
            "",
            "",
            "\1\u0157\37\uffff\1\u0157",
            "\1\u0158\37\uffff\1\u0158",
            "\1\u0159\37\uffff\1\u0159",
            "\1\u015a\37\uffff\1\u015a",
            "\1\u015b\37\uffff\1\u015b",
            "\1\u015c\37\uffff\1\u015c",
            "\1\u015d\37\uffff\1\u015d",
            "\1\u015e\37\uffff\1\u015e",
            "\1\u015f\37\uffff\1\u015f",
            "\1\u0160\37\uffff\1\u0160",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0162\37\uffff\1\u0162",
            "\1\u0163\37\uffff\1\u0163",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0165\37\uffff\1\u0165",
            "\1\u0166\37\uffff\1\u0166",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0169",
            "\1\u016a\37\uffff\1\u016a",
            "\1\u016b\37\uffff\1\u016b",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u016d\37\uffff\1\u016d",
            "",
            "\1\u016e",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0170\37\uffff\1\u0170",
            "\1\u0171\37\uffff\1\u0171",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0173\37\uffff\1\u0173",
            "\1\u0174\37\uffff\1\u0174",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0176\37\uffff\1\u0176",
            "\1\u0177\37\uffff\1\u0177",
            "\1\u0178\37\uffff\1\u0178",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u017a\37\uffff\1\u017a",
            "\1\u017b\37\uffff\1\u017b",
            "\1\u017c\37\uffff\1\u017c",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\13"+
            "\65\1\u0180\16\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0182\37\uffff\1\u0182",
            "\1\u0183\37\uffff\1\u0183",
            "\1\u0184\37\uffff\1\u0184",
            "\1\u0185\37\uffff\1\u0185",
            "\1\u0186\37\uffff\1\u0186",
            "\1\u0187\37\uffff\1\u0187",
            "\1\u0188\37\uffff\1\u0188",
            "\1\u0189\37\uffff\1\u0189",
            "\1\u018a\37\uffff\1\u018a",
            "\1\u018b\37\uffff\1\u018b",
            "\1\u018c\37\uffff\1\u018c",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u018f\37\uffff\1\u018f",
            "\1\u0190\37\uffff\1\u0190",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0192\37\uffff\1\u0192",
            "\1\u0193\37\uffff\1\u0193",
            "\1\u0194\37\uffff\1\u0194",
            "\1\u0195\37\uffff\1\u0195",
            "\1\u0196\37\uffff\1\u0196",
            "\2\65\13\uffff\12\65\7\uffff\22\65\1\u0198\7\65\4\uffff\1"+
            "\65\1\uffff\22\65\1\u0198\7\65",
            "\1\u0199\37\uffff\1\u0199",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u019c\37\uffff\1\u019c",
            "\2\65\13\uffff\12\65\7\uffff\13\65\1\u019d\16\65\4\uffff\1"+
            "\65\1\uffff\32\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u019f\37\uffff\1\u019f",
            "\1\u01a0\37\uffff\1\u01a0",
            "\1\u01a1\37\uffff\1\u01a1",
            "",
            "\1\u01a2\37\uffff\1\u01a2",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01a4\37\uffff\1\u01a4",
            "\1\u01a5\37\uffff\1\u01a5",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01a7\37\uffff\1\u01a7",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01aa\37\uffff\1\u01aa",
            "\1\u01ab\37\uffff\1\u01ab",
            "\1\u01ac\37\uffff\1\u01ac",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01ae\37\uffff\1\u01ae",
            "\1\u01af\37\uffff\1\u01af",
            "\1\u01b0\37\uffff\1\u01b0",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01b2\37\uffff\1\u01b2",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u01b4\37\uffff\1\u01b4",
            "\1\u01b5\37\uffff\1\u01b5",
            "",
            "\1\u01b6\37\uffff\1\u01b6",
            "\1\u01b7\37\uffff\1\u01b7",
            "",
            "",
            "\1\u01b8",
            "\1\u01b9\37\uffff\1\u01b9",
            "\1\u01ba\37\uffff\1\u01ba",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01bc",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u01c1\37\uffff\1\u01c1",
            "\2\65\13\uffff\12\65\7\uffff\4\65\1\u01c3\25\65\4\uffff\1"+
            "\65\1\uffff\4\65\1\u01c3\25\65",
            "\1\u01c4\37\uffff\1\u01c4",
            "",
            "\1\u01c5\37\uffff\1\u01c5",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01c7\37\uffff\1\u01c7",
            "",
            "",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01cc\37\uffff\1\u01cc",
            "\1\u01cd\37\uffff\1\u01cd",
            "\1\u01ce\37\uffff\1\u01ce",
            "\1\u01cf\37\uffff\1\u01cf",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01d1\37\uffff\1\u01d1",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "\1\u01d4\37\uffff\1\u01d4",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u01d6\37\uffff\1\u01d6",
            "\1\u01d7\37\uffff\1\u01d7",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01da\37\uffff\1\u01da",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01dc\37\uffff\1\u01dc",
            "",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01df\37\uffff\1\u01df",
            "\1\u01e0\37\uffff\1\u01e0",
            "\1\u01e1\37\uffff\1\u01e1",
            "",
            "\1\u01e2\26\uffff\1\u01e2",
            "\1\u01e3\37\uffff\1\u01e3",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "\1\u01e5\37\uffff\1\u01e5",
            "\1\u01e6\37\uffff\1\u01e6",
            "\1\u01e7\37\uffff\1\u01e7",
            "",
            "\1\u01e8\37\uffff\1\u01e8",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01ea\37\uffff\1\u01ea",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u01ec\37\uffff\1\u01ec",
            "\1\u01ed\37\uffff\1\u01ed",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01ef\37\uffff\1\u01ef",
            "\1\u01f0",
            "\1\u01f1\37\uffff\1\u01f1",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u01f3",
            "",
            "",
            "",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u01f5\37\uffff\1\u01f5",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01f7\37\uffff\1\u01f7",
            "",
            "\1\u01f8\37\uffff\1\u01f8",
            "",
            "",
            "",
            "",
            "\1\u01f9\37\uffff\1\u01f9",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u01fb\37\uffff\1\u01fb",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "\1\u01fe\37\uffff\1\u01fe",
            "",
            "\1\u01ff\37\uffff\1\u01ff",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "\1\u0203\37\uffff\1\u0203",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u0206\37\uffff\1\u0206",
            "",
            "\1\u0207\37\uffff\1\u0207",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\u0209\1\uffff"+
            "\32\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u020c\37\uffff\1\u020c",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u020f\37\uffff\1\u020f",
            "\1\u0210",
            "\1\u0211\37\uffff\1\u0211",
            "",
            "\1\u0212",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u0214\37\uffff\1\u0214",
            "\1\u0215\37\uffff\1\u0215",
            "\1\u0216\37\uffff\1\u0216",
            "",
            "\1\u0217\37\uffff\1\u0217",
            "",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "",
            "\1\u021a\37\uffff\1\u021a",
            "",
            "",
            "\1\u021b\37\uffff\1\u021b",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u021d\37\uffff\1\u021d",
            "",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0220",
            "\1\u0221\37\uffff\1\u0221",
            "\1\u0222",
            "",
            "\1\u0223\37\uffff\1\u0223",
            "\1\u0224\37\uffff\1\u0224",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "\1\u0227\37\uffff\1\u0227",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u0229\37\uffff\1\u0229",
            "",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u022d\37\uffff\1\u022d",
            "",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u022f",
            "",
            "",
            "",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u0231\37\uffff\1\u0231",
            "",
            "\1\u0232\37\uffff\1\u0232",
            "\1\u0233\37\uffff\1\u0233",
            "\1\u0234\37\uffff\1\u0234",
            "\2\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            ""
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( FOR_NOTATION | NATIONAL_CHAR_STRING_LIT | BIT_STRING_LIT | HEX_STRING_LIT | PERIOD | EXACT_NUM_LIT | CHAR_STRING | CHAR_STRING_PERL | DELIMITED_ID | PERCENT | AMPERSAND | LEFT_PAREN | RIGHT_PAREN | DOUBLE_ASTERISK | ASTERISK | PLUS_SIGN | COMMA | SOLIDUS | AT_SIGN | ASSIGN_OP | BINDVAR | COLON | SEMICOLON | LESS_THAN_OR_EQUALS_OP | LESS_THAN_OP | GREATER_THAN_OR_EQUALS_OP | NOT_EQUAL_OP | CARRET_OPERATOR_PART | TILDE_OPERATOR_PART | EXCLAMATION_OPERATOR_PART | GREATER_THAN_OP | CONCATENATION_OP | VERTICAL_BAR | EQUALS_OP | LEFT_BRACKET | RIGHT_BRACKET | INTRODUCER | SEPARATOR | PROMPT | SQL92_RESERVED_ALL | SQL92_RESERVED_ALTER | SQL92_RESERVED_AND | SQL92_RESERVED_ANY | SQL92_RESERVED_AS | SQL92_RESERVED_ASC | SQL92_RESERVED_BEGIN | SQL92_RESERVED_BETWEEN | SQL92_RESERVED_BY | SQL92_RESERVED_CASE | SQL92_RESERVED_CHECK | PLSQL_RESERVED_CLUSTERS | PLSQL_RESERVED_COLAUTH | PLSQL_RESERVED_COMPRESS | SQL92_RESERVED_CONNECT | PLSQL_NON_RESERVED_CONNECT_BY_ROOT | PLSQL_RESERVED_CRASH | SQL92_RESERVED_CREATE | SQL92_RESERVED_CURRENT | SQL92_RESERVED_CURSOR | SQL92_RESERVED_DATE | SQL92_RESERVED_DECLARE | SQL92_RESERVED_DEFAULT | SQL92_RESERVED_DELETE | SQL92_RESERVED_DESC | SQL92_RESERVED_DISTINCT | SQL92_RESERVED_DROP | SQL92_RESERVED_ELSE | SQL92_RESERVED_END | SQL92_RESERVED_EXCEPTION | PLSQL_RESERVED_EXCLUSIVE | SQL92_RESERVED_EXISTS | SQL92_RESERVED_FALSE | SQL92_RESERVED_FETCH | SQL92_RESERVED_FOR | SQL92_RESERVED_FROM | SQL92_RESERVED_GOTO | SQL92_RESERVED_GRANT | SQL92_RESERVED_GROUP | SQL92_RESERVED_HAVING | PLSQL_RESERVED_IDENTIFIED | PLSQL_RESERVED_IF | SQL92_RESERVED_IN | PLSQL_RESERVED_INDEX | PLSQL_RESERVED_INDEXES | SQL92_RESERVED_INSERT | SQL92_RESERVED_INTERSECT | SQL92_RESERVED_INTO | SQL92_RESERVED_IS | SQL92_RESERVED_LIKE | PLSQL_RESERVED_LOCK | PLSQL_RESERVED_MINUS | PLSQL_RESERVED_MODE | PLSQL_RESERVED_NOCOMPRESS | SQL92_RESERVED_NOT | PLSQL_RESERVED_NOWAIT | SQL92_RESERVED_NULL | SQL92_RESERVED_OF | SQL92_RESERVED_ON | SQL92_RESERVED_OPTION | SQL92_RESERVED_OR | SQL92_RESERVED_ORDER | SQL92_RESERVED_OVERLAPS | SQL92_RESERVED_PRIOR | SQL92_RESERVED_PROCEDURE | SQL92_RESERVED_PUBLIC | PLSQL_RESERVED_RESOURCE | SQL92_RESERVED_REVOKE | SQL92_RESERVED_SELECT | PLSQL_RESERVED_SHARE | SQL92_RESERVED_SIZE | PLSQL_RESERVED_START | PLSQL_RESERVED_TABAUTH | SQL92_RESERVED_TABLE | SQL92_RESERVED_THE | SQL92_RESERVED_THEN | SQL92_RESERVED_TO | SQL92_RESERVED_TRUE | SQL92_RESERVED_UNION | SQL92_RESERVED_UNIQUE | SQL92_RESERVED_UPDATE | SQL92_RESERVED_VALUES | SQL92_RESERVED_VIEW | PLSQL_RESERVED_VIEWS | SQL92_RESERVED_WHEN | SQL92_RESERVED_WHERE | SQL92_RESERVED_WITH | PLSQL_NON_RESERVED_USING | PLSQL_NON_RESERVED_MODEL | PLSQL_NON_RESERVED_ELSIF | PLSQL_NON_RESERVED_PIVOT | PLSQL_NON_RESERVED_UNPIVOT | JOIN | LEFT | RIGHT | FULL | OUTER | CROSS | NATURAL | INNER | REGULAR_ID | ZV );";
        }
    }
 

}