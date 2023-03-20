package com.task.shop.order.service;

import com.task.shop.order.dto.OrderDto;
import org.springframework.data.domain.Sort;

public interface OrderService {
    OrderDto addOrder (OrderDto orderDto);

    OrderDto getOrder (Long id);
}
