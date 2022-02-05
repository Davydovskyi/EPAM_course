package by.jonline.module_2.decomposition;

/**
 * Найти все натуральные n-значные числа, цифры в которых образуют строго
 * возрастающую последовательность (например, 1234, 5789). Для решения задачи
 * использовать декомпозицию.
 */

public class Task15 {

	public static void main(String[] args) {

		int n = 4;
		
		printNumber(n);
	}

	public static void printNumber(int n) {

		int firstNumber = 0;
		int lastNumber = (int) Math.pow(10, n) - 1;

		for (int i = 0; i < n; i++) {
			firstNumber += (n - i) * Math.pow(10, i);
			lastNumber -= i * Math.pow(10, i);
		}

		for (int i = firstNumber; i <= lastNumber; i++) {
			if (ascendingSequence(i)) {
				System.out.print(i + " ");
			}
		}
	}

	public static boolean ascendingSequence(int number) {

		int previousDigit = 10;
		int temp = 0;

		while (number > 0) {
			temp = number % 10;

			if (temp < previousDigit) {
				previousDigit = temp;
				number /= 10;
			} else {
				return false;
			}
		}
		return true;
	}
}