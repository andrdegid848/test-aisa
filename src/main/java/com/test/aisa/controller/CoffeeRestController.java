package com.test.aisa.controller;

import com.test.aisa.database.entity.Coffee;
import com.test.aisa.dto.CoffeeDto;
import com.test.aisa.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffee-machine")
@RequiredArgsConstructor
public class CoffeeRestController {

    private final CoffeeService coffeeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Coffee> findAll() {
        return coffeeService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Coffee findById(@PathVariable("id") Integer id) {
        return coffeeService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee create(@RequestBody CoffeeDto coffeeDto) {
        return coffeeService.createCoffee(coffeeDto);
    }
}
