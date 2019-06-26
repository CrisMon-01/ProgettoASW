package cft.aservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AService {
	

	@Autowired
	private AMessagePublisher publisher;
	
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
		String message = this.getInstanceName()
				+ ":" + this.getAnimal();
		publisher.publish(message);
	}
	
}
