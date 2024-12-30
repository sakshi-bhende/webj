package com.cdac.acts.ProductCrud.repository;

import com.cdac.acts.ProductCrud.entity.ProductId;
import com.cdac.acts.ProductCrud.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, ProductId> {
}
