package com.example.shop.api.client;

import com.example.shop.api.dto.OrderDto;
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
    private String uriOrder;

    private final RestTemplate restTemplate;

    public ResponseEntity<OrderDto> getOrder(Long id) {
        return restTemplate.getForEntity(URI.create(uriOrder+id), OrderDto.class);
    }
}
