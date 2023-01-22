package com.niilo.diet.controllers;

import com.niilo.diet.entities.FoodProduct;
import com.niilo.diet.services.FoodProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/foodProduct")
@CrossOrigin
public class FoodProductController {

    @Autowired
    private FoodProductService foodProductService;

    @GetMapping(path = "/all")
    public List<FoodProduct> getAllFoodProducts() {
        return foodProductService.getAllFoodProducts();
    }

    @GetMapping(path = "/{id}")
    public FoodProduct getFoodProductById(@PathVariable Long id) {
        return foodProductService.getFoodProductById(id);
    }

    @PostMapping(path = "/add")
    public FoodProduct saveFoodProduct(@RequestBody FoodProduct foodProduct) {
        return foodProductService.saveFoodProduct(foodProduct);
    }

    @GetMapping(path = "/search/{name}")
    public List<FoodProduct> searchFoodProductByName(@PathVariable String name) {
        return foodProductService.searchByName(name);
    }
}
