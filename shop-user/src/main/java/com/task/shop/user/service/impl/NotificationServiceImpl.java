package com.task.shop.user.service.impl;

import com.task.shop.user.dto.NotificationDto;
import com.task.shop.user.entity.NotificationEntity;
import com.task.shop.user.mapper.NotificationMapper;
import com.task.shop.user.repository.NotificationRepository;
import com.task.shop.user.repository.UserRepository;
import com.task.shop.user.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final NotificationMapper mapper;

    @Override
    public NotificationDto addNotification(Long userId, NotificationDto notificationDto) {
        NotificationEntity newNotification = mapper.dtoToEntity(notificationDto);
        newNotification.setUser(userRepository.findById(userId).get());
        newNotification = notificationRepository.save(newNotification);
        return mapper.entityToDto(newNotification);
    }
}
