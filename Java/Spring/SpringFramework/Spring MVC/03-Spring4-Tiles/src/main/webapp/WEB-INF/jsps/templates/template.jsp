<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>

<!doctype html>
<html lang="${springRequestContext.locale}">
	<head>
		<title><tiles:getAsString name="nombreVista"/></title>
	</head>
	<body>
		<tiles:insertAttribute name="cabecera" />
		<tiles:insertAttribute name="cuerpo" />
		<tiles:insertAttribute name="pie" />
	</body>
</html>