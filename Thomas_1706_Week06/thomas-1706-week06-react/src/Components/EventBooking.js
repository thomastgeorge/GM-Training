import React, { useState, useEffect } from 'react';
import { Button, Form, Container, Alert, ListGroup } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import eventData from './EventData'; // Import eventData

const EventBooking = () => {
  const [selectedDate, setSelectedDate] = useState('');
  const [capacity, setCapacity] = useState('');
  const [bookings, setBookings] = useState([]);
  const [alertMessage, setAlertMessage] = useState('');
  const [remainingCapacity, setRemainingCapacity] = useState(100);
  const [currentEvent, setCurrentEvent] = useState(null);

  useEffect(() => {
    // Load bookings from localStorage when component mounts
    const storedBookings = JSON.parse(localStorage.getItem('bookings')) || [];
    setBookings(storedBookings);
  }, []);

  useEffect(() => {
    // Save bookings to localStorage whenever bookings change
    localStorage.setItem('bookings', JSON.stringify(bookings));
  }, [bookings]);

  const handleDateChange = (e) => {
    setSelectedDate(e.target.value);
  };

  const handleCapacityChange = (e) => {
    setCapacity(e.target.value);
  };

  const handleEventSelect = (event) => {
    setCurrentEvent(event);
    setSelectedDate('');
    setCapacity('');
    updateRemainingCapacity(event, '');
  };

  const handleShowEvent = () => {
    if (!selectedDate) {
      setAlertMessage('Please select a date.');
      return;
    }
    if (!currentEvent) {
      setAlertMessage('Please select an event.');
      return;
    }
    setAlertMessage('');
    updateRemainingCapacity(currentEvent, selectedDate);
  };

  const handleBookEvent = () => {
    if (!selectedDate) {
      setAlertMessage('Please select a date.');
      return;
    }
    if (!currentEvent) {
      setAlertMessage('Please select an event.');
      return;
    }
    if (!capacity || isNaN(capacity) || capacity <= 0 || capacity > remainingCapacity) {
      setAlertMessage(`Please enter a valid number of seats (1-${remainingCapacity}).`);
      return;
    }

    const newBooking = {
      date: selectedDate,
      location: currentEvent.location,
      capacity: parseInt(capacity, 10)
    };

    const updatedBookings = [...bookings, newBooking];
    setBookings(updatedBookings);

    setAlertMessage('Booking successful!');
    setCapacity('');
    setSelectedDate('');
    updateRemainingCapacity(currentEvent, selectedDate);
  };

  const bookedCapacity = (location, date) => {
    return bookings.filter(b => b.date === date && b.location === location)
      .reduce((sum, booking) => sum + booking.capacity, 0);
  };

  const updateRemainingCapacity = (event, date) => {
    if (date) {
      const maxCapacity = event.capacity;
      setRemainingCapacity(maxCapacity - bookedCapacity(event.location, date));
    } else {
      setRemainingCapacity(event ? event.capacity : 100);
    }
  };

  // Get today's date in YYYY-MM-DD format
  const todayDate = new Date().toISOString().split('T')[0];

  return (
    <Container className="mt-4">
      <h1>Book Your Event</h1>

      <div className="mt-4">
        <h2>Available Events</h2>
        <ListGroup>
          {eventData.map((event, index) => (
            <ListGroup.Item key={index}>
              <h4>{event.location}</h4>
              <Button
                variant="info"
                onClick={() => handleEventSelect(event)}
              >
                Book for {event.location}
              </Button>
            </ListGroup.Item>
          ))}
        </ListGroup>
      </div>

      <Form.Group controlId="eventSelector">
        <Form.Label>Select an Event:</Form.Label>
        <Form.Control as="select" onChange={(e) => handleEventSelect(eventData.find(event => event.location === e.target.value))} value={currentEvent ? currentEvent.location : ''}>
          <option value="">Select an event</option>
          {eventData.map((event, index) => (
            <option key={index} value={event.location}>{event.location}</option>
          ))}
        </Form.Control>
      </Form.Group>

      {currentEvent && (
        <>
          <Form.Group controlId="datePicker">
            <Form.Label>Choose a date:</Form.Label>
            <Form.Control
              type="date"
              value={selectedDate}
              onChange={handleDateChange}
              min={todayDate} // Disable past dates
            />
          </Form.Group>
          <Button variant="primary" onClick={handleShowEvent}>Show Event</Button>

          {selectedDate && (
            <div className="mt-4">
              <h2>Event Details</h2>
              <p><strong>Location:</strong> {currentEvent.location}</p>
              <p><strong>Remaining Capacity:</strong> {remainingCapacity}</p>

              <Form.Group controlId="bookingCapacity">
                <Form.Label>Enter capacity:</Form.Label>
                <Form.Control
                  type="number"
                  value={capacity}
                  onChange={handleCapacityChange}
                  min="1"
                  max={remainingCapacity}
                />
              </Form.Group>
              <Button variant="success" onClick={handleBookEvent}>Book Now</Button>
            </div>
          )}
        </>
      )}

      {alertMessage && (
        <Alert variant="danger" className="mt-4">
          {alertMessage}
        </Alert>
      )}
    </Container>
  );
};

export default EventBooking;
