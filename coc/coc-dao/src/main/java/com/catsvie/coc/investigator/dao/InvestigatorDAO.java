/**
 * 
 */
package com.catsvie.coc.investigator.dao;

import com.catsvie.coc.investigator.domain.Investigator;

/**
 * @author Peng Wang<br/>
 *         Dec 22, 2015
 * @version 1.0 <br/>
 */
public interface InvestigatorDAO {
	Investigator findInvestigator(long id);

	Investigator saveInvestigator(Investigator investigator);
}
