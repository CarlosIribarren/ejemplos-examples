import React from 'react';


class Caja extends React.Component {



  StyleDinamico() {
    return {
      border: 'solid',
      height: '50px',
      width: '50px',
      color: this.props.esVisible==='rojo' ? 'red' : 'black'

    }
  }

  render() {
    return (
    <div>
      <div style={this.StyleDinamico()}></div>
    </div>
    )
  }
}



export default Caja;
