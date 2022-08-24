package by.jonline.module_4.aggregation_and_composition.task4.logic;

import java.util.ArrayList;
import java.util.List;

import by.jonline.module_4.aggregation_and_composition.task4.entity.Account;

public class AccountLogic {

	public long getTotalAmount(List<Account> accounts) {
		long totalAmount = 0;

		for (Account account : accounts) {
			if (account.isAccountStatusOpen()) {
				totalAmount += account.getAccountBalance();
			}
		}
		return totalAmount;
	}

	public void unlockAccount(Account account) {
		account.setAccountStatusOpen(true);
	}

	public void blockAccount(Account account) {
		account.setAccountStatusOpen(false);
	}

	public long getNegativeAmount(List<Account> accounts) {
		long totalAmount = 0;

		for (Account account : accounts) {
			if (account.getAccountBalance() > 0) {
				return totalAmount;
			} else if (account.isAccountStatusOpen()) {
				totalAmount += account.getAccountBalance();
			}
		}
		return totalAmount;
	}

	public long getPositiveAmount(List<Account> accounts) {
		long totalAmount = 0;
		long balance;

		for (int i = accounts.size() - 1; i >= 0; i--) {
			balance = accounts.get(i).getAccountBalance();
			if (balance < 0) {
				return totalAmount;
			} else if (accounts.get(i).isAccountStatusOpen()) {
				totalAmount += balance;
			}
		}
		return totalAmount;
	}

	public Account findAccountByNumber(List<Account> accounts, long number) {
		int index;
		index = binarySearch(accounts, number);

		if (index == -1) {
			return null;
		}
		return accounts.get(index);
	}

	private int binarySearch(List<Account> accounts, long elementToSearch) {
		int firstIndex = 0;
		int lastIndex = accounts.size() - 1;
		long middleIndexElement;

		while (firstIndex <= lastIndex) {
			int middleIndex = (firstIndex + lastIndex) / 2;
			middleIndexElement = accounts.get(middleIndex).getNumber();

			if (middleIndexElement == elementToSearch) {
				return middleIndex;
			} else if (middleIndexElement < elementToSearch) {
				firstIndex = middleIndex + 1;
			} else {
				lastIndex = middleIndex - 1;
			}
		}
		return -1;
	}

	public List<Account> sortByAccountNumber(List<Account> accounts) {
		List<Account> sortedAccounts = new ArrayList<>();
		sortedAccounts.addAll(accounts);

		int d = sortedAccounts.size() / 2;
		while (d > 0) {
			for (int i = 0; i < sortedAccounts.size() - d; i++) {
				int j = i;

				while (j >= 0 && sortedAccounts.get(j).getNumber() > sortedAccounts.get(j + d).getNumber()) {
					swap(sortedAccounts, j, j + d);
					j = j - d;
				}
			}
			d = d / 2;
		}
		return sortedAccounts;
	}

	public List<Account> sortByAccountBalance(List<Account> accounts) {
		List<Account> sortedAccounts = new ArrayList<>();
		sortedAccounts.addAll(accounts);

		int d = sortedAccounts.size() / 2;
		while (d > 0) {
			for (int i = 0; i < sortedAccounts.size() - d; i++) {
				int j = i;

				while (j >= 0
						&& sortedAccounts.get(j).getAccountBalance() > sortedAccounts.get(j + d).getAccountBalance()) {
					swap(sortedAccounts, j, j + d);
					j = j - d;
				}
			}
			d = d / 2;
		}
		return sortedAccounts;
	}

	private void swap(List<Account> accounts, int id1, int id2) {
		Account account = accounts.get(id1);
		accounts.set(id1, accounts.get(id2));
		accounts.set(id2, account);
	}
}