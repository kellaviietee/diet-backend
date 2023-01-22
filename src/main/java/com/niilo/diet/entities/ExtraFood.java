package com.niilo.diet.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is Entity is meant for cases when person does not know the foodProducts used in Meals
 * but just knows the name of the food and how much calories it gave.
 */
@Entity
@Table(name = "extra_food")
@Data
@NoArgsConstructor
public class ExtraFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer calories;
}
