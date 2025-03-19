package com.scaler.projectservicejan31capstone.Controller;

import com.scaler.projectservicejan31capstone.DTO.FakeStoreProductsDTO;
import com.scaler.projectservicejan31capstone.DTO.ProductResponseDTO;
import com.scaler.projectservicejan31capstone.Services.FakeStoreProductService;
import com.scaler.projectservicejan31capstone.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    FakeStoreProductService fakeStoreProductService;
    public ProductController(FakeStoreProductService fakeStoreProductService) {
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable long id) {
        Product product = fakeStoreProductService.getProductById(id);

        ProductResponseDTO productResponseDTO = ProductResponseDTO.from(product);
        ResponseEntity<ProductResponseDTO> responseEntity =
                new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
        return responseEntity;
    }
}
