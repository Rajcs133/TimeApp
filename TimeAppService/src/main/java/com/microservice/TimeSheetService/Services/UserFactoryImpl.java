package com.microservice.TimeSheetService.Services;

import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserFactoryImpl implements UserFactory {

	public final Map<String,IUserActivity> allUserObj;
	
	
	@Override
	public IUserActivity getUserObj(String psRole) {
		return allUserObj.get(psRole);
	}

}
