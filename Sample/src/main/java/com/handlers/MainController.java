package com.handlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Applicants;
import com.model.PassportOffice;
import com.model.QualifiedApplicants;
import com.model.Schedule;
import com.service.AdminServiceImplementation;
import com.service.ApplicantsServiceImplementation;
import com.service.PaymentServiceImplementation;
import com.service.QualifiedApplicantsServiceImplementation;
import com.service.ScheduleServiceImplementation;

@Controller
public class MainController {

	@Autowired
	private AdminServiceImplementation adminservice;
	@Autowired
	private ApplicantsServiceImplementation applicantService;
	@Autowired
	private ScheduleServiceImplementation scheduleService;
	@Autowired
	private QualifiedApplicantsServiceImplementation qualifiedApplicantsService;
	@Autowired
	private PaymentServiceImplementation paymentService;
	@Autowired
	private PassportOffice passportoffice;
	
	final SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	final SimpleDateFormat sdft=new SimpleDateFormat("dd-MM-yyyy HH:mm");
	LocalDate date =null;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView test(){
		ModelAndView model = new ModelAndView();
		/*Admin admin = new Admin();
		admin.setUserId("raja");
		admin.setPassword("raja");
		adminservice.saveAdmin(admin);*/
		model.setViewName("test");
		return model;
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginPage(HttpSession session) {
		ModelAndView model = new ModelAndView();
		if(session.isNew()||session==null){
			model.setViewName("login");
		}else{
			if(session.getAttribute("applicantId")==null){
				model.setViewName("login");
			}else{
				model.setViewName("redirect:/home");
			}
		}
		
		return model;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username , @RequestParam("password") String password ,HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		if(applicantService.authentication(username, password)){
			session.setAttribute("applicantId", username);
			session.setAttribute("modelscript","show" );
			session.setAttribute("modelbodycontent", "Login Successful");
			if(qualifiedApplicantsService.checkApplicantAvailable(username)){
				session.setAttribute("schedulebuttoncss", "");
			}
			else{
				session.setAttribute("schedulebuttoncss", "disabled");
			}
			model.setViewName("redirect:/home");
		}else{
			model.addObject("errormessage", "username or password is invalid");
			model.addObject("errorcss", "alert alert-danger m-2");
			model.setViewName("login");
		}
		return model;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registerPage(HttpSession session) {
		ModelAndView model = new ModelAndView();
		if(session.isNew()||session==null){
			model.setViewName("register");
		}else{
			if(session.getAttribute("applicantId")==null){
				model.setViewName("register");
			}else{
				model.setViewName("redirect:/home");
			}
		}
		return model;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute Applicants applicant, @RequestParam("dateOfBirth") String dob,HttpServletRequest request) throws ParseException {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		applicant.setDob(formDate(dob));
		applicant.setPassportOffice("Chennai");
		System.out.println(applicant.toString());
		
		if(applicantService.checkValidApplicant(applicant)){
			applicantService.saveApplicant(applicant);
			long length = applicantService.getCount();
			System.out.println("Applicant Table Length :- "+length);
			session.setAttribute("applicantId", applicant.getApplicantId());
			session.setAttribute("modelscript", "show");
			session.setAttribute("modelbodycontent", "Registration Successful");
			session.setAttribute("schedulebuttoncss", "disabled");
			model.setViewName("redirect:/home");
		}else{
			model.addObject("errormessage", "username or Email Id is alread exists");
			model.addObject("errorcss", "alert alert-danger m-2");
			model.setViewName("register");
		}
		
		return model;
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		model=checkSessionValidation(session,model);
		//System.out.println("####====>"+model.getViewName());
		if(!model.getViewName().equals("redirect:/login")){
			model.addObject("modelscript", session.getAttribute("modelscript"));
			model.addObject("modelbodycontent", session.getAttribute("modelbodycontent"));
			model.addObject("schedulebuttoncss", session.getAttribute("schedulebuttoncss"));
			Schedule schedule=scheduleService.getScheduledData((String)session.getAttribute("applicantId"));
			if(schedule==null){
				model.addObject("applicationid", " Not yet scheduled");
				model.addObject("passportoffice", " Not yet scheduled");
				model.addObject("scheduleddate", " Not yet scheduled");
				model.addObject("scheduledtime", " Not yet scheduled");
				model.addObject("paymentstatus", " Not yet scheduled");
			}else{
				model.addObject("applicationid", schedule.getApplicationId());
				model.addObject("passportoffice", schedule.getPassportOffice());
				model.addObject("scheduleddate", sdf.format(schedule.getScheduleDate()));
				model.addObject("scheduledtime", new SimpleDateFormat("HH:mm").format(schedule.getScheduleDateTime()));
				model.addObject("paymentstatus", "success");
			}
			/*model.addObject("viewschedulecss", session.getAttribute("viewschedulecss"));*/
			session.setAttribute("modelscript", "hide");
			session.setAttribute("modelbodycontent", "modelbodycontent");
			model.setViewName("home");
		}
		return model;
	}
	@RequestMapping(value="/eform", method=RequestMethod.GET)
	public ModelAndView eformPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		model=checkSessionValidation(session,model);
		//System.out.println("####====>"+model.getViewName());
		if(!model.getViewName().equals("redirect:/login")){
			String applicantId = (String) session.getAttribute("applicantId");
			QualifiedApplicants qualifiedApplicants = qualifiedApplicantsService.findByApplicantId(applicantId);
			if(qualifiedApplicants!=null){
				model.addObject("qualifiedapplicants", qualifiedApplicants);
				
				model.addObject("dateOfBirth", sdf.format(qualifiedApplicants.getDob()));
				model.addObject("operation", "edit");
				model.addObject("buttonvalue", "Save Changes");
				model.addObject("resetcss", "d-none");
				model.addObject("homecss", "");
			}else{
				model.addObject("homecss", "d-none");
				model.addObject("operation", "insert");
				model.addObject("buttonvalue", "Submit");
			}
			model.setViewName("eform");
		}
		return model;
	}
	
	@RequestMapping(value="/eform", method=RequestMethod.POST)
	public ModelAndView eform(@ModelAttribute QualifiedApplicants qualifiedApplicants, @RequestParam("dateOfBirth") String dateOfBirth,@RequestParam("operation") String operation,HttpServletRequest request) throws ParseException {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		String applicantId = (String) session.getAttribute("applicantId");
		if(applicantId.isEmpty()||applicantId==null){
			model.setViewName("login");
		}else{
		qualifiedApplicants.setDob(formDate(dateOfBirth));
		qualifiedApplicants.setApplicantId(applicantId);
		System.out.println(qualifiedApplicants);
		System.out.println("####"+operation);
		if(operation.equals("edit")){
			qualifiedApplicantsService.updateQualifiedApplicant(qualifiedApplicants);
			session.setAttribute("modelscript", "show");
			session.setAttribute("modelbodycontent", "E-form Update successful");
			session.setAttribute("schedulebuttoncss", "");
			model.setViewName("redirect:/home");
		}else{
			if(qualifiedApplicantsService.checkValidQualifiedApplicant(qualifiedApplicants)){
				
				if(operation.equals("insert")){
					qualifiedApplicantsService.saveQualifiedApplicant(qualifiedApplicants);
				}/*else if(operation.equals("edit")){
					qualifiedApplicantsService.updateQualifiedApplicant(qualifiedApplicants);
				}*/
				/*model.addObject("modelscript", "show");
				model.addObject("modelbodycontent", "E-form Update successful");
				model.addObject("schedulebuttoncss", "");//enable button
*/				
				session.setAttribute("modelscript", "show");
				session.setAttribute("modelbodycontent", "E-form Update successful");
				session.setAttribute("schedulebuttoncss", "");
				model.setViewName("redirect:/home");
			}else{
				model.addObject("errormessage", "Email Id ,Mobile Number or Aadhar Number already exists");
				model.addObject("errorcss", "alert alert-danger m-2");
				model.setViewName("eform");
			}
		}
		
		
		}
		
		return model;
	}
	
	@RequestMapping(value="/scheduleappointment", method=RequestMethod.GET)
	public ModelAndView scheduleappointmentPage(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model=checkSessionValidation(session,model);
		//System.out.println("####====>"+model.getViewName());
		if(!model.getViewName().equals("redirect:/login")){
			List<String> monthList=scheduleService.getMonthList();
			model.addObject("passportoffices", passportoffice.getPassportOfficeList());
			model.addObject("months", monthList);
			model.setViewName("schedule");
		}
		return model;
	}
	
	@RequestMapping(value="/scheduleappointment", method=RequestMethod.POST)
	public ModelAndView scheduleappointment(@RequestParam("passportoffice") String passportOffice, @RequestParam("month") String month,HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		System.out.println(passportOffice+" : "+month);
		HttpSession session = request.getSession();
		String applicantId = (String) session.getAttribute("applicantId");
		Map<String,LinkedHashMap<String, String>> tableData = scheduleService.checkAvailabeDate(passportOffice, month);
		
		if(!scheduleService.checkValidScheduler(applicantId)){
			// should change css for reschedule functionality
			System.out.println("#### old scheduler ----");
			model.addObject("oldSchedulerButtoncss", "d-none");
		}
		System.out.println(tableData);
		List<String> monthList=scheduleService.getMonthList();
		model.addObject("tableData", tableData);
		model.addObject("passportofficevalue", passportOffice);
		model.addObject("monthvalue", month);
		model.addObject("passportoffices", passportoffice.getPassportOfficeList());
		model.addObject("months", monthList);
		model.setViewName("schedule");
		return model;
	}
	
	@RequestMapping(value="/checkforconfirm", method=RequestMethod.POST)
	public ModelAndView checkavailablity(@RequestParam("date") String crmDate,@RequestParam("time") String crmTime,@RequestParam("passportoffice") String passportOffice,HttpServletRequest request) throws ParseException {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		String applicantId = (String) session.getAttribute("applicantId");
		System.out.println(crmDate+" : "+crmTime);
		QualifiedApplicants qualifiedApplicants=qualifiedApplicantsService.findByApplicantId(applicantId);
		model.addObject("date", crmDate);
		model.addObject("time", crmTime);
		model.addObject("passportoffice", passportOffice);
		model.addObject("applicantid", applicantId);
		model.addObject("applicationid",qualifiedApplicants.getApplicationId());
		model.addObject("name",qualifiedApplicants.getName());
		model.setViewName("payment");
		return model;
	}
	
	@RequestMapping(value="/payment", method=RequestMethod.POST)
	public ModelAndView paymentPage(@ModelAttribute Schedule schedule, @RequestParam("date") String crmDate,@RequestParam("time") String crmTime,HttpServletRequest request) throws ParseException{
		ModelAndView model = new ModelAndView();
		HttpSession session =request.getSession();
		System.out.println("#### "+schedule);
		String applicantId = (String) session.getAttribute("applicantId");
		if(scheduleService.checkAvailabe(formDate(crmDate,crmTime),schedule.getPassportOffice())){
			model.setViewName("payment");
			schedule.setApplicantId(applicantId);
			schedule.setScheduleDate(formDate(crmDate));
			schedule.setScheduleDateTime(formDate(crmDate,crmTime));
			//-------> check for valid scheduler based on applicataion Id should be unique
			if(scheduleService.checkValidScheduler(schedule)){
				scheduleService.saveSchedule(schedule);
				if(paymentService.checkValidPayment(schedule.getApplicationId())){
					paymentService.savePayment(schedule.getApplicationId());
				}
				
				/*model.addObject("modelscript", "show");
				model.addObject("modelbodycontent", "Payment is successful");*/
				session.setAttribute("modelscript", "show");
				session.setAttribute("modelbodycontent", "Payment is successful");
				session.setAttribute("schedulebuttoncss", "");
				model.setViewName("redirect:/home");
			}else{
				//model.setViewName("redirect:/scheduleappointment");
				//modelredirect.addAttribute("modelscript", "show");
				//return new ModelAndView("redirect:/scheduleappointment",modelredirect);
				List<String> monthList=scheduleService.getMonthList();
				model.addObject("passportoffices", passportoffice.getPassportOfficeList());
				model.addObject("months", monthList);
				model.addObject("modelscript", "show");
				model.addObject("modelbodycontent", "you have already paid");
				model.setViewName("schedule");
			}
		}else{
			model.addObject("modelscript", "show");
			model.addObject("modelbodycontent", "selected date is not available");
			model.setViewName("schedule");
		}
		
		return model;
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
		if(session!=null||!session.isNew()){
			if(session.getAttribute("applicantId")!=null){
				session.invalidate();
				model.setViewName("redirect:/login");
			}
		}
		return model;
	}
	
	@RequestMapping(value="/editprofile", method=RequestMethod.GET)
	public ModelAndView editProfilePage(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model=checkSessionValidation(session,model);
		if(!model.getViewName().equals("redirect:/login")){
			Applicants applicant = applicantService.findByApplicantId((String)session.getAttribute("applicantId"));
			model.addObject("applicant", applicant);
			model.addObject("dob", sdf.format(applicant.getDob()));
			model.setViewName("editprofile");
		}
		return model;
	}
	
	@RequestMapping(value="/editprofile", method=RequestMethod.POST)
	public ModelAndView editProfile(@ModelAttribute Applicants applicant,@RequestParam("dateOfBirth") String dateOfBirth,HttpSession session) throws ParseException {
		ModelAndView model = new ModelAndView();
		applicant.setApplicantId((String)session.getAttribute("applicantId"));
		applicant.setDob(formDate(dateOfBirth));
		applicantService.updateApplicant(applicant);
		session.setAttribute("modelscript", "show");
		session.setAttribute("modelbodycontent", "Profile Update successful");
		session.setAttribute("schedulebuttoncss", "");
		model.setViewName("redirect:/home");
		return model;
	}
	
	public static void main(String[] args) {
		List<String> monthList = new ArrayList<String>();
		LocalDate today = LocalDate.now();
		for (int i = 1; i <4; i++) {
			//System.out.println(today.getMonth().toString());
			monthList.add(today.getMonth().toString());
			today=today.plusMonths(1);
		}
		System.out.println(monthList);
		
	}
	
	public Date formDate(String dob) throws ParseException{
		/*System.out.println("#####"+dob);*/
		Date dt = sdf.parse(dob);
		System.out.println("#### parsed date : "+dt);
		/*date=dt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		date=date.plusMonths(1);
		System.out.println("#####"+date);
		dt=Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println("#####"+dt);*/
		return dt;
	}
	public Date formDate(String date,String time) throws ParseException{
		/*System.out.println("#####"+dob);*/
		Date dt = sdft.parse(date+" "+time);
		System.out.println("#### parsed date : "+dt);
		/*date=dt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		date=date.plusMonths(1);
		System.out.println("#####"+date);
		dt=Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println("#####"+dt);*/
		return dt;
	}
	
	public ModelAndView checkSessionValidation(HttpSession session,ModelAndView model){
		if(session.isNew()||session==null){
			model.setViewName("redirect:/login");
		}else{
			if(session.getAttribute("applicantId")==null){
				model.setViewName("redirect:/login");
			}else{
				model.setViewName("");
			}
		}
		return model;
	}
}
