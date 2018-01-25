/**
 * Muestra ejemplo de como leer ficheros sincronamente utilizando el modulo File System.
 * 
 * Llamadas síncronas: No continua con la siguiente linea hasta que termine la operación.
 * 
 *      - var file = fs.readFileSync(path[, options])
 *          Returns the contents of the path
 */

//Obtener el modulo http
var http = require("http");
//Obtener el modulo fs
var fs = require("fs");

//Leer el fichero (Sincronamente)
var html_Sync = fs.readFileSync("./index.html");

// Iniciar el servidor
http.createServer(function(req, res){

    //Mandar un archivo html al usuario
    res.write(html_Sync);

    //Terminar la conexion
    res.end();

}).listen(8080);
