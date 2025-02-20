package com.coffeetracker.mapper;

import com.coffeetracker.Entity.AdminUserPermission;
import com.coffeetracker.dto.AdminUserDTO;
import com.coffeetracker.dto.AdminUserData;
import com.coffeetracker.dto.AdminUserProjection;
import com.coffeetracker.dto.CreateAdminUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminUserMapper {
    AdminUserMapper INSTANCE = Mappers.getMapper(AdminUserMapper.class);

    AdminUserData toAdminUserDTO(AdminUserProjection projection);

    AdminUserPermission toEntity(CreateAdminUserRequest dto);

    AdminUserDTO toDTO(AdminUserPermission entity);
}
