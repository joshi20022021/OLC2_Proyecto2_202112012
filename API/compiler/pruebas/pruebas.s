.data
float_0: .double 123.45
float_1: .double 123
str_2: .asciz "int"
float_3: .double 3.14159
str_4: .asciz "float64"
str_5: .asciz "Hola. mundo!"
str_6: .asciz "string"
str_7: .asciz "bool"
str_8: .asciz "[]int"
lit_10: .asciz "\=\=\= Archivo de prueba de funciones \=\=\="
newline_10: .asciz "\n"
lit_12: .asciz "\=\=\=\= Funciones no recursivas sin parámetros \=\=\=\="
newline_12: .asciz "\n"
lit_14: .asciz "Función sin retorno:"
newline_14: .asciz "\n"
lit_16: .asciz "\n\n###Validacion Manual"
newline_16: .asciz "\n"
lit_18: .asciz "¡Hola. mundo!"
newline_18: .asciz "\n"
lit_20: .asciz "\nFunción con retorno:"
newline_20: .asciz "\n"
lit_22: .asciz "El número obtenido es:"
space_23: .asciz " "
int_buffer_23: .space 20
newline_24: .asciz "\n"
lit_27: .asciz "OK Funciones no recursivas sin parámetros: correcto"
newline_27: .asciz "\n"
lit_29: .asciz "\n\=\=\=\= strconv.Atoi \=\=\=\="
newline_29: .asciz "\n"
lit_31: .asciz "Conversión de string a int:"
newline_31: .asciz "\n"
lit_33: .asciz "\"123\" convertido a int:"
space_34: .asciz " "
int_buffer_34: .space 20
newline_35: .asciz "\n"
lit_38: .asciz "OK strconv.Atoi: correcto"
newline_38: .asciz "\n"
lit_40: .asciz "\n\=\=\=\= strconv.ParseFloat \=\=\=\="
newline_40: .asciz "\n"
lit_42: .asciz "Conversión de string a float64:"
newline_42: .asciz "\n"
lit_44: .asciz "\"123.45\" convertido a float64:"
space_45: .asciz " "
float_buffer_45: .space 30
newline_46: .asciz "\n"
lit_48: .asciz "\"123\" convertido a float64:"
space_49: .asciz " "
float_buffer_49: .space 30
newline_50: .asciz "\n"
lit_53: .asciz "OK strconv.ParseFloat: correcto"
newline_53: .asciz "\n"
lit_55: .asciz "\n\=\=\=\= reflect.TypeOf \=\=\=\="
newline_55: .asciz "\n"
lit_57: .asciz "Obtener tipo de datos:"
newline_57: .asciz "\n"
lit_59: .asciz "Tipo de 42:"
space_60: .asciz " "
empty_str_60: .asciz ""
newline_61: .asciz "\n"
lit_63: .asciz "Tipo de 3.14159:"
space_64: .asciz " "
empty_str_64: .asciz ""
newline_65: .asciz "\n"
lit_67: .asciz "Tipo de \"Hola. mundo!\":"
space_68: .asciz " "
empty_str_68: .asciz ""
newline_69: .asciz "\n"
lit_71: .asciz "Tipo de true:"
space_72: .asciz " "
empty_str_72: .asciz ""
newline_73: .asciz "\n"
lit_75: .asciz "Tipo de []int{1. 2. 3}:"
space_76: .asciz " "
empty_str_76: .asciz ""
newline_77: .asciz "\n"
lit_80: .asciz "OK reflect.TypeOf: correcto"
newline_80: .asciz "\n"
lit_82: .asciz "\n\=\=\= Tabla de Resultados \=\=\="
newline_82: .asciz "\n"
lit_84: .asciz "+----------------------------------+--------+-------+"
newline_84: .asciz "\n"
lit_86: .asciz "| Característica                   | Puntos | Total |"
newline_86: .asciz "\n"
lit_88: .asciz "+----------------------------------+--------+-------+"
newline_88: .asciz "\n"
lit_90: .asciz "| Funciones sin parámetros         | "
space_91: .asciz " "
int_buffer_91: .space 20
space_93: .asciz " "
lit_94: .asciz "    | 5     |"
newline_94: .asciz "\n"
lit_96: .asciz "| strconv.Atoi                     | "
space_97: .asciz " "
int_buffer_97: .space 20
space_99: .asciz " "
lit_100: .asciz "    | 2     |"
newline_100: .asciz "\n"
lit_102: .asciz "| strconv.ParseFloat               | "
space_103: .asciz " "
int_buffer_103: .space 20
space_105: .asciz " "
lit_106: .asciz "    | 2     |"
newline_106: .asciz "\n"
lit_108: .asciz "| reflect.TypeOf                   | "
space_109: .asciz " "
int_buffer_109: .space 20
space_111: .asciz " "
lit_112: .asciz "    | 1     |"
newline_112: .asciz "\n"
lit_114: .asciz "+----------------------------------+--------+-------+"
newline_114: .asciz "\n"
lit_116: .asciz "| TOTAL                            | "
space_117: .asciz " "
int_buffer_117: .space 20
space_119: .asciz " "
lit_120: .asciz "   | 25    |"
newline_120: .asciz "\n"
lit_122: .asciz "+----------------------------------+--------+-------+"
newline_122: .asciz "\n"

