package com.garbuz.calculator;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private Long id;
	private String name;
	private List<Employee> employees = new ArrayList<Employee>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void addEmployee(final Employee employeeToAdd) {
		this.employees.add(employeeToAdd);
	}
}
