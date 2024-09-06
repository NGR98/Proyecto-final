package com.eoi.es.proyectofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProyectofinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectofinalApplication.class, args);
	}

}
