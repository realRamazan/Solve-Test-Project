package solva.solvaTestProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SolvaTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolvaTestProjectApplication.class, args);
	}

}
