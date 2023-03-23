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
     * Запрос продукта по id
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
     * Добавление товара в корзину -
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
     * Удаление товара из корзины -
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
     * Оплата корзины -
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
     * Добавление комментария к продукту + (добавить проверку на покупку)
     *
     * @param productId
     * @return
     */
    @PostMapping("/product/{productId}/comment")
    public ResponseEntity<CommentDto> addComment(@PathVariable Long productId,
                                                 @RequestBody CommentDto commentDto,
                                                 Authentication authentication) {
        return ResponseEntity.ok(productClient.addComment(productId, commentDto, authentication));
    }

    /**
     * Получение комментария +
     *
     * @param productId
     * @param commentId
     * @return
     */
    @GetMapping("/product/{productId}/comment/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long productId,
                                                 @PathVariable CommentDto commentId) {
        return ResponseEntity.ok(productClient.getComment(productId, commentId));
    }

    /**
     * Обновление комментария +
     *
     * @param productId
     * @param commentId
     * @param commentDto
     * @return
     */
    @PatchMapping("/product/{productId}/comment/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long productId,
                                                    @PathVariable Long commentId,
                                                    @RequestBody CommentDto commentDto,
                                                    Authentication authentication) {
        return ResponseEntity.ok(productClient.updateCommentByUser(productId, commentId, commentDto, authentication));
    }

    /**
     * Удаление комментария +
     *
     * @param productId
     * @param commentId
     * @return
     */
    @DeleteMapping("/product/{productId}/comment/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Long productId,
                                        @PathVariable Long commentId,
                                        Authentication authentication) {
        productClient.deleteCommentByUser(productId, commentId, authentication);
        return ResponseEntity.ok().build();
    }

    /**
     * Добавление рейтинга продукции + (добавить проверку на покупку)
     *
     * @param productId
     * @return
     */
    @PatchMapping("/product/{productId}/rating")
    public ResponseEntity addRating(@PathVariable Long productId,
                                    @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productClient.addRating(productId, productDto));
    }

    /**
     * Запрос заказа/всех заказов
     *
     * @param userId
     * @param orderId
     * @return
     */
    @GetMapping("/user/{userId}/order")
    public ResponseEntity getOrderById(@PathVariable Long userId,
                                       @RequestParam(required = false) Long orderId,
                                       Authentication authentication) {
        if (orderId.equals(null)) {
            return orderClient.getAllOrderByUser(userId, authentication);
        } else {
            return orderClient.getOrderByUser(userId, orderId, authentication);
        }
    }

    /**
     * Возврат покупки
     *
     * @param userId
     * @param orderId
     * @return
     */
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
     * Получение информации организации
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

    /**
     * Обновление информации об организации
     *
     * @param userId
     * @param orgId
     * @param organizationDto
     * @return
     */
    @PatchMapping("/user/{userId}/organization/{orgId}")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable Long userId,
                                                              @PathVariable Long orgId,
                                                              @RequestBody OrganizationDto organizationDto) {
        return ResponseEntity.ok(organizationClient.updateOrganization(userId, orgId, organizationDto));
    }

    /**
     * Удаление организации
     *
     * @param orgId
     * @return
     */
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
