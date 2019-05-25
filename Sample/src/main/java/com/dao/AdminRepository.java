package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Admin;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, String> {
	
}
