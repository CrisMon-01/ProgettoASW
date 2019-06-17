package cft.servizioA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient						//RIMUOVI PER TEST SENZA EUREKA
public class ServizioAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServizioAApplication.class, args);
	}

}
