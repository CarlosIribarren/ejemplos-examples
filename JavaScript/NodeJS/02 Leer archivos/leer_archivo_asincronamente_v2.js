/**
 * Muestra ejemplo de como leer ficheros asincronamente utilizando el modulo File System.
 * -------------------------------------------------------------------------------------------------------
 * 
 * Funcionamiento: Cada vez que se recibe una peticion, se lee el fichero asincronamente.
 *      Cuando termina de leer el fichero asincronamente, se envia la respuesta al cliente.
 *      Se lee el fichero en cada peticion.
 *      Si actualizamos algo en el fichero index.html, no hay que reiniciar el servidor.
 * 
 * -------------------------------------------------------------------------------------------------------
 * 
 * Llamadas asíncronas: No bloqueamos la ejecución de nuestro programa.
 * 
 *      - fs.readFile(path[, options], callback)
 *          callback: Es una funcion que se pasa como parametro y que se ejecuta despues de hacer algo.
 * 
 * -------------------------------------------------------------------------------------------------------
 * 
 * + Problemas de la programacion asincrona:
 *      - Uno no puede decir cuando esta accion va a terminar.
 *      - No estamos seguros de cuando esta accion se va a ejecutar.
 */

//Obtener el modulo http
var http = require("http");
//Obtener el modulo fs
var fs = require("fs");

/* Arrancar el servidor. Cada vez que se recibe una peticion, se ejecuta la funcion */
http.createServer(function (req, res) {

    /* Leer el fichero (Asincronamente):
    Se lee el fichero, y despues que lo haya leido, se llama a la funcion de calback.
    Es interesante porque la ejecucion no se detiene */
    fs.readFile("./index.html", function (err, html_Async) {

        //Mandar un archivo html al usuario
        res.write(html_Async);

        //Terminar la conexion
        res.end();
    });

}).listen(8080);




