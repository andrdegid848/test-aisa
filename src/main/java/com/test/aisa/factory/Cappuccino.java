package com.test.aisa.factory;

import com.test.aisa.database.entity.Coffee;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "coffee", schema = "public")
public class Cappuccino extends Coffee {

    @Override
    public void makeCoffee() {
        System.out.println("Cappuccino is ready!");
    }
}
