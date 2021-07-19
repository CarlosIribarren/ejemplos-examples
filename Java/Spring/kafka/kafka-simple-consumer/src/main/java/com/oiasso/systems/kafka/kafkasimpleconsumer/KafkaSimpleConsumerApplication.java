package com.oiasso.systems.kafka.kafkasimpleconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaSimpleConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSimpleConsumerApplication.class, args);
	}

    @KafkaListener(id = "myId", topics = "a")
    public void listen(String in) {
        System.out.println(in);
    }

}
