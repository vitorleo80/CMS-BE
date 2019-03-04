package io.cms.service;

import java.util.List;

import io.cms.entities.Category;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */
public interface CategoryService {

	Category createCategory(Category category);

	List<Category> getCategories();

	Category findById(int id);

}
