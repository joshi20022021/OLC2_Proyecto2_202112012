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
float_9: .double 5
lit_11: .asciz "\n\=\=\=\= strconv.Atoi \=\=\=\="
newline_11: .asciz "\n"
lit_13: .asciz "Conversión de string a int:"
newline_13: .asciz "\n"
lit_15: .asciz "\"123\" convertido a int:"
space_16: .asciz " "
int_buffer_16: .space 20
newline_17: .asciz "\n"
lit_20: .asciz "OK strconv.Atoi: correcto"
newline_20: .asciz "\n"
lit_22: .asciz "\n\=\=\=\= strconv.ParseFloat \=\=\=\="
newline_22: .asciz "\n"
lit_24: .asciz "Conversión de string a float64:"
newline_24: .asciz "\n"
lit_26: .asciz "\"123.45\" convertido a float64:"
space_27: .asciz " "
float_buffer_27: .space 30
newline_28: .asciz "\n"
lit_30: .asciz "\"123\" convertido a float64:"
space_31: .asciz " "
float_buffer_31: .space 30
newline_32: .asciz "\n"
lit_35: .asciz "OK strconv.ParseFloat: correcto"
newline_35: .asciz "\n"
lit_37: .asciz "\n\=\=\=\= reflect.TypeOf \=\=\=\="
newline_37: .asciz "\n"
lit_39: .asciz "Obtener tipo de datos:"
newline_39: .asciz "\n"
lit_41: .asciz "Tipo de 42:"
space_42: .asciz " "
empty_str_42: .asciz ""
newline_43: .asciz "\n"
lit_45: .asciz "Tipo de 3.14159:"
space_46: .asciz " "
empty_str_46: .asciz ""
newline_47: .asciz "\n"
lit_49: .asciz "Tipo de \"Hola. mundo!\":"
space_50: .asciz " "
empty_str_50: .asciz ""
newline_51: .asciz "\n"
lit_53: .asciz "Tipo de true:"
space_54: .asciz " "
empty_str_54: .asciz ""
newline_55: .asciz "\n"
lit_57: .asciz "Tipo de []int{1. 2. 3}:"
space_58: .asciz " "
empty_str_58: .asciz ""
newline_59: .asciz "\n"
lit_62: .asciz "OK reflect.TypeOf: correcto"
newline_62: .asciz "\n"
lit_64: .asciz "\n\=\=\= Tabla de Resultados \=\=\="
newline_64: .asciz "\n"
lit_66: .asciz "+----------------------------------+--------+-------+"
newline_66: .asciz "\n"
lit_68: .asciz "| Característica                   | Puntos | Total |"
newline_68: .asciz "\n"
lit_70: .asciz "+----------------------------------+--------+-------+"
newline_70: .asciz "\n"
lit_72: .asciz "| strconv.Atoi                     | "
space_73: .asciz " "
int_buffer_73: .space 20
space_75: .asciz " "
lit_76: .asciz "    | 2     |"
newline_76: .asciz "\n"
lit_78: .asciz "| strconv.ParseFloat               | "
space_79: .asciz " "
int_buffer_79: .space 20
space_81: .asciz " "
lit_82: .asciz "    | 2     |"
newline_82: .asciz "\n"
lit_84: .asciz "| reflect.TypeOf                   | "
space_85: .asciz " "
int_buffer_85: .space 20
space_87: .asciz " "
lit_88: .asciz "    | 1     |"
newline_88: .asciz "\n"
lit_90: .asciz "+----------------------------------+--------+-------+"
newline_90: .asciz "\n"
lit_92: .asciz "| TOTAL                            | "
space_93: .asciz " "
float_buffer_93: .space 30
space_95: .asciz " "
lit_96: .asciz "   | 25    |"
newline_96: .asciz "\n"
lit_98: .asciz "+----------------------------------+--------+-------+"
newline_98: .asciz "\n"

