package by.jonline.module_2.decomposition;

/**
 * Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его
 * цифр и т.д. Сколько таких действий надо произвести, чтобы получился нуль? Для
 * решения задачи использовать декомпозицию.
 */

public class Task17 {

	public static void main(String[] args) {

		int number = 78;

		if (number < 0) {
			return;
		}

		int countOfIterations;
		countOfIterations = getCountOfIterations(number);

		System.out.println(countOfIterations);
	}

	public static int getCountOfIterations(int number) {

		if (number == 0) {
			return 0;
		}

		int count = 1;
		number = number - getSumOfDigits(number);
		count += number / 9;

		return count;
	}

	public static int getSumOfDigits(int number) {

		int sum = 0;

		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
}