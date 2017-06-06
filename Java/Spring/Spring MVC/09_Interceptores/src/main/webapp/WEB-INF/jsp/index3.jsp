<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<title>Index 3</title>
</head>
<body>

  <h1>Index 3</h1>

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
