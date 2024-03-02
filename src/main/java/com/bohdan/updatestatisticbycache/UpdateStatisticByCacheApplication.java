package com.bohdan.updatestatisticbycache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UpdateStatisticByCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpdateStatisticByCacheApplication.class, args);
	}

}
