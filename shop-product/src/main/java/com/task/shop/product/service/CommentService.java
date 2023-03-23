package com.task.shop.product.service;

import com.task.shop.product.dto.CommentDto;

public interface CommentService {
    CommentDto addComment(Long productId, CommentDto commentDto);
    CommentDto getComment(Long productId, Long commentId);
    CommentDto updateComment(Long productId, Long commentId, CommentDto commentDto);
    void deleteComment(Long productId, Long commentId, Long userId);

}
