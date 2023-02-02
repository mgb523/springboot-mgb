package com.getshortyapp;

import com.getshortyapp.controller.LinkShortenerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ComponentScan(basePackageClasses = LinkShortenerController.class)
@ComponentScan({"com.getshortyapp"})
@EntityScan("com.getshortyapp.entity")
@EnableJpaRepositories("com.getshortyapp.repository")
public class GetShortyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetShortyApplication.class, args);
	}

}
