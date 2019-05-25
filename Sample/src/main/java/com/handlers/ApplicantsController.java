package com.handlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Applicants;
import com.service.ApplicantsServiceImplementation;

@Controller
public class ApplicantsController {
	
	private ApplicantsServiceImplementation applicantService;
	
	
	
	@RequestMapping(value="/saveapplicant", method=RequestMethod.GET)
	public ModelAndView saveApplicant() throws ParseException{
		ModelAndView model = new ModelAndView();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
		Applicants applicant = new Applicants();
		applicant.setApplicantId("viceraja@gamail.com");
		applicant.setDob(sdf.parse("25-02-1995"));
		applicant.setEmailId("viceraja@gamail.com");
		applicant.setHintAnswer("xxx");
		applicant.setHintQuestion("yyy");
		applicant.setName("Raja");
		applicant.setPassportOffice("zzzz");
		applicant.setPassword("raja");
		applicant.setSurname("Raja");
		
		applicantService.saveApplicant(applicant);
		model.setViewName("test");
		return model;
	}
	
	@RequestMapping(value="/deleteapplicant", method=RequestMethod.GET)
	public ModelAndView deleteApplicant() throws ParseException{
		ModelAndView model = new ModelAndView();
		/*SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");*/
		Applicants applicant = new Applicants();
		applicant.setApplicantId("viceraja@gamail.com");
		/*applicant.setDob(sdf.parse("25-02-1995"));
		applicant.setEmailId("viceraja@gamail.com");
		applicant.setHintAnswer("xxx");
		applicant.setHintQuestion("yyy");
		applicant.setName("Raja");
		applicant.setPassportOffice("zzzz");
		applicant.setPassword("raja");
		applicant.setSurname("Raja");*/
		
		
		model.setViewName("test");
		return model;
	}
}
