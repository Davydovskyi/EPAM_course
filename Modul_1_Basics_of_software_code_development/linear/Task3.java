package by.jonline.module_1.linear;

import java.util.Scanner;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.tan;

/**
 * Вычислить значение выражения по формуле (все переменные принимают
 * действительные значения): (𝑠𝑖𝑛 𝑥 + 𝑐𝑜𝑠 y) / (𝑐𝑜𝑠 𝑥 − 𝑠𝑖𝑛 𝑦) * tg (x * y).
 */

public class Task3 {

	public static void main(String[] args) {

		double x;
		double y;

		double result;

		x = enterFromConsole("x");
		y = enterFromConsole("y");

		result = (sin(x) + cos(y)) / (cos(x) - sin(y)) * tan(x * y);

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
