package cft.ServizioB.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cft.ServizioB.domain.ServizioB;

@RestController
public class ServizioBController {

	@Autowired 
	private ServizioB serviceB;

	private final Logger logger = Logger.getLogger(ServizioBController.class.toString()); 

//	@GetMapping(value="/")
//	public String getXXX() {
//		String word = serviceA.getSentence(); 
//		logger.info("getSentence(): " + word);
//		return word; 
//	}
	
//	@PostMapping(value="/")
//	public void sendMessageToKafkaTopic(){					//MIGLIORA NOMENCLATURA METODI
//		serviceB.publish();
//	}
	
	
	@RequestMapping("/")									//TEST, POI VA RIMOSSO
	public String test() {
		String word = serviceB.test(); 
		logger.info("getSentence(): " + word);
		return word; 
	}

}
