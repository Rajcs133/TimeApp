package com.microservice.TimeSheetService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.Services.TimeSheetService;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

@RestController
@RequestMapping
public class TimeSheetServiceController {
	
	@Autowired
	TimeSheetService loTimeSheetService;
	
	 
	
	@PostMapping(path = "/saveTimeSheetEntryCheck")
	public ResponseEntity<TimeSheetEntity> saveTimeSheetEntry1(@RequestBody TimeSheetEntity poTimeSheetEntity) throws CustomBusinessException{
		poTimeSheetEntity = loTimeSheetService.saveTimeSheetEntry1(poTimeSheetEntity);
		return new ResponseEntity<>(poTimeSheetEntity, HttpStatus.OK);
		
	}
		
	

	
	@GetMapping(path = "/getEntry/{Id}")
	public ResponseEntity<TimeSheetEntity> getEntryBasedOnId(@PathVariable("Id") int Id) throws Exception{
	 
		TimeSheetEntity poTimeSheetEntity = loTimeSheetService.getEntryBasedOnId(Id);
		return new ResponseEntity<>(poTimeSheetEntity, HttpStatus.OK);
				
	}
	
	
	@GetMapping(path = "/getSortedPaginatedEntries")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Page<TimeSheetEntity>> getEntriesBasedOnPaginationAndSorting(@RequestParam(name="offset",required = false) Integer psOffset,@RequestParam(name="pagesize",required = false) Integer psPageSize,@RequestParam(name = "fieldName", required = false) String psFieldName) throws Exception{
	 
		loTimeSheetService.getEntriesBasedOnPaginationAndSorting(psOffset, psPageSize, psFieldName);
		
		return new ResponseEntity<>(loTimeSheetService.getEntriesBasedOnPaginationAndSorting(psOffset,psPageSize,psFieldName), HttpStatus.OK);
			
	}
	
	

	
	
	
	
}
