/* java org.antlr.Tool OracleLexer.g */
lexer grammar OracleLexer;

tokens { 
    UNSIGNED_INTEGER; 
    APPROXIMATE_NUM_LIT; 
    MINUS_SIGN; 
    DOUBLE_PERIOD;
    UNDERSCORE;
}

@header {
package com.lenovo.lps.farseer.priest2.platform.util.antlr;

import java.util.LinkedList;
}

@members {
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
}

fragment A_ :	'a' | 'A';
fragment B_ :	'b' | 'B';
fragment C_ :	'c' | 'C';
fragment D_ :	'd' | 'D';
fragment E_ :	'e' | 'E';
fragment F_ :	'f' | 'F';
fragment G_ :	'g' | 'G';
fragment H_ :	'h' | 'H';
fragment I_ :	'i' | 'I';
fragment J_ :	'j' | 'J';
fragment K_ :	'k' | 'K';
fragment L_ :	'l' | 'L';
fragment M_ :	'm' | 'M';
fragment N_ :	'n' | 'N';
fragment O_ :	'o' | 'O';
fragment P_ :	'p' | 'P';
fragment Q_ :	'q' | 'Q';
fragment R_ :	'r' | 'R';
fragment S_ :	's' | 'S';
fragment T_ :	't' | 'T';
fragment U_ :	'u' | 'U';
fragment V_ :	'v' | 'V';
fragment W_ :	'w' | 'W';
fragment X_ :	'x' | 'X';
fragment Y_ :	'y' | 'Y';
fragment Z_ :	'z' | 'Z';

FOR_NOTATION
    :    UNSIGNED_INTEGER
        {state.type = UNSIGNED_INTEGER; emit(); advanceInput();}
        '..'
        {state.type = DOUBLE_PERIOD; emit(); advanceInput();}
        UNSIGNED_INTEGER
        {state.type = UNSIGNED_INTEGER; emit(); advanceInput(); $channel=HIDDEN;}
    ;

NATIONAL_CHAR_STRING_LIT
    :    N_ '\'' (options{greedy=true;}: ~('\'' | '\r' | '\n' ) | '\'' '\'' | NEWLINE)* '\''
    ;

BIT_STRING_LIT
    :    B_ ('\'' ('0' | '1')* '\'' SEPARATOR? )+
    ;

HEX_STRING_LIT
    :    X_ ('\'' ('a'..'f' | 'A'..'F' | '0'..'9')* '\'' SEPARATOR? )+ 
    ;

PERIOD
    :    '.' 
    {    if ((char) input.LA(1) == '.') {
            input.consume();
            $type = DOUBLE_PERIOD;
        }
    }
    ;

EXACT_NUM_LIT
    : (
            UNSIGNED_INTEGER
            ( '.' UNSIGNED_INTEGER
            |    {$type = UNSIGNED_INTEGER;}
            ) ( ('E' | 'e') ('+' | '-')? UNSIGNED_INTEGER {$type = APPROXIMATE_NUM_LIT;} )?
    |    '.' UNSIGNED_INTEGER ( ('E' | 'e') ('+' | '-')? UNSIGNED_INTEGER {$type = APPROXIMATE_NUM_LIT;} )?
    )
    ( D_ | F_)?
    ;

CHAR_STRING
    :    '\'' (options{greedy=true;}: ~('\'' | '\r' | '\n') | '\'' '\'' | NEWLINE)* '\''
    ;

CHAR_STRING_PERL    : Q_ ( QS_ANGLE | QS_BRACE | QS_BRACK | QS_PAREN | QS_OTHER) {$type = CHAR_STRING;};
fragment QUOTE      : '\'' ;
fragment QS_ANGLE   : QUOTE '<' ( options {greedy=false;} : . )* '>' QUOTE ;
fragment QS_BRACE   : QUOTE '{' ( options {greedy=false;} : . )* '}' QUOTE ;
fragment QS_BRACK   : QUOTE '[' ( options {greedy=false;} : . )* ']' QUOTE ;
fragment QS_PAREN   : QUOTE '(' ( options {greedy=false;} : . )* ')' QUOTE ;

