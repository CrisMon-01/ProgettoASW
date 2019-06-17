package cft.servizioB.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServizioB {
	
	//private static final Logger logger = Logger.getLogger(ServizioA.class.toString());
	
	@Value("${eureka.instance.metadataMap.instanceId}")
	private String instanceName;
	
	private String messageFromA;
	
	public void setMessageFromA(String message) {
		this.messageFromA = message;
	}

	public void onMessage(String message) {
		//logger.info("RECEIVED MESSAGE: " + message);
		this.setMessageFromA(message);
	}
	
	public String test() {					//TEST, POI VA MODIFICATO PER INTERAGIRE CON C
		String message = this.instanceName
				+ " : " + this.messageFromA; 
		//logger.info("PUBLISHING MESSAGE: " + message);
		return message;
	}
		
}
