package com.task.shop.user.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private String mail;
    private BigDecimal balance;
    private String role;
    private Boolean activeStatus;
}
