package com.enrique.managers;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.enrique.entities.CategoryEntity;
import com.enrique.model.EditContainer;
import com.enrique.model.QuestionException;
import com.enrique.repositories.CategoryRepository;

@Service
public class CategoryManager {
	private CategoryRepository categoryRepository;

	private QuestionException listEmptyException = new QuestionException("The list of categories is empty");

	public CategoryManager(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public void addCategory(String name) {
		CategoryEntity lastCategory = categoryRepository.findFirstByOrderByIdDesc()
				.orElseThrow(() -> listEmptyException);
		categoryRepository.save(new CategoryEntity(lastCategory.getId() + 1L, name));
	}

	public void deleteCategory(String name) {
		categoryRepository.delete(categoryRepository.findByName(name).orElseThrow(() -> listEmptyException));
	}

	public boolean editCategory(EditContainer editContainer) {
		CategoryEntity exitingCategory = categoryRepository.findByName(editContainer.getOldOne())
				.orElseThrow(() -> new QuestionException("No element found with name " + editContainer.getOldOne()));
		if (!StringUtils.isEmpty(editContainer.getNewOne())) {
			categoryRepository.save(new CategoryEntity(exitingCategory.getId(), editContainer.getNewOne()));
			return true;
		} else {
			throw new QuestionException(
					"Category " + editContainer.getNewOne() + " does not exits or a null value was provided");
		}
	}

}
