package com.coffeetracker.dto;

import com.coffeetracker.dto.rest.ApplicationResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AdminUserDTO extends ApplicationResponse {
    private AdminUserData data;


}

// Response
// DTO => data