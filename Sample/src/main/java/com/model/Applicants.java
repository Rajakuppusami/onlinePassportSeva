package com.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class Applicants {
	@Column
	private String passportOffice;
	@Column 
	private String name;
	@Column 
	private String surname;
	@Column 
	private String emailId;
	@Id
	private String applicantId;
	@Column 
	private String password;
	@Column 
	private String hintQuestion;
	@Column 
	private String hintAnswer;
	@Column(name="Dob") 
	private Date dob;
	
	public String getPassportOffice() {
		return passportOffice;
	}
	public void setPassportOffice(String passportOffice) {
		this.passportOffice = passportOffice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHintQuestion() {
		return hintQuestion;
	}
	public void setHintQuestion(String hintQuestion) {
		this.hintQuestion = hintQuestion;
	}
	public String getHintAnswer() {
		return hintAnswer;
	}
	public void setHintAnswer(String hintAnswer) {
		this.hintAnswer = hintAnswer;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Applicants [passportOffice=" + passportOffice + ", name=" + name + ", surname=" + surname + ", emailId="
				+ emailId + ", applicantId=" + applicantId + ", password=" + password + ", hintQuestion=" + hintQuestion
				+ ", hintAnswer=" + hintAnswer + ", dob=" + dob + "]";
	}
	
}
