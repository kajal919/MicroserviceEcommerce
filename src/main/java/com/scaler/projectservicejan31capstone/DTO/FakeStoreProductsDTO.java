package com.scaler.projectservicejan31capstone.DTO;


import com.scaler.projectservicejan31capstone.models.Category;
import com.scaler.projectservicejan31capstone.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductsDTO {
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setName(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageURL(image);

        Category category1 = new Category();
        category1.setName(category);
        product.setCategory(category1);
        return product;


    }

}

