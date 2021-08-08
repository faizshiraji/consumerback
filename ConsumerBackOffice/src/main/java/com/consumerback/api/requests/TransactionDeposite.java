package com.consumerback.api.requests;

public class TransactionDeposite {

	private int toAccount;
	private double amount;
	private String description;
	
	public TransactionDeposite() {
	}

	public TransactionDeposite(int toAccount, double amount, String description) {
		this.toAccount = toAccount;
		this.amount = amount;
		this.description = description;
	}

	public int getToAccount() {
		return toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
