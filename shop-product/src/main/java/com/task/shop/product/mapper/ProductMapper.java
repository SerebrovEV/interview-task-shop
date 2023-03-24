package com.task.shop.product.mapper;

import com.task.shop.product.dto.ProductDto;
import com.task.shop.product.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity dtoToEntity (ProductDto productDto);

    ProductDto entityToDto (ProductEntity productEntity);

    List<ProductDto> entityToDto (List<ProductEntity> products);
    List<ProductEntity> dtoToEntity (List<ProductDto> products);

}
