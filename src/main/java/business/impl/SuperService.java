package business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dashboard.kafka.producers.*;

public abstract class SuperService {
	
	@Autowired
	protected KafkaProducer kafkaProducer;
}
