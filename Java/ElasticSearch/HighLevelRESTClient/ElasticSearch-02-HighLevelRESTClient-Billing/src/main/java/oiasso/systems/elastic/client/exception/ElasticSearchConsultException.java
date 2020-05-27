package oiasso.systems.elastic.client.exception;

public class ElasticSearchConsultException extends Exception {

	// ************************
	// ****** Constants *******
	// ************************

	private static final long serialVersionUID = 321097312993231180L;

	// ************************
	// **** Public methods ****
	// ************************

	public ElasticSearchConsultException(final String errorMessage, final Exception e) {
		super(errorMessage, e);
	}
}
