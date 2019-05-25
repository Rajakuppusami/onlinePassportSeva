package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.model.Admin;

@Service
public class AdminServiceImplementation implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	
}
