window.onload = function(){

    /* Ejemplo 1: 
        Declarar una funcion.
         Los parametros pueden ser de cualquier tipo.
         Si no se retorna nada, retorna undefined.
         Como se retorna un resultado, el resultado se puede almacenar en una variable.
         No es necesario enviar todos los parametros. Si un paramtero no se envia, el parametro
         toma el valor de undefined. 
    */
    function suma(a,b){
        return a+b;
    }
    // Ejeutar la funcion y guardar el resultado
    var resultado_1 = suma(4,7);
    console.log(resultado_1);
    

    /* Ejemplo 2: 
        Declarar una funcion con parametros opcionales.
         No es necesario enviar todos los parametros. 
         Si un paramtero no se envia, el parametro toma el valor de undefined. 
    */
    function suma_con_parametro_b_opcional(a,b){
        console.log(b);
        // El operador OR toma el primer valor que devuelva true, undefined no es un valor true
        b = b || 0;
        return a+b;
    }
    // Ejeutar la funcion sin enviar el parametro b
    var resultado_2 = suma_con_parametro_b_opcional(4);
    console.log(resultado_2);


    /* Ejemplo 3: 
        Almacenar la funcion en una variable.
    */
    // Crear una funcion que recibe como parametro una funcion.
    // Al llamar a ejecutar la funcion no se envian los parametros.
    function ejecutar_funcion(funcion){
        return funcion();
    }
    // Crear una funcion sin parametros
    function visualizar_log(){
        console.log("Mensaje del log");
    }
    // Guardar la funcion en una variable
    var funcion_visualizar_log = visualizar_log;  

    // Pasar como parametro la variable que contiene la funcion.
    ejecutar_funcion(funcion_visualizar_log);


}