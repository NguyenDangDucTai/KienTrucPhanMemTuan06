package com.example.tuan06;

import com.example.tuan06.model.Person;
import com.example.tuan06.model.Product;
import com.example.tuan06.repositories.PersonRepository;
import com.example.tuan06.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tuan06Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tuan06Application.class, args);
	}

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private PersonRepository personRepository;

	@Override
	@Transactional
	public void run(String... args) {
		Faker faker = new Faker();
		for (int i = 0; i < 5; i++) {
			Product product = new Product(
					faker.device().modelName(),
					Float.parseFloat(faker.commerce().price())
			);
			productRepository.save(product);
		}
		for (int i = 0; i < 5; i++) {
			Person person = new Person(
					faker.name().fullName(),
					faker.number().numberBetween(18, 60)
			);
			personRepository.save(person);
		}
	}
}
