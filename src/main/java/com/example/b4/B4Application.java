package com.example.b4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaAuditing
@SpringBootApplication
public class B4Application {

	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}

	public static final String APPLICATION_LOCATIONS = "spring.config.location="
			+ "classpath:application.properties,"
			//+ "classpath:aws.yml"
			+ "classpath:application-oauth.properties";

	public static void main(String[] args) {
		//SpringApplication.run(B4Application.class, args);
		new SpringApplicationBuilder(B4Application.class)
				.properties(APPLICATION_LOCATIONS)
				.run(args);
	}

}
