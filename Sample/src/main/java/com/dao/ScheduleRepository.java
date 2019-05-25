package com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

	public List<Schedule> findByScheduleDate(Date scheduleDate);
	public List<Schedule> findByScheduleDateAndPassportOffice(Date scheduleDate,String passportOffice);
	public List<Schedule> findByScheduleDateTimeAndPassportOffice(Date scheduleDateTime,String passportOffice);
	public List<Schedule> findByApplicationId(String applicationId);
	public List<Schedule> findByApplicantId(String applicantId);
}
