package com.cdac.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.backend.dto.CategoryDTO;
import com.cdac.backend.dto.UsersDTO;
import com.cdac.backend.entity.Category;
import com.cdac.backend.entity.Users;
import com.cdac.backend.repositories.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public boolean save(CategoryDTO dto) {
		
		Category eCategory = new Category();
		BeanUtils.copyProperties(dto, eCategory);
		categoryRepository.save(eCategory);
		
		return true;
	}

	@Override
	public CategoryDTO getByCategoryName(int id) {
		Optional<Category> categoryEntity = categoryRepository.findById(id);
		if(categoryEntity.isPresent()) {
			CategoryDTO dto = new CategoryDTO();
			BeanUtils.copyProperties(categoryEntity.get(),dto);
			return dto;
		}
		
		return null;
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
