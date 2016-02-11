package com.chitra.kms.kh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private State state;
	@Column(name="birth_date")
	private String dateOfBirth;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//private Address address;
	

}
