package com.bootcamp.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages ={"com.bootcamp.library.*","com.bootcamp.customer.*"} )
@EnableJpaRepositories(value = "com.bootcamp.library.repository")
@EntityScan(value = "com.bootcamp.library.model")
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
