package com.example.shop.api.controller;

import com.example.shop.api.dto.NotificationDto;
import com.example.shop.api.dto.OrderDto;
import com.example.shop.api.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    /**
     * Приветсвие
     *
     * @param authentication
     * @return
     */
    @GetMapping
    public ResponseEntity<String> sendHello(Authentication authentication) {
        return ResponseEntity.ok("Hello " + authentication.getName());
    }


    @PostMapping("/order")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto,
                                             Authentication authentication) {
        return ResponseEntity.ok(orderDto);
    }

    /**
     * Запрос определеного заказа
     *
     * @param orderId
     * @param authentication
     * @return
     */
    @GetMapping("/order/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId,
                                                 Authentication authentication) {
        return ResponseEntity.ok(new OrderDto());
    }

    /**
     * Список всех заказов пользователя
     * @param authentication
     * @return
     */
    @GetMapping("/order/all/")
    public ResponseEntity<List<OrderDto>> getAllOder(Authentication authentication) {
        return ResponseEntity.ok(new ArrayList<>());
    }

    /**
     * Получение списка всех уведомлений
     *
     * @return
     */
    @GetMapping("/notification/all")
    public ResponseEntity<List<NotificationDto>> getAllNotification(Authentication authentication) {
        return ResponseEntity.ok(new ArrayList<>());
    }

    /**
     * Запрос увдеомления по id
     * @param authentication
     * @param notId
     * @return
     */
    @GetMapping("/notification/{notId}")
    public ResponseEntity<NotificationDto> getNotificationById(Authentication authentication, @PathVariable String notId) {
        return ResponseEntity.ok(new NotificationDto());
    }

    @PostMapping("/organization")
    public ResponseEntity<OrganizationDto> applicationFoOrganization(@RequestBody OrganizationDto organizationDto) {
        return ResponseEntity.ok(new OrganizationDto());
    }
}
