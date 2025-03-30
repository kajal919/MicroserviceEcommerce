package com.scaler.projectservicejan31capstone.Services;

import com.scaler.projectservicejan31capstone.Exceptions.ProductNotFoundException;
import com.scaler.projectservicejan31capstone.Repositories.CategoryRepository;
import com.scaler.projectservicejan31capstone.Repositories.ProductRepository;
import com.scaler.projectservicejan31capstone.models.Category;
import com.scaler.projectservicejan31capstone.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductDBService implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public ProductDBService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product createProduct(String name, String description, double price, String imageURL, String category) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageURL(imageURL);

        Category categoryObj = getCategoryFromDB(category);

        product.setCategory(categoryObj);
        return productRepository.save(product);

    }
    private Category getCategoryFromDB(String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        if(category.isPresent()) {
            return category.get();

        }

        Category categoryObj = new Category();
        categoryObj.setName(name);

        return categoryRepository.save(categoryObj);

    }
}
