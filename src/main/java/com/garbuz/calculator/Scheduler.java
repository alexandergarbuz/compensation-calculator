package com.garbuz.calculator;

public class Scheduler {
	
	private Scheduler() {}
	
	public static final void schedule(final Schedule schedule, final Department departmentToPlaceEmployee, final int numberOfHours, final Employee employeeToSchedule) {
		schedule.addEmployee(employeeToSchedule, numberOfHours);
		departmentToPlaceEmployee.addEmployee(employeeToSchedule);
	}
}
