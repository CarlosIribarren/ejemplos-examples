Comentarios para ejemplo.php

Tres cosas a destacar:

Al usar un servidor smtp para el envío del mensaje es muy importante definir la propiedad PluginDir que indica donde se encuentra el fichero class.smtp.php que contiene la clase SMTP, en este caso se encuentra en el subdirectorio includes

El uso simultáneo de las propiedades Body y AltBody. Se debe hacer cuando queremos mandar un mensaje con formato Html ya que es posible que el destinatario acepte sólo correos en formato texto. Al definir las dos propiedades, Body y AltBody, no es necesario ejecutar el método IsHTML(True) cuando a Body se le asigna un mensaje en formato Html

La tercera y más importante a tener en cuenta es el hecho de que el éxito en el envio del mail no depende sólo de la clase PHPMailer sino que es vital el tiempo que el servidor smtp necesita para autenticar al usuario así como el tiempo que tarda dicho servidor en enviar un correo.

Por tanto es fundamental proporcionarle al servidor el tiempo que le hace falta, ello se cosigue de dos formas: Por un lado aumentando el valor de la propiedad Timeout pasando por ejemplo de 10 a 30 segundos; Y por otro lado reintentando el envío del mensaje un número razonable de veces (por ejemplo 5), dejando un tiempo de espera (por ejemplo 5 segundos), entre cada intento.

Mediante la combinación de estos 3 factores: Propiedad Tiemout, numero de intentos para enviar el mensaje y tiempo de espera entre cada intento evitaremos los dos mensajes de error más frecuentes que nos puede dar la clase PHPMailer, relacionados con el tiempo que necesita el servidor smtp para realizar su función, y que son:

    SMTP Error: The following recipientes failed ......
    SMTP Error: Could not authenticate


