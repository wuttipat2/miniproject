package com.coffeetracker.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeBeanDTO {
    private Long id;
    private String name;
    private String variety;
    private String species;
    private String originCountry;
    private Double cuppingScore;
    private Double price;
}
