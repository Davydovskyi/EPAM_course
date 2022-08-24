package by.jonline.module_4.simple_class_and_object.task8.main;

import java.util.List;

import by.jonline.module_4.simple_class_and_object.task8.entity.Customer;
import by.jonline.module_4.simple_class_and_object.task8.entity.CustomersData;
import by.jonline.module_4.simple_class_and_object.task8.logic.CustomerLogic;
import by.jonline.module_4.simple_class_and_object.task8.view.CustomerView;

/**
 * Создать класс Customer, спецификация которого приведена ниже. Определить
 * конструкторы, set- и get- методы и метод toString(). Создать второй класс,
 * агрегирующий массив типа Customer, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль. Класс
 * Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер
 * банковского счета. Найти и вывести: a) список покупателей в алфавитном
 * порядке; b) список покупателей, у которых номер кредитной карточки находится
 * в заданном интервале.
 */

public class Main {

	public static void main(String[] args) {

		CustomersData customersData = new CustomersData();
		CustomerLogic customerLogic = new CustomerLogic();
		CustomerView customerView = new CustomerView();

		customersData.addCustomer(new Customer("Валерий", "Сергеев", "Николаевич", "Жукова 45", 99589332, 122356778));
		customersData.addCustomer(new Customer("Виталий", "Ульд", "Витольдович", "Победы 23", 12589332, 99554332));
		customersData.addCustomer(new Customer("Сергей", "Арбузов", "Валерьевич", "Маршала 47", 945567332, 99994430));
		customersData.addCustomer(new Customer("Михаил", "Никанов", "Евгеньевич", "Фрунзе 4", 23578332, 10003211));
		customersData.addCustomer(new Customer("Вячеслав", "Боров", "Аркадьевич", "Амурская 12", 11567332, 49302432));
		customersData.addCustomer(new Customer("Сергей", "Арбузов", "Петрович", "Кирова 15", 67589334, 992394430));

		List<Customer> sortedByFullName;
		sortedByFullName = customerLogic.sortedByFullName(customersData.getCustomers());

		List<Customer> sortedByCardNumber;
		sortedByCardNumber = customerLogic.sortedByCreditCardNumber(customersData.getCustomers());

		List<Customer> creditCardRange;
		creditCardRange = customerLogic.getCustomersByCardNumberRange(sortedByCardNumber, 22578332, 73578332);

		if (!creditCardRange.isEmpty()) {
			customerView.ptintCustomers("Cписок покупателей в заданном интеравале номеров карт:", creditCardRange);
		} else {
			customerView.printErrorMessage("Покупателей с номерами карт в заданном интервале не существует.");
		}
	}
}