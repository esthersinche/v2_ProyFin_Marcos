import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Spinner, Alert } from 'react-bootstrap';
import SidebarFilters from '../components/SidebarFilters';
import Header from '../components/Header';
import Footer from '../components/Footer';

export default function RutasPage() {
  const [rutas, setRutas] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [filters, setFilters] = useState({ salida: [], modelo: [] });

  const fetchRutas = () => {
    setLoading(true);
    const params = new URLSearchParams();
    filters.salida.forEach(s => params.append('salida', s));
    filters.modelo.forEach(m => params.append('modelo', m));

    fetch(`/api/rutas?${params.toString()}`)
      .then(res => {
        if (!res.ok) throw new Error('Error al cargar rutas');
        return res.json();
      })
      .then(data => setRutas(data))
      .catch(err => setError(err.message))
      .finally(() => setLoading(false));
  };

  useEffect(() => {
    fetchRutas();
  }, [filters]);

  return (
    <>
      <Header />
      <main className="py-4 container">
        <Row>
          <Col md={3}>
            <SidebarFilters
              selectedSalida={filters.salida}
              selectedModelos={filters.modelo}
              onFilter={setFilters}
            />
          </Col>
          <Col md={9}>
            <h1 className="text-center mb-4">Destinos disponibles</h1>

            {loading && <div className="text-center"><Spinner /></div>}
            {error && <Alert variant="danger">{error}</Alert>}

            <Row xs={1} md={2} className="g-4">
              {!loading && !error && rutas.map((ruta, idx) => (
                <Col key={ruta.idruta}>
                  <Card className="h-100 shadow-sm">
                    <Row className="g-0 h-100">
                      <Col md={5} className={idx % 2 ? 'order-2' : 'order-1'}>
                        <Card.Img 
                          variant="top"
                          src={ruta.imagen}
                          className="h-100 w-100 object-fit-cover rounded-start"
                          alt={ruta.nombreruta}
                        />
                      </Col>
                      <Col md={7} className={`${idx % 2 ? 'order-1 ps-3' : 'order-2 pe-3'}`}>
                        <Card.Body className="d-flex flex-column">
                          <Card.Title className="text-ocean">{ruta.nombreruta}</Card.Title>
                          <Card.Text className="flex-grow-1">{ruta.descripcionruta}</Card.Text>
                          <ul className="list-group list-group-flush mb-3">
                            <li className="list-group-item">Duración: {ruta.diasruta} días</li>
                            <li className="list-group-item">
                              Modelos:{' '}
                              {ruta.modelos.map(m => (
                                <span key={m} className="badge bg-secondary me-1">{m}</span>
                              ))}
                            </li>
                            <li className="list-group-item">Precio: ${ruta.precioruta.toFixed(2)}</li>
                            <li className="list-group-item">Salida: {ruta.salida}</li>
                          </ul>
                        </Card.Body>
                      </Col>
                    </Row>
                  </Card>
                </Col>
              ))}
            </Row>
          </Col>
        </Row>
      </main>
      <Footer />
    </>
  );
}