fragment QS_OTHER_CH: ~('<'|'{'|'['|'('|' '|'\t'|'\n'|'\r');
fragment QS_OTHER
		:
		QUOTE delimiter=QS_OTHER_CH
    ( { input.LT(1) != $delimiter.text.charAt(0) || ( input.LT(1) == $delimiter.text.charAt(0) && input.LT(2) != '\'') }? => . )*
    ( { input.LT(1) == $delimiter.text.charAt(0) && input.LT(2) == '\'' }? => . ) QUOTE

		;

DELIMITED_ID
    :    '"' (~('"' | '\r' | '\n') | '"' '"')+ '"' 
    ;

PERCENT
    :    '%'
    ;

AMPERSAND
    :    '&'
    ;

LEFT_PAREN
    :    '('
    ;

RIGHT_PAREN
    :    ')'
    ;

DOUBLE_ASTERISK
    :    '**'
    ;

ASTERISK
    :    '*'
    ;

PLUS_SIGN
    :    '+'
    ;

COMMA
    :    ','
    ;

SOLIDUS
    :    '/'
    ; 

AT_SIGN
    :    '@'
    ;

ASSIGN_OP
    :    ':='
    ;

BINDVAR
    :    COLON SIMPLE_LETTER  ( SIMPLE_LETTER | '0' .. '9' | '_' )*
    |    COLON DELIMITED_ID  
    |    COLON UNSIGNED_INTEGER
    |    QUESTION_MARK 
    ;

COLON
    :    ':'
    ;

SEMICOLON
    :    ';'
    ;

LESS_THAN_OR_EQUALS_OP
    :    '<='
    ;

LESS_THAN_OP
    :    '<'
    ;

GREATER_THAN_OR_EQUALS_OP
    :    '>='
    ;

NOT_EQUAL_OP
    :    '!='
    |    '<>'
    |    '^='
    |    '~='
    ;
CARRET_OPERATOR_PART
    :    '^'
    ;

TILDE_OPERATOR_PART
    :    '~'
    ;

EXCLAMATION_OPERATOR_PART
    :    '!'
    ;

GREATER_THAN_OP
    :    '>'
    ;

fragment
QUESTION_MARK
    :    '?'
    ;

CONCATENATION_OP
    :    '||'
    ;

VERTICAL_BAR
    :    '|'
    ;

EQUALS_OP
    :    '='
    ;

LEFT_BRACKET
    :    '['
    ;

RIGHT_BRACKET
    :    ']'
    ;

INTRODUCER
    :    '_' (SEPARATOR {$type = UNDERSCORE;})?
    ;

SEPARATOR
    :    '-' {$type = MINUS_SIGN;}
    |    COMMENT { $channel=HIDDEN; }
    |    (SPACE | NEWLINE)+ { $channel=HIDDEN; }
    ;

fragment
SIMPLE_LETTER
    :    'a'..'z'
    |    'A'..'Z'
    ;

fragment
UNSIGNED_INTEGER
    :    ('0'..'9')+ 
    ;

fragment
COMMENT
    :    '--' ( ~('\r' | '\n') )* (NEWLINE|EOF)
    |    '/*' (options{greedy=false;} : .)* '*/'
    ;

PROMPT
	: P_ R_ O_ M_ P_ T_ SPACE ( ~('\r' | '\n') )* (NEWLINE|EOF)
	;

fragment
NEWLINE
    :    '\r' (options{greedy=true;}: '\n')?
    |    '\n'
    ;
fragment
SPACE    :    ' '
    |    '\t'
    ;

fragment APPROXIMATE_NUM_LIT: ;
fragment MINUS_SIGN: ;    
fragment UNDERSCORE: ;
fragment DOUBLE_PERIOD: ;

