// src/components/ProtectedRoute.js
import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';

// ProtectedRoute component checks if user is authenticated
const ProtectedRoute = () => {
    const user = JSON.parse(localStorage.getItem('user'));

    // Redirect to login if not authenticated
    if (!user) {
        return <Navigate to="/login" />;
    }

    // Render the nested routes if authenticated
    return <Outlet />;
};

export default ProtectedRoute;
