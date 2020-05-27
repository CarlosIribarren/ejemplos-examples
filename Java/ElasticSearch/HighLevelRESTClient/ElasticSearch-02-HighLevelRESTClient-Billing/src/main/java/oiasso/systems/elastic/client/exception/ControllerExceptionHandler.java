package oiasso.systems.elastic.client.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler(ElasticSearchConsultException.class)
	public ResponseEntity<Object> handleElasticSearchException(ElasticSearchConsultException e) {
		LOGGER.error(e.getMessage(), e);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
