package io.cms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.cms.entities.Author;
import io.cms.service.AuthorService;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@PostMapping("/sign-up")
	public String registerAuthor(@RequestBody Author author) {
		authorService.registerAuthor(author);
		return "Author created";
	}

	@GetMapping("/")
	public List<Author> getAuthors() {
		return authorService.getAuthors();

	}

}