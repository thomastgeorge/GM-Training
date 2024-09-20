// src/components/Logout.js
import React from 'react';
import { useNavigate } from 'react-router-dom';

const Logout = () => {
    const navigate = useNavigate();

    const handleLogout = () => {
        localStorage.removeItem('user');
        navigate('/login');
    };

    return (
        <button onClick={handleLogout}>Logout</button>
    );
};

export default Logout;