// ARM64 Assembly
.text
.global _start
_start:
    stp x29, x30, [sp, #-16]!
    mov x29, sp
    sub sp, sp, #512

    // Declaraciones de variables
    // Debug: Símbolos en tabla: 18
    // Símbolo: '273', Tipo: 'Función', Dato: 'void'

    // Declaración de variable: main
    // Símbolo: '276', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosAtoi
    mov x9, #0
    str x9, [sp, #16]
    // Símbolo: '279', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: numeroEntero
    mov x9, #123
    str x9, [sp, #24]
    // Símbolo: '282', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosParseFloat
    mov x9, #0
    str x9, [sp, #32]
    // Símbolo: '285', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: numeroDecimal1
    adr x9, float_0
    ldr d0, [x9]
    str d0, [sp, #40]
    // Símbolo: '288', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: numeroDecimal2
    adr x9, float_1
    ldr d0, [x9]
    str d0, [sp, #48]
    // Símbolo: '291', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosTypeOf
    mov x9, #0
    str x9, [sp, #56]
    // Símbolo: '294', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: entero
    mov x9, #42
    str x9, [sp, #64]
    // Símbolo: '297', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: tipoEntero
    adr x9, str_2
    str x9, [sp, #72]
    // Símbolo: '300', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: decimal
    adr x9, float_3
    ldr d0, [x9]
    str d0, [sp, #80]
    // Símbolo: '303', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: tipoDecimal
    adr x9, str_4
    str x9, [sp, #88]
    // Símbolo: '306', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: texto
    adr x9, str_5
    str x9, [sp, #96]
    // Símbolo: '309', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: tipoTexto
    adr x9, str_6
    str x9, [sp, #104]
    // Símbolo: '312', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: booleano
    mov x9, #1
    str x9, [sp, #112]
    // Símbolo: '315', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: tipoBooleano
    adr x9, str_7
    str x9, [sp, #120]
    // Símbolo: '318', Tipo: 'Variable', Dato: '[]int'

    // Declaración de variable: slice
    // Símbolo: '321', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: tipoSlice
    adr x9, str_8
    str x9, [sp, #128]
    // Símbolo: '323', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: puntos
    adr x9, float_9
    ldr d0, [x9]
    str d0, [sp, #136]

    // Procesando instrucciones

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= strconv.Atoi \=\=\=\=
    adr x0, lit_11
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_11
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_11
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_11
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Conversión de string a int:
    adr x0, lit_13
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_13
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_13
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_13
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \"123\" convertido a int:
    adr x0, lit_15
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_15
    mov x8, #64
    svc #0
    adr x0, space_16
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_16
    mov x8, #64
    svc #0
    // Imprimir entero: numeroEntero
    ldr x0, [sp, #24]
    adr x1, int_buffer_16
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_16
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_17
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_17
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: numeroEntero==123
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_18
    // Bloque if (then)
    b endif_18
else_18:
    // Bloque else
endif_18:

    // Procesando nodo: Condicion  Valor=numeroEntero==123

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosAtoi (int) en [sp, #16]
    mov x9, #2
    str x9, [sp, #16]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK strconv.Atoi: correcto
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
    // Imprimir literal: \n\=\=\=\= strconv.ParseFloat \=\=\=\=
    adr x0, lit_22
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_22
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_22
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_22
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Conversión de string a float64:
    adr x0, lit_24
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_24
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

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \"123.45\" convertido a float64:
    adr x0, lit_26
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_26
    mov x8, #64
    svc #0
    adr x0, space_27
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_27
    mov x8, #64
    svc #0
    // Imprimir flotante: numeroDecimal1
    ldr d0, [sp, #40]
    adr x0, float_buffer_27
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_27
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_28
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_28
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \"123\" convertido a float64:
    adr x0, lit_30
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_30
    mov x8, #64
    svc #0
    adr x0, space_31
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_31
    mov x8, #64
    svc #0
    // Imprimir flotante: numeroDecimal2
    ldr d0, [sp, #48]
    adr x0, float_buffer_31
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_31
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_32
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_32
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: numeroDecimal1==123.45&&numeroDecimal2==123.0
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_33
    // Bloque if (then)
    b endif_33
else_33:
    // Bloque else
endif_33:

    // Procesando nodo: Condicion  Valor=numeroDecimal1==123.45&&numeroDecimal2==123.0

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosParseFloat (int) en [sp, #32]
    mov x9, #2
    str x9, [sp, #32]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK strconv.ParseFloat: correcto
    adr x0, lit_35
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_35
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

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= reflect.TypeOf \=\=\=\=
    adr x0, lit_37
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_37
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_37
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_37
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Obtener tipo de datos:
    adr x0, lit_39
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_39
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_39
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_39
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Tipo de 42:
    adr x0, lit_41
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_41
    mov x8, #64
    svc #0
    adr x0, space_42
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_42
    mov x8, #64
    svc #0
    // Imprimir string: tipoEntero
    ldr x0, [sp, #72]
    cmp x0, #0
    beq skip_print_42
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #72]
    mov x8, #64
    svc #0
    b end_print_42
skip_print_42:
    adr x0, empty_str_42
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_42
    mov x8, #64
    svc #0
end_print_42:
    // Imprimir salto de línea
    adr x0, newline_43
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_43
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Tipo de 3.14159:
    adr x0, lit_45
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_45
    mov x8, #64
    svc #0
    adr x0, space_46
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_46
    mov x8, #64
    svc #0
    // Imprimir string: tipoDecimal
    ldr x0, [sp, #88]
    cmp x0, #0
    beq skip_print_46
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #88]
    mov x8, #64
    svc #0
    b end_print_46
skip_print_46:
    adr x0, empty_str_46
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_46
    mov x8, #64
    svc #0
end_print_46:
    // Imprimir salto de línea
    adr x0, newline_47
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_47
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Tipo de \"Hola, mundo!\":
    adr x0, lit_49
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_49
    mov x8, #64
    svc #0
    adr x0, space_50
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_50
    mov x8, #64
    svc #0
    // Imprimir string: tipoTexto
    ldr x0, [sp, #104]
    cmp x0, #0
    beq skip_print_50
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #104]
    mov x8, #64
    svc #0
    b end_print_50
skip_print_50:
    adr x0, empty_str_50
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_50
    mov x8, #64
    svc #0
end_print_50:
    // Imprimir salto de línea
    adr x0, newline_51
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_51
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Tipo de true:
    adr x0, lit_53
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_53
    mov x8, #64
    svc #0
    adr x0, space_54
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_54
    mov x8, #64
    svc #0
    // Imprimir string: tipoBooleano
    ldr x0, [sp, #120]
    cmp x0, #0
    beq skip_print_54
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #120]
    mov x8, #64
    svc #0
    b end_print_54
skip_print_54:
    adr x0, empty_str_54
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_54
    mov x8, #64
    svc #0
end_print_54:
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
    // Imprimir literal: Tipo de []int{1, 2, 3}:
    adr x0, lit_57
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_57
    mov x8, #64
    svc #0
    adr x0, space_58
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_58
    mov x8, #64
    svc #0
    // Imprimir string: tipoSlice
    ldr x0, [sp, #128]
    cmp x0, #0
    beq skip_print_58
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #128]
    mov x8, #64
    svc #0
    b end_print_58
skip_print_58:
    adr x0, empty_str_58
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_58
    mov x8, #64
    svc #0
end_print_58:
    // Imprimir salto de línea
    adr x0, newline_59
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_59
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: tipoEntero=="int"&&tipoDecimal=="float64"&&tipoTexto=="string"&&tipoBooleano=="bool"&&tipoSlice=="[]int"
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_60
    // Bloque if (then)
    b endif_60
else_60:
    // Bloque else
endif_60:

    // Procesando nodo: Condicion  Valor=tipoEntero=="int"&&tipoDecimal=="float64"&&tipoTexto=="string"&&tipoBooleano=="bool"&&tipoSlice=="[]int"

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 1 a puntosTypeOf (int) en [sp, #56]
    mov x9, #1
    str x9, [sp, #56]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK reflect.TypeOf: correcto
    adr x0, lit_62
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_62
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_62
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_62
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\= Tabla de Resultados \=\=\=
    adr x0, lit_64
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_64
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_64
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_64
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +----------------------------------+--------+-------+
    adr x0, lit_66
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_66
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_66
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_66
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | Característica                   | Puntos | Total |
    adr x0, lit_68
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_68
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_68
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_68
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +----------------------------------+--------+-------+
    adr x0, lit_70
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_70
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_70
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_70
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | strconv.Atoi                     | 
    adr x0, lit_72
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_72
    mov x8, #64
    svc #0
    adr x0, space_73
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_73
    mov x8, #64
    svc #0
    // Imprimir entero: puntosAtoi
    ldr x0, [sp, #16]
    adr x1, int_buffer_73
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_73
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_75
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 2     |
    adr x0, lit_76
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_76
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_76
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_76
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | strconv.ParseFloat               | 
    adr x0, lit_78
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_78
    mov x8, #64
    svc #0
    adr x0, space_79
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_79
    mov x8, #64
    svc #0
    // Imprimir entero: puntosParseFloat
    ldr x0, [sp, #32]
    adr x1, int_buffer_79
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_79
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_81
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 2     |
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
    // Imprimir literal: | reflect.TypeOf                   | 
    adr x0, lit_84
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_84
    mov x8, #64
    svc #0
    adr x0, space_85
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_85
    mov x8, #64
    svc #0
    // Imprimir entero: puntosTypeOf
    ldr x0, [sp, #56]
    adr x1, int_buffer_85
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_85
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_87
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 1     |
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
    // Imprimir literal: +----------------------------------+--------+-------+
    adr x0, lit_90
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_90
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_90
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_90
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | TOTAL                            | 
    adr x0, lit_92
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_92
    mov x8, #64
    svc #0
    adr x0, space_93
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_93
    mov x8, #64
    svc #0
    // Imprimir flotante: puntos
    ldr d0, [sp, #136]
    adr x0, float_buffer_93
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_93
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_95
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:    | 25    |
    adr x0, lit_96
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_96
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_96
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_96
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +----------------------------------+--------+-------+
    adr x0, lit_98
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_98
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_98
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_98
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
