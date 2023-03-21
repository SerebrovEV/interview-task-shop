package com.task.shop.product.service;

import com.task.shop.product.dto.DiscountDto;

public interface DiscountService {
    DiscountDto addDiscount(Long id, DiscountDto discountDto);

    DiscountDto updateDiscount(Long discId, DiscountDto discountDto);
}
