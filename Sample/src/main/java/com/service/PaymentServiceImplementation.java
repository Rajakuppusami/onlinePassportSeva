package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PaymentRepository;
import com.model.Payment;

@Service
public class PaymentServiceImplementation {
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private Payment payment; 
	
	public void savePayment(String applicationId){
		payment.setApplicationId(applicationId);
		payment.setPaymentDate(new Date());
		payment.setpId((int)paymentRepository.count());
		paymentRepository.save(payment);
	}
	
	public boolean checkValidPayment(String applicationId){
		List<Payment> paymentList = paymentRepository.findByApplicationId(applicationId);
		if(paymentList.isEmpty()){
			return true;
		}
		return false;
	}
	
}
