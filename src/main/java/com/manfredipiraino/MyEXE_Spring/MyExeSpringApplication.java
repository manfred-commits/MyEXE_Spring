package com.manfredipiraino.MyEXE_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MyExeSpringApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MyExeSpringApplication.class, args);
		
		System.out.println("Questo comando è stato eseguito dopo il run");
	}

}
