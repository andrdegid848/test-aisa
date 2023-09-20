package com.test.aisa.database.entity;

import com.test.aisa.database.enums.AdditionalIngredient;
import com.test.aisa.database.enums.CookingMethod;
import com.test.aisa.database.enums.Roast;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public abstract class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roast roast;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CookingMethod cookingMethod;

    @Enumerated(EnumType.STRING)
    private AdditionalIngredient additionalIngredient;

    public abstract void makeCoffee();
}
