package com.task.shop.api.service;

import com.task.shop.api.dto.RegisterReq;
import com.task.shop.api.dto.Role;

public interface AuthService {
    boolean login(String userName, String password);
    boolean register(RegisterReq registerReq, Role role);
}
