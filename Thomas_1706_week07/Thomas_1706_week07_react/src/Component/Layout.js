import React, { useState } from 'react';
import Sidebar from './Sidebar'; // Adjust the import path as needed
import SearchPage from '../Pages/SearchPage'; // Adjust the import path as needed

const Layout = () => {
  const [category, setCategory] = useState('');
  const [minPrice, setMinPrice] = useState('');
  const [maxPrice, setMaxPrice] = useState('');

  return (
    <div className="container-fluid">
      <div className="row">
        <div className="col-md-3">
          <Sidebar
            category={category}
            setCategory={setCategory}
            minPrice={minPrice}
            setMinPrice={setMinPrice}
            maxPrice={maxPrice}
            setMaxPrice={setMaxPrice}
          />
        </div>
        <div className="col-md-9">
          <SearchPage />
        </div>
      </div>
    </div>
  );
};

export default Layout;
