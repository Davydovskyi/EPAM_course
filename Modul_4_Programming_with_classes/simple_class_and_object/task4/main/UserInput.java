package by.jonline.module_4.simple_class_and_object.task4.main;

import java.util.Scanner;

public class UserInput {

	public int enterTrainNumber(String message) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println(message);
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		return scanner.nextInt();
	}
}