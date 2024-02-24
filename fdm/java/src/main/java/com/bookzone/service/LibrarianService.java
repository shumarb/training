/**
 * LibrarianService.java manages the Librarian object.
 * 
 * There are 2 operations involved to manage a Librarian object:
 * 
 * 1. Registering a librarian.
 * This is when the librarian does not have a BookZone account.
 *
 * 2. Logging the librarian into BookZone.
 * This is when the librarian attempts to log into BookZone using
 * his/her email address and password stored in the librarians table
 * in the MySQL database of the book_zone schema.
 */

package com.bookzone.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookzone.model.Librarian;
import com.bookzone.repository.LibrarianRepository;

@Service
public class LibrarianService {

	/**
	 * Logger for LibrarianService
	 */
	private static final Logger librarianServiceLogger = LogManager.getLogger(LibrarianService.class);
	
	@Autowired
	private LibrarianRepository librarianRepository;
	
	/**
	 * Register a librarian by checking if the librarian's account exists in the BookZone database
	 * If not, save the name, email address, and password that the Librarian has enteered into the MySQL database
	 * 
	 * @params: Librarian object, which comprises of the name, email, and password the Librarian has entered at the Registration page
	 * @return: True if librarian's account exists, false otherwise
	 */
	public void registerLibrarian(Librarian librarian) {
		librarianServiceLogger.info("LibrarianServiceLogger: Email address provided is available");
		this.librarianRepository.save(librarian);
	}
	
	/**
	 * Checks if an email address is taken
	 * 
	 * @params Email address
	 * @return True if email address exists in database, false otherwise
	 */
	public boolean isValidEmailAddress(String email) {
		Optional<Librarian> librarianOptional = this.librarianRepository.findByEmail(email);
		
		// 1. Check if email address provided exists
		if (librarianOptional.isPresent()) {
			librarianServiceLogger.error("LibrarianServiceLogger: Email address provided is unavailable");
			return false;
		}
		
		// 2. Check if email address provided ends with @sgbookcollectors.com
		if (isEndWithCompanyEmailAddress(email)) {
			
			librarianServiceLogger.info("LibrarianServiceLogger: Email address provided is valid");
			return true;
			
		} else {
			
			librarianServiceLogger.error("LibrarianServiceLogger: Email address provided is invalid");
			
		}
		return false;
	}
	
	/**
	 * Checks if password has at least 8 characters
	 * 
	 * @params: Password
	 * @return: True if password has at least 8 characters, false otherwise
	 */
	public boolean hasAtLeastEightCharacters(String password) {
		return password.length() > 8;
	}
	
	/**
	 * Checks if email address entered is valid
	 * 
	 * @params: Email address
	 * @return: True if email address ends with @sgbookcollectors.com, false otherwise
	 */
	public boolean isEndWithCompanyEmailAddress(String email) {
	
		if (email.endsWith("@sgbookcollectors.com")) {
			
			librarianServiceLogger.info("LibrarianServiceLogger: Email address provided ends with @sgbookcollectors.com");
			return true;
		}
		
		librarianServiceLogger.error("LibrarianServiceLogger: Email address provided does not end with @sgbookcollectors.com");
		return false;
	}
	
	/**
	 * Checks if name if valid
	 * 
	 * @params: Name
	 * @return: True if name has at least 2 words, and each word has at least 3 characters
	 */
	public boolean isValidName(String name) {
		String[] nameValues = name.split(" ");
		// 1. Invalid if name has less than 2 words
		if (nameValues.length < 2) {
			librarianServiceLogger.error("LibrarianServiceLogger: Name has less than 2 words");
			return false;
		}
		
		// 2. Invalid if each word has less than 3 characters
		for (int i = 0; i < nameValues.length; i++) {
			if (nameValues[i].length() < 3) {
				librarianServiceLogger.info("LibrarianServiceLogger: At least 1 word in the name has less than 3 characters");
				return false;
			}
		}
		
		// 3. Name has at least 2 words, and each word has at least 3 characters
		// Check if every character in the word is a letter
		// Invalid if there exists at least 1 character that is not a letter
		for (int i = 0; i < nameValues.length; i++) {
			String word = nameValues[i];
			if (word != null && !word.matches("[a-zA-Z]+")) {
				librarianServiceLogger.error("LibrarianServiceLogger: There is at least 1 character detected in the name");
				return false;
			}
		}
		
		librarianServiceLogger.info("LibrarianServiceLogger: Valid name");
		return true;
	}
	
	/**
	 * Checks if password has at least 3 uppercase letters,
	 * at least 3 lowercase letters, and at least 2 numbers
	 * 
	 * @params: Password
	 * @return: True if password has at least 3 uppercase letters,
	 * at least 3 lowercase letters, and at least 2 numbers
	 */
	public boolean hasSufficientUpperCaseAndLowerCaseAndNumbers(String password) {
		int numberOfUpperCaseLetters = 0;
	    int numberOfLowerCaseLetters = 0;
	    int numberOfNumbers = 0;
	    
	    for (int i = 0; i < password.length(); i++) {
	    	char currentChar = password.charAt(i);
	    	if (Character.isUpperCase(currentChar)) {
	    		numberOfUpperCaseLetters++;
	    	}
	    	if (Character.isLowerCase(currentChar)) {
	    		numberOfLowerCaseLetters++;
	    	}
	    	if (Character.isDigit(currentChar)) {
	    		numberOfNumbers++;
	    	}
	    }
	    
	    if (numberOfUpperCaseLetters > 3 && numberOfLowerCaseLetters > 3 && numberOfNumbers > 2) {
	    	librarianServiceLogger.info("LibrarianServiceLogger: Valid password: Password has at least 8 characters and contains at least 3 are uppercase letters, at least 3 lowercase letters, and at least 2 numbers");
	    } else {
	    	librarianServiceLogger.info("LibrarianServiceLogger: Invalid password: Password has at least 8 characters and at least one of these situations: less than 3 uppercase letters, less than 3 lowercase letters, and less than 2 numbers");     	
	    }
	    return numberOfUpperCaseLetters > 3 && numberOfLowerCaseLetters > 3 && numberOfNumbers > 2;
	}
	
	/**
	 * Checks if password provided is valid
	 * 
	 * @params: Password
	 * @return: True if valid password, false otherwise
	 */
	public boolean isValidPassword(String password) {
	    return hasAtLeastEightCharacters(password) && hasSufficientUpperCaseAndLowerCaseAndNumbers(password);
	}
	
	/**
	 * Log the librarian into BookZone by checking if the librarian's email address exists
	 * 
	 * If it does exist, check if the password provided is correct.
	 * If both these checks passed, the librarian has entered the correct login details and hence
	 * logs into BookZone. Otherwise, access into BookZone is denied.
	 * 
	 * @params: Email address and password of the librarian
	 * @result: True if librarian enters valid email address and password, false otherwise
	 */
	public boolean loginLibrarian(String email, String password) {
		Optional<Librarian> librarianOptional = this.librarianRepository.findByEmail(email);
		if (librarianOptional.isPresent()) {
			Librarian librarian = librarianOptional.get();
			if (librarian.getPassword().equals(password)) {
				librarianServiceLogger.error("LibrarianServiceLogger: Email address provided exists and password provided is correct");
				return true;
			} else {
				librarianServiceLogger.error("LibrarianServiceLogger: Email address provided exists but password provided is incorrect");
			}
		} else {
			librarianServiceLogger.error("LibrarianServiceLogger: Email address provided does not exist");
		}
		return false;
	}
}
