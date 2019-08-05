package kubo.financiero;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kubo.financiero.entities.Person;
import kubo.financiero.repositories.PersonRepository;

@SpringBootApplication
public class ServiceFuzzyApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceFuzzyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Juan Antonio Perez","Maria Lopez Aguilar","Juan Mora Lozano").forEach(name->{
			personRepository.save(new Person(name));
		});
		
		personRepository.findAll().forEach(person->{
			System.out.println(person.getName());
		});
		
	}

}
