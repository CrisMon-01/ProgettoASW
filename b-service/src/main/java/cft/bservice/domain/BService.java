package cft.bservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BService {


	@Value("${names}")
	private String names;

	@Autowired
	private CService animalService;
	
	private String instanceName;

	private String messageFromA;


	private String getInstanceName() {
		if(this.instanceName == null) {
			String[] nomi = names.split(",");
			int rnd = (int) (Math.round(Math.random()*(nomi.length-1)));
			this.instanceName = nomi[rnd];
		}
		return this.instanceName;
	}

	public void setMessageFromA(String message) {
		this.messageFromA = message;
	}


	public void sendMessageToC() {
		String message = this.getInstanceName()
				+ ":" + this.messageFromA;
		//logger.info("PUBLISHING MESSAGE: " + message);
		this.animalService.saveAnimals(message);
	}
	
	
	public void onMessage(String message) {
		this.setMessageFromA(message);
		this.sendMessageToC();
	}



}
