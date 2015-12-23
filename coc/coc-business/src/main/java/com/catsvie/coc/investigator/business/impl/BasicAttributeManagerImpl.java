/**
 * 
 */
package com.catsvie.coc.investigator.business.impl;

import java.util.Set;

import javax.inject.Inject;

import com.catsvie.coc.investigator.business.BasiAttributeManager;
import com.catsvie.coc.investigator.dao.BasicAttributeDAO;
import com.catsvie.coc.investigator.domain.BasicAttribute;

/**
 * @author Peng Wang<br/>
 *         Dec 22, 2015
 * @version 1.0 <br/>
 */
public class BasicAttributeManagerImpl implements BasiAttributeManager {
	@Inject
	private BasicAttributeDAO basicAttributeDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.catsvie.coc.investigator.business.BasiAttributeManager#
	 * loadBasicAttributes()
	 */
	@Override
	public Set<BasicAttribute> loadBasicAttributes() {
		return basicAttributeDAO.loadBasicAttributes();
	}

}
