package cft.servizioA.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cft.servizioA.domain.ServizioA;

@RestController
public class ServizioAController {
	
	@Autowired 
	private ServizioA serviceA;

	//private final Logger logger = Logger.getLogger(ServizioAController.class.toString()); 

//	@GetMapping(value="/")
//	public String getXXX() {
//		String word = serviceA.getSentence(); 
//		logger.info("getSentence(): " + word);
//		return word; 
//	}
	
	@PostMapping(value="/")
	public void sendMessageToKafkaTopic(){					//MIGLIORA NOMENCLATURA METODI
		serviceA.publish();
	}
	

}
