package by.jonline.module_2.decomposition;

import java.util.Arrays;

/**
 * Натуральное число, в записи которого n цифр, называется числом Армстронга,
 * если сумма его цифр, возведенная в степень n, равна самому числу. Найти все
 * числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.
 */

public class Task14 {

	public static void main(String[] args) {

		int k = 400;

		if (k < 1) {
			return;
		}

		int[] array;
		array = getArmstrongNumbers(k);

		System.out.println(Arrays.toString(array));
	}

	public static int[] getArmstrongNumbers(int a) {

		int[] array = new int[30];
		int count = 0;

		for (int i = 1; i <= a; i++) {
			if (getSumOfDigits(i) == i) {
				array[count] = i;
				count++;
			}
		}
		return Arrays.copyOf(array, count);
	}

	public static int getSumOfDigits(int a) {

		int sum = 0;
		int temp = 0;
		int length = String.valueOf(a).length();

		while (a > 0) {
			temp = a % 10;
			sum += Math.pow(temp, length);
			a /= 10;
		}
		return sum;
	}
}