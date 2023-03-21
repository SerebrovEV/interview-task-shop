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

    @Column(unique = true, name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "raiting")
    private Byte rating;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "organization_id")
    private Long organizationId;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<CommentEntity> comments;

    @ManyToMany
    private Collection<TagsEntity> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private DiscountEntity discount;
}
