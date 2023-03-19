package com.task.shop.user.service.impl;

import com.task.shop.user.mapper.UserMapper;
import com.task.shop.user.repository.UserRepository;
import com.task.shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
}
