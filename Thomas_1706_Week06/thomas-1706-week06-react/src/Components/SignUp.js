import React, { useState } from 'react';

const SignUp = () => {
  // State to manage form inputs and errors
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [mobile, setMobile] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [error, setError] = useState('');

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    // Basic validation
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const mobilePattern = /^[0-9]{10}$/;
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    if (!emailPattern.test(email)) {
      setError('Invalid email address.');
      return;
    }

    if (!mobilePattern.test(mobile)) {
      setError('Mobile number must be 10 digits long.');
      return;
    }

    if (!passwordPattern.test(password)) {
      setError('Password must contain at least one lowercase letter, one uppercase letter, one number, one special character, and be at least 8 characters long.');
      return;
    }

    if (password !== confirmPassword) {
      setError('Passwords do not match.');
      return;
    }

    // Simulate successful sign up
    localStorage.setItem('user', JSON.stringify({ name, email, mobile, password }));
    setError('');
    alert('Account created successfully!');
  };

  return (
    <div className="container-fluid d-flex vh-100 align-items-center justify-content-center">
      <div className="row w-100 mx-0">
        {/* Image Section */}
        <div className="col-md-6 d-flex justify-content-center align-items-center px-0" style={{ paddingRight: '0.5rem' }}>
          <img src="calender.png" alt="Calendar" className="img-fluid" style={{ maxWidth: '80%', height: 'auto', objectFit: 'cover' }} />
        </div>
        {/* Form Section */}
        <div className="col-md-6 d-flex justify-content-center align-items-center px-0" style={{ paddingLeft: '0.5rem' }}>
          <div className="p-4 border rounded shadow-sm" style={{ width: '90%', maxWidth: '400px', minHeight: '350px' }}>
            <h1 className="text-center mb-4">Evento</h1>
            <h5 className="mb-4">Sign Up</h5>
            {error && <div className="alert alert-danger mb-3 small">{error}</div>}
            <form onSubmit={handleSubmit}>
              <div className="form-group mb-2">
                <label htmlFor="name">Name:</label>
                <input
                  type="text"
                  className="form-control"
                  id="name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                  required
                />
              </div>
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
                <label htmlFor="mobile">Mobile:</label>
                <input
                  type="text"
                  className="form-control"
                  id="mobile"
                  value={mobile}
                  onChange={(e) => setMobile(e.target.value)}
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
                <label htmlFor="confirmPassword">Confirm Password:</label>
                <input
                  type="password"
                  className="form-control"
                  id="confirmPassword"
                  value={confirmPassword}
                  onChange={(e) => setConfirmPassword(e.target.value)}
                  required
                />
              </div>
              <div className="d-flex justify-content-center mt-3">
                <button type="submit" className="btn btn-primary">Sign Up</button>
              </div>
              <p className="text-center mt-3 mb-0">
                Already have an account?{' '}
                <a href="/login" className="text-dark font-weight-bold" style={{ textDecoration: 'none' }}>Login</a>
              </p>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SignUp;