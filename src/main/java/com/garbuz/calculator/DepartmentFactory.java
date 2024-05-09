package com.garbuz.calculator;

public class DepartmentFactory {

	private DepartmentFactory() {
	}
	
	public static final Department create(final String name) {
		Department department = new Department();
		Long id = IdGenerator.generateUniqueId();
		department.setId(id);
		department.setName(name);
		return department;
	}
}
