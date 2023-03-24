package com.task.shop.product.mapper;

import com.task.shop.product.dto.TagsDto;
import com.task.shop.product.entity.TagsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagsDto entityToDto(TagsEntity tagsEntity);
    TagsEntity dtoToEntity(TagsDto tagsDto);
}
