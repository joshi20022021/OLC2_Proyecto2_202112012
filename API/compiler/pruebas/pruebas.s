.data
float_0: .double 3.14
str_1: .asciz "Hola!"
lit_3: .asciz "=== Archivo de prueba básico ==="
newline_3: .asciz "\n"
lit_5: .asciz "Validaciones manuales esperadas: 4"
newline_5: .asciz "\n"
lit_7: .asciz "==== Declaración de variables ===="
newline_7: .asciz "\n"
lit_9: .asciz "Declaración explícita con tipo y valor"
newline_9: .asciz "\n"
lit_11: .asciz "\n\n###Validacion Manual"
newline_11: .asciz "\n"
lit_13: .asciz "entero:"
space_14: .asciz " "
int_buffer_14: .space 20
newline_15: .asciz "\n"
lit_17: .asciz "decimal:"
space_18: .asciz " "
float_buffer_18: .space 30
newline_19: .asciz "\n"
lit_21: .asciz "texto:"
space_22: .asciz " "
newline_22: .asciz "\n"
lit_24: .asciz "booleano:"
space_25: .asciz " "
true_str_26: .asciz "true"
false_str_27: .asciz "false"
newline_27: .asciz "\n"
lit_29: .asciz "caracter:"
space_30: .asciz " "
newline_30: .asciz "\n"
lit_32: .asciz ""
newline_32: .asciz "\n"

// ARM64 Assembly
.text
.global _start
_start:
    stp x29, x30, [sp, #-16]!
    mov x29, sp
    sub sp, sp, #128

    // Declaraciones de variables
    // Debug: Símbolos en tabla: 8
    // Símbolo: '1', Tipo: 'Función', Dato: 'void'

    // Declaración de variable: main
    // Símbolo: '4', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntos
    mov x9, #0
    str x9, [sp, #16]
    // Símbolo: '7', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosDeclaracion
    mov x9, #0
    str x9, [sp, #24]
    // Símbolo: '10', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: entero
    mov x9, #42
    str x9, [sp, #32]
    // Símbolo: '13', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: decimal
    adr x9, float_0
    ldr d0, [x9]
    str d0, [sp, #40]
    // Símbolo: '16', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: texto
    adr x9, str_1
    str x9, [sp, #48]
    // Símbolo: '19', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: booleano
    mov x9, #1
    str x9, [sp, #56]
    // Símbolo: '22', Tipo: 'Variable', Dato: 'rune'

    // Declaración de variable: caracter
    mov w9, #65
    str w9, [sp, #64]

    // Procesando instrucciones

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor==== Archivo de prueba básico ===
    // Generando código para imprimir: === Archivo de prueba básico ===

    // fmt.Println
    // Imprimir literal: === Archivo de prueba básico ===
    mov x0, #1
    adr x1, lit_3
    mov x2, #32
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_3
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=Validaciones manuales esperadas: 4
    // Generando código para imprimir: Validaciones manuales esperadas: 4

    // fmt.Println
    // Imprimir literal: Validaciones manuales esperadas: 4
    mov x0, #1
    adr x1, lit_5
    mov x2, #34
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
    // Argumento: tipo=Argumento, valor===== Declaración de variables ====
    // Generando código para imprimir: ==== Declaración de variables ====

    // fmt.Println
    // Imprimir literal: ==== Declaración de variables ====
    mov x0, #1
    adr x1, lit_7
    mov x2, #34
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
    // Argumento: tipo=Argumento, valor=Declaración explícita con tipo y valor
    // Generando código para imprimir: Declaración explícita con tipo y valor

    // fmt.Println
    // Imprimir literal: Declaración explícita con tipo y valor
    mov x0, #1
    adr x1, lit_9
    mov x2, #38
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_9
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=

###Validacion Manual
    // Generando código para imprimir: 

###Validacion Manual

    // fmt.Println
    // Imprimir literal: \n\n###Validacion Manual
    mov x0, #1
    adr x1, lit_11
    mov x2, #24
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
    // Argumento: tipo=Argumento, valor=entero:
    // Argumento: tipo=Argumento, valor=entero
    // Generando código para imprimir: entero:, entero

    // fmt.Println
    // Imprimir literal: entero:
    mov x0, #1
    adr x1, lit_13
    mov x2, #7
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_14
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir entero: entero
    ldr x0, [sp, #32]
    adr x1, int_buffer_14
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_14
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
    // Argumento: tipo=Argumento, valor=decimal:
    // Argumento: tipo=Argumento, valor=decimal
    // Generando código para imprimir: decimal:, decimal

    // fmt.Println
    // Imprimir literal: decimal:
    mov x0, #1
    adr x1, lit_17
    mov x2, #8
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_18
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir flotante: decimal
    ldr d0, [sp, #40]
    adr x0, float_buffer_18
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_18
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_19
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=texto:
    // Argumento: tipo=Argumento, valor=texto
    // Generando código para imprimir: texto:, texto

    // fmt.Println
    // Imprimir literal: texto:
    mov x0, #1
    adr x1, lit_21
    mov x2, #6
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_22
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir string: texto
    ldr x0, [sp, #48]
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #48]
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_22
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=booleano:
    // Argumento: tipo=Argumento, valor=booleano
    // Generando código para imprimir: booleano:, booleano

    // fmt.Println
    // Imprimir literal: booleano:
    mov x0, #1
    adr x1, lit_24
    mov x2, #9
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_25
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir booleano: booleano
    ldr x0, [sp, #56]
    cmp x0, #0
    beq print_false_27
    mov x0, #1
    adr x1, true_str_26
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_27
print_false_27:
    mov x0, #1
    adr x1, false_str_27
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_27:
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_27
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=caracter:
    // Argumento: tipo=Argumento, valor=caracter
    // Generando código para imprimir: caracter:, caracter

    // fmt.Println
    // Imprimir literal: caracter:
    mov x0, #1
    adr x1, lit_29
    mov x2, #9
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_30
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir rune: caracter
    mov x0, #1
    sub sp, sp, #1
    ldr w1, [sp, #64]
    strb w1, [sp]
    mov x1, sp
    mov x2, #1
    mov x8, #64
    svc #0
    add sp, sp, #1
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_30
    mov x2, #1
    mov x8, #64
    svc #0

    // Procesando nodo tipo: fmt.Println

    // fmt.Println detectado
    // Argumento: tipo=Argumento, valor=
    // Generando código para imprimir: 

    // fmt.Println
    // Imprimir literal: 
    mov x0, #1
    adr x1, lit_32
    mov x2, #0
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_32
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
    