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

    public ResponseEntity<OrderDto> addOrder(OrderDto orderDto) {
        return restTemplate.postForEntity(uriOrder, orderDto, OrderDto.class);
    }

    /**
     * In work
     * @param id
     * @return
     */
    public ResponseEntity<OrderDto> getOrder(Long id) {
        return restTemplate.getForEntity(uriOrder+id.toString(), OrderDto.class);
    }
}
