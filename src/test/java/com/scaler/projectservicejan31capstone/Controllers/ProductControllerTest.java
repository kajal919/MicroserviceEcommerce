package com.scaler.projectservicejan31capstone.Controllers;

import com.scaler.projectservicejan31capstone.Controller.ProductController;
import com.scaler.projectservicejan31capstone.DTO.ProductResponseDTO;
import com.scaler.projectservicejan31capstone.Exceptions.ProductNotFoundException;
import com.scaler.projectservicejan31capstone.Services.ProductService;
import com.scaler.projectservicejan31capstone.models.Category;
import com.scaler.projectservicejan31capstone.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @MockitoBean
    @Qualifier("productDBService")
    public ProductService productService;


    @Autowired
    public ProductController productController;

    @Test
    public void testProductByIdReturnsProductResponseDTO() throws ProductNotFoundException {
        Product dummyProduct = new Product();
        dummyProduct.setId(1L);
        dummyProduct.setName("name");
        dummyProduct.setDescription("decription");
        dummyProduct.setPrice(12.7);
        dummyProduct.setImageURL("img.url");

        Category dummyCategory = new Category();
        dummyCategory.setId(1L);
        dummyCategory.setName("category");
        dummyCategory.setDescription("category");
        dummyProduct.setCategory(dummyCategory);

        when(productService.getProductById(1L)).thenReturn(dummyProduct);

        ProductResponseDTO productResponseDTO = productController.getProductById(1L);
        assertEquals(1L, productResponseDTO.getId());
        assertEquals("name", productResponseDTO.getName());
        assertEquals("decription", productResponseDTO.getDescription());
        assertEquals("img.url", productResponseDTO.getImageURL());
        assertEquals(12.7, productResponseDTO.getPrice(), 0);
        assertEquals(1L, dummyCategory.getId());

    }
    @Test
    public void testGetProductByIdReturnsNull() throws ProductNotFoundException {
        when(productService.getProductById(1L)).thenReturn(null);
        ProductResponseDTO productResponseDTO = productController.getProductById(1L);
        assertNull(productResponseDTO);
    }
}
