import React from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';
export default function AdminHeader() {
  return (
    <Navbar expand="lg" className="bg-header">
      <Container fluid>
        <i className="bi bi-tsunami text-white"></i>
        <Navbar.Brand className="text-white ms-2">TuCrucerito.com</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav className="me-auto">
            <Nav.Link href="/barcoMant" className="text-white">Barcos</Nav.Link>
            <Nav.Link href="/rutaMant" className="text-white">Rutas</Nav.Link>
            <Nav.Link href="/paqueteMant" className="text-white">Paquetes</Nav.Link>
            <Nav.Link href="/Mantenimiento/reportes" className="text-white">Reportes</Nav.Link>
          </Nav>
          <Nav className="ms-auto">
            <Nav.Link href="/main" className="text-white">Cerrar Sesión</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}