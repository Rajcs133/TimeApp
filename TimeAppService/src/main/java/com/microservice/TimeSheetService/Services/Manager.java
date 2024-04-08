package com.microservice.TimeSheetService.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

@Service(Manager.BEAN_ID)
public class Manager extends Employee  {

	public static final String BEAN_ID = "ADMIN";

	@Autowired
	ITimeSheet loTimeSheetService;

	public TimeSheetEntity approveTimeSheet(TimeSheetEntity loTimeSheet) {
		return loTimeSheet;
	}

	@Override
	public TimeSheetEntity performTimeSheetTask(TimeSheetEntity poTimeSheet, Mode psMode) throws CustomBusinessException {
		
		if (psMode.equals(Mode.APPROVE)) {
			poTimeSheet = approveTimeSheet(poTimeSheet);
		}
		
		return poTimeSheet;
	}

	public Page<TimeSheetEntity> getEntriesBasedOnPaginationAndSorting(Integer offset, Integer pagesize,
			String psFieldName)
			throws CustomBusinessException {

		return loTimeSheetService.getEntriesBasedOnPaginationAndSorting( offset,  pagesize,
				 psFieldName);

	}


}
