package oiasso.systems.elastic.client;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig.Builder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder.RequestConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchConfig.class);

	// ************************
	// ****** Attributes ******
	// ************************

	@Value("${elasticsearch.server.host}")
	private String host;

	@Value("${elasticsearch.server.port}")
	private Integer port;

	@Value("${elasticsearch.server.method}")
	private String method;

	// ************************
	// ******** Beans *********
	// ************************

	@Bean(destroyMethod = "close")
	public RestHighLevelClient restClient() {

		final RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost[] { new HttpHost(this.host, this.port.intValue(), this.method) })
						.setRequestConfigCallback(this.requestConfigCallback()));

		return client;
	}

	// ************************
	// **** Private methods ***
	// ************************

	private RequestConfigCallback requestConfigCallback() {
		return new RequestConfigCallback() {

			@Override
			public Builder customizeRequestConfig(final Builder requestConfigBuilder) {
				return requestConfigBuilder.setConnectTimeout(30000).setSocketTimeout(120000);
			}
		};
	}

}
