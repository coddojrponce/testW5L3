package com.robertp.testW5L1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.robertp.testW5L1.models.License;
import com.robertp.testW5L1.models.LoginUser;
import com.robertp.testW5L1.models.Person;
import com.robertp.testW5L1.services.LicenseService;
import com.robertp.testW5L1.services.PersonService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private LicenseService licenseService;
	
	
	@GetMapping("/persons")
	public String index(
			Model model,HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		 if(userId==null) {
			 return "redirect:/";
		 }
		model.addAttribute("persons",personService.getAll());
		
		return "index.jsp";
	}
	
	@GetMapping("/persons/new")
	public String newPerson(
			@ModelAttribute("person") Person person
			) {
		
		return "newPerson.jsp";
	}
	
	@GetMapping("/licenses/new")
	public String newLicense(
			@ModelAttribute("license") License license,
			Model model 
			) {
		model.addAttribute("persons",personService.getAll());

		return "newLicense.jsp";
	}

	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
	    
	    Person someAwesomePerson = personService.findById(person_id);
	    model.addAttribute("person", someAwesomePerson);
	    
	    return "person.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/licenses")
	public String licenses(@Valid @ModelAttribute("license") License license,BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "newLicense.jsp";
		}
		else {
		    licenseService.create(license); // Already has the person!
			return "redirect:/persons";
		}
	        
	}
	
	@PostMapping("/persons")
	public String newPRoute(@Valid @ModelAttribute("person") Person person,BindingResult result) {
		
		
		
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}
		else {
			personService.createPerson(person);
			return "redirect:/persons";
		}
	}	
	
	@GetMapping("/")
    public String logreg(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new Person());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") Person newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
    	
    	personService.register(newUser, result);
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        
        session.setAttribute("user_id",newUser.getId());
       
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        
    
        return "redirect:/persons";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    	
    	Person person = personService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new Person());
            return "login.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id",person.getId() );
  
    
        return "redirect:/persons";
    }
}
