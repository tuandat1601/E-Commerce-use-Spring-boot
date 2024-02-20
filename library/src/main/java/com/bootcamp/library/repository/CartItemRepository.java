package com.bootcamp.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootcamp.library.model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	 @Query(value = "update cart_items set shopping_cart_id = null where shopping_cart_id = ?1", nativeQuery = true)
	    void deleteCartItemById(Long cartId);
}
