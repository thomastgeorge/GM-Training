import './App.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Outlet } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';


import ProtectedRoute from './Components/ProtectedRoute';
import NavBar from './Components/NavBar';
import Login from './Components/Login'
import SignUp from './Components/SignUp'
import Home from './Components/Home'
import EventBooking from './Components/EventBooking';
import Booked from './Components/Booked';


const ProtectedLayout = () => (
  <>
    <NavBar />
    <div className="container mt-4">
      <Outlet />
    </div>
  </>
);

function App() {
  return (
    <Router>
      <Routes>
        {/* Public routes */}
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />

        {/* Protected routes */}
        <Route element={<ProtectedRoute />}>
          <Route element={<ProtectedLayout />}>
            <Route path="/" element={<Home />} />
            <Route path="/eventbooking" element={<EventBooking />} />
            <Route path="/booked" element={<Booked />}/>
          </Route>
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
