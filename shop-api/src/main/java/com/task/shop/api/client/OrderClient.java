package com.task.shop.api.client;

import com.task.shop.api.dto.OrderDto;
import com.task.shop.api.dto.OrderListDto;
import com.task.shop.api.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@Component
@RequiredArgsConstructor
public class OrderClient {
    @Value("${url.order}")
    private URI uriOrder;
    private final UserClient userClient;
    private final RestTemplate restTemplate;

    public OrderDto addOrder(Long userId, Long productId) {
        return restTemplate.getForObject(uriOrder + userId.toString() + "/product/" + productId.toString(), OrderDto.class);
    }

    public ResponseEntity<OrderDto> getOrderByUser(Long userId, Long orderId, Authentication authentication) {
        UserDto userDto = userClient.getUserByName(authentication.getName());
        if (userDto.getId().equals(userId) || userDto.getRole().equals("ADMIN")) {
            return ResponseEntity.ok(restTemplate.getForEntity(
                    uriOrder + orderId.toString() + "/user/" + userId,
                    OrderDto.class).getBody());
        } else {
            throw new RuntimeException();
        }
    }

    public OrderListDto getAllOrder() {
        return restTemplate.getForEntity(uriOrder + "all", OrderListDto.class).getBody();
    }

    public ResponseEntity<OrderListDto> getAllOrdersByUser(Long userId, Authentication authentication) {
        UserDto user = userClient.getUserByName(authentication.getName());
        if (user.getId().equals(userId) || user.getRole().equals("ADMIN")) {
            return restTemplate.getForEntity(uriOrder + userId.toString() + "all", OrderListDto.class);
        }
        throw new RuntimeException();
    }
}
