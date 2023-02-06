package com.shortenlinkapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackageClasses = LinkShortenerController.class)
@ComponentScan({"com.shortenlinkapp"})
@EntityScan("com.shortenlinkapp.entity")
@EnableJpaRepositories("com.shortenlinkapp.repository")
public class ShortenLinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortenLinkApplication.class, args);
	}

}
