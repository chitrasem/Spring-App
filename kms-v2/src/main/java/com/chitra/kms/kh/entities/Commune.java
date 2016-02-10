package com.chitra.kms.kh.entities;

import java.util.HashSet;
import java.util.Set;

public class Commune {
	
	private long id;
	private String code;
	private String kName;
	private String eName;
	private String reference;
	private String note;
	private String issueDate;
	private District district;
	private Set<Village> privinces = new HashSet<Village>();
	
	public Set<Village> getPrivinces() {
		return privinces;
	}
	public void setPrivinces(Set<Village> privinces) {
		this.privinces = privinces;
	}
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
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	
	
	

}
