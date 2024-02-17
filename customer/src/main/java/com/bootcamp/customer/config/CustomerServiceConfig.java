package com.bootcamp.customer.config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bootcamp.library.model.Customer;
import com.bootcamp.library.repository.CustomerRepository;

public class CustomerServiceConfig implements UserDetailsService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByUserName(username);
		if(customer==null) {
			   throw new UsernameNotFoundException("Could not find username");
        }
        return new User(
                customer.getUserName(),
                customer.getPassword(),
                customer.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
	}

}
