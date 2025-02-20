package com.coffeetracker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAdminUserRequest {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}
