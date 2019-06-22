package cft.aservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AServiceProducerRunner implements CommandLineRunner {

	//private static final Logger logger = Logger.getLogger(SimpleProducerRunner.class.toString());

	@Autowired
	private AService serviceA;

	public void run(String[] args) throws InterruptedException {
		
		for (int i=0; i<10; i++) {
			String message = "Message #" + i; 
			// logger.info("Sending message: " + message); 
			serviceA.publish(); 
		}

	}
}