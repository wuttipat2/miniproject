package com.coffeetracker.service;

import com.coffeetracker.dto.OrderDTO;
import com.coffeetracker.mapper.OrderMapper;
import com.coffeetracker.Entity.Order;
import com.coffeetracker.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDTO> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        return orderMapper.toDTO(order);
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        order = orderRepository.save(order);
        return orderMapper.toDTO(order);
    }

    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
