package com.coffeetracker.controller;

import com.coffeetracker.dto.AdminUserDTO;
import com.coffeetracker.dto.AdminUserData;
import com.coffeetracker.dto.CreateAdminUserRequest;
import com.coffeetracker.dto.GetAdminUserRequest;
import com.coffeetracker.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.coffeetracker.constant.ResponseConstants.Status.STATUS_SUCCESS;

@RestController
@RequestMapping("/api/admin-user")
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService adminUserService;

    @PostMapping("/get")
    public ResponseEntity<AdminUserDTO> getAdminUser(
//            @RequestHeader("Authorization") String authToken,
//            @RequestHeader(value = "Accept-Language", defaultValue = "EN") String language,
            @RequestBody GetAdminUserRequest request) {

        String username = request.getUsername();

        if (ObjectUtils.isEmpty(username)) {
            return ResponseEntity.ok(AdminUserDTO
                    .builder()
                    .status(STATUS_SUCCESS)
                    .data(new AdminUserData())
                    .build());
        }

        var adminUserData = adminUserService.getAdminUserByUsername(username);

        if (ObjectUtils.isEmpty(adminUserData)) {
            return ResponseEntity.ok(AdminUserDTO
                    .builder()
                    .status(STATUS_SUCCESS)
                    .data(new AdminUserData())
                    .build());
        }

        return ResponseEntity.ok(AdminUserDTO
                .builder()
                .status(STATUS_SUCCESS)
                .data(adminUserData)
                .build());
    }

    @PostMapping("/save")
    public ResponseEntity<Integer> createAdminUser(
//            @RequestHeader("Authorization") String authToken,
//            @RequestHeader(value = "Accept-Language", defaultValue = "EN") String language,
            @RequestBody CreateAdminUserRequest request) {
        var response = adminUserService.createAdminUser(request);

        return ResponseEntity.ok(response);
    }
}
