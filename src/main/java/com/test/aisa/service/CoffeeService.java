package com.test.aisa.service;

import com.test.aisa.database.entity.Coffee;
import com.test.aisa.database.enums.AdditionalIngredient;
import com.test.aisa.database.enums.CookingMethod;
import com.test.aisa.database.enums.Roast;
import com.test.aisa.database.repository.CoffeeRepository;
import com.test.aisa.dto.CoffeeDto;
import com.test.aisa.factory.CoffeeFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final CoffeeFactory coffeeFactory = CoffeeFactory.getInstance();

    public Optional<Coffee> findById(Integer id) {
        return coffeeRepository.findById(id);
    }

    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    public Coffee createCoffee(CoffeeDto coffeeDto) {

        if (coffeeDto.getName() == null || coffeeDto.getName().isBlank())
            throw new RuntimeException("Coffee name is incorrect");

        Coffee coffee;

        try {
            coffee = coffeeFactory.createCoffee(coffeeDto);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        coffeeRepository.save(coffee);
        return coffee;
    }
}
