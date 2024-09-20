// src/Navbar.js
import React from 'react';
import { Navbar, Nav, Form, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css'; // Ensure Bootstrap CSS is imported
import { Link, useNavigate } from 'react-router-dom';

const NavBar = () => {
  const navigate = useNavigate();

  // Function to handle logout
  const handleLogout = () => {
    localStorage.removeItem('user');
    navigate('/login');
  };

  return (
    <Navbar bg="light" expand="lg" className="shadow-sm">
      <Link to="/">
      <div className="d-flex align-items-center" style={{
        color: 'black',
        textDecoration: 'none'
      }}>
        <img
          src="logo.png"
          alt="Logo"
          width="40"
          height="auto"
          className="mr-3 mx-4" // Add margin to the right of the logo
        />
        Evento
      </div>
      </Link>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Form className="mx-auto d-flex" style={{ width: '40%' }}>
          
        </Form>
        <Nav className="ml-auto d-flex align-items-center mx-3">
          <Link to="/booked"style={{
            color: 'black',
            textDecoration: 'none'
          }}>
            Booked-Events
            </Link>
            <Button
              variant="outline-danger"
              className="ml-2 mx-4" // Add margin to the left of the logout button
              onClick={handleLogout}
            >
              Logout
            </Button>
         
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
};

export default NavBar;
