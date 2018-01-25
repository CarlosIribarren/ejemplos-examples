<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- DEFINIR EL NAME SPACE DE JSTL -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>USANDO JSTL</h1>
	<hr>

	<!-- USANDO JSTL -->
	<!-- ${bean.propiedad} -->
	<h3>Usando expresion languaje de JSTL </h3>
	${personaAtributo.nombre}
	
	<hr>
	<h3>Usando tags del core de JSTL </h3>
	<c:out value="${personaAtributo.nombre}"></c:out>


</body>
</html>