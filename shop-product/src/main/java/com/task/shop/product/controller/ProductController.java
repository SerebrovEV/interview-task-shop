package com.task.shop.product.controller;

import com.task.shop.product.dto.CommentDto;
import com.task.shop.product.dto.DiscountDto;
import com.task.shop.product.dto.ProductDto;
import com.task.shop.product.dto.ProductDtoList;
import com.task.shop.product.service.CommentService;
import com.task.shop.product.service.DiscountService;
import com.task.shop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductController {


    private final ProductService productService;
    private final DiscountService discountService;

    private final CommentService commentService;


    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        System.out.println(productDto.toString());
        return ResponseEntity.ok(productService.addProduct(productDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/all")
    public ResponseEntity<ProductDtoList> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id,
                                                    @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/discount")
    public ResponseEntity<DiscountDto> addDiscount(@RequestBody DiscountDto discountDto) {
        return ResponseEntity.ok(discountService.addDiscount(discountDto));
    }

    @PatchMapping("/discount/{discId}")
    public ResponseEntity<DiscountDto> updateDiscount(@PathVariable Long discId,
                                                      @RequestBody DiscountDto discountDto) {
        return ResponseEntity.ok(discountService.updateDiscount(discId, discountDto));
    }

    //???????????????????????? метод в дискаунте
    @PostMapping("/discount/products")
    public ResponseEntity<ProductDtoList> addDiscountForProduct(@RequestBody ProductDtoList productDtoList) {
        return ResponseEntity.ok(discountService.addDiscountForProduct(productDtoList));
    }

    @PostMapping("/{productId}/comment/")
    public ResponseEntity<CommentDto> addComment(@PathVariable Long productId,
                                                 @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.addComment(productId, commentDto));
    }

    @DeleteMapping("/{productId}/comment/{commentId}")
    public ResponseEntity<Void> deleteCommentByUser(@PathVariable Long productId,
                                                    @PathVariable Long commentId) {
        commentService.deleteComment(productId, commentId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{productId}/comment/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long productId,
                                                    @PathVariable Long commentId,
                                                    @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.updateComment(productId, commentId, commentDto));
    }

    @GetMapping("/{productId}/comment/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long productId,
                                                 @PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.getComment(productId, commentId));
    }

    @PatchMapping("/{productId}/rating")
    public ResponseEntity<ProductDto> addRatingForProduct(@PathVariable Long productId,
                                                          @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.addRating(productId, productDto));
    }

}
