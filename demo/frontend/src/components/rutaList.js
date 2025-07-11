import React, { useState, useEffect, use } from "react";
import { fetchRutas } from "../api/rutaService";
//falta filtros

export default function RutaList() {
  const [rutas, setRutas] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchRutas()
      .then((data) => {
        console.log("Datos recibidos del backend", data);
        setRutas(data);
      })
      .catch((err) => {
        console.error("Error al cargas las rutas", err);
        setError(err);
      });
  }, []);

  if (error) {
    return (
      <div className="alert alert-danger">
        Error cargando las rutas : {error.message}
      </div>
    );
  }

  return (
    <main className="py-4 container">
      <div className="row">
        {/* Sidebar de filtros */}
        <aside className="col-md-3 mb-4">
          <form onSubmit={handleSubmit}>
            <div className="accordion" id="filterAccordion">
              {/* Puertos de salida */}
              <div className="accordion-item">
                <h2 className="accordion-header" id="headingPort">
                  <button
                    className="accordion-button collapsed"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#collapsePort"
                  >
                    Puertos de salida
                  </button>
                </h2>
                <div
                  id="collapsePort"
                  className="accordion-collapse collapse"
                  data-bs-parent="#filterAccordion"
                >
                  <div className="accordion-body">
                    {puertos.map((puerto) => (
                      <div className="form-check" key={puerto}>
                        <input
                          className="form-check-input"
                          type="checkbox"
                          id={puerto}
                          checked={selectedSalida.includes(puerto)}
                          onChange={() =>
                            toggleFilter(
                              puerto,
                              selectedSalida,
                              setSelectedSalida
                            )
                          }
                        />
                        <label className="form-check-label" htmlFor={puerto}>
                          {puerto}
                        </label>
                      </div>
                    ))}
                  </div>
                </div>
              </div>

              {/* Modelos de Barcos */}
              <div className="accordion-item">
                <h2 className="accordion-header" id="headingShip">
                  <button
                    className="accordion-button collapsed"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#collapseShip"
                  >
                    Modelos de Barcos
                  </button>
                </h2>
                <div
                  id="collapseShip"
                  className="accordion-collapse collapse"
                  data-bs-parent="#filterAccordion"
                >
                  <div className="accordion-body">
                    {modelosBarco.map((modelo) => (
                      <div className="form-check" key={modelo}>
                        <input
                          className="form-check-input"
                          type="checkbox"
                          id={modelo}
                          checked={selectedModelos.includes(modelo)}
                          onChange={() =>
                            toggleFilter(
                              modelo,
                              selectedModelos,
                              setSelectedModelos
                            )
                          }
                        />
                        <label className="form-check-label" htmlFor={modelo}>
                          {modelo}
                        </label>
                      </div>
                    ))}
                  </div>
                </div>
              </div>
            </div>
            <button type="submit" className="btn btn-ocean w-100 mt-3">
              Aplicar filtros
            </button>
          </form>
        </aside>

        {/* Sección de cards */}
        <section className="col-md-9">
          <h1 className="text-dark text-center mb-4">Destinos disponibles</h1>

          <div className="row row-cols-1 row-cols-md-2 g-4">
            {rutas.map((ruta, idx) => {
              const isOdd = idx % 2 === 1;
              return (
                <div className="col" key={ruta.id || idx}>
                  <div className="card h-100 shadow-sm">
                    <div className="row g-0 h-100">
                      {/* Imagen */}
                      <div
                        className={isOdd ? "col-5 order-2" : "col-5 order-1"}
                      >
                        <img
                          src={ruta.imagen}
                          alt={ruta.nombreruta}
                          className="img-fluid rounded-start h-100 w-100 object-fit-cover"
                        />
                      </div>

                      {/* Contenido */}
                      <div
                        className={
                          isOdd
                            ? "col-7 d-flex flex-column order-1 ps-3"
                            : "col-7 d-flex flex-column order-2 pe-3"
                        }
                      >
                        <div className="card-body d-flex flex-column">
                          <h5 className="card-title text-ocean">
                            {ruta.nombreruta}
                          </h5>
                          <p className="card-text flex-grow-1">
                            {ruta.descripcionruta}
                          </p>
                          <ul className="list-group list-group-flush mb-3">
                            <li className="list-group-item">
                              Duración: <span>{ruta.diasruta} días</span>
                            </li>
                            <li className="list-group-item">
                              Modelos de Barco:{" "}
                              {ruta.barcos.map((b) => (
                                <span
                                  className="badge bg-secondary me-1"
                                  key={b.id || b.barmodel.modeloBarco}
                                >
                                  {b.barmodel.modeloBarco}
                                </span>
                              ))}
                            </li>
                            <li className="list-group-item">
                              Precio: ${ruta.precioruta}
                            </li>
                            <li className="list-group-item">
                              Salida: <span>{ruta.salida}</span>
                            </li>
                          </ul>
                          <a href="/paquetes" className="btn btn-ocean mt-auto">
                            Ver paquetes
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              );
            })}
          </div>
        </section>
      </div>
    </main>
  );
}
