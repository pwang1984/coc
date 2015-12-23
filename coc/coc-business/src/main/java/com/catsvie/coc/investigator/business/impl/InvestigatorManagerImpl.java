/**
 * 
 */
package com.catsvie.coc.investigator.business.impl;

import java.util.Set;

import javax.inject.Inject;

import com.catsvie.coc.commons.dice.DiceManager;
import com.catsvie.coc.commons.dice.exception.RollDiceException;
import com.catsvie.coc.investigator.business.BasiAttributeManager;
import com.catsvie.coc.investigator.business.InvestigatorManager;
import com.catsvie.coc.investigator.domain.BasicAttribute;
import com.catsvie.coc.investigator.domain.Investigator;

/**
 * @author Peng Wang<br/>
 *         Dec 22, 2015
 * @version 1.0 <br/>
 */
public class InvestigatorManagerImpl implements InvestigatorManager {
	@Inject
	private BasiAttributeManager basiAttributeManager;

	@Inject
	private DiceManager diceManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.catsvie.coc.investigator.business.InvestigatorManager#
	 * initInvestigator()
	 */
	@Override
	public Investigator initInvestigator() throws RollDiceException {
		Set<BasicAttribute> attributes = basiAttributeManager.loadBasicAttributes();
		Investigator investigator = new Investigator();

		for (BasicAttribute attribute : attributes) {
			int value = diceManager.rollDice(attribute.getGenerateRule()).getTotal();
		}

		return investigator;
	}

}
