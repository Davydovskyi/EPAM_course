package by.jonline.module_5.task2.main;

import by.jonline.module_5.task2.entity.Payment;
import by.jonline.module_5.task2.entity.Payment.Product;
import by.jonline.module_5.task2.logic.PaymentBuilder;
import by.jonline.module_5.task2.logic.PaymentLogic;

/**
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно
 * сформировать покупку из нескольких товаров.
 */

public class Main {

	public static void main(String[] args) {
		PaymentBuilder builder = new PaymentBuilder();
		PaymentLogic logic = new PaymentLogic();

		Product product1 = new Product("корм", 4);

		Payment payment = builder
				.addProduct(product1, 3)
				.addProduct("Корм", 4, 2)
				.create();
		payment.setId(234878);

		double totalPrice;
		totalPrice = logic.getTotalPrice(payment);

		System.out.println(payment);
		System.out.println(totalPrice);
	}
}