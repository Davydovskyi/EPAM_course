package by.jonline.module_2.decomposition;

/**
 * Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел
 * от 1 до 9.
 */

public class Task7 {

	public static void main(String[] args) {

		int sum = 0;

		for (int i = 1; i < 10; i = i + 2) {
			sum += getFactorial(i);
		}

		System.out.println(sum);
	}

	public static int getFactorial(int number) {

		int result = 1;
		for (int i = 1; i <= number; i++) {
			result *= i;
		}

		return result;
	}
}