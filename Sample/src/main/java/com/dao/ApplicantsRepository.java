package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Applicants;

@Repository
public interface ApplicantsRepository  extends JpaRepository<Applicants, String> {
	public List<Applicants> findByApplicantId(String applicantId);
	public void deleteByApplicantId(String applicantId);
	public List<Applicants> findByEmailId(String emailId);
}
