package com.coffeetracker.mapper;

import com.coffeetracker.dto.CoffeeBeanDTO;
import com.coffeetracker.Entity.CoffeeBean;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CoffeeBeanMapper {
    CoffeeBeanMapper INSTANCE = Mappers.getMapper(CoffeeBeanMapper.class);
    CoffeeBeanDTO toDTO(CoffeeBean coffeeBean);
    CoffeeBean toEntity(CoffeeBeanDTO coffeeBeanDTO);
}
