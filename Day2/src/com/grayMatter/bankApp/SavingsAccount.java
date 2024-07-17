package com.grayMatter.bankApp;

public class SavingsAccount extends Account {
	private double balance;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(String accNo, String accHolderName, int pin, String bankName, String ifsc, double balance) {
		super(accNo, accHolderName, pin, bankName, ifsc);
		this.balance = balance;
	}

	@Override
	public void withdraw(double amount) {
		if(amount<=balance)
			System.out.println("From savings account amount withdrawed: "+amount);
		else
			return;
		balance-=amount;
	}

	@Override
	public String toString() {
		return "SavingsAccount [balance=" + balance + super.toString() + "]";
	}
	
	public void printBalance() {
		System.out.println(balance);
	}

}
