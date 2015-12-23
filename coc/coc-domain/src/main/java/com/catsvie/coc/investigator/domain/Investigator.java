/**
 * 
 */
package com.catsvie.coc.investigator.domain;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents the Investigator in game and database
 * 
 * @author Peng Wang<br/>
 *         Dec 21, 2015
 * @version 1.0 <br/>
 * 
 */
@Entity
@Table(name = "INVESTIGATOR")
public class Investigator {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * name of the investigator
	 * 
	 */
	@Column(nullable = false, length = 64)
	private String name;

	/**
	 * age of the investigator
	 * 
	 */
	@Column(nullable = false)
	private int age;

	/**
	 * background of the investigator
	 * 
	 */
	@Column
	private String background;
	/**
	 * Remaining health point of the investigator
	 * 
	 */
	@Column
	private int hp;

	@ManyToMany
	@JoinTable(name = "INVESTIGATOR_ATTRIBUTE")
	private Map<String, BasicAttribute> basicAttributeSet;

	@ManyToOne
	private Occupation occupation;

	@ManyToMany
	@JoinTable(name = "INVESTIGATOR_SKILL")
	private Map<Long, Skill> skills;

}
