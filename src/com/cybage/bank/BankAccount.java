package com.cybage.bank;


public class BankAccount {

	private int accountNumber;
	private String accountHolderName;
	public double balance;
	private String Ifsc;
	private String accountType;
	private double interestRate;

//	public BankAccount() {
//
//	}

	public BankAccount(int accountNumber, String accountHolderName, double balance, String ifsc, String accountType,
			double interestRate) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		Ifsc = ifsc;
		this.accountType = accountType;
		this.interestRate = interestRate;
	}


	public BankAccount(int accountNumber, String accountHolderName, String ifsc, double balance, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.Ifsc = ifsc;
		this.accountType = accountType;;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getIfsc() {
		return Ifsc;
	}

	public void setIfsc(String ifsc) {
		Ifsc = ifsc;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public boolean deposit(double amount) {
		balance += amount;
		return true;
	}

	public boolean withdraw(double amount) throws InsufficientBalanceException {
		if (balance < amount) {
			throw new InsufficientBalanceException("Insufficient balance");
		}
		balance -= amount;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", balance="
				+ balance + ", Ifsc=" + Ifsc + ", accountType=" + accountType + ", interestRate=" + interestRate+ "]";
	}
}
