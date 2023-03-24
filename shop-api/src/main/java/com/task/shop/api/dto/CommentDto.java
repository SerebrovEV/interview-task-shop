package com.task.shop.api.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;

    private String message;

    private String createAt;

    private Long userId;

}
