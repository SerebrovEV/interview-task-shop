package com.task.shop.api.dto;

import lombok.Data;

@Data
public class NotificationDto {
    private Long id;
    private String title;
    private String description;
    private String createAt;
    private Long userId;
}
