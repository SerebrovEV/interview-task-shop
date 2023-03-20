package com.example.shop.organization.entity;

import jdk.jfr.Timestamp;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "seller_id")
    private Long userId;

    @Column(name = "active")
    private Boolean activeStatus;

    @Timestamp
    @Column(name = "create_at")
    private LocalDate createAt;
}
