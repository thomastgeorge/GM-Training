import React from 'react';
import { Navbar, Nav, Button } from 'react-bootstrap';
import { FaSearch, FaShoppingCart, FaRegUserCircle } from 'react-icons/fa';
import { useNavigate } from 'react-router-dom';

const NavBar = () => {
  const nav = useNavigate();

  // Function to handle logout
  const handleLogout = () => {
    // Clear session storage
    sessionStorage.clear();

    // Optionally navigate to a different route, e.g., home page
    nav('/login');
  };

  return (
    <div>
      <Navbar bg="light" expand="md" className="py-2">
        <div className="container-fluid mx-3">
          {/* Logo */}
          <Navbar.Brand
            onClick={() => nav('/')}
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

          {/* Mobile Toggle Button (Hamburger Icon) */}
          <Navbar.Toggle aria-controls="basic-navbar-nav" />

          {/* Collapsible Content */}
          <Navbar.Collapse id="basic-navbar-nav" className="w-100">
            <div className="d-flex flex-column flex-md-row align-items-center justify-content-between w-100">
              {/* Centered Search Bar */}
              <div className="d-flex flex-grow-1 justify-content-center align-items-center">
                <div className="d-flex align-items-center" style={{ maxWidth: '100%' }}>
                  <input
                    type="text"
                    placeholder="Search"
                    className="form-control custom-search-bar rounded-0"
                    style={{ minWidth: '200px', maxWidth: '400px', width: '100%' }}
                  />
                  <Button variant="outline-secondary" className="rounded-0">
                    <FaSearch />
                  </Button>
                </div>
              </div>

              {/* Right side (User Icons and Login Button) */}
              <Nav className="d-flex align-items-center justify-content-center flex-column flex-md-row">
                <Button
                  onClick={handleLogout} // Call the handleLogout function on click
                  variant="success"
                  className="text-white mx-3 px-4 my-2 my-md-0"
                >
                  Logout
                </Button>
                <div className="d-flex">
                  <Nav.Link
                    className="mx-2"
                    style={{ cursor: 'pointer' }}
                  >
                    <FaShoppingCart size="1.7em" />
                  </Nav.Link>
                  <Nav.Link
                    className="mx-2"
                    style={{ cursor: 'pointer' }}
                  >
                    <FaRegUserCircle size="1.7em" />
                  </Nav.Link>
                </div>
              </Nav>
            </div>
          </Navbar.Collapse>
        </div>
      </Navbar>
    </div>
  );
};

export default NavBar;