SQL92_RESERVED_ALL
    :    A_ L_ L_
    ;

SQL92_RESERVED_ALTER
    :    A_ L_ T_ E_ R_
    ;

SQL92_RESERVED_AND
    :    A_ N_ D_
    ;

SQL92_RESERVED_ANY
    :    A_ N_ Y_
    ;

SQL92_RESERVED_AS
    :    A_ S_
    ;

SQL92_RESERVED_ASC
    :    A_ S_ C_
    ;

SQL92_RESERVED_BEGIN
    :    B_ E_ G_ I_ N_
    ;

SQL92_RESERVED_BETWEEN
    :    B_ E_ T_ W_ E_ E_ N_
    ;

SQL92_RESERVED_BY
    :    B_ Y_
    ;

SQL92_RESERVED_CASE
    :    C_ A_ S_ E_
    ;

SQL92_RESERVED_CHECK
    :    C_ H_ E_ C_ K_
    ;

PLSQL_RESERVED_CLUSTERS
    :    C_ L_ U_ S_ T_ E_ R_ S_
    ;

PLSQL_RESERVED_COLAUTH
    :    C_ O_ L_ A_ U_ T_ H_
    ;

PLSQL_RESERVED_COMPRESS
    :    C_ O_ M_ P_ R_ E_ S_ S_
    ;

SQL92_RESERVED_CONNECT
    :    C_ O_ N_ N_ E_ C_ T_
    ;

PLSQL_NON_RESERVED_CONNECT_BY_ROOT
    :    C_ O_ N_ N_ E_ C_ T_ '_' B_ Y_ '_' R_ O_ O_ T_
    ;

PLSQL_RESERVED_CRASH
    :    C_ R_ A_ S_ H_
    ;

SQL92_RESERVED_CREATE
    :    C_ R_ E_ A_ T_ E_
    ;

SQL92_RESERVED_CURRENT
    :    C_ U_ R_ R_ E_ N_ T_
    ;

SQL92_RESERVED_CURSOR
    :    C_ U_ R_ S_ O_ R_
    ;

SQL92_RESERVED_DATE
    :    D_ A_ T_ E_
    ;

SQL92_RESERVED_DECLARE
    :    D_ E_ C_ L_ A_ R_ E_
    ;

SQL92_RESERVED_DEFAULT
    :    D_ E_ F_ A_ U_ L_ T_
    ;

SQL92_RESERVED_DELETE
    :    D_ E_ L_ E_ T_ E_
    ;

SQL92_RESERVED_DESC
    :    D_ E_ S_ C_
    ;

SQL92_RESERVED_DISTINCT
    :    D_ I_ S_ T_ I_ N_ C_ T_
    ;

SQL92_RESERVED_DROP
    :    D_ R_ O_ P_
    ;

SQL92_RESERVED_ELSE
    :    E_ L_ S_ E_
    ;

SQL92_RESERVED_END
    :    E_ N_ D_
    ;

SQL92_RESERVED_EXCEPTION
    :    e='exception' | e='EXCEPTION'
    {
    $e.setType(SQL92_RESERVED_EXCEPTION);
    emit($e);
    advanceInput();

    $type = Token.INVALID_TOKEN_TYPE;
    int markModel = input.mark();

    Token t1 = super.nextToken();
    { 
        if( t1 != null && t1.getType() == Token.EOF)
        {
             $e.setType(REGULAR_ID);
        } else {
             t1 = tokenBuffer.pollLast(); 
             while(true)
             {
                 if(t1.getType() == EOF)   
                 {
                     $e.setType(REGULAR_ID);
                     break;
                 }

                 if(t1.getChannel() == HIDDEN) 
                 {
                     t1 = super.nextToken(); if( t1 == null) { t1 = tokenBuffer.pollLast(); };
                     continue;
                 }

                 if( t1.getType() != SQL92_RESERVED_WHEN && t1.getType() != SEMICOLON) 
                 {
                     $e.setType(REGULAR_ID);
                     break;
                 }

                 break; 
              } 
         } 
    }
    input.rewind(markModel);
    }
    ;

