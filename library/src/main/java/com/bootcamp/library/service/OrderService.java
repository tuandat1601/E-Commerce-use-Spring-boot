package com.bootcamp.library.service;

import java.util.List;

import com.bootcamp.library.model.Order;
import com.bootcamp.library.model.ShoppingCart;

public interface OrderService {
	 	Order save(ShoppingCart shoppingCart);

	    List<Order> findAll(String username);

	    List<Order> findALlOrders();

	    Order acceptOrder(Long id);

	    void cancelOrder(Long id);
}
