package com.css.services;

public class Main { 

	
	public static void main(String[] args)
	{
		Bank[] bankAccount = new Bank[4];
		bankAccount[0]= new Bank("mohana");
		bankAccount[1] = new Bank("lakshmi");
		bankAccount[2] = new Bank( "sahana");
		bankAccount[3] = new Bank("megha");
	
		Accounts myAccount = new Accounts();
		myAccount.setBankAccount(bankAccount);
		Bank foundAccount = myAccount.checkaccount(Integer.toString(3));
		System.out.println("Check balance :"+foundAccount.toString());
		System.out.println("DepositMoney :"+myAccount.deppositmoney(Integer.toString(3),300));
		System.out.println("get Balance :"+myAccount.getbalance(Integer.toString(3)));
		System.out.println("withdraw money :"+myAccount.withdrawmoney(Integer.toString(3),250));
		System.out.println("balanceafter withdraw :"+myAccount.getbalance(Integer.toString(3)));
		System.out.println("Trnasfer Money :"+myAccount.transfermoney(Integer.toString(3), Integer.toString(2),500));
		
	    
}
}
