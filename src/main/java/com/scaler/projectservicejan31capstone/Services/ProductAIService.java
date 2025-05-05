package com.scaler.projectservicejan31capstone.Services;

import com.scaler.projectservicejan31capstone.models.Product;

public interface ProductAIService {
    Product createProductWithAIDesc(String name, double price,
                                    String imageURL, String category);
}
