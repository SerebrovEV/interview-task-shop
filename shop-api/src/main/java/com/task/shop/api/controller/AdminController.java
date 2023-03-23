package com.task.shop.api.controller;

import com.task.shop.api.client.OrderClient;
import com.task.shop.api.client.ProductClient;
import com.task.shop.api.client.UserClient;
import com.task.shop.api.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final OrderClient orderClient;
    private final ProductClient productClient;
    private final UserClient userClient;

    /**
     * Админ может добавлять и изменять любую информацию о товарах в магазине +
     *
     * @param productDto
     * @return
     */
    @PatchMapping("/product/{productId}")
    public ResponseEntity<ProductDto> correctionProduct(@RequestBody ProductDto productDto,
                                                        @PathVariable Long productId) {
        return ResponseEntity.ok(productClient.updateProduct(productId, productDto).getBody());
    }

    /**
     * Для товара или группы товаров админ может добавлять скидки +-
     *
     * @param discountDto
     * @return
     */
    @PostMapping("/product/{productId}/discount")
    public ResponseEntity<DiscountDto> addDiscount(@RequestBody DiscountDto discountDto,
                                                   @PathVariable String productId) {
        return ResponseEntity.ok(productClient.addDiscount(productId, discountDto).getBody());
    }

    /**
     * Для товара или группы товаров админ может изменять скидки +-
     *
     * @param discountDto
     * @param
     * @return
     */
    @PatchMapping("/product/{productId}/discount/{discId}")
    public ResponseEntity<DiscountDto> addDiscount(@RequestBody DiscountDto discountDto,
                                                   @PathVariable Long productId,
                                                   @PathVariable Long discId) {
        return ResponseEntity.ok(productClient.updateDiscount(productId, discId, discountDto));
    }

    /**?????????
     * Админ может просмотреть историю покупок любого пользователя;+
     *
     * @param userId
     * @param orderId
     * @return
     */
    @GetMapping("/user/{userId}/order")
    public ResponseEntity getOrderByUserId(@PathVariable Long userId,
                                           @RequestParam(required = false) Long orderId) {
        if (orderId.equals(null)) {
            return ResponseEntity.ok(orderClient.getAllOrder());
        }
        return ResponseEntity.ok(orderClient.getOrder(userId, orderId).getBody());
    }

    /**
     * Aдмин может пополнять баланс пользователя+
     *
     * @param
     * @return
     */
    @PatchMapping("/user/{userId}/balance")
    public ResponseEntity<UserDto> addToUserBalance(@PathVariable Long userId,
                                                    @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userClient.addToUserBalance(userId, userDto).getBody());
    }

    /**
     * Админ может просматривать информацию о пользователях+
     *
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userClient.getUser(userId).getBody());
    }

    /**
     * Админ может удалять пользователя+
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userClient.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    /**
     * Админ может замораживать аккаунты +
     *
     * @param userId
     * @param userDto
     * @return
     */
    @PatchMapping("/user/{userId}/status")
    public ResponseEntity<UserDto> changeStatusUser(@PathVariable Long userId,
                                                    @RequestBody UserDto userDto) {
        return userClient.updateUserStatus(userId, userDto);
    }

    /**
     * Админ может отправлять пользователю уведомления
     *
     * @param userId
     * @param notificationDto
     * @return
     */
    @PostMapping("/user/{userId}/notification")
    public ResponseEntity<NotificationDto> sendNotification(@PathVariable Long userId,
                                                            @RequestBody NotificationDto notificationDto) {
        return ResponseEntity.ok(notificationDto);
    }

    /**
     * Админ вправе принимать заявки на регистрацию организации, замораживать организации
     *
     * @param orgId
     * @param status
     * @return
     */
    @PatchMapping("/organization/{orgId}/status")
    public ResponseEntity<OrganizationDto> changeStatusOrganization(@PathVariable Long orgId,
                                                                    @RequestParam Boolean status) {
        return ResponseEntity.ok().build();
    }

    /**
     * Админ вправе удалять активные организации
     *
     * @param orgId
     * @return
     */
    @DeleteMapping("/organization/{orgId}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long orgId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Получение информации об организации
     *
     * @param orgId
     * @return
     */
    @GetMapping("/organization/{orgId}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable Long orgId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Изменение статуса продукта
     *
     * @param orgId
     * @param productId
     * @param status
     * @return
     */
    @PatchMapping("/organization/{orgId}/product/{productId}/status")
    public ResponseEntity changeStatusProduct(@PathVariable Long orgId,
                                              @PathVariable Long productId,
                                              @RequestParam Boolean status) {
        return ResponseEntity.ok().build();
    }
}
