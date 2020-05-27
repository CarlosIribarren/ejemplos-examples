package oiasso.systems.elastic.example.factory;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchRequestFactory {

	private static final String INDEX = "billing-*"; 

	private final String node;
	
	@Autowired
	public ElasticSearchRequestFactory(@Value("${elasticsearch.node.url}") final String node) {
		System.out.println("node:" + node);
		this.node = node;
	}

	public boolean isNodePropertyDisabled() {
		return "DISABLED".equalsIgnoreCase(node);
	}
	
	public String createSearchURL() {
		final StringBuilder builder = new StringBuilder(node);
		builder.append("/").append(INDEX).append("/_search");
		return builder.toString();
	}
	
	public HttpEntity<String> createRequestEntity(final String query) {
		final JSONObject jSONObject = new JSONObject(query);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(jSONObject.toString(), headers);
	}

	public boolean isBadAnswer(final ResponseEntity<String> response) {
		return response.getStatusCode() != HttpStatus.OK;
	}
	
}
