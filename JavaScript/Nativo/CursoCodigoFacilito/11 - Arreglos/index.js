window.onload = function(){

    // Definir un arreglo, existen dos maneras para definir.
    var arreglo_1 = []; // W3C recomienda utilizar esta manera
    var arreglo_2 = new Array();

    // Los arreglos no tienen tipos. 
    // Se puede colocar cualquier valor que una variable de JS acepte.
    var arreglo_3 = [20, "Hola mundo", {}, []];

    // Aceder a un arreglo a traves de la posicion. El primera posicion es 0.
    var arreglo_4 = [20, 10, 5];
    console.log(arreglo_4[0]);

    // Los arreglos son objetos y tienen metodos
    // Obtener la longitud de un arreglo
    console.log(arreglo_4.length);

    /* Ejemplo 1:
        Se puede utilizar el arreglo como una pila
    */
    console.log("Ejemplo 1:")

    // Añadir un obj al final
    arreglo_4.push(7);
    console.log(arreglo_4);
    // Eliminar el ultimo obj
    arreglo_4.pop();
    console.log(arreglo_4);

    // Añadir un obj al principio
    arreglo_4.unshift(8);
    console.log(arreglo_4);
    // Eliminar el primer obj
    arreglo_4.shift();
    console.log(arreglo_4);

    /* Ejemplo 2: 
        Iterar el arreglo hacia adelante
    */
    console.log("Ejemplo 2:")

    // Iterar un arreglo hacia adelante
    var arreglo_5 = [20, 10, 5];
    for(var i=0;i<arreglo_4.length;i++){
        console.log(arreglo_5[i]);
    }

    /* Ejemplo 3: 
        Iterar el arreglo hacia atras. Ees mas optima que la anterior, ya que cada vez que itera
        y comprueba el condicion, es mas facil comparar con el valor de 0 que comparar con la 
        longitud del metodo (arreglo_4.length) como en el ejemplo anterior.
    */
    console.log("Ejemplo 3:")

    // Iterar un arreglo hacia atras
    var arreglo_6 = [30, 40, 6];
    for(var i=arreglo_6.length-1;i>=0;i--){
        console.log(arreglo_6[i]);
    }


    
}