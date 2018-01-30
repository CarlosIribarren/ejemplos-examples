
window.onload = function(){

//Imprime un mensaje por la consola
console.log("Hola Mundo");

//Muestra una alerta
alert("Hola Mundo");

//Insertar el texto en el tag body
document.querySelector("body").innerHTML = "Hola Mundo";


//******** Variables ******

// No se necesita declarar el tipo
var nombre;
nombre =  "Uriel";

// No diferenrencia entre float y enteros
var edad = 22;
var precio = 12.5;

//Mala practica
// Exiset la posiblidad de declarar una variable sin la palabra reservada var
// Se recomienda utilizar la palabra var
canal = "Youtube";


// Probado las variables
console.log(edad);

//Concatenar la variable
document.querySelector("body").innerHTML = "Hola " + nombre;






}

