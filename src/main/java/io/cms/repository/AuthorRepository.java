package io.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.cms.entities.Author;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	Author findAuthorByEmail(String email);

}
