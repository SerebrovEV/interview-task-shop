package com.task.shop.api.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String title;
    private String description;
    private Float price;
    private Integer amount;
    private Byte rating;
    private Long organizationId;
}
