package com.model;

import java.util.List;

import org.springframework.stereotype.Component;


public class PassportOffice {
	private List<String> passportOfficeList;

	public List<String> getPassportOfficeList() {
		return passportOfficeList;
	}

	public void setPassportOfficeList(List<String> passportOfficeList) {
		this.passportOfficeList = passportOfficeList;
	}
}
