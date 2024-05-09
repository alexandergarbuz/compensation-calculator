package com.garbuz.calculator;

public class CalculatorFactory {

	private CalculatorFactory() {}
	
	public static final Calculator create(final Company company, final Schedule schedule) {
		Calculator calculator = new Calculator();
		calculator.setCompany(company);
		calculator.setSchedule(schedule);
		return calculator;
	}
	
}
