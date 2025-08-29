package com.kvh2.spingcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*  Bean Configuration
	@SpringBootApplication(
		scanBasePackages = {"com.kvh2.springcoredemo", "com.kvh2.util"}
	)
*/
@SpringBootApplication
public class SpingcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingcoredemoApplication.class, args);
	}

}
