import React from 'react'
import { BrowserRouter , Route, Routes as Switch, Navigate } from 'react-router-dom';
import Home from '../Pages/Home'
import Login from '../Pages/Login';
import SignUp from '../Pages/Signup';
import UserRoutes from './UserRoutes';

const Routes = () => {
    const token = localStorage.getItem('token');
    const isAdmin = localStorage.getItem('isAdmin') === 'true';
  
    return (
      <BrowserRouter>
            {
                    <Switch>
                        <Route path="/login" element={<Login />} />
                        <Route path="/ignup" element={<SignUp />} />
                        <Route path="/*" element={<UserRoutes />} />
                    </Switch>
            }
        </BrowserRouter>
    );
  };

export default Routes
