package oiasso.systems.elastic.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
	private static final Logger log = LoggerFactory.getLogger(ElasticSearchConfig.class);

	@Value("${elasticsearch.server.host}")
	private String host;

	@Value("${elasticsearch.server.port}")
	private Integer port;

	@Value("${elasticsearch.server.method}")
	private String method;

	@Bean(destroyMethod = "close")
	public RestHighLevelClient restClient() {
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost[] { new HttpHost(this.host, this.port.intValue(), this.method) }));

		log.info("Elastic conectado");

		return client;
	}
}
