package com.garbuz.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	
	
	@Test
	public void calculateOvertimePay() {
		Calculator calc = CalculatorFactory.create(new Company(), new Schedule());
		
		Assert.assertEquals(0.0, calc.calculateOvertimePay(10.0, 30), 0);
		Assert.assertEquals(0.0, calc.calculateOvertimePay(10.0, 40), 0);
		Assert.assertEquals(150.0, calc.calculateOvertimePay(10.0, 50), 0);
		
	}
}
