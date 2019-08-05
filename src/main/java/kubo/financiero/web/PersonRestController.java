package kubo.financiero.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kubo.financiero.entities.Person;
import kubo.financiero.entities.Search;
import kubo.financiero.services.PersonService;

@RestController
public class PersonRestController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/list")
	public List<Person> list(){
		return personService.list();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Person person) {
		personService.add(person);
	}

	@PostMapping("/fuzzy-search")
	public Person search(@RequestBody Search search) {
		return personService.search(search);
	}	
}
