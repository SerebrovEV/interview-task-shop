package com.task.shop.order.mapper;

import com.task.shop.order.dto.OrderDto;
import com.task.shop.order.entity.OrderEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto entityToDto (OrderEntity orderEntity);

    OrderEntity dtoToEntity(OrderDto orderDto);
}
