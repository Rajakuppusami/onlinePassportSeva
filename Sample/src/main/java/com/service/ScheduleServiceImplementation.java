package com.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ScheduleRepository;
import com.handlers.MainController;
import com.model.Schedule;

@Service
public class ScheduleServiceImplementation {
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	final SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	final SimpleDateFormat sdft=new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public Map<String,LinkedHashMap<String, String>> checkAvailabeDate(String passportOffice,String month){
		//List<Schedule> scheduleList = findAll();
		Map<String,LinkedHashMap<String, String>> tableDate = new LinkedHashMap<String, LinkedHashMap<String,String>>();
		LocalDate date = LocalDate.now();
		String curmonth = date.getMonth().toString();
		System.out.println(month);
		if(!curmonth.equals(month)){
			while(true){
				date=date.plusMonths(1);
				if(date.getMonth().toString().equals(month))
					break;
			}
			date=LocalDate.of(date.getYear(), date.getMonthValue(), 01);
			//System.out.println(date.toString());
		}
		//checking by date wise
		while(true){
			//logic for db
			Date scheduledate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
			List<Schedule> scheduleList = scheduleRepository.findByScheduleDateAndPassportOffice(scheduledate,passportOffice);
			LinkedHashMap<String, String> tableDatebyTime = new LinkedHashMap<String, String>();
			if(scheduleList.isEmpty()){
				System.out.println(date.toString()+" is Available");
				LocalTime time = LocalTime.of(10, 00);
				for (int i = 1; i < 8; i++) {
					tableDatebyTime.put(time.toString(), "Available and remaining :5");
					time=time.plusHours(1);
				}
			}else{
				if(scheduleList.size()>=35){
					System.out.println(date.toString()+" is not Available");
					LocalTime time = LocalTime.of(10, 00);
					for (int i = 1; i < 8; i++) {
						time=time.plusHours(1);
						tableDatebyTime.put(time.toString(), "not Available");
					}
				}else{
					LocalTime time = LocalTime.of(10, 00);
					LocalDateTime datetime = LocalDateTime.of(date, time);
					System.out.println(datetime.toString());
					for (int i = 1; i < 8; i++) {
						Date scheduledateTime = Date.from(datetime.atZone(ZoneId.systemDefault()).toInstant());
						int applicantCountPerHour=0;
						for(Schedule schedule:scheduleList){
							System.out.println("####"+sdft.format(schedule.getScheduleDateTime())+" == "+sdft.format(scheduledateTime));
							if(sdft.format(schedule.getScheduleDateTime()).equals(sdft.format(scheduledateTime))){
								applicantCountPerHour++;
							}
						}
						if(applicantCountPerHour>=5){
							System.out.println(scheduledateTime.toString()+" is not Available");
							tableDatebyTime.put(time.toString(), "notAvailable");
							time=time.plusHours(1);
						}else{
							System.out.println(scheduledateTime.toString()+" is Available"+"\n remaining free :"+(5-applicantCountPerHour));
							tableDatebyTime.put(time.toString(), "Available and remaining :"+(5-applicantCountPerHour));
							time=time.plusHours(1);
						}
						datetime=datetime.plusHours(1);
						System.out.println(datetime.toString());
					}
					
				}
			}
			tableDate.put(sdf.format(scheduledate), tableDatebyTime);
			System.out.println(date.toString());
			date=date.plusDays(1);
			if(!month.equals(date.getMonth().toString())){
				System.out.println(date.getMonth());
				break;
			}
		}
		return tableDate;
	}
	
	public List<Schedule> findAll(){
		List<Schedule> scheduleList=scheduleRepository.findAll();	
		return scheduleList;
	}
	
	// get current 3 month as list
	public List<String> getMonthList(){
		List<String> monthList = new ArrayList<String>();
		LocalDate today = LocalDate.now();
		for (int i = 1; i <4; i++) {
			monthList.add(today.getMonth().toString());
			today=today.plusMonths(1);
		}
		System.out.println(monthList);
		return monthList;
	}
	
	public boolean checkAvailabe(Date date,String passportOffice){
		
		List<Schedule> scheduleList = scheduleRepository.findByScheduleDateTimeAndPassportOffice(date,passportOffice);
		if(scheduleList.isEmpty()){
			return true;
		}else{
			if(scheduleList.size()<=4)
				return true;
		}
		return false;
	}
	
	public boolean checkValidScheduler(Schedule schedule){
		List<Schedule> scheduleList =scheduleRepository.findByApplicationId(schedule.getApplicationId());
		
		if(scheduleList.isEmpty()){
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws ParseException {
		/*LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.of(10, 00);
		LocalDateTime datetime = LocalDateTime.of(date, time);
		System.out.println(datetime.toString());
		
		for (int i = 1; i < 8; i++) {
			datetime=datetime.plusHours(1);
			Date date1 =Date.from(datetime.atZone(ZoneId.systemDefault()).toInstant());
			System.out.println(date1.toString());
		}*/
		
		MainController m=new MainController();
		System.out.println(m.formDate("25-02-2017","24:00"));
		
	}

	public void saveSchedule(Schedule schedule) {
		int sId= (int)scheduleRepository.count();
		schedule.setsId(sId);
		scheduleRepository.save(schedule);
	}

	public boolean checkValidScheduler(String applicantId) {
		boolean flag=false;
		List<Schedule> scheduleList =scheduleRepository.findByApplicantId(applicantId);
		
		if(scheduleList.isEmpty()){
			flag=true;
		}
		System.out.println("#### checkValidScheduler : "+flag);
		return flag;
	}

	public Schedule getScheduledData(String applicantId) {
		// TODO Auto-generated method stub
		Schedule schedule = null;
		List<Schedule> scheduleList = scheduleRepository.findByApplicantId(applicantId);
		if(!scheduleList.isEmpty()){
			schedule=scheduleList.get(scheduleList.size()-1);
		}
		return schedule;
	}
}
