package com.task.shop.user.dto;

import lombok.Data;

@Data
public class NotificationDto {
    private Long id;
    private String title;
    private String description;
    private String createAt;
    private Long userId;
}
