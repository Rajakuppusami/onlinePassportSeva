package com.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.model.PassportOffice;

@Configuration
public class DefaultValueConfig {

	@Bean
	public PassportOffice getPassportOffice(){
		PassportOffice passOff = new PassportOffice();
		List<String> passOffLi=Arrays.asList("Ahmedabad","Bangalore", "Bhopal","Chennai","Coimbatore","Hyderabad");
		passOff.setPassportOfficeList(passOffLi);
		return passOff;
	}
}
