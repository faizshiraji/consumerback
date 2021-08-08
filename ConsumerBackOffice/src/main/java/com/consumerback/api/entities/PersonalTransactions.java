package com.consumerback.api.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "personal_transactions")
public class PersonalTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpersonalTransactions;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date tranDate;
	private String naration;
	private double withdrawal;
	private double deposit;
	private BigDecimal availableBalance;
	private int status;
	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private PersonalAccount personalAccount;

	public PersonalTransactions() {
	}

	public PersonalTransactions(Date tranDate, String naration, double withdrawal, double deposit,
			BigDecimal availableBalance, int status) {
		this.tranDate = tranDate;
		this.naration = naration;
		this.withdrawal = withdrawal;
		this.deposit = deposit;
		this.availableBalance = availableBalance;
		this.status = status;
	}

	public int getIdpersonalTransactions() {
		return idpersonalTransactions;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public String getNaration() {
		return naration;
	}

	public double getWithdrawal() {
		return withdrawal;
	}

	public double getDeposit() {
		return deposit;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public int getStatus() {
		return status;
	}

	public void setIdpersonalTransactions(int idpersonalTransactions) {
		this.idpersonalTransactions = idpersonalTransactions;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public void setNaration(String naration) {
		this.naration = naration;
	}

	public void setWithdrawal(double withdrawal) {
		this.withdrawal = withdrawal;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PersonalTransactions [idpersonalTransactions=" + idpersonalTransactions + ", tranDate=" + tranDate
				+ ", naration=" + naration + ", withdrawal=" + withdrawal + ", deposit=" + deposit
				+ ", availableBalance=" + availableBalance + ", status=" + status + "]";
	}

	

}
