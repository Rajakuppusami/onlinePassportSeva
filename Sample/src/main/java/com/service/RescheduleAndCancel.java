package com.service;



import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OldScheduleRepository;
import com.dao.ScheduleRepository;
import com.model.OldSchedule;
import com.model.Schedule;

@Service
public class RescheduleAndCancel {

	@Autowired
	private ScheduleRepository scheduledao;
	@Autowired
	private OldScheduleRepository oldScheduledao;
	
	public boolean checkEligibleForRescheduleByYear(String applicantId,String applicationId) {
		
		LocalDate currentDate = LocalDate.now();
		Date firstAppointmentDate = null;
		List<Schedule>scheduleList = scheduledao.findByApplicantId(applicantId);
		if(!scheduleList.isEmpty()) {
			Schedule schedule = scheduleList.get(scheduleList.size()-1);
			if(schedule.getAttempts()<1) {
				firstAppointmentDate=schedule.getScheduleDateTime();
			}else {
				List<OldSchedule>oldScheduleList =oldScheduledao.findByApplicationId(applicationId);
				if(!oldScheduleList.isEmpty()) {
					for(OldSchedule oldSchedule:oldScheduleList) {
						if(oldSchedule.getAttempts()==1) {
							firstAppointmentDate=oldSchedule.getOldScheduleDates();
							break;
						}
					}
				}
			}
			if(firstAppointmentDate!=null) {
				LocalDate fpd = firstAppointmentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				//System.out.println("####"+fpd+ " : "+ firstAppointmentDate);
				if(fpd.getYear()==currentDate.getYear()) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
		
	}
	public boolean checkEligibleForRescheduleByAttempt(String applicantId) {

		List<Schedule>scheduleList = scheduledao.findByApplicantId(applicantId);
		if(!scheduleList.isEmpty()) {
			Schedule schedule = scheduleList.get(scheduleList.size()-1);
			if(schedule.getAttempts()<2) {
				return true;
			}else {
				return false;
			}
		
		}
		return false;
	}
}

