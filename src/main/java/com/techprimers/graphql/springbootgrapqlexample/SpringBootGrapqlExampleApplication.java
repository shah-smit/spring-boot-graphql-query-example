package com.techprimers.graphql.springbootgrapqlexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootGrapqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGrapqlExampleApplication.class, args);
	}
}
