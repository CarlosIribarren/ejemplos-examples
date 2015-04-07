<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<!-- TODO LO QUE ESTA METIDO DENTRO DE LA CARPETA WEB-INF 
     ,NO ES ACESIBLE DESDE FUERA DE LA MISMA 
     EN LA CARPETA DE WEB-INF SOLO METEMOS LOS JSP, 
     PARA QUE EL USUARIO NO PUEDA HACEDER A LOS JSP
     NI TAMPOCO A EL WEB.XML -->

<head>
	<meta charset="utf-8" />
	<link rel="stylesheet" href="CSS/estilo.css" />
	<title>Pagina de Inicio</title>
</head>

<body>
	<nav>
		<h2>Navegacion</h2>
	</nav>
	<section>
		<h2>Seccion 1</h2>
		<article>
			<h3>Articulo 1</h3>
		</article>
		<article>
			<h2>Articulo 2</h2>
		</article>
	</section>

	<input id="form-person-title" type="text" list="mylist">
	<datalist id="mylist">
		<option label="Mr" value="Mr">
			<option label="Ms" value="Ms">		
		<option label="Prof" value="Mad Professor">
	</datalist>
			<input type="range" mix="0" max="100" step="5">
	
	<footer>
				<h2>Pie de pagina</h2>
	</footer>

		</body>
</html>