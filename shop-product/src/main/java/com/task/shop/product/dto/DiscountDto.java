package com.task.shop.product.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class DiscountDto {
    private Long id;
    private Integer percentDiscount;
    private Integer periodDiscount;
}
