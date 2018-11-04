grammar SimpleLang;

simpleLang
    : block EOF
    ;

block
    : stat* returnStat?
    ;

stat
    : VAR (',' VAR)* '=' expr (',' expr)*
    | functionCall
    | functionDef
    ;

returnStat
    : 'return' (expr | var)
    ;

functionCall
    : VAR '(' expr (',' expr)* ')'
    ;

expr
    : 'nil' | 'false' | 'true'
    | number
    | string
    | var
    | opUnary expr
    | '(' expr ')'
    | functionCall
    | expr opMudAndDiv expr
    | expr opAddAndSub expr
    ;

functionDef
    : 'function' VAR '(' VAR (',' VAR)* ')' block 'end'
    ;

opMudAndDiv
    : '*' | '/'
    ;

opAddAndSub
    : '+' | '-'
    ;

opUnary
    : '-' | '+'
    ;

var
    : VAR
    ;

string
    :
    CHARSTRING | STRING
    ;

number
    : INT | FLOAT
    ;

VAR
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

INT
    : Digit+
    ;

FLOAT
    : Digit+ '.' Digit* ExponentPart?
    | '.' Digit+ ExponentPart?
    | Digit+ ExponentPart
    ;

CHARSTRING
    : '\'' ( EscapeSequence | ~('\''|'\\') )* '\''
    ;

STRING
    : '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

MUL : '*';
DIV : '/';
ADD : '+';
SUB : '-';

fragment
Digit
    : [0-9]
    ;
fragment
ExponentPart
    : [eE] [+-]? Digit+
    ;
fragment
    EscapeSequence
    : '\\' [abfnrtvz"'\\]
    | '\\' '\r'? '\n'
    ;

COMMENT :   '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT :  '//' ~[\r\n]*    -> channel(HIDDEN);
WS :    [ \t\r\n]+ -> skip;

