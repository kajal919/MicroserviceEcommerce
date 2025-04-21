package com.scaler.projectservicejan31capstone.Services;

import com.scaler.projectservicejan31capstone.DTO.FakeStoreProductsDTO;
import com.scaler.projectservicejan31capstone.Exceptions.ProductNotFoundException;
import com.scaler.projectservicejan31capstone.models.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FakeStoreProductServiceTest {

    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    RedisTemplate<String, Object> redisTemplate = Mockito.mock(RedisTemplate.class);

    FakeStoreProductService fakeStoreProductService = new FakeStoreProductService(restTemplate, redisTemplate);

    @Test
    public void testGetProductByIdReturnsProduct() throws ProductNotFoundException {
        FakeStoreProductsDTO dummyResponse = new FakeStoreProductsDTO();
        dummyResponse.setId(1L);
        dummyResponse.setTitle("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
        dummyResponse.setDescription("description");
        dummyResponse.setPrice(22);
        dummyResponse.setImage("img.url");
        dummyResponse.setCategory("category");


        when(restTemplate.getForObject(
                "https://fakestoreapi.com/products/1",
                FakeStoreProductsDTO.class)).thenReturn(dummyResponse);
        Product product = fakeStoreProductService.getProductById(1L);

        assertEquals(1L, product.getId());
        assertEquals("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", product.getName());


    }

    @Test
    public void getProductByIdWithNullProductThrowException() throws ProductNotFoundException {
        when(restTemplate.getForObject(
                "https://fakestoreapi.com/products/1",
                FakeStoreProductsDTO.class)).thenReturn(null);

        assertThrows(ProductNotFoundException.class, () ->
                fakeStoreProductService.getProductById(1L));
    }
    @Test
    public void testCreateProductVerifyAPICalls(){
        FakeStoreProductsDTO dummyResponse = new FakeStoreProductsDTO();
        dummyResponse.setId(1L);
        dummyResponse.setTitle("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
        dummyResponse.setDescription("description");
        dummyResponse.setPrice(22);
        dummyResponse.setImage("img.url");
        dummyResponse.setCategory("category");


        when(restTemplate.postForObject(
                eq("https://fakestoreapi.com/products"),
                any(),
                eq(FakeStoreProductsDTO.class))).thenReturn(dummyResponse);

            Product product = fakeStoreProductService.createProduct("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", "description", 22, "img.url",
                     "category");
            verify(restTemplate, times(1)).postForObject(
                    eq("https://fakestoreapi.com/products"),
                    any(),
                    eq(FakeStoreProductsDTO.class));

    }
}
