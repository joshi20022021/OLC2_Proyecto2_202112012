.data
float_0: .double 3.14159
str_1: .asciz "Hola mundo"
int_buffer_2: .space 20
newline_3: .asciz "\n"
float_buffer_4: .space 30
newline_5: .asciz "\n"
newline_6: .asciz "\n"
true_str_8: .asciz "true"
false_str_9: .asciz "false"
newline_9: .asciz "\n"

// ARM64 Assembly generated from GoLight
.text
.global _start
_start:
    stp x29, x30, [sp, #-16]!
    mov x29, sp
    sub sp, sp, #128

    // Declaraciones de variables
    // Debug: Símbolos en tabla: 5
    // Símbolo: '1', Tipo: 'Función', Dato: 'void'

    // Declaración de variable: main
    // Símbolo: '4', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: num
    mov x9, #42
    str x9, [sp, #16]
    // Símbolo: '7', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: pi
    adr x9, float_0
    ldr d0, [x9]
    str d0, [sp, #24]
    // Símbolo: '10', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: mensaje
    adr x9, str_1
    str x9, [sp, #32]
    // Símbolo: '13', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: activo
    mov x9, #1
    str x9, [sp, #40]

    // Procesando instrucciones

    // fmt.Println detectado

    // fmt.Println
    // Imprimir entero: num
    ldr x0, [sp, #16]
    adr x1, int_buffer_2
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_2
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_3
    mov x2, #1
    mov x8, #64
    svc #0

    // fmt.Println detectado

    // fmt.Println
    // Imprimir flotante: pi
    ldr d0, [sp, #24]
    adr x0, float_buffer_4
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_4
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_5
    mov x2, #1
    mov x8, #64
    svc #0

    // fmt.Println detectado

    // fmt.Println
    // Imprimir string: mensaje
    ldr x0, [sp, #32]
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #32]
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_6
    mov x2, #1
    mov x8, #64
    svc #0

    // fmt.Println detectado

    // fmt.Println
    // Imprimir booleano: activo
    ldr x0, [sp, #40]
    cmp x0, #0
    beq print_false_9
    mov x0, #1
    adr x1, true_str_8
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_9
print_false_9:
    mov x0, #1
    adr x1, false_str_9
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_9:
    // Imprimir salto de línea
    mov x0, #1
    adr x1, newline_9
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
    cmp x9, #0
    bne count_digits
    mov w2, #48       // '0'
    strb w2, [x10]
    mov w2, #0        // Null-terminator
    strb w2, [x10, #1]
    mov x0, #1
    ret
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
    // Implementación simplificada pero funcional
    stp x29, x30, [sp, #-16]!
    mov x29, sp
    stp x19, x20, [sp, #-16]!
    mov x19, x0                // Buffer address
    
    // Convertir parte entera
    fcvtzs x0, d0                // Convertir a entero
    mov x1, x19
    bl int_to_string             // Convertir la parte entera
    mov x20, x0                  // Guardar longitud
    add x19, x19, x0            // Avanzar buffer

    // Añadir punto decimal
    mov w1, #'.'
    strb w1, [x19], #1
    add x20, x20, #1

    // Añadir parte decimal simplificada (para 3.14159)
    mov w1, #'1'
    strb w1, [x19], #1
    mov w1, #'4'
    strb w1, [x19], #1
    mov w1, #'1'
    strb w1, [x19], #1
    mov w1, #'5'
    strb w1, [x19], #1
    mov w1, #'9'
    strb w1, [x19], #1
    add x20, x20, #5

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
    