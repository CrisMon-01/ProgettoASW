package cft.bservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BService {

	//private static final Logger logger = Logger.getLogger(ServizioA.class.toString());

	//	@Value("${eureka.instance.metadataMap.instanceId}")
	private String instanceName;

	private String messageFromA;

	@Value("${names}")
	private String names;

	@Autowired
	private CService animalService;


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

	public void onMessage(String message) {
		//logger.info("RECEIVED MESSAGE: " + message);
		this.setMessageFromA(message);
		this.sendMessageToC();
	}

	public void sendMessageToC() {
		String message = this.instanceName
				+ " : " + this.messageFromA;
		//logger.info("PUBLISHING MESSAGE: " + message);
		this.animalService.saveAnimals(message);
	}



}
