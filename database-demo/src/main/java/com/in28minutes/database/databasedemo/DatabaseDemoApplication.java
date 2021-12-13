package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import java.util.Collection;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final Collection<Person> personById = personJpaRepository.findAll();
		logger.info("People({}): {}", personById.size(), personById);

		final int personId = 10002;
		logger.info("Person id#{}: {}", personId, personJpaRepository.findById(personId));

		final String personName = "Joe Mama";
		final Collection<Person> personByName = personJpaRepository.findByName(personName);
		logger.info("Named '{}'({}): {}", personName, personByName.size(), personByName);

		logger.info("Delete Person id#{}: {}", personId, personJpaRepository.deleteById(personId));

		Person newPerson = new Person( "Pietra", "Russia", new Date());
		logger.info("Insert Person: {}", personJpaRepository.save(newPerson));

		newPerson.setName("Boskonovich");
		logger.info("Renamed Person with id#{}, {}", newPerson.getId(), personJpaRepository.save(newPerson));
		newPerson.setLocation("Kamuning");
		logger.info("Updated Person again to {}, {}", newPerson, personJpaRepository.save(newPerson));
	}
}
