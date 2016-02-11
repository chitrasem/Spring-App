package com.chitra.kms.kh.entities;

public enum State {
	ACTIVE("Active"),
	INACTIVE("Inactive"),
	LOCKED("Locked"),
	DELETED("Deleted");
	
	private String state;
	private State(final String state){
		this.state = state;
	}
	public String getState() {
		return this.state;
	}
	
	@Override
	public String toString() {
		return this.state;
	}
	public String getName(){
		return this.name();
	}
	
	

}
