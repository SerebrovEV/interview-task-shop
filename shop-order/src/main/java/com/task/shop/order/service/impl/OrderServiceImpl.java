package com.task.shop.order.service.impl;

import com.task.shop.order.dto.OrderDto;
import com.task.shop.order.entity.OrderEntity;
import com.task.shop.order.mapper.OrderMapper;
import com.task.shop.order.repository.OrderRepository;
import com.task.shop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public OrderDto getOrderByUser(Long orderId, Long userId) {
        OrderEntity findOrder = orderRepository.findByIdAndUserId(orderId, userId).get();
        return orderMapper.entityToDto(findOrder);
    }

    //???
    @Override
    public OrderDto addProductToOrder(Long userId, Long productId) {
        Optional<OrderEntity> order = orderRepository.findByUserIdAndStatus(userId, true);
        if(order.isEmpty()){
            OrderEntity newOrder = new OrderEntity();
            newOrder.setStatus(true);
            newOrder.setProducts(List.of());
        }
        return null;
    }

    private OrderEntity addOrderEntity(OrderEntity orderEntity) {
       return orderRepository.save(orderEntity);
    }
}
