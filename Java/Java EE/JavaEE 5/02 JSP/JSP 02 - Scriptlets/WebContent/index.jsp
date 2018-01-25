<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo de Scriptlets</title>
</head>
<body>


<h1> Scriptlets DECLARACIONES </h1>

<!-- definir variable 
    para que una variable sea visible en todos los trozos de Scriplet,
    se tiene que utilizar con el simbolo especial [!] -->
<%! int maxAlumnosClase = 30; %>
<!-- mostrar variable [=] -->
<p> Se ha definido una variable en un trozo de Scriptlet y se lee desde otro trozo de Scriplet </p>
<p> Definir variable y leer => maxAlumnosClase : <%=maxAlumnosClase %> </p>
<hr>





</body>
</html>
