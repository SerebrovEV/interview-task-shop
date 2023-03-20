package com.task.shop.api.client;

import com.task.shop.api.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductClient {
    @Value("${url.product}")
    private String uriProduct;

    private final RestTemplate restTemplate;

    public ResponseEntity<ProductDto> getProduct(Long id) {
        return restTemplate.getForEntity(uriProduct.toString()+id.toString(), ProductDto.class);
    }

//    private List<ProductDto> getAllProduct() {
//         restTemplate.getForEntity(uriProduct, ResponseEntity<List<ProductDto>>);
//    }

    public ProductDto updateProduct(Long productId, ProductDto productDto) {
       return restTemplate.patchForObject(uriProduct+productId, productDto, ProductDto.class);
    }

}
