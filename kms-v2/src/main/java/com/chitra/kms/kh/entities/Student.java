package com.chitra.kms.kh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="kms_student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="gender", length=1, nullable=false)
	private String gender = Gender.NOT.getGender();
	@Column(name="state")
	private State state;
	@Column(name="birth_date")
	private String dateOfBirth;
	
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name="email")
	private String email;
	
	@ManyToOne(optional= false)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="address_id")
	private Address address;
	@Column(name="house_no")
	private String houseNumber;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="parent_id")
	private Parent parent;
	
	

}
