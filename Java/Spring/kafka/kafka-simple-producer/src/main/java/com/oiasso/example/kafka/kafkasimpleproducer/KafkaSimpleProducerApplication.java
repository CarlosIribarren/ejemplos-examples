package com.oiasso.example.kafka.kafkasimpleproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaSimpleProducerApplication {

	@Autowired
	private static KafkaTemplate<String, String> kafkaTemplate;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(KafkaSimpleProducerApplication.class, args);

		KafkaTemplate<String, String> kafkaTemplate = context.getBean(KafkaTemplate.class);

		kafkaTemplate.send("a", "message111");
	}

}
