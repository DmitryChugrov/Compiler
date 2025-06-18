grammar Tokens;

@header {
package ru.Compiler;
}

// Основная структура
program
  : namespaceDeclaration? interfaceDeclaration implementationDeclaration END_P ;

namespaceDeclaration
  : NAMESPACE ID_UP PC;


interfaceDeclaration
  : INTERFACE classDeclaration*;

classDeclaration
  : ID_UP EQUALLY CLASS classBody END_M;


classBody
  : (privateSection publicSection? | publicSection privateSection?) ;

publicSection
  : PUBLIC classMember;

privateSection
  : PRIVATE classMember;

classMember
  : methodDeclaration* | nestedClassDeclaration ;

methodDeclaration
  : CLASS METHOD (ID_LOW| (MAIN)?) '(' parameterList? ')' (':' type)? PC ;

parameterList
  : parameter (',' parameter)* ;

parameter
  : typeParam ID_LOW ;

nestedClassDeclaration
  : classDeclaration ;

type
  : INT_M
  | DOUBLE_M
  | STRING_M
  | BOOLEAN_M ;

implementationDeclaration
  : IMPLMT classMethod* ;

classMethod
  : CLASS METHOD ID_UP POINT (ID_LOW | MAIN?) '(' parameterList? ')' PC methodBody
  | CLASS METHOD ID_UP POINT ID_LOW '(' parameterList? ')' ':' type PC returnMethodBody ;

methodBody
  : BEGIN statementList END_M ;

returnMethodBody
  : BEGIN statementList returnStatement END_M ;

returnStatement
  : RETURN expression PC ;

statementList
  : statement* ;

statement
  : assignment | variableDeclaration | methodCall | returnStatement | booleanDeclaration | for | if | while | print;

methodCall : ID_UP POINT (ID_LOW | MAIN) '(' argumentList? ')' PC;

methodCallReturn : ID_UP POINT (ID_LOW | MAIN) '(' argumentList? ')';

assignment
  : ID_LOW EQUALLY expression PC ;


argumentList
  : expression (',' expression)*;


variableDeclaration
  : (INT | DOUBLE | STRING) ID_LOW (EQUALLY expression)? PC ;

booleanDeclaration : BOOLEAN ID_LOW (EQUALLY (TRUE | FALSE))? PC ;

expression
  : shiftExpression ((PLUS | MINUS) shiftExpression)* ;

shiftExpression
  : term ((LSHIFT | RSHIFT) term)* ;

term
  : factor ((MULT | DIV | R_DIV) factor)* ;

factor
  : DOUBLE_NUMBER
  | NUMBER_INT
  | STRING_LITERAL
  | TRUE
  | FALSE
  | ID_LOW
  | methodCallReturn
  | '(' expression ')' ;

print : PRINT '(' printExpression ')' PC ;

printExpression
  : printAddExpr ;

printAddExpr
  : printAtom (PLUS printAtom)* ;

printAtom
  : expression
  | STRING_LITERAL ;

bool : expression (MANY | LESS | EQUALLY_BOOL | NOT_EQUALLY | M_EQUALLY | L_EQUALLY) expression;

boolExpression
  : boolTerm (OR boolTerm)* ;

boolTerm
  : boolFactor (AND boolFactor)* ;

boolFactor
  : '(' boolExpression ')'
  | comparison ;

comparison
  : expression (MANY | LESS | EQUALLY_BOOL | NOT_EQUALLY | M_EQUALLY | L_EQUALLY) (expression | TRUE | FALSE) ;

for : FOR '(' (variableDeclaration | ) bool PC (prefix | postfix) ')' BEGIN statementList END_M;

while : WHILE '(' (boolExpression) ')' BEGIN statementList END_M;

if : IF '(' (boolExpression) ')' BEGIN statementList BREAK? END_M (else | else_if)? ;

else : ELSE statementList;

else_if : ELSE_IF '(' boolExpression ')' BEGIN statementList BREAK? END_M else_if?;

prefix : (INCREM | DECREM) ID_LOW;
postfix : ID_LOW (INCREM | DECREM);

typeParam: (INT | DOUBLE | STRING | BOOLEAN);

// Лексика
INT : 'int' ;
DOUBLE : 'double' ;
STRING : 'String' ;
BOOLEAN : 'boolean' ;


BLANK : [ \t\r\n]+ -> skip ;

NAMESPACE : 'namespace' ;
INTERFACE : 'interface' ;
CLASS : 'class' ;
METHOD : 'method' ;
IMPLMT : 'implementation' ;
USES : 'uses' ;
BEGIN : 'begin' ;
END_M : 'end;' ;
END_P : 'end.' ;
FOR : 'for' ;
WHILE : 'while' ;
BREAK : 'break' ;
IF : 'if' ;
ELSE : 'else' ;
ELSE_IF : 'else if';
RETURN : 'return';

PLUS : '+' ;
MINUS : '-' ;
MULT : '*' ;
DIV : '/' ;
R_DIV : '%';
EQUALLY : '=' ;
COMMENT: '//' ~[\r\n]* -> skip;
POINT : '.' ;
PC : ';' ;
Q_MARK : '\'' ;

MANY : '>';
LESS : '<';
EQUALLY_BOOL : '==';
NOT_EQUALLY : '!=';
L_EQUALLY: '<=';
M_EQUALLY: '=>';

INCREM : '++';
DECREM : '--';

AND : '&';
OR : '|' ;
TRUE: 'true';
FALSE : 'false';

LSHIFT : '<<' ;
RSHIFT : '>>' ;

INT_M : 'Integer' ;
DOUBLE_M : 'Double' ;
STRING_M : 'STRING' ;
BOOLEAN_M : 'Boolean';

PUBLIC : 'public' ;
PRIVATE : 'private' ;

NUMBER_INT : [0-9]+ ;
DOUBLE_NUMBER : [0-9]+ '.' [0-9]+ ([eE] [+\-]? [0-9]+)? ;
STRING_LITERAL : '"' (~["\\] | '\\' .)* '"' ;
MAIN : 'main' ;

PRINT : 'print';

ID_UP : [A-Z][a-zA-Z0-9_]*;
ID_LOW : [a-zA-Z_][a-zA-Z_0-9]* ;



