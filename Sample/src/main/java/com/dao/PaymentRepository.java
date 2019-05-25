package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	public List<Payment> findByApplicationId(String applicationId);
}
