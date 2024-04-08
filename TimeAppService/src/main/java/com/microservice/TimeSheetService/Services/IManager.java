package com.microservice.TimeSheetService.Services;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;

public interface IManager extends IUserActivity {

	public boolean approveTimeSheetEntry(TimeSheetEntity loTimeSheet);
	
}
