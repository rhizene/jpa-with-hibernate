package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
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
	private PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final Collection<Person> personById = dao.findAll();
		logger.info("People({}): {}", personById.size(), personById);

		final int personId = 10002;
		logger.info("Person id#{}: {}", personId, dao.findById(personId));

		final String personName = "Joe Mama";
		final Collection<Person> personByName = dao.findByName(personName);
		logger.info("Named '{}'({}): {}", personName, personByName.size(), personByName);

		logger.info("Delete Person id#{}: {}", personId, dao.deleteById(personId));

		Person newPerson = new Person( "Pietra", "Russia", new Date());
		dao.insert(newPerson);
		newPerson = dao.findByNameAndLocation(newPerson.getName(), newPerson.getLocation());
		logger.info("Insert Person: {}", newPerson);

		logger.info("Renamed Person with id#{}, {}", newPerson.getId(), dao.updateNameById(newPerson.getId(), "Boskonovich"));
		newPerson.setLocation("Kamuning");
		logger.info("Updated Person again to {}, {}", newPerson, dao.update(newPerson));
	}
}
