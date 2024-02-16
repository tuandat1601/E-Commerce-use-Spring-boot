package com.bootcamp.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.library.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	Admin findByUserName(String username); 
}
