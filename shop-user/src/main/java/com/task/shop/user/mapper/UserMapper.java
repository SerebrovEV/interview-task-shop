package com.task.shop.user.mapper;

import com.task.shop.user.dto.UserDto;
import com.task.shop.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto entityToDto (UserEntity userEntity);

    UserEntity dtoToEntity(UserDto userDto);
}
