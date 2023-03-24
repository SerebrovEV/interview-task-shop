package com.task.shop.product.service.impl;

import com.task.shop.product.dto.DiscountDto;
import com.task.shop.product.dto.ProductDto;
import com.task.shop.product.dto.ProductDtoList;
import com.task.shop.product.entity.DiscountEntity;
import com.task.shop.product.entity.ProductEntity;
import com.task.shop.product.mapper.DiscountMapper;
import com.task.shop.product.mapper.ProductMapper;
import com.task.shop.product.repository.DiscountRepository;
import com.task.shop.product.repository.ProductRepository;
import com.task.shop.product.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public DiscountDto addDiscount(DiscountDto discountDto) {
        DiscountEntity newDiscount = discountMapper.dtoToEntity(discountDto);
        newDiscount.setStartAt(LocalDateTime.now());
        newDiscount = discountRepository.save(newDiscount);
        return discountMapper.entityToDto(newDiscount);
    }

    @Override
    public DiscountDto updateDiscount(Long discId, DiscountDto discountDto) {
        DiscountEntity findDiscount = discountRepository.findById(discId).get();
        findDiscount.setPercentDiscount(discountDto.getPercentDiscount());
        findDiscount.setPeriodDiscount(discountDto.getPeriodDiscount());
        discountRepository.save(findDiscount);
        return discountMapper.entityToDto(findDiscount);
    }

    //???????????????????????????????????
    @Override
    public ProductDtoList addDiscountForProduct(ProductDtoList productDtoList) {
        List<ProductDto> findProductDto = productDtoList.getProductsDto();
        List<ProductEntity> products = new ArrayList<>();

        for (int i = 0; i < productDtoList.getProductsDto().size(); i++) {
            ProductEntity productEntity = productRepository.findById(findProductDto.get(i).getId()).get();
            products.add(productEntity);

        }
        ProductDtoList list = new ProductDtoList();
        list.setProductsDto(productMapper.entityToDto(products));
        return list;
    }

    public DiscountDto getDiscount(Long id) {
        return discountMapper.entityToDto(discountRepository.findById(id).get());
    }
}
