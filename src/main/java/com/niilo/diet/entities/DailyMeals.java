package com.niilo.diet.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "daily_meals")
public class DailyMeals {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Person person;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Meal> meals = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<ExtraFood> extraFoods = new ArrayList<>();
    @Column(name = "total_calories")
    private Integer totalCalories = 0;
    @Column(name = "date")
    private LocalDate date = LocalDate.now();
}
