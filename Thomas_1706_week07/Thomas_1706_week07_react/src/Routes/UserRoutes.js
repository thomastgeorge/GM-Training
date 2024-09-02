import React from 'react'
import Home from '../Pages/Home'
import NavBar from '../Component/Navbar'
import SearchPage from '../Pages/SearchPage'
import {Routes, Route } from 'react-router-dom';
import Sidebar from '../Component/Sidebar';
import Layout from '../Component/Layout';
import Product from '..//Pages/Product'
import AdminPage from '../Pages/AdminPage';

const UserRoutes = () => {
  const isAdmin = localStorage.getItem('isAdmin');
  console.log(isAdmin)
  return (
    <>
      <NavBar />
      <div className="container-fluid">
        <Routes>
          {(isAdmin==='true') ? (
            <Route path="/" element={<AdminPage />} />
          ) : (
            <>
              <Route path="/" element={<Home />} />
              <Route path="/search" element={<Layout />} />
              <Route path="/product/:pid" element={<Product />} />
            </>
          )}
        </Routes>
      </div>
    </>
  );
  };

export default UserRoutes
