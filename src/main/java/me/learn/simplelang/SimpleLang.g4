grammar SimpleLang;

simpleLang
    : block EOF
    ;

block
    : stat* returnStat?
    ;

stat
    : VAR '=' expr # assign
    | functionCall # callFunction
    | functionDef # defFunction
    ;

returnStat
    : 'return' (expr | var)
    ;

functionCall
    : VAR '(' expr (',' expr)* ')'
    ;

expr
    : 'false' | 'true'
    | string
    | var
    | functionCall
    | calExpr
    ;

calExpr
    : number
    | var
    | opUnary calExpr
    | '(' calExpr ')'
    | functionCall
    | calExpr opAddAndSub calExpr
    | calExpr opMudAndDiv calExpr
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

