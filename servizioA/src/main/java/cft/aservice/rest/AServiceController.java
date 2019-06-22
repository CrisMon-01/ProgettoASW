package cft.aservice.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cft.aservice.domain.AService;

@RestController
public class AServiceController {
	
	@Autowired 
	private AService serviceA;

	//private final Logger logger = Logger.getLogger(ServizioAController.class.toString()); 

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAnimalServiceC() {
		return this.serviceA.getAnimals(); 
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public void sendMessageToKafkaTopic(){
		serviceA.publish();
	}
	
	

}
