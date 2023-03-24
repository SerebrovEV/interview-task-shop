package com.task.shop.order.repository;

import com.task.shop.order.entity.OrderEntity;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByIdAndUserId(Long orderId, Long userId);

    Optional<OrderEntity> findByUserIdAndStatus(Long userId, Boolean status);
}
