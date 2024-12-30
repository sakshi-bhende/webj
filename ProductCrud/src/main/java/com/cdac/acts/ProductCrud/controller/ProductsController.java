package com.cdac.acts.ProductCrud.controller;

import com.cdac.acts.ProductCrud.dto.ProductsDTO;
import com.cdac.acts.ProductCrud.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ProductsController {
    @Autowired
    ProductsService productsService;
    @GetMapping("")
    public String apiTest(){
        return "Welcome to products controller ";
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductsDTO>> getAllProducts(){
        return new ResponseEntity<>(productsService.getAllProducts(),HttpStatus.OK);
    }
    @GetMapping("/product/{pid}/{cid}")
    public ResponseEntity<ProductsDTO> getProductById(@PathVariable("pid") int productId,@PathVariable("cid") int categoryId){
        ProductsDTO dto = new ProductsDTO();
        dto.setProductId(productId);
        dto.setCategoryId(categoryId);
        return new ResponseEntity<>(productsService.getById(dto),HttpStatus.OK);
    }
    @DeleteMapping("/product/{pid}/{cid}")
    public ResponseEntity<String> deleteProductById(@PathVariable("pid") int productId,@PathVariable("cid") int categoryId){
        ProductsDTO dto = new ProductsDTO();
        dto.setProductId(productId);
        dto.setCategoryId(categoryId);
        return productsService.deleteById(dto);
    }
    @PostMapping("/product")
    public ResponseEntity<ProductsDTO> saveProducts(@RequestBody ProductsDTO dto){
        productsService.saveProduct(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @PutMapping("/product")
    public ResponseEntity<String> updateProduct(@RequestBody ProductsDTO dto){
        return productsService.updateProduct(dto);
    }

}
