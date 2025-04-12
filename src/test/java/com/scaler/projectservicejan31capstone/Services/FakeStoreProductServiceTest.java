package com.scaler.projectservicejan31capstone.Services;

import com.scaler.projectservicejan31capstone.DTO.FakeStoreProductsDTO;
import com.scaler.projectservicejan31capstone.Exceptions.ProductNotFoundException;
import com.scaler.projectservicejan31capstone.models.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FakeStoreProductServiceTest {

    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

    FakeStoreProductService fakeStoreProductService = new FakeStoreProductService(restTemplate);
    @Test
    public void testGetProductByIdReturnsProduct() throws ProductNotFoundException {
        FakeStoreProductsDTO dummyResponse = new FakeStoreProductsDTO();
        dummyResponse.setId(1L);
        dummyResponse.setTitle("Title");
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
}
