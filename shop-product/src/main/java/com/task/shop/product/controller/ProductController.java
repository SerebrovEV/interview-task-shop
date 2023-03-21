package com.task.shop.product.controller;

import com.task.shop.product.dto.CommentDto;
import com.task.shop.product.dto.DiscountDto;
import com.task.shop.product.dto.ProductDto;
import com.task.shop.product.dto.ProductListDto;
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
    public ResponseEntity<ProductListDto> getAllProduct() {
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

    @PostMapping("/{productId}/discount")
    public ResponseEntity<DiscountDto> addDiscount(@PathVariable Long productId,
                                                   @RequestBody DiscountDto discountDto) {
        return ResponseEntity.ok(discountService.addDiscount(productId, discountDto));
    }

    @PatchMapping("/{productId}/discount/{discId}")
    public ResponseEntity<DiscountDto> updateDiscount(@PathVariable Long productId,
                                                      @PathVariable Long discId,
                                                      @RequestBody DiscountDto discountDto) {
        return ResponseEntity.ok(discountService.updateDiscount(discId, discountDto));
    }

    @PostMapping("/{productId}/comment")
    public ResponseEntity<CommentDto> addComment(@PathVariable Long productId,
                                                 @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.addComment(productId, commentDto));
    }

    @DeleteMapping("/{productId}/comment/{commentId}")
    public ResponseEntity<CommentDto> deleteProduct(@PathVariable Long productId,
                                                    @PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.deleteComment(productId, commentId));
    }

    @PatchMapping("/{productId}/comment/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long productId,
                                                    @PathVariable Long commentId,
                                                    @RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentService.updateComment(productId, commentId, commentDto));
    }

    @GetMapping("/{productId}/comment/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long productId,
                                                 @PathVariable Long commentId){
        return ResponseEntity.ok(commentService.getComment(productId, commentId));
    }

}
