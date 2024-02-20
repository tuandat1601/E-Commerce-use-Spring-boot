package com.bootcamp.library.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.library.dto.AdminDto;
import com.bootcamp.library.model.Admin;
import com.bootcamp.library.repository.AdminRepository;
import com.bootcamp.library.repository.RoleRepository;
import com.bootcamp.library.service.AdminService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
	 private final AdminRepository adminRepository;
	 private final RoleRepository roleRepository;

	@Override
	public Admin findByUserName(String username) {
		// TODO Auto-generated method stub
		return adminRepository.findByUserName(username);
	}

	@Override
	public Admin save(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setFirstName(adminDto.getFirstName());
		admin.setLastName(adminDto.getLastName());
        admin.setUserName(adminDto.getUserName());
        admin.setPassword(adminDto.getPassword());
        admin.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
		return adminRepository.save(admin);
	}

}
