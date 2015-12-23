package com.catsvie.coc.commons.dice.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.catsvie.coc.commons.dice.exception.UnsupportedRollRuleException;

@RunWith(MockitoJUnitRunner.class)
public class RollRuleTest {
	@Test
	public void testParseRule1D100() throws Exception {
		RollRule expected = new RollRule(1, 100, null, 0);
		RollRule actual = RollRule.parseRule("1D100");
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testParseRule3D6Plus6() throws Exception {
		RollRule expected = new RollRule(3, 6, true, 6);
		RollRule actual = RollRule.parseRule("3D6+6");
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testParseRule2D8Minus2() throws Exception {
		RollRule expected = new RollRule(2, 8, false, 2);
		RollRule actual = RollRule.parseRule("2D8-2");
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = UnsupportedRollRuleException.class)
	public void testParseRule1() throws Exception {
		RollRule.parseRule("AD8");
	}
	
	@Test(expected = UnsupportedRollRuleException.class)
	public void testParseRule2() throws Exception {
		RollRule.parseRule("2DD8");
	}
	
	@Test(expected = UnsupportedRollRuleException.class)
	public void testParseRule3() throws Exception {
		RollRule.parseRule("2DB");
	}

}
