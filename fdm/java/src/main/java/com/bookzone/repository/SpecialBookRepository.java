/**
 * The SpecialBookRepository interface that extends from the JpaRepository.
 * It is used to manage the SpecialBook enitity.
 */

package com.bookzone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookzone.model.SpecialBook;

@Repository
public interface SpecialBookRepository extends JpaRepository<SpecialBook, Long> {
	
	/**
	 * Retrives a SpecialBook by id
	 * 
	 * @param A SpecialBook's id
	 * @return an Optional of type SpecialBook containing either the SpecialBook with the given id,
	 * or empty if no SpecialBook with the given id exists
	 */
	Optional<SpecialBook> findById(Long id);
}
