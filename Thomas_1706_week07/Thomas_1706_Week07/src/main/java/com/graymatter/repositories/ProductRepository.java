package com.graymatter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.graymatter.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//	List<Product> findByName(String name);
//	
//	List<Product> findByCategory(String category);
//	
//	@Query("SELECT p FROM Product p WHERE CONCAT(',', p.tags, ',') LIKE %:tag%")
//    List<Product> findByTag(@Param("tag") String tag);
//
//    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    
    @Query("SELECT p FROM Product p " +
            "WHERE (:tag IS NULL OR CONCAT(',', p.tags, ',') LIKE %:tag%) " +
            "AND (:name IS NULL OR p.name LIKE %:name%) " +
            "AND (:category IS NULL OR p.category = :category) " +
            "AND (:minPrice IS NULL OR :maxPrice IS NULL OR p.price BETWEEN :minPrice AND :maxPrice)")
     List<Product> search(@Param("tag") String tag,
                          @Param("name") String name,
                          @Param("category") String category,
                          @Param("minPrice") Double minPrice,
                          @Param("maxPrice") Double maxPrice);
}
