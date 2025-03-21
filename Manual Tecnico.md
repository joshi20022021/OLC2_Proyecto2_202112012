# 📌 Universidad de San Carlos de Guatemala  
### 🏛 Facultad de Ingeniería - Escuela de Ciencias y Sistemas  
### 🖥 ORGANIZACION DE LENGUAJES Y COMPILADORES 2, SECCION B

## 👤 Nombre: **Edgar Josías Cán Ajquejay**  
## 🎓 Carnet: **202112012**  

## 🏥 **Manual Técnico**  

## GRAMATICA ANTLR
Aca se obtiene lo que es la gramatica ANTLR para el lenguaje de go en donde se muestra todos los tokens
reglas y derivaciones de cada instruccion, funcion y sentencia como se ejecutar a partir de una serie de
sucesion de reglas sintacticas y lexicas para ejecutar lo que seria el patron visitor.

```bash
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
    | IDENTIFICADOR L_CORCHETE expresion R_CORCHETE IGUAL expresion   # AsignarSlice
    | IDENTIFICADOR L_CORCHETE expresion R_CORCHETE L_CORCHETE expresion R_CORCHETE IGUAL expresion  # AsignarMatriz
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
    : L_CORCHETE R_CORCHETE IDENTIFICADOR? '{' (sliceElemento (',' sliceElemento)*)? '}'
    ;

sliceElemento
    : expresion         
    | sliceLiteral     
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
    | IDENTIFICADOR L_CORCHETE expresion R_CORCHETE     # AccesoSlice
    | AGREGAR PARENTESIS_IZQ expresion ',' expresion PARENTESIS_DER          # FuncionAppend
    | LONGITUD PARENTESIS_IZQ expresion PARENTESIS_DER                           # FuncionLen
    | INDICE PARENTESIS_IZQ expresion ',' expresion PARENTESIS_DER    # FuncionIndex
    | UNIR PARENTESIS_IZQ expresion ',' expresion PARENTESIS_DER    # FuncionJoin
    | IDENTIFICADOR L_CORCHETE expresion R_CORCHETE L_CORCHETE expresion R_CORCHETE  # AccesoSlice2D
    | LIT_ENTERO                           # LiteralEntero
    | LIT_FLOAT                            # LiteralFlotante
    | LIT_RUNE                             # LiteralRune
    | LIT_STRING                           # LiteralCadena  
    | VERDADERO                            # LiteralVerdadero
    | FALSO                                # LiteralFalso
    | NULO                                 # LiteralNulo
    | IDENTIFICADOR                        # Identificador
    ;



```

## Compiler Visitor
## Manejo de Entornos y Tabla de Símbolos

El Visitor utiliza una pila de entornos para manejar el ámbito de las variables y una tabla de símbolos para almacenar información sobre variables, funciones y otros elementos.

```bash
private Stack<Dictionary<string, EntradaSimbolo>> pilaEntornos = new Stack<Dictionary<string, EntradaSimbolo>>();
private readonly List<EntradaSimbolo> tablaSimbolos = new List<EntradaSimbolo>();
```

## Manejo de Errores Semánticos

El Visitor recopila errores semánticos durante la ejecución y los almacena en una lista.

```bash
public List<CustomError> ErroresSemanticos { get; } = new List<CustomError>();
private void AgregarError(string mensaje, int line, int column)
{
    ErroresSemanticos.Add(new CustomError
    {
        Line = line,
        Column = column,
        Message = mensaje,
        Type = "Semántico"
    });
    mensajesSalida.Add($"ERROR DETECTADO: {mensaje}");
}
```

## Evaluación de Expresiones

El Visitor evalúa expresiones aritméticas, lógicas y de comparación.

```bash
public override object VisitSuma(LanguageParser.SumaContext context)
{
    var izq = Visit(context.expresion(0));
    var der = Visit(context.expresion(1));
    if (izq is string || der is string)
        return (izq?.ToString() ?? "") + (der?.ToString() ?? "");
    double? valIzq = ConvertirANumero(izq);
    double? valDer = ConvertirANumero(der);
    return valIzq.HasValue && valDer.HasValue ? valIzq.Value + valDer.Value : "Error: Tipos incompatibles en suma.";
}
```

## Manejo de Variables

El Visitor maneja la declaración, asignación y acceso a variables.

```bash
public override object VisitAsignar(LanguageParser.AsignarContext context)
{
    var varName = context.IDENTIFICADOR().GetText();
    var value = Visit(context.expresion());
    foreach (var entorno in pilaEntornos)
    {
        if (entorno.ContainsKey(varName))
        {
            entorno[varName].Valor = value;
            return value;
        }
    }
    AgregarError($"Error: La variable '{varName}' no está definida.", context.Start.Line, context.Start.Column + 1);
    return "nulo";
}
```

## Manejo tabla de simbolos

```bash
  public class EntradaSimbolo
        {
            public int Id { get; set; }
            public string TipoSimbolo { get; set; } = "Variable"; // Variable/Funcion/Procedimiento
            public string Nombre { get; set; } = string.Empty;
            public string TipoDato { get; set; } = "indefinido";
            public object Valor { get; set; } = "nulo";
            public string Ambito { get; set; } = "Global";
            public int Linea { get; set; }
            public int Columna { get; set; }
            public List<object> Lista { get; set; } = new List<object>();
            
            // Nueva propiedad para seguimiento de ID único
            private static int _contadorId = 1;
            public EntradaSimbolo() => Id = _contadorId++;
        }
```

## Metodo para obtener el tipo de variable

```bash
private string ObtenerNombreTipo(object valor)
        {
            return valor switch
            {
                null => "nulo",
                long _ => "int",
                double _ => "float64",
                bool _ => "bool",
                string _ => "string",
                char _ => "rune",  
                _ => valor.GetType().Name
            };
        }
```


## CustomErrorListener.cs

### Manejo de errores lexicos

```bash
    public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, 
        int line, int charPositionInLine, string msg, RecognitionException e)
    {
        _errores.Add(new CustomError
        {
            Line = line,
            Column = charPositionInLine,
            Message = msg,
            Type = "Léxico"
        });
    }
}
```

### Manejo de errores sintacticos

```bash
    public void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, 
        int line, int charPositionInLine, string msg, RecognitionException e)
    {
        _errores.Add(new CustomError
        {
            Line = line,
            Column = charPositionInLine,
            Message = msg,
            Type = "Sintáctico"
        });
    }
```

