<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script>
	
	$(document).ready(function(){

		$("#sumar").click(function(){

			// Obtener valores
			n1 = $("#value1").val();
			n2 = $("#value2").val();
		
			// propiedes:
			//		- url: URL a la que se quiere invocar, al realizar la llamada le pone la "/"
		    // 		- dataType: tipo de dato (obligatorio)
		    // 		- data: datos que se quieren enviar
			
		    $.ajax({
		    	url: "sumar",
		    	dataType: "json",
		    	data: { numero1: n1, numero2: n2 },
		    	success: function(result){
		    		$("#total").val(result);
		    }});
		    
		});
	
	});
		
	</script>
	
</head>
<body>

	<label>Numero 1: </label>
 	<input type="number" name="numero1" id="value1"/>

	<br>

	<label>Numero 2: </label>
	<input type="number" name="numero2" id="value2"/>
	
	<br>
	
	<button type="button" id="sumar">Sumar</button>
	
	<br>
	
	<label>Total: </label>
	<input type="text" id="total"/>
	
</body>
</html>

