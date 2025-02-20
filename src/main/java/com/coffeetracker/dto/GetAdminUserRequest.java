package com.coffeetracker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetAdminUserRequest {
    private String username;
}
