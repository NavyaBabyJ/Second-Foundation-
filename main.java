package com.nissan.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nissan.model.Administrator;
import com.nissan.model.Customer;

public class main {
	static Administrator obj = new Administrator();
	static Customer obj1 = new Customer();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int choice,choice1;
	    String mobileNo;

		try {
		do {
			System.out.println("1.Admin 2.Customer 3.exit Enter the option");
			int opt= s.nextInt();
			if(opt==1) {
			System.out.println("Bank Management");
			System.out.println("1-Add Customer");
			System.out.println("2-Update Customer Details");
			System.out.println("3-Delete Customer");
			System.out.println("4-Display Customers list");
			System.out.println("5-Exit");
			choice=s.nextInt();
			if (choice == 1) {
				System.out.println("Enter customer name: ");
				String custumerName = s.next();
				obj1.getValidCustomerName(custumerName);
				System.out.println("Enter account type(SAVINGS/CURRENT): ");
				String accountType = s.next();
				System.out.println("Enter present balance: ");
				double balance = s.nextDouble();
				System.out.println("Enter minimum balance: ");
				double minBalance=s.nextDouble();
				do {
				System.out.println("Enter mobile number: ");
				mobileNo = s.next();
				if(mobileNo.length()!=10) {
					System.out.println("Invalid please re enter");
				}
				}while(mobileNo.length()!=10);
				System.out.println("Enter email: ");
				String email = s.next();
				obj.addCustomer(custumerName, accountType, balance, minBalance, mobileNo, email);

			} else if (choice == 2) {
				System.out.println("Enter account number: ");
				int accountNo = s.nextInt();
				do {
				System.out.println("Enter new mobile number: ");
				mobileNo = s.next();
				if(mobileNo.length()!=10)
				{
					System.out.println("Invalid mobile number! enter again");
				}
				}while(mobileNo.length()!=10);
				System.out.println("Enter new email: ");
				String email = s.next();
				obj.updateCustomerDetails(accountNo, mobileNo, email);
			} else if (choice == 3) {
				System.out.println("Enetr acccount number to be deleted:");
				int accountNo = s.nextInt();
				obj.deleteCustomer(accountNo);
			} else if (choice == 4)
				obj.displayAllCustomers(); 
			}
			else if(opt==2) {
				System.out.println("1.Deposit: ");
				System.out.println("2.Withdraw: ");
				System.out.println("3.showBalance: ");
				System.out.println("4.TransferMoney: ");
                 choice1=s.nextInt();
				if(choice1==1) {
				System.out.println("Enter account number: ");
				int accountNo = s.nextInt();
				System.out.println("Enter amount to deposit: ");
				int amount = s.nextInt();
				obj1.deposit(amount);}
			 else if (choice1 == 2) {
				System.out.println("Enter account number: ");
				int accountNo = s.nextInt();
				System.out.println("Enter amount to withdraw: ");
				int amount = s.nextInt();
				obj1.withdraw(amount);}
			else if(choice1==3) {
				System.out.println("Enter account number: ");
				int accountNo = s.nextInt();
				obj1.showBalance();
			}
			else if(choice1==4){
				System.out.println("Enter amount to transfer: ");
				int amount=s.nextInt();

				obj1.transferMoney(amount);
			}
			
	}else {
		System.out.println("invalid choice");
	}
			
		} while (true);
		}catch(Exception e) {
			System.out.println("Invalid choice");
		}

}
}
