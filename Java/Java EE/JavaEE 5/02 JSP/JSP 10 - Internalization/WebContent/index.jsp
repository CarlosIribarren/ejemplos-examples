<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- DEFINIR EL NAME SPACE DE JSTL -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- DEFINIR LAS URL CON PARAMETROS -->

	<c:url value="cambiarIdioma" var="url_ES">
		<c:param name="idioma" value="es_ES" />
	</c:url>
	<c:url value="cambiarIdioma" var="url_EN">
		<c:param name="idioma" value="en_US" />
	</c:url>
	<c:url value="cambiarIdioma" var="url_EUS">
		<c:param name="idioma" value="es_EUS" />
	</c:url>

	<hr>
		<a href="url_ES">castellano</a>
	<hr>
		<a href="url_EUS">euskera</a>
	<hr>
		<a href="url_EN">Ingles</a>
	<hr>
	

	
	<hr>

	<c:set var="idioma" scope="page" value="holaaaaaaaaa"/>
	${param.idioma}
	${idioma}
	
	
	<fmt:setLocale value="es_ES"/>
	
	<fmt:setBundle basename="i18n.Translations" var="traduciones"/>
	<fmt:message key="cabecera1" bundle="${traduciones}" ></fmt:message>


</body>
</html>