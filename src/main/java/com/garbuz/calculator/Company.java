package com.garbuz.calculator;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private List<Department> departments = new ArrayList<Department>();

	public List<Department> getDepartments() {
		return departments;
	}

	public void addDepartment(final Department departmentToAdd) {
		this.departments.add(departmentToAdd);
	}
}
