package com.coffeetracker.service;

import com.coffeetracker.dto.AdminUserDTO;
import com.coffeetracker.Entity.AdminUserPermission;
import com.coffeetracker.dto.AdminUserData;
import com.coffeetracker.mapper.AdminUserMapper;
import com.coffeetracker.repository.AdminUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserService {
    private final AdminUserRepository adminUserRepository;
    private final AdminUserMapper adminUserMapper;

    public AdminUserData getAdminUserByUsername(String username) {
        // ✅ Repository ควร Return `AdminUserDTO` เลย ไม่ต้องแปลงจาก Entity
        return adminUserRepository.findByUsername(username).map(adminUserMapper::toAdminUserDTO) // ✅ ใช้ Mapper ที่สร้างไว้
                .orElse(null); // คืนค่า null ถ้าไม่พบข้อมูล
    }

//    public AdminUserDTO createAdminUser(AdminUserDTO adminUserDTO) {
//        // ✅ แปลงจาก DTO -> Entity
//        AdminUserPermission userEntity = adminUserMapper.toEntity(adminUserDTO);
//
//        // ✅ บันทึกลง Database
//        AdminUserPermission savedUser = adminUserRepository.save(userEntity);
//
//        // ✅ แปลงกลับจาก Entity -> DTO และส่งกลับ
//        return adminUserMapper.toDTO(savedUser);
//    }
}

