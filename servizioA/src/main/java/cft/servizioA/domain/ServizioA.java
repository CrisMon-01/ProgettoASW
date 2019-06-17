package cft.servizioA.domain;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServizioA {
	
	//private static final Logger logger = Logger.getLogger(ServizioA.class.toString());
	
	//@Autowired
	private ServizioAPublisher publisher;
	
	@Value("${eureka.instance.metadataMap.instanceId}")
	private String instanceName;
	
	@Value("${animals}")
	private String animals;
	
	private String getAnimale() {
		String[] animali = animals.split(",");
		int i = (int) (Math.round(Math.random()*(animali.length-1)));
		String animale = animali[i];	
		return animale;
	}
	
	public void publish() {
		String message = this.instanceName 
				+ " : " + this.getAnimale();
		//logger.info("PUBLISHING MESSAGE: " + message);
		publisher.publish(message);
	}
	
}
