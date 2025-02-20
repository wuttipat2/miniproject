package com.coffeetracker.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "coffee_bean_id", nullable = false)
    private CoffeeBean coffeeBean;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Double unitPrice;

    @Column(nullable = false)
    private Double totalPrice;
}
