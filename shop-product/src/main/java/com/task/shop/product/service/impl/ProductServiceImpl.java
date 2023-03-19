package com.task.shop.product.service.impl;

import com.task.shop.product.dto.ProductDto;
import com.task.shop.product.dto.ProductListDto;
import com.task.shop.product.entity.ProductEntity;
import com.task.shop.product.mapper.ProductMapper;
import com.task.shop.product.repository.ProductRepository;
import com.task.shop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        ProductEntity product = productRepository.save(productMapper.dtoToEntity(productDto));
        return productMapper.entityToDto(product);
    }

    @Override
    public ProductDto getProduct(Long id) {
        ProductEntity findProduct = productRepository.findById(id).get();
        return productMapper.entityToDto(findProduct);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        ProductEntity updateProduct = productRepository.findById(productDto.getId()).get();
        updateProduct.setAmount(productDto.getAmount());
        updateProduct.setPrice(BigDecimal.valueOf(productDto.getPrice()));
        productRepository.save(updateProduct);
        return productMapper.entityToDto(updateProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.findById(id).get();
        productRepository.deleteById(id);
    }

    @Override
    public ProductListDto getAllProduct() {
        ProductListDto products = new ProductListDto();
        products.setProductsDto(productMapper.entityToDto(productRepository.findAll()));
        return products;
    }
}
