/**
 * 
 */
package com.catsvie.coc.investigator.business;

import java.util.Set;

import com.catsvie.coc.investigator.domain.BasicAttribute;

/**
 * @author Peng Wang<br/>
 *         Dec 22, 2015
 * @version 1.0 <br/>
 */
public interface BasiAttributeManager {
	/**
	 * Load a set of available basic attributes.
	 * 
	 * @return
	 */
	Set<BasicAttribute> loadBasicAttributes();
}
