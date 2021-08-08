package com.consumerback.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_profile")
public class TransactionProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtransactionProfile;
	private int accType;
	private int userid;
	
	public TransactionProfile() {
	}

	public int getIdtransactionProfile() {
		return idtransactionProfile;
	}

	public int getAccType() {
		return accType;
	}

	public int getUserid() {
		return userid;
	}

	public void setIdtransactionProfile(int idtransactionProfile) {
		this.idtransactionProfile = idtransactionProfile;
	}

	public void setAccType(int accType) {
		this.accType = accType;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	
}
