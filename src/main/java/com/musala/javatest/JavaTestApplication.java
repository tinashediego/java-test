package com.musala.javatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class JavaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaTestApplication.class, args);
	}

}
