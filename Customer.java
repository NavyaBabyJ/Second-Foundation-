package com.nissan.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
	Scanner s = new Scanner(System.in);
	public String CustomerName;
	public int AccountNo;
	public String AcountType;
	public double balance;
	public double minBalance;
	public String mobileNo;
	public String email;
	public int pin;

	public Customer() {

	}

	public Customer(Scanner s, String customerName, int accountNo, String acountType, double balance, double minBalance,
			String mobileNo, String email, int pin) {
		super();
		this.s = s;
		CustomerName = customerName;
		AccountNo = accountNo;
		AcountType = acountType;
		this.balance = balance;
		this.minBalance = minBalance;
		this.mobileNo = mobileNo;
		this.email = email;
		this.pin = pin;
	}

	public Customer(int accountNo2, String customerName2, String accountType, double balance2, double minBalance2,
			String mobileNo2, String email2) {
		// TODO Auto-generated constructor stub
	}

	public int updateMobileNumber(String newMobileNumber) {
		// TODO Auto-generated method stub
		System.out.println("Enter new mobile number: ");
		return s.nextInt();
	}

	public String updateEmailId(String newEmailId) {
		// TODO Auto-generated method stub
		System.out.println("Enter new mailid: ");
		return s.nextLine();
	}

	public void setMobileNumber(String newMobileNumber) {
		
		this.mobileNo= newMobileNumber;

	}

	public void setEmailId(String newEmailId) {
		this.email=newEmailId; 

	}
	
	//deposit money 
	public void deposit(double amount) {
		if (amount > 50000) {
			System.out.print("Enter PAN Card number: ");
			Scanner s = new Scanner(System.in);
			String panCard = s.nextLine();
			System.out.println("PAN Card number: " + panCard);
		}

		balance += amount;
		System.out.println("Deposited " + amount + " successfully.");
	}

	// Withdraw money from the customer's account
	public void withdraw(double amount) {
		double availableBalance = balance - minBalance;
		if (amount > availableBalance) {
			System.out.println("Insufficient funds..!!!");
			return;
		}

		if (amount > 50000) {
			System.out.print("Enter PAN Card number: ");
			Scanner s = new Scanner(System.in);
			String panCard = s.nextLine();
			System.out.println("PAN Card number: " + panCard);
		}

		balance -= amount;
		System.out.println("Withdrawn " + amount + " successfully.");
	}

	// Show balance of the customer
	public void showBalance() {
		System.out.println("Current Balance: " + balance);
	}

	// Transfer money to another account
	public boolean transferMoney(int amount) {
		if (amount > balance - minBalance) {
			System.out.println("Insufficient funds..!!!");
			return false;
		}

		if (amount > 50000) {
			System.out.print("Enter PAN Card number: ");
			Scanner s = new Scanner(System.in);
			String panCard = s.nextLine();
			System.out.println("PAN Card number: " + panCard);
		}

		balance -= amount;
		System.out.println("Transferred " + amount + " successfully.");
		return true;
	}

	public static String getValidCustomerName(String customerName) {

		try {
			// creating object for BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// creating pattern using regular expression
			Pattern pattern = Pattern.compile("[^A-Za-z ]");

			do {

				// Match
				Matcher matcher = pattern.matcher(customerName);
				boolean finder = matcher.find(); // find() returns false if the string matches the pattern

				if (finder) {
					System.out.print("Name must contain only alphabets. Please re-enter name: ");
					customerName = br.readLine();
				} else if (customerName.length() < 3) {
					System.out.print("Name should contain minimum 3 characters. Please re-enter name: ");
					customerName = br.readLine();
				} else if (customerName.length() > 30) {
					System.out.print("Name contains more than 30 characters. Please re-enter name: ");
					customerName = br.readLine();
				} else {
					break;
				}

			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid name");
		}

		return customerName;
	}
	
	private static double getValidBalance(String balance) {

		try {
		//creating object for BufferedReader
		BufferedReader brBalance = new BufferedReader(new InputStreamReader(System.in));

		//creating pattern using regular expression
		Pattern patternBalance = Pattern.compile("[^0-9.-]");

		do {
		Matcher matcherBalance = patternBalance.matcher(balance);
		boolean balanceFinder = matcherBalance.find();

		if(balanceFinder) {
		System.out.print("Balance should contain only positive numeric values. Please re-enter balance: ");
		balance = brBalance.readLine();
		}
		else if(balance.length() > 8) {
		System.out.print("Balance cannot be greater than 100000000. Please re-enter: ");
		balance = brBalance.readLine();
		}
		else if(Double.parseDouble(balance) < 1000) {
		System.out.print("Sorry! Minimum balance should be 1000. Please re-enter: ");
		balance = brBalance.readLine();
		}
		else {
		break;
		}

		}while(true);



		}catch(Exception e) {
		System.out.println("Invalid balance");
		}

		double doubleBalance = Double.parseDouble(balance);

		return doubleBalance;
		}

}
