package com.task.shop.product.service.impl;

import com.task.shop.product.dto.DiscountDto;
import com.task.shop.product.dto.ProductDto;
import com.task.shop.product.dto.ProductListDto;
import com.task.shop.product.entity.DiscountEntity;
import com.task.shop.product.entity.ProductEntity;
import com.task.shop.product.mapper.DiscountMapper;
import com.task.shop.product.mapper.ProductMapper;
import com.task.shop.product.repository.ProductRepository;
import com.task.shop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private ProductEntity getProductEntity(Long userId) {
        return productRepository.findById(userId).get();
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        ProductEntity product = productRepository.save(productMapper.dtoToEntity(productDto));
        return productMapper.entityToDto(product);
    }

    @Override
    public ProductDto getProduct(Long id) {
        return productMapper.entityToDto(getProductEntity(id));
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        ProductEntity updateProduct = getProductEntity(id);
        updateProduct.setDescription(productDto.getDescription());
        updateProduct.setAmount(productDto.getAmount());
        updateProduct.setPrice(BigDecimal.valueOf(productDto.getPrice()));
        productRepository.save(updateProduct);
        return productMapper.entityToDto(updateProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        getProduct(id);
        productRepository.deleteById(id);
    }

    @Override
    public ProductListDto getAllProduct() {
        ProductListDto products = new ProductListDto();
        products.setProductsDto(productMapper.entityToDto(productRepository.findAll()));
        return products;
    }

    @Override
    public ProductDto addRating(Long productId, ProductDto productDto) {
        ProductEntity findProduct = getProductEntity(productId);
        findProduct.setRating(productDto.getRating());
        return productMapper.entityToDto(productRepository.save(findProduct));
    }

}
