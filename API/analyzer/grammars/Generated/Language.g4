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
PUNTOYCOMA : ';';

//imprimir
IMPRIMIR : 'fmt.Println';

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

//condiciones
bloque : '{' sentencia* '}' ;

//sentencias
sentencia
    : asignacion PUNTOYCOMA               # SentenciaAsignacion
    | imprimir PUNTOYCOMA                 # SentenciaImprimir
    | expresion PUNTOYCOMA                # SentenciaExpresion
    ;

//asignacion de variables
asignacion
    : IDENTIFICADOR IGUAL expresion       # Asignar
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
    | LIT_ENTERO                           # LiteralEntero
    | LIT_FLOAT                            # LiteralFlotante
    | LIT_RUNE                             # LiteralRune
    | LIT_STRING                           # LiteralCadena  
    | VERDADERO                            # LiteralVerdadero
    | FALSO                                # LiteralFalso
    | NULO                                 # LiteralNulo
    | IDENTIFICADOR                        # Identificador
    ;
