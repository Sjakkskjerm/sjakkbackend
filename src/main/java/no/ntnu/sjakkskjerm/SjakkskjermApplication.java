package no.ntnu.sjakkskjerm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SjakkskjermApplication {

	public static void main(String[] args) {
		SpringApplication.run(SjakkskjermApplication.class, args);
	}

}
