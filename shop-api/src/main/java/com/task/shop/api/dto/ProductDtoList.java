package com.task.shop.api.dto;

import lombok.Data;

import java.util.Collection;
@Data
public class ProductDtoList {
    private Collection<ProductDto> products;
}
