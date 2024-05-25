import React from 'react';
import { Navigate } from 'react-router-dom';

const PrivateRoute = ({ children, roles }) => {
  const user = JSON.parse(localStorage.getItem('user'));

  return user ? children : <Navigate to="/login" replace />;
};

export default PrivateRoute;