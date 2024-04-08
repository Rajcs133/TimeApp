package com.microservice.TimeSheetService.Services;

public enum Mode {
	INSERT, DELETE, APPROVE, RETRIEVE;

	@Override
	public String toString() {
		return name();
	}

}
