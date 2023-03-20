package com.example.shop.organization.dto;

import lombok.Data;

@Data
public class OrganizationDto {

    private Long id;
    private String name;
    private String description;
    private String image;
    private Long userId;

}
