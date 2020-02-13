package oiasso.system.listadocoches.datatables.front.variables;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/*
 * Clase donde se agrupas todas las variables de entorno para este proyecto. 
 * Solo se implementan los metodos get.
 */

@Component
public class VariablesEntornoListadoCochesWEB {

	// *********************
	// ***** Atributos *****
	// *********************
	
	@Value("${API_COCHES_HOST:http://localhost:8081}")
	private String apiCochesHost;

	// *********************
	// ****** Getter *******
	// *********************	
	
	public String getApiCochesHost() {
		return apiCochesHost;
	}	
	
	
	
	
}
