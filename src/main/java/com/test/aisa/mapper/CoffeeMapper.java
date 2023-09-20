package com.test.aisa.mapper;

import com.test.aisa.database.entity.Coffee;
import com.test.aisa.dto.CoffeeDto;
import org.springframework.stereotype.Component;

@Component
public class CoffeeMapper implements Mapper<Coffee, CoffeeDto> {

    @Override
    public Coffee map(Coffee entity, CoffeeDto dto) {
        entity.setName(dto.getName().toLowerCase());
        entity.setRoast(dto.getRoast());
        entity.setCookingMethod(dto.getCookingMethod());
        entity.setAdditionalIngredient(dto.getAdditionalIngredient());
        return entity;
    }
}
