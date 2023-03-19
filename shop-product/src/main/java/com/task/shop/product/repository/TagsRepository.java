package com.task.shop.product.repository;

import com.task.shop.product.entity.TagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<TagsEntity, Integer> {
}
