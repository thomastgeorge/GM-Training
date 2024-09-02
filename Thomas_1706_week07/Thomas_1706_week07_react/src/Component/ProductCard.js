import React from 'react';
import { Card } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const ProductCard = ({ product }) => {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate(`/product/${product.pid}`, { state: { product } });
  };

  return (
    <Card
      style={{ width: '15rem', height: '23rem', margin: '1rem' }}
      onClick={handleClick}
      className="cursor-pointer"
    >
      <Card.Img
        variant="top"
        src={product.imageUrl}
        style={{
          height: '250px',
          width: '100%',
          objectFit: 'contain', // Ensures the entire image is visible
          padding: '7px',
        }}
      />
      <Card.Body>
        <Card.Title>{product.name}</Card.Title>
        <Card.Text>
          Price: ₹{product.price.toFixed(2)}
        </Card.Text>
      </Card.Body>
    </Card>
  );
  
};

export default ProductCard;
