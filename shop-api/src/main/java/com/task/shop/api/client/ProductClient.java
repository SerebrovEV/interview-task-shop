package com.task.shop.api.client;

import com.task.shop.api.dto.DiscountDto;
import com.task.shop.api.dto.ProductDto;
import com.task.shop.api.dto.ProductListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProductClient {
    @Value("${url.product}")
    private String uriProduct;

    private final RestTemplate restTemplate;

    public ResponseEntity<ProductDto> getProduct(Long id) {
        return restTemplate.getForEntity(uriProduct + id.toString(), ProductDto.class);
    }

    public ResponseEntity<ProductListDto> getAllProduct() {
        return restTemplate.getForEntity(uriProduct+"/all",ProductListDto.class);
    }


    public ResponseEntity<ProductDto> updateProduct(Long productId, ProductDto productDto) {
        return ResponseEntity.ok(restTemplate.patchForObject(uriProduct + productId, productDto, ProductDto.class));
    }

    public ResponseEntity<DiscountDto> addDiscount(String productId, DiscountDto discountDto) {
        return ResponseEntity.ok(restTemplate.postForObject(uriProduct + productId + "/discount", discountDto, DiscountDto.class));
    }

    public DiscountDto updateDiscount(Long productId, Long discId, DiscountDto discountDto) {
        return ResponseEntity.ok(restTemplate.patchForObject(
                uriProduct + productId + "/discount/" + discId,
                discountDto,
                DiscountDto.class)).getBody();
    }


}
