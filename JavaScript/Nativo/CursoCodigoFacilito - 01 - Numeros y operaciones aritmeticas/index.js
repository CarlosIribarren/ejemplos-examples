
window.onload = function(){

var edad = 19;
edad++;
console.log(edad + 3);

var punto_flotantes = 12.5;
// Sumar una variable entera con un float sin tener que convertir los tipos
console.log(edad + punto_flotantes);

/* 
Comentarios de bloque

Operadores aritmeticos
Division = /
Multiplicacion = *
Suma = +
Resta = -
Modulo = %

*/

// Asignar a una variable una operacion
var resultado_suma = edad + punto_flotantes;
console.log(resultado_suma);

// Modulo
var resultado_modulo = edad % 2;
console.log(resultado_modulo);
console.log(es_par(3));
console.log(es_par(4));


function es_par(numero)
{
     if(numero % 2 == 0){
         return true;
     }
     return false;
}


// Clase Math
// Potencia
console.log(Math.pow(2,3));
// Redondeo
console.log(Math.round(0.3));
console.log(Math.round(0.7));
// Redondeo hacia arriba
console.log(Math.ceil(0.3));
// Redondear hacia abajo
console.log(Math.floor(0.3));
// PI
console.log(Math.PI);
// Numero aleatorio entre 0 y 1
console.log(Math.random());
// Raiz cuadrada
console.log(Math.sqrt(4));

}

