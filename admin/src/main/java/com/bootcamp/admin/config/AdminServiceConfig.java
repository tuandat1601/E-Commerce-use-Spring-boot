package com.bootcamp.admin.config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bootcamp.library.model.Admin;

import com.bootcamp.library.repository.AdminRepository;

public class AdminServiceConfig implements UserDetailsService{

	@Autowired
    private AdminRepository adminRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Admin admin = adminRepository.findByUserName(username);
		 if (admin == null) {
	            throw new UsernameNotFoundException("Could not find username");
	        }
	        return new User(
	                admin.getUserName(),
	                admin.getPassword(),
	                admin.getRoles()
	                .stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
	                       
	}

}
