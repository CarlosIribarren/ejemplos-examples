package oiasso.systems.elastic.example.exception;

public class ElasticSearchConsultException extends Exception {

	private static final long serialVersionUID = 321097312993231180L;

	public ElasticSearchConsultException(final String errorMessage, final Exception e) {
        super(errorMessage, e);
    }
	
}
