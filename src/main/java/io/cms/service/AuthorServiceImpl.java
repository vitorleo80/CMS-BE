package io.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.cms.entities.Author;
import io.cms.exceptions.ServiceException;
import io.cms.repository.AuthorRepository;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void registerAuthor(Author author) {
		if (authorRepo.findAuthorByEmail(author.getEmail()) != null) {
			throw new ServiceException(author.getEmail() + " " + "is already an user. Try another name ");
		}
		author.setPassword(bCryptPasswordEncoder.encode(author.getPassword()));
		authorRepo.save(author);

	}

	@Override
	public List<Author> getAuthors() {
		List<Author> authors = new ArrayList<>();
		authorRepo.findAll().forEach(author -> {
			authors.add(author);
		});
		return authors;
	}

	@Override
	public Author findByEmail(String email) {
		Author author = authorRepo.findAuthorByEmail(email);
		if (author == null) {
			throw new ServiceException("Author not found");
		}
		return author;

	}

	@Override
	public Author findAuthorById(int id) {
		Optional<Author> author = authorRepo.findById(id);
		if (!author.isPresent()) {
			throw new ServiceException("Author not found");
		}
		return author.get();
	}

}
