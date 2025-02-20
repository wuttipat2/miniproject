package com.coffeetracker.dto.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationResponse {
    private Integer status;
    private Error error;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Error {
        private Integer code;
        private String message;
    }
}

