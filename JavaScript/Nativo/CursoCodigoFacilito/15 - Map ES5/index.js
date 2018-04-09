window.onload = function(){

        /* Ecmascript 5:
           =============
            - Map: Metodo que toma como parametro un callback o una funcion, y construlle un nuevo arreglo
                        con el resultado despues de ejecutar la funcion para cada elemento.
        */

    var numeros = [1,5,6,8];

    /* Ejemplo 1:
        Sin utilizar Map
        Por cada numero del arreglo, calcular el cuadrado del numero y crear un arreglo nuevo
    */
    console.log("Ejemplo 1: Sin utilizar Map");
    var cuadrados_1 = [];
    for(var i = numeros.length-1 ; i>=0; i--){
        // Obtener el numero
        var numero = numeros[i];
        // Calcular el cuadrado
        var numero_Calculado = Math.pow(numero,2);
        cuadrados_1.push(numero_Calculado);
    }
    console.log(cuadrados_1);

    /* Ejemplo 2:
        Utilizando Map
        Por cada numero del arreglo, calcular el cuadrado del numero y crear un arreglo nuevo
    */
    console.log("Ejemplo 2: Utilizando Map");
    function map_Cuadrado(numero){
        var numero_Calculado = Math.pow(numero,2);
        return numero_Calculado;
    }
    // Utilizar la funcion de map
    var cuadrados_2 = numeros.map(map_Cuadrado);
    console.log(cuadrados_2);

}