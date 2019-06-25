package cft.aservice.cservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cft.aservice.domain.CService;

@Service
public class CServiceImpl implements CService {
	
	@Autowired 
	private CClient cClient;
	
	@Override
	public String getAnimals() {
		return this.cClient.getAnimals(); 
	}
	
}