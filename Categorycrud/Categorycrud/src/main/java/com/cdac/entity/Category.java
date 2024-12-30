package com.cdac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Category")
public class Category {

	@Id
	@Column(name="categoryid")
private int CategoryId;
	
	@Column(name="categoryname")
private String CategoryName;
	
	@Column(name="categorydescription")
private String CategoryDescription;
	
	
	@Column(name="categoryimageurl")
private String CategoryImageUrl;


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


	public String getCategoryDescription() {
		return CategoryDescription;
	}


	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}


	public String getCategoryImageUrl() {
		return CategoryImageUrl;
	}


	public void setCategoryImageUrl(String categoryImageUrl) {
		CategoryImageUrl = categoryImageUrl;
	}
	
	
}
