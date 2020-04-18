<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
<head>
	<title>04 Parametros Entrada</title>
</head>
<body>
	<h2>04 Parametros</h2>
	<p>Esta JSP envia datos en un obj cuenta</p>
	<p>En Spring los parametros de HTML se envian en obj (Clases).</p>
	<p>Con el atributo ModelAtribute se indica el objeto</p>
	<p>Con el atributo path se indica la propiedad del obj con la que se quiere mapear</p>

	
	<form:form action="persona/new" method="POST" modelAttribute="persona" >
	
		<li>
			<label>Introduce un Id:</label> 
			<form:input path="id" />
		</li>
		<li>
			<label>Introduce un Nombre:</label> 
			<form:input path="nombre" />
		</li>
		<li>
			<label>Introduce un apellido:</label> 
			<form:input path="apellido"/>
		</li>
		<li>
			<label>Poblacion:</label> 
			<form:input path="poblacion"/>
		</li>
		
		<input type="submit" value="Enviar Objeto Persona"/>
		
	</form:form>


</body>
</html>
