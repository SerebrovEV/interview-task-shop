package com.task.shop.user.mapper;

import com.task.shop.user.dto.NotificationDto;
import com.task.shop.user.entity.NotificationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    NotificationEntity dtoToEntity(NotificationDto notificationDto);

    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    NotificationDto entityToDto(NotificationEntity notificationEntity);

}
