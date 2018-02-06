window.onload = function(){

        /* Ecmascript 5:
           =============
            - reduce: Metodo que toma como parametro un callback o una funcion, 
                        y ejecuta la funcion para cada elemento.
                      Gracias a el parametro "valor_anterior_retornado", 
                        permite llevar un rastro de las ejecuciones anteriores 
                        de la funcion, o dicho de otra manera, permite llevar un 
                        registro de todo lo que va retornando en sus iteraciones previas.
                        Esto seria como si tuvieramos un ciclo
                        for/while y tuvieramos una variable dentro guardando
                        algun valor, como puedan ser, "cadena_total_1" o "suma_total_3".
        */  

        
    /* Ejemplo 0:
        Ejempo de reduce. Muestra el valor de cada parametro en cada iteracion.
     */
    console.log("****** Ejemplo 0: Ejempo de reduce. Muestra el valor de cada parametro en cada iteracion *********");
    var letras = ["H", "o", "l", "a"];
    /**
     * Funcion de mustra para reduce.
     * 
     * @param {*} valor_anterior_retornado Valor retornado en la anteior interacion
     * @param {*} valor_actual Valor actual del arreglo
     * @param {*} index Indice del arreglo actual
     * @param {*} arreglo Arreglo
     */
    function reduce_funcion(valor_anterior_retornado, valor_actual, index, arreglo){
        console.log(" ******** Iteracion ********");
        console.log("valor_anterior_retornado: " + valor_anterior_retornado);
        console.log("valor_actual: " + valor_actual);
        console.log("index: " + index);
        console.log("arreglo: " + arreglo);
    }
    var palabra = letras.reduce(reduce_funcion);

 
    /* Ejemplo 1:
        Unir los elementos de un arreglo sin reduce.
     */
    console.log("****** Ejemplo 1: Unir los elementos de un arreglo sin reduce *********");
    var arreglo_1 = ["H","o","l","a"];
    var cadena_total_1 = "";
    for(var i = 0; i < arreglo_1.length;i++){
        cadena_total_1 = cadena_total_1 + arreglo_1[i];
    }
    console.log(cadena_total_1);


    /* Ejemplo 2:
        Unir los elementos de un arreglo con reduce.
     */
    console.log("****** Ejemplo 2: Unir los elementos de un arreglo con reduce *********");
    var arreglo_2 = ["H","o","l","a"];
    function reduce_Unir_Arreglo(valor_anterior_retornado, valor_actual, index, arreglo){
        return valor_anterior_retornado + valor_actual;
    }
    var arreglo_2_Unido = arreglo_2.reduce(reduce_Unir_Arreglo);
    console.log(arreglo_2_Unido);
    
    
    
    /* Ejemplo 3:
        Sumar todos los numeros de un arreglo sin reduce.
     */
    console.log("****** Ejemplo 3: Sumar todos los numeros de un arreglo sin reduce *********");
    var arreglo_3 = [20,1,23,1,5];
    var suma_total_3 = 0;
    for(var i = 0; i < arreglo_3.length;i++){
        suma_total_3 = suma_total_3 + arreglo_3[i];
    }
    console.log(suma_total_3);

    
    /* Ejemplo 4:
        Sumar todos los numeros de un arreglo con reduce.
     */
    console.log("****** Ejemplo 4: Sumar todos los numeros de un arreglo con reduce *********");
    var arreglo_4 = [20,1,23,1,5];
    var total_4 = arreglo_4.reduce(function(valor_anterior_retornado, valor_actual, index, arreglo){
        return valor_anterior_retornado + valor_actual;
    });
    console.log(total_4);


    /* Ejemplo 5:
        Sumar todos los numeros de un arreglo con reduce y definir un "initialValue"

        En la primera iteracion el valor de "valor_anterior_retornado" es undefined.
        Con el parametro "initialValue" ee puede pasar por parametro el valor para este caso:
        
        array.reduce(function(total, currentValue, currentIndex, arr), initialValue)

     */
    console.log("****** Ejemplo 6: Sumar todos los numeros de un arreglo con reduce y definir un 'initialValue' *********");
    var arreglo_5 = [20,1,23,1,5];
    var total_5 = arreglo_5.reduce(function(valor_anterior_retornado, valor_actual, index, arreglo){
        return valor_anterior_retornado + valor_actual;
    }, 5);
    console.log(total_5);  
  
}