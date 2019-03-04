package io.cms.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.cms.entities.Author;
import io.cms.repository.AuthorRepository;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	AuthorRepository authorRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Author author = authorRepo.findAuthorByEmail(email);

		if (author == null) {
			throw new UsernameNotFoundException(email);
		}

		return new User(author.getEmail(), author.getPassword(), Collections.emptyList());
	}

}
