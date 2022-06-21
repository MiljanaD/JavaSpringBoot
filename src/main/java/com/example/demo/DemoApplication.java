package com.example.demo;

import com.example.demo.model.Hello;
import com.example.demo.repository.HelloRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private HelloRepository helloRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
