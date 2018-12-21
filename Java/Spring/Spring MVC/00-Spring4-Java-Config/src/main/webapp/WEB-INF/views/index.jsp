<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
	<title>Spring MVC Java Config Example</title>
</head>
<body>

	<h1>Oiasso Systems - Examples - Spring MVC</h1>
	<p>Ejemplo de Spring4-Java-Config</p>

	<p>${message}</p>

	<ul>

		<li>
			<h2 style="text-decoration: underline;">getServletMappings()</h2>
			<p> Con el método <strong>getServletMappings()</strong> estamos indicando que el Dispatcher Servlet va a procesar la ruta "/" siendo así el servlet predeterminado 
				de nuestra aplicación web.</p>
		</li>

		<li>
			<h2 style="text-decoration:underline;">Diferencia entre getRootConfigClasses() y getServletConfigClasses() </h2>
			<p> El método <strong>getServletConfigClasses()</strong> devuelve la clase usada para la configuración de la capa web, ejemplo:
				Controladores, Vistas, etc., mientras que <strong>getRootConfigClasses()</strong> retorna la clase usada para configurar las demás capas de la
				aplicación, ejemplo: Servicios, Acceso a datos, etc.
			</p>
			<img alt="" src="resources/img/k3kI2.png" height="500ep" width="500ep">
			<p>
				Es posible ubicar toda la configuracion en la clase devuelta por <strong>getRootConfigClasses()</strong>
			</p>
			<img alt="" src="resources/img/ykYLG.png" height="500ep" width="500ep">
		</li>
		
	</ul>

</body>
</html>
