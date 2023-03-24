package com.task.shop.api.dto;

import lombok.Data;

@Data
public class LoginReq {
    private String password;
    private String username;

}