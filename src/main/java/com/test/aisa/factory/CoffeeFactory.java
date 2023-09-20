package com.test.aisa.factory;

import com.test.aisa.database.entity.Coffee;
import com.test.aisa.database.enums.AdditionalIngredient;
import com.test.aisa.database.enums.CookingMethod;
import com.test.aisa.database.enums.Roast;
import com.test.aisa.dto.CoffeeDto;
import com.test.aisa.mapper.CoffeeMapper;
import com.test.aisa.mapper.Mapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
public class CoffeeFactory {

    private static final CoffeeFactory INSTANCE = new CoffeeFactory();
    private final CoffeeMapper coffeeMapper = new CoffeeMapper();

    public static synchronized CoffeeFactory getInstance() {
        return INSTANCE;
    }

    public Coffee createCoffee(CoffeeDto coffeeDto) throws ClassNotFoundException {
        Coffee coffee = switch (coffeeDto.getName().toLowerCase()) {
            case "americano" -> new Americano();
            case "cappuccino" -> new Cappuccino();
            case "latte" -> new Latte();
            default -> throw new ClassNotFoundException("There is no such type of coffee");
        };

        return coffeeMapper.map(coffee, coffeeDto);
    }
}
