package com.task.shop.api.client;

import com.task.shop.api.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@Component
@RequiredArgsConstructor
public class OrderClient {
    @Value("${url.order}")
    private URI uriOrder;

    private final RestTemplate restTemplate;

    public OrderDto addOrder(Long userId, Long productId) {
        return restTemplate.getForObject(uriOrder+userId.toString()+"/product/"+productId.toString(),OrderDto.class);
    }

    ///{orderId}/user/{userId}
    public ResponseEntity<OrderDto> getOrderByUser(Long userId, Long orderId) {
        return ResponseEntity.ok(restTemplate.getForEntity(uriOrder+orderId.toString()+"/user/"+userId, OrderDto.class).getBody());
    }

    public ResponseEntity<OrderDto> getOrder(Long orderId) {
        return null;
    }
}
