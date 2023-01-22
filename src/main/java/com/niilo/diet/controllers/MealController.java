package com.niilo.diet.controllers;

import com.niilo.diet.entities.Meal;
import com.niilo.diet.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/meal")
@CrossOrigin
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping(path = "/all")
    public List<Meal> getAllMealParts() {
        return mealService.getAllMeals();
    }

    @PostMapping(path = "/add")
    public Meal saveMealPart(@RequestBody Meal meal) {
        return mealService.saveMeal(meal);
    }
}
