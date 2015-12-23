/**
 * 
 */
package com.catsvie.coc.commons.dice.exception;

/**
 * @author Peng Wang<br/>
 *         Dec 21, 2015
 * @version 1.0 <br/>
 */
public class RollDiceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6152551819150842387L;

	/**
	 * 
	 */
	public RollDiceException() {
		super();
		
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RollDiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RollDiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public RollDiceException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public RollDiceException(Throwable cause) {
		super(cause);
		
	}

}
