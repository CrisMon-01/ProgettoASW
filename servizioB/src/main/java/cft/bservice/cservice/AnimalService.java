package cft.bservice.cservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cft.bservice.domain.CService;

@Service
public class AnimalService implements CService {
	
	@Autowired 
	private AnimalClient animalClient;
	
	public void saveAnimals(String name) {
		 this.animalClient.saveAnimals(name); 
	}
	
}