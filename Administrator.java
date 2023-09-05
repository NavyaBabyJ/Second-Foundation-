package com.nissan.model;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Administrator {

	private Map<Integer, Customer> customers;
	
	public Administrator() {
		customers = new HashMap<>();
	}

	public static long generateNineDigitNumber() {
		Random random = new Random();
		long min = 100000000L;
		long max = 999999999L;
		return min + ((long) (random.nextDouble() * (max - min)));
	}
	
	//add customer details
	public void addCustomer(String customerName, String accountType, double balance, double minBalance, String mobileNo,
			String email) {
		int accountNo = (int) generateNineDigitNumber();
		int atmPin = (int) (Math.random() * 9000) + 1000;
		Customer customer = new Customer(accountNo, customerName, accountType, balance, minBalance, mobileNo, email);
		customers.put(accountNo, customer);
		System.out.println("Customer added successfully with Account No: " + accountNo);
		customers.put(atmPin, customer);
		System.out.println("Customer added successfully with Atm pin: " + atmPin);
	}
	
	//update customer details
	public void updateCustomerDetails(int accountNo, String newMobileNumber, String newEmailId) {
		if (customers.containsKey(accountNo)) {
			Customer customer = customers.get(accountNo);
			int number = Integer.parseInt(newMobileNumber);
			customer.setMobileNumber(number);
			customer.setEmailId(newEmailId);
			System.out.println("Customer details updated successfully.");
		} else {
			System.out.println("Account number not found..!!!");
		}
	}
	
	//delete customer
	public void deleteCustomer(int accountNo) {
		if (customers.containsKey(accountNo)) {
			customers.remove(accountNo);
			System.out.println("Customer with Account No " + accountNo + " deleted successfully.");
		} else {
			System.out.println("Account number not found..!!!");
		}
	}

	//display customers
	public void displayAllCustomers() {
		for (Customer customer : customers.values()) {
			System.out.println(customer);
			System.out.println();
		}
	}
	
	//display customers with entered account number
	public void displayCustomerDetails(int accountNo) {
		if (customers.containsKey(accountNo)) {
			System.out.println(customers.get(accountNo));
		} else {
			System.out.println("Account number not found..!!!");
		}
	}
	


		//Step3: check duplicates in customer name
		private static boolean checkCustomerNameExists(String temp, String[] customerNames) {
		for (String customerName : customerNames) {
		if(temp.equals(customerName)) {
		return true;
		}
		}
		return false;
		}

}
