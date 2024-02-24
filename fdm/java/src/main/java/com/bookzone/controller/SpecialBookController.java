/**
 * The SpecialBookController class handles incoming requests, processes these requests, 
 * and provides the appropriate responses for deleting a Book from a list of Special Books.
 * 
 * @author Sheikh Umar
 */

package com.bookzone.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookzone.service.SpecialBookService;

@Controller
public class SpecialBookController {

	/**
	 * Logger used for logging messages of the SpecialBookController class
	 */
	private static final Logger specialBookControllerLogger = LogManager.getLogger(SpecialBookController.class);
	
	/**
	 * SpecialBookService to manage the SpecialBook entity
	 */
	@Autowired
	private SpecialBookService specialBookService;
	
	/**
	 * Deletes a SpecialBook by its id
	 * 
	 * @param id of the SpecialBook to be deleted
	 * @return redirection to Specials webpage
	 * that displays all remaining SpecialBooks
	 */
	@RequestMapping("/deleteSpecialBook/{id}")
	public String deleteSpecialBook(@PathVariable("id") long id) {
		this.specialBookService.deleteSpecialBookById(id);
		specialBookControllerLogger.info("SpecialBookControllerLogger: Deleting a SpecialBook from the SpecialBook list.");
		return "redirect:/specials";
	}
	
}
