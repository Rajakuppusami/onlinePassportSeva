package com.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class QualifiedApplicants {
	@Column
	String name;
	@Column
	String surName;
	@Column
	String gender;
	@Column
	String placeOfBirth;
	@Column
	String emailId;
	@Column
	long aadharNumber;
	@Column
	String fatherName;
	@Column
	String applicantId;
	@Id
	String applicationId;
	@Column
	long mobileNumber;
	@Column
	Date dob;
	@Column
	boolean declaration;
	public boolean isDeclaration() {
		return declaration;
	}
	public void setDeclaration(boolean declaration) {
		this.declaration = declaration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "QualifiedApplicants [name=" + name + ", surName=" + surName + ", gender=" + gender + ", placeOfBirth="
				+ placeOfBirth + ", emailId=" + emailId + ", aadharNumber=" + aadharNumber + ", fatherName="
				+ fatherName + ", applicantId=" + applicantId + ", applicationId=" + applicationId + ", mobileNumber="
				+ mobileNumber + ", dob=" + dob + ", declaration=" + declaration + "]";
	}
	
	

}
