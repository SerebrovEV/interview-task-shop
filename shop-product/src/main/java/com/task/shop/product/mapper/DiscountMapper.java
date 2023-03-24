package com.task.shop.product.mapper;

import com.task.shop.product.dto.DiscountDto;
import com.task.shop.product.entity.DiscountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscountMapper {
    DiscountDto entityToDto(DiscountEntity discountEntity);
    DiscountEntity dtoToEntity(DiscountDto discountDto);
}
