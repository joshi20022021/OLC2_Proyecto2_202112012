grammar Language;

// ** Reglas Léxicas **

MAS     : '+';
MENOS   : '-';
MULT    : '*';
DIV     : '/';
MOD     : '%';
IGUAL   : '=';
PARENTESIS_IZQ : '(';
PARENTESIS_DER : ')';
L_CORCHETE : '[';
R_CORCHETE : ']';
PUNTOYCOMA : ';';

// Operadores Relacionales
MAYOR    : '>';
MENOR    : '<';
MAYOR_IGUAL : '>=';
MENOR_IGUAL : '<=';
IGUALDAD : '==';
DIFERENTE : '!=';

// Tipos primitivos
VERDADERO : 'true';
FALSO     : 'false';
NULO      : 'nil';

//sintaxis y tipos de datos
LIT_STRING : '"' (~["])* '"';  
LIT_RUNE   : '\'' ~['\n\r] '\''; 
LIT_FLOAT  : [0-9]+ '.' [0-9]+;
LIT_ENTERO : [0-9]+;
IDENTIFICADOR : [a-zA-Z_][a-zA-Z0-9_]*;

//comentarios
ESPACIOS : [ \t\r\n]+ -> skip;
COMENTARIO : '//' ~[\r\n]* -> skip;
COMENTARIO_MULTILINEA : '/*' .*? '*/' -> skip;

// ** Reglas Sintácticas **

//inicio de mi programa
programa : funcionMain ;

//funcion main para ejecutar el archivo
funcionMain : 'func' 'main' '(' ')' bloque ;

//imprimir
IMPRIMIR : 'fmt.Println';

//sentencias de transferencia
breakStmt : 'break' ;      
continueStmt : 'continue' ;
returnStmt : 'return' expresion? ; 

//condiciones
bloque : '{' sentencia* '}' ;

//sentencias
sentencia
    : (declaracion
      | asignacion
      | imprimir
      | expresion
      | ifStmt
      | switchStmt
      | forStmt
      | breakStmt     
      | continueStmt 
      | returnStmt  
      ) PUNTOYCOMA?
    ;


//sentencia if y else
ifStmt
    : 'if' expresion bloque ( 'else' ifStmt | 'else' bloque )? # IfElse
    ;

//declaracion de variables
declaracion
    : 'var' IDENTIFICADOR (tipo)? (IGUAL expresion)?    // Declaración explícita
    | IDENTIFICADOR ':=' expresion                       // Declaración implícita (inferencia de tipo)
    ;

//asignacion de variables
asignacion
    : IDENTIFICADOR IGUAL expresion       # Asignar
    ;

//tipo de variables
tipo
    : IDENTIFICADOR
    ;

// switch
switchStmt
    : 'switch' expresion '{' caseBlock* defaultBlock? '}' # Switch
    ;

//case
caseBlock
    : 'case' expresion ':' (sentencia)* breakStmt?
    ;

//break
defaultBlock
    : 'default' ':' (sentencia)* breakStmt?
    ;

//ciclo for
forStmt
    : 'for' expresion bloque  # ForCondicion
    | 'for' (declaracion | asignacion)? ';' expresion? ';' (asignacion | contador)? bloque  # ForClasico
    | 'for' IDENTIFICADOR ',' IDENTIFICADOR ':=' 'range' expresion bloque  # ForRange
    ;

contador
    : IDENTIFICADOR MAS MAS    # Incremento
    | IDENTIFICADOR MENOS MENOS  # Decremento
    ;

//slice
sliceLiteral
    : L_CORCHETE R_CORCHETE IDENTIFICADOR? '{' (expresion (',' expresion)*)? '}'
    ;



//imprimir argumentos
imprimir
    : IMPRIMIR PARENTESIS_IZQ (expresion (',' expresion)*)? PARENTESIS_DER # Imprime
    ;

//expresion aritmeticas,logicas, relacionales, tipos de datos
expresion
    : expresion MAS expresion              # Suma
    | expresion MENOS expresion            # Resta
    | expresion MULT expresion             # Multiplicacion
    | expresion DIV expresion              # Division
    | expresion MOD expresion              # Modulo
    | expresion IGUALDAD expresion         # ComparacionIgual
    | expresion DIFERENTE expresion        # ComparacionDiferente
    | expresion MAYOR expresion            # MayorQue
    | expresion MENOR expresion            # MenorQue
    | expresion MAYOR_IGUAL expresion      # MayorOIgual
    | expresion MENOR_IGUAL expresion      # MenorOIgual
    | expresion '&&' expresion             # And
    | expresion '||' expresion             # Or
    | '!' expresion                        # Not
    | PARENTESIS_IZQ expresion PARENTESIS_DER # Parentesis
    | sliceLiteral                         # Slice
    | LIT_ENTERO                           # LiteralEntero
    | LIT_FLOAT                            # LiteralFlotante
    | LIT_RUNE                             # LiteralRune
    | LIT_STRING                           # LiteralCadena  
    | VERDADERO                            # LiteralVerdadero
    | FALSO                                # LiteralFalso
    | NULO                                 # LiteralNulo
    | IDENTIFICADOR                        # Identificador
    ;