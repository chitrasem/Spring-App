package com.chitra.kms.kh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="kms_address")
public class Address {
	
	@Id
	@Column(nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Province province;
	
	@ManyToOne(fetch=FetchType.LAZY)	
	private District district;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Commune commune;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Village village;
	
	@Column(name="house_number")
	private String houseNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	

}
