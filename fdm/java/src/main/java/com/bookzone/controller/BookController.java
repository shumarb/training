/**
 * The BookController class handles incoming requests, processes these requests, 
 * and provides the appropriate responses for requests on adding, editing, and deleting 
 * a book from the BookZone catalogue.
 * 
 * @author Sheikh Umar
 */

package com.bookzone.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookzone.model.Book;
import com.bookzone.model.SpecialBook;
import com.bookzone.service.BookService;
import com.bookzone.service.SpecialBookService;

@Controller
public class BookController {

	/**
	 * Logger used for logging messages of the BookController class
	 */
	private static final Logger bookControllerLogger = LogManager.getLogger(BookController.class);
	
	/**
	 * BookService for accessing and managing the Book entities
	 */
	@Autowired
	private BookService bookService;
	
	/**
	 * BookService for accessing and managing the SpecialBook entities
	 */
	@Autowired
	private SpecialBookService specialBookService;
	
	/**
	 * Goes to Add page 
	 * 
	 * @return name of Add page
	 */
	@GetMapping("/addBook")
	public String goToAdd() {
		bookControllerLogger.info("BookControllerLogger: Librarian is at the Add page");
		return "add";
	}
	
	/**
	 * Gets all books in the catalogue
	 * 
	 * @return
	 */
	@GetMapping("/catalogue")
	public ModelAndView getAllBooks() {
		List<Book> list = bookService.getAllBooks();
		bookControllerLogger.info("BookControllerLogger: Displaying all books in the catalogue");
		return new ModelAndView("catalogue", "book", list);
	}
	
	/**
	 * Adds a Book to the catalogue
	 * @param book: Book object to add to catalogue
	 * @return a redirect to the Catalogue page
	 */
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		this.bookService.saveBook(book);
		bookControllerLogger.info("BookControllerLogger: Adding a book to the catalogue");
		return "redirect:/catalogue";
	}
	
	/**
	 * Gets all Special books from the catalogue and adds it to the catalogue for display
	 * 
	 * @param model: The model in which the SpecialBook will be added
	 * @return name of the SpecialBook page
	 */
	@GetMapping("/specials")
	public String getSpecialBooks(Model model) {
		List<SpecialBook> list = specialBookService.getAllSpecialBooks();
		model.addAttribute("book", list);
		bookControllerLogger.info("BookControllerLogger: Displaying all special books in the catalogue");
		return "specials";
	}
	
	/**
	 * Adds a Book to the SpecialBook list
	 * 
	 * @param id: The id of the Book to be added to the SpecialBook list
	 * @return a redirect to the name of the SpecialBook page
	 */
	@RequestMapping("/addBookToSpecials/{id}")
	public String addBookToSpecials(@PathVariable("id") long id) {
		Book book = bookService.getBookById(id);
		SpecialBook specialBook = new SpecialBook(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getYear());
		specialBookService.saveSpecialBook(specialBook);
		bookControllerLogger.info("BookControllerLogger: A book in the catalogue has been selected as Special, and adding this book to Specials");
		return "redirect:/specials";
	}
	
	/**
	 * Retrieves a Book to edit by id
	 * 
	 * @param id: Id of the Book to edit
	 * @param model: The model that the Book will be added
	 * @return The name of the edit page
	 */
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") long id, Model model) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		bookControllerLogger.info("BookControllerLogger: Editing a book in the catalogue");
		return "edit";
	}
	
	/**
	 * Deletes a Book from the catalogue by it's id,
	 * as well as the SpecialBook list if it exists
	 * 
	 * @param id: Id of Book to be deleted
	 * @return: Redirection to the Catalogue page
	 */
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") long id) {
		this.specialBookService.deleteSpecialBookById(id);
		this.bookService.deleteById(id);
		bookControllerLogger.info("BookControllerLogger: Deleting a book from the catalogue. If book is Special, it will also be deleted from Special.");
		return "redirect:/catalogue";
	}
	
}
