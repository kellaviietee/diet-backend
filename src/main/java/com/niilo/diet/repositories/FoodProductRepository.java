package com.niilo.diet.repositories;

import com.niilo.diet.entities.FoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodProductRepository extends JpaRepository<FoodProduct,Long> {

    List<FoodProduct> findByNameContainingIgnoreCase(String name);

}
