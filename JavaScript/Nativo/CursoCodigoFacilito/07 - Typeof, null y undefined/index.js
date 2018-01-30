window.onload = function(){

    // Typeof: Permite identificar el tipo de una variable
    // ***************************************************
    
    // Tipo de un numero = number
    var numero = 0;
    console.log(typeof numero);
    // Tipo de una cadena = string
    var cadena = "";
    console.log(typeof cadena);
    // Tipo de un array = object
    var arreglo = [];
    console.log(typeof arreglo);
    // Tipo de un json = object
    var json = [];
    console.log(typeof json);


    // Validar si una variable esta declarada
    if(typeof hola == "undefined"){
        console.log("La variable hola no esta declarada");
    }

    // null: la variable no tiene valor pero esta declarada
    // ***************************************************
    var contador = null
    if(typeof contador == "undefined"){
        console.log("La variable contador si esta definida");
        if(contador == null)
        {
            console.log("La variable contador esta vacia");
        }
    }

    // undefined: Cunado una variable no esta definida
    // ***********************************************
    // Es una variable global del lenguaje
    // No se puede asignar ningun valor 
     console.log("valor de undefined: " + undefined);

     // Al hacer la conversion de datos de undefined y de null retornan false.
     // estas dos variables retornan false, entonces false == false
    if(null == undefined){
        console.log("null == undefined es verdadero");
    }    
    if(null === undefined){
        console.log("null === undefined es falso");
    }    
}