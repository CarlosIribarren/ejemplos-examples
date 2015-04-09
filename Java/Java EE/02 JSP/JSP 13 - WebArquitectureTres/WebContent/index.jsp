<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Plantilla básica de Bootstrap</title>
 
    <!-- CSS de Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
    <!-- CUSTOM CSS Bootstrap -->
    <link href="css/customCSS.css" rel="stylesheet" media="screen">
 
    <!-- librerías opcionales que activan el soporte de HTML5 para IE8 -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<h1>My index</h1>
	<a href="emp/view">Ver empleados</a>
	
	<!-- PRINCIPAL -->
	<div class="container">	

		<!-- MENU HORIZONTAL -->
		
		<div class="row-menu-horizontal"> <!-- DEFINIMOS row-nombre => para referenciar desde el CSS y darle un margin-boton -->
			<nav >
				<ul>
					<div class="col-sm-2">
						<a class="text-danger" href="empleados">Empleados</a>
					</div>
					<div class="col-sm-2">
						<a href="empresas">Empresas</a>
					</div>
					<div class="col-sm-8">
						<a href="coches">Coches</a>
					</div>
				</ul>
			</nav>
		</div>

		
		<!-- MENU LATERAL -->
		<div class="row">
		
			<div class="col-sm-2">
				<nav>
					<ul class="list-unstyled"><!-- list-unstyled => para quitar el formato a la lista -->
						<li><a href="empleados">Empleados</a></li>
						<li><a href="empresas">Empresas</a></li>
						<li><a href="coches">Coches</a></li>
					</ul>
				</nav>
			</div>
			
			<div class="col-sm-10">
				<section>
					<h2>Seccion 1</h2>
					<article>
						<h3>Articulo 1</h3>
					</article> 
					<article>
						<h2>Articulo 2</h2>
					</article> 
				</section>
			</div>

	</div>
	
	
	
	<!-- Librería jQuery requerida por los plugins de JavaScript -->
    <script src="http://code.jquery.com/jquery.js"></script>
 
    <!-- JS de Bootstrap -->
    <script src="js/bootstrap.min.js"></script>
    
    <!-- CUSTOM JS -->
    <script src="js/customJS.js"></script>
    
</body>
</html>