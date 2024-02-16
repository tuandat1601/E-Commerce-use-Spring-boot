package com.bootcamp.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages ={"com.bootcamp.library.*","com.bootcamp.admin.*"} )
@EntityScan(value = "com.bootcamp.library.model")
public class AdminApplication {

	 
	public static void main(String[] args) {
		
		
		SpringApplication.run(AdminApplication.class, args);
		
	}

}
