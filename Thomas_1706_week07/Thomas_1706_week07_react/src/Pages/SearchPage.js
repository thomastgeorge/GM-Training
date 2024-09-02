import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import Axios from '../Config/Axios/Axios';
import Spinner from 'react-bootstrap/Spinner';
import ProductCard from '../Component/ProductCard';
import { Col, Container, Row } from 'react-bootstrap';

const SearchPage = () => {
  const [searchResults, setSearchResults] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const query = queryParams.get('query') || '';
  const category = queryParams.get('category') || null;
  const minPrice = queryParams.get('minPrice') || '';
  const maxPrice = queryParams.get('maxPrice') || '';

  useEffect(() => {
    setLoading(true);
    setError(null);

    Axios.get('/api/v1/user/product/search', {
      params: { name: query, tag: query, category, minPrice, maxPrice }
    })
    .then(response => {
      setSearchResults(Array.isArray(response.data) ? response.data : []);
      setLoading(false);
    })
    .catch(err => {
      setError('Error fetching search results. Please try again later.');
      setLoading(false);
    });
  }, [location.search]);

  return (
    <div className="container mt-4" style={{backgroundColor: '#E0FCFF' }}>
      {loading ? (
        <div className="d-flex justify-content-center mt-4">
          <Spinner animation="border" />
        </div>
      ) : error ? (
        <p>{error}</p>
      ) : (
        <div>
          <h2>Search Results for: {query}</h2>
          <Container>
            <Row>
              {searchResults.length > 0 ? (
                searchResults.map(product => (
                  <Col key={product.pid} xs={12} sm={6} md={4} lg={3} className="mb-4 mx-4">
                    <ProductCard product={product} />
                  </Col>
                ))
              ) : (
                <p>No results found. Try a different search term.</p>
              )}
            </Row>
          </Container>
        </div>
      )}
    </div>
  );
};

export default SearchPage;