PLSQL_RESERVED_EXCLUSIVE
    :    E_ X_ C_ L_ U_ S_ I_ V_ E_
    ;

SQL92_RESERVED_EXISTS
    :    E_ X_ I_ S_ T_ S_
    ;

SQL92_RESERVED_FALSE
    :    F_ A_ L_ S_ E_
    ;

SQL92_RESERVED_FETCH
    :    F_ E_ T_ C_ H_
    ;

SQL92_RESERVED_FOR
    :    F_ O_ R_
    ;

SQL92_RESERVED_FROM
    :    F_ R_ O_ M_
    ;

SQL92_RESERVED_GOTO
    :    G_ O_ T_ O_
    ;

SQL92_RESERVED_GRANT
    :    G_ R_ A_ N_ T_
    ;

SQL92_RESERVED_GROUP
    :    G_ R_ O_ U_ P_
    ;

SQL92_RESERVED_HAVING
    :    H_ A_ V_ I_ N_ G_
    ;

PLSQL_RESERVED_IDENTIFIED
    :    I_ D_ E_ N_ T_ I_ F_ I_ E_ D_
    ;

PLSQL_RESERVED_IF
    :    I_ F_
    ;

SQL92_RESERVED_IN
    :    I_ N_
    ;

PLSQL_RESERVED_INDEX
    :    I_ N_ D_ E_ X_
    ;

PLSQL_RESERVED_INDEXES
    :    I_ N_ D_ E_ X_ E_ S_
    ;

SQL92_RESERVED_INSERT
    :    I_ N_ S_ E_ R_ T_
    ;

SQL92_RESERVED_INTERSECT
    :    I_ N_ T_ E_ R_ S_ E_ C_ T_
    ;

SQL92_RESERVED_INTO
    :    I_ N_ T_ O_
    ;

SQL92_RESERVED_IS
    :    I_ S_
    ;

SQL92_RESERVED_LIKE
    :    L_ I_ K_ E_
    ;

PLSQL_RESERVED_LOCK
    :    L_ O_ C_ K_
    ;

PLSQL_RESERVED_MINUS
    :    M_ I_ N_ U_ S_
    ;

PLSQL_RESERVED_MODE
    :    M_ O_ D_ E_
    ;

PLSQL_RESERVED_NOCOMPRESS
    :    N_ O_ C_ O_ M_ P_ R_ E_ S_ S_
    ;

SQL92_RESERVED_NOT
    :    N_ O_ T_
    ;

PLSQL_RESERVED_NOWAIT
    :    N_ O_ W_ A_ I_ T_
    ;

SQL92_RESERVED_NULL
    :    N_ U_ L_ L_
    ;

SQL92_RESERVED_OF
    :    O_ F_
    ;

SQL92_RESERVED_ON
    :    O_ N_
    ;

SQL92_RESERVED_OPTION
    :    O_ P_ T_ I_ O_ N_
    ;

SQL92_RESERVED_OR
    :    O_ R_
    ;

SQL92_RESERVED_ORDER
    :    O_ R_ D_ E_ R_
    ;

SQL92_RESERVED_OVERLAPS
    :    O_ V_ E_ R_ L_ A_ P_ S_
    ;

SQL92_RESERVED_PRIOR
    :    P_ R_ I_ O_ R_
    ;

SQL92_RESERVED_PROCEDURE
    :    P_ R_ O_ C_ E_ D_ U_ R_ E_
    ;

SQL92_RESERVED_PUBLIC
    :    P_ U_ B_ L_ I_ C_
    ;

PLSQL_RESERVED_RESOURCE
    :    R_ E_ S_ O_ U_ R_ C_ E_
    ;

