package com.grayMatter.bankApp;

public class Account {
	
	private String accNo;
	private String accHolderName;
	private int pin;
	private String bankName;
	private String ifsc;
	
	public Account() {
		super();
	}

	public Account(String accNo, String accHolderName, int pin, String bankName, String ifsc) {
		super();
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.pin = pin;
		this.bankName = bankName;
		this.ifsc = ifsc;
	}

	@Override
	public String toString() {
		return " Account accNo=" + accNo + ", accHolderName=" + accHolderName + ", pin=" + pin + ", bankName="
				+ bankName + ", ifsc=" + ifsc;
	}
	
	public void changePin(int currPin, int newPin) {
		if (currPin == newPin) {
			System.out.println("Invalid: new pin same as old pin");
		} else {
			this.pin = newPin;
		}
	}
	
	public void withdraw(double amount) {
		System.out.println("From account amount withdrawed:");
	}
	

}
