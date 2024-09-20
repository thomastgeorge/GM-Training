// src/Components/Home.js
import React from 'react';
import { Container, Row, Col, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom'; // Import Link from react-router-dom
import 'bootstrap/dist/css/bootstrap.min.css'; // Ensure Bootstrap CSS is imported

const Home = () => {
  return (
    <Container fluid className="p-0">
      {/* Image Section */}
      <Row className="m-0 position-relative no-gutters">
        <Col xs={12} className="p-0">
          <div style={{ position: 'relative', width: '100%', height: '70vh' }}>
            <img
              src='cupcake.png'
              alt='Cupcake'
              style={{
                position: 'absolute',
                top: '50%',
                left: '50%',
                width: '100%',
                height: 'auto',
                objectFit: 'contain',
                transform: 'translate(-50%, -50%)',
                zIndex: -1, // Ensure the image is behind other content
              }}
            />
            <div
              className="d-flex flex-column align-items-end"
              style={{
                position: 'absolute',
                top: '50%',
                right: '20px',
                transform: 'translateY(-50%)',
                textAlign: 'right',
                zIndex: 1, // Ensure text and button are in front of the image
                color: 'white', // Ensure text is visible
              }}
            >
              <div style={{ marginBottom: '20px', marginRight: '50px', marginTop: '130px' }}>
                <h1 style={{ margin: 5 }}>Hassle-Free</h1>
                <h1 style={{ margin: 5 }}>Event Booking</h1>
              </div>
              <Link to="/eventbooking" style={{ textDecoration: 'none' }}>
                <Button
                  variant='primary'
                  style={{
                    fontSize: '1.25rem',
                    marginTop: '20px',
                    marginRight: '110px'
                  }}
                >
                  Book Now
                </Button>
              </Link>
            </div>
          </div>
        </Col>
      </Row>
    </Container>
  );
};

export default Home;
