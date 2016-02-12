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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="kms_district")
public class District {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String code;
	@Column(name="k_name")	
	private String kName;
	
	@Column(name="e_name")
	private String eName;
	
	private String reference;
	
	private String note;
	
	@Column(name="date_issue")
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Province province;

	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Commune> communes;
	
	
	
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
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public List<Commune> getCommunes() {
		return communes;
	}
	public void setCommunes(List<Commune> communes) {
		this.communes = communes;
	}
	
	
	

}
