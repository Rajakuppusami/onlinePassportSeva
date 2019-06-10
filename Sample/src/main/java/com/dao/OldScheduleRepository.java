package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.OldSchedule;

@Repository
public interface OldScheduleRepository extends JpaRepository<OldSchedule, Integer>{

	List<OldSchedule> findByApplicationId(String applicationId);

}
