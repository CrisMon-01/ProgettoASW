package cft.aservice.cservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cft.aservice.domain.CService;

@Service
public class AnimalService implements CService {
	
	@Autowired 
	private AnimalClient animalClient;
	
	public String getAnimals() {
		return this.animalClient.getAnimals(); 
	}
	
}