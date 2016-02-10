package com.chitra.kms.kh.entities;

import java.util.HashSet;
import java.util.Set;

public class Province {
	
	private long id;
	private String code;
	private String kName;
	private String eName;
	private String reference;
	private String note;
	private String issueDate;
	private Set<District> districts = new HashSet<District>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getkName() {
		return kName;
	}
	public void setkName(String kName) {
		this.kName = kName;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public Set<District> getDistricts() {
		return districts;
	}
	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}
	
	
	

}
