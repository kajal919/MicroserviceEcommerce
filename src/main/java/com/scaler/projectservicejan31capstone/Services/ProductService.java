package com.scaler.projectservicejan31capstone.Services;

import com.scaler.projectservicejan31capstone.Exceptions.ProductNotFoundException;
import com.scaler.projectservicejan31capstone.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id) throws ProductNotFoundException;
    List<Product> getAllProduct();
    Product createProduct(String name, String description, double price,
                  String imageURL, String category);

}
