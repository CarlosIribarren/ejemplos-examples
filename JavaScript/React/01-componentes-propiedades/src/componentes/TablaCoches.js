import React from 'react';
import './TablaCoches.css';
import FilaCoches from './FilaCoche';

class TablaCoches extends React.Component {

    state = {
        coches : [
            {
                Matricula:"5824-GLB", 
                Marca:"Audi", 
                Modelo:"A4", 
                fechaMatriculacion:"01-01-2020" 
            },
            {
                Matricula:"1469-KIO", 
                Marca:"Ford", 
                Modelo:"Focus", 
                fechaMatriculacion:"03-05-2018" 
            },
            {
                Matricula:"8436-AUR", 
                Marca:"Nissan", 
                Modelo:"Juke", 
                fechaMatriculacion:"08-12-2019" 
            }
        ]
    }

    render() {
        
        return (
            <table id="tabla-coches">
                <thead>
                    <tr>
                        <th>Matricula</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Fecha matriculacion</th>
                    </tr>
                </thead>
                <tbody>
                    { this.state.coches.map((c) => <FilaCoches  cochePropiedad={c} key={c.Matricula} /> ) }
                </tbody>
            </table>
        )
    }

}

export default TablaCoches;