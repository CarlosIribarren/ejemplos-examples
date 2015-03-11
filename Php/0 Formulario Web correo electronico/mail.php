<?php

$fecha=date("d-m-Y");
$hora=date("H:i:s");

$destino="izozkadenda@gmail.com";
$asunto="Comentario de Pagina Web Izozka";
$desde="From ".$_POST['correo'];


$nombre=$_POST['nombre'];
$correo=$_POST['correo'];
$telefono=$_POST['telefono'];
$consulta=$_POST['mensaje'];

$comentario = "
\n	
Nombre: $nombre \n
Email: $correo \n
Telefono : $telefono \n
Consulta: $consulta \n
Enviado: $fecha a las $hora\n
\n
";
$respuesta=mail($destino, $asunto, $comentario);
echo $respuesta;
if($respuesta){
    echo "Mensaje enviado";
}else{
    echo "Mensaje no enviado";
}

echo 'MAIL'
?>
