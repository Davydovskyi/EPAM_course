package by.jonline.module_5.task4.main;

import java.util.Scanner;

import by.jonline.module_5.task4.controller.Controller;
import by.jonline.module_5.task4.controller.impl.TreasureController;

/**
 * Создать консольное приложение, удовлетворяющее следующим требованиям: 
 * • Приложение должно быть объектно-, а не процедурно-ориентированным. 
 * • Каждый класс должен иметь отражающее смысл название и информативный состав. 
 * • Наследование должно применяться только тогда, когда это имеет смысл. 
 * • При кодировании должны быть использованы соглашения об оформлении кода java code
 * convention. 
 * • Классы должны быть грамотно разложены по пакетам. 
 * • Консольное меню должно быть минимальным. 
 * • Для хранения данных можно использовать файлы.
 * 
 * Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения
 * о 100 сокровищах в пещере дракона. Реализовать возможность просмотра
 * сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ на
 * заданную сумму.
 */

public class Main {

	private static final String MENU_MESSAGE = "Выберете действие:" + "\n1. Просмотр всех сокровищ."
			+ "\n2. Просмотр определённого количества сокровищ." + "\n3. Выбрать самое дорогое сокровище из всех."
			+ "\n4. Выбать самое дорогое сокровище из определенного количества сокровищ."
			+ "\n5. Выбор сокровищ на заданную сумму из всех сокровищ."
			+ "\n6. Выбор сокровищ на заданную сумму из определенного количества сокровищ." + "\n0. Выход.";

	public static void main(String[] args) {
		String request;
		request = createRequest();

		Controller controller = new TreasureController();

		String response;
		response = controller.doAction(request);

		System.out.println(response);

	}

	private static String enterFromConsole(String message, String pattern) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println(message);
		while (!scanner.hasNext(pattern)) {
			scanner.next();
		}
		return scanner.next(pattern);
	}

	private static String createRequest() {
		int choice;
		choice = Integer.parseInt(enterFromConsole(MENU_MESSAGE, "[0-6]"));

		String countTreasureMessage = "Введите количество сокровищ.";
		String amountMessage = "Введите сумму.";
		String pattern = "\\d{1,9}";

		String request = null;
		int count;
		int amount;

		switch (choice) {
		case 1:
			request = "getTreasure isFull=true count=0";
			return request;
		case 2:
			count = Integer.parseInt(enterFromConsole(countTreasureMessage, pattern));
			request = "getTreasure isFull=false count=" + count;
			return request;
		case 3:
			request = "mostExpensive isFull=true count=0";
			return request;
		case 4:
			count = Integer.parseInt(enterFromConsole(countTreasureMessage, pattern));
			request = "mostExpensive isFull=false count=" + count;
			return request;
		case 5:
			amount = Integer.parseInt(enterFromConsole(amountMessage, pattern));
			request = "forAmount isFull=true count=0 amount=" + amount;
			return request;
		case 6:
			count = Integer.parseInt(enterFromConsole(countTreasureMessage, pattern));
			amount = Integer.parseInt(enterFromConsole(amountMessage, pattern));
			request = "forAmount isFull=false count=" + count + " amount=" + amount;
			return request;
		case 0:
			System.exit(0);
			request = "";
			return request;
		default:
			request = "";
			return request;
		}
	}
}