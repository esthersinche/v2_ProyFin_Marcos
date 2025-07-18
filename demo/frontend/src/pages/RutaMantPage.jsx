import React, { useState, useEffect } from "react";
import {
  fetchRutas,
  fetchRutaById,
  saveRuta,
  updateRuta,
  deleteRuta,
} from "../api/RutaMantService";

export default function RutaMantPage() {
  const [ruta, setRuta] = useState({
    idRuta: "",
    nombreRuta: "",
    diasRuta: "",
    precioRuta: "",
    salidaRuta: "",
    descripcionRuta: "",
    urlRuta: "",
  });

  const [puertos, setPuertos] = useState([
    "Callao",
    "Pisco",
    "Matarani",
    "Ilo",
  ]);
  const [errorMsg, setErrorMsg] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setRuta({ ...ruta, [name]: value });
  };

  const handleBuscar = async (e) => {
    e.preventDefault();
    try {
      const data = await fetchRutaById(ruta.idRuta);
      setRuta(data);
    } catch {
      setErrorMsg("Ruta no encontrada.");
    }
  };

  const handleGuardar = async (e) => {
    e.preventDefault();
    try {
      await saveRuta(ruta);
      alert("Ruta guardada correctamente.");
    } catch {
      setErrorMsg("Error al guardar la ruta.");
    }
  };

  const handleEditar = async (e) => {
    e.preventDefault();
    try {
      await updateRuta(ruta.idRuta, ruta);
      alert("Ruta actualizada correctamente.");
    } catch {
      setErrorMsg("Error al editar la ruta.");
    }
  };

  const handleEliminar = async (e) => {
    e.preventDefault();
    try {
      await deleteRuta(ruta.idRuta);
      alert("Ruta eliminada.");
      setRuta({
        idRuta: "",
        nombreRuta: "",
        diasRuta: "",
        precioRuta: "",
        salidaRuta: "",
        descripcionRuta: "",
        urlRuta: "",
      });
    } catch {
      setErrorMsg("Error al eliminar la ruta.");
    }
  };

  return (
    <div className="container py-5">
      <h2 className="mb-4">Mantenimiento de Rutas</h2>
      {errorMsg && <div className="alert alert-danger">{errorMsg}</div>}
      <div className="card shadow">
        <div className="card-body">
          <form>
            <div className="row g-3">
              <div className="col-md-3">
                <label className="form-label">ID Ruta</label>
                <input
                  type="text"
                  className="form-control"
                  name="idRuta"
                  value={ruta.idRuta}
                  onChange={handleChange}
                  placeholder="Código"
                />
                <button className="btn btn-info mt-2" onClick={handleBuscar}>
                  Buscar
                </button>
              </div>

              <div className="col-md-5">
                <label className="form-label">Nombre</label>
                <input
                  type="text"
                  className="form-control"
                  name="nombreRuta"
                  value={ruta.nombreRuta}
                  onChange={handleChange}
                  placeholder="Nombre de la ruta"
                />
              </div>

              <div className="col-md-4">
                <label className="form-label">Duración (días)</label>
                <input
                  type="number"
                  className="form-control"
                  name="diasRuta"
                  value={ruta.diasRuta}
                  onChange={handleChange}
                  placeholder="Número de días"
                />
              </div>

              <div className="col-md-6">
                <label className="form-label">Precio</label>
                <input
                  type="number"
                  className="form-control"
                  name="precioRuta"
                  value={ruta.precioRuta}
                  onChange={handleChange}
                  placeholder="Precio en USD"
                />
              </div>

              <div className="col-md-6">
                <label className="form-label">Puerto de Salida</label>
                <select
                  className="form-select"
                  name="salidaRuta"
                  value={ruta.salidaRuta}
                  onChange={handleChange}
                >
                  <option value="">Seleccione un puerto</option>
                  {puertos.map((p) => (
                    <option key={p} value={p}>
                      {p}
                    </option>
                  ))}
                </select>
              </div>

              <div className="col-12">
                <label className="form-label">Descripción</label>
                <textarea
                  className="form-control"
                  name="descripcionRuta"
                  rows="3"
                  value={ruta.descripcionRuta}
                  onChange={handleChange}
                  placeholder="Descripción de la ruta"
                ></textarea>
              </div>

              <div className="col-12">
                <label className="form-label">Imagen (URL)</label>
                <input
                  type="url"
                  className="form-control"
                  name="urlRuta"
                  value={ruta.urlRuta}
                  onChange={handleChange}
                  placeholder="Enlace de la imagen"
                />
              </div>
            </div>

            <div className="mt-4 d-flex justify-content-between">
              <div>
                <button className="btn btn-warning me-2" onClick={handleEditar}>
                  Editar
                </button>
                <button className="btn btn-danger" onClick={handleEliminar}>
                  Eliminar
                </button>
              </div>
              <button className="btn btn-success" onClick={handleGuardar}>
                Guardar
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}
