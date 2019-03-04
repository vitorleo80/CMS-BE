package io.cms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.cms.entities.Category;
import io.cms.service.CategoryService;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */

@RestController
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping("/")
	public Category createCategory(@RequestBody Category category) {
		Category createdCategory = categoryService.createCategory(category);
		return createdCategory;
	}

	@GetMapping("/")
	public List<Category> getCategoriesList() {
		return categoryService.getCategories();

	}
}