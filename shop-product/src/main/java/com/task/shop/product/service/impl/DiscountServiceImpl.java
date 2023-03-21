package com.task.shop.product.service.impl;

import com.task.shop.product.dto.DiscountDto;
import com.task.shop.product.entity.DiscountEntity;
import com.task.shop.product.mapper.DiscountMapper;
import com.task.shop.product.repository.DiscountRepository;
import com.task.shop.product.repository.ProductRepository;
import com.task.shop.product.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final ProductRepository productRepository;
    private final DiscountMapper discountMapper;
    @Override
    public DiscountDto addDiscount(Long id, DiscountDto discountDto) {
        DiscountEntity newDiscount = discountMapper.dtoToEntity(discountDto);
        newDiscount.setStartAt(LocalDateTime.now());
        newDiscount.setProducts(List.of(productRepository.findById(id).get()));
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
}
