/**
 * 
 */
package com.catsvie.coc.commons.dice.exception;

/**
 * @author Peng Wang<br/>
 *         Dec 21, 2015
 * @version 1.0 <br/>
 */
public class UnsupportedRollRuleException extends RollDiceException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6283680864037663714L;

	/**
	 * 
	 */
	public UnsupportedRollRuleException() {
		super();

	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public UnsupportedRollRuleException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);

	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public UnsupportedRollRuleException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	/**
	 * @param arg0
	 */
	public UnsupportedRollRuleException(String arg0) {
		super(arg0);

	}

	/**
	 * @param arg0
	 */
	public UnsupportedRollRuleException(Throwable arg0) {
		super(arg0);

	}

}
