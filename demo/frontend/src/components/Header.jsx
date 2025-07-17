import React from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';
export default function Header() {
  return (
    <Navbar expand="lg" className="bg-header">
      <Container fluid>
        <i className="bi bi-tsunami text-white"></i>
        <Navbar.Brand href="/main" className="text-white ms-2">TuCrucerito.com</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav className="me-auto my-2">
            <Nav.Link href="/rutas" className="text-white">Rutas</Nav.Link>
            <Nav.Link href="/paquetes" className="text-white">Paquetes</Nav.Link>
            <Nav.Link href="/barcos" className="text-white">Barcos</Nav.Link>
            <Nav.Link href="/comprar" className="text-white">Comprar</Nav.Link>
          </Nav>
          <Nav className="ms-auto">
            <Nav.Link href="/login" className="btn btn-outline-light ms-2">Iniciar Sesión</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}