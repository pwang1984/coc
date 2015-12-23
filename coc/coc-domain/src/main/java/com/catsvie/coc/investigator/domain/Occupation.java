/**
 * 
 */
package com.catsvie.coc.investigator.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Represents occupation in the game and database.
 * 
 * @author Peng Wang<br/>
 *         Dec 21, 2015
 * @version 1.0 <br/>
 */
@Entity
@Table(name = "OCCUPATION")
public class Occupation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;

	@Column
	private String name;

	@Column
	private String description;

	@ManyToMany
	@JoinTable(name = "OCCUPATION_SKILL")
	private Set<Skill> skills;
}
