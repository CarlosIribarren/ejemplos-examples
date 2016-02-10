<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>05 Validator Anotaciones Spring Y Hibernate</title>
    <style>
    	.error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>
	
	<h2>05 Validator Anotaciones Spring Y Hibernate</h2>

	<form:form action="" method="POST" modelAttribute="estudiante" >
	
		<ul>
			<li>
				<label>Introduce un Nombre:</label>
			 
				<form:input path="nombre" />
				<form:errors path="nombre" cssClass="error"/>
			</li>
		</ul>
		<ul>
			<li>
				<label>Introduce un edad:</label> 
				<form:input path="edad"/>
				<form:errors path="edad" cssClass="error"/>
			</li>
		</ul>	
		
		<input type="submit" value="Guardar"/>
		
	</form:form>

	<a href="/SpringMVC_CRUD_REST/">Atras</a>

</body>
</html>