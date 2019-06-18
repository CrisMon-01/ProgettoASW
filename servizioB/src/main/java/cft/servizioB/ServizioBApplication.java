package cft.servizioB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient							//SERVE???????????????????????????
public class ServizioBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServizioBApplication.class, args);
	}

}
