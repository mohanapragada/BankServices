package com.css.services;
import java.util.Arrays;
public class Accounts implements IBankServiceProvide {
	private Bank[] bankAccount;

	public Bank[] getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Bank[] bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accounts(Bank[] bankAccount) {
		super();
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Accounts [bankAccount=" + Arrays.toString(bankAccount) + "]";
	}

	@Override
	public Bank checkaccount(String accountNumber) {
		Bank foundAccount=null;
		for(Bank number : this.bankAccount) {
			if(number.getAccountNumber().equals(accountNumber)) {
				foundAccount=number;
				return foundAccount;
			}
		}
		
		return null;
	}

	@Override
	public double getbalance(String accountNumber) {
		
		double balance=0.0;
		Bank foundAccount = this.checkaccount(accountNumber);
		if(foundAccount!=null)
			balance=foundAccount.getBalance();
		return balance;
	}

	@Override
	public boolean withdrawmoney(String accountNumber, double amount) {
		boolean withdrawFlag=false;
		Bank foundAccount = this.checkaccount(accountNumber);
		if(foundAccount!=null) {
			if(foundAccount.getBalance()>=amount) {
			double newbalance=foundAccount.getBalance()-amount;
			foundAccount.setBalance(newbalance);
			withdrawFlag=true;
			}
		}
		return withdrawFlag;
	}

	@Override
	public boolean deppositmoney(String accountNumber, double amount) {
		boolean depositFlag=false;
		Bank foundAccount = this.checkaccount(accountNumber);
		if(foundAccount!=null) {
			double newbalance=foundAccount.getBalance()+amount;
			foundAccount.setBalance(newbalance);
			depositFlag=true;
			}
		return depositFlag;
		
	}

	@Override
	public boolean transfermoney(String fromAccountNumber,String toAccountNumber, double amount) {
		boolean transferFlag=false;
		boolean withdrawFlag=this.withdrawmoney(fromAccountNumber, amount);
		if(withdrawFlag) {
			boolean depositFlag =this.deppositmoney(toAccountNumber,amount);
			if(depositFlag)
				transferFlag=true;
			else
				this.deppositmoney(fromAccountNumber,amount);
		}
		return transferFlag;
	}
	
	
}