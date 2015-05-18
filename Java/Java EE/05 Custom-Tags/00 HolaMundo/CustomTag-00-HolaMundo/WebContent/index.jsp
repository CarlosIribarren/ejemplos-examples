<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="customtag" prefix="test" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head><title>TAG SIMPLE</title></head>
<body>
<%String nombre="Carlos Iribarren";%>
<h1><test:holaMundo nombre="<%=nombre%>"/></h1>
</body>
</html>