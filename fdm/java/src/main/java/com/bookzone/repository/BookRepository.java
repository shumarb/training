/**
 * The BookRepository interface that extends from the JpaRepository.
 * It is used to manage the Book enitity.
 */

package com.bookzone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookzone.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	/**
	 * Finds a book based on it's id.
	 * 
	 * @param the id of the book to retrieve
	 * @return an Optional of type Book that has the given ID,
	 * or empty if no Book with the given id exists.
	 */
	Optional<Book> findById(Long id);
}
