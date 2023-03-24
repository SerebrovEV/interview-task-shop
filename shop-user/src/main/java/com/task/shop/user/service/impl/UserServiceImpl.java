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

    private UserEntity findUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        UserEntity newUser = userMapper.dtoToEntity(userDto);
        newUser = userRepository.save(newUser);
        return userMapper.entityToDto(newUser);
    }

    @Override
    public UserDto getUser(Long id) {
        return userMapper.entityToDto(findUser(id));
    }

    //?????
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        UserEntity findUser = findUser(id);
        findUser.setMail(userDto.getMail());

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

    @Override
    public UserDto addToBalance(Long userId, UserDto userDto) {
        UserEntity findUser = findUser(userId);
        findUser.setBalance(userDto.getBalance());
        userRepository.save(findUser);
        return userMapper.entityToDto(findUser);
    }

    @Override
    public UserDto updateUserStatus(Long userId, UserDto userDto) {
        UserEntity findUser = findUser(userId);
        findUser.setActiveStatus(userDto.getActiveStatus());
        userRepository.save(findUser);
        return userMapper.entityToDto(findUser);
    }


}
