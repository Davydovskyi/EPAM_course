package by.jonline.module_4.simple_class_and_object.task8.logic;

import java.util.ArrayList;
import java.util.List;

import by.jonline.module_4.simple_class_and_object.task8.entity.Customer;

public class CustomerLogic {

	public List<Customer> sortedByFullName(List<Customer> custumers) {

		List<Customer> sortedCustomers = new ArrayList<>();
		sortedCustomers.addAll(custumers);

		Customer customer1;
		Customer customer2;
		StringBuilder fullName1;
		StringBuilder fullName2;
		int compare;

		boolean sorted = false;
		while (!sorted) {
			sorted = true;

			for (int i = 0; i < sortedCustomers.size() - 1; i++) {
				customer1 = sortedCustomers.get(i);
				customer2 = sortedCustomers.get(i + 1);

				fullName1 = new StringBuilder().append(customer1.getLastName()).append(customer1.getFirstName())
						.append(customer1.getPatronymic());
				fullName2 = new StringBuilder().append(customer2.getLastName()).append(customer2.getFirstName())
						.append(customer2.getPatronymic());

				compare = fullName1.compareTo(fullName2);

				if (compare > 0) {
					sorted = false;
					swap(sortedCustomers, i, i + 1);
				}
			}
		}
		return sortedCustomers;
	}

	public List<Customer> sortedByCreditCardNumber(List<Customer> custumers) {// сортировка нужна была для двоичного поиска, но не смог.

		List<Customer> sortedCustomers = new ArrayList<>();
		sortedCustomers.addAll(custumers);

		int d = sortedCustomers.size() / 2;
		while (d > 0) {
			for (int i = 0; i < sortedCustomers.size() - d; i++) {
				int j = i;
				while (j >= 0 && sortedCustomers.get(j).getCreditCardNumber() > sortedCustomers.get(j + d)
						.getCreditCardNumber()) {
					swap(sortedCustomers, j, j + d);
					j = j - d;
				}
			}
			d = d / 2;
		}
		return sortedCustomers;
	}

	public List<Customer> getCustomersByCardNumberRange(List<Customer> customers, int from, int to) {

		List<Customer> specialCustomers;

		int start = from;
		int end = to;

		if (start > end) {
			start = to;
			end = from;
		}

		specialCustomers = new ArrayList<>();

		if (customers.isEmpty() || start > customers.get(customers.size() - 1).getCreditCardNumber()) {
			return specialCustomers;
		}

		for (Customer customer : customers) {
			if (customer.getCreditCardNumber() >= start && customer.getCreditCardNumber() <= end) {
				specialCustomers.add(customer);
			}
		}
		return specialCustomers;
	}

	private void swap(List<Customer> customers, int id1, int id2) {
		Customer customer = customers.get(id1);
		customers.set(id1, customers.get(id2));
		customers.set(id2, customer);
	}
}