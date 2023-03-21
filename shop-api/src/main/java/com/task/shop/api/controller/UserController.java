package com.task.shop.api.controller;

import com.task.shop.api.client.OrderClient;
import com.task.shop.api.client.OrganizationClient;
import com.task.shop.api.client.ProductClient;
import com.task.shop.api.dto.*;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final OrganizationClient organizationClient;
    private final OrderClient orderClient;
    private final ProductClient productClient;

    /**
     * Запрос продута +
     *
     * @return
     */

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        return productClient.getProduct(productId);
    }

    /**
     * Запрос списка всех продуктов +
     *
     * @return
     */
    @GetMapping("/product/all")
    public ResponseEntity getAllProduct() {
        return ResponseEntity.ok(productClient.getAllProduct());
    }

    /**
     * Добавление товара в корзину ?
     *
     * @param userId
     * @param productId
     * @return
     */
    @GetMapping("/user/{userId}/order/{productId}")
    public ResponseEntity<OrderDto> addProductToOrder(@PathVariable Long userId,
                                                      @PathVariable Long productId) {
        return ResponseEntity.ok(orderClient.addOrder(userId, productId));
    }

    /**
     * Удаление товара из корзины
     *
     * @param userId
     * @param productId
     * @return
     */
    @DeleteMapping("/user/{userId}/order/{productId}")
    public ResponseEntity<OrderDto> deleteProductToOrder(@PathVariable Long userId,
                                                         @PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Оплата корзины
     *
     * @param userId
     * @param productId
     * @return
     */
    @PatchMapping("/user/{userId}/order/pay")
    public ResponseEntity<OrderDto> payOrder(@PathVariable Long userId,
                                             @PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Добавление комментария к заказу
     *
     * @param productId
     * @return
     */
    @PostMapping("/product/{productId}/comment")
    public ResponseEntity addComment(@PathVariable Long productId,
                                     @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok().build();
    }

    /**
     * Получение комментария
     *
     * @param productId
     * @param commentId
     * @return
     */
    @GetMapping("/product/{productId}/comment/{commentId}")
    public ResponseEntity getComment(@PathVariable Long productId,
                                     @PathVariable CommentDto commentId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Обновление комментария
     *
     * @param productId
     * @param commentId
     * @param commentDto
     * @return
     */
    @PatchMapping("/product/{productId}/comment/{commentId}")
    public ResponseEntity updateComment(@PathVariable Long productId,
                                        @PathVariable Long commentId,
                                        @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok().build();
    }

    /**
     * Удаление комментария
     *
     * @param productId
     * @param commentId
     * @return
     */
    @DeleteMapping("/product/{productId}/comment/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Long productId,
                                        @PathVariable Long commentId) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/product/{productId}")
    public ResponseEntity addRating(@PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Запрос заказа/всех заказов
     *
     * @param userId
     * @param orderId
     * @return
     */
    @GetMapping("/user/{userId}/order")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long userId,
                                                 @RequestParam(required = false) Long orderId) {
        return orderClient.getOrder(orderId);
    }

    @PatchMapping("/user/{userId}/order/{orderId}")
    public ResponseEntity returnOrder(@PathVariable Long userId,
                                      @PathVariable Long orderId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Получение списка всех уведомлений
     *
     * @return
     */
    @GetMapping("/user/{userId}/notification")
    public ResponseEntity<List<NotificationDto>> getAllNotification(@PathVariable Long userId,
                                                                    @RequestParam(required = false) Long notId) {
        return ResponseEntity.ok(new ArrayList<>());
    }


    /**
     * Запрос на регистрацию организации
     *
     * @param organizationDto
     * @return
     */
    @PostMapping("/user/{userId}/organization")
    public ResponseEntity<OrganizationDto> addOrganization(@PathVariable Long userId,
                                                           @RequestBody OrganizationDto organizationDto) {
        return organizationClient.addOrganization(userId, organizationDto);
    }

    /**
     * В работе
     *
     * @param orgId
     * @param authentication
     * @return
     */
    @GetMapping("/user/{userId}/organization/{orgId}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable Long userId,
                                                           @PathVariable Long orgId,
                                                           Authentication authentication) {
        return ResponseEntity.ok(organizationClient.getOrganization(userId, orgId, authentication.getName()));
    }

    @PatchMapping("/user/{userId}/organization/{orgId}")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable Long userId,
                                                              @PathVariable Long orgId,
                                                              @RequestBody OrganizationDto organizationDto) {
        return ResponseEntity.ok(organizationClient.updateOrganization(userId, orgId, organizationDto));
    }

    @DeleteMapping("/user/organization/{orgId}")
    public ResponseEntity<OrganizationDto> deleteOrganization(@PathVariable Long orgId) {
        return null;
    }


    /**
     * Запрос на добавление товара организацией
     *
     * @param productDto
     * @return
     */
    @PostMapping("/organization/{orgId}/product")
    public ResponseEntity<ProductDto> addProduct(@PathVariable Long orgId,
                                     @RequestBody ProductDto productDto) {
         return organizationClient.addOrganizationProduct(orgId, productDto);
    }

}
