/**
 * 
 */
package com.customer.rewards.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Welcome
 *
 */
@Entity
@Table(name="TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "TRANSACTION_ID")
	private Long transId;
	
	@Column(name= "CUSTOMER_ID")
	private Long customerId;
	
	@Column(name= "TRANSACTION_DATE")
	private Timestamp date;
	
	@Column(name= "AMOUNT")
	private Double amount;

	public Transaction() {
		
	}
	
	public Transaction(Long transId, Long customerId, Timestamp date, Double amount) {
		super();
		this.transId = transId;
		this.customerId = customerId;
		this.date = date;
		this.amount = amount;
	}

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}	

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
}
