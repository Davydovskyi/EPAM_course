package by.jonline.module_2.array_sorting;

import java.util.Arrays;

/**
 * Даны две последовательности a1 <= a2 <=...<= an и b1 <= b2 <=...<= bm.
 * Образовать из них новую последовательность чисел так, чтобы она тоже была
 * неубывающей. Примечание. Дополнительный массив не использовать
 */

public class Task2 {

	public static void main(String[] args) {

		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] array2 = { 5, 6, 8, 9, 11, 12, 13 };

		int[] finalArray;
		finalArray = merge(array1, array2);

		System.out.println(Arrays.toString(finalArray));
	}

	public static int[] merge(int[] array1, int[] array2) {

		if (array1 == null || array2 == null) {
			return new int[0];
		}

		int[] finalArray = new int[array1.length + array2.length];

		for (int i = 0; i < finalArray.length; i++) {
			if (i < array1.length) {
				finalArray[i] = array1[i];
			} else {
				finalArray[i] = array2[i - array1.length];
			}
		}

		sort(finalArray);

		return finalArray;
	}

	public static void sort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			int minId = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minId]) {
					minId = j;
				}
			}
			swap(array, i, minId);
		}
	}

	private static void swap(int[] array, int id1, int id2) {
		int temp = array[id1];
		array[id1] = array[id2];
		array[id2] = temp;
	}
}
