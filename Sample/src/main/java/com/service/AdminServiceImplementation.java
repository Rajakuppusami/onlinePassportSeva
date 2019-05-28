package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminRepository;
import com.model.Admin;
import com.model.Applicants;
import com.model.Payment;
import com.model.Schedule;

@Service
public class AdminServiceImplementation{
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ApplicantsServiceImplementation applicantsService;
	@Autowired
	private PaymentServiceImplementation paymentservice;
	@Autowired
	private ScheduleServiceImplementation scheduleservice;
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}

	public boolean authentication(String username, String password) {
		List<Admin> adminList= adminRepository.findByUserId(username);
		if(!adminList.isEmpty()){
			System.out.println("Applicant count :"+adminList.size());
			for(Admin value:adminList){
				if(value.getPassword().equals(password)){
					return true;
				}
			}
		}
		return false;
	}

	public List<Applicants> getAllRegisterApplicant() {
		List<Applicants> applicantsList = applicantsService.findAll();
		return applicantsList;
	}

	@Transactional
	public void deleteApplicantByApplicantId(String applicantId) {
		applicantsService.deleteApplicantByApplicantId(applicantId);
	}

	public List<Payment> getAllPaymentHistory() {
		List<Payment> paymentList=paymentservice.findAllPayment();
		return paymentList;
	}

	public List<Schedule> getAllSchedules() {
		// TODO Auto-generated method stub
		List<Schedule> scheduleList = scheduleservice.findAll();
		return scheduleList;
	}
	
	
}
