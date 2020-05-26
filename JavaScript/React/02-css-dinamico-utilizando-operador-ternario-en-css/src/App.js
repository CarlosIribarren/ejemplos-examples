import React from 'react';
import './App.css';
import Caja from './componentes/Caja';

function App() {



  return (
    <div>
      <Caja esVisible='rojo' />
      <Caja esVisible='noRojo' />
    </div>
  );
}



export default App;
