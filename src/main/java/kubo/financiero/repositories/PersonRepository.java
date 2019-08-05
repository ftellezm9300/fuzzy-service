package kubo.financiero.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kubo.financiero.entities.Person;

@Repository
public class PersonRepository {

	final static String fileName = "fuzzy-search.txt";

	public List<Person> findAll() {
		ArrayList<Person> persons = new ArrayList<>();
		if(new File(fileName).exists())			
			try {
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
		        String name;
		        while((name=br.readLine())!=null)
		            persons.add(new Person(name));
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return persons;
	}	
	
	public void save(Person person) {
		 try{    
	           FileWriter fw=new FileWriter(fileName,true);    
	           fw.write(person.getName()+"\n");    
	           fw.close();    
	          }catch(Exception e){
	        	  e.printStackTrace();
	          }    		

	}


}
