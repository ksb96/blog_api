package com.kmk.blogapi.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryResponse {
	private List<CategoryDto> content;
	
	private int pageNumber;
	private int pageSize;
	private long totalRecods;
	private int totalPages;
	private boolean lastPage;
}
