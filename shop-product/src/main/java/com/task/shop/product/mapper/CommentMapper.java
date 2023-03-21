package com.task.shop.product.mapper;

import com.task.shop.product.dto.CommentDto;
import com.task.shop.product.entity.CommentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto entityToDto(CommentEntity commentEntity);

    CommentEntity dtoToEntity(CommentDto commentDto);
}
