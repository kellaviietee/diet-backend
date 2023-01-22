package com.niilo.diet.services;


import com.niilo.diet.entities.DailyMeals;
import com.niilo.diet.entities.ExtraFood;
import com.niilo.diet.entities.Meal;
import com.niilo.diet.repositories.DailyMealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DailyMealService {

    @Autowired
    MealService mealService;

    @Autowired
    PersonService personService;

    @Autowired
    DailyMealsRepository dailyMealsRepository;

    public List<DailyMeals> getAllDailyMeals() {
        dailyMealsRepository.save(createTestDailyMeals());
        return dailyMealsRepository.findAll();
    }

    DailyMeals createTestDailyMeals() {
        DailyMeals dailyMeals = new DailyMeals();
        dailyMeals.setMeals(List.of(mealService.createTestMeal(), mealService.createTestMeal()));
        dailyMeals.setDate(LocalDate.now());
        dailyMeals.setPerson(personService.createTestPerson());
        return dailyMeals;
    }

    public DailyMeals addMealToDailyMeals(Meal meal) {
        DailyMeals dailyMeals = dailyMealsRepository.findByDate(LocalDate.now());
        dailyMeals.getMeals().add(meal);
        updateDailyMealsTotalCalories(dailyMeals);
        dailyMeals = dailyMealsRepository.save(dailyMeals);
        return dailyMeals;
    }

    public DailyMeals addExtraFoodToDailyMeals(ExtraFood extraFood) {
        DailyMeals dailyMeals = dailyMealsRepository.findByDate(LocalDate.now());
        dailyMeals.getExtraFoods().add(extraFood);
        updateDailyMealsTotalCalories(dailyMeals);
        dailyMeals = dailyMealsRepository.save(dailyMeals);
        return  dailyMeals;
    }

    private void updateDailyMealsTotalCalories(DailyMeals dailyMeals) {
        int totalCalories = dailyMeals.getMeals().stream()
                .mapToInt(Meal::getCalories)
                .sum();
        totalCalories += dailyMeals.getExtraFoods().stream()
                .mapToInt(ExtraFood::getCalories)
                .sum();
        dailyMeals.setTotalCalories(totalCalories);
    }

    public DailyMeals getCurrentDailyMeals(){
        LocalDate today = LocalDate.now();
        DailyMeals dailyMeals = dailyMealsRepository.findByDate(today);
        //Creating Today's dailyMeals if one does not yet exist.
        if (dailyMeals == null) {
            dailyMeals = new DailyMeals();
            dailyMeals.setDate(LocalDate.now());
            dailyMeals.setMeals(new ArrayList<>());
            dailyMeals.setTotalCalories(0);
        }
        return dailyMealsRepository.save(dailyMeals);
    }
}
