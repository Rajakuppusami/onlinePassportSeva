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

	public List<Payment> findAllPayment() {
		// TODO Auto-generated method stub
		List<Payment> paymentList=paymentRepository.findAll();
		return paymentList;
	}

	public Payment getPaymentData(String applicationId) {
		Payment payment = null;
		List<Payment> paymentList = paymentRepository.findByApplicationId(applicationId);
		if(!paymentList.isEmpty()) {
			payment = paymentList.get(paymentList.size()-1);
		}
		return payment;
	}
	
}
