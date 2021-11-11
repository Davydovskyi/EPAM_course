package by.jonline.module_1.branching;

import java.util.Scanner;

/**
 * Вычислить значение функции: 
 * F(x) = x² - 3 * x + 9, если x <= 3 
 * F(x) = 1 / (x³ + 6), если x > 3
 */

public class Task5 {

	public static void main(String[] args) {

		double x;

		double result;

		x = enterFromConsole();
		
		if (x <= 3) {

			result = Math.pow(x, 2) - 3 * x + 9;

		} else {

			result = 1 / (Math.pow(x, 3) + 6);
		}

		System.out.println("F(x) = " + result);

	}

	public static double enterFromConsole() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("x >>");
		while (!scanner.hasNextDouble()) {
			scanner.next();
		}

		return scanner.nextDouble();

	}

}
