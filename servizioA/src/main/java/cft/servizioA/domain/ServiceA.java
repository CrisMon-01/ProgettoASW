package cft.servizioA.domain;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {
	
	@Autowired
	@Value("${spring.profiles}")
	private String instanceName;
	
	//@Autowired
	//@Value("${animals}")
	//private String animals;
	
	//public String getAnimale() {
	//	String[] animali = animals.split(",");
	//	int i = (int) (Math.round(Math.random()*(animali.length-1)));
	//	String animale = animali[i];	
	//	return animale;
	//}
	
	public String getName() {
		return this.instanceName;
	}
	
	public String getSentence() {
		String sentence = this.getName();
		//+": "+this.getAnimale();
		return sentence;
	}
	
}
