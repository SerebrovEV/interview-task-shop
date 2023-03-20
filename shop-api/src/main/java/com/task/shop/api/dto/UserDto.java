package com.task.shop.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private String mail;
    private String password;
    private BigDecimal balance;
    private String role;
}
