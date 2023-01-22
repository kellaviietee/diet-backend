package com.niilo.diet.services;

import com.niilo.diet.entities.FoodProduct;
import com.niilo.diet.repositories.FoodProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodProductService {

    @Autowired
    private FoodProductRepository foodProductRepository;

    public List<FoodProduct> getAllFoodProducts() {
        return foodProductRepository.findAll();
    }

    public FoodProduct getFoodProductById(Long id) {
        return foodProductRepository.findById(id).orElse(null);
    }

    public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
        return foodProductRepository.save(foodProduct);
    }

    FoodProduct createTestFoodProduct() {
        FoodProduct foodProduct = new FoodProduct();
        foodProduct.setName("kakao");
        foodProduct.setCalories(87);
        return foodProduct;
    }
    public List<FoodProduct> searchByName(String name) {
        return foodProductRepository.findByNameContainingIgnoreCase(name);
    }

}
