# Oiasso Systems - Examples - Spring MVC
# Ejemplo de Rest Api

## Caracteristicas de proyecto:
	- Tomcat 8.5 
	- Java 8
	- Maven

## Obtener todas las personas
	- http://localhost:8080/01-Spring4-Rest-Api/personas (GET)
	
## Obtener una persona
	- http://localhost:8080/01-Spring4-Rest-Api/personas/2 (GET)
	
## Crear una persona
	- http://localhost:8080/01-Spring4-Rest-Api/personas (POST)
		{
        "id": 40,
        "nombre": "nombreNuevo",
        "apellido": "apellidoNuevo"
		}
		
## Borrar una persona
	- http://localhost:8080/01-Spring4-Rest-Api/personas/2 (DELETE)
	
## Actulizar una persona
	- http://localhost:8080/01-Spring4-Rest-Api/personas/3 (PUT)
		{
        "id": 3,
        "nombre": "nombreModificado",
        "apellido": "apellidoModificado"
		}
	





