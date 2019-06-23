package cft.aservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AProducerService {

	//private Logger logger = Logger.getLogger(AProducerService.class.toString());
	
	@Autowired
	private AServicePublisher aServicePublisher;
	
	public void publish (String message) {
		//logger.info("PUBBLICO IL MESSAGGIO: " + message);
		aServicePublisher.publish(message);
	}
}
