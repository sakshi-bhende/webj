package com.cdac.dto;

public class CategoryDto {
  
	private int CategoryId;
	private String CategoryName;
	private String CategoryImageUrl;
	private String CategoryDescription;
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getCategoryImageUrl() {
		return CategoryImageUrl;
	}
	public void setCategoryImageUrl(String categoryImageUrl) {
		CategoryImageUrl = categoryImageUrl;
	}
	public String getCategoryDescription() {
		return CategoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}
	
	
}
