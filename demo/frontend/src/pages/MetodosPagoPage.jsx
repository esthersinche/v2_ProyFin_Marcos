import React, { useState } from 'react';
import { Container, Card, Form, Button, Alert } from 'react-bootstrap';
import { useNavigate, useParams } from 'react-router-dom';
import Header from '../components/Header';
import Footer from '../components/Footer';

export default function MetodosPagoPage() {
  const { idReserva } = useParams();
  const [metodo, setMetodo] = useState('tarjeta');
  const [processing, setProcessing] = useState(false);
  const [error, setError] = useState(null);
  const navigate = useNavigate();
  const [showGracias, setShowGracias] = useState(false);


  const handleSubmit = async (e) => {
    e.preventDefault();
    setProcessing(true);
    setError(null);

    try {
      // Simula la llamada a tu backend
      const response = await fetch('/api/reservacontrol/pagos/simulacion', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          reservaId: idReserva,
          metodo,
          datos: metodo === 'tarjeta' ? {
            numero: '4111 1111 1111 1111',
            vencimiento: '12/30',
            cvv: '123'
          } : { codigoQR: 'YAPE123456789' } // Simulación de yape
        })
      });
      if (!response.ok) throw new Error('Error simulando el pago');

      // Si el pago fue "exitoso", confirmar en backend
      await fetch(`/api/reservacontrol/${idReserva}/pago`, { method: 'PATCH' });

    // Mostrar mensaje de agradecimiento
    setShowGracias(true);

    // Redirigir al home luego de 4 segundos
    setTimeout(() => {
      navigate('/');
    }, 4000);
  } catch (err) {
    setError(err.message);
  } finally {
    setProcessing(false);
  }
};

  return (
    <Container className="py-4">
      <Header />
      <Card>
        <Card.Header className="bg-ocean text-white text-center">
          <h4>Métodos de Pago</h4>
        </Card.Header>
        <Card.Body>
          {error && <Alert variant="danger">{error}</Alert>}
            {showGracias ? (
            <div className="text-center my-5">
                <h3 className="text-success">✅ ¡Gracias por tu pago!</h3>
                <p>Tu reserva ha sido confirmada con éxito.</p>
                <p>Serás redirigido al inicio en unos segundos...</p>
            </div>
            ) : (        

          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3">
              <Form.Label>Método de pago</Form.Label>
              <Form.Select value={metodo} onChange={(e) => setMetodo(e.target.value)} disabled={processing}>
                <option value="tarjeta">Tarjeta de Crédito/Débito</option>
                <option value="yape">Yape / Pago virtual</option>
              </Form.Select>
            </Form.Group>

            {metodo === 'tarjeta' && (
              <>
                <Form.Group className="mb-3">
                  <Form.Label>Número de tarjeta</Form.Label>
                  <Form.Control type="text" defaultValue="4111 1111 1111 1111" required />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>Expiración MM/AA</Form.Label>
                  <Form.Control type="text" defaultValue="12/30" required />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>CVV</Form.Label>
                  <Form.Control type="text" defaultValue="123" required />
                </Form.Group>
              </>
            )}

            {metodo === 'yape' && (
              <div className="mb-3 text-center">
                <p>Escanea este código QR simulado:</p>
                <img src="https://upload.wikimedia.org/wikipedia/commons/5/5f/QR_Code_example.png" alt="QR Simulado" width="200" />
                <p><em>(Yape de prueba)</em></p>
              </div>
            )}

            <div className="d-flex justify-content-between mt-4">
              <Button variant="outline-secondary" onClick={() => navigate(-1)} disabled={processing}>
                Regresar
              </Button>
              <Button variant="ocean" type="submit" disabled={processing}>
                {processing ? 'Procesando...' : 'Pagar'}
              </Button>
            </div>
          </Form>
            )}
        </Card.Body>
      </Card>
      <Footer />
    </Container>
  );
}