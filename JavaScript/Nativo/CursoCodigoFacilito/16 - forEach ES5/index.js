window.onload = function(){

        /* Ecmascript 5:
           =============
            - forEach: Metodo que toma como parametro un callback o una funcion, 
                        y ejecuta la funcion para cada elemento.
        */    

        /* Ejemplo 1:
            Iterar un arreglo
         */
        console.log("Ejemplo 1:")
        var numeros_1 = [2,4,6,8];

        /**
         * Funcion que se ejecuta para cada elemento del arreglo.
         * 
         * @param {*} element El elemento que se esta acediendo
         * @param {*} index El indice del elemento
         * @param {*} arreglo El array del cual se esta obteniendo cada uno de los elementos
         */
        function forEach_funcion(element, index, arreglo){
            console.log(element);
            console.log(index);
            console.log(arreglo);
        }

        // Iterar el arreglo
        numeros_1.forEach(forEach_funcion);


        /* Ejemplo 2:
            Iterar un arreglo y sumar 1 a cada elemento
         */
        console.log("Ejemplo 2:")
        var numeros_2 = [2,4,6,8];
        numeros_2.forEach(function(element, index, arreglo){
            arreglo[index] = element + 1;
        })
        console.log("Resultado arreglo sumando una unidad:" + numeros_2)

}