<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<!-- HACEMOS LA QUERY PREGUNTANDO AL RECURSO -->
	<sql:query var="rs" dataSource="jdbc/empresaReparto">
		select nombre from empleado
	</sql:query>

<html>
<head>
<title>Test</title>
</head>
<body>
	<h2>Empleados</h2>
<c:forEach var="row" items="${rs.rows}">
<p>Nombre: ${row.nombre}</p>
</c:forEach>
</body>
</html>

