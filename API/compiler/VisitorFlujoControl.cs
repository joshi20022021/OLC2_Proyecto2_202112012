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
            
            // Crear el nodo Switch principal
            var nodoSwitch = new NodoAST {
                Tipo = "Switch",
                Hijos = new List<NodoAST> {
                    new NodoAST { 
                        Tipo = "Expresion", 
                        Valor = context.expresion().GetText() 
                    }
                }
            };
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

            // NUEVO: Crear nodo AST para el bucle For
            var nodoFor = new NodoAST {
                Tipo = "ForLoop",
                Hijos = new List<NodoAST> {
                    new NodoAST { 
                        Tipo = "Condicion", 
                        Valor = ctx.expresion().GetText(),
                        Hijos = new List<NodoAST> { 
                            new NodoAST { Tipo = "Expresion", Valor = ctx.expresion().GetText() }
                        }
                    }
                }
            };
            
            // NUEVO: Bloque For
            var bloqueForNodo = new NodoAST { Tipo = "BloqueFor", Hijos = new List<NodoAST>() };
            nodoFor.Hijos.Add(bloqueForNodo);
            
            // NUEVO: Añadir a la lista de nodos AST
            nodosAST.Add(nodoFor);

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

            // CREAR AST PARA FOR CLÁSICO
            var nodoFor = new NodoAST {
                Tipo = "ForClassicLoop",
                Hijos = new List<NodoAST>()
            };
            
            // 1. Inicialización
            var inicNodo = new NodoAST { Tipo = "Inicializacion", Hijos = new List<NodoAST>() };
            if (ctx.declaracion() != null) {
                inicNodo.Valor = ctx.declaracion().GetText();
                // Añadir información adicional si es necesario
            } else if (ctx.asignacion().Length > 0) {
                inicNodo.Valor = ctx.asignacion(0).GetText();
                // Añadir información adicional si es necesario
            }
            nodoFor.Hijos.Add(inicNodo);
            
            // 2. Condición
            var condNodo = new NodoAST { 
                Tipo = "Condicion", 
                Valor = ctx.expresion().GetText(),
                Hijos = new List<NodoAST> { 
                    new NodoAST { Tipo = "Expresion", Valor = ctx.expresion().GetText() }
                }
            };
            nodoFor.Hijos.Add(condNodo);
            
            // 3. Incremento
            var incNodo = new NodoAST { Tipo = "Incremento", Hijos = new List<NodoAST>() };
            if (ctx.contador() != null) {
                incNodo.Valor = ctx.contador().GetText();
                // Añadir información adicional si es necesario
            } else if (ctx.asignacion().Length > 1) {
                incNodo.Valor = ctx.asignacion(1).GetText();
                // Añadir información adicional si es necesario
            }
            nodoFor.Hijos.Add(incNodo);
            
            // 4. Bloque de código
            var bloqueForNodo = new NodoAST { Tipo = "BloqueFor", Hijos = new List<NodoAST>() };
            nodoFor.Hijos.Add(bloqueForNodo);
            
            // Añadir a la lista de nodos AST
            nodosAST.Add(nodoFor);
            
            // CÓDIGO DE EJECUCIÓN EXISTENTE
            // Inicialización
            if (ctx.declaracion() != null)
                Visit(ctx.declaracion());
            else if (ctx.asignacion().Length > 0)
                Visit(ctx.asignacion(0));

            try
                {
                    // 1. Inicialización
                    if (ctx.declaracion() != null)
                        Visit(ctx.declaracion());
                    else if (ctx.asignacion().Length > 0)
                        Visit(ctx.asignacion(0));

                    // 2. Bucle principal
                    while (true)
                    {
                        // Evaluar condición
                        object cond = Visit(ctx.expresion());
                        if (!(cond is bool bCond) || !bCond)
                            break; // Salir si la condición es falsa
                        
                        // Ejecutar el cuerpo del bucle
                        object resultado = Visit(ctx.bloque());
                        
                        // Manejar break y continue
                        if (resultado is BreakCommand)
                            break;
                            
                        if (resultado is ContinueCommand)
                            goto incremento; // Saltar directamente al incremento
                            
                        // 3. Incremento
                        incremento:
                        if (ctx.contador() != null)
                            Visit(ctx.contador());
                        else if (ctx.asignacion().Length > 1)
                            Visit(ctx.asignacion(1));
                    }
                }
                finally
                {
                    pilaEntornos.Pop();
                    EnCiclo = false;
                }
                
                return null;
        }

        public override object VisitForRange(LanguageParser.ForRangeContext context)
        {
            EnCiclo = true;
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());

            // Obtener los nombres del iterador y variable del contexto
            string iterador = context.IDENTIFICADOR(0).GetText();
            string variable = context.IDENTIFICADOR(1).GetText();
            
            // Crear nodo AST para el bucle For Range
            var nodoForRange = new NodoAST {
                Tipo = "ForRangeLoop",
                Hijos = new List<NodoAST> {
                    new NodoAST { 
                        Tipo = "Iterador", 
                        Valor = iterador
                    },
                    new NodoAST { 
                        Tipo = "Variable", 
                        Valor = variable
                    },
                    new NodoAST { 
                        Tipo = "Coleccion", 
                        Valor = context.expresion().GetText(),
                        Hijos = new List<NodoAST> { 
                            new NodoAST { Tipo = "Expresion", Valor = context.expresion().GetText() }
                        }
                    }
                }
            };
            
            // Bloque For
            var bloqueForNodo = new NodoAST { Tipo = "BloqueFor", Hijos = new List<NodoAST>() };
            nodoForRange.Hijos.Add(bloqueForNodo);
            
            // Añadir a la lista de nodos AST
            nodosAST.Add(nodoForRange);
            
            try
            {
                // Evaluar la colección
                object coleccion = Visit(context.expresion());
                
                // Verificar si es una lista
                if (!(coleccion is List<object> lista))
                {
                    AgregarError($"Error: range requiere un slice, obtuvo {TipoDato.ObtenerNombreTipo(coleccion)}", 
                                context.Start.Line, context.Start.Column);
                    return null;
                }

                // Iteración con manejo adecuado de break y continue
                for (int i = 0; i < lista.Count; i++)
                {
                    // Asignar valores a las variables del entorno actual
                    pilaEntornos.Peek()[iterador] = new EntradaSimbolo { 
                        Nombre = iterador, 
                        TipoDato = "int", 
                        Valor = i 
                    };
                    
                    pilaEntornos.Peek()[variable] = new EntradaSimbolo { 
                        Nombre = variable, 
                        TipoDato = TipoDato.ObtenerNombreTipo(lista[i]), 
                        Valor = lista[i] 
                    };

                    // Ejecutar el bloque
                    object resultado = Visit(context.bloque());
                    
                    // Manejar break y continue
                    if (resultado is BreakCommand)
                        break;
                        
                    // Si es continue, continuar automáticamente (no se necesita código adicional)
                }
            }
            finally
            {
                pilaEntornos.Pop();
                EnCiclo = false;
            }
            
            return null;
        }

        //manejo de for range

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
            // Validar si estamos dentro de un bucle
            if (!EnCiclo)
            {
                AgregarError("Error: 'continue' solo puede usarse dentro de un ciclo.", 
                            context.Start.Line, context.Start.Column + 1);
                return null;
            }

            // Es crítico retornar un nuevo objeto ContinueCommand
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