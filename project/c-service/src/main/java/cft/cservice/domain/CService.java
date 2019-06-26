package cft.cservice.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CService {


	@Value("${names}")
	private String names;

	private String instanceName;

	private List<String> animals = new ArrayList<String>();

	
	public void saveAnimal(String name) {
		this.animals.add(name);
	}

	public String getAnimals() {
		String commaDivision = String.join(",", this.animals);
		String out = "\n" + this.getInstanceName() + ":[" + commaDivision + "]" + "\n";
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

