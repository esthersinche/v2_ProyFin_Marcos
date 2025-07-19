import React, { useState, useEffect } from "react";
import { Form, Button, Alert, Container, Card } from "react-bootstrap";
import AdminHeader from "../components/AdminHeader";
import {
  fetchBeneficios,
  fetchPaqueteById,
  savePaquete,
  editPaquete,
  deletePaquete,
} from "../api/PaqueteMantService";

export default function PaqueteMantPage() {
  const [paquete, setPaquete] = useState({
    idPaquete: "",
    nomPaquete: "",
    descPaquete: "",
    precPaqueteUni: "",
    idsbeneficios: [],
  });
  const [beneficios, setBeneficios] = useState([]);
  const [errorMsg, setErrorMsg] = useState(null);

  useEffect(() => {
    fetchBeneficios()
      .then(setBeneficios)
      .catch(() => setErrorMsg("Error al cargar beneficios"));
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setPaquete((prev) => ({ ...prev, [name]: value }));
  };

  const handleSelect = (e) => {
    const selected = Array.from(e.target.selectedOptions, (opt) => opt.value);
    setPaquete((prev) => ({ ...prev, idsbeneficios: selected }));
  };

  const handleBuscar = (e) => {
    e.preventDefault();
    if (!paquete.idPaquete) return;
    fetchPaqueteById(paquete.idPaquete)
      .then((data) => setPaquete(data))
      .catch(() => setErrorMsg("Paquete no encontrado"));
  };

  const handleGuardar = (e) => {
    e.preventDefault();
    savePaquete(paquete)
      .then(() => alert("Paquete guardado con éxito"))
      .catch(() => setErrorMsg("Error al guardar paquete"));
  };

  const handleEditar = (e) => {
    e.preventDefault();
    editPaquete(paquete.idPaquete, paquete)
      .then(() => alert("Paquete editado con éxito"))
      .catch(() => setErrorMsg("Error al editar paquete"));
  };

  const handleEliminar = (e) => {
    e.preventDefault();
    deletePaquete(paquete.idPaquete)
      .then(() => {
        alert("Paquete eliminado");
        setPaquete({
          idPaquete: "",
          nomPaquete: "",
          descPaquete: "",
          precPaqueteUni: "",
          idsbeneficios: [],
        });
      })
      .catch(() => setErrorMsg("Error al eliminar paquete"));
  };

  return (
    <>
      <AdminHeader />
      <Container className="py-5">
        <h2 className="mb-4">Mantenimiento de Paquetes</h2>
        {errorMsg && <Alert variant="danger">{errorMsg}</Alert>}
        <Card className="shadow">
          <Card.Body>
            <Form>
              <Form.Group className="mb-3">
                <Form.Label>ID Paquete</Form.Label>
                <Form.Control
                  type="text"
                  name="idPaquete"
                  value={paquete.idPaquete}
                  onChange={handleChange}
                />
                <Button variant="info" className="mt-2" onClick={handleBuscar}>
                  Buscar
                </Button>
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>Nombre</Form.Label>
                <Form.Control
                  type="text"
                  name="nomPaquete"
                  value={paquete.nomPaquete}
                  onChange={handleChange}
                />
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>Descripción</Form.Label>
                <Form.Control
                  as="textarea"
                  rows={2}
                  name="descPaquete"
                  value={paquete.descPaquete}
                  onChange={handleChange}
                />
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>Precio Unitario</Form.Label>
                <Form.Control
                  type="number"
                  step="0.01"
                  name="precPaqueteUni"
                  value={paquete.precPaqueteUni}
                  onChange={handleChange}
                />
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>Beneficios Asignados</Form.Label>
                <Form.Control
                  as="select"
                  multiple
                  size={5}
                  name="idsbeneficios"
                  value={paquete.idsbeneficios}
                  onChange={handleSelect}
                >
                  {beneficios.map((b) => (
                    <option key={b.idBene} value={b.idBene}>
                      {b.nombreBene}
                    </option>
                  ))}
                </Form.Control>
                <small className="text-muted">
                  Mantén Ctrl o Cmd para seleccionar múltiples
                </small>
              </Form.Group>

              <div className="d-flex justify-content-between">
                <div>
                  <Button
                    variant="warning"
                    onClick={handleEditar}
                    className="me-2"
                  >
                    Editar
                  </Button>
                  <Button variant="danger" onClick={handleEliminar}>
                    Eliminar
                  </Button>
                </div>
                <Button variant="primary" onClick={handleGuardar}>
                  Guardar
                </Button>
              </div>
            </Form>
          </Card.Body>
        </Card>
      </Container>
    </>
  );
}
