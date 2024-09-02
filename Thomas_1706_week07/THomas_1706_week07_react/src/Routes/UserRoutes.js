import React from 'react'
import Home from '../Pages/Home'
import NavBar from '../Component/Navbar'
import { Routes, Route } from 'react-router-dom';

const UserRoutes = () => {
    return (
      <>
        <NavBar />
        <Routes>
          <Route path="/" element={<Home />} />
          {/* Add more user-specific routes here */}
        </Routes>
      </>
    );
  };

export default UserRoutes
