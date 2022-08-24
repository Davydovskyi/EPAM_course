package by.jonline.module_4.aggregation_and_composition.task4.main;

import java.util.List;

import by.jonline.module_4.aggregation_and_composition.task4.entity.Account;
import by.jonline.module_4.aggregation_and_composition.task4.entity.Client;
import by.jonline.module_4.aggregation_and_composition.task4.logic.AccountLogic;
import by.jonline.module_4.aggregation_and_composition.task4.view.AccountView;

/**
 * Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность
 * блокировки/разблокировки счета. Реализовать поиск и сортировку счетов.
 * Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, имеющим
 * положительный и отрицательный балансы отдельно.
 */

public class Main {

	public static void main(String[] args) {
		AccountLogic accountLogic = new AccountLogic();
		AccountView accountView = new AccountView();
		Client client = new Client("Mark", "Noble");

		client.addAccount(new Account(345));
		client.addAccount(new Account(-478));
		client.addAccount(new Account(38));
		client.addAccount(new Account(87));
		client.addAccount(new Account(-100));

		long totalAmount;
		totalAmount = accountLogic.getTotalAmount(client.getAccounts());
		accountView.printBalance("Общая сумма по счетам: ", totalAmount);

		List<Account> sortedByBalance;
		sortedByBalance = accountLogic.sortByAccountBalance(client.getAccounts());
		accountView.printAllAcounts("Все счета: ", sortedByBalance);

		List<Account> sortedByNumber;
		sortedByNumber = accountLogic.sortByAccountNumber(sortedByBalance);
		accountView.printAllAcounts("Все счета: ", sortedByNumber);

		Account account;
		account = accountLogic.findAccountByNumber(sortedByNumber, 1000000003);
		if (account == null) {
			accountView.printErrorMessage("Номер счёта не найден.");
		} else {
			accountView.printAccount("Счёт найден", account);
		}

		long negativeAmount;
		negativeAmount = accountLogic.getNegativeAmount(sortedByBalance);
		accountView.printBalance("Cумма отрицательных баллансов: ", negativeAmount);

		accountLogic.blockAccount(account);

		long positiveAmount;
		positiveAmount = accountLogic.getPositiveAmount(sortedByBalance);
		accountView.printBalance("Cумма отрицательных баллансов: ", positiveAmount);
	}
}