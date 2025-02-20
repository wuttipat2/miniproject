package com.coffeetracker.mapper;

import com.coffeetracker.dto.OrderDTO;
import com.coffeetracker.Entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "user.id", target = "userId")
    OrderDTO toDTO(Order order);

    @Mapping(source = "userId", target = "user.id")
    Order toEntity(OrderDTO orderDTO);
}
