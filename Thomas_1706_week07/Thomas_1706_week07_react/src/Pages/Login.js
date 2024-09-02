import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  // State to manage form inputs, errors, and checkbox
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState('');
  const [isAdmin, setIsAdmin] = useState(false); // State for checkbox
  const navigate = useNavigate(); // Initialize useNavigate

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();

    // Basic validation
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{6,}$/;

    if (!emailPattern.test(email)) {
      setErrors('Invalid email address.');
      return;
    }

    if (!passwordPattern.test(password)) {
      setErrors('Password must contain at least one lowercase letter, one uppercase letter, one number, and be at least 8 characters long.');
      return;
    }

    try {
        // Make an API request with Fetch
        const response = await fetch('http://localhost:8085/api/v1/auth/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            email,
            password,
          }),
        });
      
        // Check if the response status is OK (200-299)
        if (response.ok) {
          // Parse the JSON response
          const data = await response.json();
          
          // Log the response data to inspect its structure
          console.log('Response data:', data);
          
          // Simulate successful login
          if (data.token) { // Check if token is present in the response
            // Store token and isAdmin status in localStorage
            localStorage.setItem('token', data.token);
            localStorage.setItem('isAdmin', isAdmin); // Store the checkbox value
            setErrors(''); // Clear any previous errors
            navigate('/'); // Redirect to the home page
          } else {
            setErrors('Token not found in response.');
          }
        } else {
          // Handle non-200 responses
          const errorData = await response.json();
          setErrors(errorData.message || 'Invalid email or password.');
        }
      } catch (error) {
        // Handle network errors or unexpected issues
        setErrors('An error occurred. Please try again.');
        console.error('Error:', error);
      }
      
  };

  return (
    <div className="container-fluid d-flex vh-100 align-items-center justify-content-center" style={{ backgroundColor: '#E0FCFF' }}>
      <div className="row w-100 mx-0">
        {/* Image Section */}
        <div className="col-md-6 d-flex justify-content-center align-items-center px-0" style={{ paddingRight: '0.5rem' }}>
          <img src="shopping-cart.png" alt="shopping-cart" className="img-fluid" style={{ maxWidth: '80%', height: 'auto', objectFit: 'cover' }} />
        </div>
        {/* Form Section */}
        <div className="col-md-6 d-flex justify-content-center align-items-center px-0" style={{ paddingLeft: '0.5rem' }}>
          <div className="p-4 border rounded shadow-sm" style={{ width: '90%', maxWidth: '400px', backgroundColor: '#FFFFFF' }}>
            <h1 className="text-center mb-4">Flipon</h1>
            <h5 className="mb-4">Login</h5>
            {errors && <div className="alert alert-danger mb-3 small">{errors}</div>}
            <form onSubmit={handleSubmit}>
              <div className="form-group mb-2">
                <label htmlFor="email">Email:</label>
                <input
                  type="email"
                  className="form-control"
                  id="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  required
                />
              </div>
              <div className="form-group mb-2">
                <label htmlFor="password">Password:</label>
                <input
                  type="password"
                  className="form-control"
                  id="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  required
                />
              </div>
              <div className="form-group mb-2">
                <div className="form-check">
                  <input
                    type="checkbox"
                    className="form-check-input"
                    id="isAdmin"
                    checked={isAdmin}
                    onChange={(e) => setIsAdmin(e.target.checked)}
                  />
                  <label className="form-check-label" htmlFor="isAdmin">Admin</label>
                </div>
              </div>
              <div className="d-flex justify-content-center mt-3">
                <button type="submit" className="btn btn-primary">Login</button>
              </div>
              <p className="text-center mt-3 mb-0">
                Create Account,{' '}
                <a href="/signup" className="text-dark font-weight-bold" style={{ textDecoration: 'none' }}>Sign Up</a>
              </p>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
