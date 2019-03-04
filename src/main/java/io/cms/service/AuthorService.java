package io.cms.service;

import java.util.List;

import io.cms.entities.Author;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */
public interface AuthorService {

	void registerAuthor(Author author);

	List<Author> getAuthors();

	Author findByEmail(String email);

	Author findAuthorById(int id);

}
