package com.microservice.TimeSheetService.Services;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

public interface IUserActivity {

	public TimeSheetEntity performTimeSheetTask(TimeSheetEntity TimeSheet, Mode ModeValue) throws CustomBusinessException;

}
