package com.bootcamp.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.library.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
