// Bookings.js
import React, { useState, useEffect } from 'react';
import { Container, Table, Button, Alert } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

const Booked = () => {
  const [bookings, setBookings] = useState([]);
  const [alertMessage, setAlertMessage] = useState('');

  useEffect(() => {
    // Load bookings from localStorage when component mounts
    const storedBookings = JSON.parse(localStorage.getItem('bookings')) || [];
    setBookings(storedBookings);
  }, []);

  const handleDeleteBooking = (index) => {
    // Remove booking at the specified index
    const updatedBookings = bookings.filter((_, i) => i !== index);
    setBookings(updatedBookings);
    localStorage.setItem('bookings', JSON.stringify(updatedBookings));
    setAlertMessage('Booking deleted successfully!');
  };

  return (
    <Container className="mt-4">
      <h1>All Bookings</h1>

      {alertMessage && (
        <Alert variant="success" className="mt-4">
          {alertMessage}
        </Alert>
      )}

      <Table striped bordered hover className="mt-4">
        <thead>
          <tr>
            <th>Date</th>
            <th>Location</th>
            <th>Capacity</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {bookings.length > 0 ? (
            bookings.map((booking, index) => (
              <tr key={index}>
                <td>{booking.date}</td>
                <td>{booking.location}</td>
                <td>{booking.capacity}</td>
                <td>
                  <Button
                    variant="danger"
                    onClick={() => handleDeleteBooking(index)}
                  >
                    Delete
                  </Button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" className="text-center">No bookings available.</td>
            </tr>
          )}
        </tbody>
      </Table>
    </Container>
  );
};

export default Booked;
