.data
float_0: .double 0
str_1: .asciz ""
float_2: .double 2.71
str_3: .asciz "Adios!"
lit_5: .asciz "\=\=\= Prueba de Características Avanzadas \=\=\="
newline_5: .asciz "\n"
lit_7: .asciz "\=\=\=\= Declaración sin valor inicial \=\=\=\="
newline_7: .asciz "\n"
lit_9: .asciz "enteroSinValor:"
space_10: .asciz " "
int_buffer_10: .space 20
newline_11: .asciz "\n"
lit_13: .asciz "decimalSinValor:"
space_14: .asciz " "
float_buffer_14: .space 30
newline_15: .asciz "\n"
lit_17: .asciz "textoSinValor:"
space_18: .asciz " "
newline_18: .asciz "\n"
lit_20: .asciz "booleanoSinValor:"
space_21: .asciz " "
true_str_22: .asciz "true"
false_str_23: .asciz "false"
newline_23: .asciz "\n"
lit_25: .asciz "\n\=\=\=\= Declaración con inferencia de tipo \=\=\=\="
newline_25: .asciz "\n"
lit_27: .asciz "enteroInferido:"
space_28: .asciz " "
int_buffer_28: .space 20
newline_29: .asciz "\n"
lit_31: .asciz "decimalInferido:"
space_32: .asciz " "
float_buffer_32: .space 30
newline_33: .asciz "\n"
lit_35: .asciz "textoInferido:"
space_36: .asciz " "
newline_36: .asciz "\n"
lit_38: .asciz "booleanoInferido:"
space_39: .asciz " "
true_str_40: .asciz "true"
false_str_41: .asciz "false"
newline_41: .asciz "\n"
lit_43: .asciz "\n\=\=\=\= Asignación de variables \=\=\=\="
newline_43: .asciz "\n"
lit_45: .asciz "Después de asignación simple:"
newline_45: .asciz "\n"
lit_47: .asciz "enteroInferido:"
space_48: .asciz " "
int_buffer_48: .space 20
newline_49: .asciz "\n"
lit_51: .asciz "decimalInferido:"
space_52: .asciz " "
float_buffer_52: .space 30
newline_53: .asciz "\n"
lit_55: .asciz "textoInferido:"
space_56: .asciz " "
newline_56: .asciz "\n"
lit_58: .asciz "booleanoInferido:"
space_59: .asciz " "
true_str_60: .asciz "true"
false_str_61: .asciz "false"
newline_61: .asciz "\n"
lit_63: .asciz "\n\=\=\=\= Operaciones con variables \=\=\=\="
newline_63: .asciz "\n"
lit_65: .asciz "Después de operaciones:"
newline_65: .asciz "\n"
lit_67: .asciz "enteroInferido + 50:"
space_68: .asciz " "
int_buffer_68: .space 20
newline_69: .asciz "\n"
lit_71: .asciz "decimalInferido * 2:"
space_72: .asciz " "
float_buffer_72: .space 30
newline_73: .asciz "\n"
lit_75: .asciz "textoInferido + '!':"
space_76: .asciz " "
newline_76: .asciz "\n"
lit_78: .asciz "!booleanoInferido:"
space_79: .asciz " "
true_str_80: .asciz "true"
false_str_81: .asciz "false"
newline_81: .asciz "\n"

