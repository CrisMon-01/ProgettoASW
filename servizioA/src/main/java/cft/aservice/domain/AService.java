package cft.aservice.domain;

import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AService {
	
	//private static final Logger logger = Logger.getLogger(ServizioA.class.toString());
	
//	@Autowired
	private AServicePublisher publisher;
	
	@Autowired
	private CService serviceC;
	
	@Value("${names}")
	private String names;
	
	@Value("${animals}")
	private String animals;
	
	private String instanceName;
	
	
	
	private String getInstanceName() {
		if(this.instanceName == null) {
			String[] nomi = names.split(",");
			int rnd = (int) (Math.round(Math.random()*(nomi.length-1)));
			this.instanceName = nomi[rnd];
		}
		return this.instanceName;
	} 
	
//	public void saveAnimal() {
//		String name = this.getInstanceName() + ":" + this.getAnimal();
//		this.serviceC.saveAnimal(name);
//	}
	
	private String getAnimal() {
		String[] animali = animals.split(",");
		int rnd = (int) (Math.round(Math.random()*(animali.length-1)));
		String animal = animali[rnd];	
		return animal;
	}
	
	public String getAnimals() {
		return this.serviceC.getAnimals();
	}
	
	public void publish() {
		String message = this.instanceName 
				+ " : " + this.getAnimal();
		//logger.info("PUBLISHING MESSAGE: " + message);
		publisher.publish(message);
	}
	
}
