package by.jonline.module_5.task5.main;

import by.jonline.module_5.task5.controller.Contoller;
import by.jonline.module_5.task5.controller.impl.GiftController;

/**
 * Создать консольное приложение, удовлетворяющее следующим требованиям: 
 * • Корректно спроектируйте и реализуйте предметную область задачи. 
 * • Для создания объектов из иерархии классов продумайте возможность использования
 * порождающих шаблонов проектирования. 
 * • Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента. 
 * • для проверки корректности переданных данных можно применить регулярные выражения. 
 * • Меню выбора действия пользователем можно не реализовывать, используйте заглушку. 
 * • Особое условие: переопределите, где необходимо, методы toString(), equals() и
 * hashCode().
 * 
 * Подарки. Реализовать приложение, позволяющее создавать подарки (объект,
 * представляющий собой подарок). Составляющими целого подарка являются сладости
 * и упаковка.
 */

public class Main {

	public static void main(String[] args) {

		String request = "createGift chocolate=4 caramel=20 caramel=3";

		Contoller contoller = new GiftController();

		String response;
		response = contoller.doAction(request);

		System.out.println(response);
	}
}