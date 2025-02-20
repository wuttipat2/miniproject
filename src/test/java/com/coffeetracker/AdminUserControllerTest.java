package com.coffeetracker;

import com.coffeetracker.controller.AdminUserController;
import com.coffeetracker.dto.AdminUserData;
import com.coffeetracker.dto.GetAdminUserRequest;
import com.coffeetracker.service.AdminUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.coffeetracker.constant.ResponseConstants.Status.STATUS_SUCCESS;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {AdminUserController.class})
class AdminUserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    AdminUserService adminUserService;

    @Test
    void givenValidUsername_whenGetAdminUser_thenReturnSuccessResponse() throws Exception {
        var request = GetAdminUserRequest.builder()
                .username("john.doe")
                .build();
        AdminUserData userData = AdminUserData.builder()
                .username(request.getUsername())
                .fullName("John Doe")
                .orgName("TechCorp")
                .email("john.doe@example.com")
                .build();

        when(adminUserService.getAdminUserByUsername(any())).thenReturn(userData);

        mockMvc.perform(post("/api/admin-user/get")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(STATUS_SUCCESS))
                .andExpect(jsonPath("$.data.username").value(request.getUsername()))
                .andExpect(jsonPath("$.data.fullName").value("John Doe"))
                .andExpect(jsonPath("$.data.orgName").value("TechCorp"))
                .andExpect(jsonPath("$.data.email").value("john.doe@example.com"));
    }

    @Test
    void givenEmptyUsername_whenGetAdminUser_thenReturnEmptyData() throws Exception {
        var request = GetAdminUserRequest.builder().build();

        mockMvc.perform(post("/api/admin-user/get")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(STATUS_SUCCESS))
                .andExpect(jsonPath("$.data.username").doesNotExist());
    }

    @Test
    void givenUsernameNotFound_whenGetAdminUser_thenReturnEmptyData() throws Exception {
        var request = GetAdminUserRequest.builder()
                .username("nonexistent.user")
                .build();

        when(adminUserService.getAdminUserByUsername(any())).thenReturn(null);

        mockMvc.perform(post("/api/admin-user/get")
                        .header("Authorization", "Bearer token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(STATUS_SUCCESS))
                .andExpect(jsonPath("$.data.username").doesNotExist());
    }
}
