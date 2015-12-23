/**
 * 
 */
package com.catsvie.coc.investigator.business;

import com.catsvie.coc.investigator.domain.Investigator;

/**
 * @author Peng Wang<br/>
 *         Dec 22, 2015
 * @version 1.0 <br/>
 */
public interface InvestigatorManager {
	/**
	 * Initialize an investigator. All basic attributes are randomly generated
	 * but no skills, name, or gender are set. TODO: JAVADOC METHOD
	 * 
	 * @return
	 */
	Investigator initInvestigator();
}
