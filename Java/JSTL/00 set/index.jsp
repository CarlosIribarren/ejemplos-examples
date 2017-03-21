<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<title><c:set> Tag Example</title>
</head>

<body>
	<c:set var="salary" scope="session" value="${2000*2}"/>
	<c:out value="${salary}"/>
</body>

</html>