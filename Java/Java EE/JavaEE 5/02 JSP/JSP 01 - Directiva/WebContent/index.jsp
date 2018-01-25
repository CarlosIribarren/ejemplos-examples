<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    
     info="se puede acceder a traves del metodo Servlet.getServletInfo"
     
     errorPage="error.jsp"
    %>

    <!-- DIRECTIVA : Incluye el contenido de un fichero en la página mediante el atributo file  -->
    <%@ include file="cabecera.html" %>
    
    

<body>
<h1>Ejemplo Directiva</h1>

<p> Se carga una cabecera utilizando el tag [include file] de JSP </p>
<hr>
<p> Se ha definido una pagina de error en este JSP, en la Directiva page, en el atributo page, [errorPage="error.jsp"]  </p>


</body>
</html>