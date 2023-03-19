package com.task.shop.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String mail;
    private String password;
    private BigDecimal balance;
    private String role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<NotificationEntity> notifications;
}
