package com.niilo.diet.services;


import com.niilo.diet.entities.Meal;
import com.niilo.diet.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FoodProductService foodProductService;

    public List<Meal> getAllMeals() {
        mealRepository.save(createTestMeal());
        return mealRepository.findAll();
    }

    public Meal saveMeal(Meal meal) {
        //Setting the meals calories here before saving it to the repository. Not sure how to do it in Entity class.
        meal.setCalories((int)Math.round(meal.getFoodProduct().getCalories() * meal.getMass() / 100.0));
        return mealRepository.save(meal);
    }

    Meal createTestMeal(){
        Meal meal = new Meal();
        meal.setMass(28);
        meal.setFoodProduct(foodProductService.createTestFoodProduct());
        return meal;
    }
}
