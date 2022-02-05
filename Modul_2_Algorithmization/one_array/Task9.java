package by.jonline.module_2.one_array;

import java.util.Arrays;

/**
 * В массиве целых чисел с количеством элементов n найти наиболее часто
 * встречающееся число. Если таких чисел несколько, то определить наименьшее из
 * них.
 */

public class Task9 {

	public static void main(String[] args) {

		int n = 10;

		long minValue;
		long[] array;

		array = createArray(n);
		minValue = findMinValue(array, countMatch(array));

		System.out.println(Arrays.toString(array));
		System.out.println(minValue);

	}

	public static long[] createArray(int length) {

		if (length < 0) {

			return new long[0];
		}

		long[] array = new long[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = (long) (Math.random() * 20 - 10);
		}

		return array;
	}

	public static int[] countMatch(long[] array) {

		int[] countOfMatch = new int[array.length];

		for (int i = 0; i < array.length; i++) {

			int count = 0;

			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					count++;
				}
				countOfMatch[i] = count;
			}
		}

		return countOfMatch;
	}

	public static long findMinValue(long[] array, int[] countOfMatch) {

		if (array.length == 0) {

			System.out.println("Minimum value not found");
			return 0;
		}

		long minValue = Long.MAX_VALUE;
		int maxCountOfMatch = 0;

		for (int i = 0; i < countOfMatch.length; i++) {
			if (countOfMatch[i] > maxCountOfMatch) {
				maxCountOfMatch = countOfMatch[i];
			}
		}
		
		for (int i = 0; i < countOfMatch.length; i++) {
			if (countOfMatch[i] == maxCountOfMatch && minValue > array[i]) {
				minValue = array[i];
			}
		}

		return minValue;
	}

}
