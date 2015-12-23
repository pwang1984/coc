/**
 * 
 */
package com.catsvie.coc.investigator.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.catsvie.coc.investigator.dao.InvestigatorDAO;
import com.catsvie.coc.investigator.domain.Investigator;

/**
 * @author Peng Wang<br/>
 *         Dec 22, 2015
 * @version 1.0 <br/>
 */
public class InvestigatorDAOImpl implements InvestigatorDAO {
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.catsvie.coc.investigator.dao.InvestigatorDAO#findInvestigator(long)
	 */
	@Override
	public Investigator findInvestigator(long id) {
		return entityManager.find(Investigator.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.catsvie.coc.investigator.dao.InvestigatorDAO#saveInvestigator(com.
	 * catsvie.coc.investigator.domain.Investigator)
	 */
	@Override
	public Investigator saveInvestigator(Investigator investigator) {
		return entityManager.merge(investigator);
	}

}
