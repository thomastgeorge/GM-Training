package com.grayMatter.bankApp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\tWelcome to Paisa Bank\n");
		int primaryChoice=3;

		do {
			System.out.println("Menu\n"
							+ "1. Savigs Account \n"
							+ "2. Current Account \n"
							+ "3. Exit \n"
							+ "Enter value: ");
			primaryChoice=sc.nextInt();
			switch(primaryChoice) {
			case 1:	SAccount();
					break;
			case 2: CAccount();
					break;
			case 3: break;
			default: System.out.println("Invalid value Entered");
			}
		}while(primaryChoice!=3);
		
		sc.close();

	}
	
	public static void SAccount() {
		int accountChoice=5;
		System.out.println("\tSavings Account\n");
		Scanner sc=new Scanner(System.in);
		
		SavingsAccount sa = new SavingsAccount("AC001", "UsrName", 1111, "Paisa Bank", "IFSC001", 98277828.5f);
		
		do {
			System.out.println("Menu\n"
			+ "1. Withdraw \n"
			+ "2. Account Details \n"
			+ "3. Change PIN \n"
			+ "4. Balance \n"
			+ "5. Exit \n"
			+ "Enter value: ");
			accountChoice=sc.nextInt();
			switch(accountChoice) {
			case 1:	System.out.println("Enter Withdraw Amount: ");
					float amt=sc.nextFloat();
					sa.withdraw(amt);
					break;
			case 2: System.out.println(sa.toString());
					break;
			case 3: System.out.println("Enter Current PIN: ");
					int cpin=sc.nextInt();
					System.out.println("Enter New PIN: ");
					int npin=sc.nextInt();
					sa.changePin(cpin, npin);
					break;
			case 4: sa.printBalance();
					break;
			case 5:	break;
			default: System.out.println("Invalid pin");
			}
			} while(accountChoice!=5);
		
	}
	
	public static void CAccount() {
		int accountChoice=5;
		System.out.println("\tCurrent Account\n");
		Scanner sc = new Scanner(System.in);
		
		CurrentAccount ac = new CurrentAccount("AC002", "UsrName", 2222, "Paisa Bank", "IFSC001", 123456789.0f);
		
		do {
			System.out.println("Menu\n"
			+ "1. Withdraw \n"
			+ "2. Account Details \n"
			+ "3. Change PIN \n"
			+ "4. Draf tLmit \n"
			+ "5. Exit \n"
			+ "Enter value: ");
			accountChoice=sc.nextInt();
			switch(accountChoice) {
				case 1:	System.out.println("Enter Withdraw Amount: ");
						float amt=sc.nextFloat();
						ac.withdraw(amt);
						break;
				case 2: System.out.println(ac.toString());
						break;
				case 3: System.out.println("Enter Current PIN: ");
						int cpin=sc.nextInt();
						System.out.println("Enter New PIN: ");
						int npin=sc.nextInt();
						ac.changePin(cpin, npin);
						break;
				case 4: ac.printOverDraftLmit();
						break;
				case 5:	break;
				default: System.out.println("Invalid pin");
			}
			} while(accountChoice!=5);
		
	}
	
}
