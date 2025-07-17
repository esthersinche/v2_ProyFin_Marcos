// src/components/SidebarFilters.jsx
import React from 'react';
import { Form, Accordion, Button } from 'react-bootstrap';

export default function SidebarFilters({ selectedSalida = [], selectedModelos = [], onFilter }) {
  const puertos = ['Barcelona','Seattle','Miami'];
  const modelos = ['SMODEL','MMODEL','LMODEL'];

  const handleSubmit = (e) => {
    e.preventDefault();
    const form = e.target;
    const salida = Array.from(form.elements['salida'])
      .filter(c => c.checked)
      .map(c => c.value);
    const modelo = Array.from(form.elements['modelo'])
      .filter(c => c.checked)
      .map(c => c.value);
    onFilter({ salida, modelo });
  };

  return (
    <Form onSubmit={handleSubmit} className="mb-4">
      <Accordion alwaysOpen>
        <Accordion.Item eventKey="0">
          <Accordion.Header>Puertos de salida</Accordion.Header>
          <Accordion.Body>
            {puertos.map(p => (
              <Form.Check
                key={p}
                label={p}
                name="salida"
                value={p}
                defaultChecked={selectedSalida.includes(p)}
              />
            ))}
          </Accordion.Body>
        </Accordion.Item>
        <Accordion.Item eventKey="1">
          <Accordion.Header>Modelos de Barcos</Accordion.Header>
          <Accordion.Body>
            {modelos.map(m => (
              <Form.Check
                key={m}
                label={m}
                name="modelo"
                value={m}
                defaultChecked={selectedModelos.includes(m)}
              />
            ))}
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
      <Button type="submit" className="btn-ocean w-100 mt-3">Aplicar filtros</Button>
    </Form>
  );
}
