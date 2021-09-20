package es.ibil.platform.config.swagger;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *   Periodically poll the service instaces and update the in memory store as key value pair	
 */
@Component
public class ServiceDescriptionUpdater {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceDescriptionUpdater.class);
	
	private static final String DEFAULT_SWAGGER_URL="/v2/api-docs";
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@Value("${spring.application.name}")
	private String myServiceName;
	
	private Integer zuulPort;
	
	private final RestTemplate template;
	
	public ServiceDescriptionUpdater(){
		this.template = new RestTemplate();
	}
	
	@Autowired
	private ServiceDefinitionsContext definitionContext;
	
	@Scheduled(fixedDelayString= "${swagger.config.refreshrate}")
	public void refreshSwaggerConfigurations(){
		logger.debug("Starting Service Definition Context refresh");
		
		discoveryClient.getServices().stream().forEach(serviceId -> {
			
			// Exclude documentation service
			if(serviceId.equals(myServiceName)){
				return;
			}
			
			logger.debug("Attempting service definition refresh for Service : {} ", serviceId);
			final List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);
			if(serviceInstances == null || serviceInstances.isEmpty()){ //Should not be the case kept for failsafe
				logger.info("No instances available for service : {} ",serviceId);
			}else{
				final ServiceInstance instance = serviceInstances.get(0);
				final String swaggerURL =  getSwaggerURL( instance);
				
				final Integer microServicePort = instance.getPort();
				
				// Save zuul port
				if(serviceId.contains("zuul")) {
					zuulPort = microServicePort;
					return;
				}
				
				final Optional<Object> jsonData = getSwaggerDefinitionForAPI(serviceId, swaggerURL);
				
				if(jsonData.isPresent()){
					String content = getJSON(serviceId, jsonData.get());
					
					// Replace zuulPort in microServicePort
					if(microServicePort != null && zuulPort != null) {
						content = content.replace(microServicePort.toString(), zuulPort.toString());
					}
					
					definitionContext.addServiceDefinition(serviceId, content);
				}else{
					logger.error("Skipping service id : {} Error : Could not get Swagegr definition from API ",serviceId);
				}
				
				logger.info("Service Definition Context Refreshed at :  {}",LocalDate.now());
			}
			
		});
	}

	private String getSwaggerURL( final ServiceInstance instance){
		return instance.getUri()+DEFAULT_SWAGGER_URL;
	}
	
	private Optional<Object> getSwaggerDefinitionForAPI(final String serviceName, final String url){
		logger.debug("Accessing the SwaggerDefinition JSON for Service : {} : URL : {} ", serviceName, url);
		try{
			final Object jsonData = template.getForObject(url, Object.class);
			return Optional.of(jsonData);
		}catch(final RestClientException ex){
			logger.error("Error while getting service definition for service : {} Error : {} ", serviceName, ex.getMessage());
			return Optional.empty();
		}
	}

	public String getJSON(final String serviceId, final Object jsonData){
		try {
			return new ObjectMapper().writeValueAsString(jsonData);
		} catch (final JsonProcessingException e) {
			logger.error("Error : {} ", e.getMessage());
			return "";
		}
	}
	
}
