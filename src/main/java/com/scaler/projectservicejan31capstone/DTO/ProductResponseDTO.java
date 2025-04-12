package com.scaler.projectservicejan31capstone.DTO;

import com.scaler.projectservicejan31capstone.models.Product;

public class ProductResponseDTO {
    private long id;
    private String name;
    private String description;
    private String imageURL;
    private double price;
    private String category;

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public double getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static ProductResponseDTO from(Product products) {
        if (products == null)
            return null;

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(products.getId());
        productResponseDTO.setName(products.getName());
        productResponseDTO.setDescription(products.getDescription());
        productResponseDTO.setImageURL(products.getImageURL());
        productResponseDTO.setPrice(products.getPrice());
        productResponseDTO.setCategory(products.getCategory().getName());
        return productResponseDTO;
    }
}
