window.onload = function(){

    /* Ecmascript 5:
       =============
            - Filter: Metodo que toma como parametro un callback o una funcion, y construlle un nuevo arreglo
                        a partir de aquellos elementos que al ejecutar la funcion esta devuelve verdadero.
    */

    var numeros = [10,2,3,5,9,20,22];
    console.log("Numeros originales:" + numeros);

    /* Ejemplo 1:
        Buscar los numeros pares, sin Filter
     */
    console.log("Ejemplo 1:");
    // Definir arreglo para el resultado
    var numeros_pares_2 = [];
    for(var i = numeros.length; i>=0;i--){

        var numero = numeros[i];
        if(numero % 2 == 0){
            numeros_pares_2.push(numero);
        }
    }
    console.log("Numeros pares sin Filter:" + numeros_pares_2);

    /* Ejemplo 2:
        Buscar los numeros pares, con Filter
     */
    console.log("Ejemplo 2:");
    //Definir funcion para filtrar
    function filter_Numeros_Pares(numero){
        if(numero % 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }
    // Utilizar la funcion para filtrar con filter
    var numeros_pares_1 = numeros.filter(filter_Numeros_Pares);
    console.log("Numeros pares con Filter:" + numeros_pares_1);

}