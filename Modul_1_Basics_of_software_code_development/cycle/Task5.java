package by.jonline.module_1.cycle;

/**
 * Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль
 * которых больше или равен заданному е. Общий член ряда имеет вид: a(n) = 1 /
 * 2(n) + 1 / 3(n).
 */

public class Task5 {

	public static void main(String[] args) {

		double e = 0.001;

		double sum = 0;

		int i = 0;

		double result;

		result = compute(i);

		while (result >= e) {

			sum += result;
			i++;
			result = compute(i);
		}

		System.out.println("sum = " + sum);

	}

	public static double compute(int n) {

		return 1 / Math.pow(2, n) + 1 / Math.pow(3, n);
	}

}
