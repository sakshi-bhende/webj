package com.cdac.acts.ProductCrud.service;

import com.cdac.acts.ProductCrud.dto.ProductsDTO;
import com.cdac.acts.ProductCrud.entity.ProductId;
import com.cdac.acts.ProductCrud.entity.Products;
import com.cdac.acts.ProductCrud.repository.ProductsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService{
    @Autowired
    ProductsRepository productsRepository;

    @Override
    public ProductsDTO saveProduct(ProductsDTO dto) {
        Products product = new Products();
        product.setProductId(new ProductId(dto.getCategoryId(), dto.getProductId()));
        product.setProductName(dto.getProductName());
        product.setProductDescription(dto.getProductDescription());
        product.setProductImageUrl(dto.getProductImageUrl());
        product.setProductPrice(dto.getProductPrice());
        productsRepository.save(product);
        BeanUtils.copyProperties(product, dto);
        return dto;
    }

    @Override
    public ProductsDTO getById(ProductsDTO dto) {
        Optional<Products> optProducts = productsRepository.findById(new ProductId(dto.getProductId(),dto.getCategoryId()));
        if(optProducts.isPresent()){
            Products products = optProducts.get();
            dto = new ProductsDTO(products.getProductId().getProductId(),products.getProductId().getCategoryId(),products.getProductName(),products.getProductDescription(),products.getProductImageUrl(),products.getProductPrice());
            return dto;
        }
        return null;
    }

    @Override
    public ResponseEntity<String> deleteById(ProductsDTO dto) {
        ProductId pid = new ProductId( dto.getProductId(),dto.getCategoryId());
        Optional<Products> optProduct= productsRepository.findById(pid);
        if(optProduct.isPresent()){
            productsRepository.deleteById(pid);
            return new ResponseEntity<>("Product With Product Id "+dto.getProductId()+" Category Id "+dto.getCategoryId()+" has been deleted", HttpStatus.FOUND);

        }
            return new ResponseEntity<>("ProductId or CategoryId  is null or  cannot find data", HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public List<ProductsDTO> getAllProducts() {
        List<Products> productsList = productsRepository.findAll();
        List<ProductsDTO> finalList = new ArrayList<>();
        for(Products products : productsList){
            ProductsDTO dto = new ProductsDTO(products.getProductId().getProductId(),products.getProductId().getCategoryId(),products.getProductName(),products.getProductDescription(),products.getProductImageUrl(),products.getProductPrice());
            finalList.add(dto);
        }
        return finalList;
    }

    @Override
    public ResponseEntity<String> updateProduct(ProductsDTO dto) {

        if(dto.getProductId()!=0 && dto.getCategoryId()!=0){
            Optional<Products> product = productsRepository.findById(new ProductId(dto.getProductId(), dto.getCategoryId()));

            if(product.isPresent()){
                if(dto.getProductName()!=null){
                        product.get().setProductName(dto.getProductName());
                }
                if(dto.getProductDescription()!=null){
                    product.get().setProductDescription(dto.getProductDescription());
                }
                if(dto.getProductImageUrl()!=null){
                    product.get().setProductPrice(dto.getProductPrice());
                }
                productsRepository.save(product.get());

                return new ResponseEntity<>("Product With Product Id "+dto.getProductId()+" Category Id "+dto.getCategoryId()+" has been updated", HttpStatus.FOUND);
            }
            else {
                return new ResponseEntity<>("Product With Product Id "+dto.getProductId()+" Category Id "+dto.getCategoryId()+" not found", HttpStatus.NOT_FOUND);
            }
        }
        else{
            return new ResponseEntity<>("Product or Category is null cannot find data", HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
