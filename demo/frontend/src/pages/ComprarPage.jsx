import React, { useState } from 'react';
import { Container, Row, Col, Form, Button, Card, ProgressBar, InputGroup } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import Header from '../components/Header';
import Footer from '../components/Footer';

export default function ComprarPage() {
  const [form, setForm] = useState({
    nombre: '', apellido: '', dniCliente: '', correo: '', celular: '',
    ciudad: '', cantidadPasajeros: 1, terminos: false
  });
  const [validated, setValidated] = useState(false);
  const [reservaId, setReservaId] = useState(null);
  const navigate = useNavigate();

  const handleChange = e => {
    const { name, value, type, checked } = e.target;
    setForm(prev => ({ ...prev, [name]: type==='checkbox'?checked:value }));
  };

  const handleSubmit = async e => {
    e.preventDefault();
    const formEl = e.currentTarget;
    if (!formEl.checkValidity()) { setValidated(true); return; }

    // Llamada API para crear cliente y reserva inicial
    const response = await fetch('/api/reservacontrol', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        dniCliente: form.dniCliente,
        nombre: form.nombre,
        apellido: form.apellido,
        correo: form.correo,
        celular: form.celular,
        ciudad: form.ciudad,
        cantidadpasajeros: form.cantidadPasajeros
      })
    });
    const data = await response.json();
    console.log('data del POST /api/reservacontrol:', data);
    const location = response.headers.get('Location');
    console.log('Location header:', location);

    const idReserva = location?.split('/').pop();
  console.log(`Redirigiendo a elegir-ruta con ID=${idReserva}`);

  if (response.ok && idReserva) {
    navigate(`/elegir-ruta/${idReserva}`);
  } else {
    alert("No se pudo obtener el ID de reserva correctamente.");
  }
  };

  return (
    <Container className="py-4">
        <Header />
      <h1 className="text-ocean text-center mt-4 mb-5">Proceso de Reservación</h1>
      <Card className="p-4 mb-4 shadow-sm">
        <ProgressBar now={0} className="mb-4" />
        <Form noValidate validated={validated} onSubmit={handleSubmit}>
          <Row className="g-3">
            <Col md={4}>
              <Form.Group controlId="nombre">
                <Form.Label>Nombre</Form.Label>
                <Form.Control
                  required
                  type="text"
                  name="nombre"
                  value={form.nombre}
                  onChange={handleChange}
                />
                <Form.Control.Feedback type="invalid">
                  Por favor ingresa tu nombre.
                </Form.Control.Feedback>
              </Form.Group>
            </Col>
            <Col md={4}>
              <Form.Group controlId="apellido">
                <Form.Label>Apellido</Form.Label>
                <Form.Control
                  required
                  type="text"
                  name="apellido"
                  value={form.apellido}
                  onChange={handleChange}
                />
                <Form.Control.Feedback type="invalid">
                  Por favor ingresa tu apellido.
                </Form.Control.Feedback>
              </Form.Group>
            </Col>
            <Col md={4}>
              <Form.Group controlId="dniCliente">
                <Form.Label>DNI</Form.Label>
                <Form.Control
                  required
                  type="number"
                  name="dniCliente"
                  value={form.dniCliente}
                  onChange={handleChange}
                />
                <Form.Control.Feedback type="invalid">
                  Por favor ingresa tu DNI.
                </Form.Control.Feedback>
              </Form.Group>
            </Col>
            <Col md={4}>
              <Form.Group controlId="correo">
                <Form.Label>Correo electrónico</Form.Label>
                <InputGroup hasValidation>
                  <InputGroup.Text>@</InputGroup.Text>
                  <Form.Control
                    required
                    type="email"
                    name="correo"
                    value={form.correo}
                    onChange={handleChange}
                  />
                  <Form.Control.Feedback type="invalid">
                    Introduce un correo válido.
                  </Form.Control.Feedback>
                </InputGroup>
              </Form.Group>
            </Col>
            <Col md={6}>
              <Form.Group controlId="celular">
                <Form.Label>Número celular</Form.Label>
                <Form.Control
                  required
                  pattern="[0-9]{9}"
                  name="celular"
                  value={form.celular}
                  onChange={handleChange}
                />
                <Form.Control.Feedback type="invalid">
                  Formato: 9 dígitos numéricos.
                </Form.Control.Feedback>
              </Form.Group>
            </Col>
            <Col md={3}>
              <Form.Group controlId="ciudad">
                <Form.Label>Ciudad</Form.Label>
                <Form.Select
                  required
                  name="ciudad"
                  value={form.ciudad}
                  onChange={handleChange}
                >
                  <option value="">Elige tu ciudad</option>
                  {['Lima','Ica','Arequipa','Ancash','Piura'].map(c => (
                    <option key={c} value={c}>{c}</option>
                  ))}
                </Form.Select>
                <Form.Control.Feedback type="invalid">
                  Debes seleccionar una ciudad.
                </Form.Control.Feedback>
              </Form.Group>
            </Col>
            <Col md={3}>
              <Form.Group controlId="cantidadPasajeros">
                <Form.Label>Cantidad de pasajeros</Form.Label>
                <Form.Control
                  required
                  type="number"
                  name="cantidadPasajeros"
                  min={1}
                  max={20}
                  value={form.cantidadPasajeros}
                  onChange={handleChange}
                />
              </Form.Group>
            </Col>
            <Col xs={12}>
              <Form.Group controlId="terminos">
                <Form.Check
                  required
                  type="checkbox"
                  name="terminos"
                  label="Acepto los términos y condiciones"
                  checked={form.terminos}
                  onChange={handleChange}
                />
                <Form.Control.Feedback type="invalid">
                  Debes aceptar los términos.
                </Form.Control.Feedback>
              </Form.Group>
            </Col>
            <Col xs={12} className="text-center">
              <Button variant="ocean" size="lg" type="submit">Siguiente</Button>
            </Col>
          </Row>
        </Form>
      </Card>
    </Container>
  );
}
