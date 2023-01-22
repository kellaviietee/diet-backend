package com.niilo.diet.services;

import com.niilo.diet.entities.ExtraFood;
import com.niilo.diet.repositories.ExtraFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ExtraFoodService {

    @Autowired
    private ExtraFoodRepository extraFoodRepository;

    public ExtraFood saveExtraFood(ExtraFood extraFood) {
        return extraFoodRepository.save(extraFood);
    }
}
