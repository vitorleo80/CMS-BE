package io.cms.service;

import java.util.List;

import io.cms.entities.Article;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */
public interface ArticleService {

	Article createPost(Article article);

	List<Article> findAllArticles(int page, int limit);

	Article updateArticle(int id, Article article);

	void deleteArticle(int id);

	Article getArticleBySlug(String slug);

	List<Article> findAllArticlesByAuthor(int id);

	List<Article> findAllArticlesByCategory(int id);

}