// ARM64 Assembly
.text
.global _start
_start:
    stp x29, x30, [sp, #-16]!
    mov x29, sp
    sub sp, sp, #512

    // Declaraciones de variables
    // Debug: Símbolos en tabla: 22
    // Símbolo: '13', Tipo: 'Función', Dato: 'void'

    // Declaración de variable: saludar
    // Símbolo: '14', Tipo: 'Función', Dato: 'int'

    // Declaración de variable: obtenerNumero
    mov x9, #0
    str x9, [sp, #16]
    // Símbolo: '15', Tipo: 'Función', Dato: 'void'

    // Declaración de variable: main
    // Símbolo: '18', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntos
    mov x9, #0
    str x9, [sp, #24]
    // Símbolo: '21', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosFuncionesSimples
    mov x9, #0
    str x9, [sp, #32]
    // Símbolo: '24', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: numero
    mov x9, #42
    str x9, [sp, #40]
    // Símbolo: '27', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosAtoi
    mov x9, #0
    str x9, [sp, #48]
    // Símbolo: '30', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: numeroEntero
    mov x9, #123
    str x9, [sp, #56]
    // Símbolo: '33', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosParseFloat
    mov x9, #0
    str x9, [sp, #64]
    // Símbolo: '36', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: numeroDecimal1
    adr x9, float_0
    ldr d0, [x9]
    str d0, [sp, #72]
    // Símbolo: '39', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: numeroDecimal2
    adr x9, float_1
    ldr d0, [x9]
    str d0, [sp, #80]
    // Símbolo: '42', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosTypeOf
    mov x9, #0
    str x9, [sp, #88]
    // Símbolo: '45', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: entero
    mov x9, #42
    str x9, [sp, #96]
    // Símbolo: '48', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: tipoEntero
    adr x9, str_2
    str x9, [sp, #104]
    // Símbolo: '51', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: decimal
    adr x9, float_3
    ldr d0, [x9]
    str d0, [sp, #112]
    // Símbolo: '54', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: tipoDecimal
    adr x9, str_4
    str x9, [sp, #120]
    // Símbolo: '57', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: texto
    adr x9, str_5
    str x9, [sp, #128]
    // Símbolo: '60', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: tipoTexto
    adr x9, str_6
    str x9, [sp, #136]
    // Símbolo: '63', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: booleano
    mov x9, #1
    str x9, [sp, #144]
    // Símbolo: '66', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: tipoBooleano
    adr x9, str_7
    str x9, [sp, #152]
    // Símbolo: '69', Tipo: 'Variable', Dato: '[]int'

    // Declaración de variable: slice
    // Símbolo: '72', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: tipoSlice
    adr x9, str_8
    str x9, [sp, #160]

    // Procesando instrucciones

    // Procesando nodo: FuncionDeclaracion  Valor=saludar

    // Procesando nodo: TipoRetorno  Valor=void

    // Procesando nodo: BloqueFuncion  Valor=

    // Procesando nodo: FuncionDeclaracion  Valor=obtenerNumero

    // Procesando nodo: TipoRetorno  Valor=int

    // Procesando nodo: BloqueFuncion  Valor=

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \=\=\= Archivo de prueba de funciones \=\=\=
    adr x0, lit_10
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_10
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_10
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_10
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \=\=\=\= Funciones no recursivas sin parámetros \=\=\=\=
    adr x0, lit_12
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_12
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_12
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_12
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Función sin retorno:
    adr x0, lit_14
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_14
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_14
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_14
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\n###Validacion Manual
    adr x0, lit_16
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_16
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_16
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_16
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: ¡Hola, mundo!
    adr x0, lit_18
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_18
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_18
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_18
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \nFunción con retorno:
    adr x0, lit_20
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_20
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_20
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_20
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: El número obtenido es:
    adr x0, lit_22
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_22
    mov x8, #64
    svc #0
    adr x0, space_23
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_23
    mov x8, #64
    svc #0
    // Imprimir entero: numero
    ldr x0, [sp, #40]
    adr x1, int_buffer_23
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_23
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_24
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_24
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: numero==42
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_25
    // Bloque if (then)
    b endif_25
else_25:
    // Bloque else
endif_25:

    // Procesando nodo: Condicion  Valor=numero==42

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 5 a puntosFuncionesSimples (int) en [sp, #32]
    mov x9, #5
    str x9, [sp, #32]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Funciones no recursivas sin parámetros: correcto
    adr x0, lit_27
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_27
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_27
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_27
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= strconv.Atoi \=\=\=\=
    adr x0, lit_29
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_29
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_29
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_29
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Conversión de string a int:
    adr x0, lit_31
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_31
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_31
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_31
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \"123\" convertido a int:
    adr x0, lit_33
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_33
    mov x8, #64
    svc #0
    adr x0, space_34
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_34
    mov x8, #64
    svc #0
    // Imprimir entero: numeroEntero
    ldr x0, [sp, #56]
    adr x1, int_buffer_34
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_34
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_35
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_35
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: numeroEntero==123
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_36
    // Bloque if (then)
    b endif_36
else_36:
    // Bloque else
endif_36:

    // Procesando nodo: Condicion  Valor=numeroEntero==123

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosAtoi (int) en [sp, #48]
    mov x9, #2
    str x9, [sp, #48]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK strconv.Atoi: correcto
    adr x0, lit_38
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_38
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_38
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_38
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= strconv.ParseFloat \=\=\=\=
    adr x0, lit_40
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_40
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_40
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_40
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Conversión de string a float64:
    adr x0, lit_42
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_42
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_42
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_42
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \"123.45\" convertido a float64:
    adr x0, lit_44
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_44
    mov x8, #64
    svc #0
    adr x0, space_45
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_45
    mov x8, #64
    svc #0
    // Imprimir flotante: numeroDecimal1
    ldr d0, [sp, #72]
    adr x0, float_buffer_45
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_45
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_46
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_46
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \"123\" convertido a float64:
    adr x0, lit_48
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_48
    mov x8, #64
    svc #0
    adr x0, space_49
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_49
    mov x8, #64
    svc #0
    // Imprimir flotante: numeroDecimal2
    ldr d0, [sp, #80]
    adr x0, float_buffer_49
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_49
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_50
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_50
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: numeroDecimal1==123.45&&numeroDecimal2==123.0
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_51
    // Bloque if (then)
    b endif_51
else_51:
    // Bloque else
endif_51:

    // Procesando nodo: Condicion  Valor=numeroDecimal1==123.45&&numeroDecimal2==123.0

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosParseFloat (int) en [sp, #64]
    mov x9, #2
    str x9, [sp, #64]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK strconv.ParseFloat: correcto
    adr x0, lit_53
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_53
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_53
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_53
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= reflect.TypeOf \=\=\=\=
    adr x0, lit_55
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_55
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_55
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_55
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Obtener tipo de datos:
    adr x0, lit_57
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_57
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_57
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_57
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Tipo de 42:
    adr x0, lit_59
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_59
    mov x8, #64
    svc #0
    adr x0, space_60
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_60
    mov x8, #64
    svc #0
    // Imprimir string: tipoEntero
    ldr x0, [sp, #104]
    cmp x0, #0
    beq skip_print_60
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #104]
    mov x8, #64
    svc #0
    b end_print_60
skip_print_60:
    adr x0, empty_str_60
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_60
    mov x8, #64
    svc #0
end_print_60:
    // Imprimir salto de línea
    adr x0, newline_61
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_61
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Tipo de 3.14159:
    adr x0, lit_63
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_63
    mov x8, #64
    svc #0
    adr x0, space_64
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_64
    mov x8, #64
    svc #0
    // Imprimir string: tipoDecimal
    ldr x0, [sp, #120]
    cmp x0, #0
    beq skip_print_64
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #120]
    mov x8, #64
    svc #0
    b end_print_64
skip_print_64:
    adr x0, empty_str_64
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_64
    mov x8, #64
    svc #0
end_print_64:
    // Imprimir salto de línea
    adr x0, newline_65
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_65
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Tipo de \"Hola, mundo!\":
    adr x0, lit_67
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_67
    mov x8, #64
    svc #0
    adr x0, space_68
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_68
    mov x8, #64
    svc #0
    // Imprimir string: tipoTexto
    ldr x0, [sp, #136]
    cmp x0, #0
    beq skip_print_68
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #136]
    mov x8, #64
    svc #0
    b end_print_68
skip_print_68:
    adr x0, empty_str_68
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_68
    mov x8, #64
    svc #0
end_print_68:
    // Imprimir salto de línea
    adr x0, newline_69
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_69
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Tipo de true:
    adr x0, lit_71
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_71
    mov x8, #64
    svc #0
    adr x0, space_72
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_72
    mov x8, #64
    svc #0
    // Imprimir string: tipoBooleano
    ldr x0, [sp, #152]
    cmp x0, #0
    beq skip_print_72
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #152]
    mov x8, #64
    svc #0
    b end_print_72
skip_print_72:
    adr x0, empty_str_72
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_72
    mov x8, #64
    svc #0
end_print_72:
    // Imprimir salto de línea
    adr x0, newline_73
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_73
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Tipo de []int{1, 2, 3}:
    adr x0, lit_75
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_75
    mov x8, #64
    svc #0
    adr x0, space_76
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_76
    mov x8, #64
    svc #0
    // Imprimir string: tipoSlice
    ldr x0, [sp, #160]
    cmp x0, #0
    beq skip_print_76
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #160]
    mov x8, #64
    svc #0
    b end_print_76
skip_print_76:
    adr x0, empty_str_76
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_76
    mov x8, #64
    svc #0
end_print_76:
    // Imprimir salto de línea
    adr x0, newline_77
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_77
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: tipoEntero=="int"&&tipoDecimal=="float64"&&tipoTexto=="string"&&tipoBooleano=="bool"&&tipoSlice=="[]int"
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_78
    // Bloque if (then)
    b endif_78
else_78:
    // Bloque else
endif_78:

    // Procesando nodo: Condicion  Valor=tipoEntero=="int"&&tipoDecimal=="float64"&&tipoTexto=="string"&&tipoBooleano=="bool"&&tipoSlice=="[]int"

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 1 a puntosTypeOf (int) en [sp, #88]
    mov x9, #1
    str x9, [sp, #88]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK reflect.TypeOf: correcto
    adr x0, lit_80
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_80
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_80
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_80
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 10 a puntos (int) en [sp, #24]
    mov x9, #10
    str x9, [sp, #24]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\= Tabla de Resultados \=\=\=
    adr x0, lit_82
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_82
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_82
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_82
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +----------------------------------+--------+-------+
    adr x0, lit_84
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_84
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_84
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_84
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | Característica                   | Puntos | Total |
    adr x0, lit_86
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_86
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_86
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_86
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +----------------------------------+--------+-------+
    adr x0, lit_88
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_88
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_88
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_88
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | Funciones sin parámetros         | 
    adr x0, lit_90
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_90
    mov x8, #64
    svc #0
    adr x0, space_91
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_91
    mov x8, #64
    svc #0
    // Imprimir entero: puntosFuncionesSimples
    ldr x0, [sp, #32]
    adr x1, int_buffer_91
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_91
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_93
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 5     |
    adr x0, lit_94
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_94
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_94
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_94
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | strconv.Atoi                     | 
    adr x0, lit_96
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_96
    mov x8, #64
    svc #0
    adr x0, space_97
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_97
    mov x8, #64
    svc #0
    // Imprimir entero: puntosAtoi
    ldr x0, [sp, #48]
    adr x1, int_buffer_97
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_97
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_99
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 2     |
    adr x0, lit_100
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_100
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_100
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_100
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | strconv.ParseFloat               | 
    adr x0, lit_102
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_102
    mov x8, #64
    svc #0
    adr x0, space_103
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_103
    mov x8, #64
    svc #0
    // Imprimir entero: puntosParseFloat
    ldr x0, [sp, #64]
    adr x1, int_buffer_103
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_103
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_105
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 2     |
    adr x0, lit_106
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_106
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_106
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_106
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | reflect.TypeOf                   | 
    adr x0, lit_108
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_108
    mov x8, #64
    svc #0
    adr x0, space_109
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_109
    mov x8, #64
    svc #0
    // Imprimir entero: puntosTypeOf
    ldr x0, [sp, #88]
    adr x1, int_buffer_109
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_109
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_111
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 1     |
    adr x0, lit_112
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_112
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_112
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_112
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +----------------------------------+--------+-------+
    adr x0, lit_114
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_114
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_114
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_114
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | TOTAL                            | 
    adr x0, lit_116
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_116
    mov x8, #64
    svc #0
    adr x0, space_117
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_117
    mov x8, #64
    svc #0
    // Imprimir entero: puntos
    ldr x0, [sp, #24]
    adr x1, int_buffer_117
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_117
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_119
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:    | 25    |
    adr x0, lit_120
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_120
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_120
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_120
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +----------------------------------+--------+-------+
    adr x0, lit_122
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_122
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_122
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_122
    mov x8, #64
    svc #0

    // Saltar directamente al final del programa
    b program_exit

// Rutinas auxiliares

string_copy:
    // x0 = destino, x1 = origen
    cmp x1, #0
    beq string_copy_null
    mov x2, x0
string_copy_loop:
    ldrb w3, [x1], #1
    strb w3, [x0], #1
    cmp w3, #0
    bne string_copy_loop
    sub x0, x0, #1
    ret
string_copy_null:
    // Si origen es NULL, simplemente poner terminador nulo en destino
    mov w3, #0
    strb w3, [x0]
    ret
int_to_string:
    // x0 = número, x1 = buffer
    mov x9, x0        // Guardar número original
    mov x10, x1       // Guardar dirección original del buffer
    mov x11, #0       // Contador de dígitos
    mov x12, #0       // Para contar dígitos totales
    mov x14, #0       // Flag para indicar si es negativo
    cmp x9, #0
    bne count_digits
    mov w2, #48       // '0'
    strb w2, [x10]
    mov w2, #0        // Null-terminator
    strb w2, [x10, #1]
    mov x0, #1
    ret
    // Verificar si es negativo
    cmp x9, #0
    bge positive_number
    // Es negativo, imprimir '-'
    neg x9, x9     // Convertir a positivo
    mov w2, #45    // '-' en ASCII
    strb w2, [x10], #1
    mov x14, #1    // Flag para indicar que es negativo (afectará a la longitud final)
positive_number:
count_digits:
    mov x2, x9        // Copiar número
    mov x13, #10      // Constante 10 para división
digit_count_loop:
    cbz x2, gen_digits
    udiv x2, x2, x13  // Dividir por 10 usando registro
    add x12, x12, #1  // Incrementar contador
    b digit_count_loop
gen_digits:
    mov x11, x12      // Longitud total
    mov x2, #1        // Potencia de 10
    mov x13, #10      // Base 10
calc_power_loop:
    cmp x12, #1       // Si solo queda 1 dígito, salir
    ble extract_digits
    mul x2, x2, x13   // Multiplicar por 10
    sub x12, x12, #1  // Decrementar contador
    b calc_power_loop
extract_digits:
    mov x3, x9        // Restaurar número
    mov x12, x11      // Restaurar contador total
extract_loop:
    cbz x12, finish_str
    udiv x4, x3, x2   // x4 = número / potencia
    msub x3, x4, x2, x3 // x3 = x3 - (x4 * x2) (resto)
    add w4, w4, #48   // Convertir a ASCII
    strb w4, [x10], #1// Almacenar y avanzar
    udiv x2, x2, x13  // Reducir potencia por 10 (x13=10)
    sub x12, x12, #1  // Decrementar contador
    b extract_loop
finish_str:
    mov w2, #0        // Null-terminator
    strb w2, [x10]
    // Si era negativo, incrementar longitud por el signo
    cbz x14, return_length
    add x11, x11, #1  // Ajustar longitud por el signo '-'
return_length:
    mov x0, x11       // Retornar longitud
    ret

string_compare:
    // x0 = primera cadena, x1 = segunda cadena
    // Devuelve 0 si son iguales, no-0 si son diferentes
    // Verificar si alguna es NULL
    cmp x0, #0
    beq check_second_null
    cmp x1, #0
    beq strings_not_equal
    // Ambas no son NULL, comparar
compare_loop:
    ldrb w2, [x0], #1
    ldrb w3, [x1], #1
    cmp w2, w3
    bne strings_not_equal
    cbz w2, strings_equal
    b compare_loop
check_second_null:
    cmp x1, #0
    beq strings_equal
strings_not_equal:
    mov x0, #1
    ret
strings_equal:
    mov x0, #0
    ret

string_length:
    // x0 = dirección de la cadena
    cmp x0, #0
    beq string_length_null
    mov x2, x0
length_loop:
    ldrb w1, [x0], #1  // cargar byte y avanzar
    cmp w1, #0         // comparar con null
    bne length_loop    // continuar si no es null
    sub x0, x0, x2     // calcular longitud
    sub x0, x0, #1     // ajustar por null
    ret
string_length_null:
    mov x0, #0         // Retornar 0 para cadenas NULL
    ret

float_to_string:
    // Implementación mejorada
    stp x29, x30, [sp, #-16]!
    mov x29, sp
    stp x19, x20, [sp, #-16]!
    mov x19, x0                // Buffer address

    // Extraer signo
    mov x21, #0               // Flag para negativo
    fcmpe d0, #0.0
    bpl convert_integer
    mov x21, #1               // Es negativo
    fneg d0, d0               // Convertir a positivo
    mov w1, #45               // '-'
    strb w1, [x19], #1
convert_integer:
    // Convertir parte entera
    fcvtzs x0, d0             // Convertir a entero
    mov x1, x19               // Buffer para la parte entera
    bl int_to_string          // Convertir entero
    mov x20, x0               // Guardar longitud
    cmp x21, #1               // Si era negativo
    beq was_negative
    add x19, x19, x0          // Avanzar buffer
    b add_decimal
was_negative:
    add x19, x19, x0          // Avanzar buffer
    add x20, x20, #1          // +1 por el signo
add_decimal:
    // Añadir punto
    mov w1, #'.'
    strb w1, [x19], #1
    add x20, x20, #1

    // Convertir 6 dígitos decimales
    fcvtzs x0, d0             // Volver a convertir a entero
    scvtf d1, x0              // Convertir entero a float
    fsub d1, d0, d1           // Parte decimal = float - entero
    mov x22, #2               // 6 dígitos decimales
    fmov d2, #10.0            // Constante 10.0
decimal_loop:
    fmul d1, d1, d2           // d1 = d1 * 10
    fcvtzs x0, d1             // Entero = int(d1)
    add w0, w0, #48           // Convertir a ASCII
    strb w0, [x19], #1        // Guardar y avanzar
    add x20, x20, #1          // Incrementar longitud
    scvtf d3, x0              // Convertir dígito a flotante
    mov x0, #48               // Valor ASCII '0'
    scvtf d4, x0              // Convertir 48 a float
    fsub d3, d3, d4           // Restar ASCII offset
    fsub d1, d1, d3           // Restar dígito
    subs x22, x22, #1         // Decrementar contador
    bne decimal_loop          // Continuar si no hemos terminado
    // Terminar cadena
    mov w1, #0
    strb w1, [x19]

    // Retornar longitud total
    mov x0, x20
    ldp x19, x20, [sp], #16
    ldp x29, x30, [sp], #16
    ret

program_exit:
    // Terminar programa
    mov sp, x29
    ldp x29, x30, [sp], #16
    mov x8, #93     // exit syscall
    mov x0, #0      // exit code 0
    svc #0          // supervisor call
