package com.garbuz.calculator;

import java.util.HashMap;
import java.util.Map;

public class Schedule {
	
	private Map<Long, Integer> scheduleByEmployeeId = new HashMap<Long, Integer>();

	public void addEmployee(final Employee employeeToAdd, final int hoursScheduled) {
		this.scheduleByEmployeeId.put(employeeToAdd.getId(), new Integer (hoursScheduled));
	}
	
	public Integer lookUpHoursByEmployee(final Employee employeeToLookup) {
		return this.scheduleByEmployeeId.get(employeeToLookup.getId());
	}
}
