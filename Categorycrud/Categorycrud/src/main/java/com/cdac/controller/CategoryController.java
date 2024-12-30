package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.CategoryDto;
import com.cdac.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;
    @PostMapping("/save")
	public boolean saveCategory(@RequestBody CategoryDto Dto){
		
		return service.saveCategory(Dto);}
    
    @GetMapping("/get/{cid}")
  	public CategoryDto getCategoryById(@PathVariable("cid") int cid){
  		
  		return service.getCategoryById(cid);}
    
    @GetMapping("/get")
    public List<CategoryDto> getallCategory(){
		return service.getallCategory();
    	
    }
    @PutMapping("/update/{cid}")
    public boolean updateCategory(@PathVariable("cid") int cid, @RequestBody CategoryDto Dto) {
        return service.updateCategory(cid, Dto);
    }
    
    @DeleteMapping("/delete/{cid}")
    public boolean deleteCategory(@PathVariable("cid") int cid) {
        return service.deleteCategory(cid);
    }
	
}
