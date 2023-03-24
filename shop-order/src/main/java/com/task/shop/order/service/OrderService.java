package com.task.shop.order.service;

import com.task.shop.order.dto.OrderDto;

public interface OrderService {
    OrderDto addOrder (OrderDto orderDto);

    OrderDto getOrder (Long id);

    OrderDto getOrderByUser(Long orderId, Long userId);

    OrderDto addProductToOrder(Long userId, Long productId);
}
