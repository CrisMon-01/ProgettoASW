package cft.servizioB.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cft.servizioB.domain.ServizioB;

@RestController
public class ServizioBController {

	@Autowired 
	private ServizioB serviceB;

	private final Logger logger = Logger.getLogger(ServizioBController.class.toString()); 

	
//	@RequestMapping("/")									//TEST, POI VA RIMOSSO
//	public String test() {
//		String word = serviceB.test(); 
//		logger.info("getSentence(): " + word);
//		return word; 
//	}

}
