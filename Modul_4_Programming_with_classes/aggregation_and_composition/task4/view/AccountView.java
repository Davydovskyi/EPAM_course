package by.jonline.module_4.aggregation_and_composition.task4.view;

import java.util.List;

import by.jonline.module_4.aggregation_and_composition.task4.entity.Account;

public class AccountView {

	public void printAccount(String message, Account account) {

		System.out.println(message);

		String status = account.isAccountStatusOpen() ? "open" : "close";

		System.out.printf("Number: %d%nBalance: %d%nStatus: %s%n", account.getNumber(), account.getAccountBalance(),
				status);
	}

	public void printAllAcounts(String message, List<Account> accounts) {

		System.out.println(message);

		System.out.println("------------------------------------");

		String status;

		for (Account account : accounts) {
			status = account.isAccountStatusOpen() ? "open" : "close";

			System.out.printf("Number: %d%nBalance: %d%nStatus: %s%n", account.getNumber(), account.getAccountBalance(),
					status);

			System.out.println("------------------------------------");
		}
	}

	public void printBalance(String message, long balance) {
		System.out.println(message + balance);
	}

	public void printErrorMessage(String message) {
		System.out.println(message);
	}
}