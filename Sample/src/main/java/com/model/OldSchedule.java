package com.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OldSchedule {
	@Id
	int osId;
	@Column
	int attempts;
	@Column
	String applicationId;
	@Column
	Date oldScheduleDates;
	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public Date getOldScheduleDates() {
		return oldScheduleDates;
	}
	public void setOldScheduleDates(Date oldScheduleDates) {
		this.oldScheduleDates = oldScheduleDates;
	}
	
	
}
