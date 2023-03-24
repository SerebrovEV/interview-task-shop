package com.task.shop.user.service;

import com.task.shop.user.dto.NotificationDto;

public interface NotificationService {
    NotificationDto addNotification(Long userId, NotificationDto notificationDto);
}
