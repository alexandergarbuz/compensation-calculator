package com.garbuz.calculator;

public class EmployeeFactory {

	private EmployeeFactory() {}
	
	public static final Employee create(final String firstName, final String lastName, final JobType jobType) {
		Employee employee = new Employee();
		Long id = IdGenerator.generateUniqueId();
		employee.setId(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setJobType(jobType);
		return employee;
	}
}
