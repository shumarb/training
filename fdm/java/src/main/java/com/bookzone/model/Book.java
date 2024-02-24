/***
 * This class illustrates the attributes and behaviours of a Book object,
 * as well as the annotations of Spring used to map entities in the MySQL database.
 * 
 * Every book object is stored in a table called catalogue.
 * 
 * @author Sheikh Umar
 */
package com.bookzone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalogue")
public class Book {

	/***
	 * A book's identification number.
	 * 
	 * Every book will have a unique identification number
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/**
	 * A book's title.
	 */
	private String title;
	
	/**
	 * A book's author.
	 */
	private String author;
	
	/**
	 * A book's category
	 * 
	 * Example: Fantasy.
	 */
	private String category;
	
	/**
	 * A book's year of publication.
	 */
	private int year;
	
	public Book(String title, String author, String category, int year) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.year = year;
	}
	
	public Book(long id, String title, String author, String category, int year) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.year = year;
	}
	
	public Book() {
		super();
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

	public void setId(long id) {
		this.id = id;
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
