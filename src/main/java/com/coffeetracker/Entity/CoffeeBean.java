package com.coffeetracker.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "coffee_beans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String variety;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String originCountry;

    private Double cuppingScore;

    @Column(nullable = false)
    private Double price;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}

