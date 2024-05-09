package com.garbuz.calculator;

import org.junit.Assert;
import org.junit.Test;

public class PayRateTest{

	@Test
	public void testPayRate() {
		Assert.assertEquals(new Double(50.0), PayRate.getBonusRate(JobType.EXECUTIVE));
	}
	@Test
	public void testBonusPayRate() {
		Assert.assertEquals(new Double(50.0), PayRate.getBonusRate(JobType.EXECUTIVE));
	}
	@Test
	public void testBonusPayRate_WronType() {
		Assert.assertEquals(new Double(0.0), PayRate.getBonusRate(JobType.INTERN));
	}
}
