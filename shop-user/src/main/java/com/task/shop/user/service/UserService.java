package com.task.shop.user.service;

import com.task.shop.user.dto.UserDto;

public interface UserService {
    UserDto addUser(UserDto userDto);

    UserDto getUser(Long id);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    UserDto getByName(String name);
}
