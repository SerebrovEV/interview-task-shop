package com.task.shop.api.controller;

import com.task.shop.api.client.OrderClient;
import com.task.shop.api.client.OrganizationClient;
import com.task.shop.api.client.ProductClient;
import com.task.shop.api.client.UserClient;
import com.task.shop.api.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final OrderClient orderClient;
    private final ProductClient productClient;
    private final UserClient userClient;
    private final OrganizationClient organizationClient;

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
     * Для товара или группы товаров админ может добавлять скидки +
     *
     * @param discountDto
     * @return
     */
    @PostMapping("/discount")
    public ResponseEntity<DiscountDto> addDiscount(@RequestBody DiscountDto discountDto) {
        return ResponseEntity.ok(productClient.addDiscount(discountDto).getBody());
    }

    /**
     * Для товара или группы товаров админ может изменять скидки +-
     *
     * @param discountDto
     * @param
     * @return
     */
    @PatchMapping("/discount/{discId}")
    public ResponseEntity<DiscountDto> updateDiscount(@RequestBody DiscountDto discountDto,
                                                      @PathVariable Long discId) {
        return ResponseEntity.ok(productClient.updateDiscount(discId, discountDto));
    }

    ///???????? в дискаунте
    @PatchMapping("/product/discount")
    public ResponseEntity<ProductDtoList> addDiscountForProduct(@RequestBody ProductDtoList productDtoList) {
        return ResponseEntity.ok(productClient.addDiscountForProducts(productDtoList));
    }

    /**
     * Админ может просмотреть историю покупок любого пользователя +
     *
     * @param userId
     * @param orderId
     * @return
     */
    @GetMapping("/user/{userId}/order")
    public ResponseEntity getOrderByUserId(@PathVariable Long userId,
                                           @RequestParam(required = false) Long orderId,
                                           Authentication authentication) {
        if (orderId == null) {
            return ResponseEntity.ok(orderClient.getAllOrdersByUser(userId, authentication));
        }
        return ResponseEntity.ok(orderClient.getOrderByUser(userId, orderId, authentication));
    }

    /**
     * Админ может запросить все заказы +
     *
     * @return
     */
    @GetMapping("/orders")
    public ResponseEntity<OrderListDto> getAllOrders() {
        return ResponseEntity.ok(orderClient.getAllOrder());
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
     * Админ может отправлять пользователю уведомления +
     *
     * @param userId
     * @param notificationDto
     * @return
     */
    @PostMapping("/user/{userId}/notification")
    public ResponseEntity<NotificationDto> sendNotification(@PathVariable Long userId,
                                                            @RequestBody NotificationDto notificationDto) {
        return ResponseEntity.ok(userClient.addNotification(userId, notificationDto));
    }

    /**
     * Админ вправе принимать заявки на регистрацию организации, замораживать организации +
     *
     * @param orgId
     * @param organizationDto
     * @return
     */
    @PatchMapping("/organization/{orgId}/status")
    public ResponseEntity<OrganizationDto> changeStatusOrganization(@PathVariable Long orgId,
                                                                    @RequestBody OrganizationDto organizationDto) {
        return ResponseEntity.ok(organizationClient.changeStatusOrganization(orgId, organizationDto));
    }

    /**
     * Админ вправе удалять активные организации +
     *
     * @param orgId
     * @return
     */
    @DeleteMapping("/organization/{orgId}")
    public ResponseEntity<OrganizationDto> deleteOrganization(@PathVariable Long orgId,
                                                              Authentication authentication) {
        return ResponseEntity.ok(organizationClient.deleteOrganization(orgId, authentication));
    }

    /**
     * Получение информации об организации +
     *
     * @param orgId
     * @return
     */
    @GetMapping("/organization/{orgId}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable Long orgId,
                                                           Authentication authentication) {
        return ResponseEntity.ok(organizationClient.getOrganization(orgId, authentication));
    }

}
