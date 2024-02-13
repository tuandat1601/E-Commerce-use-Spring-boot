package com.bootcamp.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.library.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>  {

}
