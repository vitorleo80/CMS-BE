package io.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.cms.entities.Article;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

	Article findArticleByTitle(String title);

	Article findArticleBySlug(String slug);

}
