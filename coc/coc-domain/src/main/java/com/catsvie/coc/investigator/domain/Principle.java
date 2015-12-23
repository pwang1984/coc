/**
 * 
 */
package com.catsvie.coc.investigator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Peng Wang<br/>
 *         Dec 22, 2015
 * @version 1.0 <br/>
 */
@Entity
@Table(name = "PRINCIPLE")
public class Principle {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String description;
}
