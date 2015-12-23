/**
 * 
 */
package com.catsvie.coc.investigator.domain;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
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
	 * Sanity
	 * 
	 */
	@Column
	private long sanity;

	// /**
	// * principle of the investigator
	// */
	// @ManyToOne
	// private Principle principle;
	//
	// /**
	// * Important person
	// */
	// @ManyToOne
	// private ImportantPeople importantPeople;

	/**
	 * Why {@link Investigator#importantPeople} are important
	 * 
	 */
	@ManyToOne
	private ImportantPeopleReason importantPeopleReason;

	/**
	 * Remaining health point of the investigator
	 * 
	 */
	@Column
	private int hp;

	@ElementCollection
	@CollectionTable(name = "INVESTIGATOR_ATTRIBUTE", joinColumns = @JoinColumn(name = "investigator") )
	@MapKeyJoinColumn(name = "attribute", referencedColumnName = "id")
	@Column(name = "value")
	private Map<BasicAttribute, Integer> attibuteValues;

	@ManyToOne
	private Occupation occupation;

	@ElementCollection
	@CollectionTable(name = "INVESTIGATOR_SKILL", joinColumns = @JoinColumn(name = "investigator") )
	@MapKeyJoinColumn(name = "skill", referencedColumnName = "id")
	@Column(name = "value")
	private Map<Skill, Integer> skills;

}
