package com.scaler.projectservicejan31capstone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class Product extends BaseModel implements Serializable {

    private String description;
    private String imageURL;
    private double price;
    @ManyToOne
    private Category category;




    public String getDescription() {
        return this.description;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public double getPrice() {
        return this.price;
    }

    public Category getCategory() {
        return this.category;
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

    public void setCategory(Category category) {
        this.category = category;
    }
}
