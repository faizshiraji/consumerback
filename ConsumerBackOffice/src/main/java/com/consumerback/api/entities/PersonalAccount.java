package com.consumerback.api.entities;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "personal_account")
public class PersonalAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpersonalAccount;
	@Column(unique = true, name = "account_number")
	private int accountNumber;
	private BigDecimal accountBalance;
	private int status;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateDate;

	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "personalAccount")
	private Users users;

//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pt_id")
	List<PersonalTransactions> personalTransactions = new ArrayList<>();
	
//	private PersonalTransactions personalTransactions;
	
	
	public PersonalAccount() {
	}

	public PersonalAccount(int accountNumber, BigDecimal accountBalance, int status, Date createDate, Date updateDate,
			Users users, List<PersonalTransactions> personalTransactions) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.users = users;
		this.personalTransactions = personalTransactions;
	}

	public int getIdpersonalAccount() {
		return idpersonalAccount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public int getStatus() {
		return status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public Users getUsers() {
		return users;
	}

	public List<PersonalTransactions> getPersonalTransactions() {
		return personalTransactions;
	}

	public void setIdpersonalAccount(int idpersonalAccount) {
		this.idpersonalAccount = idpersonalAccount;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public void setPersonalTransactions(List<PersonalTransactions> personalTransactions) {
		this.personalTransactions = personalTransactions;
	}

	@Override
	public String toString() {
		return "PersonalAccount [idpersonalAccount=" + idpersonalAccount + ", accountNumber=" + accountNumber
				+ ", accountBalance=" + accountBalance + ", status=" + status + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", users=" + users + ", personalTransactions=" + personalTransactions
				+ "]";
	}

	
	

}
