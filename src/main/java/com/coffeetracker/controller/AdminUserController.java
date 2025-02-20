package com.coffeetracker.controller;

import com.coffeetracker.dto.AdminUserDTO;
import com.coffeetracker.dto.AdminUserData;
import com.coffeetracker.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.coffeetracker.constant.ResponseConstants.Status.STATUS_SUCCESS;

@RestController
@RequestMapping("/api/admin-user")
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService adminUserService;

    // ✅ POST: ดึงข้อมูล Admin ตาม username
    @PostMapping
    public ResponseEntity<AdminUserDTO> getAdminUser(
//            @RequestHeader("Authorization") String authToken,
//            @RequestHeader(value = "Accept-Language", defaultValue = "EN") String language,
            @RequestBody Map<String, String> requestBody) {

        // ✅ ดึงค่า username จาก request body
        String username = requestBody.get("username");

        // ✅ ตรวจสอบว่า username มีค่าหรือไม่
        if (username == null || username.isEmpty()) {
            return ResponseEntity.ok(AdminUserDTO
                    .builder()
                    .status(STATUS_SUCCESS)
                    .data(new AdminUserData())
                    .build());
        }

        var adminUserData = adminUserService.getAdminUserByUsername(username);

        // ✅ ถ้าไม่พบข้อมูล user → data เป็น object ว่าง
        if (adminUserData == null) {
            return ResponseEntity.ok(AdminUserDTO
                    .builder()
                    .status(STATUS_SUCCESS)
                    .data(new AdminUserData())
                    .build());
        }

        // ✅ เรียก Service เพื่อดึงข้อมูล User
        var AdminUserData = adminUserService.getAdminUserByUsername(username);

        // ✅ ถ้าไม่เจอใน Database → คืน data ว่าง
        if (adminUserData == null) {
            return ResponseEntity.ok(AdminUserDTO.builder()
                    .status(STATUS_SUCCESS)
                    .data(new AdminUserData())
                    .build());
        }

        return ResponseEntity.ok(AdminUserDTO
                .builder()
                .status(STATUS_SUCCESS)
                .data(AdminUserData)
                .build());
    }
}
