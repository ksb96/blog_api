package com.kmk.blogapi.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
	
	private Integer categoryId;
	@NotBlank
	@Size(min = 6, max = 10)
	private String categoryTitle;
	@NotBlank
	@Size(min = 6)
	private String categoryDescription;

}
