package com.scaler.projectservicejan31capstone.Repositories;

import com.scaler.projectservicejan31capstone.models.Category;
import com.scaler.projectservicejan31capstone.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//JPA repository 1st argument: table name
//2nd argument: type of primary key
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(long id);

    List<Product> findByCategory(Category category);

    List<Product> findByCategory_Name(String categoryName);

    @Query("Select p from Product p where p.category.name= :categoryName")
    List<Product> getProductsByCategoryName(Category categoryName);

    @Query(value = "Select * from Product where category_id in (Select category_id from category where name= :categoryName)", nativeQuery = true)
    List<Product> getProductsByCategoryNamesNative(@Param("CategoryName") String CategoryName);

    Page<Product> findByNameContaining(String query, Pageable pageable);
    
}
