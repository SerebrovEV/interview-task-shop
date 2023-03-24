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

    public ResponseEntity<ProductDtoList> getAllProduct() {
        return restTemplate.getForEntity(uriProduct + "/all", ProductDtoList.class);
    }


    public ResponseEntity<ProductDto> updateProduct(Long productId, ProductDto productDto) {
        return ResponseEntity.ok(restTemplate.patchForObject(uriProduct + productId, productDto, ProductDto.class));
    }

    public ResponseEntity<DiscountDto> addDiscount(DiscountDto discountDto) {
        return ResponseEntity.ok(restTemplate.postForObject(
                uriProduct + "discount",
                discountDto,
                DiscountDto.class));
    }

    public DiscountDto updateDiscount(Long discId, DiscountDto discountDto) {
        return ResponseEntity.ok(restTemplate.patchForObject(
                uriProduct + "discount/" + discId,
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

    public CommentDto getComment(Long productId, Long commentId) {
        return restTemplate.getForEntity(uriProduct + productId + "/comment/" + commentId, CommentDto.class).getBody();
    }

    public void deleteCommentByUser(Long productId, Long commentId, Authentication authentication) {
        UserDto user = userClient.getUserByName(authentication.getName());
        CommentDto commentDto = getComment(productId, commentId);
        if (user.getId().equals(commentDto.getUserId()) || user.getRole().equals("ADMIN")) {
            restTemplate.delete(uriProduct + productId + "/comment/" + commentId + "/user/" + user.getId());
        } else {
            throw new RuntimeException();
        }
    }

    public CommentDto updateCommentByUser(Long productId,
                                          Long commentId,
                                          CommentDto commentDto,
                                          Authentication authentication) {
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

    public ProductDtoList addDiscountForProducts(ProductDtoList productDtoList) {
        return restTemplate.postForEntity(uriProduct + "/discount/products",
                productDtoList, ProductDtoList.class).getBody();
    }
}
