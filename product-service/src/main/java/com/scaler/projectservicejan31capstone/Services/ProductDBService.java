package com.scaler.projectservicejan31capstone.Services;

import com.scaler.projectservicejan31capstone.Exceptions.ProductNotFoundException;
import com.scaler.projectservicejan31capstone.Repositories.CategoryRepository;
import com.scaler.projectservicejan31capstone.Repositories.ProductRepository;
import com.scaler.projectservicejan31capstone.models.Category;
import com.scaler.projectservicejan31capstone.models.Product;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductDBService implements ProductService, ProductAIService {

    private final ChatClient chatClient;
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public ProductDBService(ProductRepository productRepository, CategoryRepository categoryRepository, ChatClient chatClient) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.chatClient = chatClient;
    }
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {

        Optional<Category> categoryOptional = categoryRepository.findByName("Electronics");
        List<Product> products = productRepository.findByCategory(categoryOptional.get());
        System.out.println(products);


        return null;
//        Optional<Product> product = productRepository.findById(id);
//        if (product.isEmpty()) {
//            throw new ProductNotFoundException("Product with id " + id + " not found");
//        }
//        return product.get();
    }

    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll();

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

    @Override
    public Product createProductWithAIDesc(String name, double price, String imageURL, String category) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setImageURL(imageURL);
        Category categoryObj = getCategoryFromDB(category);
        product.setCategory(categoryObj);

        String description = getDescriptionFromAI(product);
        product.setDescription(description);
        return productRepository.save(product);
    }

    private String getDescriptionFromAI(Product product) {
        String message = String.format("Generate a 150 word professional marketing for a %s product name '%s'."+
                "Key features: priced at $%.2f, Category: %s."+
                "Focus on benefits and unique selling points. Avoid technical jargons. Use markdown formatting",
                product.getCategory().getName().toLowerCase(),
                product.getName(),
                 product.getPrice(),
                 product.getCategory().getName());

        return chatClient.prompt().user(message).call().content();

    }
}
