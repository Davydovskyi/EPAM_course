package by.jonline.module_2.one_array;

import java.util.Arrays;

/**
 * Дана последовательность действительных чисел а1, а2,..., ап. Заменить все ее
 * члены, большие данного Z, этим числом. Подсчитать количество замен.
 */

public class Task2 {

	public static void main(String[] args) {

		double z = 34.6;

		double[] array = { 2, 756, 345, 34, 45.7, 45 };

		int countOfReplacement;
		countOfReplacement = replace(array, z);

		System.out.println(Arrays.toString(array) + "\nCount of Replacements: " + countOfReplacement);

	}

	public static int replace(double[] array, double z) {

		if (array == null) {
			return 0;
		}

		int countOfReplecement = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > z) {
				array[i] = z;
				countOfReplecement++;
			}
		}

		return countOfReplecement;
	}

}
