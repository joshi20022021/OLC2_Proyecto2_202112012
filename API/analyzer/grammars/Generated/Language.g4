grammar Language;

// ***********************
// ** Reglas Léxicas **
// ***********************
PLUS      : '+';
MINUS     : '-';
MULT      : '*';
DIV       : '/';
MOD       : '%';
ASSIGN    : '=';
LPAREN    : '(';
RPAREN    : ')';
SEMI      : ';';

PRINT     : 'print';

// Nuevos tokens para tipos primitivos
TRUE      : 'true';
FALSE     : 'false';
NIL       : 'nil';
STRING_LIT : '"' (~["])* '"';   // String entre comillas dobles
RUNE_LIT   : '\'' ~['\n\r] '\''; // Rune entre comillas simples
FLOAT_LIT : [0-9]+ '.' [0-9]+;
INT_LIT   : [0-9]+;
ID        : [a-zA-Z_][a-zA-Z0-9_]*;

WS : [ \t\r\n]+ -> skip;
COMMENT : '//' ~[\r\n]* -> skip;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip;

// ***********************
// ** Reglas Sintácticas **
// ***********************
program
    : statement*                          # ProgramRule
    ;

statement
    : assignmentStmt SEMI                 # AssignmentStatement
    | printStmt SEMI                      # PrintStatement
    | expr SEMI                           # ExpressionStatement
    ;

assignmentStmt
    : ID ASSIGN expr                      # Assignment
    ;

printStmt
    : PRINT LPAREN expr RPAREN            # Print
    ;

expr
    : expr PLUS expr                      # Add
    | expr MINUS expr                     # Subtract
    | expr MULT expr                      # Multiply
    | expr DIV expr                       # Divide
    | expr MOD expr                       # Modulus
    | LPAREN expr RPAREN                  # Parentheses
    | INT_LIT                             # IntegerLiteral
    | FLOAT_LIT                           # FloatLiteral
    | RUNE_LIT                            # RuneLiteral
    | STRING_LIT                          # StringLiteral  
    | TRUE                                # BooleanTrue
    | FALSE                               # BooleanFalse
    | NIL                                 # NilLiteral
    | ID                                  # Identifier
    ;