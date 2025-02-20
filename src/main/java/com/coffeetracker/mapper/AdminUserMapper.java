package com.coffeetracker.mapper;

import com.coffeetracker.dto.AdminUserDTO;
import com.coffeetracker.Entity.AdminUserPermission;
import com.coffeetracker.dto.AdminUserData;
import com.coffeetracker.dto.AdminUserProjection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminUserMapper {
    AdminUserMapper INSTANCE = Mappers.getMapper(AdminUserMapper.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "orgName", target = "orgName")
    @Mapping(source = "email", target = "email")
    AdminUserData toAdminUserDTO(AdminUserProjection projection);
}
