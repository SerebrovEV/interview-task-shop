package com.task.shop.order.controller;

import com.task.shop.order.dto.OrderDto;
import com.task.shop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @PatchMapping
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}/user/{userId}")
    public ResponseEntity<OrderDto> getOrderByUser(@PathVariable Long orderId,
                                                   @PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrderByUser(orderId, userId));
    }

    @GetMapping("/user/{userId}/product/{productId}")
    public ResponseEntity<OrderDto> addProductToOrder(@PathVariable Long userId,
                                                      @PathVariable Long productId) {
        return ResponseEntity.ok(orderService.addProductToOrder(userId, productId));
    }
}
