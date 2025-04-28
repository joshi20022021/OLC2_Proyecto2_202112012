.data
float_0: .double 3.14
str_1: .asciz "Hola!"
float_2: .double 0
str_3: .asciz ""
float_4: .double 2.71
str_5: .asciz "Adios!"
float_6: .double 15
float_7: .double 16
float_8: .double 15.5
float_9: .double 15.5
float_10: .double 11
float_11: .double 12.5
float_12: .double 11
float_13: .double 5
float_14: .double 2.5
float_15: .double 2.5
float_16: .double 2.5
float_17: .double 0
str_18: .asciz ""
lit_20: .asciz "\=\=\= Archivo de prueba básico \=\=\="
newline_20: .asciz "\n"
lit_22: .asciz "Validaciones manuales esperadas: 4"
newline_22: .asciz "\n"
lit_24: .asciz "\=\=\=\= Declaración de variables \=\=\=\="
newline_24: .asciz "\n"
lit_26: .asciz "Declaración explícita con tipo y valor"
newline_26: .asciz "\n"
lit_28: .asciz "\n\n###Validacion Manual"
newline_28: .asciz "\n"
lit_30: .asciz "entero:"
space_31: .asciz " "
int_buffer_31: .space 20
newline_32: .asciz "\n"
lit_34: .asciz "decimal:"
space_35: .asciz " "
float_buffer_35: .space 30
newline_36: .asciz "\n"
lit_38: .asciz "texto:"
space_39: .asciz " "
empty_str_39: .asciz ""
newline_40: .asciz "\n"
lit_42: .asciz "booleano:"
space_43: .asciz " "
true_str_44: .asciz "true"
false_str_45: .asciz "false"
newline_45: .asciz "\n"
lit_47: .asciz "caracter:"
space_48: .asciz " "
newline_48: .asciz "\n"
lit_50: .asciz ""
newline_50: .asciz "\n"
lit_53: .asciz "OK Declaración explícita: correcto"
newline_53: .asciz "\n"
lit_55: .asciz "Declaración sin valor"
newline_55: .asciz "\n"
lit_57: .asciz "enteroSinValor:"
space_58: .asciz " "
int_buffer_58: .space 20
newline_59: .asciz "\n"
lit_61: .asciz "decimalSinValor:"
space_62: .asciz " "
float_buffer_62: .space 30
newline_63: .asciz "\n"
lit_65: .asciz "textoSinValor:"
space_66: .asciz " "
empty_str_66: .asciz ""
newline_67: .asciz "\n"
lit_69: .asciz "booleanoSinValor:"
space_70: .asciz " "
true_str_71: .asciz "true"
false_str_72: .asciz "false"
newline_72: .asciz "\n"
lit_75: .asciz "OK Declaración sin valor: correcto"
newline_75: .asciz "\n"
lit_77: .asciz "Declaración con inferencia de tipo"
newline_77: .asciz "\n"
lit_79: .asciz "enteroInferido:"
space_80: .asciz " "
int_buffer_80: .space 20
newline_81: .asciz "\n"
lit_83: .asciz "decimalInferido:"
space_84: .asciz " "
float_buffer_84: .space 30
newline_85: .asciz "\n"
lit_87: .asciz "textoInferido:"
space_88: .asciz " "
empty_str_88: .asciz ""
newline_89: .asciz "\n"
lit_91: .asciz "booleanoInferido:"
space_92: .asciz " "
true_str_93: .asciz "true"
false_str_94: .asciz "false"
newline_94: .asciz "\n"
lit_97: .asciz "OK Declaración con inferencia: correcto"
newline_97: .asciz "\n"
lit_99: .asciz "\n\=\=\=\= Asignación de variables \=\=\=\="
newline_99: .asciz "\n"
lit_101: .asciz "Asignación con tipo correcto"
newline_101: .asciz "\n"
float_102: .double 9.9
str_103: .asciz "Nuevo"
lit_105: .asciz "\n\n###Validacion Manual"
newline_105: .asciz "\n"
lit_107: .asciz "entero:"
space_108: .asciz " "
int_buffer_108: .space 20
newline_109: .asciz "\n"
lit_111: .asciz "decimal:"
space_112: .asciz " "
float_buffer_112: .space 30
newline_113: .asciz "\n"
lit_115: .asciz "texto:"
space_116: .asciz " "
empty_str_116: .asciz ""
newline_117: .asciz "\n"
lit_119: .asciz "booleano:"
space_120: .asciz " "
true_str_121: .asciz "true"
false_str_122: .asciz "false"
newline_122: .asciz "\n"
lit_124: .asciz ""
newline_124: .asciz "\n"
lit_127: .asciz "OK Asignación simple: correcto"
newline_127: .asciz "\n"
lit_129: .asciz "Asignación con expresiones"
newline_129: .asciz "\n"
float_130: .double 19.8
str_131: .asciz "Nuevo!"
lit_133: .asciz "entero:"
space_134: .asciz " "
int_buffer_134: .space 20
newline_135: .asciz "\n"
lit_137: .asciz "decimal:"
space_138: .asciz " "
float_buffer_138: .space 30
newline_139: .asciz "\n"
lit_141: .asciz "texto:"
space_142: .asciz " "
empty_str_142: .asciz ""
newline_143: .asciz "\n"
lit_145: .asciz "booleano:"
space_146: .asciz " "
true_str_147: .asciz "true"
false_str_148: .asciz "false"
newline_148: .asciz "\n"
lit_151: .asciz "OK Asignación con expresiones: correcto"
newline_151: .asciz "\n"
lit_153: .asciz "Asignación con tipo incorrecto"
newline_153: .asciz "\n"
lit_155: .asciz "OK Asignación con tipo incorrecto: correcto"
newline_155: .asciz "\n"
lit_157: .asciz "\n\=\=\=\= Operaciones Aritméticas \=\=\=\="
newline_157: .asciz "\n"
lit_159: .asciz "Suma"
newline_159: .asciz "\n"
lit_161: .asciz "10 + 5 \="
space_162: .asciz " "
float_buffer_162: .space 30
newline_163: .asciz "\n"
lit_165: .asciz "10.5 + 5.5 \="
space_166: .asciz " "
float_buffer_166: .space 30
newline_167: .asciz "\n"
lit_169: .asciz "10 + 5.5 \="
space_170: .asciz " "
float_buffer_170: .space 30
newline_171: .asciz "\n"
lit_173: .asciz "10.5 + 5 \="
space_174: .asciz " "
float_buffer_174: .space 30
newline_175: .asciz "\n"
lit_178: .asciz "OK Suma: correcto"
newline_178: .asciz "\n"
lit_180: .asciz "Multiplicación"
newline_180: .asciz "\n"
lit_182: .asciz "5 * 3 \="
space_183: .asciz " "
int_buffer_183: .space 20
newline_184: .asciz "\n"
lit_186: .asciz "5.5 * 2.0 \="
space_187: .asciz " "
float_buffer_187: .space 30
newline_188: .asciz "\n"
lit_190: .asciz "5 * 2.5 \="
space_191: .asciz " "
float_buffer_191: .space 30
newline_192: .asciz "\n"
lit_194: .asciz "5.5 * 2 \="
space_195: .asciz " "
float_buffer_195: .space 30
newline_196: .asciz "\n"
lit_199: .asciz "OK Multiplicación: correcto"
newline_199: .asciz "\n"
lit_201: .asciz "División"
newline_201: .asciz "\n"
lit_203: .asciz "10 / 2 \="
space_204: .asciz " "
float_buffer_204: .space 30
newline_205: .asciz "\n"
lit_207: .asciz "10.0 / 4.0 \="
space_208: .asciz " "
float_buffer_208: .space 30
newline_209: .asciz "\n"
lit_211: .asciz "10 / 4.0 \="
space_212: .asciz " "
float_buffer_212: .space 30
newline_213: .asciz "\n"
lit_215: .asciz "10.0 / 4 \="
space_216: .asciz " "
float_buffer_216: .space 30
newline_217: .asciz "\n"
lit_220: .asciz "OK División: correcto"
newline_220: .asciz "\n"
lit_222: .asciz "\n\=\=\=\= Operaciones Relacionales \=\=\=\="
newline_222: .asciz "\n"
lit_224: .asciz "Igualdad"
newline_224: .asciz "\n"
lit_226: .asciz "10 \=\= 10:"
space_227: .asciz " "
true_str_228: .asciz "true"
false_str_229: .asciz "false"
newline_229: .asciz "\n"
lit_231: .asciz "10 \=\= 5:"
space_232: .asciz " "
true_str_233: .asciz "true"
false_str_234: .asciz "false"
newline_234: .asciz "\n"
lit_236: .asciz "10.5 \=\= 10.5:"
space_237: .asciz " "
true_str_238: .asciz "true"
false_str_239: .asciz "false"
newline_239: .asciz "\n"
lit_241: .asciz "10.5 \=\= 5.5:"
space_242: .asciz " "
true_str_243: .asciz "true"
false_str_244: .asciz "false"
newline_244: .asciz "\n"
lit_246: .asciz "\"Hola\" \=\= \"Hola\":"
space_247: .asciz " "
true_str_248: .asciz "true"
false_str_249: .asciz "false"
newline_249: .asciz "\n"
lit_251: .asciz "\"Hola\" \=\= \"Mundo\":"
space_252: .asciz " "
true_str_253: .asciz "true"
false_str_254: .asciz "false"
newline_254: .asciz "\n"
lit_257: .asciz "OK Igualdad: correcto"
newline_257: .asciz "\n"
lit_259: .asciz "Mayor/Menor"
newline_259: .asciz "\n"
lit_261: .asciz "10 > 5:"
space_262: .asciz " "
true_str_263: .asciz "true"
false_str_264: .asciz "false"
newline_264: .asciz "\n"
lit_266: .asciz "10 < 5:"
space_267: .asciz " "
true_str_268: .asciz "true"
false_str_269: .asciz "false"
newline_269: .asciz "\n"
lit_271: .asciz "10.5 > 5.5:"
space_272: .asciz " "
true_str_273: .asciz "true"
false_str_274: .asciz "false"
newline_274: .asciz "\n"
lit_276: .asciz "10.5 < 5.5:"
space_277: .asciz " "
true_str_278: .asciz "true"
false_str_279: .asciz "false"
newline_279: .asciz "\n"
lit_282: .asciz "OK Mayor/Menor: correcto"
newline_282: .asciz "\n"
lit_284: .asciz "Mayor o igual/Menor o igual"
newline_284: .asciz "\n"
lit_286: .asciz "10 >\= 10:"
space_287: .asciz " "
true_str_288: .asciz "true"
false_str_289: .asciz "false"
newline_289: .asciz "\n"
lit_291: .asciz "10 <\= 5:"
space_292: .asciz " "
true_str_293: .asciz "true"
false_str_294: .asciz "false"
newline_294: .asciz "\n"
lit_296: .asciz "10.5 >\= 5.5:"
space_297: .asciz " "
true_str_298: .asciz "true"
false_str_299: .asciz "false"
newline_299: .asciz "\n"
lit_301: .asciz "10.5 <\= 10.5:"
space_302: .asciz " "
true_str_303: .asciz "true"
false_str_304: .asciz "false"
newline_304: .asciz "\n"
lit_307: .asciz "OK Mayor o igual/Menor o igual: correcto"
newline_307: .asciz "\n"
lit_309: .asciz "\n\=\=\=\= Operaciones Lógicas \=\=\=\="
newline_309: .asciz "\n"
lit_311: .asciz "AND"
newline_311: .asciz "\n"
lit_313: .asciz "true && true:"
space_314: .asciz " "
true_str_315: .asciz "true"
false_str_316: .asciz "false"
newline_316: .asciz "\n"
lit_318: .asciz "true && false:"
space_319: .asciz " "
true_str_320: .asciz "true"
false_str_321: .asciz "false"
newline_321: .asciz "\n"
lit_323: .asciz "(10 \=\= 10) && (5 \=\= 5):"
space_324: .asciz " "
true_str_325: .asciz "true"
false_str_326: .asciz "false"
newline_326: .asciz "\n"
lit_328: .asciz "(10 \=\= 10) && (5 \=\= 6):"
space_329: .asciz " "
true_str_330: .asciz "true"
false_str_331: .asciz "false"
newline_331: .asciz "\n"
lit_334: .asciz "OK AND: correcto"
newline_334: .asciz "\n"
lit_336: .asciz "OR"
newline_336: .asciz "\n"
lit_338: .asciz "true || false:"
space_339: .asciz " "
true_str_340: .asciz "true"
false_str_341: .asciz "false"
newline_341: .asciz "\n"
lit_343: .asciz "false || false:"
space_344: .asciz " "
true_str_345: .asciz "true"
false_str_346: .asciz "false"
newline_346: .asciz "\n"
lit_348: .asciz "(10 \=\= 10) || (5 \=\= 6):"
space_349: .asciz " "
true_str_350: .asciz "true"
false_str_351: .asciz "false"
newline_351: .asciz "\n"
lit_353: .asciz "(10 \=\= 11) || (5 \=\= 6):"
space_354: .asciz " "
true_str_355: .asciz "true"
false_str_356: .asciz "false"
newline_356: .asciz "\n"
lit_359: .asciz "OK OR: correcto"
newline_359: .asciz "\n"
lit_361: .asciz "NOT"
newline_361: .asciz "\n"
lit_363: .asciz "!true:"
space_364: .asciz " "
true_str_365: .asciz "true"
false_str_366: .asciz "false"
newline_366: .asciz "\n"
lit_368: .asciz "!false:"
space_369: .asciz " "
true_str_370: .asciz "true"
false_str_371: .asciz "false"
newline_371: .asciz "\n"
lit_373: .asciz "!(10 \=\= 10):"
space_374: .asciz " "
true_str_375: .asciz "true"
false_str_376: .asciz "false"
newline_376: .asciz "\n"
lit_378: .asciz "!(10 \=\= 11):"
space_379: .asciz " "
true_str_380: .asciz "true"
false_str_381: .asciz "false"
newline_381: .asciz "\n"
lit_384: .asciz "OK NOT: correcto"
newline_384: .asciz "\n"
lit_386: .asciz "\n\=\=\=\= fmt.Println \=\=\=\="
newline_386: .asciz "\n"
lit_388: .asciz "\n\n###Validacion Manual"
newline_388: .asciz "\n"
lit_390: .asciz "Impresión de valores simples"
newline_390: .asciz "\n"
lit_392: .asciz "42"
newline_392: .asciz "\n"
lit_394: .asciz "3.14"
newline_394: .asciz "\n"
lit_396: .asciz "Texto"
newline_396: .asciz "\n"
lit_398: .asciz "true"
newline_398: .asciz "\n"
lit_400: .asciz "A"
newline_400: .asciz "\n"
lit_402: .asciz ""
newline_402: .asciz "\n"
lit_404: .asciz "OK Impresión de valores simples: correcto"
newline_404: .asciz "\n"
lit_406: .asciz "Impresión de múltiples valores"
newline_406: .asciz "\n"
lit_408: .asciz "Números:"
space_409: .asciz " "
lit_410: .asciz "42"
space_411: .asciz " "
lit_412: .asciz "3.14"
newline_412: .asciz "\n"
lit_414: .asciz "Booleano:"
space_415: .asciz " "
lit_416: .asciz "true"
space_417: .asciz " "
lit_418: .asciz "Texto:"
space_419: .asciz " "
lit_420: .asciz "Hola"
newline_420: .asciz "\n"
lit_422: .asciz "OK Impresión de múltiples valores: correcto"
newline_422: .asciz "\n"
lit_424: .asciz "Impresión de expresiones"
newline_424: .asciz "\n"
lit_426: .asciz "Suma:"
space_427: .asciz " "
lit_428: .asciz "15"
newline_428: .asciz "\n"
lit_430: .asciz "Comparación:"
space_431: .asciz " "
lit_432: .asciz "true"
newline_432: .asciz "\n"
lit_434: .asciz "Lógica:"
space_435: .asciz " "
lit_436: .asciz "false"
newline_436: .asciz "\n"
lit_438: .asciz "OK Impresión de expresiones: correcto"
newline_438: .asciz "\n"
lit_440: .asciz "\n\=\=\=\= Manejo de valor nulo \=\=\=\="
newline_440: .asciz "\n"
lit_442: .asciz "Valores por defecto"
newline_442: .asciz "\n"
lit_444: .asciz "\n\n###Validacion Manual"
newline_444: .asciz "\n"
lit_446: .asciz "enteroNulo:"
space_447: .asciz " "
int_buffer_447: .space 20
newline_448: .asciz "\n"
lit_450: .asciz "decimalNulo:"
space_451: .asciz " "
float_buffer_451: .space 30
newline_452: .asciz "\n"
lit_454: .asciz "textoNulo:"
space_455: .asciz " "
empty_str_455: .asciz ""
newline_456: .asciz "\n"
lit_458: .asciz "booleanoNulo:"
space_459: .asciz " "
true_str_460: .asciz "true"
false_str_461: .asciz "false"
newline_461: .asciz "\n"
lit_463: .asciz ""
newline_463: .asciz "\n"
lit_466: .asciz "OK Valores por defecto: correcto"
newline_466: .asciz "\n"
lit_468: .asciz "Operaciones con nil"
newline_468: .asciz "\n"
lit_470: .asciz "OK Operaciones con nil: correcto"
newline_470: .asciz "\n"
lit_472: .asciz "\n\=\=\= Tabla de Resultados \=\=\="
newline_472: .asciz "\n"
lit_474: .asciz "+--------------------------+--------+-------+"
newline_474: .asciz "\n"
lit_476: .asciz "| Característica           | Puntos | Total |"
newline_476: .asciz "\n"
lit_478: .asciz "+--------------------------+--------+-------+"
newline_478: .asciz "\n"
lit_480: .asciz "| Declaración de variables | "
space_481: .asciz " "
int_buffer_481: .space 20
space_483: .asciz " "
lit_484: .asciz "    | 3     |"
newline_484: .asciz "\n"
lit_486: .asciz "| Asignación de variables  | "
space_487: .asciz " "
int_buffer_487: .space 20
space_489: .asciz " "
lit_490: .asciz "    | 3     |"
newline_490: .asciz "\n"
lit_492: .asciz "| Operaciones Aritméticas  | "
space_493: .asciz " "
int_buffer_493: .space 20
space_495: .asciz " "
lit_496: .asciz "    | 3     |"
newline_496: .asciz "\n"
lit_498: .asciz "| Operaciones Relacionales | "
space_499: .asciz " "
int_buffer_499: .space 20
space_501: .asciz " "
lit_502: .asciz "    | 3     |"
newline_502: .asciz "\n"
lit_504: .asciz "| Operaciones Lógicas      | "
space_505: .asciz " "
int_buffer_505: .space 20
space_507: .asciz " "
lit_508: .asciz "    | 3     |"
newline_508: .asciz "\n"
lit_510: .asciz "| fmt.Println              | "
space_511: .asciz " "
int_buffer_511: .space 20
space_513: .asciz " "
lit_514: .asciz "    | 3     |"
newline_514: .asciz "\n"
lit_516: .asciz "| Manejo de valor nulo     | "
space_517: .asciz " "
int_buffer_517: .space 20
space_519: .asciz " "
lit_520: .asciz "    | 2     |"
newline_520: .asciz "\n"
lit_522: .asciz "+--------------------------+--------+-------+"
newline_522: .asciz "\n"
lit_524: .asciz "| TOTAL                    | "
space_525: .asciz " "
int_buffer_525: .space 20
space_527: .asciz " "
lit_528: .asciz "   | 20    |"
newline_528: .asciz "\n"
lit_530: .asciz "+--------------------------+--------+-------+"
newline_530: .asciz "\n"

