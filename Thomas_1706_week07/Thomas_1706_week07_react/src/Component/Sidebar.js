import React, { useEffect } from 'react';
import { Form } from 'react-bootstrap';
import { useNavigate, useLocation } from 'react-router-dom';

const Sidebar = ({ category, setCategory, minPrice, setMinPrice, maxPrice, setMaxPrice }) => {
  const navigate = useNavigate();
  const location = useLocation();

  // Update URL whenever any filter changes
  useEffect(() => {
    const queryParams = new URLSearchParams(location.search);

    if (category) {
      queryParams.set('category', category);
    } else {
      queryParams.delete('category');
    }

    if (minPrice) {
      queryParams.set('minPrice', minPrice);
    } else {
      queryParams.delete('minPrice');
    }

    if (maxPrice) {
      queryParams.set('maxPrice', maxPrice);
    } else {
      queryParams.delete('maxPrice');
    }

    navigate(`?${queryParams.toString()}`);
  }, [category, minPrice, maxPrice, navigate, location.search]);

  return (
    <aside className="p-3 bg-light border-end" style={{ width: '220px', height: '550px' }}>
      <h2>Filter</h2>
      <Form.Group className="mb-3">
        <Form.Label>Category:</Form.Label>
        <Form.Select
          value={category}
          onChange={(e) => setCategory(e.target.value)}
        >
          <option value="">All Categories</option>
          <option value="electronics">Electronics</option>
          <option value="books">Books</option>
          <option value="clothing">Clothing</option>
        </Form.Select>
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Price Range:</Form.Label>
        <div className="d-flex">
          <Form.Control
            type="number"
            placeholder="Min Price"
            value={minPrice}
            onChange={(e) => setMinPrice(e.target.value)}
            className="me-2"
            min="0"
          />
          <Form.Control
            type="number"
            placeholder="Max Price"
            value={maxPrice}
            onChange={(e) => setMaxPrice(e.target.value)}
            min="0"
          />
        </div>
      </Form.Group>
    </aside>
  );
};

export default Sidebar;
