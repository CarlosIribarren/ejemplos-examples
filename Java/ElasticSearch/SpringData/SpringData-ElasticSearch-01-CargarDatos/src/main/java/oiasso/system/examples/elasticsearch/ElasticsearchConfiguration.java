package oiasso.system.examples.elasticsearch;

import java.time.Duration;
import java.util.Arrays;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import oiasso.system.examples.elasticsearch.converters.LocalDateTimeToString;
import oiasso.system.examples.elasticsearch.converters.StringToLocalDateTime;

@Configuration
@EnableElasticsearchRepositories
public class ElasticsearchConfiguration extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String elasticsearchHost;

    @Value("${elasticsearch.port}")
    private int elasticsearchPort;
	
	@Override
	public RestHighLevelClient elasticsearchClient() {
		
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticsearchHost + ":" + elasticsearchPort )
                .withConnectTimeout(Duration.ofMinutes(10))                            
                .withSocketTimeout(Duration.ofMinutes(10)) 
                .build();
		
		return RestClients.create(clientConfiguration).rest();
		
	}
	
	@Bean
	@Override
	public EntityMapper entityMapper() {

		ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper(
				elasticsearchMappingContext(), new DefaultConversionService());
		
		entityMapper.setConversions(elasticsearchCustomConversions());  

		return entityMapper;
	}

	@Bean
	@Override
	public ElasticsearchCustomConversions elasticsearchCustomConversions() {
		return new ElasticsearchCustomConversions(
				Arrays.asList(new StringToLocalDateTime(), new LocalDateTimeToString()));       
	}

}
