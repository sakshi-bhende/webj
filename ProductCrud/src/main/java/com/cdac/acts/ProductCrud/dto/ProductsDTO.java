package com.cdac.acts.ProductCrud.dto;

import com.cdac.acts.ProductCrud.entity.ProductId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {

    int productId;

    int categoryId;

    String productName;

    String productDescription;

    String productImageUrl;

    float productPrice;
}
