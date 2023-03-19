package com.task.shop.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class DiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer percentDiscount;
    private Integer periodDiscount;

    @OneToMany(mappedBy = "discount")
    private Collection<ProductEntity> products;

}
