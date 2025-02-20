package com.coffeetracker.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {
    private Long coffeeBeanId;
    private String coffeeBeanName;
    private int quantity;
    private Double totalPrice;
}
