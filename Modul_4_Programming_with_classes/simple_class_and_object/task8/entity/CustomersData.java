package by.jonline.module_4.simple_class_and_object.task8.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomersData implements Serializable {

	private static final long serialVersionUID = -5199373529728556263L;

	private List<Customer> customers;

	public CustomersData() {
		customers = new ArrayList<>();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void addCustomer(Customer customer) {
		if (customer != null) {
			customers.add(customer);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		CustomersData other = (CustomersData) obj;

		return Objects.equals(customers, other.customers);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [customers=").append(customers.toString()).append("]");
		return builder.toString();
	}
}