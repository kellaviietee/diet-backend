package com.niilo.diet.repositories;

import com.niilo.diet.entities.DailyMeals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface DailyMealsRepository extends JpaRepository<DailyMeals,Long> {

    DailyMeals findByDate(LocalDate date);
}
