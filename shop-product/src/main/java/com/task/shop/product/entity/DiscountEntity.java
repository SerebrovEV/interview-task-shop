package com.task.shop.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Data
@Table(name = "discounts")
public class DiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "discount")
    private Integer percentDiscount;
    @Column(name = "start_discount")
    private LocalDateTime startAt;

    @Column(name = "period")
    private Integer periodDiscount;

    @OneToMany(mappedBy = "discount")
    private Collection<ProductEntity> products;

}
