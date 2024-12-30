package com.cdac.services;

import java.util.List;

//import com.cdac.controller.List;
import com.cdac.dto.CategoryDto;


public interface CategoryService {
 
	//@Autowired
	//CategoryRepository categoryRepository;
	
	public boolean saveCategory(CategoryDto Dto) ;
	public boolean deleteCategory(int CategoryId) ;
	public CategoryDto getCategoryById(int  cid) ;
	 public List<CategoryDto> getallCategory();
	public boolean updateCategory(int cid, CategoryDto dto);
	
}
