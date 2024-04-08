package com.microservice.TimeSheetService.Services;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

@Service
public class TimeSheetService {


	@Autowired
	UserFactory loUserFactory;
	

	public IUserActivity getUserObject() {
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		boolean isAdmin = authorities.stream().map(GrantedAuthority::getAuthority)
				.anyMatch(authority -> "ROLE_ADMIN".equals(authority));

		return isAdmin ? ((UserFactory) loUserFactory).getUserObj("ADMIN")
				: ((UserFactory) loUserFactory).getUserObj("EMPLOYEE");
	}

	public TimeSheetEntity saveTimeSheetEntry1(TimeSheetEntity poTimeSheetEntity) throws CustomBusinessException {

		TimeSheetEntity lsTimeSheetEntity = (TimeSheetEntity) getUserObject().performTimeSheetTask(poTimeSheetEntity,
				Mode.INSERT);
	
		return lsTimeSheetEntity;

	}



	public TimeSheetEntity getEntryBasedOnId(int id) throws Exception {
		
		TimeSheetEntity lsTimeSheetEntity = new TimeSheetEntity();
		lsTimeSheetEntity.getLsUserEntity().setLsUserid(id);
		
		lsTimeSheetEntity = (TimeSheetEntity) getUserObject().performTimeSheetTask(lsTimeSheetEntity,
				Mode.RETRIEVE);
		
		return lsTimeSheetEntity;

	}

	
	public Page<TimeSheetEntity> getEntriesBasedOnPaginationAndSorting(Integer offset, Integer pagesize,
			String psFieldName) throws CustomBusinessException {
		
		return (Page<TimeSheetEntity>) ((Manager)getUserObject()).getEntriesBasedOnPaginationAndSorting( offset,  pagesize,
				 psFieldName);
	
	}
	

}
