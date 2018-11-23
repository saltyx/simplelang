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
    : string
    | var
    | functionCall
    | calExpr
    ;

calExpr
    : number                        # numberCalExpr
    | var                           # varCalExpr
    | opUnary calExpr               # unaryCalExpr
    | '(' calExpr ')'               # bracketsCalExpr
    | functionCall                  # functionCalExpr
    | calExpr opAddAndSub calExpr   # addOrSubCalExpr
    | calExpr opMudAndDiv calExpr   # mudOrDivCalExpr
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

