package business.impl;

import kafka.producers.*;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class SuperService {
	
	@Autowired
	protected KafkaProducer kafkaProducer;
}
