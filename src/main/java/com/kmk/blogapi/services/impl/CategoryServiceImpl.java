package com.kmk.blogapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kmk.blogapi.entities.Category;
import com.kmk.blogapi.entities.Post;
import com.kmk.blogapi.exceptions.ResourceNotFoundException;
import com.kmk.blogapi.payloads.CategoryDto;
import com.kmk.blogapi.payloads.CategoryResponse;
import com.kmk.blogapi.payloads.PostDto;
import com.kmk.blogapi.payloads.PostResponse;
import com.kmk.blogapi.repo.CategoryRepo;
import com.kmk.blogapi.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	// CREATE new category
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);

		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	// UPDATE category
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryId));

		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());

		Category updatedcat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	@Override
	// DELETE category
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryId));
		this.categoryRepo.delete(cat);
	}

	@Override
	// GET[SINGLE] category
	public CategoryDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	//GET[ALL] category
	public CategoryResponse getAllCategory(Integer pageNumber, Integer pageSize) {
		
		Pageable p = PageRequest.of(pageNumber, pageSize);	
		Page<Category> pageCategory = this.categoryRepo.findAll(p);
		
		List<Category> allCategories = pageCategory.getContent();
		List<CategoryDto> catDtos = pageCategory.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setContent(catDtos);
		categoryResponse.setPageNumber(pageCategory.getNumber());
		categoryResponse.setPageSize(pageCategory.getSize());
		categoryResponse.setTotalRecods(pageCategory.getTotalElements());
		categoryResponse.setTotalPages(categoryResponse.getTotalPages());
		categoryResponse.setLastPage(pageCategory.isLast());
		
		return categoryResponse;
	}
	
	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}

}
