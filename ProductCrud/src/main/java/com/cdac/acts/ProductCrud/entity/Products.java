package com.cdac.acts.ProductCrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @EmbeddedId
    ProductId productId;
    @Column(name="productname")
    String productName;
    @Column(name="productdescription")
    String productDescription;
    @Column(name="productimageurl")
    String productImageUrl;
    @Column(name="productprice")
    float productPrice;

}
