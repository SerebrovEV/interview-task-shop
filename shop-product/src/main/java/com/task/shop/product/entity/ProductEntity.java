package com.task.shop.product.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;


@Data
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String description;
    private BigDecimal price;
    private Byte rating;
    private Integer amount;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<CommentEntity> comments;
    @ManyToMany
    private Collection<TagsEntity> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private DiscountEntity discount;
}
