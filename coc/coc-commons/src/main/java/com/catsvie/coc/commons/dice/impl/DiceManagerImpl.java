/**
 * 
 */
package com.catsvie.coc.commons.dice.impl;

import java.util.Random;

import javax.inject.Inject;

import com.catsvie.coc.commons.dice.DiceManager;
import com.catsvie.coc.commons.dice.DiceResult;
import com.catsvie.coc.commons.dice.exception.RollDiceException;

/**
 * @author Peng Wang<br/>
 *         Dec 21, 2015
 * @version 1.0 <br/>
 */
class DiceManagerImpl implements DiceManager {
	@Inject
	private Random random;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.catsvie.coc.commons.dice.DiceManager#rollDice(java.lang.String)
	 */
	@Override
	public DiceResult rollDice(String rule) throws RollDiceException {
		RollRule rollRule = RollRule.parseRule(rule);
		int res = 0;
		for (int i = 0; i < rollRule.getDiceNumber(); i++) {
			res += random.nextInt(rollRule.getDiceSides()) + 1;

		}
		if (rollRule.isAmendPlus() != null) {
			if (rollRule.isAmendPlus()) {
				res += rollRule.getAmendValue();
			} else {
				res -= rollRule.getAmendValue();
			}
		}
		return new DiceResultImpl(res);
	}

}
