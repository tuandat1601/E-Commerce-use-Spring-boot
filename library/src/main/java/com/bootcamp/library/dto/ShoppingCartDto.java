package com.bootcamp.library.dto;

import java.util.Set;

import com.bootcamp.library.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {
	private Long id;

    private Customer customer;

    private double totalPrice;

    private int totalItems;

    private Set<CartItemDto> cartItems;

}
