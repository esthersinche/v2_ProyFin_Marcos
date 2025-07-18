import React, { useState, useEffect } from 'react';
import { Container, Card, ListGroup, Button, Spinner, Alert } from 'react-bootstrap';
import { useParams, useNavigate } from 'react-router-dom';

export default function ResumenPage() {
  const { idReserva } = useParams();
  const [reserva, setReserva] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    fetch(`/api/reservacontrol/${idReserva}`)
      .then(res => {
        if (!res.ok) throw new Error('No se pudo cargar el resumen');
        return res.json();
      })
      .then(data => setReserva(data))
      .catch(err => setError(err.message))
      .finally(() => setLoading(false));
  }, [idReserva]);

  if (loading) return <div className="text-center my-5"><Spinner animation="border" /></div>;
  if (error) return <Alert variant="danger">{error}</Alert>;

  // Formatear fecha
  const fecha = new Date(reserva.fechaReserva).toLocaleDateString();

  return (
    <Container className="py-4">
      <Alert variant="success" className="text-center">
        <h2>¡Gracias por tu reserva!</h2>
        <p>Se ha enviado un correo de confirmación a <strong>{reserva.clienteCorreo}</strong>.</p>
        <p>Espera instrucciones con el método de pago y próximos pasos.</p>
      </Alert>

      <Card className="shadow-sm">
        <Card.Body>
          <h4 className="text-ocean mb-3">Resumen de tu reservación</h4>

          <h5>Datos del Cliente</h5>
          <ListGroup variant="flush" className="mb-3">
            <ListGroup.Item>Nombre: {reserva.clienteNombre}</ListGroup.Item>
            <ListGroup.Item>Correo: {reserva.clienteCorreo}</ListGroup.Item>
            <ListGroup.Item>DNI: {reserva.clienteDni}</ListGroup.Item>
            <ListGroup.Item>Pasajeros: {reserva.cantidadPasajeros}</ListGroup.Item>
            <ListGroup.Item>Fecha de reserva: {fecha}</ListGroup.Item>
          </ListGroup>

          <h5>Ruta Elegida</h5>
          <ListGroup variant="flush" className="mb-3">
            <ListGroup.Item>Nombre: {reserva.puertoDestino}</ListGroup.Item>
            <ListGroup.Item>Duración: {reserva.rutaDuracion} días</ListGroup.Item>
            <ListGroup.Item>Puerto de Salida: {reserva.puertoSalida}</ListGroup.Item>
            <ListGroup.Item>Precio Ruta: S/ {reserva.subtotalRuta.toFixed(2)}</ListGroup.Item>
          </ListGroup>

          <h5>Paquete</h5>
          <ListGroup variant="flush" className="mb-3">
            <ListGroup.Item>Nombre: {reserva.paqueteNombre}</ListGroup.Item>
            <ListGroup.Item>Descripción: {reserva.paqueteDescripcion}</ListGroup.Item>
            <ListGroup.Item>Precio Paquete: S/ {reserva.subtotalPaquete.toFixed(2)}</ListGroup.Item>
          </ListGroup>

          <h5>Cabina</h5>
          <ListGroup variant="flush" className="mb-3">
            <ListGroup.Item>Tipo: {reserva.cabinaTipo}</ListGroup.Item>
            <ListGroup.Item>Precio Cabina por persona: S/ {reserva.cabinaPrecioPorPersona.toFixed(2)}</ListGroup.Item>
          </ListGroup>

          <h4 className="text-end">Total a pagar: <strong>S/ {reserva.total.toFixed(2)}</strong></h4>

          <div className="d-flex justify-content-between mt-4">
            <Button variant="outline-secondary" onClick={() => navigate(-1)}>
              Cancelar
            </Button>
            <Button variant="ocean" onClick={() => navigate(`/metodos-pago/${idReserva}`)}>
              Pagar
            </Button>
          </div>
        </Card.Body>
      </Card>
    </Container>
  );
}