// ARM64 Assembly
.text
.global _start
_start:
    stp x29, x30, [sp, #-16]!
    mov x29, sp
    sub sp, sp, #512

    // Declaraciones de variables
    // Debug: Símbolos en tabla: 64
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
    // Símbolo: '25', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: enteroSinValor
    mov x9, #0
    str x9, [sp, #72]
    // Símbolo: '28', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: decimalSinValor
    adr x9, float_2
    ldr d0, [x9]
    str d0, [sp, #80]
    // Símbolo: '31', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: textoSinValor
    adr x9, str_3
    str x9, [sp, #88]
    // Símbolo: '34', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: booleanoSinValor
    mov x9, #0
    str x9, [sp, #96]
    // Símbolo: '37', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: enteroInferido
    mov x9, #100
    str x9, [sp, #104]
    // Símbolo: '40', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: decimalInferido
    adr x9, float_4
    ldr d0, [x9]
    str d0, [sp, #112]
    // Símbolo: '43', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: textoInferido
    adr x9, str_5
    str x9, [sp, #120]
    // Símbolo: '46', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: booleanoInferido
    mov x9, #0
    str x9, [sp, #128]
    // Símbolo: '49', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosAsignacion
    mov x9, #0
    str x9, [sp, #136]
    // Símbolo: '52', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosOperacionesAritmeticas
    mov x9, #0
    str x9, [sp, #144]
    // Símbolo: '55', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoSuma1
    adr x9, float_6
    ldr d0, [x9]
    str d0, [sp, #152]
    // Símbolo: '58', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoSuma2
    adr x9, float_7
    ldr d0, [x9]
    str d0, [sp, #160]
    // Símbolo: '61', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoSuma3
    adr x9, float_8
    ldr d0, [x9]
    str d0, [sp, #168]
    // Símbolo: '64', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoSuma4
    adr x9, float_9
    ldr d0, [x9]
    str d0, [sp, #176]
    // Símbolo: '67', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: resultadoMult1
    mov x9, #15
    str x9, [sp, #184]
    // Símbolo: '70', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoMult2
    adr x9, float_10
    ldr d0, [x9]
    str d0, [sp, #192]
    // Símbolo: '73', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoMult3
    adr x9, float_11
    ldr d0, [x9]
    str d0, [sp, #200]
    // Símbolo: '76', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoMult4
    adr x9, float_12
    ldr d0, [x9]
    str d0, [sp, #208]
    // Símbolo: '79', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoDiv1
    adr x9, float_13
    ldr d0, [x9]
    str d0, [sp, #216]
    // Símbolo: '82', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoDiv2
    adr x9, float_14
    ldr d0, [x9]
    str d0, [sp, #224]
    // Símbolo: '85', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoDiv3
    adr x9, float_15
    ldr d0, [x9]
    str d0, [sp, #232]
    // Símbolo: '88', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: resultadoDiv4
    adr x9, float_16
    ldr d0, [x9]
    str d0, [sp, #240]
    // Símbolo: '91', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosOperacionesRelacionales
    mov x9, #0
    str x9, [sp, #248]
    // Símbolo: '94', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoIgualdad1
    mov x9, #1
    str x9, [sp, #256]
    // Símbolo: '97', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoIgualdad2
    mov x9, #0
    str x9, [sp, #264]
    // Símbolo: '100', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoIgualdad3
    mov x9, #1
    str x9, [sp, #272]
    // Símbolo: '103', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoIgualdad4
    mov x9, #0
    str x9, [sp, #280]
    // Símbolo: '106', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoIgualdad5
    mov x9, #1
    str x9, [sp, #288]
    // Símbolo: '109', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoIgualdad6
    mov x9, #0
    str x9, [sp, #296]
    // Símbolo: '112', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoComp1
    mov x9, #1
    str x9, [sp, #304]
    // Símbolo: '115', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoComp2
    mov x9, #0
    str x9, [sp, #312]
    // Símbolo: '118', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoComp3
    mov x9, #1
    str x9, [sp, #320]
    // Símbolo: '121', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoComp4
    mov x9, #0
    str x9, [sp, #328]
    // Símbolo: '124', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoComp5
    mov x9, #1
    str x9, [sp, #336]
    // Símbolo: '127', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoComp6
    mov x9, #0
    str x9, [sp, #344]
    // Símbolo: '130', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoComp7
    mov x9, #1
    str x9, [sp, #352]
    // Símbolo: '133', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoComp8
    mov x9, #1
    str x9, [sp, #360]
    // Símbolo: '136', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosOperacionesLogicas
    mov x9, #0
    str x9, [sp, #368]
    // Símbolo: '139', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoAnd1
    mov x9, #1
    str x9, [sp, #376]
    // Símbolo: '142', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoAnd2
    mov x9, #0
    str x9, [sp, #384]
    // Símbolo: '145', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoAnd3
    mov x9, #1
    str x9, [sp, #392]
    // Símbolo: '148', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoAnd4
    mov x9, #0
    str x9, [sp, #400]
    // Símbolo: '151', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoOr1
    mov x9, #1
    str x9, [sp, #408]
    // Símbolo: '154', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoOr2
    mov x9, #0
    str x9, [sp, #416]
    // Símbolo: '157', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoOr3
    mov x9, #1
    str x9, [sp, #424]
    // Símbolo: '160', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoOr4
    mov x9, #0
    str x9, [sp, #432]
    // Símbolo: '163', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoNot1
    mov x9, #0
    str x9, [sp, #440]
    // Símbolo: '166', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoNot2
    mov x9, #1
    str x9, [sp, #448]
    // Símbolo: '169', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoNot3
    mov x9, #0
    str x9, [sp, #456]
    // Símbolo: '172', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: resultadoNot4
    mov x9, #1
    str x9, [sp, #464]
    // Símbolo: '175', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosPrintln
    mov x9, #0
    str x9, [sp, #472]
    // Símbolo: '178', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: puntosValorNulo
    mov x9, #0
    str x9, [sp, #480]
    // Símbolo: '181', Tipo: 'Variable', Dato: 'int'

    // Declaración de variable: enteroNulo
    mov x9, #0
    str x9, [sp, #488]
    // Símbolo: '184', Tipo: 'Variable', Dato: 'float64'

    // Declaración de variable: decimalNulo
    adr x9, float_17
    ldr d0, [x9]
    str d0, [sp, #496]
    // Símbolo: '187', Tipo: 'Variable', Dato: 'string'

    // Declaración de variable: textoNulo
    adr x9, str_18
    str x9, [sp, #504]
    // Símbolo: '190', Tipo: 'Variable', Dato: 'bool'

    // Declaración de variable: booleanoNulo
    mov x9, #0
    str x9, [sp, #512]

    // Procesando instrucciones

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \=\=\= Archivo de prueba básico \=\=\=
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
    // Imprimir literal: Validaciones manuales esperadas: 4
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
    // Imprimir literal: \=\=\=\= Declaración de variables \=\=\=\=
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
    // Imprimir literal: Declaración explícita con tipo y valor
    adr x0, lit_26
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_26
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_26
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_26
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\n###Validacion Manual
    adr x0, lit_28
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_28
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
    // Imprimir literal: entero:
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
    // Imprimir entero: entero
    ldr x0, [sp, #32]
    adr x1, int_buffer_31
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_31
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

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: decimal:
    adr x0, lit_34
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_34
    mov x8, #64
    svc #0
    adr x0, space_35
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_35
    mov x8, #64
    svc #0
    // Imprimir flotante: decimal
    ldr d0, [sp, #40]
    adr x0, float_buffer_35
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_35
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_36
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_36
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: texto:
    adr x0, lit_38
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_38
    mov x8, #64
    svc #0
    adr x0, space_39
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_39
    mov x8, #64
    svc #0
    // Imprimir string: texto
    ldr x0, [sp, #48]
    cmp x0, #0
    beq skip_print_39
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #48]
    mov x8, #64
    svc #0
    b end_print_39
skip_print_39:
    adr x0, empty_str_39
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_39
    mov x8, #64
    svc #0
end_print_39:
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
    // Imprimir literal: booleano:
    adr x0, lit_42
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_42
    mov x8, #64
    svc #0
    adr x0, space_43
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_43
    mov x8, #64
    svc #0
    // Imprimir booleano: booleano
    ldr x0, [sp, #56]
    cmp x0, #0
    beq print_false_45
    mov x0, #1
    adr x1, true_str_44
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_45
print_false_45:
    mov x0, #1
    adr x1, false_str_45
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_45:
    // Imprimir salto de línea
    adr x0, newline_45
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_45
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: caracter:
    adr x0, lit_47
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_47
    mov x8, #64
    svc #0
    adr x0, space_48
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_48
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
    adr x0, newline_48
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_48
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 
    adr x0, lit_50
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_50
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
    // Evaluar condición: entero==42&&decimal>3.0&&texto=="Hola!"&&booleano==true&&caracter=='A'
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_51
    // Bloque if (then)
    b endif_51
else_51:
    // Bloque else
endif_51:

    // Procesando nodo: Condicion  Valor=entero==42&&decimal>3.0&&texto=="Hola!"&&booleano==true&&caracter=='A'

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 1 a puntosDeclaracion (int) en [sp, #24]
    mov x9, #1
    str x9, [sp, #24]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Declaración explícita: correcto
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
    // Imprimir literal: Declaración sin valor
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
    // Imprimir literal: enteroSinValor:
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
    // Imprimir entero: enteroSinValor
    ldr x0, [sp, #72]
    adr x1, int_buffer_58
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_58
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_59
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_59
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: decimalSinValor:
    adr x0, lit_61
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_61
    mov x8, #64
    svc #0
    adr x0, space_62
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_62
    mov x8, #64
    svc #0
    // Imprimir flotante: decimalSinValor
    ldr d0, [sp, #80]
    adr x0, float_buffer_62
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_62
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_63
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_63
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: textoSinValor:
    adr x0, lit_65
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_65
    mov x8, #64
    svc #0
    adr x0, space_66
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_66
    mov x8, #64
    svc #0
    // Imprimir string: textoSinValor
    ldr x0, [sp, #88]
    cmp x0, #0
    beq skip_print_66
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #88]
    mov x8, #64
    svc #0
    b end_print_66
skip_print_66:
    adr x0, empty_str_66
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_66
    mov x8, #64
    svc #0
end_print_66:
    // Imprimir salto de línea
    adr x0, newline_67
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_67
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: booleanoSinValor:
    adr x0, lit_69
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_69
    mov x8, #64
    svc #0
    adr x0, space_70
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_70
    mov x8, #64
    svc #0
    // Imprimir booleano: booleanoSinValor
    ldr x0, [sp, #96]
    cmp x0, #0
    beq print_false_72
    mov x0, #1
    adr x1, true_str_71
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_72
print_false_72:
    mov x0, #1
    adr x1, false_str_72
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_72:
    // Imprimir salto de línea
    adr x0, newline_72
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_72
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: enteroSinValor==0&&decimalSinValor==0.0&&textoSinValor==""&&booleanoSinValor==false
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_73
    // Bloque if (then)
    b endif_73
else_73:
    // Bloque else
endif_73:

    // Procesando nodo: Condicion  Valor=enteroSinValor==0&&decimalSinValor==0.0&&textoSinValor==""&&booleanoSinValor==false

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosDeclaracion (int) en [sp, #24]
    mov x9, #2
    str x9, [sp, #24]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Declaración sin valor: correcto
    adr x0, lit_75
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_75
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_75
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_75
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Declaración con inferencia de tipo
    adr x0, lit_77
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_77
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_77
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_77
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: enteroInferido:
    adr x0, lit_79
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_79
    mov x8, #64
    svc #0
    adr x0, space_80
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_80
    mov x8, #64
    svc #0
    // Imprimir entero: enteroInferido
    ldr x0, [sp, #104]
    adr x1, int_buffer_80
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_80
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_81
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_81
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: decimalInferido:
    adr x0, lit_83
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_83
    mov x8, #64
    svc #0
    adr x0, space_84
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_84
    mov x8, #64
    svc #0
    // Imprimir flotante: decimalInferido
    ldr d0, [sp, #112]
    adr x0, float_buffer_84
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_84
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_85
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_85
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: textoInferido:
    adr x0, lit_87
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_87
    mov x8, #64
    svc #0
    adr x0, space_88
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_88
    mov x8, #64
    svc #0
    // Imprimir string: textoInferido
    ldr x0, [sp, #120]
    cmp x0, #0
    beq skip_print_88
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #120]
    mov x8, #64
    svc #0
    b end_print_88
skip_print_88:
    adr x0, empty_str_88
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_88
    mov x8, #64
    svc #0
end_print_88:
    // Imprimir salto de línea
    adr x0, newline_89
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_89
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: booleanoInferido:
    adr x0, lit_91
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_91
    mov x8, #64
    svc #0
    adr x0, space_92
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_92
    mov x8, #64
    svc #0
    // Imprimir booleano: booleanoInferido
    ldr x0, [sp, #128]
    cmp x0, #0
    beq print_false_94
    mov x0, #1
    adr x1, true_str_93
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_94
print_false_94:
    mov x0, #1
    adr x1, false_str_94
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_94:
    // Imprimir salto de línea
    adr x0, newline_94
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_94
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: enteroInferido==100&&decimalInferido>2.7&&textoInferido=="Adios!"&&booleanoInferido==false
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_95
    // Bloque if (then)
    b endif_95
else_95:
    // Bloque else
endif_95:

    // Procesando nodo: Condicion  Valor=enteroInferido==100&&decimalInferido>2.7&&textoInferido=="Adios!"&&booleanoInferido==false

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 3 a puntosDeclaracion (int) en [sp, #24]
    mov x9, #3
    str x9, [sp, #24]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Declaración con inferencia: correcto
    adr x0, lit_97
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_97
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_97
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_97
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= Asignación de variables \=\=\=\=
    adr x0, lit_99
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_99
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_99
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_99
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Asignación con tipo correcto
    adr x0, lit_101
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_101
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_101
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_101
    mov x8, #64
    svc #0

    // Procesando nodo: Asignacion  Valor=
    // Asignando 99 a entero (int) en [sp, #32]
    mov x9, #99
    str x9, [sp, #32]

    // Procesando nodo: Asignacion  Valor=
    // Asignando 9,9 a decimal (float64) en [sp, #40]
    adr x9, float_102
    ldr d0, [x9]
    str d0, [sp, #40]

    // Procesando nodo: Asignacion  Valor=
    // Asignando Nuevo a texto (string) en [sp, #48]
    adr x0, str_103
    str x0, [sp, #48]

    // Procesando nodo: Negacion  Valor=!

    // Procesando nodo: Asignacion  Valor=
    // Asignando False a booleano (bool) en [sp, #56]
    mov x0, #0
    str x0, [sp, #56]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\n###Validacion Manual
    adr x0, lit_105
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_105
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_105
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_105
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: entero:
    adr x0, lit_107
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_107
    mov x8, #64
    svc #0
    adr x0, space_108
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_108
    mov x8, #64
    svc #0
    // Imprimir entero: entero
    ldr x0, [sp, #32]
    adr x1, int_buffer_108
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_108
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_109
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_109
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: decimal:
    adr x0, lit_111
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_111
    mov x8, #64
    svc #0
    adr x0, space_112
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_112
    mov x8, #64
    svc #0
    // Imprimir flotante: decimal
    ldr d0, [sp, #40]
    adr x0, float_buffer_112
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_112
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_113
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_113
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: texto:
    adr x0, lit_115
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_115
    mov x8, #64
    svc #0
    adr x0, space_116
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_116
    mov x8, #64
    svc #0
    // Imprimir string: texto
    ldr x0, [sp, #48]
    cmp x0, #0
    beq skip_print_116
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #48]
    mov x8, #64
    svc #0
    b end_print_116
skip_print_116:
    adr x0, empty_str_116
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_116
    mov x8, #64
    svc #0
end_print_116:
    // Imprimir salto de línea
    adr x0, newline_117
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_117
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: booleano:
    adr x0, lit_119
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_119
    mov x8, #64
    svc #0
    adr x0, space_120
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_120
    mov x8, #64
    svc #0
    // Imprimir booleano: booleano
    ldr x0, [sp, #56]
    cmp x0, #0
    beq print_false_122
    mov x0, #1
    adr x1, true_str_121
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_122
print_false_122:
    mov x0, #1
    adr x1, false_str_122
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_122:
    // Imprimir salto de línea
    adr x0, newline_122
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_122
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 
    adr x0, lit_124
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_124
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_124
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_124
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: entero==99&&decimal==9.9&&texto=="Nuevo"&&booleano==false
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_125
    // Bloque if (then)
    b endif_125
else_125:
    // Bloque else
endif_125:

    // Procesando nodo: Condicion  Valor=entero==99&&decimal==9.9&&texto=="Nuevo"&&booleano==false

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 1 a puntosAsignacion (int) en [sp, #136]
    mov x9, #1
    str x9, [sp, #136]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Asignación simple: correcto
    adr x0, lit_127
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_127
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_127
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_127
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Asignación con expresiones
    adr x0, lit_129
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_129
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_129
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_129
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 100 a entero (int) en [sp, #32]
    mov x9, #100
    str x9, [sp, #32]

    // Procesando nodo: Operacion  Valor=*

    // Procesando nodo: Asignacion  Valor=
    // Asignando 19,8 a decimal (float64) en [sp, #40]
    adr x9, float_130
    ldr d0, [x9]
    str d0, [sp, #40]

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando Nuevo! a texto (string) en [sp, #48]
    adr x0, str_131
    str x0, [sp, #48]

    // Procesando nodo: Negacion  Valor=!

    // Procesando nodo: Asignacion  Valor=
    // Asignando True a booleano (bool) en [sp, #56]
    mov x0, #1
    str x0, [sp, #56]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: entero:
    adr x0, lit_133
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_133
    mov x8, #64
    svc #0
    adr x0, space_134
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_134
    mov x8, #64
    svc #0
    // Imprimir entero: entero
    ldr x0, [sp, #32]
    adr x1, int_buffer_134
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_134
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_135
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_135
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: decimal:
    adr x0, lit_137
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_137
    mov x8, #64
    svc #0
    adr x0, space_138
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_138
    mov x8, #64
    svc #0
    // Imprimir flotante: decimal
    ldr d0, [sp, #40]
    adr x0, float_buffer_138
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_138
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_139
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_139
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: texto:
    adr x0, lit_141
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_141
    mov x8, #64
    svc #0
    adr x0, space_142
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_142
    mov x8, #64
    svc #0
    // Imprimir string: texto
    ldr x0, [sp, #48]
    cmp x0, #0
    beq skip_print_142
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #48]
    mov x8, #64
    svc #0
    b end_print_142
skip_print_142:
    adr x0, empty_str_142
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_142
    mov x8, #64
    svc #0
end_print_142:
    // Imprimir salto de línea
    adr x0, newline_143
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_143
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: booleano:
    adr x0, lit_145
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_145
    mov x8, #64
    svc #0
    adr x0, space_146
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_146
    mov x8, #64
    svc #0
    // Imprimir booleano: booleano
    ldr x0, [sp, #56]
    cmp x0, #0
    beq print_false_148
    mov x0, #1
    adr x1, true_str_147
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_148
print_false_148:
    mov x0, #1
    adr x1, false_str_148
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_148:
    // Imprimir salto de línea
    adr x0, newline_148
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_148
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: entero==100&&decimal==19.8&&texto=="Nuevo!"&&booleano==true
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_149
    // Bloque if (then)
    b endif_149
else_149:
    // Bloque else
endif_149:

    // Procesando nodo: Condicion  Valor=entero==100&&decimal==19.8&&texto=="Nuevo!"&&booleano==true

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosAsignacion (int) en [sp, #136]
    mov x9, #2
    str x9, [sp, #136]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Asignación con expresiones: correcto
    adr x0, lit_151
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_151
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_151
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_151
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Asignación con tipo incorrecto
    adr x0, lit_153
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_153
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_153
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_153
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 3 a puntosAsignacion (int) en [sp, #136]
    mov x9, #3
    str x9, [sp, #136]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Asignación con tipo incorrecto: correcto
    adr x0, lit_155
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_155
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_155
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_155
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= Operaciones Aritméticas \=\=\=\=
    adr x0, lit_157
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_157
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_157
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_157
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Suma
    adr x0, lit_159
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_159
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_159
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_159
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10 + 5 \=
    adr x0, lit_161
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_161
    mov x8, #64
    svc #0
    adr x0, space_162
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_162
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoSuma1
    ldr d0, [sp, #152]
    adr x0, float_buffer_162
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_162
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_163
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_163
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10.5 + 5.5 \=
    adr x0, lit_165
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_165
    mov x8, #64
    svc #0
    adr x0, space_166
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_166
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoSuma2
    ldr d0, [sp, #160]
    adr x0, float_buffer_166
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_166
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_167
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_167
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10 + 5.5 \=
    adr x0, lit_169
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_169
    mov x8, #64
    svc #0
    adr x0, space_170
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_170
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoSuma3
    ldr d0, [sp, #168]
    adr x0, float_buffer_170
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_170
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_171
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_171
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10.5 + 5 \=
    adr x0, lit_173
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_173
    mov x8, #64
    svc #0
    adr x0, space_174
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_174
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoSuma4
    ldr d0, [sp, #176]
    adr x0, float_buffer_174
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_174
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_175
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_175
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: resultadoSuma1==15&&resultadoSuma2==16.0&&resultadoSuma3==15.5&&resultadoSuma4==15.5
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_176
    // Bloque if (then)
    b endif_176
else_176:
    // Bloque else
endif_176:

    // Procesando nodo: Condicion  Valor=resultadoSuma1==15&&resultadoSuma2==16.0&&resultadoSuma3==15.5&&resultadoSuma4==15.5

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 1 a puntosOperacionesAritmeticas (int) en [sp, #144]
    mov x9, #1
    str x9, [sp, #144]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Suma: correcto
    adr x0, lit_178
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_178
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_178
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_178
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Multiplicación
    adr x0, lit_180
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_180
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_180
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_180
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=*

    // Procesando nodo: Operacion  Valor=*

    // Procesando nodo: Operacion  Valor=*

    // Procesando nodo: Operacion  Valor=*

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 5 * 3 \=
    adr x0, lit_182
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_182
    mov x8, #64
    svc #0
    adr x0, space_183
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_183
    mov x8, #64
    svc #0
    // Imprimir entero: resultadoMult1
    ldr x0, [sp, #184]
    adr x1, int_buffer_183
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_183
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_184
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_184
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 5.5 * 2.0 \=
    adr x0, lit_186
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_186
    mov x8, #64
    svc #0
    adr x0, space_187
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_187
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoMult2
    ldr d0, [sp, #192]
    adr x0, float_buffer_187
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_187
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_188
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_188
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 5 * 2.5 \=
    adr x0, lit_190
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_190
    mov x8, #64
    svc #0
    adr x0, space_191
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_191
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoMult3
    ldr d0, [sp, #200]
    adr x0, float_buffer_191
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_191
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_192
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_192
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 5.5 * 2 \=
    adr x0, lit_194
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_194
    mov x8, #64
    svc #0
    adr x0, space_195
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_195
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoMult4
    ldr d0, [sp, #208]
    adr x0, float_buffer_195
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_195
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_196
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_196
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: resultadoMult1==15&&resultadoMult2==11.0&&resultadoMult3==12.5&&resultadoMult4==11.0
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_197
    // Bloque if (then)
    b endif_197
else_197:
    // Bloque else
endif_197:

    // Procesando nodo: Condicion  Valor=resultadoMult1==15&&resultadoMult2==11.0&&resultadoMult3==12.5&&resultadoMult4==11.0

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosOperacionesAritmeticas (int) en [sp, #144]
    mov x9, #2
    str x9, [sp, #144]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Multiplicación: correcto
    adr x0, lit_199
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_199
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_199
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_199
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: División
    adr x0, lit_201
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_201
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_201
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_201
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=/

    // Procesando nodo: Operacion  Valor=/

    // Procesando nodo: Operacion  Valor=/

    // Procesando nodo: Operacion  Valor=/

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10 / 2 \=
    adr x0, lit_203
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_203
    mov x8, #64
    svc #0
    adr x0, space_204
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_204
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoDiv1
    ldr d0, [sp, #216]
    adr x0, float_buffer_204
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_204
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_205
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_205
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10.0 / 4.0 \=
    adr x0, lit_207
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_207
    mov x8, #64
    svc #0
    adr x0, space_208
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_208
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoDiv2
    ldr d0, [sp, #224]
    adr x0, float_buffer_208
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_208
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_209
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_209
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10 / 4.0 \=
    adr x0, lit_211
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_211
    mov x8, #64
    svc #0
    adr x0, space_212
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_212
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoDiv3
    ldr d0, [sp, #232]
    adr x0, float_buffer_212
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_212
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_213
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_213
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10.0 / 4 \=
    adr x0, lit_215
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_215
    mov x8, #64
    svc #0
    adr x0, space_216
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_216
    mov x8, #64
    svc #0
    // Imprimir flotante: resultadoDiv4
    ldr d0, [sp, #240]
    adr x0, float_buffer_216
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_216
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_217
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_217
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: resultadoDiv1==5&&resultadoDiv2==2.5&&resultadoDiv3==2.5&&resultadoDiv4==2.5
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_218
    // Bloque if (then)
    b endif_218
else_218:
    // Bloque else
endif_218:

    // Procesando nodo: Condicion  Valor=resultadoDiv1==5&&resultadoDiv2==2.5&&resultadoDiv3==2.5&&resultadoDiv4==2.5

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 3 a puntosOperacionesAritmeticas (int) en [sp, #144]
    mov x9, #3
    str x9, [sp, #144]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK División: correcto
    adr x0, lit_220
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_220
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_220
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_220
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= Operaciones Relacionales \=\=\=\=
    adr x0, lit_222
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_222
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_222
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_222
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Igualdad
    adr x0, lit_224
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_224
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_224
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_224
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10 \=\= 10:
    adr x0, lit_226
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_226
    mov x8, #64
    svc #0
    adr x0, space_227
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_227
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoIgualdad1
    ldr x0, [sp, #256]
    cmp x0, #0
    beq print_false_229
    mov x0, #1
    adr x1, true_str_228
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_229
print_false_229:
    mov x0, #1
    adr x1, false_str_229
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_229:
    // Imprimir salto de línea
    adr x0, newline_229
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_229
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10 \=\= 5:
    adr x0, lit_231
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_231
    mov x8, #64
    svc #0
    adr x0, space_232
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_232
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoIgualdad2
    ldr x0, [sp, #264]
    cmp x0, #0
    beq print_false_234
    mov x0, #1
    adr x1, true_str_233
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_234
print_false_234:
    mov x0, #1
    adr x1, false_str_234
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_234:
    // Imprimir salto de línea
    adr x0, newline_234
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_234
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10.5 \=\= 10.5:
    adr x0, lit_236
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_236
    mov x8, #64
    svc #0
    adr x0, space_237
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_237
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoIgualdad3
    ldr x0, [sp, #272]
    cmp x0, #0
    beq print_false_239
    mov x0, #1
    adr x1, true_str_238
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_239
print_false_239:
    mov x0, #1
    adr x1, false_str_239
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_239:
    // Imprimir salto de línea
    adr x0, newline_239
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_239
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10.5 \=\= 5.5:
    adr x0, lit_241
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_241
    mov x8, #64
    svc #0
    adr x0, space_242
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_242
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoIgualdad4
    ldr x0, [sp, #280]
    cmp x0, #0
    beq print_false_244
    mov x0, #1
    adr x1, true_str_243
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_244
print_false_244:
    mov x0, #1
    adr x1, false_str_244
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_244:
    // Imprimir salto de línea
    adr x0, newline_244
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_244
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \"Hola\" \=\= \"Hola\":
    adr x0, lit_246
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_246
    mov x8, #64
    svc #0
    adr x0, space_247
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_247
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoIgualdad5
    ldr x0, [sp, #288]
    cmp x0, #0
    beq print_false_249
    mov x0, #1
    adr x1, true_str_248
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_249
print_false_249:
    mov x0, #1
    adr x1, false_str_249
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_249:
    // Imprimir salto de línea
    adr x0, newline_249
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_249
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \"Hola\" \=\= \"Mundo\":
    adr x0, lit_251
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_251
    mov x8, #64
    svc #0
    adr x0, space_252
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_252
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoIgualdad6
    ldr x0, [sp, #296]
    cmp x0, #0
    beq print_false_254
    mov x0, #1
    adr x1, true_str_253
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_254
print_false_254:
    mov x0, #1
    adr x1, false_str_254
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_254:
    // Imprimir salto de línea
    adr x0, newline_254
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_254
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: resultadoIgualdad1==true&&resultadoIgualdad2==false&&resultadoIgualdad3==true&&resultadoIgualdad4==false&&resultadoIgualdad5==true&&resultadoIgualdad6==false
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_255
    // Bloque if (then)
    b endif_255
else_255:
    // Bloque else
endif_255:

    // Procesando nodo: Condicion  Valor=resultadoIgualdad1==true&&resultadoIgualdad2==false&&resultadoIgualdad3==true&&resultadoIgualdad4==false&&resultadoIgualdad5==true&&resultadoIgualdad6==false

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 1 a puntosOperacionesRelacionales (int) en [sp, #248]
    mov x9, #1
    str x9, [sp, #248]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Igualdad: correcto
    adr x0, lit_257
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_257
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_257
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_257
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Mayor/Menor
    adr x0, lit_259
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_259
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_259
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_259
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10 > 5:
    adr x0, lit_261
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_261
    mov x8, #64
    svc #0
    adr x0, space_262
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_262
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoComp1
    ldr x0, [sp, #304]
    cmp x0, #0
    beq print_false_264
    mov x0, #1
    adr x1, true_str_263
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_264
print_false_264:
    mov x0, #1
    adr x1, false_str_264
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_264:
    // Imprimir salto de línea
    adr x0, newline_264
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_264
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10 < 5:
    adr x0, lit_266
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_266
    mov x8, #64
    svc #0
    adr x0, space_267
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_267
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoComp2
    ldr x0, [sp, #312]
    cmp x0, #0
    beq print_false_269
    mov x0, #1
    adr x1, true_str_268
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_269
print_false_269:
    mov x0, #1
    adr x1, false_str_269
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_269:
    // Imprimir salto de línea
    adr x0, newline_269
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_269
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10.5 > 5.5:
    adr x0, lit_271
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_271
    mov x8, #64
    svc #0
    adr x0, space_272
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_272
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoComp3
    ldr x0, [sp, #320]
    cmp x0, #0
    beq print_false_274
    mov x0, #1
    adr x1, true_str_273
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_274
print_false_274:
    mov x0, #1
    adr x1, false_str_274
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_274:
    // Imprimir salto de línea
    adr x0, newline_274
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_274
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10.5 < 5.5:
    adr x0, lit_276
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_276
    mov x8, #64
    svc #0
    adr x0, space_277
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_277
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoComp4
    ldr x0, [sp, #328]
    cmp x0, #0
    beq print_false_279
    mov x0, #1
    adr x1, true_str_278
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_279
print_false_279:
    mov x0, #1
    adr x1, false_str_279
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_279:
    // Imprimir salto de línea
    adr x0, newline_279
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_279
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: resultadoComp1==true&&resultadoComp2==false&&resultadoComp3==true&&resultadoComp4==false
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_280
    // Bloque if (then)
    b endif_280
else_280:
    // Bloque else
endif_280:

    // Procesando nodo: Condicion  Valor=resultadoComp1==true&&resultadoComp2==false&&resultadoComp3==true&&resultadoComp4==false

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosOperacionesRelacionales (int) en [sp, #248]
    mov x9, #2
    str x9, [sp, #248]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Mayor/Menor: correcto
    adr x0, lit_282
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_282
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_282
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_282
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Mayor o igual/Menor o igual
    adr x0, lit_284
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_284
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_284
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_284
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10 >\= 10:
    adr x0, lit_286
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_286
    mov x8, #64
    svc #0
    adr x0, space_287
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_287
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoComp5
    ldr x0, [sp, #336]
    cmp x0, #0
    beq print_false_289
    mov x0, #1
    adr x1, true_str_288
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_289
print_false_289:
    mov x0, #1
    adr x1, false_str_289
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_289:
    // Imprimir salto de línea
    adr x0, newline_289
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_289
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10 <\= 5:
    adr x0, lit_291
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_291
    mov x8, #64
    svc #0
    adr x0, space_292
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_292
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoComp6
    ldr x0, [sp, #344]
    cmp x0, #0
    beq print_false_294
    mov x0, #1
    adr x1, true_str_293
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_294
print_false_294:
    mov x0, #1
    adr x1, false_str_294
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_294:
    // Imprimir salto de línea
    adr x0, newline_294
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_294
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10.5 >\= 5.5:
    adr x0, lit_296
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_296
    mov x8, #64
    svc #0
    adr x0, space_297
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_297
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoComp7
    ldr x0, [sp, #352]
    cmp x0, #0
    beq print_false_299
    mov x0, #1
    adr x1, true_str_298
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_299
print_false_299:
    mov x0, #1
    adr x1, false_str_299
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_299:
    // Imprimir salto de línea
    adr x0, newline_299
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_299
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 10.5 <\= 10.5:
    adr x0, lit_301
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_301
    mov x8, #64
    svc #0
    adr x0, space_302
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_302
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoComp8
    ldr x0, [sp, #360]
    cmp x0, #0
    beq print_false_304
    mov x0, #1
    adr x1, true_str_303
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_304
print_false_304:
    mov x0, #1
    adr x1, false_str_304
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_304:
    // Imprimir salto de línea
    adr x0, newline_304
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_304
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: resultadoComp5==true&&resultadoComp6==false&&resultadoComp7==true&&resultadoComp8==true
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_305
    // Bloque if (then)
    b endif_305
else_305:
    // Bloque else
endif_305:

    // Procesando nodo: Condicion  Valor=resultadoComp5==true&&resultadoComp6==false&&resultadoComp7==true&&resultadoComp8==true

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 3 a puntosOperacionesRelacionales (int) en [sp, #248]
    mov x9, #3
    str x9, [sp, #248]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Mayor o igual/Menor o igual: correcto
    adr x0, lit_307
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_307
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_307
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_307
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= Operaciones Lógicas \=\=\=\=
    adr x0, lit_309
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_309
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_309
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_309
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: AND
    adr x0, lit_311
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_311
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_311
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_311
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: true && true:
    adr x0, lit_313
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_313
    mov x8, #64
    svc #0
    adr x0, space_314
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_314
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoAnd1
    ldr x0, [sp, #376]
    cmp x0, #0
    beq print_false_316
    mov x0, #1
    adr x1, true_str_315
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_316
print_false_316:
    mov x0, #1
    adr x1, false_str_316
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_316:
    // Imprimir salto de línea
    adr x0, newline_316
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_316
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: true && false:
    adr x0, lit_318
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_318
    mov x8, #64
    svc #0
    adr x0, space_319
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_319
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoAnd2
    ldr x0, [sp, #384]
    cmp x0, #0
    beq print_false_321
    mov x0, #1
    adr x1, true_str_320
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_321
print_false_321:
    mov x0, #1
    adr x1, false_str_321
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_321:
    // Imprimir salto de línea
    adr x0, newline_321
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_321
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: (10 \=\= 10) && (5 \=\= 5):
    adr x0, lit_323
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_323
    mov x8, #64
    svc #0
    adr x0, space_324
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_324
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoAnd3
    ldr x0, [sp, #392]
    cmp x0, #0
    beq print_false_326
    mov x0, #1
    adr x1, true_str_325
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_326
print_false_326:
    mov x0, #1
    adr x1, false_str_326
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_326:
    // Imprimir salto de línea
    adr x0, newline_326
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_326
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: (10 \=\= 10) && (5 \=\= 6):
    adr x0, lit_328
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_328
    mov x8, #64
    svc #0
    adr x0, space_329
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_329
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoAnd4
    ldr x0, [sp, #400]
    cmp x0, #0
    beq print_false_331
    mov x0, #1
    adr x1, true_str_330
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_331
print_false_331:
    mov x0, #1
    adr x1, false_str_331
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_331:
    // Imprimir salto de línea
    adr x0, newline_331
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_331
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: resultadoAnd1==true&&resultadoAnd2==false&&resultadoAnd3==true&&resultadoAnd4==false
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_332
    // Bloque if (then)
    b endif_332
else_332:
    // Bloque else
endif_332:

    // Procesando nodo: Condicion  Valor=resultadoAnd1==true&&resultadoAnd2==false&&resultadoAnd3==true&&resultadoAnd4==false

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 1 a puntosOperacionesLogicas (int) en [sp, #368]
    mov x9, #1
    str x9, [sp, #368]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK AND: correcto
    adr x0, lit_334
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_334
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_334
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_334
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OR
    adr x0, lit_336
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_336
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_336
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_336
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: true || false:
    adr x0, lit_338
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_338
    mov x8, #64
    svc #0
    adr x0, space_339
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_339
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoOr1
    ldr x0, [sp, #408]
    cmp x0, #0
    beq print_false_341
    mov x0, #1
    adr x1, true_str_340
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_341
print_false_341:
    mov x0, #1
    adr x1, false_str_341
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_341:
    // Imprimir salto de línea
    adr x0, newline_341
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_341
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: false || false:
    adr x0, lit_343
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_343
    mov x8, #64
    svc #0
    adr x0, space_344
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_344
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoOr2
    ldr x0, [sp, #416]
    cmp x0, #0
    beq print_false_346
    mov x0, #1
    adr x1, true_str_345
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_346
print_false_346:
    mov x0, #1
    adr x1, false_str_346
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_346:
    // Imprimir salto de línea
    adr x0, newline_346
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_346
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: (10 \=\= 10) || (5 \=\= 6):
    adr x0, lit_348
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_348
    mov x8, #64
    svc #0
    adr x0, space_349
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_349
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoOr3
    ldr x0, [sp, #424]
    cmp x0, #0
    beq print_false_351
    mov x0, #1
    adr x1, true_str_350
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_351
print_false_351:
    mov x0, #1
    adr x1, false_str_351
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_351:
    // Imprimir salto de línea
    adr x0, newline_351
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_351
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: (10 \=\= 11) || (5 \=\= 6):
    adr x0, lit_353
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_353
    mov x8, #64
    svc #0
    adr x0, space_354
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_354
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoOr4
    ldr x0, [sp, #432]
    cmp x0, #0
    beq print_false_356
    mov x0, #1
    adr x1, true_str_355
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_356
print_false_356:
    mov x0, #1
    adr x1, false_str_356
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_356:
    // Imprimir salto de línea
    adr x0, newline_356
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_356
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: resultadoOr1==true&&resultadoOr2==false&&resultadoOr3==true&&resultadoOr4==false
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_357
    // Bloque if (then)
    b endif_357
else_357:
    // Bloque else
endif_357:

    // Procesando nodo: Condicion  Valor=resultadoOr1==true&&resultadoOr2==false&&resultadoOr3==true&&resultadoOr4==false

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosOperacionesLogicas (int) en [sp, #368]
    mov x9, #2
    str x9, [sp, #368]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK OR: correcto
    adr x0, lit_359
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_359
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_359
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_359
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: NOT
    adr x0, lit_361
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_361
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_361
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_361
    mov x8, #64
    svc #0

    // Procesando nodo: Negacion  Valor=!

    // Procesando nodo: Negacion  Valor=!

    // Procesando nodo: Negacion  Valor=!

    // Procesando nodo: Negacion  Valor=!

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: !true:
    adr x0, lit_363
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_363
    mov x8, #64
    svc #0
    adr x0, space_364
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_364
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoNot1
    ldr x0, [sp, #440]
    cmp x0, #0
    beq print_false_366
    mov x0, #1
    adr x1, true_str_365
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_366
print_false_366:
    mov x0, #1
    adr x1, false_str_366
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_366:
    // Imprimir salto de línea
    adr x0, newline_366
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_366
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: !false:
    adr x0, lit_368
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_368
    mov x8, #64
    svc #0
    adr x0, space_369
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_369
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoNot2
    ldr x0, [sp, #448]
    cmp x0, #0
    beq print_false_371
    mov x0, #1
    adr x1, true_str_370
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_371
print_false_371:
    mov x0, #1
    adr x1, false_str_371
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_371:
    // Imprimir salto de línea
    adr x0, newline_371
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_371
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: !(10 \=\= 10):
    adr x0, lit_373
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_373
    mov x8, #64
    svc #0
    adr x0, space_374
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_374
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoNot3
    ldr x0, [sp, #456]
    cmp x0, #0
    beq print_false_376
    mov x0, #1
    adr x1, true_str_375
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_376
print_false_376:
    mov x0, #1
    adr x1, false_str_376
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_376:
    // Imprimir salto de línea
    adr x0, newline_376
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_376
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: !(10 \=\= 11):
    adr x0, lit_378
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_378
    mov x8, #64
    svc #0
    adr x0, space_379
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_379
    mov x8, #64
    svc #0
    // Imprimir booleano: resultadoNot4
    ldr x0, [sp, #464]
    cmp x0, #0
    beq print_false_381
    mov x0, #1
    adr x1, true_str_380
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_381
print_false_381:
    mov x0, #1
    adr x1, false_str_381
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_381:
    // Imprimir salto de línea
    adr x0, newline_381
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_381
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: resultadoNot1==false&&resultadoNot2==true&&resultadoNot3==false&&resultadoNot4==true
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_382
    // Bloque if (then)
    b endif_382
else_382:
    // Bloque else
endif_382:

    // Procesando nodo: Condicion  Valor=resultadoNot1==false&&resultadoNot2==true&&resultadoNot3==false&&resultadoNot4==true

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 3 a puntosOperacionesLogicas (int) en [sp, #368]
    mov x9, #3
    str x9, [sp, #368]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK NOT: correcto
    adr x0, lit_384
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_384
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_384
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_384
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= fmt.Println \=\=\=\=
    adr x0, lit_386
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_386
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_386
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_386
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\n###Validacion Manual
    adr x0, lit_388
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_388
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_388
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_388
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Impresión de valores simples
    adr x0, lit_390
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_390
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_390
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_390
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 42
    adr x0, lit_392
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_392
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_392
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_392
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 3.14
    adr x0, lit_394
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_394
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_394
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_394
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Texto
    adr x0, lit_396
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_396
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_396
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_396
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: true
    adr x0, lit_398
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_398
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_398
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_398
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: A
    adr x0, lit_400
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_400
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_400
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_400
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 
    adr x0, lit_402
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_402
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_402
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_402
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 1 a puntosPrintln (int) en [sp, #472]
    mov x9, #1
    str x9, [sp, #472]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Impresión de valores simples: correcto
    adr x0, lit_404
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_404
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_404
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_404
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Impresión de múltiples valores
    adr x0, lit_406
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_406
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_406
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_406
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Números:
    adr x0, lit_408
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_408
    mov x8, #64
    svc #0
    adr x0, space_409
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_409
    mov x8, #64
    svc #0
    // Imprimir literal: 42
    adr x0, lit_410
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_410
    mov x8, #64
    svc #0
    adr x0, space_411
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_411
    mov x8, #64
    svc #0
    // Imprimir literal: 3.14
    adr x0, lit_412
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_412
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_412
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_412
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Booleano:
    adr x0, lit_414
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_414
    mov x8, #64
    svc #0
    adr x0, space_415
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_415
    mov x8, #64
    svc #0
    // Imprimir literal: true
    adr x0, lit_416
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_416
    mov x8, #64
    svc #0
    adr x0, space_417
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_417
    mov x8, #64
    svc #0
    // Imprimir literal: Texto:
    adr x0, lit_418
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_418
    mov x8, #64
    svc #0
    adr x0, space_419
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_419
    mov x8, #64
    svc #0
    // Imprimir literal: Hola
    adr x0, lit_420
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_420
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_420
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_420
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosPrintln (int) en [sp, #472]
    mov x9, #2
    str x9, [sp, #472]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Impresión de múltiples valores: correcto
    adr x0, lit_422
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_422
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_422
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_422
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Impresión de expresiones
    adr x0, lit_424
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_424
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_424
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_424
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Suma:
    adr x0, lit_426
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_426
    mov x8, #64
    svc #0
    adr x0, space_427
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_427
    mov x8, #64
    svc #0
    // Imprimir literal: 15
    adr x0, lit_428
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_428
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_428
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_428
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Comparación:
    adr x0, lit_430
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_430
    mov x8, #64
    svc #0
    adr x0, space_431
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_431
    mov x8, #64
    svc #0
    // Imprimir literal: true
    adr x0, lit_432
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_432
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_432
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_432
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Lógica:
    adr x0, lit_434
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_434
    mov x8, #64
    svc #0
    adr x0, space_435
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_435
    mov x8, #64
    svc #0
    // Imprimir literal: false
    adr x0, lit_436
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_436
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_436
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_436
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 3 a puntosPrintln (int) en [sp, #472]
    mov x9, #3
    str x9, [sp, #472]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Impresión de expresiones: correcto
    adr x0, lit_438
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_438
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_438
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_438
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\=\= Manejo de valor nulo \=\=\=\=
    adr x0, lit_440
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_440
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_440
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_440
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Valores por defecto
    adr x0, lit_442
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_442
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_442
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_442
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\n###Validacion Manual
    adr x0, lit_444
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_444
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_444
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_444
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: enteroNulo:
    adr x0, lit_446
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_446
    mov x8, #64
    svc #0
    adr x0, space_447
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_447
    mov x8, #64
    svc #0
    // Imprimir entero: enteroNulo
    ldr x0, [sp, #488]
    adr x1, int_buffer_447
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_447
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_448
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_448
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: decimalNulo:
    adr x0, lit_450
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_450
    mov x8, #64
    svc #0
    adr x0, space_451
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_451
    mov x8, #64
    svc #0
    // Imprimir flotante: decimalNulo
    ldr d0, [sp, #496]
    adr x0, float_buffer_451
    bl float_to_string
    mov x2, x0
    mov x0, #1
    adr x1, float_buffer_451
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_452
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_452
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: textoNulo:
    adr x0, lit_454
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_454
    mov x8, #64
    svc #0
    adr x0, space_455
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_455
    mov x8, #64
    svc #0
    // Imprimir string: textoNulo
    ldr x0, [sp, #504]
    cmp x0, #0
    beq skip_print_455
    bl string_length
    mov x2, x0
    mov x0, #1
    ldr x1, [sp, #504]
    mov x8, #64
    svc #0
    b end_print_455
skip_print_455:
    adr x0, empty_str_455
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, empty_str_455
    mov x8, #64
    svc #0
end_print_455:
    // Imprimir salto de línea
    adr x0, newline_456
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_456
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: booleanoNulo:
    adr x0, lit_458
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_458
    mov x8, #64
    svc #0
    adr x0, space_459
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_459
    mov x8, #64
    svc #0
    // Imprimir booleano: booleanoNulo
    ldr x0, [sp, #512]
    cmp x0, #0
    beq print_false_461
    mov x0, #1
    adr x1, true_str_460
    mov x2, #4
    mov x8, #64
    svc #0
    b end_print_bool_461
print_false_461:
    mov x0, #1
    adr x1, false_str_461
    mov x2, #5
    mov x8, #64
    svc #0
end_print_bool_461:
    // Imprimir salto de línea
    adr x0, newline_461
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_461
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: 
    adr x0, lit_463
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_463
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_463
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_463
    mov x8, #64
    svc #0

    // Procesando nodo: IfStatement  Valor=

    // If Statement
    // Evaluar condición: enteroNulo==0&&decimalNulo==0.0&&textoNulo==""&&booleanoNulo==false
    // ADVERTENCIA: No se pudo evaluar condición 'True'
    mov x0, #0
    cmp x0, #0
    beq else_464
    // Bloque if (then)
    b endif_464
else_464:
    // Bloque else
endif_464:

    // Procesando nodo: Condicion  Valor=enteroNulo==0&&decimalNulo==0.0&&textoNulo==""&&booleanoNulo==false

    // Procesando nodo: Expresion  Valor=True

    // Procesando nodo: BloqueIf  Valor=

    // Procesando nodo: BloqueElse  Valor=

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 1 a puntosValorNulo (int) en [sp, #480]
    mov x9, #1
    str x9, [sp, #480]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Valores por defecto: correcto
    adr x0, lit_466
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_466
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_466
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_466
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: Operaciones con nil
    adr x0, lit_468
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_468
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_468
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_468
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 2 a puntosValorNulo (int) en [sp, #480]
    mov x9, #2
    str x9, [sp, #480]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: OK Operaciones con nil: correcto
    adr x0, lit_470
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_470
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_470
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_470
    mov x8, #64
    svc #0

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Operacion  Valor=+

    // Procesando nodo: Asignacion  Valor=
    // Asignando 20 a puntos (int) en [sp, #16]
    mov x9, #20
    str x9, [sp, #16]

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: \n\=\=\= Tabla de Resultados \=\=\=
    adr x0, lit_472
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_472
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_472
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_472
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +--------------------------+--------+-------+
    adr x0, lit_474
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_474
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_474
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_474
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | Característica           | Puntos | Total |
    adr x0, lit_476
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_476
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_476
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_476
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +--------------------------+--------+-------+
    adr x0, lit_478
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_478
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_478
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_478
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | Declaración de variables | 
    adr x0, lit_480
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_480
    mov x8, #64
    svc #0
    adr x0, space_481
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_481
    mov x8, #64
    svc #0
    // Imprimir entero: puntosDeclaracion
    ldr x0, [sp, #24]
    adr x1, int_buffer_481
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_481
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_483
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 3     |
    adr x0, lit_484
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_484
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_484
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_484
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | Asignación de variables  | 
    adr x0, lit_486
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_486
    mov x8, #64
    svc #0
    adr x0, space_487
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_487
    mov x8, #64
    svc #0
    // Imprimir entero: puntosAsignacion
    ldr x0, [sp, #136]
    adr x1, int_buffer_487
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_487
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_489
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 3     |
    adr x0, lit_490
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_490
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_490
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_490
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | Operaciones Aritméticas  | 
    adr x0, lit_492
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_492
    mov x8, #64
    svc #0
    adr x0, space_493
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_493
    mov x8, #64
    svc #0
    // Imprimir entero: puntosOperacionesAritmeticas
    ldr x0, [sp, #144]
    adr x1, int_buffer_493
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_493
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_495
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 3     |
    adr x0, lit_496
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_496
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_496
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_496
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | Operaciones Relacionales | 
    adr x0, lit_498
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_498
    mov x8, #64
    svc #0
    adr x0, space_499
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_499
    mov x8, #64
    svc #0
    // Imprimir entero: puntosOperacionesRelacionales
    ldr x0, [sp, #248]
    adr x1, int_buffer_499
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_499
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_501
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 3     |
    adr x0, lit_502
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_502
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_502
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_502
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | Operaciones Lógicas      | 
    adr x0, lit_504
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_504
    mov x8, #64
    svc #0
    adr x0, space_505
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_505
    mov x8, #64
    svc #0
    // Imprimir entero: puntosOperacionesLogicas
    ldr x0, [sp, #368]
    adr x1, int_buffer_505
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_505
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_507
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 3     |
    adr x0, lit_508
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_508
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_508
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_508
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | fmt.Println              | 
    adr x0, lit_510
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_510
    mov x8, #64
    svc #0
    adr x0, space_511
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_511
    mov x8, #64
    svc #0
    // Imprimir entero: puntosPrintln
    ldr x0, [sp, #472]
    adr x1, int_buffer_511
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_511
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_513
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 3     |
    adr x0, lit_514
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_514
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_514
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_514
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | Manejo de valor nulo     | 
    adr x0, lit_516
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_516
    mov x8, #64
    svc #0
    adr x0, space_517
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_517
    mov x8, #64
    svc #0
    // Imprimir entero: puntosValorNulo
    ldr x0, [sp, #480]
    adr x1, int_buffer_517
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_517
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_519
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:     | 2     |
    adr x0, lit_520
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_520
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_520
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_520
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +--------------------------+--------+-------+
    adr x0, lit_522
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_522
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_522
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_522
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: | TOTAL                    | 
    adr x0, lit_524
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_524
    mov x8, #64
    svc #0
    adr x0, space_525
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, space_525
    mov x8, #64
    svc #0
    // Imprimir entero: puntos
    ldr x0, [sp, #16]
    adr x1, int_buffer_525
    bl int_to_string
    mov x2, x0
    mov x0, #1
    adr x1, int_buffer_525
    mov x8, #64
    svc #0
    mov x0, #1
    adr x1, space_527
    mov x2, #1
    mov x8, #64
    svc #0
    // Imprimir literal:    | 20    |
    adr x0, lit_528
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_528
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_528
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_528
    mov x8, #64
    svc #0

    // Procesando nodo: fmt.Println  Valor=

    // fmt.Println
    // Imprimir literal: +--------------------------+--------+-------+
    adr x0, lit_530
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, lit_530
    mov x8, #64
    svc #0
    // Imprimir salto de línea
    adr x0, newline_530
    bl string_length
    mov x2, x0
    mov x0, #1
    adr x1, newline_530
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
