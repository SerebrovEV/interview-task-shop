package com.task.shop.user.service.impl;

import com.task.shop.user.dto.UserDto;
import com.task.shop.user.entity.UserEntity;
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

    @Override
    public UserDto addUser(UserDto userDto) {
        UserEntity newUser = userMapper.dtoToEntity(userDto);
        newUser = userRepository.save(newUser);
        return userMapper.entityToDto(newUser);
    }

    @Override
    public UserDto getUser(Long id) {
        UserEntity findUser = userRepository.findById(id).get();
        return userMapper.entityToDto(findUser);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        UserEntity findUser = userRepository.findById(id).get();
        return userMapper.entityToDto(findUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getByName(String userName) {
        UserEntity findUser = userRepository.findByUserName(userName).get();
        return userMapper.entityToDto(findUser);
    }
}
