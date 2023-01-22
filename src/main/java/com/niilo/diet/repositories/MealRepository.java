package com.niilo.diet.repositories;

import com.niilo.diet.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal,Long> {
}
