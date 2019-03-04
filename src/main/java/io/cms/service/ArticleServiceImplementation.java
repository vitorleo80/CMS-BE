package io.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.cms.entities.Article;
import io.cms.exceptions.ServiceException;
import io.cms.repository.ArticleRepository;
import io.cms.utils.Slug;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */

@Service
public class ArticleServiceImplementation implements ArticleService {

	@Autowired
	ArticleRepository articleRepo;

	@Autowired
	AuthorService authorService;

	@Autowired
	CategoryService categoryService;

	@Override
	public Article createPost(Article article) {

		if (articleRepo.findArticleByTitle(article.getTitle()) != null) {
			throw new ServiceException("Title already exists");
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		article.setAuthor(authorService.findByEmail(authentication.getName()));
		makeSlug(article);
		article.setCategory(categoryService.findById(article.getCategory().getId()));
		return articleRepo.save(article);
	}

	private void makeSlug(Article article) {
		Slug slug = new Slug();
		article.setSlug(slug.makeSlug(article.getTitle()));
	}

	@Override
	public List<Article> findAllArticles(int page, int limit) {
		List<Article> returnValue = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limit);
		Page<Article> articlesPage = articleRepo.findAll(pageableRequest);
		List<Article> articles = articlesPage.getContent();
		articles.forEach(article -> {
			returnValue.add(article);
		});

		return returnValue;
	}

	@Override
	public Article updateArticle(int id, Article article) {

		try {
			Article foundArticle = findArticle(id);
			if (foundArticle.getSlug() != article.getSlug()) {
				makeSlug(article);
			}
			articleRepo.save(article);
		} catch (RuntimeException e) {
			throw new ServiceException("You are trying to update an old version of" + " " + article.getTitle() + " "
					+ ". Please refresh your app and try again.");
		}
		return article;
	}

	private Article findArticle(int id) {
		Optional<Article> foundArticle = articleRepo.findById(id);
		if (!foundArticle.isPresent()) {
			throw new ServiceException("Article not found");
		}
		return foundArticle.get();
	}

	@Override
	public void deleteArticle(int id) {
		findArticle(id);
		Article foundArticle = findArticle(id);
		articleRepo.delete(foundArticle);
	}

	@Override
	public Article getArticleBySlug(String slug) {
		Article foundArticle = articleRepo.findArticleBySlug(slug);
		if (foundArticle == null) {
			throw new ServiceException("Article not found");
		}
		return foundArticle;
	}

	@Override
	public List<Article> findAllArticlesByAuthor(int id) {
		authorService.findAuthorById(id);
		List<Article> articles = new ArrayList<>();
		articleRepo.findAll().forEach(article -> {
			if (article.getAuthor().getId() == id) {
				articles.add(article);
			}
		});
		return articles;
	}

	@Override
	public List<Article> findAllArticlesByCategory(int id) {
		categoryService.findById(id);
		List<Article> articles = new ArrayList<>();
		articleRepo.findAll().forEach(article -> {
			if (article.getCategory().getId() == id) {
				articles.add(article);
			}
		});
		return articles;
	}

}
