package com.microservice.TimeSheetService.Services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.Entity.UserTimeSheetEntity;
import com.microservice.TimeSheetService.Repositories.TimeSheetRepo;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

@SpringBootTest
public class TimeSheetServiceTest {
	
	
	@InjectMocks
	TimeSheetService loTimeSheetService;
	
	@Mock
	TimeSheetRepo loRepo;
	
	@Test
	/*
	 * public void getEntryBasedOnIdTest() throws Exception {
	 * 
	 * //Given int id=1;
	 * 
	 * when(loRepo.findById(id)).thenReturn(getStub());
	 * 
	 * // When
	 * 
	 * UserTimeSheetEntity loTimeSheet = loTimeSheetService.getEntryBasedOnId(1);
	 * 
	 * //Then assertEquals(loTimeSheet.getLsUserid(), 1);
	 * 
	 * }
	 * 
	 * @Test public void testGetEntryBasedOnId_WhenEmpty() throws Exception { //
	 * Given int id = 2; when(loRepo.findById(id)).thenReturn(Optional.empty());
	 * 
	 * // When/Then CustomBusinessException loCustomException =
	 * assertThrows(CustomBusinessException.class, () -> {
	 * loTimeSheetService.getEntryBasedOnId(id); });
	 * 
	 * assertEquals("There is no Entry for the given Id",
	 * loCustomException.getMessage()); }
	 * 
	 * 
	 * 
	 * @Test public void getTimeSheetEntry() throws Exception {
	 * 
	 * // Given when(loRepo.findAll()).thenReturn(getStub3());
	 * List<UserTimeSheetEntity> listofTimeSheetExpected =getStub3();
	 * 
	 * //When
	 * 
	 * List<UserTimeSheetEntity> loTimeSheet =
	 * loTimeSheetService.getTimeSheetEntry();
	 * 
	 * 
	 * //Then assertArrayEquals(loTimeSheet.toArray(),
	 * listofTimeSheetExpected.toArray());
	 * 
	 * }
	 * 
	 * 
	 * @Test public void testSaveTimeSheetEntry() { // Given UserTimeSheetEntity
	 * timeSheetEntityToSave = new UserTimeSheetEntity(); UserTimeSheetEntity
	 * savedTimeSheetEntity = getStub().get(); // Mock saved entity // Mocking the
	 * repository save method call
	 * when(loRepo.save(timeSheetEntityToSave)).thenReturn(getStub().get());
	 * 
	 * // When UserTimeSheetEntity result =
	 * loTimeSheetService.saveTimeSheetEntry(timeSheetEntityToSave);
	 * 
	 * // Then verify(loRepo, times(1)).save(timeSheetEntityToSave);
	 * 
	 * assertEquals(savedTimeSheetEntity, result,
	 * "Returned entity should match the mock saved entity"); }
	 */
	
	
	
	private Optional<UserTimeSheetEntity> getStub() {
		return Optional.of(UserTimeSheetEntity.builder().lsUserid(1).lsUserName("Raj").loTimeSheetEntries(getStub2()).build());
	}
	
	
    private List<UserTimeSheetEntity> getStub3() {
		
		List<UserTimeSheetEntity> listofTimeSheet =new ArrayList<UserTimeSheetEntity>();
		listofTimeSheet.add(getStub().get());
		listofTimeSheet.add(getStub().get());
		return listofTimeSheet;
	}
	

	private List<TimeSheetEntity> getStub2() {
		
		List<TimeSheetEntity> listofTimeSheet =new ArrayList<TimeSheetEntity>();
		listofTimeSheet.add(TimeSheetEntity.builder().id(1).lsInputChannel("QC").build());
		listofTimeSheet.add(TimeSheetEntity.builder().id(2).lsInputChannel("Jira").build());
		return listofTimeSheet;
	}
	

}
