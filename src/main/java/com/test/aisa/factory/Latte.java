package com.test.aisa.factory;

import com.test.aisa.database.entity.Coffee;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "coffee", schema = "public")
public class Latte extends Coffee {

    @Override
    public void makeCoffee() {
        System.out.println("Latte is ready!");
    }
}
