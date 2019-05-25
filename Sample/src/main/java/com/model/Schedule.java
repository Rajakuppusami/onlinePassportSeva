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
public class Schedule {
	@Id
	int sId;
	@Column
	int attempts;
	@Column
	boolean reshedule;
	@Column
	boolean paymentStatus;
	@Column
	boolean cancellationStatus;
	@Column
	String applicantId;
	@Column
	String applicationId;
	@Column
	Date scheduleDateTime;
	@Column
	Date scheduleDate;
	@Column
	private String passportOffice;
	
	public String getPassportOffice() {
		return passportOffice;
	}
	public void setPassportOffice(String passportOffice) {
		this.passportOffice = passportOffice;
	}
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public boolean isReshedule() {
		return reshedule;
	}
	public void setReshedule(boolean reshedule) {
		this.reshedule = reshedule;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public boolean isCancellationStatus() {
		return cancellationStatus;
	}
	public void setCancellationStatus(boolean cancellationStatus) {
		this.cancellationStatus = cancellationStatus;
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
	public Date getScheduleDateTime() {
		return scheduleDateTime;
	}
	public void setScheduleDateTime(Date scheduleDateTime) {
		this.scheduleDateTime = scheduleDateTime;
	}
	@Override
	public String toString() {
		return "Schedule [sId=" + sId + ", attempts=" + attempts + ", reshedule=" + reshedule + ", paymentStatus="
				+ paymentStatus + ", cancellationStatus=" + cancellationStatus + ", applicantId=" + applicantId
				+ ", applicationId=" + applicationId + ", scheduleDateTime=" + scheduleDateTime + ", scheduleDate="
				+ scheduleDate + ", passportOffice=" + passportOffice + "]";
	}
	
	
}
