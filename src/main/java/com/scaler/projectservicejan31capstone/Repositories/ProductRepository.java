package com.scaler.projectservicejan31capstone.Repositories;

import com.scaler.projectservicejan31capstone.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA repository 1st argument: table name
//2nd argument: type of primary key
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    
}
