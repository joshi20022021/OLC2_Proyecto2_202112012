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
          //sentencia if y else

        public override object VisitIfElse(LanguageParser.IfElseContext ctx)
        {
            // Evaluar la condición principal
    // Evaluar la condición principal
            object cond = Visit(ctx.expresion());
            
            // Crear nodo AST para la estructura if/else
            var nodoIf = new NodoAST {
                Tipo = "IfStatement",
                Hijos = new List<NodoAST> {
                    new NodoAST { 
                        Tipo = "Condicion", 
                        Valor = ctx.expresion().GetText(),
                        Hijos = new List<NodoAST> { 
                            // AQUÍ ESTÁ EL ERROR - Cambia esto:
                            // new NodoAST { Tipo = "Expresion", Valor = cond }
                            // Por esto:
                            new NodoAST { Tipo = "Expresion", Valor = cond?.ToString() }
                        }
                    }
                }
            };
            // Bloque if (then)
            var bloqueIfNodo = new NodoAST { Tipo = "BloqueIf", Hijos = new List<NodoAST>() };
            nodoIf.Hijos.Add(bloqueIfNodo);
            
            // Bloque else (si existe)
            if (ctx.bloque().Length > 1 || ctx.ifStmt() != null) {
                var bloqueElseNodo = new NodoAST { Tipo = "BloqueElse", Hijos = new List<NodoAST>() };
                nodoIf.Hijos.Add(bloqueElseNodo);
            }
            
            // Añadir a la lista de nodos AST
            nodosAST.Add(nodoIf);
            
            // Lógica de ejecución (tu código existente)
            if (cond is bool boolCond)
            {
                // Caso 1: La condición principal es verdadera
                if (boolCond)
                {
                    pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
                    var resultado = Visit(ctx.bloque(0)); // Primer bloque (if)
                    pilaEntornos.Pop();
                    return resultado;
                }
                
                // Caso 2: La condición no es verdadera, verificar si hay un else o else if
                if (ctx.ifStmt() != null)
                {
                    // Es un else if
                    return Visit(ctx.ifStmt());
                }
                else if (ctx.bloque().Length > 1)
                {
                    // Es un else simple
                    pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
                    var resultado = Visit(ctx.bloque(1)); // Segundo bloque (else)
                    pilaEntornos.Pop();
                    return resultado;
                }
            }
            else
            {
                var token = ctx.expresion().Start;
                AgregarError("Error: La condición del if debe ser booleana.", 
                        token.Line, 
                        token.Column + 1);
            }
            
            return null;
        }
        //switch case        
        public override object VisitSwitch(LanguageParser.SwitchContext context)
        {
            EnSwitch = true;
            var switchValue = Visit(context.expresion());

            // Verificar que switchValue no sea nulo, etc.

            foreach (var caseBlock in context.caseBlock())
            {
                var caseValue = Visit(caseBlock.expresion());
                if (switchValue.Equals(caseValue))
                {
                    // Entramos al bloque de ese case
                    object resultado = Visit(caseBlock);

                    // Si hay un BreakCommand, salimos del switch
                    if (resultado is BreakCommand)
                    {
                        EnSwitch = false;
                        return null; 
                    }
                    EnSwitch = false;
                    return null;
                }
            }

            // Si no se cumplió ningún case verificar si break existe
            if (context.defaultBlock() != null)
            {
                object resultado = Visit(context.defaultBlock());
                if (resultado is BreakCommand)
                {
                    EnSwitch = false;
                    return null;
                }
            }

            EnSwitch = false;
            return null;
        }


        public override object VisitCaseBlock(LanguageParser.CaseBlockContext ctx)
        {
            // Primero visitamos las sentencias
            foreach (var st in ctx.sentencia())
            {
                var result = Visit(st);
                if (result is BreakCommand || result is ContinueCommand)
                {
                    return result;
                }
                if (result is Tuple<string, object> ret && ret.Item1 == "RETURN")
                {
                    return ret;
                }
            }

            if (ctx.breakStmt() != null)
            {
                var breakResult = VisitBreakStmt(ctx.breakStmt());
                return breakResult; // Esto retornará BreakCommand
            }

            return null;
        }


        //for con condicion
        public override object VisitForCondicion(LanguageParser.ForCondicionContext ctx)
        {
            EnCiclo = true;
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>(pilaEntornos.Count > 0 
                ? pilaEntornos.Peek() 
                : new Dictionary<string, EntradaSimbolo>()));

            try
            {
                object cond = Visit(ctx.expresion());

                while (cond is bool bCond && bCond)
                {
                    // Ejecutar el bloque
                    object resultado = Visit(ctx.bloque());
                    
                    if (resultado is BreakCommand)
                        break;
                    
                    // Si es continue, simplemente saltamos al siguiente ciclo
                    if (resultado is ContinueCommand)
                    {
                        cond = Visit(ctx.expresion());
                        continue; // Esta línea es crucial
                    }
                    
                    // Reevaluar la condición para el siguiente ciclo
                    cond = Visit(ctx.expresion());
                }
            }
            finally
            {
                pilaEntornos.Pop();
                EnCiclo = false;
            }
            return null;
        }

        //for clasico con contador
        public override object VisitForClasico(LanguageParser.ForClasicoContext ctx)
        {
            EnCiclo = true;
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());

            // Inicialización
            if (ctx.declaracion() != null)
                Visit(ctx.declaracion());
            else if (ctx.asignacion().Length > 0)
                Visit(ctx.asignacion(0));

            // Bucle
            while (true)
            {
                // Evaluar condición
                object cond = Visit(ctx.expresion());
                if (!(cond is bool bCond) || !bCond)
                    break;

                // Ejecutar bloque
                object resultado = Visit(ctx.bloque());
                
                // Si hay un break, salir del bucle
                if (resultado is BreakCommand)
                    break;
                
                // Si hay un continue, saltar la iteración
                if (resultado is ContinueCommand)
                {
                    // Aplicar incremento si existe
                    if (ctx.contador() != null)
                        Visit(ctx.contador());
                    else if (ctx.asignacion().Length > 1)
                        Visit(ctx.asignacion(1));
                    
                    continue;
                }

                // Aplicar incremento si existe
                if (ctx.contador() != null)
                    Visit(ctx.contador());
                else if (ctx.asignacion().Length > 1)
                    Visit(ctx.asignacion(1));
            }

            pilaEntornos.Pop();
            EnCiclo = false;
            return null;
        }


        //manejo de for range
        public override object VisitForRange(LanguageParser.ForRangeContext context)
        {
            EnCiclo = true;
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());

            // Obtener los nombres del iterador y variable del contexto
            string iterador = context.IDENTIFICADOR(0).GetText();
            string variable = context.IDENTIFICADOR(1).GetText();
            
            // Obtener la colección a iterar
            object coleccion = Visit(context.expresion());
            
            // Verificar si es una lista (slice)
            if (!(coleccion is List<object> lista))
            {
                AgregarError($"Error: range requiere un slice, obtuvo {TipoDato.ObtenerNombreTipo(coleccion)}", 
                            context.Start.Line, context.Start.Column);
                pilaEntornos.Pop();
                EnCiclo = false;
                return null;
            }

            // Iterar sobre la lista
            for (int i = 0; i < lista.Count; i++)
            {
                pilaEntornos.Peek()[iterador] = new EntradaSimbolo { Nombre = iterador, TipoDato = "int", Valor = i };
                pilaEntornos.Peek()[variable] = new EntradaSimbolo { Nombre = variable, TipoDato = TipoDato.ObtenerNombreTipo(lista[i]), Valor = lista[i] };

                // Ejecutar el bloque y verificar si devuelve un break o continue
                var resultado = Visit(context.bloque());
                if (resultado is BreakCommand)
                    break;
                if (resultado is ContinueCommand)
                    continue;
            }

            pilaEntornos.Pop();
            EnCiclo = false;
            return null;
        }
            public override object VisitBloque(LanguageParser.BloqueContext context)
        {
            // Recorremos
            foreach (var stmt in context.sentencia())
            {
                // Visitamos la sentencia concreta
                var result = Visit(stmt);

                if (result is BreakCommand || result is ContinueCommand)
                {
                    return result; 
                }
                // IMPORTANTE: Buscar "RETURN" en lugar de "return"
                else if (result is Tuple<string, object> retorno && retorno.Item1 == "RETURN")
                {
                    return retorno; 
                }
            }
            // devolvemos null
            return null;
        }



        // Método común para actualizar el contador
            private object ActualizarContador(string varName, int delta, ParserRuleContext context)
        {
            // Buscar la variable
            object valorActual = null;
            foreach (var env in pilaEntornos)
            {
                if (env.ContainsKey(varName))
                {
                    valorActual = env[varName].Valor;
                    break;
                }
            }
            
            if (valorActual == null)
            {
                var simboloGlobal = tablaSimbolos.Find(s => s.Nombre == varName);
                if (simboloGlobal != null)
                    valorActual = simboloGlobal.Valor;
            }

            if (valorActual is long longVal)
            {
                long nuevoValor = longVal + delta;
                // Actualizar en el entorno
                foreach (var env in pilaEntornos)
                {
                    if (env.ContainsKey(varName))
                    {
                        env[varName].Valor = nuevoValor;
                        return nuevoValor;
                    }
                }
                // Actualizar global si no está en la pila
                var simbolo = tablaSimbolos.Find(s => s.Nombre == varName);
                if (simbolo != null)
                    simbolo.Valor = nuevoValor;
                return nuevoValor;
            }
            else
            {
                AgregarError($"Error: '{varName}' no es un entero.", context.Start.Line, context.Start.Column + 1);
                return valorActual;
            }
        }

        // Visitor para el incremento
        public override object VisitIncremento(LanguageParser.IncrementoContext context)
        {
            string varName = context.IDENTIFICADOR().GetText();
            // parámetro 'context'
            return ActualizarContador(varName, 1, context);
        }

        public override object VisitDecremento(LanguageParser.DecrementoContext context)
        {
            string varName = context.IDENTIFICADOR().GetText();
            // parámetro 'context'
            return ActualizarContador(varName, -1, context);
        }


        //implementacion break
        public override object VisitBreakStmt(LanguageParser.BreakStmtContext context)
        {
            Console.WriteLine("DEBUG: Se encontró un 'break'");

            // Validar si estamos dentro de un bucle o un switch
            if (!EnCiclo && !EnSwitch)
            {
                AgregarError("Error: 'break' solo puede usarse dentro de un ciclo o switch.", 
                            context.Start.Line, 
                            context.Start.Column + 1);
                return null;
            }

            // Retornar el comando de break
            return new BreakCommand();
        }


        //implementacion continue
        public override object VisitContinueStmt(LanguageParser.ContinueStmtContext context)
        {
            Console.WriteLine("DEBUG: Se encontró un 'continue'");

            // Validar si estamos dentro de un bucle
            if (!EnCiclo)
            {
            AgregarError("Error: 'continue'...", context.Start.Line, context.Start.Column + 1);
                return null;
            }

            // Retornar el objeto ContinueCommand
            return new ContinueCommand();
        }

        //implementacion return
        public override object VisitReturnStmt(LanguageParser.ReturnStmtContext context)
        {
            if (!EnFuncion)
            {
                var token = context.Start;
                AgregarError("Error: 'return' solo puede usarse dentro de una función.", token.Line, token.Column + 1);
                return null;
            }

            object valorRetorno = null;
            if (context.expresion() != null)
            {
                valorRetorno = Visit(context.expresion());
            }

            // Usar "RETURN" en mayúsculas para ser consistente
            return new Tuple<string, object>("RETURN", valorRetorno ?? "nulo");
        }
    }
}