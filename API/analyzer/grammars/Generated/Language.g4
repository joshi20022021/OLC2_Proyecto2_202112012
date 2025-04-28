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

//SLICES
AGREGAR: 'append';
LONGITUD: 'len';
INDICE: 'slice.Index';
UNIR: 'strings.Join';

//CONVERSION DE TIPOS
STRCONV_ATOI      : 'strconv.Atoi';
STRCONV_PARSEFLOAT: 'strconv.ParseFloat';
REFLECT_TYPEOF    : 'reflect.TypeOf';

//sintaxis y tipos de datos
LIT_STRING: '"' (ESCAPE_SEQUENCE | ~["\\\r\n])* '"';
fragment ESCAPE_SEQUENCE: '\\' [btnfr"'\\];
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
programa : (declaracionStruct | funcionStruct | funcionDeclaracion | declaracion)* funcionMain ;

//funcion main para ejecutar el archivo
funcionMain : 'func' 'main' '(' ')' bloque ;

//imprimir
IMPRIMIR : 'fmt.Println';

//sentencias de transferencia
breakStmt : 'break' ;      
continueStmt : 'continue' ;
returnStmt : 'return' expresion? ; 

//condiciones
bloque : '{' (sentencia)* '}';

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
    | IDENTIFICADOR L_CORCHETE expresion R_CORCHETE IGUAL expresion   # AsignarSlice
    | IDENTIFICADOR L_CORCHETE expresion R_CORCHETE L_CORCHETE expresion R_CORCHETE IGUAL expresion  # AsignarMatriz
    ;

//tipo de variables
tipo
    : '[' ']' tipo    
    | IDENTIFICADOR   
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

//contador incremento y decremento
contador
    : IDENTIFICADOR MAS MAS    # Incremento
    | IDENTIFICADOR MENOS MENOS  # Decremento
    ;

//slice
sliceLiteral
    : '[' ']' tipo? '{' (sliceElemento (',' sliceElemento)*)? '}'
    ;

//lista
listLiteral
    : '{' (expresion (',' expresion)*)? '}'  
    ;

//elementos de lista
sliceElemento
    : expresion
    | sliceLiteral
    | listLiteral
    ;

//llamada funcion
funcionCall
    : (IDENTIFICADOR '.')? IDENTIFICADOR PARENTESIS_IZQ (expresion (',' expresion)*)? PARENTESIS_DER
    ;

//parametros funcion
parametros
    : parametro (',' parametro)*
    ;

//para
parametro
    : IDENTIFICADOR tipo
    ;

//imprimir argumentos
imprimir
    : IMPRIMIR PARENTESIS_IZQ (expresion (',' expresion)*)? PARENTESIS_DER # Imprime
    ;

// Definición de un struct
declaracionStruct
    : 'type' IDENTIFICADOR 'struct' '{' (atributoStruct)* '}' #StructDeclaracion 
    ;

//asignacion de atributos
asignacionAtributo
    : expresion '.' IDENTIFICADOR IGUAL expresion
    ;

//atributos de los structs
atributoStruct
    : IDENTIFICADOR tipo  # Atributo 
    ;

//declaracion de funciones struct
funcionStruct
    : 'func' '(' IDENTIFICADOR IDENTIFICADOR ')' IDENTIFICADOR '(' parametros? ')' tipo? bloque #MetodoStruct
    ;

//declaracion de funciones 
funcionDeclaracion
    : 'func' IDENTIFICADOR PARENTESIS_IZQ (parametros)? PARENTESIS_DER (tipo)? bloque
    ;

//expresiones de los structs
expresionLiteralStruct
    : IDENTIFICADOR '{' (atributosInicializacion)? '}'  
    ;
    
//atributos de inicializacion
atributosInicializacion
    : IDENTIFICADOR ':' expresion (',' IDENTIFICADOR ':' expresion)*
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
    | IDENTIFICADOR L_CORCHETE expresion R_CORCHETE     # AccesoSlice
    | AGREGAR PARENTESIS_IZQ expresion ',' expresion PARENTESIS_DER          # FuncionAppend
    | LONGITUD PARENTESIS_IZQ expresion PARENTESIS_DER                           # FuncionLen
    | INDICE PARENTESIS_IZQ expresion ',' expresion PARENTESIS_DER    # FuncionIndex
    | UNIR PARENTESIS_IZQ expresion ',' expresion PARENTESIS_DER    # FuncionJoin
    | IDENTIFICADOR L_CORCHETE expresion R_CORCHETE L_CORCHETE expresion R_CORCHETE  # AccesoSlice2D
    | funcionCall                          # FuncionLlamada
    | expresionLiteralStruct               #ExpresionStructLiteral
    | expresion '.' IDENTIFICADOR #ExpresionAccesoAtributo
    | STRCONV_ATOI PARENTESIS_IZQ expresion PARENTESIS_DER       # FuncionAtoi
    | STRCONV_PARSEFLOAT PARENTESIS_IZQ expresion PARENTESIS_DER   # FuncionParseFloat
    | REFLECT_TYPEOF PARENTESIS_IZQ expresion PARENTESIS_DER         # FuncionTypeOf
    | LIT_ENTERO                           # LiteralEntero
    | LIT_FLOAT                            # LiteralFlotante
    | LIT_RUNE                             # LiteralRune
    | LIT_STRING                           # LiteralCadena  
    | VERDADERO                            # LiteralVerdadero
    | FALSO                                # LiteralFalso
    | NULO                                 # LiteralNulo
    | IDENTIFICADOR                        # Identificador
    ;
