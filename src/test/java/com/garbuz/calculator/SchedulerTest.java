package com.garbuz.calculator;

import org.junit.Assert;
import org.junit.Test;



public class SchedulerTest {
	
	@Test
	public void testSchedule() {
		
    	Department department = DepartmentFactory.create("Test Department");
    	
    	Company company = new Company();
    	company.addDepartment(department);
    	
    	
    	Schedule schedule = new Schedule();
    	
    	Employee e1 = EmployeeFactory.create("Test", "Employee 1",    JobType.EXECUTIVE);
    	Employee e2 = EmployeeFactory.create("Test", "Employee 2",    JobType.SUPERVISOR);
    	Employee e3 = EmployeeFactory.create("Test", "Employee 3",    JobType.MANAGER);
    	Employee e4 = EmployeeFactory.create("Test", "Employee 4",    JobType.INTERN);
    	Employee e5 = EmployeeFactory.create("Test", "Employee 5",    JobType.FLOOR_WORKER);
    	
    	
    	Scheduler.schedule(schedule, department, 10, e1);
    	Scheduler.schedule(schedule, department, 20, e2);
    	Scheduler.schedule(schedule, department, 30, e3);
    	Scheduler.schedule(schedule, department, 40, e4);
    	Scheduler.schedule(schedule, department, 50, e5);
    	
    	
    	Assert.assertEquals(new Integer(10), schedule.lookUpHoursByEmployee(e1));
    	Assert.assertEquals(new Integer(20), schedule.lookUpHoursByEmployee(e2));
    	Assert.assertEquals(new Integer(50), schedule.lookUpHoursByEmployee(e5));
	}
}
