package com.task.shop.api.client;

import com.task.shop.api.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProductClient {
    @Value("${url.product}")
    private String uriProduct;

    private final RestTemplate restTemplate;
    private final UserClient userClient;

    public ResponseEntity<ProductDto> getProduct(Long id) {
        return restTemplate.getForEntity(uriProduct + id.toString(), ProductDto.class);
    }

    public ResponseEntity<ProductListDto> getAllProduct() {
        return restTemplate.getForEntity(uriProduct + "/all", ProductListDto.class);
    }


    public ResponseEntity<ProductDto> updateProduct(Long productId, ProductDto productDto) {
        return ResponseEntity.ok(restTemplate.patchForObject(uriProduct + productId, productDto, ProductDto.class));
    }

    public ResponseEntity<DiscountDto> addDiscount(String productId, DiscountDto discountDto) {
        return ResponseEntity.ok(restTemplate.postForObject(
                uriProduct + productId + "/discount",
                discountDto,
                DiscountDto.class));
    }

    public DiscountDto updateDiscount(Long productId, Long discId, DiscountDto discountDto) {
        return ResponseEntity.ok(restTemplate.patchForObject(
                uriProduct + productId + "/discount/" + discId,
                discountDto,
                DiscountDto.class)).getBody();
    }


    public CommentDto addComment(Long productId, CommentDto commentDto, Authentication authentication) {
        UserDto user = userClient.getUserByName(authentication.getName());
        commentDto.setUserId(user.getId());
        return restTemplate.postForEntity(uriProduct + productId + "/comment",
                commentDto,
                CommentDto.class)
                .getBody();
    }

    public CommentDto getComment(Long productId, CommentDto commentId) {
        return restTemplate.getForEntity(uriProduct + productId + "/comment/" + commentId, CommentDto.class).getBody();
    }

    public void deleteCommentByUser(Long productId, Long commentId, Authentication authentication) {
        UserDto user = userClient.getUserByName(authentication.getName());
        restTemplate.delete(uriProduct + productId + "/comment/" + commentId + "/user/" + user.getId());
    }

    public CommentDto updateCommentByUser(Long productId, Long commentId, CommentDto commentDto, Authentication authentication) {
        UserDto user = userClient.getUserByName(authentication.getName());
        commentDto.setUserId(user.getId());
        return restTemplate.patchForObject(
                uriProduct + productId + "/comment/" + commentId,
                commentDto,
                CommentDto.class);
    }

    public ProductDto addRating(Long productId, ProductDto productDto) {
        return restTemplate.patchForObject(
                uriProduct + productId + "/rating",
                productDto,
                ProductDto.class);
    }
}
