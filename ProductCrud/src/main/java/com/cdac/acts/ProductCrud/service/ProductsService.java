package com.cdac.acts.ProductCrud.service;

import com.cdac.acts.ProductCrud.dto.ProductsDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductsService {
    public ProductsDTO saveProduct(ProductsDTO dto);
    public ProductsDTO getById(ProductsDTO dto);
    public ResponseEntity<String> deleteById(ProductsDTO dto);
    public List<ProductsDTO> getAllProducts();
    public ResponseEntity<String>  updateProduct(ProductsDTO dto);
}
