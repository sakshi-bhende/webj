package com.cdac.backend.services;

import java.util.List;

import com.cdac.backend.dto.CategoryDTO;
import com.cdac.backend.dto.UsersDTO;

public interface CategoryService {
	public boolean save(CategoryDTO dto);
	public CategoryDTO getByCategoryName(int id);
	public List<CategoryDTO> getAllCategories();
}
