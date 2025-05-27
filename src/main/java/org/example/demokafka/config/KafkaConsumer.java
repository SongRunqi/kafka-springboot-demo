package org.example.demokafka.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaConsumer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void someMethod() {
		this.kafkaTemplate.send("someTopic","mykey", "Hello");
	}
	int count = 0;

	@KafkaListener(topics = "someTopic")
	public void processMessage(String content) {
		System.out.println("content = " + content);
		if (count++ < 1000) {
			someMethod();
		}

	}

}