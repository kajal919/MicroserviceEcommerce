package com.scaler.projectservicejan31capstone.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFakeStoreProductDTO {
    private String name;
    private String description;
    private String category;
    private double price;
    private String imageURL;

}
