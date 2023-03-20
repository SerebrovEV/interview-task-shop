package com.task.shop.order.service.impl;

import com.task.shop.order.dto.OrderDto;
import com.task.shop.order.entity.OrderEntity;
import com.task.shop.order.mapper.OrderMapper;
import com.task.shop.order.repository.OrderRepository;
import com.task.shop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        OrderEntity newOrder = orderMapper.dtoToEntity(orderDto);
        newOrder = orderRepository.save(newOrder);
        return orderMapper.entityToDto(newOrder);
    }

    @Override
    public OrderDto getOrder(Long id) {
        OrderEntity findOrder = orderRepository.findById(id).get();
        return orderMapper.entityToDto(findOrder);
    }
}
