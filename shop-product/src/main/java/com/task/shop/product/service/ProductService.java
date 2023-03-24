package com.task.shop.product.service;

import com.task.shop.product.dto.ProductDto;
import com.task.shop.product.dto.ProductDtoList;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);

    ProductDto getProduct(Long id);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);

    ProductDtoList getAllProduct();

    ProductDto addRating(Long productId, ProductDto productDto);
}
