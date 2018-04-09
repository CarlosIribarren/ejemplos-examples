window.onload = function(){

    /* Ejemplo 1:
        Ordenar un arreglo por el abecedario
        Si no se define una funcion de ordenacion, se ordena por el abecedario
    */
    console.log("Ejemplo 1: Ordenar un arreglo por el abecedario");
    // Definir un arreglo
    var arreglo_1 = [2,5,1,10,20];
    console.log("Arreglo original:" + arreglo_1);
    // Ordenar
    arreglo_1.sort();
    // Imprimir por consola
    console.log(arreglo_1);


    
    /* Ejemplo 2:
        Ordenar un arreglo por los numeros

        Se define una funcion para la ordenacion con la siguiente forma por definicion:
        ===============================================================================
        function compare(a, b) {
             if (a es menor que b según criterio de ordenamiento) {
                return -1;
            }
            if (a es mayor que b según criterio de ordenamiento) {
                return 1;
            }
            // a debe ser igual b
            return 0;
        }

    */
    console.log("Ejemplo 2: Ordenar un arreglo por los numeros");
    function ordenacion_Numerica(a,b){
        if(a>b){
            return 1;
        }
        else if(b>a){
            return -1;
        }
        else if(a==b){
            return 0;
        }
    }

    // Definir un arreglo
    var arreglo_2 = [2,5,1,10,20];
    console.log("Arreglo original:" + arreglo_2);
    // Ordenar
    arreglo_2.sort(ordenacion_Numerica);
    // Imprimir por consola
    console.log(arreglo_2);


    /* Ejemplo 3:
        Dar la vuelta a un arreglo
    */
    console.log("Ejemplo 3: Dar la vuelta a un arreglo");
    // Definir un arreglo
    var arreglo_3 = [2,5,1,10,20];
    console.log("Arreglo original:" + arreglo_3);
    // Ordenar
    arreglo_3.reverse();
    // Imprimir por consola
    console.log(arreglo_3);


    /* Ejemplo 4:
        Convertir una cadena en una arreglo
    */
    console.log("Ejemplo 4: Convertir una cadena en una arreglo");
    var cadena_4 = "a,b,c,2";
    console.log("Cadena original:" + cadena_4);
    // Utilizando el separador por coma, lo convertimos en un arreglo
    var arreglo_4 = cadena_4.split(",");
    // Imprimir por consola
    console.log(arreglo_4);


    /* Ejemplo 5:
        Convertir un arreglo en una cadena
    */
    console.log("Ejemplo 5: Convertir un arreglo en una cadena");
    var arreglo_5 = ["a","b","c","2"];
    console.log("Arreglo original:" + arreglo_5);
    
    // Separar los valores con coma y convertir en String
    var cadena_5_coma = arreglo_5.join(",");
    // Separar los valores con punto y convertir en String
    var cadena_5_punto = arreglo_5.join(".");

    // Imprimir por consola
    console.log(cadena_5_coma);
    console.log(cadena_5_punto);
}