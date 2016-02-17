package com.chitra.kms.kh.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="payment_type", nullable=false)
	private String paymentType;
	
	@Temporal(TemporalType.DATE)
	@Column(name="payment_date", nullable=false)
	private Date paymentDate;
	@Column(name="riel_amount")
	private Double amountInRield;
	@Column(name="dollar_amount")
	private Double amountInDollar;
	@Column(name="comment")
	private String comment;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="stu_id")
	private Student student;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="user_id")
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmountInRield() {
		return amountInRield;
	}

	public void setAmountInRield(Double amountInRield) {
		this.amountInRield = amountInRield;
	}

	public Double getAmountInDollar() {
		return amountInDollar;
	}

	public void setAmountInDollar(Double amountInDollar) {
		this.amountInDollar = amountInDollar;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
