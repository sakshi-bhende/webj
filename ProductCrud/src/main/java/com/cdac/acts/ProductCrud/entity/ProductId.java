package com.cdac.acts.ProductCrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductId implements Serializable {

    @Column(name="productid")
    int productId;
    @Column(name="categoryid")
    int categoryId;
}
