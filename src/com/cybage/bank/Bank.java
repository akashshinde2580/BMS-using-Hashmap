package com.cybage.bank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Bank {
	
private Map<Integer, BankAccount> account;
	
	public Bank(Map<Integer, BankAccount> map) {
		this.account=map;
	}
	
	
	Scanner scanner = new Scanner(System.in);
	public void addAccount() {
		
		System.out.println("Enter accNum:");
		int accNum = scanner.nextInt();
		System.out.println("Enter name:");
		String name = scanner.next();
		System.out.println("Enter ifsc:");
		String ifsc = scanner.next();
		System.out.println("Enter bal:");
		double balance = scanner.nextDouble();
		System.out.println("Enter Account type:");
		String accountType = scanner.next();
		

		BankAccount acct12 = new BankAccount(accNum, name, ifsc, balance, accountType);
		int accKey = acct12.getAccountNumber();
		
		if (!account.containsKey(accKey)) {
			account.put(accKey, acct12);
			System.out.println("Account added sucessfully...!");
		} else {
			System.out.println("Account already exist...");
		}
	}
	
	public void displayAllAccounts() {
		System.out.println("All accounts:");
		for (BankAccount acct : account.values()) {
			System.out.println(acct.toString());
		}
	}
	
	public void getAccountDetails() throws AccountNotFoundException{
		System.out.print("Enter account number: ");
		int accountNumber = scanner.nextInt();
		scanner.nextLine();

		if (account.containsKey(accountNumber)) {
			BankAccount acct = account.get(accountNumber);
			System.out.println(acct.toString());
		} else {
			//throw new AccountNotFoundException("Account not found");
			System.out.println("Account not found");
		}
	}
	
	public void closeAccount() throws AccountNotFoundException  {
		System.out.print("Enter account number: ");
		int acctNumber = scanner.nextInt();
		scanner.nextLine();
		
		if (account.containsKey(acctNumber)) {
			account.remove(acctNumber);
			System.out.println("Account removed successfully..!");
		} else {
			//throw new AccountNotFoundException("Account not found");
			System.out.println("Account not found");
		}
	}
	
	public void applyInterest() {
		System.out.print("Enter Interest rate: ");
		int interestRate = scanner.nextInt();
//		
		for (BankAccount acc : account.values()) {
			if (acc.getAccountType().equals("savings")) {
				double newBalance = acc.getBalance() + (acc.getBalance() * interestRate / 100);
				acc.setBalance(newBalance);
				acc.setInterestRate(interestRate);
			}
		}
		System.out.println("interest rate applied sucessfully...");
	}
	public void reverseSortedAccounts() {
	Map<Integer, BankAccount> reverseSortedAccountMap = new TreeMap<>(Collections.reverseOrder());
	reverseSortedAccountMap.putAll(account);
	reverseSortedAccountMap.forEach((accountId, bankAccount) -> {
		System.out.println("Account Id: " + accountId + ", " + bankAccount);
	});
	}
	
	public void sortedAccounts() {
		Map<Integer, BankAccount> sorted = new TreeMap<>();
		sorted.putAll(account);
		for (Entry<Integer, BankAccount> entry : sorted.entrySet())
			System.out.println("Account Id : " + entry.getKey() + ", " + entry.getValue());
		
	}
}
