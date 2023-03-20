package com.task.shop.user.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String mail;

    private String password;
    private BigDecimal balance;

    @Column(name = "active")
    private Boolean activeStatus;

    private String role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<NotificationEntity> notifications;
}
