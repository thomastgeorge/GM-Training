import React from 'react';
import { Navigate } from 'react-router-dom';

const ProtectedRoute = ({ element, ...rest }) => {
  const token = localStorage.getItem('token');

  if (!token) {
    // Redirect to login page if token is not available
    return <Navigate to="/login" />;
  }

  // Render the component if token exists
  return element;
};

export default ProtectedRoute;
