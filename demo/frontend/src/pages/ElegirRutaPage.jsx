import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Form, Button } from 'react-bootstrap';
import { useParams, useNavigate } from 'react-router-dom';
import Header from '../components/Header';
import Footer from '../components/Footer';

export default function ElegirRutaPage() {
  console.log('Params recibidos:', useParams());
  const { idReserva } = useParams();
  const [rutas, setRutas] = useState([]);
  const [selectedRuta, setSelectedRuta] = useState('');
  const [validated, setValidated] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    fetch('/api/rutas')
      .then(res => res.json())
      .then(setRutas);
  }, []);

  const handleSubmit = async e => {
    e.preventDefault();
    if (!selectedRuta) { setValidated(true); return; }
    const resp = await fetch(`/api/reservacontrol/${idReserva}/ruta`, {
      method: 'PATCH', headers:{'Content-Type':'application/json'},
      body: JSON.stringify({ idRuta: selectedRuta })
    });
    if (resp.ok) navigate(`/elegir-barco/${idReserva}`);
  };

  return (
    
    <Container className="py-4">
        <Header />
      <h1 className="text-center mb-4">Elige tu ruta</h1>
      <Form noValidate validated={validated} onSubmit={handleSubmit}>
        <Row xs={1} md={2} className="g-4">
          {rutas.map(r => (
            <Col key={r.idruta}>
              <Card>
                <Card.Img src={r.imagen} />
                <Card.Body>
                  <Card.Title>{r.nombreruta}</Card.Title>
                  <Form.Check
                    type="radio" name="idruta" required
                    label={`Salida: ${r.salida}, Dur: ${r.diasruta} días, Precio: S/ ${r.precioruta}`}
                    onChange={() => setSelectedRuta(r.idruta)}
                  />
                </Card.Body>
              </Card>
            </Col>
          ))}
        </Row>
        <div className="text-center mt-4">
          <Button type="submit" variant="ocean" size="lg">Siguiente</Button>
        </div>
      </Form>
    </Container>
  );
}