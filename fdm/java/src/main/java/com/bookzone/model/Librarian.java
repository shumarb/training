/**
 * This class illustrates the attributes and behaviours of a Librarian.
 * 
 * Every librarian is stored in a table called librarians in the MySQL database.
 * 
 * @author Sheikh Umar
 */

package com.bookzone.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "librarians")
public class Librarian {

	/**
	 * A librarian's identification number.
	 * 
	 * Every librarian will have a unique identification number.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/**
	 * A librarian's name.
	 */
	private String name;
	
	/**
	 * A librarian's email address when accessing BookZone.
	 * @Column annotation used to enforce that every librarian has a unique email address.
	 */
	@Column(unique = true)
	private String email;
	
	/**
	 * A librarian's password when accessing BookZone.
	 */
	private String password;
	
	public Librarian() {
		super();
	}

	public Librarian(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Librarian(long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
}
