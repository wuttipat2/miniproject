package com.coffeetracker.service;

import com.coffeetracker.Entity.AdminUserPermission;
import com.coffeetracker.dto.AdminUserData;
import com.coffeetracker.dto.CreateAdminUserRequest;
import com.coffeetracker.mapper.AdminUserMapper;
import com.coffeetracker.repository.AdminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserService {
    private final AdminUserRepository adminUserRepository;

    public AdminUserData getAdminUserByUsername(String username) {
        var query = adminUserRepository.findByUsername(username).orElse(null);
        return AdminUserMapper.INSTANCE.toAdminUserDTO(query);
    }

    public Integer createAdminUser(CreateAdminUserRequest request) {
        var adminEntity = AdminUserMapper.INSTANCE.toEntity(request);
        AdminUserPermission savedUser = adminUserRepository.save(adminEntity);
        return savedUser.getId();
    }
}

