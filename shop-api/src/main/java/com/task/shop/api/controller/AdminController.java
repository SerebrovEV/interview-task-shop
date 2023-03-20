package com.task.shop.api.controller;

import com.task.shop.api.client.OrderClient;
import com.task.shop.api.client.ProductClient;
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
    /**
     * Админ может добавлять и изменять любую информацию о товарах в магазине +
     *
     * @param productDto
     * @return
     */
    @PatchMapping("/product/{productId}")
    public ResponseEntity<ProductDto> correctionProduct(@RequestBody ProductDto productDto,
                                                        @PathVariable Long productId) {
        return ResponseEntity.ok(productClient.updateProduct(productId, productDto));
    }

    /**
     * Для товара или группы товаров админ может добавлять скидки
     *
     * @param discountDto
     * @return
     */
    @PostMapping("/discount/")
    public ResponseEntity<DiscountDto> addDiscount(@RequestBody DiscountDto discountDto) {
        return ResponseEntity.ok(discountDto);
    }

    /**
     * Для товара или группы товаров админ может изменять скидки
     *
     * @param discountDto
     * @param id
     * @return
     */
    @PatchMapping("/discount/{id}")
    public ResponseEntity<DiscountDto> addDiscount(@RequestBody DiscountDto discountDto,
                                                   @PathVariable Long id) {
        return ResponseEntity.ok(discountDto);
    }

    /**
     * Админ может просмотреть историю покупок любого пользователя;
     *
     * @param userId
     * @param orderId
     * @return
     */
    @GetMapping("/user/{userId}/order")
    public ResponseEntity<OrderDto> getOrderByUserId(@PathVariable Long userId,
                                                     @RequestParam(required = false) Long orderId) {
        return ResponseEntity.ok(new OrderDto());
    }

    /**
     * Aдмин может пополнять баланс пользователя
     *
     * @param count
     * @return
     */
    @PatchMapping("/user/balance")
    public ResponseEntity<UserDto> addToUserBalance(@RequestParam BigDecimal count) {
        return ResponseEntity.ok().build();
    }

    /**
     * Админ может просматривать информацию о пользователях
     *
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(new UserDto());
    }

    /**
     * Админ может удалять пользователя
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Админ может замораживать аккаунты
     *
     * @param userId
     * @param status
     * @return
     */
    @PatchMapping("/user/{userId}/status")
    public ResponseEntity<UserDto> changeStatusUser(@PathVariable Long userId,
                                                    @RequestParam Boolean status) {
        return ResponseEntity.ok().build();
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
     * @param orgId
     * @return
     */
    @DeleteMapping("/organization/{orgId}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long orgId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Получение информации об организации
     * @param orgId
     * @return
     */
    @GetMapping("/organization/{orgId}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable Long orgId) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/organization/{orgId}/product/{productId}/status")
    public ResponseEntity changeStatusProduct(@PathVariable Long orgId,
                                              @PathVariable Long productId,
                                              @RequestParam Boolean status){
        return ResponseEntity.ok().build();
    }
}
