package by.jonline.module_2.decomposition;

/**
 * Написать программу, определяющую сумму n - значных чисел, содержащих только
 * нечетные цифры. Определить также, сколько четных цифр в найденной сумме. Для
 * решения задачи использовать декомпозицию.
 */

public class Task16 {

	public static void main(String[] args) {

		int n = 4;
		
		long sum;
		sum = getSum(n);
		
		int countOfEvenDigits;
		countOfEvenDigits = getCountOfEvenDigits(sum);
		
		System.out.println(sum);
		System.out.println(countOfEvenDigits);
	}

	public static long getSum(int n) {

		long sum = 0;
		int firstNumber = 0;
		int lastNumber = (int) Math.pow(10, n);

		for (int i = 0; i < n; i++) {
			firstNumber += Math.pow(10, i);
		}

		for (int i = firstNumber; i < lastNumber; i += 2) {
			if (oddDigits(i)) {
				sum += i;
			}
		}
		return sum;
	}

	public static boolean oddDigits(int number) {

		while (number > 0) {

			if ((number % 10) % 2 == 0) {
				return false;
			}
			number /= 10;
		}
		return true;
	}

	public static int getCountOfEvenDigits(long number) {

		int count = 0;

		while (number > 0) {
			if ((number % 10) % 2 == 0) {
				count++;
			}
			number /= 10;
		}
		return count;
	}
}