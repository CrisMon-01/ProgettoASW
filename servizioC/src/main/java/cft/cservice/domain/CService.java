package cft.cservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CService {

	//private static final Logger logger = Logger.getLogger(ServizioA.class.toString());

	//	@Value("${eureka.instance.metadataMap.instanceId}")
	//	String instanceId;

	@Value("${names}")
	private String names;

	private String instanceName;

	private List<String> animals = new ArrayList<String>();

	public void saveAnimal(String name) {
		this.animals.add(name);
	}

	public String getAnimals() {
		String commaSeparated = String.join(",", this.animals);
		String out = this.getInstanceName() + ":[" + commaSeparated + "]";
		return out; 
	}

	private String getInstanceName() {
		if(this.instanceName == null) {
			String[] nomi = names.split(",");
			int rnd = (int) (Math.round(Math.random()*(nomi.length-1)));
			this.instanceName = nomi[rnd];
		}
		return this.instanceName;
	}

}

