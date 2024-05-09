package com.garbuz.calculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

	public static final String LINE_SEPARATOR = System.lineSeparator();
	public static final double OVERTIME_RATE = 1.5;
	public static final int OVERTIME_THRESHHOLD = 40;
	
	private Company company = new Company();
	private Schedule schedule = new Schedule();

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	
	protected List<Department> sortDepartmentsByName(List<Department> unsortedDepartments) {
    	List<Department> sortedDepartments = unsortedDepartments
    			.stream()
    			.sorted(Comparator.comparing(Department::getName))
    			.collect(Collectors.toList());
    	return sortedDepartments;
	}
	protected List<Employee> sortEmployeesByLastNameAndFirstName(List<Employee> unsortedEmployees) {
		List<Employee> sortedEmployees = unsortedEmployees
				.stream()
				.sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
				.collect(Collectors.toList());
		return sortedEmployees;
	}
	
	protected String printEmployeeCompensation(final Employee employeeToPrint, int hoursWorked, double total, double overtime, double bonus) {
		StringBuilder out = new StringBuilder();
		
		out.append(employeeToPrint.getLastName()).append(", ").append(employeeToPrint.getFirstName()) 
		.append(" (").append(employeeToPrint.getJobType().getTypeName()).append(")") 
		.append(" Hours: ").append( hoursWorked) 
		.append(" Total: $").append(total  )
		.append(" Overtime pay: $").append(overtime) 
		.append(" Bonus pay: $").append(bonus)
		.append(LINE_SEPARATOR);
		
		return out.toString();
	}
	
	protected double calculateOvertimePay(double hourlyRate, int hoursWorked) {
		int overtimeHours = (OVERTIME_THRESHHOLD < hoursWorked) ? hoursWorked - OVERTIME_THRESHHOLD : 0;
		double overtimePay = overtimeHours * hourlyRate * OVERTIME_RATE;
		return overtimePay;
	}

	public String calculatePayByDepartment() {
		
		final StringBuilder out = new StringBuilder();
    	final List<Department> departments = sortDepartmentsByName(this.company.getDepartments());
    	for(Department department : departments) {
    		
    		final List<Employee> employees = sortEmployeesByLastNameAndFirstName(department.getEmployees());
    		double totalByDepartment = 0.0;
    		for (Employee emp : employees) {
    			
    			double hourlyRate = PayRate.getHourlyRate(emp.getJobType());
    			double bonusRate  = PayRate.getBonusRate(emp.getJobType());
    			int hoursWorked   = schedule.lookUpHoursByEmployee(emp);

    			double overtimePay = calculateOvertimePay(hourlyRate, hoursWorked);
    			double totalCompensation = hourlyRate * hoursWorked + overtimePay + bonusRate;

    			totalByDepartment += totalCompensation;
    			
    			out.append(printEmployeeCompensation(emp,hoursWorked,totalCompensation,overtimePay,bonusRate));
    		}
    		out.append("_______________________________").append(LINE_SEPARATOR);
    		out.append("Total By '").append(department.getName()).append("' Deartment: $").append(totalByDepartment).append(LINE_SEPARATOR);
    		out.append(LINE_SEPARATOR);
    	}
		
		
		return out.toString();
	}

	public String calclulatePayByLastName() {
		
		final StringBuilder out = new StringBuilder();
    	final List<Department> departments = this.company.getDepartments();
    	final List<Employee> allEmployees = new ArrayList<>();
    	for(Department department : departments) {
    		allEmployees.addAll(department.getEmployees());
    	}
    	
    	final List<Employee> sortedEmployees = sortEmployeesByLastNameAndFirstName(allEmployees);
		double totalForCompany = 0.0;
		for (Employee emp : sortedEmployees) {
			
			double hourlyRate = PayRate.getHourlyRate(emp.getJobType());
			double bonusRate  = PayRate.getBonusRate(emp.getJobType());
			int hoursWorked   = schedule.lookUpHoursByEmployee(emp);

			double overtimePay = calculateOvertimePay(hourlyRate, hoursWorked);
			double totalCompensation = hourlyRate * hoursWorked + overtimePay + bonusRate;

			totalForCompany += totalCompensation;
			
			out.append(printEmployeeCompensation(emp,hoursWorked,totalCompensation,overtimePay,bonusRate));
		}
		out.append("_______________________________").append(LINE_SEPARATOR);
		out.append("Total $").append(totalForCompany).append(LINE_SEPARATOR);
		out.append(LINE_SEPARATOR);    	

		
		
		return out.toString();
	}
}
