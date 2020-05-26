# Ejemplo
En este ejemplo se muestra como se puede utilizar un operador ternario en un CSS.

Es un ejemplo poco comun, normalmente no puede hacer de otras maneras mejor.

## Caja
El en componente caja se define un metodo que retorna un objeto de CSS.

La propiedad color del CSS tiene un operador ternario, que utiliza el valor de la propiedad esVisible del componente.
En funcion del valor de la propiedad esVisible, se se da un valor a la propiedad color.

```js
  StyleDinamico() {
    return {
      border: 'solid',
      height: '50px',
      width: '50px',
      color: this.props.esVisible==='rojo' ? 'red' : 'black'

    }
  }
```

Y al renderizar el DIV, se llama al metodo que contiene el CSS.

```js
    <div>
      <div style={this.StyleDinamico()}></div>
    </div>
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