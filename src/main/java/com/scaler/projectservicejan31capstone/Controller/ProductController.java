package com.scaler.projectservicejan31capstone.Controller;

import com.scaler.projectservicejan31capstone.DTO.CreateFakeStoreProductDTO;
import com.scaler.projectservicejan31capstone.DTO.ErrorDTO;
import com.scaler.projectservicejan31capstone.DTO.ProductResponseDTO;
import com.scaler.projectservicejan31capstone.Exceptions.ProductNotFoundException;
import com.scaler.projectservicejan31capstone.Services.FakeStoreProductService;
import com.scaler.projectservicejan31capstone.Services.ProductService;
import com.scaler.projectservicejan31capstone.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductController {
    ProductService productService;
    public ProductController(@Qualifier("fakeStoreProductService")
                             ProductService productService) {

        this.productService = productService;

    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable long id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);

        ProductResponseDTO productResponseDTO = ProductResponseDTO.from(product);
        ResponseEntity<ProductResponseDTO> responseEntity =
                new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
        return productResponseDTO;
    }
    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDTO productResponseDTO = ProductResponseDTO.from(product);
            productResponseDTOs.add(productResponseDTO);
        }
        return productResponseDTOs;
    }
    @PostMapping("/products")
    public ProductResponseDTO createProduct(@RequestBody
                                            CreateFakeStoreProductDTO createFakeStoreProductDTO){

        Product product = productService.createProduct(
                createFakeStoreProductDTO.getName(),
                createFakeStoreProductDTO.getDescription(),
                createFakeStoreProductDTO.getPrice(),
                createFakeStoreProductDTO.getImageURL(),
                createFakeStoreProductDTO.getCategory()
        );
        ProductResponseDTO productResponseDTO = ProductResponseDTO.from(product);

        return productResponseDTO;
    }


}
