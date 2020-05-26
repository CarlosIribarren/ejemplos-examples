# Ejemplo
En este ejemplo se muestra como se pasan propiedades de un componente a otro.

## TablaCoche
El componente TablaCoche tiene definido en el estado un JSON, con un array de coches.

```js
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
```

Al la hora de renderizar la parte del body de la tabla. Con la funcion de map, se recorre la variable coches definida en el estado.

La funcion map recorre uno a uno el array de coches. (Al utilizar la funcion de map, se define la matricula como identificador para cada elemento del map.)

Para cada coche, escribe/añade un componente FilaCoches. Se le pasa en el atributo "cochePropiedad" el coche de la iteracion que esta del map.

```js
<tbody>
    { this.state.coches.map((c) => <FilaCoches  cochePropiedad={c} key={c.Matricula} /> ) }
</tbody>
```

## FilaCoche
En el componente FilaCoche obtiene un coche en la propiedad "cochePropiedad"
```js
const cocheConstante = this.props.cochePropiedad;
```

E imprime una fila con los datos de ese coche en concreto.
```js
    return (
       <tr>
            <td>{cocheConstante.Matricula}</td>
            <td>{cocheConstante.Marca}</td>
            <td>{cocheConstante.Modelo}</td>
            <td>{cocheConstante.fechaMatriculacion}</td>
        </tr>
     )
```


# Ejecutar
- Descargar el proyecto
- Instalar depedencias en local
(Dentro de la carpeta del proyecto)
```
npm install
```
- Ejecutar en local
(Dentro de la carpeta del proyecto)
```
npm start
```