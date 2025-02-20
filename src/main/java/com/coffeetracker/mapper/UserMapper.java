package com.coffeetracker.mapper;

import com.coffeetracker.dto.UserDTO;
import com.coffeetracker.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
