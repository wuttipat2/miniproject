package com.coffeetracker.mapper;

import com.coffeetracker.dto.OrderItemDTO;
import com.coffeetracker.Entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    @Mapping(source = "coffeeBean.id", target = "coffeeBeanId")
    @Mapping(source = "coffeeBean.name", target = "coffeeBeanName")
    OrderItemDTO toDTO(OrderItem orderItem);

    @Mapping(source = "coffeeBeanId", target = "coffeeBean.id")
    OrderItem toEntity(OrderItemDTO orderItemDTO);
}
