package cft.cservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cft.cservice.domain.CService;

@RestController
public class CServiceController {
	
	@Autowired 
	private CService serviceC;
	

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAnimals() {
		return this.serviceC.getAnimals();
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public void saveAnimal(@RequestBody String name) {
		this.serviceC.saveAnimal(name);
	}

}

