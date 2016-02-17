package com.chitra.kms.kh.entities;

public enum PaymentType {
	INCOME("Income"),
	EXPENSE("Exspense");
	
	private String paymentType;
	
	private PaymentType(final String paymentType){
		this.paymentType=paymentType;
	}
	@Override
	public String toString() {
		return this.paymentType;
	}
	public String getName(){
		return this.getName();
	}
	public String getPaymentType(){
		return this.getPaymentType();
	}

}
