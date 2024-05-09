package com.garbuz.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.garbuz.calculator.util.FileUtil;

public class CalculatorTest {

	private final static String EXPECTED_OUTPUT_BY_NAME = "Calculator-Pay-By-Last-Name.txt";
	private final static String EXPECTED_OUTPUT_BY_DEPARTMENT = "Calculator-Pay-By-Department.txt";
	
	private Department testDepartment1;
	private Department testDepartment2;
	private Company company;
	private Schedule schedule;
	private Calculator calc;
	
	@Before
	public void setUp() throws Exception {
		this.testDepartment1 = DepartmentFactory.create("Test department 1");
		this.testDepartment2 = DepartmentFactory.create("Test department 2");
    	
		this.company = new Company();
		this.company.addDepartment(testDepartment2);
		this.company.addDepartment(testDepartment1);
    	
		this.schedule = new Schedule();
    	
    	Scheduler.schedule(schedule, testDepartment1, 20, EmployeeFactory.create("Person 11", "Intern",      JobType.INTERN));
    	Scheduler.schedule(schedule, testDepartment1, 40, EmployeeFactory.create("Person 12", "Floor worker",JobType.FLOOR_WORKER));
    	Scheduler.schedule(schedule, testDepartment1, 30, EmployeeFactory.create("Person 13", "Supervisor",  JobType.SUPERVISOR));
    	Scheduler.schedule(schedule, testDepartment1, 40, EmployeeFactory.create("Person 14", "Manager",     JobType.MANAGER));
    	Scheduler.schedule(schedule, testDepartment1, 60, EmployeeFactory.create("Person 15", "Executive",   JobType.EXECUTIVE));
    	
    	Scheduler.schedule(schedule, testDepartment2, 20, EmployeeFactory.create("Person 21", "Intern",      JobType.INTERN));
    	Scheduler.schedule(schedule, testDepartment2, 40, EmployeeFactory.create("Person 22", "Floor worker",JobType.FLOOR_WORKER));
    	Scheduler.schedule(schedule, testDepartment2, 30, EmployeeFactory.create("Person 23", "Supervisor",  JobType.SUPERVISOR));
    	Scheduler.schedule(schedule, testDepartment2, 40, EmployeeFactory.create("Person 24", "Manager",     JobType.MANAGER));
    	Scheduler.schedule(schedule, testDepartment2, 60, EmployeeFactory.create("Person 25", "Executive",   JobType.EXECUTIVE));
    	
    	
    	this.calc = CalculatorFactory.create(company, schedule);
	}
	
	@Test
	public void calculateOvertimePay() {
		Calculator calc = CalculatorFactory.create(new Company(), new Schedule());
		
		Assert.assertEquals(0.0, calc.calculateOvertimePay(10.0, 30), 0);
		Assert.assertEquals(0.0, calc.calculateOvertimePay(10.0, 40), 0);
		Assert.assertEquals(150.0, calc.calculateOvertimePay(10.0, 50), 0);
		
	}
	
	@Test 
	public void calclulatePayByLastName() throws Exception {
    	String output = calc.calclulatePayByLastName();
    	// this line is commented out in case the output changes 
    	// and new expected output needs to be generated
    	//FileUtil.writeStringToFile(output, "C:\\tmp\\" + EXPECTED_OUTPUT_BY_NAME);
    	String expectedOutput = FileUtil.readFileFromClasspath(EXPECTED_OUTPUT_BY_NAME) ;
    	
    	Assert.assertEquals(expectedOutput.trim(), output.trim());
	}
	
	@Test 
	public void calculatePayByDepartment() throws Exception {
    	String output = calc.calculatePayByDepartment();
    	// this line is commented out in case the output changes 
    	// and new expected output needs to be generated
    	//FileUtil.writeStringToFile(output, "C:\\tmp\\" + EXPECTED_OUTPUT_BY_DEPARTMENT);
    	String expectedOutput = FileUtil.readFileFromClasspath(EXPECTED_OUTPUT_BY_DEPARTMENT) ;
    	
    	Assert.assertEquals(expectedOutput.trim(), output.trim());
	}
}
