package com.cybage.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccountManager {

//	private Map<Integer, BankAccount> accountMap;
//	private HashMap<Integer, BankAccount> map = new HashMap<>();
//	 
//
//	public HashMap<Integer, BankAccount> getMap() {
//        return map;
//    }
//
//	public class MyKey implements Comparable<MyKey> {
//
//		private int accountNumber;
//		private String ifsc;
//
//		public MyKey(int accountNumber, String ifsc) {
//			this.accountNumber = accountNumber;
//			this.ifsc = ifsc;
//		}
//
//		public MyKey(int accountNumber) {
//			this.accountNumber = accountNumber;
//		}
//
//		@Override
//		public boolean equals(Object o) {
//			if (this == o)
//				return true;
//			if (o == null || getClass() != o.getClass())
//				return false;
//			MyKey myKey = (MyKey) o;
//			return Objects.equals(accountNumber, myKey.accountNumber);
//		}
//
//		@Override
//		public int hashCode() {
//			return Objects.hash(accountNumber);
//		}
//
//		@Override
//		public int compareTo(MyKey other) {
//			int result = this.ifsc.compareTo(other.ifsc);
//			if (result == 0) {
//				result = Integer.compare(this.accountNumber, other.accountNumber);
//			}
//			return result;
//		}
//	}

	public static void main(String[] args) throws Exception {
		//BankAccountManager manager = new BankAccountManager();

		Map<Integer, BankAccount> bankMap = new HashMap<>();

		// HashMap<BankAccountManager.MyKey, BankAccount> map = new HashMap<>();
		// add some bank accounts
		// BankAccount acct1 = new BankAccount(12345, "John Doe", "ABC123", 1000.00);
		// MyKey key1 = manager.new MyKey(acct1.getAccountNumber());
		// map.put(key1, acct1);
		BankAccount acct2 = new BankAccount(123, "John ", 10000.00, "ABC12", "savings", 5);
		int accountKey = acct2.getAccountNumber();
		bankMap.put(accountKey, acct2);

		Bank bank = new Bank(bankMap);

		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("\nMenu:");

			System.out.println("1. Add accounts");
			System.out.println("2. Display all accounts");
			System.out.println("3. Get account summary by account number");
			System.out.println("4. Remove account by account number");
			System.out.println("5. Funds transfer");
			System.out.println("6. Asc order of  accts Ids");
			System.out.println("7. Desc order of  accts Ids");
			System.out.println("8. Apply interest on saving type of a/cs");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:

				bank.addAccount();
				/*
				 * System.out.println("Enter accNum:"); int accNum = scanner.nextInt();
				 * System.out.println("Enter name:"); String name = scanner.next();
				 * System.out.println("Enter ifsc:"); String ifsc = scanner.next();
				 * System.out.println("Enter bal:"); double balance = scanner.nextDouble();
				 * System.out.println("Enter Account type:"); String accountType =
				 * scanner.next();
				 * 
				 * 
				 * BankAccount acct12 = new BankAccount(accNum, name, ifsc, balance,
				 * accountType); int accKey = acct12.getAccountNumber();
				 * 
				 * if (!bankMap.containsKey(accKey)) { bankMap.put(accKey, acct12);
				 * System.out.println("Account added sucessfully...!"); } else {
				 * System.out.println("Account already exist..."); }
				 */
				break;

			case 2:
				bank.displayAllAccounts();
//				System.out.println("All accounts:");
//				for (BankAccount acct : bankMap.values()) {
//					System.out.println(acct.toString());
//				}
				break;

			case 3:
				bank.getAccountDetails();
				// get account summary by account number
//				System.out.print("Enter account number: ");
//				int accountNumber = scanner.nextInt();
//				scanner.nextLine();
//
//				if (bankMap.containsKey(accountNumber)) {
//					BankAccount acct = bankMap.get(accountNumber);
//					System.out.println(acct.toString());
//				} else {
//					System.out.println("Account not found");
//				}
				break;

			case 4:
				bank.closeAccount();
//				System.out.print("Enter account number: ");
//				int acctNumber = scanner.nextInt();
//				scanner.nextLine();
//				
//				if (!bankMap.containsKey(acctNumber)) {
//					bankMap.remove(acctNumber);
//					System.out.println("Account removed successfully..!");
//				} else {
//					System.out.println("Account not found");
//				}
				break;

			case 5:
				Account account = new Account(bankMap);
				account.transferFunds();
				break;

			case 6:
				bank.sortedAccounts();
//				Map<Integer, BankAccount> sorted = new TreeMap<>();
//				// Copy all data from hashMap into TreeMap
//				sorted.putAll(bankMap);
//				// Display the TreeMap which is naturally sorted
//				for (Entry<Integer, BankAccount> entry : sorted.entrySet())
//					System.out.println("Account Id : " + entry.getKey() + ", " + entry.getValue());
				break;

			case 7:
				bank.reverseSortedAccounts();
//				Map<Integer, BankAccount> reverseSortedAccountMap = new TreeMap<>(Collections.reverseOrder());
//				reverseSortedAccountMap.putAll(bankMap);
//				reverseSortedAccountMap.forEach((accountId, bankAccount) -> {
//					System.out.println("Account Id: " + accountId + ", " + bankAccount);
//				});
				break;
			case 8:
				bank.applyInterest();
//				System.out.print("Enter Interest rate: ");
//				int interestRate = scanner.nextInt();
//			
//				for (BankAccount acc : bankMap.values()) {
//					if (acc.getAccountType().equals("savings")) {
//						double newBalance = acc.getBalance() + (acc.getBalance() * interestRate / 100);
//						acc.setBalance(newBalance);
//					}
//				}
//				System.out.println("interest rate applied sucessfully...");
				break;

			case 9:
				// exit
				System.out.println("Exiting program...");
				break;

			default:
				System.out.println("Invalid choice, please try again");
			}

		} while (choice != 9);
	}

}
