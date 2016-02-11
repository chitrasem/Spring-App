package com.chitra.kms.kh.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="kms_village")
public class Village {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=false)
	private long id;
	
	private String code;
	
	@Column(name="k_name")
	private String kName;
	
	@Column(name="e_name")
	private String eName;
	
	
	private String reference;
	private String note;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_issue")
	private Date issueDate;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Commune> commune;
	
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
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public List<Commune> getCommune() {
		return commune;
	}
	public void setCommune(List<Commune> commune) {
		this.commune = commune;
	}
	
	
	

}
