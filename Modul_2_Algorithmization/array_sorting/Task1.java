package by.jonline.module_2.array_sorting;

import java.util.Arrays;

/**
 * Заданы два одномерных массива с различным количеством элементов и натуральное
 * число k. Объединить их в один массив, включив второй массив между k-м и (k+1)
 * - м элементами первого, при этом не используя дополнительный массив.
 */

public class Task1 {

	public static void main(String[] args) {

		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] array2 = { 9, 5, 2 };
		int k = 1;

		int[] finalArray;
		finalArray = merge(array1, array2, k);

		System.out.println(Arrays.toString(finalArray));
	}

	public static int[] merge(int[] array1, int[] array2, int k) {

		if (array1 == null || array2 == null) {
			return new int[0];
		}

		if (k >= array1.length || k < 1) {
			System.out.println("It's impossible to include the array.");
			return new int[0];
		}

		int[] finalArray = new int[array1.length + array2.length];

		for (int i = 0; i < k; i++) {
			finalArray[i] = array1[i];
		}

		for (int i = 0; i < array2.length; i++) {
			finalArray[i + k] = array2[i];
		}

		for (int i = k; i < array1.length; i++) {
			finalArray[i + array2.length] = array1[i];
		}

		return finalArray;
	}
}
