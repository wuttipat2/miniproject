package com.coffeetracker.controller;

import com.coffeetracker.dto.OrderDTO;
import com.coffeetracker.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // ✅ GET: ดึงคำสั่งซื้อทั้งหมดของ User
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getUserOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    // ✅ GET: ดึงคำสั่งซื้อตาม ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    // ✅ POST: ให้ User สั่งซื้อสินค้า
    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    // ✅ DELETE: ยกเลิกคำสั่งซื้อ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }
}
