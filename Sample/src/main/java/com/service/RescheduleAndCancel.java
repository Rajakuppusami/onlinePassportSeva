package com.service;



import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OldScheduleRepository;
import com.dao.PaymentRepository;
import com.dao.ScheduleRepository;
import com.model.OldSchedule;
import com.model.Payment;
import com.model.Schedule;
import com.sun.xml.internal.ws.message.PayloadElementSniffer;

@Service
public class RescheduleAndCancel {

	@Autowired
	private ScheduleRepository scheduledao;
	@Autowired
	private OldScheduleRepository oldScheduledao;
	@Autowired
	private PaymentRepository paymentdao;
	
	public boolean checkEligibleForRescheduleByYear(String applicantId,String applicationId) {
		
		LocalDate currentDate = LocalDate.now();
		Date firstAppointmentDate = null;
		List<Schedule>scheduleList = scheduledao.findByApplicationId(applicationId);
		if(!scheduleList.isEmpty()) {
			Schedule schedule = scheduleList.get(scheduleList.size()-1);
			if(schedule.getAttempts()<2) {
				System.out.println("testing");
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
			System.out.println("#### "+firstAppointmentDate);
			if(firstAppointmentDate!=null) {
				LocalDate fpd = firstAppointmentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				System.out.println("#### "+fpd+ " : "+ currentDate);
				Period period = Period.between(currentDate,fpd);
				int daysDiff = period.getDays();
				int monthDiff = period.getMonths();
				int yearDiff = period.getYears();
				System.out.println("#### day diff : "+daysDiff);
				System.out.println("#### month diff : "+monthDiff);
				System.out.println("#### year diff : "+yearDiff);
				if(daysDiff>=0) {
					return true;
				}else {
					return false;
				}
				/*if(fpd.getYear()==currentDate.getYear()) {
					return true;
				}else {
					return false;
				}*/
			}
		}
		System.out.println("schedule is empty..");
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
	public void saveReschedule(Schedule schedule) {
		List<Schedule>scheduleList = scheduledao.findByApplicantId(schedule.getApplicantId());
		if(!scheduleList.isEmpty()) {
			Schedule oldScheduleDetails = scheduleList.get(scheduleList.size()-1);
			OldSchedule oldschedule = new OldSchedule();
			oldschedule.setOsId((int)oldScheduledao.count());
			oldschedule.setApplicationId(oldScheduleDetails.getApplicationId());
			oldschedule.setOldScheduleDates(oldScheduleDetails.getScheduleDateTime());
			oldschedule.setAttempts(oldScheduleDetails.getAttempts()+1);
			oldScheduledao.save(oldschedule);
			oldScheduleDetails.setAttempts(oldScheduleDetails.getAttempts()+1);
			oldScheduleDetails.setScheduleDate(schedule.getScheduleDate());
			oldScheduleDetails.setScheduleDateTime(schedule.getScheduleDateTime());
			oldScheduleDetails.setReshedule(true);
			scheduledao.save(oldScheduleDetails);
		}
	}
	public void cancel(String applicantId) {
		// TODO Auto-generated method stub
		List<Schedule>scheduleList = scheduledao.findByApplicantId(applicantId);
		if(!scheduleList.isEmpty()) {
			Schedule oldScheduleDetails = scheduleList.get(scheduleList.size()-1);
			oldScheduleDetails.setCancellationStatus(true);
			scheduledao.save(oldScheduleDetails);
			LocalDate currentDate = LocalDate.now();
			List<Payment> paymentList = paymentdao.findByApplicationId(oldScheduleDetails.getApplicationId());
			if(!paymentList.isEmpty()) {
				Payment paymentDetails = paymentList.get(paymentList.size()-1);
				paymentDetails.setCancellationDate(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
				currentDate=currentDate.plusDays(2);
				paymentDetails.setRefundDate(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
				paymentdao.save(paymentDetails);
			}
			
		}
		
	}
	public boolean checkforcancellation(String applicantId) {
		// TODO Auto-generated method stub
		List<Schedule>scheduleList = scheduledao.findByApplicantId(applicantId);
		if(!scheduleList.isEmpty()) {
			Schedule oldScheduleDetails = scheduleList.get(scheduleList.size()-1);
			if(!oldScheduleDetails.isCancellationStatus()) {
				return true;
			}else {
				return false;
			}
		}
		
		return false;
	}
	
	
}

