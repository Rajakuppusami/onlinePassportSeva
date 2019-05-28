package com.handlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Applicants;
import com.model.Payment;
import com.model.Schedule;
import com.service.AdminServiceImplementation;

@Controller
public class AdminController {
	
	@Autowired
	private AdminServiceImplementation adminService;
	
	@RequestMapping(value="/adminlogin", method=RequestMethod.GET)
	public ModelAndView adminloginPage(HttpSession session) throws ParseException{
		ModelAndView model = new ModelAndView();
		if(session.isNew()||session==null){
			model.setViewName("adminlogin");
		}else{
			if(session.getAttribute("userid")==null){
				model.setViewName("adminlogin");
			}else{
				model.setViewName("redirect:/adminhome");
			}
		}
		
		return model;
	}
	
	@RequestMapping(value="/adminlogin", method=RequestMethod.POST)
	public ModelAndView adminloginPage(@RequestParam("username") String username , @RequestParam("password") String password ,HttpSession session) throws ParseException{
		ModelAndView model =new  ModelAndView();
		if(adminService.authentication(username, password)){
			session.setAttribute("userid", username);
			session.setAttribute("modelscript","show" );
			session.setAttribute("modelbodycontent", "Login Successful");
			model.setViewName("redirect:/adminhome");
		}else{
			model.addObject("errormessage", "username or password is invalid");
			model.addObject("errorcss", "alert alert-danger m-2");
			model.setViewName("adminlogin");
		}
		return model;
	}
	
	@RequestMapping(value="/adminhome", method=RequestMethod.GET)
	public ModelAndView adminhomePage(HttpSession session) throws ParseException{
		ModelAndView model =new  ModelAndView();
		model=checkSessionValidation(session,model);
		if(!model.getViewName().equals("redirect:/adminlogin")) {
			model.addObject("modelscript", session.getAttribute("modelscript"));
			model.addObject("modelbodycontent", session.getAttribute("modelbodycontent"));
			session.setAttribute("modelscript", "hide");
			
			session.setAttribute("modelbodycontent", "modelbodycontent");
			model.setViewName("adminhome");
		}
		return model;
	}
	
	@RequestMapping(value="/deteleapplicant", method=RequestMethod.POST)
	public ModelAndView deteleapplicant(HttpSession session, @RequestParam("applicantId") String applicantId) {
		ModelAndView model = new ModelAndView();
		model=checkSessionValidation(session,model);
		if(!model.getViewName().equals("redirect:/adminlogin")) {
			adminService.deleteApplicantByApplicantId(applicantId);
			model.setViewName("redirect:/viewallapplicant");
		}
		return model;
	}
	
	@RequestMapping(value="/viewallapplicant", method=RequestMethod.GET)
	public ModelAndView viewallapplicant(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model=checkSessionValidation(session,model);
		if(!model.getViewName().equals("redirect:/adminlogin")) {
			List<Applicants>applicantList = adminService.getAllRegisterApplicant();
			model.addObject("applicantList", applicantList);
			model.setViewName("applicant");
		}
		return model;
	}
	
	@RequestMapping(value="/viewallschedulers", method=RequestMethod.GET)
	public ModelAndView viewallschedulers(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model=checkSessionValidation(session,model);
		if(!model.getViewName().equals("redirect:/adminlogin")) {
			List<Schedule> scheduleList = adminService.getAllSchedules();
			model.addObject("scheduleList", scheduleList);
			model.addObject("sdft", new SimpleDateFormat("HH:mm"));
			model.addObject("sdf", new SimpleDateFormat("dd-MM-yyyy"));
			model.setViewName("scheduleDetails");
		}
		return model;
	}
	@RequestMapping(value="/viewallpayment", method=RequestMethod.GET)
	public ModelAndView viewallpayment(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model=checkSessionValidation(session,model);
		if(!model.getViewName().equals("redirect:/adminlogin")) {
			List<Payment> paymentList=adminService.getAllPaymentHistory();
			model.addObject("paymentList", paymentList);
			model.addObject("sdf", new SimpleDateFormat("dd-MM-yyyy"));
			model.setViewName("paymentdetails");
		}
		return model;
	}
	
	/*@RequestMapping(value="/adminhome", method=RequestMethod.POST)
	public ModelAndView adminhome() throws ParseException{
		ModelAndView model =new  ModelAndView();
		
		model.setViewName("adminhome");
		return model;
	}*/
	
	@RequestMapping(value="/adminlogout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
		if(session!=null||!session.isNew()){
			if(session.getAttribute("userid")!=null){
				session.invalidate();
				model.setViewName("redirect:/adminlogin");
			}
		}
		return model;
	}
	
	
	public ModelAndView checkSessionValidation(HttpSession session,ModelAndView model){
		if(session.isNew()||session==null){
			model.setViewName("redirect:/adminlogin");
		}else{
			if(session.getAttribute("userid")==null){
				model.setViewName("redirect:/adminlogin");
			}else{
				model.setViewName("");
			}
		}
		return model;
	}
}
