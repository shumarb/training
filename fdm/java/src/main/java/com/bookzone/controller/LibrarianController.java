/**
 * The LibrarianController class handles incoming requests, processes these requests, 
 * and provides the appropriate webpages for the Librarian.
 * 
 * @author Sheikh Umar
 */

package com.bookzone.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookzone.model.Librarian;
import com.bookzone.service.LibrarianService;

@Controller
public class LibrarianController {

	/**
	 * Logger used for logging messages of the LibrarianController
	 */
	private static final Logger librarianControllerLogger = LogManager.getLogger(LibrarianController.class);
	
	/**
	 * LibrarianService to manage the Librarians
	 */
	@Autowired
	private LibrarianService librarianService;
	
	/**
	 * Goes to the Index page
	 * 
	 * @return name of the Index page
	 */
	@GetMapping("/")
	public String goToIndex() {
		
		librarianControllerLogger.info("LibrarianControllerLogger: Currently at Index page");
		return "index";
		
	}
	
	/**
	 * Goes to the Home page
	 * 
	 * @return name of the Home page
	 */
	@GetMapping("/home")
	public String goToHome() {
		
		librarianControllerLogger.info("LibrarianControllerLogger: Currently at Home page");
		return "home";
		
	}
	
	/**
	 * Goes to the Login page
	 * 
	 * @return name of the Login page
	 */
	@GetMapping("/login")
	public String goToLogin() {
		
		librarianControllerLogger.info("LibrarianControllerLogger: Currently at Login page");
		return "login";
		
	}
	
	/**
	 * Manages a Librarian's login process
	 * 
	 * @param email: email address of the Librarian
	 * @param password: password of the Librarian
	 * @param model: The model where attributes can be added for the view
	 * @return: Redirection to the Home page for a successful login, or back to the login page 
	 * with an error message displayed for unsuccessful login
	 */
	@PostMapping("/login")
	public String loginLibrarian(@RequestParam String email, @RequestParam String password, Model model) {
		
	    boolean doesLibrarianExist = this.librarianService.loginLibrarian(email, password);
	    if (doesLibrarianExist) {
	        librarianControllerLogger.info("LibrarianControllerLogger: Librarian successfully logged in, proceeding to Home page");
	        return "redirect:/home";
	    } else {
	        librarianControllerLogger.error("LibrarianControllerLogger: Librarian unsuccessful in logging in, proceeding to Login page");
	        model.addAttribute("error", "Invalid email or password. Please try again.");
	        return "login";
	    }
	    
	}
	
	/**
	 * Goes to the Registration page
	 * 
	 * @return name of the Registration page
	 */
	
	@GetMapping("/register")
	public String goToRegistration() {
		
		librarianControllerLogger.info("LibrarianControllerLogger: Currently at Registration page");
		return "register";
	
	}
	
	/**
	 * Manages the Librarian's registration
	 * 
	 * @param email: email address of the Librarian
	 * @param password: password of the Librarian
	 * @param model: The model where attributes can be added for the view
	 * @return: Redirection to the Login page for a successful registration, or back to the Registraion page 
	 * with an error message displaying the reason(s) for unsuccessful registration
	 */
	@PostMapping("/register")
	public String registerLibrarian(@RequestParam String name, @RequestParam String email, @RequestParam String password, Model model) {
		
		if (this.librarianService.isValidName(name) && this.librarianService.isValidEmailAddress(email) && this.librarianService.isValidPassword(password)) {
			
	    	this.librarianService.registerLibrarian(new Librarian(name, email, password));
	        librarianControllerLogger.info("LibrarianControllerLogger: Librarian successfully registered, proceeding to Login page");
	        return "redirect:/login";
	    
		} else {
	    	
	    	if (!this.librarianService.isValidName(name)) {
	    		
	    		librarianControllerLogger.error("LibrarianControllerLogger: Unsuccessful registration due to invalid name, proceeding to Registration page");
		    	model.addAttribute("error", "Unsuccessful registration due to invalid name");
	    	
	    	} else if (!this.librarianService.isValidEmailAddress(email)) {
	    		
	    		librarianControllerLogger.error("LibrarianControllerLogger: Unsuccessful registration due to invalid email address, proceeding to Registration page");
		    	model.addAttribute("error", "Unsuccessful registration due to invalid email address");
	    	
	    	} else if (!this.librarianService.isValidPassword(password)) {
	    		
	    		librarianControllerLogger.error("LibrarianControllerLogger: Unsuccessful registration due to invalid password, proceeding to Registration page");
		    	model.addAttribute("error", "Unsuccessful registration due to invalid password");
	    	
	    	} 
	    	
	    	return "register";
	    }
	}

	/**
	 * Logs out the Librarian
	 * 
	 * @return redirection to the Index page
	 */
	@GetMapping("/logout")
	public String logoutLibrarian() {
		
		librarianControllerLogger.info("LibrarianControllerLogger: Librarian logged out, proceeding to Index page");
		return "redirect:/";
	
	}
	
}
