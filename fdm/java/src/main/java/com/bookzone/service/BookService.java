/**
 * BookService is a Service class to manage the Book entity
 */

package com.bookzone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookzone.model.Book;
import com.bookzone.repository.BookRepository;

@Service
public class BookService {

	/**
	 * BookRepository to manage the Book entity
	 */
	@Autowired
	private BookRepository bookRepository;
	
	/**
	 * Saves a Book to the catalogue
	 * 
	 * @param Book to save to the catalogue
	 */
	public void saveBook(Book book) {
		this.bookRepository.save(book);
	}
	
	/**
	 * Retrieves all Books in the catalogue
	 * 
	 * @return list of all Books in the catalogue
	 */
	public List<Book> getAllBooks() {
		return this.bookRepository.findAll();
	}
	
	/**
	 * Retrieves a Book from a catalogue by its id
	 * 
	 * @param id
	 * @return a Book with the given id, otherwise null
	 */
	public Book getBookById(long id) {
		return this.bookRepository.findById(id).get();
	}
	
	/**
	 * Deletes a book by its id
	 * 
	 * @param id of the book to delete
	 * from the catalogue
	 */
	public void deleteById(long id) {
		this.bookRepository.deleteById(id);
	}
	
}
