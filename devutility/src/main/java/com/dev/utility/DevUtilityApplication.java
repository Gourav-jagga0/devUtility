package com.dev.utility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dev")
public class DevUtilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevUtilityApplication.class, args);
	}

}
