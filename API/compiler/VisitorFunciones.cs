using System;
using System.Collections.Generic;
using System.Globalization;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using API.compiler;

namespace API.compiler
{
    public partial class CompilerVisitor
    {
            //visitar la declaracion de la funcion
        public override object VisitFuncionDeclaracion(LanguageParser.FuncionDeclaracionContext context)
        {
            // Validar que se esté declarando en ámbito global
            if (_ambitoActual.Count > 0 && _ambitoActual.Peek() != "Global")
            {
                AgregarError("Las funciones solo pueden declararse en el ámbito global", context.Start.Line, context.Start.Column);
                return null;
            }

            string nombreFuncion = context.IDENTIFICADOR().GetText();
            
            // Validar unicidad del nombre
            if (tablaFunciones.ContainsKey(nombreFuncion))
            {
                AgregarError($"La función '{nombreFuncion}' ya está definida", context.Start.Line, context.Start.Column);
                return null;
            }

            // Procesar parámetros, si existen
            List<Tuple<string, string>> parametros = new List<Tuple<string, string>>();
            if (context.parametros() != null)
            {
                foreach (var paramCtx in context.parametros().parametro())
                {
                    string nombreParam = paramCtx.IDENTIFICADOR().GetText();
                    string tipoParam = paramCtx.tipo().GetText();
                    if (parametros.Any(p => p.Item2 == nombreParam))
                    {
                        AgregarError($"Parámetro duplicado: '{nombreParam}'", paramCtx.Start.Line, paramCtx.Start.Column);
                        continue;
                    }
                    parametros.Add(Tuple.Create(tipoParam, nombreParam));
                }
            }

            // Determinar tipo de retorno (si no se especifica, es "void")
            string tipoRetorno = "void";
            if (context.tipo() != null)
            {
                tipoRetorno = context.tipo().GetText();
            }

            // Registrar la función
            Funcion f = new Funcion
            {
                Nombre = nombreFuncion,
                Parametros = parametros,
                TipoRetorno = tipoRetorno,
                Bloque = context.bloque()
            };
            tablaFunciones.Add(nombreFuncion, f);

            tablaSimbolos.Add(new EntradaSimbolo
            {
                TipoSimbolo = "Función",
                Nombre = nombreFuncion,
                TipoDato = tipoRetorno,
                Ambito = "Global",
                Linea = context.Start.Line,
                Columna = context.Start.Column + 1
            });
            var nodoFuncion = new NodoAST
            {
                Tipo = "FuncionDeclaracion",
                Valor = nombreFuncion,
                Hijos = new List<NodoAST>()
            };
            
            // Añadir tipo de retorno
            tipoRetorno = context.tipo()?.GetText() ?? "void";
            nodoFuncion.Hijos.Add(new NodoAST
            {
                Tipo = "TipoRetorno",
                Valor = tipoRetorno
            });
            
            // Añadir parámetros
            if (context.parametros() != null)
            {
                var parametrosNodo = new NodoAST
                {
                    Tipo = "Parametros",
                    Hijos = new List<NodoAST>()
                };
                
                foreach (var param in context.parametros().parametro())
                {
                    parametrosNodo.Hijos.Add(new NodoAST
                    {
                        Tipo = "Parametro",
                        Valor = param.IDENTIFICADOR().GetText(),
                        Hijos = new List<NodoAST> {
                            new NodoAST {
                                Tipo = "TipoParametro",
                                Valor = param.tipo().GetText()
                            }
                        }
                    });
                }
                
                nodoFuncion.Hijos.Add(parametrosNodo);
            }
            
            // Añadir bloque de código
            var bloqueNodo = new NodoAST
            {
                Tipo = "BloqueFuncion",
                Hijos = new List<NodoAST>() // Se llenará con las instrucciones
            };
            nodoFuncion.Hijos.Add(bloqueNodo);
            
            // Añadir al AST global
            nodosAST.Add(nodoFuncion);
            
            return null;
        }
        //visitar la llamada a la funcion
         public override object VisitFuncionCall(LanguageParser.FuncionCallContext context)
        {
            // Obtener el nombre de la función
            string nombreFuncion = string.Join(".", context.IDENTIFICADOR().Select(id => id.GetText()));
            
            // Evaluar argumentos
            List<object> argumentos = new List<object>();
            if (context.expresion() != null)
            {
                foreach (var expr in context.expresion())
                {
                    argumentos.Add(Visit(expr));
                }
            }
            
            // --- Verificar funciones del sistema ---
            // fmt.Println y otras funciones nativas
            if (nombreFuncion == "fmt.Println")
            {
                // Tu código actual para fmt.Println
                List<string> valores = new List<string>();
                foreach (var arg in argumentos)
                {
                    Console.WriteLine($"DEBUG: Valor a imprimir - Tipo: {arg?.GetType().Name}, Valor: {arg}");
                    valores.Add(FormatearValor(arg));
                }
                string salida = string.Join(" ", valores);
                Console.WriteLine($"DEBUG: Salida formateada: '{salida}'");
                mensajesSalida.Add(salida);
                return null;
            }
            else if (nombreFuncion == "strconv.Atoi")
            {
                if (argumentos.Count != 1 || !(argumentos[0] is string s))
                {
                    AgregarError("strconv.Atoi requiere una cadena de texto.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (s.Contains("."))
                {
                    AgregarError("strconv.Atoi no puede convertir un número decimal.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (long.TryParse(s, out long resultado))
                {
                    return resultado;
                }
                else
                {
                    AgregarError("strconv.Atoi: cadena no convertible a entero.", context.Start.Line, context.Start.Column);
                    return null;
                }
            }
            else if (nombreFuncion == "strconv.ParseFloat")
            {
                if (argumentos.Count != 1 || !(argumentos[0] is string s))
                {
                    AgregarError("strconv.ParseFloat requiere una cadena de texto.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (double.TryParse(s, NumberStyles.Any, CultureInfo.InvariantCulture, out double resultado))
                {
                    return resultado;
                }
                else
                {
                    AgregarError("strconv.ParseFloat: cadena no convertible a float64.", context.Start.Line, context.Start.Column);
                    return null;
                }
            }
            else if (nombreFuncion == "slices.Index")
            {
                if (argumentos.Count != 2)
                {
                    AgregarError("slices.Index requiere dos argumentos: un slice y un valor a buscar.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (!(argumentos[0] is List<object> lista))
                {
                    AgregarError("El primer argumento de slices.Index debe ser un slice.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                object valorBuscado = argumentos[1];
                
                // Buscar el valor en la lista
                for (int i = 0; i < lista.Count; i++)
                {
                    if (lista[i]?.Equals(valorBuscado) == true)
                    {
                        return i;
                    }
                }
                
                // Si no se encuentra, retornar -1
                return -1;
            }
            else if (nombreFuncion == "strings.Join")
            {
                if (argumentos.Count != 2)
                {
                    AgregarError("strings.Join requiere dos argumentos: un slice de strings y un separador.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (!(argumentos[0] is List<object> lista))
                {
                    AgregarError("El primer argumento de strings.Join debe ser un slice.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                string separador = argumentos[1]?.ToString() ?? "";
                
                // Convertir todos los elementos a string
                List<string> strings = new List<string>();
                foreach (var item in lista)
                {
                    strings.Add(item?.ToString() ?? "nulo");
                }
                
                return string.Join(separador, strings);
            }
            else if (nombreFuncion == "reflect.TypeOf")
            {
                if (argumentos.Count != 1)
                {
                    AgregarError("reflect.TypeOf requiere un argumento.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                object valor = argumentos[0];
                
                if (valor == null)
                    return "nil";
                
                // Determinar el tipo de forma correcta para Go
                string tipo;
                if (valor is long)
                    tipo = "int";
                else if (valor is double)
                    tipo = "float64";
                else if (valor is string)
                    tipo = "string";
                else if (valor is bool)
                    tipo = "bool";
                else if (valor is List<object>)
                {
                    // Para slices, intentamos inferir el tipo basado en el primer elemento
                    var lista = (List<object>)valor;
                    if (lista.Count > 0 && lista[0] is long)
                        tipo = "[]int";
                    else if (lista.Count > 0 && lista[0] is double)
                        tipo = "[]float64";
                    else if (lista.Count > 0 && lista[0] is string)
                        tipo = "[]string";
                    else if (lista.Count > 0 && lista[0] is bool)
                        tipo = "[]bool";
                    else
                        tipo = "[]interface{}";
                }
                else if (valor is StructInstance si)
                    tipo = si.Definicion.Nombre;
                else
                    tipo = "interface{}";
                
                return tipo;
            }

            // SI es un struct, métodos
            else if (argumentos.Count > 0 && argumentos[0] is StructInstance instancia)
            {
                string key = $"{instancia.Definicion.Nombre}_{nombreFuncion}";
                if (_tablaFuncionesStruct.TryGetValue(key, out MetodoStruct metodo))
                {
                    // Verificar número de parámetros
                    if (metodo.Parametros.Count != argumentos.Count - 1)
                    {
                        AgregarError($"Número incorrecto de parámetros para {nombreFuncion}",
                                    context.Start.Line, context.Start.Column + 1);
                        return null;
                    }
                    
                    // Crear nuevo entorno
                    _ambitoActual.Push(nombreFuncion);
                    EnFuncion = true;
                    pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
                    
                    // Registrar parámetros en el entorno
                    for (int i = 0; i < metodo.Parametros.Count; i++)
                    {
                        string nombreParam = metodo.Parametros[i].Item2;
                        pilaEntornos.Peek()[nombreParam] = new EntradaSimbolo { 
                            Nombre = nombreParam,
                            Valor = argumentos[i + 1] 
                        };
                    }
                    
                    // Agregar la instancia 
                    pilaEntornos.Peek()["this"] = new EntradaSimbolo {
                        Nombre = "this",
                        Valor = instancia
                    };
                    
                    // Ejecutar el bloque del método
                    object resultado = Visit(metodo.Bloque);
                    
                    // Manejar el valor de retorno
                    if (resultado is Tuple<string, object> retVal && retVal.Item1 == "RETURN")
                    {
                        pilaEntornos.Pop();
                        EnFuncion = false;
                        _ambitoActual.Pop();
                        return retVal.Item2;
                    }
                    
                    pilaEntornos.Pop();
                    EnFuncion = false;
                    _ambitoActual.Pop();
                    return null;
                }
            }
        else if (nombreFuncion == "ObtenerSiguienteNombre" && argumentos.Count > 0 && 
        argumentos[0] is StructInstance instanciaOSN && instanciaOSN.Definicion.Nombre == "Nodo")
    {
        // Verificar primero si existe el atributo Siguiente
        if (!instanciaOSN.Valores.TryGetValue("Siguiente", out object siguiente) || siguiente == null)
        {
            Console.WriteLine("DEBUG: ObtenerSiguienteNombre - No hay siguiente nodo");
            return "No hay siguiente nodo";
        }
        
        // Si el siguiente existe, buscar su nombre
        if (siguiente is StructInstance siguienteStruct && 
            siguienteStruct.Valores.TryGetValue("Nombre", out object nombreSiguiente))
        {
            Console.WriteLine($"DEBUG: ObtenerSiguienteNombre - Nombre del siguiente: {nombreSiguiente}");
            return nombreSiguiente?.ToString() ?? "nulo";
        }
        
        Console.WriteLine("DEBUG: ObtenerSiguienteNombre - Estructura incorrecta");
        return "No hay siguiente nodo";
    }
        else if (nombreFuncion == "CambiarValor" && argumentos.Count > 0 && 
                argumentos[0] is StructInstance instanciaCV && instanciaCV.Definicion.Nombre == "Nodo")
        {
            // Asegurarse de que hay un parámetro
            if (argumentos.Count != 2) 
            {
                AgregarError("CambiarValor requiere un valor entero", context.Start.Line, context.Start.Column);
                return null;
            }
            
            // Asignar el nuevo valor directamente
            instanciaCV.Valores["Valor"] = argumentos[1];
            
            return null;
        }
            if (tablaFunciones.TryGetValue(nombreFuncion, out Funcion funcion))
            {
                // Crear nuevo entorno para la función
                _ambitoActual.Push(nombreFuncion);
                EnFuncion = true;
                pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
                
                // Verificar número de parámetros
                if (funcion.Parametros.Count != argumentos.Count)
                {
                    AgregarError($"Error: La función '{nombreFuncion}' espera {funcion.Parametros.Count} parámetros, pero recibió {argumentos.Count}.",
                                context.Start.Line, context.Start.Column);
                    pilaEntornos.Pop();
                    EnFuncion = false;
                    _ambitoActual.Pop();
                    return null;
                }
                
                // Registrar parámetros en el entorno de la función
                for (int i = 0; i < funcion.Parametros.Count; i++)
                {
                    string tipoParam = funcion.Parametros[i].Item1;
                    string nombreParam = funcion.Parametros[i].Item2;
                    object valorParam = argumentos[i];
                    
                    // Agregar al entorno
                    pilaEntornos.Peek()[nombreParam] = new EntradaSimbolo
                    {
                        Nombre = nombreParam,
                        TipoDato = tipoParam,
                        Valor = valorParam,
                        Ambito = nombreFuncion,
                        Linea = context.Start.Line,
                        Columna = context.Start.Column
                    };
                }
                
                // Ejecutar el bloque de la función
                object resultado = Visit(funcion.Bloque);
                
                // Manejar el valor de retorno
                if (resultado is Tuple<string, object> retVal && retVal.Item1 == "RETURN")
                {
                    pilaEntornos.Pop();
                    EnFuncion = false;
                    _ambitoActual.Pop();
                    return retVal.Item2;
                }
            
                pilaEntornos.Pop();
                EnFuncion = false;
                _ambitoActual.Pop();
                return null;
            }
            
            AgregarError($"Función no implementada: {nombreFuncion}", context.Start.Line, context.Start.Column);
            return null;
        }
                //visitor para la funcion main
        public override object VisitFuncionMain(LanguageParser.FuncionMainContext context)
        {
            var funcionSymbol = new EntradaSimbolo
            {
                TipoSimbolo = "Función",
                Nombre = "main",
                TipoDato = "void",
                Ambito = "Global",
                Linea = context.Start.Line,
                Columna = context.Start.Column + 1
            };
            
            tablaSimbolos.Add(funcionSymbol);
            _ambitoActual.Push("main");
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>()); // Iniciar entorno global
            var resultado = Visit(context.bloque());
            pilaEntornos.Pop(); // Eliminar el entorno al salir
            _ambitoActual.Pop();
            return resultado;
        }
     //visitar la funcion Atoi
        public override object VisitFuncionAtoi(LanguageParser.FuncionAtoiContext context)
        {
            object valor = Visit(context.expresion());

            // Agregar logging para depuración
            Console.WriteLine($"DEBUG: strconv.Atoi recibió: {valor} de tipo {valor?.GetType().Name ?? "null"}");

            if (valor is string s)
            {
                if (s.Contains("."))
                {
                    AgregarError("strconv.Atoi no puede convertir un número decimal.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (long.TryParse(s, out long resultado))
                {
                    Console.WriteLine($"DEBUG: strconv.Atoi convertido exitosamente a: {resultado}");
                    return resultado;
                }
                else
                {
                    AgregarError("strconv.Atoi: cadena no convertible a entero.", context.Start.Line, context.Start.Column);
                    return null;
                }
            }
            else
            {
                AgregarError("strconv.Atoi requiere una cadena de texto.", context.Start.Line, context.Start.Column);
                return null;
            }
        }
            
        //convertir a parsefloat
        public override object VisitFuncionParseFloat(LanguageParser.FuncionParseFloatContext context)
        {
            object valor = Visit(context.expresion());
            
            if (!(valor is string s))
            {
                AgregarError("strconv.ParseFloat requiere una cadena de texto.", context.Start.Line, context.Start.Column);
                return null;
            }
            
            if (double.TryParse(s, NumberStyles.Any, CultureInfo.InvariantCulture, out double resultado))
            {
                return resultado;
            }
            else
            {
                AgregarError("strconv.ParseFloat: cadena no convertible a float64.", context.Start.Line, context.Start.Column);
                return null;
            }
        }

        public override object VisitFuncionTypeOf(LanguageParser.FuncionTypeOfContext context)
        {
            object valor = Visit(context.expresion());
            
            Console.WriteLine($"DEBUG: reflect.TypeOf recibió: {valor} de tipo {valor?.GetType().Name ?? "null"}");
            
            // Determinar el tipo de forma correcta para Go
            string tipo;
            if (valor == null)
                tipo = "nil";
            else if (valor is long)
                tipo = "int";
            else if (valor is double)
                tipo = "float64";
            else if (valor is string)
                tipo = "string";
            else if (valor is bool)
                tipo = "bool";
            else if (valor is List<object> lista)
            {
                // Mejorado el manejo de slices
                if (lista.Count == 0)
                    tipo = "[]interface{}";
                else if (lista.All(i => i is long))
                    tipo = "[]int";
                else if (lista.All(i => i is double))
                    tipo = "[]float64";
                else if (lista.All(i => i is string))
                    tipo = "[]string";
                else if (lista.All(i => i is bool))
                    tipo = "[]bool";
                else
                    tipo = "[]interface{}";
            }
            else if (valor is StructInstance si)
                tipo = si.Definicion.Nombre;
            else
                tipo = "interface{}";
            
            Console.WriteLine($"DEBUG: reflect.TypeOf de {valor} devolvió: {tipo}");
            return tipo;
        }
    }
}