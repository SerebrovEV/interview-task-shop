package com.task.shop.product.mapper;

import com.task.shop.product.dto.CommentDto;
import com.task.shop.product.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    CommentDto entityToDto(CommentEntity commentEntity);

    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    CommentEntity dtoToEntity(CommentDto commentDto);
}
