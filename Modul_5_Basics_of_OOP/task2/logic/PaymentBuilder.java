package by.jonline.module_5.task2.logic;

import by.jonline.module_5.task2.entity.Payment;
import by.jonline.module_5.task2.entity.Payment.Product;

public class PaymentBuilder {

	private Payment payment;

	public PaymentBuilder() {
		payment = new Payment();
	}

	public PaymentBuilder addProduct(Product product, int count) {
		if (product != null && count > 0) {
			payment.getProducts().merge(product, count, (oldVal, newVal) -> oldVal + newVal);
		}
		return this;
	}

	public PaymentBuilder addProduct(String name, double price, int count) {
		if (price > 0) {
			addProduct(new Product(name, price), count);
		}
		return this;
	}

	public Payment create() {
		return payment;
	}
}