package com.niilo.diet.controllers;

import com.niilo.diet.entities.DailyMeals;
import com.niilo.diet.entities.ExtraFood;
import com.niilo.diet.entities.Meal;
import com.niilo.diet.services.DailyMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/dailyMeals")
@CrossOrigin
public class DailyMealsController {

    @Autowired
    DailyMealService dailyMealService;

    @GetMapping(path = "/all")
    public List<DailyMeals> getAllDailyMeals(){
        return dailyMealService.getAllDailyMeals();
    }

    @GetMapping(path = "/current")
    public DailyMeals getCurrentDailyMeals(){
        return dailyMealService.getCurrentDailyMeals();
    }

    @PostMapping(path = "/addMeal")
    public DailyMeals addMealToDailyMeals(@RequestBody Meal meal) {
        return dailyMealService.addMealToDailyMeals(meal);
    }

    @PostMapping(path = "/addExtraFood")
    public DailyMeals addExtraFoodToDailyMeals(@RequestBody ExtraFood extraFood) {
        return dailyMealService.addExtraFoodToDailyMeals(extraFood);
    }
}
