package com.test.aisa.mapper;

public interface Mapper<E, D> {
    E map(E entity, D dto);
}
