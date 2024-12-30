package com.cdac.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.CategoryDto;
import com.cdac.entity.Category;
import com.cdac.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository cr;
	
	@Override
	public boolean saveCategory(CategoryDto Dto) {
		
		Category obj =new Category();
		BeanUtils.copyProperties(Dto, obj);
		cr.save(obj);
		return true;
	}

	@Override
	public boolean deleteCategory(int CategoryId) {
				
	Optional<Category> k =	cr.findById(CategoryId);
	if(k.isPresent()) {
		cr.deleteById(CategoryId);
		return true;
	} 
	else {
				
		return false;
	}
	}

	@Override
	public CategoryDto getCategoryById(int CategoryId) {

		//Category obj =new Category();
		CategoryDto obj1=new CategoryDto();
		
				Optional<Category> s=cr.findById(CategoryId);
				BeanUtils.copyProperties(s.get(),obj1);
		return obj1;
	}

	
	@Override
	public List<CategoryDto> getallCategory() {
		
		List<Category> list= cr.findAll();
		List<CategoryDto> listdto= new ArrayList<>();
		
		for(Category e:list) {
			CategoryDto Dto = new CategoryDto();
			BeanUtils.copyProperties(e,Dto);
			listdto.add(Dto);
			
		}
		return listdto;
	}

	@Override
	public boolean updateCategory(int cid, CategoryDto dto) {
		// TODO Auto-generated method stub
		Category obj =new Category();
		BeanUtils.copyProperties(dto, obj);

		
		 cr.save(obj);
		 return true;
	}

}
