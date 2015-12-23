/**
 * 
 */
package com.catsvie.coc.commons.dice;

import com.catsvie.coc.commons.dice.exception.RollDiceException;

/**
 * A manager that controls dice in game.
 * 
 * @author Peng Wang<br/>
 *         Dec 21, 2015
 * @version 1.0 <br/>
 */
public interface DiceManager {
	/**
	 * Roll the dice according to the rule
	 * 
	 * @param rule
	 *            - how many and which dice(s) to roll. Then do + or - to amend
	 *            the result.<br/>
	 *            For example, 1D100 means roll a 100 sides dice. 2D6+6 means
	 *            roll two 6 sides dice, then plus 6 to the result
	 * @return
	 * @throws RollDiceException
	 */
	DiceResult rollDice(String rule) throws RollDiceException;
}
