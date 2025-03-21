import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';

function App() {
  const [files, setFiles] = useState([{ name: 'Untitled.glt', content: '', saved: false }]);
  const [activeFileIndex, setActiveFileIndex] = useState(0);
  const [consoleOutput, setConsoleOutput] = useState('');
  const [reportErrors, setReportErrors] = useState([]);
  const [symbolTable, setSymbolTable] = useState([]);
  const [ast, setAst] = useState(null);
  const [visibleReport, setVisibleReport] = useState(null);

  const API_URL = "http://localhost:5089/compile";

  const createNewFile = () => {
    const newFile = {
      name: `Untitled-${files.length + 1}.glt`,
      content: '',
      saved: false
    };
    setFiles([...files, newFile]);
    setActiveFileIndex(files.length);
  };

  const openFile = async (e) => {
    const file = e.target.files[0];
    if (file?.name.endsWith('.glt')) {
      const content = await file.text();
      setFiles([...files, {
        name: file.name,
        content,
        saved: true
      }]);
      setActiveFileIndex(files.length);
    }
  };

  const saveFile = () => {
    const blob = new Blob([files[activeFileIndex].content], { type: 'text/plain' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = files[activeFileIndex].name;
    a.click();
    URL.revokeObjectURL(url);
  };

  const handleExecute = async () => {
    const codeToSend = files[activeFileIndex].content.trim();

    if (!codeToSend) {
      setConsoleOutput("El código no puede estar vacío.");
      return;
    }

    try {
      const response = await axios.post(API_URL, { Code: codeToSend });
      setConsoleOutput(response.data.output || "Ejecución completada.");
      setReportErrors(response.data.errors || []);
      setSymbolTable(response.data.symbolTable || []);
      setAst(response.data.ast || null);
    } catch (error) {
      const errorMessage = error.response?.data?.output || error.message;
      setConsoleOutput(`Error: ${errorMessage}`);
      setReportErrors(error.response?.data?.errors || [errorMessage]);
    }
  };

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
          <pre className="p-2 bg-dark text-light rounded border">
            {ast ? JSON.stringify(ast, null, 2) : 'AST no generado'}
          </pre>
        );
      default:
        return <div className="text-muted p-3">Selecciona un reporte para visualizarlo</div>;
    }
  };

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

      <div className="d-flex border-bottom border-secondary">
        {files.map((file, index) => (
          <div key={index}
            className={`d-flex align-items-center px-3 py-2 border-end border-secondary cursor-pointer ${index === activeFileIndex ? 'bg-primary text-white' : 'bg-secondary'}`}
            onClick={() => setActiveFileIndex(index)}
          >
            <span className="me-2">{file.name}</span>
            <i className="bi bi-x" onClick={(e) => {
              e.stopPropagation();
              setFiles(files.filter((_, i) => i !== index));
              if (index === activeFileIndex) setActiveFileIndex(Math.max(0, index - 1));
            }}></i>
          </div>
        ))}
      </div>

      <div className="row flex-grow-1 m-0">
        <div className="col-md-8 d-flex flex-column p-0" style={{ height: 'calc(100vh - 96px)' }}>
          <div className="flex-grow-1 border-end border-secondary" style={{ height: '70%' }}>
            <div className="h-100 position-relative overflow-hidden">
              <div className="position-absolute line-numbers bg-secondary text-white pe-2" 
                   style={{ 
                     zIndex: 1,
                     left: 1,
                     top: 0,
                     bottom: 0,
                     width: '55px',
                     overflow: 'hidden',
                     textAlign: 'right' 
                   }}>
                {files[activeFileIndex].content.split('\n').map((_, i) => (
                  <div key={i} style={{ paddingLeft: '8px' }}>{i + 1}</div>
                ))}
              </div>
              <textarea
                className="w-100 h-100 border-0 bg-dark text-light"
                style={{ 
                  padding: '10px 25px 10px 55px !important',
                  fontFamily: "'Fira Code', monospace",
                  outline: 'none',
                  resize: 'none',
                  tabSize: 4,
                  lineHeight: '1.5',
                  whiteSpace: 'pre-wrap'
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
          <div className="border-top border-secondary" style={{ height: '30%', minHeight: '120px' }}>
            <div className="p-2 bg-secondary border-bottom border-secondary">Consola</div>
            <pre className="m-0 p-2 bg-dark text-light" style={{ height: 'calc(200px - 38px)', overflowY: 'auto' }}>
              {consoleOutput}
            </pre>
          </div>
        </div>

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
            </div>
            <div className="flex-grow-1 overflow-auto">
              {renderReportContent()}
            </div>
          </div>
        </div>
      </div>

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
    color: #6c757d;
    background: #1a1a1a;
    pointer-events: none;
    user-select: none;
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
`;

const styleSheet = document.createElement('style');
styleSheet.innerText = styles;
document.head.appendChild(styleSheet);