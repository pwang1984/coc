/**
 * 
 */
package com.catsvie.coc.commons.dice.impl;

import com.catsvie.coc.commons.dice.DiceResult;

/**
 * @author Peng Wang<br/>
 *         Dec 21, 2015
 * @version 1.0 <br/>
 */
class DiceResultImpl implements DiceResult {
	private int total;

	/**
	 * @param total
	 */
	DiceResultImpl(int total) {
		super();
		this.total = total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.catsvie.coc.commons.dice.DiceResult#getTotal()
	 */
	@Override
	public int getTotal() {
		return total;
	}

}
