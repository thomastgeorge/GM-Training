package com.grayMatter.bankApp;

public class CurrentAccount extends Account {
	
	private double overDraftLmit;
	
	public CurrentAccount() {
		super();
	}

	public CurrentAccount(String accNo, String accHolderName, int pin, String bankName, String ifsc,
			double overDraftLmit) {
		super(accNo, accHolderName, pin, bankName, ifsc);
		this.overDraftLmit = overDraftLmit;
	}

	@Override
	public void withdraw(double amount) {
		if(amount<=overDraftLmit)
			System.out.println("From savings account amount withdrawed: "+amount);
		else
			return;
		overDraftLmit-=amount;
	}
	
	public void printOverDraftLmit() {
		System.out.println(overDraftLmit);
	}

}
