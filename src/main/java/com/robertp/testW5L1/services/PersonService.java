package com.robertp.testW5L1.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.robertp.testW5L1.models.LoginUser;
import com.robertp.testW5L1.models.Person;
import com.robertp.testW5L1.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;
	
	
	//create
	
	public void createPerson(Person p) {
		personRepo.save(p);
	}

	public Person findById(Long id) {
		Optional<Person> thisUser = personRepo.findById(id);
		if(thisUser.isPresent()) {
			return thisUser.get();
		}
		else {
			return null;
		}
	}
	
	public List<Person> getAll(){
		return personRepo.findAll();
	}
	
	
	public Person register(Person newUser, BindingResult result) {
        // TO-DO: Additional validations!
		Optional<Person> existingUser = personRepo.findByEmail(newUser.getEmail());
		if(existingUser.isPresent()) {
			result.rejectValue("email", "Matches","An account with that email already exists");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm","Matches","The confirm password must match password");
		}
		
		if(result.hasErrors()) {
			return null;
		}
        
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return personRepo.save(newUser);
    }
    public Person login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional<Person> exists = personRepo.findByEmail(newLoginObject.getEmail());
    	if(!exists.isPresent()) {
    		result.rejectValue("email", "Matches","User not Found");
    		return null;
    	}
    	
    	Person person = exists.get();
    	
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), person.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
        	return null;
        }

    	return person;
    }
	
	
}
