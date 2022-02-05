package by.jonline.module_2.one_array;

import java.util.Arrays;

/**
 * Дана последовательность целых чисел а1, а2,..., аn. Образовать новую
 * последовательность, выбросив из исходной те члены, которые равны min(а1,
 * а2,..., аn).
 */

public class Task8 {

	public static void main(String[] args) {

		long[] array = { 3, 5, 6, 7, 34, 3 };

		long min;
		long[] arrayWithoutMin;

		min = findMin(array);

		arrayWithoutMin = createArray(array, min);

		System.out.println(Arrays.toString(arrayWithoutMin));

	}

	public static long[] createArray(long[] array, long min) {

		if (array == null) {

			return new long[0];
		}

		int countOfMin = 0;

		for (long element : array) {
			if (element == min) {
				countOfMin++;
			}
		}

		long[] newArray = new long[array.length - countOfMin];

		int indexNewArray = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] != min) {
				newArray[indexNewArray] = array[i];
				indexNewArray++;
			}
		}

		return newArray;
	}

	public static long findMin(long[] array) {

		if (array == null || array.length == 0) {

			System.out.println("Minimum not found!");
			return 0;
		}

		long min = array[0];

		for (long element : array) {
			if (element < min) {
				min = element;
			}
		}

		return min;
	}

}
