package com.cdac.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.cdac.backend.controller","com.cdac.backend.services"})
@EntityScan(basePackages= {"com.cdac.backend.entity"})
@EnableJpaRepositories(basePackages= {"com.cdac.backend.repositories"})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
