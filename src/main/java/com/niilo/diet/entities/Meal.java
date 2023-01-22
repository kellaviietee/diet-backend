package com.niilo.diet.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "meals")
public class Meal {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.DETACH)
    private FoodProduct foodProduct;
    @Column(name = "mass")
    private Integer mass;
    @Column(name = "calories")
    private Integer calories;

}
