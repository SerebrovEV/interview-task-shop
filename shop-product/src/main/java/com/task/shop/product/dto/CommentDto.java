package com.task.shop.product.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {

    private Long id;

    private String message;

    private LocalDateTime createAt;

    private Long userId;


}
