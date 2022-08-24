package by.jonline.module_4.simple_class_and_object.task8.view;

import java.util.List;

import by.jonline.module_4.simple_class_and_object.task8.entity.Customer;

public class CustomerView {

	public void ptintCustomers(String message, List<Customer> customers) {

		StringBuilder builder;

		System.out.println(message);
		System.out.println("------------------------------------");

		for (Customer customer : customers) {
			builder = new StringBuilder().append(customer.getLastName()).append(" ").append(customer.getFirstName())
					.append(" ").append(customer.getPatronymic());
			System.out.printf("%s%nid: %d%naddress: %s%ncard number: %d%naccount number: %d%n", builder.toString(),
					customer.getId(), customer.getAddress(), customer.getCreditCardNumber(),
					customer.getAccountNumber());
			System.out.println("------------------------------------");
		}
	}

	public void printErrorMessage(String message) {
		System.out.println(message);
	}
}