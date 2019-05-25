package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Documents {
	@Id
	private int dId;
	@Column
	private boolean aadharCard;
	@Column
	private  boolean voterId;
	@Column
	private boolean drivingLicense;
	@Column
	private boolean panCard;
	@Column
	private boolean xthMarksheet;
	@Column
	private boolean xiithMarksheet;
	@Column
	private boolean birthCertificate;
	@Column
	private String applicationId;
	@Column
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public boolean isAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(boolean aadharCard) {
		this.aadharCard = aadharCard;
	}
	public boolean isVoterId() {
		return voterId;
	}
	public void setVoterId(boolean voterId) {
		this.voterId = voterId;
	}
	public boolean isDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(boolean drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public boolean isPanCard() {
		return panCard;
	}
	public void setPanCard(boolean panCard) {
		this.panCard = panCard;
	}
	public boolean isXthMarksheet() {
		return xthMarksheet;
	}
	public void setXthMarksheet(boolean xthMarksheet) {
		this.xthMarksheet = xthMarksheet;
	}
	public boolean isXiithMarksheet() {
		return xiithMarksheet;
	}
	public void setXiithMarksheet(boolean xiithMarksheet) {
		this.xiithMarksheet = xiithMarksheet;
	}
	public boolean isBirthCertificate() {
		return birthCertificate;
	}
	public void setBirthCertificate(boolean birthCertificate) {
		this.birthCertificate = birthCertificate;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
}
