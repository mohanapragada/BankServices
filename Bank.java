package com.css.services;

public class Bank {
	
	public String accountName;
	private String accountNumber;
	private double balance;
	
	
	static int lastAssignedNumber=0;


	public Bank(String accountName) {
		super();
		this.accountName = accountName;
		this.accountNumber=Integer.toString(lastAssignedNumber+1);
		lastAssignedNumber++;
		balance=10000;
		
	}
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Bank() {
		super();
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Bank [accountName=" + accountName + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}


	
	
}