// ARM64 Assembly
.text
.global _start
_start:
    stp x29, x30, [sp, #-16]!
    mov x29, sp
    sub sp, sp, #128

    // Declaraciones de variables
    // Debug: Símbolos en tabla: 9
    // Símbolo: '1', Tipo: 'Función', Dato: 'void'

    // Declaración de variable: main
    // Símbolo: '4', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: enteroSinValor
    mov x9, #0
    str x9, [sp, #16]
    // Símbolo: '7', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: decimalSinValor
    adr x9, float_0
    ldr d0, [x9]
    str d0, [sp, #24]
    // Símbolo: '10', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: textoSinValor
    adr x9, str_1
    str x9, [sp, #32]
    // Símbolo: '13', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: booleanoSinValor
    mov x9, #0
    str x9, [sp, #40]
    // Símbolo: '16', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: enteroInferido
    mov x9, #100
    str x9, [sp, #48]
    // Símbolo: '19', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: decimalInferido
    adr x9, float_2
    ldr d0, [x9]
    str d0, [sp, #56]
    // Símbolo: '22', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: textoInferido
    adr x9, str_3
    str x9, [sp, #64]
    // Símbolo: '25', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: booleanoInferido
    mov x9, #0
    str x9, [sp, #72]

    // Procesando instrucciones

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor==== Prueba de Características Avanzadas ===
    // Generando código para imprimir: === Prueba de Características Avanzadas ===

    // fmt.Println
    // Imprimir literal: \=\=\= Prueba de Características Avanzadas \=\=\=
    mov x0, #1
    adr x1, lit_5
    mov x2, #49
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_5
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor===== Declaración sin valor inicial ====
    // Generando código para imprimir: ==== Declaración sin valor inicial ====

    // fmt.Println
    // Imprimir literal: \=\=\=\= Declaración sin valor inicial \=\=\=\=
    mov x0, #1
    adr x1, lit_7
    mov x2, #47
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_7
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=enteroSinValor:
    // Argumento: tipo=Argumento, valor=enteroSinValor
    // Generando código para imprimir: enteroSinValor:, enteroSinValor

    // fmt.Println
    // Imprimir literal: enteroSinValor:
    mov x0, #1
    adr x1, lit_9
    mov x2, #15
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_10
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir entero: enteroSinValor
    ldr x0, [sp, #16]
    adr x1, int_buffer_10
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_10
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_11
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=decimalSinValor:
    // Argumento: tipo=Argumento, valor=decimalSinValor
    // Generando código para imprimir: decimalSinValor:, decimalSinValor

    // fmt.Println
    // Imprimir literal: decimalSinValor:
    mov x0, #1
    adr x1, lit_13
    mov x2, #16
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_14
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir flotante: decimalSinValor
    ldr d0, [sp, #24]
    adr x0, float_buffer_14
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_14
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_15
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=textoSinValor:
    // Argumento: tipo=Argumento, valor=textoSinValor
    // Generando código para imprimir: textoSinValor:, textoSinValor

    // fmt.Println
    // Imprimir literal: textoSinValor:
    mov x0, #1
    adr x1, lit_17
    mov x2, #14
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_18
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir string: textoSinValor
    ldr x0, [sp, #32]
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #32]
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_18
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=booleanoSinValor:
    // Argumento: tipo=Argumento, valor=booleanoSinValor
    // Generando código para imprimir: booleanoSinValor:, booleanoSinValor

    // fmt.Println
    // Imprimir literal: booleanoSinValor:
    mov x0, #1
    adr x1, lit_20
    mov x2, #17
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_21
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir booleano: booleanoSinValor
    ldr x0, [sp, #40]
    cmp x0, #0
    beq print_false_23
    mov x0, #1
    adr x1, true_str_22
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_23
print_false_23:
    mov x0, #1
    adr x1, false_str_23
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_23:
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_23
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=\n==== Declaración con inferencia de tipo ====
    // Generando código para imprimir: \n==== Declaración con inferencia de tipo ====

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= Declaración con inferencia de tipo \=\=\=\=
    mov x0, #1
    adr x1, lit_25
    mov x2, #53
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_25
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=enteroInferido:
    // Argumento: tipo=Argumento, valor=enteroInferido
    // Generando código para imprimir: enteroInferido:, enteroInferido

    // fmt.Println
    // Imprimir literal: enteroInferido:
    mov x0, #1
    adr x1, lit_27
    mov x2, #15
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_28
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir entero: enteroInferido
    ldr x0, [sp, #48]
    adr x1, int_buffer_28
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_28
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_29
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=decimalInferido:
    // Argumento: tipo=Argumento, valor=decimalInferido
    // Generando código para imprimir: decimalInferido:, decimalInferido

    // fmt.Println
    // Imprimir literal: decimalInferido:
    mov x0, #1
    adr x1, lit_31
    mov x2, #16
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_32
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir flotante: decimalInferido
    ldr d0, [sp, #56]
    adr x0, float_buffer_32
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_32
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_33
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=textoInferido:
    // Argumento: tipo=Argumento, valor=textoInferido
    // Generando código para imprimir: textoInferido:, textoInferido

    // fmt.Println
    // Imprimir literal: textoInferido:
    mov x0, #1
    adr x1, lit_35
    mov x2, #14
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_36
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir string: textoInferido
    ldr x0, [sp, #64]
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #64]
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_36
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=booleanoInferido:
    // Argumento: tipo=Argumento, valor=booleanoInferido
    // Generando código para imprimir: booleanoInferido:, booleanoInferido

    // fmt.Println
    // Imprimir literal: booleanoInferido:
    mov x0, #1
    adr x1, lit_38
    mov x2, #17
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_39
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir booleano: booleanoInferido
    ldr x0, [sp, #72]
    cmp x0, #0
    beq print_false_41
    mov x0, #1
    adr x1, true_str_40
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_41
print_false_41:
    mov x0, #1
    adr x1, false_str_41
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_41:
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_41
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=\n==== Asignación de variables ====
    // Generando código para imprimir: \n==== Asignación de variables ====

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= Asignación de variables \=\=\=\=
    mov x0, #1
    adr x1, lit_43
    mov x2, #42
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_43
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=Después de asignación simple:
    // Generando código para imprimir: Después de asignación simple:

    // fmt.Println
    // Imprimir literal: Después de asignación simple:
    mov x0, #1
    adr x1, lit_45
    mov x2, #29
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_45
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=enteroInferido:
    // Argumento: tipo=Argumento, valor=enteroInferido
    // Generando código para imprimir: enteroInferido:, enteroInferido

    // fmt.Println
    // Imprimir literal: enteroInferido:
    mov x0, #1
    adr x1, lit_47
    mov x2, #15
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_48
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir entero: enteroInferido
    ldr x0, [sp, #48]
    adr x1, int_buffer_48
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_48
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_49
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=decimalInferido:
    // Argumento: tipo=Argumento, valor=decimalInferido
    // Generando código para imprimir: decimalInferido:, decimalInferido

    // fmt.Println
    // Imprimir literal: decimalInferido:
    mov x0, #1
    adr x1, lit_51
    mov x2, #16
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_52
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir flotante: decimalInferido
    ldr d0, [sp, #56]
    adr x0, float_buffer_52
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_52
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_53
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=textoInferido:
    // Argumento: tipo=Argumento, valor=textoInferido
    // Generando código para imprimir: textoInferido:, textoInferido

    // fmt.Println
    // Imprimir literal: textoInferido:
    mov x0, #1
    adr x1, lit_55
    mov x2, #14
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_56
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir string: textoInferido
    ldr x0, [sp, #64]
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #64]
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_56
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=booleanoInferido:
    // Argumento: tipo=Argumento, valor=booleanoInferido
    // Generando código para imprimir: booleanoInferido:, booleanoInferido

    // fmt.Println
    // Imprimir literal: booleanoInferido:
    mov x0, #1
    adr x1, lit_58
    mov x2, #17
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_59
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir booleano: booleanoInferido
    ldr x0, [sp, #72]
    cmp x0, #0
    beq print_false_61
    mov x0, #1
    adr x1, true_str_60
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_61
print_false_61:
    mov x0, #1
    adr x1, false_str_61
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_61:
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_61
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=\n==== Operaciones con variables ====
    // Generando código para imprimir: \n==== Operaciones con variables ====

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= Operaciones con variables \=\=\=\=
    mov x0, #1
    adr x1, lit_63
    mov x2, #44
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_63
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=Después de operaciones:
    // Generando código para imprimir: Después de operaciones:

    // fmt.Println
    // Imprimir literal: Después de operaciones:
    mov x0, #1
    adr x1, lit_65
    mov x2, #23
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_65
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=enteroInferido + 50:
    // Argumento: tipo=Argumento, valor=enteroInferido
    // Generando código para imprimir: enteroInferido + 50:, enteroInferido

    // fmt.Println
    // Imprimir literal: enteroInferido + 50:
    mov x0, #1
    adr x1, lit_67
    mov x2, #20
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_68
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir entero: enteroInferido
    ldr x0, [sp, #48]
    adr x1, int_buffer_68
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_68
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_69
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=decimalInferido * 2:
    // Argumento: tipo=Argumento, valor=decimalInferido
    // Generando código para imprimir: decimalInferido * 2:, decimalInferido

    // fmt.Println
    // Imprimir literal: decimalInferido * 2:
    mov x0, #1
    adr x1, lit_71
    mov x2, #20
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_72
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir flotante: decimalInferido
    ldr d0, [sp, #56]
    adr x0, float_buffer_72
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_72
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_73
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=textoInferido + '!':
    // Argumento: tipo=Argumento, valor=textoInferido
    // Generando código para imprimir: textoInferido + '!':, textoInferido

    // fmt.Println
    // Imprimir literal: textoInferido + '!':
    mov x0, #1
    adr x1, lit_75
    mov x2, #20
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_76
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir string: textoInferido
    ldr x0, [sp, #64]
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #64]
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_76
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=!booleanoInferido:
    // Argumento: tipo=Argumento, valor=booleanoInferido
    // Generando código para imprimir: !booleanoInferido:, booleanoInferido

    // fmt.Println
    // Imprimir literal: !booleanoInferido:
    mov x0, #1
    adr x1, lit_78
    mov x2, #18
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_79
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir booleano: booleanoInferido
    ldr x0, [sp, #72]
    cmp x0, #0
    beq print_false_81
    mov x0, #1
    adr x1, true_str_80
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_81
print_false_81:
    mov x0, #1
    adr x1, false_str_81
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_81:
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_81
    mov x2, #1
    mov x8, #64
    svc #0

    // Saltar directamente al final del programa
    b program_exit

// Rutinas auxiliares
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

string_length:
    // x0 = dirección de la cadena
    mov x2, x0     // guardar dirección original
length_loop:
    ldrb w1, [x0], #1  // cargar byte y avanzar
    cmp w1, #0         // comparar con null
    bne length_loop    // continuar si no es null
    sub x0, x0, x2     // calcular longitud
    sub x0, x0, #1     // ajustar por null
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
    mov x22, #6               // 6 dígitos decimales
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
    