package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.QualifiedApplicants;

@Repository
public interface QualifiedApplicantsRepository extends JpaRepository<QualifiedApplicants, String> {
	public List<QualifiedApplicants> findByEmailId(String emailId);
	public List<QualifiedApplicants> findByAadharNumber(long aadharNumber);
	public List<QualifiedApplicants> findByApplicationId(String applicationId);
	public List<QualifiedApplicants> findByMobileNumber(long mobileNumber);
	public List<QualifiedApplicants> findByApplicantId(String applicantId);
	public void deleteByApplicantId(String applicantId);
}
