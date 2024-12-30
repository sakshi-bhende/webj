package com.cdac.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.backend.dto.CategoryDTO;
import com.cdac.backend.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
		
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/{id}")
	public CategoryDTO getByCategoryName(@PathVariable("id") int id) {
		return categoryService.getByCategoryName(id);
	}
	
	@PostMapping("/")
	public boolean saveCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.save(categoryDTO);
	}
}
