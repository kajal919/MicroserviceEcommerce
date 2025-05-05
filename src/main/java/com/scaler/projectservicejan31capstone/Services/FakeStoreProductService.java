package com.scaler.projectservicejan31capstone.Services;

import com.scaler.projectservicejan31capstone.DTO.FakeStoreProductRequestDTO;
import com.scaler.projectservicejan31capstone.DTO.FakeStoreProductsDTO;
import com.scaler.projectservicejan31capstone.DTO.ProductResponseDTO;
import com.scaler.projectservicejan31capstone.Exceptions.ProductNotFoundException;
import com.scaler.projectservicejan31capstone.models.Product;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;
    RedisTemplate<String, Object> redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate<String, Object> redisTemplate) {

        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;

    }
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {

        Product productFromCache = (Product)redisTemplate.opsForValue().get(String.valueOf(id));

        if(productFromCache != null) {
            return productFromCache;
        }
        FakeStoreProductsDTO fakeStoreProductsDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductsDTO.class);
        if(fakeStoreProductsDTO == null) {
            throw new ProductNotFoundException("Product does not exist for id:"+ id);
        }
        Product productFromFakeStore = fakeStoreProductsDTO.toProduct();
        redisTemplate.opsForValue().set(String.valueOf(id), productFromFakeStore);
        return productFromFakeStore;

    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreProductsDTO[] fakeStoreProductsDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductsDTO[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductsDTO fakeStoreProductsDTO1 : fakeStoreProductsDTO) {
            Product product = fakeStoreProductsDTO1.toProduct();
            products.add(product);
        }
        return products;
    }

    @Override
    public Product createProduct(String name, String description, double price, String imageURL, String category) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setTitle(name);
        fakeStoreProductRequestDTO.setDescription(description);
        fakeStoreProductRequestDTO.setPrice(price);
        fakeStoreProductRequestDTO.setImageURL(imageURL);
        fakeStoreProductRequestDTO.setCategory(category);

        FakeStoreProductsDTO fakeStoreProductsDTO = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductRequestDTO,
                FakeStoreProductsDTO.class);

        return fakeStoreProductsDTO.toProduct();
    }


}
