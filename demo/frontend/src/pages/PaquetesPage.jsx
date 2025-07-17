import React, { useState, useEffect } from 'react';
import {Container, Row, Col, Card, Button, Spinner, Alert} from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Header from '../components/Header';
import CarouselComponent from '../components/CarouselComponent';
import Footer from '../components/Footer';

export default function PaquetesPage() {
  const [paquetes, setPaquetes] = useState([]);
  const [beneficiosMap, setBeneficiosMap] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Cargar beneficios primero para mapear IDs a nombres
    const fetchBeneficios = fetch('/api/beneficios')
      .then((res) => {
        if (!res.ok) throw new Error('Error al cargar beneficios');
        return res.json();
      })
      .then((data) => {
        // data: array de { idBene, nombreBene }
        const map = {};
        data.forEach((b) => { map[b.idBene] = b.nombreBene; });
        setBeneficiosMap(map);
      });

    // Luego cargar paquetes
    const fetchPaquetes = fetch('/api/paquetes')
      .then((res) => {
        if (!res.ok) throw new Error('Error al cargar paquetes');
        return res.json();
      })
      .then((data) => setPaquetes(data));

    Promise.all([fetchBeneficios, fetchPaquetes])
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, []);

  return (
    <>
      <Header />

      <main className="py-4 bg-white">
        <CarouselComponent />
        <Container>
          <h2 className="pb-2 border-bottom text-ocean mt-5">Nuestros Paquetes</h2>

          {loading && (
            <div className="text-center my-5">
              <Spinner animation="border" role="status">
                <span className="visually-hidden">Cargando...</span>
              </Spinner>
            </div>
          )}

          {error && (
            <Alert variant="danger" className="text-center">
              {error}
            </Alert>
          )}

          {!loading && !error && (
            <Row xs={1} lg={3} className="g-4 py-3">
              {paquetes.map((paq) => (
                <Col key={paq.idPaquete}>
                  <Card className="h-100 text-light bg-ocean rounded-4 shadow-lg">
                    <Card.Body className="d-flex flex-column justify-content-between">
                      <div>
                        <Card.Title className="fs-3">{paq.nomPaquete}</Card.Title>
                        <Card.Text>{paq.descPaquete}</Card.Text>
                      </div>

                      <ul className="list-unstyled d-flex mb-3">
                        <li>
                          <i className="bi bi-cash-stack"></i>{' '}
                          <small>${paq.precPaqueteUni.toFixed(2)}</small>
                        </li>
                      </ul>

                      <div>
                        <strong>Beneficios:</strong>
                        <ul>
                          {paq.idsbeneficios.map((id) => (
                            <li key={id}>{beneficiosMap[id] || id}</li>
                          ))}
                        </ul>
                      </div>

                      <Link to={`/paquete/${paq.idPaquete}`} className="btn btn-light btn-lg mt-3">
                        Ver detalle
                      </Link>
                    </Card.Body>
                  </Card>
                </Col>
              ))}
            </Row>
          )}
        </Container>
      </main>

      <Footer />
    </>
  );
}
