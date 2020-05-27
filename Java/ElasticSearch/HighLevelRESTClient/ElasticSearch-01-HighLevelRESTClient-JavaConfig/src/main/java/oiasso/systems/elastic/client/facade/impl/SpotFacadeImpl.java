package oiasso.systems.elastic.client.facade.impl;

import java.io.IOException;

import org.apache.log4j.chainsaw.Main;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.support.ValuesSourceAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.systems.elastic.client.facade.SpotFacade;

@Service
public class SpotFacadeImpl implements SpotFacade {
	private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

	@Autowired
	private RestHighLevelClient client;

	public void buscarDispositivosDeUnAnuncio(String nombreAnuncio) throws IOException {
		LOGGER.info("**************************************************************");
		LOGGER.info("************ buscar Dispositivos Del Anuncio : " + nombreAnuncio);
		LOGGER.info("**************************************************************");

		SearchRequest searchRequest = new SearchRequest(new String[] { "test" });
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
				.filter((QueryBuilder) QueryBuilders.matchQuery("spot", nombreAnuncio));

		ValuesSourceAggregationBuilder valuesSourceAggregationBuilder = AggregationBuilders
				.terms("dispositivoDeAnuncio").field("device.keyword");

		searchSourceBuilder.query((QueryBuilder) boolQueryBuilder);
		searchSourceBuilder.aggregation((AggregationBuilder) valuesSourceAggregationBuilder);
		searchSourceBuilder.size(0);

		searchRequest.source(searchSourceBuilder);

		SearchResponse searchResponse = this.client.search(searchRequest, RequestOptions.DEFAULT);

		Aggregations aggregationResult = searchResponse.getAggregations();
		ParsedStringTerms a = (ParsedStringTerms) aggregationResult.get("dispositivoDeAnuncio");
		for (Terms.Bucket b : a.getBuckets()) {
			LOGGER.info("Nombre : " + b.getKey().toString());
			LOGGER.info("Valor : " + b.getDocCount());
		}
	}

	public void buscarPorDispositivo(String nombreDispositivo) throws IOException {
		LOGGER.info("**************************************************************");
		LOGGER.info("************ buscar Por el Dispositivo : " + nombreDispositivo);
		LOGGER.info("**************************************************************");

		SearchRequest searchRequest = new SearchRequest(new String[] { "test" });
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query((QueryBuilder) QueryBuilders.matchQuery("device", nombreDispositivo));
		searchRequest.source(searchSourceBuilder);

		SearchResponse searchResponse = this.client.search(searchRequest, RequestOptions.DEFAULT);

		for (SearchHit hit : searchResponse.getHits().getHits()) {
			LOGGER.info("Documento con id {}: {}", hit.getId(), hit.getSourceAsString());
		}
	}

	public void obtenerTodoLosDocumentos() throws IOException {
		LOGGER.info("**************************************************************");
		LOGGER.info("************ obtener Todo Los Documentos ");
		LOGGER.info("**************************************************************");

		SearchRequest searchRequest = new SearchRequest(new String[] { "test" });
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query((QueryBuilder) QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);

		SearchResponse searchResponse = this.client.search(searchRequest, RequestOptions.DEFAULT);

		for (SearchHit hit : searchResponse.getHits().getHits()) {
			LOGGER.info("Documento con id {}: {}", hit.getId(), hit.getSourceAsString());
		}
	}

	public void obtenerTodosLosAnuncios() throws IOException {
		LOGGER.info("**************************************************************");
		LOGGER.info("************ obtener Todo Los Documentos ");
		LOGGER.info("**************************************************************");

		SearchRequest searchRequest = new SearchRequest(new String[] { "test" });
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
				.filter((QueryBuilder) QueryBuilders.matchAllQuery());
		ValuesSourceAggregationBuilder valuesSourceAggregationBuilder = AggregationBuilders.terms("anuncios")
				.field("spot.keyword");

		searchSourceBuilder.aggregation((AggregationBuilder) valuesSourceAggregationBuilder);
		searchSourceBuilder.query((QueryBuilder) boolQueryBuilder);
		searchSourceBuilder.size(0);

		searchRequest.source(searchSourceBuilder);

		SearchResponse searchResponse = this.client.search(searchRequest, RequestOptions.DEFAULT);

		for (SearchHit hit : searchResponse.getHits().getHits())
			LOGGER.info("Documento con id {}: {}", hit.getId(), hit.getSourceAsString());
	}
}
