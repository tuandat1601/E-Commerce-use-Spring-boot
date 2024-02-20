package com.bootcamp.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootcamp.library.dto.CategoryDto;
import com.bootcamp.library.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>  {
	 @Query(value = "update Category set name = ?1 where id = ?2")
	    Category update(String name, Long id);

	    @Query(value = "select * from categories where is_activated = true", nativeQuery = true)
	    List<Category> findAllByActivatedTrue();

	    @Query(value = "select new com.bootcamp.library.dto.CategoryDto(c.id, c.name, count(p.category.id)) " +
	            "from Category c left join Product p on c.id = p.category.id " +
	            "where c.activated = true and c.deleted = false " +
	            "group by c.id ")
	    List<CategoryDto> getCategoriesAndSize();
}
