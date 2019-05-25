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
public class Payment {
	@Column
	String applicationId;
	@Id
	int pId;
	@Column
	Date paymentDate;
	@Column
	Date refundDate;
	@Column
	Date cancellationDate;
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Date getRefundDate() {
		return refundDate;
	}
	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}
	public Date getCancellationDate() {
		return cancellationDate;
	}
	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}
	

}
