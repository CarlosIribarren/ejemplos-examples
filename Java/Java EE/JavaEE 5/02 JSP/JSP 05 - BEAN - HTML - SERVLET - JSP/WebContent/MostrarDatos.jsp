<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="bean.BeanPersona"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<h1>Recibir Bean</h1>
	<hr>


	<h2>Recibir Bean 1 : desde Servlet => usando JSP TAGS</h2>
	 
		<jsp:useBean id="persona" class="bean.BeanPersona" scope="request"/>
		
		Nombre : <jsp:getProperty name="persona" property="nombre"/> 
		Apellido : <jsp:getProperty name="persona" property="apellido"/> 
	<hr>

	<h2>Recibir Bean 1 : desde Servlet => usando Scriptlets</h2>
	 
		<%
	 			BeanPersona p = new BeanPersona();
	 			 			 				p = (BeanPersona) request.getAttribute("persona");
	 		%>
		Nombre : <%=p.getNombre()%>
		Apellido : <%=p.getApellido()%>
	<hr>
	
	<h2>Recibir Bean 1 : desde Servlet => usando expresion</h2>
	 
		<jsp:useBean id="persona2" class="bean.BeanPersona" scope="request"/>
		Nombre : ${ persona2.nombre }
		Apellido : ${ persona2.apellido}
	<hr>

</body>
</html>