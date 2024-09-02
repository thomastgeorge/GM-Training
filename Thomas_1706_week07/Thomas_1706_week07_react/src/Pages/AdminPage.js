// src/Pages/AdminPage.jsx
import React, { useState } from 'react';
import Axios from '../Config/Axios/Axios'; // Adjust import based on your Axios setup

const AdminPage = () => {
  const [currentForm, setCurrentForm] = useState(''); // State to manage which form is visible
  const [product, setProduct] = useState({
    pid: '', // PID for Add form, initially empty
    name: '',
    description: '',
    price: '',
    stockQuantity: '',
    category: '',
    tags: '',
    imageUrl: '',
    rating: '',
    ratingcount: '',
    createdDate: '',
  });
  const [pidToDelete, setPidToDelete] = useState(''); // Product ID for Delete form
  const [pidToUpdate, setPidToUpdate] = useState(''); // Product ID for Update form
  const [message, setMessage] = useState('');

  const handleAddProduct = async () => {
    try {
      const productData = {
        ...product,
        pid: parseInt(product.pid, 10), // Convert PID to integer
      };
      await Axios.post('/api/v1/admin/add/product', productData);
      setMessage('Product added successfully!');
      setCurrentForm('');
      setProduct({
        pid: '', // Reset PID for Add form
        name: '',
        description: '',
        price: '',
        stockQuantity: '',
        category: '',
        tags: '',
        imageUrl: '',
        rating: '',
        ratingcount: '',
        createdDate: '',
      });
    } catch (error) {
      setMessage('Error adding product.');
      console.error(error);
    }
  };

  const handleDeleteProduct = async () => {
    try {
      await Axios.delete(`/api/v1/admin/delete/product/${parseInt(pidToDelete, 10)}`); // Convert PID to integer
      setMessage('Product deleted successfully!');
      setCurrentForm('');
      setPidToDelete('');
    } catch (error) {
      setMessage('Error deleting product.');
      console.error(error);
    }
  };

  const handleUpdateProduct = async () => {
    try {
      const productData = {
        ...product,
        pid: parseInt(pidToUpdate, 10), // Convert PID to integer
      };
      await Axios.put('/api/v1/user/update/product', productData);
      setMessage('Product updated successfully!');
      setCurrentForm('');
      setProduct({
        pid: '', // Reset PID for Update form
        name: '',
        description: '',
        price: '',
        stockQuantity: '',
        category: '',
        tags: '',
        imageUrl: '',
        rating: '',
        ratingcount: '',
        createdDate: '',
      });
      setPidToUpdate(''); // Reset PID after update
    } catch (error) {
      setMessage('Error updating product.');
      console.error(error);
    }
  };

  return (
    <div className="container mt-4">
      <h1 className="text-center mb-4">Admin Page</h1>
      <div className="d-flex justify-content-center mb-4">
        <div className="btn-group">
          <button
            className="btn btn-primary mx-2"
            onClick={() => setCurrentForm('add')}
          >
            Add Product
          </button>
          <button
            className="btn btn-secondary mx-2"
            onClick={() => setCurrentForm('delete')}
          >
            Delete Product
          </button>
          <button
            className="btn btn-success mx-2"
            onClick={() => setCurrentForm('update')}
          >
            Update Product
          </button>
        </div>
      </div>

      {/* Conditional Rendering of Forms */}
      {currentForm === 'add' && (
        <div className="form-container">
          <h2>Add Product</h2>
          <form
            onSubmit={(e) => {
              e.preventDefault();
              handleAddProduct();
            }}
          >
            <div className="mb-3">
              <label className="form-label">Product ID:</label>
              <input
                type="number"
                className="form-control"
                value={product.pid}
                onChange={(e) => setProduct({ ...product, pid: e.target.value })}
              />
            </div>
            {Object.keys(product).filter(key => key !== 'pid').map((key) => (
              <div className="mb-3" key={key}>
                <label className="form-label">{key.replace(/([A-Z])/g, ' $1').toUpperCase()}:</label>
                <input
                  type="text"
                  className="form-control"
                  value={product[key]}
                  onChange={(e) => setProduct({ ...product, [key]: e.target.value })}
                />
              </div>
            ))}
            <button type="submit" className="btn btn-primary">Add Product</button>
          </form>
        </div>
      )}

      {currentForm === 'delete' && (
        <div className="form-container">
          <h2>Delete Product</h2>
          <form
            onSubmit={(e) => {
              e.preventDefault();
              handleDeleteProduct();
            }}
          >
            <div className="mb-3">
              <label className="form-label">Product ID:</label>
              <input
                type="number"
                className="form-control"
                value={pidToDelete}
                onChange={(e) => setPidToDelete(e.target.value)}
              />
            </div>
            <button type="submit" className="btn btn-danger">Delete Product</button>
          </form>
        </div>
      )}

      {currentForm === 'update' && (
        <div className="form-container">
          <h2>Update Product</h2>
          <form
            onSubmit={(e) => {
              e.preventDefault();
              handleUpdateProduct();
            }}
          >
            <div className="mb-3">
              <label className="form-label">Product ID:</label>
              <input
                type="number"
                className="form-control"
                value={pidToUpdate}
                onChange={(e) => setPidToUpdate(e.target.value)}
              />
            </div>
            {Object.keys(product).filter(key => key !== 'pid').map((key) => (
              <div className="mb-3" key={key}>
                <label className="form-label">{key.replace(/([A-Z])/g, ' $1').toUpperCase()}:</label>
                <input
                  type="text"
                  className="form-control"
                  value={product[key]}
                  onChange={(e) => setProduct({ ...product, [key]: e.target.value })}
                />
              </div>
            ))}
            <button type="submit" className="btn btn-success">Update Product</button>
          </form>
        </div>
      )}

      {/* Display Message */}
      {message && <div className="alert alert-info mt-4">{message}</div>}

      {/* Custom CSS for form width */}
      <style jsx>{`
        .form-container {
          max-width: 600px;
          margin: auto;
        }
      `}</style>
    </div>
  );
};

export default AdminPage;
