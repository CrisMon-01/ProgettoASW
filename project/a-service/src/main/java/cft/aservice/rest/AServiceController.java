package cft.aservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cft.aservice.domain.AService;

@RestController
public class AServiceController {
	
	@Autowired 
	private AService serviceA;

	@GetMapping(value="/")
	public String getAnimalServiceC() {
		return this.serviceA.getAnimals(); 
	}
	
	@PostMapping(value="/")
	public void sendMessageToKafkaTopic(){
		serviceA.publish();
	}
	
	

}
