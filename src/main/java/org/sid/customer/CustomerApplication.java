package org.sid.customer;

import org.sid.customer.entities.Customer;
import org.sid.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){

		return args -> {

			customerRepository.save(new Customer(null,"Dione","dioneousseynou03@gmail.com"));
			customerRepository.save(new Customer(null,"Ousseynou","ouzin03@gmail.com"));
			customerRepository.save(new Customer(null,"Weuz","weuzinho03@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);

		};

	}

}
