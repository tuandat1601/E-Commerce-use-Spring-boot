package com.bootcamp.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.library.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
