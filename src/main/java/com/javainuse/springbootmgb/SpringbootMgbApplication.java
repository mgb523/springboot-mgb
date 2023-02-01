package com.javainuse.springbootmgb;

import com.javainuse.controllers.LinkShortenerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = LinkShortenerController.class)
public class SpringbootMgbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMgbApplication.class, args);
	}

}
