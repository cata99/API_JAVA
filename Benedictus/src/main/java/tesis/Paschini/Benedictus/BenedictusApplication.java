package tesis.Paschini.Benedictus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class BenedictusApplication {

	public static void main(String[] args) {

		SpringApplication.run(BenedictusApplication.class, args);
	}

}
