package by.jonline.module_2.one_array;

/**
 * Задана последовательность N вещественных чисел. Вычислить сумму чисел,
 * порядковые номера которых являются простыми числами.
 */

public class Task6 {

	public static void main(String[] args) {

		int n = 6;

		double result = 0;

		double[] array;
		array = createArray(n);

		result = sum(array);

		System.out.println("Sum = " + result);

	}

	public static double[] createArray(int length) {

		if (length < 0) {
			return new double[0];
		}

		double[] array = new double[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() * 20 - 10;
		}

		return array;
	}

	public static boolean isPrime(int number) {

		if (number < 2) {
			return false;
		}

		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static double sum(double[] array) {

		double sum = 0;

		for (int i = 0; i < array.length; i++) {
			if (isPrime(i)) {
				sum += array[i];
			}
		}

		return sum;
	}

}
