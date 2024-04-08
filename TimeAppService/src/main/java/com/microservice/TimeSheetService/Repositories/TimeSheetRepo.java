package com.microservice.TimeSheetService.Repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.Entity.UserTimeSheetEntity;


public interface TimeSheetRepo extends JpaRepository<TimeSheetEntity, Integer>{
	
	public Optional<TimeSheetEntity> findById(Integer Id);
	
	

}
