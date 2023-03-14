package com.shortenlinkapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.shortenlinkapp.entity")
@EnableJpaRepositories("com.shortenlinkapp.repository")
public class ShortenLinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortenLinkApplication.class, args);
	}
}
