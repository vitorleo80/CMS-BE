package io.cms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.cms.entities.Category;
import io.cms.exceptions.ServiceException;
import io.cms.repository.CategoryRepository;
import io.cms.utils.Slug;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */
@Service
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	CategoryRepository categoryRepo;

	@Override
	public Category createCategory(Category category) {
		findCategoryByName(category);
		makeSlug(category);
		return categoryRepo.save(category);

	}

	private void findCategoryByName(Category category) {
		Category foundCategory = categoryRepo.findCategoryByName(category.getName());
		if (foundCategory != null) {
			throw new ServiceException(category.getName() + " " + "already exists. Try another name");
		}
	}

	private void makeSlug(Category category) {
		Slug slug = new Slug();
		category.setSlug(slug.makeSlug(category.getName()));
	}

	@Override
	public List<Category> getCategories() {
		return categoryRepo.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public Category findById(int id) {
		Optional<Category> categoryOptional = categoryRepo.findById(id);
		if (!categoryOptional.isPresent()) {
			throw new ServiceException("Category not found");
		}
		return categoryOptional.get();
	}

}
