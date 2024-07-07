import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import ChatBot from './ChatBot.jsx'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <ChatBot />
  </React.StrictMode>,
)
