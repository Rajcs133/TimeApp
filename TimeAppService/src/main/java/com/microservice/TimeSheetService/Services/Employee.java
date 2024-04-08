package com.microservice.TimeSheetService.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.Repositories.TimeSheetRepo;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;


@Service(Employee.BEAN_ID)
public class Employee implements IUserActivity {
	
	public static final String BEAN_ID= "USER";
	
	@Autowired
	TimeSheetRepo loRepo;
	
	@Autowired
	ITimeSheet loTimeSheetService;
	
	public Object fillTimeSheet(TimeSheetEntity poTimeSheetEntity) {		
		return loTimeSheetService.saveTimeSheetEntity(poTimeSheetEntity);
	}

	public Object getTimeSheetBasedonId(int id) throws CustomBusinessException {

		return loTimeSheetService.getTimeSheetEntry(id);
	
	}

    @Override
	public TimeSheetEntity performTimeSheetTask(TimeSheetEntity TimeSheet, Mode ModeValue) throws CustomBusinessException {
		TimeSheetEntity loTimeSheetEntity = null;
		if(ModeValue.equals(Mode.INSERT)){
			 loTimeSheetEntity = (TimeSheetEntity) fillTimeSheet((TimeSheetEntity) TimeSheet);
		}
		if(ModeValue.equals(Mode.RETRIEVE)){
			 loTimeSheetEntity = (TimeSheetEntity) getTimeSheetBasedonId(TimeSheet.getLsUserEntity().getLsUserid());
		}
		return loTimeSheetEntity;
	}

	

}
