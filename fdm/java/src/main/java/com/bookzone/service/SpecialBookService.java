/**
 * SpecialBookService is a Service class to manage the SpecialBook entity
 */

package com.bookzone.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookzone.model.SpecialBook;
import com.bookzone.repository.SpecialBookRepository;

@Service
public class SpecialBookService {

	/**
	 * SpecialBookRepository to manage the SpecialBook entity
	 */
	@Autowired
	private SpecialBookRepository specialBookRepository;
	
	/**
	 * Logger for SpecialBookService
	 */
	private static final Logger specialBookServiceLogger = LogManager.getLogger(SpecialBookService.class);
	
	/**
	 * Saves a Book to the Special books catalogue
	 * 
	 * @param book
	 */
	public void saveSpecialBook(SpecialBook book) {
		this.specialBookRepository.save(book);
		specialBookServiceLogger.info("SpecialBookServiceLogger: Book titled " + book.getTitle() + " has been saved as a SpecialBook");
	}
	
	/**
	 * Gets all books in the SpecialBook catalogue
	 * 
	 * @return list of all SpecialBooks
	 */
	public List<SpecialBook> getAllSpecialBooks() {
		specialBookServiceLogger.info("SpecialBookServiceLogger: List of all SpecialBooks have been retrieved.");
		return this.specialBookRepository.findAll();
	}
	
	/**
	 * Deletes a SpecialBook from the SpecialBook catalogue by id
	 * 
	 * @param id of SpecialBook to delete
	 */
	public void deleteSpecialBookById(long id) {
		this.specialBookRepository.deleteById(id);
		specialBookServiceLogger.info("SpecialBookServiceLogger: SpecialBook with id" + id + " has been deleted.");
	}
	
}
