import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Button, Spinner, Alert } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Header from '../components/Header';
import Footer from '../components/Footer';

export default function BarcosPage() {
  const [barcos, setBarcos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch('/api/barcos')
      .then(res => {
        if (!res.ok) throw new Error('Error en la respuesta de la API');
        return res.json();
      })
      .then(data => setBarcos(data))
      .catch(err => setError(err.message))
      .finally(() => setLoading(false));
  }, []);

  return (
    <>
      <Header />

      <main className="py-4 bg-white">
        <Container>
          <h1 className="text-center mb-4">Conoce a nuestra flota</h1>

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

          {!loading && !error && barcos.map((barco, idx) => (
            <React.Fragment key={barco.idBarco || idx}>
              <Row className="featurette align-items-center mb-5">
                <Col
                  md={7}
                  className={`${idx % 2 === 1 ? 'order-md-2 text-start' : 'text-end'}`}
                >
                  <h3 className="featurette-heading">
                    {barco.nombreBarco}
                    <br />
                    <small className="text-ocean">{barco.modeloBarco}</small>
                  </h3>
                  <p className="lead text-dark">
                    <strong>Capitán:</strong> {barco.capitanBarco}
                    <br />
                    <strong>Camarotes y Suites:</strong> {barco.totalCabinas} Cabinas
                    <br />
                    <strong>Capacidad:</strong> {barco.capacidadTotal} Pasajeros
                    <br />
                    <strong>Descripción:</strong> {barco.descripcionBarco}
                  </p>
                  <Link to="/paquetes" className="btn btn-dark btn-lg mt-3">
                    Ver destinos disponibles
                  </Link>
                </Col>

                <Col
                  md={5}
                  className={`${idx % 2 === 1 ? 'order-md-1' : ''}`}
                >
                  <img
                    src={barco.imgURLbarco}
                    alt={barco.nombreBarco}
                    className="img-fluid mx-auto d-block rounded shadow-sm"
                    style={{ maxHeight: '350px', objectFit: 'cover' }}
                  />
                </Col>
              </Row>
              {idx < barcos.length - 1 && <hr className="featurette-divider" />}
            </React.Fragment>
          ))}
        </Container>
      </main>


      <Footer />
    </>
  );
}