package com.example.demo;

import com.example.demo.Customer.Customer;
import com.example.demo.Customer.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return args -> {
			this.customerRepository.save(new Customer("Jack", "Bauer"));
			this.customerRepository.save(new Customer("Chloe", "O'Brian"));
			this.customerRepository.save(new Customer("David", "Palmer"));
			this.customerRepository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : this.customerRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
		};
	}



}
