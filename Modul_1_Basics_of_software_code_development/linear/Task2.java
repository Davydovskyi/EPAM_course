package by.jonline.linear;

import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Вычислить значение выражения по формуле (все переменные принимают
 * действительные значения): (b + √(b² + 4 * a * c)) / (2 * a) – a³ * с + b⁻².
 */

public class Task2 {

	public static void main(String[] args) {

		double a;
		double b;
		double c;

		double result;

		a = enterFromConsole("a");
		b = enterFromConsole("b");
		c = enterFromConsole("c");

		result = (b + sqrt((pow(b, 2) + 4 * a * c))) / (2 * a) - pow(a, 3) * c + pow(b, -2);

		System.out.println("result = " + result);

	}

	public static double enterFromConsole(String message) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println(message + " >>");
		while (!scanner.hasNextDouble()) {
			scanner.next();
		}

		return scanner.nextDouble();
	}
}
