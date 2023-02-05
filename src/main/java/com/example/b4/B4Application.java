package com.example.b4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class B4Application {

	public static void main(String[] args) {
		SpringApplication.run(B4Application.class, args);
	}

}
