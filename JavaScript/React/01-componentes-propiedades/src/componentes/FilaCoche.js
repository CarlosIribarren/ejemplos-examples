import React from 'react';

class FilaCoches extends React.Component {



    render() {

        const cocheConstante = this.props.cochePropiedad;

        return (
            <tr>
                <td>{cocheConstante.Matricula}</td>
                <td>{cocheConstante.Marca}</td>
                <td>{cocheConstante.Modelo}</td>
                <td>{cocheConstante.fechaMatriculacion}</td>
            </tr>
 
        )
    }

}

export default FilaCoches;