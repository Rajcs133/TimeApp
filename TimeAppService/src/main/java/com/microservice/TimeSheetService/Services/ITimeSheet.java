package com.microservice.TimeSheetService.Services;

import org.springframework.data.domain.Page;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

public interface ITimeSheet {
	
	public TimeSheetEntity saveTimeSheetEntity(TimeSheetEntity poTimeSheetEntity);
	
	public TimeSheetEntity deleteTimeSheetEntity(TimeSheetEntity poTimeSheetEntity);
	
	public TimeSheetEntity approveTimeSheetEntity(TimeSheetEntity poTimeSheetEntity);
	
	public TimeSheetEntity getTimeSheetEntry(int lnUserId) throws CustomBusinessException;
	
	public Page<TimeSheetEntity> getEntriesBasedOnPaginationAndSorting(Integer psOffset,Integer psPageSize,String psFieldName) throws CustomBusinessException;
	
}
