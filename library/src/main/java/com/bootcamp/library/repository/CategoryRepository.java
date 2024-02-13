package com.bootcamp.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.library.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>  {

}
