package by.jonline.module_1.branching;

/**
 * Найти max{min(a, b), min(c, d)}.
 */

public class Task2 {

	public static void main(String[] args) {

		double a = 78;
		double b = 78.5;
		double c = 4;
		double d = 45;

		double result;

		result = max(min(a, b), min(c, d));

		System.out.println("result: " + result);

	}

	public static double max(double a, double b) {

		return a > b ? a : b;

	}

	public static double min(double a, double b) {

		return a < b ? a : b;

	}

}
