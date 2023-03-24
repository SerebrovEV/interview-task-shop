package com.task.shop.product.service;

import com.task.shop.product.dto.DiscountDto;
import com.task.shop.product.dto.ProductDtoList;

public interface DiscountService {
    DiscountDto addDiscount(DiscountDto discountDto);

    DiscountDto updateDiscount(Long discId, DiscountDto discountDto);

    ProductDtoList addDiscountForProduct(ProductDtoList productDtoList);
}
