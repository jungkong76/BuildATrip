package com.example.buildatrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BuildATripApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildATripApplication.class, args);
	}

}
