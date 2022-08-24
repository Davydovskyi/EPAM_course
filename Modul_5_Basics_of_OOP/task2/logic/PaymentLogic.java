package by.jonline.module_5.task2.logic;

import java.util.Map;

import by.jonline.module_5.task2.entity.Payment;
import by.jonline.module_5.task2.entity.Payment.Product;

public class PaymentLogic {

	public double getTotalPrice(Payment payment) {
		int totalPrice = 0;
		if (payment != null) {
			for (Map.Entry<Product, Integer> pr : payment.getProducts().entrySet()) {
				totalPrice += pr.getKey().getPrice() * pr.getValue();
			}
		}
		return totalPrice;
	}
}