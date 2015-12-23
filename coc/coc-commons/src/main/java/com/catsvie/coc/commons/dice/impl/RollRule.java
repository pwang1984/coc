/**
 * 
 */
package com.catsvie.coc.commons.dice.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.catsvie.coc.commons.dice.DiceManager;
import com.catsvie.coc.commons.dice.exception.UnsupportedRollRuleException;

/**
 * Represents the roll rule.
 * 
 * @author Peng Wang<br/>
 *         Dec 21, 2015
 * @version 1.0 <br/>
 */
class RollRule {
	private final static String ROLL_RULL_PATTERN = "^(\\d+)D(\\d+)(([\\+|-])(\\d+))?$";

	/**
	 * Parse the rolling dice rule.
	 * 
	 * @param rule
	 *            - rolling dice rule. See {@link DiceManager#rollDice(String)}
	 *            for detailed explanation.
	 * @return
	 * @throws UnsupportedRollRuleException
	 */
	static RollRule parseRule(String rule) throws UnsupportedRollRuleException {
		Pattern p = Pattern.compile(ROLL_RULL_PATTERN);
		Matcher m = p.matcher(rule);
		if (m.find()) {
			int diceNumber = Integer.valueOf(m.group(1));
			int diceSides = Integer.valueOf(m.group(2));
			Boolean amendPlus = null;
			int amendValue = 0;
			if (m.groupCount() > 4 && m.group(3) != null) {
				amendPlus = (m.group(4).equals("+"));
				amendValue = Integer.valueOf(m.group(5));
			}
			return new RollRule(diceNumber, diceSides, amendPlus, amendValue);
		} else {
			throw new UnsupportedRollRuleException();
		}
	}

	private Boolean amendPlus;
	private int amendValue;
	private int diceNumber;

	private int diceSides;

	/**
	 * @param diceNumber
	 * @param diceSides
	 * @param amendPlus
	 * @param amendValue
	 */
	RollRule(int diceNumber, int diceSides, Boolean amendPlus, int amendValue) {
		super();
		this.diceNumber = diceNumber;
		this.diceSides = diceSides;
		this.amendPlus = amendPlus;
		this.amendValue = amendValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amendPlus == null) ? 0 : amendPlus.hashCode());
		result = prime * result + amendValue;
		result = prime * result + diceNumber;
		result = prime * result + diceSides;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RollRule other = (RollRule) obj;
		if (amendPlus == null) {
			if (other.amendPlus != null)
				return false;
		} else if (!amendPlus.equals(other.amendPlus))
			return false;
		if (amendValue != other.amendValue)
			return false;
		if (diceNumber != other.diceNumber)
			return false;
		if (diceSides != other.diceSides)
			return false;
		return true;
	}

	/**
	 * @return the amendValue
	 */
	int getAmendValue() {
		return amendValue;
	}

	/**
	 * @return the diceNumber
	 */
	int getDiceNumber() {
		return diceNumber;
	}

	/**
	 * @return the diceSides
	 */
	int getDiceSides() {
		return diceSides;
	}

	/**
	 * @return the amendPlus
	 */
	Boolean isAmendPlus() {
		return amendPlus;
	}

}
