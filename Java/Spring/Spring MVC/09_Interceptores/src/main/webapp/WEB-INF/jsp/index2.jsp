<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Index 2</title>
</head>
<body>

  <h1>Index 2</h1>

  <li><a href="/Interceptores/pagina1">Ir a Pagina 1</a></li>
  <li><a href="/Interceptores/pagina2">Ir a Pagina 2</a></li>
  <li><a href="/Interceptores/pagina3">Ir a Pagina 3</a></li>

  <c:forEach items="${pila}" var="element">
    <p>
      Item: 
      <c:out value="${element}" />
    </p>
  </c:forEach>

</body>
</html>
