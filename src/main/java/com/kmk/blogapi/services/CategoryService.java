package com.kmk.blogapi.services;

import java.util.List;

import com.kmk.blogapi.payloads.CategoryDto;

public interface CategoryService {

	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	//delete
	public void deleteCategory(Integer categoryId);
	//get
	public CategoryDto getCategory(Integer categoryId);
	//getAll
	List<CategoryDto> getCategories();
	public List<CategoryDto> getAllCategory();
}
