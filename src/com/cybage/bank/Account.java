package com.cybage.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class AccountNotFoundException extends Exception {
	public AccountNotFoundException(String message) {
		super(message);
	}
}

class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message);
	}
}

public class Account {

	private Map<Integer, BankAccount> accounts;
	
	public Account(Map<Integer, BankAccount> map) {
		this.accounts=map;
	}

	public void transferFunds() throws AccountNotFoundException, InsufficientBalanceException {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter source account number: ");
		int sourceAccountNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter destination account number: ");
		int destinationAccountNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter amount: ");
		int amount = scanner.nextInt();
		scanner.nextLine();
		if (!accounts.containsKey(sourceAccountNumber)
				|| !accounts.containsKey(destinationAccountNumber)) {
			throw new AccountNotFoundException("Account not found");
		}
		BankAccount sourceAccount = accounts.get(sourceAccountNumber);
		BankAccount destinationAccount = accounts.get(destinationAccountNumber);
		if (sourceAccount.withdraw(amount)) {
			destinationAccount.deposit(amount);
			System.out.println("Fund transfer successfully..!");
		}
	}
}
