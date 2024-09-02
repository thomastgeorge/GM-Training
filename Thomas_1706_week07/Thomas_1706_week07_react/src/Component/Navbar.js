import React, { useState } from 'react';
import { Navbar, Nav, Button, Form } from 'react-bootstrap';
import { FaSearch, FaShoppingCart, FaRegUserCircle } from 'react-icons/fa';
import { useNavigate } from 'react-router-dom';

const NavBar = () => {
  const [searchQuery, setSearchQuery] = useState('');
  const navigate = useNavigate();

  const handleSearch = () => {
    
    const trimmedQuery = searchQuery.trim();
    if (trimmedQuery) {
      const encodedQuery = encodeURIComponent(trimmedQuery);
      navigate(`/search?query=${encodedQuery}`);
    }
  };

  const handleKeyDown = (e) => {
    if (e.key === 'Enter') {
      e.preventDefault();  // Prevent form submission
      handleSearch();
    }
  };

  const handleLogout = () => {
    localStorage.clear();
    navigate('/login');
  };


  return (
    <Navbar bg="light" expand="md" className="py-2">
      <div className="container-fluid mx-3">
        <Navbar.Brand
          onClick={() => navigate('/')}
          className="d-flex align-items-center"
          style={{ cursor: 'pointer' }}
        >
          <img
            src="logo.png"
            width="50"
            height="45"
            className="d-inline-block align-top me-2"
            alt="Logo"
          />
          <span className="font-weight-bold">Flipon</span>
        </Navbar.Brand>

        <Navbar.Toggle aria-controls="basic-navbar-nav" />

        <Navbar.Collapse id="basic-navbar-nav" className="w-100">
        <div className="d-flex flex-column flex-md-row align-items-center justify-content-between w-100">
            <Form
              className="d-flex align-items-center flex-grow-1"
              style={{ maxWidth: '600px', width: '100%' }}
              onKeyDown={handleKeyDown}  // Add keydown event listener
            >
              <Form.Control
                type="text"
                placeholder="Search"
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
                className="rounded-0 me-2"
              />
              <Button
                variant="outline-secondary"
                className="rounded-0"
                onClick={handleSearch}
                aria-label="Search"
              >
                <FaSearch />
              </Button>
            </Form>

            <Nav className="d-flex align-items-center">
              <Button
                onClick={handleLogout}
                variant="success"
                className="text-white mx-3"
                aria-label="Logout"
              >
                Logout
              </Button>
              <Nav.Link className="mx-2" aria-label="Shopping Cart">
                <FaShoppingCart size="1.7em" />
              </Nav.Link>
              <Nav.Link className="mx-2" aria-label="User Profile">
                <FaRegUserCircle size="1.7em" />
              </Nav.Link>
            </Nav>
          </div>
        </Navbar.Collapse>
      </div>
    </Navbar>
  );
};

export default NavBar;
