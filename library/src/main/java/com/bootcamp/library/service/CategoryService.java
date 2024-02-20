package com.bootcamp.library.service;

import java.util.List;
import java.util.Optional;

import com.bootcamp.library.dto.CategoryDto;
import com.bootcamp.library.model.Category;

public interface CategoryService {
	List<Category> findAll();
	
	Category save(Category category);

    Category update(Category category);

    List<Category> findAllByActivatedTrue();
    
    Optional<Category> findById(Long id);

    void deleteById(Long id);

    void enableById(Long id);

    List<CategoryDto> getCategoriesAndSize();
}

