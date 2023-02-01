package com.javainuse.springbootmgb;

import com.javainuse.controllers.LinkShortenerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = LinkShortenerController.class)
public class GetShortyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetShortyApplication.class, args);
	}

}
