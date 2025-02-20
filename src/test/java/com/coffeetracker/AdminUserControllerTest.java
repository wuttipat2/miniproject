package com.coffeetracker.controller;

import com.coffeetracker.dto.AdminUserDTO;
import com.coffeetracker.dto.AdminUserData;
import com.coffeetracker.service.AdminUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static com.coffeetracker.constant.ResponseConstants.Status.STATUS_SUCCESS;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)  // ✅ เปิดใช้งาน Mockito กับ JUnit 5
class AdminUserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AdminUserService adminUserService;

    @InjectMocks
    private AdminUserController adminUserController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // 🪄 เริ่มต้น Mockito
        mockMvc = MockMvcBuilders.standaloneSetup(adminUserController).build(); // 🎯 MockMvc ใช้ทดสอบ Controller โดยไม่ต้องโหลด Spring Context
    }

    @Test
    void givenValidUsername_whenGetAdminUser_thenReturnSuccessResponse() throws Exception {
        // 📝 Arrange
        String username = "john.doe";
        AdminUserData userData = AdminUserData.builder()
                .username(username)
                .fullName("John Doe")
                .orgName("TechCorp")
                .email("john.doe@example.com")
                .build();

        AdminUserDTO responseDto = AdminUserDTO.builder()
                .status(STATUS_SUCCESS)
                .data(userData)
                .build();

        when(adminUserService.getAdminUserByUsername(username)).thenReturn(userData); // 🪄 Mock Service

        // 🏃‍♂️ Act & ✅ Assert
        mockMvc.perform(post("/api/admin-user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"" + username + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(STATUS_SUCCESS))
                .andExpect(jsonPath("$.data.username").value(username))
                .andExpect(jsonPath("$.data.fullName").value("John Doe"))
                .andExpect(jsonPath("$.data.orgName").value("TechCorp"))
                .andExpect(jsonPath("$.data.email").value("john.doe@example.com"));
    }

    @Test
    void givenEmptyUsername_whenGetAdminUser_thenReturnEmptyData() throws Exception {
        // 📝 Arrange
        String emptyUsername = "";

        // 🏃‍♂️ Act & ✅ Assert
        mockMvc.perform(post("/api/admin-user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"" + emptyUsername + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(STATUS_SUCCESS))
                .andExpect(jsonPath("$.data.username").doesNotExist()); // ❗️ต้องไม่เจอ username ใน data
    }

    @Test
    void givenUsernameNotFound_whenGetAdminUser_thenReturnEmptyData() throws Exception {
        // 📝 Arrange
        String username = "nonexistent.user";

        when(adminUserService.getAdminUserByUsername(username)).thenReturn(null); // 🪄 Mock กรณีไม่เจอข้อมูล

        // 🏃‍♂️ Act & ✅ Assert
        mockMvc.perform(post("/api/admin-user")
                        .header("Authorization", "Bearer token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"" + username + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(STATUS_SUCCESS))
                .andExpect(jsonPath("$.data.username").doesNotExist()); // ❗️ไม่พบข้อมูล username
    }
}
