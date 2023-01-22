package com.niilo.diet.services;

import com.niilo.diet.entities.Recipe;
import com.niilo.diet.entities.Meal;
import com.niilo.diet.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private MealService mealService;
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllMeals() {
        recipeRepository.save(createTestMeal());
        return recipeRepository.findAll();
    }

    public Recipe saveMeal(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    Recipe createTestMeal() {
        Recipe recipe = new Recipe();
        recipe.setName("Breakfast");
        List<Meal> mealList = List.of(mealService.createTestMeal(),mealService.createTestMeal());
        recipe.setMeals(mealList);
        return recipe;
    }
}
