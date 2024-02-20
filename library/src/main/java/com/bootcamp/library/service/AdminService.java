package com.bootcamp.library.service;

import com.bootcamp.library.dto.AdminDto;
import com.bootcamp.library.model.Admin;

public interface AdminService {
	Admin findByUserName(String username);
	Admin save(AdminDto adminDto);
}
