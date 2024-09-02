import React, { useState } from 'react';
import Axios from '../Config/Axios/Axios';
import { useNavigate, useLocation } from 'react-router-dom';

const Product = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const { product } = location.state || {};

  const [rating, setRating] = useState(0);
  const [updatedProduct, setUpdatedProduct] = useState(product);

  const handleRatingChange = (event) => {
    setRating(Number(event.target.value));
  };

  const handleSubmitRating = async () => {
    try {
      // Calculate new average rating
      const newRatingCount = updatedProduct.ratingcount + 1;
      const newAverageRating = 
        ((updatedProduct.rating * updatedProduct.ratingcount) + rating) / newRatingCount;

      // Update product with new rating
      const updatedProductData = {
        ...updatedProduct,
        rating: newAverageRating,
        ratingcount: newRatingCount,
      };

      await Axios.put('api/v1/user/update/product', updatedProductData);

      // Update local state
      setUpdatedProduct(updatedProductData);

      alert('Thank you for your rating!');
    } catch (error) {
      console.error('Failed to submit rating', error);
    }
  };

  return (
    <div style={{ display: 'flex', padding: '20px', backgroundColor: '#E0FCFF'  }}>
      <div style={{ flex: 1 }}>
        <img src={updatedProduct.imageUrl} alt={updatedProduct.name} style={{ width: '100%', maxWidth: '300px' }} />
      </div>
      <div style={{ flex: 2, marginLeft: '20px' }}>
        <h1>{updatedProduct.name}</h1>
        <p>Price: ₹{updatedProduct.price}</p>
        <p>Rating: {updatedProduct.rating.toFixed(1)} ({updatedProduct.ratingcount} reviews)</p>
        <p>{updatedProduct.description}</p>
        
        <div>
          <h3>Leave a rating:</h3>
          <select value={rating} onChange={handleRatingChange}>
            <option value={0}>Select Rating</option>
            <option value={1}>1 Star</option>
            <option value={2}>2 Stars</option>
            <option value={3}>3 Stars</option>
            <option value={4}>4 Stars</option>
            <option value={5}>5 Stars</option>
          </select>
          <button onClick={handleSubmitRating}>Submit Rating</button>
        </div>
      </div>
    </div>
  );
};

export default Product;
