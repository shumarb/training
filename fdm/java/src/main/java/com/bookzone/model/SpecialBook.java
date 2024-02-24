/**
 * This class illustrates the attributes and behaviours of a Special Book object,
 * as well as the annotations of Spring used to map entities in the MySQL database.
 * 
 * A Special book is a Book that the Librarian has indicated as Special.
 * 
 * Every Special book object is stored in a table called specials.
 * 
 * @author Sheikh Umar
 */

package com.bookzone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "specials")
public class SpecialBook {
	
	/**
	 * A special book's identification number
	 */
	@Id
	private long id;
	
	/**
	 * A Special book's title
	 */
	private String title;
	
	/**
	 * A Special book's author
	 */
	private String author;
	
	/**
	 * A Special book's category
	 * Example: Fantasy.
	 */
	private String category;
	
	/**
	 * A Special book's year of publication.
	 */
	private int year;
	
	public SpecialBook() {
		super();
	}

	public SpecialBook(long id, String title, String author, String category, int year) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.year = year;
	}

	public long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getCategory() {
		return this.category;
	}

	public int getYear() {
		return this.year;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
