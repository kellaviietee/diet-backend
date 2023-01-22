package com.niilo.diet.controllers;

import com.niilo.diet.entities.Recipe;
import com.niilo.diet.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/recipe")
@CrossOrigin
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(path = "/all")
    public List<Recipe> getAllMeals() {
        return recipeService.getAllMeals();
    }

    @PostMapping(path = "/add")
    public Recipe saveMeal(@RequestBody Recipe recipe) {
        return recipeService.saveMeal(recipe);
    }
}
