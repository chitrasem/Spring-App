package com.chitra.kms.kh.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="kms_level")
public class Level {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private long id;
	private String level;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "kms_level_classroom", joinColumns = { @JoinColumn(name = "level_id") }, inverseJoinColumns = {
			@JoinColumn(name = "classroom_id") })
	private Set<Classroom> classrooms = new HashSet<Classroom>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Set<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(Set<Classroom> classrooms) {
		this.classrooms = classrooms;
	}
	
	
	
	
}
