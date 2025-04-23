using System;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using API.compiler;

namespace API.compiler
{
    public partial class CompilerVisitor
    {
        //declaracion de structs
         public override object VisitStructDeclaracion(LanguageParser.StructDeclaracionContext context)
        { 
        string nombreStruct = context.IDENTIFICADOR().GetText();
        var structDef = StructManager.ObtenerStruct(nombreStruct);

        foreach (var attrCtx in context.atributoStruct()) {
            if (attrCtx is LanguageParser.AtributoContext atributo) {
                var resultado = Visit(atributo) as Tuple<string, string>;
                string tipoAttr = resultado.Item1;
                string nombreAttr = resultado.Item2;

                // Validar tipo 
                if (!TipoDato.EsTipoValido(tipoAttr) && !StructManager.ExisteStruct(tipoAttr)) {
                    AgregarError($"Tipo inválido '{tipoAttr}'", atributo.Start.Line, atributo.Start.Column);
                    continue;
                }

                    structDef.Atributos.Add(nombreAttr, tipoAttr);
                }
            }
            tablaSimbolos.Add(new EntradaSimbolo
            {
                TipoSimbolo = "Struct",
                Nombre = nombreStruct,
                TipoDato = "Struct",
                Ambito = "Global",
                Linea = context.Start.Line,
                Columna = context.Start.Column + 1
            });
            return null;
        }

        //visitar atributos del struct
        public override object VisitAtributo(LanguageParser.AtributoContext context)
        {
            string nombreAttr = context.IDENTIFICADOR().GetText(); 
            string tipo = context.tipo().GetText(); 
            
            return Tuple.Create(tipo, nombreAttr);
        }

        //visitar la expresion literal del struct
        public override object VisitExpresionLiteralStruct(LanguageParser.ExpresionLiteralStructContext context)
        {
            string nombreStruct = context.IDENTIFICADOR().GetText();
            var structDef = StructManager.ObtenerStruct(nombreStruct);
            
            var instancia = new StructInstance { Definicion = structDef };

            var atributosInitCtx = context.atributosInicializacion();
            if (atributosInitCtx != null)
            {
                var ids = atributosInitCtx.IDENTIFICADOR();
                var exprs = atributosInitCtx.expresion();

                for (int i = 0; i < ids.Length; i++)
                {
                    string nombreAttr = ids[i].GetText();
                    object valor = Visit(exprs[i]);

                    // Validar existencia del atributo
                    if (!structDef.Atributos.ContainsKey(nombreAttr)) 
                    {
                        AgregarError($"Atributo '{nombreAttr}' no existe en el struct '{nombreStruct}'",
                        ids[i].Symbol.Line, 
                        ids[i].Symbol.Column + 1);
                        continue;
                    }

                    instancia.Valores[nombreAttr] = valor;
                }
            }
            
            return instancia;
        }

        //visitar el accesso al atributo de struct
           public override object VisitExpresionAccesoAtributo(LanguageParser.ExpresionAccesoAtributoContext context) 
        {
            object padre = Visit(context.expresion());
            string nombreAttr = context.IDENTIFICADOR().GetText();
            
            // Manejar correctamente el caso cuando el padre es null
            if (padre == null) 
            {
                AgregarError($"Error: No se puede acceder al atributo '{nombreAttr}' de un valor nil", 
                        context.Start.Line, context.Start.Column);
                return null;
            }
            
            if (!(padre is StructInstance instancia)) 
            {
                AgregarError($"Error: No se puede acceder al atributo '{nombreAttr}' de un valor de tipo {TipoDato.ObtenerNombreTipo(padre)}", 
                        context.Start.Line, context.Start.Column);
                return null;
            }

            if (!instancia.Definicion.Atributos.ContainsKey(nombreAttr)) 
            {
                AgregarError($"Error: El atributo '{nombreAttr}' no existe en el struct '{instancia.Definicion.Nombre}'", 
                            context.Start.Line, context.Start.Column);
                return null;
            }

            return instancia.Valores.TryGetValue(nombreAttr, out object valor) ? valor : null;
        }

        //visitar la asignacion de atributo
        public override object VisitAsignacionAtributo(LanguageParser.AsignacionAtributoContext context)
        {
            object padre = Visit(context.expresion(0));
            string nombreAttr = context.IDENTIFICADOR().GetText();
            object nuevoValor = Visit(context.expresion(1));
            
            Console.WriteLine($"DEBUG: Asignación de atributo - Padre: {padre?.GetType().Name}, Atributo: {nombreAttr}, Valor: {nuevoValor}");
            
            if (padre == null)
            {
                AgregarError("No se puede asignar un atributo a un valor nil", context.Start.Line, context.Start.Column);
                return null;
            }
            
            if (!(padre is StructInstance instancia))
            {
                AgregarError($"Error: No se puede acceder al atributo '{nombreAttr}' de un valor de tipo {TipoDato.ObtenerNombreTipo(padre)}", 
                            context.Start.Line, context.Start.Column);
                return null;
            }
            
            // Verificar existencia del atributo
            if (!instancia.Definicion.Atributos.ContainsKey(nombreAttr))
            {
                AgregarError($"El atributo '{nombreAttr}' no existe en el struct '{instancia.Definicion.Nombre}'", 
                            context.Start.Line, context.Start.Column);
                return null;
            }
            
            // Verificar compatibilidad de tipo para asignaciones de struct
            string tipoAtributo = instancia.Definicion.Atributos[nombreAttr];
            if (StructManager.ExisteStruct(tipoAtributo) && !(nuevoValor is StructInstance || nuevoValor == null))
            {
                AgregarError($"El atributo '{nombreAttr}' espera un valor de tipo '{tipoAtributo}'", 
                            context.Start.Line, context.Start.Column);
                return null;
            }
            
            // Actualizar el valor del atributo
            instancia.Valores[nombreAttr] = nuevoValor;
            Console.WriteLine($"DEBUG: Atributo actualizado correctamente: {nombreAttr} = {nuevoValor}");
            return nuevoValor;
        }


        //visitar el metodo struct
        public override object VisitMetodoStruct(LanguageParser.MetodoStructContext context)
        {
            // Obtener el receptor y el tipo del receptor
            string receptor = context.IDENTIFICADOR(0).GetText();         
            string tipoStruct = context.IDENTIFICADOR(1).GetText();      
            string nombreMetodo = context.IDENTIFICADOR(2).GetText();        

            // Validar existencia del struct usando el tipo correcto
            if (!StructManager.ExisteStruct(tipoStruct))
            {
                AgregarError($"Struct '{tipoStruct}' no existe", context.Start.Line, context.Start.Column);
                return null;
            }

            // Procesar parámetros 
            List<Tuple<string, string>> parametros = new List<Tuple<string, string>>();
            var parametrosContext = context.parametros();
            if (parametrosContext != null)
            {
                foreach (var paramCtx in parametrosContext.parametro())
                {
                    string tipo = paramCtx.tipo().GetText();
                    string nombre = paramCtx.IDENTIFICADOR().GetText();
                    parametros.Add(Tuple.Create(tipo, nombre));
                }
            }

            // Registrar el método en la tabla de funciones del struct
            string key = $"{tipoStruct}_{nombreMetodo}";
            _tablaFuncionesStruct[key] = new MetodoStruct
            {
                Nombre = nombreMetodo,
                Parametros = parametros,
                Bloque = context.bloque()
            };

            return null;
        }
            
    }
}