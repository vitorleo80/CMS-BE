package io.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cms.entities.Category;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findCategoryByName(String name);

}
