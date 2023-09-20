package com.test.aisa.dto;

import com.test.aisa.database.enums.AdditionalIngredient;
import com.test.aisa.database.enums.CookingMethod;
import com.test.aisa.database.enums.Roast;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Value;

@Value
public class CoffeeDto {
    String name;
    Roast roast;
    CookingMethod cookingMethod;
    AdditionalIngredient additionalIngredient;
}
