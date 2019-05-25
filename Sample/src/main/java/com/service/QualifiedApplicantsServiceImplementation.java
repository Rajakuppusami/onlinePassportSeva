package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.QualifiedApplicantsRepository;
import com.model.QualifiedApplicants;

@Service
public class QualifiedApplicantsServiceImplementation {

	@Autowired
	public QualifiedApplicantsRepository qualifiedApplicantsRepository;
	
	public void saveQualifiedApplicant(QualifiedApplicants qualifiedApplicants){
		String applicantionId = "AI"+LocalDate.now().getMonthValue()+LocalDate.now().getYear()+qualifiedApplicantsRepository.count();
		System.out.println(applicantionId);
		qualifiedApplicants.setApplicationId(applicantionId);
		qualifiedApplicantsRepository.save(qualifiedApplicants);
	}
	
	public boolean checkValidQualifiedApplicant(QualifiedApplicants qualifiedApplicants){
		List<QualifiedApplicants> qualifiedApplicantsList = qualifiedApplicantsRepository.findByAadharNumber(qualifiedApplicants.getAadharNumber());
		if(qualifiedApplicantsList.isEmpty()){
			qualifiedApplicantsList=qualifiedApplicantsRepository.findByEmailId(qualifiedApplicants.getEmailId());
			if(qualifiedApplicantsList.isEmpty()){
				qualifiedApplicantsList = qualifiedApplicantsRepository.findByMobileNumber(qualifiedApplicants.getMobileNumber());
				if(qualifiedApplicantsList.isEmpty()){
					qualifiedApplicantsList = qualifiedApplicantsRepository.findByApplicationId(qualifiedApplicants.getApplicationId());
					if(qualifiedApplicantsList.isEmpty()){
						qualifiedApplicantsList = qualifiedApplicantsRepository.findByApplicantId(qualifiedApplicants.getApplicantId());
						if(qualifiedApplicantsList.isEmpty()){
							return true;
						}else{
							System.out.println("ApplicantId is alread exists");
						}
					}else
						System.out.println("ApplicationId is alread exists");
				}else
					System.out.println("MobileNumber is alread exists");
			}else
				System.out.println("EmailId is alread exists");
		}else
			System.out.println("AadharNumber is alread exists");
		return false;
	}
	
	public QualifiedApplicants findByApplicantId(String applicantId){
		QualifiedApplicants qualifiedApplicants=null;
		List<QualifiedApplicants> qualifiedApplicantsList = qualifiedApplicantsRepository.findByApplicantId(applicantId);
		if(!qualifiedApplicantsList.isEmpty()){
			qualifiedApplicants = qualifiedApplicantsList.get(qualifiedApplicantsList.size()-1);
		}
		return qualifiedApplicants;
	}

	public void updateQualifiedApplicant(QualifiedApplicants qualifiedApplicants) {
		// TODO Auto-generated method stub
		QualifiedApplicants qualified=null;
		List<QualifiedApplicants> qualifiedApplicantsList = qualifiedApplicantsRepository.findByApplicantId(qualifiedApplicants.getApplicantId());
		if(!qualifiedApplicantsList.isEmpty()){
			qualified = qualifiedApplicantsList.get(qualifiedApplicantsList.size()-1);
			//qualifiedApplicantsRepository.deleteByApplicantId(qualifiedApplicants.getApplicantId());
			qualifiedApplicants.setApplicationId(qualified.getApplicationId());
			System.out.println("#### old object "+qualified);
			System.out.println("#### new object "+qualifiedApplicants);
			qualifiedApplicantsRepository.save(qualifiedApplicants);
		}
	}
	
	public boolean checkApplicantAvailable(String applicantId){
		QualifiedApplicants qualifiedApplicants = findByApplicantId(applicantId);
		if(qualifiedApplicants==null)
			return false;
		return true;
	}
	
}
