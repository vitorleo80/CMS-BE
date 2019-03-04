package io.cms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.cms.entities.Article;
import io.cms.entities.ResponseWrapper;
import io.cms.service.ArticleService;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */

@RestController
@RequestMapping("articles")
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@PostMapping("/")
	public Article createArticle(@RequestBody Article article) {
		Article createdArticle = articleService.createPost(article);
		return createdArticle;
	}

	@GetMapping("/")
	public List<Article> getArticlesList(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "3") int limit) {
		List<Article> articles = articleService.findAllArticles(page, limit);
		return articles;
	}

	@PutMapping("/{id}")
	public Article updateArticle(@PathVariable int id, @RequestBody Article article) {
		Article updatedArticle = articleService.updateArticle(id, article);
		return updatedArticle;

	}

	@DeleteMapping("/{id}")
	public ResponseWrapper deleteArticle(@PathVariable int id) {
		ResponseWrapper returnValue = new ResponseWrapper();
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		articleService.deleteArticle(id);
		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		return returnValue;
	}

	@GetMapping("{slug}")
	public Article getArticleBySlug(@PathVariable String slug) {
		Article article = articleService.getArticleBySlug(slug);
		return article;
	}

	@GetMapping("/author/{id}")
	public List<Article> getArticlesByAuthor(@PathVariable int id) {
		return articleService.findAllArticlesByAuthor(id);
	}

	@GetMapping("/category/{id}")
	public List<Article> getArticlesByCategory(@PathVariable int id) {
		return articleService.findAllArticlesByCategory(id);
	}
}