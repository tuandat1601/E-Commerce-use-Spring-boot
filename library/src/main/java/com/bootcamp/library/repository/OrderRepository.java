package com.bootcamp.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.library.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
