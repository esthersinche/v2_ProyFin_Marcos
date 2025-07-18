import React, { useState, useEffect } from 'react';
import { Container, Form, Button } from 'react-bootstrap';
import { useParams, useNavigate } from 'react-router-dom';

export default function ElegirBarcoPage() {
  const { idReserva } = useParams();
  const [barcos, setBarcos] = useState([]);
  const [idBarco, setIdBarco] = useState('');
  const [validated, setValidated] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    fetch('/api/barcos').then(res=>res.json()).then(setBarcos);
  }, []);

  const handleSubmit = async e => {
    e.preventDefault();
    if (!idBarco) { setValidated(true); return; }
    const resp = await fetch(`/api/reservacontrol/${idReserva}/barcos`, {
      method:'PATCH', headers:{'Content-Type':'application/json'},
      body: JSON.stringify({ idBarco })
    });
    if (resp.ok) navigate(`/elegir-paquete/${idReserva}`);
  };

  return (
    <Container className="py-4">
      <h1 className="text-center mb-4">Elige tu barco</h1>
      <Form validated={validated} onSubmit={handleSubmit}>
        <Form.Select
          required value={idBarco} onChange={e=>setIdBarco(e.target.value)}>
          <option value="">-- Selecciona un barco --</option>
          {barcos.map(b=> <option key={b.idBarco} value={b.idBarco}>{b.nombreBarco}</option>)}
        </Form.Select>
        <div className="text-center mt-4">
          <Button variant="ocean" size="lg" type="submit">Continuar</Button>
        </div>
      </Form>
    </Container>
  );
}