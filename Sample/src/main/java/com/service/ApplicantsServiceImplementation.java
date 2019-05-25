package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ApplicantsRepository;
import com.model.Applicants;

@Service
public class ApplicantsServiceImplementation {

	@Autowired
	private ApplicantsRepository applicantsRepository;
	
	public void saveApplicant(Applicants applicant){
		applicantsRepository.save(applicant);
	}
	
	
	public void deleteApplicant(Applicants applicant){
		applicantsRepository.deleteByApplicantId(applicant.getApplicantId());
	}
	
	public long getCount(){
		return applicantsRepository.count();
	}
	
	public boolean checkValidApplicant(Applicants applicant){
		
		List<Applicants> applicantList= applicantsRepository.findByApplicantId(applicant.getApplicantId());
		if(applicantList.isEmpty()){
			applicantList= applicantsRepository.findByEmailId(applicant.getEmailId());
				if(applicantList.isEmpty()){
					return true;
				}
		}
		System.out.println("Applicant count :"+applicantList.size());
		return false;
	}
	
	public boolean authentication(String username,String password){
		List<Applicants> applicantList= applicantsRepository.findByApplicantId(username);
		if(!applicantList.isEmpty()){
			System.out.println("Applicant count :"+applicantList.size());
			for(Applicants vaue:applicantList){
				if(vaue.getPassword().equals(password)){
					return true;
				}
			}
		}
		return false;
	}
	
	// set applicant id before and send it to update
	public void updateApplicant(Applicants applicant){
		Applicants applicantold = null;
		List<Applicants> applicantList= applicantsRepository.findByApplicantId(applicant.getApplicantId());
		if(!applicantList.isEmpty())
			applicantold = applicantList.get(applicantList.size()-1);
		applicant.setPassword(applicantold.getPassword());
		applicant.setHintQuestion(applicantold.getHintQuestion());
		applicant.setHintAnswer(applicantold.getHintAnswer());
		applicant.setPassportOffice(applicantold.getPassportOffice());
		applicantsRepository.save(applicant);
	}
	
	public Applicants findByApplicantId(String applicantId){
		Applicants applicant = null;
		List<Applicants> applicantList = applicantsRepository.findByApplicantId(applicantId);
		if(!applicantList.isEmpty())
			applicant=applicantList.get(applicantList.size()-1);
		return applicant;
	}
	
}
