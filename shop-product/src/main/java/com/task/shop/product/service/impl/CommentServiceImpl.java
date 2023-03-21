package com.task.shop.product.service.impl;

import com.task.shop.product.dto.CommentDto;
import com.task.shop.product.mapper.CommentMapper;
import com.task.shop.product.repository.CommentRepository;
import com.task.shop.product.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentDto addComment(Long productId, CommentDto commentDto) {
        return null;
    }

    @Override
    public CommentDto getComment(Long productId, Long commentId) {
        return null;
    }

    @Override
    public CommentDto updateComment(Long productId, Long commentId, CommentDto commentDto) {
        return null;
    }

    @Override
    public CommentDto deleteComment(Long productId, Long commentId) {
        return null;
    }
}
