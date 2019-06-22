package cft.bservice.cservice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface AnimalClient {
		
	@RequestMapping(value="/", method=RequestMethod.POST)
	public void saveAnimals(@RequestBody String name); 

}
