package com.cdac.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
