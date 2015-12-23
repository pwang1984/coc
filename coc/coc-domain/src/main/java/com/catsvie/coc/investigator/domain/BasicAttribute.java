/**
 * 
 */
package com.catsvie.coc.investigator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents the basic attributes in game and database
 * 
 * @author Peng Wang<br/>
 *         Dec 21, 2015
 * @version 1.0 <br/>
 */
@Entity
@Table(name = "BASIC_ATTRIBUTE")
public class BasicAttribute {
	@Id
	@Column(length = 8)
	private String id;

	/**
	 * name of the attribute.
	 * 
	 * 
	 */
	@Column
	private String name;

	/**
	 * Description of the attribute.
	 * 
	 */
	@Column
	private String description;

	/**
	 * The generate attribute rule.
	 * 
	 */
	@Column
	private String generateRule;

}
