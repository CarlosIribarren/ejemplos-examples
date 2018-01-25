<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<sql:setDataSource driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/empresaReparto" user="root"
		password="passroot" var="dataSource" />

	<sql:query var="rs" startRow="0" maxRows="-1"
		sql="SELECT * from empleado" dataSource="${dataSource}"
		scope="request" />

	<c:forEach items="${rs.rows}" var="item">
		Item <c:out value="${item.nombre}" /> <br>
	</c:forEach>

</body>
</html>