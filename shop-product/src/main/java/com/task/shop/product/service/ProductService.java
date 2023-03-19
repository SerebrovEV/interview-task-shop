package com.task.shop.product.service;

import com.task.shop.product.dto.ProductDto;
import com.task.shop.product.dto.ProductListDto;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);

    ProductDto getProduct(Long id);

    ProductDto updateProduct(ProductDto productDto);

    void deleteProduct(Long id);

    ProductListDto getAllProduct();
}
