package com.bootcamp.library.service;

import com.bootcamp.library.dto.CustomerDto;
import com.bootcamp.library.model.Customer;

public interface CustomerService {
	 	Customer save(CustomerDto customerDto);

	    Customer findByUserName(String username);

	    Customer update(CustomerDto customerDto);

	    Customer changePass(CustomerDto customerDto);

	    CustomerDto getCustomer(String username);
}
