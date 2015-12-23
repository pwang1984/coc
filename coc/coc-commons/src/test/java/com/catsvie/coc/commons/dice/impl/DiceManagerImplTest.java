package com.catsvie.coc.commons.dice.impl;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.catsvie.coc.commons.dice.DiceResult;

@RunWith(MockitoJUnitRunner.class)
public class DiceManagerImplTest {
	@Mock
	private Random random;
	@InjectMocks
	private DiceManagerImpl diceManagerImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRollDice1D100Total() throws Exception {
		int expected = 77;
		Mockito.when(random.nextInt(100)).thenReturn(expected - 1);
		DiceResult actual = diceManagerImpl.rollDice("1D100");
		Assert.assertEquals(expected, actual.getTotal());
	}

	@Test
	public void testRollDice3D6Total() throws Exception {
		int expected = 18;
		Mockito.when(random.nextInt(6)).thenReturn(5);
		DiceResult actual = diceManagerImpl.rollDice("3D6");
		Assert.assertEquals(expected, actual.getTotal());
	}

	@Test
	public void testRollDice2D6P6Total() throws Exception {
		int expected = 8;
		Mockito.when(random.nextInt(6)).thenReturn(0);
		DiceResult actual = diceManagerImpl.rollDice("2D6+6");
		Assert.assertEquals(expected, actual.getTotal());
	}

}
