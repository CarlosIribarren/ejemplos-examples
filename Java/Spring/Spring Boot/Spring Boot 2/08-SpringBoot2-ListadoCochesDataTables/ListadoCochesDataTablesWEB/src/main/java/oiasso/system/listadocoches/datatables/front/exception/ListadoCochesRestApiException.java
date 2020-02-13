package oiasso.system.listadocoches.datatables.front.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListadoCochesRestApiException extends Exception{

	// *********************
	// ***** Constantes ****
	// *********************
	
	private static final long serialVersionUID = 2285776184048295304L;

	private static final Logger LOG = LoggerFactory.getLogger(ListadoCochesRestApiException.class);
	
	// *********************
	// **** Constructor ****
	// *********************
	
	public ListadoCochesRestApiException(String errorMessage, Exception e) {
		super(errorMessage,e);
		LOG.error(errorMessage,e);
	}
	
}
