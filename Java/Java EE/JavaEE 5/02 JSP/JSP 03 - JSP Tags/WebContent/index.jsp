<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo de JSP tags</title>
</head>
<body>

<h1>Ejemplo de JSP tags</h1>

<p> En este ejemplo de muestran 3 acciones usando tags : </p>
<p> - Usar una clase como Bean</p>
<p> - Definir una valor para la propiedad del Bean</p>
<p> - Leer una valor del Bean</p>

<jsp:useBean id="persona" class="beanMIOS.Persona"/>
<jsp:setProperty name="persona" property="nombre" value="Carlos"/>

<h2> Resultado : <jsp:getProperty name="persona" property="nombre"/> </h2>







</body>
</html>