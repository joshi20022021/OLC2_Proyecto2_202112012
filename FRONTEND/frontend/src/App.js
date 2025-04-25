import React, { useState, useEffect, useCallback } from 'react';
import Viz from '@aduh95/viz.js';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';

// Función para convertir AST a DOT 
function astToDot(ast) {
  let dot = "digraph AST {\n";
  let id = 0;
  function traverse(node) {
    const currentId = id++;
    let label = node.Tipo;
    if (node.Valor) {
      label += "\\n" + node.Valor;
    }
    dot += `  node${currentId} [label="${label}"];\n`;
    if (node.Hijos && node.Hijos.length) {
      for (let child of node.Hijos) {
        const childId = id;
        traverse(child);
        dot += `  node${currentId} -> node${childId};\n`;
      }
    }
  }
  traverse(ast);
  dot += "}";
  return dot;
}

async function generateASTSVG(ast) {
  const dot = astToDot(ast);
  console.log("DOT generado para Viz.js:", dot);
  try {
    const viz = new Viz();
    const svg = await viz.renderString(dot, { format: 'svg', engine: 'dot' });
    return svg;
  } catch (error) {
    console.error("Error rendering AST:", error);
    return "<p>Error generando el AST</p>";
  }
}

function App() {
  // Estados
  const [consoleHeight, setConsoleHeight] = useState(200);
  const [isResizing, setIsResizing] = useState(false);
  const [startY, setStartY] = useState(0);
  const [files, setFiles] = useState([{ name: 'Untitled.glt', content: '', saved: false }]);
  const [activeFileIndex, setActiveFileIndex] = useState(0);
  const [consoleOutput, setConsoleOutput] = useState('');
  const [reportErrors, setReportErrors] = useState([]);
  const [symbolTable, setSymbolTable] = useState([]);
  const [ast, setAst] = useState(null);
  const [arm64Code, setArm64Code] = useState('');
  const [visibleReport, setVisibleReport] = useState(null);
  const [astSVG, setAstSVG] = useState(""); 

  const API_URL = "http://localhost:5089/compile";

  // Función arrastre
  const handleMouseDown = useCallback((e) => {
    setIsResizing(true);
    setStartY(e.clientY);
  }, []);

  // Función movimiento mouse
  const handleMouseMove = useCallback((e) => {
    if (!isResizing) return;
    const dy = e.clientY - startY;
    setStartY(e.clientY);
    setConsoleHeight((prevHeight) => {
      const newHeight = prevHeight - dy;
      return Math.max(50, Math.min(newHeight, 600));
    });
  }, [isResizing, startY]);

  // Función fin del arrastre
  const handleMouseUp = useCallback(() => {
    if (isResizing) setIsResizing(false);
  }, [isResizing]);


  useEffect(() => {
    window.addEventListener('mousemove', handleMouseMove);
    window.addEventListener('mouseup', handleMouseUp);
    return () => {
      window.removeEventListener('mousemove', handleMouseMove);
      window.removeEventListener('mouseup', handleMouseUp);
    };
  }, [handleMouseMove, handleMouseUp]);


  useEffect(() => {
    if (visibleReport === 'ast' && ast) {
      console.log("AST recibido en el frontend:", ast);
      generateASTSVG(ast).then(svg => setAstSVG(svg));
    }
  }, [visibleReport, ast]);

  // Función para cerrar pestañas
  const closeTab = (indexToClose) => {
    setFiles((prevFiles) => {
      const newFiles = prevFiles.filter((_, i) => i !== indexToClose);
      if (newFiles.length === 0) {
        setActiveFileIndex(0);
        return [{ name: 'Untitled.glt', content: '', saved: false }];
      }
      setActiveFileIndex((prevActiveIndex) => {
        if (indexToClose === prevActiveIndex) {
          if (indexToClose === prevFiles.length - 1) {
            return indexToClose - 1 >= 0 ? indexToClose - 1 : 0;
          } else {
            return indexToClose;
          }
        } else if (indexToClose < prevActiveIndex) {
          return prevActiveIndex - 1;
        }
        return prevActiveIndex;
      });
      return newFiles;
    });
  };

  // Función para crear archivo nuevo
  const createNewFile = () => {
    const newFile = {
      name: `Untitled-${files.length + 1}.glt`,
      content: '',
      saved: false
    };
    setFiles([...files, newFile]);
    setActiveFileIndex(files.length);
  };

  // Abrir archivo local
  const openFile = async (e) => {
    const file = e.target.files[0];
    if (file?.name.endsWith('.glt')) {
      const content = await file.text();
      setFiles([...files, { name: file.name, content, saved: true }]);
      setActiveFileIndex(files.length);
    }
  };

  // Guardar archivo
  const saveFile = () => {
    const blob = new Blob([files[activeFileIndex].content], { type: 'text/plain' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = files[activeFileIndex].name;
    a.click();
    URL.revokeObjectURL(url);
  };

  // Ejecutar (llamada a la API)
  const handleExecute = async () => {
    const codeToSend = files[activeFileIndex].content.trim();
    if (!codeToSend) {
      setConsoleOutput("El código no puede estar vacío.");
      return;
    }
    try {
      const response = await axios.post(API_URL, { Code: codeToSend });
      console.log("Respuesta del backend:", response.data);
      setConsoleOutput(response.data.output || "Ejecución completada.");
      setReportErrors(response.data.errors || []);
      setSymbolTable(response.data.symbolTable || []);
      setAst(response.data.ast || null);
      setArm64Code(response.data.arm64Code || '');
    } catch (error) {
      console.error("Error al ejecutar:", error);
      const errorMessage = error.response?.data?.output || error.message;
      setConsoleOutput(`Error: ${errorMessage}`);
      setReportErrors(error.response?.data?.errors || [errorMessage]);
      
    }
  };

  // Renderizado condicional de reportes
  const renderReportContent = () => {
    switch (visibleReport) {
      case 'errors':
        return (
          <div className="table-responsive">
            <table className="table table-dark table-hover">
              <thead>
                <tr>
                  <th>Línea</th>
                  <th>Columna</th>
                  <th>Descripción</th>
                  <th>Tipo</th>
                </tr>
              </thead>
              <tbody>
                {reportErrors.map((error, idx) => (
                  <tr key={idx}>
                    <td>{error.line}</td>
                    <td>{error.column}</td>
                    <td>{error.message}</td>
                    <td>{error.type}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        );
      case 'symbols':
        return (
          <div className="table-responsive">
            <table className="table table-dark table-hover">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Tipo símbolo</th>
                  <th>Tipo dato</th>
                  <th>Ámbito</th>
                  <th>Línea</th>
                  <th>Columna</th>
                  <th>Valor</th>
                </tr>
              </thead>
              <tbody>
                {symbolTable.map((symbol, idx) => (
                  <tr key={idx}>
                    <td>{symbol.id}</td>
                    <td>{symbol.tipoSimbolo}</td>
                    <td>{symbol.tipoDato}</td>
                    <td>{symbol.ambito}</td>
                    <td>{symbol.linea}</td>
                    <td>{symbol.columna}</td>
                    <td>{symbol.valor?.toString()}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        );
      case 'ast':
        return (
          <div className="p-2 bg-dark text-light rounded border">
            {astSVG ? (
              <div dangerouslySetInnerHTML={{ __html: astSVG }} />
            ) : (
              "Generando AST..."
            )}
          </div>
        );
      case 'arm64':
          return (
            <div className="h-100 d-flex bg-dark text-light">
              {/* Columna de líneas, ancho fijo */}
              <div
                style={{
                  width: '35px',
                  background: '#2d2d2d',
                  textAlign: 'right',
                  overflow: 'hidden',
                  fontFamily: "'Fira Code', monospace",
                  fontSize: '13px',
                  color: '#6c757d',
                  userSelect: 'none',
                  pointerEvents: 'none',
                }}
              >
                {arm64Code.split('\n').map((_, i) => (
                  <div key={i} style={{ padding: '0 4px' }}>
                    {i + 1}
                  </div>
                ))}
              </div>
        
              {/* Panel de código, ocupa el resto */}
              <pre
                style={{
                  flex: 1,
                  margin: 0,
                  padding: '8px',
                  fontFamily: "'Fira Code', monospace",
                  fontSize: '13px',
                  whiteSpace: 'pre-wrap',
                  overflowX: 'auto',
                }}
              >
                {arm64Code}
              </pre>
            </div>
          );
      default:
        return <div className="text-muted p-3">Selecciona un reporte para visualizarlo</div>;
    }
  };

  // Botón de toolbar reutilizable
  const ToolbarButton = ({ children, icon, onClick, isFileInput = false, variant = "primary" }) => (
    <div className="toolbar-button-wrapper">
      {isFileInput ? (
        <label className={`btn btn-${variant} glow-hover`}>
          <i className={`bi bi-${icon}`}></i> {children}
          <input type="file" hidden accept=".glt" onChange={openFile} />
        </label>
      ) : (
        <button className={`btn btn-${variant} glow-hover`} onClick={onClick}>
          <i className={`bi bi-${icon}`}></i> {children}
        </button>
      )}
    </div>
  );

  return (
    <div className="container-fluid vh-100 d-flex flex-column bg-dark text-light">
      {/* Barra de herramientas */}
      <div className="d-flex align-items-center p-2 bg-black-50 border-bottom border-primary">
        <div className="d-flex gap-2">
          <ToolbarButton icon="file-earmark-plus" onClick={createNewFile}>
            Nuevo
          </ToolbarButton>
          <ToolbarButton icon="folder2-open" isFileInput>
            Abrir
          </ToolbarButton>
          <ToolbarButton icon="save" onClick={saveFile}>
            Guardar
          </ToolbarButton>
          <ToolbarButton icon="play-circle" onClick={handleExecute} variant="success">
            Ejecutar
          </ToolbarButton>
        </div>
      </div>

      {/* Pestañas */}
      <div className="d-flex border-bottom border-secondary">
        {files.map((file, index) => (
          <div
            key={index}
            className={`d-flex align-items-center px-3 py-2 border-end border-secondary cursor-pointer ${
              index === activeFileIndex ? 'bg-primary text-white' : 'bg-secondary'
            }`}
            onClick={() => setActiveFileIndex(index)}
          >
            <span className="me-2">{file.name}</span>
            <i
              className="bi bi-x"
              onClick={(e) => {
                e.stopPropagation();
                closeTab(index);
              }}
            ></i>
          </div>
        ))}
      </div>

      {/* Contenedor principal*/}
      <div className="row flex-grow-1 m-0" style={{ minHeight: 0 }}>
        {/* Editor y Consola*/}
        <div className="col-md-8 d-flex flex-column p-0" style={{ height: 'calc(100vh - 96px)' }}>
          {/* Editor */}
          <div style={{ flex: '1 1 auto', position: 'relative', minHeight: 0 }}>
            <div className="h-100 position-relative overflow-hidden">
              <div
                className="position-absolute line-numbers bg-secondary text-white pe-2"
                style={{
                  zIndex: 1,
                  left: 1,
                  top: 0,
                  bottom: 0,
                  width: '35px',
                  overflow: 'hidden',
                  textAlign: 'right',
                }}
              >
                {files[activeFileIndex].content.split('\n').map((_, i) => (
                  <div key={i} style={{ paddingLeft: '8px' }}>{i + 1}</div>
                ))}
              </div>
              <textarea
                className="w-100 h-100 border-0 bg-dark text-light"
                style={{
                  padding: '10px 15px 10px 45px',
                  fontFamily: "'Fira Code', monospace",
                  outline: 'none',
                  resize: 'none',
                  tabSize: 4,
                  lineHeight: '1.5',
                  whiteSpace: 'pre-wrap',
                }}
                value={files[activeFileIndex].content}
                onChange={(e) => {
                  const newFiles = [...files];
                  newFiles[activeFileIndex].content = e.target.value;
                  newFiles[activeFileIndex].saved = false;
                  setFiles(newFiles);
                }}
                onScroll={(e) => {
                  const lineNumbers = e.target.previousSibling;
                  lineNumbers.scrollTop = e.target.scrollTop;
                }}
              />
            </div>
          </div>

          {/* Barra para redimensionar la consola */}
          <div
            style={{
              height: '5px',
              background: '#333',
              cursor: 'row-resize',
            }}
            onMouseDown={handleMouseDown}
          ></div>

          {/* Consola */}
          <div
            style={{
              flex: '0 0 auto',
              height: consoleHeight,
              overflow: 'hidden',
              borderTop: '1px solid #444',
            }}
          >
            <div className="p-2 bg-secondary border-bottom border-secondary">Consola</div>
            <pre
              className="m-0 p-2 bg-dark text-light"
              style={{
                height: 'calc(100% - 38px)',
                overflowY: 'auto',
              }}
            >
              {consoleOutput}
            </pre>
          </div>
        </div>

        {/* Panel de Reportes (col-md-4) */}
        <div className="col-md-4 p-0 bg-dark" style={{ height: 'calc(100vh - 96px)' }}>
          <div className="h-100 d-flex flex-column">
            <div className="d-flex justify-content-around p-2 border-bottom border-secondary">
              <button
                className={`btn btn-sm ${visibleReport === 'errors' ? 'btn-primary' : 'btn-outline-primary'}`}
                onClick={() => setVisibleReport(visibleReport === 'errors' ? null : 'errors')}
              >
                Errores
              </button>
              <button
                className={`btn btn-sm ${visibleReport === 'symbols' ? 'btn-primary' : 'btn-outline-primary'}`}
                onClick={() => setVisibleReport(visibleReport === 'symbols' ? null : 'symbols')}
              >
                Símbolos
              </button>
              <button
                className={`btn btn-sm ${visibleReport === 'ast' ? 'btn-primary' : 'btn-outline-primary'}`}
                onClick={() => setVisibleReport(visibleReport === 'ast' ? null : 'ast')}
              >
                AST
              </button>
              <button
              className={`btn btn-sm ${visibleReport === 'arm64' ? 'btn-primary' : 'btn-outline-primary'}`}
              onClick={() => setVisibleReport(visibleReport === 'arm64' ? null : 'arm64')}
             >
              ARM64
            </button>
            </div>
            <div className="flex-grow-1 overflow-auto">
              {renderReportContent()}
            </div>
          </div>
        </div>
      </div>

      {/* Indicador de guardado */}
      <div className="position-fixed bottom-0 end-0 m-3">
        <span className="badge bg-secondary">
          {files[activeFileIndex]?.saved ? 'Guardado' : 'No guardado'}
        </span>
      </div>
    </div>
  );
}

export default App;

const styles = `
  * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
  }

  .container-fluid {
    overflow: hidden;
    height: 100vh;
  }

  .row {
    flex: 1;
    min-height: 0; /* Permite que los elementos hijos colapsen */
  }

  .col-md-8 {
    flex: 1;
    min-height: 0;
    overflow: hidden;
  }

  .col-md-4 {
    height: 100%;
    overflow: hidden;
    display: flex;
    flex-direction: column;
  }

  /* Ajustar el editor */
  .position-relative {
    flex: 1;
    min-height: 0;
  }

  /* Consola */
  .border-top {
    flex: 0 0 30%;
    min-height: 120px;
    overflow: hidden;
    display: flex;
    flex-direction: column;
  }

  /* Panel de reportes */
  .report-panel {
    flex: 1;
    min-height: 0;
    overflow: auto;
    background: #1a1a1a; /* Fondo oscuro */
  }
  .toolbar-button-wrapper .btn {
    transition: all 0.3s ease;
    border-width: 2px;
    border-radius: 8px;
    padding: 8px 16px;
    font-weight: 500;
    text-transform: uppercase;
    letter-spacing: 0.5px;
    position: relative;
    overflow: hidden;
  }

  .glow-hover:hover {
    transform: translateY(-1px);
    box-shadow: 0 4px 15px rgba(0, 118, 255, 0.3);
  }

  .btn-success {
    background: linear-gradient(135deg, #28a745 0%, #1e7e34 100%);
    border-color: #1e7e34;
  }

  .btn-primary {
    background: linear-gradient(135deg, #007bff 0%, #0056b3 100%);
    border-color: #0056b3;
  }

  .btn-warning {
    background: linear-gradient(135deg, #ffc107 0%, #d39e00 100%);
    border-color: #d39e00;
  }

  .line-numbers {
    font-family: 'Fira Code', monospace;
    font-size: 13px;
    width: 35px;
    background: #1a1a1a;
    color: #6c757d;
    pointer-events: none;
    user-select: none;
    text-align: right;
  }


  textarea {
    font-family: 'Fira Code', monospace;
    font-size: 13px;
    line-height: 1.5;
    caret-color: #00ff88;
    scrollbar-width: thin;
    scrollbar-color: #333 #1a1a1a;
  }

  textarea::-webkit-scrollbar {
    width: 8px;
  }

  textarea::-webkit-scrollbar-track {
    background: #1a1a1a;
  }

  textarea::-webkit-scrollbar-thumb {
    background-color: #333;
    border-radius: 4px;
  }
    .editor-container {
    display: grid;
    grid-template-columns: auto 1fr;
    overflow: hidden;
  }
  
  .console-output {
    flex-grow: 1;
    min-height: 100px;
    max-height: 300px;
    overflow-y: auto;
    resize: vertical;
  }

  .report-panel {
    flex: 1 1 auto;
    min-height: 200px;
    overflow-y: auto;
  }

  body, .bg-dark, .table-dark {
    background: #1a1a1a !important;
    color: #fff;
  }

  .table-responsive {
    max-height: 70vh;
    overflow: auto;
  }

  .table-dark th {
    position: sticky;
    top: 0;
    background: #2d2d2d;
    z-index: 2;
  }
    re {
  background-color: #1a1a1a;
  color: #f8f9fa;
  border-radius: 4px;
  tab-size: 4;
  overflow: auto;
}

pre code {
  display: block;
  padding: 1rem;
  line-height: 1.5;
}

.arm64-code {
  font-family: 'Fira Code', monospace;
  font-size: 13px;
  white-space: pre-wrap;
}
`;

const styleSheet = document.createElement('style');
styleSheet.innerText = styles;
document.head.appendChild(styleSheet);
