import React, { useState, useEffect } from 'react';
import { Container, Form, Button, Card } from 'react-bootstrap';
import { useParams, useNavigate } from 'react-router-dom';

export default function ElegirPaquetePage() {
  const { idReserva } = useParams();
  const [paquetes, setPaquetes] = useState([]);
  const [cabinas, setCabinas] = useState([]);
  const [form, setForm] = useState({ idPaquete:'', idCabina:'' });
  const [precioUnit, setPrecioUnit] = useState(null);
  const navigate = useNavigate();

  useEffect(() => { fetch('/api/paquetes').then(r=>r.json()).then(setPaquetes);
                   fetch('/api/cabinas').then(r=>r.json()).then(setCabinas);
  }, []);

  const calcular = async e => {
    e.preventDefault();
    const resp = await fetch(`/api/reservacontrol/${idReserva}/paqueteycabina`, {
      method:'PATCH', headers:{'Content-Type':'application/json'},
      body: JSON.stringify(form)
    });
    const data = await resp.json();
    if (resp.ok) setPrecioUnit(data.precioUnitario);
  };

  const confirmar = async () => {
    const resp = await fetch(`/api/reservacontrol/${idReserva}/pago`, { method:'PATCH' });
    if (resp.ok) navigate(`/resumen/${idReserva}`);
  };

  return (
    <Container className="py-4">
      <h1 className="text-center mb-4">Elige tu paquete</h1>
      <Form onSubmit={calcular} className="mb-4">
        <Form.Group className="mb-3">
          <Form.Select required onChange={e=>setForm(prev=>({...prev,idPaquete:e.target.value}))}>
            <option value="">-- Paquete --</option>
            {paquetes.map(p=> <option key={p.idPaquete} value={p.idPaquete}>{p.nomPaquete}</option>)}
          </Form.Select>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Select required onChange={e=>setForm(prev=>({...prev,idCabina:e.target.value}))}>
            <option value="">-- Cabina --</option>
            {cabinas.map(c => (<option key={c.idCabina} value={c.idCabina}>
            {c.nombreCab} (Capacidad: {c.capacidadMax}) - S/ {c.precioPorPersona}  </option>))}
          </Form.Select>
          {cabinas.length === 0 && (
            <div className="text-danger mt-2">No hay cabinas disponibles actualmente.</div>)}
        </Form.Group>
        <Button variant="ocean" type="submit">Calcular Precio</Button>
      </Form>
      {precioUnit && (
        <Card className="p-4 bg-light mb-4">
          <h5>Precio unitario por pasajero: S/ {precioUnit}</h5>
          <Button onClick={confirmar} variant="ocean">Confirmar Reserva</Button>
        </Card>
      )}
    </Container>
  );
}