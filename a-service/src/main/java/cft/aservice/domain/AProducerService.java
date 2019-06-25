package cft.aservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AProducerService {
	
	@Autowired
	private AMessagePublisher aServicePublisher;
	
	public void publish (String message) {
		aServicePublisher.publish(message);
	}
}
