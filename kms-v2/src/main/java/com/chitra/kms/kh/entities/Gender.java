package com.chitra.kms.kh.entities;

public enum Gender {
	MALE("M"),
	FEMALE("F"),
	NOT("N");
	
	private String gender;
	
	private Gender(final String gender){
		this.gender = gender;
		
	}
	@Override
	public String toString() {
		return this.gender;
	}
	public String getGender(){
		return this.gender;
	}
	public String getName(){
		return this.name();
	}

}
