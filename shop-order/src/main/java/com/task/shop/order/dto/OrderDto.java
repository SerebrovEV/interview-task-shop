package com.task.shop.order.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long id;
    private Long userId;
    private LocalDateTime createAt;
    private BigDecimal price;

}
