import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [cryptoCurrency, setCryptoCurrency] = useState('');
  const [fiatCurrency, setFiatCurrency] = useState('');
  const [cryptoPrice, setCryptoPrice] = useState(null);
  const [loading, setLoading] = useState(false);

  const fetchCryptoPrice = async () => {
    setLoading(true);
    try {
      const response = await axios.get(`http://localhost:8080/crypto/exchange-rate?cryptoCurrency=${cryptoCurrency}&fiatCurrency=${fiatCurrency}`);
      setCryptoPrice(response.data.exchangeRate);
    } catch (error) {
      console.error('Error fetching cryptocurrency price:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="app-container">
      <h1 className="app-title">Cryptocurrency Price Checker</h1>
      <div className="input-container">
        <label>Cryptocurrency:</label>
        <input type="text" value={cryptoCurrency} onChange={(e) => setCryptoCurrency(e.target.value)} />
      </div>
      <div className="input-container">
        <label>Fiat Currency:</label>
        <input type="text" value={fiatCurrency} onChange={(e) => setFiatCurrency(e.target.value)} />
      </div>
      <button className="fetch-button" onClick={fetchCryptoPrice} disabled={loading}>
        {loading ? 'Fetching...' : 'Fetch Price'}
      </button>
      {cryptoPrice !== null && (
        <p className="result-text">{`${cryptoCurrency} to ${fiatCurrency} Exchange Rate: ${cryptoPrice}`}</p>
      )}
    </div>
  );
}

export default App;
