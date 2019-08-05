package kubo.financiero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kubo.financiero.entities.Person;
import kubo.financiero.entities.Search;
import kubo.financiero.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;	

	public List<Person> list(){
		return personRepository.findAll();
	}
	
	public void add(Person person) {
		personRepository.save(person);
	}
	
	public Person search(Search s){
		int distance = 100;
		Person person = null;
		for(Person p : list()){
			for(String name:p.getName().split(" ")){
				int d = distance(name.toCharArray(), s.getSearch().toCharArray());
				if(d<distance){
					distance = d;
					person = p;
				}	
			}
		}
		return person;
	}
	
    private int distance(char [] str1, char [] str2) {
        int [][]distance = new int[str1.length+1][str2.length+1];

        for(int i=0;i<=str1.length;i++){
                distance[i][0]=i;
        }
        for(int j=0;j<=str2.length;j++){
                distance[0][j]=j;
        }
        for(int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){ 
                  distance[i][j]= minimum(distance[i-1][j]+1,
                                        distance[i][j-1]+1,
                                        distance[i-1][j-1]+
                                        ((str1[i-1]==str2[j-1])?0:1));
            }
        }
        return distance[str1.length][str2.length];      
    }
    
    private int minimum(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
   }
	
	
	
}