SQL92_RESERVED_REVOKE
    :    R_ E_ V_ O_ K_ E_
    ;

SQL92_RESERVED_SELECT
    :    S_ E_ L_ E_ C_ T_
    ;

PLSQL_RESERVED_SHARE
    :    S_ H_ A_ R_ E_
    ;

SQL92_RESERVED_SIZE
    :    S_ I_ Z_ E_
    ;

PLSQL_RESERVED_START
    :    S_ T_ A_ R_ T_
    ;

PLSQL_RESERVED_TABAUTH
    :    T_ A_ B_ A_ U_ T_ H_
    ;

SQL92_RESERVED_TABLE
    :    T_ A_ B_ L_ E_ 
    ;

SQL92_RESERVED_THE
    :    T_ H_ E_
    ;

SQL92_RESERVED_THEN
    :    T_ H_ E_ N_
    ;

SQL92_RESERVED_TO
    :    T_ O_
    ;

SQL92_RESERVED_TRUE
    :    T_ R_ U_ E_
    ;

SQL92_RESERVED_UNION
    :    U_ N_ I_ O_ N_
    ;

SQL92_RESERVED_UNIQUE
    :    U_ N_ I_ Q_ U_ E_
    ;

SQL92_RESERVED_UPDATE
    :    U_ P_ D_ A_ T_ E_
    ;

SQL92_RESERVED_VALUES
    :    V_ A_ L_ U_ E_ S_
    ;

SQL92_RESERVED_VIEW
    :    V_ I_ E_ W_
    ;

PLSQL_RESERVED_VIEWS
    :    V_ I_ E_ W_ S_
    ;

SQL92_RESERVED_WHEN
    :    W_ H_ E_ N_ 
    ;

SQL92_RESERVED_WHERE
    :    W_ H_ E_ R_ E_
    ;

SQL92_RESERVED_WITH
    :    W_ I_ T_ H_
    ;

PLSQL_NON_RESERVED_USING
    :    U_ S_ I_ N_ G_
    ;

PLSQL_NON_RESERVED_MODEL
    :    m='model' | m='MODEL'
    {
         $m.setType(PLSQL_NON_RESERVED_MODEL);
         emit($m);
         advanceInput();

         $type = Token.INVALID_TOKEN_TYPE;
         int markModel = input.mark();

         Token t1 = super.nextToken();
         {    
              if( t1 != null && t1.getType() == Token.EOF)
              {
                  $m.setType(REGULAR_ID);
              } else {
                  t1 = tokenBuffer.pollLast(); 
                  while(true)
                  {
                     if(t1.getType() == EOF)   
                     {
                         $m.setType(REGULAR_ID);
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
                         $m.setType(REGULAR_ID);
                         break;
                     }

                     break; 
                  } 
              } 
         }
         input.rewind(markModel);
    }
    ;

PLSQL_NON_RESERVED_ELSIF
    :    E_ L_ S_ I_ F_
    ;

PLSQL_NON_RESERVED_PIVOT
    :    P_ I_ V_ O_ T_
    ;

PLSQL_NON_RESERVED_UNPIVOT
    :    U_ N_ P_ I_ V_ O_ T_
    ;
    
JOIN: J_ O_ I_ N_;
LEFT: L_ E_ F_ T_;
RIGHT: R_ I_ G_ H_ T_;
FULL: F_ U_ L_ L_;
OUTER: O_ U_ T_ E_ R_;
CROSS: C_ R_ O_ S_ S_;
NATURAL: N_ A_ T_ U_ R_ A_ L_;
INNER: I_ N_ N_ E_ R_;

REGULAR_ID
    :    (SIMPLE_LETTER) (SIMPLE_LETTER | '$' | '_' | '#' | '0'..'9')*
    ;

ZV
    :    '@!' {$channel=HIDDEN;}
    ;