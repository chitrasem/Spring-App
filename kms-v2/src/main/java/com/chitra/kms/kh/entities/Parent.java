package com.chitra.kms.kh.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kms_parent")
public class Parent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private long id;
	@Column(name="km_f_name")
	private String kmFName;
	
	@Column(name="f_name")
	private String fName;
	
	@Column(name="f_job")	
	private String fJob;
	
	@Column(name="f_phone")
	private String fPhone;
	
	@Column(name="f_birth_date")
	private Date fDateOfBirth;
	
	@Column(name="km_m_name")
	private String kmMName;
	
	@Column(name="m_name")
	private String mName;
	
	@Column(name="m_job")
	private String mJob;
	
	@Column(name="m_phone")
	private String mPhone;
	
	@Column(name="m_birth_date")
	private Date mDateOfBirth;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKmFName() {
		return kmFName;
	}

	public void setKmFName(String kmFName) {
		this.kmFName = kmFName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfJob() {
		return fJob;
	}

	public void setfJob(String fJob) {
		this.fJob = fJob;
	}

	public String getfPhone() {
		return fPhone;
	}

	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}

	public Date getfDateOfBirth() {
		return fDateOfBirth;
	}

	public void setfDateOfBirth(Date fDateOfBirth) {
		this.fDateOfBirth = fDateOfBirth;
	}

	public String getKmMName() {
		return kmMName;
	}

	public void setKmMName(String kmMName) {
		this.kmMName = kmMName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmJob() {
		return mJob;
	}

	public void setmJob(String mJob) {
		this.mJob = mJob;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public Date getmDateOfBirth() {
		return mDateOfBirth;
	}

	public void setmDateOfBirth(Date mDateOfBirth) {
		this.mDateOfBirth = mDateOfBirth;
	}
	
	

}
