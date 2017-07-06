/* **************************************************************************
 * ********************* Creando el primer servidor ************************* 
 * **************************************************************************
 * 
 * Para poner en marcha en servidor ejecutar en la consola: node hello.js 
 *
 * Para probar el ejemplo hay que acceder a la url "http://localhost:8080/" 
 * y mirar si escribe "Hola mundo" en pantalla. 
 * Tambien tiene que escribir en la consola "Peticion recibida".
 * */


/* Obtener el modulo "http", que se encarga de servir aplicaciones Web con el protocolo HTTP */
var http = require("http");

/* Se define la funcion que se pasa como parametro a createServer(f). */
var manejador = function(solicitud, respuesta)
{
    //Imprime el mensaje por consola
    console.log("Peticion recibida")

    /* Cerrar la peticion(conexion) */
    respuesta.end("Hola mundo"); 

};

/* Utilizamos la funcion createServer(f) del objeto http para crear el servidor.
    La funcion que necesita recibir el metodo createServer(f), tiene que tener dos parametros: la solicitud y la respuesta */
var servidor = http.createServer(manejador);

//Asignar el puerto 8080
servidor.listen(8080);