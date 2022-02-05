package by.jonline.module_2.decomposition;

import java.util.Arrays;

/**
 * Даны натуральные числа К и N. Написать метод(методы) формирования массива А,
 * элементами которого являются числа, сумма цифр которых равна К и которые не
 * большее N.
 */

public class Task12 {

	public static void main(String[] args) {

		int maxК = 82; // для int max сумма будет такая.

		int k = 12;
		int n = 400;

		if (k < 1 || n < 1 || k > maxК) {
			return;
		}

		int[] array;
		array = getArray(k, n);

		System.out.println(Arrays.toString(array));
	}

	public static int[] getArray(int k, int n) { // проблемы с памятью и временем выполнения.

		int[] tempArray = new int[n];
		int count = 0;

		for (int i = 1; i <= n; i++) {

			int sum = 0;
			int temp = i;

			while (temp > 0) {
				sum += temp % 10;
				temp /= 10;
			}

			if (sum == k) {
				tempArray[count] = i;
				count++;
			}
		}
		return Arrays.copyOf(tempArray, count);
	}
}