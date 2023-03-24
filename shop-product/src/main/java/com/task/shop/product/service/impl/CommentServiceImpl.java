package com.task.shop.product.service.impl;

import com.task.shop.product.dto.CommentDto;
import com.task.shop.product.entity.CommentEntity;
import com.task.shop.product.mapper.CommentMapper;
import com.task.shop.product.repository.CommentRepository;
import com.task.shop.product.repository.ProductRepository;
import com.task.shop.product.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentDto addComment(Long productId, CommentDto commentDto) {
        CommentEntity newComment = commentMapper.dtoToEntity(commentDto);
        newComment.setProduct(productRepository.findById(productId).get());
        newComment = commentRepository.save(newComment);
        return commentMapper.entityToDto(newComment);
    }

    @Override
    public CommentDto getComment(Long productId, Long commentId) {
        CommentEntity findComment = commentRepository.findByIdAndProduct_Id(commentId, productId).get();
        return commentMapper.entityToDto(findComment);
    }

    @Override
    public CommentDto updateComment(Long productId, Long commentId, CommentDto commentDto) {
        CommentEntity findComment = commentRepository.findByIdAndProduct_Id(commentId, productId).get();
        if (findComment.getUserId().equals(commentDto.getUserId())){
            findComment.setMessage(commentDto.getMessage());
            commentRepository.save(findComment);
            return commentMapper.entityToDto(findComment);
        }
        throw new RuntimeException();
    }

    @Override
    public void deleteComment(Long productId, Long commentId) {
        commentRepository.deleteById(productId);
    }
}
