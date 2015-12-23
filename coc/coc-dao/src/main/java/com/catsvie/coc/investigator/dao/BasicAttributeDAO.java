/**
 * 
 */
package com.catsvie.coc.investigator.dao;

import java.util.Set;

import com.catsvie.coc.investigator.domain.BasicAttribute;

/**
 * @author Peng Wang<br/>
 *         Dec 22, 2015
 * @version 1.0 <br/>
 */
public interface BasicAttributeDAO {
	Set<BasicAttribute> loadBasicAttributes();
}
