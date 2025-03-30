package com.scaler.projectservicejan31capstone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String description;
    @OneToMany
    private List<Product> products;

    @OneToMany(mappedBy = "category")
    private List<Product> featuredProducts;
}
